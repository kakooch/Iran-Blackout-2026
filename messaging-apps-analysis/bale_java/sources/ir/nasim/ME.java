package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* loaded from: classes5.dex */
public abstract class ME extends K6 {
    public static final a m = new a(null);
    public static final int n = 8;
    private final C11335cq f;
    private boolean g;
    private boolean h;
    private int i;
    private FE0 j;
    private boolean k;
    private long l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b {
        private boolean a;

        public b(boolean z) {
            this.a = z;
        }

        public final boolean a() {
            return this.a;
        }
    }

    private static final class c {
    }

    public static final class d {
    }

    public static final class e {
    }

    public static final class f {
    }

    public static final class g {
    }

    public ME(C11335cq c11335cq) {
        AbstractC13042fc3.i(c11335cq, "messenger");
        this.f = c11335cq;
        this.k = true;
    }

    private final void A(boolean z) {
        this.h = z;
    }

    private final void D() {
        C19406qI3.a("AppStateActor", "onActivityClosed", new Object[0]);
        int i = this.i;
        if (i > 0) {
            this.i = i - 1;
        }
        if (this.i == 0) {
            H();
            this.l = System.currentTimeMillis();
            this.k = true;
        }
    }

    private final void E() {
        C19406qI3.a("AppStateActor", "onActivityOpened", new Object[0]);
        this.i++;
        G();
        if (System.currentTimeMillis() - this.l < 200) {
            this.k = false;
        }
        System.out.println((Object) "switch to foreground");
    }

    private final void F() {
        C19406qI3.a("AppStateActor", "onAppClosed", new Object[0]);
        if (this.g) {
            this.g = false;
            this.f.Z0();
        }
    }

    private final void G() {
        C19406qI3.a("AppStateActor", "onAppOpened", new Object[0]);
        this.g = true;
        this.f.a1();
        FE0 fe0 = this.j;
        if (fe0 != null) {
            if (fe0 != null) {
                fe0.cancel();
            }
            this.j = null;
        }
    }

    private final void J() {
        C19406qI3.a("AppStateActor", "onScreenOn", new Object[0]);
        if (this.i > 0) {
            G();
        }
    }

    public final boolean B() {
        return this.g;
    }

    public final boolean C(boolean z) {
        if (z && System.currentTimeMillis() - this.l < 200) {
            this.k = false;
        }
        return this.k;
    }

    protected void H() {
        C19406qI3.a("AppStateActor", "onAppProbablyClosed", new Object[0]);
        if (this.g) {
            FE0 fe0 = this.j;
            if (fe0 != null) {
                if (fe0 != null) {
                    fe0.cancel();
                }
                this.j = null;
            }
            this.j = q(new c(), 100L);
        }
    }

    public final void I() {
        C19406qI3.a("AppStateActor", "onScreenOff", new Object[0]);
        H();
    }

    public final void K() {
        this.k = false;
    }

    public final boolean L() {
        return this.h;
    }

    @Override // ir.nasim.K6
    public void m(Object obj) {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof e) {
            E();
            return;
        }
        if (obj instanceof d) {
            D();
            return;
        }
        if (obj instanceof c) {
            F();
            return;
        }
        if (obj instanceof g) {
            J();
            return;
        }
        if (obj instanceof f) {
            I();
        } else if (obj instanceof b) {
            A(((b) obj).a());
        } else {
            super.m(obj);
        }
    }
}
