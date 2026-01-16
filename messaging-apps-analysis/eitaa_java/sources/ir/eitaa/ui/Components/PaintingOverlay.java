package ir.eitaa.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.VideoEditedInfo;
import ir.eitaa.ui.Components.Paint.Views.EditTextOutline;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PaintingOverlay extends FrameLayout {
    private Drawable backgroundDrawable;
    private boolean ignoreLayout;
    private ArrayList<VideoEditedInfo.MediaEntity> mediaEntities;
    private Bitmap paintBitmap;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public PaintingOverlay(Context context) {
        super(context);
    }

    public void setData(String paintPath, ArrayList<VideoEditedInfo.MediaEntity> entities, boolean isVideo, boolean startAfterSet) {
        if (paintPath != null) {
            this.paintBitmap = BitmapFactory.decodeFile(paintPath);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.paintBitmap);
            this.backgroundDrawable = bitmapDrawable;
            setBackground(bitmapDrawable);
        } else {
            this.paintBitmap = null;
            this.backgroundDrawable = null;
            setBackground(null);
        }
        setEntities(entities, isVideo, startAfterSet);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.ignoreLayout = true;
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        if (this.mediaEntities != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int size = this.mediaEntities.size();
            for (int i = 0; i < size; i++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.mediaEntities.get(i);
                View view = mediaEntity.view;
                if (view != null) {
                    if (view instanceof EditTextOutline) {
                        view.measure(View.MeasureSpec.makeMeasureSpec(mediaEntity.viewWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                        float f = (mediaEntity.textViewWidth * measuredWidth) / mediaEntity.viewWidth;
                        mediaEntity.view.setScaleX(mediaEntity.scale * f);
                        mediaEntity.view.setScaleY(mediaEntity.scale * f);
                    } else {
                        view.measure(View.MeasureSpec.makeMeasureSpec((int) (measuredWidth * mediaEntity.width), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (measuredHeight * mediaEntity.height), 1073741824));
                    }
                }
            }
        }
        this.ignoreLayout = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int measuredWidth;
        int measuredHeight;
        if (this.mediaEntities != null) {
            int measuredWidth2 = getMeasuredWidth();
            int measuredHeight2 = getMeasuredHeight();
            int size = this.mediaEntities.size();
            for (int i = 0; i < size; i++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.mediaEntities.get(i);
                View view = mediaEntity.view;
                if (view != null) {
                    if (view instanceof EditTextOutline) {
                        measuredWidth = ((int) (measuredWidth2 * mediaEntity.textViewX)) - (view.getMeasuredWidth() / 2);
                        measuredHeight = ((int) (measuredHeight2 * mediaEntity.textViewY)) - (mediaEntity.view.getMeasuredHeight() / 2);
                    } else {
                        measuredWidth = (int) (measuredWidth2 * mediaEntity.x);
                        measuredHeight = (int) (measuredHeight2 * mediaEntity.y);
                    }
                    View view2 = mediaEntity.view;
                    view2.layout(measuredWidth, measuredHeight, view2.getMeasuredWidth() + measuredWidth, mediaEntity.view.getMeasuredHeight() + measuredHeight);
                }
            }
        }
    }

    public void showAll() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setVisibility(0);
        }
        setBackground(this.backgroundDrawable);
    }

    public void hideEntities() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setVisibility(4);
        }
    }

    public void hideBitmap() {
        setBackground(null);
    }

    public void setEntities(ArrayList<VideoEditedInfo.MediaEntity> entities, boolean isVideo, boolean startAfterSet) {
        this.mediaEntities = entities;
        removeAllViews();
        if (entities == null || entities.isEmpty()) {
            return;
        }
        int size = this.mediaEntities.size();
        for (int i = 0; i < size; i++) {
            VideoEditedInfo.MediaEntity mediaEntity = this.mediaEntities.get(i);
            byte b = mediaEntity.type;
            if (b == 0) {
                BackupImageView backupImageView = new BackupImageView(getContext());
                backupImageView.setAspectFit(true);
                ImageReceiver imageReceiver = backupImageView.getImageReceiver();
                if (isVideo) {
                    imageReceiver.setAllowDecodeSingleFrame(true);
                    imageReceiver.setAllowStartLottieAnimation(false);
                    if (startAfterSet) {
                        imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$PaintingOverlay$DiJerI-k4pCF0qJEKpp9XUe4SUw
                            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                            public final void didSetImage(ImageReceiver imageReceiver2, boolean z, boolean z2, boolean z3) {
                                PaintingOverlay.lambda$setEntities$0(imageReceiver2, z, z2, z3);
                            }

                            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
                            public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver2) {
                                ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver2);
                            }
                        });
                    }
                }
                imageReceiver.setImage(ImageLocation.getForDocument(mediaEntity.document), (String) null, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(mediaEntity.document.thumbs, 90), mediaEntity.document), (String) null, "webp", mediaEntity.parentObject, 1);
                if ((mediaEntity.subType & 2) != 0) {
                    backupImageView.setScaleX(-1.0f);
                }
                mediaEntity.view = backupImageView;
            } else if (b == 1) {
                EditTextOutline editTextOutline = new EditTextOutline(getContext()) { // from class: ir.eitaa.ui.Components.PaintingOverlay.1
                    @Override // android.view.View
                    public boolean dispatchTouchEvent(MotionEvent event) {
                        return false;
                    }

                    @Override // android.widget.TextView, android.view.View
                    public boolean onTouchEvent(MotionEvent event) {
                        return false;
                    }
                };
                editTextOutline.setBackgroundColor(0);
                editTextOutline.setPadding(AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f));
                editTextOutline.setTextSize(0, mediaEntity.fontSize);
                editTextOutline.setText(mediaEntity.text);
                editTextOutline.setTypeface(null, 1);
                editTextOutline.setGravity(17);
                editTextOutline.setHorizontallyScrolling(false);
                editTextOutline.setImeOptions(268435456);
                editTextOutline.setFocusableInTouchMode(true);
                editTextOutline.setEnabled(false);
                editTextOutline.setInputType(editTextOutline.getInputType() | 16384);
                if (Build.VERSION.SDK_INT >= 23) {
                    editTextOutline.setBreakStrategy(0);
                }
                byte b2 = mediaEntity.subType;
                if ((b2 & 1) != 0) {
                    editTextOutline.setTextColor(-1);
                    editTextOutline.setStrokeColor(mediaEntity.color);
                    editTextOutline.setFrameColor(0);
                    editTextOutline.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                } else if ((b2 & 4) != 0) {
                    editTextOutline.setTextColor(-16777216);
                    editTextOutline.setStrokeColor(0);
                    editTextOutline.setFrameColor(mediaEntity.color);
                    editTextOutline.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                } else {
                    editTextOutline.setTextColor(mediaEntity.color);
                    editTextOutline.setStrokeColor(0);
                    editTextOutline.setFrameColor(0);
                    editTextOutline.setShadowLayer(5.0f, 0.0f, 1.0f, 1711276032);
                }
                mediaEntity.view = editTextOutline;
            }
            addView(mediaEntity.view);
            View view = mediaEntity.view;
            double d = -mediaEntity.rotation;
            Double.isNaN(d);
            view.setRotation((float) ((d / 3.141592653589793d) * 180.0d));
        }
    }

    static /* synthetic */ void lambda$setEntities$0(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        RLottieDrawable lottieAnimation;
        if (!z || z2 || (lottieAnimation = imageReceiver.getLottieAnimation()) == null) {
            return;
        }
        lottieAnimation.start();
    }

    public void setBitmap(Bitmap bitmap) {
        this.paintBitmap = bitmap;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        this.backgroundDrawable = bitmapDrawable;
        setBackground(bitmapDrawable);
    }

    public Bitmap getBitmap() {
        return this.paintBitmap;
    }

    @Override // android.view.View
    public void setAlpha(float alpha) {
        super.setAlpha(alpha);
        Drawable drawable = this.backgroundDrawable;
        if (drawable != null) {
            drawable.setAlpha((int) (alpha * 255.0f));
        }
    }

    public Bitmap getThumb() {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float fMax = Math.max(measuredWidth / AndroidUtilities.dp(120.0f), measuredHeight / AndroidUtilities.dp(120.0f));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (measuredWidth / fMax), (int) (measuredHeight / fMax), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f = 1.0f / fMax;
        canvas.scale(f, f);
        draw(canvas);
        return bitmapCreateBitmap;
    }
}
