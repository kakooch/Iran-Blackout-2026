package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: ir.nasim.bQ1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C10298bQ1 extends AbstractC21435tf0 {
    private final HashSet g;
    private final InterfaceC22483vJ4 h;
    private final Context i;
    private final C22042ua0 j;
    private AJ4 k;
    private List l;

    public C10298bQ1(C19024pf0 c19024pf0, InterfaceC22483vJ4 interfaceC22483vJ4, Context context, C22042ua0 c22042ua0, AJ4 aj4) {
        super(c19024pf0, true);
        this.g = new HashSet();
        this.l = new ArrayList();
        this.i = context;
        this.h = interfaceC22483vJ4;
        this.j = c22042ua0;
        this.k = aj4;
    }

    private void Q(C17067mL1 c17067mL1) {
        int peerId = c17067mL1.R().getPeerId();
        if (c17067mL1.getExPeerType() != ExPeerType.PRIVATE || this.g.contains(Integer.valueOf(peerId))) {
            return;
        }
        this.g.add(Integer.valueOf(peerId));
    }

    @Override // ir.nasim.AbstractC21435tf0
    public void B() {
        super.B();
        R();
    }

    public void J() {
        this.l.clear();
    }

    @Override // ir.nasim.AbstractC21435tf0
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public void G(C20649sN1 c20649sN1, int i, C17067mL1 c17067mL1) {
        Q(c17067mL1);
        boolean z = this.l.size() > 0;
        c20649sN1.H0(c17067mL1, i == getItemCount() - 1, Boolean.valueOf(this.l.contains(Long.valueOf(c17067mL1.R().u()))), Boolean.valueOf(z), this.k);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public C20649sN1 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new C20649sN1(this.i, new FrameLayout(this.i), this.h, this.j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(C20649sN1 c20649sN1) {
        super.onViewAttachedToWindow(c20649sN1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(C20649sN1 c20649sN1) {
        super.onViewDetachedFromWindow(c20649sN1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C20649sN1 c20649sN1) {
        c20649sN1.a();
    }

    public void P(List list) {
        this.l.clear();
        this.l.addAll(list);
    }

    public void R() {
        ArrayList arrayList = new ArrayList(this.g);
        C5735Kp4.w().i().c1(arrayList);
        this.g.removeAll(arrayList);
    }
}
