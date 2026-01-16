package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class afa extends Surface {
    private static int a;
    private static boolean b;
    private final aez c;
    private boolean d;

    /* synthetic */ afa(aez aezVar, SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.c = aezVar;
    }

    public static synchronized boolean a(Context context) {
        String strEglQueryString;
        String strEglQueryString2;
        if (!b) {
            int i = aeu.a;
            int i2 = 2;
            if (i < 24 || ((i < 26 && ("samsung".equals(aeu.c) || "XT1650".equals(aeu.d))) || ((i < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) || (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !strEglQueryString.contains("EGL_EXT_protected_content")))) {
                i2 = 0;
            } else if (i >= 17 && (strEglQueryString2 = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString2.contains("EGL_KHR_surfaceless_context")) {
                i2 = 1;
            }
            a = i2;
            b = true;
        }
        return a != 0;
    }

    public static afa b(Context context, boolean z) {
        boolean z2 = true;
        if (z && !a(context)) {
            z2 = false;
        }
        ary.q(z2);
        return new aez().a(z ? a : 0);
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.c) {
            if (!this.d) {
                this.c.b();
                this.d = true;
            }
        }
    }
}
