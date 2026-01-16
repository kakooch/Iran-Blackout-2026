package androidx.navigation;

import androidx.navigation.m;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C15017is;
import ir.nasim.C19938rB7;
import ir.nasim.C23903xi5;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public final class n {
    private boolean b;
    private boolean c;
    private String e;
    private boolean f;
    private boolean g;
    private final m.a a = new m.a();
    private int d = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(C23903xi5 c23903xi5) {
            AbstractC13042fc3.i(c23903xi5, "$this$null");
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C23903xi5) obj);
            return C19938rB7.a;
        }
    }

    public static /* synthetic */ void e(n nVar, int i, UA2 ua2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            ua2 = a.e;
        }
        nVar.c(i, ua2);
    }

    private final void h(String str) {
        if (str != null) {
            if (!(!AbstractC20762sZ6.n0(str))) {
                throw new IllegalArgumentException("Cannot pop up to an empty route".toString());
            }
            this.e = str;
            this.f = false;
        }
    }

    public final void a(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "animBuilder");
        C15017is c15017is = new C15017is();
        ua2.invoke(c15017is);
        this.a.b(c15017is.a()).c(c15017is.b()).e(c15017is.c()).f(c15017is.d());
    }

    public final m b() {
        m.a aVar = this.a;
        aVar.d(this.b);
        aVar.j(this.c);
        String str = this.e;
        if (str != null) {
            aVar.h(str, this.f, this.g);
        } else {
            aVar.g(this.d, this.f, this.g);
        }
        return aVar.a();
    }

    public final void c(int i, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "popUpToBuilder");
        g(i);
        h(null);
        C23903xi5 c23903xi5 = new C23903xi5();
        ua2.invoke(c23903xi5);
        this.f = c23903xi5.a();
        this.g = c23903xi5.b();
    }

    public final void d(String str, UA2 ua2) {
        AbstractC13042fc3.i(str, "route");
        AbstractC13042fc3.i(ua2, "popUpToBuilder");
        h(str);
        g(-1);
        C23903xi5 c23903xi5 = new C23903xi5();
        ua2.invoke(c23903xi5);
        this.f = c23903xi5.a();
        this.g = c23903xi5.b();
    }

    public final void f(boolean z) {
        this.b = z;
    }

    public final void g(int i) {
        this.d = i;
        this.f = false;
    }

    public final void i(boolean z) {
        this.c = z;
    }
}
