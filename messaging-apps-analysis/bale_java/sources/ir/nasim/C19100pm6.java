package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ir.nasim.features.mxp.entity.PuppetGroup;
import ir.nasim.features.mxp.entity.PuppetUser;
import ir.nasim.features.smiles.widget.StickerRecyclerView;
import java.util.List;

/* renamed from: ir.nasim.pm6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19100pm6 extends com.google.android.material.bottomsheet.b {
    private UA2 n1;
    private PuppetGroup o1;
    private com.google.android.material.bottomsheet.a p1;
    private final InterfaceC10358bW7 q1;
    private C14374ho4 r1;
    static final /* synthetic */ InterfaceC5239Im3[] t1 = {AbstractC10882cM5.i(new C25226zw5(C19100pm6.class, "binding", "getBinding()Lir/nasim/databinding/DialogSelectMxpContactBinding;", 0))};
    public static final a s1 = new a(null);
    public static final int u1 = 8;

    /* renamed from: ir.nasim.pm6$a */
    public static final class a {
        private a() {
        }

        public final C19100pm6 a(PuppetGroup puppetGroup) {
            AbstractC13042fc3.i(puppetGroup, "puppet");
            C19100pm6 c19100pm6 = new C19100pm6(null);
            Bundle bundle = new Bundle();
            bundle.putParcelable("puppets", puppetGroup);
            c19100pm6.a8(bundle);
            return c19100pm6;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.pm6$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        public b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC9764aW7 invoke(Fragment fragment) {
            AbstractC13042fc3.i(fragment, "fragment");
            return C22534vP1.a(fragment.V7());
        }
    }

    public /* synthetic */ C19100pm6(ED1 ed1) {
        this();
    }

    private final C22534vP1 T8() {
        Object objA = this.q1.a(this, t1[0]);
        AbstractC13042fc3.h(objA, "getValue(...)");
        return (C22534vP1) objA;
    }

    private final StickerRecyclerView U8() {
        C22534vP1 c22534vP1T8 = T8();
        c22534vP1T8.i.setTypeface(C6011Lu2.i());
        StickerRecyclerView stickerRecyclerView = c22534vP1T8.g;
        stickerRecyclerView.setItemAnimator(null);
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        stickerRecyclerView.addItemDecoration(new GC6(contextS7, KB5.divider_select_mxp_contact));
        stickerRecyclerView.setAdapter(this.r1);
        AbstractC13042fc3.h(stickerRecyclerView, "with(...)");
        return stickerRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 V8(C19100pm6 c19100pm6, PuppetUser puppetUser) {
        AbstractC13042fc3.i(c19100pm6, "this$0");
        AbstractC13042fc3.i(puppetUser, "it");
        c19100pm6.W8(puppetUser);
        c19100pm6.u8();
        UA2 ua2 = c19100pm6.n1;
        if (ua2 != null) {
            ua2.invoke(puppetUser);
        }
        return C19938rB7.a;
    }

    private final void W8(final PuppetUser puppetUser) {
        AbstractC5969Lp4.e().W().w0(AbstractC10360bX0.g(Integer.valueOf(puppetUser.getUserId())), false).m0(new InterfaceC24449ye1() { // from class: ir.nasim.nm6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19100pm6.Y8(puppetUser, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.om6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C19100pm6.X8((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X8(Exception exc) {
        C19406qI3.a("mxp", "openPuppet e: " + exc, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y8(PuppetUser puppetUser, C14505i18 c14505i18) {
        AbstractC13042fc3.i(puppetUser, "$puppet");
        C18987pb3 c18987pb3 = C18987pb3.a;
        C11458d25 c11458d25R = C11458d25.r(puppetUser.getUserId());
        AbstractC13042fc3.h(c11458d25R, "fromUniqueId(...)");
        C18987pb3.x1(c18987pb3, c11458d25R, null, null, false, null, null, false, null, null, false, null, 2046, null);
    }

    private final void a9(List list) {
        StickerRecyclerView stickerRecyclerView = T8().g;
        AbstractC13042fc3.h(stickerRecyclerView, "rcMxpContact");
        stickerRecyclerView.setVisibility(0);
        C14374ho4 c14374ho4 = this.r1;
        c14374ho4.C(list);
        c14374ho4.notifyDataSetChanged();
        CircularProgressIndicator circularProgressIndicator = T8().f;
        AbstractC13042fc3.h(circularProgressIndicator, "prg");
        circularProgressIndicator.setVisibility(8);
        LinearLayout linearLayout = T8().c;
        AbstractC13042fc3.h(linearLayout, "frNotFound");
        linearLayout.setVisibility(list.isEmpty() ? 0 : 8);
        com.google.android.material.bottomsheet.a aVar = this.p1;
        if (aVar == null) {
            AbstractC13042fc3.y("bottomSheetDialog");
            aVar = null;
        }
        aVar.o().J0(3);
    }

    private final void b9() {
        C22534vP1 c22534vP1T8 = T8();
        c22534vP1T8.h.setTypeface(C6011Lu2.k());
        LinearLayout linearLayout = c22534vP1T8.c;
        AbstractC13042fc3.h(linearLayout, "frNotFound");
        linearLayout.setVisibility(0);
        CircularProgressIndicator circularProgressIndicator = c22534vP1T8.f;
        AbstractC13042fc3.h(circularProgressIndicator, "prg");
        circularProgressIndicator.setVisibility(8);
        StickerRecyclerView stickerRecyclerView = c22534vP1T8.g;
        AbstractC13042fc3.h(stickerRecyclerView, "rcMxpContact");
        stickerRecyclerView.setVisibility(8);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle bundle) {
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(S7(), AbstractC23035wE5.PlayListBottomSheetDialogTheme);
        aVar.setCancelable(true);
        aVar.setCanceledOnTouchOutside(true);
        BottomSheetBehavior bottomSheetBehaviorO = aVar.o();
        bottomSheetBehaviorO.J0(4);
        bottomSheetBehaviorO.B0(0.5f);
        bottomSheetBehaviorO.F0(C22078ud6.b() / 2);
        bottomSheetBehaviorO.z0(true);
        bottomSheetBehaviorO.I0(false);
        this.p1 = aVar;
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle bundle) {
        PuppetGroup puppetGroup = null;
        if (Build.VERSION.SDK_INT >= 33) {
            Bundle bundleE5 = E5();
            if (bundleE5 != null) {
                puppetGroup = (PuppetGroup) bundleE5.getParcelable("puppets", PuppetGroup.class);
            }
        } else {
            Bundle bundleE52 = E5();
            if (bundleE52 != null) {
                puppetGroup = (PuppetGroup) bundleE52.getParcelable("puppets");
            }
        }
        this.o1 = puppetGroup;
        super.M6(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AbstractC13042fc3.i(layoutInflater, "inflater");
        super.Q6(layoutInflater, viewGroup, bundle);
        LinearLayout root = C22534vP1.c(layoutInflater, viewGroup, false).getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    public final void Z8(UA2 ua2) {
        this.n1 = ua2;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle bundle) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, bundle);
        U8();
        PuppetGroup puppetGroup = this.o1;
        if (puppetGroup != null) {
            a9(puppetGroup.getPuppets());
        } else {
            b9();
        }
    }

    private C19100pm6() {
        this.q1 = AbstractC6056Lz2.f(this, new b(), AbstractC20046rN7.c());
        this.r1 = new C14374ho4(AbstractC10360bX0.m(), new UA2() { // from class: ir.nasim.mm6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C19100pm6.V8(this.a, (PuppetUser) obj);
            }
        });
    }
}
