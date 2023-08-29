pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Test2"
include(":app")
include(":calc")
include(":animal")
include(":ch05_01")
include(":calc2_number_button")
include(":ch06_01_reservation")
include(":ch06_02_viewflipper")
include(":ch06_03_tabhost")
include(":ch06_04_actionbar_and_fragment")
include(":ch06_05_webview")
include(":ch07_01_menu_01_options")
include(":ch07_02_menu_02_jeju")
include(":ch07_03_dialog_multi")
include(":ch07_04_dialog_login")
include(":ch10_activity_01")
include(":ch10_activity_02_movie")
