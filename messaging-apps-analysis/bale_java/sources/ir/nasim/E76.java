package ir.nasim;

/* loaded from: classes5.dex */
public class E76 implements CT1 {
    private G76 a = new G76();

    @Override // ir.nasim.CT1
    public void a(byte[] bArr, int i) {
        this.a.n(bArr, i);
    }

    @Override // ir.nasim.CT1
    public int b() {
        return this.a.o();
    }

    @Override // ir.nasim.CT1
    public void c(byte[] bArr, int i, int i2) {
        if (i2 + i > bArr.length) {
            throw new RuntimeException("Incorrect length");
        }
        this.a.g(bArr, i, i2);
    }

    @Override // ir.nasim.CT1
    public void reset() {
        this.a.e();
    }
}
