package org.linphone.core;

/* loaded from: classes3.dex */
public class CoreException extends Exception {
    public CoreException() {
    }

    public CoreException(String str) {
        super(str);
    }

    public CoreException(Throwable th) {
        super(th);
    }

    public CoreException(String str, Throwable th) {
        super(str, th);
    }
}
