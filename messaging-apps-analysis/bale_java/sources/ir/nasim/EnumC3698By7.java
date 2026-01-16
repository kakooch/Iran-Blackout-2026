package ir.nasim;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* renamed from: ir.nasim.By7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class EnumC3698By7 {
    public static final EnumC3698By7 a = new EnumC3698By7("SeeMessage", 0);
    public static final EnumC3698By7 b = new EnumC3698By7("DeleteMessage", 1);
    public static final EnumC3698By7 c = new EnumC3698By7("KickUser", 2);
    public static final EnumC3698By7 d = new EnumC3698By7("PinMessage", 3);
    public static final EnumC3698By7 e = new EnumC3698By7("InviteUser", 4);
    public static final EnumC3698By7 f = new EnumC3698By7("AddAdmin", 5);
    public static final EnumC3698By7 g = new EnumC3698By7("ChangeInfo", 6);
    public static final EnumC3698By7 h = new EnumC3698By7("SendMessage", 7);
    public static final EnumC3698By7 i = new EnumC3698By7("SeeMembers", 8);
    public static final EnumC3698By7 j = new EnumC3698By7("EditMessage", 9);
    public static final EnumC3698By7 k = new EnumC3698By7("SendMedia", 10);
    public static final EnumC3698By7 l = new EnumC3698By7("SendGifStickers", 11);
    public static final EnumC3698By7 m = new EnumC3698By7("ReplyToStory", 12);
    public static final EnumC3698By7 n = new EnumC3698By7("AddStory", 13);
    public static final EnumC3698By7 o = new EnumC3698By7("StartCall", 14);
    public static final EnumC3698By7 p = new EnumC3698By7("CallManagement", 15);
    private static final /* synthetic */ EnumC3698By7[] q;
    private static final /* synthetic */ F92 r;

    static {
        EnumC3698By7[] enumC3698By7ArrA = a();
        q = enumC3698By7ArrA;
        r = G92.a(enumC3698By7ArrA);
    }

    private EnumC3698By7(String str, int i2) {
    }

    private static final /* synthetic */ EnumC3698By7[] a() {
        return new EnumC3698By7[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
    }

    public static EnumC3698By7 valueOf(String str) {
        return (EnumC3698By7) Enum.valueOf(EnumC3698By7.class, str);
    }

    public static EnumC3698By7[] values() {
        return (EnumC3698By7[]) q.clone();
    }
}
