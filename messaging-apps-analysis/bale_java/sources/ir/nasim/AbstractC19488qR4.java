package ir.nasim;

/* renamed from: ir.nasim.qR4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC19488qR4 {

    /* renamed from: ir.nasim.qR4$a */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[C75.values().length];
            try {
                iArr[C75.PfmTransactionType_UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[C75.PfmTransactionType_TOPUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[C75.PfmTransactionType_WITHDRAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[EnumC18897pR4.values().length];
            try {
                iArr2[EnumC18897pR4.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EnumC18897pR4.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnumC18897pR4.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            b = iArr2;
        }
    }

    public static final EnumC18897pR4 a(C75 c75) {
        int i = c75 == null ? -1 : a.a[c75.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? EnumC18897pR4.b : EnumC18897pR4.d : EnumC18897pR4.c : EnumC18897pR4.b;
    }

    public static final C75 b(EnumC18897pR4 enumC18897pR4) {
        int i = enumC18897pR4 == null ? -1 : a.b[enumC18897pR4.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? C75.PfmTransactionType_UNKNOWN : C75.PfmTransactionType_WITHDRAW : C75.PfmTransactionType_TOPUP : C75.PfmTransactionType_UNKNOWN;
    }
}
