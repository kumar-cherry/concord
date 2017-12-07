package com.flipkart.concord.guardrail

import scala.util.Try

trait TGuardrailService[E, R] {
  def isGuarded(entity: TGuardrailEntity[E], meta: TGuardrailEntityMetadata): Try[Boolean]

  def guard(entity: TGuardrailEntity[E], meta: TGuardrailEntityMetadata): Try[TGuardrailResponse[R]]
}
