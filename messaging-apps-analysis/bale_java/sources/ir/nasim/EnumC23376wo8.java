package ir.nasim;

/* renamed from: ir.nasim.wo8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC23376wo8 implements InterfaceC22160ul8 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4);

    private static final InterfaceC23346wl8 g = new InterfaceC23346wl8() { // from class: ir.nasim.Co8
        @Override // ir.nasim.InterfaceC23346wl8
        public final /* synthetic */ InterfaceC22160ul8 l(int i) {
            return EnumC23376wo8.a(i);
        }
    };
    private final int a;

    EnumC23376wo8(int i) {
        this.a = i;
    }

    public static EnumC23376wo8 a(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 1) {
            return UNMETERED_ONLY;
        }
        if (i == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i != 4) {
            return null;
        }
        return NEVER;
    }

    public final int j() {
        return this.a;
    }
}
