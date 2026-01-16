package ir.nasim.features.payment.view.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.button.MaterialButton;
import ir.nasim.AbstractC12208eD5;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16494lN1;
import ir.nasim.AbstractC23035wE5;
import ir.nasim.BC5;
import ir.nasim.C13886gz2;
import ir.nasim.C19938rB7;
import ir.nasim.C21937uO3;
import ir.nasim.C4909Hb6;
import ir.nasim.C5354Iz1;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.ED1;
import ir.nasim.H40;
import ir.nasim.I40;
import ir.nasim.InterfaceC18751pB2;
import ir.nasim.InterfaceC21074t40;
import ir.nasim.InterfaceC22058ub6;
import ir.nasim.InterfaceC22409vB2;
import ir.nasim.QG4;
import ir.nasim.UA2;
import ir.nasim.WB5;
import ir.nasim.features.payment.view.fragment.C13068a;
import ir.nasim.features.payment.view.fragment.x;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001OB\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u0005R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010-\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010J\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0014\u0010M\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006P"}, d2 = {"Lir/nasim/features/payment/view/fragment/I;", "Lcom/google/android/material/bottomsheet/b;", "Lir/nasim/I40$a;", "Lir/nasim/I40$c;", "<init>", "()V", "Lir/nasim/rB7;", "g9", "", "mTitle", "mDescription", "e9", "(Ljava/lang/String;Ljava/lang/String;)V", "c9", "a9", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "B8", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Lir/nasim/H40;", "bankCardSaved", "W4", "(Lir/nasim/H40;)V", "u4", "R6", "Lir/nasim/gz2;", "n1", "Lir/nasim/gz2;", "_binding", "", "o1", "Z", "isChangeList", "()Z", "l9", "(Z)V", "Lir/nasim/ub6;", "p1", "Lir/nasim/ub6;", "viewModel", "", "q1", "Ljava/lang/Integer;", "type", "Lir/nasim/I40;", "r1", "Lir/nasim/I40;", "Z8", "()Lir/nasim/I40;", "savedAdapter", "Lcom/google/android/material/button/MaterialButton;", "s1", "Lcom/google/android/material/button/MaterialButton;", "addButton", "Lir/nasim/t40;", "t1", "Lir/nasim/t40;", "getBankCardChangeListener", "()Lir/nasim/t40;", "k9", "(Lir/nasim/t40;)V", "bankCardChangeListener", "Y8", "()Lir/nasim/gz2;", "binding", "u1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class I extends com.google.android.material.bottomsheet.b implements I40.a, I40.c {

    /* renamed from: u1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int v1 = 8;

    /* renamed from: n1, reason: from kotlin metadata */
    private C13886gz2 _binding;

    /* renamed from: o1, reason: from kotlin metadata */
    private boolean isChangeList;

    /* renamed from: p1, reason: from kotlin metadata */
    private InterfaceC22058ub6 viewModel;

    /* renamed from: q1, reason: from kotlin metadata */
    private Integer type;

    /* renamed from: r1, reason: from kotlin metadata */
    private final I40 savedAdapter = new I40(I40.d.a);

    /* renamed from: s1, reason: from kotlin metadata */
    private MaterialButton addButton;

    /* renamed from: t1, reason: from kotlin metadata */
    private InterfaceC21074t40 bankCardChangeListener;

    /* renamed from: ir.nasim.features.payment.view.fragment.I$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final I a(int i) {
            I i2 = new I();
            Bundle bundle = new Bundle();
            bundle.putInt("type", i);
            i2.a8(bundle);
            return i2;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    public static final class b implements x.a {
        final /* synthetic */ H40 b;

        b(H40 h40) {
            this.b = h40;
        }

        @Override // ir.nasim.features.payment.view.fragment.x.a
        public void a() {
            int iIndexOf;
            if (I.this.getSavedAdapter().z().contains(this.b) && I.this.getSavedAdapter().z().size() >= (iIndexOf = I.this.getSavedAdapter().z().indexOf(this.b))) {
                I.this.getSavedAdapter().z().remove(iIndexOf);
                I.this.getSavedAdapter().notifyItemRemoved(iIndexOf);
                Integer num = I.this.type;
                InterfaceC22058ub6 interfaceC22058ub6 = null;
                if (num != null && num.intValue() == 0) {
                    InterfaceC22058ub6 interfaceC22058ub62 = I.this.viewModel;
                    if (interfaceC22058ub62 == null) {
                        AbstractC13042fc3.y("viewModel");
                    } else {
                        interfaceC22058ub6 = interfaceC22058ub62;
                    }
                    interfaceC22058ub6.i0(this.b);
                } else if (num != null && num.intValue() == 1) {
                    InterfaceC22058ub6 interfaceC22058ub63 = I.this.viewModel;
                    if (interfaceC22058ub63 == null) {
                        AbstractC13042fc3.y("viewModel");
                    } else {
                        interfaceC22058ub6 = interfaceC22058ub63;
                    }
                    interfaceC22058ub6.T(this.b);
                }
                I.this.l9(true);
            }
        }
    }

    static final class c implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        c(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "function");
            this.a = ua2;
        }

        @Override // ir.nasim.QG4
        public final /* synthetic */ void a(Object obj) {
            this.a.invoke(obj);
        }

        @Override // ir.nasim.InterfaceC22409vB2
        public final InterfaceC18751pB2 b() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof QG4) && (obj instanceof InterfaceC22409vB2)) {
                return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
            }
            return false;
        }

        public final int hashCode() {
            return b().hashCode();
        }
    }

    private final C13886gz2 Y8() {
        C13886gz2 c13886gz2 = this._binding;
        AbstractC13042fc3.f(c13886gz2);
        return c13886gz2;
    }

    private final void a9() {
        InterfaceC22058ub6 interfaceC22058ub6 = this.viewModel;
        if (interfaceC22058ub6 == null) {
            AbstractC13042fc3.y("viewModel");
            interfaceC22058ub6 = null;
        }
        interfaceC22058ub6.P().j(p6(), new c(new UA2() { // from class: ir.nasim.hb6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.payment.view.fragment.I.b9(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b9(I i, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(i, "this$0");
        if (!c5354Iz1.c()) {
            I40 i40 = i.savedAdapter;
            Object objA = c5354Iz1.a();
            AbstractC13042fc3.f(objA);
            i40.C(new ArrayList((Collection) objA));
            i.savedAdapter.notifyDataSetChanged();
        }
        return C19938rB7.a;
    }

    private final void c9() {
        InterfaceC22058ub6 interfaceC22058ub6 = this.viewModel;
        if (interfaceC22058ub6 == null) {
            AbstractC13042fc3.y("viewModel");
            interfaceC22058ub6 = null;
        }
        interfaceC22058ub6.h().j(p6(), new c(new UA2() { // from class: ir.nasim.ib6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.payment.view.fragment.I.d9(this.a, (C5354Iz1) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d9(I i, C5354Iz1 c5354Iz1) {
        AbstractC13042fc3.i(i, "this$0");
        if (!c5354Iz1.c()) {
            I40 i40 = i.savedAdapter;
            Object objA = c5354Iz1.a();
            AbstractC13042fc3.f(objA);
            i40.C(new ArrayList((Collection) objA));
            i.savedAdapter.notifyDataSetChanged();
        }
        return C19938rB7.a;
    }

    private final void e9(String mTitle, String mDescription) {
        Y8().e.setText(mTitle);
        Y8().c.setText(mDescription);
        Y8().e.setTypeface(C6011Lu2.i());
        Y8().c.setTypeface(C6011Lu2.k());
        Y8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.jb6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.I.f9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f9(I i, View view) {
        AbstractC13042fc3.i(i, "this$0");
        AbstractC16494lN1.a(i);
    }

    private final void g9() {
        Integer num = this.type;
        if (num != null && num.intValue() == 0) {
            String strH6 = h6(AbstractC12217eE5.card_payment_select_source_card);
            AbstractC13042fc3.h(strH6, "getString(...)");
            String strH62 = h6(AbstractC12217eE5.card_payment_select_source_card_description);
            AbstractC13042fc3.h(strH62, "getString(...)");
            e9(strH6, strH62);
        } else if (num != null && num.intValue() == 1) {
            String strH63 = h6(AbstractC12217eE5.card_payment_select_destination_card);
            AbstractC13042fc3.h(strH63, "getString(...)");
            String strH64 = h6(AbstractC12217eE5.card_payment_select_destination_card_description);
            AbstractC13042fc3.h(strH64, "getString(...)");
            e9(strH63, strH64);
        }
        Y8().d.setAdapter(this.savedAdapter);
        Y8().d.addItemDecoration(new C21937uO3(14, 14, 8, 14, 30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h9(com.google.android.material.bottomsheet.a aVar, final I i, DialogInterface dialogInterface) {
        AbstractC13042fc3.i(aVar, "$bottomSheetDialog");
        AbstractC13042fc3.i(i, "this$0");
        AbstractC13042fc3.g(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar2 = (com.google.android.material.bottomsheet.a) dialogInterface;
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) aVar2.findViewById(WB5.coordinator);
        final FrameLayout frameLayout = (FrameLayout) aVar2.findViewById(WB5.container);
        MaterialButton materialButton = null;
        final View viewInflate = aVar.getLayoutInflater().inflate(AbstractC12208eD5.fragment_saved_cards_footer, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        viewInflate.setLayoutParams(layoutParams);
        AbstractC13042fc3.f(frameLayout);
        frameLayout.addView(viewInflate);
        viewInflate.post(new Runnable() { // from class: ir.nasim.kb6
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.payment.view.fragment.I.i9(coordinatorLayout, viewInflate, frameLayout);
            }
        });
        viewInflate.setBackgroundColor(C5495Jo7.a.k0());
        MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(BC5.add);
        i.addButton = materialButton2;
        if (materialButton2 == null) {
            AbstractC13042fc3.y("addButton");
            materialButton2 = null;
        }
        materialButton2.setTypeface(C6011Lu2.i());
        MaterialButton materialButton3 = i.addButton;
        if (materialButton3 == null) {
            AbstractC13042fc3.y("addButton");
            materialButton3 = null;
        }
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.lb6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.payment.view.fragment.I.j9(this.a, view);
            }
        });
        Integer num = i.type;
        if (num != null && num.intValue() == 1) {
            MaterialButton materialButton4 = i.addButton;
            if (materialButton4 == null) {
                AbstractC13042fc3.y("addButton");
            } else {
                materialButton = materialButton4;
            }
            materialButton.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i9(CoordinatorLayout coordinatorLayout, View view, FrameLayout frameLayout) {
        AbstractC13042fc3.f(coordinatorLayout);
        ViewGroup.LayoutParams layoutParams = coordinatorLayout.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = view.getMeasuredHeight();
        frameLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j9(I i, View view) {
        AbstractC13042fc3.i(i, "this$0");
        AbstractC16494lN1.a(i);
        C13068a.Companion companion = C13068a.INSTANCE;
        Integer num = i.type;
        AbstractC13042fc3.f(num);
        C13068a c13068aA = companion.a(num.intValue());
        c13068aA.X8(i.bankCardChangeListener);
        c13068aA.K8(i.Q7().B0(), null);
    }

    @Override // com.google.android.material.bottomsheet.b, ir.nasim.ZD, androidx.fragment.app.l
    public Dialog B8(Bundle savedInstanceState) {
        Dialog dialogB8 = super.B8(savedInstanceState);
        AbstractC13042fc3.g(dialogB8, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) dialogB8;
        aVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ir.nasim.gb6
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ir.nasim.features.payment.view.fragment.I.h9(aVar, this, dialogInterface);
            }
        });
        return aVar;
    }

    @Override // androidx.fragment.app.l, androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        Bundle bundleE5 = E5();
        if (bundleE5 != null) {
            this.type = Integer.valueOf(bundleE5.getInt("type"));
        }
        I8(0, AbstractC23035wE5.CardPaymentBottomSheetTheme);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        this.viewModel = (InterfaceC22058ub6) new androidx.lifecycle.G(fragmentActivityQ7).b(C4909Hb6.class);
        this.savedAdapter.D(this);
        this.savedAdapter.E(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C13886gz2.d(inflater, container, false);
        if (this.savedAdapter.z().isEmpty()) {
            Integer num = this.type;
            if (num != null && num.intValue() == 0) {
                c9();
            } else if (num != null && num.intValue() == 1) {
                a9();
            }
        } else {
            this.savedAdapter.notifyDataSetChanged();
        }
        return Y8().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        InterfaceC21074t40 interfaceC21074t40;
        super.R6();
        if (this.isChangeList && (interfaceC21074t40 = this.bankCardChangeListener) != null) {
            interfaceC21074t40.Q();
        }
        this._binding = null;
    }

    @Override // ir.nasim.I40.c
    public void W4(H40 bankCardSaved) {
        AbstractC13042fc3.i(bankCardSaved, "bankCardSaved");
        x xVar = new x();
        xVar.S8(new b(bankCardSaved));
        xVar.K8(Q7().B0(), null);
    }

    /* renamed from: Z8, reason: from getter */
    public final I40 getSavedAdapter() {
        return this.savedAdapter;
    }

    public final void k9(InterfaceC21074t40 interfaceC21074t40) {
        this.bankCardChangeListener = interfaceC21074t40;
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        g9();
    }

    public final void l9(boolean z) {
        this.isChangeList = z;
    }

    @Override // ir.nasim.I40.a
    public void u4(H40 bankCardSaved) {
        InterfaceC21074t40 interfaceC21074t40;
        AbstractC13042fc3.i(bankCardSaved, "bankCardSaved");
        Integer num = this.type;
        if (num != null && num.intValue() == 0) {
            InterfaceC21074t40 interfaceC21074t402 = this.bankCardChangeListener;
            if (interfaceC21074t402 != null) {
                interfaceC21074t402.m3(bankCardSaved.c());
            }
        } else if (num != null && num.intValue() == 1 && (interfaceC21074t40 = this.bankCardChangeListener) != null) {
            interfaceC21074t40.a0(bankCardSaved.c());
        }
        AbstractC16494lN1.a(this);
    }
}
