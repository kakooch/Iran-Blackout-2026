package ir.nasim;

import android.view.View;
import android.widget.TextView;

/* loaded from: classes6.dex */
public final class HO4 extends KQ4 {
    private final SQ4 v;
    private final View w;
    private final TextView x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HO4(View view, SQ4 sq4) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        this.v = sq4;
        View viewFindViewById = view.findViewById(BC5.inner_container);
        this.w = viewFindViewById;
        TextView textView = (TextView) view.findViewById(BC5.tag_title);
        this.x = textView;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewFindViewById.setBackgroundColor(c5495Jo7.X());
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GO4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HO4.H0(this.a, view2);
            }
        });
        textView.setTypeface(C6011Lu2.i());
        textView.setTextSize(14.0f);
        textView.setTextColor(c5495Jo7.h0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(HO4 ho4, View view) {
        AbstractC13042fc3.i(ho4, "this$0");
        SQ4 sq4 = ho4.v;
        if (sq4 != null) {
            sq4.U0();
        }
    }
}
