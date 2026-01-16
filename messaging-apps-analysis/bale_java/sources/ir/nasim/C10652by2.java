package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.by2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10652by2 implements InterfaceC9764aW7 {
    private final FrameLayout a;
    public final RecyclerView b;
    public final LinearLayout c;

    private C10652by2(FrameLayout frameLayout, RecyclerView recyclerView, LinearLayout linearLayout) {
        this.a = frameLayout;
        this.b = recyclerView;
        this.c = linearLayout;
    }

    public static C10652by2 a(View view) {
        int i = AbstractC10792cC5.dialogsList;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC10792cC5.emptyStatePlaceHolder;
            LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
            if (linearLayout != null) {
                return new C10652by2((FrameLayout) view, recyclerView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C10652by2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(AbstractC11565dD5.fragment_dialog_list_tab, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
