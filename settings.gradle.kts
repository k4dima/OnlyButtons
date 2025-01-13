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
        /*mavenLocal()*/
        maven("https://maven.pkg.github.com/k4dima/testio") {
            credentials {
                username = extra["gpr.user"] as String?
                password = extra["gpr.key"] as String?
            }
        }
    }
}
@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        /*mavenLocal()*/
        maven("https://maven.pkg.github.com/k4dima/testio") {
            credentials {
                username = extra["gpr.user"] as String?
                password = extra["gpr.key"] as String?
            }
        }
    }
    versionCatalogs {
        create("tlibs") { from("com.github.k4dima.testio:catalog:0.1.0-SNAPSHOT") }
    }
}
include(":app")