package ir.nasim;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public final class X74 extends androidx.recyclerview.widget.h {
    public X74() {
        V(false);
        w(60L);
    }

    @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.x
    public boolean B(RecyclerView.C c) {
        AbstractC13042fc3.i(c, "holder");
        super.B(c);
        View view = c.a;
        AbstractC13042fc3.h(view, "itemView");
        ViewParent parent = view.getParent();
        AbstractC13042fc3.g(parent, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) parent;
        if (c.K() != 0) {
            return true;
        }
        view.setTranslationY(recyclerView.getHeight() - view.getTop());
        return true;
    }
}
