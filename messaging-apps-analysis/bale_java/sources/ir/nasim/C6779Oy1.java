package ir.nasim;

import ir.nasim.YR7;

/* renamed from: ir.nasim.Oy1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C6779Oy1 {
    private final int a;
    private final byte[] b;

    private C6779Oy1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static C6779Oy1[] b(byte[] bArr, YR7 yr7, X92 x92) {
        if (bArr.length != yr7.h()) {
            throw new IllegalArgumentException();
        }
        YR7.b bVarF = yr7.f(x92);
        YR7.a[] aVarArrA = bVarF.a();
        int iA = 0;
        for (YR7.a aVar : aVarArrA) {
            iA += aVar.a();
        }
        C6779Oy1[] c6779Oy1Arr = new C6779Oy1[iA];
        int i = 0;
        for (YR7.a aVar2 : aVarArrA) {
            int i2 = 0;
            while (i2 < aVar2.a()) {
                int iB = aVar2.b();
                c6779Oy1Arr[i] = new C6779Oy1(iB, new byte[bVarF.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = c6779Oy1Arr[0].b.length;
        int i3 = iA - 1;
        while (i3 >= 0 && c6779Oy1Arr[i3].b.length != length) {
            i3--;
        }
        int i4 = i3 + 1;
        int iB2 = length - bVarF.b();
        int i5 = 0;
        for (int i6 = 0; i6 < iB2; i6++) {
            int i7 = 0;
            while (i7 < i) {
                c6779Oy1Arr[i7].b[i6] = bArr[i5];
                i7++;
                i5++;
            }
        }
        int i8 = i4;
        while (i8 < i) {
            c6779Oy1Arr[i8].b[iB2] = bArr[i5];
            i8++;
            i5++;
        }
        int length2 = c6779Oy1Arr[0].b.length;
        while (iB2 < length2) {
            int i9 = 0;
            while (i9 < i) {
                c6779Oy1Arr[i9].b[i9 < i4 ? iB2 : iB2 + 1] = bArr[i5];
                i9++;
                i5++;
            }
            iB2++;
        }
        return c6779Oy1Arr;
    }

    byte[] a() {
        return this.b;
    }

    int c() {
        return this.a;
    }
}
