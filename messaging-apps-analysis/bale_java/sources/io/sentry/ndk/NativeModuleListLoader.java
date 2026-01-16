package io.sentry.ndk;

/* loaded from: classes3.dex */
public final class NativeModuleListLoader {
    public static native void nativeClearModuleList();

    public static native DebugImage[] nativeLoadModuleList();
}
