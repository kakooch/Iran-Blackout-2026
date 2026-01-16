package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.iT3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C14779iT3 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ImageView b;
    public final LinearLayout c;
    public final TextView d;

    private C14779iT3(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView) {
        this.a = linearLayout;
        this.b = imageView;
        this.c = linearLayout2;
        this.d = textView;
    }

    public static C14779iT3 a(View view) {
        int i = AbstractC14017hC5.line;
        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = AbstractC14017hC5.title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i2);
            if (textView != null) {
                return new C14779iT3(linearLayout, imageView, linearLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
