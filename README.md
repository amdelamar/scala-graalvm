# scala-graalvm

A simple example with Scala on GraalVM.

Requires [GraalVM](https://www.graalvm.org/downloads/), [JDK 11](https://adoptopenjdk.net/), and [sbt 1.3+](https://www.scala-sbt.org/).

## Setup

Assuming you're on a Linux Ubuntu distro, otherwise set wherever you extracted them for your environment.

```bash
export HOTSPOT_HOME="/usr/lib/jvm/java-11-openjdk-amd64/"
export GRAALVM_HOME="/usr/lib/jvm/graalvm-ce-java11-20.0.0/"
```


## Compare compile speed

1. Compile with HotSpot
  ```
  $ time sbt -java-home $HOTSPOT_HOME compile
  ```
2. Compile with GraalVM
  ```
  $ time sbt -java-home $GRAALVM_HOME compile
  ```


## Compare run speed

First, use `sbt assembly` to package as a Runnable Jar.

1. Run with HotSpot
  ```
  $ time $HOTSPOT_HOME/bin/java -jar target/scala-2.13/scala-graalvm-assembly-1.0.jar
  ```
2. Run with GraalVM
  ```
  $ time $GRAALVM_HOME/bin/java -jar target/scala-2.13/scala-graalvm-assembly-1.0.jar
  ```


## (Optional) Package to Native Image

```
# Add Graal's bin to your PATH
$ export PATH="$PATH:$GRAALVM_HOME/bin"

# Install native-image command
$ gu install native-image

# Package image
$ sbt graalvm-native-image:packageBin

# Now you can run it like so, instead of a Jar.
$ ./target/graalvm-native-image/scala-graalvm
```
