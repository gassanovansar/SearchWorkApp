pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SearchWorkApp"
include(":app")
include(":core")
include(":common")
include(":models")
include(":uikit")
include(":features:favourite")
include(":features:search")
include(":features:auth:domain")
include(":features:auth:ui")
include(":source")
include(":managers")
include(":features:main:data")
include(":features:main:ui")
include(":features:main:domain")
include(":features:detail:ui")
include(":features:detail:domain")
include(":features:search:ui")
include(":features:search:domain")
include(":features:favourite:domain")
include(":features:favourite:ui")
