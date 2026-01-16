package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.Wf3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C8497Wf3 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final TextView c;

    private C8497Wf3(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = textView;
    }

    public static C8497Wf3 a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i = AbstractC14017hC5.title;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new C8497Wf3(linearLayout, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C8497Wf3 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(JC5.item_search_result_show_all, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
