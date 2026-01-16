package ir.nasim;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: ir.nasim.sv6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C20981sv6 extends AbstractC5782Ku6 {
    private final TextView w;
    private final TextView x;
    private final ImageView y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20981sv6(View view) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        View viewFindViewById = view.findViewById(BC5.setting_row_tv_title);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        this.w = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(BC5.setting_row_tv_subtitle);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        this.x = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(BC5.setting_row_icon);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        this.y = (ImageView) viewFindViewById3;
    }

    @Override // ir.nasim.AbstractC5782Ku6
    public void C0(C21668tv6 c21668tv6) {
        AbstractC13042fc3.i(c21668tv6, "item");
        E0(c21668tv6);
        View view = this.a;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        view.setBackgroundColor(c5495Jo7.O0());
        if (c21668tv6.a() != 0) {
            this.y.setVisibility(0);
            this.y.setImageResource(c21668tv6.a());
        } else {
            this.y.setVisibility(8);
        }
        if (c21668tv6.e().length() > 0) {
            this.w.setVisibility(0);
            this.w.setText(c21668tv6.e());
            this.w.setTypeface(C6011Lu2.k());
            this.w.setTextSize(1, 15.0f);
            this.w.setTextColor(c5495Jo7.g1());
        } else {
            this.w.setVisibility(8);
        }
        if (c21668tv6.d().length() > 0) {
            this.x.setVisibility(0);
            this.x.setText(c21668tv6.d());
            this.x.setTypeface(C6011Lu2.k());
            this.x.setTextSize(1, 14.0f);
            this.x.setTextColor(c5495Jo7.f1());
        } else {
            this.x.setVisibility(8);
        }
        View viewD0 = D0();
        if (viewD0 != null) {
            viewD0.setBackgroundColor(c5495Jo7.a1());
        }
    }

    public final TextView F0() {
        return this.x;
    }
}
