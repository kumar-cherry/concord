package com.flipkart.concord.transformer

import scala.util.Try

trait TURLTransformer {

  def shorten(url: String): Try[String]

  def deeplink(url: String, context: Map[String,AnyRef]): Try[String]

}
