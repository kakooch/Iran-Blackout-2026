package com.google.crypto.tink.internal;

/* loaded from: classes3.dex */
public final class TinkBugException extends RuntimeException {

    public interface a {
        Object get();
    }

    public TinkBugException(String str) {
        super(str);
    }

    public static Object a(a aVar) {
        try {
            return aVar.get();
        } catch (Exception e) {
            throw new TinkBugException(e);
        }
    }

    public TinkBugException(String str, Throwable th) {
        super(str, th);
    }

    public TinkBugException(Throwable th) {
        super(th);
    }
}
