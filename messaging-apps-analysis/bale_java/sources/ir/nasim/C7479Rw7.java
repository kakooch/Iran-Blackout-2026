package ir.nasim;

/* renamed from: ir.nasim.Rw7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7479Rw7 implements R12 {
    private final int a;
    private final int b;
    private final K22 c;

    public C7479Rw7(int i, int i2, K22 k22) {
        this.a = i;
        this.b = i2;
        this.c = k22;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C7479Rw7)) {
            return false;
        }
        C7479Rw7 c7479Rw7 = (C7479Rw7) obj;
        return c7479Rw7.a == this.a && c7479Rw7.b == this.b && AbstractC13042fc3.d(c7479Rw7.c, this.c);
    }

    @Override // ir.nasim.R12, ir.nasim.InterfaceC5766Kt
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C17127mR7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        return new C17127mR7(this.a, this.b, this.c);
    }

    public int hashCode() {
        return (((this.a * 31) + this.c.hashCode()) * 31) + this.b;
    }

    public /* synthetic */ C7479Rw7(int i, int i2, K22 k22, int i3, ED1 ed1) {
        this((i3 & 1) != 0 ? 300 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? T22.d() : k22);
    }
}
