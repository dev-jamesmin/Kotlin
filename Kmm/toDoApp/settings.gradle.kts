//pluginManagement {
//    repositories {
//        google()
//        gradlePluginPortal()
//        mavenCentral()
//    }
//}

rootProject.name = "toDoApp"
//include(":androidApp")
//include(":shared")
//include(":web")
//include(":common:edit")
//include(":common:utils")
//include(":common:database")
//include(":common:main")
//include(":common:root")
//include(":common:compose-ui")

include(
    ":common:utils",
    ":common:database",
    ":common:main",
    ":common:edit",
    ":common:root",
    ":common:compose-ui",
    ":androidApp",
    ":web"
)

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