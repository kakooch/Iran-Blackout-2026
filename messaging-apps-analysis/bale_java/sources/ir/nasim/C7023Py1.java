package ir.nasim;

import ir.nasim.XR7;

/* renamed from: ir.nasim.Py1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C7023Py1 {
    private final int a;
    private final byte[] b;

    private C7023Py1(int i, byte[] bArr) {
        this.a = i;
        this.b = bArr;
    }

    static C7023Py1[] b(byte[] bArr, XR7 xr7) {
        XR7.c cVarD = xr7.d();
        XR7.b[] bVarArrA = cVarD.a();
        int iA = 0;
        for (XR7.b bVar : bVarArrA) {
            iA += bVar.a();
        }
        C7023Py1[] c7023Py1Arr = new C7023Py1[iA];
        int i = 0;
        for (XR7.b bVar2 : bVarArrA) {
            int i2 = 0;
            while (i2 < bVar2.a()) {
                int iB = bVar2.b();
                c7023Py1Arr[i] = new C7023Py1(iB, new byte[cVarD.b() + iB]);
                i2++;
                i++;
            }
        }
        int length = c7023Py1Arr[0].b.length - cVarD.b();
        int i3 = length - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 0;
            while (i6 < i) {
                c7023Py1Arr[i6].b[i5] = bArr[i4];
                i6++;
                i4++;
            }
        }
        boolean z = xr7.i() == 24;
        int i7 = z ? 8 : i;
        int i8 = 0;
        while (i8 < i7) {
            c7023Py1Arr[i8].b[i3] = bArr[i4];
            i8++;
            i4++;
        }
        int length2 = c7023Py1Arr[0].b.length;
        while (length < length2) {
            int i9 = 0;
            while (i9 < i) {
                int i10 = z ? (i9 + 8) % i : i9;
                c7023Py1Arr[i10].b[(!z || i10 <= 7) ? length : length - 1] = bArr[i4];
                i9++;
                i4++;
            }
            length++;
        }
        if (i4 == bArr.length) {
            return c7023Py1Arr;
        }
        throw new IllegalArgumentException();
    }

    byte[] a() {
        return this.b;
    }

    int c() {
        return this.a;
    }
}
