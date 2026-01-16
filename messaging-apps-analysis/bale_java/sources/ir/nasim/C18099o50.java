package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C12126e50;

/* renamed from: ir.nasim.o50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18099o50 extends RecyclerView.C {
    public static final a w = new a(null);
    private final C12126e50.b u;
    private final C12126e50.c v;

    /* renamed from: ir.nasim.o50$a */
    public static final class a {
        private a() {
        }

        public final C18099o50 a(ViewGroup viewGroup, C12126e50.b bVar, C12126e50.c cVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_card_payment_card_suggest, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C18099o50(viewInflate, bVar, cVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C18099o50(View view, C12126e50.b bVar, C12126e50.c cVar, ED1 ed1) {
        this(view, bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C18099o50 c18099o50, C11483d50 c11483d50, View view) {
        AbstractC13042fc3.i(c18099o50, "this$0");
        AbstractC13042fc3.i(c11483d50, "$suggest");
        C12126e50.c cVar = c18099o50.v;
        if (cVar != null) {
            cVar.p2(c11483d50);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C18099o50 c18099o50, C11483d50 c11483d50, View view) {
        AbstractC13042fc3.i(c18099o50, "this$0");
        AbstractC13042fc3.i(c11483d50, "$suggest");
        C12126e50.b bVar = c18099o50.u;
        if (bVar != null) {
            bVar.t0(c11483d50);
        }
    }

    public final void E0(final C11483d50 c11483d50) {
        AbstractC13042fc3.i(c11483d50, "suggest");
        TextView textView = (TextView) this.a.findViewById(BC5.nameTxt);
        TextView textView2 = (TextView) this.a.findViewById(BC5.cardNumberTxt);
        ImageView imageView = (ImageView) this.a.findViewById(BC5.bankLogo);
        ImageButton imageButton = (ImageButton) this.a.findViewById(BC5.delete);
        textView.setTypeface(C6011Lu2.k());
        textView2.setTypeface(C6011Lu2.k());
        imageView.setImageDrawable(AbstractC4043Dl1.f(this.a.getContext(), c11483d50.b()));
        String strE = c11483d50.e();
        if (strE == null || strE.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(c11483d50.e());
            textView.setVisibility(0);
        }
        textView2.setText(c11483d50.d());
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.m50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C18099o50.F0(this.a, c11483d50, view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.n50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C18099o50.H0(this.a, c11483d50, view);
            }
        });
    }

    private C18099o50(View view, C12126e50.b bVar, C12126e50.c cVar) {
        super(view);
        this.u = bVar;
        this.v = cVar;
    }
}
