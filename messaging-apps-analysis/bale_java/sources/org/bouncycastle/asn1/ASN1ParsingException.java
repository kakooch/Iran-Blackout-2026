package org.bouncycastle.asn1;

/* loaded from: classes8.dex */
public class ASN1ParsingException extends IllegalStateException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
