package ir.nasim;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.ld0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC16640ld0 extends RecyclerView.C {
    private Context u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC16640ld0(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        Context context = view.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        this.u = context;
    }

    public final Context C0() {
        return this.u;
    }
}
