package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.ey2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C12650ey2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialButton b;
    public final TextView c;
    public final TextView d;
    public final ImageView e;
    public final TextView f;
    public final MaterialButton g;
    public final ConstraintLayout h;
    public final C18523oo0 i;
    public final MaterialCardView j;
    public final MaterialCardView k;
    public final FrameLayout l;
    public final TextView m;

    private C12650ey2(ConstraintLayout constraintLayout, MaterialButton materialButton, TextView textView, TextView textView2, ImageView imageView, TextView textView3, MaterialButton materialButton2, ConstraintLayout constraintLayout2, C18523oo0 c18523oo0, MaterialCardView materialCardView, MaterialCardView materialCardView2, FrameLayout frameLayout, TextView textView4) {
        this.a = constraintLayout;
        this.b = materialButton;
        this.c = textView;
        this.d = textView2;
        this.e = imageView;
        this.f = textView3;
        this.g = materialButton2;
        this.h = constraintLayout2;
        this.i = c18523oo0;
        this.j = materialCardView;
        this.k = materialCardView2;
        this.l = frameLayout;
        this.m = textView4;
    }

    public static C12650ey2 a(View view) {
        View viewA;
        int i = BC5.cancelBtn;
        MaterialButton materialButton = (MaterialButton) AbstractC11738dW7.a(view, i);
        if (materialButton != null) {
            i = BC5.cardNumberDescText;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = BC5.cardNumberText;
                TextView textView2 = (TextView) AbstractC11738dW7.a(view, i);
                if (textView2 != null) {
                    i = BC5.copyImg;
                    ImageView imageView = (ImageView) AbstractC11738dW7.a(view, i);
                    if (imageView != null) {
                        i = BC5.description;
                        TextView textView3 = (TextView) AbstractC11738dW7.a(view, i);
                        if (textView3 != null) {
                            i = BC5.enrollmentBtn;
                            MaterialButton materialButton2 = (MaterialButton) AbstractC11738dW7.a(view, i);
                            if (materialButton2 != null) {
                                i = BC5.enrollment_container;
                                ConstraintLayout constraintLayout = (ConstraintLayout) AbstractC11738dW7.a(view, i);
                                if (constraintLayout != null && (viewA = AbstractC11738dW7.a(view, (i = BC5.loading_enrollment))) != null) {
                                    C18523oo0 c18523oo0A = C18523oo0.a(viewA);
                                    i = BC5.materialCardView;
                                    MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                    if (materialCardView != null) {
                                        i = BC5.materialCardView2;
                                        MaterialCardView materialCardView2 = (MaterialCardView) AbstractC11738dW7.a(view, i);
                                        if (materialCardView2 != null) {
                                            i = BC5.snackbar_container;
                                            FrameLayout frameLayout = (FrameLayout) AbstractC11738dW7.a(view, i);
                                            if (frameLayout != null) {
                                                i = BC5.title;
                                                TextView textView4 = (TextView) AbstractC11738dW7.a(view, i);
                                                if (textView4 != null) {
                                                    return new C12650ey2((ConstraintLayout) view, materialButton, textView, textView2, imageView, textView3, materialButton2, constraintLayout, c18523oo0A, materialCardView, materialCardView2, frameLayout, textView4);
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

    public static C12650ey2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.fragment_enrollment_card, viewGroup, false);
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
