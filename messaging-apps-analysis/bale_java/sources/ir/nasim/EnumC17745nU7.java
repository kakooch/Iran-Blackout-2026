package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.nU7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class EnumC17745nU7 implements InterfaceC18336oU7 {
    public static final EnumC17745nU7 c = new EnumC17745nU7("H120", 0, new AS7(160, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER, 15, false, 8, null), new C9737aT7(70000, 15));
    public static final EnumC17745nU7 d = new EnumC17745nU7("H180", 1, new AS7(SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER, 15, false, 8, null), new C9737aT7(125000, 15));
    public static final EnumC17745nU7 e = new EnumC17745nU7("H240", 2, new AS7(320, SetRpcStruct$ComposedRpc.RESPONSE_STICKERS_REPONSE_FIELD_NUMBER, 15, false, 8, null), new C9737aT7(140000, 15));
    public static final EnumC17745nU7 f = new EnumC17745nU7("H360", 3, new AS7(480, 360, 30, false, 8, null), new C9737aT7(330000, 30));
    public static final EnumC17745nU7 g = new EnumC17745nU7("H480", 4, new AS7(640, 480, 30, false, 8, null), new C9737aT7(500000, 30));
    public static final EnumC17745nU7 h = new EnumC17745nU7("H540", 5, new AS7(720, 540, 30, false, 8, null), new C9737aT7(600000, 30));
    public static final EnumC17745nU7 i = new EnumC17745nU7("H720", 6, new AS7(960, 720, 30, false, 8, null), new C9737aT7(1300000, 30));
    public static final EnumC17745nU7 j = new EnumC17745nU7("H1080", 7, new AS7(1440, 1080, 30, false, 8, null), new C9737aT7(2300000, 30));
    public static final EnumC17745nU7 k = new EnumC17745nU7("H1440", 8, new AS7(1920, 1440, 30, false, 8, null), new C9737aT7(3800000, 30));
    private static final /* synthetic */ EnumC17745nU7[] l;
    private static final /* synthetic */ F92 m;
    private final AS7 a;
    private final C9737aT7 b;

    static {
        EnumC17745nU7[] enumC17745nU7ArrP = p();
        l = enumC17745nU7ArrP;
        m = G92.a(enumC17745nU7ArrP);
    }

    private EnumC17745nU7(String str, int i2, AS7 as7, C9737aT7 c9737aT7) {
        this.a = as7;
        this.b = c9737aT7;
    }

    private static final /* synthetic */ EnumC17745nU7[] p() {
        return new EnumC17745nU7[]{c, d, e, f, g, h, i, j, k};
    }

    public static EnumC17745nU7 valueOf(String str) {
        return (EnumC17745nU7) Enum.valueOf(EnumC17745nU7.class, str);
    }

    public static EnumC17745nU7[] values() {
        return (EnumC17745nU7[]) l.clone();
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
