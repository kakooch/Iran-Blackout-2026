package ir.nasim;

/* loaded from: classes2.dex */
public final class MW5 implements InterfaceC8154Ut2 {
    private final int a;
    private final C4593Fu2 b;
    private final int c;
    private final C4359Eu2 d;
    private final int e;

    public /* synthetic */ MW5(int i, C4593Fu2 c4593Fu2, int i2, C4359Eu2 c4359Eu2, int i3, ED1 ed1) {
        this(i, c4593Fu2, i2, c4359Eu2, i3);
    }

    @Override // ir.nasim.InterfaceC8154Ut2
    public int a() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC8154Ut2
    public C4593Fu2 b() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC8154Ut2
    public int c() {
        return this.c;
    }

    public final int d() {
        return this.a;
    }

    public final C4359Eu2 e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MW5)) {
            return false;
        }
        MW5 mw5 = (MW5) obj;
        return this.a == mw5.a && AbstractC13042fc3.d(b(), mw5.b()) && C3418Au2.f(c(), mw5.c()) && AbstractC13042fc3.d(this.d, mw5.d) && AbstractC16812lu2.e(a(), mw5.a());
    }

    public int hashCode() {
        return (((((((this.a * 31) + b().hashCode()) * 31) + C3418Au2.g(c())) * 31) + AbstractC16812lu2.f(a())) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.a + ", weight=" + b() + ", style=" + ((Object) C3418Au2.h(c())) + ", loadingStrategy=" + ((Object) AbstractC16812lu2.g(a())) + ')';
    }

    private MW5(int i, C4593Fu2 c4593Fu2, int i2, C4359Eu2 c4359Eu2, int i3) {
        this.a = i;
        this.b = c4593Fu2;
        this.c = i2;
        this.d = c4359Eu2;
        this.e = i3;
    }
}
