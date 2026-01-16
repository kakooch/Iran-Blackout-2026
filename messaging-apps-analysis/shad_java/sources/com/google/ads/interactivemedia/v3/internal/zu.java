package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class zu implements so<zu> {
    public final String p;
    public final List<String> q;
    public final boolean r;

    protected zu(String str, List<String> list, boolean z) {
        this.p = str;
        this.q = Collections.unmodifiableList(list);
        this.r = z;
    }
}
