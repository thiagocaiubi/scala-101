package com.caiubi.skala;

object Timer {
	
	def main(args: Array[String]) {
		onePerSecond(() => println("Time flies like an arrow..."))
	}
	
	def onePerSecond(callback: () => Unit) {
		while (true) {
			callback()
			Thread sleep 1000
		}
	}
}