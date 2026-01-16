package ir.nasim;

import android.app.Dialog;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.C14142hQ4;
import ir.nasim.C23142wQ4;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001TB\t\b\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u000f\u0010\u001e\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b\"\u0010!J\u0017\u0010#\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010!R\u0014\u0010&\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010@\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b?\u0010;R\u0016\u0010B\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010;R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u0002098\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010;R\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\bQ\u0010%¨\u0006U"}, d2 = {"Lir/nasim/wQ4;", "Landroidx/fragment/app/Fragment;", "Lir/nasim/SQ4;", "<init>", "()V", "Lir/nasim/D45;", "persianDate", "", "N8", "(Lir/nasim/D45;)Ljava/lang/String;", "Lir/nasim/features/pfm/tags/PFMTag;", "selectedTag", "", "labelAction", "newLabel", "Lir/nasim/rB7;", "S8", "(Lir/nasim/features/pfm/tags/PFMTag;ILjava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "G6", "U0", "pfmTag", "A1", "(Lir/nasim/features/pfm/tags/PFMTag;)V", "h3", "S3", "W0", TokenNames.I, "ACTION_SIZE_ADAPTER", "Lir/nasim/MY;", "X0", "Lir/nasim/MY;", "dialog", "Lir/nasim/features/pfm/h;", "Y0", "Lir/nasim/Yu3;", "O8", "()Lir/nasim/features/pfm/h;", "viewModel", "Landroidx/recyclerview/widget/RecyclerView;", "Z0", "Landroidx/recyclerview/widget/RecyclerView;", "tagsRecyclerView", "Lir/nasim/TQ4;", "a1", "Lir/nasim/TQ4;", "tagsAdapter", "Landroid/widget/TextView;", "b1", "Landroid/widget/TextView;", "pfmTransactionType", "c1", "pfmTransactionAmount", "d1", "pfmTransactionTime", "e1", "pfmTransactionDescription", "Landroid/widget/EditText;", "f1", "Landroid/widget/EditText;", "tagSearch", "Lcom/google/android/material/appbar/AppBarLayout;", "g1", "Lcom/google/android/material/appbar/AppBarLayout;", "pfmAppbar", "h1", "tagNotFound", "Lir/nasim/features/pfm/entity/PFMTransaction;", "i1", "Lir/nasim/features/pfm/entity/PFMTransaction;", "pfmTransaction", "j1", "LIMIT_CUSTOM_TAG", "k1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* renamed from: ir.nasim.wQ4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C23142wQ4 extends Fragment implements SQ4 {

    /* renamed from: k1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: X0, reason: from kotlin metadata */
    private MY dialog;

    /* renamed from: Z0, reason: from kotlin metadata */
    private RecyclerView tagsRecyclerView;

    /* renamed from: a1, reason: from kotlin metadata */
    private TQ4 tagsAdapter;

    /* renamed from: b1, reason: from kotlin metadata */
    private TextView pfmTransactionType;

    /* renamed from: c1, reason: from kotlin metadata */
    private TextView pfmTransactionAmount;

    /* renamed from: d1, reason: from kotlin metadata */
    private TextView pfmTransactionTime;

    /* renamed from: e1, reason: from kotlin metadata */
    private TextView pfmTransactionDescription;

    /* renamed from: f1, reason: from kotlin metadata */
    private EditText tagSearch;

    /* renamed from: g1, reason: from kotlin metadata */
    private AppBarLayout pfmAppbar;

    /* renamed from: h1, reason: from kotlin metadata */
    private TextView tagNotFound;

    /* renamed from: i1, reason: from kotlin metadata */
    private PFMTransaction pfmTransaction;

    /* renamed from: W0, reason: from kotlin metadata */
    private final int ACTION_SIZE_ADAPTER = 1;

    /* renamed from: Y0, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.kQ4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C23142wQ4.U8(this.a);
        }
    });

    /* renamed from: j1, reason: from kotlin metadata */
    private final int LIMIT_CUSTOM_TAG = 5;

    /* renamed from: ir.nasim.wQ4$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ C23142wQ4 b(Companion companion, PFMTransaction pFMTransaction, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.a(pFMTransaction, z);
        }

        public final C23142wQ4 a(PFMTransaction pFMTransaction, boolean z) {
            AbstractC13042fc3.i(pFMTransaction, "pfmTransaction");
            Bundle bundle = new Bundle();
            bundle.putParcelable("PFM_TRANSACTION", pFMTransaction);
            bundle.putBoolean("PFM_SET_TAG_FROM_SHREDDING", z);
            C23142wQ4 c23142wQ4 = new C23142wQ4();
            c23142wQ4.a8(bundle);
            return c23142wQ4;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.wQ4$b */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumC18897pR4.values().length];
            try {
                iArr[EnumC18897pR4.c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18897pR4.d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* renamed from: ir.nasim.wQ4$d */
    static final class d implements InterfaceC15796kB2 {
        final /* synthetic */ PFMTag b;

        d(PFMTag pFMTag) {
            this.b = pFMTag;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(Dialog dialog, final C23142wQ4 c23142wQ4, final PFMTag pFMTag) {
            AbstractC13042fc3.i(dialog, "$it");
            AbstractC13042fc3.i(c23142wQ4, "this$0");
            AbstractC13042fc3.i(pFMTag, "$pfmTag");
            dialog.dismiss();
            c23142wQ4.O8().i3(pFMTag).m0(new InterfaceC24449ye1() { // from class: ir.nasim.zQ4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) throws NumberFormatException {
                    C23142wQ4.d.h(c23142wQ4, pFMTag, (C14505i18) obj);
                }
            });
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(C23142wQ4 c23142wQ4, PFMTag pFMTag, C14505i18 c14505i18) throws NumberFormatException {
            AbstractC13042fc3.i(c23142wQ4, "this$0");
            AbstractC13042fc3.i(pFMTag, "$pfmTag");
            C23142wQ4.T8(c23142wQ4, pFMTag, 4, null, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(Dialog dialog) {
            AbstractC13042fc3.i(dialog, "$it");
            dialog.dismiss();
            return C19938rB7.a;
        }

        public final void d(final Dialog dialog, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(dialog, "it");
            C13374g71 c13374g71 = C13374g71.a;
            InterfaceC14603iB2 interfaceC14603iB2A = c13374g71.a();
            AbstractC10289bP1.b.C0905b c0905b = AbstractC10289bP1.b.C0905b.b;
            InterfaceC14603iB2 interfaceC14603iB2B = c13374g71.b();
            AbstractC10289bP1.a.c cVar = AbstractC10289bP1.a.c.a;
            InterfaceC19114po0.c.a aVar = InterfaceC19114po0.c.a.a;
            interfaceC22053ub1.W(-986202999);
            boolean zD = interfaceC22053ub1.D(dialog) | interfaceC22053ub1.D(C23142wQ4.this) | interfaceC22053ub1.D(this.b);
            final C23142wQ4 c23142wQ4 = C23142wQ4.this;
            final PFMTag pFMTag = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.xQ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C23142wQ4.d.f(dialog, c23142wQ4, pFMTag);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            int i2 = AbstractC12217eE5.positive_remove_custom_tag;
            InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
            interfaceC22053ub1.W(-986187494);
            boolean zD2 = interfaceC22053ub1.D(dialog);
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.yQ4
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return C23142wQ4.d.i(dialog);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC19555qZ.E(interfaceC14603iB2A, c0905b, interfaceC14603iB2B, cVar, aVar, sa2, i2, c1454b, (SA2) objB2, AbstractC12217eE5.negative_remove_custom_tag, null, interfaceC22053ub1, (AbstractC10289bP1.b.C0905b.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.c.a.b << 12) | (InterfaceC19114po0.b.C1454b.b << 21), 0, 1024);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((Dialog) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.wQ4$e */
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
    public static final void F8(final C23142wQ4 c23142wQ4, View view) {
        EnumC18897pR4 transactionType;
        AppCompatEditText appCompatEditTextQ;
        AppCompatEditText appCompatEditTextQ2;
        Editable text;
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        MY my = c23142wQ4.dialog;
        CharSequence charSequenceN1 = (my == null || (appCompatEditTextQ2 = my.q()) == null || (text = appCompatEditTextQ2.getText()) == null) ? null : AbstractC20762sZ6.n1(text);
        if (charSequenceN1 == null || charSequenceN1.length() == 0) {
            MY my2 = c23142wQ4.dialog;
            if (my2 != null) {
                Context contextG5 = c23142wQ4.G5();
                MY.B(my2, contextG5 != null ? contextG5.getString(AbstractC12217eE5.pfm_error_custom_tag_msg_empty) : null, false, 2, null);
                return;
            }
            return;
        }
        PFMTransaction pFMTransaction = c23142wQ4.pfmTransaction;
        if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
            return;
        }
        ir.nasim.features.pfm.h hVarO8 = c23142wQ4.O8();
        MY my3 = c23142wQ4.dialog;
        hVarO8.A1(String.valueOf((my3 == null || (appCompatEditTextQ = my3.q()) == null) ? null : appCompatEditTextQ.getText()), transactionType, c23142wQ4.pfmTransaction, null).E(new InterfaceC24449ye1() { // from class: ir.nasim.lQ4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23142wQ4.G8(this.a, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.mQ4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23142wQ4.H8(this.a, (C14505i18) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G8(C23142wQ4 c23142wQ4, Exception exc) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        MY my = c23142wQ4.dialog;
        if (my != null) {
            MY.B(my, String.valueOf(exc.getMessage()), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H8(C23142wQ4 c23142wQ4, C14505i18 c14505i18) {
        AppCompatEditText appCompatEditTextQ;
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        MY my = c23142wQ4.dialog;
        if (my != null) {
            my.o();
        }
        MY my2 = c23142wQ4.dialog;
        XV4 xv4 = new XV4("label_text", String.valueOf((my2 == null || (appCompatEditTextQ = my2.q()) == null) ? null : appCompatEditTextQ.getText()));
        PFMTransaction pFMTransaction = c23142wQ4.pfmTransaction;
        C3343Am.i("pfm_add_label", AbstractC20051rO3.n(xv4, new XV4("accounting_type", Integer.valueOf((pFMTransaction != null ? pFMTransaction.getTransactionType() : null) == EnumC18897pR4.c ? 0 : 1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I8(C23142wQ4 c23142wQ4, View view) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        MY my = c23142wQ4.dialog;
        if (my != null) {
            my.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J8(final C23142wQ4 c23142wQ4, final PFMTag pFMTag, View view) {
        EnumC18897pR4 transactionType;
        AppCompatEditText appCompatEditTextQ;
        AppCompatEditText appCompatEditTextQ2;
        Editable text;
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$pfmTag");
        MY my = c23142wQ4.dialog;
        Editable text2 = null;
        CharSequence charSequenceN1 = (my == null || (appCompatEditTextQ2 = my.q()) == null || (text = appCompatEditTextQ2.getText()) == null) ? null : AbstractC20762sZ6.n1(text);
        if (charSequenceN1 == null || charSequenceN1.length() == 0) {
            MY my2 = c23142wQ4.dialog;
            if (my2 != null) {
                Context contextG5 = c23142wQ4.G5();
                MY.B(my2, contextG5 != null ? contextG5.getString(AbstractC12217eE5.pfm_error_custom_tag_msg_empty) : null, false, 2, null);
                return;
            }
            return;
        }
        PFMTransaction pFMTransaction = c23142wQ4.pfmTransaction;
        if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
            return;
        }
        ir.nasim.features.pfm.h hVarO8 = c23142wQ4.O8();
        MY my3 = c23142wQ4.dialog;
        if (my3 != null && (appCompatEditTextQ = my3.q()) != null) {
            text2 = appCompatEditTextQ.getText();
        }
        hVarO8.I1(pFMTag, String.valueOf(text2), transactionType).E(new InterfaceC24449ye1() { // from class: ir.nasim.uQ4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C23142wQ4.K8(this.a, (Exception) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.vQ4
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) throws NumberFormatException {
                C23142wQ4.L8(this.a, pFMTag, (C19938rB7) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K8(C23142wQ4 c23142wQ4, Exception exc) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        MY my = c23142wQ4.dialog;
        if (my != null) {
            Context contextG5 = c23142wQ4.G5();
            MY.B(my, contextG5 != null ? contextG5.getString(AbstractC12217eE5.pfm_error_custom_tag_msg_exist) : null, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L8(C23142wQ4 c23142wQ4, PFMTag pFMTag, C19938rB7 c19938rB7) throws NumberFormatException {
        AppCompatEditText appCompatEditTextQ;
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        AbstractC13042fc3.i(pFMTag, "$pfmTag");
        MY my = c23142wQ4.dialog;
        if (my != null) {
            my.o();
        }
        MY my2 = c23142wQ4.dialog;
        c23142wQ4.S8(pFMTag, 3, String.valueOf((my2 == null || (appCompatEditTextQ = my2.q()) == null) ? null : appCompatEditTextQ.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M8(C23142wQ4 c23142wQ4, View view) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        MY my = c23142wQ4.dialog;
        if (my != null) {
            my.o();
        }
    }

    private final String N8(D45 persianDate) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AbstractC16613la3.a(persianDate.u()));
        stringBuffer.append(":");
        stringBuffer.append(AbstractC16613la3.a(persianDate.v()));
        stringBuffer.append(" - ");
        stringBuffer.append(AbstractC16613la3.a(persianDate.C()));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(persianDate.B()));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(persianDate.A()));
        return XY6.e(stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ir.nasim.features.pfm.h O8() {
        return (ir.nasim.features.pfm.h) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P8(C23142wQ4 c23142wQ4, List list) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        TQ4 tq4 = null;
        if (list.isEmpty()) {
            TextView textView = c23142wQ4.tagNotFound;
            if (textView == null) {
                AbstractC13042fc3.y("tagNotFound");
                textView = null;
            }
            textView.setVisibility(0);
        } else {
            TextView textView2 = c23142wQ4.tagNotFound;
            if (textView2 == null) {
                AbstractC13042fc3.y("tagNotFound");
                textView2 = null;
            }
            textView2.setVisibility(8);
        }
        TQ4 tq42 = c23142wQ4.tagsAdapter;
        if (tq42 == null) {
            AbstractC13042fc3.y("tagsAdapter");
            tq42 = null;
        }
        tq42.C(list);
        TQ4 tq43 = c23142wQ4.tagsAdapter;
        if (tq43 == null) {
            AbstractC13042fc3.y("tagsAdapter");
        } else {
            tq4 = tq43;
        }
        tq4.notifyDataSetChanged();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q8(C23142wQ4 c23142wQ4, View view, boolean z) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        if (z) {
            AppBarLayout appBarLayout = c23142wQ4.pfmAppbar;
            if (appBarLayout == null) {
                AbstractC13042fc3.y("pfmAppbar");
                appBarLayout = null;
            }
            appBarLayout.setExpanded(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R8(C23142wQ4 c23142wQ4, View view) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        AppBarLayout appBarLayout = c23142wQ4.pfmAppbar;
        if (appBarLayout == null) {
            AbstractC13042fc3.y("pfmAppbar");
            appBarLayout = null;
        }
        appBarLayout.setExpanded(false, true);
    }

    private final void S8(PFMTag selectedTag, int labelAction, String newLabel) throws NumberFormatException {
        String amount;
        long j = 0;
        try {
            PFMTransaction pFMTransaction = this.pfmTransaction;
            if (pFMTransaction != null && (amount = pFMTransaction.getAmount()) != null) {
                j = Long.parseLong(amount);
            }
        } catch (Exception unused) {
        }
        Map mapP = AbstractC20051rO3.p(new XV4("label_type", selectedTag.getLabel()), new XV4("label_version", Integer.valueOf(selectedTag.getUserId() == 0 ? 1 : 2)), new XV4("accounting_type", Integer.valueOf(selectedTag.getTransactionType() == EnumC18897pR4.c ? 0 : 1)), new XV4("action_type", Integer.valueOf(labelAction)), new XV4("amount", Long.valueOf(j)));
        if (newLabel != null) {
            mapP.put("new_label", newLabel);
        }
        PFMTransaction pFMTransaction2 = this.pfmTransaction;
        if (pFMTransaction2 != null) {
            mapP.put("transaction_date", Long.valueOf(pFMTransaction2.getDate()));
        }
        C3343Am.i("pfm_label_page", mapP);
    }

    static /* synthetic */ void T8(C23142wQ4 c23142wQ4, PFMTag pFMTag, int i, String str, int i2, Object obj) throws NumberFormatException {
        if ((i2 & 4) != 0) {
            str = null;
        }
        c23142wQ4.S8(pFMTag, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ir.nasim.features.pfm.h U8(C23142wQ4 c23142wQ4) {
        AbstractC13042fc3.i(c23142wQ4, "this$0");
        FragmentActivity fragmentActivityQ7 = c23142wQ4.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (ir.nasim.features.pfm.h) new androidx.lifecycle.G(fragmentActivityQ7).b(ir.nasim.features.pfm.h.class);
    }

    @Override // ir.nasim.SQ4
    public void A1(PFMTag pfmTag) {
        AbstractC13042fc3.i(pfmTag, "pfmTag");
        PFMTransaction pFMTransaction = this.pfmTransaction;
        if (pFMTransaction != null) {
            O8().O1(pfmTag);
            C14142hQ4.Companion aVar = C14142hQ4.INSTANCE;
            Bundle bundleE5 = E5();
            C14142hQ4 c14142hQ4A = aVar.a(pFMTransaction, pfmTag, true, bundleE5 != null ? bundleE5.getBoolean("PFM_SET_TAG_FROM_SHREDDING") : false);
            Q7().B0().s().c(BC5.pfm_container, c14142hQ4A, c14142hQ4A.getClass().getSimpleName()).w(4097).g(null).h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void G6(Bundle savedInstanceState) {
        EnumC18897pR4 transactionType;
        List labels;
        PFMTag pFMTag;
        List labels2;
        PFMTag pFMTag2;
        List labels3;
        PFMTag pFMTag3;
        super.G6(savedInstanceState);
        ir.nasim.features.pfm.h hVarO8 = O8();
        PFMTransaction pFMTransaction = this.pfmTransaction;
        if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
            transactionType = EnumC18897pR4.b;
        }
        hVarO8.S2(transactionType);
        PFMTransaction pFMTransaction2 = this.pfmTransaction;
        if (pFMTransaction2 != null) {
            AbstractC13042fc3.f(pFMTransaction2);
            if (!pFMTransaction2.getLabels().isEmpty()) {
                PFMTransaction pFMTransaction3 = this.pfmTransaction;
                Long lValueOf = null;
                parentTag = null;
                parentTag = null;
                PFMTag parentTag = null;
                lValueOf = null;
                lValueOf = null;
                Boolean boolValueOf = (pFMTransaction3 == null || (labels3 = pFMTransaction3.getLabels()) == null || (pFMTag3 = (PFMTag) labels3.get(0)) == null) ? null : Boolean.valueOf(RQ4.a(pFMTag3));
                AbstractC13042fc3.f(boolValueOf);
                if (boolValueOf.booleanValue()) {
                    TQ4 tq4 = this.tagsAdapter;
                    if (tq4 == null) {
                        AbstractC13042fc3.y("tagsAdapter");
                        tq4 = null;
                    }
                    PFMTransaction pFMTransaction4 = this.pfmTransaction;
                    if (pFMTransaction4 != null && (labels2 = pFMTransaction4.getLabels()) != null && (pFMTag2 = (PFMTag) labels2.get(0)) != null) {
                        parentTag = pFMTag2.getParentTag();
                    }
                    AbstractC13042fc3.f(parentTag);
                    tq4.B(Long.valueOf(parentTag.getId()));
                } else {
                    TQ4 tq42 = this.tagsAdapter;
                    if (tq42 == null) {
                        AbstractC13042fc3.y("tagsAdapter");
                        tq42 = null;
                    }
                    PFMTransaction pFMTransaction5 = this.pfmTransaction;
                    if (pFMTransaction5 != null && (labels = pFMTransaction5.getLabels()) != null && (pFMTag = (PFMTag) labels.get(0)) != null) {
                        lValueOf = Long.valueOf(pFMTag.getId());
                    }
                    tq42.B(lValueOf);
                }
            }
        }
        O8().u2().j(p6(), new e(new UA2() { // from class: ir.nasim.nQ4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C23142wQ4.P8(this.a, (List) obj);
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        c8(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String description;
        AbstractC13042fc3.i(inflater, "inflater");
        Bundle bundleE5 = E5();
        TextView textView = null;
        this.pfmTransaction = bundleE5 != null ? (PFMTransaction) bundleE5.getParcelable("PFM_TRANSACTION") : null;
        View viewInflate = inflater.inflate(AbstractC12208eD5.pfm_set_tag_fragment, container, false);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        viewInflate.setBackgroundColor(c5495Jo7.r());
        this.tagsRecyclerView = (RecyclerView) viewInflate.findViewById(BC5.recycler_view_tags);
        BaleToolbar baleToolbar = (BaleToolbar) viewInflate.findViewById(BC5.set_tag_toolbar);
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        RecyclerView recyclerView = this.tagsRecyclerView;
        if (recyclerView == null) {
            AbstractC13042fc3.y("tagsRecyclerView");
            recyclerView = null;
        }
        recyclerView.setBackgroundColor(c5495Jo7.r());
        this.pfmAppbar = (AppBarLayout) viewInflate.findViewById(BC5.pfm_appbar);
        int i = this.ACTION_SIZE_ADAPTER;
        Bundle bundleE52 = E5();
        this.tagsAdapter = new TQ4(this, i, bundleE52 != null ? bundleE52.getBoolean("PFM_SET_TAG_FROM_SHREDDING") : false);
        RecyclerView recyclerView2 = this.tagsRecyclerView;
        if (recyclerView2 == null) {
            AbstractC13042fc3.y("tagsRecyclerView");
            recyclerView2 = null;
        }
        TQ4 tq4 = this.tagsAdapter;
        if (tq4 == null) {
            AbstractC13042fc3.y("tagsAdapter");
            tq4 = null;
        }
        recyclerView2.setAdapter(tq4);
        RecyclerView recyclerView3 = this.tagsRecyclerView;
        if (recyclerView3 == null) {
            AbstractC13042fc3.y("tagsRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(G5(), 1, false));
        viewInflate.findViewById(BC5.pfm_set_tag_inner_container).setBackgroundColor(c5495Jo7.X());
        viewInflate.findViewById(BC5.pfm_search_inner_container).setBackgroundColor(c5495Jo7.X());
        this.pfmTransactionType = (TextView) viewInflate.findViewById(BC5.pfm_transaction_type);
        this.pfmTransactionAmount = (TextView) viewInflate.findViewById(BC5.pfm_transaction_amount);
        this.pfmTransactionTime = (TextView) viewInflate.findViewById(BC5.pfm_transaction_time);
        this.pfmTransactionDescription = (TextView) viewInflate.findViewById(BC5.pfm_transaction_description);
        this.tagSearch = (EditText) viewInflate.findViewById(BC5.tag_search);
        TextView textView2 = this.pfmTransactionType;
        if (textView2 == null) {
            AbstractC13042fc3.y("pfmTransactionType");
            textView2 = null;
        }
        textView2.setTypeface(C6011Lu2.i());
        textView2.setTextColor(c5495Jo7.W());
        TextView textView3 = this.pfmTransactionAmount;
        if (textView3 == null) {
            AbstractC13042fc3.y("pfmTransactionAmount");
            textView3 = null;
        }
        textView3.setTypeface(C6011Lu2.i());
        textView3.setTextColor(c5495Jo7.g0());
        TextView textView4 = this.pfmTransactionDescription;
        if (textView4 == null) {
            AbstractC13042fc3.y("pfmTransactionDescription");
            textView4 = null;
        }
        textView4.setTypeface(C6011Lu2.k());
        textView4.setTextColor(c5495Jo7.U());
        TextView textView5 = this.pfmTransactionTime;
        if (textView5 == null) {
            AbstractC13042fc3.y("pfmTransactionTime");
            textView5 = null;
        }
        textView5.setTypeface(C6011Lu2.k());
        textView5.setTextColor(c5495Jo7.U());
        PFMTransaction pFMTransaction = this.pfmTransaction;
        if (pFMTransaction != null) {
            TextView textView6 = this.pfmTransactionAmount;
            if (textView6 == null) {
                AbstractC13042fc3.y("pfmTransactionAmount");
                textView6 = null;
            }
            textView6.setText(pFMTransaction.getAmount());
            TextView textView7 = this.pfmTransactionDescription;
            if (textView7 == null) {
                AbstractC13042fc3.y("pfmTransactionDescription");
                textView7 = null;
            }
            textView7.setText(pFMTransaction.getDescription());
            TextView textView8 = this.pfmTransactionTime;
            if (textView8 == null) {
                AbstractC13042fc3.y("pfmTransactionTime");
                textView8 = null;
            }
            textView8.setText(String.valueOf(pFMTransaction.getDate()));
            PFMTransaction pFMTransaction2 = this.pfmTransaction;
            AbstractC13042fc3.f(pFMTransaction2);
            EnumC18897pR4 transactionType = pFMTransaction2.getTransactionType();
            int i2 = transactionType == null ? -1 : b.a[transactionType.ordinal()];
            if (i2 == 1) {
                TextView textView9 = this.pfmTransactionType;
                if (textView9 == null) {
                    AbstractC13042fc3.y("pfmTransactionType");
                    textView9 = null;
                }
                textView9.setText(h6(AbstractC12217eE5.pfm_deposit));
                TextView textView10 = this.pfmTransactionType;
                if (textView10 == null) {
                    AbstractC13042fc3.y("pfmTransactionType");
                    textView10 = null;
                }
                textView10.setTextColor(c5495Jo7.f2());
            } else if (i2 == 2) {
                TextView textView11 = this.pfmTransactionType;
                if (textView11 == null) {
                    AbstractC13042fc3.y("pfmTransactionType");
                    textView11 = null;
                }
                textView11.setText(h6(AbstractC12217eE5.pfm_withdraw));
                TextView textView12 = this.pfmTransactionType;
                if (textView12 == null) {
                    AbstractC13042fc3.y("pfmTransactionType");
                    textView12 = null;
                }
                textView12.setTextColor(c5495Jo7.X0());
            }
            PFMTransaction pFMTransaction3 = this.pfmTransaction;
            String amount = pFMTransaction3 != null ? pFMTransaction3.getAmount() : null;
            String str = XY6.e(XY6.e(amount != null ? GY6.g(amount) : null)) + " ریال";
            TextView textView13 = this.pfmTransactionAmount;
            if (textView13 == null) {
                AbstractC13042fc3.y("pfmTransactionAmount");
                textView13 = null;
            }
            textView13.setText(str);
            TextView textView14 = this.pfmTransactionTime;
            if (textView14 == null) {
                AbstractC13042fc3.y("pfmTransactionTime");
                textView14 = null;
            }
            PFMTransaction pFMTransaction4 = this.pfmTransaction;
            textView14.setText(N8(new D45(pFMTransaction4 != null ? Long.valueOf(pFMTransaction4.getDate()) : null)));
            TextView textView15 = this.pfmTransactionDescription;
            if (textView15 == null) {
                AbstractC13042fc3.y("pfmTransactionDescription");
                textView15 = null;
            }
            PFMTransaction pFMTransaction5 = this.pfmTransaction;
            if (pFMTransaction5 == null || (description = pFMTransaction5.getDescription()) == null) {
                description = "";
            }
            textView15.setText(description);
        }
        EditText editText = this.tagSearch;
        if (editText == null) {
            AbstractC13042fc3.y("tagSearch");
            editText = null;
        }
        editText.addTextChangedListener(new c());
        EditText editText2 = this.tagSearch;
        if (editText2 == null) {
            AbstractC13042fc3.y("tagSearch");
            editText2 = null;
        }
        editText2.setTypeface(C6011Lu2.k());
        EditText editText3 = this.tagSearch;
        if (editText3 == null) {
            AbstractC13042fc3.y("tagSearch");
            editText3 = null;
        }
        editText3.setTextColor(c5495Jo7.g0());
        EditText editText4 = this.tagSearch;
        if (editText4 == null) {
            AbstractC13042fc3.y("tagSearch");
            editText4 = null;
        }
        editText4.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.oQ4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                C23142wQ4.Q8(this.a, view, z);
            }
        });
        EditText editText5 = this.tagSearch;
        if (editText5 == null) {
            AbstractC13042fc3.y("tagSearch");
            editText5 = null;
        }
        editText5.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.pQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23142wQ4.R8(this.a, view);
            }
        });
        TextView textView16 = (TextView) viewInflate.findViewById(BC5.tag_not_found);
        this.tagNotFound = textView16;
        if (textView16 == null) {
            AbstractC13042fc3.y("tagNotFound");
        } else {
            textView = textView16;
        }
        textView.setTypeface(C6011Lu2.k());
        textView.setTextColor(c5495Jo7.o0());
        return viewInflate;
    }

    @Override // ir.nasim.SQ4
    public void S3(final PFMTag pfmTag) throws NumberFormatException {
        AbstractC13042fc3.i(pfmTag, "pfmTag");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        MY myA = new NY(contextS7).B(h6(AbstractC12217eE5.edit_custom_tag_title)).E(4).j(false).p(KB5.pfm_default_tag).l(true).z(pfmTag.getLabel()).e(true).c(false).x(h6(AbstractC12217eE5.edit_custom_tag_btn)).u(h6(AbstractC12217eE5.negative_remove_custom_tag)).i("").v(new View.OnClickListener() { // from class: ir.nasim.qQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23142wQ4.J8(this.a, pfmTag, view);
            }
        }).s(new View.OnClickListener() { // from class: ir.nasim.rQ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C23142wQ4.M8(this.a, view);
            }
        }).a();
        this.dialog = myA;
        if (myA != null) {
            myA.z();
        }
        T8(this, pfmTag, 1, null, 4, null);
    }

    @Override // ir.nasim.SQ4
    public void U0() {
        Context contextG5;
        Map mapF = C23077wJ2.a.f();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapF.entrySet()) {
            if (((PFMTag) entry.getValue()).getUserId() != 0) {
                EnumC18897pR4 transactionType = ((PFMTag) entry.getValue()).getTransactionType();
                PFMTransaction pFMTransaction = this.pfmTransaction;
                if (transactionType == (pFMTransaction != null ? pFMTransaction.getTransactionType() : null)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (linkedHashMap.size() < this.LIMIT_CUSTOM_TAG) {
            Context contextS7 = S7();
            AbstractC13042fc3.h(contextS7, "requireContext(...)");
            MY myA = new NY(contextS7).B(h6(AbstractC12217eE5.add_custom_tag_title)).E(4).j(false).p(KB5.pfm_default_tag).l(true).e(true).c(false).v(new View.OnClickListener() { // from class: ir.nasim.sQ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C23142wQ4.F8(this.a, view);
                }
            }).s(new View.OnClickListener() { // from class: ir.nasim.tQ4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C23142wQ4.I8(this.a, view);
                }
            }).x(h6(AbstractC12217eE5.add_custom_tag_btn)).u(h6(AbstractC12217eE5.negative_remove_custom_tag)).d(true).i("").a();
            this.dialog = myA;
            if (myA != null) {
                myA.z();
                return;
            }
            return;
        }
        View viewO6 = o6();
        if (viewO6 == null || (contextG5 = G5()) == null) {
            return;
        }
        C17468n10 c17468n10 = new C17468n10(viewO6, null, 0, 6, null);
        String string = contextG5.getString(AbstractC12217eE5.error_msg_add_custom_tag);
        AbstractC13042fc3.h(string, "getString(...)");
        c17468n10.o(string);
    }

    @Override // ir.nasim.SQ4
    public void h3(PFMTag pfmTag) throws NumberFormatException {
        AbstractC13042fc3.i(pfmTag, "pfmTag");
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        AbstractC21375tZ.c(contextS7, interfaceC18633oz3P6, null, AbstractC19242q11.c(137083386, true, new d(pfmTag)), 4, null).show();
        T8(this, pfmTag, 2, null, 4, null);
    }

    /* renamed from: ir.nasim.wQ4$c */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EnumC18897pR4 transactionType;
            PFMTransaction pFMTransaction = C23142wQ4.this.pfmTransaction;
            if (pFMTransaction == null || (transactionType = pFMTransaction.getTransactionType()) == null) {
                return;
            }
            C23142wQ4 c23142wQ4 = C23142wQ4.this;
            if (charSequence == null || AbstractC20762sZ6.n0(charSequence)) {
                c23142wQ4.O8().Q1("", transactionType);
            } else {
                c23142wQ4.O8().Q1(AbstractC20762sZ6.n1(charSequence.toString()).toString(), transactionType);
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
