package com.flipkart.concord.publisher

trait TPublishRequest {
  def validate(): Boolean

  def schemaVersion(): String
}

trait TPublishRequestMetadata {
  def id: String

  def namespace(): Option[String] = None

  def requestType: RequestType.Value

  def time: Long = System.currentTimeMillis()

  def isSandboxRequest: Boolean = false
}

object RequestType extends Enumeration {
  val Event, Entity = Value
}