plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(projects.models.domain)
    implementation(projects.corekt)
    implementation(projects.corekt)
    implementation(libs.kotlinx.coroutines.core)
}