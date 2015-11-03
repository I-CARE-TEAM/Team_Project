#pragma strict

public var ExpEffect : GameObject;

function Start () {
}

function Update () {
}

function OnCollisionEnter(coll : Collision) {
    // 衝突が起こったら、cahierの大きさを変更
    transform.localScale.x += Random.Range(0.1,0.5);
    transform.localScale.y += Random.Range(0.1,0.5);
    transform.localScale.z += Random.Range(0.1,0.5);

    // ExpMoneyオブジェクトを削除
    var effect : GameObject = Instantiate(ExpEffect,transform.position,transform.rotation);
    Destroy(effect, 5);
    Destroy(coll.gameObject);
}