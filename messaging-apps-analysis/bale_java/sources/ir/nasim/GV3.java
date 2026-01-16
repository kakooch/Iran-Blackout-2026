package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.zxing.WriterException;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
abstract class GV3 {
    private static final int[][] a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, Type.L64, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, Type.EUI48, 134, -1}, new int[]{6, 34, 60, 86, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, WKSRecord.Service.NETBIOS_DGM, -1}, new int[]{6, 30, 58, 86, 114, WKSRecord.Service.BL_IDM, -1}, new int[]{6, 34, 62, 90, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, Type.L64, WKSRecord.Service.CISCO_SYS, 158}, new int[]{6, 32, 58, 84, 110, 136, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER}, new int[]{6, 26, 54, 82, 110, WKSRecord.Service.NETBIOS_DGM, 166}, new int[]{6, 30, 58, 86, 114, WKSRecord.Service.BL_IDM, 170}};
    private static final int[][] d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(C3988Df0 c3988Df0, X92 x92, YR7 yr7, int i, C5722Ko0 c5722Ko0) throws WriterException {
        c(c5722Ko0);
        d(yr7, c5722Ko0);
        l(x92, i, c5722Ko0);
        s(yr7, c5722Ko0);
        f(c3988Df0, i, c5722Ko0);
    }

    static int b(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iN = n(i2);
        int iN2 = i << (iN - 1);
        while (n(iN2) >= iN) {
            iN2 ^= i2 << (n(iN2) - iN);
        }
        return iN2;
    }

    static void c(C5722Ko0 c5722Ko0) {
        c5722Ko0.a((byte) -1);
    }

    static void d(YR7 yr7, C5722Ko0 c5722Ko0) throws WriterException {
        j(c5722Ko0);
        e(c5722Ko0);
        r(yr7, c5722Ko0);
        k(c5722Ko0);
    }

    private static void e(C5722Ko0 c5722Ko0) throws WriterException {
        if (c5722Ko0.b(8, c5722Ko0.d() - 8) == 0) {
            throw new WriterException();
        }
        c5722Ko0.f(8, c5722Ko0.d() - 8, 1);
    }

    static void f(C3988Df0 c3988Df0, int i, C5722Ko0 c5722Ko0) throws WriterException {
        boolean zI;
        int iE = c5722Ko0.e() - 1;
        int iD = c5722Ko0.d() - 1;
        int i2 = 0;
        int i3 = -1;
        while (iE > 0) {
            if (iE == 6) {
                iE--;
            }
            while (iD >= 0 && iD < c5722Ko0.d()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = iE - i4;
                    if (o(c5722Ko0.b(i5, iD))) {
                        if (i2 < c3988Df0.n()) {
                            zI = c3988Df0.i(i2);
                            i2++;
                        } else {
                            zI = false;
                        }
                        if (i != -1 && HU3.f(i, i5, iD)) {
                            zI = !zI;
                        }
                        c5722Ko0.g(i5, iD, zI);
                    }
                }
                iD += i3;
            }
            i3 = -i3;
            iD += i3;
            iE -= 2;
        }
        if (i2 == c3988Df0.n()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i2 + '/' + c3988Df0.n());
    }

    private static void g(int i, int i2, C5722Ko0 c5722Ko0) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (!o(c5722Ko0.b(i4, i2))) {
                throw new WriterException();
            }
            c5722Ko0.f(i4, i2, 0);
        }
    }

    private static void h(int i, int i2, C5722Ko0 c5722Ko0) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                c5722Ko0.f(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void i(int i, int i2, C5722Ko0 c5722Ko0) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                c5722Ko0.f(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void j(C5722Ko0 c5722Ko0) throws WriterException {
        int length = a[0].length;
        i(0, 0, c5722Ko0);
        i(c5722Ko0.e() - length, 0, c5722Ko0);
        i(0, c5722Ko0.e() - length, c5722Ko0);
        g(0, 7, c5722Ko0);
        g(c5722Ko0.e() - 8, 7, c5722Ko0);
        g(0, c5722Ko0.e() - 8, c5722Ko0);
        m(7, 0, c5722Ko0);
        m(c5722Ko0.d() - 8, 0, c5722Ko0);
        m(7, c5722Ko0.d() - 7, c5722Ko0);
    }

    private static void k(C5722Ko0 c5722Ko0) {
        int i = 8;
        while (i < c5722Ko0.e() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (o(c5722Ko0.b(i, 6))) {
                c5722Ko0.f(i, 6, i3);
            }
            if (o(c5722Ko0.b(6, i))) {
                c5722Ko0.f(6, i, i3);
            }
            i = i2;
        }
    }

    static void l(X92 x92, int i, C5722Ko0 c5722Ko0) throws WriterException {
        C3988Df0 c3988Df0 = new C3988Df0();
        p(x92, i, c3988Df0);
        for (int i2 = 0; i2 < c3988Df0.n(); i2++) {
            boolean zI = c3988Df0.i((c3988Df0.n() - 1) - i2);
            int[] iArr = d[i2];
            c5722Ko0.g(iArr[0], iArr[1], zI);
            if (i2 < 8) {
                c5722Ko0.g((c5722Ko0.e() - i2) - 1, 8, zI);
            } else {
                c5722Ko0.g(8, (c5722Ko0.d() - 7) + (i2 - 8), zI);
            }
        }
    }

    private static void m(int i, int i2, C5722Ko0 c5722Ko0) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!o(c5722Ko0.b(i, i4))) {
                throw new WriterException();
            }
            c5722Ko0.f(i, i4, 0);
        }
    }

    static int n(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    private static boolean o(int i) {
        return i == -1;
    }

    static void p(X92 x92, int i, C3988Df0 c3988Df0) throws WriterException {
        if (!C21029sz5.b(i)) {
            throw new WriterException("Invalid mask pattern");
        }
        int iJ = (x92.j() << 3) | i;
        c3988Df0.d(iJ, 5);
        c3988Df0.d(b(iJ, 1335), 10);
        C3988Df0 c3988Df02 = new C3988Df0();
        c3988Df02.d(21522, 15);
        c3988Df0.v(c3988Df02);
        if (c3988Df0.n() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + c3988Df0.n());
    }

    static void q(YR7 yr7, C3988Df0 c3988Df0) throws WriterException {
        c3988Df0.d(yr7.j(), 6);
        c3988Df0.d(b(yr7.j(), 7973), 12);
        if (c3988Df0.n() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + c3988Df0.n());
    }

    private static void r(YR7 yr7, C5722Ko0 c5722Ko0) {
        if (yr7.j() < 2) {
            return;
        }
        int[] iArr = c[yr7.j() - 1];
        for (int i : iArr) {
            if (i >= 0) {
                for (int i2 : iArr) {
                    if (i2 >= 0 && o(c5722Ko0.b(i2, i))) {
                        h(i2 - 2, i - 2, c5722Ko0);
                    }
                }
            }
        }
    }

    static void s(YR7 yr7, C5722Ko0 c5722Ko0) throws WriterException {
        if (yr7.j() < 7) {
            return;
        }
        C3988Df0 c3988Df0 = new C3988Df0();
        q(yr7, c3988Df0);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean zI = c3988Df0.i(i);
                i--;
                c5722Ko0.g(i2, (c5722Ko0.d() - 11) + i3, zI);
                c5722Ko0.g((c5722Ko0.d() - 11) + i3, i2, zI);
            }
        }
    }
}
