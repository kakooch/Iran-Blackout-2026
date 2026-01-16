package ir.nasim;

import org.xbill.DNS.SimpleResolver;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.Fd6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC4444Fd6 implements InterfaceC18336oU7 {
    public static final EnumC4444Fd6 c = new EnumC4444Fd6("H360_FPS3", 0, new AS7(640, 360, 3, false, 8, null), new C9737aT7(200000, 3));
    public static final EnumC4444Fd6 d = new EnumC4444Fd6("H360_FPS15", 1, new AS7(640, 360, 15, false, 8, null), new C9737aT7(400000, 15));
    public static final EnumC4444Fd6 e = new EnumC4444Fd6("H720_FPS5", 2, new AS7(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 720, 5, false, 8, null), new C9737aT7(800000, 5));
    public static final EnumC4444Fd6 f = new EnumC4444Fd6("H720_FPS15", 3, new AS7(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 720, 15, false, 8, null), new C9737aT7(1500000, 15));
    public static final EnumC4444Fd6 g = new EnumC4444Fd6("H720_FPS30", 4, new AS7(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 720, 30, false, 8, null), new C9737aT7(2000000, 30));
    public static final EnumC4444Fd6 h = new EnumC4444Fd6("H1080_FPS15", 5, new AS7(1920, 1080, 15, false, 8, null), new C9737aT7(2500000, 15));
    public static final EnumC4444Fd6 i = new EnumC4444Fd6("H1080_FPS30", 6, new AS7(1920, 1080, 30, false, 8, null), new C9737aT7(5000000, 30));
    public static final EnumC4444Fd6 j = new EnumC4444Fd6("ORIGINAL", 7, new AS7(0, 0, 30, false), new C9737aT7(7000000, 30));
    private static final /* synthetic */ EnumC4444Fd6[] k;
    private static final /* synthetic */ F92 l;
    private final AS7 a;
    private final C9737aT7 b;

    static {
        EnumC4444Fd6[] enumC4444Fd6ArrP = p();
        k = enumC4444Fd6ArrP;
        l = G92.a(enumC4444Fd6ArrP);
    }

    private EnumC4444Fd6(String str, int i2, AS7 as7, C9737aT7 c9737aT7) {
        this.a = as7;
        this.b = c9737aT7;
    }

    private static final /* synthetic */ EnumC4444Fd6[] p() {
        return new EnumC4444Fd6[]{c, d, e, f, g, h, i, j};
    }

    public static EnumC4444Fd6 valueOf(String str) {
        return (EnumC4444Fd6) Enum.valueOf(EnumC4444Fd6.class, str);
    }

    public static EnumC4444Fd6[] values() {
        return (EnumC4444Fd6[]) k.clone();
    }

    @Override // ir.nasim.InterfaceC18336oU7
    public AS7 a() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC18336oU7
    public C9737aT7 j() {
        return this.b;
    }
}
