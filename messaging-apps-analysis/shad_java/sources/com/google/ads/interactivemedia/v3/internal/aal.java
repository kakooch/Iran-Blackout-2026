package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* loaded from: classes.dex */
final /* synthetic */ class aal implements Comparator {
    static final Comparator a = new aal();

    private aal() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Integer num = (Integer) obj;
        Integer num2 = (Integer) obj2;
        int i = aaw.a;
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }
}
