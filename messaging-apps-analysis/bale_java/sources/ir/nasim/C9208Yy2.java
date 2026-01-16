package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import ir.nasim.features.pfm.persiandate.view.PersianDatePicker;

/* renamed from: ir.nasim.Yy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9208Yy2 implements InterfaceC9764aW7 {
    private final NestedScrollView a;
    public final MaterialRadioButton b;
    public final ConstraintLayout c;
    public final View d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final CardView h;
    public final PersianDatePicker i;
    public final TextView j;
    public final ImageView k;
    public final ImageView l;
    public final MaterialRadioButton m;
    public final MaterialRadioButton n;
    public final ConstraintLayout o;
    public final TextView p;
    public final TextView q;
    public final CardView r;
    public final PersianDatePicker s;
    public final TextView t;
    public final MaterialRadioButton u;
    public final TextView v;
    public final MaterialRadioButton w;

    private C9208Yy2(NestedScrollView nestedScrollView, MaterialRadioButton materialRadioButton, ConstraintLayout constraintLayout, View view, TextView textView, TextView textView2, TextView textView3, CardView cardView, PersianDatePicker persianDatePicker, TextView textView4, ImageView imageView, ImageView imageView2, MaterialRadioButton materialRadioButton2, MaterialRadioButton materialRadioButton3, ConstraintLayout constraintLayout2, TextView textView5, TextView textView6, CardView cardView2, PersianDatePicker persianDatePicker2, TextView textView7, MaterialRadioButton materialRadioButton4, TextView textView8, MaterialRadioButton materialRadioButton5) {
        this.a = nestedScrollView;
        this.b = materialRadioButton;
        this.c = constraintLayout;
        this.d = view;
        this.e = textView;
        this.f = textView2;
        this.g = textView3;
        this.h = cardView;
        this.i = persianDatePicker;
        this.j = textView4;
        this.k = imageView;
        this.l = imageView2;
        this.m = materialRadioButton2;
        this.n = materialRadioButton3;
        this.o = constraintLayout2;
        this.p = textView5;
        this.q = textView6;
        this.r = cardView2;
        this.s = persianDatePicker2;
        this.t = textView7;
        this.u = materialRadioButton4;
        this.v = textView8;
        this.w = materialRadioButton5;
    }

    public static C9208Yy2 a(View view) {
        View viewA;
        int i = BC5.custom_time_filter_rb;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
        if (materialRadioButton != null) {
            i = BC5.date_layout;
            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.divider))) != null) {
                i = BC5.do_filter_btn;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    i = BC5.from_time;
                    TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView2 != null) {
                        i = BC5.from_time_error_tv;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = BC5.from_time_persian_date_card;
                            CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                            if (cardView != null) {
                                i = BC5.from_time_persian_date_picker;
                                PersianDatePicker persianDatePicker = (PersianDatePicker) AbstractC11738dW7.a(view, i);
                                if (persianDatePicker != null) {
                                    i = BC5.from_time_tv;
                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                    if (textView4 != null) {
                                        i = BC5.imv_close;
                                        ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView != null) {
                                            i = BC5.line_iv;
                                            ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                            if (imageView2 != null) {
                                                i = BC5.month_filter_rb;
                                                MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                                if (materialRadioButton2 != null) {
                                                    i = BC5.thirtyDays_filter_rb;
                                                    MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                                    if (materialRadioButton3 != null) {
                                                        i = BC5.time_filter_rg;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                        if (constraintLayout2 != null) {
                                                            i = BC5.to_time;
                                                            TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView5 != null) {
                                                                i = BC5.to_time_error_tv;
                                                                TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView6 != null) {
                                                                    i = BC5.to_time_persian_date_card;
                                                                    CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                                                    if (cardView2 != null) {
                                                                        i = BC5.to_time_persian_date_picker;
                                                                        PersianDatePicker persianDatePicker2 = (PersianDatePicker) AbstractC11738dW7.a(view, i);
                                                                        if (persianDatePicker2 != null) {
                                                                            i = BC5.to_time_tv;
                                                                            TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView7 != null) {
                                                                                i = BC5.today_filter_rb;
                                                                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                                                                if (materialRadioButton4 != null) {
                                                                                    i = BC5.transaction_type_title;
                                                                                    TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView8 != null) {
                                                                                        i = BC5.week_filter_rb;
                                                                                        MaterialRadioButton materialRadioButton5 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                                                                        if (materialRadioButton5 != null) {
                                                                                            return new C9208Yy2((NestedScrollView) view, materialRadioButton, constraintLayout, viewA, textView, textView2, textView3, cardView, persianDatePicker, textView4, imageView, imageView2, materialRadioButton2, materialRadioButton3, constraintLayout2, textView5, textView6, cardView2, persianDatePicker2, textView7, materialRadioButton4, textView8, materialRadioButton5);
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

    public static C9208Yy2 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C9208Yy2 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_pfm_time_filter_bottom_sheet_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.a;
    }
}
