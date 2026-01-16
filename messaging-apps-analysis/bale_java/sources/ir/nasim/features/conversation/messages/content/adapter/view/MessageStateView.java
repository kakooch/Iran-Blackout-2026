package ir.nasim.features.conversation.messages.content.adapter.view;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/MessageStateView;", "Lir/nasim/features/conversation/messages/content/adapter/view/BubbleTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nasim_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageStateView extends BubbleTextView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageStateView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ MessageStateView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        if (isInEditMode()) {
            return;
        }
        setTextSize(2, 11.0f);
        setTypeface(C6011Lu2.k());
        setTextDirection(3);
    }
}
