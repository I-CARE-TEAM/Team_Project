#pragma strict

public var ExpEffect : GameObject;

function Start () {

}

function Update () {
	if (transform.position.z < -15)
		Destroy(gameObject);
}

function OnCollisionEnter(obj : Collision){
	if(obj.gameObject.name == "cashier"){
		Instantiate(ExpEffect,transform.position,transform.rotation);
		Destroy(gameObject);
	}
}