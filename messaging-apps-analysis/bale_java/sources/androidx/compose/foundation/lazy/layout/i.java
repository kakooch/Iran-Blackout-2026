package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.lazy.layout.d;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C12889fL5;
import ir.nasim.C15595jq7;
import ir.nasim.C17833ne1;
import ir.nasim.C19197pw3;
import ir.nasim.C19938rB7;
import ir.nasim.C4272Ek5;
import ir.nasim.ED1;
import ir.nasim.EnumC8411Vv7;
import ir.nasim.InterfaceC20397rw3;
import ir.nasim.InterfaceC4506Fk5;
import ir.nasim.InterfaceC4755Gk5;
import ir.nasim.InterfaceC4989Hk5;
import ir.nasim.InterfaceC8645Wv7;
import ir.nasim.P73;
import ir.nasim.Q12;
import ir.nasim.TZ6;
import ir.nasim.UA2;
import java.util.List;
import kotlin.KotlinNothingValueException;

/* loaded from: classes.dex */
public final class i {
    private final C19197pw3 a;
    private final TZ6 b;
    private final InterfaceC4989Hk5 c;

    private final class a implements d.b, InterfaceC4506Fk5 {
        private final int a;
        private final long b;
        private final C4272Ek5 c;
        private TZ6.a d;
        private boolean e;
        private boolean f;
        private boolean g;
        private C0046a h;
        private boolean i;
        private long j;
        private long k;
        private long l;

        /* renamed from: androidx.compose.foundation.lazy.layout.i$a$a, reason: collision with other inner class name */
        private final class C0046a {
            private final List a;
            private final List[] b;
            private int c;
            private int d;

            public C0046a(List list) {
                this.a = list;
                this.b = new List[list.size()];
                if (!list.isEmpty()) {
                    return;
                }
                P73.a("NestedPrefetchController shouldn't be created with no states");
            }

