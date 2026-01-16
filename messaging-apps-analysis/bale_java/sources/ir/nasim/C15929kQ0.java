package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;

/* renamed from: ir.nasim.kQ0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15929kQ0 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final MaterialCardView b;
    public final LottieAnimationView c;
    public final TextView d;

    private C15929kQ0(ConstraintLayout constraintLayout, MaterialCardView materialCardView, LottieAnimationView lottieAnimationView, TextView textView) {
        this.a = constraintLayout;
        this.b = materialCardView;
        this.c = lottieAnimationView;
        this.d = textView;
    }

    public static C15929kQ0 a(View view) {
        int i = BC5.chat_peer_empty_cv;
        MaterialCardView materialCardView = (MaterialCardView) AbstractC11738dW7.a(view, i);
        if (materialCardView != null) {
            i = BC5.chat_peer_empty_lottie;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
            if (lottieAnimationView != null) {
                i = BC5.chat_peer_empty_tv;
                TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                if (textView != null) {
                    return new C15929kQ0((ConstraintLayout) view, materialCardView, lottieAnimationView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C15929kQ0 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC12208eD5.chat_peer_empty_view, viewGroup, false);
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
