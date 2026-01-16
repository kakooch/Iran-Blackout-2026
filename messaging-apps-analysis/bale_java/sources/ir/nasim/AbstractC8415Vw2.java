package ir.nasim;

/* renamed from: ir.nasim.Vw2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC8415Vw2 implements InterfaceC9845af2 {
    private final InterfaceC9845af2 a;

    public AbstractC8415Vw2(InterfaceC9845af2 interfaceC9845af2) {
        this.a = interfaceC9845af2;
    }

    @Override // ir.nasim.InterfaceC9845af2
    public int a(int i) {
        return this.a.a(i);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public boolean c(byte[] bArr, int i, int i2, boolean z) {
        return this.a.c(bArr, i, i2, z);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void e() {
        this.a.e();
    }

    @Override // ir.nasim.InterfaceC9845af2
    public boolean f(byte[] bArr, int i, int i2, boolean z) {
        return this.a.f(bArr, i, i2, z);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public long g() {
        return this.a.g();
    }

    @Override // ir.nasim.InterfaceC9845af2
    public long getLength() {
        return this.a.getLength();
    }

    @Override // ir.nasim.InterfaceC9845af2
    public long getPosition() {
        return this.a.getPosition();
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void h(int i) {
        this.a.h(i);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public int j(byte[] bArr, int i, int i2) {
        return this.a.j(bArr, i, i2);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void k(int i) {
        this.a.k(i);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public boolean l(int i, boolean z) {
        return this.a.l(i, z);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void m(byte[] bArr, int i, int i2) {
        this.a.m(bArr, i, i2);
    }

    @Override // ir.nasim.InterfaceC9845af2, ir.nasim.InterfaceC18631oz1
    public int read(byte[] bArr, int i, int i2) {
        return this.a.read(bArr, i, i2);
    }

    @Override // ir.nasim.InterfaceC9845af2
    public void readFully(byte[] bArr, int i, int i2) {
        this.a.readFully(bArr, i, i2);
    }
}
