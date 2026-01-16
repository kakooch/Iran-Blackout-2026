package ir.eitaa.ui.Cells;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RadialProgressView;

/* loaded from: classes3.dex */
public class LoadingCell extends FrameLayout {
    private int height;
    private RadialProgressView progressBar;

    public LoadingCell(Context context) {
        this(context, AndroidUtilities.dp(40.0f), AndroidUtilities.dp(54.0f));
    }

    public LoadingCell(Context context, int size, int h) {
        super(context);
        this.height = h;
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressBar = radialProgressView;
        radialProgressView.setSize(size);
        addView(this.progressBar, LayoutHelper.createFrame(-2, -2, 17));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }
}