            public final boolean a(InterfaceC4755Gk5 interfaceC4755Gk5) {
                if (this.c >= this.a.size()) {
                    return false;
                }
                if (!(!a.this.f)) {
                    P73.c("Should not execute nested prefetch on canceled request");
                }
                Trace.beginSection("compose:lazy:prefetch:nested");
                while (this.c < this.a.size()) {
                    try {
                        if (this.b[this.c] == null) {
                            if (interfaceC4755Gk5.a() <= 0) {
                                Trace.endSection();
                                return true;
                            }
                            List[] listArr = this.b;
                            int i = this.c;
                            listArr[i] = ((d) this.a.get(i)).b();
                        }
                        List list = this.b[this.c];
                        AbstractC13042fc3.f(list);
                        while (this.d < list.size()) {
                            if (((InterfaceC4506Fk5) list.get(this.d)).b(interfaceC4755Gk5)) {
                                Trace.endSection();
                                return true;
                            }
                            this.d++;
                        }
                        this.d = 0;
                        this.c++;
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
                Trace.endSection();
                return false;
            }
        }

        static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C12889fL5 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C12889fL5 c12889fL5) {
                super(1);
                this.e = c12889fL5;
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final EnumC8411Vv7 invoke(InterfaceC8645Wv7 interfaceC8645Wv7) {
                AbstractC13042fc3.g(interfaceC8645Wv7, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
                d dVarV2 = ((j) interfaceC8645Wv7).v2();
                C12889fL5 c12889fL5 = this.e;
                List listS = (List) c12889fL5.a;
                if (listS != null) {
                    listS.add(dVarV2);
                } else {
                    listS = AbstractC10360bX0.s(dVarV2);
                }
                c12889fL5.a = listS;
                return EnumC8411Vv7.b;
            }
        }

        public /* synthetic */ a(i iVar, int i, long j, C4272Ek5 c4272Ek5, ED1 ed1) {
            this(i, j, c4272Ek5);
        }

        private final boolean d() {
            return this.d != null;
        }

        private final void e(InterfaceC20397rw3 interfaceC20397rw3, Object obj) {
            if (!(this.d == null)) {
                P73.a("Request was already composed!");
            }
            Object objD = interfaceC20397rw3.d(this.a);
            this.d = i.this.b.i(objD, i.this.a.b(this.a, objD, obj));
        }

        private final void f(long j) {
            if (!(!this.f)) {
                P73.a("Callers should check whether the request is still valid before calling performMeasure()");
            }
            if (!(!this.e)) {
                P73.a("Request was already measured!");
            }
            this.e = true;
            TZ6.a aVar = this.d;
            if (aVar == null) {
                P73.b("performComposition() must be called before performMeasure()");
                throw new KotlinNothingValueException();
            }
            int iE = aVar.e();
            for (int i = 0; i < iE; i++) {
                aVar.b(i, j);
            }
        }

        private final void g(long j) {
            this.j = j;
            this.l = C15595jq7.a.a();
            this.k = 0L;
        }

        private final C0046a h() {
            TZ6.a aVar = this.d;
            if (aVar == null) {
                P73.b("Should precompose before resolving nested prefetch states");
                throw new KotlinNothingValueException();
            }
            C12889fL5 c12889fL5 = new C12889fL5();
            aVar.a("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new b(c12889fL5));
            List list = (List) c12889fL5.a;
            if (list != null) {
                return new C0046a(list);
            }
            return null;
        }

        private final boolean i(long j, long j2) {
            return (this.i && j > 0) || j2 < j;
        }

        private final void j() {
            long jA = C15595jq7.a.a();
            long jC = Q12.C(C15595jq7.a.h(jA, this.l));
            this.k = jC;
            this.j -= jC;
            this.l = jA;
        }

        @Override // androidx.compose.foundation.lazy.layout.d.b
        public void a() {
            this.i = true;
        }

        @Override // ir.nasim.InterfaceC4506Fk5
        public boolean b(InterfaceC4755Gk5 interfaceC4755Gk5) {
            InterfaceC20397rw3 interfaceC20397rw3 = (InterfaceC20397rw3) i.this.a.d().invoke();
            if (!this.f) {
                int iA = interfaceC20397rw3.a();
                int i = this.a;
                if (i >= 0 && i < iA) {
                    Object objF = interfaceC20397rw3.f(i);
                    g(interfaceC4755Gk5.a());
                    if (!d()) {
                        if (!i(this.j, this.c.b(objF))) {
                            return true;
                        }
                        Trace.beginSection("compose:lazy:prefetch:compose");
                        try {
                            e(interfaceC20397rw3, objF);
                            C19938rB7 c19938rB7 = C19938rB7.a;
                            Trace.endSection();
                            j();
                            this.c.d(objF, this.k);
                        } finally {
                        }
                    }
                    if (!this.i) {
                        if (!this.g) {
                            if (this.j <= 0) {
                                return true;
                            }
                            Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                            try {
                                this.h = h();
                                this.g = true;
                                C19938rB7 c19938rB72 = C19938rB7.a;
                            } finally {
                            }
                        }
                        C0046a c0046a = this.h;
                        if (c0046a != null ? c0046a.a(interfaceC4755Gk5) : false) {
                            return true;
                        }
                        j();
                    }
                    if (!this.e && !C17833ne1.p(this.b)) {
                        if (!i(this.j, this.c.c(objF))) {
                            return true;
                        }
                        Trace.beginSection("compose:lazy:prefetch:measure");
                        try {
                            f(this.b);
                            C19938rB7 c19938rB73 = C19938rB7.a;
                            Trace.endSection();
                            j();
                            this.c.e(objF, this.k);
                        } finally {
                        }
                    }
                }
            }
            return false;
        }

        @Override // androidx.compose.foundation.lazy.layout.d.b
        public void cancel() {
            if (this.f) {
                return;
            }
            this.f = true;
            TZ6.a aVar = this.d;
            if (aVar != null) {
                aVar.dispose();
            }
            this.d = null;
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.a + ", constraints = " + ((Object) C17833ne1.q(this.b)) + ", isComposed = " + d() + ", isMeasured = " + this.e + ", isCanceled = " + this.f + " }";
        }

        private a(int i, long j, C4272Ek5 c4272Ek5) {
            this.a = i;
            this.b = j;
            this.c = c4272Ek5;
            this.l = C15595jq7.a.a();
        }
    }

    public i(C19197pw3 c19197pw3, TZ6 tz6, InterfaceC4989Hk5 interfaceC4989Hk5) {
        this.a = c19197pw3;
        this.b = tz6;
        this.c = interfaceC4989Hk5;
    }

    public final InterfaceC4506Fk5 c(int i, long j, C4272Ek5 c4272Ek5) {
        return new a(this, i, j, c4272Ek5, null);
    }

    public final d.b d(int i, long j, C4272Ek5 c4272Ek5) {
        a aVar = new a(this, i, j, c4272Ek5, null);
        this.c.a(aVar);
        return aVar;
    }
}
