package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.CommentContainerView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReactionView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageReplyView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.jf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15481jf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Barrier b;
    public final ViewStub c;
    public final MaterialButton d;
    public final CommentContainerView e;
    public final ConstraintLayout f;
    public final ViewStub g;
    public final MessageReplyView h;
    public final MessageEmojiTextView i;
    public final MessageEmojiTextView j;
    public final MessageReactionView k;
    public final MessageStateView l;
    public final BubbleTextView m;
    public final Barrier n;

    private C15481jf3(ConstraintLayout constraintLayout, Barrier barrier, ViewStub viewStub, MaterialButton materialButton, CommentContainerView commentContainerView, ConstraintLayout constraintLayout2, ViewStub viewStub2, MessageReplyView messageReplyView, MessageEmojiTextView messageEmojiTextView, MessageEmojiTextView messageEmojiTextView2, MessageReactionView messageReactionView, MessageStateView messageStateView, BubbleTextView bubbleTextView, Barrier barrier2) {
        this.a = constraintLayout;
        this.b = barrier;
        this.c = viewStub;
        this.d = materialButton;
        this.e = commentContainerView;
        this.f = constraintLayout2;
        this.g = viewStub2;
        this.h = messageReplyView;
        this.i = messageEmojiTextView;
        this.j = messageEmojiTextView2;
        this.k = messageReactionView;
        this.l = messageStateView;
        this.m = bubbleTextView;
        this.n = barrier2;
    }

    public static C15481jf3 a(View view) {
        int i = BC5.bodyBarrier;
        Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
        if (barrier != null) {
            i = BC5.bottomViewStub;
            ViewStub viewStub = (ViewStub) AbstractC11738dW7.a(view, i);
            if (viewStub != null) {
                i = BC5.buttonJoinAndShow;
                MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                if (materialButton != null) {
                    i = BC5.comment_container;
                    CommentContainerView commentContainerView = (CommentContainerView) AbstractC11738dW7.a(view, i);
                    if (commentContainerView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = BC5.mainViewStub;
                        ViewStub viewStub2 = (ViewStub) AbstractC11738dW7.a(view, i);
                        if (viewStub2 != null) {
                            i = BC5.replyView;
                            MessageReplyView messageReplyView = (MessageReplyView) AbstractC11738dW7.a(view, i);
                            if (messageReplyView != null) {
                                i = BC5.textViewBody;
                                MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                                if (messageEmojiTextView != null) {
                                    i = BC5.textViewForward;
                                    MessageEmojiTextView messageEmojiTextView2 = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                                    if (messageEmojiTextView2 != null) {
                                        i = BC5.textViewReactions;
                                        MessageReactionView messageReactionView = (MessageReactionView) AbstractC11738dW7.a(view, i);
                                        if (messageReactionView != null) {
                                            i = BC5.textViewState;
                                            MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
                                            if (messageStateView != null) {
                                                i = BC5.textViewUsername;
                                                BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                                                if (bubbleTextView != null) {
                                                    i = BC5.viewStubBarrier;
                                                    Barrier barrier2 = (Barrier) AbstractC11738dW7.a(view, i);
                                                    if (barrier2 != null) {
                                                        return new C15481jf3(constraintLayout, barrier, viewStub, materialButton, commentContainerView, constraintLayout, viewStub2, messageReplyView, messageEmojiTextView, messageEmojiTextView2, messageReactionView, messageStateView, bubbleTextView, barrier2);
                                                    }
                                                }
                                            }
                                        }
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

    public static C15481jf3 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C15481jf3 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_chat_text_bubble, viewGroup, false);
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
