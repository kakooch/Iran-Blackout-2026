package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C14142hQ4;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0004J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001cR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006C"}, d2 = {"Lir/nasim/hQ4;", "Landroidx/fragment/app/Fragment;", "Lir/nasim/SQ4;", "<init>", "()V", "Lir/nasim/rB7;", "T8", "Q8", "", "show", "V8", "(Z)V", "S8", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "U0", "Lir/nasim/features/pfm/tags/PFMTag;", "pfmTag", "A1", "(Lir/nasim/features/pfm/tags/PFMTag;)V", "h3", "S3", "Lir/nasim/MY;", "W0", "Lir/nasim/MY;", "dialog", "Lir/nasim/features/pfm/h;", "X0", "Lir/nasim/Yu3;", "P8", "()Lir/nasim/features/pfm/h;", "viewModel", "Lir/nasim/j75;", "Y0", "Lir/nasim/j75;", "binding", "Lir/nasim/features/pfm/entity/PFMTransaction;", "Z0", "Lir/nasim/features/pfm/entity/PFMTransaction;", "pfmTransaction", "a1", "Lir/nasim/features/pfm/tags/PFMTag;", ParameterNames.TAG, "b1", "Z", "enteredFromSetTagFragment", "Lir/nasim/JQ4;", "c1", "Lir/nasim/JQ4;", "subTagsAdapter", "N8", "()Lir/nasim/j75;", "fragmentView", "O8", "()Lir/nasim/features/pfm/tags/PFMTag;", "parentTag", "d1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.hQ4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14142hQ4 extends Fragment implements SQ4 {

    /* renamed from: d1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int e1 = 8;

    /* renamed from: W0, reason: from kotlin metadata */
    private MY dialog;

    /* renamed from: Y0, reason: from kotlin metadata */
    private C15169j75 binding;

    /* renamed from: Z0, reason: from kotlin metadata */
    private PFMTransaction pfmTransaction;

    /* renamed from: a1, reason: from kotlin metadata */
    private PFMTag tag;

    /* renamed from: c1, reason: from kotlin metadata */
    private JQ4 subTagsAdapter;

    /* renamed from: X0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.YP4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C14142hQ4.W8(this.a);
        }
    });

    /* renamed from: b1, reason: from kotlin metadata */
    private boolean enteredFromSetTagFragment = true;

    /* renamed from: ir.nasim.hQ4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ C14142hQ4 b(Companion companion, PFMTransaction pFMTransaction, PFMTag pFMTag, boolean z, boolean z2, int i, Object obj) {
            if ((i & 8) != 0) {
                z2 = false;
            }
            return companion.a(pFMTransaction, pFMTag, z, z2);
        }

        public final C14142hQ4 a(PFMTransaction pFMTransaction, PFMTag pFMTag, boolean z, boolean z2) {
            AbstractC13042fc3.i(pFMTransaction, "pfmTransaction");
            AbstractC13042fc3.i(pFMTag, "parentTag");
            Bundle bundle = new Bundle();
            bundle.putParcelable("PFM_TRANSACTION", pFMTransaction);
            bundle.putParcelable("PFM_TAG", pFMTag);
            bundle.putBoolean("PFM_SET_TAG_FROM_SHREDDING", z2);
            bundle.putBoolean("ENTERED_FROM_SET_TAG_FRAGMENT", z);
            C14142hQ4 c14142hQ4 = new C14142hQ4();
            c14142hQ4.a8(bundle);
            return c14142hQ4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hQ4$c */
    public static final class c extends ClickableSpan {
        c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            Context contextS7 = C14142hQ4.this.S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            new NY(contextS7).E(4).i(C14142hQ4.this.h6(AbstractC12217eE5.set_sub_tag_helper_alert)).k(NY.O.a()).w(AbstractC12217eE5.gift_dialogs_realized_button_title).f(true).a().z();
        }
    }

    /* renamed from: ir.nasim.hQ4$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ PFMTag b;

        d(PFMTag pFMTag) {
            this.b = pFMTag;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 d(Dialog dialog, C14142hQ4 c14142hQ4, PFMTag pFMTag) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c14142hQ4, "this$0");
            AbstractC13042fc3.i(pFMTag, "$pfmTag");
            dialog.dismiss();
            c14142hQ4.P8().i3(pFMTag);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void c(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C12738f71 c12738f71 = C12738f71.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c12738f71.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c12738f71.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(-390877988);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C14142hQ4.this) | interfaceC22053ub1.D(this.b);
            final C14142hQ4 c14142hQ4 = C14142hQ4.this;
            final PFMTag pFMTag = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.iQ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C14142hQ4.d.d(dialog, c14142hQ4, pFMTag);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.positive_remove_custom_tag;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-390869272);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.jQ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C14142hQ4.d.f(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, cVar, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.negative_remove_custom_tag, null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            c((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.hQ4$e */
    static final class e implements QG4, InterfaceC22409vB2 {
        private final /* synthetic */ UA2 a;

        e(UA2 ua2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F8(C14142hQ4 c14142hQ4, View view) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        MY my = c14142hQ4.dialog;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G8(final C14142hQ4 c14142hQ4, View view) {
        EnumC18897pR4 transactionType;
        AppCompatEditText appCompatEditTextQ;
        AppCompatEditText appCompatEditTextQ2;
        Editable text;
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        MY my = c14142hQ4.dialog;
        Editable text2 = null;
        CharSequence charSequenceN1 = (my == null || (appCompatEditTextQ2 = my.q()) == null || (text = appCompatEditTextQ2.getText()) == null) ? null : AbstractC20762sZ6.n1(text);
        if (charSequenceN1 == null || charSequenceN1.length() == 0) {
            MY my2 = c14142hQ4.dialog;
            if (my2 != null) {
                Context contextG5 = c14142hQ4.G5();
                MY.B(my2, contextG5 != null ? contextG5.getString(AbstractC12217eE5.pfm_error_custom_sub_tag_msg_empty) : null, false, 2, null);
                return;
            }
            return;
        }
        PFMTransaction pFMTransaction = c14142hQ4.pfmTransaction;
        if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
            return;
        }
        ir.nasim.features.pfm.h hVarP8 = c14142hQ4.P8();
        MY my3 = c14142hQ4.dialog;
        if (my3 != null && (appCompatEditTextQ = my3.q()) != null) {
            text2 = appCompatEditTextQ.getText();
        }
        hVarP8.A1(String.valueOf(text2), transactionType, c14142hQ4.pfmTransaction, c14142hQ4.O8()).E(new InterfaceC24449ye1() { // from class: ir.nasim.gQ4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C14142hQ4.H8(this.a, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.XP4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C14142hQ4.I8(this.a, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H8(C14142hQ4 c14142hQ4, Exception exc) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        MY my = c14142hQ4.dialog;
        if (my != null) {
            MY.B(my, String.valueOf(exc.getMessage()), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I8(C14142hQ4 c14142hQ4, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        c14142hQ4.Q7().onBackPressed();
        C19938rB7 c19938rB7 = C19938rB7.a;
        if (c14142hQ4.enteredFromSetTagFragment) {
            c14142hQ4.Q7().onBackPressed();
        }
        MY my = c14142hQ4.dialog;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J8(final C14142hQ4 c14142hQ4, PFMTag pFMTag, View view) {
        EnumC18897pR4 transactionType;
        AppCompatEditText appCompatEditTextQ;
        AppCompatEditText appCompatEditTextQ2;
        Editable text;
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$pfmTag");
        MY my = c14142hQ4.dialog;
        Editable text2 = null;
        CharSequence charSequenceN1 = (my == null || (appCompatEditTextQ2 = my.q()) == null || (text = appCompatEditTextQ2.getText()) == null) ? null : AbstractC20762sZ6.n1(text);
        if (charSequenceN1 == null || charSequenceN1.length() == 0) {
            MY my2 = c14142hQ4.dialog;
            if (my2 != null) {
                Context contextG5 = c14142hQ4.G5();
                MY.B(my2, contextG5 != null ? contextG5.getString(AbstractC12217eE5.pfm_error_custom_sub_tag_msg_empty) : null, false, 2, null);
                return;
            }
            return;
        }
        PFMTransaction pFMTransaction = c14142hQ4.pfmTransaction;
        if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
            return;
        }
        ir.nasim.features.pfm.h hVarP8 = c14142hQ4.P8();
        MY my3 = c14142hQ4.dialog;
        if (my3 != null && (appCompatEditTextQ = my3.q()) != null) {
            text2 = appCompatEditTextQ.getText();
        }
        hVarP8.I1(pFMTag, String.valueOf(text2), transactionType).E(new InterfaceC24449ye1() { // from class: ir.nasim.eQ4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C14142hQ4.K8(this.a, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.fQ4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C14142hQ4.L8(this.a, (C19938rB7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K8(C14142hQ4 c14142hQ4, Exception exc) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        MY my = c14142hQ4.dialog;
        if (my != null) {
            Context contextG5 = c14142hQ4.G5();
            MY.B(my, contextG5 != null ? contextG5.getString(AbstractC12217eE5.pfm_error_custom_sub_tag_msg_exist) : null, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L8(C14142hQ4 c14142hQ4, C19938rB7 c19938rB7) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        MY my = c14142hQ4.dialog;
        if (my != null) {
            my.o();
        }
        c14142hQ4.P8().W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M8(C14142hQ4 c14142hQ4, View view) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        MY my = c14142hQ4.dialog;
        if (my != null) {
            my.o();
        }
    }

    private final C15169j75 N8() {
        C15169j75 c15169j75 = this.binding;
        AbstractC13042fc3.f(c15169j75);
        return c15169j75;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PFMTag O8() {
        PFMTag pFMTag = this.tag;
        AbstractC13042fc3.f(pFMTag);
        return pFMTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ir.nasim.features.pfm.h P8() {
        return (ir.nasim.features.pfm.h) this.viewModel.getValue();
    }

    private final void Q8() {
        this.subTagsAdapter = new JQ4(this, 1);
        RecyclerView recyclerView = N8().h;
        JQ4 jq4 = this.subTagsAdapter;
        if (jq4 == null) {
            AbstractC13042fc3.y("subTagsAdapter");
            jq4 = null;
        }
        recyclerView.setAdapter(jq4);
        N8().h.setLayoutManager(new LinearLayoutManager(G5(), 1, false));
        P8().s2().j(p6(), new e(new UA2() { // from class: ir.nasim.ZP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C14142hQ4.R8(this.a, (List) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 R8(C14142hQ4 c14142hQ4, List list) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        List listR2 = c14142hQ4.P8().r2(c14142hQ4.O8());
        if (listR2 != null) {
            if (c14142hQ4.P8().N2(c14142hQ4.O8()) && listR2.isEmpty()) {
                c14142hQ4.V8(false);
            } else {
                Editable text = c14142hQ4.N8().l.getText();
                AbstractC13042fc3.h(text, "getText(...)");
                if (text.length() != 0 && list.isEmpty()) {
                    c14142hQ4.V8(true);
                } else {
                    c14142hQ4.V8(false);
                }
            }
        }
        JQ4 jq4 = null;
        if (list != null) {
            JQ4 jq42 = c14142hQ4.subTagsAdapter;
            if (jq42 == null) {
                AbstractC13042fc3.y("subTagsAdapter");
                jq42 = null;
            }
            jq42.C(list);
        } else {
            JQ4 jq43 = c14142hQ4.subTagsAdapter;
            if (jq43 == null) {
                AbstractC13042fc3.y("subTagsAdapter");
                jq43 = null;
            }
            jq43.C(AbstractC10360bX0.m());
        }
        JQ4 jq44 = c14142hQ4.subTagsAdapter;
        if (jq44 == null) {
            AbstractC13042fc3.y("subTagsAdapter");
        } else {
            jq4 = jq44;
        }
        jq4.notifyDataSetChanged();
        return C19938rB7.a;
    }

    private final void S8() {
        ConstraintLayout constraintLayout = (ConstraintLayout) N8().e.findViewById(BC5.pfm_search_inner_container);
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(C5495Jo7.a.X());
        }
        N8().l.addTextChangedListener(new b());
        N8().l.setTypeface(C6011Lu2.k());
        N8().l.setTextColor(C5495Jo7.a.g0());
    }

    private final void T8() throws Resources.NotFoundException {
        String string;
        List listR2;
        N8().g.setMovementMethod(LinkMovementMethod.getInstance());
        if (P8().N2(O8()) && ((listR2 = P8().r2(O8())) == null || listR2.isEmpty())) {
            Resources resourcesB6 = b6();
            int i = AbstractC12217eE5.set_sub_tag_helper_no_sub_tag;
            PFMTag pFMTagO8 = O8();
            string = resourcesB6.getString(i, pFMTagO8 != null ? pFMTagO8.getLabel() : null);
        } else {
            Resources resourcesB62 = b6();
            int i2 = AbstractC12217eE5.set_sub_tag_helper;
            PFMTag pFMTagO82 = O8();
            string = resourcesB62.getString(i2, pFMTagO82 != null ? pFMTagO82.getLabel() : null);
        }
        AbstractC13042fc3.f(string);
        SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder(string).append((CharSequence) Separators.SP);
        Context contextG5 = G5();
        ImageSpan imageSpan = contextG5 != null ? new ImageSpan(contextG5, KB5.ic_pfm_set_sub_tag_help, 0) : null;
        c cVar = new c();
        spannableStringBuilderAppend.setSpan(imageSpan, string.length(), string.length() + 1, 33);
        spannableStringBuilderAppend.setSpan(cVar, string.length(), string.length() + 1, 33);
        N8().g.setText(spannableStringBuilderAppend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U8(C14142hQ4 c14142hQ4, View view) throws NumberFormatException {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        PFMTransaction pFMTransaction = c14142hQ4.pfmTransaction;
        if (pFMTransaction != null) {
            c14142hQ4.P8().E3(c14142hQ4.O8(), pFMTransaction);
        }
        c14142hQ4.Q7().onBackPressed();
        C19938rB7 c19938rB7 = C19938rB7.a;
        if (c14142hQ4.enteredFromSetTagFragment) {
            c14142hQ4.Q7().onBackPressed();
        }
    }

    private final void V8(boolean show) {
        N8().k.setVisibility(show ? 0 : 8);
        N8().h.setVisibility(show ? 8 : 0);
        N8().c.setVisibility(show ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.pfm.h W8(C14142hQ4 c14142hQ4) {
        AbstractC13042fc3.i(c14142hQ4, "this$0");
        FragmentActivity fragmentActivityQ7 = c14142hQ4.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (ir.nasim.features.pfm.h) new androidx.lifecycle.G(fragmentActivityQ7).b(ir.nasim.features.pfm.h.class);
    }

    @Override // ir.nasim.SQ4
    public void A1(PFMTag pfmTag) throws NumberFormatException {
        AbstractC13042fc3.i(pfmTag, "pfmTag");
        PFMTransaction pFMTransaction = this.pfmTransaction;
        if (pFMTransaction != null) {
            P8().E3(pfmTag, pFMTransaction);
        }
        Q7().onBackPressed();
        C19938rB7 c19938rB7 = C19938rB7.a;
        if (this.enteredFromSetTagFragment) {
            Q7().onBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) throws Resources.NotFoundException {
        EnumC18897pR4 transactionType;
        List labels;
        PFMTag pFMTag;
        AbstractC13042fc3.i(inflater, "inflater");
        this.binding = C15169j75.c(inflater, container, false);
        N8().getRoot().setBackgroundColor(C5495Jo7.a.r());
        Bundle bundleE5 = E5();
        Long lValueOf = null;
        this.pfmTransaction = bundleE5 != null ? (PFMTransaction) bundleE5.getParcelable("PFM_TRANSACTION") : null;
        Bundle bundleE52 = E5();
        this.tag = bundleE52 != null ? (PFMTag) bundleE52.getParcelable("PFM_TAG") : null;
        Bundle bundleE53 = E5();
        Boolean boolValueOf = bundleE53 != null ? Boolean.valueOf(bundleE53.getBoolean("ENTERED_FROM_SET_TAG_FRAGMENT")) : null;
        AbstractC13042fc3.f(boolValueOf);
        this.enteredFromSetTagFragment = boolValueOf.booleanValue();
        N8().n.setText(O8().getLabel());
        N8().n.setCompoundDrawablesWithIntrinsicBounds(0, 0, O8().getIconId(), 0);
        BaleToolbar baleToolbar = N8().j;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        N8().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.WP4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws NumberFormatException {
                C14142hQ4.U8(this.a, view);
            }
        });
        T8();
        S8();
        Q8();
        ir.nasim.features.pfm.h hVarP8 = P8();
        PFMTransaction pFMTransaction = this.pfmTransaction;
        if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
            transactionType = EnumC18897pR4.b;
        }
        hVarP8.S2(transactionType);
        if (this.pfmTransaction != null && (!r7.getLabels().isEmpty())) {
            JQ4 jq4 = this.subTagsAdapter;
            if (jq4 == null) {
                AbstractC13042fc3.y("subTagsAdapter");
                jq4 = null;
            }
            PFMTransaction pFMTransaction2 = this.pfmTransaction;
            if (pFMTransaction2 != null && (labels = pFMTransaction2.getLabels()) != null && (pFMTag = (PFMTag) labels.get(0)) != null) {
                lValueOf = Long.valueOf(pFMTag.getId());
            }
            jq4.B(lValueOf);
        }
        ConstraintLayout root = N8().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // ir.nasim.SQ4
    public void S3(final PFMTag pfmTag) {
        AppCompatEditText appCompatEditTextQ;
        TextView textViewR;
        AbstractC13042fc3.i(pfmTag, "pfmTag");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        MY myA = new NY(contextS7).B(h6(AbstractC12217eE5.edit_custom_sub_tag_title)).E(4).j(false).p(KB5.pfm_default_tag).l(true).z(pfmTag.getLabel()).e(true).c(false).x(h6(AbstractC12217eE5.edit_custom_tag_btn)).u(h6(AbstractC12217eE5.negative_remove_custom_tag)).i("").v(new View.OnClickListener() { // from class: ir.nasim.aQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14142hQ4.J8(this.a, pfmTag, view);
            }
        }).s(new View.OnClickListener() { // from class: ir.nasim.bQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14142hQ4.M8(this.a, view);
            }
        }).a();
        this.dialog = myA;
        if (myA != null) {
            myA.z();
        }
        MY my = this.dialog;
        if (my != null && (textViewR = my.r()) != null) {
            textViewR.setText(h6(AbstractC12217eE5.pfm_sub_tag_title));
        }
        MY my2 = this.dialog;
        if (my2 == null || (appCompatEditTextQ = my2.q()) == null) {
            return;
        }
        appCompatEditTextQ.setHint(h6(AbstractC12217eE5.pfm_choose_sub_tag_title));
    }

    @Override // ir.nasim.SQ4
    public void U0() {
        List listM;
        AppCompatEditText appCompatEditTextQ;
        TextView textViewR;
        Context contextG5;
        List listR2 = P8().r2(O8());
        if (listR2 != null) {
            listM = new ArrayList();
            for (Object obj : listR2) {
                PFMTag pFMTag = (PFMTag) obj;
                if (pFMTag.getUserId() != 0) {
                    EnumC18897pR4 transactionType = pFMTag.getTransactionType();
                    PFMTransaction pFMTransaction = this.pfmTransaction;
                    if (transactionType == (pFMTransaction != null ? pFMTransaction.getTransactionType() : null)) {
                        listM.add(obj);
                    }
                }
            }
        } else {
            listM = AbstractC10360bX0.m();
        }
        if (listM.size() >= 5) {
            View viewO6 = o6();
            if (viewO6 == null || (contextG5 = G5()) == null) {
                return;
            }
            C17468n10 c17468n10 = new C17468n10(viewO6, null, 0, 6, null);
            String string = contextG5.getString(AbstractC12217eE5.error_msg_add_custom_sub_tag);
            AbstractC13042fc3.h(string, "getString(...)");
            c17468n10.o(string);
            return;
        }
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        MY myA = new NY(contextS7).B(h6(AbstractC12217eE5.add_custom_sub_tag_title)).E(4).j(false).l(true).e(true).c(false).s(new View.OnClickListener() { // from class: ir.nasim.cQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14142hQ4.F8(this.a, view);
            }
        }).v(new View.OnClickListener() { // from class: ir.nasim.dQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C14142hQ4.G8(this.a, view);
            }
        }).x(h6(AbstractC12217eE5.add_custom_tag_btn)).u(h6(AbstractC12217eE5.negative_remove_custom_tag)).d(true).i("").a();
        this.dialog = myA;
        if (myA != null) {
            myA.z();
        }
        MY my = this.dialog;
        if (my != null && (textViewR = my.r()) != null) {
            textViewR.setText(h6(AbstractC12217eE5.pfm_sub_tag_title));
        }
        MY my2 = this.dialog;
        if (my2 == null || (appCompatEditTextQ = my2.q()) == null) {
            return;
        }
        appCompatEditTextQ.setHint(h6(AbstractC12217eE5.pfm_choose_sub_tag_title));
    }

    @Override // ir.nasim.SQ4
    public void h3(PFMTag pfmTag) {
        AbstractC13042fc3.i(pfmTag, "pfmTag");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(-316566256, true, new d(pfmTag)), 4, null).show();
    }

    /* renamed from: ir.nasim.hQ4$b */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EnumC18897pR4 transactionType;
            PFMTransaction pFMTransaction = C14142hQ4.this.pfmTransaction;
            if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
                return;
            }
            C14142hQ4 c14142hQ4 = C14142hQ4.this;
            if (charSequence == null || AbstractC20762sZ6.n0(charSequence)) {
                c14142hQ4.P8().P1("", transactionType, c14142hQ4.O8());
            } else {
                c14142hQ4.P8().P1(AbstractC20762sZ6.n1(charSequence.toString()).toString(), transactionType, c14142hQ4.O8());
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
