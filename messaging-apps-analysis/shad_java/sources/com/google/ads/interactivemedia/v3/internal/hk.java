package com.google.ads.interactivemedia.v3.internal;

import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class hk extends Exception {
    public final boolean a;

    public hk(int i, int i2, int i3, int i4, boolean z, Exception exc) {
        String str = true != z ? BuildConfig.FLAVOR : " (recoverable)";
        StringBuilder sb = new StringBuilder(str.length() + 80);
        sb.append("AudioTrack init failed ");
        sb.append(i);
        sb.append(" ");
        sb.append("Config(");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(")");
        sb.append(str);
        super(sb.toString(), exc);
        this.a = z;
    }
}
