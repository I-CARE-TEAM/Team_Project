/*消費表示のプロトタイプ　例*/
#pragma strict
import System.Collections.Generic;

var ST : GUIStyle;

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
private var m1_list = new List.<GameObject>();
private var m5_list = new List.<GameObject>();
private var m10_list = new List.<GameObject>();
private var m50_list = new List.<GameObject>();
private var m100_list = new List.<GameObject>();
private var m500_list = new List.<GameObject>();
private var m1000_list = new List.<GameObject>();
private var m5000_list = new List.<GameObject>();
private var m10000_list = new List.<GameObject>();
private var money_list = new List.<List.<GameObject> >();

private var chargeMoney_list = new List.<GameObject>();
private var expMoney_list = new List.<GameObject>();



var m1BasePosition : Vector3 ;//= Vector3(20.0,0,0);
var m5BasePosition : Vector3 ;//= Vector3(15.0,0,0);
var m10BasePosition : Vector3 ;//= Vector3(10.0,0,0);
var m50BasePosition : Vector3 ;//= Vector3(5.0,0,0);
var m100BasePosition : Vector3 ;//= Vector3(0,0,0);
var m500BasePosition : Vector3 ;//= Vector3(-5.0,0,0);
var m1000BasePosition : Vector3 ;//= Vector3(-10.0,0,0);
var m5000BasePosition : Vector3 ;//= Vector3(-15.0,0,0);
var m10000BasePosition : Vector3 ;//= Vector3(-20.0,0,0);
private var money_pos_list = new List.<Vector3>();

var cashierPosition : Vector3;
var cashierMovePosition : Vector3;

// 所有金額
// private var mnArray = new Array (2,1,2,1,2,1,2,1,7);
// 77777  1円　5円...
private var hold_money : int;			//残高
private var hold_money_list = new List.<int>();
private var expenditure : int;			//消費金額
private var expenditure_list = new List.<int>();
private var charge_money : int;			//チャージ金額
private var charge_money_list = new List.<int>();
// 位置
private var SpacingForY : float = 1.0;
private var SpacingForZ : float = 0.5;

public var initialSpeed : float;		//移動速度
private var eventType :int ; //１消費　　２チャージ　　３残高

// チャージ金額から枚数を計算
function calcChargeMoneyNum() {
    var num_div : int;
    var num_rem : int;
    var charge_money_ : int = charge_money;
    for (var i = 0; i < money_type.length; i++) {
        num_div= charge_money_ / money_type[i];
        num_rem= charge_money_ % money_type[i];
        charge_money_list.Add(num_div);
        charge_money_ = num_rem;
    }
    charge_money_list.Reverse();
}

//消費金額から枚数を計算
function calcExpMoneyNum() {
    var num_div : int;
    var num_rem : int;
    var exp_money_ : int = expenditure;
    for (var i = 0; i < money_type.length; i++) {
        num_div= exp_money_ / money_type[i];
        num_rem= exp_money_ % money_type[i];
        expenditure_list.Add(num_div);
        exp_money_ = num_rem;
    }
    expenditure_list.Reverse();
}

//チャージしたお金の移動
function chargeMoneyMove(){
	var direction : Vector3 = cashierMovePosition;
	for(var i = 0; i < chargeMoney_list.Count; i++){
		direction = cashierMovePosition;
		direction -= chargeMoney_list[i].transform.position;
		chargeMoney_list[i].GetComponent.<Rigidbody>().velocity = direction*initialSpeed;
	}
}

//消費したお金の移動
function expMoneyMove(){
	var direction : Vector3 = cashierPosition;
	for(var i = 0; i < expMoney_list.Count; i++){
		direction = cashierPosition;
		direction -= expMoney_list[i].transform.position;
		expMoney_list[i].GetComponent.<Rigidbody>().velocity = direction*initialSpeed;
	}
}


// 残高のお金作成
function CreateMoney (money_pre:GameObject, amount:int, pos:Vector3, store_list:List.<GameObject>) {
    for (var i = 0; i < amount; i++) {
        var newMoney : GameObject = Instantiate (money_pre, Vector3(pos.x,pos.y +money_pre.transform.localScale.y*i,pos.z+SpacingForZ*i), transform.rotation) as GameObject;
        store_list.Add(newMoney);
        newMoney.transform.parent = GameObject.Find("MoneyObject").transform;
    }
}

//チャージ金額のお金作成、作成位置は調整する必要がある
function CreateChargeMoney (money_pre:GameObject, amount:int, pos:Vector3, store_list:List.<GameObject>) {
    for (var i = 0; i < amount; i++) {
        var newMoney : GameObject = Instantiate (money_pre, Vector3(pos.x,pos.y +(money_pre.transform.localScale.y+SpacingForY)*i,pos.z+SpacingForZ*i-13), transform.rotation) as GameObject;
        chargeMoney_list.Add(newMoney);
		store_list.Add(newMoney);
        newMoney.transform.parent = GameObject.Find("MoneyObject").transform;
    }
}

