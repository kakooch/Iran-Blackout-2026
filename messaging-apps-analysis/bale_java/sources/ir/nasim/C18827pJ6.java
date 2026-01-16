package ir.nasim;

/* renamed from: ir.nasim.pJ6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18827pJ6 implements InterfaceC4788Go2 {
    private final float a;
    private final float b;
    private final Object c;

    public C18827pJ6(float f, float f2, Object obj) {
        this.a = f;
        this.b = f2;
        this.c = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C18827pJ6)) {
            return false;
        }
        C18827pJ6 c18827pJ6 = (C18827pJ6) obj;
        return c18827pJ6.a == this.a && c18827pJ6.b == this.b && AbstractC13042fc3.d(c18827pJ6.c, this.c);
    }

    public final float f() {
        return this.a;
    }

    public final float g() {
        return this.b;
    }

    public final Object h() {
        return this.c;
    }

    public int hashCode() {
        Object obj = this.c;
        return ((((obj != null ? obj.hashCode() : 0) * 31) + Float.hashCode(this.a)) * 31) + Float.hashCode(this.b);
    }

    @Override // ir.nasim.InterfaceC5766Kt
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public C16536lR7 a(InterfaceC5342Ix7 interfaceC5342Ix7) {
        return new C16536lR7(this.a, this.b, AbstractC5999Lt.b(interfaceC5342Ix7, this.c));
    }

    public /* synthetic */ C18827pJ6(float f, float f2, Object obj, int i, ED1 ed1) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1500.0f : f2, (i & 4) != 0 ? null : obj);
    }
}
