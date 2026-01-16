package ir.nasim.designsystem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.AbstractC14008hB5;
import ir.nasim.C5495Jo7;

@Deprecated
/* loaded from: classes5.dex */
public class DividerView extends View {
    public DividerView(Context context) {
        super(context);
        a();
    }

    private void a() {
        C5495Jo7 c5495Jo7 = C5495Jo7.a;
        setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 12));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getResources().getDimensionPixelSize(AbstractC14008hB5.div_size));
    }

    public DividerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DividerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
