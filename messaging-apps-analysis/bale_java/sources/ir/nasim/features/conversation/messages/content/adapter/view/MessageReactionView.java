package ir.nasim.features.conversation.messages.content.adapter.view;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.AttributeSet;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.C20610sI7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.FU;
import ir.nasim.LG5;
import ir.nasim.UA2;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lir/nasim/features/conversation/messages/content/adapter/view/MessageReactionView;", "Lir/nasim/features/conversation/messages/content/adapter/view/BubbleTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/text/Spannable;", "spannable", "Lir/nasim/rB7;", "r", "(Landroid/text/Spannable;)V", "Lir/nasim/FU;", "h", "Lir/nasim/FU;", "avatarDownloader", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class MessageReactionView extends BubbleTextView {

    /* renamed from: h, reason: from kotlin metadata */
    private final FU avatarDownloader;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageReactionView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(LG5 lg5, int i, MessageReactionView messageReactionView, Drawable drawable) {
        AbstractC13042fc3.i(lg5, "$reactionAvatarSpan");
        AbstractC13042fc3.i(messageReactionView, "this$0");
        AbstractC13042fc3.i(drawable, "resource");
        lg5.E().set(i, drawable);
        messageReactionView.invalidate();
        return C19938rB7.a;
    }

    @Override // ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView
    public void r(Spannable spannable) {
        LG5[] lg5Arr;
        super.r(spannable);
        if (spannable != null && (lg5Arr = (LG5[]) spannable.getSpans(0, spannable.length(), LG5.class)) != null) {
            for (final LG5 lg5 : lg5Arr) {
                final int i = 0;
                for (Object obj : lg5.C()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        AbstractC10360bX0.w();
                    }
                    FU.g(this.avatarDownloader, (C20610sI7) obj, lg5.B(), null, new UA2() { // from class: ir.nasim.m74
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return MessageReactionView.t(lg5, i, this, (Drawable) obj2);
                        }
                    }, 4, null);
                    i = i2;
                }
            }
        }
        setImportantForAccessibility(4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageReactionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ MessageReactionView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.textViewStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageReactionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.avatarDownloader = new FU(context);
        if (isInEditMode()) {
            return;
        }
        setTextSize(1, 14.0f);
        setTypeface(C6011Lu2.k());
        setLineSpacing(0.0f, 1.0f);
        setIncludeFontPadding(false);
    }
}
