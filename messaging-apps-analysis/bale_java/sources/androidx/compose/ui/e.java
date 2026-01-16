package androidx.compose.ui;

import ir.nasim.AbstractC19067pj3;
import ir.nasim.AbstractC20906so1;
import ir.nasim.InterfaceC13730gj3;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.JG1;
import ir.nasim.KG1;
import ir.nasim.M73;
import ir.nasim.SA2;
import ir.nasim.UA2;
import ir.nasim.UG4;
import ir.nasim.XA4;

/* loaded from: classes2.dex */
public interface e {
    public static final a a = a.b;

    public interface b extends e {
        @Override // androidx.compose.ui.e
        default Object a(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
            return interfaceC14603iB2.invoke(obj, this);
        }

        @Override // androidx.compose.ui.e
        default boolean c(UA2 ua2) {
            return ((Boolean) ua2.invoke(this)).booleanValue();
        }

        @Override // androidx.compose.ui.e
        default boolean d(UA2 ua2) {
            return ((Boolean) ua2.invoke(this)).booleanValue();
        }
    }

    public static abstract class c implements JG1 {
        private InterfaceC20315ro1 b;
        private int c;
        private c e;
        private c f;
        private UG4 g;
        private XA4 h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private SA2 m;
        private boolean n;
        private c a = this;
        private int d = -1;

        public final int R1() {
            return this.d;
        }

        public final c S1() {
            return this.f;
        }

        public final XA4 T1() {
            return this.h;
        }

        public final InterfaceC20315ro1 U1() {
            InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            if (interfaceC20315ro1 != null) {
                return interfaceC20315ro1;
            }
            InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(KG1.p(this).getCoroutineContext().X(AbstractC19067pj3.a((InterfaceC13730gj3) KG1.p(this).getCoroutineContext().a(InterfaceC13730gj3.n0))));
            this.b = interfaceC20315ro1A;
            return interfaceC20315ro1A;
        }

        public final boolean V1() {
            return this.i;
        }

        public final int W1() {
            return this.c;
        }

        public final UG4 X1() {
            return this.g;
        }

        public final c Y1() {
            return this.e;
        }

        public boolean Z1() {
            return true;
        }

        public final boolean a2() {
            return this.j;
        }

        public final boolean b2() {
            return this.n;
        }

        public void c2() {
            if (!(!this.n)) {
                M73.b("node attached multiple times");
            }
            if (!(this.h != null)) {
                M73.b("attach invoked on a node without a coordinator");
            }
            this.n = true;
            this.k = true;
        }

        public void d2() {
            if (!this.n) {
                M73.b("Cannot detach a node that is not attached");
            }
            if (!(!this.k)) {
                M73.b("Must run runAttachLifecycle() before markAsDetached()");
            }
            if (!(!this.l)) {
                M73.b("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.n = false;
            InterfaceC20315ro1 interfaceC20315ro1 = this.b;
            if (interfaceC20315ro1 != null) {
                AbstractC20906so1.c(interfaceC20315ro1, new ModifierNodeDetachedCancellationException());
                this.b = null;
            }
        }

        public void e2() {
        }

        public void f2() {
        }

        public void g2() {
        }

        @Override // ir.nasim.JG1
        public final c h() {
            return this.a;
        }

        public void h2() {
            if (!this.n) {
                M73.b("reset() called on an unattached node");
            }
            g2();
        }

        public void i2() {
            if (!this.n) {
                M73.b("Must run markAsAttached() prior to runAttachLifecycle");
            }
            if (!this.k) {
                M73.b("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.k = false;
            e2();
            this.l = true;
        }

        public void j2() {
            if (!this.n) {
                M73.b("node detached multiple times");
            }
            if (!(this.h != null)) {
                M73.b("detach invoked on a node without a coordinator");
            }
            if (!this.l) {
                M73.b("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.l = false;
            SA2 sa2 = this.m;
            if (sa2 != null) {
                sa2.invoke();
            }
            f2();
        }

        public final void k2(int i) {
            this.d = i;
        }

        public void l2(c cVar) {
            this.a = cVar;
        }

        public final void m2(c cVar) {
            this.f = cVar;
        }

        public final void n2(SA2 sa2) {
            this.m = sa2;
        }

        public final void o2(boolean z) {
            this.i = z;
        }

        public final void p2(int i) {
            this.c = i;
        }

        public final void q2(UG4 ug4) {
            this.g = ug4;
        }

        public final void r2(c cVar) {
            this.e = cVar;
        }

        public final void s2(boolean z) {
            this.j = z;
        }

        public final void t2(SA2 sa2) {
            KG1.p(this).h(sa2);
        }

        public void u2(XA4 xa4) {
            this.h = xa4;
        }
    }

    Object a(Object obj, InterfaceC14603iB2 interfaceC14603iB2);

    boolean c(UA2 ua2);

    boolean d(UA2 ua2);

    default e i(e eVar) {
        return eVar == a ? this : new androidx.compose.ui.a(this, eVar);
    }

    public static final class a implements e {
        static final /* synthetic */ a b = new a();

        private a() {
        }

        @Override // androidx.compose.ui.e
        public boolean c(UA2 ua2) {
            return true;
        }

        @Override // androidx.compose.ui.e
        public boolean d(UA2 ua2) {
            return false;
        }

        @Override // androidx.compose.ui.e
        public e i(e eVar) {
            return eVar;
        }

        public String toString() {
            return "Modifier";
        }

        @Override // androidx.compose.ui.e
        public Object a(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
            return obj;
        }
    }
}
