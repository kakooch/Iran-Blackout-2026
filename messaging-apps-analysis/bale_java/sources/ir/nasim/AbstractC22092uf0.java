package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.uf0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC22092uf0 extends RecyclerView.C {
    protected final View u;
    protected final FrameLayout v;

    public AbstractC22092uf0(View view) {
        super(view);
        this.u = view;
        if (view instanceof FrameLayout) {
            this.v = (FrameLayout) view;
        } else {
            this.v = null;
        }
    }
}
