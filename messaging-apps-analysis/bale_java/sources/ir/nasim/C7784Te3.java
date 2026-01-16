package ir.nasim;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.Te3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7784Te3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final BubbleTextView c;
    public final MessageStateView d;
    public final MessageEmojiTextView e;

    private C7784Te3(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, BubbleTextView bubbleTextView, MessageStateView messageStateView, MessageEmojiTextView messageEmojiTextView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = bubbleTextView;
        this.d = messageStateView;
        this.e = messageEmojiTextView;
    }

    public static C7784Te3 a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = BC5.textview_call_bubble_duration;
        BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
        if (bubbleTextView != null) {
            i = BC5.textview_call_bubble_state;
            MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
            if (messageStateView != null) {
                i = BC5.textview_call_bubble_title;
                MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                if (messageEmojiTextView != null) {
                    return new C7784Te3(constraintLayout, constraintLayout, bubbleTextView, messageStateView, messageEmojiTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
