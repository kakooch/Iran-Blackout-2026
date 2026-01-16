package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;

/* renamed from: ir.nasim.Ng2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6358Ng2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TextView c;
    public final LottieAnimationView d;

    private C6358Ng2(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, LottieAnimationView lottieAnimationView) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = textView;
        this.d = lottieAnimationView;
    }

    public static C6358Ng2 a(View view) {
        int i = AbstractC12808fC5.album_rv;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC12808fC5.feed_album_text;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC12808fC5.feed_reaction_anim;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) AbstractC11738dW7.a(view, i);
                if (lottieAnimationView != null) {
                    return new C6358Ng2((ConstraintLayout) view, recyclerView, textView, lottieAnimationView);
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
