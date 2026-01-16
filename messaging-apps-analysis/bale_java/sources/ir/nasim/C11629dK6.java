package ir.nasim;

/* renamed from: ir.nasim.dK6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C11629dK6 extends AbstractC8415Vw2 {
    private final long b;

    public C11629dK6(InterfaceC9845af2 interfaceC9845af2, long j) {
        super(interfaceC9845af2);
        AbstractC20011rK.a(interfaceC9845af2.getPosition() >= j);
        this.b = j;
    }

    @Override // ir.nasim.AbstractC8415Vw2, ir.nasim.InterfaceC9845af2
    public long g() {
        return super.g() - this.b;
    }

    @Override // ir.nasim.AbstractC8415Vw2, ir.nasim.InterfaceC9845af2
    public long getLength() {
        return super.getLength() - this.b;
    }

    @Override // ir.nasim.AbstractC8415Vw2, ir.nasim.InterfaceC9845af2
    public long getPosition() {
        return super.getPosition() - this.b;
    }
}
