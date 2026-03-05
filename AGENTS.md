# Project: PeriodTracker

## Architecture

Kotlin Multiplatform (KMP). All business logic in `shared/commonMain`.
Platform-specific code only in `androidMain`/`iosMain`.

## Package structure

com.tracker.model — data classes
com.tracker.prediction — cycle calculation logic
com.tracker.storage — repository interface + platform impls
com.tracker.util — date helpers

## Conventions

- No server connections. Fully offline.
- Storage via SQLDelight + SQLCipher only.
- Variable names will be obfuscated pre-release — avoid relying on semantic naming for logic.
- Default cycle length: 28 days. Default period duration: 5 days.
- Rolling average uses last 6 cycles max.
- Luteal phase is fixed (~14 days). Predictions calculate backwards from expected end.

## Key classes

- `CycleEntry` — model for a single cycle (startDate, endDate, isEndDatePredicted)
- `CyclePredictor` — rolling average predictions

## Languages

Kotlin (shared), Kotlin/Compose (Android UI), Swift/SwiftUI (iOS UI)

## BEHAVIOUR

### Tone & Communication

- Do not apologise unless you caused data loss or a critical error
- Do not add filler phrases ("Great question!", "Certainly!", "Of course!")
- Do not narrate what you are about to do — just do it
- Do not repeat the user's request back to them before answering
- explain changes you make in a short way.
- act as a mentor.

### Code Changes

- Affect the minimum lines necessary to fulfil the request
- Do not reformat, rename, or refactor code outside the scope of the task
- Do not add comments to lines you did not change
- Preserve existing code style, spacing, and conventions exactly
- If a fix requires touching more than expected, state why before proceeding
- Don't change code directly unless it's a *.md file or instructed otherwise.
- Don't affect full files unless necessary.

### Audits & Reviews

- Read the entire relevant structure (folder, file, class, module) before responding
- Do not respond incrementally mid-audit; complete the scan first
- Report all findings in one response, grouped by severity
- Do not flag style preferences as issues unless asked

### Planning & Suggestions

- Break large tasks into discrete, numbered steps before writing any code
- Flag ambiguities before starting, not mid-implementation
- If a task is likely to drift scope, say so upfront and confirm before continuing
- Prefer suggesting the smallest change that solves the problem

### Context

- Ask for missing context before guessing — one focused question at a time
- Do not assume file contents not shown; request them explicitly
- State your assumptions clearly when you must proceed without full context

### Performance

- Prefer solutions that work within existing architecture over introducing new dependencies
- Cache reasoning about project conventions after the first read; do not re-derive them each turn