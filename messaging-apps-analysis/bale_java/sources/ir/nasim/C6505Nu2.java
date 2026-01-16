package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.Nu2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C6505Nu2 extends RecyclerView.h {
    private boolean d;

    /* renamed from: ir.nasim.Nu2$a */
    public static final class a extends RecyclerView.C {
        private final View u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            AbstractC13042fc3.i(view, "view");
            this.u = view;
        }

        public final void C0(boolean z) {
            this.u.setVisibility(z ? 0 : 8);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.footer_item, viewGroup, false);
        AbstractC13042fc3.f(viewInflate);
        return new a(viewInflate);
    }

    public final void B(boolean z) {
        this.d = z;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        AbstractC13042fc3.i(aVar, "holder");
        aVar.C0(this.d);
    }
}
