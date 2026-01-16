package ir.nasim;

import androidx.fragment.app.Fragment;

/* renamed from: ir.nasim.gh6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13713gh6 extends AbstractC20423rz2 {
    private final Fragment l;
    private final String m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13713gh6(Fragment fragment, String str) {
        super(fragment);
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(str, "query");
        this.l = fragment;
        this.m = str;
    }

    @Override // ir.nasim.AbstractC20423rz2
    public Fragment B(int i) {
        return i != 0 ? i != 1 ? i != 2 ? C4034Dk1.INSTANCE.a(this.m) : MJ0.INSTANCE.a(this.m) : new C10764c95() : C4034Dk1.INSTANCE.a(this.m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 3;
    }
}
