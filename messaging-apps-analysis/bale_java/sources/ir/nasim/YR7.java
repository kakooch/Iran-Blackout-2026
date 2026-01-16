package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.zxing.FormatException;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public final class YR7 {
    private static final int[] e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final YR7[] f = b();
    private final int a;
    private final int[] b;
    private final b[] c;
    private final int d;

    public static final class a {
        private final int a;
        private final int b;

        a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }
    }

    public static final class b {
        private final int a;
        private final a[] b;

        b(int i, a... aVarArr) {
            this.a = i;
            this.b = aVarArr;
        }

        public a[] a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }

        public int c() {
            int iA = 0;
            for (a aVar : this.b) {
                iA += aVar.a();
            }
            return iA;
        }

        public int d() {
            return this.a * c();
        }
    }

    private YR7(int i, int[] iArr, b... bVarArr) {
        this.a = i;
        this.b = iArr;
        this.c = bVarArr;
        int iB = bVarArr[0].b();
        int iA = 0;
        for (a aVar : bVarArr[0].a()) {
            iA += aVar.a() * (aVar.b() + iB);
        }
        this.d = iA;
    }

    private static YR7[] b() {
        return new YR7[]{new YR7(1, new int[0], new b(7, new a(1, 19)), new b(10, new a(1, 16)), new b(13, new a(1, 13)), new b(17, new a(1, 9))), new YR7(2, new int[]{6, 18}, new b(10, new a(1, 34)), new b(16, new a(1, 28)), new b(22, new a(1, 22)), new b(28, new a(1, 16))), new YR7(3, new int[]{6, 22}, new b(15, new a(1, 55)), new b(26, new a(1, 44)), new b(18, new a(2, 17)), new b(22, new a(2, 13))), new YR7(4, new int[]{6, 26}, new b(20, new a(1, 80)), new b(18, new a(2, 32)), new b(26, new a(2, 24)), new b(16, new a(4, 9))), new YR7(5, new int[]{6, 30}, new b(26, new a(1, Type.EUI48)), new b(24, new a(2, 43)), new b(18, new a(2, 15), new a(2, 16)), new b(22, new a(2, 11), new a(2, 12))), new YR7(6, new int[]{6, 34}, new b(18, new a(2, 68)), new b(16, new a(4, 27)), new b(24, new a(4, 19)), new b(28, new a(4, 15))), new YR7(7, new int[]{6, 22, 38}, new b(20, new a(2, 78)), new b(18, new a(4, 31)), new b(18, new a(2, 14), new a(4, 15)), new b(26, new a(4, 13), new a(1, 14))), new YR7(8, new int[]{6, 24, 42}, new b(24, new a(2, 97)), new b(22, new a(2, 38), new a(2, 39)), new b(22, new a(4, 18), new a(2, 19)), new b(26, new a(4, 14), new a(2, 15))), new YR7(9, new int[]{6, 26, 46}, new b(30, new a(2, 116)), new b(22, new a(3, 36), new a(2, 37)), new b(20, new a(4, 16), new a(4, 17)), new b(24, new a(4, 12), new a(4, 13))), new YR7(10, new int[]{6, 28, 50}, new b(18, new a(2, 68), new a(2, 69)), new b(26, new a(4, 43), new a(1, 44)), new b(24, new a(6, 19), new a(2, 20)), new b(28, new a(6, 15), new a(2, 16))), new YR7(11, new int[]{6, 30, 54}, new b(20, new a(4, 81)), new b(30, new a(1, 50), new a(4, 51)), new b(28, new a(4, 22), new a(4, 23)), new b(24, new a(3, 12), new a(8, 13))), new YR7(12, new int[]{6, 32, 58}, new b(24, new a(2, 92), new a(2, 93)), new b(22, new a(6, 36), new a(2, 37)), new b(26, new a(4, 20), new a(6, 21)), new b(28, new a(7, 14), new a(4, 15))), new YR7(13, new int[]{6, 34, 62}, new b(26, new a(4, 107)), new b(22, new a(8, 37), new a(1, 38)), new b(24, new a(8, 20), new a(4, 21)), new b(22, new a(12, 11), new a(4, 12))), new YR7(14, new int[]{6, 26, 46, 66}, new b(30, new a(3, 115), new a(1, 116)), new b(24, new a(4, 40), new a(5, 41)), new b(20, new a(11, 16), new a(5, 17)), new b(24, new a(11, 12), new a(5, 13))), new YR7(15, new int[]{6, 26, 48, 70}, new b(22, new a(5, 87), new a(1, 88)), new b(24, new a(5, 41), new a(5, 42)), new b(30, new a(5, 24), new a(7, 25)), new b(24, new a(11, 12), new a(7, 13))), new YR7(16, new int[]{6, 26, 50, 74}, new b(24, new a(5, 98), new a(1, 99)), new b(28, new a(7, 45), new a(3, 46)), new b(24, new a(15, 19), new a(2, 20)), new b(30, new a(3, 15), new a(13, 16))), new YR7(17, new int[]{6, 30, 54, 78}, new b(28, new a(1, 107), new a(5, Type.EUI48)), new b(28, new a(10, 46), new a(1, 47)), new b(28, new a(1, 22), new a(15, 23)), new b(28, new a(2, 14), new a(17, 15))), new YR7(18, new int[]{6, 30, 56, 82}, new b(30, new a(5, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER), new a(1, WKSRecord.Service.ERPC)), new b(26, new a(9, 43), new a(4, 44)), new b(28, new a(17, 22), new a(1, 23)), new b(28, new a(2, 14), new a(19, 15))), new YR7(19, new int[]{6, 30, 58, 86}, new b(28, new a(3, 113), new a(4, 114)), new b(26, new a(3, 44), new a(11, 45)), new b(26, new a(17, 21), new a(4, 22)), new b(26, new a(9, 13), new a(16, 14))), new YR7(20, new int[]{6, 34, 62, 90}, new b(28, new a(3, 107), new a(5, Type.EUI48)), new b(26, new a(3, 41), new a(13, 42)), new b(30, new a(15, 24), new a(5, 25)), new b(28, new a(15, 15), new a(10, 16))), new YR7(21, new int[]{6, 28, 50, 72, 94}, new b(28, new a(4, 116), new a(4, WKSRecord.Service.UUCP_PATH)), new b(26, new a(17, 42)), new b(28, new a(17, 22), new a(6, 23)), new b(30, new a(19, 16), new a(6, 17))), new YR7(22, new int[]{6, 26, 50, 74, 98}, new b(28, new a(2, WKSRecord.Service.SUNRPC), new a(7, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER)), new b(28, new a(17, 46)), new b(30, new a(7, 24), new a(16, 25)), new b(24, new a(34, 13))), new YR7(23, new int[]{6, 30, 54, 78, 102}, new b(30, new a(4, WKSRecord.Service.ERPC), new a(5, 122)), new b(28, new a(4, 47), new a(14, 48)), new b(30, new a(11, 24), new a(14, 25)), new b(30, new a(16, 15), new a(14, 16))), new YR7(24, new int[]{6, 28, 54, 80, Type.L64}, new b(30, new a(6, WKSRecord.Service.UUCP_PATH), new a(4, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER)), new b(28, new a(6, 45), new a(14, 46)), new b(30, new a(11, 24), new a(16, 25)), new b(30, new a(30, 16), new a(2, 17))), new YR7(25, new int[]{6, 32, 58, 84, 110}, new b(26, new a(8, Type.L64), new a(4, 107)), new b(28, new a(8, 47), new a(13, 48)), new b(30, new a(7, 24), new a(22, 25)), new b(30, new a(22, 15), new a(13, 16))), new YR7(26, new int[]{6, 30, 58, 86, 114}, new b(28, new a(10, 114), new a(2, 115)), new b(28, new a(19, 46), new a(4, 47)), new b(28, new a(28, 22), new a(6, 23)), new b(30, new a(33, 16), new a(4, 17))), new YR7(27, new int[]{6, 34, 62, 90, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER}, new b(30, new a(8, 122), new a(4, 123)), new b(28, new a(22, 45), new a(3, 46)), new b(30, new a(8, 23), new a(26, 24)), new b(30, new a(12, 15), new a(28, 16))), new YR7(28, new int[]{6, 26, 50, 74, 98, 122}, new b(30, new a(3, WKSRecord.Service.UUCP_PATH), new a(10, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER)), new b(28, new a(3, 45), new a(23, 46)), new b(30, new a(4, 24), new a(31, 25)), new b(30, new a(11, 15), new a(31, 16))), new YR7(29, new int[]{6, 30, 54, 78, 102, 126}, new b(30, new a(7, 116), new a(7, WKSRecord.Service.UUCP_PATH)), new b(28, new a(21, 45), new a(7, 46)), new b(30, new a(1, 23), new a(37, 24)), new b(30, new a(19, 15), new a(26, 16))), new YR7(30, new int[]{6, 26, 52, 78, 104, 130}, new b(30, new a(5, 115), new a(10, 116)), new b(28, new a(19, 47), new a(10, 48)), new b(30, new a(15, 24), new a(25, 25)), new b(30, new a(23, 15), new a(25, 16))), new YR7(31, new int[]{6, 30, 56, 82, Type.EUI48, 134}, new b(30, new a(13, 115), new a(3, 116)), new b(28, new a(2, 46), new a(29, 47)), new b(30, new a(42, 24), new a(1, 25)), new b(30, new a(23, 15), new a(28, 16))), new YR7(32, new int[]{6, 34, 60, 86, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, WKSRecord.Service.NETBIOS_DGM}, new b(30, new a(17, 115)), new b(28, new a(10, 46), new a(23, 47)), new b(30, new a(10, 24), new a(35, 25)), new b(30, new a(19, 15), new a(35, 16))), new YR7(33, new int[]{6, 30, 58, 86, 114, WKSRecord.Service.BL_IDM}, new b(30, new a(17, 115), new a(1, 116)), new b(28, new a(14, 46), new a(21, 47)), new b(30, new a(29, 24), new a(19, 25)), new b(30, new a(11, 15), new a(46, 16))), new YR7(34, new int[]{6, 34, 62, 90, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER, SetRpcStruct$ComposedRpc.RESPONSE_GET_USER_CONTEXT_FIELD_NUMBER}, new b(30, new a(13, 115), new a(6, 116)), new b(28, new a(14, 46), new a(23, 47)), new b(30, new a(44, 24), new a(7, 25)), new b(30, new a(59, 16), new a(1, 17))), new YR7(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new b(30, new a(12, WKSRecord.Service.ERPC), new a(7, 122)), new b(28, new a(12, 47), new a(26, 48)), new b(30, new a(39, 24), new a(14, 25)), new b(30, new a(22, 15), new a(41, 16))), new YR7(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new b(30, new a(6, WKSRecord.Service.ERPC), new a(14, 122)), new b(28, new a(6, 47), new a(34, 48)), new b(30, new a(46, 24), new a(10, 25)), new b(30, new a(2, 15), new a(64, 16))), new YR7(37, new int[]{6, 28, 54, 80, Type.L64, WKSRecord.Service.CISCO_SYS, 158}, new b(30, new a(17, 122), new a(4, 123)), new b(28, new a(29, 46), new a(14, 47)), new b(30, new a(49, 24), new a(10, 25)), new b(30, new a(24, 15), new a(46, 16))), new YR7(38, new int[]{6, 32, 58, 84, 110, 136, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER}, new b(30, new a(4, 122), new a(18, 123)), new b(28, new a(13, 46), new a(32, 47)), new b(30, new a(48, 24), new a(14, 25)), new b(30, new a(42, 15), new a(32, 16))), new YR7(39, new int[]{6, 26, 54, 82, 110, WKSRecord.Service.NETBIOS_DGM, 166}, new b(30, new a(20, WKSRecord.Service.UUCP_PATH), new a(4, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER)), new b(28, new a(40, 47), new a(7, 48)), new b(30, new a(43, 24), new a(22, 25)), new b(30, new a(10, 15), new a(67, 16))), new YR7(40, new int[]{6, 30, 58, 86, 114, WKSRecord.Service.BL_IDM, 170}, new b(30, new a(19, SetRpcStruct$ComposedRpc.LOAD_HISTORY_FIELD_NUMBER), new a(6, 119)), new b(28, new a(18, 47), new a(31, 48)), new b(30, new a(34, 24), new a(34, 25)), new b(30, new a(20, 15), new a(61, 16)))};
    }

    static YR7 c(int i) {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = e;
            if (i3 >= iArr.length) {
                if (i2 <= 3) {
                    return i(i4);
                }
                return null;
            }
            int i5 = iArr[i3];
            if (i5 == i) {
                return i(i3 + 7);
            }
            int iE = C22254uv2.e(i, i5);
            if (iE < i2) {
                i4 = i3 + 7;
                i2 = iE;
            }
            i3++;
        }
    }

    public static YR7 g(int i) throws FormatException {
        if (i % 4 != 1) {
            throw FormatException.a();
        }
        try {
            return i((i - 17) / 4);
        } catch (IllegalArgumentException unused) {
            throw FormatException.a();
        }
    }

    public static YR7 i(int i) {
        if (i <= 0 || i > 40) {
            throw new IllegalArgumentException();
        }
        return f[i - 1];
    }

    C4705Gf0 a() {
        int iE = e();
        C4705Gf0 c4705Gf0 = new C4705Gf0(iE);
        c4705Gf0.p(0, 0, 9, 9);
        int i = iE - 8;
        c4705Gf0.p(i, 0, 8, 9);
        c4705Gf0.p(0, i, 9, 8);
        int length = this.b.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = this.b[i2] - 2;
            for (int i4 = 0; i4 < length; i4++) {
                if ((i2 != 0 || (i4 != 0 && i4 != length - 1)) && (i2 != length - 1 || i4 != 0)) {
                    c4705Gf0.p(this.b[i4] - 2, i3, 5, 5);
                }
            }
        }
        int i5 = iE - 17;
        c4705Gf0.p(6, 9, 1, i5);
        c4705Gf0.p(9, 6, i5, 1);
        if (this.a > 6) {
            int i6 = iE - 11;
            c4705Gf0.p(i6, 0, 3, 6);
            c4705Gf0.p(0, i6, 6, 3);
        }
        return c4705Gf0;
    }

    public int[] d() {
        return this.b;
    }

    public int e() {
        return (this.a * 4) + 17;
    }

    public b f(X92 x92) {
        return this.c[x92.ordinal()];
    }

    public int h() {
        return this.d;
    }

    public int j() {
        return this.a;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
