#pragma strict

// お金
public var coin100 : GameObject;
public var coin500 : GameObject;
public var bill1000 : GameObject;
public var bill5000 : GameObject;
public var bill10000 : GameObject;

// お金管理
private var coin100_arr = new Array();
private var coin500_arr = new Array();
private var bill1000_arr = new Array();
private var bill5000_arr = new Array();
private var bill10000_arr = new Array();

// お金作成
function CreateMoney (MoneyPre:GameObject, amount:int, pos:Vector3, parent_object:String) {
    for (var i = 0; i < amount; i++) {
        var newMoney : GameObject = Instantiate (MoneyPre, pos, Quaternion.identity) as GameObject;
        newMoney.transform.parent = GameObject.Find("MoneyObject").transform;
    }
}

// タグに合わせて配列を変更
function SwitchMoney (parent_object:String) {
    // switch(parent_object) {
    //     case :

    //         break;
    //     case :

    //         break;
    // }
}

function Start () {

}

function Update () {

}