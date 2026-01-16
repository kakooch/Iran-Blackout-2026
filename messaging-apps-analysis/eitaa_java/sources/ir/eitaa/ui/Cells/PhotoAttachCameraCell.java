package ir.eitaa.ui.Cells;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import java.io.File;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class PhotoAttachCameraCell extends FrameLayout {
    private ImageView backgroundView;
    private ImageView imageView;
    private int itemSize;
    private final Theme.ResourcesProvider resourcesProvider;

    public PhotoAttachCameraCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.resourcesProvider = resourcesProvider;
        ImageView imageView = new ImageView(context);
        this.backgroundView = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.backgroundView, LayoutHelper.createFrame(80, 80.0f));
        ImageView imageView2 = new ImageView(context);
        this.imageView = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        this.imageView.setImageResource(R.drawable.instant_camera);
        addView(this.imageView, LayoutHelper.createFrame(80, 80.0f));
        setFocusable(true);
        this.itemSize = AndroidUtilities.dp(0.0f);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.itemSize + AndroidUtilities.dp(5.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(this.itemSize + AndroidUtilities.dp(5.0f), 1073741824));
    }

    public void setItemSize(int size) {
        this.itemSize = size;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.imageView.getLayoutParams();
        int i = this.itemSize;
        layoutParams.height = i;
        layoutParams.width = i;
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.backgroundView.getLayoutParams();
        int i2 = this.itemSize;
        layoutParams2.height = i2;
        layoutParams2.width = i2;
    }

    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogCameraIcon"), PorterDuff.Mode.MULTIPLY));
    }

    public void updateBitmap() {
        Bitmap bitmapDecodeFile;
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(new File(ApplicationLoader.getFilesDirFixed(), "cthumb.jpg").getAbsolutePath());
        } catch (Throwable unused) {
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile != null) {
            this.backgroundView.setImageBitmap(bitmapDecodeFile);
        } else {
            this.backgroundView.setImageResource(R.drawable.icplaceholder);
        }
    }

    protected int getThemedColor(String key) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Integer color = resourcesProvider != null ? resourcesProvider.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }
}
