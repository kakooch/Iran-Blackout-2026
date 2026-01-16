package ir.nasim;

import ir.nasim.InterfaceC4589Ft7;

/* renamed from: ir.nasim.nw7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18019nw7 {
    private final byte[] a = new byte[10];
    private boolean b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;

    public void a(InterfaceC4589Ft7 interfaceC4589Ft7, InterfaceC4589Ft7.a aVar) {
        if (this.c > 0) {
            interfaceC4589Ft7.b(this.d, this.e, this.f, this.g, aVar);
            this.c = 0;
        }
    }

    public void b() {
        this.b = false;
        this.c = 0;
    }

    public void c(InterfaceC4589Ft7 interfaceC4589Ft7, long j, int i, int i2, int i3, InterfaceC4589Ft7.a aVar) {
        AbstractC20011rK.h(this.g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.b) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i4 == 0) {
                this.d = j;
                this.e = i;
                this.f = 0;
            }
            this.f += i2;
            this.g = i3;
            if (i5 >= 16) {
                a(interfaceC4589Ft7, aVar);
            }
        }
    }

    public void d(InterfaceC9845af2 interfaceC9845af2) {
        if (this.b) {
            return;
        }
        interfaceC9845af2.m(this.a, 0, 10);
        interfaceC9845af2.e();
        if (AbstractC15704k2.j(this.a) == 0) {
            return;
        }
        this.b = true;
    }
}
