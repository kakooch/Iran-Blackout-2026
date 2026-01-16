package ir.nasim;

import java.util.Collection;
import java.util.List;

/* renamed from: ir.nasim.Ly7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC6052Ly7 extends InterfaceC6785Oy7 {

    /* renamed from: ir.nasim.Ly7$a */
    public static final class a {
        public static List a(InterfaceC6052Ly7 interfaceC6052Ly7, ZC6 zc6, InterfaceC14475hy7 interfaceC14475hy7) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            AbstractC13042fc3.i(interfaceC14475hy7, "constructor");
            return null;
        }

        public static InterfaceC9438Zx7 b(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC9204Yx7 interfaceC9204Yx7, int i) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC9204Yx7, "receiver");
            if (interfaceC9204Yx7 instanceof ZC6) {
                return interfaceC6052Ly7.L((InterfaceC5050Hr3) interfaceC9204Yx7, i);
            }
            if (interfaceC9204Yx7 instanceof C23664xJ) {
                E e = ((C23664xJ) interfaceC9204Yx7).get(i);
                AbstractC13042fc3.h(e, "get(index)");
                return (InterfaceC9438Zx7) e;
            }
            throw new IllegalStateException(("unknown type argument list type: " + interfaceC9204Yx7 + ", " + AbstractC10882cM5.b(interfaceC9204Yx7.getClass())).toString());
        }

        public static InterfaceC9438Zx7 c(InterfaceC6052Ly7 interfaceC6052Ly7, ZC6 zc6, int i) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            if (i < 0 || i >= interfaceC6052Ly7.g0(zc6)) {
                return null;
            }
            return interfaceC6052Ly7.L(zc6, i);
        }

        public static boolean d(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            return interfaceC6052Ly7.U(interfaceC6052Ly7.C(interfaceC5050Hr3)) != interfaceC6052Ly7.U(interfaceC6052Ly7.W(interfaceC5050Hr3));
        }

        public static boolean e(InterfaceC6052Ly7 interfaceC6052Ly7, ZC6 zc6) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            return interfaceC6052Ly7.A(interfaceC6052Ly7.d(zc6));
        }

        public static boolean f(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            ZC6 zc6E = interfaceC6052Ly7.e(interfaceC5050Hr3);
            return (zc6E == null ? null : interfaceC6052Ly7.z(zc6E)) != null;
        }

        public static boolean g(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            InterfaceC6933Pp2 interfaceC6933Pp2V = interfaceC6052Ly7.v(interfaceC5050Hr3);
            if (interfaceC6933Pp2V == null) {
                return false;
            }
            interfaceC6052Ly7.e0(interfaceC6933Pp2V);
            return false;
        }

        public static boolean h(InterfaceC6052Ly7 interfaceC6052Ly7, ZC6 zc6) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(zc6, "receiver");
            return interfaceC6052Ly7.V(interfaceC6052Ly7.d(zc6));
        }

        public static boolean i(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            return (interfaceC5050Hr3 instanceof ZC6) && interfaceC6052Ly7.U((ZC6) interfaceC5050Hr3);
        }

        public static boolean j(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            return interfaceC6052Ly7.G(interfaceC6052Ly7.g(interfaceC5050Hr3)) && !interfaceC6052Ly7.P(interfaceC5050Hr3);
        }

        public static ZC6 k(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            InterfaceC6933Pp2 interfaceC6933Pp2V = interfaceC6052Ly7.v(interfaceC5050Hr3);
            if (interfaceC6933Pp2V != null) {
                return interfaceC6052Ly7.b(interfaceC6933Pp2V);
            }
            ZC6 zc6E = interfaceC6052Ly7.e(interfaceC5050Hr3);
            AbstractC13042fc3.f(zc6E);
            return zc6E;
        }

        public static int l(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC9204Yx7 interfaceC9204Yx7) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC9204Yx7, "receiver");
            if (interfaceC9204Yx7 instanceof ZC6) {
                return interfaceC6052Ly7.g0((InterfaceC5050Hr3) interfaceC9204Yx7);
            }
            if (interfaceC9204Yx7 instanceof C23664xJ) {
                return ((C23664xJ) interfaceC9204Yx7).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + interfaceC9204Yx7 + ", " + AbstractC10882cM5.b(interfaceC9204Yx7.getClass())).toString());
        }

        public static InterfaceC14475hy7 m(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            ZC6 zc6E = interfaceC6052Ly7.e(interfaceC5050Hr3);
            if (zc6E == null) {
                zc6E = interfaceC6052Ly7.C(interfaceC5050Hr3);
            }
            return interfaceC6052Ly7.d(zc6E);
        }

        public static ZC6 n(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3) {
            AbstractC13042fc3.i(interfaceC6052Ly7, "this");
            AbstractC13042fc3.i(interfaceC5050Hr3, "receiver");
            InterfaceC6933Pp2 interfaceC6933Pp2V = interfaceC6052Ly7.v(interfaceC5050Hr3);
            if (interfaceC6933Pp2V != null) {
                return interfaceC6052Ly7.a(interfaceC6933Pp2V);
            }
            ZC6 zc6E = interfaceC6052Ly7.e(interfaceC5050Hr3);
            AbstractC13042fc3.f(zc6E);
            return zc6E;
        }
    }

    boolean A(InterfaceC14475hy7 interfaceC14475hy7);

    boolean B(ZC6 zc6);

    ZC6 C(InterfaceC5050Hr3 interfaceC5050Hr3);

    boolean E(InterfaceC14475hy7 interfaceC14475hy7);

    boolean F(ZC6 zc6);

    boolean G(InterfaceC14475hy7 interfaceC14475hy7);

    InterfaceC19385qG0 H(ZC6 zc6);

    boolean I(InterfaceC14475hy7 interfaceC14475hy7);

    InterfaceC5050Hr3 K(List list);

    InterfaceC9438Zx7 L(InterfaceC5050Hr3 interfaceC5050Hr3, int i);

    Collection M(InterfaceC14475hy7 interfaceC14475hy7);

    boolean P(InterfaceC5050Hr3 interfaceC5050Hr3);

    EnumC8204Uy7 Q(InterfaceC9438Zx7 interfaceC9438Zx7);

    int R(InterfaceC9204Yx7 interfaceC9204Yx7);

    InterfaceC5050Hr3 T(InterfaceC19385qG0 interfaceC19385qG0);

    boolean U(ZC6 zc6);

    boolean V(InterfaceC14475hy7 interfaceC14475hy7);

    ZC6 W(InterfaceC5050Hr3 interfaceC5050Hr3);

    InterfaceC9204Yx7 X(ZC6 zc6);

    boolean Y(InterfaceC14475hy7 interfaceC14475hy7);

    boolean Z(ZC6 zc6);

    ZC6 a(InterfaceC6933Pp2 interfaceC6933Pp2);

    InterfaceC5050Hr3 a0(InterfaceC9438Zx7 interfaceC9438Zx7);

    ZC6 b(InterfaceC6933Pp2 interfaceC6933Pp2);

    ZC6 b0(ZC6 zc6, EnumC15839kG0 enumC15839kG0);

    ZC6 c(ZC6 zc6, boolean z);

    InterfaceC14475hy7 d(ZC6 zc6);

    ZC6 e(InterfaceC5050Hr3 interfaceC5050Hr3);

    InterfaceC21056t22 e0(InterfaceC6933Pp2 interfaceC6933Pp2);

    boolean f(InterfaceC5050Hr3 interfaceC5050Hr3);

    boolean f0(InterfaceC19385qG0 interfaceC19385qG0);

    InterfaceC14475hy7 g(InterfaceC5050Hr3 interfaceC5050Hr3);

    int g0(InterfaceC5050Hr3 interfaceC5050Hr3);

    boolean h(InterfaceC14475hy7 interfaceC14475hy7);

    boolean h0(InterfaceC5050Hr3 interfaceC5050Hr3);

    InterfaceC24062xy7 i(InterfaceC14475hy7 interfaceC14475hy7, int i);

    boolean l(InterfaceC14475hy7 interfaceC14475hy7, InterfaceC14475hy7 interfaceC14475hy72);

    ZC6 m(EG1 eg1);

    InterfaceC9438Zx7 n(InterfaceC5050Hr3 interfaceC5050Hr3);

    boolean o(InterfaceC9438Zx7 interfaceC9438Zx7);

    InterfaceC5050Hr3 q(InterfaceC5050Hr3 interfaceC5050Hr3, boolean z);

    int s(InterfaceC14475hy7 interfaceC14475hy7);

    EnumC8204Uy7 t(InterfaceC24062xy7 interfaceC24062xy7);

    Collection u(ZC6 zc6);

    InterfaceC6933Pp2 v(InterfaceC5050Hr3 interfaceC5050Hr3);

    InterfaceC9438Zx7 w(InterfaceC9204Yx7 interfaceC9204Yx7, int i);

    InterfaceC5050Hr3 y(InterfaceC5050Hr3 interfaceC5050Hr3);

    EG1 z(ZC6 zc6);
}
