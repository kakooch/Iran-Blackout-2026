package ir.nasim;

/* loaded from: classes3.dex */
public abstract class Th8 {
    private static Th8 a;

    public static synchronized Th8 b() {
        try {
            if (a == null) {
                a = new C20250rh8();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    public abstract InterfaceC9881ai8 a(String str, boolean z);
}
