package ir.nasim;

/* loaded from: classes8.dex */
public final class Z1 {
    public static final Z1 a = new Z1();

    private Z1() {
    }

    private final boolean a(InterfaceC6052Ly7 interfaceC6052Ly7, ZC6 zc6, ZC6 zc62) {
        int iG0;
        if (interfaceC6052Ly7.g0(zc6) == interfaceC6052Ly7.g0(zc62) && interfaceC6052Ly7.U(zc6) == interfaceC6052Ly7.U(zc62)) {
            if ((interfaceC6052Ly7.z(zc6) == null) == (interfaceC6052Ly7.z(zc62) == null) && interfaceC6052Ly7.l(interfaceC6052Ly7.d(zc6), interfaceC6052Ly7.d(zc62))) {
                if (!interfaceC6052Ly7.d0(zc6, zc62) && (iG0 = interfaceC6052Ly7.g0(zc6)) > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        InterfaceC9438Zx7 interfaceC9438Zx7L = interfaceC6052Ly7.L(zc6, i);
                        InterfaceC9438Zx7 interfaceC9438Zx7L2 = interfaceC6052Ly7.L(zc62, i);
                        if (interfaceC6052Ly7.o(interfaceC9438Zx7L) != interfaceC6052Ly7.o(interfaceC9438Zx7L2)) {
                            return false;
                        }
                        if (!interfaceC6052Ly7.o(interfaceC9438Zx7L) && (interfaceC6052Ly7.Q(interfaceC9438Zx7L) != interfaceC6052Ly7.Q(interfaceC9438Zx7L2) || !c(interfaceC6052Ly7, interfaceC6052Ly7.a0(interfaceC9438Zx7L), interfaceC6052Ly7.a0(interfaceC9438Zx7L2)))) {
                            return false;
                        }
                        if (i2 >= iG0) {
                            break;
                        }
                        i = i2;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean c(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32) {
        if (interfaceC5050Hr3 == interfaceC5050Hr32) {
            return true;
        }
        ZC6 zc6E = interfaceC6052Ly7.e(interfaceC5050Hr3);
        ZC6 zc6E2 = interfaceC6052Ly7.e(interfaceC5050Hr32);
        if (zc6E != null && zc6E2 != null) {
            return a(interfaceC6052Ly7, zc6E, zc6E2);
        }
        InterfaceC6933Pp2 interfaceC6933Pp2V = interfaceC6052Ly7.v(interfaceC5050Hr3);
        InterfaceC6933Pp2 interfaceC6933Pp2V2 = interfaceC6052Ly7.v(interfaceC5050Hr32);
        if (interfaceC6933Pp2V == null || interfaceC6933Pp2V2 == null) {
            return false;
        }
        return a(interfaceC6052Ly7, interfaceC6052Ly7.b(interfaceC6933Pp2V), interfaceC6052Ly7.b(interfaceC6933Pp2V2)) && a(interfaceC6052Ly7, interfaceC6052Ly7.a(interfaceC6933Pp2V), interfaceC6052Ly7.a(interfaceC6933Pp2V2));
    }

    public final boolean b(InterfaceC6052Ly7 interfaceC6052Ly7, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32) {
        AbstractC13042fc3.i(interfaceC6052Ly7, "context");
        AbstractC13042fc3.i(interfaceC5050Hr3, "a");
        AbstractC13042fc3.i(interfaceC5050Hr32, "b");
        return c(interfaceC6052Ly7, interfaceC5050Hr3, interfaceC5050Hr32);
    }
}
