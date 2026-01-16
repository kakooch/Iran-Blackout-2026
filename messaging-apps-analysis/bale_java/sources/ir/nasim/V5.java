package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes5.dex */
public final class V5 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final ConstraintLayout e;
    public final ImageView f;
    public final LinearLayout g;
    public final View h;
    public final TextView i;
    public final Toolbar j;
    public final TextView k;

    private V5(ConstraintLayout constraintLayout, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, ImageView imageView, LinearLayout linearLayout, View view, TextView textView2, Toolbar toolbar, TextView textView3) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = frameLayout;
        this.d = frameLayout2;
        this.e = constraintLayout2;
        this.f = imageView;
        this.g = linearLayout;
        this.h = view;
        this.i = textView2;
        this.j = toolbar;
        this.k = textView3;
    }

    public static V5 a(View view) {
        View viewA;
        int i = BC5.close;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.content_frame;
            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
            if (frameLayout != null) {
                i = BC5.fragment_container;
                FrameLayout frameLayout2 = (FrameLayout) AbstractC11738dW7.a(view, i);
                if (frameLayout2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = BC5.img_support;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = BC5.linear_support;
                        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                        if (linearLayout != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.statusBar_background))) != null) {
                            i = BC5.titleTxt;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.toolbar;
                                Toolbar toolbar = (Toolbar) AbstractC11738dW7.a(view, i);
                                if (toolbar != null) {
                                    i = BC5.txt_support;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        return new V5(constraintLayout, textView, frameLayout, frameLayout2, constraintLayout, imageView, linearLayout, viewA, textView2, toolbar, textView3);
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

    public static V5 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static V5 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.activity_card_payment, viewGroup, false);
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
