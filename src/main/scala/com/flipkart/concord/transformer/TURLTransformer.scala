package com.flipkart.concord.transformer

trait TURLTransformer {
  def shorten(url: String): String
  def deeplink(url: String): String
}
