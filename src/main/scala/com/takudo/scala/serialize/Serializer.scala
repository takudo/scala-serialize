package com.takudo.scala.serialize

import java.io._
import scala.Serializable
import scala.Some
import biz.source_code.base64Coder.Base64Coder

/**
 * Created with IntelliJ IDEA.
 * User: doyao
 * Date: 14/03/20
 * Time: 17:18
 */
object Serializer {

  def serialize(obj: Serializable): String = {

    var oos: ObjectOutputStream = null

    val baos = new ByteArrayOutputStream()
    var prefix = "oos"

    if (obj.isInstanceOf[Serializable]) {
      oos = new ObjectOutputStream(baos)
      oos.writeObject(obj)
      oos.flush()
    }
    val result = prefix + "-" + new String( Base64Coder.encode(baos.toByteArray()))
    result

  }

  def deserialize[T](value:String): Option[T] = {

    var ois: ObjectInputStream = null

    val data: Seq[String] = value.split("-")
    val b = Base64Coder.decode(data.last)

    try{
      ois = new ObjectInputStream(new ByteArrayInputStream(b))
      val r  = ois.readObject().asInstanceOf[T]
      Some(r)
    }catch{
      case _ => None
    }

  }
}
