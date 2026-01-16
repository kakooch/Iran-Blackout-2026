package ir.nasim;

/* renamed from: ir.nasim.yK3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C24267yK3 {
    private static final C24267yK3 b = new C24267yK3();
    private final C17660nL3 a = new C17660nL3(20);

    C24267yK3() {
    }

    public static C24267yK3 b() {
        return b;
    }

    public C23677xK3 a(String str) {
        if (str == null) {
            return null;
        }
        return (C23677xK3) this.a.d(str);
    }

    public void c(String str, C23677xK3 c23677xK3) {
        if (str == null) {
            return;
        }
        this.a.f(str, c23677xK3);
    }
}
