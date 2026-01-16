package ir.nasim.features.media.Cells;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.KB5;

/* loaded from: classes6.dex */
public class PhotoAttachCameraCell extends FrameLayout {
    public PhotoAttachCameraCell(Context context) {
        super(context);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(KB5.ic_camera_alt_white_24dp);
        addView(imageView, C14433hu3.a(80, 80.0f));
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a(86.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(80.0f), 1073741824));
    }
}
