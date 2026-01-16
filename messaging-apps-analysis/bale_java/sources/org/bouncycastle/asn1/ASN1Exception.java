package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes8.dex */
public class ASN1Exception extends IOException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
