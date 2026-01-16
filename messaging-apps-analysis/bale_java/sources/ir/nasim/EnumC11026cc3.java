package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.cc3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class EnumC11026cc3 {
    public static final EnumC11026cc3 a = new EnumC11026cc3("Min", 0);
    public static final EnumC11026cc3 b = new EnumC11026cc3("Max", 1);
    private static final /* synthetic */ EnumC11026cc3[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC11026cc3[] enumC11026cc3ArrA = a();
        c = enumC11026cc3ArrA;
        d = G92.a(enumC11026cc3ArrA);
    }

    private EnumC11026cc3(String str, int i) {
    }

    private static final /* synthetic */ EnumC11026cc3[] a() {
        return new EnumC11026cc3[]{a, b};
    }

    public static EnumC11026cc3 valueOf(String str) {
        return (EnumC11026cc3) Enum.valueOf(EnumC11026cc3.class, str);
    }

    public static EnumC11026cc3[] values() {
        return (EnumC11026cc3[]) c.clone();
    }
}
