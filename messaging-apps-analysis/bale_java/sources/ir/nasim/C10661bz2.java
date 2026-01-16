package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* renamed from: ir.nasim.bz2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10661bz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final ComposeView b;
    public final MaterialButton c;
    public final ImageView d;
    public final ImageView e;
    public final Guideline f;
    public final ImageView g;
    public final ConstraintLayout h;
    public final RecyclerView i;
    public final TextView j;
    public final TextView k;
    public final TextView l;
    public final TextView m;
    public final TextView n;
    public final TextView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final MaterialButton y;
    public final TextView z;

    private C10661bz2(LinearLayout linearLayout, ComposeView composeView, MaterialButton materialButton, ImageView imageView, ImageView imageView2, Guideline guideline, ImageView imageView3, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, MaterialButton materialButton2, TextView textView16) {
        this.a = linearLayout;
        this.b = composeView;
        this.c = materialButton;
        this.d = imageView;
        this.e = imageView2;
        this.f = guideline;
        this.g = imageView3;
        this.h = constraintLayout;
        this.i = recyclerView;
        this.j = textView;
        this.k = textView2;
        this.l = textView3;
        this.m = textView4;
        this.n = textView5;
        this.o = textView6;
        this.p = textView7;
        this.q = textView8;
        this.r = textView9;
        this.s = textView10;
        this.t = textView11;
        this.u = textView12;
        this.v = textView13;
        this.w = textView14;
        this.x = textView15;
        this.y = materialButton2;
        this.z = textView16;
    }

    public static C10661bz2 a(View view) {
        int i = BC5.card_to_card_banner_advertisement;
        ComposeView composeView = (ComposeView) AbstractC11738dW7.a(view, i);
        if (composeView != null) {
            i = BC5.closeBtn;
            MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
            if (materialButton != null) {
                i = BC5.divider;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.dividerImg;
                    ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView2 != null) {
                        i = BC5.guideline_rec;
                        Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                        if (guideline != null) {
                            i = BC5.iconImg;
                            ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                            if (imageView3 != null) {
                                i = BC5.informationTitle_container;
                                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout != null) {
                                    i = BC5.inviteFriendsRecycler;
                                    RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
                                    if (recyclerView != null) {
                                        i = BC5.inviteFriendsTxt;
                                        TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                                        if (textView != null) {
                                            i = BC5.receipt_amount;
                                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                                            if (textView2 != null) {
                                                i = BC5.receipt_date;
                                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView3 != null) {
                                                    i = BC5.receipt_description;
                                                    TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                    if (textView4 != null) {
                                                        i = BC5.receipt_dst_card;
                                                        TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView5 != null) {
                                                            i = BC5.receipt_owner_name;
                                                            TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView6 != null) {
                                                                i = BC5.receipt_response_amount;
                                                                TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView7 != null) {
                                                                    i = BC5.receipt_response_date;
                                                                    TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView8 != null) {
                                                                        i = BC5.receipt_response_description;
                                                                        TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                        if (textView9 != null) {
                                                                            i = BC5.receipt_response_dst_card;
                                                                            TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                            if (textView10 != null) {
                                                                                i = BC5.receipt_response_dst_name;
                                                                                TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                if (textView11 != null) {
                                                                                    i = BC5.receipt_response_seguimiento;
                                                                                    TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView12 != null) {
                                                                                        i = BC5.receipt_response_src_card;
                                                                                        TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                        if (textView13 != null) {
                                                                                            i = BC5.receipt_seguimiento;
                                                                                            TextView textView14 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                            if (textView14 != null) {
                                                                                                i = BC5.receipt_src_card;
                                                                                                TextView textView15 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                if (textView15 != null) {
                                                                                                    i = BC5.shareBtn;
                                                                                                    MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
                                                                                                    if (materialButton2 != null) {
                                                                                                        i = BC5.titleTxt;
                                                                                                        TextView textView16 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                        if (textView16 != null) {
                                                                                                            return new C10661bz2((LinearLayout) view, composeView, materialButton, imageView, imageView2, guideline, imageView3, constraintLayout, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, materialButton2, textView16);
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

    public static C10661bz2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_receipt, viewGroup, false);
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
