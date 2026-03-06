# Project TODOs

### Missing Implementations

- [x] **`CycleEntry.kt`**: Create the `CycleEntry` data class in the `shared/src/commonMain/kotlin/com/tracker/model/` directory.
- [x] **SQLDelight Setup**: 
    - [x] Add the SQLDelight plugin to `shared/build.gradle.kts`.
    - [x] Add SQLDelight dependencies for the common and Android source sets.
- [ ] **Database Implementation**:
    - [ ] Define the database schema in a `.sq` file.
    - [ ] Implement the platform-specific database driver in `shared/src/androidMain`.
- [ ] **Repository Implementation**: Implement the `CycleRepository` interface to interact with the SQLDelight database.

### Future Work

- [ ] **Android UI**: Build the Jetpack Compose UI for the Android app.
    - **Note:** Remember to update the `README.md` tech stack when this is added.
- [ ] **iOS UI**: Build the SwiftUI interface for the iOS app.

- [ ] All DB tables encrypted with SQLCipher (key derived from user PIN)
- [ ] Field‑level encryption for health‑sensitive columns
- [ ] Granular consent UI + signed ConsentReceipt storage
- [ ] Retention job (auto‑purge >5 years)
- [ ] “Delete all my data” button that wipes DB, model, audit log
- [ ] Integrity monitor + 72‑hour breach‑report template
- [ ] Append‑only encrypted audit log (metadata only)
- [ ] PIA document signed by DPO, referenced in app
- [ ] No third‑party telemetry SDKs linked
- [ ] Clear privacy notice displayed on first launch
- [ ] DPO dashboard (audit view, consent revocation) behind admin guard
