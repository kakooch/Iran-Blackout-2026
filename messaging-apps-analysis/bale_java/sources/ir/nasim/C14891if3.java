package ir.nasim;

import android.view.View;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReplyView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;
import ir.nasim.features.smiles.widget.StickerView;

/* renamed from: ir.nasim.if3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14891if3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final LottieAnimationView b;
    public final Barrier c;
    public final Barrier d;
    public final ConstraintLayout e;
    public final MessageReplyView f;
    public final StickerView g;
    public final MessageEmojiTextView h;
    public final MessageReactionView i;
    public final MessageStateView j;

    private C14891if3(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, Barrier barrier, Barrier barrier2, ConstraintLayout constraintLayout2, MessageReplyView messageReplyView, StickerView stickerView, MessageEmojiTextView messageEmojiTextView, MessageReactionView messageReactionView, MessageStateView messageStateView) {
        this.a = constraintLayout;
        this.b = lottieAnimationView;
        this.c = barrier;
        this.d = barrier2;
        this.e = constraintLayout2;
        this.f = messageReplyView;
        this.g = stickerView;
        this.h = messageEmojiTextView;
        this.i = messageReactionView;
        this.j = messageStateView;
    }

    public static C14891if3 a(View view) {
        int i = BC5.animationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
        if (lottieAnimationView != null) {
            i = BC5.barrier_bottom;
            Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
            if (barrier != null) {
                i = BC5.barrier_end;
                Barrier barrier2 = (Barrier) AbstractC11738dW7.a(view, i);
                if (barrier2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = BC5.replyView;
                    MessageReplyView messageReplyView = (MessageReplyView) AbstractC11738dW7.a(view, i);
                    if (messageReplyView != null) {
                        i = BC5.sticker;
                        StickerView stickerView = (StickerView) AbstractC11738dW7.a(view, i);
                        if (stickerView != null) {
                            i = BC5.textViewForward;
                            MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                            if (messageEmojiTextView != null) {
                                i = BC5.textViewReactions;
                                MessageReactionView messageReactionView = (MessageReactionView) AbstractC11738dW7.a(view, i);
                                if (messageReactionView != null) {
                                    i = BC5.textViewState;
                                    MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
                                    if (messageStateView != null) {
                                        return new C14891if3(constraintLayout, lottieAnimationView, barrier, barrier2, constraintLayout, messageReplyView, stickerView, messageEmojiTextView, messageReactionView, messageStateView);
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
