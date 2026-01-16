package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ai.bale.proto.SetUpdatesStruct$ComposedUpdates;
import com.google.zxing.ChecksumException;
import com.google.zxing.NotFoundException;
import java.util.Arrays;
import java.util.Map;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* renamed from: ir.nasim.zW0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C24966zW0 extends MK4 {
    static final int[] e = {52, 289, 97, 352, 49, 304, SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, Type.DOA, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, SetRpcStruct$ComposedRpc.RESPONSE_START_PHONE_AUTH_FIELD_NUMBER, 448, SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER, 400, 208, WKSRecord.Service.STATSRV, 388, 196, 168, SetUpdatesStruct$ComposedUpdates.MESSAGE_CONTENT_CHANGED_FIELD_NUMBER, WKSRecord.Service.NETBIOS_DGM, 42};
    private final boolean a;
    private final boolean b;
    private final StringBuilder c;
    private final int[] d;

    public C24966zW0() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String g(java.lang.CharSequence r12) throws com.google.zxing.FormatException {
        /*
            int r0 = r12.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        Lb:
            if (r3 >= r0) goto Lbf
            char r4 = r12.charAt(r3)
            r5 = 47
            r6 = 37
            r7 = 36
            r8 = 43
            if (r4 == r8) goto L27
            if (r4 == r7) goto L27
            if (r4 == r6) goto L27
            if (r4 != r5) goto L22
            goto L27
        L22:
            r1.append(r4)
            goto Lb6
        L27:
            int r3 = r3 + 1
            char r9 = r12.charAt(r3)
            r10 = 90
            r11 = 65
            if (r4 == r7) goto Lac
            r7 = 79
            if (r4 == r6) goto L5e
            if (r4 == r8) goto L52
            if (r4 == r5) goto L3e
        L3b:
            r4 = r2
            goto Lb3
        L3e:
            if (r9 < r11) goto L47
            if (r9 > r7) goto L47
            int r9 = r9 + (-32)
        L44:
            char r4 = (char) r9
            goto Lb3
        L47:
            if (r9 != r10) goto L4d
            r4 = 58
            goto Lb3
        L4d:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.a()
            throw r12
        L52:
            if (r9 < r11) goto L59
            if (r9 > r10) goto L59
            int r9 = r9 + 32
            goto L44
        L59:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.a()
            throw r12
        L5e:
            if (r9 < r11) goto L67
            r4 = 69
            if (r9 > r4) goto L67
            int r9 = r9 + (-38)
            goto L44
        L67:
            r4 = 70
            if (r9 < r4) goto L72
            r4 = 74
            if (r9 > r4) goto L72
            int r9 = r9 + (-11)
            goto L44
        L72:
            r4 = 75
            if (r9 < r4) goto L7b
            if (r9 > r7) goto L7b
            int r9 = r9 + 16
            goto L44
        L7b:
            r4 = 80
            if (r9 < r4) goto L86
            r4 = 84
            if (r9 > r4) goto L86
            int r9 = r9 + 43
            goto L44
        L86:
            r4 = 85
            if (r9 != r4) goto L8b
            goto L3b
        L8b:
            r4 = 86
            if (r9 != r4) goto L92
            r4 = 64
            goto Lb3
        L92:
            r4 = 87
            if (r9 != r4) goto L99
            r4 = 96
            goto Lb3
        L99:
            r4 = 88
            if (r9 == r4) goto La9
            r4 = 89
            if (r9 == r4) goto La9
            if (r9 != r10) goto La4
            goto La9
        La4:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.a()
            throw r12
        La9:
            r4 = 127(0x7f, float:1.78E-43)
            goto Lb3
        Lac:
            if (r9 < r11) goto Lba
            if (r9 > r10) goto Lba
            int r9 = r9 + (-64)
            goto L44
        Lb3:
            r1.append(r4)
        Lb6:
            int r3 = r3 + 1
            goto Lb
        Lba:
            com.google.zxing.FormatException r12 = com.google.zxing.FormatException.a()
            throw r12
        Lbf:
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C24966zW0.g(java.lang.CharSequence):java.lang.String");
    }

    private static int[] h(C3988Df0 c3988Df0, int[] iArr) throws NotFoundException {
        int iN = c3988Df0.n();
        int iL = c3988Df0.l(0);
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = iL;
        while (iL < iN) {
            if (c3988Df0.i(iL) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else {
                    if (j(iArr) == 148 && c3988Df0.p(Math.max(0, i2 - ((iL - i2) / 2)), i2, false)) {
                        return new int[]{i2, iL};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            iL++;
        }
        throw NotFoundException.a();
    }

    private static char i(int i) throws NotFoundException {
        int i2 = 0;
        while (true) {
            int[] iArr = e;
            if (i2 >= iArr.length) {
                if (i == 148) {
                    return '*';
                }
                throw NotFoundException.a();
            }
            if (iArr[i2] == i) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i2);
            }
            i2++;
        }
    }

    private static int j(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override // ir.nasim.MK4
    public X06 b(int i, C3988Df0 c3988Df0, Map map) throws NotFoundException, ChecksumException {
        int[] iArr = this.d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.c;
        sb.setLength(0);
        int iL = c3988Df0.l(h(c3988Df0, iArr)[1]);
        int iN = c3988Df0.n();
        while (true) {
            MK4.e(c3988Df0, iL, iArr);
            int iJ = j(iArr);
            if (iJ < 0) {
                throw NotFoundException.a();
            }
            char cI = i(iJ);
            sb.append(cI);
            int i2 = iL;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iL2 = c3988Df0.l(i2);
            if (cI == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (iL2 - iL) - i4;
                if (iL2 != iN && (i6 << 1) < i4) {
                    throw NotFoundException.a();
                }
                if (this.a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.c.charAt(i7));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw ChecksumException.a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw NotFoundException.a();
                }
                float f = i;
                return new X06(this.b ? g(sb) : sb.toString(), null, new C12092e16[]{new C12092e16((r2[1] + r2[0]) / 2.0f, f), new C12092e16(iL + (i4 / 2.0f), f)}, EnumC9549a90.CODE_39);
            }
            iL = iL2;
        }
    }

    public C24966zW0(boolean z) {
        this(z, false);
    }

    public C24966zW0(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.c = new StringBuilder(20);
        this.d = new int[9];
    }
}
