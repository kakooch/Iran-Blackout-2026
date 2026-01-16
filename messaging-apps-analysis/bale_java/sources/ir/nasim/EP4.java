package ir.nasim;

import ai.bale.proto.PfmStruct$PfmTransactionId;
import ir.nasim.features.pfm.entity.PFMTransactionId;

/* loaded from: classes6.dex */
public final class EP4 {
    public static final EP4 a = new EP4();

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18897pR4.values().length];
            try {
                iArr[EnumC18897pR4.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18897pR4.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18897pR4.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    private EP4() {
    }

    private final C75 a(EnumC18897pR4 enumC18897pR4) {
        int i = enumC18897pR4 == null ? -1 : a.a[enumC18897pR4.ordinal()];
        if (i == 1) {
            return C75.PfmTransactionType_UNKNOWN;
        }
        if (i == 2) {
            return C75.PfmTransactionType_WITHDRAW;
        }
        if (i != 3) {
            return null;
        }
        return C75.PfmTransactionType_TOPUP;
    }

    public final PfmStruct$PfmTransactionId b(PFMTransactionId pFMTransactionId) {
        AbstractC13042fc3.i(pFMTransactionId, "<this>");
        PfmStruct$PfmTransactionId pfmStruct$PfmTransactionId = (PfmStruct$PfmTransactionId) PfmStruct$PfmTransactionId.newBuilder().C(pFMTransactionId.getRid()).B(pFMTransactionId.getDate()).A(pFMTransactionId.getAccountNumber()).D(a(pFMTransactionId.getType())).a();
        AbstractC13042fc3.f(pfmStruct$PfmTransactionId);
        return pfmStruct$PfmTransactionId;
    }
}
