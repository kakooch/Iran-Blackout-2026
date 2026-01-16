package ir.nasim;

/* renamed from: ir.nasim.kJ0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15866kJ0 {
    private final InterfaceC12529em a;
    private final UA2 b;
    private final InterfaceC4788Go2 c;
    private final boolean d;

    public C15866kJ0(InterfaceC12529em interfaceC12529em, UA2 ua2, InterfaceC4788Go2 interfaceC4788Go2, boolean z) {
        this.a = interfaceC12529em;
        this.b = ua2;
        this.c = interfaceC4788Go2;
        this.d = z;
    }

    public final InterfaceC12529em a() {
        return this.a;
    }

    public final InterfaceC4788Go2 b() {
        return this.c;
    }

    public final boolean c() {
        return this.d;
    }

    public final UA2 d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15866kJ0)) {
            return false;
        }
        C15866kJ0 c15866kJ0 = (C15866kJ0) obj;
        return AbstractC13042fc3.d(this.a, c15866kJ0.a) && AbstractC13042fc3.d(this.b, c15866kJ0.b) && AbstractC13042fc3.d(this.c, c15866kJ0.c) && this.d == c15866kJ0.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "ChangeSize(alignment=" + this.a + ", size=" + this.b + ", animationSpec=" + this.c + ", clip=" + this.d + ')';
    }
}
