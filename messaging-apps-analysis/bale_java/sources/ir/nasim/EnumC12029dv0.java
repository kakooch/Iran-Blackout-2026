package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.dv0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC12029dv0 {
    public static final EnumC12029dv0 a = new EnumC12029dv0("UNKNOWN", 0);
    public static final EnumC12029dv0 b = new EnumC12029dv0("MISSED", 1);
    public static final EnumC12029dv0 c = new EnumC12029dv0("DISCONNECT", 2);
    public static final EnumC12029dv0 d = new EnumC12029dv0("HANGUP", 3);
    public static final EnumC12029dv0 e = new EnumC12029dv0("BUSY", 4);
    private static final /* synthetic */ EnumC12029dv0[] f;
    private static final /* synthetic */ F92 g;

    static {
        EnumC12029dv0[] enumC12029dv0ArrA = a();
        f = enumC12029dv0ArrA;
        g = G92.a(enumC12029dv0ArrA);
    }

    private EnumC12029dv0(String str, int i) {
    }

    private static final /* synthetic */ EnumC12029dv0[] a() {
        return new EnumC12029dv0[]{a, b, c, d, e};
    }

    public static EnumC12029dv0 valueOf(String str) {
        return (EnumC12029dv0) Enum.valueOf(EnumC12029dv0.class, str);
    }

    public static EnumC12029dv0[] values() {
        return (EnumC12029dv0[]) f.clone();
    }
}
