/*消費表示のプロトタイプ　例*/
#pragma strict
import System.Collections.Generic;

var ST : GUIStyle;

// エフェクト
public var chargeEffect : GameObject;
public var omedetou : GameObject;

// お金の種類
private var money_type : int[] = [10000, 5000, 1000, 500, 100, 50, 10, 5, 1];

// お金 : オブジェクト設定
public var m1 : GameObject;
public var m5 : GameObject;
public var m10 : GameObject;
public var m50 : GameObject;
public var m100 : GameObject;
public var m500 : GameObject;
public var m1000 : GameObject;
public var m5000 : GameObject;
public var m10000 : GameObject;
private var money_obj = new List.<GameObject>();

// お金(オブジェクト)管理 : 作成したオブジェクト群をリストで管理
private var holdMoney_list = new List.<GameObject>();
private var chargeMoney_list = new List.<GameObject>();
private var expMoney_list = new List.<GameObject>();

// お金が作成される位置
public var m1BasePosition : Vector3 ;//= Vector3(20.0,0,0);
public var m5BasePosition : Vector3 ;//= Vector3(15.0,0,0);
public var m10BasePosition : Vector3 ;//= Vector3(10.0,0,0);
public var m50BasePosition : Vector3 ;//= Vector3(5.0,0,0);
public var m100BasePosition : Vector3 ;//= Vector3(0,0,0);
public var m500BasePosition : Vector3 ;//= Vector3(-5.0,0,0);
public var m1000BasePosition : Vector3 ;//= Vector3(-10.0,0,0);
public var m5000BasePosition : Vector3 ;//= Vector3(-15.0,0,0);
public var m10000BasePosition : Vector3 ;//= Vector3(-20.0,0,0);
private var money_pos_list = new List.<Vector3>();

// キャッシャー
public var cashierPosition : Vector3;
public var cashierMovePosition : Vector3;

// 所有金額
// private var mnArray = new Array (2,1,2,1,2,1,2,1,7);
private var hold_money : int;			//残高
private var hold_money_list = new List.<int>();
private var expenditure : int;			//消費金額
private var expenditure_list = new List.<int>();
private var charge_money : int;			//チャージ金額
private var charge_money_list = new List.<int>();

// その他
private var SpacingForY : float = 1.0;
private var SpacingForZ : float = 0.5;

public var initialSpeed : float;    //移動速度
private var eventType : int; //１消費　　２チャージ　　３残高
private var check : boolean;  // お金作成完了フラグ

// リスト化
function init () {
    // オブジェクトをリスト化
    money_obj.Add(m1);
    money_obj.Add(m5);
    money_obj.Add(m10);
    money_obj.Add(m50);
    money_obj.Add(m100);
    money_obj.Add(m500);
    money_obj.Add(m1000);
    money_obj.Add(m5000);
    money_obj.Add(m10000);

    // お金の位置情報をリスト化
    money_pos_list.Add(m1BasePosition);
    money_pos_list.Add(m5BasePosition);
    money_pos_list.Add(m10BasePosition);
    money_pos_list.Add(m50BasePosition);
    money_pos_list.Add(m100BasePosition);
    money_pos_list.Add(m500BasePosition);
    money_pos_list.Add(m1000BasePosition);
    money_pos_list.Add(m5000BasePosition);
    money_pos_list.Add(m10000BasePosition);
}

// 金額から枚数を計算：計算したい金額, 計算結果を入れるリスト
function calcMoneyNum (money:int, result_money_list:List.<int>) {
    var num_div : int;
    var num_rem : int;
    var money_ : int = money;
    result_money_list.Clear();
    for (var i = 0; i < money_type.length; i++) {
        num_div= money_ / money_type[i];
        num_rem= money_ % money_type[i];
        result_money_list.Add(num_div);
        money_ = num_rem;
    }
    result_money_list.Reverse();
}

// お金の移動：位置, 移動するお金のリスト
function moneyMove (pos:Vector3, move_list:List.<GameObject>) {
    var direction : Vector3 = pos;
    yield WaitForSeconds(1);
    for(var i = 0; i < move_list.Count; i++){
        if (move_list[i] == null) break;
        direction = pos;
        direction -= move_list[i].transform.position;
        move_list[i].GetComponent.<Rigidbody>().velocity = direction*initialSpeed;
    }
}

