package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC25195zt3;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public final class QM1 {
    private final InterfaceC7720Sx5 a;
    private final InterfaceC9173Yu3 b;

    public QM1(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "myUidProvider");
        this.a = interfaceC7720Sx5;
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.PM1
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return QM1.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C15296jL3 b() {
        return new C15296jL3(510);
    }

    private final C15296jL3 c() {
        return (C15296jL3) this.b.getValue();
    }

    private final int d() {
        Object obj = this.a.get();
        AbstractC13042fc3.h(obj, "get(...)");
        return ((Number) obj).intValue();
    }

    private final boolean h(boolean z, int i, boolean z2, boolean z3) {
        return z && i <= 0 && !z2 && !z3;
    }

    public final String e(Context context, boolean z, AbstractC25195zt3 abstractC25195zt3, String str, AbstractC19428qK7 abstractC19428qK7, boolean z2, String str2, boolean z3, int i, boolean z4, boolean z5, long j, long j2, String str3, String str4, String str5) throws IOException {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "userName");
        AbstractC13042fc3.i(abstractC19428qK7, "userType");
        AbstractC13042fc3.i(str2, "lastReactionEmoji");
        StringBuilder sb = new StringBuilder();
        C15296jL3 c15296jL3C = c();
        Long lValueOf = Long.valueOf(j);
        Object objO = c15296jL3C.get(lValueOf);
        if (objO == null) {
            objO = C14593iA1.O(context, j);
            c15296jL3C.put(lValueOf, objO);
        }
        String string = (String) objO;
        List listC = AbstractC9766aX0.c();
        Integer numA = abstractC19428qK7.a();
        if (numA != null) {
            listC.add(context.getString(numA.intValue()));
        }
        listC.add(str);
        if (z) {
            listC.add(context.getString(UD5.mute_icon_content_description));
        }
        if (i > 0) {
            listC.add(context.getString(UD5.new_message_content_description, i > 999 ? "+999" : String.valueOf(i)));
        }
        if (j2 != d()) {
            if (z2) {
                listC.add(context.getString(UD5.mention_icon_content_description));
            }
            if (!h(z5, i, z4, z2) && (!AbstractC20762sZ6.n0(str2))) {
                listC.add(context.getString(UD5.reaction_icon_content_description));
            }
        }
        if (z3) {
            listC.add(context.getString(UD5.pin_icon_content_description));
        }
        if (new C20644sM5("\\d{1,2}:\\d{1,2}").g(string)) {
            List listN0 = AbstractC20762sZ6.N0(string, new String[]{":"}, false, 0, 6, null);
            string = context.getString(UD5.time_content_description, (String) listN0.get(0), (String) listN0.get(1));
        }
        AbstractC13042fc3.f(string);
        if (str5 != null) {
            listC.add(context.getString(AbstractC12217eE5.message_state_with_time, string, str5));
        } else {
            listC.add(string);
        }
        if (j2 == d() && !(abstractC25195zt3 instanceof AbstractC25195zt3.d) && !(abstractC25195zt3 instanceof AbstractC25195zt3.c)) {
            listC.add(context.getString(UD5.new_message_content_description));
        }
        if (str4 != null) {
            String str6 = AbstractC20762sZ6.n0(str4) ^ true ? str4 : null;
            if (str6 != null) {
                listC.add(str6);
            }
        }
        if (str3 != null) {
            String str7 = AbstractC20762sZ6.n0(str3) ^ true ? str3 : null;
            if (str7 != null) {
                listC.add(str7);
            }
        }
        AbstractC15401jX0.x0(AbstractC9766aX0.a(listC), sb, (124 & 2) != 0 ? ", " : Separators.SP, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        String string2 = sb.toString();
        AbstractC13042fc3.h(string2, "toString(...)");
        return string2;
    }

    public final void g() {
        c().clear();
    }
}
