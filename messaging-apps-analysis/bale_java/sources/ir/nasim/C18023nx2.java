package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.nx2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C18023nx2 implements InterfaceC9764aW7 {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final TextView c;
    public final EditText d;

    private C18023nx2(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, EditText editText) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = textView;
        this.d = editText;
    }

    public static C18023nx2 a(View view) {
        int i = AbstractC18172oC5.add_text_color_picker_recycler_view;
        RecyclerView recyclerView = (RecyclerView) AbstractC11738dW7.a(view, i);
        if (recyclerView != null) {
            i = AbstractC18172oC5.add_text_done_tv;
            TextView textView = (TextView) AbstractC11738dW7.a(view, i);
            if (textView != null) {
                i = AbstractC18172oC5.add_text_edit_text;
                EditText editText = (EditText) AbstractC11738dW7.a(view, i);
                if (editText != null) {
                    return new C18023nx2((ConstraintLayout) view, recyclerView, textView, editText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static C18023nx2 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(RC5.fragment_add_text, viewGroup, false);
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
