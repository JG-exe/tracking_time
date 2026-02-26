plugins {
	kotlin("multiplatform")
	id("com.android.library")
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
			}
		}

		val androidMain by getting
		val iosMain by creating {
			dependsOn(commonMain)
		}
	}
}


android {
	namespace = "com.tracker"
	compileSdk = 34
	defaultConfig { minSdk = 24 }
}