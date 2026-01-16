package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.ij1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14929ij1 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;
    public final TextView c;

    private C14929ij1(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.a = linearLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static C14929ij1 a(View view) {
        int i = BC5.btn;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.description;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
            if (textView2 != null) {
                return new C14929ij1((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
