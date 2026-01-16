package io.sentry.android.replay.capture;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import io.sentry.C3106e;
import io.sentry.C3155n3;
import io.sentry.C3160o3;
import io.sentry.C3222x1;
import io.sentry.D1;
import io.sentry.I;
import io.sentry.X;
import io.sentry.Z;
import io.sentry.android.replay.capture.h;
import io.sentry.android.replay.u;
import io.sentry.protocol.v;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12889fL5;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.UA2;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface h {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        /* renamed from: io.sentry.android.replay.capture.h$a$a, reason: collision with other inner class name */
        static final class C0239a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ Date e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0239a(Date date, List list) {
                super(1);
                this.e = date;
                this.f = list;
            }

            public final void a(io.sentry.rrweb.b bVar) {
                AbstractC13042fc3.i(bVar, "event");
                if (bVar.e() >= this.e.getTime()) {
                    this.f.add(bVar);
                }
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((io.sentry.rrweb.b) obj);
                return C19938rB7.a;
            }
        }

        public static final class b implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AbstractC18050o01.d(Long.valueOf(((io.sentry.rrweb.b) obj).e()), Long.valueOf(((io.sentry.rrweb.b) obj2).e()));
            }
        }

        private a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x012a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final io.sentry.android.replay.capture.h.c b(io.sentry.C3155n3 r19, java.io.File r20, io.sentry.protocol.v r21, java.util.Date r22, int r23, int r24, int r25, int r26, int r27, long r28, io.sentry.C3160o3.b r30, java.lang.String r31, java.util.List r32, java.util.Deque r33) {
            /*
                Method dump skipped, instructions count: 403
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.capture.h.a.b(io.sentry.n3, java.io.File, io.sentry.protocol.v, java.util.Date, int, int, int, int, int, long, io.sentry.o3$b, java.lang.String, java.util.List, java.util.Deque):io.sentry.android.replay.capture.h$c");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(C12889fL5 c12889fL5, X x) {
            AbstractC13042fc3.i(c12889fL5, "$crumbs");
            AbstractC13042fc3.i(x, "scope");
            c12889fL5.a = new ArrayList(x.n());
        }

        private final boolean e(C3106e c3106e) {
            if (c3106e != null && AbstractC13042fc3.d(c3106e.r(), "network.event")) {
                Map mapS = c3106e.s();
                AbstractC13042fc3.h(mapS, "data");
                Object obj = mapS.get("action");
                if (obj == null) {
                    obj = null;
                }
                if (AbstractC13042fc3.d(obj, "NETWORK_AVAILABLE")) {
                    return true;
                }
            }
            return false;
        }

        private final boolean f(C3106e c3106e) {
            return AbstractC13042fc3.d(c3106e.r(), "network.event") && c3106e.s().containsKey("network_type");
        }

        public static /* synthetic */ void h(a aVar, Deque deque, long j, UA2 ua2, int i, Object obj) {
            if ((i & 4) != 0) {
                ua2 = null;
            }
            aVar.g(deque, j, ua2);
        }

        public final c c(Z z, C3155n3 c3155n3, long j, Date date, v vVar, int i, int i2, int i3, C3160o3.b bVar, io.sentry.android.replay.h hVar, int i4, int i5, String str, List list, Deque deque) {
            io.sentry.android.replay.b bVarK;
            List list2;
            AbstractC13042fc3.i(c3155n3, "options");
            AbstractC13042fc3.i(date, "currentSegmentTimestamp");
            AbstractC13042fc3.i(vVar, "replayId");
            AbstractC13042fc3.i(bVar, "replayType");
            AbstractC13042fc3.i(deque, "events");
            if (hVar == null || (bVarK = io.sentry.android.replay.h.k(hVar, Math.min(j, 300000L), date.getTime(), i, i2, i3, i4, i5, null, 128, null)) == null) {
                return c.b.a;
            }
            File fileA = bVarK.a();
            int iB = bVarK.b();
            long jC = bVarK.c();
            if (list == null) {
                final C12889fL5 c12889fL5 = new C12889fL5();
                c12889fL5.a = AbstractC10360bX0.m();
                if (z != null) {
                    z.z(new D1() { // from class: io.sentry.android.replay.capture.g
                        @Override // io.sentry.D1
                        public final void a(X x) {
                            h.a.d(c12889fL5, x);
                        }
                    });
                }
                list2 = (List) c12889fL5.a;
            } else {
                list2 = list;
            }
            return b(c3155n3, fileA, vVar, date, i, i2, i3, iB, i4, jC, bVar, str, list2, deque);
        }

        public final void g(Deque deque, long j, UA2 ua2) {
            AbstractC13042fc3.i(deque, "events");
            Iterator it = deque.iterator();
            AbstractC13042fc3.h(it, "events.iterator()");
            while (it.hasNext()) {
                io.sentry.rrweb.b bVar = (io.sentry.rrweb.b) it.next();
                if (bVar.e() < j) {
                    if (ua2 != null) {
                        AbstractC13042fc3.h(bVar, "event");
                        ua2.invoke(bVar);
                    }
                    it.remove();
                }
            }
        }
    }

    public static final class b {
        public static /* synthetic */ void a(h hVar, int i, v vVar, C3160o3.b bVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: start");
            }
            if ((i2 & 1) != 0) {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                vVar = new v();
            }
            if ((i2 & 4) != 0) {
                bVar = null;
            }
            hVar.i(i, vVar, bVar);
        }
    }

    public static abstract class c {

        public static final class a extends c {
            private final C3160o3 a;
            private final C3222x1 b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C3160o3 c3160o3, C3222x1 c3222x1) {
                super(null);
                AbstractC13042fc3.i(c3160o3, "replay");
                AbstractC13042fc3.i(c3222x1, "recording");
                this.a = c3160o3;
                this.b = c3222x1;
            }

            public static /* synthetic */ void b(a aVar, Z z, I i, int i2, Object obj) {
                if ((i2 & 2) != 0) {
                    i = new I();
                }
                aVar.a(z, i);
            }

            public final void a(Z z, I i) {
                AbstractC13042fc3.i(i, "hint");
                if (z != null) {
                    C3160o3 c3160o3 = this.a;
                    i.l(this.b);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                    z.C(c3160o3, i);
                }
            }

            public final C3160o3 c() {
                return this.a;
            }

            public final void d(int i) {
                this.a.n0(i);
                List<io.sentry.rrweb.b> listA = this.b.a();
                if (listA != null) {
                    for (io.sentry.rrweb.b bVar : listA) {
                        if (bVar instanceof io.sentry.rrweb.j) {
                            ((io.sentry.rrweb.j) bVar).C(i);
                        }
                    }
                }
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return AbstractC13042fc3.d(this.a, aVar.a) && AbstractC13042fc3.d(this.b, aVar.b);
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.b.hashCode();
            }

            public String toString() {
                return "Created(replay=" + this.a + ", recording=" + this.b + ')';
            }
        }

        public static final class b extends c {
            public static final b a = new b();

            private b() {
                super(null);
            }
        }

        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    void a(MotionEvent motionEvent);

    void b(Bitmap bitmap, InterfaceC14603iB2 interfaceC14603iB2);

    v c();

    void d(int i);

    int e();

    void f(boolean z, UA2 ua2);

    h g();

    void h();

    void i(int i, v vVar, C3160o3.b bVar);

    void j(Date date);

    void stop();

    void v();

    void x(u uVar);
}
