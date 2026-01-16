package org.bouncycastle.crypto;

/* loaded from: classes8.dex */
public class CryptoException extends Exception {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
