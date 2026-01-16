package org.bouncycastle.crypto.io;

import java.io.IOException;

/* loaded from: classes8.dex */
public class CipherIOException extends IOException {
    private final Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
