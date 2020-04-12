name := "scala-graalvm"
organization := "com.amdelamar"
version := "1.0"
scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  // No dependencies!
)

lazy val root = (project in file("."))
enablePlugins(JavaAppPackaging)
enablePlugins(LauncherJarPlugin)
enablePlugins(GraalVMNativeImagePlugin)
