package org.bouncycastle.util.encoders;

/* loaded from: classes8.dex */
public class DecoderException extends IllegalStateException {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
