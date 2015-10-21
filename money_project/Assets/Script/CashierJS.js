#pragma strict

function Start () {

}

function Update () {

}

function OnCollisionEnter(){
	
		transform.localScale.x += Random.Range(0.1,0.5);
		transform.localScale.y += Random.Range(0.1,0.5);
		transform.localScale.z += Random.Range(0.1,0.5);
}