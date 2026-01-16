package ir.nasim;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.Bh3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3541Bh3 extends AbstractC20423rz2 {
    private List l;
    private final Map m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3541Bh3(Fragment fragment, List list) {
        super(fragment);
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(list, "jaryanTabs");
        this.l = list;
        this.m = new LinkedHashMap();
    }

    @Override // ir.nasim.AbstractC20423rz2
    public Fragment B(int i) {
        Fragment fragmentA = ((AbstractC21525th3) this.l.get(i)).a();
        this.m.put(((AbstractC21525th3) this.l.get(i)).c(), fragmentA);
        return fragmentA;
    }

    public final Map T() {
        return this.m;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.l.size();
    }
}
