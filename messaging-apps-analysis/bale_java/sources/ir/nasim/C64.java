package ir.nasim;

import android.content.Context;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class C64 {
    public static final C64 a = new C64();

    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((J44) obj).j()), Long.valueOf(((J44) obj2).j()));
        }
    }

    private C64() {
    }

    private final String a(NI5 ni5, Context context) throws NumberFormatException {
        String strV = ni5.v();
        AbstractC13042fc3.h(strV, "getReceipt(...)");
        Integer numValueOf = Integer.valueOf(AbstractC20762sZ6.l0(strV, "<date>", 0, false, 6, null));
        C64 c64 = a;
        if (!c64.f(numValueOf.intValue())) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            String strV2 = ni5.v();
            AbstractC13042fc3.h(strV2, "getReceipt(...)");
            return strV2;
        }
        int iIntValue = numValueOf.intValue();
        String strV3 = ni5.v();
        AbstractC13042fc3.h(strV3, "getReceipt(...)");
        Integer numValueOf2 = Integer.valueOf(AbstractC20762sZ6.l0(strV3, "</date>", 0, false, 6, null));
        Integer num = c64.f(numValueOf2.intValue()) ? numValueOf2 : null;
        if (num == null) {
            String strV4 = ni5.v();
            AbstractC13042fc3.h(strV4, "getReceipt(...)");
            return strV4;
        }
        int iIntValue2 = num.intValue();
        String strV5 = ni5.v();
        AbstractC13042fc3.h(strV5, "getReceipt(...)");
        String strSubstring = strV5.substring(iIntValue + 6, iIntValue2);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        try {
            long j = Long.parseLong(XY6.h(strSubstring));
            String strC = AbstractC20655sN7.c(context, AbstractC12217eE5.message_holder_content_bank_receipt_date, C14593iA1.h(context, j, false, 4, null), C14593iA1.A(j));
            String strV6 = ni5.v();
            AbstractC13042fc3.h(strV6, "getReceipt(...)");
            return AbstractC20153rZ6.M(strV6, strSubstring, strC, false, 4, null);
        } catch (Exception e) {
            C19406qI3.c("MessageFormatter", "Error in dateFormattedReceipt", e);
            String strV7 = ni5.v();
            AbstractC13042fc3.h(strV7, "getReceipt(...)");
            return strV7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0135 A[PHI: r9
      0x0135: PHI (r9v25 java.lang.String) = 
      (r9v3 java.lang.String)
      (r9v6 java.lang.String)
      (r9v9 java.lang.String)
      (r9v12 java.lang.String)
      (r9v14 java.lang.String)
      (r9v20 java.lang.String)
      (r9v24 java.lang.String)
      (r9v28 java.lang.String)
      (r9v31 java.lang.String)
     binds: [B:72:0x0132, B:65:0x011f, B:58:0x010c, B:52:0x00f1, B:49:0x00e6, B:46:0x00a9, B:42:0x00a1, B:22:0x0056, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String b(android.content.Context r21, ir.nasim.J44[] r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C64.b(android.content.Context, ir.nasim.J44[], boolean):java.lang.String");
    }

    public static /* synthetic */ String c(Context context, J44[] j44Arr, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return b(context, j44Arr, z);
    }

    private final InterfaceC8344Vo3 d() {
        return AbstractC5969Lp4.e().W().p0();
    }

    private final String e(J44 j44) {
        C17637nI7 c17637nI7 = (C17637nI7) d().d(j44.U());
        String name = c17637nI7 != null ? c17637nI7.getName() : null;
        if (name == null || name.length() == 0) {
            return "";
        }
        return name + ": ";
    }

    private final boolean f(int i) {
        return i != -1;
    }
}