// お金作成：作成するお金の種類, 数, 位置, 格納するリスト
function CreateMoney (money_pre:GameObject, amount:int, pos:Vector3, store_list:List.<GameObject>) {
    store_list.Clear();
    for (var i = 0; i < amount; i++) {
        yield WaitForSeconds(0.2);
        var newMoney : GameObject = Instantiate (money_pre, Vector3(pos.x,pos.y+money_pre.transform.localScale.y*i,pos.z+SpacingForZ*i), transform.rotation) as GameObject;
        switch(store_list) {
            case holdMoney_list:
            newMoney.layer = LayerMask.NameToLayer("HoldMoney");
            newMoney.transform.parent = GameObject.Find("HoldMoney").transform;
            break;
            case chargeMoney_list:
            newMoney.layer = LayerMask.NameToLayer("ChargeMoney");
            newMoney.transform.parent = GameObject.Find("ChargeMoney").transform;
            break;
            case expMoney_list:
            newMoney.layer = LayerMask.NameToLayer("ExpMoney");
            newMoney.transform.parent = GameObject.Find("ExpMoney").transform;
            break;
            default: break;
        }
        store_list.Add(newMoney);
    }
}

// 複数のお金を作成：作成する金額, 作成したものを格納するリスト
function CreateMultiMoney (create_list:List.<int>, multi_money_list:List.<GameObject>) {
    multi_money_list.Clear();
    for (var i = 0; i < create_list.Count; i++) {
        CreateMoney(money_obj[i], create_list[i], money_pos_list[i], multi_money_list);
    }
}

// 複数のお金を作成(作成位置を調整可)
function CreateMultiMoneyAddPos (create_list:List.<int>, multi_money_list:List.<GameObject>, pos:Vector3) {
    multi_money_list.Clear();
    for (var i = 0; i < create_list.Count; i++) {
        var add_pos = money_pos_list[i] + pos;
        CreateMoney(money_obj[i], create_list[i], add_pos, multi_money_list);
    }
}

// 料金表示
function OnGUI() {
    GUI.Label(Rect(10,25,100,30), "残高:" + hold_money, ST);
    if(eventType == 1){
        GUI.Label(Rect(10,10,100,30), "消費金額:" + expenditure, ST);
    }else if(eventType == 2){
        GUI.Label(Rect(10,10,100,30), "チャージ金額:" + charge_money, ST);
    }
}

function WaitForIt () {
    yield WaitForSeconds(1.5f);
    check = true;
}

function Start ()
{
    init();
    eventType = 2;
    hold_money = 68888; // 所有金額分のお金を作成
    check = false;

    if(eventType == 1){
		expenditure = 12345;  //消費金額
		hold_money -= expenditure;
        calcMoneyNum(expenditure, expenditure_list);
        CreateMultiMoneyAddPos(expenditure_list, expMoney_list, new Vector3(0, 0, -5));
    }else if(eventType == 2){
		charge_money = 68888; //チャージ金額
        calcMoneyNum(charge_money, charge_money_list);
        CreateMultiMoneyAddPos(charge_money_list, chargeMoney_list, new Vector3(0, 20, -13));
    }

    // 残高金額
    calcMoneyNum(hold_money, hold_money_list);
    CreateMultiMoney(hold_money_list, holdMoney_list);

    WaitForIt();
}

function Update ()
{
    if (check) {
        if(eventType == 1){
            moneyMove(cashierPosition, expMoney_list);
            if (GameObject.Find("ExpMoney").transform.childCount == 0) {
                check = false;
            }
        }else if(eventType == 2){
            moneyMove(cashierMovePosition, chargeMoney_list);

            if (GameObject.Find("ChargeMoney").transform.childCount == 0) {
                for (var obj in holdMoney_list) Destroy(obj);
                hold_money += charge_money;
                charge_money = 0;
                calcMoneyNum(hold_money, hold_money_list);
                CreateMultiMoney(hold_money_list, holdMoney_list);
                var omedetouEffect : GameObject = Instantiate(omedetou,m500BasePosition,transform.rotation);
                Destroy(omedetouEffect, 3);
                check = false;
            }
        }
    }
}
