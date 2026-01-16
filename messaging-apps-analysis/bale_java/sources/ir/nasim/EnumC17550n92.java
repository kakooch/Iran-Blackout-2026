package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.n92, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC17550n92 {
    public static final EnumC17550n92 a = new EnumC17550n92("PreEnter", 0);
    public static final EnumC17550n92 b = new EnumC17550n92("Visible", 1);
    public static final EnumC17550n92 c = new EnumC17550n92("PostExit", 2);
    private static final /* synthetic */ EnumC17550n92[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC17550n92[] enumC17550n92ArrA = a();
        d = enumC17550n92ArrA;
        e = G92.a(enumC17550n92ArrA);
    }

    private EnumC17550n92(String str, int i) {
    }

    private static final /* synthetic */ EnumC17550n92[] a() {
        return new EnumC17550n92[]{a, b, c};
    }

    public static EnumC17550n92 valueOf(String str) {
        return (EnumC17550n92) Enum.valueOf(EnumC17550n92.class, str);
    }

    public static EnumC17550n92[] values() {
        return (EnumC17550n92[]) d.clone();
    }
}
