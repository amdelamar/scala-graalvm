package com.amdelamar

object FibonacciDemo {

  def main(args: Array[String]): Unit = {
    println(s"Using this JVM = ${System.getProperty("java.home")}")

    // arg 1 or default to 100
    val number = scala.util.Try(args.head.toInt).getOrElse(100)
    val fibNumber = fib(number)

    println(s"The Fibonacci sequence of ${number} = ${fibNumber}")
  }

  /**
   * Calculates the Fibonacci sequence of a given value.
   * https://stackoverflow.com/a/7388895/7065245
   */
  def fib(n: Int): BigInt = {
    def fibs(n: Int): (BigInt, BigInt) = if (n == 1) (1,0) else {
      val (a,b) = fibs(n/2)
      val p = (2*b+a)*a
      val q = a*a + b*b
      if(n % 2 == 0) (p,q) else (p+q,p)
    }
    fibs(n)._1
  }

}
