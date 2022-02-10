pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "toDoApp"
include(":androidApp")
include(":shared")
include(":web")


//include(
//    ":common:utils",
//    ":common:database",
//    ":common:main",
//    ":common:edit",
//    ":common:root",
//    ":common:compose-ui",
//    ":android",
//    ":desktop",
//    ":web"
//)