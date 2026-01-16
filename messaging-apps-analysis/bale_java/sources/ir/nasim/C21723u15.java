package ir.nasim;

import java.util.ArrayList;

/* renamed from: ir.nasim.u15, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21723u15 {
    private float[] a = new float[64];

    public static /* synthetic */ ArrayList b(C21723u15 c21723u15, String str, ArrayList arrayList, int i, Object obj) {
        if ((i & 2) != 0) {
            arrayList = new ArrayList();
        }
        return c21723u15.a(str, arrayList);
    }

    public final ArrayList a(String str, ArrayList arrayList) {
        int i;
        char cCharAt;
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length && AbstractC13042fc3.k(str.charAt(i3), 32) <= 0) {
            i3++;
        }
        while (length > i3 && AbstractC13042fc3.k(str.charAt(length - 1), 32) <= 0) {
            length--;
        }
        int i4 = 0;
        while (i3 < length) {
            while (true) {
                i = i3 + 1;
                cCharAt = str.charAt(i3);
                int i5 = cCharAt | ' ';
                if ((i5 - 97) * (i5 - 122) <= 0 && i5 != 101) {
                    break;
                }
                if (i >= length) {
                    cCharAt = 0;
                    break;
                }
                i3 = i;
            }
            if (cCharAt != 0) {
                if ((cCharAt | ' ') != 122) {
                    i4 = 0;
                    while (true) {
                        if (i >= length || AbstractC13042fc3.k(str.charAt(i), 32) > 0) {
                            long jA = AbstractC19627qg2.a(str, i, length);
                            i2 = (int) (jA >>> 32);
                            float fIntBitsToFloat = Float.intBitsToFloat((int) (jA & 4294967295L));
                            if (!Float.isNaN(fIntBitsToFloat)) {
                                float[] fArr = this.a;
                                int i6 = i4 + 1;
                                fArr[i4] = fIntBitsToFloat;
                                if (i6 >= fArr.length) {
                                    float[] fArr2 = new float[i6 * 2];
                                    this.a = fArr2;
                                    AbstractC9648aK.i(fArr, fArr2, 0, 0, fArr.length);
                                }
                                i4 = i6;
                            }
                            while (i2 < length && str.charAt(i2) == ',') {
                                i2++;
                            }
                            if (i2 >= length || Float.isNaN(fIntBitsToFloat)) {
                                break;
                            }
                            i = i2;
                        } else {
                            i++;
                        }
                    }
                    i = i2;
                }
                AbstractC19246q15.a(cCharAt, arrayList, this.a, i4);
            }
            i3 = i;
        }
        return arrayList;
    }
}
