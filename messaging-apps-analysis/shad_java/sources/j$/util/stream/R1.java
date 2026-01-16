package j$.util.stream;

/* loaded from: classes2.dex */
abstract class R1 extends C1 implements InterfaceC0260z1 {
    R1(InterfaceC0260z1 interfaceC0260z1, InterfaceC0260z1 interfaceC0260z12) {
        super(interfaceC0260z1, interfaceC0260z12);
    }

    @Override // j$.util.stream.InterfaceC0260z1
    public void e(Object obj, int i) {
        ((InterfaceC0260z1) this.a).e(obj, i);
        ((InterfaceC0260z1) this.b).e(obj, i + ((int) ((InterfaceC0260z1) this.a).count()));
    }

    @Override // j$.util.stream.InterfaceC0260z1
    public Object g() {
        long jCount = count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object objD = d((int) jCount);
        e(objD, 0);
        return objD;
    }

    @Override // j$.util.stream.InterfaceC0260z1
    public void h(Object obj) {
        ((InterfaceC0260z1) this.a).h(obj);
        ((InterfaceC0260z1) this.b).h(obj);
    }

    @Override // j$.util.stream.A1
    public /* synthetic */ Object[] r(j$.util.function.m mVar) {
        return AbstractC0202o1.g(this, mVar);
    }

    public String toString() {
        return count() < 32 ? String.format("%s[%s.%s]", getClass().getName(), this.a, this.b) : String.format("%s[size=%d]", getClass().getName(), Long.valueOf(count()));
    }
}
