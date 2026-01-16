package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
abstract class p extends n {
    private static final WeakReference i = new WeakReference(null);
    private WeakReference h;

    p(byte[] bArr) {
        super(bArr);
        this.h = i;
    }

    @Override // com.google.android.gms.common.n
    final byte[] E2() {
        byte[] bArrF2;
        synchronized (this) {
            try {
                bArrF2 = (byte[]) this.h.get();
                if (bArrF2 == null) {
                    bArrF2 = F2();
                    this.h = new WeakReference(bArrF2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrF2;
    }

    protected abstract byte[] F2();
}
