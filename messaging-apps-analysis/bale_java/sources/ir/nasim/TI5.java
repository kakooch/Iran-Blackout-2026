package ir.nasim;

/* loaded from: classes5.dex */
public enum TI5 {
    PURCHASE(1),
    BILL(2),
    CHARGE(3),
    MONEY_TRANSFER(4),
    UNSUPPORTED_VALUE(-1);

    private int a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TI5.values().length];
            a = iArr;
            try {
                iArr[TI5.BILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TI5.CHARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TI5.PURCHASE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TI5.MONEY_TRANSFER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    TI5(int i) {
        this.a = i;
    }

    public static TI5 j(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? UNSUPPORTED_VALUE : MONEY_TRANSFER : CHARGE : BILL : PURCHASE;
    }

    public EnumC21816uB p() {
        int i = a.a[j(this.a).ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? EnumC21816uB.UNSUPPORTED_VALUE : EnumC21816uB.MONEY_TRANSFER : EnumC21816uB.PURCHESE : EnumC21816uB.CHARGE : EnumC21816uB.BILL;
    }
}
