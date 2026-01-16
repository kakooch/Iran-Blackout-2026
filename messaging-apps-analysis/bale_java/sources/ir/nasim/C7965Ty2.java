package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.features.pfm.PFMSpinner;

/* renamed from: ir.nasim.Ty2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7965Ty2 implements InterfaceC9764aW7 {
    public final TextView A;
    public final TextView B;
    public final TextView C;
    public final View D;
    public final View E;
    private final LinearLayout a;
    public final LinearLayout b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final Guideline g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final PFMSpinner k;
    public final MaterialCardView l;
    public final AppBarLayout m;
    public final TextView n;
    public final CollapsingToolbarLayout o;
    public final TextView p;
    public final TextView q;
    public final MaterialCardView r;
    public final ConstraintLayout s;
    public final MaterialCardView t;
    public final ConstraintLayout u;
    public final CardView v;
    public final ProgressBar w;
    public final ConstraintLayout x;
    public final ConstraintLayout y;
    public final RecyclerView z;

    private C7965Ty2(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, Guideline guideline, ImageView imageView, ImageView imageView2, ImageView imageView3, PFMSpinner pFMSpinner, MaterialCardView materialCardView, AppBarLayout appBarLayout, TextView textView5, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView6, TextView textView7, MaterialCardView materialCardView2, ConstraintLayout constraintLayout, MaterialCardView materialCardView3, ConstraintLayout constraintLayout2, CardView cardView, ProgressBar progressBar, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView8, TextView textView9, TextView textView10, View view, View view2) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = textView4;
        this.g = guideline;
        this.h = imageView;
        this.i = imageView2;
        this.j = imageView3;
        this.k = pFMSpinner;
        this.l = materialCardView;
        this.m = appBarLayout;
        this.n = textView5;
        this.o = collapsingToolbarLayout;
        this.p = textView6;
        this.q = textView7;
        this.r = materialCardView2;
        this.s = constraintLayout;
        this.t = materialCardView3;
        this.u = constraintLayout2;
        this.v = cardView;
        this.w = progressBar;
        this.x = constraintLayout3;
        this.y = constraintLayout4;
        this.z = recyclerView;
        this.A = textView8;
        this.B = textView9;
        this.C = textView10;
        this.D = view;
        this.E = view2;
    }

    public static C7965Ty2 a(View view) {
        View viewA;
        View viewA2;
        int i = BC5.calculation_method_container;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = BC5.fpm_amount_top_up_text;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.fpm_amount_withdraw_text;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.fpm_title_bardadsht_text;
                    TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView3 != null) {
                        i = BC5.fpm_title_variz_text;
                        TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView4 != null) {
                            i = BC5.guideLine;
                            Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                            if (guideline != null) {
                                i = BC5.help_ic;
                                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                if (imageView != null) {
                                    i = BC5.imv_date_filter_icon;
                                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView2 != null) {
                                        i = BC5.imv_filters_icon;
                                        ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                        if (imageView3 != null) {
                                            i = BC5.pfm_accounts_spinner;
                                            PFMSpinner pFMSpinner = (PFMSpinner) AbstractC11738dW7.a(view, i);
                                            if (pFMSpinner != null) {
                                                i = BC5.pfm_accounts_spinner_card;
                                                MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                if (materialCardView != null) {
                                                    i = BC5.pfm_appbar;
                                                    AppBarLayout appBarLayout = (AppBarLayout) AbstractC11738dW7.a(view, i);
                                                    if (appBarLayout != null) {
                                                        i = BC5.pfm_calculation_method;
                                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView5 != null) {
                                                            i = BC5.pfm_ct;
                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) AbstractC11738dW7.a(view, i);
                                                            if (collapsingToolbarLayout != null) {
                                                                i = BC5.pfm_date_range_tv;
                                                                TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView6 != null) {
                                                                    i = BC5.pfm_empty_trans_tv;
                                                                    TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView7 != null) {
                                                                        i = BC5.pfm_filter_date;
                                                                        MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                        if (materialCardView2 != null) {
                                                                            i = BC5.pfm_filter_date_cl;
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                            if (constraintLayout != null) {
                                                                                i = BC5.pfm_filter_more;
                                                                                MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                if (materialCardView3 != null) {
                                                                                    i = BC5.pfm_filter_more_cl;
                                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                    if (constraintLayout2 != null) {
                                                                                        i = BC5.pfm_layout_mali;
                                                                                        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                                                                        if (cardView != null) {
                                                                                            i = BC5.pfm_list_pb;
                                                                                            ProgressBar progressBar = (ProgressBar) AbstractC11738dW7.a(view, i);
                                                                                            if (progressBar != null) {
                                                                                                i = BC5.pfm_parent_cs;
                                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                if (constraintLayout3 != null) {
                                                                                                    i = BC5.pfm_root_collapsing;
                                                                                                    ConstraintLayout constraintLayout4 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                                                    if (constraintLayout4 != null) {
                                                                                                        i = BC5.pfm_transaction_recycler;
                                                                                                        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                                                                                        if (recyclerView != null) {
                                                                                                            i = BC5.rial1;
                                                                                                            TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                            if (textView8 != null) {
                                                                                                                i = BC5.rial2;
                                                                                                                TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                if (textView9 != null) {
                                                                                                                    i = BC5.tv_filters;
                                                                                                                    TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                    if (textView10 != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.vertical_divider))) != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.vertical_divider_first))) != null) {
                                                                                                                        return new C7965Ty2((LinearLayout) view, linearLayout, textView, textView2, textView3, textView4, guideline, imageView, imageView2, imageView3, pFMSpinner, materialCardView, appBarLayout, textView5, collapsingToolbarLayout, textView6, textView7, materialCardView2, constraintLayout, materialCardView3, constraintLayout2, cardView, progressBar, constraintLayout3, constraintLayout4, recyclerView, textView8, textView9, textView10, viewA, viewA2);
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

    public static C7965Ty2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_p_f_m, viewGroup, false);
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
