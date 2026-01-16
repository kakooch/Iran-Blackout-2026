package io.sentry;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes3.dex */
public final class S3 implements ILogger {
    private String e(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // io.sentry.ILogger
    public void a(Y2 y2, Throwable th, String str, Object... objArr) {
        if (th == null) {
            c(y2, str, objArr);
        } else {
            System.out.println(String.format("%s: %s \n %s\n%s", y2, String.format(str, objArr), th.toString(), e(th)));
        }
    }

    @Override // io.sentry.ILogger
    public void b(Y2 y2, String str, Throwable th) {
        if (th == null) {
            c(y2, str, new Object[0]);
        } else {
            System.out.println(String.format("%s: %s\n%s", y2, String.format(str, th.toString()), e(th)));
        }
    }

    @Override // io.sentry.ILogger
    public void c(Y2 y2, String str, Object... objArr) {
        System.out.println(String.format("%s: %s", y2, String.format(str, objArr)));
    }

    @Override // io.sentry.ILogger
    public boolean d(Y2 y2) {
        return true;
    }
}
