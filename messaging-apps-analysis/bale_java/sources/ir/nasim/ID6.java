package ir.nasim;

/* loaded from: classes3.dex */
public final class ID6 {
    private static ID6 c;
    private final C4548Fp2 a = new C4548Fp2();
    private final C23916xj8 b = new C23916xj8();

    static {
        ID6 id6 = new ID6();
        synchronized (ID6.class) {
            c = id6;
        }
    }

    private ID6() {
    }

    public static C4548Fp2 a() {
        return b().a;
    }

    private static ID6 b() {
        ID6 id6;
        synchronized (ID6.class) {
            id6 = c;
        }
        return id6;
    }
}
