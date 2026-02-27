```json
PeriodTracker/
├── shared/
│   ├── src/
│   │   ├── commonMain/kotlin/com/tracker/
│   │   │   ├── model/
│   │   │   │   └── CycleEntry.kt        // data classes only
│   │   │   ├── prediction/
│   │   │   │   └── CyclePredictor.kt    // rolling average logic
│   │   │   ├── storage/
│   │   │   │   └── CycleRepository.kt   // interface (expect)
│   │   │   └── util/
│   │   │       └── DateUtils.kt         // date helpers
│   │   │
│   │   ├── androidMain/kotlin/com/tracker/
│   │   │   └── storage/
│   │   │       └── AndroidCycleRepository.kt  // actual impl for Android
│   │   │
│   │   └── iosMain/kotlin/com/tracker/
│   │       └── storage/
│   │           └── IosCycleRepository.kt      // actual impl for iOS
│   │
│   └── build.gradle.kts             // declares KMP targets + shared deps
│
├── androidApp/
│   ├── src/main/
│   │   ├── java/com/tracker/
│   │   │   └── MainActivity.kt      // Android entry point
│   │   └── res/                     // layouts, drawables, strings
│   └── build.gradle.kts             // Android-specific deps (Compose etc)
│
├── iosApp/                          // Xcode project — not a Gradle module
│   ├── iosApp.xcodeproj
│   └── iosApp/
│       ├── ContentView.swift        // iOS UI entry point
│       └── iOSApp.swift             // app bootstrap
│
├── build.gradle.kts                 // root: just wires modules together
├── settings.gradle.kts              // declares which modules exist
└── gradle.properties                // JVM args, KMP flags
```