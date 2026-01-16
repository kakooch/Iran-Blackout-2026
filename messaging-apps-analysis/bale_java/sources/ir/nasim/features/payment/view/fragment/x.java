package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.C10036ay2;
import ir.nasim.C6011Lu2;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0003J!\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lir/nasim/features/payment/view/fragment/x;", "Landroidx/fragment/app/l;", "<init>", "()V", "Lir/nasim/rB7;", "P8", "j7", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "R6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/ay2;", "m1", "Lir/nasim/ay2;", "_binding", "Lir/nasim/features/payment/view/fragment/x$a;", "n1", "Lir/nasim/features/payment/view/fragment/x$a;", "getDeleteListener", "()Lir/nasim/features/payment/view/fragment/x$a;", "S8", "(Lir/nasim/features/payment/view/fragment/x$a;)V", "deleteListener", "O8", "()Lir/nasim/ay2;", "binding", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class x extends androidx.fragment.app.l {

    /* renamed from: m1, reason: from kotlin metadata */
    private C10036ay2 _binding;

    /* renamed from: n1, reason: from kotlin metadata */
    private a deleteListener;

    public interface a {
        void a();
    }

    private final C10036ay2 O8() {
        C10036ay2 c10036ay2 = this._binding;
        AbstractC13042fc3.f(c10036ay2);
        return c10036ay2;
    }

    private final void P8() {
        O8().e.setTypeface(C6011Lu2.i());
        O8().d.setTypeface(C6011Lu2.k());
        O8().c.setTypeface(C6011Lu2.i());
        O8().b.setTypeface(C6011Lu2.i());
        O8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.rH1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.x.Q8(this.a, view);
            }
        });
        O8().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sH1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.x.R8(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q8(x xVar, View view) {
        AbstractC13042fc3.i(xVar, "this$0");
        AbstractC16494lN1.a(xVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R8(x xVar, View view) {
        AbstractC13042fc3.i(xVar, "this$0");
        a aVar = xVar.deleteListener;
        if (aVar != null) {
            aVar.a();
        }
        AbstractC16494lN1.a(xVar);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C10036ay2.c(inflater, container, false);
        return O8().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final void S8(a aVar) {
        this.deleteListener = aVar;
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
        P8();
    }
}
