package ir.nasim;

import ir.nasim.DT1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Sd1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C7536Sd1 {
    private final Object a;
    private final List b;
    private final C7773Td1 c;
    private final InterfaceC14163hS7 d;
    private final InterfaceC14163hS7 e;
    private final IY2 f;
    private final InterfaceC14163hS7 g;
    private final InterfaceC14163hS7 h;
    private final IY2 i;
    private final InterfaceC17231md0 j;
    private DT1 k;
    private DT1 l;
    private FY7 m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;

    /* renamed from: ir.nasim.Sd1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ DT1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(DT1 dt1) {
            super(1);
            this.f = dt1;
        }

        public final void a(TK6 tk6) {
            AbstractC13042fc3.i(tk6, "state");
            tk6.c(C7536Sd1.this.d()).V(((HT1) this.f).e(tk6));
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((TK6) obj);
            return C19938rB7.a;
        }
    }

    public C7536Sd1(Object obj) {
        AbstractC13042fc3.i(obj, "id");
        this.a = obj;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Integer num = UK6.f;
        AbstractC13042fc3.h(num, "PARENT");
        this.c = new C7773Td1(num);
        this.d = new C16060ke1(obj, -2, arrayList);
        this.e = new C16060ke1(obj, 0, arrayList);
        this.f = new C9018Yd1(obj, 0, arrayList);
        this.g = new C16060ke1(obj, -1, arrayList);
        this.h = new C16060ke1(obj, 1, arrayList);
        this.i = new C9018Yd1(obj, 1, arrayList);
        this.j = new C8477Wd1(obj, arrayList);
        DT1.b bVar = DT1.a;
        this.k = bVar.b();
        this.l = bVar.b();
        this.m = FY7.b.a();
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = 1.0f;
        float f = 0;
        this.q = C17784nZ1.q(f);
        this.r = C17784nZ1.q(f);
        this.s = C17784nZ1.q(f);
        this.t = 0.5f;
        this.u = 0.5f;
        this.v = Float.NaN;
        this.w = Float.NaN;
    }

    public final void a(TK6 tk6) {
        AbstractC13042fc3.i(tk6, "state");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((UA2) it.next()).invoke(tk6);
        }
    }

    public final IY2 b() {
        return this.i;
    }

    public final InterfaceC14163hS7 c() {
        return this.g;
    }

    public final Object d() {
        return this.a;
    }

    public final C7773Td1 e() {
        return this.c;
    }

    public final InterfaceC14163hS7 f() {
        return this.d;
    }

    public final IY2 g() {
        return this.f;
    }

    public final void h(DT1 dt1) {
        AbstractC13042fc3.i(dt1, "value");
        this.k = dt1;
        this.b.add(new a(dt1));
    }
}
