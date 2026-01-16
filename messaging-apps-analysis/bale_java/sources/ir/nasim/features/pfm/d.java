package ir.nasim.features.pfm;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.BC5;
import ir.nasim.C11690dR4;
import ir.nasim.C13542gP4;
import ir.nasim.C14142hQ4;
import ir.nasim.C19938rB7;
import ir.nasim.C22042ua0;
import ir.nasim.C23142wQ4;
import ir.nasim.C3343Am;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C6505Nu2;
import ir.nasim.C7965Ty2;
import ir.nasim.ED1;
import ir.nasim.EQ4;
import ir.nasim.EnumC15195jA1;
import ir.nasim.EnumC18897pR4;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC18633oz3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.MY;
import ir.nasim.NY;
import ir.nasim.RQ4;
import ir.nasim.SA2;
import ir.nasim.TA5;
import ir.nasim.UA2;
import ir.nasim.XV4;
import ir.nasim.XY6;
import ir.nasim.features.pfm.PFMSpinner;
import ir.nasim.features.pfm.entity.PFMTransaction;
import ir.nasim.features.pfm.j;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 B2\u00020\u0001:\u0001CB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J!\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u001d\u0010\u0017\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lir/nasim/features/pfm/d;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/rB7;", "T6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "va", "", "Lir/nasim/H75;", "accounts", "ua", "(Ljava/util/List;)V", "", "action", "ta", "(I)V", "", "isScroll", "fa", "(Z)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "ga", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "Lir/nasim/MY;", "c1", "Lir/nasim/MY;", "dialog", "Lir/nasim/features/pfm/h;", "d1", "Lir/nasim/Yu3;", "ia", "()Lir/nasim/features/pfm/h;", "viewModel", "Lir/nasim/Ty2;", "e1", "Lir/nasim/Ty2;", "_binding", "Lir/nasim/gP4;", "f1", "Lir/nasim/gP4;", "pfmAdapter", "Lir/nasim/Nu2;", "g1", "Lir/nasim/Nu2;", "footerAdapter", "Landroidx/recyclerview/widget/f;", "h1", "Landroidx/recyclerview/widget/f;", "concatAdapter", "ha", "()Lir/nasim/Ty2;", "binding", "i1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class d extends C22042ua0 {

    /* renamed from: i1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int j1 = 8;

    /* renamed from: c1, reason: from kotlin metadata */
    private MY dialog;

    /* renamed from: e1, reason: from kotlin metadata */
    private C7965Ty2 _binding;

    /* renamed from: f1, reason: from kotlin metadata */
    private C13542gP4 pfmAdapter;

    /* renamed from: h1, reason: from kotlin metadata */
    private androidx.recyclerview.widget.f concatAdapter;

    /* renamed from: d1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.GP4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ir.nasim.features.pfm.d.xa(this.a);
        }
    });

    /* renamed from: g1, reason: from kotlin metadata */
    private final C6505Nu2 footerAdapter = new C6505Nu2();

    /* renamed from: ir.nasim.features.pfm.d$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final d a() {
            d dVar = new d();
            dVar.a8(new Bundle());
            return dVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

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

    public static final class c extends RecyclerView.t {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            AbstractC13042fc3.i(recyclerView, "recyclerView");
            super.b(recyclerView, i, i2);
            if (d.this.ia().i2()) {
                return;
            }
            d dVar = d.this;
            RecyclerView.p layoutManager = recyclerView.getLayoutManager();
            AbstractC13042fc3.g(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            dVar.ga((LinearLayoutManager) layoutManager);
        }
    }

    /* renamed from: ir.nasim.features.pfm.d$d, reason: collision with other inner class name */
    public static final class C1207d implements AdapterView.OnItemSelectedListener {
        C1207d() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (d.this.ia().V1() != i) {
                d.this.ia().q3(i);
                d.this.ia().a3();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static final class e implements PFMSpinner.a {
        e() {
        }

        @Override // ir.nasim.features.pfm.PFMSpinner.a
        public void a(Spinner spinner) {
            d.this.ta(0);
            d.this.ha().k.setBackground(AbstractC4043Dl1.f(d.this.S7(), KB5.bg_spinner_pfm_up));
        }

        @Override // ir.nasim.features.pfm.PFMSpinner.a
        public void b(Spinner spinner) {
            d.this.ha().k.setBackground(AbstractC4043Dl1.f(d.this.S7(), KB5.bg_spinner_pfm_down));
        }
    }

    public static final class f extends ClickableSpan {
        f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            MY my = d.this.dialog;
            if (my != null) {
                my.o();
            }
            Fragment fragmentB = i.INSTANCE.b();
            d.this.Q7().B0().s().c(BC5.pfm_container, fragmentB, fragmentB.getClass().getSimpleName()).w(4097).g(null).h();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    private final void fa(boolean isScroll) {
        ViewGroup.LayoutParams layoutParams = ha().o.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        layoutParams2.g(isScroll ? 3 : 0);
        ha().o.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga(LinearLayoutManager layoutManager) {
        if (ia().l2().length() <= 0 || ia().z2().size() - layoutManager.g2() >= 15) {
            return;
        }
        this.footerAdapter.B(true);
        ia().W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C7965Ty2 ha() {
        C7965Ty2 c7965Ty2 = this._binding;
        AbstractC13042fc3.f(c7965Ty2);
        return c7965Ty2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h ia() {
        return (h) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(d dVar, View view) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.ta(1);
        new C11690dR4().K8(dVar.F5(), "PFMTime");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ka(d dVar, View view) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.ta(3);
        ir.nasim.features.pfm.f fVarA = ir.nasim.features.pfm.f.INSTANCE.a();
        dVar.Q7().B0().s().c(BC5.pfm_container, fVarA, fVarA.getClass().getSimpleName()).w(4097).g(null).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 la(d dVar, PFMTransaction pFMTransaction, PFMTag pFMTag) {
        AbstractC13042fc3.i(dVar, "this$0");
        AbstractC13042fc3.i(pFMTransaction, "pfmTransaction");
        if (pFMTag == null || !RQ4.a(pFMTag)) {
            dVar.ta(2);
            C23142wQ4 c23142wQ4B = C23142wQ4.Companion.b(C23142wQ4.INSTANCE, pFMTransaction, false, 2, null);
            dVar.Q7().B0().s().c(BC5.pfm_container, c23142wQ4B, c23142wQ4B.getClass().getSimpleName()).w(4097).g(null).h();
        } else {
            h hVarIa = dVar.ia();
            PFMTag parentTag = pFMTag.getParentTag();
            AbstractC13042fc3.f(parentTag);
            hVarIa.O1(parentTag);
            C14142hQ4 c14142hQ4B = C14142hQ4.Companion.b(C14142hQ4.INSTANCE, pFMTransaction, pFMTag.getParentTag(), false, false, 8, null);
            dVar.Q7().B0().s().c(BC5.pfm_container, c14142hQ4B, c14142hQ4B.getClass().getSimpleName()).w(4097).g(null).h();
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ma(d dVar, Fragment fragment) {
        AbstractC13042fc3.i(dVar, "this$0");
        AbstractC13042fc3.i(fragment, "it");
        C22042ua0.v9(dVar, BC5.pfm_container, fragment, "", true, false, 16, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 na(d dVar, List list) {
        AbstractC13042fc3.i(dVar, "this$0");
        AbstractC13042fc3.f(list);
        dVar.ua(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 oa(final d dVar, j jVar) {
        AbstractC13042fc3.i(dVar, "this$0");
        ConstraintLayout constraintLayout = dVar.ha().x;
        AbstractC13042fc3.h(constraintLayout, "pfmParentCs");
        constraintLayout.setVisibility(0);
        if (dVar.ia().W1() == EnumC15195jA1.d) {
            dVar.ha().p.setTextColor(AbstractC4043Dl1.c(dVar.S7(), TA5.itemSubtitle));
            dVar.ha().i.setColorFilter(AbstractC4043Dl1.c(dVar.S7(), TA5.itemSubtitle));
            dVar.ha().r.setStrokeWidth(AbstractC8943Xx1.c(0));
        } else {
            dVar.ha().p.setTextColor(AbstractC4043Dl1.c(dVar.S7(), TA5.buttonContent));
            dVar.ha().i.setColorFilter(AbstractC4043Dl1.c(dVar.S7(), TA5.buttonContent));
            dVar.ha().r.setStrokeColor(C5495Jo7.a.t2());
            dVar.ha().r.setStrokeWidth(AbstractC8943Xx1.c(2));
        }
        if (dVar.ia().x2() == EnumC18897pR4.b && dVar.ia().t2().isEmpty()) {
            dVar.ha().C.setTextColor(AbstractC4043Dl1.c(dVar.S7(), TA5.itemSubtitle));
            dVar.ha().j.setColorFilter(AbstractC4043Dl1.c(dVar.S7(), TA5.itemSubtitle));
            dVar.ha().t.setStrokeWidth(AbstractC8943Xx1.c(0));
        } else {
            dVar.ha().C.setTextColor(AbstractC4043Dl1.c(dVar.S7(), TA5.buttonContent));
            dVar.ha().j.setColorFilter(AbstractC4043Dl1.c(dVar.S7(), TA5.buttonContent));
            dVar.ha().t.setStrokeColor(C5495Jo7.a.t2());
            dVar.ha().t.setStrokeWidth(AbstractC8943Xx1.c(2));
        }
        if (jVar instanceof j.c) {
            ProgressBar progressBar = dVar.ha().w;
            AbstractC13042fc3.h(progressBar, "pfmListPb");
            progressBar.setVisibility(8);
            j.c cVar = (j.c) jVar;
            if (((List) cVar.a()).isEmpty()) {
                RecyclerView recyclerView = dVar.ha().z;
                AbstractC13042fc3.h(recyclerView, "pfmTransactionRecycler");
                recyclerView.setVisibility(8);
                TextView textView = dVar.ha().q;
                AbstractC13042fc3.h(textView, "pfmEmptyTransTv");
                textView.setVisibility(0);
                dVar.ha().m.setExpanded(true, true);
            } else {
                RecyclerView recyclerView2 = dVar.ha().z;
                AbstractC13042fc3.h(recyclerView2, "pfmTransactionRecycler");
                recyclerView2.setVisibility(0);
                TextView textView2 = dVar.ha().q;
                AbstractC13042fc3.h(textView2, "pfmEmptyTransTv");
                textView2.setVisibility(8);
            }
            CardView cardView = dVar.ha().v;
            AbstractC13042fc3.h(cardView, "pfmLayoutMali");
            cardView.setVisibility(0);
            dVar.ha().y.setVisibility(0);
            dVar.ha().b.setVisibility(0);
            dVar.va();
            dVar.fa(true);
            List listP1 = AbstractC15401jX0.p1((Collection) cVar.a());
            C13542gP4 c13542gP4 = dVar.pfmAdapter;
            if (c13542gP4 == null) {
                AbstractC13042fc3.y("pfmAdapter");
                c13542gP4 = null;
            }
            c13542gP4.C(listP1);
            dVar.footerAdapter.B(false);
            if (dVar.ia().n2()) {
                dVar.ha().z.post(new Runnable() { // from class: ir.nasim.HP4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ir.nasim.features.pfm.d.pa(this.a);
                    }
                });
            }
        } else if (jVar instanceof j.b) {
            ProgressBar progressBar2 = dVar.ha().w;
            AbstractC13042fc3.h(progressBar2, "pfmListPb");
            progressBar2.setVisibility(0);
            RecyclerView recyclerView3 = dVar.ha().z;
            AbstractC13042fc3.h(recyclerView3, "pfmTransactionRecycler");
            recyclerView3.setVisibility(8);
            TextView textView3 = dVar.ha().q;
            AbstractC13042fc3.h(textView3, "pfmEmptyTransTv");
            textView3.setVisibility(8);
            CardView cardView2 = dVar.ha().v;
            AbstractC13042fc3.h(cardView2, "pfmLayoutMali");
            cardView2.setVisibility(8);
            dVar.ha().b.setVisibility(8);
            dVar.fa(false);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(d dVar) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.ha().z.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 qa(d dVar, String str) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.ha().d.setText(XY6.c(XY6.e(str.toString()), (char) 0, 2, null));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ra(d dVar, String str) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.ha().c.setText(XY6.c(XY6.e(str.toString()), (char) 0, 2, null));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 sa(d dVar, String str) {
        AbstractC13042fc3.i(dVar, "this$0");
        dVar.ha().p.setText(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ta(int action) {
        XV4 xv4 = new XV4("action_type", Integer.valueOf(action));
        int i = b.a[ia().x2().ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            i2 = 2;
        }
        C3343Am.i("pfm_text_page", AbstractC20051rO3.n(xv4, new XV4("accounting_type", Integer.valueOf(i2))));
    }

    private final void ua(List accounts) {
        ha().k.setBackground(AbstractC4043Dl1.f(S7(), KB5.bg_spinner_pfm_down));
        ha().k.setDropDownVerticalOffset(AbstractC8943Xx1.c(78));
        PFMSpinner pFMSpinner = ha().k;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        pFMSpinner.setAdapter((SpinnerAdapter) new EQ4(contextS7, accounts));
        ha().k.setSelection(ia().V1(), true);
        ha().k.setOnItemSelectedListener(new C1207d());
        ha().k.setSpinnerEventsListener(new e());
    }

    private final void va() {
        final SpannableString spannableString = new SpannableString(h6(AbstractC12217eE5.pfm_calculation_method_content_full));
        int iK0 = AbstractC20762sZ6.k0(spannableString, (char) 171, 0, false, 6, null);
        int iK02 = AbstractC20762sZ6.k0(spannableString, (char) 187, 0, false, 6, null) + 1;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(C5495Jo7.a.h0());
        f fVar = new f();
        spannableString.setSpan(foregroundColorSpan, iK0, iK02, 33);
        spannableString.setSpan(fVar, iK0, iK02, 33);
        ha().b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.IP4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.d.wa(this.a, spannableString, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(d dVar, SpannableString spannableString, View view) {
        AbstractC13042fc3.i(dVar, "this$0");
        AbstractC13042fc3.i(spannableString, "$spannableString");
        dVar.ta(4);
        Context contextS7 = dVar.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        MY myB = new NY(contextS7).A(AbstractC12217eE5.pfm_calculation_method_title).i(spannableString).E(4).k(4).w(AbstractC12217eE5.understand).b(false);
        dVar.dialog = myB;
        if (myB != null) {
            myB.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h xa(d dVar) {
        AbstractC13042fc3.i(dVar, "this$0");
        FragmentActivity fragmentActivityQ7 = dVar.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (h) new G(fragmentActivityQ7).b(h.class);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C7965Ty2.c(inflater, container, false);
        LinearLayout root = ha().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        root.setBackgroundColor(c5495Jo7.r());
        C7965Ty2 c7965Ty2Ha = ha();
        c7965Ty2Ha.n.setTypeface(C6011Lu2.k());
        c7965Ty2Ha.n.setTextColor(c5495Jo7.a0());
        c7965Ty2Ha.q.setTypeface(C6011Lu2.k());
        c7965Ty2Ha.q.setTextColor(c5495Jo7.g1());
        return root;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void T6() {
        super.T6();
        this._binding = null;
    }

    @Override // ir.nasim.C23278wf0, androidx.fragment.app.Fragment
    public void h7() {
        super.h7();
        ha().k.setSelection(ia().V1(), true);
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        boolean z = ((T7().C0().get(0) instanceof d) || (T7().C0().get(0) instanceof ir.nasim.features.pfm.b)) ? false : true;
        InterfaceC18633oz3 interfaceC18633oz3P6 = p6();
        AbstractC13042fc3.h(interfaceC18633oz3P6, "getViewLifecycleOwner(...)");
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        C13542gP4 c13542gP4 = new C13542gP4(interfaceC18633oz3P6, z, fragmentActivityQ7, new InterfaceC14603iB2() { // from class: ir.nasim.JP4
            @Override // ir.nasim.InterfaceC14603iB2
            public final Object invoke(Object obj, Object obj2) {
                return ir.nasim.features.pfm.d.la(this.a, (PFMTransaction) obj, (PFMTag) obj2);
            }
        }, new UA2() { // from class: ir.nasim.KP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.d.ma(this.a, (Fragment) obj);
            }
        }, false, 32, null);
        this.pfmAdapter = c13542gP4;
        this.concatAdapter = new androidx.recyclerview.widget.f(c13542gP4, this.footerAdapter);
        ha().m.setExpanded(ia().n2());
        ConstraintLayout constraintLayout = ha().u;
        int iC = AbstractC4043Dl1.c(S7(), TA5.buttonBackground);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackground(AbstractC4310Eo7.j(iC, c5495Jo7.y0(c5495Jo7.n0(), 27), 0));
        ha().s.setBackground(AbstractC4310Eo7.j(AbstractC4043Dl1.c(S7(), TA5.buttonBackground), c5495Jo7.y0(c5495Jo7.n0(), 27), 0));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(S7());
        c cVar = new c();
        RecyclerView recyclerView = ha().z;
        androidx.recyclerview.widget.f fVar = this.concatAdapter;
        if (fVar == null) {
            AbstractC13042fc3.y("concatAdapter");
            fVar = null;
        }
        recyclerView.setAdapter(fVar);
        ha().z.setBackgroundColor(c5495Jo7.r());
        ha().z.setLayoutManager(linearLayoutManager);
        ha().z.addOnScrollListener(cVar);
        ia().R1().j(p6(), new ir.nasim.features.pfm.e(new UA2() { // from class: ir.nasim.LP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.d.na(this.a, (List) obj);
            }
        }));
        ia().y2().j(p6(), new ir.nasim.features.pfm.e(new UA2() { // from class: ir.nasim.MP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.d.oa(this.a, (ir.nasim.features.pfm.j) obj);
            }
        }));
        ia().I2().j(p6(), new ir.nasim.features.pfm.e(new UA2() { // from class: ir.nasim.NP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.d.qa(this.a, (String) obj);
            }
        }));
        ia().c2().j(p6(), new ir.nasim.features.pfm.e(new UA2() { // from class: ir.nasim.OP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.d.ra(this.a, (String) obj);
            }
        }));
        ia().X1().j(p6(), new ir.nasim.features.pfm.e(new UA2() { // from class: ir.nasim.PP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.d.sa(this.a, (String) obj);
            }
        }));
        ha().s.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.QP4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.d.ja(this.a, view2);
            }
        });
        ha().u.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.RP4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.d.ka(this.a, view2);
            }
        });
    }
}
