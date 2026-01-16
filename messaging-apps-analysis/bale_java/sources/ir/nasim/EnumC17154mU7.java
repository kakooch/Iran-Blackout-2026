package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import org.xbill.DNS.SimpleResolver;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.mU7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC17154mU7 implements InterfaceC18336oU7 {
    public static final EnumC17154mU7 c = new EnumC17154mU7("H90", 0, new AS7(160, 90, 15, false, 8, null), new C9737aT7(90000, 15));
    public static final EnumC17154mU7 d = new EnumC17154mU7("H180", 1, new AS7(320, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, 15, false, 8, null), new C9737aT7(160000, 15));
    public static final EnumC17154mU7 e = new EnumC17154mU7("H216", 2, new AS7(384, 216, 15, false, 8, null), new C9737aT7(180000, 15));
    public static final EnumC17154mU7 f = new EnumC17154mU7("H360", 3, new AS7(640, 360, 30, false, 8, null), new C9737aT7(450000, 30));
    public static final EnumC17154mU7 g = new EnumC17154mU7("H540", 4, new AS7(960, 540, 30, false, 8, null), new C9737aT7(800000, 30));
    public static final EnumC17154mU7 h = new EnumC17154mU7("H720", 5, new AS7(SimpleResolver.DEFAULT_EDNS_PAYLOADSIZE, 720, 30, false, 8, null), new C9737aT7(1700000, 30));
    public static final EnumC17154mU7 i = new EnumC17154mU7("H1080", 6, new AS7(1920, 1080, 30, false, 8, null), new C9737aT7(3000000, 30));
    public static final EnumC17154mU7 j = new EnumC17154mU7("H1440", 7, new AS7(2560, 1440, 30, false, 8, null), new C9737aT7(5000000, 30));
    public static final EnumC17154mU7 k = new EnumC17154mU7("H2160", 8, new AS7(3840, 2160, 30, false, 8, null), new C9737aT7(8000000, 30));
    private static final /* synthetic */ EnumC17154mU7[] l;
    private static final /* synthetic */ F92 m;
    private final AS7 a;
    private final C9737aT7 b;

    static {
        EnumC17154mU7[] enumC17154mU7ArrP = p();
        l = enumC17154mU7ArrP;
        m = G92.a(enumC17154mU7ArrP);
    }

    private EnumC17154mU7(String str, int i2, AS7 as7, C9737aT7 c9737aT7) {
        this.a = as7;
        this.b = c9737aT7;
    }

    private static final /* synthetic */ EnumC17154mU7[] p() {
        return new EnumC17154mU7[]{c, d, e, f, g, h, i, j, k};
    }

    public static EnumC17154mU7 valueOf(String str) {
        return (EnumC17154mU7) Enum.valueOf(EnumC17154mU7.class, str);
    }

    public static EnumC17154mU7[] values() {
        return (EnumC17154mU7[]) l.clone();
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
