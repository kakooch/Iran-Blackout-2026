package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.xM4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class EnumC23696xM4 {
    public static final a a;
    public static final EnumC23696xM4 b = new EnumC23696xM4("LANDSCAPE", 0);
    public static final EnumC23696xM4 c = new EnumC23696xM4("PORTRAIT", 1);
    private static final /* synthetic */ EnumC23696xM4[] d;
    private static final /* synthetic */ F92 e;

    /* renamed from: ir.nasim.xM4$a */
    public static final class a {
        private a() {
        }

        public final EnumC23696xM4 a() {
            return EnumC23696xM4.c;
        }

        public final EnumC23696xM4 b(int i) {
            return i != 1 ? i != 2 ? a() : EnumC23696xM4.b : EnumC23696xM4.c;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        EnumC23696xM4[] enumC23696xM4ArrA = a();
        d = enumC23696xM4ArrA;
        e = G92.a(enumC23696xM4ArrA);
        a = new a(null);
    }

    private EnumC23696xM4(String str, int i) {
    }

    private static final /* synthetic */ EnumC23696xM4[] a() {
        return new EnumC23696xM4[]{b, c};
    }

    public static EnumC23696xM4 valueOf(String str) {
        return (EnumC23696xM4) Enum.valueOf(EnumC23696xM4.class, str);
    }

    public static EnumC23696xM4[] values() {
        return (EnumC23696xM4[]) d.clone();
    }
}
