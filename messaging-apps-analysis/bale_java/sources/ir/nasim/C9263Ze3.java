package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import ir.nasim.designsystem.ImageViewCrossFade;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.DocumentStateButton;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.Ze3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9263Ze3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final DocumentStateButton b;
    public final ImageViewCrossFade c;
    public final AppCompatImageView d;
    public final MaterialCheckBox e;
    public final MessageStateView f;
    public final BubbleTextView g;

    private C9263Ze3(ConstraintLayout constraintLayout, DocumentStateButton documentStateButton, ImageViewCrossFade imageViewCrossFade, AppCompatImageView appCompatImageView, MaterialCheckBox materialCheckBox, MessageStateView messageStateView, BubbleTextView bubbleTextView) {
        this.a = constraintLayout;
        this.b = documentStateButton;
        this.c = imageViewCrossFade;
        this.d = appCompatImageView;
        this.e = materialCheckBox;
        this.f = messageStateView;
        this.g = bubbleTextView;
    }

    public static C9263Ze3 a(View view) {
        int i = BC5.document_state_button;
        DocumentStateButton documentStateButton = (DocumentStateButton) AbstractC11738dW7.a(view, i);
        if (documentStateButton != null) {
            i = BC5.imageView;
            ImageViewCrossFade imageViewCrossFade = (ImageViewCrossFade) AbstractC11738dW7.a(view, i);
            if (imageViewCrossFade != null) {
                i = BC5.imageViewVolumeState;
                AppCompatImageView appCompatImageView = (AppCompatImageView) AbstractC11738dW7.a(view, i);
                if (appCompatImageView != null) {
                    i = BC5.selectionCheckBox;
                    MaterialCheckBox materialCheckBox = (MaterialCheckBox) AbstractC11738dW7.a(view, i);
                    if (materialCheckBox != null) {
                        i = BC5.stateView;
                        MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
                        if (messageStateView != null) {
                            i = BC5.textViewProgress;
                            BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                            if (bubbleTextView != null) {
                                return new C9263Ze3((ConstraintLayout) view, documentStateButton, imageViewCrossFade, appCompatImageView, materialCheckBox, messageStateView, bubbleTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C9263Ze3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_chat_image_bubble, viewGroup, false);
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
