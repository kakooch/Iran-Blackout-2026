package ir.nasim;

import java.util.Arrays;

/* renamed from: ir.nasim.hH4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C14061hH4 {
    private final C14663iH4 a = new C14663iH4();
    private final EW4 b = new EW4(new byte[65025], 0);
    private int c = -1;
    private int d;
    private boolean e;

    C14061hH4() {
    }

    private int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            C14663iH4 c14663iH4 = this.a;
            if (i5 >= c14663iH4.g) {
                break;
            }
            int[] iArr = c14663iH4.j;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public C14663iH4 b() {
        return this.a;
    }

    public EW4 c() {
        return this.b;
    }

    public boolean d(InterfaceC9845af2 interfaceC9845af2) {
        int i;
        AbstractC20011rK.g(interfaceC9845af2 != null);
        if (this.e) {
            this.e = false;
            this.b.O(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(interfaceC9845af2) || !this.a.a(interfaceC9845af2, true)) {
                    return false;
                }
                C14663iH4 c14663iH4 = this.a;
                int iA = c14663iH4.h;
                if ((c14663iH4.b & 1) == 1 && this.b.g() == 0) {
                    iA += a(0);
                    i = this.d;
                } else {
                    i = 0;
                }
                if (!AbstractC11055cf2.e(interfaceC9845af2, iA)) {
                    return false;
                }
                this.c = i;
            }
            int iA2 = a(this.c);
            int i2 = this.c + this.d;
            if (iA2 > 0) {
                EW4 ew4 = this.b;
                ew4.c(ew4.g() + iA2);
                if (!AbstractC11055cf2.d(interfaceC9845af2, this.b.e(), this.b.g(), iA2)) {
                    return false;
                }
                EW4 ew42 = this.b;
                ew42.R(ew42.g() + iA2);
                this.e = this.a.j[i2 + (-1)] != 255;
            }
            if (i2 == this.a.g) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }

    public void e() {
        this.a.b();
        this.b.O(0);
        this.c = -1;
        this.e = false;
    }

    public void f() {
        if (this.b.e().length == 65025) {
            return;
        }
        EW4 ew4 = this.b;
        ew4.Q(Arrays.copyOf(ew4.e(), Math.max(65025, this.b.g())), this.b.g());
    }
}
