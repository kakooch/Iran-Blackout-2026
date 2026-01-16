package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.Ve3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8254Ve3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BubbleTextView b;
    public final MaterialButton c;
    public final View d;
    public final View e;
    public final LinearLayout f;
    public final LinearProgressIndicator g;
    public final BubbleTextView h;
    public final BubbleTextView i;

    private C8254Ve3(ConstraintLayout constraintLayout, BubbleTextView bubbleTextView, MaterialButton materialButton, View view, View view2, LinearLayout linearLayout, LinearProgressIndicator linearProgressIndicator, BubbleTextView bubbleTextView2, BubbleTextView bubbleTextView3) {
        this.a = constraintLayout;
        this.b = bubbleTextView;
        this.c = materialButton;
        this.d = view;
        this.e = view2;
        this.f = linearLayout;
        this.g = linearProgressIndicator;
        this.h = bubbleTextView2;
        this.i = bubbleTextView3;
    }

    public static C8254Ve3 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.crowdFundingAmountDetails;
        BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
        if (bubbleTextView != null) {
            i = BC5.crowdFundingDetailsButton;
            MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.crowdFundingDividerAmount))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.crowdFundingDividerProgress))) != null) {
                i = BC5.crowdFundingLinearLayout;
                LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout != null) {
                    i = BC5.crowdFundingProgressBar;
                    LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) AbstractC11738dW7.a(view, i);
                    if (linearProgressIndicator != null) {
                        i = BC5.crowdFundingProgressDetails;
                        BubbleTextView bubbleTextView2 = (BubbleTextView) AbstractC11738dW7.a(view, i);
                        if (bubbleTextView2 != null) {
                            i = BC5.crowdFundingRemainingDetails;
                            BubbleTextView bubbleTextView3 = (BubbleTextView) AbstractC11738dW7.a(view, i);
                            if (bubbleTextView3 != null) {
                                return new C8254Ve3((ConstraintLayout) view, bubbleTextView, materialButton, viewA, viewA2, linearLayout, linearProgressIndicator, bubbleTextView2, bubbleTextView3);
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
