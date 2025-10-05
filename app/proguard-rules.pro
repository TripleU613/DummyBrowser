# Keep Lottie animations
-keep class com.airbnb.lottie.** { *; }
-dontwarn com.airbnb.lottie.**

# Keep Compose classes
-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

# Keep annotations
-dontwarn javax.annotation.**
-keep class javax.annotation.Nullable { *; }

# Keep R classes for resources
-keepclassmembers class **.R$* {
    public static <fields>;
}
