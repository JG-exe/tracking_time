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
