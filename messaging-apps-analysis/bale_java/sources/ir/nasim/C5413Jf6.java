package ir.nasim;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Jf6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5413Jf6 extends RecyclerView.C {
    public static final a x = new a(null);
    public static final int y = 8;
    private final C4945Hf6 u;
    private final UA2 v;
    private C4711Gf6 w;

    /* renamed from: ir.nasim.Jf6$a */
    public static final class a {
        private a() {
        }

        public final C5413Jf6 a(C4945Hf6 c4945Hf6, UA2 ua2) {
            AbstractC13042fc3.i(c4945Hf6, "itemView");
            AbstractC13042fc3.i(ua2, "onItemClick");
            return new C5413Jf6(c4945Hf6, ua2);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5413Jf6(C4945Hf6 c4945Hf6, UA2 ua2) {
        super(c4945Hf6.getRoot());
        AbstractC13042fc3.i(c4945Hf6, "binding");
        AbstractC13042fc3.i(ua2, "onItemClick");
        this.u = c4945Hf6;
        this.v = ua2;
        c4945Hf6.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.If6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5413Jf6.D0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(C5413Jf6 c5413Jf6, View view) {
        AbstractC13042fc3.i(c5413Jf6, "this$0");
        C4711Gf6 c4711Gf6 = c5413Jf6.w;
        if (c4711Gf6 != null) {
            c5413Jf6.v.invoke(c4711Gf6);
        }
    }

    public final void E0(C4711Gf6 c4711Gf6, int i) {
        AbstractC13042fc3.i(c4711Gf6, "item");
        this.w = c4711Gf6;
        this.u.c.setText(C5721Ko.a.d().getString(i == 0 ? JD5.search_in_categories_pure : JD5.search_in_categories, c4711Gf6.b()));
        Integer numA = c4711Gf6.a();
        if (numA != null) {
            this.u.b.setImageResource(numA.intValue());
        }
    }
}
