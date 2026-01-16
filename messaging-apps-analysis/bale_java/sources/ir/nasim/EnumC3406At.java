package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.At, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class EnumC3406At {
    public static final EnumC3406At a = new EnumC3406At("BoundReached", 0);
    public static final EnumC3406At b = new EnumC3406At("Finished", 1);
    private static final /* synthetic */ EnumC3406At[] c;
    private static final /* synthetic */ F92 d;

    static {
        EnumC3406At[] enumC3406AtArrA = a();
        c = enumC3406AtArrA;
        d = G92.a(enumC3406AtArrA);
    }

    private EnumC3406At(String str, int i) {
    }

    private static final /* synthetic */ EnumC3406At[] a() {
        return new EnumC3406At[]{a, b};
    }

    public static EnumC3406At valueOf(String str) {
        return (EnumC3406At) Enum.valueOf(EnumC3406At.class, str);
    }

    public static EnumC3406At[] values() {
        return (EnumC3406At[]) c.clone();
    }
}
