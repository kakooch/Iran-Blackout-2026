package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.Tf6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C7796Tf6 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;

    private C7796Tf6(LinearLayout linearLayout, TextView textView) {
        this.a = linearLayout;
        this.b = textView;
    }

    public static C7796Tf6 a(View view) {
        int i = AbstractC12808fC5.no_result_found_tv;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            return new C7796Tf6((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
