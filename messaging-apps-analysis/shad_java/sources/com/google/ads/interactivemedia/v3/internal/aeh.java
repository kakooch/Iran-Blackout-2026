package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* loaded from: classes.dex */
final /* synthetic */ class aeh implements Comparator {
    static final Comparator a = new aeh();

    private aeh() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return Float.compare(((aei) obj).c, ((aei) obj2).c);
    }
}
