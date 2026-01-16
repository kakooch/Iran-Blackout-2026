package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.bank.MoneyAmountView;
import ir.nasim.features.conversation.view.TitledBankCardView;

/* loaded from: classes5.dex */
public final class C14 implements InterfaceC9764aW7 {
    public final BaleButton A;
    public final O50 B;
    public final RelativeLayout C;
    public final CardView D;
    public final TextView E;
    public final CardView F;
    public final ConstraintLayout G;
    public final TextView H;
    public final TextView I;
    public final ScrollView J;
    public final ConstraintLayout K;
    public final TitledBankCardView L;
    public final TextView M;
    public final ConstraintLayout N;
    public final TextView O;
    public final TextView P;
    private final RelativeLayout a;
    public final ConstraintLayout b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final RelativeLayout f;
    public final TextView g;
    public final ConstraintLayout h;
    public final TextView i;
    public final View j;
    public final FrameLayout k;
    public final ConstraintLayout l;
    public final RelativeLayout m;
    public final ImageView n;
    public final TextView o;
    public final CardView p;
    public final ConstraintLayout q;
    public final ConstraintLayout r;
    public final View s;
    public final View t;
    public final RelativeLayout u;
    public final TextView v;
    public final MoneyAmountView w;
    public final ConstraintLayout x;
    public final TextView y;
    public final TextView z;

    private C14(RelativeLayout relativeLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout2, TextView textView4, ConstraintLayout constraintLayout2, TextView textView5, View view, FrameLayout frameLayout, ConstraintLayout constraintLayout3, RelativeLayout relativeLayout3, ImageView imageView, TextView textView6, CardView cardView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, View view2, View view3, RelativeLayout relativeLayout4, TextView textView7, MoneyAmountView moneyAmountView, ConstraintLayout constraintLayout6, TextView textView8, TextView textView9, BaleButton baleButton, O50 o50, RelativeLayout relativeLayout5, CardView cardView2, TextView textView10, CardView cardView3, ConstraintLayout constraintLayout7, TextView textView11, TextView textView12, ScrollView scrollView, ConstraintLayout constraintLayout8, TitledBankCardView titledBankCardView, TextView textView13, ConstraintLayout constraintLayout9, TextView textView14, TextView textView15) {
        this.a = relativeLayout;
        this.b = constraintLayout;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = relativeLayout2;
        this.g = textView4;
        this.h = constraintLayout2;
        this.i = textView5;
        this.j = view;
        this.k = frameLayout;
        this.l = constraintLayout3;
        this.m = relativeLayout3;
        this.n = imageView;
        this.o = textView6;
        this.p = cardView;
        this.q = constraintLayout4;
        this.r = constraintLayout5;
        this.s = view2;
        this.t = view3;
        this.u = relativeLayout4;
        this.v = textView7;
        this.w = moneyAmountView;
        this.x = constraintLayout6;
        this.y = textView8;
        this.z = textView9;
        this.A = baleButton;
        this.B = o50;
        this.C = relativeLayout5;
        this.D = cardView2;
        this.E = textView10;
        this.F = cardView3;
        this.G = constraintLayout7;
        this.H = textView11;
        this.I = textView12;
        this.J = scrollView;
        this.K = constraintLayout8;
        this.L = titledBankCardView;
        this.M = textView13;
        this.N = constraintLayout9;
        this.O = textView14;
        this.P = textView15;
    }

