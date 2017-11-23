package com.flipkart.concord.validator

import akka.http.scaladsl.model.{HttpRequest, HttpResponse}

import scala.concurrent.Future
import scala.util.Try

trait TGuardrailService {

  def guard(params: AnyRef*): Try[Boolean]

  def entryViaHttp(httpRequest: HttpRequest): Future[HttpResponse]

}
