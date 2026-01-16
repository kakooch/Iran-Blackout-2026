package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import ir.nasim.AbstractC6165Ml3;
import ir.nasim.AbstractC7610Sl3;
import ir.nasim.InterfaceC4356Eu;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;

/* renamed from: ir.nasim.Jm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5473Jm3 extends AbstractC10536bm3 implements InterfaceC5239Im3 {
    private final AbstractC10266bM5.b e;
    private final AbstractC10266bM5.a f;
    private final AbstractC16142km3 g;
    private final String h;
    private final String i;
    private final Object j;
    public static final b l = new b(null);
    private static final Object k = new Object();

    /* renamed from: ir.nasim.Jm3$a */
    public static abstract class a extends AbstractC10536bm3 implements InterfaceC16733lm3 {
        @Override // ir.nasim.AbstractC10536bm3
        public boolean C() {
            return E().C();
        }

        public abstract InterfaceC19199pw5 D();

        public abstract AbstractC5473Jm3 E();

        @Override // ir.nasim.InterfaceC16733lm3
        public boolean isExternal() {
            return D().isExternal();
        }

        @Override // ir.nasim.InterfaceC16733lm3
        public boolean isInfix() {
            return D().isInfix();
        }

        @Override // ir.nasim.InterfaceC16733lm3
        public boolean isInline() {
            return D().isInline();
        }

        @Override // ir.nasim.InterfaceC16733lm3
        public boolean isOperator() {
            return D().isOperator();
        }

        @Override // ir.nasim.InterfaceC16733lm3
        public boolean isSuspend() {
            return D().isSuspend();
        }

        @Override // ir.nasim.AbstractC10536bm3
        public AbstractC16142km3 y() {
            return E().y();
        }

        @Override // ir.nasim.AbstractC10536bm3
        public InterfaceC18740pA0 z() {
            return null;
        }
    }

    /* renamed from: ir.nasim.Jm3$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.Jm3$c */
    public static abstract class c extends a implements InterfaceC16733lm3 {
        static final /* synthetic */ InterfaceC5239Im3[] g = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final AbstractC10266bM5.a e = AbstractC10266bM5.c(new b());
        private final AbstractC10266bM5.b f = AbstractC10266bM5.b(new a());

        /* renamed from: ir.nasim.Jm3$c$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18740pA0 invoke() {
                return AbstractC5707Km3.c(c.this, true);
            }
        }

        /* renamed from: ir.nasim.Jm3$c$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC22266uw5 invoke() {
                InterfaceC22266uw5 interfaceC22266uw5G = c.this.E().D().g();
                return interfaceC22266uw5G != null ? interfaceC22266uw5G : AbstractC23657xI1.b(c.this.E().D(), InterfaceC4356Eu.W.b());
            }
        }

        @Override // ir.nasim.AbstractC5473Jm3.a
        /* renamed from: F, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public InterfaceC22266uw5 D() {
            return (InterfaceC22266uw5) this.e.b(this, g[0]);
        }

        @Override // ir.nasim.InterfaceC9916am3
        public String getName() {
            return "<get-" + E().getName() + '>';
        }

        @Override // ir.nasim.AbstractC10536bm3
        public InterfaceC18740pA0 x() {
            return (InterfaceC18740pA0) this.f.b(this, g[1]);
        }
    }

    /* renamed from: ir.nasim.Jm3$d */
    public static abstract class d extends a implements InterfaceC16733lm3 {
        static final /* synthetic */ InterfaceC5239Im3[] g = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        private final AbstractC10266bM5.a e = AbstractC10266bM5.c(new b());
        private final AbstractC10266bM5.b f = AbstractC10266bM5.b(new a());

        /* renamed from: ir.nasim.Jm3$d$a */
        static final class a extends AbstractC8614Ws3 implements SA2 {
            a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC18740pA0 invoke() {
                return AbstractC5707Km3.c(d.this, false);
            }
        }

        /* renamed from: ir.nasim.Jm3$d$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final InterfaceC4146Dw5 invoke() {
                InterfaceC4146Dw5 interfaceC4146Dw5J = d.this.E().D().J();
                if (interfaceC4146Dw5J != null) {
                    return interfaceC4146Dw5J;
                }
                InterfaceC20989sw5 interfaceC20989sw5D = d.this.E().D();
                InterfaceC4356Eu.a aVar = InterfaceC4356Eu.W;
                return AbstractC23657xI1.c(interfaceC20989sw5D, aVar.b(), aVar.b());
            }
        }

        @Override // ir.nasim.AbstractC5473Jm3.a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public InterfaceC4146Dw5 D() {
            return (InterfaceC4146Dw5) this.e.b(this, g[0]);
        }

        @Override // ir.nasim.InterfaceC9916am3
        public String getName() {
            return "<set-" + E().getName() + '>';
        }

        @Override // ir.nasim.AbstractC10536bm3
        public InterfaceC18740pA0 x() {
            return (InterfaceC18740pA0) this.f.b(this, g[1]);
        }
    }

    /* renamed from: ir.nasim.Jm3$e */
    static final class e extends AbstractC8614Ws3 implements SA2 {
        e() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC20989sw5 invoke() {
            return AbstractC5473Jm3.this.y().s(AbstractC5473Jm3.this.getName(), AbstractC5473Jm3.this.J());
        }
    }

    /* renamed from: ir.nasim.Jm3$f */
    static final class f extends AbstractC8614Ws3 implements SA2 {
        f() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Field invoke() {
            Class enclosingClass;
            AbstractC7610Sl3 abstractC7610Sl3F = A76.b.f(AbstractC5473Jm3.this.D());
            if (!(abstractC7610Sl3F instanceof AbstractC7610Sl3.c)) {
                if (abstractC7610Sl3F instanceof AbstractC7610Sl3.a) {
                    return ((AbstractC7610Sl3.a) abstractC7610Sl3F).b();
                }
                if ((abstractC7610Sl3F instanceof AbstractC7610Sl3.b) || (abstractC7610Sl3F instanceof AbstractC7610Sl3.d)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            AbstractC7610Sl3.c cVar = (AbstractC7610Sl3.c) abstractC7610Sl3F;
            InterfaceC20989sw5 interfaceC20989sw5B = cVar.b();
            AbstractC6165Ml3.a aVarD = C8083Ul3.d(C8083Ul3.a, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
            if (aVarD == null) {
                return null;
            }
            if (SI1.e(interfaceC20989sw5B) || C8083Ul3.f(cVar.e())) {
                enclosingClass = AbstractC5473Jm3.this.y().e().getEnclosingClass();
            } else {
                InterfaceC12795fB1 interfaceC12795fB1B = interfaceC20989sw5B.b();
                enclosingClass = interfaceC12795fB1B instanceof InterfaceC21331tU0 ? AbstractC14729iN7.m((InterfaceC21331tU0) interfaceC12795fB1B) : AbstractC5473Jm3.this.y().e();
            }
            if (enclosingClass == null) {
                return null;
            }
            try {
                return enclosingClass.getDeclaredField(aVarD.c());
            } catch (NoSuchFieldException unused) {
                return null;
            }
        }
    }

    private AbstractC5473Jm3(AbstractC16142km3 abstractC16142km3, String str, String str2, InterfaceC20989sw5 interfaceC20989sw5, Object obj) {
        this.g = abstractC16142km3;
        this.h = str;
        this.i = str2;
        this.j = obj;
        AbstractC10266bM5.b bVarB = AbstractC10266bM5.b(new f());
        AbstractC13042fc3.h(bVarB, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.e = bVarB;
        AbstractC10266bM5.a aVarD = AbstractC10266bM5.d(interfaceC20989sw5, new e());
        AbstractC13042fc3.h(aVarD, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.f = aVarD;
    }

    @Override // ir.nasim.AbstractC10536bm3
    public boolean C() {
        return !AbstractC13042fc3.d(this.j, AbstractC15785kA0.NO_RECEIVER);
    }

    protected final Field D() {
        if (D().B()) {
            return I();
        }
        return null;
    }

    public final Object E() {
        return I73.a(this.j, D());
    }

    protected final Object F(Field field, Object obj) throws IllegalPropertyDelegateAccessException {
        try {
            if (obj == k && D().Q() == null) {
                throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
            }
            if (field != null) {
                return field.get(obj);
            }
            return null;
        } catch (IllegalAccessException e2) {
            throw new IllegalPropertyDelegateAccessException(e2);
        }
    }

    @Override // ir.nasim.AbstractC10536bm3
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public InterfaceC20989sw5 D() {
        Object objInvoke = this.f.invoke();
        AbstractC13042fc3.h(objInvoke, "_descriptor()");
        return (InterfaceC20989sw5) objInvoke;
    }

    public abstract c H();

    public final Field I() {
        return (Field) this.e.invoke();
    }

    public final String J() {
        return this.i;
    }

    public boolean equals(Object obj) {
        AbstractC5473Jm3 abstractC5473Jm3B = AbstractC14729iN7.b(obj);
        return abstractC5473Jm3B != null && AbstractC13042fc3.d(y(), abstractC5473Jm3B.y()) && AbstractC13042fc3.d(getName(), abstractC5473Jm3B.getName()) && AbstractC13042fc3.d(this.i, abstractC5473Jm3B.i) && AbstractC13042fc3.d(this.j, abstractC5473Jm3B.j);
    }

    @Override // ir.nasim.InterfaceC9916am3
    public String getName() {
        return this.h;
    }

    public int hashCode() {
        return (((y().hashCode() * 31) + getName().hashCode()) * 31) + this.i.hashCode();
    }

    public String toString() {
        return C15307jM5.b.g(D());
    }

    @Override // ir.nasim.AbstractC10536bm3
    public InterfaceC18740pA0 x() {
        return H().x();
    }

    @Override // ir.nasim.AbstractC10536bm3
    public AbstractC16142km3 y() {
        return this.g;
    }

    @Override // ir.nasim.AbstractC10536bm3
    public InterfaceC18740pA0 z() {
        return H().z();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbstractC5473Jm3(AbstractC16142km3 abstractC16142km3, String str, String str2, Object obj) {
        this(abstractC16142km3, str, str2, null, obj);
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC5473Jm3(AbstractC16142km3 abstractC16142km3, InterfaceC20989sw5 interfaceC20989sw5) {
        AbstractC13042fc3.i(abstractC16142km3, "container");
        AbstractC13042fc3.i(interfaceC20989sw5, "descriptor");
        String strH = interfaceC20989sw5.getName().h();
        AbstractC13042fc3.h(strH, "descriptor.name.asString()");
        this(abstractC16142km3, strH, A76.b.f(interfaceC20989sw5).a(), interfaceC20989sw5, AbstractC15785kA0.NO_RECEIVER);
    }
}
