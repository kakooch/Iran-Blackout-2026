package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Yt7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC9168Yt7 {
    public static final a a;
    public static final EnumC9168Yt7 b = new EnumC9168Yt7("LINK_WIDGET", 0);
    public static final EnumC9168Yt7 c = new EnumC9168Yt7("POLL_WIDGET", 1);
    public static final EnumC9168Yt7 d = new EnumC9168Yt7("POST_WIDGET", 2);
    public static final EnumC9168Yt7 e = new EnumC9168Yt7("RESTORY_WIDGET", 3);
    public static final EnumC9168Yt7 f = new EnumC9168Yt7("UNKNOWN", 4);
    private static final /* synthetic */ EnumC9168Yt7[] g;
    private static final /* synthetic */ F92 h;

    /* renamed from: ir.nasim.Yt7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC9168Yt7[] enumC9168Yt7ArrA = a();
        g = enumC9168Yt7ArrA;
        h = G92.a(enumC9168Yt7ArrA);
        a = new a(null);
    }

    private EnumC9168Yt7(String str, int i) {
    }

    private static final /* synthetic */ EnumC9168Yt7[] a() {
        return new EnumC9168Yt7[]{b, c, d, e, f};
    }

    public static EnumC9168Yt7 valueOf(String str) {
        return (EnumC9168Yt7) Enum.valueOf(EnumC9168Yt7.class, str);
    }

    public static EnumC9168Yt7[] values() {
        return (EnumC9168Yt7[]) g.clone();
    }
}
