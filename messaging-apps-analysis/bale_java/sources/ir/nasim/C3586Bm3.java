package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import ir.nasim.InterfaceC15194jA0;
import ir.nasim.InterfaceC3347Am3;
import java.lang.reflect.Type;
import java.util.List;

/* renamed from: ir.nasim.Bm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C3586Bm3 implements InterfaceC3347Am3 {
    static final /* synthetic */ InterfaceC5239Im3[] f = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C3586Bm3.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C3586Bm3.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final AbstractC10266bM5.a a;
    private final AbstractC10266bM5.a b;
    private final AbstractC10536bm3 c;
    private final int d;
    private final InterfaceC3347Am3.a e;

    /* renamed from: ir.nasim.Bm3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            return AbstractC14729iN7.c(C3586Bm3.this.i());
        }
    }

    /* renamed from: ir.nasim.Bm3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Type invoke() {
            InterfaceC17169mW4 interfaceC17169mW4I = C3586Bm3.this.i();
            if (!(interfaceC17169mW4I instanceof ZI5) || !AbstractC13042fc3.d(AbstractC14729iN7.f(C3586Bm3.this.h().D()), interfaceC17169mW4I) || C3586Bm3.this.h().D().f() != InterfaceC15194jA0.a.FAKE_OVERRIDE) {
                return (Type) C3586Bm3.this.h().x().a().get(C3586Bm3.this.j());
            }
            InterfaceC12795fB1 interfaceC12795fB1B = C3586Bm3.this.h().D().b();
            if (interfaceC12795fB1B == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            Class clsM = AbstractC14729iN7.m((InterfaceC21331tU0) interfaceC12795fB1B);
            if (clsM != null) {
                return clsM;
            }
            throw new C25175zr3("Cannot determine receiver Java type of inherited declaration: " + interfaceC17169mW4I);
        }
    }

    public C3586Bm3(AbstractC10536bm3 abstractC10536bm3, int i, InterfaceC3347Am3.a aVar, SA2 sa2) {
        AbstractC13042fc3.i(abstractC10536bm3, "callable");
        AbstractC13042fc3.i(aVar, "kind");
        AbstractC13042fc3.i(sa2, "computeDescriptor");
        this.c = abstractC10536bm3;
        this.d = i;
        this.e = aVar;
        this.a = AbstractC10266bM5.c(sa2);
        this.b = AbstractC10266bM5.c(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC17169mW4 i() {
        return (InterfaceC17169mW4) this.a.b(this, f[0]);
    }

    @Override // ir.nasim.InterfaceC3347Am3
    public boolean c() {
        InterfaceC17169mW4 interfaceC17169mW4I = i();
        return (interfaceC17169mW4I instanceof InterfaceC24919zQ7) && ((InterfaceC24919zQ7) interfaceC17169mW4I).u0() != null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C3586Bm3) {
            C3586Bm3 c3586Bm3 = (C3586Bm3) obj;
            if (AbstractC13042fc3.d(this.c, c3586Bm3.c) && j() == c3586Bm3.j()) {
                return true;
            }
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC3347Am3
    public InterfaceC3347Am3.a f() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC3347Am3
    public String getName() {
        InterfaceC17169mW4 interfaceC17169mW4I = i();
        if (!(interfaceC17169mW4I instanceof InterfaceC24919zQ7)) {
            interfaceC17169mW4I = null;
        }
        InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) interfaceC17169mW4I;
        if (interfaceC24919zQ7 == null || interfaceC24919zQ7.b().h0()) {
            return null;
        }
        C6432No4 name = interfaceC24919zQ7.getName();
        AbstractC13042fc3.h(name, "valueParameter.name");
        if (name.q()) {
            return null;
        }
        return name.h();
    }

    @Override // ir.nasim.InterfaceC3347Am3
    public InterfaceC5941Lm3 getType() {
        AbstractC4099Dr3 type = i().getType();
        AbstractC13042fc3.h(type, "descriptor.type");
        return new C6673Om3(type, new b());
    }

    public final AbstractC10536bm3 h() {
        return this.c;
    }

    public int hashCode() {
        return (this.c.hashCode() * 31) + Integer.valueOf(j()).hashCode();
    }

    public int j() {
        return this.d;
    }

    public String toString() {
        return C15307jM5.b.f(this);
    }

    @Override // ir.nasim.InterfaceC3347Am3
    public boolean w() {
        InterfaceC17169mW4 interfaceC17169mW4I = i();
        if (!(interfaceC17169mW4I instanceof InterfaceC24919zQ7)) {
            interfaceC17169mW4I = null;
        }
        InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) interfaceC17169mW4I;
        if (interfaceC24919zQ7 != null) {
            return PI1.a(interfaceC24919zQ7);
        }
        return false;
    }
}
