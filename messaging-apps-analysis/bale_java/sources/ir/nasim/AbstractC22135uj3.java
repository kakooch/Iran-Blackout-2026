package ir.nasim;

/* renamed from: ir.nasim.uj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC22135uj3 extends D01 implements NV1, W53 {
    public C22725vj3 d;

    public final C22725vj3 B() {
        C22725vj3 c22725vj3 = this.d;
        if (c22725vj3 != null) {
            return c22725vj3;
        }
        AbstractC13042fc3.y("job");
        return null;
    }

    public final void C(C22725vj3 c22725vj3) {
        this.d = c22725vj3;
    }

    @Override // ir.nasim.W53
    public boolean b() {
        return true;
    }

    @Override // ir.nasim.W53
    public C10782cB4 c() {
        return null;
    }

    @Override // ir.nasim.NV1
    public void dispose() {
        B().R0(this);
    }

    @Override // ir.nasim.C16451lI3
    public String toString() {
        return YA1.a(this) + '@' + YA1.b(this) + "[job@" + YA1.b(B()) + ']';
    }
}
