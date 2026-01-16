package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final /* synthetic */ class ih {
    public static gs a(int i, int i2) {
        return new gs(1, 1);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }
}
