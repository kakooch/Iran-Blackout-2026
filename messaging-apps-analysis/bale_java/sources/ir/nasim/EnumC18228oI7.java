package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.oI7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC18228oI7 {
    public static final EnumC18228oI7 a = new EnumC18228oI7("STREAMING", 0);
    public static final EnumC18228oI7 b = new EnumC18228oI7("CALLING", 1);
    public static final EnumC18228oI7 c = new EnumC18228oI7("HAS_UNSEEN_STORY", 2);
    public static final EnumC18228oI7 d = new EnumC18228oI7("ALL_STORY_VISITED", 3);
    private static final /* synthetic */ EnumC18228oI7[] e;
    private static final /* synthetic */ F92 f;

    static {
        EnumC18228oI7[] enumC18228oI7ArrA = a();
        e = enumC18228oI7ArrA;
        f = G92.a(enumC18228oI7ArrA);
    }

    private EnumC18228oI7(String str, int i) {
    }

    private static final /* synthetic */ EnumC18228oI7[] a() {
        return new EnumC18228oI7[]{a, b, c, d};
    }

    public static F92 j() {
        return f;
    }

    public static EnumC18228oI7 valueOf(String str) {
        return (EnumC18228oI7) Enum.valueOf(EnumC18228oI7.class, str);
    }

    public static EnumC18228oI7[] values() {
        return (EnumC18228oI7[]) e.clone();
    }
}
