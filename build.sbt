sbtPlugin := true

name := "sbt-cloudformation"

organization := "com.github.myyk"

version := "0.5.0"

scalaVersion := "2.10.5"

libraryDependencies += "com.amazonaws" % "aws-java-sdk-cloudformation" % "1.9.40"

publishTo <<= (version) { version: String =>
   val scalasbt = "http://scalasbt.artifactoryonline.com/scalasbt/"
   val (name, url) = if (version.contains("-SNAPSHOT"))
                       ("sbt-plugin-snapshots-publish", scalasbt+"sbt-plugin-snapshots")
                     else
                       ("sbt-plugin-releases-publish", scalasbt+"sbt-plugin-releases")
   Some(Resolver.url(name, new URL(url))(Resolver.ivyStylePatterns))
}

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scalacOptions += "-deprecation"

bintrayPackageLabels := Seq("aws", "cloudformation")

publishMavenStyle := false

bintrayOrganization in bintray := None
