package ir.nasim;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\u0003J+\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0003R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lir/nasim/nM5;", "Landroidx/fragment/app/l;", "<init>", "()V", "R8", "()Lir/nasim/nM5;", "O8", "P8", "Lir/nasim/rB7;", "j7", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "R6", "Lir/nasim/dz2;", "m1", "Lir/nasim/bW7;", "N8", "()Lir/nasim/dz2;", "binding", "market_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.nM5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17671nM5 extends androidx.fragment.app.l {
    static final /* synthetic */ InterfaceC5239Im3[] n1 = {AbstractC10882cM5.i(new C25226zw5(C17671nM5.class, "binding", "getBinding()Lir/nasim/databinding/FragmentRefreshDialogBinding;", 0))};
    public static final int o1 = 8;

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new a(), AbstractC20046rN7.c());

    /* renamed from: ir.nasim.nM5$a */
    public static final class a extends AbstractC8614Ws3 implements UA2 {
        public a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C12068dz2.a(fragment.V7());
        }
    }

    private final C12068dz2 N8() {
        Object objA = this.binding.a(this, n1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C12068dz2) objA;
    }

    private final C17671nM5 O8() {
        N8().e.setAnimation(AbstractC19954rD5.market_swipe_tip);
        N8().e.x();
        N8().e.setRepeatCount(Integer.MAX_VALUE);
        return this;
    }

    private final C17671nM5 P8() {
        N8().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.mM5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C17671nM5.Q8(this.a, view);
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q8(C17671nM5 c17671nM5, View view) {
        AbstractC13042fc3.i(c17671nM5, "this$0");
        AbstractC16494lN1.a(c17671nM5);
    }

    private final C17671nM5 R8() {
        N8().d.setTypeface(C6011Lu2.k());
        N8().c.setTypeface(C6011Lu2.i());
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C12068dz2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        AbstractC5969Lp4.e().F().h0();
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void j7() {
        Window window;
        Window window2;
        super.j7();
        if (y8() != null) {
            Dialog dialogY8 = y8();
            if (dialogY8 != null && (window2 = dialogY8.getWindow()) != null) {
                window2.setLayout(-1, -2);
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
        R8().O8().P8();
    }
}
