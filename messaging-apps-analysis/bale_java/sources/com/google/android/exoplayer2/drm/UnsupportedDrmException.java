package com.google.android.exoplayer2.drm;

/* loaded from: classes2.dex */
public final class UnsupportedDrmException extends Exception {
    public final int a;

    public UnsupportedDrmException(int i) {
        this.a = i;
    }

    public UnsupportedDrmException(int i, Exception exc) {
        super(exc);
        this.a = i;
    }
}
