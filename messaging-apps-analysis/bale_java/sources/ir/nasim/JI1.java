package ir.nasim;

import ir.nasim.FI1;
import ir.nasim.II1;
import ir.nasim.OU0;
import java.lang.reflect.Field;
import java.util.Set;

/* loaded from: classes8.dex */
public final class JI1 implements II1 {
    static final /* synthetic */ InterfaceC5239Im3[] X = {AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "withDefinedIn", "getWithDefinedIn()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "modifiers", "getModifiers()Ljava/util/Set;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "startFromName", "getStartFromName()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "debugMode", "getDebugMode()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "verbose", "getVerbose()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "unitReturnType", "getUnitReturnType()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "withoutReturnType", "getWithoutReturnType()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "enhancedTypes", "getEnhancedTypes()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderDefaultModality", "getRenderDefaultModality()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "receiverAfterName", "getReceiverAfterName()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), AbstractC10882cM5.f(new C5942Lm4(AbstractC10882cM5.b(JI1.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    private final AI5 A;
    private final AI5 B;
    private final AI5 C;
    private final AI5 D;
    private final AI5 E;
    private final AI5 F;
    private final AI5 G;
    private final AI5 H;
    private final AI5 I;
    private final AI5 J;
    private final AI5 K;
    private final AI5 L;
    private final AI5 M;
    private final AI5 N;
    private final AI5 O;
    private final AI5 P;
    private final AI5 Q;
    private final AI5 R;
    private final AI5 S;
    private final AI5 T;
    private final AI5 U;
    private final AI5 V;
    private final AI5 W;
    private boolean a;
    private final AI5 b = m0(OU0.c.a);
    private final AI5 c;
    private final AI5 d;
    private final AI5 e;
    private final AI5 f;
    private final AI5 g;
    private final AI5 h;
    private final AI5 i;
    private final AI5 j;
    private final AI5 k;
    private final AI5 l;
    private final AI5 m;
    private final AI5 n;
    private final AI5 o;
    private final AI5 p;
    private final AI5 q;
    private final AI5 r;
    private final AI5 s;
    private final AI5 t;
    private final AI5 u;
    private final AI5 v;
    private final AI5 w;
    private final AI5 x;
    private final AI5 y;
    private final AI5 z;

    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(InterfaceC24919zQ7 interfaceC24919zQ7) {
            AbstractC13042fc3.i(interfaceC24919zQ7, "it");
            return "...";
        }
    }

    public static final class b extends KG4 {
        final /* synthetic */ Object b;
        final /* synthetic */ JI1 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, Object obj2, JI1 ji1) {
            super(obj2);
            this.b = obj;
            this.c = ji1;
        }

        @Override // ir.nasim.KG4
        protected boolean d(InterfaceC5239Im3 interfaceC5239Im3, Object obj, Object obj2) {
            AbstractC13042fc3.i(interfaceC5239Im3, "property");
            if (this.c.k0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(abstractC4099Dr3, "it");
            return abstractC4099Dr3;
        }
    }

    public JI1() {
        Boolean bool = Boolean.TRUE;
        this.c = m0(bool);
        this.d = m0(bool);
        this.e = m0(HI1.c);
        Boolean bool2 = Boolean.FALSE;
        this.f = m0(bool2);
        this.g = m0(bool2);
        this.h = m0(bool2);
        this.i = m0(bool2);
        this.j = m0(bool2);
        this.k = m0(bool);
        this.l = m0(bool2);
        this.m = m0(bool2);
        this.n = m0(bool2);
        this.o = m0(bool);
        this.p = m0(bool);
        this.q = m0(bool2);
        this.r = m0(bool2);
        this.s = m0(bool2);
        this.t = m0(bool2);
        this.u = m0(bool2);
        this.v = m0(bool2);
        this.w = m0(bool2);
        this.x = m0(c.e);
        this.y = m0(a.e);
        this.z = m0(bool);
        this.A = m0(PN4.RENDER_OPEN);
        this.B = m0(FI1.l.a.a);
        this.C = m0(CO5.PLAIN);
        this.D = m0(EnumC18351oW4.ALL);
        this.E = m0(bool2);
        this.F = m0(bool2);
        this.G = m0(EnumC20399rw5.DEBUG);
        this.H = m0(bool2);
        this.I = m0(bool2);
        this.J = m0(AbstractC4597Fu6.d());
        this.K = m0(C8235Vc2.a.a());
        this.L = m0(null);
        this.M = m0(EnumC19173pu.NO_ARGUMENTS);
        this.N = m0(bool2);
        this.O = m0(bool);
        this.P = m0(bool);
        this.Q = m0(bool2);
        this.R = m0(bool);
        this.S = m0(bool);
        this.T = m0(bool2);
        this.U = m0(bool2);
        this.V = m0(bool2);
        this.W = m0(bool);
    }

