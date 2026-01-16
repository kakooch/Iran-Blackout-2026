package ir.nasim;

/* renamed from: ir.nasim.ic6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C14865ic6 {
    private final float a;
    private final long b;
    private final InterfaceC4788Go2 c;

    public /* synthetic */ C14865ic6(float f, long j, InterfaceC4788Go2 interfaceC4788Go2, ED1 ed1) {
        this(f, j, interfaceC4788Go2);
    }

    public final InterfaceC4788Go2 a() {
        return this.c;
    }

    public final float b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14865ic6)) {
            return false;
        }
        C14865ic6 c14865ic6 = (C14865ic6) obj;
        return Float.compare(this.a, c14865ic6.a) == 0 && androidx.compose.ui.graphics.f.e(this.b, c14865ic6.b) && AbstractC13042fc3.d(this.c, c14865ic6.c);
    }

    public int hashCode() {
        return (((Float.hashCode(this.a) * 31) + androidx.compose.ui.graphics.f.h(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Scale(scale=" + this.a + ", transformOrigin=" + ((Object) androidx.compose.ui.graphics.f.i(this.b)) + ", animationSpec=" + this.c + ')';
    }

    private C14865ic6(float f, long j, InterfaceC4788Go2 interfaceC4788Go2) {
        this.a = f;
        this.b = j;
        this.c = interfaceC4788Go2;
    }
}
