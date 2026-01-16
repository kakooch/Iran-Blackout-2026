package ir.nasim;

import android.content.Context;
import android.gov.nist.core.Separators;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.view.ContextThemeWrapper;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class TZ0 {
    public static final a c = new a(null);
    public static final int d = 8;
    private final InterfaceC9173Yu3 a;
    private final InterfaceC9173Yu3 b;

    public static final class a {
        private a() {
        }

        public final Map a(Context context, C13518gM7 c13518gM7, Set set) {
            CI7 ci7A;
            AbstractC13042fc3.i(context, "context");
            AbstractC13042fc3.i(c13518gM7, "usersProcessor");
            AbstractC13042fc3.i(set, "userIds");
            Map mapD = AbstractC19460qO3.d();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (!mapD.containsKey(Integer.valueOf(iIntValue)) && (ci7A = c13518gM7.a(iIntValue)) != null) {
                    mapD.put(Integer.valueOf(ci7A.c()), AbstractC13591gV.a(ci7A, context));
                }
            }
            return AbstractC19460qO3.c(mapD);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public TZ0(final Context context) {
        AbstractC13042fc3.i(context, "context");
        this.a = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.RZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TZ0.j(context);
            }
        });
        this.b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.SZ0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return TZ0.k(context);
            }
        });
    }

    private final void c(SpannableStringBuilder spannableStringBuilder, ReplacementSpan replacementSpan, String str) {
        spannableStringBuilder.setSpan(replacementSpan, 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(6));
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.append((CharSequence) AbstractC17636nI6.b(16));
    }

    private final ReplacementSpan d(ContextThemeWrapper contextThemeWrapper, int i) {
        Drawable drawableF = AbstractC4043Dl1.f(contextThemeWrapper, i);
        if (drawableF == null) {
            return null;
        }
        drawableF.setBounds(0, (int) (((-8) * AbstractC3742Cd6.c()) + 0.5d), (int) ((24 * AbstractC3742Cd6.c()) + 0.5d), (int) ((16 * AbstractC3742Cd6.c()) + 0.5d));
        drawableF.setTint(OY0.b(contextThemeWrapper, AbstractC21139tA5.bubble_low_text));
        return new ImageSpan(drawableF);
    }

    private final int f(Context context) {
        return OY0.b(context, AbstractC21139tA5.bubble_third);
    }

    private final int g(Context context) {
        XV4 xv4A = AbstractC4616Fw7.a(Integer.valueOf(AbstractC21139tA5.bubble_primary), Integer.valueOf(AbstractC21139tA5.bubble_third));
        return OY0.a(OY0.b(context, ((Number) xv4A.e()).intValue()), OY0.b(context, ((Number) xv4A.f()).intValue()));
    }

    private final ContextThemeWrapper h() {
        return (ContextThemeWrapper) this.a.getValue();
    }

    private final ContextThemeWrapper i() {
        return (ContextThemeWrapper) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper j(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new ContextThemeWrapper(context, AbstractC23035wE5.Theme_Bale_BubbleTheme_Incomming);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextThemeWrapper k(Context context) {
        AbstractC13042fc3.i(context, "$context");
        return new ContextThemeWrapper(context, AbstractC23035wE5.Theme_Bale_BubbleTheme_Outgoing);
    }

    public final Spannable e(int i, int i2, int i3, List list) {
        ReplacementSpan replacementSpanD;
        String string;
        AbstractC13042fc3.i(list, "avatars");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ContextThemeWrapper contextThemeWrapperH = i2 != i ? h() : i();
        int iF = f(contextThemeWrapperH);
        if (!list.isEmpty()) {
            replacementSpanD = new C17192mZ0(iF, g(contextThemeWrapperH), 0.0f, 0, 0, 0, 0, list, 124, null);
        } else {
            replacementSpanD = d(contextThemeWrapperH, KB5.comment);
            if (replacementSpanD == null) {
                return spannableStringBuilder;
            }
        }
        if (i3 == 0) {
            string = contextThemeWrapperH.getString(AbstractC12217eE5.leave_comment);
        } else {
            string = XY6.v(XY6.i(i3)) + Separators.SP + contextThemeWrapperH.getString(AbstractC12217eE5.comment);
        }
        AbstractC13042fc3.f(string);
        String strV = XY6.v(string);
        spannableStringBuilder.append("avatar");
        c(spannableStringBuilder, replacementSpanD, strV);
        return spannableStringBuilder;
    }
}
