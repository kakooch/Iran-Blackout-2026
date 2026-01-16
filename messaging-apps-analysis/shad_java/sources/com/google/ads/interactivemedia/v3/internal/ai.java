package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ai {
    private final s a;
    private final ArrayList<String> b = new ArrayList<>();

    public ai(s sVar, String str) {
        this.a = sVar;
        a(str);
    }

    public final void a(String str) {
        this.b.add(str);
    }

    public final s b() {
        return this.a;
    }

    public final ArrayList<String> c() {
        return this.b;
    }
}
