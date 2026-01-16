package ir.nasim.core.markdown.card;

import android.content.Context;
import android.view.View;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19406qI3;
import ir.nasim.C3343Am;
import ir.nasim.designsystem.BaseUrlSpan;
import ir.nasim.features.payment.view.activity.CardPaymentActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lir/nasim/core/markdown/card/BankCardSpan;", "Lir/nasim/designsystem/BaseUrlSpan;", "", "cardText", "<init>", "(Ljava/lang/String;)V", "Landroid/view/View;", "widget", "Lir/nasim/rB7;", "onClick", "(Landroid/view/View;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class BankCardSpan extends BaseUrlSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardSpan(String str) {
        super(str);
        AbstractC13042fc3.i(str, "cardText");
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        AbstractC13042fc3.i(widget, "widget");
        try {
            C3343Am.g("c2c_open_from_message_card_detect");
            CardPaymentActivity.Companion companion = CardPaymentActivity.INSTANCE;
            Context context = widget.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            String url = getURL();
            AbstractC13042fc3.h(url, "getURL(...)");
            companion.h(context, url);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }
}
