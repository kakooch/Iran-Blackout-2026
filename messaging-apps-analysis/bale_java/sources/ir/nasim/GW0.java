package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import android.util.Pair;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class GW0 {
    private static final byte[] a = {0, 0, 0, 1};
    private static final String[] b = {"", "A", "B", TokenNames.C};

    public static String a(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static List b(boolean z) {
        return Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        StringBuilder sb = new StringBuilder(AbstractC9683aN7.A("hvc1.%s%d.%X.%c%d", b[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(z ? 'H' : 'L'), Integer.valueOf(i4)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, int i, int i2) {
        byte[] bArr2 = a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }

    public static Pair e(byte[] bArr) {
        EW4 ew4 = new EW4(bArr);
        ew4.S(9);
        int iF = ew4.F();
        ew4.S(20);
        return Pair.create(Integer.valueOf(ew4.J()), Integer.valueOf(iF));
    }

    public static boolean f(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }
}
