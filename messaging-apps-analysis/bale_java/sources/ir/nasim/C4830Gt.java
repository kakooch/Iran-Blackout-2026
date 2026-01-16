package ir.nasim;

/* renamed from: ir.nasim.Gt, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4830Gt {
    private final C6233Mt a;
    private final EnumC3406At b;

    public C4830Gt(C6233Mt c6233Mt, EnumC3406At enumC3406At) {
        this.a = c6233Mt;
        this.b = enumC3406At;
    }

    public final EnumC3406At a() {
        return this.b;
    }

    public final C6233Mt b() {
        return this.a;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.b + ", endState=" + this.a + ')';
    }
}
