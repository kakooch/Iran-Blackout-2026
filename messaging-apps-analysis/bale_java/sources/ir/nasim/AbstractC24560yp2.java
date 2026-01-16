package ir.nasim;

import com.google.android.exoplayer2.ParserException;
import io.appmetrica.analytics.AppMetricaDefaultValues;

/* renamed from: ir.nasim.yp2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC24560yp2 {

    /* renamed from: ir.nasim.yp2$a */
    public static final class a {
        public long a;
    }

    private static boolean a(EW4 ew4, C3846Cp2 c3846Cp2, int i) {
        int iJ = j(ew4, i);
        return iJ != -1 && iJ <= c3846Cp2.b;
    }

    private static boolean b(EW4 ew4, int i) {
        return ew4.F() == AbstractC9683aN7.t(ew4.e(), i, ew4.f() - 1, 0);
    }

    private static boolean c(EW4 ew4, C3846Cp2 c3846Cp2, boolean z, a aVar) {
        try {
            long jM = ew4.M();
            if (!z) {
                jM *= c3846Cp2.b;
            }
            aVar.a = jM;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(EW4 ew4, C3846Cp2 c3846Cp2, int i, a aVar) {
        int iF = ew4.f();
        long jH = ew4.H();
        long j = jH >>> 16;
        if (j != i) {
            return false;
        }
        return g((int) ((jH >> 4) & 15), c3846Cp2) && f((int) ((jH >> 1) & 7), c3846Cp2) && !(((jH & 1) > 1L ? 1 : ((jH & 1) == 1L ? 0 : -1)) == 0) && c(ew4, c3846Cp2, ((j & 1) > 1L ? 1 : ((j & 1) == 1L ? 0 : -1)) == 0, aVar) && a(ew4, c3846Cp2, (int) ((jH >> 12) & 15)) && e(ew4, c3846Cp2, (int) ((jH >> 8) & 15)) && b(ew4, iF);
    }

    private static boolean e(EW4 ew4, C3846Cp2 c3846Cp2, int i) {
        int i2 = c3846Cp2.e;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            return i == c3846Cp2.f;
        }
        if (i == 12) {
            return ew4.F() * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT == i2;
        }
        if (i > 14) {
            return false;
        }
        int iL = ew4.L();
        if (i == 14) {
            iL *= 10;
        }
        return iL == i2;
    }

    private static boolean f(int i, C3846Cp2 c3846Cp2) {
        return i == 0 || i == c3846Cp2.i;
    }

    private static boolean g(int i, C3846Cp2 c3846Cp2) {
        return i <= 7 ? i == c3846Cp2.g - 1 : i <= 10 && c3846Cp2.g == 2;
    }

    public static boolean h(InterfaceC9845af2 interfaceC9845af2, C3846Cp2 c3846Cp2, int i, a aVar) {
        long jG = interfaceC9845af2.g();
        byte[] bArr = new byte[2];
        interfaceC9845af2.m(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
            interfaceC9845af2.e();
            interfaceC9845af2.h((int) (jG - interfaceC9845af2.getPosition()));
            return false;
        }
        EW4 ew4 = new EW4(16);
        System.arraycopy(bArr, 0, ew4.e(), 0, 2);
        ew4.R(AbstractC11055cf2.c(interfaceC9845af2, ew4.e(), 2, 14));
        interfaceC9845af2.e();
        interfaceC9845af2.h((int) (jG - interfaceC9845af2.getPosition()));
        return d(ew4, c3846Cp2, i, aVar);
    }

    public static long i(InterfaceC9845af2 interfaceC9845af2, C3846Cp2 c3846Cp2) throws ParserException {
        interfaceC9845af2.e();
        interfaceC9845af2.h(1);
        byte[] bArr = new byte[1];
        interfaceC9845af2.m(bArr, 0, 1);
        boolean z = (bArr[0] & 1) == 1;
        interfaceC9845af2.h(2);
        int i = z ? 7 : 6;
        EW4 ew4 = new EW4(i);
        ew4.R(AbstractC11055cf2.c(interfaceC9845af2, ew4.e(), 0, i));
        interfaceC9845af2.e();
        a aVar = new a();
        if (c(ew4, c3846Cp2, z, aVar)) {
            return aVar.a;
        }
        throw ParserException.a(null, null);
    }

    public static int j(EW4 ew4, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return ew4.F() + 1;
            case 7:
                return ew4.L() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }
}
