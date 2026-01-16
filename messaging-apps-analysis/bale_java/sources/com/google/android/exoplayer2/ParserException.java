package com.google.android.exoplayer2;

import java.io.IOException;

/* loaded from: classes2.dex */
public class ParserException extends IOException {
    public final boolean a;
    public final int b;

    protected ParserException(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.a = z;
        this.b = i;
    }

    public static ParserException a(String str, Throwable th) {
        return new ParserException(str, th, true, 1);
    }

    public static ParserException b(String str, Throwable th) {
        return new ParserException(str, th, true, 0);
    }

    public static ParserException c(String str, Throwable th) {
        return new ParserException(str, th, true, 4);
    }

    public static ParserException d(String str) {
        return new ParserException(str, null, false, 1);
    }
}
