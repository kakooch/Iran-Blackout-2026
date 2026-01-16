package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Ku6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC5782Ku6 extends RecyclerView.C {
    public C21668tv6 u;
    private final View v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC5782Ku6(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.v = view.findViewById(BC5.setting_row_bottom_divider_view);
    }

    public abstract void C0(C21668tv6 c21668tv6);

    public final View D0() {
        return this.v;
    }

    public final void E0(C21668tv6 c21668tv6) {
        AbstractC13042fc3.i(c21668tv6, "<set-?>");
        this.u = c21668tv6;
    }
}
