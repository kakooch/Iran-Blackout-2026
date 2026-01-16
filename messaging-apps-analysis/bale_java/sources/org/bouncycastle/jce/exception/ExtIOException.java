package org.bouncycastle.jce.exception;

import java.io.IOException;

/* loaded from: classes8.dex */
public class ExtIOException extends IOException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
