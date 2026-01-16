package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ir.nasim.Ei4, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4253Ei4 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final CardView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final TextView f;
    public final TextView g;
    public final ImageView h;
    public final TextView i;
    public final ConstraintLayout j;
    public final TextView k;
    public final CardView l;
    public final ImageView m;
    public final ConstraintLayout n;
    public final TextView o;
    public final O50 p;

    private C4253Ei4(ConstraintLayout constraintLayout, View view, CardView cardView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, ConstraintLayout constraintLayout3, TextView textView4, CardView cardView2, ImageView imageView3, ConstraintLayout constraintLayout4, TextView textView5, O50 o50) {
        this.a = constraintLayout;
        this.b = view;
        this.c = cardView;
        this.d = imageView;
        this.e = constraintLayout2;
        this.f = textView;
        this.g = textView2;
        this.h = imageView2;
        this.i = textView3;
        this.j = constraintLayout3;
        this.k = textView4;
        this.l = cardView2;
        this.m = imageView3;
        this.n = constraintLayout4;
        this.o = textView5;
        this.p = o50;
    }

    public static C4253Ei4 a(View view) {
        View viewA;
        int i = BC5.c6;
        View viewA2 = AbstractC11738dW7.a(view, i);
        if (viewA2 != null) {
            i = BC5.money_request_pay_type_card;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = BC5.money_request_pay_type_card_icon;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.money_request_pay_type_card_inside;
                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout != null) {
                        i = BC5.money_request_pay_type_card_title;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = BC5.money_request_pay_type_choose;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.money_request_pay_type_close_btn;
                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView2 != null) {
                                    i = BC5.money_request_pay_type_desc;
                                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView3 != null) {
                                        i = BC5.money_request_pay_type_header;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                        if (constraintLayout2 != null) {
                                            i = BC5.money_request_pay_type_title;
                                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView4 != null) {
                                                i = BC5.money_request_pay_type_wallet;
                                                CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                                if (cardView2 != null) {
                                                    i = BC5.money_request_pay_type_wallet_icon;
                                                    ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                    if (imageView3 != null) {
                                                        i = BC5.money_request_pay_type_wallet_inside;
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                        if (constraintLayout3 != null) {
                                                            i = BC5.money_request_pay_type_wallet_title;
                                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView5 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.progress_bar_view))) != null) {
                                                                return new C4253Ei4((ConstraintLayout) view, viewA2, cardView, imageView, constraintLayout, textView, textView2, imageView2, textView3, constraintLayout2, textView4, cardView2, imageView3, constraintLayout3, textView5, O50.a(viewA));
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C4253Ei4 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.money_request_pay_type_layout, viewGroup, false);
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
