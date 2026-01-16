package ir.nasim;

/* loaded from: classes8.dex */
final class SV1 extends AbstractC24804zE0 {
    private final NV1 a;

    public SV1(NV1 nv1) {
        this.a = nv1;
    }

    @Override // ir.nasim.AE0
    public void i(Throwable th) {
        this.a.dispose();
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        i((Throwable) obj);
        return C19938rB7.a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.a + ']';
    }
}
