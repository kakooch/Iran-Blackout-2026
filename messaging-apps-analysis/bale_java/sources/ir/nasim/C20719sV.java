package ir.nasim;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.sV, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20719sV extends androidx.fragment.app.v {
    private final List j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20719sV(FragmentManager fragmentManager) {
        super(fragmentManager);
        AbstractC13042fc3.i(fragmentManager, "fm");
        this.j = new ArrayList();
    }

    @Override // androidx.viewpager.widget.a
    public int d() {
        return this.j.size();
    }

    @Override // androidx.viewpager.widget.a
    public int e(Object obj) {
        AbstractC13042fc3.i(obj, "obj");
        return -2;
    }

    @Override // androidx.fragment.app.v, androidx.viewpager.widget.a
    public Object h(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "container");
        Object objH = super.h(viewGroup, i);
        AbstractC13042fc3.h(objH, "instantiateItem(...)");
        if (objH != ((Fragment) this.j.get(i))) {
            this.j.set(i, (Fragment) objH);
        }
        return objH;
    }

    @Override // androidx.fragment.app.v
    public Fragment t(int i) {
        return (Fragment) this.j.get(i);
    }

    public final void u(Fragment fragment) {
        AbstractC13042fc3.i(fragment, "fragment");
        this.j.add(fragment);
    }

    public final void v() {
        this.j.clear();
    }
}
