package ir.nasim;

import android.app.Activity;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

/* loaded from: classes5.dex */
public final class L60 implements M60 {
    private final void b(SpannableStringBuilder spannableStringBuilder, C23057wH0 c23057wH0, Context context) {
        String strA = c23057wH0.a();
        if (strA == null || !(!AbstractC20762sZ6.n0(strA))) {
            return;
        }
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_date));
        l(spannableStringBuilder, strA);
    }

    private final void c(SpannableStringBuilder spannableStringBuilder, C23057wH0 c23057wH0, Context context) {
        String strB = c23057wH0.b();
        if (strB == null || !(!AbstractC20762sZ6.n0(strB))) {
            return;
        }
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_description));
        l(spannableStringBuilder, strB);
    }

    private final void d(SpannableStringBuilder spannableStringBuilder, C23057wH0 c23057wH0, Context context) {
        String strC = c23057wH0.c();
        if (strC == null || !(!AbstractC20762sZ6.n0(strC))) {
            return;
        }
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_dest_card));
        l(spannableStringBuilder, AbstractC20153rZ6.M(strC, Separators.SP, "", false, 4, null));
    }

    private final void e(SpannableStringBuilder spannableStringBuilder, C23057wH0 c23057wH0, Context context) {
        String strD = c23057wH0.d();
        if (strD == null || !(!AbstractC20762sZ6.n0(strD))) {
            return;
        }
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_dest_name));
        l(spannableStringBuilder, strD);
    }

    private final void f(SpannableStringBuilder spannableStringBuilder, Context context) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_share_hashtags));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(AbstractC4043Dl1.c(context, TA5.secondary)), length, spannableStringBuilder.length(), 33);
    }

    private final void g(SpannableStringBuilder spannableStringBuilder, C23057wH0 c23057wH0, Context context) {
        String strE = c23057wH0.e();
        if (strE == null || !(!AbstractC20762sZ6.n0(strE))) {
            return;
        }
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_amount));
        l(spannableStringBuilder, strE);
    }

    private final void h(SpannableStringBuilder spannableStringBuilder, C23057wH0 c23057wH0, Context context) {
        String strF = c23057wH0.f();
        if (strF == null || !(!AbstractC20762sZ6.n0(strF))) {
            return;
        }
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_src_card));
        l(spannableStringBuilder, AbstractC20153rZ6.M(strF, Separators.SP, "", false, 4, null));
    }

    private final void i(SpannableStringBuilder spannableStringBuilder, Context context) {
        spannableStringBuilder.append(Separators.RETURN);
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_title));
        spannableStringBuilder.append(Separators.RETURN);
    }

    private final void j(SpannableStringBuilder spannableStringBuilder, C23057wH0 c23057wH0, Context context) {
        String strG = c23057wH0.g();
        if (strG == null || !(!AbstractC20762sZ6.n0(strG))) {
            return;
        }
        spannableStringBuilder.append((CharSequence) context.getString(AbstractC12217eE5.banking_card2card_receipt_dialog_trace_number));
        l(spannableStringBuilder, strG);
    }

    private final void k(SpannableStringBuilder spannableStringBuilder, String str) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        spannableStringBuilder.setSpan(new StyleSpan(1), length, spannableStringBuilder.length(), 33);
    }

    private final void l(SpannableStringBuilder spannableStringBuilder, String str) {
        spannableStringBuilder.append(Separators.SP);
        k(spannableStringBuilder, str);
        spannableStringBuilder.append(Separators.RETURN);
    }

    @Override // ir.nasim.M60
    public void a(Context context, InterfaceC19311q80 interfaceC19311q80, Activity activity) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(activity, "activity");
        try {
            if (interfaceC19311q80 instanceof C23057wH0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                String string = context.getString(AbstractC12217eE5.banking_card2card_receipt_share_main_title);
                AbstractC13042fc3.h(string, "getString(...)");
                k(spannableStringBuilder, string);
                i(spannableStringBuilder, context);
                g(spannableStringBuilder, (C23057wH0) interfaceC19311q80, context);
                h(spannableStringBuilder, (C23057wH0) interfaceC19311q80, context);
                d(spannableStringBuilder, (C23057wH0) interfaceC19311q80, context);
                e(spannableStringBuilder, (C23057wH0) interfaceC19311q80, context);
                j(spannableStringBuilder, (C23057wH0) interfaceC19311q80, context);
                b(spannableStringBuilder, (C23057wH0) interfaceC19311q80, context);
                c(spannableStringBuilder, (C23057wH0) interfaceC19311q80, context);
                f(spannableStringBuilder, context);
                AbstractC16739ln.a.h(activity, spannableStringBuilder);
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }
}
