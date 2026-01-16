package ir.nasim;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C14056hH;
import ir.nasim.components.appbar.view.BaleToolbar;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001:B\t\b\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0006J!\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0006R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0014\u00108\u001a\u00020!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lir/nasim/dH;", "Lir/nasim/ua0;", "Lir/nasim/hH$c;", "Lir/nasim/hH$b;", "Lir/nasim/hH$d;", "<init>", "()V", "Lir/nasim/rB7;", "T9", "S9", "Q9", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/fH;", "item", "B4", "(Lir/nasim/fH;)V", "D2", "Lir/nasim/gH;", "j2", "(Lir/nasim/gH;)V", "T6", "Lir/nasim/sx2;", "c1", "Lir/nasim/sx2;", "_binding", "Lir/nasim/eH;", "d1", "Lir/nasim/Yu3;", "V9", "()Lir/nasim/eH;", "viewModel", "Lir/nasim/hH;", "e1", "Lir/nasim/hH;", "suggestAdapter", "f1", "Lir/nasim/hH$c;", "getSuggestClickListener", "()Lir/nasim/hH$c;", "W9", "(Lir/nasim/hH$c;)V", "suggestClickListener", "U9", "()Lir/nasim/sx2;", "binding", "g1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.dH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11595dH extends C22042ua0 implements C14056hH.c, C14056hH.b, C14056hH.d {

    /* renamed from: g1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int h1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private C20995sx2 _binding;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.bH
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C11595dH.X9(this.a);
        }
    });

    /* renamed from: e1, reason: from kotlin metadata */
    private final C14056hH suggestAdapter = new C14056hH();

    /* renamed from: f1, reason: from kotlin metadata */
    private C14056hH.c suggestClickListener;

    /* renamed from: ir.nasim.dH$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C11595dH a() {
            return new C11595dH();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private final void Q9() {
        RecyclerView recyclerView = U9().c;
        V9().W0().j(p6(), new QG4() { // from class: ir.nasim.cH
            @Override // ir.nasim.QG4
            public final void a(Object obj) {
                C11595dH.R9(this.a, (ArrayList) obj);
            }
        });
        recyclerView.setAdapter(this.suggestAdapter);
        V9().b1();
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        recyclerView.addItemDecoration(new GC6(contextS7, KB5.ic_card_payment_divider_line));
        this.suggestAdapter.A(this);
        this.suggestAdapter.B(this);
        this.suggestAdapter.C(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(C11595dH c11595dH, ArrayList arrayList) {
        AbstractC13042fc3.i(c11595dH, "this$0");
        c11595dH.suggestAdapter.z(arrayList);
        c11595dH.suggestAdapter.notifyDataSetChanged();
    }

    private final void S9() {
        BaleToolbar baleToolbar = U9().e;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
    }

    private final void T9() {
        S9();
        Q9();
    }

    private final C20995sx2 U9() {
        C20995sx2 c20995sx2 = this._binding;
        AbstractC13042fc3.f(c20995sx2);
        return c20995sx2;
    }

    private final C12238eH V9() {
        return (C12238eH) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C12238eH X9(C11595dH c11595dH) {
        AbstractC13042fc3.i(c11595dH, "this$0");
        return (C12238eH) new androidx.lifecycle.G(c11595dH).b(C12238eH.class);
    }

    @Override // ir.nasim.C14056hH.d
    public void B4(C12847fH item) {
        AbstractC13042fc3.i(item, "item");
        V9().Z0(item.a());
    }

    @Override // ir.nasim.C14056hH.c
    public void D2(C12847fH item) {
        AbstractC13042fc3.i(item, "item");
        C14056hH.c cVar = this.suggestClickListener;
        if (cVar != null) {
            cVar.D2(item);
        }
        Q7().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C20995sx2.c(inflater, container, false);
        return U9().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        C14056hH.c cVar = this.suggestClickListener;
        if (cVar != null) {
            cVar.D2(new C12847fH("", ""));
        }
        super.T6();
    }

    public final void W9(C14056hH.c cVar) {
        this.suggestClickListener = cVar;
    }

    @Override // ir.nasim.C14056hH.b
    public void j2(C13465gH item) {
        AbstractC13042fc3.i(item, "item");
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        T9();
    }
}
