package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Barrier;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.p74, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18714p74 implements InterfaceC9764aW7 {
    private final View a;
    public final Barrier b;
    public final ImageView c;
    public final View d;
    public final ShapeableImageView e;
    public final MessageEmojiTextView f;
    public final MessageEmojiTextView g;

    private C18714p74(View view, Barrier barrier, ImageView imageView, View view2, ShapeableImageView shapeableImageView, MessageEmojiTextView messageEmojiTextView, MessageEmojiTextView messageEmojiTextView2) {
        this.a = view;
        this.b = barrier;
        this.c = imageView;
        this.d = view2;
        this.e = shapeableImageView;
        this.f = messageEmojiTextView;
        this.g = messageEmojiTextView2;
    }

    public static C18714p74 a(View view) {
        View viewA;
        int i = BC5.barrier;
        Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
        if (barrier != null) {
            i = BC5.fileImageView;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.line))) != null) {
                i = BC5.mediaImageView;
                ShapeableImageView shapeableImageView = (ShapeableImageView) AbstractC11738dW7.a(view, i);
                if (shapeableImageView != null) {
                    i = BC5.textViewReplyBody;
                    MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                    if (messageEmojiTextView != null) {
                        i = BC5.textViewReplyUserName;
                        MessageEmojiTextView messageEmojiTextView2 = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                        if (messageEmojiTextView2 != null) {
                            return new C18714p74(view, barrier, imageView, viewA, shapeableImageView, messageEmojiTextView, messageEmojiTextView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    public View getRoot() {
        return this.a;
    }
}
