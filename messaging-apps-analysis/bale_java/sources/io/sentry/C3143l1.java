package io.sentry;

import android.gov.nist.javax.sip.header.ParameterNames;
import io.sentry.util.AbstractC3204c;
import io.sentry.util.m;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/* renamed from: io.sentry.l1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3143l1 extends AbstractC3197u implements Q {
    private static final Charset i = Charset.forName("UTF-8");
    private final Z e;
    private final P f;
    private final InterfaceC3107e0 g;
    private final ILogger h;

    public C3143l1(Z z, P p, InterfaceC3107e0 interfaceC3107e0, ILogger iLogger, long j, int i2) {
        super(z, iLogger, j, i2);
        this.e = (Z) io.sentry.util.u.c(z, "Scopes are required.");
        this.f = (P) io.sentry.util.u.c(p, "Envelope reader is required.");
        this.g = (InterfaceC3107e0) io.sentry.util.u.c(interfaceC3107e0, "Serializer is required.");
        this.h = (ILogger) io.sentry.util.u.c(iLogger, "Logger is required.");
    }

    private V3 i(T3 t3) {
        String strB;
        if (t3 != null && (strB = t3.b()) != null) {
            try {
                Double dValueOf = Double.valueOf(Double.parseDouble(strB));
                if (io.sentry.util.y.h(dValueOf, false)) {
                    String strA = t3.a();
                    if (strA != null) {
                        Double dValueOf2 = Double.valueOf(Double.parseDouble(strA));
                        if (io.sentry.util.y.h(dValueOf2, false)) {
                            return new V3(Boolean.TRUE, dValueOf, dValueOf2);
                        }
                    }
                    return io.sentry.util.y.a(new V3(Boolean.TRUE, dValueOf));
                }
                this.h.c(Y2.ERROR, "Invalid sample rate parsed from TraceContext: %s", strB);
            } catch (Exception unused) {
                this.h.c(Y2.ERROR, "Unable to parse sample rate from TraceContext: %s", strB);
            }
        }
        return new V3(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(File file, io.sentry.hints.k kVar) {
        if (kVar.a()) {
            return;
        }
        try {
            if (file.delete()) {
                return;
            }
            this.h.c(Y2.ERROR, "Failed to delete: %s", file.getAbsolutePath());
        } catch (RuntimeException e) {
            this.h.a(Y2.ERROR, e, "Failed to delete: %s", file.getAbsolutePath());
        }
    }

    private void l(J2 j2, int i2) {
        this.h.c(Y2.ERROR, "Item %d of type %s returned null by the parser.", Integer.valueOf(i2), j2.J().b());
    }

    private void m(int i2) {
        this.h.c(Y2.DEBUG, "Item %d is being captured.", Integer.valueOf(i2));
    }

    private void n(io.sentry.protocol.v vVar) {
        this.h.c(Y2.WARNING, "Timed out waiting for event id submission: %s", vVar);
    }

    private void o(C3134j2 c3134j2, io.sentry.protocol.v vVar, int i2) {
        this.h.c(Y2.ERROR, "Item %d of has a different event id (%s) to the envelope header (%s)", Integer.valueOf(i2), c3134j2.b().a(), vVar);
    }

    private void p(C3134j2 c3134j2, I i2) {
        BufferedReader bufferedReader;
        Object objG;
        this.h.c(Y2.DEBUG, "Processing Envelope with %d item(s)", Integer.valueOf(AbstractC3204c.e(c3134j2.c())));
        int i3 = 0;
        for (J2 j2 : c3134j2.c()) {
            i3++;
            if (j2.J() == null) {
                this.h.c(Y2.ERROR, "Item %d has no header", Integer.valueOf(i3));
            } else if (X2.Event.equals(j2.J().b())) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(j2.I()), i));
                } catch (Throwable th) {
                    this.h.b(Y2.ERROR, "Item failed to process.", th);
                }
                try {
                    L2 l2 = (L2) this.g.c(bufferedReader, L2.class);
                    if (l2 == null) {
                        l(j2, i3);
                    } else {
                        if (l2.L() != null) {
                            io.sentry.util.m.s(i2, l2.L().e());
                        }
                        if (c3134j2.b().a() == null || c3134j2.b().a().equals(l2.G())) {
                            this.e.I(l2, i2);
                            m(i3);
                            if (!q(i2)) {
                                n(l2.G());
                                bufferedReader.close();
                                return;
                            }
                        } else {
                            o(c3134j2, l2.G(), i3);
                            bufferedReader.close();
                        }
                    }
                    bufferedReader.close();
                    objG = io.sentry.util.m.g(i2);
                    if (!(objG instanceof io.sentry.hints.p) && !((io.sentry.hints.p) objG).e()) {
                        this.h.c(Y2.WARNING, "Envelope had a failed capture at item %d. No more items will be sent.", Integer.valueOf(i3));
                        return;
                    }
                    io.sentry.util.m.o(i2, io.sentry.hints.j.class, new m.a() { // from class: io.sentry.k1
                        @Override // io.sentry.util.m.a
                        public final void accept(Object obj) {
                            ((io.sentry.hints.j) obj).reset();
                        }
                    });
                } finally {
                }
            } else {
                if (X2.Transaction.equals(j2.J().b())) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(j2.I()), i));
                        try {
                            io.sentry.protocol.C c = (io.sentry.protocol.C) this.g.c(bufferedReader, io.sentry.protocol.C.class);
                            if (c == null) {
                                l(j2, i3);
                            } else if (c3134j2.b().a() == null || c3134j2.b().a().equals(c.G())) {
                                T3 t3C = c3134j2.b().c();
                                if (c.C().i() != null) {
                                    c.C().i().s(i(t3C));
                                }
                                this.e.y(c, t3C, i2);
                                m(i3);
                                if (!q(i2)) {
                                    n(c.G());
                                    bufferedReader.close();
                                    return;
                                }
                            } else {
                                o(c3134j2, c.G(), i3);
                                bufferedReader.close();
                            }
                            bufferedReader.close();
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.h.b(Y2.ERROR, "Item failed to process.", th2);
                    }
                } else {
                    this.e.x(new C3134j2(c3134j2.b().a(), c3134j2.b().b(), j2), i2);
                    this.h.c(Y2.DEBUG, "%s item %d is being captured.", j2.J().b().getItemType(), Integer.valueOf(i3));
                    if (!q(i2)) {
                        this.h.c(Y2.WARNING, "Timed out waiting for item type submission: %s", j2.J().b().getItemType());
                        return;
                    }
                }
                objG = io.sentry.util.m.g(i2);
                if (!(objG instanceof io.sentry.hints.p)) {
                }
                io.sentry.util.m.o(i2, io.sentry.hints.j.class, new m.a() { // from class: io.sentry.k1
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        ((io.sentry.hints.j) obj).reset();
                    }
                });
            }
        }
    }

    private boolean q(I i2) {
        Object objG = io.sentry.util.m.g(i2);
        if (objG instanceof io.sentry.hints.i) {
            return ((io.sentry.hints.i) objG).g();
        }
        io.sentry.util.s.a(io.sentry.hints.i.class, objG, this.h);
        return true;
    }

    @Override // io.sentry.Q
    public void a(String str, I i2) {
        io.sentry.util.u.c(str, "Path is required.");
        f(new File(str), i2);
    }

    @Override // io.sentry.AbstractC3197u
    protected boolean c(String str) {
        return (str == null || str.startsWith(ParameterNames.SESSION) || str.startsWith("previous_session") || str.startsWith("startup_crash")) ? false : true;
    }

    @Override // io.sentry.AbstractC3197u
    public /* bridge */ /* synthetic */ void e(File file) {
        super.e(file);
    }

    @Override // io.sentry.AbstractC3197u
    protected void f(final File file, I i2) {
        ILogger iLogger;
        m.a aVar;
        io.sentry.util.u.c(file, "File is required.");
        try {
            if (!c(file.getName())) {
                this.h.c(Y2.DEBUG, "File '%s' should be ignored.", file.getAbsolutePath());
                return;
            }
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    C3134j2 c3134j2A = this.f.a(bufferedInputStream);
                    if (c3134j2A == null) {
                        this.h.c(Y2.ERROR, "Stream from path %s resulted in a null envelope.", file.getAbsolutePath());
                    } else {
                        p(c3134j2A, i2);
                        this.h.c(Y2.DEBUG, "File '%s' is done.", file.getAbsolutePath());
                    }
                    bufferedInputStream.close();
                    iLogger = this.h;
                    aVar = new m.a() { // from class: io.sentry.j1
                        @Override // io.sentry.util.m.a
                        public final void accept(Object obj) {
                            this.a.k(file, (io.sentry.hints.k) obj);
                        }
                    };
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                this.h.b(Y2.ERROR, "Error processing envelope.", e);
                iLogger = this.h;
                aVar = new m.a() { // from class: io.sentry.j1
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.a.k(file, (io.sentry.hints.k) obj);
                    }
                };
            }
            io.sentry.util.m.q(i2, io.sentry.hints.k.class, iLogger, aVar);
        } catch (Throwable th3) {
            io.sentry.util.m.q(i2, io.sentry.hints.k.class, this.h, new m.a() { // from class: io.sentry.j1
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.a.k(file, (io.sentry.hints.k) obj);
                }
            });
            throw th3;
        }
    }
}
