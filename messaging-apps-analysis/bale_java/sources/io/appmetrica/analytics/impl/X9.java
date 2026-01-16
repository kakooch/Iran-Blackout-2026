package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public enum X9 {
    UNKNOWN(0),
    FIRST_OCCURRENCE(1),
    NON_FIRST_OCCURENCE(2);

    public final int a;

    X9(int i) {
        this.a = i;
    }

    public static X9 a(Integer num) {
        if (num != null) {
            for (X9 x9 : values()) {
                if (x9.a == num.intValue()) {
                    return x9;
                }
            }
        }
        return UNKNOWN;
    }
}
