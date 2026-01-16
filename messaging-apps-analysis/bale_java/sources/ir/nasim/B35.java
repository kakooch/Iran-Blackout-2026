package ir.nasim;

import android.content.Context;
import androidx.tracing.perfetto.jni.PerfettoNative;
import androidx.tracing.perfetto.security.IncorrectChecksumException;
import java.io.File;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes2.dex */
public final class B35 {
    private static boolean b;
    public static final B35 a = new B35();
    private static final ReentrantReadWriteLock c = new ReentrantReadWriteLock();

    private B35() {
    }

    public static /* synthetic */ ZW5 c(B35 b35, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        return b35.a(i, str);
    }

    private final ZW5 e(XV4 xv4) {
        ReentrantReadWriteLock reentrantReadWriteLock = c;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        AbstractC13042fc3.h(lock, "enableTracingLock.readLock()");
        lock.lock();
        try {
            if (b) {
                return c(a, 2, null, 2, null);
            }
            C19938rB7 c19938rB7 = C19938rB7.a;
            lock.unlock();
            ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
            AbstractC13042fc3.h(writeLock, "enableTracingLock.writeLock()");
            writeLock.lock();
            try {
                return a.h(xv4);
            } finally {
                writeLock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    private final ZW5 h(XV4 xv4) {
        if (!c.isWriteLockedByCurrentThread()) {
            throw new RuntimeException();
        }
        if (b) {
            return c(this, 2, null, 2, null);
        }
        try {
            if (xv4 == null) {
                PerfettoNative.a.a();
            } else {
                PerfettoNative.a.b((File) xv4.a(), new C19327q96((Context) xv4.b()));
            }
            String strNativeVersion = PerfettoNative.nativeVersion();
            if (AbstractC13042fc3.d(strNativeVersion, "1.0.0")) {
                try {
                    PerfettoNative.nativeRegisterWithPerfetto();
                    b = true;
                    return c(this, 1, null, 2, null);
                } catch (Exception e) {
                    return b(99, e);
                }
            }
            return a(12, "Binary and Java version mismatch. Binary: " + strNativeVersion + ". Java: 1.0.0");
        } catch (Throwable th) {
            if (th instanceof IncorrectChecksumException) {
                return b(13, th);
            }
            if (th instanceof UnsatisfiedLinkError) {
                return b(11, th);
            }
            if (th instanceof Exception) {
                return b(99, th);
            }
            throw th;
        }
    }

    private final String j(Throwable th) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        if (th.getMessage() != null) {
            str = ": " + th.getMessage();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public final ZW5 a(int i, String str) {
        return new ZW5(i, "1.0.0", str);
    }

    public final ZW5 b(int i, Throwable th) {
        AbstractC13042fc3.i(th, "exception");
        return a(i, j(th));
    }

    public final void d(String str) {
        AbstractC13042fc3.i(str, "sectionName");
        if (b) {
            PerfettoNative.nativeTraceEventBegin(0, str);
        }
    }

    public final ZW5 f() {
        return e(null);
    }

    public final ZW5 g(File file, Context context) {
        AbstractC13042fc3.i(file, "file");
        AbstractC13042fc3.i(context, "context");
        return e(AbstractC4616Fw7.a(file, context));
    }

    public final void i() {
        if (b) {
            PerfettoNative.nativeTraceEventEnd();
        }
    }

    public final boolean k() {
        return b;
    }
}
