package io.sentry.cache;

import io.sentry.C3106e;
import io.sentry.C3155n3;
import io.sentry.E1;
import io.sentry.H3;
import io.sentry.X;
import io.sentry.Y2;
import io.sentry.cache.tape.c;
import io.sentry.cache.tape.d;
import io.sentry.protocol.C3168c;
import io.sentry.protocol.v;
import io.sentry.util.q;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class q extends E1 {
    private static final Charset c = Charset.forName("UTF-8");
    private C3155n3 a;
    private final io.sentry.util.q b = new io.sentry.util.q(new q.a() { // from class: io.sentry.cache.i
        @Override // io.sentry.util.q.a
        public final Object a() {
            return this.a.s();
        }
    });

    class a implements c.a {
        a() {
        }

        @Override // io.sentry.cache.tape.c.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C3106e b(byte[] bArr) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr), q.c));
                try {
                    C3106e c3106e = (C3106e) q.this.a.getSerializer().c(bufferedReader, C3106e.class);
                    bufferedReader.close();
                    return c3106e;
                } finally {
                }
            } catch (Throwable th) {
                q.this.a.getLogger().a(Y2.ERROR, th, "Error reading entity from scope cache", new Object[0]);
                return null;
            }
        }

        @Override // io.sentry.cache.tape.c.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(C3106e c3106e, OutputStream outputStream) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, q.c));
            try {
                q.this.a.getSerializer().a(c3106e, bufferedWriter);
                bufferedWriter.close();
            } catch (Throwable th) {
                try {
                    bufferedWriter.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public q(C3155n3 c3155n3) {
        this.a = c3155n3;
    }

    private void B(final Runnable runnable) {
        if (this.a.isEnableScopePersistence()) {
            if (Thread.currentThread().getName().contains("SentryExecutor")) {
                try {
                    runnable.run();
                    return;
                } catch (Throwable th) {
                    this.a.getLogger().b(Y2.ERROR, "Serialization task failed", th);
                    return;
                }
            }
            try {
                this.a.getExecutorService().submit(new Runnable() { // from class: io.sentry.cache.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.t(runnable);
                    }
                });
            } catch (Throwable th2) {
                this.a.getLogger().b(Y2.ERROR, "Serialization task could not be scheduled", th2);
            }
        }
    }

    public static void C(C3155n3 c3155n3, Object obj, String str) {
        d.d(c3155n3, obj, ".scope-cache", str);
    }

    private void D(Object obj, String str) {
        C(this.a, obj, str);
    }

    private void q(String str) {
        d.a(this.a, ".scope-cache", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(C3106e c3106e) {
        try {
            ((io.sentry.cache.tape.c) this.b.a()).j(c3106e);
        } catch (IOException e) {
            this.a.getLogger().b(Y2.ERROR, "Failed to add breadcrumb to file queue", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ io.sentry.cache.tape.c s() {
        io.sentry.cache.tape.d dVarA;
        File fileB = d.b(this.a, ".scope-cache");
        if (fileB == null) {
            this.a.getLogger().c(Y2.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return io.sentry.cache.tape.c.Z();
        }
        File file = new File(fileB, "breadcrumbs.json");
        try {
            try {
                dVarA = new d.a(file).b(this.a.getMaxBreadcrumbs()).a();
            } catch (IOException e) {
                this.a.getLogger().b(Y2.ERROR, "Failed to create breadcrumbs queue", e);
                return io.sentry.cache.tape.c.Z();
            }
        } catch (IOException unused) {
            file.delete();
            dVarA = new d.a(file).b(this.a.getMaxBreadcrumbs()).a();
        }
        return io.sentry.cache.tape.c.S(dVarA, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.a.getLogger().b(Y2.ERROR, "Serialization task failed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        try {
            ((io.sentry.cache.tape.c) this.b.a()).clear();
        } catch (IOException e) {
            this.a.getLogger().b(Y2.ERROR, "Failed to clear breadcrumbs from file queue", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(C3168c c3168c) {
        D(c3168c, "contexts.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(v vVar) {
        D(vVar, "replay.json");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(H3 h3, X x) {
        if (h3 == null) {
            D(x.z().g(), "trace.json");
        } else {
            D(h3, "trace.json");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str) {
        if (str == null) {
            q("transaction.json");
        } else {
            D(str, "transaction.json");
        }
    }

    public void A() {
        try {
            ((io.sentry.cache.tape.c) this.b.a()).clear();
        } catch (IOException e) {
            this.a.getLogger().b(Y2.ERROR, "Failed to clear breadcrumbs from file queue", e);
        }
        q("user.json");
        q("level.json");
        q("request.json");
        q("fingerprint.json");
        q("contexts.json");
        q("extras.json");
        q("tags.json");
        q("trace.json");
        q("transaction.json");
    }

    @Override // io.sentry.Y
    public void a(final C3106e c3106e) {
        B(new Runnable() { // from class: io.sentry.cache.j
            @Override // java.lang.Runnable
            public final void run() {
                this.a.r(c3106e);
            }
        });
    }

    @Override // io.sentry.E1, io.sentry.Y
    public void b(Collection collection) {
        if (collection.isEmpty()) {
            B(new Runnable() { // from class: io.sentry.cache.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.u();
                }
            });
        }
    }

    @Override // io.sentry.Y
    public void c(final H3 h3, final X x) {
        B(new Runnable() { // from class: io.sentry.cache.p
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x(h3, x);
            }
        });
    }

    @Override // io.sentry.E1, io.sentry.Y
    public void d(final C3168c c3168c) {
        B(new Runnable() { // from class: io.sentry.cache.o
            @Override // java.lang.Runnable
            public final void run() {
                this.a.v(c3168c);
            }
        });
    }

    @Override // io.sentry.E1, io.sentry.Y
    public void e(final String str) {
        B(new Runnable() { // from class: io.sentry.cache.m
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y(str);
            }
        });
    }

    @Override // io.sentry.E1, io.sentry.Y
    public void k(final v vVar) {
        B(new Runnable() { // from class: io.sentry.cache.l
            @Override // java.lang.Runnable
            public final void run() {
                this.a.w(vVar);
            }
        });
    }

    public Object z(C3155n3 c3155n3, String str, Class cls) {
        if (!str.equals("breadcrumbs.json")) {
            return d.c(c3155n3, ".scope-cache", str, cls, null);
        }
        try {
            return cls.cast(((io.sentry.cache.tape.c) this.b.a()).P());
        } catch (IOException unused) {
            c3155n3.getLogger().c(Y2.ERROR, "Unable to read serialized breadcrumbs from QueueFile", new Object[0]);
            return null;
        }
    }
}
