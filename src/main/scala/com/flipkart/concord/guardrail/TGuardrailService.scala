package com.flipkart.concord.guardrail

import scala.util.Try

trait TGuardrailService {
  def isGuarded(entity: AnyRef, meta: Map[String, Any]): Try[Boolean]

  def guard(entity: AnyRef, meta: Map[String, Any]): Unit
}
