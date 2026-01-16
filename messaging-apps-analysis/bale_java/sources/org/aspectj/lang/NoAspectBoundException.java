package org.aspectj.lang;

/* loaded from: classes8.dex */
public class NoAspectBoundException extends RuntimeException {
    Throwable a;

    public NoAspectBoundException(String str, Throwable th) {
        if (th != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Exception while initializing ");
            stringBuffer.append(str);
            stringBuffer.append(": ");
            stringBuffer.append(th);
            str = stringBuffer.toString();
        }
        super(str);
        this.a = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    public NoAspectBoundException() {
    }
}
