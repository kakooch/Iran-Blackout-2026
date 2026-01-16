package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* loaded from: classes.dex */
public final class RH5 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BubbleTextView b;
    public final Switch c;

    private RH5(ConstraintLayout constraintLayout, BubbleTextView bubbleTextView, Switch r3) {
        this.a = constraintLayout;
        this.b = bubbleTextView;
        this.c = r3;
    }

    public static RH5 a(View view) {
        int i = AbstractC15217jC5.reactionTextView;
        BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
        if (bubbleTextView != null) {
            i = AbstractC15217jC5.switchView;
            Switch r2 = (Switch) AbstractC11738dW7.a(view, i);
            if (r2 != null) {
                return new RH5((ConstraintLayout) view, bubbleTextView, r2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static RH5 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(MC5.reaction_settings_reaction_item_holder, viewGroup, false);
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
