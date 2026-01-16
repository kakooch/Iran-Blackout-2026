package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.Spannable;
import android.text.SpannableStringBuilder;

/* loaded from: classes5.dex */
public final class I74 implements InterfaceC14123hO3 {
    private final Context a;

    public I74(Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = context;
    }

    private final Spannable b(Context context, C8445Vz5 c8445Vz5) {
        String strC = c(c8445Vz5);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) (Separators.SP + context.getString(AbstractC12217eE5.message_forwarded) + Separators.SP + strC));
        return spannableStringBuilder;
    }

    private final String c(C8445Vz5 c8445Vz5) {
        C10410bZ6 c10410bZ6R;
        String str = Separators.QUESTION;
        String strC = c8445Vz5.C();
        if (strC != null) {
            return strC;
        }
        try {
            C21231tK7 c21231tK7 = (C21231tK7) AbstractC5969Lp4.g().n(c8445Vz5.z());
            if (c21231tK7 != null && (c10410bZ6R = c21231tK7.r()) != null) {
                String str2 = (String) c10410bZ6R.b();
                if (str2 != null) {
                    str = str2;
                }
            }
        } catch (Exception unused) {
        }
        return str;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C4602Fv2 a(J44 j44) {
        AbstractC13042fc3.i(j44, "input");
        C8445Vz5 c8445Vz5Q = j44.Q();
        if (c8445Vz5Q != null && c8445Vz5Q.E()) {
            return new C4602Fv2(b(this.a, c8445Vz5Q), c8445Vz5Q.w(), c8445Vz5Q.s(), c8445Vz5Q.h(), c8445Vz5Q.u());
        }
        return null;
    }
}
