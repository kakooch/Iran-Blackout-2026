package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class kj {
    private final aee a = new aee(10);

    public final qz a(jv jvVar, ry ryVar) throws IOException {
        qz qzVarC = null;
        int i = 0;
        while (true) {
            try {
                jvVar.g(this.a.i(), 0, 10);
                this.a.h(0);
                if (this.a.r() != 4801587) {
                    break;
                }
                this.a.k(3);
                int iA = this.a.A();
                int i2 = iA + 10;
                if (qzVarC == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.a.i(), 0, bArr, 0, 10);
                    jvVar.g(bArr, 10, iA);
                    qzVarC = new sa(ryVar).c(bArr, i2);
                } else {
                    jvVar.i(iA);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        jvVar.j();
        jvVar.i(i);
        return qzVarC;
    }
}