    private final AI5 m0(Object obj) {
        QG1 qg1 = QG1.a;
        return new b(obj, obj, this);
    }

    public Set A() {
        return (Set) this.J.a(this, X[34]);
    }

    public boolean B() {
        return ((Boolean) this.R.a(this, X[42])).booleanValue();
    }

    public boolean C() {
        return II1.a.a(this);
    }

    public boolean D() {
        return II1.a.b(this);
    }

    public boolean E() {
        return ((Boolean) this.u.a(this, X[19])).booleanValue();
    }

    public boolean F() {
        return ((Boolean) this.W.a(this, X[47])).booleanValue();
    }

    public Set G() {
        return (Set) this.e.a(this, X[3]);
    }

    public boolean H() {
        return ((Boolean) this.n.a(this, X[12])).booleanValue();
    }

    public PN4 I() {
        return (PN4) this.A.a(this, X[25]);
    }

    public EnumC18351oW4 J() {
        return (EnumC18351oW4) this.D.a(this, X[28]);
    }

    public boolean K() {
        return ((Boolean) this.S.a(this, X[43])).booleanValue();
    }

    public EnumC20399rw5 L() {
        return (EnumC20399rw5) this.G.a(this, X[31]);
    }

    public boolean M() {
        return ((Boolean) this.E.a(this, X[29])).booleanValue();
    }

    public boolean N() {
        return ((Boolean) this.F.a(this, X[30])).booleanValue();
    }

    public boolean O() {
        return ((Boolean) this.q.a(this, X[15])).booleanValue();
    }

    public boolean P() {
        return ((Boolean) this.O.a(this, X[39])).booleanValue();
    }

    public boolean Q() {
        return ((Boolean) this.H.a(this, X[32])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.p.a(this, X[14])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.o.a(this, X[13])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.r.a(this, X[16])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.Q.a(this, X[41])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.P.a(this, X[40])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.z.a(this, X[24])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.g.a(this, X[5])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.f.a(this, X[4])).booleanValue();
    }

    public CO5 Z() {
        return (CO5) this.C.a(this, X[27]);
    }

    @Override // ir.nasim.II1
    public void a(boolean z) {
        this.f.b(this, X[4], Boolean.valueOf(z));
    }

    public UA2 a0() {
        return (UA2) this.x.a(this, X[22]);
    }

    @Override // ir.nasim.II1
    public void b(boolean z) {
        this.c.b(this, X[1], Boolean.valueOf(z));
    }

    public boolean b0() {
        return ((Boolean) this.t.a(this, X[18])).booleanValue();
    }

    @Override // ir.nasim.II1
    public boolean c() {
        return ((Boolean) this.m.a(this, X[11])).booleanValue();
    }

    public boolean c0() {
        return ((Boolean) this.k.a(this, X[9])).booleanValue();
    }

    @Override // ir.nasim.II1
    public void d(EnumC18351oW4 enumC18351oW4) {
        AbstractC13042fc3.i(enumC18351oW4, "<set-?>");
        this.D.b(this, X[28], enumC18351oW4);
    }

    public FI1.l d0() {
        return (FI1.l) this.B.a(this, X[26]);
    }

    @Override // ir.nasim.II1
    public void e(boolean z) {
        this.w.b(this, X[21], Boolean.valueOf(z));
    }

    public boolean e0() {
        return ((Boolean) this.j.a(this, X[8])).booleanValue();
    }

    @Override // ir.nasim.II1
    public void f(boolean z) {
        this.E.b(this, X[29], Boolean.valueOf(z));
    }

