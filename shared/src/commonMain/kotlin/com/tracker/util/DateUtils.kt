package com.tracker.util

import kotlinx.datetime.LocalDate
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn
import kotlinx.datetime.daysUntil

object DateUtils {
	fun today(): LocalDate =
		Clock.System.todayIn(TimeZone.currentSystemDefault())

	fun daysBetween(from: LocalDate, to: LocalDate): Int =
		from.daysUntil(to)

	fun LocalDate.plusDays(days: Int): LocalDate =
		this.plus(days, kotlinx.datetime.DateTimeUnit.DAY)
}