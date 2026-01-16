package ir.nasim;

/* loaded from: classes2.dex */
public final class T05 implements QY7 {
    private final char b;

    public T05(char c) {
        this.b = c;
    }

    @Override // ir.nasim.QY7
    public C18600ov7 a(C13245fu c13245fu) {
        return new C18600ov7(new C13245fu(AbstractC20153rZ6.I(String.valueOf(this.b), c13245fu.k().length()), null, 2, null), InterfaceC11600dH4.a.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof T05) && this.b == ((T05) obj).b;
    }

    public int hashCode() {
        return Character.hashCode(this.b);
    }

    public /* synthetic */ T05(char c, int i, ED1 ed1) {
        this((i & 1) != 0 ? (char) 8226 : c);
    }
}
