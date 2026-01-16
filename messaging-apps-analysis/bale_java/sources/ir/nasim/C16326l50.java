package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C13353g50;

/* renamed from: ir.nasim.l50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16326l50 extends RecyclerView.C {
    public static final a v = new a(null);
    public static final int w = 8;
    private final C13353g50.c u;

    /* renamed from: ir.nasim.l50$a */
    public static final class a {
        private a() {
        }

        public final C16326l50 a(ViewGroup viewGroup, C13353g50.c cVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_card_payment_card_suggest_button, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C16326l50(viewInflate, cVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C16326l50(View view, C13353g50.c cVar, ED1 ed1) {
        this(view, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C16326l50 c16326l50, C13944h50 c13944h50, View view) {
        AbstractC13042fc3.i(c16326l50, "this$0");
        AbstractC13042fc3.i(c13944h50, "$button");
        C13353g50.c cVar = c16326l50.u;
        if (cVar != null) {
            cVar.t(c13944h50);
        }
    }

    public final void D0(final C13944h50 c13944h50) {
        AbstractC13042fc3.i(c13944h50, "button");
        TextView textView = (TextView) this.a.findViewById(BC5.title);
        textView.setTypeface(C6011Lu2.i());
        textView.setText(c13944h50.b());
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.k50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C16326l50.E0(this.a, c13944h50, view);
            }
        });
    }

    private C16326l50(View view, C13353g50.c cVar) {
        super(view);
        this.u = cVar;
    }
}
