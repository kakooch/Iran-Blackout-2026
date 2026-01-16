package com.google.ads.interactivemedia.v3.internal;

import android.util.Pair;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class abf {
    private abq a;

    public abf() {
    }

    public abf(byte[] bArr) {
        this();
    }

    protected abstract Pair<ef[], aba[]> a(aay aayVar, int[][][] iArr, int[] iArr2) throws bn;

    protected final abq g() {
        abq abqVar = this.a;
        ary.t(abqVar);
        return abqVar;
    }

    public final void h(abq abqVar) {
        this.a = abqVar;
    }

    public abg i(ee[] eeVarArr, vj vjVar) throws bn {
        int length;
        int[] iArr;
        vj vjVar2 = vjVar;
        int length2 = eeVarArr.length + 1;
        int[] iArr2 = new int[length2];
        vh[][] vhVarArr = new vh[length2][];
        int[][][] iArr3 = new int[length2][][];
        int i = 0;
        for (int i2 = 0; i2 < length2; i2++) {
            int i3 = vjVar2.b;
            vhVarArr[i2] = new vh[i3];
            iArr3[i2] = new int[i3][];
        }
        int length3 = eeVarArr.length;
        int[] iArr4 = new int[length3];
        for (int i4 = 0; i4 < length3; i4++) {
            iArr4[i4] = eeVarArr[i4].s();
        }
        int i5 = 0;
        while (i5 < vjVar2.b) {
            vh vhVarA = vjVar2.a(i5);
            int iJ = adz.j(vhVarA.a(i).l);
            int length4 = eeVarArr.length;
            int i6 = 0;
            int i7 = 0;
            boolean z = true;
            while (true) {
                length = eeVarArr.length;
                if (i6 >= length) {
                    break;
                }
                ee eeVar = eeVarArr[i6];
                int iMax = 0;
                while (i < vhVarA.a) {
                    iMax = Math.max(iMax, asn.r(eeVar.O(vhVarA.a(i))));
                    i++;
                }
                boolean z2 = iArr2[i6] == 0;
                if (iMax > i7) {
                    z = z2;
                    i7 = iMax;
                    length4 = i6;
                } else if (iMax == i7 && iJ == 4 && !z && z2) {
                    i7 = iMax;
                    length4 = i6;
                    z = true;
                }
                i6++;
                i = 0;
            }
            if (length4 == length) {
                iArr = new int[vhVarA.a];
            } else {
                ee eeVar2 = eeVarArr[length4];
                int[] iArr5 = new int[vhVarA.a];
                for (int i8 = 0; i8 < vhVarA.a; i8++) {
                    iArr5[i8] = eeVar2.O(vhVarA.a(i8));
                }
                iArr = iArr5;
            }
            int i9 = iArr2[length4];
            vhVarArr[length4][i9] = vhVarA;
            iArr3[length4][i9] = iArr;
            iArr2[length4] = i9 + 1;
            i5++;
            vjVar2 = vjVar;
            i = 0;
        }
        int length5 = eeVarArr.length;
        vj[] vjVarArr = new vj[length5];
        String[] strArr = new String[length5];
        int[] iArr6 = new int[length5];
        int i10 = 0;
        while (true) {
            int length6 = eeVarArr.length;
            if (i10 >= length6) {
                new vj((vh[]) aeu.h(vhVarArr[length6], iArr2[length6]));
                aay aayVar = new aay(iArr6, vjVarArr);
                Pair<ef[], aba[]> pairA = a(aayVar, iArr3, iArr4);
                return new abg((ef[]) pairA.first, (aba[]) pairA.second, aayVar);
            }
            int i11 = iArr2[i10];
            vjVarArr[i10] = new vj((vh[]) aeu.h(vhVarArr[i10], i11));
            iArr3[i10] = (int[][]) aeu.h(iArr3[i10], i11);
            strArr[i10] = eeVarArr[i10].K();
            iArr6[i10] = eeVarArr[i10].a();
            i10++;
        }
    }
}
