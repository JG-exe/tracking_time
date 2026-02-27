package com.tracker.storage

import com.tracker.model.CycleEntry
import kotlinx.datetime.LocalDate

interface CycleRepository {
	suspend fun insertCycle(entry: CycleEntry)
	suspend fun updateCycle(entry: CycleEntry)
	suspend fun getAllCycles(): List<CycleEntry>
	suspend fun getLatestCycle(): CycleEntry?
	suspend fun deleteCycle(startDate: LocalDate)
}