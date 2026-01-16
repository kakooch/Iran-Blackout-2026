package ir.nasim;

/* renamed from: ir.nasim.od8, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC18421od8 {
    public static void a(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = iArr[8];
        int i11 = iArr[9];
        int i12 = iArr2[0];
        int i13 = iArr2[1];
        int i14 = iArr2[2];
        int i15 = iArr2[3];
        int i16 = iArr2[4];
        int i17 = iArr2[5];
        int i18 = iArr2[6];
        int i19 = iArr2[7];
        int i20 = -i;
        int i21 = (i2 ^ i12) & i20;
        int i22 = (i3 ^ i13) & i20;
        int i23 = (i4 ^ i14) & i20;
        int i24 = (i5 ^ i15) & i20;
        int i25 = (i6 ^ i16) & i20;
        int i26 = (i7 ^ i17) & i20;
        int i27 = (i8 ^ i18) & i20;
        int i28 = (i9 ^ i19) & i20;
        int i29 = (i10 ^ iArr2[8]) & i20;
        int i30 = (i11 ^ iArr2[9]) & i20;
        iArr[0] = i2 ^ i21;
        iArr[1] = i3 ^ i22;
        iArr[2] = i4 ^ i23;
        iArr[3] = i5 ^ i24;
        iArr[4] = i6 ^ i25;
        iArr[5] = i7 ^ i26;
        iArr[6] = i8 ^ i27;
        iArr[7] = i9 ^ i28;
        iArr[8] = i10 ^ i29;
        iArr[9] = i11 ^ i30;
    }
}