    public boolean f0() {
        return ((Boolean) this.c.a(this, X[1])).booleanValue();
    }

    @Override // ir.nasim.II1
    public void g(CO5 co5) {
        AbstractC13042fc3.i(co5, "<set-?>");
        this.C.b(this, X[27], co5);
    }

    public boolean g0() {
        return ((Boolean) this.d.a(this, X[2])).booleanValue();
    }

    @Override // ir.nasim.II1
    public void h(OU0 ou0) {
        AbstractC13042fc3.i(ou0, "<set-?>");
        this.b.b(this, X[0], ou0);
    }

    public boolean h0() {
        return ((Boolean) this.l.a(this, X[10])).booleanValue();
    }

    @Override // ir.nasim.II1
    public Set i() {
        return (Set) this.K.a(this, X[35]);
    }

    public boolean i0() {
        return ((Boolean) this.w.a(this, X[21])).booleanValue();
    }

    @Override // ir.nasim.II1
    public boolean j() {
        return ((Boolean) this.h.a(this, X[6])).booleanValue();
    }

    public boolean j0() {
        return ((Boolean) this.v.a(this, X[20])).booleanValue();
    }

    @Override // ir.nasim.II1
    public EnumC19173pu k() {
        return (EnumC19173pu) this.M.a(this, X[37]);
    }

    public final boolean k0() {
        return this.a;
    }

    @Override // ir.nasim.II1
    public void l(Set set) {
        AbstractC13042fc3.i(set, "<set-?>");
        this.K.b(this, X[35], set);
    }

    public final void l0() {
        this.a = true;
    }

    @Override // ir.nasim.II1
    public void m(Set set) {
        AbstractC13042fc3.i(set, "<set-?>");
        this.e.b(this, X[3], set);
    }

    @Override // ir.nasim.II1
    public void n(boolean z) {
        this.h.b(this, X[6], Boolean.valueOf(z));
    }

    @Override // ir.nasim.II1
    public void o(boolean z) {
        this.F.b(this, X[30], Boolean.valueOf(z));
    }

    @Override // ir.nasim.II1
    public void p(EnumC19173pu enumC19173pu) {
        AbstractC13042fc3.i(enumC19173pu, "<set-?>");
        this.M.b(this, X[37], enumC19173pu);
    }

    @Override // ir.nasim.II1
    public void q(boolean z) {
        this.v.b(this, X[20], Boolean.valueOf(z));
    }

    public final JI1 r() {
        JI1 ji1 = new JI1();
        Field[] declaredFields = JI1.class.getDeclaredFields();
        AbstractC13042fc3.h(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i = 0;
        while (i < length) {
            Field field = declaredFields[i];
            i++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                KG4 kg4 = obj instanceof KG4 ? (KG4) obj : null;
                if (kg4 != null) {
                    String name = field.getName();
                    AbstractC13042fc3.h(name, "field.name");
                    AbstractC20153rZ6.S(name, "is", false, 2, null);
                    InterfaceC11299cm3 interfaceC11299cm3B = AbstractC10882cM5.b(JI1.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    AbstractC13042fc3.h(name3, "field.name");
                    field.set(ji1, ji1.m0(kg4.a(this, new C25226zw5(interfaceC11299cm3B, name2, AbstractC13042fc3.q("get", AbstractC20153rZ6.t(name3))))));
                }
            }
        }
        return ji1;
    }

    public boolean s() {
        return ((Boolean) this.s.a(this, X[17])).booleanValue();
    }

    public boolean t() {
        return ((Boolean) this.N.a(this, X[38])).booleanValue();
    }

    public UA2 u() {
        return (UA2) this.L.a(this, X[36]);
    }

    public boolean v() {
        return ((Boolean) this.V.a(this, X[46])).booleanValue();
    }

    public boolean w() {
        return ((Boolean) this.i.a(this, X[7])).booleanValue();
    }

    public OU0 x() {
        return (OU0) this.b.a(this, X[0]);
    }

    public UA2 y() {
        return (UA2) this.y.a(this, X[23]);
    }

    public boolean z() {
        return ((Boolean) this.I.a(this, X[33])).booleanValue();
    }
}
