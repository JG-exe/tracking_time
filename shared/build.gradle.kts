plugins {
	kotlin("multiplatform")
	id("com.android.library")
	id("app.cash.sqldelight")
}
kotlin {
	androidTarget()
	iosX64()
	iosArm64()
	iosSimulatorArm64()

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
				implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
				implementation("app.cash.sqldelight:runtime:2.0.1")
			}
		}

		val androidMain by getting {
			dependencies {
				implementation("app.cash.sqldelight:android-driver:2.0.1")
			}
		}
		val iosMain by creating {
			dependsOn(commonMain)
			dependencies {
				implementation("app.cash.sqldelight:native-driver:2.0.1")
			}
		}
		val iosX64Main by getting {
			dependsOn(iosMain)
		}
		val iosArm64Main by getting {
			dependsOn(iosMain)
		}
		val iosSimulatorArm64Main by getting {
			dependsOn(iosMain)
		}
	}
}


android {
	namespace = "com.tracker"
	compileSdk = 34
	defaultConfig { minSdk = 24 }
}

sqldelight {
	databases {
		create("AppDatabase") {
			packageName.set("com.tracker.db")
		}
	}
}
