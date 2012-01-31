package com.caiubi.skala;

import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._

object BrazilDate {
	
	def main(args: Array[String]) {
		val now = new Date
		val dateFormat = getDateInstance(LONG, new Locale("pt", "BR"))
		println(dateFormat format now)
	}
}