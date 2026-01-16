package ir.nasim.features.pfm;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.G;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.MPPointF;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC18050o01;
import ir.nasim.AbstractC19460qO3;
import ir.nasim.AbstractC20051rO3;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21263tO3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.AbstractC4616Fw7;
import ir.nasim.AbstractC8943Xx1;
import ir.nasim.BC5;
import ir.nasim.C10600bs7;
import ir.nasim.C11690dR4;
import ir.nasim.C16515lP4;
import ir.nasim.C19406qI3;
import ir.nasim.C19938rB7;
import ir.nasim.C22042ua0;
import ir.nasim.C3343Am;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.C8953Xy2;
import ir.nasim.C9663aL5;
import ir.nasim.D20;
import ir.nasim.ED1;
import ir.nasim.EQ4;
import ir.nasim.EnumC14437hu7;
import ir.nasim.EnumC15195jA1;
import ir.nasim.H46;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KB5;
import ir.nasim.MA;
import ir.nasim.MY;
import ir.nasim.NY;
import ir.nasim.SA2;
import ir.nasim.T10;
import ir.nasim.TA5;
import ir.nasim.UA2;
import ir.nasim.XV4;
import ir.nasim.XY6;
import ir.nasim.features.pfm.PFMSpinner;
import ir.nasim.features.pfm.j;
import ir.nasim.features.pfm.tags.PFMTag;
import java.math.RoundingMode;
import java.text.Bidi;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 h2\u00020\u0001:\u0001iB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J!\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0003J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010 J+\u0010%\u001a\u00020\r2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\"0!2\u0006\u0010$\u001a\u00020\u0018H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010 J7\u0010-\u001a\u00020\r2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0(2\b\b\u0002\u0010+\u001a\u00020\u001a2\b\b\u0002\u0010,\u001a\u00020\u001aH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u001f\u00105\u001a\u0002042\u0006\u00100\u001a\u00020/2\u0006\u00103\u001a\u00020\u001aH\u0002¢\u0006\u0004\b5\u00106J\u001f\u0010:\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u000204H\u0002¢\u0006\u0004\b:\u0010;J\u001d\u0010?\u001a\u00020\r2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<H\u0002¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\rH\u0002¢\u0006\u0004\bA\u0010\u0003R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010YR\"\u0010d\u001a\u00020]8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0014\u0010g\u001a\u00020O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006j"}, d2 = {"Lir/nasim/features/pfm/b;", "Lir/nasim/ua0;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "Q6", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lir/nasim/rB7;", "T6", "view", "l7", "(Landroid/view/View;Landroid/os/Bundle;)V", "h7", "Pa", "", "action", "Fa", "(I)V", "Lir/nasim/MA;", "transactionType", "", "animateIfNotEmpty", "Ra", "(Lir/nasim/MA;Z)V", "parentView", "Ka", "(Landroid/view/View;)V", "", "", "mutableMap", "transType", "Ga", "(Ljava/util/Map;Lir/nasim/MA;)V", "La", "", "Lir/nasim/features/pfm/tags/PFMTag;", "tags", "showLegendBullets", "animate", "Ha", "(Ljava/util/Map;ZZ)V", "", "percent", "ra", "(F)F", "rightToLeft", "", "oa", "(FZ)Ljava/lang/String;", "Landroid/text/SpannableStringBuilder;", ParameterNames.TEXT, "boldString", "ka", "(Landroid/text/SpannableStringBuilder;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;", "", "Lir/nasim/H75;", "accounts", "Ma", "(Ljava/util/List;)V", "Na", "Lir/nasim/features/pfm/h;", "c1", "Lir/nasim/Yu3;", "qa", "()Lir/nasim/features/pfm/h;", "viewModel", "d1", "Z", "showedFirstTooltip", "Lir/nasim/MY;", "e1", "Lir/nasim/MY;", "dialog", "Lir/nasim/Xy2;", "f1", "Lir/nasim/Xy2;", "_binding", "Lcom/github/mikephil/charting/charts/BarChart;", "g1", "Lcom/github/mikephil/charting/charts/BarChart;", "barChart", "Landroid/view/View$OnClickListener;", "h1", "Landroid/view/View$OnClickListener;", "clickListenerGoToTxTab", "i1", "clickListenerOpenDetailsTag", "Lcom/github/mikephil/charting/charts/PieChart;", "j1", "Lcom/github/mikephil/charting/charts/PieChart;", "pa", "()Lcom/github/mikephil/charting/charts/PieChart;", "Ja", "(Lcom/github/mikephil/charting/charts/PieChart;)V", "pieChart", "na", "()Lir/nasim/Xy2;", "binding", "k1", "a", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class b extends C22042ua0 {

    /* renamed from: k1, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int l1 = 8;

    /* renamed from: d1, reason: from kotlin metadata */
    private boolean showedFirstTooltip;

    /* renamed from: e1, reason: from kotlin metadata */
    private MY dialog;

    /* renamed from: f1, reason: from kotlin metadata */
    private C8953Xy2 _binding;

    /* renamed from: g1, reason: from kotlin metadata */
    private BarChart barChart;

    /* renamed from: j1, reason: from kotlin metadata */
    public PieChart pieChart;

    /* renamed from: c1, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 viewModel = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.DP4
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return ir.nasim.features.pfm.b.Ta(this.a);
        }
    });

    /* renamed from: h1, reason: from kotlin metadata */
    private final View.OnClickListener clickListenerGoToTxTab = new View.OnClickListener() { // from class: ir.nasim.nP4
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.pfm.b.la(this.a, view);
        }
    };

    /* renamed from: i1, reason: from kotlin metadata */
    private final View.OnClickListener clickListenerOpenDetailsTag = new View.OnClickListener() { // from class: ir.nasim.oP4
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ir.nasim.features.pfm.b.ma(this.a, view);
        }
    };

    /* renamed from: ir.nasim.features.pfm.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final b a() {
            b bVar = new b();
            bVar.a8(new Bundle());
            return bVar;
        }

        public /* synthetic */ Companion(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.features.pfm.b$b, reason: collision with other inner class name */
    public static final class C1206b implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AbstractC18050o01.d(Long.valueOf(((Number) ((XV4) obj).b()).longValue()), Long.valueOf(((Number) ((XV4) obj2).b()).longValue()));
        }
    }

    public static final class c implements AdapterView.OnItemSelectedListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            if (b.this.qa().V1() != i) {
                b.this.qa().q3(i);
                b.this.qa().a3();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static final class d implements PFMSpinner.a {
        d() {
        }

        @Override // ir.nasim.features.pfm.PFMSpinner.a
        public void a(Spinner spinner) {
            b.this.Fa(0);
            b.this.na().p.setBackground(AbstractC4043Dl1.f(b.this.S7(), KB5.bg_spinner_pfm_up));
        }

        @Override // ir.nasim.features.pfm.PFMSpinner.a
        public void b(Spinner spinner) {
            b.this.na().p.setBackground(AbstractC4043Dl1.f(b.this.S7(), KB5.bg_spinner_pfm_down));
        }
    }

    public static final class e extends ClickableSpan {
        e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            AbstractC13042fc3.i(view, "widget");
            MY my = b.this.dialog;
            if (my != null) {
                my.o();
            }
            C22042ua0.v9(b.this, BC5.pfm_container, i.INSTANCE.b(), null, false, false, 28, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            AbstractC13042fc3.i(textPaint, "ds");
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Aa(b bVar, String str) {
        AbstractC13042fc3.i(bVar, "this$0");
        bVar.na().t.setText(str);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ba(b bVar, Map map) {
        AbstractC13042fc3.i(bVar, "this$0");
        if (bVar.na().g.isChecked()) {
            AbstractC13042fc3.f(map);
            bVar.Ga(map, MA.WITHDRAW);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Ca(b bVar, Map map) {
        AbstractC13042fc3.i(bVar, "this$0");
        if (bVar.na().f.isChecked()) {
            AbstractC13042fc3.f(map);
            bVar.Ga(map, MA.TOPUP);
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(b bVar, View view) {
        AbstractC13042fc3.i(bVar, "this$0");
        bVar.Fa(1);
        new C11690dR4().K8(bVar.F5(), "PFMTime");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(C9663aL5 c9663aL5, b bVar) {
        AbstractC13042fc3.i(c9663aL5, "$firstListener");
        AbstractC13042fc3.i(bVar, "this$0");
        if (!c9663aL5.a || ((int) bVar.na().H.getY()) == 0 || ((int) bVar.na().B.getY()) == 0) {
            return;
        }
        c9663aL5.a = false;
        bVar.Na();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fa(int action) {
        C3343Am.i("pfm_diagram_page", AbstractC20051rO3.n(new XV4("action_type", Integer.valueOf(action)), new XV4("accounting_type", Integer.valueOf(!na().h.isChecked() ? 1 : 0))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void Ga(java.util.Map r17, ir.nasim.MA r18) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.pfm.b.Ga(java.util.Map, ir.nasim.MA):void");
    }

    private final void Ha(Map tags, boolean showLegendBullets, boolean animate) {
        Object objValueOf;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Map mapW = AbstractC20051rO3.w(AbstractC15401jX0.T0(AbstractC15401jX0.a1(AbstractC21263tO3.C(tags), new C1206b())));
        float fLongValue = 0.0f;
        while (mapW.entrySet().iterator().hasNext()) {
            fLongValue += ((Number) ((Map.Entry) r5.next()).getValue()).longValue();
        }
        new DecimalFormat("0.##").setRoundingMode(RoundingMode.HALF_DOWN);
        Iterator it = mapW.entrySet().iterator();
        while (it.hasNext()) {
            PFMTag pFMTag = (PFMTag) ((Map.Entry) it.next()).getKey();
            float fLongValue2 = fLongValue == 0.0f ? 0.0f : ((Number) r5.getValue()).longValue() / fLongValue;
            String strM = AbstractC20153rZ6.M(pFMTag.getLabel(), Separators.SP, " ", false, 4, null);
            if (showLegendBullets) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strM);
                String strOa = oa(fLongValue2, new Bidi(strM, -2).isRightToLeft());
                spannableStringBuilder.append((CharSequence) strOa);
                objValueOf = ka(spannableStringBuilder, strOa);
            } else {
                objValueOf = SpannableString.valueOf(pFMTag.getLabel());
            }
            if (fLongValue2 > 0.0f) {
                float fRa = ra(fLongValue2);
                arrayList3.add(objValueOf);
                arrayList2.add(Integer.valueOf(pFMTag.getColor()));
                arrayList.add(new PieEntry(fRa, objValueOf));
            }
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, "");
        pieDataSet.setValueTypeface(C6011Lu2.i());
        pieDataSet.setDrawIcons(false);
        pieDataSet.setSliceSpace(1.0f);
        pieDataSet.setIconsOffset(new MPPointF(0.0f, 40.0f));
        pieDataSet.setSelectionShift(5.0f);
        pieDataSet.setColors(arrayList2);
        if (showLegendBullets) {
            pa().getLegend().setForm(Legend.LegendForm.CIRCLE);
        } else {
            pa().getLegend().setForm(Legend.LegendForm.NONE);
        }
        PieData pieData = new PieData(pieDataSet);
        pieData.setDrawValues(false);
        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(11.0f);
        pieData.setValueTextColor(-1);
        pieData.setValueTypeface(C6011Lu2.i());
        pa().setData(pieData);
        if (showLegendBullets) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("● ");
                spannableStringBuilder3.append((CharSequence) arrayList3.get(i));
                spannableStringBuilder3.append((CharSequence) "    ");
                Object obj = arrayList2.get(i);
                AbstractC13042fc3.h(obj, "get(...)");
                spannableStringBuilder3.setSpan(new ForegroundColorSpan(((Number) obj).intValue()), 0, 1, 18);
                spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(9, true), 0, 1, 18);
                spannableStringBuilder2.append((CharSequence) spannableStringBuilder3);
            }
            if (na().D.getVisibility() != 0) {
                na().D.setVisibility(0);
                na().E.setVisibility(8);
            }
            na().D.setText(spannableStringBuilder2);
        } else {
            if (na().E.getVisibility() != 0) {
                na().E.setVisibility(0);
                na().D.setVisibility(8);
            }
            if (!arrayList3.isEmpty()) {
                na().E.setText((CharSequence) arrayList3.get(0));
            } else {
                na().E.setText("");
            }
        }
        pa().highlightValues(null);
        if (animate) {
            pa().animateXY(400, 400);
        } else {
            pa().invalidate();
        }
    }

    static /* synthetic */ void Ia(b bVar, Map map, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        bVar.Ha(map, z, z2);
    }

    private final void Ka(View parentView) {
        BarChart barChart = (BarChart) parentView.findViewById(BC5.pfm_bar_chart);
        this.barChart = barChart;
        BarChart barChart2 = null;
        if (barChart == null) {
            AbstractC13042fc3.y("barChart");
            barChart = null;
        }
        barChart.setDrawBarShadow(false);
        BarChart barChart3 = this.barChart;
        if (barChart3 == null) {
            AbstractC13042fc3.y("barChart");
            barChart3 = null;
        }
        barChart3.setDrawValueAboveBar(false);
        BarChart barChart4 = this.barChart;
        if (barChart4 == null) {
            AbstractC13042fc3.y("barChart");
            barChart4 = null;
        }
        barChart4.getDescription().setEnabled(false);
        BarChart barChart5 = this.barChart;
        if (barChart5 == null) {
            AbstractC13042fc3.y("barChart");
            barChart5 = null;
        }
        barChart5.setScaleEnabled(false);
        BarChart barChart6 = this.barChart;
        if (barChart6 == null) {
            AbstractC13042fc3.y("barChart");
            barChart6 = null;
        }
        barChart6.setDoubleTapToZoomEnabled(false);
        BarChart barChart7 = this.barChart;
        if (barChart7 == null) {
            AbstractC13042fc3.y("barChart");
            barChart7 = null;
        }
        barChart7.setMaxVisibleValueCount(60);
        BarChart barChart8 = this.barChart;
        if (barChart8 == null) {
            AbstractC13042fc3.y("barChart");
            barChart8 = null;
        }
        barChart8.setPinchZoom(false);
        BarChart barChart9 = this.barChart;
        if (barChart9 == null) {
            AbstractC13042fc3.y("barChart");
            barChart9 = null;
        }
        barChart9.setScaleEnabled(false);
        BarChart barChart10 = this.barChart;
        if (barChart10 == null) {
            AbstractC13042fc3.y("barChart");
            barChart10 = null;
        }
        barChart10.setDrawGridBackground(false);
        BarChart barChart11 = this.barChart;
        if (barChart11 == null) {
            AbstractC13042fc3.y("barChart");
            barChart11 = null;
        }
        XAxis xAxis = barChart11.getXAxis();
        AbstractC13042fc3.h(xAxis, "getXAxis(...)");
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(C6011Lu2.i());
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        xAxis.setTextColor(c5495Jo7.T0());
        xAxis.setTextSize(12.0f);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelRotationAngle(-90.0f);
        xAxis.setGranularity(1.0f);
        xAxis.setGranularityEnabled(true);
        xAxis.setLabelCount(8);
        BarChart barChart12 = this.barChart;
        if (barChart12 == null) {
            AbstractC13042fc3.y("barChart");
            barChart12 = null;
        }
        YAxis axisLeft = barChart12.getAxisLeft();
        AbstractC13042fc3.h(axisLeft, "getAxisLeft(...)");
        axisLeft.setTypeface(C6011Lu2.i());
        axisLeft.setTextColor(c5495Jo7.T0());
        axisLeft.setTextSize(10.0f);
        axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        axisLeft.setLabelCount(6, true);
        axisLeft.setSpaceTop(0.0f);
        BarChart barChart13 = this.barChart;
        if (barChart13 == null) {
            AbstractC13042fc3.y("barChart");
            barChart13 = null;
        }
        barChart13.getLegend().setEnabled(false);
        BarChart barChart14 = this.barChart;
        if (barChart14 == null) {
            AbstractC13042fc3.y("barChart");
            barChart14 = null;
        }
        barChart14.getAxisRight().setEnabled(false);
        BarChart barChart15 = this.barChart;
        if (barChart15 == null) {
            AbstractC13042fc3.y("barChart");
            barChart15 = null;
        }
        BarChart barChart16 = this.barChart;
        if (barChart16 == null) {
            AbstractC13042fc3.y("barChart");
            barChart16 = null;
        }
        BarChart barChart17 = this.barChart;
        if (barChart17 == null) {
            AbstractC13042fc3.y("barChart");
            barChart17 = null;
        }
        ChartAnimator animator = barChart17.getAnimator();
        BarChart barChart18 = this.barChart;
        if (barChart18 == null) {
            AbstractC13042fc3.y("barChart");
            barChart18 = null;
        }
        H46 h46 = new H46(barChart16, animator, barChart18.getViewPortHandler());
        h46.c(16);
        barChart15.setRenderer(h46);
        BarChart barChart19 = this.barChart;
        if (barChart19 == null) {
            AbstractC13042fc3.y("barChart");
            barChart19 = null;
        }
        barChart19.setFitBars(true);
        BarChart barChart20 = this.barChart;
        if (barChart20 == null) {
            AbstractC13042fc3.y("barChart");
            barChart20 = null;
        }
        barChart20.invalidate();
        BarChart barChart21 = this.barChart;
        if (barChart21 == null) {
            AbstractC13042fc3.y("barChart");
        } else {
            barChart2 = barChart21;
        }
        barChart2.setVisibility(8);
    }

    private final void La(View parentView) {
        Ja((PieChart) parentView.findViewById(BC5.pfm_pie_chart));
        pa().setUsePercentValues(true);
        pa().getDescription().setEnabled(false);
        pa().setDragDecelerationFrictionCoef(0.95f);
        pa().setDrawHoleEnabled(true);
        PieChart pieChartPa = pa();
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        pieChartPa.setHoleColor(c5495Jo7.X());
        pa().setTransparentCircleAlpha(110);
        pa().setHoleRadius(48.0f);
        pa().setTransparentCircleRadius(48.0f);
        pa().setTransparentCircleColor(c5495Jo7.r());
        pa().setRotationAngle(0.0f);
        pa().setRotationEnabled(false);
        pa().setHighlightPerTapEnabled(true);
        Legend legend = pa().getLegend();
        legend.setTextColor(AbstractC4043Dl1.c(S7(), TA5.itemTitle));
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setFormSize(7.0f);
        legend.setTypeface(C6011Lu2.i());
        legend.setTextSize(13.0f);
        legend.setDirection(Legend.LegendDirection.RIGHT_TO_LEFT);
        legend.setWordWrapEnabled(true);
        legend.setXEntrySpace(10.0f);
        legend.setEnabled(false);
        pa().setEntryLabelColor(-1);
        pa().setEntryLabelTypeface(C6011Lu2.k());
        pa().setEntryLabelTextSize(12.0f);
        pa().setDrawEntryLabels(false);
        pa().offsetLeftAndRight(0);
        pa().offsetTopAndBottom(0);
    }

    private final void Ma(List accounts) {
        na().p.setBackground(AbstractC4043Dl1.f(S7(), KB5.bg_spinner_pfm_down));
        na().p.setDropDownVerticalOffset(AbstractC8943Xx1.c(78));
        PFMSpinner pFMSpinner = na().p;
        Context contextS7 = S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        pFMSpinner.setAdapter((SpinnerAdapter) new EQ4(contextS7, accounts));
        na().p.setSelection(qa().V1(), true);
        na().p.setOnItemSelectedListener(new c());
        na().p.setSpinnerEventsListener(new d());
    }

    private final void Na() {
        if (((int) na().H.getY()) == 0 || ((int) na().B.getY()) == 0 || this.showedFirstTooltip || !qa().P2()) {
            return;
        }
        na().z.W(0, (int) ((na().H.getY() + na().B.getY()) - (na().getRoot().getMeasuredHeightAndState() / 2)), 1250);
        new Handler().postDelayed(new Runnable() { // from class: ir.nasim.pP4
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.features.pfm.b.Oa(this.a);
            }
        }, 1250);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(b bVar) {
        AbstractC13042fc3.i(bVar, "this$0");
        if (bVar.h9()) {
            C19406qI3.a("diagramFragment", "returned from showTooltip method because PFMDiagramFragment is destroyed", new Object[0]);
            return;
        }
        D20.a aVarA = C10600bs7.a.a(bVar);
        aVarA.X1("<b>مشاهده جزئیات  <br> </b>اکنون میتوانید جزئیات بیشتر از تراکنش\u200cهایتان را مشاهده کنید.");
        aVarA.c2(true);
        aVarA.a1(0.5f);
        aVarA.k2(200);
        aVarA.u1(100);
        aVarA.b2(5);
        D20 d20A = aVarA.a();
        TextView textView = bVar.na().H;
        AbstractC13042fc3.h(textView, "setTagText");
        D20.N0(d20A, textView, 0, 0, 6, null);
        bVar.qa().C3();
        bVar.showedFirstTooltip = true;
    }

    private final void Pa() {
        final SpannableString spannableString = new SpannableString(h6(AbstractC12217eE5.pfm_calculation_method_content_full));
        int iK0 = AbstractC20762sZ6.k0(spannableString, (char) 171, 0, false, 6, null);
        int iK02 = AbstractC20762sZ6.k0(spannableString, (char) 187, 0, false, 6, null) + 1;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(C5495Jo7.a.h0());
        e eVar = new e();
        spannableString.setSpan(foregroundColorSpan, iK0, iK02, 33);
        spannableString.setSpan(eVar, iK0, iK02, 33);
        na().e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.uP4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ir.nasim.features.pfm.b.Qa(this.a, spannableString, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(b bVar, SpannableString spannableString, View view) {
        AbstractC13042fc3.i(bVar, "this$0");
        AbstractC13042fc3.i(spannableString, "$spannableString");
        bVar.Fa(4);
        Context contextS7 = bVar.S7();
        AbstractC13042fc3.h(contextS7, "requireContext(...)");
        MY myB = new NY(contextS7).A(AbstractC12217eE5.pfm_calculation_method_title).i(spannableString).E(4).k(4).w(AbstractC12217eE5.understand).b(false);
        bVar.dialog = myB;
        if (myB != null) {
            myB.z();
        }
    }

    private final void Ra(MA transactionType, boolean animateIfNotEmpty) throws NumberFormatException {
        String strM2;
        Map mapK2;
        if (transactionType == MA.TOPUP) {
            strM2 = qa().g2();
            mapK2 = qa().e2();
        } else {
            strM2 = qa().M2();
            mapK2 = qa().K2();
        }
        Map mapA = AbstractC20051rO3.A(mapK2);
        if (mapA.isEmpty() && AbstractC13042fc3.d(strM2, "0")) {
            TextView textView = na().H;
            AbstractC13042fc3.h(textView, "setTagText");
            textView.setVisibility(8);
            String string = S7().getString(AbstractC12217eE5.pfm_empty_trans);
            AbstractC13042fc3.h(string, "getString(...)");
            Ia(this, AbstractC19460qO3.g(AbstractC4616Fw7.a(new PFMTag(0, 0L, string, null, null, 0, C5495Jo7.a.r(), null, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER, null), 100L)), false, false, 4, null);
            return;
        }
        long j = Long.parseLong(strM2);
        long jE1 = AbstractC15401jX0.e1(mapA.values());
        MA ma = MA.WITHDRAW;
        PFMTag pFMTag = new PFMTag(0, 0L, null, null, null, 0, transactionType == ma ? C5495Jo7.a.b2() : C5495Jo7.a.a2(), null, SetRpcStruct$ComposedRpc.START_PHONE_AUTH_FIELD_NUMBER, null);
        TextView textView2 = na().H;
        AbstractC13042fc3.h(textView2, "setTagText");
        textView2.setVisibility(0);
        if (mapA.isEmpty()) {
            na().H.setText(h6(AbstractC12217eE5.set_tag));
            na().H.setOnClickListener(this.clickListenerGoToTxTab);
        } else {
            if (transactionType == ma) {
                na().H.setText(h6(AbstractC12217eE5.see_detail_tags_withdraw));
            } else {
                na().H.setText(h6(AbstractC12217eE5.see_detail_tags_deposit));
            }
            na().H.setOnClickListener(this.clickListenerOpenDetailsTag);
        }
        na().H.invalidate();
        mapA.put(pFMTag, Long.valueOf(j - jE1));
        Ia(this, mapA, false, animateIfNotEmpty, 2, null);
    }

    static /* synthetic */ void Sa(b bVar, MA ma, boolean z, int i, Object obj) throws NumberFormatException {
        if ((i & 2) != 0) {
            z = false;
        }
        bVar.Ra(ma, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h Ta(b bVar) {
        AbstractC13042fc3.i(bVar, "this$0");
        FragmentActivity fragmentActivityQ7 = bVar.Q7();
        AbstractC13042fc3.h(fragmentActivityQ7, "requireActivity(...)");
        return (h) new G(fragmentActivityQ7).b(h.class);
    }

    private final SpannableStringBuilder ka(SpannableStringBuilder text, String boldString) {
        int iL0 = AbstractC20762sZ6.l0(text, boldString, 0, false, 6, null);
        text.setSpan(new T10(C6011Lu2.i()), iL0, boldString.length() + iL0, 33);
        text.setSpan(new RelativeSizeSpan(1.1f), iL0, boldString.length() + iL0, 33);
        text.setSpan(new ForegroundColorSpan(C5495Jo7.a.g0()), iL0, boldString.length() + iL0, 33);
        return text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void la(b bVar, View view) {
        AbstractC13042fc3.i(bVar, "this$0");
        bVar.qa().j2().p(Boolean.TRUE);
        bVar.Fa(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(b bVar, View view) {
        AbstractC13042fc3.i(bVar, "this$0");
        C22042ua0.v9(bVar, BC5.pfm_container, C16515lP4.INSTANCE.a(bVar.na().h.isChecked() ? EnumC14437hu7.a : EnumC14437hu7.b), null, false, false, 28, null);
        bVar.Fa(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C8953Xy2 na() {
        C8953Xy2 c8953Xy2 = this._binding;
        AbstractC13042fc3.f(c8953Xy2);
        return c8953Xy2;
    }

    private final String oa(float percent, boolean rightToLeft) {
        if (percent < 5.0E-5d) {
            return rightToLeft ? " %۰.۰۱>" : " <۰.۰۱%";
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        decimalFormat.setRoundingMode(RoundingMode.HALF_DOWN);
        return XY6.e(" %" + decimalFormat.format(Float.valueOf(percent * 100)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h qa() {
        return (h) this.viewModel.getValue();
    }

    private final float ra(float percent) {
        if (percent < 0.003f) {
            return 0.003f;
        }
        return percent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(b bVar, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(bVar, "this$0");
        if (z) {
            bVar.Ga(bVar.qa().Z1(), MA.TOPUP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(b bVar, CompoundButton compoundButton, boolean z) {
        AbstractC13042fc3.i(bVar, "this$0");
        if (z) {
            bVar.Ga(bVar.qa().G2(), MA.WITHDRAW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(b bVar, CompoundButton compoundButton, boolean z) throws NumberFormatException {
        AbstractC13042fc3.i(bVar, "this$0");
        if (z) {
            Sa(bVar, MA.TOPUP, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(b bVar, CompoundButton compoundButton, boolean z) throws NumberFormatException {
        AbstractC13042fc3.i(bVar, "this$0");
        if (z) {
            Sa(bVar, MA.WITHDRAW, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 wa(b bVar, List list) {
        AbstractC13042fc3.i(bVar, "this$0");
        AbstractC13042fc3.f(list);
        bVar.Ma(list);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 xa(b bVar, j jVar) throws NumberFormatException {
        AbstractC13042fc3.i(bVar, "this$0");
        if (jVar instanceof j.c) {
            bVar.Ra(bVar.na().h.isChecked() ? MA.TOPUP : MA.WITHDRAW, true);
        } else if (jVar instanceof j.a) {
            String string = bVar.S7().getString(AbstractC12217eE5.pfm_empty_trans);
            AbstractC13042fc3.h(string, "getString(...)");
            Ia(bVar, AbstractC19460qO3.g(AbstractC4616Fw7.a(new PFMTag(0, 0L, string, null, null, 0, C5495Jo7.a.r(), null, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER, null), 100L)), false, false, 4, null);
        } else {
            if (!AbstractC13042fc3.d(jVar, j.b.a)) {
                throw new NoWhenBranchMatchedException();
            }
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            Ia(bVar, AbstractC19460qO3.g(AbstractC4616Fw7.a(new PFMTag(0, 0L, Separators.SP, null, null, 0, c5495Jo7.r(), null, SetRpcStruct$ComposedRpc.GET_GROUP_DIFFERENCE_FIELD_NUMBER, null), 100L)), false, false, 4, null);
            bVar.na().J.setText("- ریال");
            bVar.na().J.setTextColor(c5495Jo7.r());
            bVar.na().I.setText("- ریال");
            bVar.na().I.setTextColor(c5495Jo7.r());
            TextView textView = bVar.na().H;
            AbstractC13042fc3.h(textView, "setTagText");
            if (textView.getVisibility() == 0) {
                TextView textView2 = bVar.na().H;
                AbstractC13042fc3.h(textView2, "setTagText");
                textView2.setVisibility(8);
            }
        }
        if (bVar.qa().W1() == EnumC15195jA1.d) {
            bVar.na().t.setTextColor(AbstractC4043Dl1.c(bVar.S7(), TA5.itemSubtitle));
            bVar.na().l.setColorFilter(AbstractC4043Dl1.c(bVar.S7(), TA5.itemSubtitle));
            bVar.na().w.setStrokeWidth(AbstractC8943Xx1.c(0));
        } else {
            bVar.na().t.setTextColor(AbstractC4043Dl1.c(bVar.S7(), TA5.buttonContent));
            bVar.na().l.setColorFilter(AbstractC4043Dl1.c(bVar.S7(), TA5.buttonContent));
            bVar.na().w.setStrokeColor(C5495Jo7.a.t2());
            bVar.na().w.setStrokeWidth(AbstractC8943Xx1.c(2));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 ya(b bVar, String str) {
        AbstractC13042fc3.i(bVar, "this$0");
        String strC = XY6.c(XY6.e(str.toString()), (char) 0, 2, null);
        bVar.na().J.setText(strC + " ریال ");
        bVar.na().J.setTextColor(C5495Jo7.a.g1());
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 za(b bVar, String str) {
        AbstractC13042fc3.i(bVar, "this$0");
        String strC = XY6.c(XY6.e(str.toString()), (char) 0, 2, null);
        bVar.na().I.setText(strC + " ریال ");
        bVar.na().I.setTextColor(C5495Jo7.a.g1());
        return C19938rB7.a;
    }

    public final void Ja(PieChart pieChart) {
        AbstractC13042fc3.i(pieChart, "<set-?>");
        this.pieChart = pieChart;
    }

    @Override // androidx.fragment.app.Fragment
    public View Q6(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AbstractC13042fc3.i(inflater, "inflater");
        this._binding = C8953Xy2.c(inflater, container, false);
        NestedScrollView root = na().getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        root.setBackgroundColor(c5495Jo7.r());
        Ka(root);
        La(root);
        RadioButton radioButton = (RadioButton) root.findViewById(BC5.diagram_type_top_up);
        RadioButton radioButton2 = (RadioButton) root.findViewById(BC5.diagram_type_withdraw);
        TextView textView = (TextView) root.findViewById(BC5.income_label);
        textView.setTextColor(c5495Jo7.U0());
        textView.setTypeface(C6011Lu2.i());
        TextView textView2 = (TextView) root.findViewById(BC5.expenditure_label);
        textView2.setTextColor(c5495Jo7.X0());
        textView2.setTypeface(C6011Lu2.i());
        TextView textView3 = (TextView) root.findViewById(BC5.top_up_value);
        textView3.setTextColor(c5495Jo7.g0());
        textView3.setTypeface(C6011Lu2.i());
        TextView textView4 = (TextView) root.findViewById(BC5.withdraw_value);
        textView4.setTextColor(c5495Jo7.g0());
        textView4.setTypeface(C6011Lu2.i());
        root.findViewById(BC5.items_divider).setBackgroundColor(c5495Jo7.T0());
        radioButton2.setChecked(true);
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.qP4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) throws NumberFormatException {
                ir.nasim.features.pfm.b.ua(this.a, compoundButton, z);
            }
        });
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.rP4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) throws NumberFormatException {
                ir.nasim.features.pfm.b.va(this.a, compoundButton, z);
            }
        });
        na().f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.sP4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ir.nasim.features.pfm.b.sa(this.a, compoundButton, z);
            }
        });
        na().g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ir.nasim.tP4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ir.nasim.features.pfm.b.ta(this.a, compoundButton, z);
            }
        });
        na().c.setTypeface(C6011Lu2.i());
        na().c.setTextColor(c5495Jo7.g1());
        na().b.setTypeface(C6011Lu2.k());
        na().b.setTextColor(c5495Jo7.f1());
        na().d.setTypeface(C6011Lu2.k());
        na().d.setTextColor(c5495Jo7.f1());
        na().D.setTypeface(C6011Lu2.k());
        na().D.setTextColor(c5495Jo7.f1());
        na().E.setTypeface(C6011Lu2.k());
        na().E.setTextColor(c5495Jo7.g0());
        na().H.setTypeface(C6011Lu2.i());
        na().H.setTextColor(c5495Jo7.a0());
        na().u.setVisibility(0);
        na().e.setVisibility(0);
        Pa();
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
        na().p.setSelection(qa().V1(), true);
        Na();
    }

    @Override // androidx.fragment.app.Fragment
    public void l7(View view, Bundle savedInstanceState) {
        AbstractC13042fc3.i(view, "view");
        super.l7(view, savedInstanceState);
        ConstraintLayout constraintLayout = na().x;
        int iC = AbstractC4043Dl1.c(S7(), TA5.buttonBackground);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        constraintLayout.setBackground(AbstractC4310Eo7.j(iC, c5495Jo7.y0(c5495Jo7.n0(), 27), 0));
        qa().R1().j(p6(), new ir.nasim.features.pfm.c(new UA2() { // from class: ir.nasim.mP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.b.wa(this.a, (List) obj);
            }
        }));
        qa().y2().j(p6(), new ir.nasim.features.pfm.c(new UA2() { // from class: ir.nasim.vP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.b.xa(this.a, (ir.nasim.features.pfm.j) obj);
            }
        }));
        qa().J2().j(p6(), new ir.nasim.features.pfm.c(new UA2() { // from class: ir.nasim.wP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.b.ya(this.a, (String) obj);
            }
        }));
        qa().d2().j(p6(), new ir.nasim.features.pfm.c(new UA2() { // from class: ir.nasim.xP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.b.za(this.a, (String) obj);
            }
        }));
        qa().X1().j(p6(), new ir.nasim.features.pfm.c(new UA2() { // from class: ir.nasim.yP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.b.Aa(this.a, (String) obj);
            }
        }));
        qa().H2().j(p6(), new ir.nasim.features.pfm.c(new UA2() { // from class: ir.nasim.zP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.b.Ba(this.a, (Map) obj);
            }
        }));
        qa().a2().j(p6(), new ir.nasim.features.pfm.c(new UA2() { // from class: ir.nasim.AP4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return ir.nasim.features.pfm.b.Ca(this.a, (Map) obj);
            }
        }));
        na().x.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.BP4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ir.nasim.features.pfm.b.Da(this.a, view2);
            }
        });
        final C9663aL5 c9663aL5 = new C9663aL5();
        c9663aL5.a = true;
        if (this.showedFirstTooltip) {
            return;
        }
        na().H.getViewTreeObserver().addOnDrawListener(new ViewTreeObserver.OnDrawListener() { // from class: ir.nasim.CP4
            @Override // android.view.ViewTreeObserver.OnDrawListener
            public final void onDraw() {
                ir.nasim.features.pfm.b.Ea(c9663aL5, this);
            }
        });
    }

    public final PieChart pa() {
        PieChart pieChart = this.pieChart;
        if (pieChart != null) {
            return pieChart;
        }
        AbstractC13042fc3.y("pieChart");
        return null;
    }
}
