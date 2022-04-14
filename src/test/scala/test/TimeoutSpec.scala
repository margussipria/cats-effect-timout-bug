package test

import cats.effect.{IO, unsafe}
import org.scalatest.{freespec, matchers}

import scala.concurrent.duration.DurationLong
import cats.effect.implicits._
import cats.implicits._

import scala.language.postfixOps

class TimeoutSpec extends freespec.AsyncFreeSpec with matchers.must.Matchers {

  import unsafe.implicits.global

  "IO" - {

    "with timeout" in {
      intercept[Exception] {
        IO.delay(throw new Exception("moi 1")).timeout(10 minutes).unsafeRunSync()
      }.getMessage must be ("moi 1")
    }

    "with timeout and attempt" in {
      intercept[Exception] {
        IO.delay(throw new Exception("moi 1")).attempt.timeout(10 minutes).rethrow.unsafeRunSync()
      }.getMessage must be ("moi 1")
    }

    "without timeout" in {
      intercept[Exception] {
        IO.delay(throw new Exception("moi 2")).unsafeRunSync()
      }.getMessage must be ("moi 2")
    }
  }

}
