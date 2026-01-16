package ir.nasim.tgwidgets.editor.ui.Cells;

import android.view.View;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;

/* loaded from: classes7.dex */
public class FixedHeightEmptyCell extends View {
    int a;

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AbstractC21455b.F(this.a), 1073741824));
    }
}
