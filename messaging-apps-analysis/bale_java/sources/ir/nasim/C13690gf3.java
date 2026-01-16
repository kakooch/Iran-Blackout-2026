package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.MessageStateView;

/* renamed from: ir.nasim.gf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13690gf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BubbleTextView b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final MessageStateView e;
    public final MaterialButton f;

    private C13690gf3(ConstraintLayout constraintLayout, BubbleTextView bubbleTextView, ConstraintLayout constraintLayout2, ImageView imageView, MessageStateView messageStateView, MaterialButton materialButton) {
        this.a = constraintLayout;
        this.b = bubbleTextView;
        this.c = constraintLayout2;
        this.d = imageView;
        this.e = messageStateView;
        this.f = materialButton;
    }

    public static C13690gf3 a(View view) {
        int i = BC5.descriptionText;
        BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
        if (bubbleTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = BC5.protectedIcon;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.textViewState;
                MessageStateView messageStateView = (MessageStateView) AbstractC11738dW7.a(view, i);
                if (messageStateView != null) {
                    i = BC5.unlockBtn;
                    MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
                    if (materialButton != null) {
                        return new C13690gf3(constraintLayout, bubbleTextView, constraintLayout, imageView, messageStateView, materialButton);
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
