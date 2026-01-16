package ir.nasim;

import android.view.View;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.cf3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11056cf3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialButton b;
    public final Barrier c;
    public final BubbleTextView d;
    public final BubbleTextView e;
    public final View f;
    public final MaterialButton g;

    private C11056cf3(ConstraintLayout constraintLayout, MaterialButton materialButton, Barrier barrier, BubbleTextView bubbleTextView, BubbleTextView bubbleTextView2, View view, MaterialButton materialButton2) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = barrier;
        this.d = bubbleTextView;
        this.e = bubbleTextView2;
        this.f = view;
        this.g = materialButton2;
    }

    public static C11056cf3 a(View view) {
        View viewA;
        int i = BC5.details_button;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.divider_barrier;
            Barrier barrier = (Barrier) AbstractC11738dW7.a(view, i);
            if (barrier != null) {
                i = BC5.money_amount_prefix_textView;
                BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
                if (bubbleTextView != null) {
                    i = BC5.money_amount_textView;
                    BubbleTextView bubbleTextView2 = (BubbleTextView) AbstractC11738dW7.a(view, i);
                    if (bubbleTextView2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.moneyRequestDivider))) != null) {
                        i = BC5.pay_button;
                        MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
                        if (materialButton2 != null) {
                            return new C11056cf3((ConstraintLayout) view, materialButton, barrier, bubbleTextView, bubbleTextView2, viewA, materialButton2);
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
