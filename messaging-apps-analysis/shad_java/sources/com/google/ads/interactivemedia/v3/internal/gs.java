package com.google.ads.interactivemedia.v3.internal;

import android.media.AudioAttributes;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class gs {
    public static final gs a = ih.a(1, 1);
    public final int b = 0;
    public final int c = 1;
    public final int d = 1;
    private AudioAttributes e;

    /* synthetic */ gs(int i, int i2) {
    }

    public final AudioAttributes a() {
        if (this.e == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
            if (aeu.a >= 29) {
                usage.setAllowedCapturePolicy(1);
            }
            this.e = usage.build();
        }
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || gs.class != obj.getClass()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 15699889;
    }
}
