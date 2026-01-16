package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.Wi3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8524Wi3 {
    private final C9182Yv3 a;
    private final InterfaceC25246zy7 b;

    /* renamed from: ir.nasim.Wi3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ InterfaceC22882vy7 e;
        final /* synthetic */ C6637Oi3 f;
        final /* synthetic */ InterfaceC13882gy7 g;

        /* renamed from: ir.nasim.Wi3$a$a, reason: collision with other inner class name */
        static final class C0734a extends AbstractC8614Ws3 implements SA2 {
            final /* synthetic */ InterfaceC13882gy7 e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0734a(InterfaceC13882gy7 interfaceC13882gy7) {
                super(0);
                this.e = interfaceC13882gy7;
            }

            @Override // ir.nasim.SA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AbstractC4099Dr3 invoke() {
                MU0 mu0D = this.e.t();
                AbstractC13042fc3.f(mu0D);
                XC6 xc6P = mu0D.p();
                AbstractC13042fc3.h(xc6P, "constructor.declarationDescriptor!!.defaultType");
                return AbstractC7731Sy7.m(xc6P);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC22882vy7 interfaceC22882vy7, C6637Oi3 c6637Oi3, InterfaceC13882gy7 interfaceC13882gy7) {
            super(0);
            this.e = interfaceC22882vy7;
            this.f = c6637Oi3;
            this.g = interfaceC13882gy7;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final AbstractC4099Dr3 invoke() {
            InterfaceC22882vy7 interfaceC22882vy7 = this.e;
            AbstractC13042fc3.h(interfaceC22882vy7, "parameter");
            return AbstractC8790Xi3.b(interfaceC22882vy7, this.f.e(), new C0734a(this.g));
        }
    }

    public C8524Wi3(C9182Yv3 c9182Yv3, InterfaceC25246zy7 interfaceC25246zy7) {
        AbstractC13042fc3.i(c9182Yv3, "c");
        AbstractC13042fc3.i(interfaceC25246zy7, "typeParameterResolver");
        this.a = c9182Yv3;
        this.b = interfaceC25246zy7;
    }

    private final boolean a(InterfaceC9056Yh3 interfaceC9056Yh3, InterfaceC21331tU0 interfaceC21331tU0) {
        if (!b((InterfaceC6138Mi3) AbstractC15401jX0.F0(interfaceC9056Yh3.A()))) {
            return false;
        }
        List parameters = C5437Ji3.a.b(interfaceC21331tU0).j().getParameters();
        AbstractC13042fc3.h(parameters, "JavaToKotlinClassMapper.convertReadOnlyToMutable(readOnlyContainer)\n            .typeConstructor.parameters");
        InterfaceC22882vy7 interfaceC22882vy7 = (InterfaceC22882vy7) AbstractC15401jX0.F0(parameters);
        KQ7 kq7M = interfaceC22882vy7 == null ? null : interfaceC22882vy7.m();
        return (kq7M == null || kq7M == KQ7.OUT_VARIANCE) ? false : true;
    }

    private static final boolean b(InterfaceC6138Mi3 interfaceC6138Mi3) {
        InterfaceC11891dj3 interfaceC11891dj3 = interfaceC6138Mi3 instanceof InterfaceC11891dj3 ? (InterfaceC11891dj3) interfaceC6138Mi3 : null;
        return (interfaceC11891dj3 == null || interfaceC11891dj3.w() == null || interfaceC11891dj3.N()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.List c(ir.nasim.InterfaceC9056Yh3 r8, ir.nasim.C6637Oi3 r9, ir.nasim.InterfaceC13882gy7 r10) {
        /*
            r7 = this;
            boolean r0 = r8.s()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "constructor.parameters"
            if (r0 != 0) goto L26
            java.util.List r4 = r8.A()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L25
            java.util.List r4 = r10.getParameters()
            ir.nasim.AbstractC13042fc3.h(r4, r3)
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r4 = r4 ^ r2
            if (r4 == 0) goto L25
            goto L26
        L25:
            r2 = r1
        L26:
            java.util.List r4 = r10.getParameters()
            ir.nasim.AbstractC13042fc3.h(r4, r3)
            java.lang.String r3 = "parameter"
            r5 = 10
            if (r2 == 0) goto L7a
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r8 = new java.util.ArrayList
            int r1 = ir.nasim.ZW0.x(r4, r5)
            r8.<init>(r1)
            java.util.Iterator r1 = r4.iterator()
        L42:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L75
            java.lang.Object r2 = r1.next()
            ir.nasim.vy7 r2 = (ir.nasim.InterfaceC22882vy7) r2
            ir.nasim.Jx3 r4 = new ir.nasim.Jx3
            ir.nasim.Yv3 r5 = r7.a
            ir.nasim.ON6 r5 = r5.e()
            ir.nasim.Wi3$a r6 = new ir.nasim.Wi3$a
            r6.<init>(r2, r9, r10)
            r4.<init>(r5, r6)
            ir.nasim.DG5 r5 = ir.nasim.DG5.c
            ir.nasim.AbstractC13042fc3.h(r2, r3)
            if (r0 == 0) goto L67
            r6 = r9
            goto L6d
        L67:
            ir.nasim.Ri3 r6 = ir.nasim.EnumC7349Ri3.INFLEXIBLE
            ir.nasim.Oi3 r6 = r9.g(r6)
        L6d:
            ir.nasim.Cy7 r2 = r5.i(r2, r6, r4)
            r8.add(r2)
            goto L42
        L75:
            java.util.List r8 = ir.nasim.ZW0.m1(r8)
            return r8
        L7a:
            int r9 = r4.size()
            java.util.List r10 = r8.A()
            int r10 = r10.size()
            if (r9 == r10) goto Lbd
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = ir.nasim.ZW0.x(r4, r5)
            r8.<init>(r9)
            java.util.Iterator r9 = r4.iterator()
        L97:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto Lb8
            java.lang.Object r10 = r9.next()
            ir.nasim.vy7 r10 = (ir.nasim.InterfaceC22882vy7) r10
            ir.nasim.Ey7 r0 = new ir.nasim.Ey7
            ir.nasim.No4 r10 = r10.getName()
            java.lang.String r10 = r10.h()
            ir.nasim.XC6 r10 = ir.nasim.AbstractC14230ha2.j(r10)
            r0.<init>(r10)
            r8.add(r0)
            goto L97
        Lb8:
            java.util.List r8 = ir.nasim.ZW0.m1(r8)
            return r8
        Lbd:
            java.util.List r8 = r8.A()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.Iterable r8 = ir.nasim.ZW0.u1(r8)
            java.util.ArrayList r9 = new java.util.ArrayList
            int r10 = ir.nasim.ZW0.x(r8, r5)
            r9.<init>(r10)
            java.util.Iterator r8 = r8.iterator()
        Ld4:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L106
            java.lang.Object r10 = r8.next()
            ir.nasim.i63 r10 = (ir.nasim.C14555i63) r10
            int r0 = r10.a()
            java.lang.Object r10 = r10.b()
            ir.nasim.Mi3 r10 = (ir.nasim.InterfaceC6138Mi3) r10
            r4.size()
            java.lang.Object r0 = r4.get(r0)
            ir.nasim.vy7 r0 = (ir.nasim.InterfaceC22882vy7) r0
            ir.nasim.Qy7 r2 = ir.nasim.EnumC7263Qy7.COMMON
            r5 = 3
            r6 = 0
            ir.nasim.Oi3 r2 = ir.nasim.AbstractC8790Xi3.f(r2, r1, r6, r5, r6)
            ir.nasim.AbstractC13042fc3.h(r0, r3)
            ir.nasim.Cy7 r10 = r7.o(r10, r2, r0)
            r9.add(r10)
            goto Ld4
        L106:
            java.util.List r8 = ir.nasim.ZW0.m1(r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8524Wi3.c(ir.nasim.Yh3, ir.nasim.Oi3, ir.nasim.gy7):java.util.List");
    }

    private final XC6 d(InterfaceC9056Yh3 interfaceC9056Yh3, C6637Oi3 c6637Oi3, XC6 xc6) {
        InterfaceC4356Eu annotations = xc6 == null ? null : xc6.getAnnotations();
        if (annotations == null) {
            annotations = new C7466Rv3(this.a, interfaceC9056Yh3, false, 4, null);
        }
        InterfaceC4356Eu interfaceC4356Eu = annotations;
        InterfaceC13882gy7 interfaceC13882gy7E = e(interfaceC9056Yh3, c6637Oi3);
        if (interfaceC13882gy7E == null) {
            return null;
        }
        boolean zH = h(c6637Oi3);
        return (AbstractC13042fc3.d(xc6 != null ? xc6.K0() : null, interfaceC13882gy7E) && !interfaceC9056Yh3.s() && zH) ? xc6.O0(true) : C4567Fr3.i(interfaceC4356Eu, interfaceC13882gy7E, c(interfaceC9056Yh3, c6637Oi3, interfaceC13882gy7E), zH, null, 16, null);
    }

    private final InterfaceC13882gy7 e(InterfaceC9056Yh3 interfaceC9056Yh3, C6637Oi3 c6637Oi3) {
        InterfaceC8781Xh3 interfaceC8781Xh3A = interfaceC9056Yh3.a();
        if (interfaceC8781Xh3A == null) {
            return f(interfaceC9056Yh3);
        }
        if (!(interfaceC8781Xh3A instanceof InterfaceC7106Qh3)) {
            if (!(interfaceC8781Xh3A instanceof InterfaceC7583Si3)) {
                throw new IllegalStateException(AbstractC13042fc3.q("Unknown classifier kind: ", interfaceC8781Xh3A));
            }
            InterfaceC22882vy7 interfaceC22882vy7A = this.b.a((InterfaceC7583Si3) interfaceC8781Xh3A);
            if (interfaceC22882vy7A == null) {
                return null;
            }
            return interfaceC22882vy7A.j();
        }
        InterfaceC7106Qh3 interfaceC7106Qh3 = (InterfaceC7106Qh3) interfaceC8781Xh3A;
        C9424Zw2 c9424Zw2E = interfaceC7106Qh3.e();
        if (c9424Zw2E == null) {
            throw new AssertionError(AbstractC13042fc3.q("Class type should have a FQ name: ", interfaceC8781Xh3A));
        }
        InterfaceC21331tU0 interfaceC21331tU0I = i(interfaceC9056Yh3, c6637Oi3, c9424Zw2E);
        if (interfaceC21331tU0I == null) {
            interfaceC21331tU0I = this.a.a().m().a(interfaceC7106Qh3);
        }
        InterfaceC13882gy7 interfaceC13882gy7J = interfaceC21331tU0I != null ? interfaceC21331tU0I.j() : null;
        return interfaceC13882gy7J == null ? f(interfaceC9056Yh3) : interfaceC13882gy7J;
    }

    private final InterfaceC13882gy7 f(InterfaceC9056Yh3 interfaceC9056Yh3) {
        C24948zU0 c24948zU0M = C24948zU0.m(new C9424Zw2(interfaceC9056Yh3.I()));
        AbstractC13042fc3.h(c24948zU0M, "topLevel(FqName(javaType.classifierQualifiedName))");
        InterfaceC13882gy7 interfaceC13882gy7J = this.a.a().b().f().q().d(c24948zU0M, AbstractC9766aX0.e(0)).j();
        AbstractC13042fc3.h(interfaceC13882gy7J, "c.components.deserializedDescriptorResolver.components.notFoundClasses.getClass(classId, listOf(0)).typeConstructor");
        return interfaceC13882gy7J;
    }

    private final boolean g(KQ7 kq7, InterfaceC22882vy7 interfaceC22882vy7) {
        return (interfaceC22882vy7.m() == KQ7.INVARIANT || kq7 == interfaceC22882vy7.m()) ? false : true;
    }

    private final boolean h(C6637Oi3 c6637Oi3) {
        return (c6637Oi3.c() == EnumC7349Ri3.FLEXIBLE_LOWER_BOUND || c6637Oi3.f() || c6637Oi3.d() == EnumC7263Qy7.SUPERTYPE) ? false : true;
    }

    private final InterfaceC21331tU0 i(InterfaceC9056Yh3 interfaceC9056Yh3, C6637Oi3 c6637Oi3, C9424Zw2 c9424Zw2) {
        if (c6637Oi3.f() && AbstractC13042fc3.d(c9424Zw2, AbstractC8790Xi3.a)) {
            return this.a.a().o().c();
        }
        C5437Ji3 c5437Ji3 = C5437Ji3.a;
        InterfaceC21331tU0 interfaceC21331tU0H = C5437Ji3.h(c5437Ji3, c9424Zw2, this.a.d().n(), null, 4, null);
        if (interfaceC21331tU0H == null) {
            return null;
        }
        return (c5437Ji3.e(interfaceC21331tU0H) && (c6637Oi3.c() == EnumC7349Ri3.FLEXIBLE_LOWER_BOUND || c6637Oi3.d() == EnumC7263Qy7.SUPERTYPE || a(interfaceC9056Yh3, interfaceC21331tU0H))) ? c5437Ji3.b(interfaceC21331tU0H) : interfaceC21331tU0H;
    }

    public static /* synthetic */ AbstractC4099Dr3 k(C8524Wi3 c8524Wi3, InterfaceC5896Lh3 interfaceC5896Lh3, C6637Oi3 c6637Oi3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return c8524Wi3.j(interfaceC5896Lh3, c6637Oi3, z);
    }

    private final AbstractC4099Dr3 l(InterfaceC9056Yh3 interfaceC9056Yh3, C6637Oi3 c6637Oi3) {
        boolean z = (c6637Oi3.f() || c6637Oi3.d() == EnumC7263Qy7.SUPERTYPE) ? false : true;
        boolean zS = interfaceC9056Yh3.s();
        if (!zS && !z) {
            XC6 xc6D = d(interfaceC9056Yh3, c6637Oi3, null);
            return xc6D == null ? m(interfaceC9056Yh3) : xc6D;
        }
        XC6 xc6D2 = d(interfaceC9056Yh3, c6637Oi3.g(EnumC7349Ri3.FLEXIBLE_LOWER_BOUND), null);
        if (xc6D2 == null) {
            return m(interfaceC9056Yh3);
        }
        XC6 xc6D3 = d(interfaceC9056Yh3, c6637Oi3.g(EnumC7349Ri3.FLEXIBLE_UPPER_BOUND), xc6D2);
        return xc6D3 == null ? m(interfaceC9056Yh3) : zS ? new FG5(xc6D2, xc6D3) : C4567Fr3.d(xc6D2, xc6D3);
    }

    private static final XC6 m(InterfaceC9056Yh3 interfaceC9056Yh3) {
        XC6 xc6J = AbstractC14230ha2.j(AbstractC13042fc3.q("Unresolved java class ", interfaceC9056Yh3.G()));
        AbstractC13042fc3.h(xc6J, "createErrorType(\"Unresolved java class ${javaType.presentableText}\")");
        return xc6J;
    }

    private final InterfaceC3932Cy7 o(InterfaceC6138Mi3 interfaceC6138Mi3, C6637Oi3 c6637Oi3, InterfaceC22882vy7 interfaceC22882vy7) {
        if (!(interfaceC6138Mi3 instanceof InterfaceC11891dj3)) {
            return new C4400Ey7(KQ7.INVARIANT, n(interfaceC6138Mi3, c6637Oi3));
        }
        InterfaceC11891dj3 interfaceC11891dj3 = (InterfaceC11891dj3) interfaceC6138Mi3;
        InterfaceC6138Mi3 interfaceC6138Mi3W = interfaceC11891dj3.w();
        KQ7 kq7 = interfaceC11891dj3.N() ? KQ7.OUT_VARIANCE : KQ7.IN_VARIANCE;
        return (interfaceC6138Mi3W == null || g(kq7, interfaceC22882vy7)) ? AbstractC8790Xi3.d(interfaceC22882vy7, c6637Oi3) : AbstractC7731Sy7.d(n(interfaceC6138Mi3W, AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, false, null, 3, null)), kq7, interfaceC22882vy7);
    }

    public final AbstractC4099Dr3 j(InterfaceC5896Lh3 interfaceC5896Lh3, C6637Oi3 c6637Oi3, boolean z) {
        AbstractC13042fc3.i(interfaceC5896Lh3, "arrayType");
        AbstractC13042fc3.i(c6637Oi3, "attr");
        InterfaceC6138Mi3 interfaceC6138Mi3M = interfaceC5896Lh3.m();
        InterfaceC23901xi3 interfaceC23901xi3 = interfaceC6138Mi3M instanceof InterfaceC23901xi3 ? (InterfaceC23901xi3) interfaceC6138Mi3M : null;
        EnumC4809Gq5 type = interfaceC23901xi3 == null ? null : interfaceC23901xi3.getType();
        C7466Rv3 c7466Rv3 = new C7466Rv3(this.a, interfaceC5896Lh3, true);
        if (type != null) {
            XC6 xc6N = this.a.d().n().N(type);
            AbstractC13042fc3.h(xc6N, "c.module.builtIns.getPrimitiveArrayKotlinType(primitiveType)");
            xc6N.Q0(InterfaceC4356Eu.W.a(AbstractC15401jX0.P0(c7466Rv3, xc6N.getAnnotations())));
            if (c6637Oi3.f()) {
                return xc6N;
            }
            C4567Fr3 c4567Fr3 = C4567Fr3.a;
            return C4567Fr3.d(xc6N, xc6N.O0(true));
        }
        AbstractC4099Dr3 abstractC4099Dr3N = n(interfaceC6138Mi3M, AbstractC8790Xi3.f(EnumC7263Qy7.COMMON, c6637Oi3.f(), null, 2, null));
        if (c6637Oi3.f()) {
            XC6 xc6M = this.a.d().n().m(z ? KQ7.OUT_VARIANCE : KQ7.INVARIANT, abstractC4099Dr3N, c7466Rv3);
            AbstractC13042fc3.h(xc6M, "c.module.builtIns.getArrayType(projectionKind, componentType, annotations)");
            return xc6M;
        }
        C4567Fr3 c4567Fr32 = C4567Fr3.a;
        XC6 xc6M2 = this.a.d().n().m(KQ7.INVARIANT, abstractC4099Dr3N, c7466Rv3);
        AbstractC13042fc3.h(xc6M2, "c.module.builtIns.getArrayType(INVARIANT, componentType, annotations)");
        return C4567Fr3.d(xc6M2, this.a.d().n().m(KQ7.OUT_VARIANCE, abstractC4099Dr3N, c7466Rv3).O0(true));
    }

    public final AbstractC4099Dr3 n(InterfaceC6138Mi3 interfaceC6138Mi3, C6637Oi3 c6637Oi3) {
        AbstractC13042fc3.i(c6637Oi3, "attr");
        if (interfaceC6138Mi3 instanceof InterfaceC23901xi3) {
            EnumC4809Gq5 type = ((InterfaceC23901xi3) interfaceC6138Mi3).getType();
            XC6 xc6Q = type != null ? this.a.d().n().Q(type) : this.a.d().n().Y();
            AbstractC13042fc3.h(xc6Q, "{\n                val primitiveType = javaType.type\n                if (primitiveType != null) c.module.builtIns.getPrimitiveKotlinType(primitiveType)\n                else c.module.builtIns.unitType\n            }");
            return xc6Q;
        }
        if (interfaceC6138Mi3 instanceof InterfaceC9056Yh3) {
            return l((InterfaceC9056Yh3) interfaceC6138Mi3, c6637Oi3);
        }
        if (interfaceC6138Mi3 instanceof InterfaceC5896Lh3) {
            return k(this, (InterfaceC5896Lh3) interfaceC6138Mi3, c6637Oi3, false, 4, null);
        }
        if (!(interfaceC6138Mi3 instanceof InterfaceC11891dj3)) {
            if (interfaceC6138Mi3 != null) {
                throw new UnsupportedOperationException(AbstractC13042fc3.q("Unsupported type: ", interfaceC6138Mi3));
            }
            XC6 xc6Y = this.a.d().n().y();
            AbstractC13042fc3.h(xc6Y, "c.module.builtIns.defaultBound");
            return xc6Y;
        }
        InterfaceC6138Mi3 interfaceC6138Mi3W = ((InterfaceC11891dj3) interfaceC6138Mi3).w();
        AbstractC4099Dr3 abstractC4099Dr3N = interfaceC6138Mi3W == null ? null : n(interfaceC6138Mi3W, c6637Oi3);
        if (abstractC4099Dr3N != null) {
            return abstractC4099Dr3N;
        }
        XC6 xc6Y2 = this.a.d().n().y();
        AbstractC13042fc3.h(xc6Y2, "c.module.builtIns.defaultBound");
        return xc6Y2;
    }
}
