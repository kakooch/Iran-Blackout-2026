package io.sentry.android.core;

import io.sentry.AbstractC3124h2;
import io.sentry.AbstractC3141l;
import io.sentry.C3033a1;
import io.sentry.C3098c1;
import io.sentry.C3115f3;
import io.sentry.InterfaceC3102d0;
import io.sentry.InterfaceC3117g0;
import io.sentry.InterfaceC3127i0;
import io.sentry.android.core.internal.util.C;
import io.sentry.util.C3202a;
import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class X0 implements io.sentry.V, C.b {
    private static final long h = TimeUnit.SECONDS.toNanos(1);
    private static final C3115f3 i = new C3115f3(new Date(0), 0);
    private final boolean a;
    private final io.sentry.android.core.internal.util.C c;
    private volatile String d;
    protected final C3202a b = new C3202a();
    private final SortedSet e = new TreeSet(new Comparator() { // from class: io.sentry.android.core.W0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return X0.j((InterfaceC3117g0) obj, (InterfaceC3117g0) obj2);
        }
    });
    private final ConcurrentSkipListSet f = new ConcurrentSkipListSet();
    private long g = 16666666;

    private static class a implements Comparable {
        private final long a;
        private final long b;
        private final long c;
        private final long d;
        private final boolean e;
        private final boolean f;
        private final long g;

        a(long j) {
            this(j, j, 0L, 0L, false, false, 0L);
        }

        @Override // java.lang.Comparable
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Long.compare(this.b, aVar.b);
        }

        a(long j, long j2, long j3, long j4, boolean z, boolean z2, long j5) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = j4;
            this.e = z;
            this.f = z2;
            this.g = j5;
        }
    }

    public X0(SentryAndroidOptions sentryAndroidOptions, io.sentry.android.core.internal.util.C c) {
        this.c = c;
        this.a = sentryAndroidOptions.isEnablePerformanceV2() && sentryAndroidOptions.isEnableFramesTracking();
    }

    private static int g(Q0 q0, long j, long j2, long j3) {
        long jMax = Math.max(0L, j2 - j3);
        if (!io.sentry.android.core.internal.util.C.j(jMax, j)) {
            return 0;
        }
        q0.a(jMax, Math.max(0L, jMax - j), true, io.sentry.android.core.internal.util.C.i(jMax));
        return 1;
    }

    private void h(InterfaceC3117g0 interfaceC3117g0) {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            if (!this.e.remove(interfaceC3117g0)) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            AbstractC3124h2 abstractC3124h2W = interfaceC3117g0.w();
            if (abstractC3124h2W == null) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            long jK = k(interfaceC3117g0.y());
            long jK2 = k(abstractC3124h2W);
            long j = jK2 - jK;
            long j2 = 0;
            if (j <= 0) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            Q0 q0 = new Q0();
            long j3 = this.g;
            if (!this.f.isEmpty()) {
                for (a aVar : this.f.tailSet((ConcurrentSkipListSet) new a(jK))) {
                    if (aVar.a > jK2) {
                        break;
                    }
                    if (aVar.a >= jK && aVar.b <= jK2) {
                        q0.a(aVar.c, aVar.d, aVar.e, aVar.f);
                    } else if ((jK > aVar.a && jK < aVar.b) || (jK2 > aVar.a && jK2 < aVar.b)) {
                        long jMin = Math.min(aVar.d - Math.max(j2, Math.max(j2, jK - aVar.a) - aVar.g), j);
                        long jMin2 = Math.min(jK2, aVar.b) - Math.max(jK, aVar.a);
                        q0.a(jMin2, jMin, io.sentry.android.core.internal.util.C.j(jMin2, aVar.g), io.sentry.android.core.internal.util.C.i(jMin2));
                    }
                    j3 = aVar.g;
                    j2 = 0;
                }
            }
            long j4 = j3;
            int iF = q0.f();
            long jH = this.c.h();
            if (jH != -1) {
                iF = iF + g(q0, j4, jK2, jH) + i(q0, j4, j);
            }
            double dE = (q0.e() + q0.c()) / 1.0E9d;
            interfaceC3117g0.q("frames.total", Integer.valueOf(iF));
            interfaceC3117g0.q("frames.slow", Integer.valueOf(q0.d()));
            interfaceC3117g0.q("frames.frozen", Integer.valueOf(q0.b()));
            interfaceC3117g0.q("frames.delay", Double.valueOf(dE));
            if (interfaceC3117g0 instanceof InterfaceC3127i0) {
                interfaceC3117g0.o("frames_total", Integer.valueOf(iF));
                interfaceC3117g0.o("frames_slow", Integer.valueOf(q0.d()));
                interfaceC3117g0.o("frames_frozen", Integer.valueOf(q0.b()));
                interfaceC3117g0.o("frames_delay", Double.valueOf(dE));
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A == null) {
                throw th;
            }
            try {
                interfaceC3102d0A.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    private static int i(Q0 q0, long j, long j2) {
        long jG = j2 - q0.g();
        if (jG > 0) {
            return (int) Math.ceil(jG / j);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int j(InterfaceC3117g0 interfaceC3117g0, InterfaceC3117g0 interfaceC3117g02) {
        if (interfaceC3117g0 == interfaceC3117g02) {
            return 0;
        }
        int iCompareTo = interfaceC3117g0.y().compareTo(interfaceC3117g02.y());
        return iCompareTo != 0 ? iCompareTo : interfaceC3117g0.v().k().toString().compareTo(interfaceC3117g02.v().k().toString());
    }

    private static long k(AbstractC3124h2 abstractC3124h2) {
        if (abstractC3124h2 instanceof C3115f3) {
            return abstractC3124h2.h(i);
        }
        return System.nanoTime() - (AbstractC3141l.i(System.currentTimeMillis()) - abstractC3124h2.p());
    }

    @Override // io.sentry.V
    public void a(InterfaceC3117g0 interfaceC3117g0) {
        if (!this.a || (interfaceC3117g0 instanceof C3033a1) || (interfaceC3117g0 instanceof C3098c1)) {
            return;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            if (!this.e.contains(interfaceC3117g0)) {
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                    return;
                }
                return;
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
            h(interfaceC3117g0);
            interfaceC3102d0A = this.b.a();
            try {
                if (this.e.isEmpty()) {
                    clear();
                } else {
                    this.f.headSet((ConcurrentSkipListSet) new a(k(((InterfaceC3117g0) this.e.first()).y()))).clear();
                }
                if (interfaceC3102d0A != null) {
                    interfaceC3102d0A.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        } finally {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
        }
    }

    @Override // io.sentry.V
    public void b(InterfaceC3117g0 interfaceC3117g0) {
        if (!this.a || (interfaceC3117g0 instanceof C3033a1) || (interfaceC3117g0 instanceof C3098c1)) {
            return;
        }
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            this.e.add(interfaceC3117g0);
            if (this.d == null) {
                this.d = this.c.q(this);
            }
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.V
    public void clear() {
        InterfaceC3102d0 interfaceC3102d0A = this.b.a();
        try {
            if (this.d != null) {
                this.c.r(this.d);
                this.d = null;
            }
            this.f.clear();
            this.e.clear();
            if (interfaceC3102d0A != null) {
                interfaceC3102d0A.close();
            }
        } catch (Throwable th) {
            if (interfaceC3102d0A != null) {
                try {
                    interfaceC3102d0A.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // io.sentry.android.core.internal.util.C.b
    public void e(long j, long j2, long j3, long j4, boolean z, boolean z2, float f) {
        if (this.f.size() > 3600) {
            return;
        }
        long j5 = (long) (h / f);
        this.g = j5;
        if (z || z2) {
            this.f.add(new a(j, j2, j3, j4, z, z2, j5));
        }
    }
}
