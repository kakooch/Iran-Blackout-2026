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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0003J+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lir/nasim/HG;", "Landroidx/fragment/app/l;", "<init>", "()V", "Lir/nasim/rB7;", "R8", "Q8", "S8", "j7", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lir/nasim/qx2;", "m1", "Lir/nasim/bW7;", "P8", "()Lir/nasim/qx2;", "binding", "", "n1", "Z", "fromDescription", "o1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public final class HG extends androidx.fragment.app.l {

    /* renamed from: m1, reason: from kotlin metadata */
    private final InterfaceC10358bW7 binding = AbstractC6056Lz2.f(this, new b(), AbstractC20046rN7.c());

    /* renamed from: n1, reason: from kotlin metadata */
    private boolean fromDescription;
    static final /* synthetic */ InterfaceC5239Im3[] p1 = {AbstractC10882cM5.i(new C25226zw5(HG.class, "binding", "getBinding()Lir/nasim/databinding/FragmentArbaeenAddToStoryDialogBinding;", 0))};

    /* renamed from: o1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int q1 = 8;

    /* renamed from: ir.nasim.HG$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final HG a(boolean z) {
            HG hg = new HG();
            Bundle bundle = new Bundle();
            bundle.putBoolean("FROM_DESCRIPTION_EXTRA", z);
            hg.a8(bundle);
            return hg;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C19796qx2.a(fragment.V7());
        }
    }

    private final C19796qx2 P8() {
        Object objA = this.binding.a(this, p1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C19796qx2) objA;
    }

    private final void Q8() {
        if (this.fromDescription) {
            return;
        }
        P8().c.setVisibility(0);
        P8().b.setText(h6(AbstractC12217eE5.arbaeen_add_to_story_confirm));
    }

    private final void R8() {
        if (this.fromDescription) {
            P8().d.setText(h6(AbstractC12217eE5.arbaeen_add_to_story_description));
        } else {
            P8().d.setText(h6(AbstractC12217eE5.arbaeen_add_to_story_description2));
        }
    }

    private final void S8() {
        final Bundle bundle = new Bundle();
        if (this.fromDescription) {
            P8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.EG
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HG.T8(this.a, view);
                }
            });
        } else {
            P8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FG
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HG.U8(bundle, this, view);
                }
            });
            P8().c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GG
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HG.V8(bundle, this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T8(HG hg, View view) {
        AbstractC13042fc3.i(hg, "this$0");
        AbstractC16494lN1.a(hg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U8(Bundle bundle, HG hg, View view) {
        AbstractC13042fc3.i(bundle, "$bundle");
        AbstractC13042fc3.i(hg, "this$0");
        bundle.putBoolean("KEY_CLICK_ON_CONFIRM", true);
        AbstractC18623oy2.c(hg, "REQUEST_CODE_ARBAEEN_ADD_STORY_DIALOG", bundle);
        AbstractC16494lN1.a(hg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V8(Bundle bundle, HG hg, View view) {
        AbstractC13042fc3.i(bundle, "$bundle");
        AbstractC13042fc3.i(hg, "this$0");
        bundle.putBoolean("KEY_CLICK_ON_CONFIRM", false);
        AbstractC18623oy2.c(hg, "REQUEST_CODE_ARBAEEN_ADD_STORY_DIALOG", bundle);
        AbstractC16494lN1.a(hg);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        ConstraintLayout root = C19796qx2.c(inflater, container, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
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
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.fromDescription = bundleE5.getBoolean("FROM_DESCRIPTION_EXTRA");
        }
        if (C5495Jo7.a.J2()) {
            P8().e.setImageResource(KB5.arbaeen_add_to_story_dialog_image_night);
        } else {
            P8().e.setImageResource(KB5.arbaeen_add_to_story_dialog_image);
        }
        R8();
        Q8();
        S8();
    }
}
