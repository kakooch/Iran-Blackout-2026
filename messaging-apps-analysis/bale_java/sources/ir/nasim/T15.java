package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes5.dex */
public final class T15 extends AbstractC21435tf0 {
    private final InterfaceC22483vJ4 g;
    private final InterfaceC22483vJ4 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public T15(C19024pf0 c19024pf0, InterfaceC22483vJ4 interfaceC22483vJ4, InterfaceC22483vJ4 interfaceC22483vJ42) {
        super(c19024pf0);
        AbstractC13042fc3.i(c19024pf0, "bindedDisplayList");
        AbstractC13042fc3.i(interfaceC22483vJ4, "onItemClickedListener");
        AbstractC13042fc3.i(interfaceC22483vJ42, "onItemProfileClickedListener");
        this.g = interfaceC22483vJ4;
        this.h = interfaceC22483vJ42;
    }

    @Override // ir.nasim.AbstractC21435tf0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void G(S15 s15, int i, P15 p15) {
        if (p15 == null || s15 == null) {
            return;
        }
        s15.H0(p15);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public S15 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.payment_detail_item_layout, viewGroup, false);
        viewInflate.setBackgroundDrawable(AbstractC4310Eo7.k(true));
        AbstractC13042fc3.h(viewInflate, "apply(...)");
        return new S15(viewInflate, this.g, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(S15 s15) {
        AbstractC13042fc3.i(s15, "dialogHolder");
        s15.a();
    }
}
