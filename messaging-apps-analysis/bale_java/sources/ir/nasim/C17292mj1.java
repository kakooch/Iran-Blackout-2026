package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.mj1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17292mj1 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;

    private C17292mj1(LinearLayout linearLayout, TextView textView) {
        this.a = linearLayout;
        this.b = textView;
    }

    public static C17292mj1 a(View view) {
        int i = AbstractC10176bC5.title;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new C17292mj1((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
