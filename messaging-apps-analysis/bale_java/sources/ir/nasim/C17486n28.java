package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.n28, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17486n28 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final TextView b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final ConstraintLayout k;
    public final ImageView l;
    public final ImageView m;
    public final TextView n;
    public final TextView o;

    private C17486n28(ConstraintLayout constraintLayout, TextView textView, View view, View view2, View view3, View view4, View view5, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView5, TextView textView6) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = view;
        this.d = view2;
        this.e = view3;
        this.f = view4;
        this.g = view5;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = constraintLayout2;
        this.l = imageView;
        this.m = imageView2;
        this.n = textView5;
        this.o = textView6;
    }

    public static C17486n28 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        int i = BC5.auto_wallet_charge;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider1))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.divider2))) != null && (viewA3 = AbstractC11738dW7.a(view, (i = BC5.divider3))) != null && (viewA4 = AbstractC11738dW7.a(view, (i = BC5.divider4))) != null && (viewA5 = AbstractC11738dW7.a(view, (i = BC5.divider5))) != null) {
            i = BC5.wallet_balance_refresh;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
            if (textView2 != null) {
                i = BC5.wallet_cashout;
                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView3 != null) {
                    i = BC5.wallet_charge;
                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView4 != null) {
                        i = BC5.wallet_more_options_header;
                        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout != null) {
                            i = BC5.wallet_more_options_header_image;
                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView != null) {
                                i = BC5.wallet_more_options_info_btn;
                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView2 != null) {
                                    i = BC5.wallet_transactions;
                                    TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView5 != null) {
                                        i = BC5.wallet_transfer;
                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView6 != null) {
                                            return new C17486n28((ConstraintLayout) view, textView, viewA, viewA2, viewA3, viewA4, viewA5, textView2, textView3, textView4, constraintLayout, imageView, imageView2, textView5, textView6);
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

    public static C17486n28 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.wallet_more_options_layout, viewGroup, false);
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
