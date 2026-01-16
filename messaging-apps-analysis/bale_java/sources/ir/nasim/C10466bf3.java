package ir.nasim;

import android.view.View;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReplyView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.bf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10466bf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Barrier b;
    public final ShapeableImageView c;
    public final ConstraintLayout d;
    public final MessageReplyView e;
    public final ShimmerFrameLayout f;
    public final MessageStateView g;
    public final MessageEmojiTextView h;
    public final MessageReactionView i;
    public final BubbleTextView j;

    private C10466bf3(ConstraintLayout constraintLayout, Barrier barrier, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout2, MessageReplyView messageReplyView, ShimmerFrameLayout shimmerFrameLayout, MessageStateView messageStateView, MessageEmojiTextView messageEmojiTextView, MessageReactionView messageReactionView, BubbleTextView bubbleTextView) {
        this.a = constraintLayout;
        this.b = barrier;
        this.c = shapeableImageView;
        this.d = constraintLayout2;
        this.e = messageReplyView;
        this.f = shimmerFrameLayout;
        this.g = messageStateView;
        this.h = messageEmojiTextView;
        this.i = messageReactionView;
        this.j = bubbleTextView;
    }

    public static C10466bf3 a(View view) {
        int i = BC5.barrierQuotedMessage;
        Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
        if (barrier != null) {
            i = BC5.imageViewLocation;
            ShapeableImageView shapeableImageView = (ShapeableImageView) AbstractC11738dW7.a(view, i);
            if (shapeableImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = BC5.replyView;
                MessageReplyView messageReplyView = (MessageReplyView) AbstractC11738dW7.a(view, i);
                if (messageReplyView != null) {
                    i = BC5.shimmerLayout;
                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) AbstractC11738dW7.a(view, i);
                    if (shimmerFrameLayout != null) {
                        i = BC5.stateView;
                        MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
                        if (messageStateView != null) {
                            i = BC5.textViewForward;
                            MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                            if (messageEmojiTextView != null) {
                                i = BC5.textViewReactions;
                                MessageReactionView messageReactionView = (MessageReactionView) AbstractC11738dW7.a(view, i);
                                if (messageReactionView != null) {
                                    i = BC5.textViewUsername;
                                    BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                                    if (bubbleTextView != null) {
                                        return new C10466bf3(constraintLayout, barrier, shapeableImageView, constraintLayout, messageReplyView, shimmerFrameLayout, messageStateView, messageEmojiTextView, messageReactionView, bubbleTextView);
                                    }
                                }
                            }
                        }
                    }
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
