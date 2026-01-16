package ir.nasim;

/* renamed from: ir.nasim.fE6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12827fE6 {
    private final InterfaceC22053ub1 a;

    private /* synthetic */ C12827fE6(InterfaceC22053ub1 interfaceC22053ub1) {
        this.a = interfaceC22053ub1;
    }

    public static final /* synthetic */ C12827fE6 a(InterfaceC22053ub1 interfaceC22053ub1) {
        return new C12827fE6(interfaceC22053ub1);
    }

    public static boolean c(InterfaceC22053ub1 interfaceC22053ub1, Object obj) {
        return (obj instanceof C12827fE6) && AbstractC13042fc3.d(interfaceC22053ub1, ((C12827fE6) obj).f());
    }

    public static int d(InterfaceC22053ub1 interfaceC22053ub1) {
        return interfaceC22053ub1.hashCode();
    }

    public static String e(InterfaceC22053ub1 interfaceC22053ub1) {
        return "SkippableUpdater(composer=" + interfaceC22053ub1 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.a, obj);
    }

    public final /* synthetic */ InterfaceC22053ub1 f() {
        return this.a;
    }

    public int hashCode() {
        return d(this.a);
    }

    public String toString() {
        return e(this.a);
    }

    public static InterfaceC22053ub1 b(InterfaceC22053ub1 interfaceC22053ub1) {
        return interfaceC22053ub1;
    }
}
