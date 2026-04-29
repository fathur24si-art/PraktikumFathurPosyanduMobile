plugins {
    alias(libs.plugins.android.application)
}

android {
    buildFeatures {
        viewBinding = true
    }
    namespace = "com.example.fathur_carry"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fathur_carry"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// Task to fix resource names and locations
tasks.register("fixResourceFiles") {
    doLast {
        // Fix font names
        val fontDir = file("src/main/res/font")
        if (fontDir.exists()) {
            fontDir.listFiles()?.forEach { f ->
                val name = f.name
                if (name == "OFL.txt") {
                    f.delete()
                    println("Deleted: $name")
                } else {
                    val newName = name.lowercase().replace("-", "_")
                    if (name != newName) {
                        val destination = file("src/main/res/font/$newName")
                        if (f.renameTo(destination)) {
                            println("Renamed: $name -> $newName")
                        }
                    }
                }
            }
        }
        
        // Remove misplaced menu file in layout folder
        val misplacedMenu = file("src/main/res/layout/menu_pertemuan5.xml")
        if (misplacedMenu.exists()) {
            if (misplacedMenu.delete()) {
                println("Deleted misplaced menu file: layout/menu_pertemuan5.xml")
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.play.services.maps)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
