package ir.nasim;

/* renamed from: ir.nasim.wd0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C23258wd0 implements InterfaceC12197eC3 {
    final InterfaceC12197eC3 a;
    int b = 0;
    int c = -1;
    int d = -1;
    Object e = null;

    public C23258wd0(InterfaceC12197eC3 interfaceC12197eC3) {
        this.a = interfaceC12197eC3;
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void a(int i, int i2) {
        int i3;
        if (this.b == 1 && i >= (i3 = this.c)) {
            int i4 = this.d;
            if (i <= i3 + i4) {
                this.d = i4 + i2;
                this.c = Math.min(i, i3);
                return;
            }
        }
        e();
        this.c = i;
        this.d = i2;
        this.b = 1;
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void b(int i, int i2) {
        int i3;
        if (this.b == 2 && (i3 = this.c) >= i && i3 <= i + i2) {
            this.d += i2;
            this.c = i;
        } else {
            e();
            this.c = i;
            this.d = i2;
            this.b = 2;
        }
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void c(int i, int i2, Object obj) {
        int i3;
        if (this.b == 3) {
            int i4 = this.c;
            int i5 = this.d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.e == obj) {
                this.c = Math.min(i, i4);
                this.d = Math.max(i5 + i4, i3) - this.c;
                return;
            }
        }
        e();
        this.c = i;
        this.d = i2;
        this.e = obj;
        this.b = 3;
    }

    @Override // ir.nasim.InterfaceC12197eC3
    public void d(int i, int i2) {
        e();
        this.a.d(i, i2);
    }

    public void e() {
        int i = this.b;
        if (i == 0) {
            return;
        }
        if (i == 1) {
            this.a.a(this.c, this.d);
        } else if (i == 2) {
            this.a.b(this.c, this.d);
        } else if (i == 3) {
            this.a.c(this.c, this.d, this.e);
        }
        this.e = null;
        this.b = 0;
    }
}
