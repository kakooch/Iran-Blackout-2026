package org.aspectj.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes8.dex */
public class SoftException extends RuntimeException {
    private static final boolean b;
    Throwable a;

    static {
        boolean z;
        try {
            Class.forName("java.nio.Buffer");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        b = z;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable th = this.a;
        if (b || th == null) {
            return;
        }
        printStream.print("Caused by: ");
        th.printStackTrace(printStream);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable th = this.a;
        if (b || th == null) {
            return;
        }
        printWriter.print("Caused by: ");
        th.printStackTrace(printWriter);
    }
}
