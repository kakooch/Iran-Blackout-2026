package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C21955uQ3;

/* renamed from: ir.nasim.uQ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21955uQ3 extends RecyclerView.h {
    private final SA2 d;

    /* renamed from: ir.nasim.uQ3$a */
    public static final class a extends RecyclerView.C {
        public static final C1634a w = new C1634a(null);
        public static final int x = 8;
        private final C23871xf3 u;
        private final SA2 v;

        /* renamed from: ir.nasim.uQ3$a$a, reason: collision with other inner class name */
        public static final class C1634a {
            private C1634a() {
            }

            public final a a(ViewGroup viewGroup, SA2 sa2) {
                AbstractC13042fc3.i(viewGroup, "parent");
                AbstractC13042fc3.i(sa2, "onClick");
                C23871xf3 c23871xf3C = C23871xf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                AbstractC13042fc3.h(c23871xf3C, "inflate(...)");
                return new a(c23871xf3C, sa2);
            }

            public /* synthetic */ C1634a(ED1 ed1) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C23871xf3 c23871xf3, SA2 sa2) {
            super(c23871xf3.getRoot());
            AbstractC13042fc3.i(c23871xf3, "binding");
            AbstractC13042fc3.i(sa2, "openUrl");
            this.u = c23871xf3;
            this.v = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void E0(a aVar, View view) {
            AbstractC13042fc3.i(aVar, "this$0");
            aVar.v.invoke();
        }

        public final void D0() {
            this.u.b.setTypeface(C6011Lu2.i());
            this.u.c.setTypeface(C6011Lu2.i());
            this.u.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.tQ3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C21955uQ3.a.E0(this.a, view);
                }
            });
        }
    }

    public C21955uQ3(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "openUrl");
        this.d = sa2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return a.w.a(viewGroup, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
        aVar.D0();
    }
}
