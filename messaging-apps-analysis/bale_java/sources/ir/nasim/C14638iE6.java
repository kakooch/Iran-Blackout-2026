package ir.nasim;

/* renamed from: ir.nasim.iE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14638iE6 {
    private final UA2 a;
    private final InterfaceC4788Go2 b;

    public C14638iE6(UA2 ua2, InterfaceC4788Go2 interfaceC4788Go2) {
        this.a = ua2;
        this.b = interfaceC4788Go2;
    }

    public final InterfaceC4788Go2 a() {
        return this.b;
    }

    public final UA2 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14638iE6)) {
            return false;
        }
        C14638iE6 c14638iE6 = (C14638iE6) obj;
        return AbstractC13042fc3.d(this.a, c14638iE6.a) && AbstractC13042fc3.d(this.b, c14638iE6.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "Slide(slideOffset=" + this.a + ", animationSpec=" + this.b + ')';
    }
}
