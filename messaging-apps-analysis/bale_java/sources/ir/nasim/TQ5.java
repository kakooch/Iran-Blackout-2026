package ir.nasim;

/* loaded from: classes2.dex */
public final class TQ5 implements UA2 {
    private C9283Zg5 a;

    public void a(boolean z) {
        C9283Zg5 c9283Zg5 = this.a;
        if (c9283Zg5 == null) {
            return;
        }
        c9283Zg5.l(z);
    }

    public final void b(C9283Zg5 c9283Zg5) {
        this.a = c9283Zg5;
    }

    @Override // ir.nasim.UA2
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a(((Boolean) obj).booleanValue());
        return C19938rB7.a;
    }
}
