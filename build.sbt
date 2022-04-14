ThisBuild / organization := "test"
ThisBuild / scalaVersion := "2.13.5"

ThisBuild / scalaVersion := "2.13.8"

val ScalaTestVersion = "3.2.11"

lazy val root = (project in file(".")).settings(
  name := "timeout-bug",

  Test / fork := true,

  Test / testOptions := Seq(
    Tests.Argument("-oDF"),
    Tests.Argument(TestFrameworks.ScalaTest, "-u", "%s".format((Test / target).value / "test-reports"))
  ),

  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.3.11",

    "org.scalatest"     %% "scalatest-freespec"       % ScalaTestVersion,
    "org.scalatest"     %% "scalatest-mustmatchers"   % ScalaTestVersion,

    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
  )
)
