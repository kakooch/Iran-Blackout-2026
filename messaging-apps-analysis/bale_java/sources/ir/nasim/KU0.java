package ir.nasim;

import ir.nasim.InterfaceC5819Ky7;
import ir.nasim.InterfaceC6546Ny7;
import ir.nasim.PJ6;
import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public interface KU0 extends InterfaceC5819Ky7, InterfaceC6546Ny7 {

    public static final class a {
        public static boolean A(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                return AbstractC19738qr3.D0((InterfaceC13882gy7) interfaceC14475hy7, PJ6.a.b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean B(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                return ((InterfaceC13882gy7) interfaceC14475hy7).t() instanceof InterfaceC21331tU0;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean C(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                MU0 mu0D = ((InterfaceC13882gy7) interfaceC14475hy7).t();
                InterfaceC21331tU0 interfaceC21331tU0 = mu0D instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0D : null;
                return (interfaceC21331tU0 == null || !AbstractC11862dg4.a(interfaceC21331tU0) || interfaceC21331tU0.f() == AU0.ENUM_ENTRY || interfaceC21331tU0.f() == AU0.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean D(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                return ((InterfaceC13882gy7) interfaceC14475hy7).e();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean E(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                return AbstractC4816Gr3.a((AbstractC4099Dr3) interfaceC5050Hr3);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static boolean F(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                MU0 mu0D = ((InterfaceC13882gy7) interfaceC14475hy7).t();
                InterfaceC21331tU0 interfaceC21331tU0 = mu0D instanceof InterfaceC21331tU0 ? (InterfaceC21331tU0) mu0D : null;
                return AbstractC13042fc3.d(interfaceC21331tU0 != null ? Boolean.valueOf(R73.b(interfaceC21331tU0)) : null, Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean G(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                return interfaceC14475hy7 instanceof C7043Qa3;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean H(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                return interfaceC14475hy7 instanceof C7993Ub3;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean I(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            return InterfaceC6546Ny7.a.b(ku0, interfaceC5050Hr3);
        }

        public static boolean J(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof XC6) {
                return ((XC6) zc6).L0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static boolean K(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                return AbstractC19738qr3.D0((InterfaceC13882gy7) interfaceC14475hy7, PJ6.a.c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean L(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                return AbstractC7497Ry7.l((AbstractC4099Dr3) interfaceC5050Hr3);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean M(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof AbstractC4099Dr3) {
                return AbstractC19738qr3.y0((AbstractC4099Dr3) zc6);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static boolean N(KU0 ku0, InterfaceC19385qG0 interfaceC19385qG0) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC19385qG0, "receiver");
            if (interfaceC19385qG0 instanceof C24002xs4) {
                return ((C24002xs4) interfaceC19385qG0).W0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC19385qG0 + ", " + AbstractC10882cM5.b(interfaceC19385qG0.getClass())).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static boolean O(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (!(zc6 instanceof XC6)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
            }
            if (!AbstractC4816Gr3.a((AbstractC4099Dr3) zc6)) {
                XC6 xc6 = (XC6) zc6;
                if (!(xc6.K0().t() instanceof InterfaceC7722Sx7) && (xc6.K0().t() != null || (zc6 instanceof C16430lG0) || (zc6 instanceof C24002xs4) || (zc6 instanceof DG1) || (xc6.K0() instanceof C7043Qa3))) {
                    return true;
                }
            }
            return false;
        }

        public static boolean P(KU0 ku0, InterfaceC9438Zx7 interfaceC9438Zx7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC9438Zx7, "receiver");
            if (interfaceC9438Zx7 instanceof InterfaceC3932Cy7) {
                return ((InterfaceC3932Cy7) interfaceC9438Zx7).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC9438Zx7 + ", " + AbstractC10882cM5.b(interfaceC9438Zx7.getClass())).toString());
        }

        public static boolean Q(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof XC6) {
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static boolean R(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                MU0 mu0D = ((InterfaceC13882gy7) interfaceC14475hy7).t();
                return AbstractC13042fc3.d(mu0D == null ? null : Boolean.valueOf(AbstractC19738qr3.I0(mu0D)), Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static ZC6 S(KU0 ku0, InterfaceC6933Pp2 interfaceC6933Pp2) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC6933Pp2, "receiver");
            if (interfaceC6933Pp2 instanceof AbstractC6200Mp2) {
                return ((AbstractC6200Mp2) interfaceC6933Pp2).S0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC6933Pp2 + ", " + AbstractC10882cM5.b(interfaceC6933Pp2.getClass())).toString());
        }

        public static ZC6 T(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            return InterfaceC6546Ny7.a.c(ku0, interfaceC5050Hr3);
        }

        public static InterfaceC5050Hr3 U(KU0 ku0, InterfaceC19385qG0 interfaceC19385qG0) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC19385qG0, "receiver");
            if (interfaceC19385qG0 instanceof C24002xs4) {
                return ((C24002xs4) interfaceC19385qG0).V0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC19385qG0 + ", " + AbstractC10882cM5.b(interfaceC19385qG0.getClass())).toString());
        }

        public static InterfaceC5050Hr3 V(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC18174oC7) {
                return LU0.b((AbstractC18174oC7) interfaceC5050Hr3);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static InterfaceC5050Hr3 W(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            return InterfaceC5819Ky7.a.a(ku0, interfaceC5050Hr3);
        }

        public static AbstractC12095e2 X(KU0 ku0, boolean z, boolean z2) {
            AbstractC13042fc3.i(ku0, "this");
            return new IU0(z, z2, false, null, 12, null);
        }

        public static ZC6 Y(KU0 ku0, EG1 eg1) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(eg1, "receiver");
            if (eg1 instanceof DG1) {
                return ((DG1) eg1).W0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + eg1 + ", " + AbstractC10882cM5.b(eg1.getClass())).toString());
        }

        public static int Z(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                return ((InterfaceC13882gy7) interfaceC14475hy7).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static boolean a(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7, InterfaceC14475hy7 interfaceC14475hy72) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "c1");
            AbstractC13042fc3.i(interfaceC14475hy72, "c2");
            if (!(interfaceC14475hy7 instanceof InterfaceC13882gy7)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
            }
            if (interfaceC14475hy72 instanceof InterfaceC13882gy7) {
                return AbstractC13042fc3.d(interfaceC14475hy7, interfaceC14475hy72);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy72 + ", " + AbstractC10882cM5.b(interfaceC14475hy72.getClass())).toString());
        }

        public static Collection a0(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            InterfaceC14475hy7 interfaceC14475hy7D = ku0.d(zc6);
            if (interfaceC14475hy7D instanceof C7043Qa3) {
                return ((C7043Qa3) interfaceC14475hy7D).k();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static int b(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                return ((AbstractC4099Dr3) interfaceC5050Hr3).J0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static int b0(KU0 ku0, InterfaceC9204Yx7 interfaceC9204Yx7) {
            return InterfaceC6546Ny7.a.d(ku0, interfaceC9204Yx7);
        }

        public static InterfaceC9204Yx7 c(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof XC6) {
                return (InterfaceC9204Yx7) zc6;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static Collection c0(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                Collection collectionB = ((InterfaceC13882gy7) interfaceC14475hy7).b();
                AbstractC13042fc3.h(collectionB, "this.supertypes");
                return collectionB;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static InterfaceC19385qG0 d(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof XC6) {
                if (zc6 instanceof C24002xs4) {
                    return (C24002xs4) zc6;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static InterfaceC14475hy7 d0(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            return InterfaceC6546Ny7.a.e(ku0, interfaceC5050Hr3);
        }

        public static EG1 e(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof XC6) {
                if (zc6 instanceof DG1) {
                    return (DG1) zc6;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static InterfaceC14475hy7 e0(KU0 ku0, ZC6 zc6) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof XC6) {
                return ((XC6) zc6).K0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static InterfaceC21056t22 f(KU0 ku0, InterfaceC6933Pp2 interfaceC6933Pp2) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC6933Pp2, "receiver");
            if (interfaceC6933Pp2 instanceof AbstractC6200Mp2) {
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC6933Pp2 + ", " + AbstractC10882cM5.b(interfaceC6933Pp2.getClass())).toString());
        }

        public static ZC6 f0(KU0 ku0, InterfaceC6933Pp2 interfaceC6933Pp2) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC6933Pp2, "receiver");
            if (interfaceC6933Pp2 instanceof AbstractC6200Mp2) {
                return ((AbstractC6200Mp2) interfaceC6933Pp2).T0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC6933Pp2 + ", " + AbstractC10882cM5.b(interfaceC6933Pp2.getClass())).toString());
        }

        public static InterfaceC6933Pp2 g(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                AbstractC18174oC7 abstractC18174oC7N0 = ((AbstractC4099Dr3) interfaceC5050Hr3).N0();
                if (abstractC18174oC7N0 instanceof AbstractC6200Mp2) {
                    return (AbstractC6200Mp2) abstractC18174oC7N0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static ZC6 g0(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            return InterfaceC6546Ny7.a.f(ku0, interfaceC5050Hr3);
        }

        public static ZC6 h(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                AbstractC18174oC7 abstractC18174oC7N0 = ((AbstractC4099Dr3) interfaceC5050Hr3).N0();
                if (abstractC18174oC7N0 instanceof XC6) {
                    return (XC6) abstractC18174oC7N0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static InterfaceC5050Hr3 h0(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3, boolean z) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof ZC6) {
                return ku0.c((ZC6) interfaceC5050Hr3, z);
            }
            if (!(interfaceC5050Hr3 instanceof InterfaceC6933Pp2)) {
                throw new IllegalStateException("sealed".toString());
            }
            InterfaceC6933Pp2 interfaceC6933Pp2 = (InterfaceC6933Pp2) interfaceC5050Hr3;
            return ku0.J(ku0.c(ku0.b(interfaceC6933Pp2), z), ku0.c(ku0.a(interfaceC6933Pp2), z));
        }

        public static InterfaceC9438Zx7 i(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                return AbstractC7731Sy7.a((AbstractC4099Dr3) interfaceC5050Hr3);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static ZC6 i0(KU0 ku0, ZC6 zc6, boolean z) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (zc6 instanceof XC6) {
                return ((XC6) zc6).O0(z);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static ZC6 j(KU0 ku0, ZC6 zc6, EnumC15839kG0 enumC15839kG0) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "type");
            AbstractC13042fc3.i(enumC15839kG0, "status");
            if (zc6 instanceof XC6) {
                return AbstractC25186zs4.b((XC6) zc6, enumC15839kG0);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
        }

        public static InterfaceC5050Hr3 k(KU0 ku0, ZC6 zc6, ZC6 zc62) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "lowerBound");
            AbstractC13042fc3.i(zc62, "upperBound");
            if (!(zc6 instanceof XC6)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + ku0 + ", " + AbstractC10882cM5.b(ku0.getClass())).toString());
            }
            if (zc62 instanceof XC6) {
                return C4567Fr3.d((XC6) zc6, (XC6) zc62);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + ku0 + ", " + AbstractC10882cM5.b(ku0.getClass())).toString());
        }

        public static InterfaceC9438Zx7 l(KU0 ku0, InterfaceC9204Yx7 interfaceC9204Yx7, int i) {
            return InterfaceC6546Ny7.a.a(ku0, interfaceC9204Yx7, i);
        }

        public static InterfaceC9438Zx7 m(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3, int i) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                return (InterfaceC9438Zx7) ((AbstractC4099Dr3) interfaceC5050Hr3).J0().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static C10027ax2 n(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                MU0 mu0D = ((InterfaceC13882gy7) interfaceC14475hy7).t();
                if (mu0D != null) {
                    return PI1.j((InterfaceC21331tU0) mu0D);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static InterfaceC24062xy7 o(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7, int i) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                Object obj = ((InterfaceC13882gy7) interfaceC14475hy7).getParameters().get(i);
                AbstractC13042fc3.h(obj, "this.parameters[index]");
                return (InterfaceC24062xy7) obj;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static EnumC4809Gq5 p(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                MU0 mu0D = ((InterfaceC13882gy7) interfaceC14475hy7).t();
                if (mu0D != null) {
                    return AbstractC19738qr3.O((InterfaceC21331tU0) mu0D);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static EnumC4809Gq5 q(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                MU0 mu0D = ((InterfaceC13882gy7) interfaceC14475hy7).t();
                if (mu0D != null) {
                    return AbstractC19738qr3.R((InterfaceC21331tU0) mu0D);
                }
                throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static InterfaceC5050Hr3 r(KU0 ku0, InterfaceC24062xy7 interfaceC24062xy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC24062xy7, "receiver");
            if (interfaceC24062xy7 instanceof InterfaceC22882vy7) {
                return AbstractC7731Sy7.f((InterfaceC22882vy7) interfaceC24062xy7);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC24062xy7 + ", " + AbstractC10882cM5.b(interfaceC24062xy7.getClass())).toString());
        }

        public static InterfaceC5050Hr3 s(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                return R73.e((AbstractC4099Dr3) interfaceC5050Hr3);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static InterfaceC5050Hr3 t(KU0 ku0, InterfaceC9438Zx7 interfaceC9438Zx7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC9438Zx7, "receiver");
            if (interfaceC9438Zx7 instanceof InterfaceC3932Cy7) {
                return ((InterfaceC3932Cy7) interfaceC9438Zx7).getType().N0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC9438Zx7 + ", " + AbstractC10882cM5.b(interfaceC9438Zx7.getClass())).toString());
        }

        public static InterfaceC24062xy7 u(KU0 ku0, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC14475hy7, "receiver");
            if (interfaceC14475hy7 instanceof InterfaceC13882gy7) {
                MU0 mu0D = ((InterfaceC13882gy7) interfaceC14475hy7).t();
                if (mu0D instanceof InterfaceC22882vy7) {
                    return (InterfaceC22882vy7) mu0D;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC14475hy7 + ", " + AbstractC10882cM5.b(interfaceC14475hy7.getClass())).toString());
        }

        public static EnumC8204Uy7 v(KU0 ku0, InterfaceC9438Zx7 interfaceC9438Zx7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC9438Zx7, "receiver");
            if (interfaceC9438Zx7 instanceof InterfaceC3932Cy7) {
                KQ7 kq7C = ((InterfaceC3932Cy7) interfaceC9438Zx7).c();
                AbstractC13042fc3.h(kq7C, "this.projectionKind");
                return AbstractC6286My7.a(kq7C);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC9438Zx7 + ", " + AbstractC10882cM5.b(interfaceC9438Zx7.getClass())).toString());
        }

        public static EnumC8204Uy7 w(KU0 ku0, InterfaceC24062xy7 interfaceC24062xy7) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC24062xy7, "receiver");
            if (interfaceC24062xy7 instanceof InterfaceC22882vy7) {
                KQ7 kq7M = ((InterfaceC22882vy7) interfaceC24062xy7).m();
                AbstractC13042fc3.h(kq7M, "this.variance");
                return AbstractC6286My7.a(kq7M);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC24062xy7 + ", " + AbstractC10882cM5.b(interfaceC24062xy7.getClass())).toString());
        }

        public static boolean x(KU0 ku0, InterfaceC5050Hr3 interfaceC5050Hr3, C9424Zw2 c9424Zw2) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            if (interfaceC5050Hr3 instanceof AbstractC4099Dr3) {
                return ((AbstractC4099Dr3) interfaceC5050Hr3).getAnnotations().M1(c9424Zw2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + interfaceC5050Hr3 + ", " + AbstractC10882cM5.b(interfaceC5050Hr3.getClass())).toString());
        }

        public static boolean y(KU0 ku0, ZC6 zc6, ZC6 zc62) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(zc6, "a");
            AbstractC13042fc3.i(zc62, "b");
            if (!(zc6 instanceof XC6)) {
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc6 + ", " + AbstractC10882cM5.b(zc6.getClass())).toString());
            }
            if (zc62 instanceof XC6) {
                return ((XC6) zc6).J0() == ((XC6) zc62).J0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + zc62 + ", " + AbstractC10882cM5.b(zc62.getClass())).toString());
        }

        public static InterfaceC5050Hr3 z(KU0 ku0, List list) {
            AbstractC13042fc3.i(ku0, "this");
            AbstractC13042fc3.i(list, "types");
            return AbstractC8461Wb3.a(list);
        }
    }

    InterfaceC5050Hr3 J(ZC6 zc6, ZC6 zc62);

    @Override // ir.nasim.InterfaceC6052Ly7
    ZC6 a(InterfaceC6933Pp2 interfaceC6933Pp2);

    @Override // ir.nasim.InterfaceC6052Ly7
    ZC6 b(InterfaceC6933Pp2 interfaceC6933Pp2);

    @Override // ir.nasim.InterfaceC6052Ly7
    ZC6 c(ZC6 zc6, boolean z);

    @Override // ir.nasim.InterfaceC6052Ly7
    InterfaceC14475hy7 d(ZC6 zc6);

    @Override // ir.nasim.InterfaceC6052Ly7
    ZC6 e(InterfaceC5050Hr3 interfaceC5050Hr3);
}
