package io.appmetrica.analytics.impl;

import android.util.Base64;

/* loaded from: classes3.dex */
public final class F9 implements InterfaceC3014z8 {
    @Override // io.appmetrica.analytics.impl.InterfaceC3014z8
    public final C2870t8 a(Q5 q5) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC3014z8
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final B8 a() {
        return B8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}