//消費金額のお金作成、作成位置は調整する必要がある
function CreateExpMoney (money_pre:GameObject, amount:int, pos:Vector3, store_list:List.<GameObject>) {
    for (var i = 0; i < amount; i++) {
        var newMoney : GameObject = Instantiate (money_pre, Vector3(pos.x,pos.y +money_pre.transform.localScale.y*i,pos.z+SpacingForZ*i-5), transform.rotation) as GameObject;
        expMoney_list.Add(newMoney);
        newMoney.transform.parent = GameObject.Find("MoneyObject").transform;
    }
}

// 金額から枚数を計算
function calcMoneyNum() {
    var num_div : int;
    var num_rem : int;
    var hold_money_ : int = hold_money;
    for (var i = 0; i < money_type.length; i++) {
        num_div= hold_money_ / money_type[i];
        num_rem= hold_money_ % money_type[i];
        hold_money_list.Add(num_div);
        hold_money_ = num_rem;
    }
    hold_money_list.Reverse();
}

// 料金表示
function OnGUI() {
	if(eventType == 1){
		GUI.Label(Rect(10,10,100,30), "消費金額:" + expenditure, ST);
		GUI.Label(Rect(10,25,100,30), "残高:" + hold_money, ST);
	}else if(eventType == 2){
		GUI.Label(Rect(10,10,100,30), "チャージ金額:" + charge_money, ST);
		GUI.Label(Rect(10,25,100,30), "残高:" + hold_money, ST);
	}else if(eventType == 3){
		GUI.Label(Rect(10,25,100,30), "残高:" + hold_money, ST);
	}
}

function Start () {
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

    // 2次元のリストを作成
    money_list.Add(m1_list);
    money_list.Add(m5_list);
    money_list.Add(m10_list);
    money_list.Add(m50_list);
    money_list.Add(m100_list);
    money_list.Add(m500_list);
    money_list.Add(m1000_list);
    money_list.Add(m5000_list);
    money_list.Add(m10000_list);

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

	eventType = 1;
    // 所有金額分のお金を作成
    hold_money = 68888;

	if(eventType == 1){
		//消費金額
		expenditure = 12345;
		hold_money -= expenditure;

		calcExpMoneyNum();
		calcMoneyNum();

		for (var i = 0; i < hold_money_list.Count; i++) {
			CreateMoney(money_obj[i], hold_money_list[i], money_pos_list[i], money_list[i]);
		}
		//消費したお金を作成
		for (var z = 0; z < expenditure_list.Count; z++) {
			CreateExpMoney(money_obj[z], expenditure_list[z], money_pos_list[z], money_list[z]);
		}
	}
	else if(eventType == 2){
		//チャージ金額分のお金を作成
		charge_money = 68888;
		calcChargeMoneyNum();
		calcMoneyNum();
		for (i = 0; i < hold_money_list.Count; i++) {
			CreateMoney(money_obj[i], hold_money_list[i], money_pos_list[i], money_list[i]);
		}
		//チャージしたお金を作成
		for (var j = 0; j < charge_money_list.Count; j++) {
			CreateChargeMoney(money_obj[j], charge_money_list[j], money_pos_list[j], money_list[j]);
		}
	}
	else if(eventType == 3){
		calcMoneyNum();
		for (var k = 0; k < hold_money_list.Count; k++) {
			CreateMoney(money_obj[k], hold_money_list[k], money_pos_list[k], money_list[k]);
		}
	}

}

function Update () {

	if(eventType == 1)
		expMoneyMove();
	else if(eventType == 2){
		if (chargeMoney_list[0].transform.position.z<0)
			chargeMoneyMove();
		//OnCollisionEnterが使えるまでに、替わりの判断
		if (chargeMoney_list[0].transform.position.z>8){
			for(var i = 0;i < money_list.Count; i++){
				for(var j = 0;j < money_list[i].Count; j++)
				{
					Destroy(money_list[i][j]);
				}
			}

		hold_money += charge_money;
		calcMoneyNum();

		for (i = 0; i < hold_money_list.Count; i++) {
			CreateMoney(money_obj[i], hold_money_list[i], money_pos_list[i], money_list[i]);
		}
	}
	}
	//OnCollisionEnterが使えるまでに、替わりの判断
	/*if (expMoney_list[0].transform.position.z < -15){
		for(var i = 0;i < expMoney_list.Count; i++){

				Destroy(expMoney_list[i]);
		}
	}*/
}
/* なぜか当たっても実行しない*/
function OnCollisionEnter(){
	/*
		for(var i = 0;i < expMoney_list.Count; i++){
			Destroy(expMoney_list[i]);
		}
	*/
}
