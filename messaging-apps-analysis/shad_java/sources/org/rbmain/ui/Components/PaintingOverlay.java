package org.rbmain.ui.Components;

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
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.VideoEditedInfo;
import org.rbmain.ui.Components.Paint.Views.EditTextOutline;

/* loaded from: classes5.dex */
public class PaintingOverlay extends FrameLayout {
    private Drawable backgroundDrawable;
    private boolean ignoreLayout;
    private ArrayList<VideoEditedInfo.MediaEntity> mediaEntities;
    private Bitmap paintBitmap;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public PaintingOverlay(Context context) {
        super(context);
    }

    public void setData(String str, ArrayList<VideoEditedInfo.MediaEntity> arrayList, boolean z, boolean z2) {
        if (str != null) {
            this.paintBitmap = BitmapFactory.decodeFile(str);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.paintBitmap);
            this.backgroundDrawable = bitmapDrawable;
            setBackground(bitmapDrawable);
        } else {
            this.paintBitmap = null;
            this.backgroundDrawable = null;
            setBackground(null);
        }
        setEntities(arrayList, z, z2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.ignoreLayout = true;
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (this.mediaEntities != null) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int size = this.mediaEntities.size();
            for (int i3 = 0; i3 < size; i3++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.mediaEntities.get(i3);
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
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        if (this.mediaEntities != null) {
            int measuredWidth2 = getMeasuredWidth();
            int measuredHeight2 = getMeasuredHeight();
            int size = this.mediaEntities.size();
            for (int i5 = 0; i5 < size; i5++) {
                VideoEditedInfo.MediaEntity mediaEntity = this.mediaEntities.get(i5);
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

    public void setEntities(ArrayList<VideoEditedInfo.MediaEntity> arrayList, boolean z, boolean z2) {
        this.mediaEntities = arrayList;
        removeAllViews();
        if (arrayList == null || arrayList.isEmpty()) {
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
                if (z) {
                    imageReceiver.setAllowDecodeSingleFrame(true);
                    imageReceiver.setAllowStartLottieAnimation(false);
                    if (z2) {
                        imageReceiver.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: org.rbmain.ui.Components.PaintingOverlay$$ExternalSyntheticLambda0
                            @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
                            public final void didSetImage(ImageReceiver imageReceiver2, boolean z3, boolean z4, boolean z5) {
                                PaintingOverlay.lambda$setEntities$0(imageReceiver2, z3, z4, z5);
                            }

                            @Override // org.rbmain.messenger.ImageReceiver.ImageReceiverDelegate
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
                EditTextOutline editTextOutline = new EditTextOutline(this, getContext()) { // from class: org.rbmain.ui.Components.PaintingOverlay.1
                    @Override // org.rbmain.ui.Components.EditTextEffects, android.view.View
                    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                        return false;
                    }

                    @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
                    public boolean onTouchEvent(MotionEvent motionEvent) {
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
                editTextOutline.setInputType(editTextOutline.getInputType() | LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setEntities$0(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
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
    public void setAlpha(float f) {
        super.setAlpha(f);
        Drawable drawable = this.backgroundDrawable;
        if (drawable != null) {
            drawable.setAlpha((int) (f * 255.0f));
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
