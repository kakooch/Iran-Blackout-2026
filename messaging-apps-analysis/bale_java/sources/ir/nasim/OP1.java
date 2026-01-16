package ir.nasim;

/* loaded from: classes5.dex */
public enum OP1 {
    ALL(0),
    PRIVATE(1),
    GROUP(2),
    CHANNEL(3),
    BOT(4);

    private final int a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[OP1.values().length];
            a = iArr;
            try {
                iArr[OP1.BOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[OP1.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[OP1.CHANNEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[OP1.PRIVATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    OP1(int i) {
        this.a = i;
    }

    public int j() {
        return this.a;
    }

    public EnumC10088b35 p() {
        int i = a.a[ordinal()];
        if (i == 1) {
            return EnumC10088b35.ExPeerType_BOT;
        }
        if (i == 2) {
            return EnumC10088b35.ExPeerType_GROUP;
        }
        if (i == 3) {
            return EnumC10088b35.ExPeerType_CHANNEL;
        }
        if (i != 4) {
            return null;
        }
        return EnumC10088b35.ExPeerType_PRIVATE;
    }
}
