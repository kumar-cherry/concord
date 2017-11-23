package com.flipkart.concord.guardrail

import akka.http.scaladsl.model.{HttpRequest, HttpResponse}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

trait TGuardrailService {

  def guard(params: AnyRef*): Try[Boolean]

  def entryViaHttp(httpRequest: HttpRequest)(implicit ec: ExecutionContext): Future[HttpResponse]

}
