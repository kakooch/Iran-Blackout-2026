package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class bn extends Exception {
    public final int a;
    public final String b;
    public final int c;
    public final cy d;
    public final int e;
    public final int f;
    public final long g;
    public final tw h;
    final boolean i;
    private final Throwable j;

    private bn(int i, Throwable th) {
        this(i, th, null, -1, null, 4, 0, false);
    }

    public static bn a(IOException iOException) {
        return new bn(0, iOException);
    }

    public static bn b(Exception exc, String str, int i, cy cyVar, int i2, boolean z) {
        return new bn(1, exc, str, i, cyVar, cyVar == null ? 4 : i2, 0, z);
    }

    public static bn c(RuntimeException runtimeException) {
        return new bn(2, runtimeException);
    }

    public static bn d(OutOfMemoryError outOfMemoryError) {
        return new bn(4, outOfMemoryError);
    }

    public static bn e(TimeoutException timeoutException, int i) {
        return new bn(5, timeoutException, null, -1, null, 4, i, false);
    }

    final bn f(tw twVar) {
        return new bn(getMessage(), this.j, this.a, this.b, this.c, this.d, this.e, twVar, this.f, this.g, this.i);
    }

    private bn(int i, Throwable th, String str, int i2, cy cyVar, int i3, int i4, boolean z) {
        String string;
        String str2;
        if (i == 0) {
            string = "Source error";
        } else if (i != 1) {
            string = i != 3 ? i != 4 ? i != 5 ? "Unexpected runtime error" : "Timeout error" : "Out of memory error" : "Remote error";
        } else {
            String strValueOf = String.valueOf(cyVar);
            if (i3 == 0) {
                str2 = "NO";
            } else if (i3 == 1) {
                str2 = "NO_UNSUPPORTED_TYPE";
            } else if (i3 == 2) {
                str2 = "NO_UNSUPPORTED_DRM";
            } else if (i3 == 3) {
                str2 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i3 != 4) {
                    throw new IllegalStateException();
                }
                str2 = "YES";
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 53 + strValueOf.length() + str2.length());
            sb.append(str);
            sb.append(" error, index=");
            sb.append(i2);
            sb.append(", format=");
            sb.append(strValueOf);
            sb.append(", format_supported=");
            sb.append(str2);
            string = sb.toString();
        }
        if (!TextUtils.isEmpty(null)) {
            String strValueOf2 = String.valueOf(string);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 2 + "null".length());
            sb2.append(strValueOf2);
            sb2.append(": ");
            sb2.append((String) null);
            string = sb2.toString();
        }
        this(string, th, i, str, i2, cyVar, i3, null, i4, SystemClock.elapsedRealtime(), z);
    }

    private bn(String str, Throwable th, int i, String str2, int i2, cy cyVar, int i3, tw twVar, int i4, long j, boolean z) {
        super(str, th);
        this.a = i;
        this.j = th;
        this.b = str2;
        this.c = i2;
        this.d = cyVar;
        this.e = i3;
        this.h = twVar;
        this.f = i4;
        this.g = j;
        this.i = z;
    }
}
