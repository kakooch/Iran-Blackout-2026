package org.bouncycastle.util.io.pem;

import java.io.IOException;

/* loaded from: classes8.dex */
public class PemGenerationException extends IOException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
