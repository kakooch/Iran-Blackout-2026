package org.bouncycastle.jce.exception;

import java.security.cert.CertificateEncodingException;

/* loaded from: classes8.dex */
public class ExtCertificateEncodingException extends CertificateEncodingException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
