releaseSettings

sbtPlugin := true

name := "sbt-cloudformation"

organization := "com.gilt"

scalaVersion := "2.10.4"

libraryDependencies += "com.amazonaws" % "aws-java-sdk-cloudformation" % "1.9.29"

publishTo := {
  val nexus = "https://nexus.gilt.com/nexus/"
  if (isSnapshot.value)
    Some(Resolver.url("snapshots", new java.net.URL(nexus + "content/repositories/sbt-plugin-snapshots"))(Resolver.ivyStylePatterns))
  else
    Some(Resolver.url("releases", new java.net.URL(nexus + "content/repositories/sbt-plugin-releases"))(Resolver.ivyStylePatterns))
}

credentials += Credentials("Sonatype Nexus Repository Manager", "nexus.gilt.com", gilt.Identities.NexusUser, gilt.Identities.NexusPassword)

licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

scalacOptions += "-deprecation"

crossBuildingSettings

CrossBuilding.crossSbtVersions := Seq("0.13")

CrossBuilding.scriptedSettings

scriptedLaunchOpts <<= (scriptedLaunchOpts, version) { case (s,v) => s ++
  Seq("-Xmx1024M", "-XX:MaxPermSize=256M", "-Dplugin.version=" + v)
}

scriptedBufferLog := false
