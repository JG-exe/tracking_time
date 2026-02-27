# Tracking times

> A truly private period tracking app

---

## Why

With this project I want to learn more about app development and prediction algorithms.

Most period tracking apps send your data to remote servers. This one won't.  
Everything stays on your device. No accounts, cloud syncs or telemetry.

---

## Features

- [ ] Cycle logging (start date, duration)
- [ ] Flow intensity tracking
- [ ] symptom tracking
- [ ] Cycle length prediction (rolling average, 3-6 cycles)
- [ ] Ovulation detection and luteal phase lock
- [ ] Fertile window indicator
- [ ] Local-only data storage. No network calls, ever
- [ ] Purge data button to remove all data and overwrite the storage with crap to prevent data
  retrieval

---

## Data & Privacy

- All data is stored locally.
    - The plan is to use Room (SQLite) for this.
- The app requests no internet permission and will never connect itself to the internet.
- No analytics, no crash reporting, no third part SDKs that phone home.
    - (Please don't hesitate to let me know if anything is wrong.)

### Project Structure

```
app/
├── data/
│   ├── local/          # Room database, DAOs, entities
│   └── repository/     # Repository implementations
├── domain/
│   ├── model/          # Domain models (Cycle, Phase, Biomarker, etc.)
│   └── usecase/        # Business logic and prediction algorithm
└── ui/
    ├── home/           # Cycle overview screen
    ├── log/            # Daily tracking input
    └── history/        # Past cycles and trends
```

---

## Prediction Algorithm

The app calculates cycle predictions by working **backwards from the predicted end of the cycle**,
not forwards from day one. This is because the luteal phase (post-ovulation) is relatively
consistent per individual (~12–16 days), while the follicular phase is highly variable.

Key algorithm rules:

- Uses a rolling average of the last 3–6 cycles to estimate the follicular phase length.
- A positive LH test acts as a **hard interrupt** — all prior calendar predictions are discarded and
  the next period is recalculated as ~14 days from that point.
- A confirmed BBT shift (≥0.3°C sustained for 3+ days) **locks the fertile window** and begins the
  countdown to the next cycle.

---

## Tech Stack

- **Language:** Kotlin
- **Min SDK:** 24 (Android 7.0)

---

## Development Tools

For this project, I use JetBrains' Android Studio with the Gemini 2.5^ Pro as integrated assistant
to speed up the development.  
I also use Claude Sonnet 4.6^ to help me with the file structure as I learn.
I also use Claude Sonnet 4.6^ to help me with the file structure as I learn.

---

## Licence

Source-available. You may read and audit the code, but no licence is granted
to copy, modify, distribute, or use it in your own projects.  
See [LICENCE.md](./LICENCE.md) for full terms.