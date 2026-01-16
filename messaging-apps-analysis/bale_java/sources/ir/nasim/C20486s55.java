package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.s55, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20486s55 extends U1 implements InterfaceC21763u55 {
    public static final a e = new a(null);
    public static final int f = 8;
    private static final C20486s55 g;
    private final Object b;
    private final Object c;
    private final C9514a55 d;

    /* renamed from: ir.nasim.s55$a */
    public static final class a {
        private a() {
        }

        public final InterfaceC21763u55 a() {
            return C20486s55.g;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        C24746z82 c24746z82 = C24746z82.a;
        g = new C20486s55(c24746z82, c24746z82, C9514a55.d.a());
    }

    public C20486s55(Object obj, Object obj2, C9514a55 c9514a55) {
        this.b = obj;
        this.c = obj2;
        this.d = c9514a55;
    }

    @Override // java.util.Collection, java.util.Set, ir.nasim.InterfaceC21763u55
    public InterfaceC21763u55 add(Object obj) {
        if (this.d.containsKey(obj)) {
            return this;
        }
        if (isEmpty()) {
            return new C20486s55(obj, obj, this.d.q(obj, new C22410vB3()));
        }
        Object obj2 = this.c;
        Object obj3 = this.d.get(obj2);
        AbstractC13042fc3.f(obj3);
        return new C20486s55(this.b, obj, this.d.q(obj2, ((C22410vB3) obj3).e(obj)).q(obj, new C22410vB3(obj2)));
    }

    @Override // ir.nasim.G0, java.util.Collection
    public boolean contains(Object obj) {
        return this.d.containsKey(obj);
    }

    @Override // ir.nasim.G0
    public int getSize() {
        return this.d.size();
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new C21089t55(this.b, this.d);
    }

    @Override // java.util.Collection, java.util.Set, ir.nasim.InterfaceC21763u55
    public InterfaceC21763u55 remove(Object obj) {
        C22410vB3 c22410vB3 = (C22410vB3) this.d.get(obj);
        if (c22410vB3 == null) {
            return this;
        }
        C9514a55 c9514a55S = this.d.s(obj);
        if (c22410vB3.b()) {
            Object obj2 = c9514a55S.get(c22410vB3.d());
            AbstractC13042fc3.f(obj2);
            c9514a55S = c9514a55S.q(c22410vB3.d(), ((C22410vB3) obj2).e(c22410vB3.c()));
        }
        if (c22410vB3.a()) {
            Object obj3 = c9514a55S.get(c22410vB3.c());
            AbstractC13042fc3.f(obj3);
            c9514a55S = c9514a55S.q(c22410vB3.c(), ((C22410vB3) obj3).f(c22410vB3.d()));
        }
        return new C20486s55(!c22410vB3.b() ? c22410vB3.c() : this.b, !c22410vB3.a() ? c22410vB3.d() : this.c, c9514a55S);
    }
}
