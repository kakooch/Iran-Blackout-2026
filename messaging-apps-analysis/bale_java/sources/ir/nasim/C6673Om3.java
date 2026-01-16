package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.Om3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C6673Om3 implements InterfaceC6174Mm3 {
    static final /* synthetic */ InterfaceC5239Im3[] e = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C6673Om3.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C6673Om3.class), "arguments", "getArguments()Ljava/util/List;"))};
    private final AbstractC10266bM5.a a;
    private final AbstractC10266bM5.a b;
    private final AbstractC10266bM5.a c;
    private final AbstractC4099Dr3 d;

    /* renamed from: ir.nasim.Om3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.Om3$a$a, reason: collision with other inner class name */
        static final class C0560a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ int e;
            final /* synthetic */ a f;
            final /* synthetic */ InterfaceC9173Yu3 g;
            final /* synthetic */ InterfaceC5239Im3 h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0560a(int i, a aVar, InterfaceC9173Yu3 interfaceC9173Yu3, InterfaceC5239Im3 interfaceC5239Im3) {
                super(0);
                this.e = i;
                this.f = aVar;
                this.g = interfaceC9173Yu3;
                this.h = interfaceC5239Im3;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Type invoke() {
                Type typeB = C6673Om3.this.b();
                if (typeB instanceof Class) {
                    Class cls = (Class) typeB;
                    Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                    AbstractC13042fc3.h(componentType, "if (javaType.isArray) ja…Type else Any::class.java");
                    return componentType;
                }
                if (typeB instanceof GenericArrayType) {
                    if (this.e == 0) {
                        Type genericComponentType = ((GenericArrayType) typeB).getGenericComponentType();
                        AbstractC13042fc3.h(genericComponentType, "javaType.genericComponentType");
                        return genericComponentType;
                    }
                    throw new C25175zr3("Array type has been queried for a non-0th argument: " + C6673Om3.this);
                }
                if (!(typeB instanceof ParameterizedType)) {
                    throw new C25175zr3("Non-generic type has been queried for arguments: " + C6673Om3.this);
                }
                Type type = (Type) ((List) this.g.getValue()).get(this.e);
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    AbstractC13042fc3.h(lowerBounds, "argument.lowerBounds");
                    Type type2 = (Type) AbstractC10242bK.e0(lowerBounds);
                    if (type2 != null) {
                        type = type2;
                    } else {
                        Type[] upperBounds = wildcardType.getUpperBounds();
                        AbstractC13042fc3.h(upperBounds, "argument.upperBounds");
                        type = (Type) AbstractC10242bK.b0(upperBounds);
                    }
                }
                AbstractC13042fc3.h(type, "if (argument !is Wildcar…ument.upperBounds.first()");
                return type;
            }
        }

        /* renamed from: ir.nasim.Om3$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            public final List invoke() {
                Type typeB = C6673Om3.this.b();
                AbstractC13042fc3.f(typeB);
                return AbstractC21912uL5.e(typeB);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SA2 sa2) {
            super(0);
            this.f = sa2;
        }

        @Override // ir.nasim.SA2
        public final List invoke() {
            C7858Tm3 c7858Tm3D;
            List listJ0 = C6673Om3.this.i().J0();
            if (listJ0.isEmpty()) {
                return AbstractC10360bX0.m();
            }
            InterfaceC9173Yu3 interfaceC9173Yu3B = AbstractC13269fw3.b(EnumC4870Gx3.b, new b());
            List list = listJ0;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    AbstractC10360bX0.w();
                }
                InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) obj;
                if (interfaceC3932Cy7.b()) {
                    c7858Tm3D = C7858Tm3.c.c();
                } else {
                    AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
                    AbstractC13042fc3.h(type, "typeProjection.type");
                    C6673Om3 c6673Om3 = new C6673Om3(type, this.f != null ? new C0560a(i, this, interfaceC9173Yu3B, null) : null);
                    int i3 = AbstractC6413Nm3.a[interfaceC3932Cy7.c().ordinal()];
                    if (i3 == 1) {
                        c7858Tm3D = C7858Tm3.c.d(c6673Om3);
                    } else if (i3 == 2) {
                        c7858Tm3D = C7858Tm3.c.a(c6673Om3);
                    } else {
                        if (i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        c7858Tm3D = C7858Tm3.c.b(c6673Om3);
                    }
                }
                arrayList.add(c7858Tm3D);
                i = i2;
            }
            return arrayList;
        }
    }

    /* renamed from: ir.nasim.Om3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC14961im3 invoke() {
            C6673Om3 c6673Om3 = C6673Om3.this;
            return c6673Om3.h(c6673Om3.i());
        }
    }

    public C6673Om3(AbstractC4099Dr3 abstractC4099Dr3, SA2 sa2) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        this.d = abstractC4099Dr3;
        AbstractC10266bM5.a aVarC = null;
        AbstractC10266bM5.a aVar = (AbstractC10266bM5.a) (!(sa2 instanceof AbstractC10266bM5.a) ? null : sa2);
        if (aVar != null) {
            aVarC = aVar;
        } else if (sa2 != null) {
            aVarC = AbstractC10266bM5.c(sa2);
        }
        this.a = aVarC;
        this.b = AbstractC10266bM5.c(new b());
        this.c = AbstractC10266bM5.c(new a(sa2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC14961im3 h(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC4099Dr3 type;
        MU0 mu0D = abstractC4099Dr3.K0().d();
        if (!(mu0D instanceof InterfaceC21331tU0)) {
            if (mu0D instanceof InterfaceC22882vy7) {
                return new C7385Rm3(null, (InterfaceC22882vy7) mu0D);
            }
            if (!(mu0D instanceof InterfaceC7722Sx7)) {
                return null;
            }
            throw new C22420vC4("An operation is not implemented: Type alias classifiers are not yet supported");
        }
        Class clsM = AbstractC14729iN7.m((InterfaceC21331tU0) mu0D);
        if (clsM == null) {
            return null;
        }
        if (!clsM.isArray()) {
            if (AbstractC7497Ry7.l(abstractC4099Dr3)) {
                return new C12533em3(clsM);
            }
            Class clsF = AbstractC21912uL5.f(clsM);
            if (clsF != null) {
                clsM = clsF;
            }
            return new C12533em3(clsM);
        }
        InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) AbstractC15401jX0.X0(abstractC4099Dr3.J0());
        if (interfaceC3932Cy7 == null || (type = interfaceC3932Cy7.getType()) == null) {
            return new C12533em3(clsM);
        }
        AbstractC13042fc3.h(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
        InterfaceC14961im3 interfaceC14961im3H = h(type);
        if (interfaceC14961im3H != null) {
            return new C12533em3(AbstractC21912uL5.a(AbstractC4762Gl3.b(AbstractC8092Um3.a(interfaceC14961im3H))));
        }
        throw new C25175zr3("Cannot determine classifier for array element type: " + this);
    }

    @Override // ir.nasim.InterfaceC5941Lm3
    public InterfaceC14961im3 a() {
        return (InterfaceC14961im3) this.b.b(this, e[0]);
    }

    @Override // ir.nasim.InterfaceC6174Mm3
    public Type b() {
        AbstractC10266bM5.a aVar = this.a;
        if (aVar != null) {
            return (Type) aVar.invoke();
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC5941Lm3
    public List d() {
        return (List) this.c.b(this, e[1]);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C6673Om3) && AbstractC13042fc3.d(this.d, ((C6673Om3) obj).d);
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    public final AbstractC4099Dr3 i() {
        return this.d;
    }

    public String toString() {
        return C15307jM5.b.h(this.d);
    }

    public /* synthetic */ C6673Om3(AbstractC4099Dr3 abstractC4099Dr3, SA2 sa2, int i, ED1 ed1) {
        this(abstractC4099Dr3, (i & 2) != 0 ? null : sa2);
    }
}
