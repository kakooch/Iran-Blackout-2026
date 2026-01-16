package ir.nasim;

import android.view.View;
import androidx.cardview.widget.CardView;

/* loaded from: classes5.dex */
public final class O50 implements InterfaceC9764aW7 {
    private final CardView a;

    private O50(CardView cardView) {
        this.a = cardView;
    }

    public static O50 a(View view) {
        if (view != null) {
            return new O50((CardView) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CardView getRoot() {
        return this.a;
    }
}
