package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14056hH;

/* renamed from: ir.nasim.jH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15256jH extends RecyclerView.C {
    public static final a v = new a(null);
    public static final int w = 8;
    private final C14056hH.b u;

    /* renamed from: ir.nasim.jH$a */
    public static final class a {
        private a() {
        }

        public final C15256jH a(ViewGroup viewGroup, C14056hH.b bVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.item_arbaeen_mobile_suggest_button, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C15256jH(viewInflate, bVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C15256jH(View view, C14056hH.b bVar, ED1 ed1) {
        this(view, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C15256jH c15256jH, C13465gH c13465gH, View view) {
        AbstractC13042fc3.i(c15256jH, "this$0");
        AbstractC13042fc3.i(c13465gH, "$button");
        C14056hH.b bVar = c15256jH.u;
        if (bVar != null) {
            bVar.j2(c13465gH);
        }
    }

    public final void D0(final C13465gH c13465gH) {
        AbstractC13042fc3.i(c13465gH, "button");
        this.a.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iH
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15256jH.E0(this.a, c13465gH, view);
            }
        });
    }

    private C15256jH(View view, C14056hH.b bVar) {
        super(view);
        this.u = bVar;
    }
}
