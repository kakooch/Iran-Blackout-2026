package ir.nasim;

/* loaded from: classes.dex */
public final class GO5 implements InterfaceC4788Go2 {
    private final int a;
    private final R12 b;
    private final EO5 c;
    private final long d;

    public /* synthetic */ GO5(int i, R12 r12, EO5 eo5, long j, ED1 ed1) {
        this(i, r12, eo5, j);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GO5)) {
            return false;
        }
        GO5 go5 = (GO5) obj;
        return go5.a == this.a && AbstractC13042fc3.d(go5.b, this.b) && go5.c == this.c && AbstractC10865cK6.d(go5.d, this.d);
    }

    @Override // ir.nasim.InterfaceC5766Kt
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public InterfaceC11693dR7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        return new C15354jR7(this.a, this.b.a(interfaceC5342Ix7), this.c, this.d, null);
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + AbstractC10865cK6.e(this.d);
    }

    private GO5(int i, R12 r12, EO5 eo5, long j) {
        this.a = i;
        this.b = r12;
        this.c = eo5;
        this.d = j;
    }
}
