package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.pt6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC19170pt6 {
    public static final EnumC19170pt6 d = new EnumC19170pt6("NONE", 0, 0, DX0.d(4294967295L), DX0.d(4294967295L));
    public static final EnumC19170pt6 e = new EnumC19170pt6("NEW", 1, AbstractC12217eE5.badge_new, DX0.b(452412501), DX0.d(4294394965L));
    public static final EnumC19170pt6 f = new EnumC19170pt6("RECOMMENDED", 2, AbstractC12217eE5.badge_new, DX0.b(452412501), DX0.d(4294394965L));
    public static final EnumC19170pt6 g = new EnumC19170pt6("AD", 3, AbstractC12217eE5.advertise, DX0.b(871541248), DX0.d(4294084630L));
    private static final /* synthetic */ EnumC19170pt6[] h;
    private static final /* synthetic */ F92 i;
    private final int a;
    private final long b;
    private final long c;

    static {
        EnumC19170pt6[] enumC19170pt6ArrA = a();
        h = enumC19170pt6ArrA;
        i = G92.a(enumC19170pt6ArrA);
    }

    private EnumC19170pt6(String str, int i2, int i3, long j, long j2) {
        this.a = i3;
        this.b = j;
        this.c = j2;
    }

    private static final /* synthetic */ EnumC19170pt6[] a() {
        return new EnumC19170pt6[]{d, e, f, g};
    }

    public static F92 p() {
        return i;
    }

    public static EnumC19170pt6 valueOf(String str) {
        return (EnumC19170pt6) Enum.valueOf(EnumC19170pt6.class, str);
    }

    public static EnumC19170pt6[] values() {
        return (EnumC19170pt6[]) h.clone();
    }

    public final long j() {
        return this.b;
    }

    public final long q() {
        return this.c;
    }

    public final int r() {
        return this.a;
    }
}
