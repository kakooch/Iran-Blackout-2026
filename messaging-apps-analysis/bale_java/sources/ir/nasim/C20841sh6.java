package ir.nasim;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ir.nasim.YS3;

/* renamed from: ir.nasim.sh6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20841sh6 extends AbstractC20423rz2 {
    private String l;
    private final InterfaceC9173Yu3 m;
    private final InterfaceC9173Yu3 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C20841sh6(FragmentManager fragmentManager, androidx.lifecycle.j jVar, String str) {
        super(fragmentManager, jVar);
        AbstractC13042fc3.i(fragmentManager, "fm");
        AbstractC13042fc3.i(jVar, "lifecycle");
        AbstractC13042fc3.i(str, "term");
        this.l = str;
        this.m = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.qh6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20841sh6.Z(this.a);
            }
        });
        this.n = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.rh6
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20841sh6.Y(this.a);
            }
        });
    }

    private final NS3 W() {
        return (NS3) this.n.getValue();
    }

    private final YS3 X() {
        return (YS3) this.m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NS3 Y(C20841sh6 c20841sh6) {
        AbstractC13042fc3.i(c20841sh6, "this$0");
        return NS3.r1.a(c20841sh6.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YS3 Z(C20841sh6 c20841sh6) {
        AbstractC13042fc3.i(c20841sh6, "this$0");
        return YS3.a.b(YS3.s1, c20841sh6.l, false, 2, null);
    }

    @Override // ir.nasim.AbstractC20423rz2
    public Fragment B(int i) {
        return i == 0 ? X() : W();
    }

    public final void V(String str) {
        AbstractC13042fc3.i(str, "term");
        this.l = str;
        X().da(str);
        W().ha(str);
        new C15494jg6(str, null, null, null, null, 0, null, 94, null).a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return 2;
    }
}
