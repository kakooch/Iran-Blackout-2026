package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Vv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC8411Vv7 {
    public static final EnumC8411Vv7 a = new EnumC8411Vv7("ContinueTraversal", 0);
    public static final EnumC8411Vv7 b = new EnumC8411Vv7("SkipSubtreeAndContinueTraversal", 1);
    public static final EnumC8411Vv7 c = new EnumC8411Vv7("CancelTraversal", 2);
    private static final /* synthetic */ EnumC8411Vv7[] d;
    private static final /* synthetic */ F92 e;

    static {
        EnumC8411Vv7[] enumC8411Vv7ArrA = a();
        d = enumC8411Vv7ArrA;
        e = G92.a(enumC8411Vv7ArrA);
    }

    private EnumC8411Vv7(String str, int i) {
    }

    private static final /* synthetic */ EnumC8411Vv7[] a() {
        return new EnumC8411Vv7[]{a, b, c};
    }

    public static EnumC8411Vv7 valueOf(String str) {
        return (EnumC8411Vv7) Enum.valueOf(EnumC8411Vv7.class, str);
    }

    public static EnumC8411Vv7[] values() {
        return (EnumC8411Vv7[]) d.clone();
    }
}
