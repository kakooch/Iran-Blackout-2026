package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Iz5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5358Iz5 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final LinearLayout b;
    public final ImageView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final ImageView f;
    public final View g;
    public final ConstraintLayout h;
    public final TextView i;
    public final ProgressBar j;
    public final ConstraintLayout k;
    public final TextView l;
    public final TextView m;

    private C5358Iz5(ConstraintLayout constraintLayout, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ImageView imageView3, View view, ConstraintLayout constraintLayout3, TextView textView, ProgressBar progressBar, ConstraintLayout constraintLayout4, TextView textView2, TextView textView3) {
        this.a = constraintLayout;
        this.b = linearLayout;
        this.c = imageView;
        this.d = imageView2;
        this.e = constraintLayout2;
        this.f = imageView3;
        this.g = view;
        this.h = constraintLayout3;
        this.i = textView;
        this.j = progressBar;
        this.k = constraintLayout4;
        this.l = textView2;
        this.m = textView3;
    }

    public static C5358Iz5 a(View view) {
        View viewA;
        int i = BC5.button_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.charge_icon;
            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
            if (imageView != null) {
                i = BC5.close_quick_charge;
                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = BC5.direct_debit_logo;
                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView3 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                        i = BC5.new_charge_button;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                        if (constraintLayout2 != null) {
                            i = BC5.new_charge_text_view;
                            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView != null) {
                                i = BC5.progress_bar;
                                ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                                if (progressBar != null) {
                                    i = BC5.quick_charge_header;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                    if (constraintLayout3 != null) {
                                        i = BC5.quick_charge_label;
                                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView2 != null) {
                                            i = BC5.quick_charge_title;
                                            TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView3 != null) {
                                                return new C5358Iz5(constraintLayout, linearLayout, imageView, imageView2, constraintLayout, imageView3, viewA, constraintLayout2, textView, progressBar, constraintLayout3, textView2, textView3);
                                            }
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

    public static C5358Iz5 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.quick_charge_bottom_sheet_layout, viewGroup, false);
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
