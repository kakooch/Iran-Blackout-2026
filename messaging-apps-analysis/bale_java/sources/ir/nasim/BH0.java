package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes5.dex */
public final class BH0 extends RecyclerView.C {
    private final View u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private TextView y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BH0(View view) {
        super(view);
        AbstractC13042fc3.i(view, "item");
        this.u = view;
        View view2 = this.a;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        view2.setBackgroundColor(c5495Jo7.O0());
        View viewFindViewById = view.findViewById(BC5.amount_pair);
        TextView textView = (TextView) viewFindViewById.findViewById(BC5.title);
        textView.setTypeface(C6011Lu2.i());
        textView.setTextSize(15.0f);
        textView.setTextColor(c5495Jo7.g1());
        this.v = textView;
        TextView textView2 = (TextView) viewFindViewById.findViewById(BC5.label);
        textView2.setText(textView2.getContext().getString(AbstractC12217eE5.card_statement_amount));
        textView2.setTypeface(C6011Lu2.i());
        textView2.setTextSize(14.0f);
        textView2.setTextColor(c5495Jo7.f1());
        textView2.setTextDirection(4);
        View viewFindViewById2 = view.findViewById(BC5.date_pair);
        TextView textView3 = (TextView) viewFindViewById2.findViewById(BC5.title);
        textView3.setTypeface(C6011Lu2.i());
        textView3.setTextSize(15.0f);
        textView3.setTextColor(c5495Jo7.g1());
        this.w = textView3;
        TextView textView4 = (TextView) viewFindViewById2.findViewById(BC5.label);
        textView4.setText(textView4.getContext().getString(AbstractC12217eE5.card_statement_date));
        textView4.setTypeface(C6011Lu2.i());
        textView4.setTextSize(14.0f);
        textView4.setTextColor(c5495Jo7.f1());
        this.x = (ImageView) view.findViewById(BC5.image_view);
        this.y = (TextView) view.findViewById(BC5.description_text_view);
    }

    public final void C0(C19014pe0 c19014pe0) {
        AbstractC13042fc3.i(c19014pe0, ParameterNames.INFO);
        if (AbstractC13042fc3.d(c19014pe0.d(), "-")) {
            this.v.setTextColor(C5495Jo7.a.B0());
            this.x.setImageResource(KB5.card_transaction_down);
        } else if (AbstractC13042fc3.d(c19014pe0.d(), "+")) {
            this.v.setTextColor(C5495Jo7.a.e2());
            this.x.setImageResource(KB5.card_transaction_up);
        }
        this.v.setText(XY6.e(XY6.c(c19014pe0.a(), (char) 0, 2, null)) + " ریال");
        this.v.setTextDirection(4);
        this.w.setText(XY6.e(c19014pe0.b()));
        this.y.setText(c19014pe0.c());
    }
}
