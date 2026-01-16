package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C12950fS3;

/* renamed from: ir.nasim.kT3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C15959kT3 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private final C6111Mf3 u;
    private final C12950fS3.c v;

    /* renamed from: ir.nasim.kT3$a */
    public static final class a {
        private a() {
        }

        private final void b(C6111Mf3 c6111Mf3) {
            c6111Mf3.c.setTypeface(C6011Lu2.k());
        }

        public final C15959kT3 a(ViewGroup viewGroup, C12950fS3.c cVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C6111Mf3 c6111Mf3C = C6111Mf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c6111Mf3C, "inflate(...)");
            b(c6111Mf3C);
            return new C15959kT3(c6111Mf3C, cVar);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15959kT3(C6111Mf3 c6111Mf3, C12950fS3.c cVar) {
        super(c6111Mf3.getRoot());
        AbstractC13042fc3.i(c6111Mf3, "binding");
        this.u = c6111Mf3;
        this.v = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(C15959kT3 c15959kT3, C17132mS3 c17132mS3, View view) {
        AbstractC13042fc3.i(c15959kT3, "this$0");
        AbstractC13042fc3.i(c17132mS3, "$item");
        C12950fS3.c cVar = c15959kT3.v;
        if (cVar != null) {
            cVar.g3(c17132mS3);
        }
    }

    public final void D0(final C17132mS3 c17132mS3) {
        AbstractC13042fc3.i(c17132mS3, "item");
        this.u.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jT3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C15959kT3.E0(this.a, c17132mS3, view);
            }
        });
    }
}
