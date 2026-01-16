package org.bouncycastle.util.encoders;

/* loaded from: classes8.dex */
public class EncoderException extends IllegalStateException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
