package ir.nasim;

import ir.nasim.AbstractC16253kx5;
import ir.nasim.AbstractC6165Ml3;
import ir.nasim.AbstractC7849Tl3;
import ir.nasim.C6526Nw5;
import ir.nasim.InterfaceC22805vr3;
import ir.nasim.Z24;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: classes8.dex */
public abstract class A0 implements InterfaceC17991nu {
    private final InterfaceC20347rr3 a;
    private final I34 b;

    private enum a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    private static final class b {
        private final Map a;
        private final Map b;

        public b(Map map, Map map2) {
            AbstractC13042fc3.i(map, "memberAnnotations");
            AbstractC13042fc3.i(map2, "propertyConstants");
            this.a = map;
            this.b = map2;
        }

        public final Map a() {
            return this.a;
        }

        public final Map b() {
            return this.b;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC11375cu.values().length];
            iArr[EnumC11375cu.PROPERTY_GETTER.ordinal()] = 1;
            iArr[EnumC11375cu.PROPERTY_SETTER.ordinal()] = 2;
            iArr[EnumC11375cu.PROPERTY.ordinal()] = 3;
            a = iArr;
        }
    }

    public static final class d implements InterfaceC22805vr3.d {
        final /* synthetic */ HashMap b;
        final /* synthetic */ HashMap c;

        public final class a extends b implements InterfaceC22805vr3.e {
            final /* synthetic */ d d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, Z24 z24) {
                super(dVar, z24);
                AbstractC13042fc3.i(dVar, "this$0");
                AbstractC13042fc3.i(z24, "signature");
                this.d = dVar;
            }

            @Override // ir.nasim.InterfaceC22805vr3.e
            public InterfaceC22805vr3.a b(int i, C24948zU0 c24948zU0, JH6 jh6) {
                AbstractC13042fc3.i(c24948zU0, "classId");
                AbstractC13042fc3.i(jh6, "source");
                Z24 z24E = Z24.b.e(d(), i);
                List arrayList = (List) this.d.b.get(z24E);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.d.b.put(z24E, arrayList);
                }
                return A0.this.x(c24948zU0, jh6, arrayList);
            }
        }

        public class b implements InterfaceC22805vr3.c {
            private final Z24 a;
            private final ArrayList b;
            final /* synthetic */ d c;

            public b(d dVar, Z24 z24) {
                AbstractC13042fc3.i(dVar, "this$0");
                AbstractC13042fc3.i(z24, "signature");
                this.c = dVar;
                this.a = z24;
                this.b = new ArrayList();
            }

            @Override // ir.nasim.InterfaceC22805vr3.c
            public void a() {
                if (!this.b.isEmpty()) {
                    this.c.b.put(this.a, this.b);
                }
            }

            @Override // ir.nasim.InterfaceC22805vr3.c
            public InterfaceC22805vr3.a c(C24948zU0 c24948zU0, JH6 jh6) {
                AbstractC13042fc3.i(c24948zU0, "classId");
                AbstractC13042fc3.i(jh6, "source");
                return A0.this.x(c24948zU0, jh6, this.b);
            }

            protected final Z24 d() {
                return this.a;
            }
        }

        d(HashMap map, HashMap map2) {
            this.b = map;
            this.c = map2;
        }

        @Override // ir.nasim.InterfaceC22805vr3.d
        public InterfaceC22805vr3.e a(C6432No4 c6432No4, String str) {
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(str, "desc");
            Z24.a aVar = Z24.b;
            String strH = c6432No4.h();
            AbstractC13042fc3.h(strH, "name.asString()");
            return new a(this, aVar.d(strH, str));
        }

        @Override // ir.nasim.InterfaceC22805vr3.d
        public InterfaceC22805vr3.c b(C6432No4 c6432No4, String str, Object obj) {
            Object objZ;
            AbstractC13042fc3.i(c6432No4, "name");
            AbstractC13042fc3.i(str, "desc");
            Z24.a aVar = Z24.b;
            String strH = c6432No4.h();
            AbstractC13042fc3.h(strH, "name.asString()");
            Z24 z24A = aVar.a(strH, str);
            if (obj != null && (objZ = A0.this.z(str, obj)) != null) {
                this.c.put(z24A, objZ);
            }
            return new b(this, z24A);
        }
    }

    static final class f extends AbstractC8614Ws3 implements UA2 {
        f() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final b invoke(InterfaceC22805vr3 interfaceC22805vr3) {
            AbstractC13042fc3.i(interfaceC22805vr3, "kotlinClass");
            return A0.this.y(interfaceC22805vr3);
        }
    }

    public A0(ON6 on6, InterfaceC20347rr3 interfaceC20347rr3) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(interfaceC20347rr3, "kotlinClassFinder");
        this.a = interfaceC20347rr3;
        this.b = on6.e(new f());
    }

    private final List A(AbstractC16253kx5 abstractC16253kx5, C9193Yw5 c9193Yw5, a aVar) {
        Boolean boolD = AbstractC5031Hp2.z.d(c9193Yw5.W());
        AbstractC13042fc3.h(boolD, "IS_CONST.get(proto.flags)");
        boolD.booleanValue();
        boolean zF = C8083Ul3.f(c9193Yw5);
        if (aVar == a.PROPERTY) {
            Z24 z24U = u(this, c9193Yw5, abstractC16253kx5.b(), abstractC16253kx5.d(), false, true, false, 40, null);
            return z24U == null ? AbstractC10360bX0.m() : o(this, abstractC16253kx5, z24U, true, false, boolD, zF, 8, null);
        }
        Z24 z24U2 = u(this, c9193Yw5, abstractC16253kx5.b(), abstractC16253kx5.d(), true, false, false, 48, null);
        if (z24U2 == null) {
            return AbstractC10360bX0.m();
        }
        return AbstractC20762sZ6.X(z24U2.a(), "$delegate", false, 2, null) != (aVar == a.DELEGATE_FIELD) ? AbstractC10360bX0.m() : n(abstractC16253kx5, z24U2, true, true, boolD, zF);
    }

    private final InterfaceC22805vr3 C(AbstractC16253kx5.a aVar) {
        JH6 jh6C = aVar.c();
        C23991xr3 c23991xr3 = jh6C instanceof C23991xr3 ? (C23991xr3) jh6C : null;
        if (c23991xr3 == null) {
            return null;
        }
        return c23991xr3.d();
    }

    private final int m(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar) {
        if (lVar instanceof C7950Tw5) {
            if (!AbstractC3921Cx5.d((C7950Tw5) lVar)) {
                return 0;
            }
        } else if (lVar instanceof C9193Yw5) {
            if (!AbstractC3921Cx5.e((C9193Yw5) lVar)) {
                return 0;
            }
        } else {
            if (!(lVar instanceof C6765Ow5)) {
                throw new UnsupportedOperationException(AbstractC13042fc3.q("Unsupported message: ", lVar.getClass()));
            }
            AbstractC16253kx5.a aVar = (AbstractC16253kx5.a) abstractC16253kx5;
            if (aVar.g() == C6526Nw5.c.ENUM_CLASS) {
                return 2;
            }
            if (!aVar.i()) {
                return 0;
            }
        }
        return 1;
    }

    private final List n(AbstractC16253kx5 abstractC16253kx5, Z24 z24, boolean z, boolean z2, Boolean bool, boolean z3) {
        List list;
        InterfaceC22805vr3 interfaceC22805vr3P = p(abstractC16253kx5, v(abstractC16253kx5, z, z2, bool, z3));
        return (interfaceC22805vr3P == null || (list = (List) ((b) this.b.invoke(interfaceC22805vr3P)).a().get(z24)) == null) ? AbstractC10360bX0.m() : list;
    }

    static /* synthetic */ List o(A0 a0, AbstractC16253kx5 abstractC16253kx5, Z24 z24, boolean z, boolean z2, Boolean bool, boolean z3, int i, Object obj) {
        if (obj == null) {
            return a0.n(abstractC16253kx5, z24, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final InterfaceC22805vr3 p(AbstractC16253kx5 abstractC16253kx5, InterfaceC22805vr3 interfaceC22805vr3) {
        if (interfaceC22805vr3 != null) {
            return interfaceC22805vr3;
        }
        if (abstractC16253kx5 instanceof AbstractC16253kx5.a) {
            return C((AbstractC16253kx5.a) abstractC16253kx5);
        }
        return null;
    }

    private final Z24 r(kotlin.reflect.jvm.internal.impl.protobuf.l lVar, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, EnumC11375cu enumC11375cu, boolean z) {
        if (lVar instanceof C6765Ow5) {
            Z24.a aVar = Z24.b;
            AbstractC6165Ml3.b bVarB = C8083Ul3.a.b((C6765Ow5) lVar, interfaceC6692Oo4, c7029Py7);
            if (bVarB == null) {
                return null;
            }
            return aVar.b(bVarB);
        }
        if (lVar instanceof C7950Tw5) {
            Z24.a aVar2 = Z24.b;
            AbstractC6165Ml3.b bVarE = C8083Ul3.a.e((C7950Tw5) lVar, interfaceC6692Oo4, c7029Py7);
            if (bVarE == null) {
                return null;
            }
            return aVar2.b(bVarE);
        }
        if (!(lVar instanceof C9193Yw5)) {
            return null;
        }
        h.f fVar = AbstractC7849Tl3.d;
        AbstractC13042fc3.h(fVar, "propertySignature");
        AbstractC7849Tl3.d dVar = (AbstractC7849Tl3.d) AbstractC15662jx5.a((h.d) lVar, fVar);
        if (dVar == null) {
            return null;
        }
        int i = c.a[enumC11375cu.ordinal()];
        if (i == 1) {
            if (!dVar.G()) {
                return null;
            }
            Z24.a aVar3 = Z24.b;
            AbstractC7849Tl3.c cVarC = dVar.C();
            AbstractC13042fc3.h(cVarC, "signature.getter");
            return aVar3.c(interfaceC6692Oo4, cVarC);
        }
        if (i != 2) {
            if (i != 3) {
                return null;
            }
            return t((C9193Yw5) lVar, interfaceC6692Oo4, c7029Py7, true, true, z);
        }
        if (!dVar.H()) {
            return null;
        }
        Z24.a aVar4 = Z24.b;
        AbstractC7849Tl3.c cVarD = dVar.D();
        AbstractC13042fc3.h(cVarD, "signature.setter");
        return aVar4.c(interfaceC6692Oo4, cVarD);
    }

    static /* synthetic */ Z24 s(A0 a0, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, EnumC11375cu enumC11375cu, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return a0.r(lVar, interfaceC6692Oo4, c7029Py7, enumC11375cu, z);
    }

    private final Z24 t(C9193Yw5 c9193Yw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, boolean z, boolean z2, boolean z3) {
        h.f fVar = AbstractC7849Tl3.d;
        AbstractC13042fc3.h(fVar, "propertySignature");
        AbstractC7849Tl3.d dVar = (AbstractC7849Tl3.d) AbstractC15662jx5.a(c9193Yw5, fVar);
        if (dVar == null) {
            return null;
        }
        if (z) {
            AbstractC6165Ml3.a aVarC = C8083Ul3.a.c(c9193Yw5, interfaceC6692Oo4, c7029Py7, z3);
            if (aVarC == null) {
                return null;
            }
            return Z24.b.b(aVarC);
        }
        if (!z2 || !dVar.J()) {
            return null;
        }
        Z24.a aVar = Z24.b;
        AbstractC7849Tl3.c cVarE = dVar.E();
        AbstractC13042fc3.h(cVarE, "signature.syntheticMethod");
        return aVar.c(interfaceC6692Oo4, cVarE);
    }

    static /* synthetic */ Z24 u(A0 a0, C9193Yw5 c9193Yw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if (obj == null) {
            return a0.t(c9193Yw5, interfaceC6692Oo4, c7029Py7, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final InterfaceC22805vr3 v(AbstractC16253kx5 abstractC16253kx5, boolean z, boolean z2, Boolean bool, boolean z3) {
        AbstractC16253kx5.a aVarH;
        if (z) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + abstractC16253kx5 + ')').toString());
            }
            if (abstractC16253kx5 instanceof AbstractC16253kx5.a) {
                AbstractC16253kx5.a aVar = (AbstractC16253kx5.a) abstractC16253kx5;
                if (aVar.g() == C6526Nw5.c.INTERFACE) {
                    InterfaceC20347rr3 interfaceC20347rr3 = this.a;
                    C24948zU0 c24948zU0D = aVar.e().d(C6432No4.p("DefaultImpls"));
                    AbstractC13042fc3.h(c24948zU0D, "container.classId.createNestedClassId(Name.identifier(JvmAbi.DEFAULT_IMPLS_CLASS_NAME))");
                    return AbstractC20938sr3.a(interfaceC20347rr3, c24948zU0D);
                }
            }
            if (bool.booleanValue() && (abstractC16253kx5 instanceof AbstractC16253kx5.b)) {
                JH6 jh6C = abstractC16253kx5.c();
                C6898Pl3 c6898Pl3 = jh6C instanceof C6898Pl3 ? (C6898Pl3) jh6C : null;
                C4996Hl3 c4996Hl3E = c6898Pl3 == null ? null : c6898Pl3.e();
                if (c4996Hl3E != null) {
                    InterfaceC20347rr3 interfaceC20347rr32 = this.a;
                    String strF = c4996Hl3E.f();
                    AbstractC13042fc3.h(strF, "facadeClassName.internalName");
                    C24948zU0 c24948zU0M = C24948zU0.m(new C9424Zw2(AbstractC20153rZ6.L(strF, '/', '.', false, 4, null)));
                    AbstractC13042fc3.h(c24948zU0M, "topLevel(FqName(facadeClassName.internalName.replace('/', '.')))");
                    return AbstractC20938sr3.a(interfaceC20347rr32, c24948zU0M);
                }
            }
        }
        if (z2 && (abstractC16253kx5 instanceof AbstractC16253kx5.a)) {
            AbstractC16253kx5.a aVar2 = (AbstractC16253kx5.a) abstractC16253kx5;
            if (aVar2.g() == C6526Nw5.c.COMPANION_OBJECT && (aVarH = aVar2.h()) != null && (aVarH.g() == C6526Nw5.c.CLASS || aVarH.g() == C6526Nw5.c.ENUM_CLASS || (z3 && (aVarH.g() == C6526Nw5.c.INTERFACE || aVarH.g() == C6526Nw5.c.ANNOTATION_CLASS)))) {
                return C(aVarH);
            }
        }
        if (!(abstractC16253kx5 instanceof AbstractC16253kx5.b) || !(abstractC16253kx5.c() instanceof C6898Pl3)) {
            return null;
        }
        JH6 jh6C2 = abstractC16253kx5.c();
        if (jh6C2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        }
        C6898Pl3 c6898Pl32 = (C6898Pl3) jh6C2;
        InterfaceC22805vr3 interfaceC22805vr3F = c6898Pl32.f();
        return interfaceC22805vr3F == null ? AbstractC20938sr3.a(this.a, c6898Pl32.d()) : interfaceC22805vr3F;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC22805vr3.a x(C24948zU0 c24948zU0, JH6 jh6, List list) {
        if (C23072wI6.a.a().contains(c24948zU0)) {
            return null;
        }
        return w(c24948zU0, jh6, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b y(InterfaceC22805vr3 interfaceC22805vr3) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        interfaceC22805vr3.a(new d(map, map2), q(interfaceC22805vr3));
        return new b(map, map2);
    }

    protected abstract Object B(C6266Mw5 c6266Mw5, InterfaceC6692Oo4 interfaceC6692Oo4);

    protected abstract Object D(Object obj);

    @Override // ir.nasim.InterfaceC17991nu
    public List a(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(lVar, "proto");
        AbstractC13042fc3.i(enumC11375cu, "kind");
        Z24 z24S = s(this, lVar, abstractC16253kx5.b(), abstractC16253kx5.d(), enumC11375cu, false, 16, null);
        return z24S != null ? o(this, abstractC16253kx5, Z24.b.e(z24S, 0), false, false, null, false, 60, null) : AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List b(AbstractC16253kx5 abstractC16253kx5, C7477Rw5 c7477Rw5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c7477Rw5, "proto");
        Z24.a aVar = Z24.b;
        String string = abstractC16253kx5.b().getString(c7477Rw5.J());
        CU0 cu0 = CU0.a;
        String strC = ((AbstractC16253kx5.a) abstractC16253kx5).e().c();
        AbstractC13042fc3.h(strC, "container as ProtoContainer.Class).classId.asString()");
        return o(this, abstractC16253kx5, aVar.a(string, CU0.b(strC)), false, false, null, false, 60, null);
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List c(C10647bx5 c10647bx5, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC13042fc3.i(c10647bx5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        Object objS = c10647bx5.s(AbstractC7849Tl3.f);
        AbstractC13042fc3.h(objS, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<C6266Mw5> iterable = (Iterable) objS;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        for (C6266Mw5 c6266Mw5 : iterable) {
            AbstractC13042fc3.h(c6266Mw5, "it");
            arrayList.add(B(c6266Mw5, interfaceC6692Oo4));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List d(AbstractC16253kx5 abstractC16253kx5, C9193Yw5 c9193Yw5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c9193Yw5, "proto");
        return A(abstractC16253kx5, c9193Yw5, a.DELEGATE_FIELD);
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List e(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(lVar, "proto");
        AbstractC13042fc3.i(enumC11375cu, "kind");
        if (enumC11375cu == EnumC11375cu.PROPERTY) {
            return A(abstractC16253kx5, (C9193Yw5) lVar, a.PROPERTY);
        }
        Z24 z24S = s(this, lVar, abstractC16253kx5.b(), abstractC16253kx5.d(), enumC11375cu, false, 16, null);
        return z24S == null ? AbstractC10360bX0.m() : o(this, abstractC16253kx5, z24S, false, false, null, false, 60, null);
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List f(AbstractC16253kx5.a aVar) {
        AbstractC13042fc3.i(aVar, "container");
        InterfaceC22805vr3 interfaceC22805vr3C = C(aVar);
        if (interfaceC22805vr3C == null) {
            throw new IllegalStateException(AbstractC13042fc3.q("Class for loading annotations is not found: ", aVar.a()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        interfaceC22805vr3C.b(new e(arrayList), q(interfaceC22805vr3C));
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List g(AbstractC16253kx5 abstractC16253kx5, kotlin.reflect.jvm.internal.impl.protobuf.l lVar, EnumC11375cu enumC11375cu, int i, C13280fx5 c13280fx5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(lVar, "callableProto");
        AbstractC13042fc3.i(enumC11375cu, "kind");
        AbstractC13042fc3.i(c13280fx5, "proto");
        Z24 z24S = s(this, lVar, abstractC16253kx5.b(), abstractC16253kx5.d(), enumC11375cu, false, 16, null);
        if (z24S == null) {
            return AbstractC10360bX0.m();
        }
        return o(this, abstractC16253kx5, Z24.b.e(z24S, i + m(abstractC16253kx5, lVar)), false, false, null, false, 60, null);
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List h(C12053dx5 c12053dx5, InterfaceC6692Oo4 interfaceC6692Oo4) {
        AbstractC13042fc3.i(c12053dx5, "proto");
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        Object objS = c12053dx5.s(AbstractC7849Tl3.h);
        AbstractC13042fc3.h(objS, "proto.getExtension(JvmProtoBuf.typeParameterAnnotation)");
        Iterable<C6266Mw5> iterable = (Iterable) objS;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(iterable, 10));
        for (C6266Mw5 c6266Mw5 : iterable) {
            AbstractC13042fc3.h(c6266Mw5, "it");
            arrayList.add(B(c6266Mw5, interfaceC6692Oo4));
        }
        return arrayList;
    }

    @Override // ir.nasim.InterfaceC17991nu
    public List i(AbstractC16253kx5 abstractC16253kx5, C9193Yw5 c9193Yw5) {
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c9193Yw5, "proto");
        return A(abstractC16253kx5, c9193Yw5, a.BACKING_FIELD);
    }

    @Override // ir.nasim.InterfaceC17991nu
    public Object j(AbstractC16253kx5 abstractC16253kx5, C9193Yw5 c9193Yw5, AbstractC4099Dr3 abstractC4099Dr3) {
        Object obj;
        AbstractC13042fc3.i(abstractC16253kx5, "container");
        AbstractC13042fc3.i(c9193Yw5, "proto");
        AbstractC13042fc3.i(abstractC4099Dr3, "expectedType");
        InterfaceC22805vr3 interfaceC22805vr3P = p(abstractC16253kx5, v(abstractC16253kx5, true, true, AbstractC5031Hp2.z.d(c9193Yw5.W()), C8083Ul3.f(c9193Yw5)));
        if (interfaceC22805vr3P == null) {
            return null;
        }
        Z24 z24R = r(c9193Yw5, abstractC16253kx5.b(), abstractC16253kx5.d(), EnumC11375cu.PROPERTY, interfaceC22805vr3P.c().d().d(C12867fJ1.b.a()));
        if (z24R == null || (obj = ((b) this.b.invoke(interfaceC22805vr3P)).b().get(z24R)) == null) {
            return null;
        }
        return C9584aC7.d(abstractC4099Dr3) ? D(obj) : obj;
    }

    protected byte[] q(InterfaceC22805vr3 interfaceC22805vr3) {
        AbstractC13042fc3.i(interfaceC22805vr3, "kotlinClass");
        return null;
    }

    protected abstract InterfaceC22805vr3.a w(C24948zU0 c24948zU0, JH6 jh6, List list);

    protected abstract Object z(String str, Object obj);

    public static final class e implements InterfaceC22805vr3.c {
        final /* synthetic */ ArrayList b;

        e(ArrayList arrayList) {
            this.b = arrayList;
        }

        @Override // ir.nasim.InterfaceC22805vr3.c
        public InterfaceC22805vr3.a c(C24948zU0 c24948zU0, JH6 jh6) {
            AbstractC13042fc3.i(c24948zU0, "classId");
            AbstractC13042fc3.i(jh6, "source");
            return A0.this.x(c24948zU0, jh6, this.b);
        }

        @Override // ir.nasim.InterfaceC22805vr3.c
        public void a() {
        }
    }
}
