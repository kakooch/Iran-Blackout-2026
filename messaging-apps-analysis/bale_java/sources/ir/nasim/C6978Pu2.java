package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Pu2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6978Pu2 extends RecyclerView.C {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6978Pu2(View view, final OP1 op1, final InterfaceC14603iB2 interfaceC14603iB2) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        AbstractC13042fc3.i(op1, "dialogType");
        AbstractC13042fc3.i(interfaceC14603iB2, "sendSerajEvent");
        if (op1 == OP1.GROUP) {
            ((TextView) view.findViewById(BC5.text_footer)).setText(AbstractC12217eE5.view_more_groups);
        }
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        view.setBackground(AbstractC4310Eo7.i(c5495Jo7.O0(), c5495Jo7.n0()));
        view.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ou2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C6978Pu2.D0(this.a, op1, interfaceC14603iB2, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(C6978Pu2 c6978Pu2, OP1 op1, InterfaceC14603iB2 interfaceC14603iB2, View view) {
        AbstractC13042fc3.i(c6978Pu2, "this$0");
        AbstractC13042fc3.i(op1, "$dialogType");
        AbstractC13042fc3.i(interfaceC14603iB2, "$sendSerajEvent");
        c6978Pu2.E0(op1, interfaceC14603iB2);
        C18987pb3.a.c0(false);
    }

    private final void E0(OP1 op1, InterfaceC14603iB2 interfaceC14603iB2) {
        if (op1 == OP1.GROUP) {
            interfaceC14603iB2.invoke("Recommended_group_click", AbstractC20051rO3.n(AbstractC4616Fw7.a("action_type", 1), AbstractC4616Fw7.a("peer_type", "GROUP")));
        }
    }
}
