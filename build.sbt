sbtPlugin := true

name := "sbt-cloudformation"

organization := "com.github.myyk"

version := "0.5.0"

scalaVersion := "2.10.5"

libraryDependencies += "com.amazonaws" % "aws-java-sdk-cloudformation" % "1.10.0"

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scalacOptions += "-deprecation"

bintrayPackageLabels := Seq("aws", "cloudformation")
