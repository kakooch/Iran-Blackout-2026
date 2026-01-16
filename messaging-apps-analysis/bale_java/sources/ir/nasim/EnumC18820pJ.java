package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.pJ, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC18820pJ {
    public static final EnumC18820pJ c = new EnumC18820pJ("ARCHIVE", 0, EnumC23487x03.D0, FD5.archive);
    public static final EnumC18820pJ d = new EnumC18820pJ("UNARCHIVE", 1, EnumC23487x03.E0, FD5.archive);
    private static final /* synthetic */ EnumC18820pJ[] e;
    private static final /* synthetic */ F92 f;
    private final EnumC23487x03 a;
    private final int b;

    static {
        EnumC18820pJ[] enumC18820pJArrA = a();
        e = enumC18820pJArrA;
        f = G92.a(enumC18820pJArrA);
    }

    private EnumC18820pJ(String str, int i, EnumC23487x03 enumC23487x03, int i2) {
        this.a = enumC23487x03;
        this.b = i2;
    }

    private static final /* synthetic */ EnumC18820pJ[] a() {
        return new EnumC18820pJ[]{c, d};
    }

    public static EnumC18820pJ valueOf(String str) {
        return (EnumC18820pJ) Enum.valueOf(EnumC18820pJ.class, str);
    }

    public static EnumC18820pJ[] values() {
        return (EnumC18820pJ[]) e.clone();
    }

    public final int j() {
        return this.b;
    }

    public final EnumC23487x03 p() {
        return this.a;
    }
}
