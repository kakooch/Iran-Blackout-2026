package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.market.model.MarketSlideItem;
import java.util.ArrayList;

/* renamed from: ir.nasim.rT3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20096rT3 extends RecyclerView.h {
    private a d;
    private ArrayList e = new ArrayList();

    /* renamed from: ir.nasim.rT3$a */
    public interface a {
        void U4(MarketSlideItem marketSlideItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(Object obj) {
        AbstractC13042fc3.i(obj, "it");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F(Object obj) {
        AbstractC13042fc3.i(obj, "it");
        return C19938rB7.a;
    }

    public final ArrayList B() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C18323oT3 c18323oT3, int i) {
        AbstractC13042fc3.i(c18323oT3, "holder");
        Object obj = this.e.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c18323oT3.E0((MarketSlideItem) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public C18323oT3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C18323oT3.A.a(viewGroup, this.d, new UA2() { // from class: ir.nasim.pT3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20096rT3.E(obj);
            }
        }, new UA2() { // from class: ir.nasim.qT3
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C20096rT3.F(obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C18323oT3 c18323oT3) {
        AbstractC13042fc3.i(c18323oT3, "holder");
        c18323oT3.a();
    }

    public final void H(a aVar) {
        this.d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AbstractC13042fc3.i(recyclerView, "recyclerView");
        this.d = null;
    }
}
