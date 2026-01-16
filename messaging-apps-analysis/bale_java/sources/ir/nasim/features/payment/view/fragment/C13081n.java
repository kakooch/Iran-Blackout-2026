package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC4277El1;
import ir.nasim.C19406qI3;
import ir.nasim.C3343Am;
import ir.nasim.C6011Lu2;
import ir.nasim.C9433Zx2;
import ir.nasim.ED1;
import ir.nasim.KV0;
import ir.nasim.features.payment.view.fragment.C13081n;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0003J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lir/nasim/features/payment/view/fragment/n;", "Landroidx/fragment/app/l;", "<init>", "()V", "Lir/nasim/rB7;", "Q8", "j7", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/Zx2;", "m1", "Lir/nasim/Zx2;", "_binding", "", "n1", "Ljava/lang/String;", "link", "P8", "()Lir/nasim/Zx2;", "binding", "o1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.features.payment.view.fragment.n, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13081n extends androidx.fragment.app.l {

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int p1 = 8;

    /* renamed from: m1, reason: from kotlin metadata */
    private C9433Zx2 _binding;

    /* renamed from: n1, reason: from kotlin metadata */
    private String link;

    /* renamed from: ir.nasim.features.payment.view.fragment.n$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final C13081n a(String str) {
            AbstractC13042fc3.i(str, "link");
            C13081n c13081n = new C13081n();
            Bundle bundle = new Bundle();
            bundle.putString("param_data", str);
            c13081n.a8(bundle);
            return c13081n;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    private final C9433Zx2 P8() {
        C9433Zx2 c9433Zx2 = this._binding;
        AbstractC13042fc3.f(c9433Zx2);
        return c9433Zx2;
    }

    private final void Q8() {
        P8().i.setTypeface(C6011Lu2.i());
        P8().d.setTypeface(C6011Lu2.k());
        P8().f.setTypeface(C6011Lu2.k());
        P8().e.setTypeface(C6011Lu2.k());
        P8().b.setTypeface(C6011Lu2.i());
        P8().h.setTypeface(C6011Lu2.i());
        P8().f.setText(this.link);
        P8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13081n.R8(this.a, view);
            }
        });
        P8().h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13081n.S8(this.a, view);
            }
        });
        P8().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mv1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C13081n.T8(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R8(C13081n c13081n, View view) {
        AbstractC13042fc3.i(c13081n, "this$0");
        try {
            C3343Am.g("crowdfunding_share_dialog_cancel");
            c13081n.u8();
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
            AbstractC16494lN1.a(c13081n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S8(C13081n c13081n, View view) {
        AbstractC13042fc3.i(c13081n, "this$0");
        C3343Am.g("crowdfunding_share_dialog_share_link");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", c13081n.link);
        intent.setType("text/plain");
        intent.addFlags(268435456);
        c13081n.S7().startActivity(intent);
        AbstractC16494lN1.a(c13081n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T8(C13081n c13081n, View view) {
        AbstractC13042fc3.i(c13081n, "this$0");
        C3343Am.g("crowdfunding_share_dialog_copy_link");
        Context contextS7 = c13081n.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        if (KV0.a(contextS7, String.valueOf(c13081n.link)) && KV0.b()) {
            Context contextS72 = c13081n.S7();
            AbstractC13042fc3.h(contextS72, "requireContext(...)");
            String strH6 = c13081n.h6(AbstractC12217eE5.crowdfunding_link_copied);
            AbstractC13042fc3.h(strH6, "getString(...)");
            AbstractC4277El1.e(contextS72, strH6, 0, 2, null);
        }
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.link = bundleE5.getString("param_data");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C9433Zx2.c(inflater, container, false);
        LinearLayout root = P8().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void j7() {
        Window window;
        Window window2;
        super.j7();
        if (y8() != null) {
            Dialog dialogY8 = y8();
            if (dialogY8 != null && (window2 = dialogY8.getWindow()) != null) {
                window2.setLayout(-1, -1);
            }
            Dialog dialogY82 = y8();
            if (dialogY82 == null || (window = dialogY82.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        Q8();
    }
}
