# Project: PeriodTracker

## Architecture
Kotlin Multiplatform (KMP). All business logic in `shared/commonMain`.
Platform-specific code only in `androidMain`/`iosMain`.

## Package structure
com.tracker.model       — data classes
com.tracker.prediction  — cycle calculation logic
com.tracker.storage     — repository interface + platform impls
com.tracker.util        — date helpers

## Conventions
- No server connections. Fully offline.
- Storage via SQLDelight + SQLCipher only.
- Variable names will be obfuscated pre-release — avoid relying on semantic naming for logic.
- Default cycle length: 28 days. Default period duration: 5 days.
- Rolling average uses last 6 cycles max.
- Luteal phase is fixed (~14 days). Predictions calculate backwards from expected end.

## Key classes
- `CycleEntry` — model for a single cycle (startDate, nullable endDate)
- `CyclePredictor` — rolling average predictions

## Languages
Kotlin (shared), Kotlin/Compose (Android UI), Swift/SwiftUI (iOS UI)