package ir.nasim;

import com.google.gson.reflect.TypeToken;

/* renamed from: ir.nasim.bw7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10640bw7 extends AbstractC22208uq6 {
    private final InterfaceC22145uk3 a;
    final KS2 b;
    private final TypeToken c;
    private final InterfaceC6537Nx7 d;
    private final b e;
    private final boolean f;
    private volatile AbstractC6277Mx7 g;

    /* renamed from: ir.nasim.bw7$b */
    private final class b implements InterfaceC21555tk3 {
        private b() {
        }
    }

    /* renamed from: ir.nasim.bw7$c */
    private static final class c implements InterfaceC6537Nx7 {
        private final TypeToken a;
        private final boolean b;
        private final Class c;
        private final InterfaceC22145uk3 d;

        c(Object obj, TypeToken typeToken, boolean z, Class cls) {
            InterfaceC22145uk3 interfaceC22145uk3 = obj instanceof InterfaceC22145uk3 ? (InterfaceC22145uk3) obj : null;
            this.d = interfaceC22145uk3;
            AbstractC9457a.a(interfaceC22145uk3 != null);
            this.a = typeToken;
            this.b = z;
            this.c = cls;
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            TypeToken typeToken2 = this.a;
            if (typeToken2 != null ? typeToken2.equals(typeToken) || (this.b && this.a.d() == typeToken.c()) : this.c.isAssignableFrom(typeToken.c())) {
                return new C10640bw7(null, this.d, ks2, typeToken, this);
            }
            return null;
        }
    }

    public C10640bw7(InterfaceC14951il3 interfaceC14951il3, InterfaceC22145uk3 interfaceC22145uk3, KS2 ks2, TypeToken typeToken, InterfaceC6537Nx7 interfaceC6537Nx7, boolean z) {
        this.e = new b();
        this.a = interfaceC22145uk3;
        this.b = ks2;
        this.c = typeToken;
        this.d = interfaceC6537Nx7;
        this.f = z;
    }

    private AbstractC6277Mx7 f() {
        AbstractC6277Mx7 abstractC6277Mx7 = this.g;
        if (abstractC6277Mx7 != null) {
            return abstractC6277Mx7;
        }
        AbstractC6277Mx7 abstractC6277Mx7O = this.b.o(this.d, this.c);
        this.g = abstractC6277Mx7O;
        return abstractC6277Mx7O;
    }

    public static InterfaceC6537Nx7 g(TypeToken typeToken, Object obj) {
        return new c(obj, typeToken, typeToken.d() == typeToken.c(), null);
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public Object b(C12523el3 c12523el3) {
        if (this.a == null) {
            return f().b(c12523el3);
        }
        AbstractC22735vk3 abstractC22735vk3A = AbstractC19553qY6.a(c12523el3);
        if (this.f && abstractC22735vk3A.x()) {
            return null;
        }
        return this.a.a(abstractC22735vk3A, this.c.d(), this.e);
    }

    @Override // ir.nasim.AbstractC6277Mx7
    public void d(C22155ul3 c22155ul3, Object obj) {
        f().d(c22155ul3, obj);
    }

    @Override // ir.nasim.AbstractC22208uq6
    public AbstractC6277Mx7 e() {
        return f();
    }

    public C10640bw7(InterfaceC14951il3 interfaceC14951il3, InterfaceC22145uk3 interfaceC22145uk3, KS2 ks2, TypeToken typeToken, InterfaceC6537Nx7 interfaceC6537Nx7) {
        this(interfaceC14951il3, interfaceC22145uk3, ks2, typeToken, interfaceC6537Nx7, true);
    }
}
