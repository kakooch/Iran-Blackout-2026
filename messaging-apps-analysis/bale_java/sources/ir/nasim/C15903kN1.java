package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.Spannable;
import android.text.SpannableString;
import ir.nasim.core.modules.profile.entity.ExPeerType;

/* renamed from: ir.nasim.kN1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15903kN1 {
    public static final C15903kN1 a = new C15903kN1();

    private C15903kN1() {
    }

    private final ZN2 a(ExPeerType exPeerType) {
        return exPeerType == ExPeerType.CHANNEL ? ZN2.CHANNEL : ZN2.GROUP;
    }

    private final Spannable b(C15280jJ5 c15280jJ5) {
        StringBuilder sb = new StringBuilder();
        sb.append(XY6.v(c15280jJ5.a()));
        sb.append(Separators.SP + C5721Ko.a.d().getString(AbstractC12217eE5.member) + Separators.SP);
        sb.append(" | ");
        sb.append(c15280jJ5.b());
        sb.append(Separators.AT);
        Spannable spannableC = AbstractC5730Kp.c(sb.toString());
        if (spannableC != null) {
            return spannableC;
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return AbstractC17636nI6.i(string);
    }

    public static final Spannable c(Context context, C17067mL1 c17067mL1) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(c17067mL1, "dialog");
        String strK = c17067mL1.K();
        if (strK != null && strK.length() != 0 && c17067mL1.Y() == 0) {
            return a.e(strK);
        }
        C15280jJ5 c15280jJ5V = c17067mL1.V();
        if (c15280jJ5V != null) {
            return a.b(c15280jJ5V);
        }
        AbstractC17457n0 abstractC17457n0F = c17067mL1.Q().F();
        if (!(!(abstractC17457n0F instanceof C18121o72))) {
            abstractC17457n0F = null;
        }
        if (abstractC17457n0F == null) {
            C8445Vz5 c8445Vz5Q = c17067mL1.Q().Q();
            AbstractC17457n0 abstractC17457n0R = c8445Vz5Q != null ? c8445Vz5Q.r() : null;
            if (abstractC17457n0R == null) {
                return new SpannableString("");
            }
            abstractC17457n0F = abstractC17457n0R;
        }
        C15903kN1 c15903kN1 = a;
        boolean z = c15903kN1.a(c17067mL1.getExPeerType()) == ZN2.GROUP;
        CI7 ci7Y = c17067mL1.Q().Y();
        String strB = abstractC17457n0F.b(context, (ci7Y != null && ci7Y.d() && (abstractC17457n0F instanceof C24584yr6)) ? 0 : c17067mL1.Q().U(), c17067mL1.W(), z);
        if (c17067mL1.R().s() == W25.b && z && c15903kN1.f(c17067mL1.Q().F())) {
            strB = AbstractC20655sN7.e(context, c17067mL1.Q().U(), c17067mL1.W(), false, 4, null) + ": " + strB;
        }
        return c15903kN1.e(strB);
    }

    public static final String d(Context context) {
        AbstractC13042fc3.i(context, "context");
        String string = context.getString(AbstractC12217eE5.dialog_deleted_account);
        AbstractC13042fc3.h(string, "getString(...)");
        return string;
    }

    private final boolean f(AbstractC17457n0 abstractC17457n0) {
        if (abstractC17457n0 instanceof AbstractC12586er6) {
            return false;
        }
        return ((abstractC17457n0 instanceof C18285oP1) && ((C18285oP1) abstractC17457n0).s().q()) ? false : true;
    }

    public final Spannable e(String str) {
        AbstractC13042fc3.i(str, "<this>");
        Spannable spannableC = AbstractC5730Kp.c(str);
        return spannableC == null ? AbstractC17636nI6.i(str) : spannableC;
    }
}
