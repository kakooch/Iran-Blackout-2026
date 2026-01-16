package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.hf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14281hf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ViewStub b;
    public final BubbleTextView c;
    public final BubbleTextView d;
    public final ViewStub e;
    public final MessageEmojiTextView f;

    private C14281hf3(ConstraintLayout constraintLayout, ViewStub viewStub, BubbleTextView bubbleTextView, BubbleTextView bubbleTextView2, ViewStub viewStub2, MessageEmojiTextView messageEmojiTextView) {
        this.a = constraintLayout;
        this.b = viewStub;
        this.c = bubbleTextView;
        this.d = bubbleTextView2;
        this.e = viewStub2;
        this.f = messageEmojiTextView;
    }

    public static C14281hf3 a(View view) {
        int i = BC5.anonymousContactViewStub;
        ViewStub viewStub = (ViewStub) AbstractC11738dW7.a(view, i);
        if (viewStub != null) {
            i = BC5.date_separator;
            BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
            if (bubbleTextView != null) {
                i = BC5.new_messages_separator;
                BubbleTextView bubbleTextView2 = (BubbleTextView) AbstractC11738dW7.a(view, i);
                if (bubbleTextView2 != null) {
                    i = BC5.suggestedChannelsLayoutViewStub;
                    ViewStub viewStub2 = (ViewStub) AbstractC11738dW7.a(view, i);
                    if (viewStub2 != null) {
                        i = BC5.textViewBody;
                        MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                        if (messageEmojiTextView != null) {
                            return new C14281hf3((ConstraintLayout) view, viewStub, bubbleTextView, bubbleTextView2, viewStub2, messageEmojiTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C14281hf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_chat_service_message, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
