package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.attach.model.BankAttachment;
import java.util.ArrayList;

/* renamed from: ir.nasim.p40, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C18680p40 extends RecyclerView.h {
    private a d;
    private ArrayList e = new ArrayList();

    /* renamed from: ir.nasim.p40$a */
    public interface a {
        void c(BankAttachment bankAttachment);
    }

    public C18680p40(a aVar) {
        this.d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C19862r40 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C19862r40.w.a(viewGroup, this.d);
    }

    public final void B(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.e = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C19862r40 c19862r40, int i) {
        AbstractC13042fc3.i(c19862r40, "holder");
        Object obj = this.e.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c19862r40.E0((BankAttachment) obj);
    }
}
