package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import ir.nasim.features.pfm.PFMSpinner;

/* renamed from: ir.nasim.Xy2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C8953Xy2 implements InterfaceC9764aW7 {
    public final PieChart A;
    public final MaterialCardView B;
    public final MaterialCardView C;
    public final TextView D;
    public final TextView E;
    public final RadioGroup F;
    public final RadioGroup G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    private final NestedScrollView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final LinearLayout e;
    public final MaterialRadioButton f;
    public final MaterialRadioButton g;
    public final MaterialRadioButton h;
    public final MaterialRadioButton i;
    public final TextView j;
    public final ImageView k;
    public final ImageView l;
    public final TextView m;
    public final View n;
    public final MaterialCardView o;
    public final PFMSpinner p;
    public final MaterialCardView q;
    public final BarChart r;
    public final TextView s;
    public final TextView t;
    public final ConstraintLayout u;
    public final TextView v;
    public final MaterialCardView w;
    public final ConstraintLayout x;
    public final RelativeLayout y;
    public final NestedScrollView z;

    private C8953Xy2(NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout, MaterialRadioButton materialRadioButton, MaterialRadioButton materialRadioButton2, MaterialRadioButton materialRadioButton3, MaterialRadioButton materialRadioButton4, TextView textView4, ImageView imageView, ImageView imageView2, TextView textView5, View view, MaterialCardView materialCardView, PFMSpinner pFMSpinner, MaterialCardView materialCardView2, BarChart barChart, TextView textView6, TextView textView7, ConstraintLayout constraintLayout, TextView textView8, MaterialCardView materialCardView3, ConstraintLayout constraintLayout2, RelativeLayout relativeLayout, NestedScrollView nestedScrollView2, PieChart pieChart, MaterialCardView materialCardView4, MaterialCardView materialCardView5, TextView textView9, TextView textView10, RadioGroup radioGroup, RadioGroup radioGroup2, TextView textView11, TextView textView12, TextView textView13) {
        this.a = nestedScrollView;
        this.b = textView;
        this.c = textView2;
        this.d = textView3;
        this.e = linearLayout;
        this.f = materialRadioButton;
        this.g = materialRadioButton2;
        this.h = materialRadioButton3;
        this.i = materialRadioButton4;
        this.j = textView4;
        this.k = imageView;
        this.l = imageView2;
        this.m = textView5;
        this.n = view;
        this.o = materialCardView;
        this.p = pFMSpinner;
        this.q = materialCardView2;
        this.r = barChart;
        this.s = textView6;
        this.t = textView7;
        this.u = constraintLayout;
        this.v = textView8;
        this.w = materialCardView3;
        this.x = constraintLayout2;
        this.y = relativeLayout;
        this.z = nestedScrollView2;
        this.A = pieChart;
        this.B = materialCardView4;
        this.C = materialCardView5;
        this.D = textView9;
        this.E = textView10;
        this.F = radioGroup;
        this.G = radioGroup2;
        this.H = textView11;
        this.I = textView12;
        this.J = textView13;
    }

    public static C8953Xy2 a(View view) {
        View viewA;
        int i = BC5.bar_chat_sub_title;
        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
        if (textView != null) {
            i = BC5.bar_chat_title;
            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
            if (textView2 != null) {
                i = BC5.bar_rial;
                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView3 != null) {
                    i = BC5.calculation_method_container;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null) {
                        i = BC5.diagram_bar_deposit_type;
                        MaterialRadioButton materialRadioButton = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                        if (materialRadioButton != null) {
                            i = BC5.diagram_bar_withdraw_type;
                            MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                            if (materialRadioButton2 != null) {
                                i = BC5.diagram_type_top_up;
                                MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                if (materialRadioButton3 != null) {
                                    i = BC5.diagram_type_withdraw;
                                    MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) AbstractC11738dW7.a(view, i);
                                    if (materialRadioButton4 != null) {
                                        i = BC5.expenditure_label;
                                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView4 != null) {
                                            i = BC5.help_ic;
                                            ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                            if (imageView != null) {
                                                i = BC5.imv_date_filter_icon;
                                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                if (imageView2 != null) {
                                                    i = BC5.income_label;
                                                    TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView5 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.items_divider))) != null) {
                                                        i = BC5.labels_cv;
                                                        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                        if (materialCardView != null) {
                                                            i = BC5.pfm_accounts_spinner;
                                                            PFMSpinner pFMSpinner = (PFMSpinner) AbstractC11738dW7.a(view, i);
                                                            if (pFMSpinner != null) {
                                                                i = BC5.pfm_accounts_spinner_card;
                                                                MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                if (materialCardView2 != null) {
                                                                    i = BC5.pfm_bar_chart;
                                                                    BarChart barChart = (BarChart) AbstractC11738dW7.a(view, i);
                                                                    if (barChart != null) {
                                                                        i = BC5.pfm_calculation_method;
                                                                        TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView6 != null) {
                                                                            i = BC5.pfm_date_range_tv;
                                                                            TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView7 != null) {
                                                                                i = BC5.pfm_diagram_rods;
                                                                                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                if (constraintLayout != null) {
                                                                                    i = BC5.pfm_empty_trans_tv;
                                                                                    TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView8 != null) {
                                                                                        i = BC5.pfm_filter_date;
                                                                                        MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                        if (materialCardView3 != null) {
                                                                                            i = BC5.pfm_filter_date_cl;
                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                            if (constraintLayout2 != null) {
                                                                                                i = BC5.pfm_parent_cs;
                                                                                                RelativeLayout relativeLayout = (RelativeLayout) AbstractC11738dW7.a(view, i);
                                                                                                if (relativeLayout != null) {
                                                                                                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                                                                                                    i = BC5.pfm_pie_chart;
                                                                                                    PieChart pieChart = (PieChart) AbstractC11738dW7.a(view, i);
                                                                                                    if (pieChart != null) {
                                                                                                        i = BC5.pfm_tags_diagram;
                                                                                                        MaterialCardView materialCardView4 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                                        if (materialCardView4 != null) {
                                                                                                            i = BC5.pfm_trans_type_diagram;
                                                                                                            MaterialCardView materialCardView5 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                                            if (materialCardView5 != null) {
                                                                                                                i = BC5.pie_chart_custom_legend;
                                                                                                                TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = BC5.pie_chart_description;
                                                                                                                    TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (textView10 != null) {
                                                                                                                        i = BC5.rdg_bar_trans_type;
                                                                                                                        RadioGroup radioGroup = (RadioGroup) AbstractC11738dW7.a(view, i);
                                                                                                                        if (radioGroup != null) {
                                                                                                                            i = BC5.rdg_trans_type;
                                                                                                                            RadioGroup radioGroup2 = (RadioGroup) AbstractC11738dW7.a(view, i);
                                                                                                                            if (radioGroup2 != null) {
                                                                                                                                i = BC5.set_tag_text;
                                                                                                                                TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                if (textView11 != null) {
                                                                                                                                    i = BC5.top_up_value;
                                                                                                                                    TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                    if (textView12 != null) {
                                                                                                                                        i = BC5.withdraw_value;
                                                                                                                                        TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                        if (textView13 != null) {
                                                                                                                                            return new C8953Xy2(nestedScrollView, textView, textView2, textView3, linearLayout, materialRadioButton, materialRadioButton2, materialRadioButton3, materialRadioButton4, textView4, imageView, imageView2, textView5, viewA, materialCardView, pFMSpinner, materialCardView2, barChart, textView6, textView7, constraintLayout, textView8, materialCardView3, constraintLayout2, relativeLayout, nestedScrollView, pieChart, materialCardView4, materialCardView5, textView9, textView10, radioGroup, radioGroup2, textView11, textView12, textView13);
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

    public static C8953Xy2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_pfm_diagram, viewGroup, false);
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
