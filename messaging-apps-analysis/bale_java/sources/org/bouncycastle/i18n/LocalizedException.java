package org.bouncycastle.i18n;

/* loaded from: classes8.dex */
public class LocalizedException extends Exception {
    private Throwable a;

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }
}
