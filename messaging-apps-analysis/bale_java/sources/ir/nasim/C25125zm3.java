package ir.nasim;

import ir.nasim.AbstractC10266bM5;
import ir.nasim.AbstractC16142km3;
import ir.nasim.W24;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* renamed from: ir.nasim.zm3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C25125zm3 extends AbstractC16142km3 {
    private final AbstractC10266bM5.b d;
    private final Class e;
    private final String f;

    /* renamed from: ir.nasim.zm3$a */
    private final class a extends AbstractC16142km3.b {
        static final /* synthetic */ InterfaceC5239Im3[] j = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(a.class), "metadata", "getMetadata()Lkotlin/Triple;")), AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(a.class), "members", "getMembers()Ljava/util/Collection;"))};
        private final AbstractC10266bM5.a d;
        private final AbstractC10266bM5.a e;
        private final AbstractC10266bM5.b f;
        private final AbstractC10266bM5.b g;
        private final AbstractC10266bM5.a h;

        /* renamed from: ir.nasim.zm3$a$a, reason: collision with other inner class name */
        static final class C1822a extends AbstractC8614Ws3 implements SA2 {
            C1822a() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final WL5 invoke() {
                return WL5.c.a(C25125zm3.this.e());
            }
        }

        /* renamed from: ir.nasim.zm3$a$b */
        static final class b extends AbstractC8614Ws3 implements SA2 {
            b() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Collection invoke() {
                a aVar = a.this;
                return C25125zm3.this.y(aVar.f(), AbstractC16142km3.c.DECLARED);
            }
        }

        /* renamed from: ir.nasim.zm3$a$c */
        static final class c extends AbstractC8614Ws3 implements SA2 {
            c() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final C17428mw7 invoke() {
                C21625tr3 c21625tr3C;
                WL5 wl5C = a.this.c();
                if (wl5C == null || (c21625tr3C = wl5C.c()) == null) {
                    return null;
                }
                String[] strArrA = c21625tr3C.a();
                String[] strArrG = c21625tr3C.g();
                if (strArrA == null || strArrG == null) {
                    return null;
                }
                XV4 xv4M = C8083Ul3.m(strArrA, strArrG);
                return new C17428mw7((C6664Ol3) xv4M.a(), (C8652Ww5) xv4M.b(), c21625tr3C.d());
            }
        }

        /* renamed from: ir.nasim.zm3$a$d */
        static final class d extends AbstractC8614Ws3 implements SA2 {
            d() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Class invoke() {
                C21625tr3 c21625tr3C;
                WL5 wl5C = a.this.c();
                String strE = (wl5C == null || (c21625tr3C = wl5C.c()) == null) ? null : c21625tr3C.e();
                if (strE == null || strE.length() <= 0) {
                    return null;
                }
                return C25125zm3.this.e().getClassLoader().loadClass(AbstractC20153rZ6.L(strE, '/', '.', false, 4, null));
            }
        }

        /* renamed from: ir.nasim.zm3$a$e */
        static final class e extends AbstractC8614Ws3 implements SA2 {
            e() {
                super(0);
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final W24 invoke() {
                WL5 wl5C = a.this.c();
                return wl5C != null ? a.this.a().c().a(wl5C) : W24.b.b;
            }
        }

        public a() {
            super();
            this.d = AbstractC10266bM5.c(new C1822a());
            this.e = AbstractC10266bM5.c(new e());
            this.f = AbstractC10266bM5.b(new d());
            this.g = AbstractC10266bM5.b(new c());
            this.h = AbstractC10266bM5.c(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final WL5 c() {
            return (WL5) this.d.b(this, j[0]);
        }

        public final C17428mw7 d() {
            return (C17428mw7) this.g.b(this, j[3]);
        }

        public final Class e() {
            return (Class) this.f.b(this, j[2]);
        }

        public final W24 f() {
            return (W24) this.e.b(this, j[1]);
        }
    }

    /* renamed from: ir.nasim.zm3$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        b() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return C25125zm3.this.new a();
        }
    }

    /* renamed from: ir.nasim.zm3$c */
    static final /* synthetic */ class c extends DB2 implements InterfaceC14603iB2 {
        public static final c a = new c();

        c() {
            super(2);
        }

        @Override // ir.nasim.AbstractC15785kA0, ir.nasim.InterfaceC9916am3
        public final String getName() {
            return "loadProperty";
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final InterfaceC15551jm3 getOwner() {
            return AbstractC10882cM5.b(C21732u24.class);
        }

        @Override // ir.nasim.AbstractC15785kA0
        public final String getSignature() {
            return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final InterfaceC20989sw5 invoke(C21732u24 c21732u24, C9193Yw5 c9193Yw5) {
            AbstractC13042fc3.i(c21732u24, "p1");
            AbstractC13042fc3.i(c9193Yw5, "p2");
            return c21732u24.p(c9193Yw5);
        }
    }

    public C25125zm3(Class cls, String str) {
        AbstractC13042fc3.i(cls, "jClass");
        this.e = cls;
        this.f = str;
        AbstractC10266bM5.b bVarB = AbstractC10266bM5.b(new b());
        AbstractC13042fc3.h(bVarB, "ReflectProperties.lazy { Data() }");
        this.d = bVarB;
    }

    private final W24 H() {
        return ((a) this.d.invoke()).f();
    }

    @Override // ir.nasim.AbstractC16142km3
    public Collection A(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        return H().b(c6432No4, FA4.FROM_REFLECTION);
    }

    @Override // ir.nasim.InterfaceC17738nU0
    public Class e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C25125zm3) && AbstractC13042fc3.d(e(), ((C25125zm3) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    @Override // ir.nasim.AbstractC16142km3
    public Collection t() {
        return AbstractC10360bX0.m();
    }

    public String toString() {
        return "file class " + AbstractC21912uL5.b(e()).b();
    }

    @Override // ir.nasim.AbstractC16142km3
    public Collection v(C6432No4 c6432No4) {
        AbstractC13042fc3.i(c6432No4, "name");
        return H().d(c6432No4, FA4.FROM_REFLECTION);
    }

    @Override // ir.nasim.AbstractC16142km3
    public InterfaceC20989sw5 x(int i) {
        C17428mw7 c17428mw7D = ((a) this.d.invoke()).d();
        if (c17428mw7D == null) {
            return null;
        }
        C6664Ol3 c6664Ol3 = (C6664Ol3) c17428mw7D.a();
        C8652Ww5 c8652Ww5 = (C8652Ww5) c17428mw7D.b();
        C6404Nl3 c6404Nl3 = (C6404Nl3) c17428mw7D.c();
        h.f fVar = AbstractC7849Tl3.n;
        AbstractC13042fc3.h(fVar, "JvmProtoBuf.packageLocalVariable");
        C9193Yw5 c9193Yw5 = (C9193Yw5) AbstractC15662jx5.b(c8652Ww5, fVar, i);
        if (c9193Yw5 == null) {
            return null;
        }
        Class clsE = e();
        C12644ex5 c12644ex5Z = c8652Ww5.Z();
        AbstractC13042fc3.h(c12644ex5Z, "packageProto.typeTable");
        return (InterfaceC20989sw5) AbstractC14729iN7.e(clsE, c9193Yw5, c6664Ol3, new C7029Py7(c12644ex5Z), c6404Nl3, c.a);
    }

    @Override // ir.nasim.AbstractC16142km3
    protected Class z() {
        Class clsE = ((a) this.d.invoke()).e();
        return clsE != null ? clsE : e();
    }
}
