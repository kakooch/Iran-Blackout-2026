package ir.nasim;

/* renamed from: ir.nasim.Am3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC3347Am3 extends InterfaceC9326Zl3 {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* renamed from: ir.nasim.Am3$a */
    public static final class a {
        public static final a a = new a("INSTANCE", 0);
        public static final a b = new a("EXTENSION_RECEIVER", 1);
        public static final a c = new a("VALUE", 2);
        private static final /* synthetic */ a[] d;
        private static final /* synthetic */ F92 e;

        static {
            a[] aVarArrA = a();
            d = aVarArrA;
            e = G92.a(aVarArrA);
        }

        private a(String str, int i) {
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{a, b, c};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    boolean c();

    a f();

    String getName();

    InterfaceC5941Lm3 getType();

    boolean w();
}
