package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import com.google.android.exoplayer2.ParserException;

/* loaded from: classes2.dex */
public abstract class K {
    private static final int[] a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static final class b {
        public final int a;
        public final int b;
        public final String c;

        private b(int i, int i2, String str) {
            this.a = i;
            this.b = i2;
            this.c = str;
        }
    }

    public static byte[] a(int i, int i2, int i3) {
        return new byte[]{(byte) (((i << 3) & 248) | ((i2 >> 1) & 7)), (byte) (((i2 << 7) & 128) | ((i3 << 3) & SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER))};
    }

    private static int b(DW4 dw4) {
        int iH = dw4.h(5);
        return iH == 31 ? dw4.h(6) + 32 : iH;
    }

    private static int c(DW4 dw4) throws ParserException {
        int iH = dw4.h(4);
        if (iH == 15) {
            if (dw4.b() >= 24) {
                return dw4.h(24);
            }
            throw ParserException.a("AAC header insufficient data", null);
        }
        if (iH < 13) {
            return a[iH];
        }
        throw ParserException.a("AAC header wrong Sampling Frequency Index", null);
    }

    public static b d(DW4 dw4, boolean z) throws ParserException {
        int iB = b(dw4);
        int iC = c(dw4);
        int iH = dw4.h(4);
        String str = "mp4a.40." + iB;
        if (iB == 5 || iB == 29) {
            iC = c(dw4);
            iB = b(dw4);
            if (iB == 22) {
                iH = dw4.h(4);
            }
        }
        if (z) {
            if (iB != 1 && iB != 2 && iB != 3 && iB != 4 && iB != 6 && iB != 7 && iB != 17) {
                switch (iB) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.d("Unsupported audio object type: " + iB);
                }
            }
            f(dw4, iB, iH);
            switch (iB) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = dw4.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw ParserException.d("Unsupported epConfig: " + iH2);
                    }
            }
        }
        int i = b[iH];
        if (i != -1) {
            return new b(iC, i, str);
        }
        throw ParserException.a(null, null);
    }

    public static b e(byte[] bArr) {
        return d(new DW4(bArr), false);
    }

    private static void f(DW4 dw4, int i, int i2) {
        if (dw4.g()) {
            AbstractC18815pI3.k("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (dw4.g()) {
            dw4.r(14);
        }
        boolean zG = dw4.g();
        if (i2 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i == 6 || i == 20) {
            dw4.r(3);
        }
        if (zG) {
            if (i == 22) {
                dw4.r(16);
            }
            if (i == 17 || i == 19 || i == 20 || i == 23) {
                dw4.r(3);
            }
            dw4.r(1);
        }
    }
}
