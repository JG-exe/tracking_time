package com.tracker.prediction

class CyclePredictor(
	private val defaultDuration: Int = 5,
	private val defaultCycleLength: Int = 28,
	private val maxSamples: Int = 6
) {

	fun averageCycleLength(entries: List<CycleEntry>): Int {
		val lengths = cycleLength(entries)
		return if (lengths.isEmpty()) defaultCycleLength
		else lengths.takeLast(maxSamples).average().roundToInt()
	}

	fun averagePeriodDuration(entries: List<CycleEntry>): Int {
		val durations = entries
			.filter { it.endDate != null }
			.map { ChronoUnit.DAYS.between(it.startDate, it.endDate).toInt() + 1 }
		return if (durations.isEmpty()) defaultDuration
		else durations.takeLast(maxSamples).average().roundToInt()
	}

	fun nextPeriodStart(entries: List<CycleEntry>): LocalDate? {
		val last = entries.maxByOrNull { it.startDate } ?: return null
		return last.startDate.plusDays(averageCycleLength(entries).toLong())
	}

	private fun cycleLength(entries: List<CycleEntry>): List<Int> {
		val sorted = entries.sortedBy { it.startDate }
		return sorted.zipWithNext { a, b ->
			ChronoUnit.DAYS.between(a.startDate, b.startDate).toInt()
		}
	}
}