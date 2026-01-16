package ir.nasim.features.keyboard;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.view.View;
import androidx.fragment.app.Fragment;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC14008hB5;
import ir.nasim.AbstractC16172kp3;
import ir.nasim.AbstractC21636ts4;
import ir.nasim.C11458d25;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.C24819zF6;
import ir.nasim.C7183Qq;
import ir.nasim.C9248Zc6;
import ir.nasim.C9883aj0;
import ir.nasim.CF6;
import ir.nasim.ED1;
import ir.nasim.EnumC11723dV1;
import ir.nasim.InterfaceC10258bL6;
import ir.nasim.InterfaceC11950dp3;
import ir.nasim.InterfaceC19127pp3;
import ir.nasim.InterfaceC7298Rc6;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.SA2;
import ir.nasim.SO5;
import ir.nasim.SZ;
import ir.nasim.features.keyboard.NewKeyboardLayout;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes5.dex */
public final class a {
    public static final C1166a q = new C1166a(null);
    public static final int r = 8;
    private static final int s = C22078ud6.a(260.0f);
    private NewKeyboardLayout a;
    private View b;
    private CF6 c;
    private SO5 d;
    private final C11458d25 e;
    private final c f;
    private InterfaceC19127pp3 g;
    private boolean h;
    private final InterfaceC9173Yu3 i;
    private final InterfaceC9173Yu3 j;
    private AbstractC21636ts4 k;
    private boolean l;
    private int m;
    private int n;
    private b o;
    private d p;

    /* renamed from: ir.nasim.features.keyboard.a$a, reason: collision with other inner class name */
    public static final class C1166a {
        private C1166a() {
        }

        public /* synthetic */ C1166a(ED1 ed1) {
            this();
        }
    }

    public static abstract class b {

        /* renamed from: ir.nasim.features.keyboard.a$b$a, reason: collision with other inner class name */
        public static final class C1167a extends b {
            private final boolean a;

            public C1167a(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1167a) && this.a == ((C1167a) obj).a;
            }

            public int hashCode() {
                return Boolean.hashCode(this.a);
            }

            public String toString() {
                return "Consumed(followSystem=" + this.a + Separators.RPAREN;
            }
        }

        /* renamed from: ir.nasim.features.keyboard.a$b$b, reason: collision with other inner class name */
        public static final class C1168b extends b {
            private final boolean a;

            public C1168b(boolean z) {
                super(null);
                this.a = z;
            }

