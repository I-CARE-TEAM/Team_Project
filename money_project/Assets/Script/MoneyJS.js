#pragma strict

public var ExpEffect : GameObject;

function Start () {
}

function Update () {
	if (transform.position.z < -15)
		Destroy(gameObject);
}

function OnCollisionEnter(obj : Collision){
	Instantiate(ExpEffect,transform.position,transform.rotation);
	Destroy(gameObject);
}