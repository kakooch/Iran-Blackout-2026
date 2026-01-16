package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C12126e50;

/* renamed from: ir.nasim.j50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15144j50 extends RecyclerView.C {
    public static final a v = new a(null);
    public static final int w = 8;
    private final C12126e50.d u;

    /* renamed from: ir.nasim.j50$a */
    public static final class a {
        private a() {
        }

        public final C15144j50 a(ViewGroup viewGroup, C12126e50.d dVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_card_payment_card_suggest_button, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C15144j50(viewInflate, dVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C15144j50(View view, C12126e50.d dVar, ED1 ed1) {
        this(view, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C15144j50 c15144j50, C13944h50 c13944h50, View view) {
        AbstractC13042fc3.i(c15144j50, "this$0");
        AbstractC13042fc3.i(c13944h50, "$button");
        C12126e50.d dVar = c15144j50.u;
        if (dVar != null) {
            dVar.t(c13944h50);
        }
    }

    public final void D0(final C13944h50 c13944h50) {
        AbstractC13042fc3.i(c13944h50, "button");
        TextView textView = (TextView) this.a.findViewById(BC5.title);
        textView.setTypeface(C6011Lu2.i());
        textView.setText(c13944h50.b());
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.i50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15144j50.E0(this.a, c13944h50, view);
            }
        });
    }

    private C15144j50(View view, C12126e50.d dVar) {
        super(view);
        this.u = dVar;
    }
}
