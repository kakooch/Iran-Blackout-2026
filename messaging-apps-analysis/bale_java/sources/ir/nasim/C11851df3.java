package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;

/* renamed from: ir.nasim.df3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11851df3 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final ViewStub b;
    public final BubbleTextView c;
    public final Guideline d;
    public final BubbleTextView e;

    private C11851df3(ConstraintLayout constraintLayout, ViewStub viewStub, BubbleTextView bubbleTextView, Guideline guideline, BubbleTextView bubbleTextView2) {
        this.a = constraintLayout;
        this.b = viewStub;
        this.c = bubbleTextView;
        this.d = guideline;
        this.e = bubbleTextView2;
    }

    public static C11851df3 a(View view) {
        int i = BC5.bubbleStub;
        ViewStub viewStub = (ViewStub) AbstractC11738dW7.a(view, i);
        if (viewStub != null) {
            i = BC5.date_separator;
            BubbleTextView bubbleTextView = (BubbleTextView) AbstractC11738dW7.a(view, i);
            if (bubbleTextView != null) {
                i = BC5.guideline;
                Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                if (guideline != null) {
                    i = BC5.new_message_separator;
                    BubbleTextView bubbleTextView2 = (BubbleTextView) AbstractC11738dW7.a(view, i);
                    if (bubbleTextView2 != null) {
                        return new C11851df3((ConstraintLayout) view, viewStub, bubbleTextView, guideline, bubbleTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C11851df3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.item_chat_outgoing_message, viewGroup, false);
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
