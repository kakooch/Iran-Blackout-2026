package com.google.android.play.core.splitinstall.internal;

/* loaded from: classes3.dex */
public final class zzbh extends RuntimeException {
    public zzbh(String str) {
        super(str);
    }

    public zzbh(String str, Throwable th) {
        super("Failed to initialize FileStorage", th);
    }
}
