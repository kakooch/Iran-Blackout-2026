package ir.eitaa.ui.Cells;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.Components.RadialProgressView;

/* loaded from: classes3.dex */
public class LocationLoadingCell extends FrameLayout {
    private ImageView imageView;
    private RadialProgressView progressBar;
    private TextView textView;

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (AndroidUtilities.dp(56.0f) * 2.5f), 1073741824));
    }

    public void setLoading(boolean value) {
        this.progressBar.setVisibility(value ? 0 : 4);
        this.textView.setVisibility(value ? 4 : 0);
        this.imageView.setVisibility(value ? 4 : 0);
    }
}
