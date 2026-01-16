package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes5.dex */
public final class L65 implements InterfaceC9764aW7 {
    private final MaterialCardView a;
    public final ConstraintLayout b;
    public final ConstraintLayout c;
    public final ImageView d;
    public final TextView e;
    public final MaterialCardView f;
    public final ImageView g;
    public final TextView h;

    private L65(MaterialCardView materialCardView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, MaterialCardView materialCardView2, ImageView imageView2, TextView textView2) {
        this.a = materialCardView;
        this.b = constraintLayout;
        this.c = constraintLayout2;
        this.d = imageView;
        this.e = textView;
        this.f = materialCardView2;
        this.g = imageView2;
        this.h = textView2;
    }

    public static L65 a(View view) {
        int i = BC5.alert_view;
        ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
        if (constraintLayout != null) {
            i = BC5.analysisReportConstraint;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) AbstractC11738dW7.a(view, i);
            if (constraintLayout2 != null) {
                i = BC5.analysisReportIcon;
                ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                if (imageView != null) {
                    i = BC5.analysisReportTitle;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        MaterialCardView materialCardView = (MaterialCardView) view;
                        i = BC5.imageView8;
                        ImageView imageView2 = (ImageView) AbstractC11738dW7.a(view, i);
                        if (imageView2 != null) {
                            i = BC5.textView_title;
                            TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                            if (textView2 != null) {
                                return new L65(materialCardView, constraintLayout, constraintLayout2, imageView, textView, materialCardView, imageView2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static L65 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static L65 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.pfm_more_option_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public MaterialCardView getRoot() {
        return this.a;
    }
}
