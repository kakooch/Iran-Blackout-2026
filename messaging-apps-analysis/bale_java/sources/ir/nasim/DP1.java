package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

/* loaded from: classes5.dex */
public final class DP1 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final Guideline b;
    public final TextView c;
    public final TextView d;

    private DP1(ConstraintLayout constraintLayout, Guideline guideline, TextView textView, TextView textView2) {
        this.a = constraintLayout;
        this.b = guideline;
        this.c = textView;
        this.d = textView2;
    }

    public static DP1 a(View view) {
        int i = BC5.guideline;
        Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
        if (guideline != null) {
            i = BC5.tv_dialog_tab_title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.tv_unread_messages_counter;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    return new DP1((ConstraintLayout) view, guideline, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static DP1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.dialog_tab_type_item, viewGroup, false);
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
