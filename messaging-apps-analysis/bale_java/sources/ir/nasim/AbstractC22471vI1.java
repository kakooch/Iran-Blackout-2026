package ir.nasim;

/* renamed from: ir.nasim.vI1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22471vI1 {
    public static final String a(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC20419ry7 interfaceC20419ry7) {
        AbstractC13042fc3.i(interfaceC21331tU0, "klass");
        AbstractC13042fc3.i(interfaceC20419ry7, "typeMappingConfiguration");
        String strE = interfaceC20419ry7.e(interfaceC21331tU0);
        if (strE != null) {
            return strE;
        }
        InterfaceC12795fB1 interfaceC12795fB1B = interfaceC21331tU0.b();
        AbstractC13042fc3.h(interfaceC12795fB1B, "klass.containingDeclaration");
        String strJ = AbstractC23662xI6.c(interfaceC21331tU0.getName()).j();
        AbstractC13042fc3.h(strJ, "safeIdentifier(klass.name).identifier");
        if (interfaceC12795fB1B instanceof InterfaceC24340yS4) {
            C9424Zw2 c9424Zw2E = ((InterfaceC24340yS4) interfaceC12795fB1B).e();
            if (c9424Zw2E.d()) {
                return strJ;
            }
            StringBuilder sb = new StringBuilder();
            String strB = c9424Zw2E.b();
            AbstractC13042fc3.h(strB, "fqName.asString()");
            sb.append(AbstractC20153rZ6.L(strB, '.', '/', false, 4, null));
            sb.append('/');
            sb.append(strJ);
            return sb.toString();
        }
        InterfaceC21331tU0 interfaceC21331tU02 = interfaceC12795fB1B instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) interfaceC12795fB1B : null;
        if (interfaceC21331tU02 == null) {
            throw new IllegalArgumentException("Unexpected container: " + interfaceC12795fB1B + " for " + interfaceC21331tU0);
        }
        String strD = interfaceC20419ry7.d(interfaceC21331tU02);
        if (strD == null) {
            strD = a(interfaceC21331tU02, interfaceC20419ry7);
        }
        return strD + '$' + strJ;
    }

    public static /* synthetic */ String b(InterfaceC21331tU0 interfaceC21331tU0, InterfaceC20419ry7 interfaceC20419ry7, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC20419ry7 = C21009sy7.a;
        }
        return a(interfaceC21331tU0, interfaceC20419ry7);
    }

    public static final boolean c(InterfaceC14592iA0 interfaceC14592iA0) {
        AbstractC13042fc3.i(interfaceC14592iA0, "descriptor");
        if (interfaceC14592iA0 instanceof InterfaceC21426te1) {
            return true;
        }
        AbstractC4099Dr3 returnType = interfaceC14592iA0.getReturnType();
        AbstractC13042fc3.f(returnType);
        if (AbstractC19738qr3.J0(returnType)) {
            AbstractC4099Dr3 returnType2 = interfaceC14592iA0.getReturnType();
            AbstractC13042fc3.f(returnType2);
            if (!AbstractC7497Ry7.l(returnType2) && !(interfaceC14592iA0 instanceof InterfaceC22266uw5)) {
                return true;
            }
        }
        return false;
    }

    public static final Object d(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC8551Wl3 interfaceC8551Wl3, C21696ty7 c21696ty7, InterfaceC20419ry7 interfaceC20419ry7, AbstractC5230Il3 abstractC5230Il3, InterfaceC15796kB2 interfaceC15796kB2) {
        Object objD;
        AbstractC4099Dr3 abstractC4099Dr32;
        Object objD2;
        AbstractC13042fc3.i(abstractC4099Dr3, "kotlinType");
        AbstractC13042fc3.i(interfaceC8551Wl3, "factory");
        AbstractC13042fc3.i(c21696ty7, "mode");
        AbstractC13042fc3.i(interfaceC20419ry7, "typeMappingConfiguration");
        AbstractC13042fc3.i(interfaceC15796kB2, "writeGenericType");
        AbstractC4099Dr3 abstractC4099Dr3A = interfaceC20419ry7.a(abstractC4099Dr3);
        if (abstractC4099Dr3A != null) {
            return d(abstractC4099Dr3A, interfaceC8551Wl3, c21696ty7, interfaceC20419ry7, abstractC5230Il3, interfaceC15796kB2);
        }
        if (FB2.o(abstractC4099Dr3)) {
            return d(AbstractC19268q37.b(abstractC4099Dr3, interfaceC20419ry7.c()), interfaceC8551Wl3, c21696ty7, interfaceC20419ry7, abstractC5230Il3, interfaceC15796kB2);
        }
        CC6 cc6 = CC6.a;
        Object objB = AbstractC4883Gy7.b(cc6, abstractC4099Dr3, interfaceC8551Wl3, c21696ty7);
        if (objB != null) {
            Object objA = AbstractC4883Gy7.a(interfaceC8551Wl3, objB, c21696ty7.d());
            interfaceC15796kB2.q(abstractC4099Dr3, objA, c21696ty7);
            return objA;
        }
        InterfaceC13882gy7 interfaceC13882gy7K0 = abstractC4099Dr3.K0();
        if (interfaceC13882gy7K0 instanceof C7993Ub3) {
            C7993Ub3 c7993Ub3 = (C7993Ub3) interfaceC13882gy7K0;
            AbstractC4099Dr3 abstractC4099Dr3H = c7993Ub3.h();
            if (abstractC4099Dr3H == null) {
                abstractC4099Dr3H = interfaceC20419ry7.f(c7993Ub3.b());
            }
            return d(AbstractC7731Sy7.m(abstractC4099Dr3H), interfaceC8551Wl3, c21696ty7, interfaceC20419ry7, abstractC5230Il3, interfaceC15796kB2);
        }
        MU0 mu0D = interfaceC13882gy7K0.t();
        if (mu0D == null) {
            throw new UnsupportedOperationException(AbstractC13042fc3.q("no descriptor for type constructor of ", abstractC4099Dr3));
        }
        if (AbstractC14230ha2.r(mu0D)) {
            Object objD3 = interfaceC8551Wl3.d("error/NonExistentClass");
            interfaceC20419ry7.g(abstractC4099Dr3, (InterfaceC21331tU0) mu0D);
            return objD3;
        }
        boolean z = mu0D instanceof InterfaceC21331tU0;
        if (z && AbstractC19738qr3.b0(abstractC4099Dr3)) {
            if (abstractC4099Dr3.J0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            InterfaceC3932Cy7 interfaceC3932Cy7 = (InterfaceC3932Cy7) abstractC4099Dr3.J0().get(0);
            AbstractC4099Dr3 type = interfaceC3932Cy7.getType();
            AbstractC13042fc3.h(type, "memberProjection.type");
            if (interfaceC3932Cy7.c() == KQ7.IN_VARIANCE) {
                objD2 = interfaceC8551Wl3.d("java/lang/Object");
            } else {
                KQ7 kq7C = interfaceC3932Cy7.c();
                AbstractC13042fc3.h(kq7C, "memberProjection.projectionKind");
                objD2 = d(type, interfaceC8551Wl3, c21696ty7.f(kq7C, true), interfaceC20419ry7, abstractC5230Il3, interfaceC15796kB2);
            }
            return interfaceC8551Wl3.a(AbstractC13042fc3.q("[", interfaceC8551Wl3.c(objD2)));
        }
        if (!z) {
            if (mu0D instanceof InterfaceC22882vy7) {
                return d(AbstractC7731Sy7.f((InterfaceC22882vy7) mu0D), interfaceC8551Wl3, c21696ty7, interfaceC20419ry7, null, IB2.b());
            }
            if ((mu0D instanceof InterfaceC7722Sx7) && c21696ty7.b()) {
                return d(((InterfaceC7722Sx7) mu0D).G(), interfaceC8551Wl3, c21696ty7, interfaceC20419ry7, abstractC5230Il3, interfaceC15796kB2);
            }
            throw new UnsupportedOperationException(AbstractC13042fc3.q("Unknown type ", abstractC4099Dr3));
        }
        if (R73.b(mu0D) && !c21696ty7.c() && (abstractC4099Dr32 = (AbstractC4099Dr3) AbstractC20807se2.a(cc6, abstractC4099Dr3)) != null) {
            return d(abstractC4099Dr32, interfaceC8551Wl3, c21696ty7.g(), interfaceC20419ry7, abstractC5230Il3, interfaceC15796kB2);
        }
        if (c21696ty7.e() && AbstractC19738qr3.q0((InterfaceC21331tU0) mu0D)) {
            objD = interfaceC8551Wl3.f();
        } else {
            InterfaceC21331tU0 interfaceC21331tU0 = (InterfaceC21331tU0) mu0D;
            InterfaceC21331tU0 interfaceC21331tU0A = interfaceC21331tU0.a();
            AbstractC13042fc3.h(interfaceC21331tU0A, "descriptor.original");
            Object objB2 = interfaceC20419ry7.b(interfaceC21331tU0A);
            if (objB2 == null) {
                if (interfaceC21331tU0.f() == AU0.ENUM_ENTRY) {
                    interfaceC21331tU0 = (InterfaceC21331tU0) interfaceC21331tU0.b();
                }
                InterfaceC21331tU0 interfaceC21331tU0A2 = interfaceC21331tU0.a();
                AbstractC13042fc3.h(interfaceC21331tU0A2, "enumClassIfEnumEntry.original");
                objD = interfaceC8551Wl3.d(a(interfaceC21331tU0A2, interfaceC20419ry7));
            } else {
                objD = objB2;
            }
        }
        interfaceC15796kB2.q(abstractC4099Dr3, objD, c21696ty7);
        return objD;
    }

    public static /* synthetic */ Object e(AbstractC4099Dr3 abstractC4099Dr3, InterfaceC8551Wl3 interfaceC8551Wl3, C21696ty7 c21696ty7, InterfaceC20419ry7 interfaceC20419ry7, AbstractC5230Il3 abstractC5230Il3, InterfaceC15796kB2 interfaceC15796kB2, int i, Object obj) {
        if ((i & 32) != 0) {
            interfaceC15796kB2 = IB2.b();
        }
        return d(abstractC4099Dr3, interfaceC8551Wl3, c21696ty7, interfaceC20419ry7, abstractC5230Il3, interfaceC15796kB2);
    }
}
