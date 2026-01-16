package ir.nasim;

/* loaded from: classes.dex */
public final class HG6 implements R12 {
    private final int a;

    public HG6(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HG6) && ((HG6) obj).a == this.a;
    }

    public int hashCode() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC5766Kt
    public InterfaceC10929cR7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        return new C15945kR7(this.a);
    }

    public /* synthetic */ HG6(int i, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
