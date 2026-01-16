package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Fl4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC4514Fl4 {
    public static final EnumC4514Fl4 a = new EnumC4514Fl4("UNKNOWN", 0);
    public static final EnumC4514Fl4 b = new EnumC4514Fl4("JOINED", 1);
    public static final EnumC4514Fl4 c = new EnumC4514Fl4("MISSED", 2);
    private static final /* synthetic */ EnumC4514Fl4[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC4514Fl4[] enumC4514Fl4ArrA = a();
        d = enumC4514Fl4ArrA;
        e = G92.a(enumC4514Fl4ArrA);
    }

    private EnumC4514Fl4(String str, int i) {
    }

    private static final /* synthetic */ EnumC4514Fl4[] a() {
        return new EnumC4514Fl4[]{a, b, c};
    }

    public static EnumC4514Fl4 valueOf(String str) {
        return (EnumC4514Fl4) Enum.valueOf(EnumC4514Fl4.class, str);
    }

    public static EnumC4514Fl4[] values() {
        return (EnumC4514Fl4[]) d.clone();
    }
}
