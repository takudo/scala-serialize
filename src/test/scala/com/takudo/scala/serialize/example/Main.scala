package com.takudo.scala.serialize.example

import com.takudo.scala.serialize.Serializer


/**
 * Created with IntelliJ IDEA.
 * User: doyao
 * Date: 14/03/20
 * Time: 17:23
 */
object Main {

  def main(args: Array[String]) = {

    val obj = new SerializeTargetObject
    obj.name = "test name"
    obj.gender = "male"

    //シリアライズ
    val str = Serializer.serialize(obj)


    //デシリアライズ
    val deserializedObj = Serializer.deserialize[SerializeTargetObject](str)

    println("test end")

  }

}
