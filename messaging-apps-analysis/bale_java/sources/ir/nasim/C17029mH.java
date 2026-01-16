package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14056hH;

/* renamed from: ir.nasim.mH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17029mH extends RecyclerView.C {
    public static final a w = new a(null);
    private final C14056hH.c u;
    private final C14056hH.d v;

    /* renamed from: ir.nasim.mH$a */
    public static final class a {
        private a() {
        }

        public final C17029mH a(ViewGroup viewGroup, C14056hH.c cVar, C14056hH.d dVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_arbaeen_mobile_suggest, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C17029mH(viewInflate, cVar, dVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C17029mH(View view, C14056hH.c cVar, C14056hH.d dVar, ED1 ed1) {
        this(view, cVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C17029mH c17029mH, C12847fH c12847fH, View view) {
        AbstractC13042fc3.i(c17029mH, "this$0");
        AbstractC13042fc3.i(c12847fH, "$item");
        C14056hH.d dVar = c17029mH.v;
        if (dVar != null) {
            dVar.B4(c12847fH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C17029mH c17029mH, C12847fH c12847fH, View view) {
        AbstractC13042fc3.i(c17029mH, "this$0");
        AbstractC13042fc3.i(c12847fH, "$item");
        C14056hH.c cVar = c17029mH.u;
        if (cVar != null) {
            cVar.D2(c12847fH);
        }
    }

    public final void E0(final C12847fH c12847fH) {
        AbstractC13042fc3.i(c12847fH, "item");
        C6102Me3 c6102Me3A = C6102Me3.a(this.a);
        AbstractC13042fc3.h(c6102Me3A, "bind(...)");
        c6102Me3A.c.setText(XY6.e(c12847fH.b()));
        c6102Me3A.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17029mH.F0(this.a, c12847fH, view);
            }
        });
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17029mH.H0(this.a, c12847fH, view);
            }
        });
    }

    private C17029mH(View view, C14056hH.c cVar, C14056hH.d dVar) {
        super(view);
        this.u = cVar;
        this.v = dVar;
    }
}
