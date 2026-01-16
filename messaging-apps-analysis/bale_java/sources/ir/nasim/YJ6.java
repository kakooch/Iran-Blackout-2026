package ir.nasim;

/* loaded from: classes.dex */
final class YJ6 implements InterfaceC5766Kt {
    private final InterfaceC5766Kt a;
    private final long b;

    public YJ6(InterfaceC5766Kt interfaceC5766Kt, long j) {
        this.a = interfaceC5766Kt;
        this.b = j;
    }

    @Override // ir.nasim.InterfaceC5766Kt
    public ZQ7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        return new ZJ6(this.a.a(interfaceC5342Ix7), this.b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YJ6)) {
            return false;
        }
        YJ6 yj6 = (YJ6) obj;
        return yj6.b == this.b && AbstractC13042fc3.d(yj6.a, this.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Long.hashCode(this.b);
    }
}
