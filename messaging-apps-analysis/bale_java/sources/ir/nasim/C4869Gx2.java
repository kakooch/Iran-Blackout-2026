package ir.nasim;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Gx2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C4869Gx2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final RecyclerView b;
    public final C7796Tf6 c;

    private C4869Gx2(FrameLayout frameLayout, RecyclerView recyclerView, C7796Tf6 c7796Tf6) {
        this.a = frameLayout;
        this.b = recyclerView;
        this.c = c7796Tf6;
    }

    public static C4869Gx2 a(View view) {
        View viewA;
        int i = AbstractC12808fC5.channel_rv;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView == null || (viewA = AbstractC11738dW7.a(view, (i = AbstractC12808fC5.empty_state_container))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new C4869Gx2((FrameLayout) view, recyclerView, C7796Tf6.a(viewA));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
