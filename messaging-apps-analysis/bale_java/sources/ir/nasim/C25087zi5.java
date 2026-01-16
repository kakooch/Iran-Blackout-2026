package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.zi5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C25087zi5 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final TextView b;
    public final ConstraintLayout c;
    public final TextView d;
    public final ImageView e;

    private C25087zi5(LinearLayout linearLayout, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView) {
        this.a = linearLayout;
        this.b = textView;
        this.c = constraintLayout;
        this.d = textView2;
        this.e = imageView;
    }

    public static C25087zi5 a(View view) {
        int i = AbstractC12808fC5.title;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = AbstractC12808fC5.title_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = AbstractC12808fC5.title_tv;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = AbstractC12808fC5.trend_img;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        return new C25087zi5((LinearLayout) view, textView, constraintLayout, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C25087zi5 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(HC5.popular_search_suggestion_item, viewGroup, false);
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
