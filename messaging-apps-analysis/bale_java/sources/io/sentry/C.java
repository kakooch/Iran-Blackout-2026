package io.sentry;

import io.sentry.util.m;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class C extends AbstractC3197u implements Q {
    private final Z e;
    private final InterfaceC3107e0 f;
    private final ILogger g;

    public C(Z z, InterfaceC3107e0 interfaceC3107e0, ILogger iLogger, long j, int i) {
        super(z, iLogger, j, i);
        this.e = (Z) io.sentry.util.u.c(z, "Scopes are required.");
        this.f = (InterfaceC3107e0) io.sentry.util.u.c(interfaceC3107e0, "Serializer is required.");
        this.g = (ILogger) io.sentry.util.u.c(iLogger, "Logger is required.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(io.sentry.hints.i iVar) {
        if (iVar.g()) {
            return;
        }
        this.g.c(Y2.WARNING, "Timed out waiting for envelope submission.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Throwable th, File file, io.sentry.hints.k kVar) {
        kVar.d(false);
        this.g.a(Y2.INFO, th, "File '%s' won't retry.", file.getAbsolutePath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(File file, io.sentry.hints.k kVar) {
        if (kVar.a()) {
            this.g.c(Y2.INFO, "File not deleted since retry was marked. %s.", file.getAbsolutePath());
        } else {
            m(file, "after trying to capture it");
            this.g.c(Y2.DEBUG, "Deleted file %s.", file.getAbsolutePath());
        }
    }

    private void m(File file, String str) {
        try {
            if (file.delete()) {
                return;
            }
            this.g.c(Y2.ERROR, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        } catch (Throwable th) {
            this.g.a(Y2.ERROR, th, "Failed to delete '%s' %s", file.getAbsolutePath(), str);
        }
    }

    @Override // io.sentry.Q
    public void a(String str, I i) {
        io.sentry.util.u.c(str, "Path is required.");
        f(new File(str), i);
    }

    @Override // io.sentry.AbstractC3197u
    protected boolean c(String str) {
        return str.endsWith(".envelope");
    }

    @Override // io.sentry.AbstractC3197u
    public /* bridge */ /* synthetic */ void e(File file) {
        super.e(file);
    }

    @Override // io.sentry.AbstractC3197u
    protected void f(final File file, I i) {
        ILogger iLogger;
        m.a aVar;
        if (!file.isFile()) {
            this.g.c(Y2.DEBUG, "'%s' is not a file.", file.getAbsolutePath());
            return;
        }
        if (!c(file.getName())) {
            this.g.c(Y2.DEBUG, "File '%s' doesn't match extension expected.", file.getAbsolutePath());
            return;
        }
        try {
            if (!file.getParentFile().canWrite()) {
                this.g.c(Y2.WARNING, "File '%s' cannot be deleted so it will not be processed.", file.getAbsolutePath());
                return;
            }
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        C3134j2 c3134j2D = this.f.d(bufferedInputStream);
                        if (c3134j2D == null) {
                            this.g.c(Y2.ERROR, "Failed to deserialize cached envelope %s", file.getAbsolutePath());
                        } else {
                            this.e.x(c3134j2D, i);
                        }
                        io.sentry.util.m.q(i, io.sentry.hints.i.class, this.g, new m.a() { // from class: io.sentry.z
                            @Override // io.sentry.util.m.a
                            public final void accept(Object obj) {
                                this.a.j((io.sentry.hints.i) obj);
                            }
                        });
                        bufferedInputStream.close();
                        iLogger = this.g;
                        aVar = new m.a() { // from class: io.sentry.A
                            @Override // io.sentry.util.m.a
                            public final void accept(Object obj) {
                                this.a.l(file, (io.sentry.hints.k) obj);
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
                } catch (FileNotFoundException e) {
                    this.g.a(Y2.ERROR, e, "File '%s' cannot be found.", file.getAbsolutePath());
                    iLogger = this.g;
                    aVar = new m.a() { // from class: io.sentry.A
                        @Override // io.sentry.util.m.a
                        public final void accept(Object obj) {
                            this.a.l(file, (io.sentry.hints.k) obj);
                        }
                    };
                }
            } catch (IOException e2) {
                this.g.a(Y2.ERROR, e2, "I/O on file '%s' failed.", file.getAbsolutePath());
                iLogger = this.g;
                aVar = new m.a() { // from class: io.sentry.A
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.a.l(file, (io.sentry.hints.k) obj);
                    }
                };
            } catch (Throwable th3) {
                this.g.a(Y2.ERROR, th3, "Failed to capture cached envelope %s", file.getAbsolutePath());
                io.sentry.util.m.q(i, io.sentry.hints.k.class, this.g, new m.a() { // from class: io.sentry.B
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.a.k(th3, file, (io.sentry.hints.k) obj);
                    }
                });
                iLogger = this.g;
                aVar = new m.a() { // from class: io.sentry.A
                    @Override // io.sentry.util.m.a
                    public final void accept(Object obj) {
                        this.a.l(file, (io.sentry.hints.k) obj);
                    }
                };
            }
            io.sentry.util.m.q(i, io.sentry.hints.k.class, iLogger, aVar);
        } catch (Throwable th4) {
            io.sentry.util.m.q(i, io.sentry.hints.k.class, this.g, new m.a() { // from class: io.sentry.A
                @Override // io.sentry.util.m.a
                public final void accept(Object obj) {
                    this.a.l(file, (io.sentry.hints.k) obj);
                }
            });
            throw th4;
        }
    }
}
