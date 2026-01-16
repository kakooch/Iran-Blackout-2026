package ir.eitaa.messenger.time;

import ir.eitaa.messenger.R;

/* loaded from: classes.dex */
public class DateConverter {
    public static int[] gregorian_to_jalali(int gy, int gm, int gd) {
        int[] iArr = new int[3];
        iArr[0] = gm > 2 ? gy + 1 : gy;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[2] = ((((gy * 365) + 355666) + ((iArr[0] + 3) / 4)) - ((iArr[0] + 99) / 100)) + ((iArr[0] + 399) / 400) + gd + new int[]{0, 31, 59, 90, R.styleable.AppCompatTheme_windowNoTitle, 151, 181, 212, 243, 273, 304, 334}[gm - 1];
        iArr[0] = ((iArr[2] / 12053) * 33) - 1595;
        iArr[2] = iArr[2] % 12053;
        iArr[0] = iArr[0] + ((iArr[2] / 1461) * 4);
        iArr[2] = iArr[2] % 1461;
        if (iArr[2] > 365) {
            iArr[0] = iArr[0] + ((iArr[2] - 1) / 365);
            iArr[2] = (iArr[2] - 1) % 365;
        }
        if (iArr[2] < 186) {
            iArr[1] = (iArr[2] / 31) + 1;
            iArr[2] = (iArr[2] % 31) + 1;
        } else {
            iArr[1] = ((iArr[2] - 186) / 30) + 7;
            iArr[2] = ((iArr[2] - 186) % 30) + 1;
        }
        return iArr;
    }

    public static int[] jalali_to_gregorian(int jy, int jm, int jd) {
        int i = jy + 1595;
        int[] iArr = new int[3];
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = ((i * 365) - 355668) + ((i / 33) * 8) + (((i % 33) + 3) / 4) + jd + (jm < 7 ? (jm - 1) * 31 : ((jm - 7) * 30) + 186);
        iArr[0] = (iArr[2] / 146097) * 400;
        iArr[2] = iArr[2] % 146097;
        if (iArr[2] > 36524) {
            int i2 = iArr[0];
            int i3 = iArr[2] - 1;
            iArr[2] = i3;
            iArr[0] = i2 + ((i3 / 36524) * 100);
            iArr[2] = iArr[2] % 36524;
            if (iArr[2] >= 365) {
                iArr[2] = iArr[2] + 1;
            }
        }
        iArr[0] = iArr[0] + ((iArr[2] / 1461) * 4);
        iArr[2] = iArr[2] % 1461;
        if (iArr[2] > 365) {
            iArr[0] = iArr[0] + ((iArr[2] - 1) / 365);
            iArr[2] = (iArr[2] - 1) % 365;
        }
        int[] iArr2 = new int[13];
        iArr2[0] = 0;
        iArr2[1] = 31;
        iArr2[2] = ((iArr[0] % 4 != 0 || iArr[0] % 100 == 0) && iArr[0] % 400 != 0) ? 28 : 29;
        iArr2[3] = 31;
        iArr2[4] = 30;
        iArr2[5] = 31;
        iArr2[6] = 30;
        iArr2[7] = 31;
        iArr2[8] = 31;
        iArr2[9] = 30;
        iArr2[10] = 31;
        iArr2[11] = 30;
        iArr2[12] = 31;
        iArr[2] = iArr[2] + 1;
        while (iArr[1] < 13 && iArr[2] > iArr2[iArr[1]]) {
            iArr[2] = iArr[2] - iArr2[iArr[1]];
            iArr[1] = iArr[1] + 1;
        }
        return iArr;
    }
}
