package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.oC6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C18173oC6 {
    private final C25201zu a;
    private final C7115Qi3 b;
    private final C6871Pi3 c;

    /* renamed from: ir.nasim.oC6$a */
    private static class a {
        private final AbstractC4099Dr3 a;
        private final boolean b;
        private final boolean c;

        public a(AbstractC4099Dr3 abstractC4099Dr3, boolean z, boolean z2) {
            AbstractC13042fc3.i(abstractC4099Dr3, "type");
            this.a = abstractC4099Dr3;
            this.b = z;
            this.c = z2;
        }

        public final boolean a() {
            return this.c;
        }

        public final AbstractC4099Dr3 b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.oC6$c */
    private static final class c extends a {
        private final boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbstractC4099Dr3 abstractC4099Dr3, boolean z, boolean z2, boolean z3) {
            super(abstractC4099Dr3, z2, z3);
            AbstractC13042fc3.i(abstractC4099Dr3, "type");
            this.d = z;
        }

        public final boolean d() {
            return this.d;
        }
    }

    /* renamed from: ir.nasim.oC6$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            ZI5 zi5Q = interfaceC15194jA0.Q();
            AbstractC13042fc3.f(zi5Q);
            AbstractC4099Dr3 type = zi5Q.getType();
            AbstractC13042fc3.h(type, "it.extensionReceiverParameter!!.type");
            return type;
        }
    }

    /* renamed from: ir.nasim.oC6$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        public static final e e = new e();

        e() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            AbstractC4099Dr3 returnType = interfaceC15194jA0.getReturnType();
            AbstractC13042fc3.f(returnType);
            return returnType;
        }
    }

    /* renamed from: ir.nasim.oC6$f */
    static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ InterfaceC24919zQ7 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC24919zQ7 interfaceC24919zQ7) {
            super(1);
            this.e = interfaceC24919zQ7;
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke(InterfaceC15194jA0 interfaceC15194jA0) {
            AbstractC13042fc3.i(interfaceC15194jA0, "it");
            AbstractC4099Dr3 type = ((InterfaceC24919zQ7) interfaceC15194jA0.h().get(this.e.getIndex())).getType();
            AbstractC13042fc3.h(type, "it.valueParameters[p.index].type");
            return type;
        }
    }

    /* renamed from: ir.nasim.oC6$g */
    static final class g extends AbstractC8614Ws3 implements UA2 {
        public static final g e = new g();

        g() {
            super(1);
        }

        public final boolean a(AbstractC18174oC7 abstractC18174oC7) {
            AbstractC13042fc3.i(abstractC18174oC7, "it");
            return abstractC18174oC7 instanceof EG5;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Boolean.valueOf(a((AbstractC18174oC7) obj));
        }
    }

    public C18173oC6(C25201zu c25201zu, C7115Qi3 c7115Qi3, C6871Pi3 c6871Pi3) {
        AbstractC13042fc3.i(c25201zu, "annotationTypeQualifierResolver");
        AbstractC13042fc3.i(c7115Qi3, "javaTypeEnhancementState");
        AbstractC13042fc3.i(c6871Pi3, "typeEnhancement");
        this.a = c25201zu;
        this.b = c7115Qi3;
        this.c = c6871Pi3;
    }

    private final C14645iF4 c(C9424Zw2 c9424Zw2, InterfaceC21651tu interfaceC21651tu, boolean z) {
        if (AbstractC25115zl3.l().contains(c9424Zw2)) {
            return new C14645iF4(EnumC14043hF4.NULLABLE, z);
        }
        if (AbstractC25115zl3.k().contains(c9424Zw2)) {
            return new C14645iF4(EnumC14043hF4.NOT_NULL, z);
        }
        if (AbstractC13042fc3.d(c9424Zw2, AbstractC25115zl3.f())) {
            return j(interfaceC21651tu, z);
        }
        if (AbstractC13042fc3.d(c9424Zw2, AbstractC25115zl3.d()) && this.b.c()) {
            return new C14645iF4(EnumC14043hF4.NULLABLE, z);
        }
        if (AbstractC13042fc3.d(c9424Zw2, AbstractC25115zl3.c()) && this.b.c()) {
            return new C14645iF4(EnumC14043hF4.NOT_NULL, z);
        }
        if (AbstractC13042fc3.d(c9424Zw2, AbstractC25115zl3.a())) {
            return new C14645iF4(EnumC14043hF4.NOT_NULL, true);
        }
        if (AbstractC13042fc3.d(c9424Zw2, AbstractC25115zl3.b())) {
            return new C14645iF4(EnumC14043hF4.NULLABLE, true);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final ir.nasim.InterfaceC15194jA0 d(ir.nasim.InterfaceC15194jA0 r17, ir.nasim.C9182Yv3 r18) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18173oC6.d(ir.nasim.jA0, ir.nasim.Yv3):ir.nasim.jA0");
    }

    private final C14645iF4 i(InterfaceC21651tu interfaceC21651tu, boolean z, boolean z2) {
        C9424Zw2 c9424Zw2E = interfaceC21651tu.e();
        if (c9424Zw2E == null) {
            return null;
        }
        boolean z3 = (interfaceC21651tu instanceof C7232Qv3) && (((C7232Qv3) interfaceC21651tu).l() || z2) && !z;
        C14645iF4 c14645iF4L = l(c9424Zw2E);
        if (c14645iF4L == null && (c14645iF4L = c(c9424Zw2E, interfaceC21651tu, z3)) == null) {
            return null;
        }
        return (!c14645iF4L.d() && (interfaceC21651tu instanceof InterfaceC9301Zi5) && ((InterfaceC9301Zi5) interfaceC21651tu).g()) ? C14645iF4.b(c14645iF4L, null, true, 1, null) : c14645iF4L;
    }

    private final C14645iF4 j(InterfaceC21651tu interfaceC21651tu, boolean z) {
        AbstractC7068Qd1 abstractC7068Qd1B = PI1.b(interfaceC21651tu);
        N92 n92 = abstractC7068Qd1B instanceof N92 ? (N92) abstractC7068Qd1B : null;
        if (n92 == null) {
            return new C14645iF4(EnumC14043hF4.NOT_NULL, z);
        }
        String strH = n92.c().h();
        switch (strH.hashCode()) {
            case 73135176:
                if (!strH.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!strH.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (strH.equals("UNKNOWN")) {
                    return new C14645iF4(EnumC14043hF4.FORCE_FLEXIBILITY, z);
                }
                return null;
            case 1933739535:
                if (strH.equals("ALWAYS")) {
                    return new C14645iF4(EnumC14043hF4.NOT_NULL, z);
                }
                return null;
            default:
                return null;
        }
        return new C14645iF4(EnumC14043hF4.NULLABLE, z);
    }

    private final boolean k(InterfaceC24919zQ7 interfaceC24919zQ7, AbstractC4099Dr3 abstractC4099Dr3) {
        boolean zY0;
        AbstractC20964su abstractC20964suB = AbstractC14118hN7.b(interfaceC24919zQ7);
        if (abstractC20964suB instanceof FY6) {
            zY0 = AbstractC22522vN7.a(abstractC4099Dr3, ((FY6) abstractC20964suB).a()) != null;
        } else if (AbstractC13042fc3.d(abstractC20964suB, C10202bF4.a)) {
            zY0 = AbstractC7497Ry7.b(abstractC4099Dr3);
        } else {
            if (abstractC20964suB != null) {
                throw new NoWhenBranchMatchedException();
            }
            zY0 = interfaceC24919zQ7.y0();
        }
        return zY0 && interfaceC24919zQ7.d().isEmpty();
    }

    private final C14645iF4 l(C9424Zw2 c9424Zw2) {
        if (this.b.e() == EnumC23724xP5.IGNORE) {
            return null;
        }
        boolean z = this.b.e() == EnumC23724xP5.WARN;
        if (AbstractC13042fc3.d(c9424Zw2, AbstractC25115zl3.h())) {
            return new C14645iF4(EnumC14043hF4.NULLABLE, z);
        }
        if (AbstractC13042fc3.d(c9424Zw2, AbstractC25115zl3.i())) {
            return new C14645iF4(EnumC14043hF4.FORCE_FLEXIBILITY, z);
        }
        return null;
    }

    private final b m(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC10612bu interfaceC10612bu, boolean z, C9182Yv3 c9182Yv3, EnumC23427wu enumC23427wu, UA2 ua2) {
        AbstractC4099Dr3 abstractC4099Dr3 = (AbstractC4099Dr3) ua2.invoke(interfaceC15194jA0);
        Collection collectionD = interfaceC15194jA0.d();
        AbstractC13042fc3.h(collectionD, "this.overriddenDescriptors");
        Collection<InterfaceC15194jA0> collection = collectionD;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection, 10));
        for (InterfaceC15194jA0 interfaceC15194jA02 : collection) {
            AbstractC13042fc3.h(interfaceC15194jA02, "it");
            arrayList.add((AbstractC4099Dr3) ua2.invoke(interfaceC15194jA02));
        }
        return new b(interfaceC10612bu, abstractC4099Dr3, arrayList, z, AbstractC4760Gl1.h(c9182Yv3, ((AbstractC4099Dr3) ua2.invoke(interfaceC15194jA0)).getAnnotations()), enumC23427wu, false, 64, null);
    }

    private final b n(InterfaceC15194jA0 interfaceC15194jA0, InterfaceC24919zQ7 interfaceC24919zQ7, C9182Yv3 c9182Yv3, UA2 ua2) {
        C9182Yv3 c9182Yv3H;
        return m(interfaceC15194jA0, interfaceC24919zQ7, false, (interfaceC24919zQ7 == null || (c9182Yv3H = AbstractC4760Gl1.h(c9182Yv3, interfaceC24919zQ7.getAnnotations())) == null) ? c9182Yv3 : c9182Yv3H, EnumC23427wu.VALUE_PARAMETER, ua2);
    }

    public final Collection e(C9182Yv3 c9182Yv3, Collection collection) {
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(collection, "platformSignatures");
        Collection collection2 = collection;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection2, 10));
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(d((InterfaceC15194jA0) it.next(), c9182Yv3));
        }
        return arrayList;
    }

    public final AbstractC4099Dr3 f(AbstractC4099Dr3 abstractC4099Dr3, C9182Yv3 c9182Yv3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "type");
        AbstractC13042fc3.i(c9182Yv3, "context");
        return b.f(new b(null, abstractC4099Dr3, AbstractC10360bX0.m(), false, c9182Yv3, EnumC23427wu.TYPE_USE, false, 64, null), null, 1, null).b();
    }

    public final List g(InterfaceC22882vy7 interfaceC22882vy7, List list, C9182Yv3 c9182Yv3) {
        AbstractC13042fc3.i(interfaceC22882vy7, "typeParameter");
        AbstractC13042fc3.i(list, "bounds");
        AbstractC13042fc3.i(c9182Yv3, "context");
        List<AbstractC4099Dr3> list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        for (AbstractC4099Dr3 abstractC4099Dr3B : list2) {
            if (!AbstractC7731Sy7.b(abstractC4099Dr3B, g.e)) {
                abstractC4099Dr3B = b.f(new b(this, interfaceC22882vy7, abstractC4099Dr3B, AbstractC10360bX0.m(), false, c9182Yv3, EnumC23427wu.TYPE_PARAMETER_BOUNDS, true), null, 1, null).b();
            }
            arrayList.add(abstractC4099Dr3B);
        }
        return arrayList;
    }

    public final C14645iF4 h(InterfaceC21651tu interfaceC21651tu, boolean z, boolean z2) {
        C14645iF4 c14645iF4I;
        AbstractC13042fc3.i(interfaceC21651tu, "annotationDescriptor");
        C14645iF4 c14645iF4I2 = i(interfaceC21651tu, z, z2);
        if (c14645iF4I2 != null) {
            return c14645iF4I2;
        }
        InterfaceC21651tu interfaceC21651tuM = this.a.m(interfaceC21651tu);
        if (interfaceC21651tuM == null) {
            return null;
        }
        EnumC23724xP5 enumC23724xP5J = this.a.j(interfaceC21651tu);
        if (enumC23724xP5J.j() || (c14645iF4I = i(interfaceC21651tuM, z, z2)) == null) {
            return null;
        }
        return C14645iF4.b(c14645iF4I, null, enumC23724xP5J.p(), 1, null);
    }

    /* renamed from: ir.nasim.oC6$b */
    private final class b {
        private final InterfaceC10612bu a;
        private final AbstractC4099Dr3 b;
        private final Collection c;
        private final boolean d;
        private final C9182Yv3 e;
        private final EnumC23427wu f;
        private final boolean g;

        /* renamed from: ir.nasim.oC6$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C8056Ui3[] e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C8056Ui3[] c8056Ui3Arr) {
                super(1);
                this.e = c8056Ui3Arr;
            }

            public final C8056Ui3 a(int i) {
                C8056Ui3[] c8056Ui3Arr = this.e;
                return (i < 0 || i > AbstractC10242bK.l0(c8056Ui3Arr)) ? C8056Ui3.e.a() : c8056Ui3Arr[i];
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        /* renamed from: ir.nasim.oC6$b$b, reason: collision with other inner class name */
        static final class C1420b extends AbstractC8614Ws3 implements UA2 {
            public static final C1420b e = new C1420b();

            C1420b() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AbstractC18174oC7 abstractC18174oC7) {
                MU0 mu0T = abstractC18174oC7.K0().t();
                if (mu0T == null) {
                    return Boolean.FALSE;
                }
                C6432No4 name = mu0T.getName();
                C5203Ii3 c5203Ii3 = C5203Ii3.a;
                return Boolean.valueOf(AbstractC13042fc3.d(name, c5203Ii3.i().g()) && AbstractC13042fc3.d(PI1.e(mu0T), c5203Ii3.i()));
            }
        }

        /* renamed from: ir.nasim.oC6$b$c */
        static final class c extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ C17446my7 e;
            final /* synthetic */ UA2 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(C17446my7 c17446my7, UA2 ua2) {
                super(1);
                this.e = c17446my7;
                this.f = ua2;
            }

            public final C8056Ui3 a(int i) {
                C8056Ui3 c8056Ui3 = (C8056Ui3) this.e.a().get(Integer.valueOf(i));
                return c8056Ui3 == null ? (C8056Ui3) this.f.invoke(Integer.valueOf(i)) : c8056Ui3;
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        public b(C18173oC6 c18173oC6, InterfaceC10612bu interfaceC10612bu, AbstractC4099Dr3 abstractC4099Dr3, Collection collection, boolean z, C9182Yv3 c9182Yv3, EnumC23427wu enumC23427wu, boolean z2) {
            AbstractC13042fc3.i(c18173oC6, "this$0");
            AbstractC13042fc3.i(abstractC4099Dr3, "fromOverride");
            AbstractC13042fc3.i(collection, "fromOverridden");
            AbstractC13042fc3.i(c9182Yv3, "containerContext");
            AbstractC13042fc3.i(enumC23427wu, "containerApplicabilityType");
            C18173oC6.this = c18173oC6;
            this.a = interfaceC10612bu;
            this.b = abstractC4099Dr3;
            this.c = collection;
            this.d = z;
            this.e = c9182Yv3;
            this.f = enumC23427wu;
            this.g = z2;
        }

        private final EnumC14043hF4 a(InterfaceC22882vy7 interfaceC22882vy7) {
            if (!(interfaceC22882vy7 instanceof C11399cw3)) {
                return null;
            }
            C11399cw3 c11399cw3 = (C11399cw3) interfaceC22882vy7;
            List upperBounds = c11399cw3.getUpperBounds();
            AbstractC13042fc3.h(upperBounds, "upperBounds");
            List list = upperBounds;
            if ((list instanceof Collection) && list.isEmpty()) {
                return null;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!AbstractC4816Gr3.a((AbstractC4099Dr3) it.next())) {
                    List upperBounds2 = c11399cw3.getUpperBounds();
                    AbstractC13042fc3.h(upperBounds2, "upperBounds");
                    List list2 = upperBounds2;
                    if ((list2 instanceof Collection) && list2.isEmpty()) {
                        return null;
                    }
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (!AbstractC19355qC6.b((AbstractC4099Dr3) it2.next())) {
                            List upperBounds3 = c11399cw3.getUpperBounds();
                            AbstractC13042fc3.h(upperBounds3, "upperBounds");
                            List list3 = upperBounds3;
                            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                                Iterator it3 = list3.iterator();
                                while (it3.hasNext()) {
                                    AbstractC13042fc3.h((AbstractC4099Dr3) it3.next(), "it");
                                    if (!AbstractC4816Gr3.b(r0)) {
                                        return EnumC14043hF4.NOT_NULL;
                                    }
                                }
                            }
                            return EnumC14043hF4.NULLABLE;
                        }
                    }
                    return null;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final ir.nasim.UA2 b() {
            /*
                r17 = this;
                r7 = r17
                java.util.Collection r0 = r7.c
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                java.util.ArrayList r8 = new java.util.ArrayList
                r1 = 10
                int r1 = ir.nasim.ZW0.x(r0, r1)
                r8.<init>(r1)
                java.util.Iterator r0 = r0.iterator()
            L15:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L29
                java.lang.Object r1 = r0.next()
                ir.nasim.Dr3 r1 = (ir.nasim.AbstractC4099Dr3) r1
                java.util.List r1 = r7.o(r1)
                r8.add(r1)
                goto L15
            L29:
                ir.nasim.Dr3 r0 = r7.b
                java.util.List r9 = r7.o(r0)
                boolean r0 = r7.d
                r11 = 1
                if (r0 == 0) goto L63
                java.util.Collection r0 = r7.c
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                boolean r1 = r0 instanceof java.util.Collection
                if (r1 == 0) goto L46
                r1 = r0
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L46
                goto L63
            L46:
                java.util.Iterator r0 = r0.iterator()
            L4a:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L63
                java.lang.Object r1 = r0.next()
                ir.nasim.Dr3 r1 = (ir.nasim.AbstractC4099Dr3) r1
                ir.nasim.Er3 r2 = ir.nasim.InterfaceC4333Er3.a
                ir.nasim.Dr3 r3 = r7.b
                boolean r1 = r2.c(r1, r3)
                r1 = r1 ^ r11
                if (r1 == 0) goto L4a
                r12 = r11
                goto L64
            L63:
                r12 = 0
            L64:
                if (r12 == 0) goto L68
                r13 = r11
                goto L6d
            L68:
                int r0 = r9.size()
                r13 = r0
            L6d:
                ir.nasim.Ui3[] r14 = new ir.nasim.C8056Ui3[r13]
                r15 = 0
            L70:
                if (r15 >= r13) goto Lc3
                if (r15 != 0) goto L76
                r4 = r11
                goto L77
            L76:
                r4 = 0
            L77:
                java.lang.Object r0 = r9.get(r15)
                ir.nasim.Wx7 r0 = (ir.nasim.C8663Wx7) r0
                ir.nasim.Dr3 r1 = r0.a()
                ir.nasim.ai3 r3 = r0.b()
                ir.nasim.vy7 r5 = r0.c()
                boolean r6 = r0.d()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r0 = r8.iterator()
            L96:
                boolean r16 = r0.hasNext()
                if (r16 == 0) goto Lb8
                java.lang.Object r16 = r0.next()
                r10 = r16
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r10 = ir.nasim.ZW0.t0(r10, r15)
                ir.nasim.Wx7 r10 = (ir.nasim.C8663Wx7) r10
                if (r10 != 0) goto Lae
                r10 = 0
                goto Lb2
            Lae:
                ir.nasim.Dr3 r10 = r10.e()
            Lb2:
                if (r10 == 0) goto L96
                r2.add(r10)
                goto L96
            Lb8:
                r0 = r17
                ir.nasim.Ui3 r0 = r0.d(r1, r2, r3, r4, r5, r6)
                r14[r15] = r0
                int r15 = r15 + 1
                goto L70
            Lc3:
                ir.nasim.oC6$b$a r0 = new ir.nasim.oC6$b$a
                r0.<init>(r14)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18173oC6.b.b():ir.nasim.UA2");
        }

        private final C14645iF4 c(C14645iF4 c14645iF4, C9876ai3 c9876ai3, InterfaceC22882vy7 interfaceC22882vy7) {
            C14645iF4 c14645iF4E;
            if (c14645iF4 == null) {
                c14645iF4 = (c9876ai3 == null || (c14645iF4E = c9876ai3.e()) == null) ? null : new C14645iF4(c14645iF4E.c(), c14645iF4E.d());
            }
            EnumC14043hF4 enumC14043hF4A = interfaceC22882vy7 == null ? null : a(interfaceC22882vy7);
            return enumC14043hF4A == null ? c14645iF4 : c14645iF4 == null ? new C14645iF4(enumC14043hF4A, false, 2, null) : new C14645iF4(m(enumC14043hF4A, c14645iF4.c()), false, 2, null);
        }

        private final C8056Ui3 d(AbstractC4099Dr3 abstractC4099Dr3, Collection collection, C9876ai3 c9876ai3, boolean z, InterfaceC22882vy7 interfaceC22882vy7, boolean z2) {
            boolean z3;
            Collection collection2 = collection;
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(collection2, 10));
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                arrayList.add(h((AbstractC4099Dr3) it.next()));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                EnumC11300cm4 enumC11300cm4B = ((C8056Ui3) it2.next()).b();
                if (enumC11300cm4B != null) {
                    arrayList2.add(enumC11300cm4B);
                }
            }
            Set setR1 = AbstractC15401jX0.r1(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                EnumC14043hF4 enumC14043hF4C = ((C8056Ui3) it3.next()).c();
                if (enumC14043hF4C != null) {
                    arrayList3.add(enumC14043hF4C);
                }
            }
            Set setR12 = AbstractC15401jX0.r1(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            Iterator it4 = collection2.iterator();
            while (it4.hasNext()) {
                EnumC14043hF4 enumC14043hF4C2 = h(AbstractC8692Wy7.c((AbstractC4099Dr3) it4.next())).c();
                if (enumC14043hF4C2 != null) {
                    arrayList4.add(enumC14043hF4C2);
                }
            }
            Set setR13 = AbstractC15401jX0.r1(arrayList4);
            C8056Ui3 c8056Ui3I = i(abstractC4099Dr3, z, c9876ai3, interfaceC22882vy7, z2);
            EnumC14043hF4 enumC14043hF4 = null;
            C8056Ui3 c8056Ui3 = c8056Ui3I.e() ^ true ? c8056Ui3I : null;
            EnumC14043hF4 enumC14043hF4C3 = c8056Ui3 == null ? null : c8056Ui3.c();
            EnumC14043hF4 enumC14043hF4C4 = c8056Ui3I.c();
            boolean z4 = this.d && z;
            EnumC14043hF4 enumC14043hF4C5 = AbstractC16855ly7.c(setR12, enumC14043hF4C3, z4);
            if (enumC14043hF4C5 != null && (!l() || !z || enumC14043hF4C5 != EnumC14043hF4.NULLABLE)) {
                enumC14043hF4 = enumC14043hF4C5;
            }
            EnumC11300cm4 enumC11300cm4 = (EnumC11300cm4) AbstractC16855ly7.d(setR1, EnumC11300cm4.MUTABLE, EnumC11300cm4.READ_ONLY, c8056Ui3I.b(), z4);
            boolean z5 = (enumC14043hF4C4 == enumC14043hF4C3 && AbstractC13042fc3.d(setR13, setR12)) ? false : true;
            if (c8056Ui3I.d()) {
                z3 = true;
                break;
            }
            if (!arrayList.isEmpty()) {
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    if (((C8056Ui3) it5.next()).d()) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (enumC14043hF4 == null && z5) {
                return AbstractC16855ly7.a(AbstractC16855ly7.c(setR13, enumC14043hF4C4, z4), enumC11300cm4, true, z3);
            }
            return AbstractC16855ly7.a(enumC14043hF4, enumC11300cm4, enumC14043hF4 == null, z3);
        }

        public static /* synthetic */ a f(b bVar, C17446my7 c17446my7, int i, Object obj) {
            if ((i & 1) != 0) {
                c17446my7 = null;
            }
            return bVar.e(c17446my7);
        }

        private final C14645iF4 g(InterfaceC4356Eu interfaceC4356Eu, boolean z, boolean z2) {
            C18173oC6 c18173oC6 = C18173oC6.this;
            Iterator it = interfaceC4356Eu.iterator();
            while (it.hasNext()) {
                C14645iF4 c14645iF4H = c18173oC6.h((InterfaceC21651tu) it.next(), z, z2);
                if (c14645iF4H != null) {
                    return c14645iF4H;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final ir.nasim.C8056Ui3 h(ir.nasim.AbstractC4099Dr3 r12) {
            /*
                r11 = this;
                boolean r0 = ir.nasim.AbstractC7411Rp2.b(r12)
                if (r0 == 0) goto L18
                ir.nasim.Mp2 r0 = ir.nasim.AbstractC7411Rp2.a(r12)
                ir.nasim.XV4 r1 = new ir.nasim.XV4
                ir.nasim.XC6 r2 = r0.S0()
                ir.nasim.XC6 r0 = r0.T0()
                r1.<init>(r2, r0)
                goto L1d
            L18:
                ir.nasim.XV4 r1 = new ir.nasim.XV4
                r1.<init>(r12, r12)
            L1d:
                java.lang.Object r0 = r1.a()
                ir.nasim.Dr3 r0 = (ir.nasim.AbstractC4099Dr3) r0
                java.lang.Object r1 = r1.b()
                ir.nasim.Dr3 r1 = (ir.nasim.AbstractC4099Dr3) r1
                ir.nasim.Ji3 r2 = ir.nasim.C5437Ji3.a
                ir.nasim.Ui3 r10 = new ir.nasim.Ui3
                boolean r3 = r0.L0()
                r4 = 0
                if (r3 == 0) goto L38
                ir.nasim.hF4 r3 = ir.nasim.EnumC14043hF4.NULLABLE
            L36:
                r5 = r3
                goto L42
            L38:
                boolean r3 = r1.L0()
                if (r3 != 0) goto L41
                ir.nasim.hF4 r3 = ir.nasim.EnumC14043hF4.NOT_NULL
                goto L36
            L41:
                r5 = r4
            L42:
                boolean r0 = r2.f(r0)
                if (r0 == 0) goto L4b
                ir.nasim.cm4 r0 = ir.nasim.EnumC11300cm4.READ_ONLY
                goto L55
            L4b:
                boolean r0 = r2.d(r1)
                if (r0 == 0) goto L54
                ir.nasim.cm4 r0 = ir.nasim.EnumC11300cm4.MUTABLE
                goto L55
            L54:
                r0 = r4
            L55:
                ir.nasim.oC7 r12 = r12.N0()
                boolean r6 = r12 instanceof ir.nasim.C24196yC4
                r8 = 8
                r9 = 0
                r7 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18173oC6.b.h(ir.nasim.Dr3):ir.nasim.Ui3");
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final ir.nasim.C8056Ui3 i(ir.nasim.AbstractC4099Dr3 r8, boolean r9, ir.nasim.C9876ai3 r10, ir.nasim.InterfaceC22882vy7 r11, boolean r12) {
            /*
                Method dump skipped, instructions count: 299
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C18173oC6.b.i(ir.nasim.Dr3, boolean, ir.nasim.ai3, ir.nasim.vy7, boolean):ir.nasim.Ui3");
        }

        private static final Object j(List list, InterfaceC4356Eu interfaceC4356Eu, Object obj) {
            List list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (interfaceC4356Eu.z((C9424Zw2) it.next()) != null) {
                        return obj;
                    }
                }
            }
            return null;
        }

        private static final Object k(Object obj, Object obj2) {
            if (obj == null || obj2 == null || AbstractC13042fc3.d(obj, obj2)) {
                return obj == null ? obj2 : obj;
            }
            return null;
        }

        private final boolean l() {
            InterfaceC10612bu interfaceC10612bu = this.a;
            if (!(interfaceC10612bu instanceof InterfaceC24919zQ7)) {
                interfaceC10612bu = null;
            }
            InterfaceC24919zQ7 interfaceC24919zQ7 = (InterfaceC24919zQ7) interfaceC10612bu;
            return (interfaceC24919zQ7 != null ? interfaceC24919zQ7.u0() : null) != null;
        }

        private final EnumC14043hF4 m(EnumC14043hF4 enumC14043hF4, EnumC14043hF4 enumC14043hF42) {
            EnumC14043hF4 enumC14043hF43 = EnumC14043hF4.FORCE_FLEXIBILITY;
            if (enumC14043hF4 == enumC14043hF43) {
                return enumC14043hF42;
            }
            if (enumC14043hF42 == enumC14043hF43) {
                return enumC14043hF4;
            }
            EnumC14043hF4 enumC14043hF44 = EnumC14043hF4.NULLABLE;
            if (enumC14043hF4 == enumC14043hF44) {
                return enumC14043hF42;
            }
            if (enumC14043hF42 == enumC14043hF44) {
                return enumC14043hF4;
            }
            if (enumC14043hF4 == enumC14043hF42) {
                EnumC14043hF4 enumC14043hF45 = EnumC14043hF4.NOT_NULL;
            }
            return EnumC14043hF4.NOT_NULL;
        }

        private final XV4 n(AbstractC4099Dr3 abstractC4099Dr3) {
            MU0 mu0T = abstractC4099Dr3.K0().t();
            InterfaceC22882vy7 interfaceC22882vy7 = mu0T instanceof InterfaceC22882vy7 ? (InterfaceC22882vy7) mu0T : null;
            EnumC14043hF4 enumC14043hF4A = interfaceC22882vy7 == null ? null : a(interfaceC22882vy7);
            if (enumC14043hF4A == null) {
                return new XV4(null, Boolean.FALSE);
            }
            EnumC14043hF4 enumC14043hF4 = EnumC14043hF4.NOT_NULL;
            return new XV4(new C14645iF4(enumC14043hF4, false, 2, null), Boolean.valueOf(enumC14043hF4A == enumC14043hF4));
        }

        private final List o(AbstractC4099Dr3 abstractC4099Dr3) {
            ArrayList arrayList = new ArrayList(1);
            p(this, arrayList, abstractC4099Dr3, this.e, null);
            return arrayList;
        }

        private static final void p(b bVar, ArrayList arrayList, AbstractC4099Dr3 abstractC4099Dr3, C9182Yv3 c9182Yv3, InterfaceC22882vy7 interfaceC22882vy7) {
            C9182Yv3 c9182Yv3H = AbstractC4760Gl1.h(c9182Yv3, abstractC4099Dr3.getAnnotations());
            C8290Vi3 c8290Vi3B = c9182Yv3H.b();
            C9876ai3 c9876ai3A = c8290Vi3B == null ? null : c8290Vi3B.a(bVar.g ? EnumC23427wu.TYPE_PARAMETER_BOUNDS : EnumC23427wu.TYPE_USE);
            arrayList.add(new C8663Wx7(abstractC4099Dr3, c9876ai3A, interfaceC22882vy7, false));
            List listJ0 = abstractC4099Dr3.J0();
            List parameters = abstractC4099Dr3.K0().getParameters();
            AbstractC13042fc3.h(parameters, "type.constructor.parameters");
            for (XV4 xv4 : AbstractC15401jX0.v1(listJ0, parameters)) {
                InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) xv4.a();
                InterfaceC22882vy7 interfaceC22882vy72 = (InterfaceC22882vy7) xv4.b();
                if (interfaceC3932Cy7.b()) {
                    AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
                    AbstractC13042fc3.h(type, "arg.type");
                    arrayList.add(new C8663Wx7(type, c9876ai3A, interfaceC22882vy72, true));
                } else {
                    AbstractC4099Dr3 type2 = interfaceC3932Cy7.getType();
                    AbstractC13042fc3.h(type2, "arg.type");
                    p(bVar, arrayList, type2, c9182Yv3H, interfaceC22882vy72);
                }
            }
        }

        public final a e(C17446my7 c17446my7) {
            UA2 ua2B = b();
            c cVar = c17446my7 == null ? null : new c(c17446my7, ua2B);
            boolean zC = AbstractC7497Ry7.c(this.b, C1420b.e);
            C6871Pi3 c6871Pi3 = C18173oC6.this.c;
            AbstractC4099Dr3 abstractC4099Dr3 = this.b;
            if (cVar != null) {
                ua2B = cVar;
            }
            AbstractC4099Dr3 abstractC4099Dr3B = c6871Pi3.b(abstractC4099Dr3, ua2B);
            a aVar = abstractC4099Dr3B != null ? new a(abstractC4099Dr3B, true, zC) : null;
            return aVar == null ? new a(this.b, false, zC) : aVar;
        }

        public /* synthetic */ b(InterfaceC10612bu interfaceC10612bu, AbstractC4099Dr3 abstractC4099Dr3, Collection collection, boolean z, C9182Yv3 c9182Yv3, EnumC23427wu enumC23427wu, boolean z2, int i, ED1 ed1) {
            this(C18173oC6.this, interfaceC10612bu, abstractC4099Dr3, collection, z, c9182Yv3, enumC23427wu, (i & 64) != 0 ? false : z2);
        }
    }
}
