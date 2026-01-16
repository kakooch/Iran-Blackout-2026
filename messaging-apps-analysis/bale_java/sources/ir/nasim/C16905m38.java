package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.designsystem.avatar.AvatarViewGlide;
import ir.nasim.designsystem.button.BaleButton;
import ir.nasim.features.bank.BankiMoneyAmountView;

/* renamed from: ir.nasim.m38, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16905m38 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final BaleButton b;
    public final View c;
    public final CardView d;
    public final ImageView e;
    public final ConstraintLayout f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final CardView j;
    public final ImageView k;
    public final ConstraintLayout l;
    public final TextView m;
    public final CardView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final ConstraintLayout s;
    public final BankiMoneyAmountView t;
    public final TextView u;
    public final TextView v;
    public final CardView w;
    public final AvatarViewGlide x;
    public final TextView y;
    public final TextView z;

    private C16905m38(ConstraintLayout constraintLayout, BaleButton baleButton, View view, CardView cardView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, CardView cardView2, ImageView imageView2, ConstraintLayout constraintLayout3, TextView textView4, CardView cardView3, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout4, BankiMoneyAmountView bankiMoneyAmountView, TextView textView9, TextView textView10, CardView cardView4, AvatarViewGlide avatarViewGlide, TextView textView11, TextView textView12) {
        this.a = constraintLayout;
        this.b = baleButton;
        this.c = view;
        this.d = cardView;
        this.e = imageView;
        this.f = constraintLayout2;
        this.g = textView;
        this.h = textView2;
        this.i = textView3;
        this.j = cardView2;
        this.k = imageView2;
        this.l = constraintLayout3;
        this.m = textView4;
        this.n = cardView3;
        this.o = textView5;
        this.p = textView6;
        this.q = textView7;
        this.r = textView8;
        this.s = constraintLayout4;
        this.t = bankiMoneyAmountView;
        this.u = textView9;
        this.v = textView10;
        this.w = cardView4;
        this.x = avatarViewGlide;
        this.y = textView11;
        this.z = textView12;
    }

    public static C16905m38 a(View view) {
        View viewA;
        int i = BC5.transfer_type_ok_button;
        BaleButton baleButton = (BaleButton) AbstractC11738dW7.a(view, i);
        if (baleButton != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.transfer_type_ok_button_shadow))) != null) {
            i = BC5.wallet_pay_amount_money_receiver_transfer_type_card;
            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
            if (cardView != null) {
                i = BC5.wallet_pay_amount_money_receiver_transfer_type_card_icon;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.wallet_pay_amount_money_receiver_transfer_type_card_inside;
                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                    if (constraintLayout != null) {
                        i = BC5.wallet_pay_amount_money_receiver_transfer_type_card_title;
                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView != null) {
                            i = BC5.wallet_pay_amount_money_receiver_transfer_type_description;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                i = BC5.wallet_pay_amount_money_receiver_transfer_type_title;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = BC5.wallet_pay_amount_money_receiver_transfer_type_wallet;
                                    CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                    if (cardView2 != null) {
                                        i = BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_icon;
                                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView2 != null) {
                                            i = BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_inside;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                            if (constraintLayout2 != null) {
                                                i = BC5.wallet_pay_amount_money_receiver_transfer_type_wallet_title;
                                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView4 != null) {
                                                    i = BC5.wallet_pay_amount_money_wallet_balance;
                                                    CardView cardView3 = (CardView) AbstractC11738dW7.a(view, i);
                                                    if (cardView3 != null) {
                                                        i = BC5.wallet_pay_amount_money_wallet_balance_rial;
                                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView5 != null) {
                                                            i = BC5.wallet_pay_amount_money_wallet_balance_title;
                                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView6 != null) {
                                                                i = BC5.wallet_pay_amount_money_wallet_balance_value;
                                                                TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView7 != null) {
                                                                    i = BC5.wallet_pay_amount_money_wallet_charge;
                                                                    TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView8 != null) {
                                                                        i = BC5.wallet_pay_header;
                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                        if (constraintLayout3 != null) {
                                                                            i = BC5.wallet_pay_transfer_type_amount;
                                                                            BankiMoneyAmountView bankiMoneyAmountView = (BankiMoneyAmountView) AbstractC11738dW7.a(view, i);
                                                                            if (bankiMoneyAmountView != null) {
                                                                                i = BC5.wallet_pay_transfer_type_bottomsheet_close;
                                                                                TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView9 != null) {
                                                                                    i = BC5.wallet_pay_transfer_type_bottomsheet_title;
                                                                                    TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView10 != null) {
                                                                                        i = BC5.wallet_pay_transfer_type_money_receiver;
                                                                                        CardView cardView4 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                        if (cardView4 != null) {
                                                                                            i = BC5.wallet_pay_transfer_type_money_receiver_pic;
                                                                                            AvatarViewGlide avatarViewGlide = (AvatarViewGlide) AbstractC11738dW7.a(view, i);
                                                                                            if (avatarViewGlide != null) {
                                                                                                i = BC5.wallet_pay_transfer_type_money_receiver_title;
                                                                                                TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                if (textView11 != null) {
                                                                                                    i = BC5.wallet_pay_transfer_type_money_receiver_value;
                                                                                                    TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                    if (textView12 != null) {
                                                                                                        return new C16905m38((ConstraintLayout) view, baleButton, viewA, cardView, imageView, constraintLayout, textView, textView2, textView3, cardView2, imageView2, constraintLayout2, textView4, cardView3, textView5, textView6, textView7, textView8, constraintLayout3, bankiMoneyAmountView, textView9, textView10, cardView4, avatarViewGlide, textView11, textView12);
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

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
