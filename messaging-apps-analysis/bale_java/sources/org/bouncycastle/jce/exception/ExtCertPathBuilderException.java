package org.bouncycastle.jce.exception;

import java.security.cert.CertPathBuilderException;

/* loaded from: classes8.dex */
public class ExtCertPathBuilderException extends CertPathBuilderException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
