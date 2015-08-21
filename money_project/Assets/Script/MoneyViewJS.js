#pragma strict

var ST : GUIStyle;

var m1 : Transform;
var m5 : Transform;
var m10 : Transform;
var m50 : Transform;
var m100 : Transform;
var m500 : Transform;
var m1000 : Transform;
var m5000 : Transform;
var m10000 : Transform;

var SpacingForY : float = 0.05;
var SpacingForZ : float = 0.5;

var m1BasePosition : Vector3 ;//= Vector3(20.0,0,0);
var m5BasePosition : Vector3 ;//= Vector3(15.0,0,0);
var m10BasePosition : Vector3 ;//= Vector3(10.0,0,0);
var m50BasePosition : Vector3 ;//= Vector3(5.0,0,0);
var m100BasePosition : Vector3 ;//= Vector3(0,0,0);
var m500BasePosition : Vector3 ;//= Vector3(-5.0,0,0);
var m1000BasePosition : Vector3 ;//= Vector3(-10.0,0,0);
var m5000BasePosition : Vector3 ;//= Vector3(-15.0,0,0);
var m10000BasePosition : Vector3 ;//= Vector3(-20.0,0,0);

var mnArray = new Array (2,1,2,1,2,1,2,1,7); //77777  1円　5円...

var mn1 : int;
var mn5 : int;
var mn10 : int;
var mn50 : int;
var mn100 : int;
var mn500 : int;
var mn1000 : int;
var mn5000 : int;
var mn10000 : int;

function Start () {
	//m1BasePosition.Set();
	mn10000 = mnArray.Pop();
	mn5000 = mnArray.Pop();
	mn1000 = mnArray.Pop();
	mn500 = mnArray.Pop();
	mn100 = mnArray.Pop();
	mn50 = mnArray.Pop();
	mn10 = mnArray.Pop();
	mn5 = mnArray.Pop();
	mn1 = mnArray.Pop();
	creatMoney(m1,mn1,m1BasePosition);
	creatMoney(m5,mn5,m5BasePosition);
	creatMoney(m10,mn10,m10BasePosition);
	creatMoney(m50,mn50,m50BasePosition);
	creatMoney(m100,mn100,m100BasePosition);
	creatMoney(m500,mn500,m500BasePosition);
	creatMoney(m1000,mn1000,m1000BasePosition);
	creatMoney(m5000,mn5000,m5000BasePosition);
	creatMoney(m10000,mn10000,m10000BasePosition);
}

function Update () {

}

function OnGUI(){
	GUI.Label(Rect(10,10,100,30),"総金額；77777",ST);
}

function creatMoney(money : Transform , number : int , position : Vector3){
	for(var i = 0;i < number;i++){
		Instantiate(money,Vector3(position.x,position.y+SpacingForY*i,position.z+SpacingForZ*i),transform.rotation);
	}
} 