package org.bouncycastle.util;

/* loaded from: classes8.dex */
public class StreamParsingException extends Exception {
    Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
