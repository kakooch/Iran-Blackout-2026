package ir.nasim;

/* renamed from: ir.nasim.we3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C23271we3 extends AbstractC24804zE0 {
    private final UA2 a;

    public C23271we3(UA2 ua2) {
        this.a = ua2;
    }

    @Override // ir.nasim.AE0
    public void i(Throwable th) {
        this.a.invoke(th);
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        i((Throwable) obj);
        return C19938rB7.a;
    }

    public String toString() {
        return "InvokeOnCancel[" + YA1.a(this.a) + '@' + YA1.b(this) + ']';
    }
}