            public final boolean a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C1168b) && this.a == ((C1168b) obj).a;
            }

            public int hashCode() {
                return Boolean.hashCode(this.a);
            }

            public String toString() {
                return "Dismiss(needIme=" + this.a + Separators.RPAREN;
            }
        }

        public static final class c extends b {
            public static final c a = new c();

            private c() {
                super(null);
            }
        }

        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static final class c implements InterfaceC11950dp3 {
        c() {
        }

        @Override // ir.nasim.InterfaceC11950dp3
        public void a() {
            a.this.B();
        }

        @Override // ir.nasim.InterfaceC11950dp3
        public void b(boolean z) {
        }

        @Override // ir.nasim.InterfaceC11950dp3
        public void c(int i, View view) {
            AbstractC13042fc3.i(view, "view");
            NewKeyboardLayout newKeyboardLayout = a.this.a;
            if (newKeyboardLayout != null) {
                newKeyboardLayout.c(view, a.this.h);
            }
            if (i != a.this.n) {
                a.this.n = i;
                if (!(a.this.o instanceof b.C1168b)) {
                    a.this.o = b.c.a;
                }
            }
            a.this.C();
        }
    }

    public static final class d implements NewKeyboardLayout.a {
        d() {
        }

        @Override // ir.nasim.features.keyboard.NewKeyboardLayout.a
        public void a(int i) {
            a.this.u();
            a.this.F(i);
        }

        @Override // ir.nasim.features.keyboard.NewKeyboardLayout.a
        public void b() {
            a.this.u();
        }
    }

    public a(NewKeyboardLayout newKeyboardLayout, View view, CF6 cf6, SO5 so5, C11458d25 c11458d25, final Fragment fragment, final InterfaceC10258bL6 interfaceC10258bL6, final boolean z) {
        AbstractC13042fc3.i(cf6, "smilesKeyboardListener");
        AbstractC13042fc3.i(c11458d25, "peer");
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(interfaceC10258bL6, "smilesPanelState");
        this.a = newKeyboardLayout;
        this.b = view;
        this.c = cf6;
        this.d = so5;
        this.e = c11458d25;
        this.f = new c();
        this.i = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lp3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.features.keyboard.a.L(fragment, this, interfaceC10258bL6, z);
            }
        });
        this.j = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.mp3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.features.keyboard.a.p(fragment, this);
            }
        });
        this.n = this.m;
        this.o = new b.C1167a(true);
        this.p = new d();
        this.m = (int) fragment.b6().getDimension(AbstractC14008hB5.keyboard_height);
        C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.np3
            @Override // ir.nasim.InterfaceC7298Rc6
            public final Object run() {
                return ir.nasim.features.keyboard.a.e(this.a);
            }
        }).h(EnumC11723dV1.IO);
        AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
        SZ.e(c9248Zc6H);
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        NewKeyboardLayout.b windowInsetState;
        b bVar = this.o;
        b.C1168b c1168b = bVar instanceof b.C1168b ? (b.C1168b) bVar : null;
        if (c1168b == null) {
            return;
        }
        NewKeyboardLayout newKeyboardLayout = this.a;
        if (newKeyboardLayout == null || (windowInsetState = newKeyboardLayout.getWindowInsetState()) == null || !windowInsetState.b()) {
            if (c1168b.a()) {
                View view = this.b;
                if (view != null) {
                    AbstractC16172kp3.c(view, false, 1, null);
                }
                NewKeyboardLayout newKeyboardLayout2 = this.a;
                if (newKeyboardLayout2 != null) {
                    NewKeyboardLayout.i(newKeyboardLayout2, this.n, false, 2, null);
                }
            } else {
                NewKeyboardLayout newKeyboardLayout3 = this.a;
                if (newKeyboardLayout3 != null) {
                    newKeyboardLayout3.b();
                }
            }
        } else if (c1168b.a()) {
            NewKeyboardLayout newKeyboardLayout4 = this.a;
            if (newKeyboardLayout4 != null) {
                NewKeyboardLayout.i(newKeyboardLayout4, this.n, false, 2, null);
            }
        } else {
            NewKeyboardLayout newKeyboardLayout5 = this.a;
            if (newKeyboardLayout5 != null) {
                newKeyboardLayout5.b();
            }
            View view2 = this.b;
            if (view2 != null) {
                AbstractC16172kp3.a(view2);
            }
        }
        AbstractC21636ts4 abstractC21636ts4 = this.k;
        if (abstractC21636ts4 != null && abstractC21636ts4.f()) {
            if (this.k instanceof C9883aj0) {
                InterfaceC19127pp3 interfaceC19127pp3 = this.g;
                if (interfaceC19127pp3 != null) {
                    interfaceC19127pp3.d(this.l || c1168b.a());
                }
            } else {
                InterfaceC19127pp3 interfaceC19127pp32 = this.g;
                if (interfaceC19127pp32 != null) {
                    interfaceC19127pp32.b(this.l || c1168b.a());
                }
            }
        }
        this.o = new b.C1167a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        AbstractC21636ts4 abstractC21636ts4;
        View view;
        if (this.o instanceof b.c) {
            NewKeyboardLayout newKeyboardLayout = this.a;
            if (newKeyboardLayout != null) {
                if (newKeyboardLayout.getWindowInsetState().b() && (((abstractC21636ts4 = this.k) == null || (!abstractC21636ts4.b())) && (view = this.b) != null)) {
                    AbstractC16172kp3.a(view);
                }
                newKeyboardLayout.h(this.n, this.h);
            }
            if (this.k instanceof C9883aj0) {
                InterfaceC19127pp3 interfaceC19127pp3 = this.g;
                if (interfaceC19127pp3 != null) {
                    interfaceC19127pp3.a();
                }
            } else {
                w().n();
                InterfaceC19127pp3 interfaceC19127pp32 = this.g;
                if (interfaceC19127pp32 != null) {
                    interfaceC19127pp32.c();
                }
            }
            this.o = new b.C1167a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(final int i) {
        if (i != this.m) {
            if (this.k == null || (!r0.b())) {
                C9248Zc6 c9248Zc6H = new C9248Zc6(new InterfaceC7298Rc6() { // from class: ir.nasim.op3
                    @Override // ir.nasim.InterfaceC7298Rc6
                    public final Object run() {
                        return ir.nasim.features.keyboard.a.G(i);
                    }
                }).h(EnumC11723dV1.IO);
                AbstractC13042fc3.h(c9248Zc6H, "subscribeOn(...)");
                SZ.e(c9248Zc6H);
                N(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void G(int i) {
        C7183Qq.p().putInt("keyboard_height", i);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C24819zF6 L(Fragment fragment, a aVar, InterfaceC10258bL6 interfaceC10258bL6, boolean z) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(interfaceC10258bL6, "$smilesPanelState");
        C24819zF6 c24819zF6 = new C24819zF6(fragment, aVar.e, aVar.c, aVar.f, interfaceC10258bL6, z);
        c24819zF6.j(aVar.m);
        return c24819zF6;
    }

    private final void N(int i) {
        NewKeyboardLayout newKeyboardLayout;
        this.m = i;
        this.n = i;
        C24819zF6 c24819zF6W = w();
        c24819zF6W.j(this.m);
        if (c24819zF6W.f() && (newKeyboardLayout = this.a) != null) {
            NewKeyboardLayout.i(newKeyboardLayout, i, false, 2, null);
        }
        c24819zF6W.l(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        int i = C7183Qq.p().getInt("keyboard_height", aVar.m);
        aVar.m = i;
        aVar.n = i;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C9883aj0 p(Fragment fragment, a aVar) {
        AbstractC13042fc3.i(fragment, "$fragment");
        AbstractC13042fc3.i(aVar, "this$0");
        Context contextS7 = fragment.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        C9883aj0 c9883aj0 = new C9883aj0(contextS7, aVar.d, aVar.f);
        c9883aj0.j(aVar.m);
        return c9883aj0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C19938rB7 u() {
        b bVar = this.o;
        if (bVar instanceof b.c) {
            C();
            return C19938rB7.a;
        }
        if (bVar instanceof b.C1168b) {
            B();
            return C19938rB7.a;
        }
        if (!(bVar instanceof b.C1167a)) {
            throw new NoWhenBranchMatchedException();
        }
        NewKeyboardLayout newKeyboardLayout = this.a;
        if (newKeyboardLayout != null) {
            if (((b.C1167a) bVar).a()) {
                if (newKeyboardLayout.getWindowInsetState().b()) {
                    NewKeyboardLayout.i(newKeyboardLayout, newKeyboardLayout.getWindowInsetState().a(), false, 2, null);
                } else {
                    newKeyboardLayout.b();
                }
                return C19938rB7.a;
            }
            AbstractC21636ts4 abstractC21636ts4 = this.k;
            if (abstractC21636ts4 == null || !abstractC21636ts4.f()) {
                if (newKeyboardLayout.getWindowInsetState().b()) {
                    NewKeyboardLayout.i(newKeyboardLayout, newKeyboardLayout.getWindowInsetState().a(), false, 2, null);
                } else {
                    newKeyboardLayout.b();
                }
                return C19938rB7.a;
            }
            AbstractC21636ts4 abstractC21636ts42 = this.k;
            if (abstractC21636ts42 != null) {
                newKeyboardLayout.h(abstractC21636ts42.c(), this.h);
                return C19938rB7.a;
            }
        }
        return null;
    }

    private final C9883aj0 v() {
        return (C9883aj0) this.j.getValue();
    }

    private final C24819zF6 w() {
        return (C24819zF6) this.i.getValue();
    }

    public final boolean A() {
        if (this.l) {
            NewKeyboardLayout newKeyboardLayout = this.a;
            if (newKeyboardLayout == null) {
                return true;
            }
            newKeyboardLayout.b();
            return true;
        }
        AbstractC21636ts4 abstractC21636ts4 = this.k;
        if (abstractC21636ts4 != null ? abstractC21636ts4.g() : false) {
            return true;
        }
        AbstractC21636ts4 abstractC21636ts42 = this.k;
        if (!(abstractC21636ts42 != null ? abstractC21636ts42.f() : false)) {
            return false;
        }
        r(false);
        return true;
    }

    public final void D() {
        r(false);
        NewKeyboardLayout newKeyboardLayout = this.a;
        if (newKeyboardLayout != null) {
            newKeyboardLayout.setKeyboardLayoutListener(null);
        }
    }

    public final void E() {
        NewKeyboardLayout newKeyboardLayout = this.a;
        if (newKeyboardLayout != null) {
            newKeyboardLayout.setKeyboardLayoutListener(this.p);
        }
    }

    public final void H(InterfaceC19127pp3 interfaceC19127pp3) {
        this.g = interfaceC19127pp3;
    }

    public final void I(List list) {
        AbstractC13042fc3.i(list, "replyKeyboardRows");
        v().K(list);
    }

    public final void J() {
        AbstractC21636ts4 abstractC21636ts4 = this.k;
        if (!(abstractC21636ts4 instanceof C9883aj0)) {
            if (abstractC21636ts4 != null) {
                abstractC21636ts4.a();
            }
            this.k = v();
        }
        this.o = b.c.a;
        int i = s;
        this.n = i;
        this.h = true;
        AbstractC21636ts4 abstractC21636ts42 = this.k;
        if (abstractC21636ts42 != null) {
            abstractC21636ts42.k(i);
        }
    }

    public final void K() {
        AbstractC21636ts4 abstractC21636ts4 = this.k;
        if (!(abstractC21636ts4 instanceof C24819zF6)) {
            if (abstractC21636ts4 != null) {
                abstractC21636ts4.a();
            }
            this.k = w();
        }
        this.o = b.c.a;
        int i = this.m;
        this.n = i;
        this.h = false;
        AbstractC21636ts4 abstractC21636ts42 = this.k;
        if (abstractC21636ts42 != null) {
            abstractC21636ts42.k(i);
        }
    }

    public final void M() {
        if (!w().f()) {
            K();
        } else {
            if (w().g()) {
                return;
            }
            t(true);
        }
    }

    public final void q(boolean z) {
        r(z);
        NewKeyboardLayout newKeyboardLayout = this.a;
        if (newKeyboardLayout != null) {
            newKeyboardLayout.setKeyboardLayoutListener(null);
        }
        this.a = null;
        this.b = null;
    }

    public final void r(boolean z) {
        AbstractC21636ts4 abstractC21636ts4 = this.k;
        if (abstractC21636ts4 == null || !abstractC21636ts4.f()) {
            this.o = new b.C1168b(z);
            B();
            return;
        }
        AbstractC21636ts4 abstractC21636ts42 = this.k;
        if (abstractC21636ts42 instanceof C24819zF6) {
            t(z);
        } else if (abstractC21636ts42 instanceof C9883aj0) {
            s(z);
        }
    }

    public final void s(boolean z) {
        if (this.k instanceof C9883aj0) {
            this.o = new b.C1168b(z);
            AbstractC21636ts4 abstractC21636ts4 = this.k;
            if (abstractC21636ts4 != null) {
                abstractC21636ts4.a();
            }
        }
    }

    public final void t(boolean z) {
        if (this.k instanceof C24819zF6) {
            this.o = new b.C1168b(z);
            AbstractC21636ts4 abstractC21636ts4 = this.k;
            if (abstractC21636ts4 != null) {
                abstractC21636ts4.a();
            }
        }
    }

    public final boolean x() {
        return v().f();
    }

    public final boolean y() {
        AbstractC21636ts4 abstractC21636ts4 = this.k;
        if (abstractC21636ts4 != null) {
            return abstractC21636ts4.f();
        }
        return false;
    }

    public final boolean z() {
        return w().f();
    }
}
