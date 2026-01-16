package ir.nasim.features.pfm;

import android.R;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.C23077wJ2;
import ir.nasim.C3343Am;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C9442Zy2;
import ir.nasim.ED1;
import ir.nasim.EnumC14437hu7;
import ir.nasim.EnumC18897pR4;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.SA2;
import ir.nasim.XV4;
import ir.nasim.XY6;
import ir.nasim.components.appbar.view.BaleToolbar;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 j2\u00020\u0001:\u0001kB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0003J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u0003J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0018H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0002¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\u00042\b\b\u0002\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002¢\u0006\u0004\b)\u0010*J\u0019\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J+\u00104\u001a\u0002032\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00109\u001a\u00020\u00042\u0006\u00107\u001a\u0002062\u0006\u00100\u001a\u000208H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0004H\u0016¢\u0006\u0004\b;\u0010\u0003J\u0011\u0010<\u001a\u00020\n*\u00020\u0018¢\u0006\u0004\b<\u0010=R\u0016\u0010@\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010CR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\f0G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001c\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010IR\"\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010OR\"\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010OR\"\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010OR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010YR\u001b\u0010b\u001a\u00020]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lir/nasim/features/pfm/f;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Lir/nasim/rB7;", "Q8", "d9", "X8", "V8", "B8", "", "viewId", "Lir/nasim/features/pfm/tags/PFMTag;", "pfmTag", "I8", "(ILir/nasim/features/pfm/tags/PFMTag;)V", "C8", "J8", "N8", "O8", "P8", "G8", "F8", "H8", "", "showDeposit", "g9", "(Z)V", "e9", "", "query", "U8", "(Ljava/lang/String;)V", "rbId", "visibility", "W8", "(IZ)V", "K8", "()I", "x", "y", "R8", "(II)V", "Landroid/os/Bundle;", "savedInstanceState", "M6", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/view/Menu;", "menu", "Landroid/view/MenuInflater;", "P6", "(Landroid/view/Menu;Landroid/view/MenuInflater;)V", "R6", "f9", "(Z)I", "W0", TokenNames.I, "baseRbId", "Lir/nasim/pR4;", "X0", "Lir/nasim/pR4;", "transactionType", "Y0", "oldTransactionType", "", "Z0", "Ljava/util/List;", "selectedTag", "a1", "oldSelectedTag", "", "b1", "Ljava/util/Map;", "allDepositTags", "c1", "allWithdrawTags", "d1", "depositSelectedTag", "e1", "withdrawSelectedTag", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "f1", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "changeListenerDepositRb", "g1", "changeListenerWithdrawRb", "Lir/nasim/features/pfm/h;", "h1", "Lir/nasim/Yu3;", "M8", "()Lir/nasim/features/pfm/h;", "viewModel", "Lir/nasim/Zy2;", "i1", "Lir/nasim/Zy2;", "_binding", "L8", "()Lir/nasim/Zy2;", "binding", "j1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class f extends Fragment {

    /* renamed from: j1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int k1 = 8;

    /* renamed from: W0, reason: from kotlin metadata */
    private int baseRbId = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_COUNT_UPPER_BOUND;

    /* renamed from: X0, reason: from kotlin metadata */
    private EnumC18897pR4 transactionType;

    /* renamed from: Y0, reason: from kotlin metadata */
    private EnumC18897pR4 oldTransactionType;

    /* renamed from: Z0, reason: from kotlin metadata */
    private List selectedTag;

    /* renamed from: a1, reason: from kotlin metadata */
    private List oldSelectedTag;

    /* renamed from: b1, reason: from kotlin metadata */
    private Map allDepositTags;

    /* renamed from: c1, reason: from kotlin metadata */
    private Map allWithdrawTags;

    /* renamed from: d1, reason: from kotlin metadata */
    private Map depositSelectedTag;

    /* renamed from: e1, reason: from kotlin metadata */
    private Map withdrawSelectedTag;

    /* renamed from: f1, reason: from kotlin metadata */
    private final CompoundButton.OnCheckedChangeListener changeListenerDepositRb;

    /* renamed from: g1, reason: from kotlin metadata */
    private final CompoundButton.OnCheckedChangeListener changeListenerWithdrawRb;

    /* renamed from: h1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel;

    /* renamed from: i1, reason: from kotlin metadata */
    private C9442Zy2 _binding;

    /* renamed from: ir.nasim.features.pfm.f$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final f a() {
            return new f();
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
                iArr[EnumC18897pR4.b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC18897pR4.c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC18897pR4.d.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            f.this.U8(AbstractC20762sZ6.n1(String.valueOf(charSequence)).toString());
        }
    }

    public f() {
        EnumC18897pR4 enumC18897pR4 = EnumC18897pR4.b;
        this.transactionType = enumC18897pR4;
        this.oldTransactionType = enumC18897pR4;
        this.selectedTag = AbstractC10360bX0.m();
        this.oldSelectedTag = AbstractC10360bX0.m();
        this.allDepositTags = new LinkedHashMap();
        this.allWithdrawTags = new LinkedHashMap();
        this.depositSelectedTag = new LinkedHashMap();
        this.withdrawSelectedTag = new LinkedHashMap();
        this.changeListenerDepositRb = new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.jR4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ir.nasim.features.pfm.f.D8(this.a, compoundButton, z);
            }
        };
        this.changeListenerWithdrawRb = new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.kR4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ir.nasim.features.pfm.f.E8(this.a, compoundButton, z);
            }
        };
        this.viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.lR4
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return ir.nasim.features.pfm.f.h9(this.a);
            }
        });
    }

    private final void B8() {
        for (Map.Entry entry : this.allDepositTags.entrySet()) {
            I8(((Number) entry.getKey()).intValue(), (PFMTag) entry.getValue());
        }
    }

    private final void C8() {
        for (Map.Entry entry : this.allWithdrawTags.entrySet()) {
            J8(((Number) entry.getKey()).intValue(), (PFMTag) entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D8(f fVar, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(fVar, "this$0");
        if (compoundButton != null) {
            PFMTag pFMTag = (PFMTag) fVar.allDepositTags.get(Integer.valueOf(compoundButton.getId()));
            if (z) {
                if (pFMTag != null) {
                    fVar.depositSelectedTag.put(Integer.valueOf(compoundButton.getId()), pFMTag);
                }
                compoundButton.setTextColor(C5495Jo7.a.a0());
            } else {
                fVar.depositSelectedTag.remove(Integer.valueOf(compoundButton.getId()));
                compoundButton.setTextColor(C5495Jo7.a.f1());
            }
        }
        fVar.O8();
        fVar.N8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E8(f fVar, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(fVar, "this$0");
        if (compoundButton != null) {
            PFMTag pFMTag = (PFMTag) fVar.allWithdrawTags.get(Integer.valueOf(compoundButton.getId()));
            if (z) {
                if (pFMTag != null) {
                    fVar.withdrawSelectedTag.put(Integer.valueOf(compoundButton.getId()), pFMTag);
                }
                compoundButton.setTextColor(C5495Jo7.a.a0());
            } else {
                fVar.withdrawSelectedTag.remove(Integer.valueOf(compoundButton.getId()));
                compoundButton.setTextColor(C5495Jo7.a.f1());
            }
        }
        fVar.P8();
        fVar.N8();
    }

    private final void F8() {
        g9(false);
        Iterator it = AbstractC20051rO3.A(this.depositSelectedTag).entrySet().iterator();
        while (it.hasNext()) {
            ((ToggleButton) L8().getRoot().findViewById(((Number) ((Map.Entry) it.next()).getKey()).intValue())).setChecked(false);
        }
    }

    private final void G8() {
        Iterator it = AbstractC20051rO3.A(this.depositSelectedTag).entrySet().iterator();
        while (it.hasNext()) {
            ((ToggleButton) L8().getRoot().findViewById(((Number) ((Map.Entry) it.next()).getKey()).intValue())).setChecked(false);
        }
        Iterator it2 = AbstractC20051rO3.A(this.withdrawSelectedTag).entrySet().iterator();
        while (it2.hasNext()) {
            ((ToggleButton) L8().getRoot().findViewById(((Number) ((Map.Entry) it2.next()).getKey()).intValue())).setChecked(false);
        }
    }

    private final void H8() {
        g9(true);
        Iterator it = AbstractC20051rO3.A(this.withdrawSelectedTag).entrySet().iterator();
        while (it.hasNext()) {
            ((ToggleButton) L8().getRoot().findViewById(((Number) ((Map.Entry) it.next()).getKey()).intValue())).setChecked(false);
        }
    }

    private final void I8(int viewId, PFMTag pfmTag) {
        ToggleButton toggleButton = new ToggleButton(G5(), null, R.attr.borderlessButtonStyle);
        toggleButton.setId(viewId);
        toggleButton.setText(pfmTag.getLabel());
        toggleButton.setTextOff(null);
        toggleButton.setTextOn(null);
        toggleButton.setMinimumHeight(AbstractC8943Xx1.c(0));
        toggleButton.setMinHeight(AbstractC8943Xx1.c(0));
        toggleButton.setBackground(AbstractC4043Dl1.f(S7(), KB5.pfm_filter_radio_button_bg));
        toggleButton.setTextColor(C5495Jo7.a.f1());
        toggleButton.setTypeface(C6011Lu2.i());
        toggleButton.setTextSize(14.0f);
        toggleButton.setAllCaps(false);
        toggleButton.setPadding(AbstractC8943Xx1.c(16), AbstractC8943Xx1.c(6), AbstractC8943Xx1.c(16), AbstractC8943Xx1.c(6));
        toggleButton.setOnCheckedChangeListener(this.changeListenerDepositRb);
        if (this.selectedTag.contains(pfmTag)) {
            toggleButton.setChecked(true);
        }
        L8().f.getRoot().addView(toggleButton);
        L8().f.b.g(toggleButton);
    }

    private final void J8(int viewId, PFMTag pfmTag) {
        ToggleButton toggleButton = new ToggleButton(G5(), null, R.attr.borderlessButtonStyle);
        toggleButton.setId(viewId);
        toggleButton.setText(pfmTag.getLabel());
        toggleButton.setTextOff(null);
        toggleButton.setTextOn(null);
        toggleButton.setMinimumHeight(AbstractC8943Xx1.c(0));
        toggleButton.setMinHeight(AbstractC8943Xx1.c(0));
        toggleButton.setBackground(AbstractC4043Dl1.f(S7(), KB5.pfm_filter_radio_button_bg));
        toggleButton.setTextColor(C5495Jo7.a.f1());
        toggleButton.setTypeface(C6011Lu2.i());
        toggleButton.setTextSize(14.0f);
        toggleButton.setPadding(AbstractC8943Xx1.c(16), AbstractC8943Xx1.c(6), AbstractC8943Xx1.c(16), AbstractC8943Xx1.c(6));
        toggleButton.setOnCheckedChangeListener(this.changeListenerWithdrawRb);
        if (this.selectedTag.contains(pfmTag)) {
            toggleButton.setChecked(true);
        }
        L8().B.getRoot().addView(toggleButton);
        L8().B.b.g(toggleButton);
    }

    private final int K8() {
        int i = this.baseRbId + 1;
        this.baseRbId = i;
        return i;
    }

    private final C9442Zy2 L8() {
        C9442Zy2 c9442Zy2 = this._binding;
        AbstractC13042fc3.f(c9442Zy2);
        return c9442Zy2;
    }

    private final h M8() {
        return (h) this.viewModel.getValue();
    }

    private final void N8() {
        if (this.depositSelectedTag.isEmpty() && this.withdrawSelectedTag.isEmpty()) {
            L8().o.setEnabled(false);
            L8().o.setTextColor(C5495Jo7.a.e0());
            L8().p.setText(XY6.e("0"));
        } else {
            L8().p.setText(XY6.e(String.valueOf(this.depositSelectedTag.size() + this.withdrawSelectedTag.size())));
            L8().o.setEnabled(true);
            L8().o.setTextColor(C5495Jo7.a.a0());
        }
    }

    private final void O8() {
        if (this.depositSelectedTag.isEmpty()) {
            L8().c.setText("");
        } else {
            L8().c.setText(i6(AbstractC12217eE5.pfm_tag_filter_count, XY6.e(String.valueOf(this.depositSelectedTag.size()))));
        }
    }

    private final void P8() {
        if (this.withdrawSelectedTag.isEmpty()) {
            L8().y.setText("");
        } else {
            L8().y.setText(i6(AbstractC12217eE5.pfm_tag_filter_count, XY6.e(String.valueOf(this.withdrawSelectedTag.size()))));
        }
    }

    private final void Q8() {
        h hVarM8 = M8();
        this.transactionType = hVarM8.x2();
        this.oldTransactionType = hVarM8.x2();
        this.selectedTag = hVarM8.t2();
        this.oldSelectedTag = hVarM8.t2();
        Iterator it = C23077wJ2.h(EnumC18897pR4.c).iterator();
        while (it.hasNext()) {
            this.allDepositTags.put(Integer.valueOf(K8()), (PFMTag) it.next());
        }
        Iterator it2 = C23077wJ2.h(EnumC18897pR4.d).iterator();
        while (it2.hasNext()) {
            this.allWithdrawTags.put(Integer.valueOf(K8()), (PFMTag) it2.next());
        }
        this.allDepositTags.put(Integer.valueOf(K8()), C23077wJ2.d(EnumC14437hu7.a));
        this.allWithdrawTags.put(Integer.valueOf(K8()), C23077wJ2.d(EnumC14437hu7.b));
    }

    private final void R8(final int x, final int y) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: ir.nasim.mR4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.f.T8(this.a, x, y);
            }
        }, 400L);
    }

    static /* synthetic */ void S8(f fVar, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        fVar.R8(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T8(f fVar, int i, int i2) {
        AbstractC13042fc3.i(fVar, "this$0");
        fVar.L8().i.V(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U8(String query) {
        int iF9;
        int iF92;
        if (query.length() == 0) {
            TextView textView = L8().j;
            AbstractC13042fc3.h(textView, "noFindTag");
            textView.setVisibility(8);
            Iterator it = this.allDepositTags.entrySet().iterator();
            while (it.hasNext()) {
                W8(((Number) ((Map.Entry) it.next()).getKey()).intValue(), true);
            }
            Iterator it2 = this.allWithdrawTags.entrySet().iterator();
            while (it2.hasNext()) {
                W8(((Number) ((Map.Entry) it2.next()).getKey()).intValue(), true);
            }
            return;
        }
        int i = b.a[this.transactionType.ordinal()];
        if (i == 1) {
            iF9 = 0;
            for (Map.Entry entry : this.allDepositTags.entrySet()) {
                boolean zX = AbstractC20762sZ6.X(((PFMTag) entry.getValue()).getLabel(), query, false, 2, null);
                iF9 += f9(zX);
                W8(((Number) entry.getKey()).intValue(), zX);
            }
            iF92 = 0;
            for (Map.Entry entry2 : this.allWithdrawTags.entrySet()) {
                boolean zX2 = AbstractC20762sZ6.X(((PFMTag) entry2.getValue()).getLabel(), query, false, 2, null);
                iF92 += f9(zX2);
                W8(((Number) entry2.getKey()).intValue(), zX2);
            }
        } else if (i == 2) {
            iF9 = 0;
            for (Map.Entry entry3 : this.allDepositTags.entrySet()) {
                boolean zX3 = AbstractC20762sZ6.X(((PFMTag) entry3.getValue()).getLabel(), query, false, 2, null);
                iF9 += f9(zX3);
                W8(((Number) entry3.getKey()).intValue(), zX3);
            }
            iF92 = 0;
        } else if (i != 3) {
            iF9 = 0;
            iF92 = 0;
        } else {
            int iF93 = 0;
            for (Map.Entry entry4 : this.allWithdrawTags.entrySet()) {
                boolean zX4 = AbstractC20762sZ6.X(((PFMTag) entry4.getValue()).getLabel(), query, false, 2, null);
                iF93 += f9(zX4);
                W8(((Number) entry4.getKey()).intValue(), zX4);
            }
            iF92 = iF93;
            iF9 = 0;
        }
        if (iF9 == 0 && iF92 == 0) {
            TextView textView2 = L8().j;
            AbstractC13042fc3.h(textView2, "noFindTag");
            textView2.setVisibility(0);
            TextView textView3 = L8().e;
            AbstractC13042fc3.h(textView3, "depositFilterTitle");
            textView3.setVisibility(8);
            TextView textView4 = L8().c;
            AbstractC13042fc3.h(textView4, "depositFilterCounter");
            textView4.setVisibility(8);
            ConstraintLayout root = L8().f.getRoot();
            AbstractC13042fc3.h(root, "getRoot(...)");
            root.setVisibility(8);
            TextView textView5 = L8().A;
            AbstractC13042fc3.h(textView5, "withdrawFilterTitle");
            textView5.setVisibility(8);
            TextView textView6 = L8().y;
            AbstractC13042fc3.h(textView6, "withdrawFilterCounter");
            textView6.setVisibility(8);
            ConstraintLayout root2 = L8().B.getRoot();
            AbstractC13042fc3.h(root2, "getRoot(...)");
            root2.setVisibility(8);
            return;
        }
        if (iF9 == 0 && iF92 != 0) {
            TextView textView7 = L8().j;
            AbstractC13042fc3.h(textView7, "noFindTag");
            textView7.setVisibility(8);
            TextView textView8 = L8().e;
            AbstractC13042fc3.h(textView8, "depositFilterTitle");
            textView8.setVisibility(8);
            TextView textView9 = L8().c;
            AbstractC13042fc3.h(textView9, "depositFilterCounter");
            textView9.setVisibility(8);
            ConstraintLayout root3 = L8().f.getRoot();
            AbstractC13042fc3.h(root3, "getRoot(...)");
            root3.setVisibility(8);
            TextView textView10 = L8().A;
            AbstractC13042fc3.h(textView10, "withdrawFilterTitle");
            textView10.setVisibility(0);
            TextView textView11 = L8().y;
            AbstractC13042fc3.h(textView11, "withdrawFilterCounter");
            textView11.setVisibility(0);
            ConstraintLayout root4 = L8().B.getRoot();
            AbstractC13042fc3.h(root4, "getRoot(...)");
            root4.setVisibility(0);
            return;
        }
        if (iF9 == 0 || iF92 != 0) {
            TextView textView12 = L8().j;
            AbstractC13042fc3.h(textView12, "noFindTag");
            textView12.setVisibility(8);
            TextView textView13 = L8().e;
            AbstractC13042fc3.h(textView13, "depositFilterTitle");
            textView13.setVisibility(0);
            TextView textView14 = L8().c;
            AbstractC13042fc3.h(textView14, "depositFilterCounter");
            textView14.setVisibility(0);
            ConstraintLayout root5 = L8().f.getRoot();
            AbstractC13042fc3.h(root5, "getRoot(...)");
            root5.setVisibility(0);
            TextView textView15 = L8().A;
            AbstractC13042fc3.h(textView15, "withdrawFilterTitle");
            textView15.setVisibility(0);
            TextView textView16 = L8().y;
            AbstractC13042fc3.h(textView16, "withdrawFilterCounter");
            textView16.setVisibility(0);
            ConstraintLayout root6 = L8().B.getRoot();
            AbstractC13042fc3.h(root6, "getRoot(...)");
            root6.setVisibility(0);
            return;
        }
        TextView textView17 = L8().j;
        AbstractC13042fc3.h(textView17, "noFindTag");
        textView17.setVisibility(8);
        TextView textView18 = L8().e;
        AbstractC13042fc3.h(textView18, "depositFilterTitle");
        textView18.setVisibility(0);
        TextView textView19 = L8().c;
        AbstractC13042fc3.h(textView19, "depositFilterCounter");
        textView19.setVisibility(0);
        ConstraintLayout root7 = L8().f.getRoot();
        AbstractC13042fc3.h(root7, "getRoot(...)");
        root7.setVisibility(0);
        TextView textView20 = L8().A;
        AbstractC13042fc3.h(textView20, "withdrawFilterTitle");
        textView20.setVisibility(8);
        TextView textView21 = L8().y;
        AbstractC13042fc3.h(textView21, "withdrawFilterCounter");
        textView21.setVisibility(8);
        ConstraintLayout root8 = L8().B.getRoot();
        AbstractC13042fc3.h(root8, "getRoot(...)");
        root8.setVisibility(8);
    }

    private final void V8() {
        EnumC18897pR4 enumC18897pR4X2 = M8().x2();
        int size = M8().t2().size();
        int i = b.a[enumC18897pR4X2.ordinal()];
        int i2 = 2;
        if (i == 2) {
            i2 = 0;
        } else if (i == 3) {
            i2 = 1;
        }
        C3343Am.i("pfm_text_page_filter", AbstractC20051rO3.n(new XV4("transaction_type", Integer.valueOf(i2)), new XV4("label_qty", Integer.valueOf(size))));
    }

    private final void W8(int rbId, boolean visibility) {
        View viewFindViewById = L8().getRoot().findViewById(rbId);
        AbstractC13042fc3.f(viewFindViewById);
        viewFindViewById.setVisibility(visibility ? 0 : 8);
    }

    private final void X8() {
        L8().h.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.eR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.f.Y8(this.a, view);
            }
        });
        L8().v.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: ir.nasim.fR4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                ir.nasim.features.pfm.f.Z8(this.a, radioGroup, i);
            }
        });
        L8().o.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.gR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.f.a9(this.a, view);
            }
        });
        L8().r.addTextChangedListener(new c());
        L8().r.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.hR4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                ir.nasim.features.pfm.f.b9(this.a, view, z);
            }
        });
        L8().r.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.iR4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.f.c9(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y8(f fVar, View view) {
        AbstractC13042fc3.i(fVar, "this$0");
        fVar.M8().I3(fVar.transactionType);
        fVar.M8().H3(AbstractC15401jX0.R0(fVar.depositSelectedTag.values(), fVar.withdrawSelectedTag.values()));
        fVar.M8().a3();
        fVar.Q7().onBackPressed();
        fVar.V8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z8(f fVar, RadioGroup radioGroup, int i) {
        AbstractC13042fc3.i(fVar, "this$0");
        if (i == fVar.L8().b.getId()) {
            fVar.transactionType = EnumC18897pR4.b;
            fVar.e9();
        } else if (i == fVar.L8().d.getId()) {
            fVar.transactionType = EnumC18897pR4.c;
            fVar.H8();
        } else if (i == fVar.L8().z.getId()) {
            fVar.transactionType = EnumC18897pR4.d;
            fVar.F8();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a9(f fVar, View view) {
        AbstractC13042fc3.i(fVar, "this$0");
        fVar.G8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b9(f fVar, View view, boolean z) {
        AbstractC13042fc3.i(fVar, "this$0");
        if (z) {
            S8(fVar, 0, fVar.L8().u.getTop(), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c9(f fVar, View view) {
        AbstractC13042fc3.i(fVar, "this$0");
        S8(fVar, 0, fVar.L8().u.getTop(), 1, null);
    }

    private final void d9() {
        L8().r.setTypeface(C6011Lu2.k());
        L8().r.setTextColor(C5495Jo7.a.g0());
        BaleToolbar baleToolbar = L8().n;
        FragmentActivity fragmentActivityQ7 = Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        BaleToolbar.setHasBackButton$default(baleToolbar, fragmentActivityQ7, true, false, 4, null);
        int i = b.a[this.transactionType.ordinal()];
        if (i == 1) {
            L8().b.setChecked(true);
        } else if (i == 2) {
            L8().d.setChecked(true);
        } else if (i == 3) {
            L8().z.setChecked(true);
        }
        B8();
        C8();
    }

    private final void e9() {
        ConstraintLayout root = L8().f.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        if (root.getVisibility() != 0) {
            TextView textView = L8().e;
            AbstractC13042fc3.h(textView, "depositFilterTitle");
            textView.setVisibility(0);
            TextView textView2 = L8().c;
            AbstractC13042fc3.h(textView2, "depositFilterCounter");
            textView2.setVisibility(0);
            ConstraintLayout root2 = L8().f.getRoot();
            AbstractC13042fc3.h(root2, "getRoot(...)");
            root2.setVisibility(0);
        }
        ConstraintLayout root3 = L8().B.getRoot();
        AbstractC13042fc3.h(root3, "getRoot(...)");
        if (root3.getVisibility() == 0) {
            return;
        }
        TextView textView3 = L8().A;
        AbstractC13042fc3.h(textView3, "withdrawFilterTitle");
        textView3.setVisibility(0);
        TextView textView4 = L8().y;
        AbstractC13042fc3.h(textView4, "withdrawFilterCounter");
        textView4.setVisibility(0);
        ConstraintLayout root4 = L8().B.getRoot();
        AbstractC13042fc3.h(root4, "getRoot(...)");
        root4.setVisibility(0);
    }

    private final void g9(boolean showDeposit) {
        TextView textView = L8().e;
        AbstractC13042fc3.h(textView, "depositFilterTitle");
        textView.setVisibility(showDeposit ? 0 : 8);
        TextView textView2 = L8().c;
        AbstractC13042fc3.h(textView2, "depositFilterCounter");
        textView2.setVisibility(showDeposit ? 0 : 8);
        ConstraintLayout root = L8().f.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        root.setVisibility(showDeposit ? 0 : 8);
        TextView textView3 = L8().A;
        AbstractC13042fc3.h(textView3, "withdrawFilterTitle");
        textView3.setVisibility(showDeposit ^ true ? 0 : 8);
        TextView textView4 = L8().y;
        AbstractC13042fc3.h(textView4, "withdrawFilterCounter");
        textView4.setVisibility(showDeposit ^ true ? 0 : 8);
        ConstraintLayout root2 = L8().B.getRoot();
        AbstractC13042fc3.h(root2, "getRoot(...)");
        root2.setVisibility(showDeposit ^ true ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h h9(f fVar) {
        AbstractC13042fc3.i(fVar, "this$0");
        FragmentActivity fragmentActivityQ7 = fVar.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (h) new G(fragmentActivityQ7).b(h.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void M6(Bundle savedInstanceState) {
        super.M6(savedInstanceState);
        c8(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void P6(Menu menu, MenuInflater inflater) {
        AbstractC13042fc3.i(menu, "menu");
        AbstractC13042fc3.i(inflater, "inflater");
        menu.clear();
        super.P6(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C9442Zy2.c(inflater, container, false);
        L8().getRoot().setBackgroundColor(C5495Jo7.a.j());
        Q8();
        X8();
        d9();
        RelativeLayout root = L8().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void R6() {
        super.R6();
        this._binding = null;
    }

    public final int f9(boolean z) {
        return z ? 1 : 0;
    }
}
