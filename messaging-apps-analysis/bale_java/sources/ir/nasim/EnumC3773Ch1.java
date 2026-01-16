package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Ch1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class EnumC3773Ch1 {
    public static final EnumC3773Ch1 b = new EnumC3773Ch1("CATEGORY_1", 0, KD5.features_onboarding_common_contacts_members_description_1);
    public static final EnumC3773Ch1 c = new EnumC3773Ch1("CATEGORY_2", 1, KD5.features_onboarding_common_contacts_members_description_2);
    private static final /* synthetic */ EnumC3773Ch1[] d;
    private static final /* synthetic */ F92 e;
    private final int a;

    static {
        EnumC3773Ch1[] enumC3773Ch1ArrA = a();
        d = enumC3773Ch1ArrA;
        e = G92.a(enumC3773Ch1ArrA);
    }

    private EnumC3773Ch1(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC3773Ch1[] a() {
        return new EnumC3773Ch1[]{b, c};
    }

    public static EnumC3773Ch1 valueOf(String str) {
        return (EnumC3773Ch1) Enum.valueOf(EnumC3773Ch1.class, str);
    }

    public static EnumC3773Ch1[] values() {
        return (EnumC3773Ch1[]) d.clone();
    }

    public final int j() {
        return this.a;
    }
}
