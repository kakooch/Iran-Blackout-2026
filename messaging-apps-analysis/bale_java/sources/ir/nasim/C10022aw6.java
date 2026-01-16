package ir.nasim;

import android.view.View;
import android.widget.Switch;

/* renamed from: ir.nasim.aw6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10022aw6 extends C20981sv6 {
    private final Switch z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10022aw6(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        View viewFindViewById = view.findViewById(BC5.setting_row_switch);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        this.z = (Switch) viewFindViewById;
    }

    public final Switch H0() {
        return this.z;
    }
}
