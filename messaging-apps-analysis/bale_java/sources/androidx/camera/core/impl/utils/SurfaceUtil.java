package androidx.camera.core.impl.utils;

import android.view.Surface;

/* loaded from: classes.dex */
public abstract class SurfaceUtil {

    public static class a {
        public int a = 0;
        public int b = 0;
        public int c = 0;
    }

    static {
        System.loadLibrary("surface_util_jni");
    }

    public static a a(Surface surface) {
        int[] iArrNativeGetSurfaceInfo = nativeGetSurfaceInfo(surface);
        a aVar = new a();
        aVar.a = iArrNativeGetSurfaceInfo[0];
        aVar.b = iArrNativeGetSurfaceInfo[1];
        aVar.c = iArrNativeGetSurfaceInfo[2];
        return aVar;
    }

    private static native int[] nativeGetSurfaceInfo(Surface surface);
}
