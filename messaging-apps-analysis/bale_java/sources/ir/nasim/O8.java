package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes5.dex */
public final class O8 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final TextView d;
    public final View e;
    public final ImageView f;
    public final ImageView g;
    public final TextView h;

    private O8(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, View view, ImageView imageView, ImageView imageView2, TextView textView2) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = linearLayout3;
        this.d = textView;
        this.e = view;
        this.f = imageView;
        this.g = imageView2;
        this.h = textView2;
    }

    public static O8 a(View view) {
        View viewA;
        int i = BC5.add_description_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.delete_transaction_container;
            LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout2 != null) {
                i = BC5.description_menu;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider_2))) != null) {
                    i = BC5.imageView_add_description;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = BC5.img_delete_transaction;
                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView2 != null) {
                            i = BC5.txt_deleteTransaction;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                return new O8((LinearLayout) view, linearLayout, linearLayout2, textView, viewA, imageView, imageView2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static O8 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static O8 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.add_description_dialog, viewGroup, false);
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
