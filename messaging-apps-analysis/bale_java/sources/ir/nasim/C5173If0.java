package ir.nasim;

import com.google.zxing.FormatException;

/* renamed from: ir.nasim.If0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C5173If0 {
    private final C4705Gf0 a;
    private YR7 b;
    private C22254uv2 c;
    private boolean d;

    C5173If0(C4705Gf0 c4705Gf0) throws FormatException {
        int i = c4705Gf0.i();
        if (i < 21 || (i & 3) != 1) {
            throw FormatException.a();
        }
        this.a = c4705Gf0;
    }

    private int a(int i, int i2, int i3) {
        return this.d ? this.a.e(i2, i) : this.a.e(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    void b() {
        int i = 0;
        while (i < this.a.m()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.a.i(); i3++) {
                if (this.a.e(i, i3) != this.a.e(i3, i)) {
                    this.a.d(i3, i);
                    this.a.d(i, i3);
                }
            }
            i = i2;
        }
    }

    byte[] c() throws FormatException {
        C22254uv2 c22254uv2D = d();
        YR7 yr7E = e();
        EnumC10044az1 enumC10044az1 = EnumC10044az1.values()[c22254uv2D.c()];
        int i = this.a.i();
        enumC10044az1.j(this.a, i);
        C4705Gf0 c4705Gf0A = yr7E.a();
        byte[] bArr = new byte[yr7E.h()];
        int i2 = i - 1;
        boolean z = true;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = z ? i2 - i7 : i7;
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = i3 - i9;
                    if (!c4705Gf0A.e(i10, i8)) {
                        i5++;
                        i6 <<= 1;
                        if (this.a.e(i10, i8)) {
                            i6 |= 1;
                        }
                        if (i5 == 8) {
                            bArr[i4] = (byte) i6;
                            i4++;
                            i5 = 0;
                            i6 = 0;
                        }
                    }
                }
            }
            z = !z;
            i3 -= 2;
        }
        if (i4 == yr7E.h()) {
            return bArr;
        }
        throw FormatException.a();
    }

    C22254uv2 d() throws FormatException {
        C22254uv2 c22254uv2 = this.c;
        if (c22254uv2 != null) {
            return c22254uv2;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int i3 = this.a.i();
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iA = a(i6, 8, iA);
        }
        C22254uv2 c22254uv2A = C22254uv2.a(iA3, iA);
        this.c = c22254uv2A;
        if (c22254uv2A != null) {
            return c22254uv2A;
        }
        throw FormatException.a();
    }

    YR7 e() throws FormatException {
        YR7 yr7 = this.b;
        if (yr7 != null) {
            return yr7;
        }
        int i = this.a.i();
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return YR7.i(i2);
        }
        int i3 = i - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        YR7 yr7C = YR7.c(iA2);
        if (yr7C != null && yr7C.e() == i) {
            this.b = yr7C;
            return yr7C;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        YR7 yr7C2 = YR7.c(iA);
        if (yr7C2 == null || yr7C2.e() != i) {
            throw FormatException.a();
        }
        this.b = yr7C2;
        return yr7C2;
    }

    void f() {
        if (this.c == null) {
            return;
        }
        EnumC10044az1.values()[this.c.c()].j(this.a, this.a.i());
    }

    void g(boolean z) {
        this.b = null;
        this.c = null;
        this.d = z;
    }
}
