package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.kf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16072kf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final LinearLayout b;
    public final MessageEmojiTextView c;
    public final MessageStateView d;
    public final AvatarViewGlide e;

    private C16072kf3(ConstraintLayout constraintLayout, LinearLayout linearLayout, MessageEmojiTextView messageEmojiTextView, MessageStateView messageStateView, AvatarViewGlide avatarViewGlide) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = messageEmojiTextView;
        this.d = messageStateView;
        this.e = avatarViewGlide;
    }

    public static C16072kf3 a(View view) {
        int i = BC5.bubbleContainer;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.textViewBody;
            MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
            if (messageEmojiTextView != null) {
                i = BC5.textViewState;
                MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
                if (messageStateView != null) {
                    i = BC5.user_avatar;
                    AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                    if (avatarViewGlide != null) {
                        return new C16072kf3((ConstraintLayout) view, linearLayout, messageEmojiTextView, messageStateView, avatarViewGlide);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C16072kf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_chat_unsupported_message, viewGroup, false);
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
