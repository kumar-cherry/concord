package com.flipkart.concord.guardrail

import scala.util.Try

trait TGuardrailResponse[R] {
  def response: Try[R]
}
