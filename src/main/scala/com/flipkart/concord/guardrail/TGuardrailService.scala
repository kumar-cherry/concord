package com.flipkart.concord.guardrail

import scala.util.Try

trait TGuardrailService {
  def isGuarded(params: AnyRef*): Try[Boolean]
  def guard(params: AnyRef*): Unit
}
