package ir.nasim.features.media.Cells;

import android.content.Context;
import android.view.View;
import ir.nasim.C22078ud6;
import ir.nasim.KB5;

/* loaded from: classes6.dex */
public class ShadowSectionCell extends View {
    private int a;

    public ShadowSectionCell(Context context) {
        super(context);
        this.a = 12;
        setBackgroundResource(KB5.greydivider);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(this.a), 1073741824));
    }
}
