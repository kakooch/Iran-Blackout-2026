package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes5.dex */
public final class NA2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final C18523oo0 d;
    public final TextView e;

    private NA2(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, C18523oo0 c18523oo0, TextView textView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = imageView;
        this.d = c18523oo0;
        this.e = textView;
    }

    public static NA2 a(View view) {
        View viewA;
        LinearLayout linearLayout = (LinearLayout) view;
        int i = BC5.icon;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.progressBar_cnt))) != null) {
            C18523oo0 c18523oo0A = C18523oo0.a(viewA);
            i = BC5.textView;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                return new NA2(linearLayout, linearLayout, imageView, c18523oo0A, textView);
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
