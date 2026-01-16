package ir.nasim.features.pfm.tags;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C19938rB7;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.GY6;
import ir.nasim.XY6;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0010"}, d2 = {"Lir/nasim/features/pfm/tags/PFMTransactionsInfoLayout;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "", "label", "", "amount", "<init>", "(Landroid/content/Context;Ljava/lang/String;J)V", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "textSubTagName", "b", "textSubTagAmount", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes6.dex */
public final class PFMTransactionsInfoLayout extends RelativeLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private final TextView textSubTagName;

    /* renamed from: b, reason: from kotlin metadata */
    private final TextView textSubTagAmount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PFMTransactionsInfoLayout(Context context, String str, long j) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(str, "label");
        TextView textView = new TextView(context);
        this.textSubTagName = textView;
        TextView textView2 = new TextView(context);
        this.textSubTagAmount = textView2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = C22078ud6.a(8.0f);
        setLayoutParams(layoutParams);
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        textView.setTextColor(c5495Jo7.K0());
        textView.setTypeface(C6011Lu2.i());
        textView.setTextSize(2, 12.0f);
        textView2.setTextColor(c5495Jo7.K0());
        textView2.setTypeface(C6011Lu2.i());
        textView2.setTextSize(2, 12.0f);
        textView.setText(str);
        textView.setGravity(8388611);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.alignWithParent = true;
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.addRule(12);
        C19938rB7 c19938rB7 = C19938rB7.a;
        addView(textView, layoutParams2);
        textView2.setText(XY6.e(GY6.g(String.valueOf(j))));
        textView2.setGravity(8388613);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.alignWithParent = true;
        layoutParams3.addRule(9);
        layoutParams3.addRule(10);
        layoutParams3.addRule(12);
        addView(textView2, layoutParams3);
    }
}
