pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://jitpack.io/")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://jitpack.io/")
    }
}

buildscript {
    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://jitpack.io/")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21" apply false
    id("com.vanniktech.maven.publish") version "0.29.0" apply false
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0" apply true
}

include(":kotlin-commons")