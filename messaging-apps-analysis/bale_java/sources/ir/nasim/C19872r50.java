package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C13353g50;
import ir.nasim.features.payment.data.model.BankCreditCard;
import ir.nasim.features.payment.data.response.Bank;

/* renamed from: ir.nasim.r50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19872r50 extends RecyclerView.C {
    public static final a w = new a(null);
    private final C13353g50.d u;
    private final C13353g50.e v;

    /* renamed from: ir.nasim.r50$a */
    public static final class a {
        private a() {
        }

        public final C19872r50 a(ViewGroup viewGroup, C13353g50.d dVar, C13353g50.e eVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_card_payment_card_suggest, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C19872r50(viewInflate, dVar, eVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C19872r50(View view, C13353g50.d dVar, C13353g50.e eVar, ED1 ed1) {
        this(view, dVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C19872r50 c19872r50, BankCreditCard bankCreditCard, View view) {
        AbstractC13042fc3.i(c19872r50, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        C13353g50.e eVar = c19872r50.v;
        if (eVar != null) {
            eVar.i5(bankCreditCard);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C19872r50 c19872r50, BankCreditCard bankCreditCard, View view) {
        AbstractC13042fc3.i(c19872r50, "this$0");
        AbstractC13042fc3.i(bankCreditCard, "$card");
        C13353g50.d dVar = c19872r50.u;
        if (dVar != null) {
            dVar.Z0(bankCreditCard);
        }
    }

    public final void E0(final BankCreditCard bankCreditCard) {
        Integer drawableId;
        AbstractC13042fc3.i(bankCreditCard, ParameterNames.CARD);
        TextView textView = (TextView) this.a.findViewById(BC5.nameTxt);
        TextView textView2 = (TextView) this.a.findViewById(BC5.cardNumberTxt);
        ImageView imageView = (ImageView) this.a.findViewById(BC5.bankLogo);
        ImageButton imageButton = (ImageButton) this.a.findViewById(BC5.delete);
        textView.setTypeface(C6011Lu2.k());
        textView2.setTypeface(C6011Lu2.k());
        Bank bank = bankCreditCard.getBank();
        imageView.setImageDrawable((bank == null || (drawableId = bank.getDrawableId()) == null) ? null : AbstractC4043Dl1.f(this.a.getContext(), drawableId.intValue()));
        String ownerName = bankCreditCard.getOwnerName();
        if (ownerName == null || ownerName.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(bankCreditCard.getOwnerName());
            textView.setVisibility(0);
        }
        textView2.setText(XY6.e(bankCreditCard.getSpacedNumber()));
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.p50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19872r50.F0(this.a, bankCreditCard, view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.q50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C19872r50.H0(this.a, bankCreditCard, view);
            }
        });
    }

    private C19872r50(View view, C13353g50.d dVar, C13353g50.e eVar) {
        super(view);
        this.u = dVar;
        this.v = eVar;
    }
}
