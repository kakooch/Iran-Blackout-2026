package ir.nasim;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.mz2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C17450mz2 implements InterfaceC9764aW7 {
    private final LinearLayout a;
    public final LinearLayout b;
    public final RecyclerView c;
    public final LinearLayout d;
    public final TextView e;

    private C17450mz2(LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, LinearLayout linearLayout3, TextView textView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = recyclerView;
        this.d = linearLayout3;
        this.e = textView;
    }

    public static C17450mz2 a(View view) {
        int i = AbstractC17581nC5.empty_place_holder;
        LinearLayout linearLayout = (LinearLayout) AbstractC11738dW7.a(view, i);
        if (linearLayout != null) {
            i = AbstractC17581nC5.groups_container;
            RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
            if (recyclerView != null) {
                i = AbstractC17581nC5.loadState_container;
                LinearLayout linearLayout2 = (LinearLayout) AbstractC11738dW7.a(view, i);
                if (linearLayout2 != null) {
                    i = AbstractC17581nC5.please_wait_txt;
                    TextView textView = (TextView) AbstractC11738dW7.a(view, i);
                    if (textView != null) {
                        return new C17450mz2((LinearLayout) view, linearLayout, recyclerView, linearLayout2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // ir.nasim.InterfaceC9764aW7
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