    public static C14 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i = BC5.amount_section;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = BC5.amount_section_title;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.amount_text_view;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.bank_card_hint;
                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView3 != null) {
                        i = BC5.bank_card_image_container;
                        RelativeLayout relativeLayout = (RelativeLayout) AbstractC11738dW7.a(view, i);
                        if (relativeLayout != null) {
                            i = BC5.bank_card_number_text_view;
                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView4 != null) {
                                i = BC5.bank_card_section;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout2 != null) {
                                    i = BC5.bank_card_title;
                                    TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView5 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.c6))) != null) {
                                        i = BC5.card_number_placeholder;
                                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                        if (frameLayout != null) {
                                            i = BC5.first_page_container;
                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                            if (constraintLayout3 != null) {
                                                i = BC5.frame_layout_container;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) AbstractC11738dW7.a(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = BC5.image_bank_logo;
                                                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                                    if (imageView != null) {
                                                        i = BC5.melli_refund_close;
                                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView6 != null) {
                                                            i = BC5.melli_refund_details_card_view;
                                                            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                                            if (cardView != null) {
                                                                i = BC5.melli_refund_details_container;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = BC5.melli_refund_header;
                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                    if (constraintLayout5 != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.melli_refund_header_shadow))) != null && (viewA3 = AbstractC11738dW7.a(view, (i = BC5.melli_refund_ok_button_shadow))) != null) {
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                                                        i = BC5.melli_refund_title;
                                                                        TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView7 != null) {
                                                                            i = BC5.money_amount_view;
                                                                            MoneyAmountView moneyAmountView = (MoneyAmountView) AbstractC11738dW7.a(view, i);
                                                                            if (moneyAmountView != null) {
                                                                                i = BC5.name_section;
                                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                if (constraintLayout6 != null) {
                                                                                    i = BC5.name_section_title;
                                                                                    TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView8 != null) {
                                                                                        i = BC5.name_text_view;
                                                                                        TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                        if (textView9 != null) {
                                                                                            i = BC5.ok_button;
                                                                                            BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
                                                                                            if (baleButton != null && (viewA4 = AbstractC11738dW7.a(view, (i = BC5.progress_bar_view))) != null) {
                                                                                                O50 o50A = O50.a(viewA4);
                                                                                                i = BC5.refund_image_container;
                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) AbstractC11738dW7.a(view, i);
                                                                                                if (relativeLayout4 != null) {
                                                                                                    i = BC5.refund_number_container;
                                                                                                    CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                                    if (cardView2 != null) {
                                                                                                        i = BC5.refund_number_text_view;
                                                                                                        TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = BC5.refund_pay_card_container;
                                                                                                            CardView cardView3 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                                            if (cardView3 != null) {
                                                                                                                i = BC5.refund_section;
                                                                                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                if (constraintLayout7 != null) {
                                                                                                                    i = BC5.refund_section_title;
                                                                                                                    TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (textView11 != null) {
                                                                                                                        i = BC5.refund_text_view;
                                                                                                                        TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                        if (textView12 != null) {
                                                                                                                            i = BC5.scroll_view;
                                                                                                                            ScrollView scrollView = (ScrollView) AbstractC11738dW7.a(view, i);
                                                                                                                            if (scrollView != null) {
                                                                                                                                i = BC5.second_page_container;
                                                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                if (constraintLayout8 != null) {
                                                                                                                                    i = BC5.source_card_view;
                                                                                                                                    TitledBankCardView titledBankCardView = (TitledBankCardView) AbstractC11738dW7.a(view, i);
                                                                                                                                    if (titledBankCardView != null) {
                                                                                                                                        i = BC5.tv_card_number_hint;
                                                                                                                                        TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            i = BC5.type_section;
                                                                                                                                            ConstraintLayout constraintLayout9 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                                                            if (constraintLayout9 != null) {
                                                                                                                                                i = BC5.type_section_title;
                                                                                                                                                TextView textView14 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                if (textView14 != null) {
                                                                                                                                                    i = BC5.type_text_view;
                                                                                                                                                    TextView textView15 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                                    if (textView15 != null) {
                                                                                                                                                        return new C14(relativeLayout3, constraintLayout, textView, textView2, textView3, relativeLayout, textView4, constraintLayout2, textView5, viewA, frameLayout, constraintLayout3, relativeLayout2, imageView, textView6, cardView, constraintLayout4, constraintLayout5, viewA2, viewA3, relativeLayout3, textView7, moneyAmountView, constraintLayout6, textView8, textView9, baleButton, o50A, relativeLayout4, cardView2, textView10, cardView3, constraintLayout7, textView11, textView12, scrollView, constraintLayout8, titledBankCardView, textView13, constraintLayout9, textView14, textView15);
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

    public static C14 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.melli_refund_bottom_sheet_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
