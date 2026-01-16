package ir.nasim;

import android.view.ViewGroup;

/* renamed from: ir.nasim.e74, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12150e74 extends AbstractC21435tf0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12150e74(C19024pf0 c19024pf0) {
        super(c19024pf0);
        AbstractC13042fc3.i(c19024pf0, "bindedDisplayList");
    }

    @Override // ir.nasim.AbstractC21435tf0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void G(C13377g74 c13377g74, int i, P15 p15) {
        if (p15 == null || c13377g74 == null) {
            return;
        }
        c13377g74.D0(p15);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public C13377g74 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "viewGroup");
        return C13377g74.B.a(viewGroup);
    }
}
