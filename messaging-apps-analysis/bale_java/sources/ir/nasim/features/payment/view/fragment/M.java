package ir.nasim.features.payment.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC5830La0;
import ir.nasim.C19436qL6;
import ir.nasim.C22290uz2;
import ir.nasim.ED1;
import ir.nasim.GC6;
import ir.nasim.KB5;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J)\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lir/nasim/features/payment/view/fragment/M;", "Lir/nasim/La0;", "Lir/nasim/uz2;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lir/nasim/rB7;", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "R6", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "attachToParent", "t8", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lir/nasim/uz2;", "Ljava/util/ArrayList;", "Lir/nasim/features/payment/data/model/StatementItem;", "Lkotlin/collections/ArrayList;", "Y0", "Ljava/util/ArrayList;", "list", "Lir/nasim/qL6;", "Z0", "Lir/nasim/qL6;", "adapter", "a1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class M extends AbstractC5830La0<C22290uz2> {

    /* renamed from: a1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int b1 = 8;

    /* renamed from: Y0, reason: from kotlin metadata */
    private ArrayList list;

    /* renamed from: Z0, reason: from kotlin metadata */
    private final C19436qL6 adapter = new C19436qL6();

    /* renamed from: ir.nasim.features.payment.view.fragment.M$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final M a(ArrayList arrayList) {
            AbstractC13042fc3.i(arrayList, "list");
            M m = new M();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("ARG_STATEMENT_LIST", arrayList);
            m.a8(bundle);
            return m;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            ArrayList parcelableArrayList = bundleE5.getParcelableArrayList("ARG_STATEMENT_LIST");
            AbstractC13042fc3.f(parcelableArrayList);
            this.list = parcelableArrayList;
        }
    }

    @Override // ir.nasim.AbstractC5830La0, androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        Q7().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ((C22290uz2) r8()).b.setAdapter(this.adapter);
        RecyclerView recyclerView = ((C22290uz2) r8()).b;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
        C19436qL6 c19436qL6 = this.adapter;
        ArrayList arrayList = this.list;
        if (arrayList == null) {
            AbstractC13042fc3.y("list");
            arrayList = null;
        }
        c19436qL6.B(arrayList);
    }

    @Override // ir.nasim.AbstractC5830La0
    /* renamed from: t8, reason: merged with bridge method [inline-methods] */
    public C22290uz2 s8(LayoutInflater inflater, ViewGroup container, boolean attachToParent) {
        AbstractC13042fc3.i(inflater, "inflater");
        C22290uz2 c22290uz2C = C22290uz2.c(inflater, container, attachToParent);
        AbstractC13042fc3.h(c22290uz2C, "inflate(...)");
        return c22290uz2C;
    }
}
