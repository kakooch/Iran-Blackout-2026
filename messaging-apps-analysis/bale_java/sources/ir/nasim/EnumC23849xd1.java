package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.xd1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC23849xd1 {
    public static final EnumC23849xd1 b = new EnumC23849xd1("CONNECTED", 0, FD5.dialogs_connection_state_connecting);
    public static final EnumC23849xd1 c = new EnumC23849xd1("CONNECTING", 1, FD5.dialogs_connection_state_connecting);
    public static final EnumC23849xd1 d = new EnumC23849xd1("UPDATING", 2, FD5.dialogs_connection_state_updating);
    public static final EnumC23849xd1 e = new EnumC23849xd1("WAIT_FOR_NETWORK", 3, FD5.dialogs_connection_state_wait_for_network);
    private static final /* synthetic */ EnumC23849xd1[] f;
    private static final /* synthetic */ F92 g;
    private final int a;

    static {
        EnumC23849xd1[] enumC23849xd1ArrA = a();
        f = enumC23849xd1ArrA;
        g = G92.a(enumC23849xd1ArrA);
    }

    private EnumC23849xd1(String str, int i, int i2) {
        this.a = i2;
    }

    private static final /* synthetic */ EnumC23849xd1[] a() {
        return new EnumC23849xd1[]{b, c, d, e};
    }

    public static EnumC23849xd1 valueOf(String str) {
        return (EnumC23849xd1) Enum.valueOf(EnumC23849xd1.class, str);
    }

    public static EnumC23849xd1[] values() {
        return (EnumC23849xd1[]) f.clone();
    }

    public final int j() {
        return this.a;
    }
}
