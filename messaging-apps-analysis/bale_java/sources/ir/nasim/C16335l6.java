package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.makeramen.roundedimageview.RoundedImageView;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.PullBackLayout;
import ir.nasim.designsystem.photoviewer.widget.RecyclerViewFixMotionLayout;

/* renamed from: ir.nasim.l6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16335l6 implements InterfaceC9764aW7 {
    private final PullBackLayout a;
    public final RoundedImageView b;
    public final Toolbar c;
    public final Toolbar d;
    public final TextView e;
    public final TextView f;
    public final Guideline g;
    public final TextView h;
    public final ConstraintLayout i;
    public final RecyclerViewFixMotionLayout j;
    public final LinearLayout k;
    public final TextView l;
    public final PullBackLayout m;
    public final BaleToolbar n;

    private C16335l6(PullBackLayout pullBackLayout, RoundedImageView roundedImageView, Toolbar toolbar, Toolbar toolbar2, TextView textView, TextView textView2, Guideline guideline, TextView textView3, ConstraintLayout constraintLayout, RecyclerViewFixMotionLayout recyclerViewFixMotionLayout, LinearLayout linearLayout, TextView textView4, PullBackLayout pullBackLayout2, BaleToolbar baleToolbar) {
        this.a = pullBackLayout;
        this.b = roundedImageView;
        this.c = toolbar;
        this.d = toolbar2;
        this.e = textView;
        this.f = textView2;
        this.g = guideline;
        this.h = textView3;
        this.i = constraintLayout;
        this.j = recyclerViewFixMotionLayout;
        this.k = linearLayout;
        this.l = textView4;
        this.m = pullBackLayout2;
        this.n = baleToolbar;
    }

    public static C16335l6 a(View view) {
        int i = BC5.avatarImg;
        RoundedImageView roundedImageView = (RoundedImageView) AbstractC11738dW7.a(view, i);
        if (roundedImageView != null) {
            i = BC5.bottomToolbar;
            Toolbar toolbar = (Toolbar) AbstractC11738dW7.a(view, i);
            if (toolbar != null) {
                i = BC5.captionToolbar;
                Toolbar toolbar2 = (Toolbar) AbstractC11738dW7.a(view, i);
                if (toolbar2 != null) {
                    i = BC5.captionTxtView;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        i = BC5.dateTxtView;
                        TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView2 != null) {
                            i = BC5.maxDescriptionGuidLine;
                            Guideline guideline = (Guideline) AbstractC11738dW7.a(view, i);
                            if (guideline != null) {
                                i = BC5.nameTxtView;
                                TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                                if (textView3 != null) {
                                    i = BC5.parentPhotoViewerLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                    if (constraintLayout != null) {
                                        i = BC5.photoRecycler;
                                        RecyclerViewFixMotionLayout recyclerViewFixMotionLayout = (RecyclerViewFixMotionLayout) AbstractC11738dW7.a(view, i);
                                        if (recyclerViewFixMotionLayout != null) {
                                            i = BC5.placeHolderLayout;
                                            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
                                            if (linearLayout != null) {
                                                i = BC5.placeHolderTextView;
                                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView4 != null) {
                                                    PullBackLayout pullBackLayout = (PullBackLayout) view;
                                                    i = BC5.tl_photo_viewer;
                                                    BaleToolbar baleToolbar = (BaleToolbar) AbstractC11738dW7.a(view, i);
                                                    if (baleToolbar != null) {
                                                        return new C16335l6(pullBackLayout, roundedImageView, toolbar, toolbar2, textView, textView2, guideline, textView3, constraintLayout, recyclerViewFixMotionLayout, linearLayout, textView4, pullBackLayout, baleToolbar);
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

    public static C16335l6 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C16335l6 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.activity_photo_viewer, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PullBackLayout getRoot() {
        return this.a;
    }
}
