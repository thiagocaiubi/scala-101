object Timer {
	
	def main(args: Array[String]) {
		onePerSecond(timeFlies)
	}
	
	def onePerSecond(callback: () => Unit) {
		while (true) {
			callback()
			Thread sleep 1000
		}
	}
	
	def timeFlies() {
		println("Time flies like an arrow...")
	}
}