package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class D17 extends RecyclerView.h {
    private final B17 d;
    private final List e;

    public D17(List list, B17 b17) {
        AbstractC13042fc3.i(list, "channelList");
        AbstractC13042fc3.i(b17, "suggestionChannelClickListener");
        this.d = b17;
        List list2 = list;
        ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new YN2().a((C14697iL2) it.next()));
        }
        this.e = AbstractC15401jX0.p1(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(D17 d17, int i, C12913fO2 c12913fO2) {
        AbstractC13042fc3.i(d17, "this$0");
        AbstractC13042fc3.i(c12913fO2, "$groupUI");
        d17.e.set(i, C12913fO2.b(c12913fO2, 0, null, null, 0, null, true, 31, null));
        d17.notifyItemChanged(i);
        return C19938rB7.a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(A17 a17, final int i) {
        AbstractC13042fc3.i(a17, "holder");
        final C12913fO2 c12913fO2 = (C12913fO2) this.e.get(i);
        a17.J0(c12913fO2, new SA2() { // from class: ir.nasim.C17
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return D17.B(this.a, i, c12913fO2);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public A17 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.suggestion_channels_item_holder, viewGroup, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return new A17(viewInflate, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }
}
