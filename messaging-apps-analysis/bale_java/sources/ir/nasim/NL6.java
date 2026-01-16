package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.payment.data.model.StatementItem;

/* loaded from: classes6.dex */
public final class NL6 extends RecyclerView.C {
    public static final a u = new a(null);

    public static final class a {
        private a() {
        }

        public final NL6 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_card_payment_statement, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new NL6(viewInflate, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ NL6(View view, ED1 ed1) {
        this(view);
    }

    public final void C0(StatementItem statementItem) {
        AbstractC13042fc3.i(statementItem, "statementItem");
        TextView textView = (TextView) this.a.findViewById(BC5.amountTitleTxt);
        TextView textView2 = (TextView) this.a.findViewById(BC5.dateTitleTxt);
        TextView textView3 = (TextView) this.a.findViewById(BC5.amountTxt);
        TextView textView4 = (TextView) this.a.findViewById(BC5.dateTxt);
        TextView textView5 = (TextView) this.a.findViewById(BC5.descriptionTxt);
        ImageView imageView = (ImageView) this.a.findViewById(BC5.symbolImg);
        textView.setTypeface(C6011Lu2.i());
        textView2.setTypeface(C6011Lu2.i());
        textView3.setTypeface(C6011Lu2.i());
        textView4.setTypeface(C6011Lu2.i());
        textView5.setTypeface(C6011Lu2.k());
        imageView.setImageDrawable(AbstractC4043Dl1.f(this.a.getContext(), statementItem.getIsDeposit() ? KB5.card_transaction_up : KB5.card_transaction_down));
        textView3.setTextColor(statementItem.getIsDeposit() ? C5495Jo7.a.e2() : C5495Jo7.a.B0());
        String amount = statementItem.getAmount();
        textView3.setText(this.a.getContext().getString(AbstractC12217eE5.card_payment_rial_param, XY6.e(amount != null ? GY6.g(amount) : null)));
        textView4.setText(XY6.e(statementItem.getDate()));
        textView5.setText(statementItem.getDescription());
    }

    private NL6(View view) {
        super(view);
    }
}
