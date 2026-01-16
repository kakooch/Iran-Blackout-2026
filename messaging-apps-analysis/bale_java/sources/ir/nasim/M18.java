package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.bank.BankiMoneyAmountView;

/* loaded from: classes5.dex */
public final class M18 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final View b;
    public final ConstraintLayout c;
    public final BaleButton d;
    public final O50 e;
    public final ScrollView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final BankiMoneyAmountView k;
    public final TextView l;
    public final TextView m;
    public final CardView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final ConstraintLayout u;
    public final View v;
    public final View w;

    private M18(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, BaleButton baleButton, O50 o50, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, BankiMoneyAmountView bankiMoneyAmountView, TextView textView5, TextView textView6, CardView cardView, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, ConstraintLayout constraintLayout3, View view2, View view3) {
        this.a = constraintLayout;
        this.b = view;
        this.c = constraintLayout2;
        this.d = baleButton;
        this.e = o50;
        this.f = scrollView;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = textView4;
        this.k = bankiMoneyAmountView;
        this.l = textView5;
        this.m = textView6;
        this.n = cardView;
        this.o = textView7;
        this.p = textView8;
        this.q = textView9;
        this.r = textView10;
        this.s = textView11;
        this.t = textView12;
        this.u = constraintLayout3;
        this.v = view2;
        this.w = view3;
    }

    public static M18 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i = BC5.c6;
        View viewA4 = AbstractC11738dW7.a(view, i);
        if (viewA4 != null) {
            i = BC5.container;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null) {
                i = BC5.ok_button;
                BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
                if (baleButton != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.progress_bar_view))) != null) {
                    O50 o50A = O50.a(viewA);
                    i = BC5.scroll_view;
                    ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                    if (scrollView != null) {
                        i = BC5.wallet_balance_amount;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = BC5.wallet_balance_persian_amount;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.wallet_balance_rials;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = BC5.wallet_balance_title;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        i = BC5.wallet_charge_amount;
                                        BankiMoneyAmountView bankiMoneyAmountView = (BankiMoneyAmountView) AbstractC11738dW7.a(view, i);
                                        if (bankiMoneyAmountView != null) {
                                            i = BC5.wallet_charge_bottomsheet_close;
                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView5 != null) {
                                                i = BC5.wallet_charge_bottomsheet_title;
                                                TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView6 != null) {
                                                    i = BC5.wallet_charge_fixed_amount;
                                                    CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                                    if (cardView != null) {
                                                        i = BC5.wallet_charge_fixed_amount_100000;
                                                        TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView7 != null) {
                                                            i = BC5.wallet_charge_fixed_amount_20000;
                                                            TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView8 != null) {
                                                                i = BC5.wallet_charge_fixed_amount_200000;
                                                                TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView9 != null) {
                                                                    i = BC5.wallet_charge_fixed_amount_50000;
                                                                    TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView10 != null) {
                                                                        i = BC5.wallet_charge_guid_description;
                                                                        TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView11 != null) {
                                                                            i = BC5.wallet_charge_guid_title;
                                                                            TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView12 != null) {
                                                                                i = BC5.wallet_charge_header;
                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                if (constraintLayout2 != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.wallet_charge_header_shadow))) != null && (viewA3 = AbstractC11738dW7.a(view, (i = BC5.wallet_charge_ok_button_shadow))) != null) {
                                                                                    return new M18((ConstraintLayout) view, viewA4, constraintLayout, baleButton, o50A, scrollView, textView, textView2, textView3, textView4, bankiMoneyAmountView, textView5, textView6, cardView, textView7, textView8, textView9, textView10, textView11, textView12, constraintLayout2, viewA2, viewA3);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static M18 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.wallet_charge_layout, viewGroup, false);
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
