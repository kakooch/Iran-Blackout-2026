package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* renamed from: ir.nasim.q32, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19263q32 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;
    public final LinearLayout c;
    public final LinearLayout d;
    public final View e;
    public final LinearLayout f;
    public final TextView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final TextView k;

    private C19263q32(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, LinearLayout linearLayout3, View view, LinearLayout linearLayout4, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView3) {
        this.a = linearLayout;
        this.b = textView;
        this.c = linearLayout2;
        this.d = linearLayout3;
        this.e = view;
        this.f = linearLayout4;
        this.g = textView2;
        this.h = imageView;
        this.i = imageView2;
        this.j = imageView3;
        this.k = textView3;
    }

    public static C19263q32 a(View view) {
        View viewA;
        int i = BC5.delete_description;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.delete_description_container;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                i = BC5.delete_transaction_container;
                LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout2 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.devider_2))) != null) {
                    i = BC5.edit_container;
                    LinearLayout linearLayout3 = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout3 != null) {
                        i = BC5.edit_description;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = BC5.imageView_edit_description;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                i = BC5.img_delete_description;
                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView2 != null) {
                                    i = BC5.img_delete_transaction;
                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView3 != null) {
                                        i = BC5.txt_deleteTransaction;
                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView3 != null) {
                                            return new C19263q32((LinearLayout) view, textView, linearLayout, linearLayout2, viewA, linearLayout3, textView2, imageView, imageView2, imageView3, textView3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C19263q32 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C19263q32 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.edit_description_dialog, viewGroup, false);
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
