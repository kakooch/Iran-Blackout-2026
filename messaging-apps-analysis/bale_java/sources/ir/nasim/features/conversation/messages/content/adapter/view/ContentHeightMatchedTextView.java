package ir.nasim.features.conversation.messages.content.adapter.view;

import android.R;
import android.content.Context;
import android.text.Spannable;
import android.text.TextPaint;
import android.util.AttributeSet;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C4292Em7;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/ContentHeightMatchedTextView;", "Lir/nasim/features/conversation/messages/content/adapter/view/BubbleTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/text/Spannable;", "s", "(Landroid/text/Spannable;)Landroid/text/Spannable;", "spannable", "Lir/nasim/rB7;", "r", "(Landroid/text/Spannable;)V", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class ContentHeightMatchedTextView extends BubbleTextView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentHeightMatchedTextView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final Spannable s(Spannable spannable) {
        TextPaint paint = getPaint();
        AbstractC13042fc3.h(paint, "getPaint(...)");
        spannable.setSpan(new C4292Em7(paint), 0, spannable.length(), 33);
        return spannable;
    }

    @Override // ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView
    public void r(Spannable spannable) {
        super.r(spannable != null ? s(spannable) : null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentHeightMatchedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ ContentHeightMatchedTextView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentHeightMatchedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
    }
}
