package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Looper;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class H extends Error {
    public final long a;

    private static class a implements Serializable {
        private final String a;
        private final StackTraceElement[] b;

        /* renamed from: ir.nasim.H$a$a, reason: collision with other inner class name */
        private class C0397a extends Throwable {
            /* synthetic */ C0397a(a aVar, C0397a c0397a, b bVar) {
                this(c0397a);
            }

            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                setStackTrace(a.this.b);
                return this;
            }

            private C0397a(C0397a c0397a) {
                super(a.this.a, c0397a);
            }
        }

        /* synthetic */ a(String str, StackTraceElement[] stackTraceElementArr, b bVar) {
            this(str, stackTraceElementArr);
        }

        private a(String str, StackTraceElement[] stackTraceElementArr) {
            this.a = str;
            this.b = stackTraceElementArr;
        }
    }

    static class b implements Comparator {
        final /* synthetic */ Thread a;

        b(Thread thread) {
            this.a = thread;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Thread thread, Thread thread2) {
            if (thread == thread2) {
                return 0;
            }
            Thread thread3 = this.a;
            if (thread == thread3) {
                return 1;
            }
            if (thread2 == thread3) {
                return -1;
            }
            return thread2.getName().compareTo(thread.getName());
        }
    }

    private H(a.C0397a c0397a, long j) {
        super("Application Not Responding for at least " + j + " ms.", c0397a);
        this.a = j;
    }

    static H a(long j, String str, boolean z) {
        Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new b(thread));
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() == thread || (entry.getKey().getName().startsWith(str) && (z || entry.getValue().length > 0))) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (!treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        b bVar = null;
        a.C0397a c0397a = null;
        for (Map.Entry entry2 : treeMap.entrySet()) {
            c0397a = new a.C0397a(new a(c((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue(), bVar), c0397a, bVar);
        }
        return new H(c0397a, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static H b(long j) {
        Thread thread = Looper.getMainLooper().getThread();
        return new H(new a.C0397a(new a(c(thread), thread.getStackTrace(), null), 0 == true ? 1 : 0, 0 == true ? 1 : 0), j);
    }

    private static String c(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + Separators.RPAREN;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
