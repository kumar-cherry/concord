/*
 *         -╥⌐⌐⌐⌐            -⌐⌐⌐⌐-
 *      ≡╢░░░░⌐\░░░φ     ╓╝░░░░⌐░░░░╪╕
 *     ╣╬░░`    `░░░╢┘ φ▒╣╬╝╜     ░░╢╣Q
 *    ║╣╬░⌐        ` ╤▒▒▒Å`        ║╢╬╣
 *    ╚╣╬░⌐        ╔▒▒▒▒`«╕        ╢╢╣▒
 *     ╫╬░░╖    .░ ╙╨╨  ╣╣╬░φ    ╓φ░╢╢Å
 *      ╙╢░░░░⌐"░░░╜     ╙Å░░░░⌐░░░░╝`
 *        ``˚¬ ⌐              ˚˚⌐´
 *
 *      Copyright © https://opensource.org/licenses/MIT
 */
package com.flipkart.concord.config

import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.LoggerFactory
import scala.util.Try

/**
 * [[TConfig]] acts as a bridge trait for applications in which config loading can vary
 * in implementation, while finally producing a [[com.typesafe.config.Config]] instance.
 * Implementing classes control how / where config is loaded from, but the client interacts
 * with [[TConfig]] which allows querying via helper methods, once `init` is invoked.
 */
trait TConfig {

  private val _logger = LoggerFactory.getLogger(getClass)

  private var appConfig: Config = ConfigFactory.empty()

  def applyConfig(config: Config): Unit = {
    appConfig = config
    _logger.info(s"TConfig init with config: $config")
  }

  def get[V](k: String): Option[V] = Try(Some(appConfig.getAnyRef(k).asInstanceOf[V])).getOrElse(None)

  def getOrElse[T](key: String, default: T) = Try(appConfig.getAnyRef(key).asInstanceOf[T]).getOrElse(default)

  def getString(k: String): Option[String] = Try(Some(appConfig.getString(k))).getOrElse(None)

  def getInt(k: String): Option[Int] = Try(Some(appConfig.getInt(k))).getOrElse(None)

  def getDouble(k: String): Option[Double] = Try(Some(appConfig.getDouble(k))).getOrElse(None)

  def getBoolean(k: String): Option[Boolean] = Try(Some(appConfig.getBoolean(k))).getOrElse(None)

  def getConfig(k: String): Option[Config] = Try(Some(appConfig.getConfig(k))).getOrElse(None)
}
