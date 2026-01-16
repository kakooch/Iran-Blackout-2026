package ir.nasim.features.conversation.placeholder;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.JF5;
import ir.nasim.KB5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lir/nasim/features/conversation/placeholder/ChatBigEmptyView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChatBigEmptyView extends LinearLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBigEmptyView(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        setBackgroundResource(KB5.bg_saved_messsage);
        getBackground().setColorFilter(null);
        setPadding(C22078ud6.a(16.0f), C22078ud6.a(12.0f), C22078ud6.a(16.0f), C22078ud6.a(12.0f));
        setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(textView.getResources().getString(AbstractC12217eE5.saved_message_title));
        textView.setTextSize(1, 15.0f);
        textView.setTypeface(C6011Lu2.i());
        textView.setGravity(1);
        textView.setTextColor(C5495Jo7.a.f1());
        textView.setMaxWidth(C22078ud6.a(260.0f));
        addView(textView, C14433hu3.i(-2, -2, 49, 0, 8, 0, 8));
        int i = 0;
        while (true) {
            if (i >= 5) {
                return;
            }
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            addView(linearLayout, C14433hu3.i(-2, -2, JF5.g() ? 5 : 3, 0, 0, 0, 0));
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 14.0f);
            textView2.setTextColor(C5495Jo7.a.v0());
            textView2.setTypeface(C6011Lu2.k());
            textView2.setGravity((JF5.g() ? 5 : 3) | 16);
            textView2.setMaxWidth(C22078ud6.a(260.0f));
            textView2.setText(i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : textView2.getResources().getString(AbstractC12217eE5.ChatYourSelfDescription4) : textView2.getResources().getString(AbstractC12217eE5.ChatYourSelfDescription3) : textView2.getResources().getString(AbstractC12217eE5.ChatYourSelfDescription2) : textView2.getResources().getString(AbstractC12217eE5.ChatYourSelfDescription1) : textView2.getResources().getString(AbstractC12217eE5.ChatYourSelfDescription0));
            if (JF5.g()) {
                linearLayout.addView(textView2, C14433hu3.d(-2, -2));
            } else {
                linearLayout.addView(textView2, C14433hu3.d(-2, -2));
            }
            i++;
        }
    }
}
