package ir.nasim;

/* renamed from: ir.nasim.sh2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20837sh2 {
    private static SA2 c;
    public static final C20837sh2 a = new C20837sh2();
    private static float b = C7183Qq.s().getInt("message_text_size", 14);
    public static final int d = 8;

    private C20837sh2() {
    }

    public final int a() {
        return b > 14.0f ? 48 : 32;
    }

    public final float b() {
        return b;
    }

    public final float c() {
        return b - 2;
    }

    public final void d(Float f) {
        b = f != null ? f.floatValue() : C7183Qq.s().getInt("message_text_size", 14);
        SA2 sa2 = c;
        if (sa2 != null) {
            sa2.invoke();
        }
    }

    public final void e(SA2 sa2) {
        c = sa2;
    }
}
