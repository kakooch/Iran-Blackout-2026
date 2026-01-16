package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.oo3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC18526oo3 {
    private static final /* synthetic */ EnumC18526oo3[] O0;
    private static final /* synthetic */ F92 P0;
    private final boolean a;
    public static final EnumC18526oo3 b = new EnumC18526oo3("LEFT_CHAR", 0, false);
    public static final EnumC18526oo3 c = new EnumC18526oo3("RIGHT_CHAR", 1, false);
    public static final EnumC18526oo3 d = new EnumC18526oo3("RIGHT_WORD", 2, false);
    public static final EnumC18526oo3 e = new EnumC18526oo3("LEFT_WORD", 3, false);
    public static final EnumC18526oo3 f = new EnumC18526oo3("NEXT_PARAGRAPH", 4, false);
    public static final EnumC18526oo3 g = new EnumC18526oo3("PREV_PARAGRAPH", 5, false);
    public static final EnumC18526oo3 h = new EnumC18526oo3("LINE_START", 6, false);
    public static final EnumC18526oo3 i = new EnumC18526oo3("LINE_END", 7, false);
    public static final EnumC18526oo3 j = new EnumC18526oo3("LINE_LEFT", 8, false);
    public static final EnumC18526oo3 k = new EnumC18526oo3("LINE_RIGHT", 9, false);
    public static final EnumC18526oo3 l = new EnumC18526oo3("UP", 10, false);
    public static final EnumC18526oo3 m = new EnumC18526oo3("DOWN", 11, false);
    public static final EnumC18526oo3 n = new EnumC18526oo3("PAGE_UP", 12, false);
    public static final EnumC18526oo3 o = new EnumC18526oo3("PAGE_DOWN", 13, false);
    public static final EnumC18526oo3 p = new EnumC18526oo3("HOME", 14, false);
    public static final EnumC18526oo3 q = new EnumC18526oo3("END", 15, false);
    public static final EnumC18526oo3 r = new EnumC18526oo3("COPY", 16, false);
    public static final EnumC18526oo3 s = new EnumC18526oo3("PASTE", 17, true);
    public static final EnumC18526oo3 t = new EnumC18526oo3("CUT", 18, true);
    public static final EnumC18526oo3 u = new EnumC18526oo3("DELETE_PREV_CHAR", 19, true);
    public static final EnumC18526oo3 v = new EnumC18526oo3("DELETE_NEXT_CHAR", 20, true);
    public static final EnumC18526oo3 w = new EnumC18526oo3("DELETE_PREV_WORD", 21, true);
    public static final EnumC18526oo3 x = new EnumC18526oo3("DELETE_NEXT_WORD", 22, true);
    public static final EnumC18526oo3 y = new EnumC18526oo3("DELETE_FROM_LINE_START", 23, true);
    public static final EnumC18526oo3 z = new EnumC18526oo3("DELETE_TO_LINE_END", 24, true);
    public static final EnumC18526oo3 A = new EnumC18526oo3("SELECT_ALL", 25, false);
    public static final EnumC18526oo3 B = new EnumC18526oo3("SELECT_LEFT_CHAR", 26, false);
    public static final EnumC18526oo3 D = new EnumC18526oo3("SELECT_RIGHT_CHAR", 27, false);
    public static final EnumC18526oo3 G = new EnumC18526oo3("SELECT_UP", 28, false);
    public static final EnumC18526oo3 H = new EnumC18526oo3("SELECT_DOWN", 29, false);
    public static final EnumC18526oo3 J = new EnumC18526oo3("SELECT_PAGE_UP", 30, false);
    public static final EnumC18526oo3 Y = new EnumC18526oo3("SELECT_PAGE_DOWN", 31, false);
    public static final EnumC18526oo3 Z = new EnumC18526oo3("SELECT_HOME", 32, false);
    public static final EnumC18526oo3 z0 = new EnumC18526oo3("SELECT_END", 33, false);
    public static final EnumC18526oo3 A0 = new EnumC18526oo3("SELECT_LEFT_WORD", 34, false);
    public static final EnumC18526oo3 B0 = new EnumC18526oo3("SELECT_RIGHT_WORD", 35, false);
    public static final EnumC18526oo3 C0 = new EnumC18526oo3("SELECT_NEXT_PARAGRAPH", 36, false);
    public static final EnumC18526oo3 D0 = new EnumC18526oo3("SELECT_PREV_PARAGRAPH", 37, false);
    public static final EnumC18526oo3 E0 = new EnumC18526oo3("SELECT_LINE_START", 38, false);
    public static final EnumC18526oo3 F0 = new EnumC18526oo3("SELECT_LINE_END", 39, false);
    public static final EnumC18526oo3 G0 = new EnumC18526oo3("SELECT_LINE_LEFT", 40, false);
    public static final EnumC18526oo3 H0 = new EnumC18526oo3("SELECT_LINE_RIGHT", 41, false);
    public static final EnumC18526oo3 I0 = new EnumC18526oo3("DESELECT", 42, false);
    public static final EnumC18526oo3 J0 = new EnumC18526oo3("NEW_LINE", 43, true);
    public static final EnumC18526oo3 K0 = new EnumC18526oo3("TAB", 44, true);
    public static final EnumC18526oo3 L0 = new EnumC18526oo3("UNDO", 45, true);
    public static final EnumC18526oo3 M0 = new EnumC18526oo3("REDO", 46, true);
    public static final EnumC18526oo3 N0 = new EnumC18526oo3("CHARACTER_PALETTE", 47, true);

    static {
        EnumC18526oo3[] enumC18526oo3ArrA = a();
        O0 = enumC18526oo3ArrA;
        P0 = G92.a(enumC18526oo3ArrA);
    }

    private EnumC18526oo3(String str, int i2, boolean z2) {
        this.a = z2;
    }

    private static final /* synthetic */ EnumC18526oo3[] a() {
        return new EnumC18526oo3[]{b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, D, G, H, J, Y, Z, z0, A0, B0, C0, D0, E0, F0, G0, H0, I0, J0, K0, L0, M0, N0};
    }

    public static EnumC18526oo3 valueOf(String str) {
        return (EnumC18526oo3) Enum.valueOf(EnumC18526oo3.class, str);
    }

    public static EnumC18526oo3[] values() {
        return (EnumC18526oo3[]) O0.clone();
    }

    public final boolean j() {
        return this.a;
    }
}
