package com.google.common.base;

/* loaded from: classes3.dex */
public final class Verify {
    public static void verify(boolean z, String str, Object obj) {
        if (!z) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }
}
