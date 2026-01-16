package org.bouncycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes8.dex */
public class TlsException extends IOException {
    protected Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
