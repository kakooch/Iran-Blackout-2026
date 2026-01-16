package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.droidkit.progress.CircularView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* renamed from: ir.nasim.Yx2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C9199Yx2 implements InterfaceC9764aW7 {
    public final ImageView A;
    public final FrameLayout B;
    public final TextView C;
    public final CircularView D;
    public final EditText E;
    public final MaterialCardView F;
    public final TextView G;
    public final TextView H;
    public final C23480wz6 I;
    public final TextView J;
    public final View K;
    public final CardView L;
    public final View M;
    public final TextView N;
    private final ConstraintLayout a;
    public final C23480wz6 b;
    public final TextView c;
    public final MaterialCardView d;
    public final LinearLayout e;
    public final C23480wz6 f;
    public final TextView g;
    public final LinearProgressIndicator h;
    public final C22294uz6 i;
    public final ConstraintLayout j;
    public final ImageView k;
    public final CardView l;
    public final ImageButton m;
    public final ImageView n;
    public final CardView o;
    public final TextView p;
    public final TextView q;
    public final TextView r;
    public final TextView s;
    public final ImageButton t;
    public final ConstraintLayout u;
    public final ImageView v;
    public final TextView w;
    public final MaterialCardView x;
    public final MaterialCardView y;
    public final TextView z;

    private C9199Yx2(ConstraintLayout constraintLayout, C23480wz6 c23480wz6, TextView textView, MaterialCardView materialCardView, LinearLayout linearLayout, C23480wz6 c23480wz62, TextView textView2, LinearProgressIndicator linearProgressIndicator, C22294uz6 c22294uz6, ConstraintLayout constraintLayout2, ImageView imageView, CardView cardView, ImageButton imageButton, ImageView imageView2, CardView cardView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, ImageButton imageButton2, ConstraintLayout constraintLayout3, ImageView imageView3, TextView textView7, MaterialCardView materialCardView2, MaterialCardView materialCardView3, TextView textView8, ImageView imageView4, FrameLayout frameLayout, TextView textView9, CircularView circularView, EditText editText, MaterialCardView materialCardView4, TextView textView10, TextView textView11, C23480wz6 c23480wz63, TextView textView12, View view, CardView cardView3, View view2, TextView textView13) {
        this.a = constraintLayout;
        this.b = c23480wz6;
        this.c = textView;
        this.d = materialCardView;
        this.e = linearLayout;
        this.f = c23480wz62;
        this.g = textView2;
        this.h = linearProgressIndicator;
        this.i = c22294uz6;
        this.j = constraintLayout2;
        this.k = imageView;
        this.l = cardView;
        this.m = imageButton;
        this.n = imageView2;
        this.o = cardView2;
        this.p = textView3;
        this.q = textView4;
        this.r = textView5;
        this.s = textView6;
        this.t = imageButton2;
        this.u = constraintLayout3;
        this.v = imageView3;
        this.w = textView7;
        this.x = materialCardView2;
        this.y = materialCardView3;
        this.z = textView8;
        this.A = imageView4;
        this.B = frameLayout;
        this.C = textView9;
        this.D = circularView;
        this.E = editText;
        this.F = materialCardView4;
        this.G = textView10;
        this.H = textView11;
        this.I = c23480wz63;
        this.J = textView12;
        this.K = view;
        this.L = cardView3;
        this.M = view2;
        this.N = textView13;
    }

    public static C9199Yx2 a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        int i = BC5.amountShimmerLayout;
        View viewA6 = AbstractC11738dW7.a(view, i);
        if (viewA6 != null) {
            C23480wz6 c23480wz6A = C23480wz6.a(viewA6);
            i = BC5.amountTxt;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.cardPhotoImg;
                MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                if (materialCardView != null) {
                    i = BC5.completeProgressLayout;
                    LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                    if (linearLayout != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.completeProgressShimmer))) != null) {
                        C23480wz6 c23480wz6A2 = C23480wz6.a(viewA);
                        i = BC5.completeProgressTxt;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = BC5.completedProgress;
                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) AbstractC11738dW7.a(view, i);
                            if (linearProgressIndicator != null && (viewA2 = AbstractC11738dW7.a(view, (i = BC5.completedProgressShimmer))) != null) {
                                C22294uz6 c22294uz6A = C22294uz6.a(viewA2);
                                i = BC5.constraintLayout2;
                                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout != null) {
                                    i = BC5.contentIcon;
                                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                                    if (imageView != null) {
                                        i = BC5.contributorsCard;
                                        CardView cardView = (CardView) AbstractC11738dW7.a(view, i);
                                        if (cardView != null) {
                                            i = BC5.decreaseBtn;
                                            ImageButton imageButton = (ImageButton) AbstractC11738dW7.a(view, i);
                                            if (imageButton != null) {
                                                i = BC5.descriptionArrowImg;
                                                ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                                                if (imageView2 != null) {
                                                    i = BC5.descriptionCard;
                                                    CardView cardView2 = (CardView) AbstractC11738dW7.a(view, i);
                                                    if (cardView2 != null) {
                                                        i = BC5.descriptionText;
                                                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                                        if (textView3 != null) {
                                                            i = BC5.descriptionTitleText;
                                                            TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                            if (textView4 != null) {
                                                                i = BC5.finalAmountTitleTxt;
                                                                TextView textView5 = (TextView) AbstractC11738dW7.a(view, i);
                                                                if (textView5 != null) {
                                                                    i = BC5.finalAmountTxt;
                                                                    TextView textView6 = (TextView) AbstractC11738dW7.a(view, i);
                                                                    if (textView6 != null) {
                                                                        i = BC5.increaseBtn;
                                                                        ImageButton imageButton2 = (ImageButton) AbstractC11738dW7.a(view, i);
                                                                        if (imageButton2 != null) {
                                                                            i = BC5.mainScrollLayout;
                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                                                            if (constraintLayout2 != null) {
                                                                                i = BC5.paid_list_arrow_img;
                                                                                ImageView imageView3 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                if (imageView3 != null) {
                                                                                    i = BC5.paid_list_title_txt;
                                                                                    TextView textView7 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                    if (textView7 != null) {
                                                                                        i = BC5.paymentBar;
                                                                                        MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                        if (materialCardView2 != null) {
                                                                                            i = BC5.paymentCard;
                                                                                            MaterialCardView materialCardView3 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                            if (materialCardView3 != null) {
                                                                                                i = BC5.paymentTxt;
                                                                                                TextView textView8 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                if (textView8 != null) {
                                                                                                    i = BC5.photoImg;
                                                                                                    ImageView imageView4 = (ImageView) AbstractC11738dW7.a(view, i);
                                                                                                    if (imageView4 != null) {
                                                                                                        i = BC5.progressBg;
                                                                                                        FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                                                                                        if (frameLayout != null) {
                                                                                                            i = BC5.progressValue;
                                                                                                            TextView textView9 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                            if (textView9 != null) {
                                                                                                                i = BC5.progressView;
                                                                                                                CircularView circularView = (CircularView) AbstractC11738dW7.a(view, i);
                                                                                                                if (circularView != null) {
                                                                                                                    i = BC5.quantityTxt;
                                                                                                                    EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                                                                                                                    if (editText != null) {
                                                                                                                        i = BC5.quantityTxt_container;
                                                                                                                        MaterialCardView materialCardView4 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                                                                                                        if (materialCardView4 != null) {
                                                                                                                            i = BC5.quotaAmountTitleTxt;
                                                                                                                            TextView textView10 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                            if (textView10 != null) {
                                                                                                                                i = BC5.quotaAmountTxt;
                                                                                                                                TextView textView11 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                if (textView11 != null && (viewA3 = AbstractC11738dW7.a(view, (i = BC5.remainTimeShimmer))) != null) {
                                                                                                                                    C23480wz6 c23480wz6A3 = C23480wz6.a(viewA3);
                                                                                                                                    i = BC5.remainTimeTxt;
                                                                                                                                    TextView textView12 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                    if (textView12 != null && (viewA4 = AbstractC11738dW7.a(view, (i = BC5.sixtyDivider))) != null) {
                                                                                                                                        i = BC5.summaryCard;
                                                                                                                                        CardView cardView3 = (CardView) AbstractC11738dW7.a(view, i);
                                                                                                                                        if (cardView3 != null && (viewA5 = AbstractC11738dW7.a(view, (i = BC5.thirtyDivider))) != null) {
                                                                                                                                            i = BC5.titleTxt;
                                                                                                                                            TextView textView13 = (TextView) AbstractC11738dW7.a(view, i);
                                                                                                                                            if (textView13 != null) {
                                                                                                                                                return new C9199Yx2((ConstraintLayout) view, c23480wz6A, textView, materialCardView, linearLayout, c23480wz6A2, textView2, linearProgressIndicator, c22294uz6A, constraintLayout, imageView, cardView, imageButton, imageView2, cardView2, textView3, textView4, textView5, textView6, imageButton2, constraintLayout2, imageView3, textView7, materialCardView2, materialCardView3, textView8, imageView4, frameLayout, textView9, circularView, editText, materialCardView4, textView10, textView11, c23480wz6A3, textView12, viewA4, cardView3, viewA5, textView13);
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

    public static C9199Yx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_crowdfunding, viewGroup, false);
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
