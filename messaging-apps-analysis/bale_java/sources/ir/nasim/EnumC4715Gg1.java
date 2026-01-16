package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Gg1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC4715Gg1 {
    public static final EnumC4715Gg1 c = new EnumC4715Gg1("ALPHABETIC", 0, AbstractC12217eE5.contacts_sorted_by_name, AbstractC24188yB5.ic_alphabetic_sort);
    public static final EnumC4715Gg1 d = new EnumC4715Gg1("PRESENCE", 1, AbstractC12217eE5.contacts_sorted_by_last_seen, AbstractC24188yB5.ic_presence_sort);
    private static final /* synthetic */ EnumC4715Gg1[] e;
    private static final /* synthetic */ F92 f;
    private final int a;
    private final int b;

    static {
        EnumC4715Gg1[] enumC4715Gg1ArrA = a();
        e = enumC4715Gg1ArrA;
        f = G92.a(enumC4715Gg1ArrA);
    }

    private EnumC4715Gg1(String str, int i, int i2, int i3) {
        this.a = i2;
        this.b = i3;
    }

    private static final /* synthetic */ EnumC4715Gg1[] a() {
        return new EnumC4715Gg1[]{c, d};
    }

    public static EnumC4715Gg1 valueOf(String str) {
        return (EnumC4715Gg1) Enum.valueOf(EnumC4715Gg1.class, str);
    }

    public static EnumC4715Gg1[] values() {
        return (EnumC4715Gg1[]) e.clone();
    }

    public final int j() {
        return this.b;
    }

    public final int p() {
        return this.a;
    }
}
