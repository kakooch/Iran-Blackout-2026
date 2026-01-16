package androidx.constraintlayout.core.parser;

import android.gov.nist.core.Separators;

/* loaded from: classes2.dex */
public class CLParsingException extends Exception {
    private final String a;
    private final int b;
    private final String c;

    public String a() {
        return this.a + " (" + this.c + " at line " + this.b + Separators.RPAREN;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + a();
    }
}
