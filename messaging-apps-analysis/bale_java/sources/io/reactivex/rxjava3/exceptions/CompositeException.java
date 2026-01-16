package io.reactivex.rxjava3.exceptions;

import android.gov.nist.core.Separators;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes3.dex */
public final class CompositeException extends RuntimeException {
    private final List a;
    private final String b;
    private Throwable c;

    static final class a extends RuntimeException {
        a(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    static abstract class b {
        b() {
        }

        abstract void a(Object obj);
    }

    static final class c extends b {
        private final PrintStream a;

        c(PrintStream printStream) {
            this.a = printStream;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.b
        void a(Object obj) {
            this.a.println(obj);
        }
    }

    static final class d extends b {
        private final PrintWriter a;

        d(PrintWriter printWriter) {
            this.a = printWriter;
        }

        @Override // io.reactivex.rxjava3.exceptions.CompositeException.b
        void a(Object obj) {
            this.a.println(obj);
        }
    }

    public CompositeException(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private void c(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i = 1;
        for (Throwable th : this.a) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, th, Separators.HT);
            i++;
        }
        bVar.a(sb.toString());
    }

    public List b() {
        return this.a;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        int i;
        try {
            if (this.c == null) {
                String property = System.getProperty("line.separator");
                if (this.a.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Multiple exceptions (");
                    sb.append(this.a.size());
                    sb.append(Separators.RPAREN);
                    sb.append(property);
                    for (Throwable cause : this.a) {
                        int i2 = 0;
                        while (true) {
                            if (cause != null) {
                                for (int i3 = 0; i3 < i2; i3++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append(cause.getClass().getCanonicalName());
                                sb.append(": ");
                                String message = cause.getMessage();
                                if (message == null || !message.contains(property)) {
                                    sb.append(message);
                                    sb.append(property);
                                } else {
                                    sb.append(property);
                                    for (String str : message.split(property)) {
                                        for (int i4 = 0; i4 < i2 + 2; i4++) {
                                            sb.append("  ");
                                        }
                                        sb.append(str);
                                        sb.append(property);
                                    }
                                }
                                int i5 = 0;
                                while (true) {
                                    i = i2 + 2;
                                    if (i5 >= i) {
                                        break;
                                    }
                                    sb.append("  ");
                                    i5++;
                                }
                                StackTraceElement[] stackTrace = cause.getStackTrace();
                                if (stackTrace.length > 0) {
                                    sb.append("at ");
                                    sb.append(stackTrace[0]);
                                    sb.append(property);
                                }
                                if (identityHashMap.containsKey(cause)) {
                                    Throwable cause2 = cause.getCause();
                                    if (cause2 != null) {
                                        for (int i6 = 0; i6 < i; i6++) {
                                            sb.append("  ");
                                        }
                                        sb.append("|-- ");
                                        sb.append("(cause not expanded again) ");
                                        sb.append(cause2.getClass().getCanonicalName());
                                        sb.append(": ");
                                        sb.append(cause2.getMessage());
                                        sb.append(property);
                                    }
                                } else {
                                    identityHashMap.put(cause, Boolean.TRUE);
                                    cause = cause.getCause();
                                    i2++;
                                }
                            }
                        }
                    }
                    this.c = new a(sb.toString().trim());
                } else {
                    this.c = (Throwable) this.a.get(0);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        c(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        c(new d(printWriter));
    }

    public CompositeException(Iterable iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                Throwable th = (Throwable) it.next();
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.a = listUnmodifiableList;
            this.b = listUnmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
