package ir.nasim;

import androidx.fragment.app.Fragment;
import java.util.List;

/* renamed from: ir.nasim.px4, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C19207px4 extends AbstractC20423rz2 {
    private final DS6 l;
    private List m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C19207px4(C22042ua0 c22042ua0, DS6 ds6, List list) {
        super(c22042ua0);
        AbstractC13042fc3.i(c22042ua0, "fragment");
        AbstractC13042fc3.i(ds6, "listener");
        AbstractC13042fc3.i(list, "storyList");
        this.l = ds6;
        this.m = list;
    }

    @Override // ir.nasim.AbstractC20423rz2
    public Fragment B(int i) {
        return C24936zS6.w1.a((QQ6) this.m.get(i), i, this.l, i == 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.m.size();
    }
}
