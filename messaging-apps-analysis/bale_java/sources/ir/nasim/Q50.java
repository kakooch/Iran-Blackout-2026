package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.payment.data.response.Bank;

/* loaded from: classes6.dex */
public final class Q50 extends RecyclerView.C {
    public static final a u = new a(null);

    public static final class a {
        private a() {
        }

        public final Q50 a(ViewGroup viewGroup) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_card_payment_bank_logo_slider, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new Q50(viewInflate, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ Q50(View view, ED1 ed1) {
        this(view);
    }

    public final void C0(Bank bank) {
        AbstractC13042fc3.i(bank, "bank");
        Integer drawableId = bank.getDrawableId();
        if (drawableId != null) {
            ((ImageView) this.a.findViewById(BC5.logo)).setImageDrawable(AbstractC4043Dl1.f(this.a.getContext(), drawableId.intValue()));
        }
    }

    private Q50(View view) {
        super(view);
    }
}
