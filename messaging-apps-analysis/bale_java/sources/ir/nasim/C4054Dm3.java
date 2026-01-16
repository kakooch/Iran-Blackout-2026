package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import ir.nasim.AbstractC5473Jm3;

/* renamed from: ir.nasim.Dm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public class C4054Dm3 extends AbstractC5473Jm3 implements InterfaceC3820Cm3 {
    private final AbstractC10266bM5.b m;
    private final InterfaceC9173Yu3 n;

    /* renamed from: ir.nasim.Dm3$a */
    public static final class a extends AbstractC5473Jm3.c implements InterfaceC16733lm3, SA2 {
        private final C4054Dm3 h;

        public a(C4054Dm3 c4054Dm3) {
            AbstractC13042fc3.i(c4054Dm3, "property");
            this.h = c4054Dm3;
        }

        @Override // ir.nasim.AbstractC5473Jm3.a
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public C4054Dm3 E() {
            return this.h;
        }

        @Override // ir.nasim.SA2
        public Object invoke() {
            return E().get();
        }
    }

    /* renamed from: ir.nasim.Dm3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return new a(C4054Dm3.this);
        }
    }

    /* renamed from: ir.nasim.Dm3$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        public final Object invoke() {
            C4054Dm3 c4054Dm3 = C4054Dm3.this;
            return c4054Dm3.F(c4054Dm3.D(), C4054Dm3.this.E());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4054Dm3(AbstractC16142km3 abstractC16142km3, InterfaceC20989sw5 interfaceC20989sw5) {
        super(abstractC16142km3, interfaceC20989sw5);
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
        AbstractC10266bM5.b bVarB = AbstractC10266bM5.b(new b());
        AbstractC13042fc3.h(bVarB, "ReflectProperties.lazy { Getter(this) }");
        this.m = bVarB;
        this.n = AbstractC13269fw3.b(EnumC4870Gx3.b, new c());
    }

    @Override // ir.nasim.AbstractC5473Jm3
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public a g() {
        Object objInvoke = this.m.invoke();
        AbstractC13042fc3.h(objInvoke, "_getter()");
        return (a) objInvoke;
    }

    @Override // ir.nasim.InterfaceC3820Cm3
    public Object get() {
        return g().call(new Object[0]);
    }

    @Override // ir.nasim.SA2
    public Object invoke() {
        return get();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4054Dm3(AbstractC16142km3 abstractC16142km3, String str, String str2, Object obj) {
        super(abstractC16142km3, str, str2, obj);
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "signature");
        AbstractC10266bM5.b bVarB = AbstractC10266bM5.b(new b());
        AbstractC13042fc3.h(bVarB, "ReflectProperties.lazy { Getter(this) }");
        this.m = bVarB;
        this.n = AbstractC13269fw3.b(EnumC4870Gx3.b, new c());
    }
}
