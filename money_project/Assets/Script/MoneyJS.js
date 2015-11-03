#pragma strict

public var ExpEffect : GameObject;
public var ChargeEffect : GameObject;

function Start () {
}

function Update () {
	if (transform.position.z < -15)
		Destroy(gameObject);
}

function OnCollisionEnter(coll : Collision){
    switch(coll.collider.gameObject.layer) {
        // ChargeMoneyオブジェクトを削除
        // エフェクト作成&削除
        case LayerMask.NameToLayer("ChargeMoney"):
        var effect : GameObject = Instantiate(ChargeEffect,transform.position,transform.rotation);
        Destroy(effect, 3);
        Destroy(coll.gameObject);
        break;

        default: break;
    }
}