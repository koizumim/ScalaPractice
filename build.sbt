name := "practisbt"

version := "0.1"

scalaVersion := "2.10.2"

libraryDependencies += "org.specs2" %% "specs2" % "2.0"

libraryDependencies += "org.squeryl" % "squeryl_2.10" % "0.9.5-6"

libraryDependencies += "postgresql" % "postgresql" % "9.1-901.jdbc4"

libraryDependencies ++= Seq(
    "com.typesafe.akka" % "akka-actor" % "2.0.1"
)

// Note: These settings are defaults for activator, and reorganize your source directories.
Seq(
  scalaSource in Compile <<= baseDirectory / "app",
  javaSource in Compile <<= baseDirectory / "app",
  sourceDirectory in Compile <<= baseDirectory / "app",
  scalaSource in Test <<= baseDirectory / "test",
  javaSource in Test <<= baseDirectory / "test",
  sourceDirectory in Test <<= baseDirectory / "test",
  resourceDirectory in Compile <<= baseDirectory / "conf"
)

seq(com.github.retronym.SbtOneJar.oneJarSettings: _*)