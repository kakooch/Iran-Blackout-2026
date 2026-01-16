package io.appmetrica.analytics.impl;

/* loaded from: classes3.dex */
public enum B8 {
    NONE(0),
    EXTERNALLY_ENCRYPTED_EVENT_CRYPTER(1),
    AES_VALUE_ENCRYPTION(2);

    public final int a;

    B8(int i) {
        this.a = i;
    }

    public static B8 a(Integer num) {
        if (num != null) {
            for (B8 b8 : values()) {
                if (b8.a == num.intValue()) {
                    return b8;
                }
            }
        }
        return NONE;
    }
}
