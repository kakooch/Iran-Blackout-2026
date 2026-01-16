package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.Xe3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8754Xe3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final Barrier c;
    public final ImageView d;
    public final MessageEmojiTextView e;
    public final BubbleTextView f;

    private C8754Xe3(ConstraintLayout constraintLayout, View view, Barrier barrier, ImageView imageView, MessageEmojiTextView messageEmojiTextView, BubbleTextView bubbleTextView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = barrier;
        this.d = imageView;
        this.e = messageEmojiTextView;
        this.f = bubbleTextView;
    }

    public static C8754Xe3 a(View view) {
        int i = BC5.giftPacketDivider;
        View viewA = AbstractC11738dW7.a(view, i);
        if (viewA != null) {
            i = BC5.giftPacketDividerBarrier;
            Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
            if (barrier != null) {
                i = BC5.giftPacketImageView;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.giftPacketSenderNameTextview;
                    MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                    if (messageEmojiTextView != null) {
                        i = BC5.giftPacketTitleTextview;
                        BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                        if (bubbleTextView != null) {
                            return new C8754Xe3((ConstraintLayout) view, viewA, barrier, imageView, messageEmojiTextView, bubbleTextView);
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
