package com.bumptech.glide.load.engine;

import android.gov.nist.core.Separators;
import android.util.Log;
import ir.nasim.EnumC21012sz1;
import ir.nasim.InterfaceC14373ho3;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] g = new StackTraceElement[0];
    private final List a;
    private InterfaceC14373ho3 b;
    private EnumC21012sz1 c;
    private Class d;
    private String e;
    private Exception f;

    public GlideException(String str) {
        this(str, Collections.emptyList());
    }

    private void a(Throwable th, List list) {
        if (!(th instanceof GlideException)) {
            list.add(th);
            return;
        }
        Iterator it = ((GlideException) th).e().iterator();
        while (it.hasNext()) {
            a((Throwable) it.next(), list);
        }
    }

    private static void b(List list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void c(List list, Appendable appendable) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof GlideException) {
                ((GlideException) th).j(appendable);
            } else {
                d(th, appendable);
            }
            i = i2;
        }
    }

    private static void d(Throwable th, Appendable appendable) throws IOException {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void j(Appendable appendable) throws IOException {
        d(this, appendable);
        b(e(), new a(appendable));
    }

    public List e() {
        return this.a;
    }

    public List f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public void g(String str) {
        List listF = f();
        int size = listF.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(Separators.RPAREN);
            Log.i(str, sb.toString(), (Throwable) listF.get(i));
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.e);
        sb.append(this.d != null ? ", " + this.d : "");
        sb.append(this.c != null ? ", " + this.c : "");
        sb.append(this.b != null ? ", " + this.b : "");
        List<Throwable> listF = f();
        if (listF.isEmpty()) {
            return sb.toString();
        }
        if (listF.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listF.size());
            sb.append(" root causes:");
        }
        for (Throwable th : listF) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    void k(InterfaceC14373ho3 interfaceC14373ho3, EnumC21012sz1 enumC21012sz1) {
        l(interfaceC14373ho3, enumC21012sz1, null);
    }

    void l(InterfaceC14373ho3 interfaceC14373ho3, EnumC21012sz1 enumC21012sz1, Class cls) {
        this.b = interfaceC14373ho3;
        this.c = enumC21012sz1;
        this.d = cls;
    }

    public void m(Exception exc) {
        this.f = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() throws IOException {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) throws IOException {
        j(printStream);
    }

    public GlideException(String str, List list) {
        this.e = str;
        setStackTrace(g);
        this.a = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) throws IOException {
        j(printWriter);
    }

    private static final class a implements Appendable {
        private final Appendable a;
        private boolean b = true;

        a(Appendable appendable) {
            this.a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) throws IOException {
            if (this.b) {
                this.b = false;
                this.a.append("  ");
            }
            this.b = c == '\n';
            this.a.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z = false;
            if (this.b) {
                this.b = false;
                this.a.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.b = z;
            this.a.append(charSequenceA, i, i2);
            return this;
        }
    }
}
