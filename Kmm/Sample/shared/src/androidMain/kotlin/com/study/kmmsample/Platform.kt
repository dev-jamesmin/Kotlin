package com.study.kmmsample

actual class Platform actual constructor() {
    actual val platform: String = "JS- MAIN ${android.os.Build.VERSION.SDK_INT}"
}