package com.flipkart.concord.publisher

import scala.util.Try

trait TPublishResponse[R] {
  def response: Try[R]
}
