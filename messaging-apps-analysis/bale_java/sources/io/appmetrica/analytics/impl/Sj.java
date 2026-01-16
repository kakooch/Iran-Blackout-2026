package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.RealConnection;

/* loaded from: classes3.dex */
public final class Sj {
    public final C2484d5 a;
    public final Rj b;
    public final C2459c5 c;
    public final G9 d;
    public final AbstractC2551g e;
    public final AbstractC2551g f;
    public Ej g;
    public int h = 0;

    public Sj(C2484d5 c2484d5, Rj rj, C2459c5 c2459c5, C2439ba c2439ba, G2 g2, G9 g9) {
        this.a = c2484d5;
        this.c = c2459c5;
        this.e = c2439ba;
        this.f = g2;
        this.b = rj;
        this.d = g9;
    }

    public final synchronized long a() {
        Ej ej;
        ej = this.g;
        return ej == null ? RealConnection.IDLE_CONNECTION_HEALTHY_NS : ej.d - 1;
    }

    public final synchronized Ej b(Q5 q5) {
        try {
            if (this.h == 0) {
                Ej ejB = this.e.b();
                if (ejB != null) {
                    if (ejB.a(q5.i)) {
                        this.g = ejB;
                        this.h = 3;
                    } else {
                        a(ejB, q5);
                    }
                }
                Ej ejB2 = this.f.b();
                if (ejB2 != null) {
                    if (ejB2.a(q5.i)) {
                        this.g = ejB2;
                        this.h = 2;
                    } else {
                        a(ejB2, q5);
                    }
                }
                this.g = null;
                this.h = 1;
            }
            if (this.h != 1) {
                Ej ej = this.g;
                if (ej != null) {
                    if (!ej.a(q5.i)) {
                        a(ej, q5);
                    }
                }
                this.h = 1;
                this.g = null;
            }
            int iA = F7.a(this.h);
            if (iA == 1) {
                Ej ej2 = this.g;
                long j = q5.i;
                ej2.i = j;
                Vj vj = ej2.b;
                vj.a(Vj.d, Long.valueOf(j));
                vj.b();
                return this.g;
            }
            if (iA == 2) {
                return this.g;
            }
            this.a.n.info("Start background session", new Object[0]);
            this.h = 2;
            long j2 = q5.i;
            AbstractC2551g abstractC2551g = this.f;
            Fj fj = new Fj(j2, q5.j);
            abstractC2551g.getClass();
            Ej ejA = abstractC2551g.a(fj);
            if (this.a.v.c()) {
                C2459c5 c2459c5 = this.c;
                c2459c5.a.o.a(Q5.a(q5, this.d), a(ejA, q5.i));
            } else {
                int i = q5.d;
                Ta ta = Ta.EVENT_TYPE_UNDEFINED;
                if (i == 6145) {
                    C2459c5 c2459c52 = this.c;
                    c2459c52.a.o.a(q5, a(ejA, j2));
                    C2459c5 c2459c53 = this.c;
                    c2459c53.a.o.a(Q5.a(q5, this.d), a(ejA, j2));
                }
            }
            this.g = ejA;
            return ejA;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(Q5 q5) {
        try {
            if (this.h == 0) {
                Ej ejB = this.e.b();
                if (ejB != null) {
                    if (ejB.a(q5.i)) {
                        this.g = ejB;
                        this.h = 3;
                    } else {
                        a(ejB, q5);
                    }
                }
                Ej ejB2 = this.f.b();
                if (ejB2 != null) {
                    if (ejB2.a(q5.i)) {
                        this.g = ejB2;
                        this.h = 2;
                    } else {
                        a(ejB2, q5);
                    }
                }
                this.g = null;
                this.h = 1;
            }
            int iA = F7.a(this.h);
            if (iA == 0) {
                this.g = a(q5);
            } else if (iA == 1) {
                a(this.g, q5);
                this.g = a(q5);
            } else if (iA == 2) {
                Ej ej = this.g;
                if (ej != null) {
                    if (ej.a(q5.i)) {
                        Ej ej2 = this.g;
                        long j = q5.i;
                        ej2.i = j;
                        Vj vj = ej2.b;
                        vj.a(Vj.d, Long.valueOf(j));
                        vj.b();
                    } else {
                        a(ej, q5);
                    }
                }
                this.g = a(q5);
            }
        } finally {
        }
    }

    public final Ej a(Q5 q5) {
        this.a.n.info("Start foreground session", new Object[0]);
        long j = q5.i;
        AbstractC2551g abstractC2551g = this.e;
        Fj fj = new Fj(j, q5.j);
        abstractC2551g.getClass();
        Ej ejA = abstractC2551g.a(fj);
        this.h = 3;
        this.a.q.b();
        C2459c5 c2459c5 = this.c;
        c2459c5.a.o.a(Q5.a(q5, this.d), a(ejA, j));
        return ejA;
    }

    public final void a(Ej ej, Q5 q5) {
        if (ej.g && ej.d > 0) {
            C2459c5 c2459c5 = this.c;
            Q5 q5A = Q5.a(q5, Ta.EVENT_TYPE_ALIVE);
            Uj uj = new Uj();
            uj.a = ej.d;
            uj.d = ej.c.a;
            long andIncrement = ej.f.getAndIncrement();
            Vj vj = ej.b;
            vj.a(Vj.g, Long.valueOf(ej.f.get()));
            vj.b();
            uj.b = andIncrement;
            uj.c = TimeUnit.MILLISECONDS.toSeconds(Math.max(ej.i - ej.e, ej.j));
            c2459c5.a.o.a(q5A, uj);
            if (ej.g) {
                ej.g = false;
                Vj vj2 = ej.b;
                vj2.a(Vj.i, Boolean.FALSE);
                vj2.b();
            }
        }
        PublicLogger publicLogger = this.a.n;
        int iOrdinal = ej.c.a.ordinal();
        if (iOrdinal == 0) {
            publicLogger.info("Finish foreground session", new Object[0]);
        } else if (iOrdinal == 1) {
            publicLogger.info("Finish background session", new Object[0]);
        }
        synchronized (ej) {
            Vj vj3 = ej.b;
            vj3.getClass();
            vj3.c = new Xa();
            vj3.b();
            ej.h = null;
        }
    }

    public static Uj a(Ej ej, long j) {
        Uj uj = new Uj();
        uj.a = ej.d;
        long andIncrement = ej.f.getAndIncrement();
        Vj vj = ej.b;
        vj.a(Vj.g, Long.valueOf(ej.f.get()));
        vj.b();
        uj.b = andIncrement;
        Vj vj2 = ej.b;
        long j2 = j - ej.e;
        ej.j = j2;
        vj2.a(Vj.e, Long.valueOf(j2));
        uj.c = TimeUnit.MILLISECONDS.toSeconds(ej.j);
        uj.d = ej.c.a;
        return uj;
    }
}
