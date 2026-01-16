package ir.nasim.features.pfm;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import ir.nasim.AK1;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.C12659ez2;
import ir.nasim.C17468n10;
import ir.nasim.C19811qz;
import ir.nasim.C19938rB7;
import ir.nasim.C20420rz;
import ir.nasim.C5495Jo7;
import ir.nasim.C5577Jy;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.OC;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.designsystem.button.FullWidthButtonPrimary;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 92\u00020\u0001:\u0001:B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0003J!\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006;"}, d2 = {"Lir/nasim/features/pfm/i;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lir/nasim/rB7;", "F8", "Lir/nasim/qz;", "v8", "()Lir/nasim/qz;", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "z8", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "R6", "Lir/nasim/ez2;", "W0", "Lir/nasim/ez2;", "w8", "()Lir/nasim/ez2;", "E8", "(Lir/nasim/ez2;)V", "binding", "Lir/nasim/features/pfm/h;", "X0", "Lir/nasim/features/pfm/h;", "x8", "()Lir/nasim/features/pfm/h;", "G8", "(Lir/nasim/features/pfm/h;)V", "pfmViewModel", "Lir/nasim/n10;", "Y0", "Lir/nasim/n10;", "y8", "()Lir/nasim/n10;", "H8", "(Lir/nasim/n10;)V", "snackbar", "", "Z0", "Z", "getDoing", "()Z", "setDoing", "(Z)V", "doing", "a1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class i extends Fragment {

    /* renamed from: a1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int b1 = 8;

    /* renamed from: W0, reason: from kotlin metadata */
    public C12659ez2 binding;

    /* renamed from: X0, reason: from kotlin metadata */
    public h pfmViewModel;

    /* renamed from: Y0, reason: from kotlin metadata */
    public C17468n10 snackbar;

    /* renamed from: Z0, reason: from kotlin metadata */
    private boolean doing;

    /* renamed from: ir.nasim.features.pfm.i$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final Fragment a() {
            return new i();
        }

        public final Fragment b() {
            return a();
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A8(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B8(final i iVar, View view) {
        AbstractC13042fc3.i(iVar, "this$0");
        if (iVar.doing) {
            return;
        }
        iVar.z8();
        String string = iVar.w8().f.getText().toString();
        if (!AbstractC20762sZ6.n0(string)) {
            iVar.x8().o3(string, iVar.v8()).m0(new InterfaceC24449ye1() { // from class: ir.nasim.rP5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.i.C8(this.a, (C19938rB7) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.sP5
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    ir.nasim.features.pfm.i.D8(this.a, (Exception) obj);
                }
            });
            iVar.w8().b.b();
        } else {
            C17468n10 c17468n10Y8 = iVar.y8();
            String strH6 = iVar.h6(AbstractC12217eE5.error_input_is_empty);
            AbstractC13042fc3.h(strH6, "getString(...)");
            c17468n10Y8.o(strH6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C8(i iVar, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(iVar, "this$0");
        FullWidthButtonPrimary fullWidthButtonPrimary = iVar.w8().b;
        AbstractC13042fc3.h(fullWidthButtonPrimary, "buttonSaveReport");
        C17468n10 c17468n10 = new C17468n10(fullWidthButtonPrimary, null, 0, 6, null);
        String strH6 = iVar.h6(AbstractC12217eE5.pfm_report_error_success_snackbar);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10.o(strH6);
        iVar.Q7().onBackPressed();
        iVar.doing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D8(i iVar, Exception exc) {
        AbstractC13042fc3.i(iVar, "this$0");
        C17468n10 c17468n10Y8 = iVar.y8();
        String strH6 = iVar.h6(AbstractC12217eE5.error_unknown);
        AbstractC13042fc3.h(strH6, "getString(...)");
        c17468n10Y8.o(strH6);
        iVar.w8().b.i();
        iVar.doing = false;
    }

    private final void F8() {
        C12659ez2 c12659ez2W8 = w8();
        c12659ez2W8.i.setTypeface(C6011Lu2.k());
        c12659ez2W8.j.setTypeface(C6011Lu2.i());
        c12659ez2W8.f.setTypeface(C6011Lu2.k());
        ConstraintLayout constraintLayout = c12659ez2W8.e;
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackgroundColor(c5495Jo7.r());
        c12659ez2W8.i.setTextColor(c5495Jo7.U());
        c12659ez2W8.j.setTextColor(c5495Jo7.d());
        c12659ez2W8.f.setBackgroundColor(c5495Jo7.c2());
        c12659ez2W8.d.setBackgroundColor(c5495Jo7.c2());
        c12659ez2W8.f.setHintTextColor(c5495Jo7.T0());
    }

    private final C19811qz v8() {
        return new C19811qz(AbstractC10360bX0.p(new C20420rz("Version", new OC(AbstractC20507s76.r())), new C20420rz("OS", new C5577Jy(Build.VERSION.SDK_INT)), new C20420rz("Device", new OC(AK1.a.a()))));
    }

    public final void E8(C12659ez2 c12659ez2) {
        AbstractC13042fc3.i(c12659ez2, "<set-?>");
        this.binding = c12659ez2;
    }

    public final void G8(h hVar) {
        AbstractC13042fc3.i(hVar, "<set-?>");
        this.pfmViewModel = hVar;
    }

    public final void H8(C17468n10 c17468n10) {
        AbstractC13042fc3.i(c17468n10, "<set-?>");
        this.snackbar = c17468n10;
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        c8(true);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        G8((h) new G(fragmentActivityQ7).b(h.class));
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        E8(C12659ez2.c(inflater, container, false));
        F8();
        BaleToolbar baleToolbar = w8().h;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        w8().getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.qP5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.i.A8(view);
            }
        });
        w8().getRoot().setClickable(true);
        ConstraintLayout root = w8().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        H8(new C17468n10(root, null, 0, 6, null));
        y8().k(w8().b);
        y8().m(2000);
        ConstraintLayout root2 = w8().getRoot();
        AbstractC13042fc3.h(root2, "getRoot(...)");
        return root2;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        y8().f();
        super.R6();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        w8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pP5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.i.B8(this.a, view2);
            }
        });
    }

    public final C12659ez2 w8() {
        C12659ez2 c12659ez2 = this.binding;
        if (c12659ez2 != null) {
            return c12659ez2;
        }
        AbstractC13042fc3.y("binding");
        return null;
    }

    public final h x8() {
        h hVar = this.pfmViewModel;
        if (hVar != null) {
            return hVar;
        }
        AbstractC13042fc3.y("pfmViewModel");
        return null;
    }

    public final C17468n10 y8() {
        C17468n10 c17468n10 = this.snackbar;
        if (c17468n10 != null) {
            return c17468n10;
        }
        AbstractC13042fc3.y("snackbar");
        return null;
    }

    public final void z8() {
        Context contextG5 = G5();
        Object systemService = contextG5 != null ? contextG5.getSystemService("input_method") : null;
        AbstractC13042fc3.g(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(w8().f.getWindowToken(), 0);
    }
}
