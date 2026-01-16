package ir.nasim;

import android.content.Context;
import android.content.Intent;
import android.gov.nist.core.Separators;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import ir.nasim.C15791kA6;
import java.util.List;

/* loaded from: classes5.dex */
public final class SA6 {
    public static final SA6 a = new SA6();
    private static String b = "push_shortcut_";
    public static final int c = 8;

    private SA6() {
    }

    public final C15791kA6 a(Context context, String str, D55 d55) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "peerUniqueId");
        AbstractC13042fc3.i(d55, "person");
        if (!c()) {
            return null;
        }
        String str2 = b + str;
        CharSequence charSequenceF = d55.f();
        if (charSequenceF == null) {
            charSequenceF = Separators.DOT;
        }
        SpannableString spannableString = new SpannableString(charSequenceF);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        C15791kA6 c15791kA6A = new C15791kA6.b(context, str2).f(new Intent("android.intent.action.VIEW")).m(spannableString).h().c(AbstractC4363Eu6.c("msg")).k(true).i(new C18224oI3(str2 + str)).e(d55.d()).a();
        AbstractC13042fc3.h(c15791kA6A, "build(...)");
        RA6.i(context, c15791kA6A);
        return c15791kA6A;
    }

    public final void b(List list) {
        AbstractC13042fc3.i(list, "shortcutIds");
        if (c()) {
            RA6.k(C5721Ko.a.d(), list);
        }
    }

    public final boolean c() {
        return Build.VERSION.SDK_INT >= 29;
    }
}
