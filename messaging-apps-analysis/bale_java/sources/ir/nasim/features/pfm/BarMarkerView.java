package ir.nasim.features.pfm;

import android.content.Context;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4043Dl1;
import ir.nasim.BC5;
import ir.nasim.C5495Jo7;
import ir.nasim.GY6;
import ir.nasim.KB5;
import ir.nasim.MA;
import ir.nasim.Vb8;
import ir.nasim.XY6;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lir/nasim/features/pfm/BarMarkerView;", "Lcom/github/mikephil/charting/components/MarkerView;", "Landroid/content/Context;", "context", "", "layoutResource", "Lir/nasim/Vb8;", "xAxisFormatter", "", "", "amounts", "Lir/nasim/MA;", "transType", "<init>", "(Landroid/content/Context;ILir/nasim/Vb8;Ljava/util/List;Lir/nasim/MA;)V", "Lcom/github/mikephil/charting/data/Entry;", "e", "Lcom/github/mikephil/charting/highlight/Highlight;", "highlight", "Lir/nasim/rB7;", "refreshContent", "(Lcom/github/mikephil/charting/data/Entry;Lcom/github/mikephil/charting/highlight/Highlight;)V", "Lcom/github/mikephil/charting/utils/MPPointF;", "getOffset", "()Lcom/github/mikephil/charting/utils/MPPointF;", "d", "Lir/nasim/Vb8;", "Ljava/util/List;", "f", "Lir/nasim/MA;", "Landroid/widget/TextView;", "g", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "setDateTv", "(Landroid/widget/TextView;)V", "dateTv", "h", "getAmountTv", "setAmountTv", "amountTv", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "getRootView", "()Landroid/widget/LinearLayout;", "setRootView", "(Landroid/widget/LinearLayout;)V", "rootView", "j", TokenNames.I, "getCount", "()I", "setCount", "(I)V", "count", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class BarMarkerView extends MarkerView {

    /* renamed from: d, reason: from kotlin metadata */
    private final Vb8 xAxisFormatter;

    /* renamed from: e, reason: from kotlin metadata */
    private final List amounts;

    /* renamed from: f, reason: from kotlin metadata */
    private final MA transType;

    /* renamed from: g, reason: from kotlin metadata */
    private TextView dateTv;

    /* renamed from: h, reason: from kotlin metadata */
    private TextView amountTv;

    /* renamed from: i, reason: from kotlin metadata */
    private LinearLayout rootView;

    /* renamed from: j, reason: from kotlin metadata */
    private int count;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BarMarkerView(Context context, int i, Vb8 vb8, List list, MA ma) {
        super(context, i);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(vb8, "xAxisFormatter");
        AbstractC13042fc3.i(list, "amounts");
        AbstractC13042fc3.i(ma, "transType");
        this.xAxisFormatter = vb8;
        this.amounts = list;
        this.transType = ma;
        View viewFindViewById = findViewById(BC5.date_marker_view_tv);
        AbstractC13042fc3.h(viewFindViewById, "findViewById(...)");
        this.dateTv = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(BC5.amount_marker_view_tv);
        AbstractC13042fc3.h(viewFindViewById2, "findViewById(...)");
        this.amountTv = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(BC5.marker_view_root);
        AbstractC13042fc3.h(viewFindViewById3, "findViewById(...)");
        this.rootView = (LinearLayout) viewFindViewById3;
    }

    public final TextView getAmountTv() {
        return this.amountTv;
    }

    public final int getCount() {
        return this.count;
    }

    public final TextView getDateTv() {
        return this.dateTv;
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public MPPointF getOffset() {
        return this.count <= 14 ? new MPPointF((-getWidth()) / 5.0f, -getHeight()) : new MPPointF((-getWidth()) + (getWidth() / 5.5f), -getHeight());
    }

    @Override // android.view.View
    public final LinearLayout getRootView() {
        return this.rootView;
    }

    @Override // com.github.mikephil.charting.components.MarkerView, com.github.mikephil.charting.components.IMarker
    public void refreshContent(Entry e, Highlight highlight) {
        AbstractC13042fc3.i(e, "e");
        AbstractC13042fc3.i(highlight, "highlight");
        int x = (int) e.getX();
        this.count = x;
        String strE = XY6.e(GY6.g(String.valueOf(((Number) this.amounts.get(x)).longValue())));
        if (this.transType == MA.TOPUP) {
            this.amountTv.setText("واریز: " + strE + " ریال ");
        } else {
            this.amountTv.setText("برداشت: " + strE + " ریال ");
        }
        this.dateTv.setText(this.xAxisFormatter.getFormattedValue(e.getX()));
        if (e.getX() <= 14.0f) {
            if (C5495Jo7.a.J2()) {
                this.rootView.setBackground(AbstractC4043Dl1.f(getContext(), KB5.night_left_tooltip));
            } else {
                this.rootView.setBackground(AbstractC4043Dl1.f(getContext(), KB5.left_tooltip));
            }
        } else if (C5495Jo7.a.J2()) {
            this.rootView.setBackground(AbstractC4043Dl1.f(getContext(), KB5.night_right_tooltip));
        } else {
            this.rootView.setBackground(AbstractC4043Dl1.f(getContext(), KB5.right_tooltip));
        }
        super.refreshContent(e, highlight);
    }

    public final void setAmountTv(TextView textView) {
        AbstractC13042fc3.i(textView, "<set-?>");
        this.amountTv = textView;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public final void setDateTv(TextView textView) {
        AbstractC13042fc3.i(textView, "<set-?>");
        this.dateTv = textView;
    }

    public final void setRootView(LinearLayout linearLayout) {
        AbstractC13042fc3.i(linearLayout, "<set-?>");
        this.rootView = linearLayout;
    }
}
