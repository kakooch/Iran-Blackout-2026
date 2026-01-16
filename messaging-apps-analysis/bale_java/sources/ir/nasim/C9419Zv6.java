package ir.nasim;

import android.view.View;
import android.widget.TextView;

/* renamed from: ir.nasim.Zv6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C9419Zv6 extends AbstractC5782Ku6 {
    private final TextView w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9419Zv6(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        View viewFindViewById = view.findViewById(BC5.setting_row_tv_title);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        this.w = (TextView) viewFindViewById;
    }

    @Override // ir.nasim.AbstractC5782Ku6
    public void C0(C21668tv6 c21668tv6) {
        AbstractC13042fc3.i(c21668tv6, "item");
        E0(c21668tv6);
        this.w.setVisibility(8);
        if (c21668tv6.e().length() > 0) {
            this.w.setVisibility(0);
            this.w.setText(c21668tv6.e());
            this.w.setTypeface(C6011Lu2.k());
            this.w.setTextSize(1, 14.0f);
            this.w.setTextColor(C5495Jo7.a.b1());
        }
        this.a.setBackgroundColor(C5495Jo7.a.a1());
    }
}
