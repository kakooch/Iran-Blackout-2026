package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageEmojiTextView;

/* renamed from: ir.nasim.We3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8488We3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Barrier b;
    public final DocumentStateButton c;
    public final BubbleTextView d;
    public final MessageEmojiTextView e;
    public final ShapeableImageView f;
    public final ImageView g;

    private C8488We3(ConstraintLayout constraintLayout, Barrier barrier, DocumentStateButton documentStateButton, BubbleTextView bubbleTextView, MessageEmojiTextView messageEmojiTextView, ShapeableImageView shapeableImageView, ImageView imageView) {
        this.a = constraintLayout;
        this.b = barrier;
        this.c = documentStateButton;
        this.d = bubbleTextView;
        this.e = messageEmojiTextView;
        this.f = shapeableImageView;
        this.g = imageView;
    }

    public static C8488We3 a(View view) {
        int i = BC5.barrier2;
        Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
        if (barrier != null) {
            i = BC5.document_state_button;
            DocumentStateButton documentStateButton = (DocumentStateButton) AbstractC11738dW7.a(view, i);
            if (documentStateButton != null) {
                i = BC5.file_details;
                BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                if (bubbleTextView != null) {
                    i = BC5.file_name;
                    MessageEmojiTextView messageEmojiTextView = (MessageEmojiTextView) AbstractC11738dW7.a(view, i);
                    if (messageEmojiTextView != null) {
                        i = BC5.imageViewFile;
                        ShapeableImageView shapeableImageView = (ShapeableImageView) AbstractC11738dW7.a(view, i);
                        if (shapeableImageView != null) {
                            i = BC5.more_options;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                return new C8488We3((ConstraintLayout) view, barrier, documentStateButton, bubbleTextView, messageEmojiTextView, shapeableImageView, imageView);
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
