package ir.nasim;

/* renamed from: ir.nasim.ah0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C9863ah0 extends AbstractC17902nl0 implements InterfaceC8844Xo3 {
    private long a;
    private byte[] b;

    public C9863ah0() {
        this.a = -1L;
        this.b = null;
    }

    @Override // ir.nasim.InterfaceC8844Xo3
    public long a() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.d(1);
    }

    public byte[] q() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.b(1, this.b);
    }

    public C9863ah0(long j, byte[] bArr) {
        this.a = j;
        this.b = bArr;
    }
}
