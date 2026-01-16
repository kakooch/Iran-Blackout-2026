package ir.nasim;

/* loaded from: classes5.dex */
public enum E25 {
    INFORMAL(1),
    VERIFIED(2),
    LEGAL(3);

    private int a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[E25.values().length];
            a = iArr;
            try {
                iArr[E25.INFORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[E25.VERIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[E25.LEGAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    E25(int i) {
        this.a = i;
    }

    public static E25 j(int i) {
        return i != 2 ? i != 3 ? INFORMAL : LEGAL : VERIFIED;
    }

    public int p() {
        return this.a;
    }

    public EnumC15129j35 q() {
        int i = a.a[ordinal()];
        return i != 1 ? i != 2 ? EnumC15129j35.PeerIdentity_LEGAL : EnumC15129j35.PeerIdentity_VERIFIED : EnumC15129j35.PeerIdentity_INFORMAL;
    }
}
