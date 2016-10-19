package com.flipkart.concord.publisher

trait TPublisher[R] {
  def publish(request: TPublishRequest, metadata: TPublishRequestMetadata): TPublishResponse[R]
}

trait TSocketPublisher[R] extends TPublisher[R]