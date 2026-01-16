package ir.nasim;

/* loaded from: classes2.dex */
public abstract class KH0 {
    public static void a(long j, EW4 ew4, InterfaceC4589Ft7[] interfaceC4589Ft7Arr) {
        while (true) {
            if (ew4.a() <= 1) {
                return;
            }
            int iC = c(ew4);
            int iC2 = c(ew4);
            int iF = ew4.f() + iC2;
            if (iC2 == -1 || iC2 > ew4.a()) {
                AbstractC18815pI3.k("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iF = ew4.g();
            } else if (iC == 4 && iC2 >= 8) {
                int iF2 = ew4.F();
                int iL = ew4.L();
                int iO = iL == 49 ? ew4.o() : 0;
                int iF3 = ew4.F();
                if (iL == 47) {
                    ew4.T(1);
                }
                boolean z = iF2 == 181 && (iL == 49 || iL == 47) && iF3 == 3;
                if (iL == 49) {
                    z &= iO == 1195456820;
                }
                if (z) {
                    b(j, ew4, interfaceC4589Ft7Arr);
                }
            }
            ew4.S(iF);
        }
    }

    public static void b(long j, EW4 ew4, InterfaceC4589Ft7[] interfaceC4589Ft7Arr) {
        int iF = ew4.F();
        if ((iF & 64) != 0) {
            ew4.T(1);
            int i = (iF & 31) * 3;
            int iF2 = ew4.f();
            for (InterfaceC4589Ft7 interfaceC4589Ft7 : interfaceC4589Ft7Arr) {
                ew4.S(iF2);
                interfaceC4589Ft7.d(ew4, i);
                if (j != -9223372036854775807L) {
                    interfaceC4589Ft7.b(j, 1, i, 0, null);
                }
            }
        }
    }

    private static int c(EW4 ew4) {
        int i = 0;
        while (ew4.a() != 0) {
            int iF = ew4.F();
            i += iF;
            if (iF != 255) {
                return i;
            }
        }
        return -1;
    }
}
