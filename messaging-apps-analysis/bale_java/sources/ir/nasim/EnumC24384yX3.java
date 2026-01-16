package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.yX3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class EnumC24384yX3 {
    public static final EnumC24384yX3 a = new EnumC24384yX3("ALL", 0);
    public static final EnumC24384yX3 b = new EnumC24384yX3("PHOTOS", 1);
    public static final EnumC24384yX3 c = new EnumC24384yX3("VIDEOS", 2);
    private static final /* synthetic */ EnumC24384yX3[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC24384yX3[] enumC24384yX3ArrA = a();
        d = enumC24384yX3ArrA;
        e = G92.a(enumC24384yX3ArrA);
    }

    private EnumC24384yX3(String str, int i) {
    }

    private static final /* synthetic */ EnumC24384yX3[] a() {
        return new EnumC24384yX3[]{a, b, c};
    }

    public static EnumC24384yX3 valueOf(String str) {
        return (EnumC24384yX3) Enum.valueOf(EnumC24384yX3.class, str);
    }

    public static EnumC24384yX3[] values() {
        return (EnumC24384yX3[]) d.clone();
    }
}
