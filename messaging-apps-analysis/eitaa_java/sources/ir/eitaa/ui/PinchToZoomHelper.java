package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.WebFile;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_messageActionUserUpdatedPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaInvoice;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaWebPage;
import ir.eitaa.tgnet.TLRPC$TL_messageService;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class PinchToZoomHelper {
    Callback callback;
    private View child;
    private ImageReceiver childImage;
    ClipBoundsListener clipBoundsListener;
    private float enterProgress;
    private float finishProgress;
    ValueAnimator finishTransition;
    private float fullImageHeight;
    private float fullImageWidth;
    private float imageHeight;
    private float imageWidth;
    private float imageX;
    private float imageY;
    private boolean inOverlayMode;
    private boolean isHardwareVideo;
    boolean isInPinchToZoomTouchMode;
    private MessageObject messageObject;
    private ZoomOverlayView overlayView;
    float parentOffsetX;
    float parentOffsetY;
    private final ViewGroup parentView;
    float pinchCenterX;
    float pinchCenterY;
    float pinchScale;
    float pinchStartCenterX;
    float pinchStartCenterY;
    float pinchStartDistance;
    float pinchTranslationX;
    float pinchTranslationY;
    private int pointerId1;
    private int pointerId2;
    private float progressToFullView;
    private ImageReceiver fullImage = new ImageReceiver();
    private float[] clipTopBottom = new float[2];

    public interface Callback {

        /* renamed from: ir.eitaa.ui.PinchToZoomHelper$Callback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static TextureView $default$getCurrentTextureView(Callback callback) {
                return null;
            }

            public static void $default$onZoomFinished(Callback callback, MessageObject messageObject) {
            }
        }

        TextureView getCurrentTextureView();

        void onZoomFinished(MessageObject messageObject);

        void onZoomStarted(MessageObject messageObject);
    }

    public interface ClipBoundsListener {
        void getClipTopBottom(float[] topBottom);
    }

    protected void drawOverlays(Canvas canvas, float alpha, float parentOffsetX, float parentOffsetY, float clipTop, float clipBottom) {
    }

    static /* synthetic */ float access$1416(PinchToZoomHelper pinchToZoomHelper, float f) {
        float f2 = pinchToZoomHelper.progressToFullView + f;
        pinchToZoomHelper.progressToFullView = f2;
        return f2;
    }

    static /* synthetic */ float access$616(PinchToZoomHelper pinchToZoomHelper, float f) {
        float f2 = pinchToZoomHelper.enterProgress + f;
        pinchToZoomHelper.enterProgress = f2;
        return f2;
    }

    public PinchToZoomHelper(ViewGroup parentView) {
        this.parentView = parentView;
    }

    public void startZoom(View child, ImageReceiver image, MessageObject messageObject) {
        this.child = child;
        this.messageObject = messageObject;
        if (this.overlayView == null) {
            ZoomOverlayView zoomOverlayView = new ZoomOverlayView(this.parentView.getContext());
            this.overlayView = zoomOverlayView;
            zoomOverlayView.setFocusable(false);
            this.overlayView.setFocusableInTouchMode(false);
            this.overlayView.setEnabled(false);
        }
        if (this.fullImage == null) {
            ImageReceiver imageReceiver = new ImageReceiver();
            this.fullImage = imageReceiver;
            imageReceiver.setCrossfadeAlpha((byte) 2);
            this.fullImage.setCrossfadeWithOldImage(false);
            this.fullImage.onAttachedToWindow();
        }
        this.inOverlayMode = true;
        this.parentView.addView(this.overlayView);
        this.finishProgress = 1.0f;
        this.progressToFullView = 0.0f;
        setFullImage(messageObject);
        this.imageX = image.getImageX();
        this.imageY = image.getImageY();
        this.imageHeight = image.getImageHeight();
        this.imageWidth = image.getImageWidth();
        this.fullImageHeight = image.getBitmapHeight();
        float bitmapWidth = image.getBitmapWidth();
        this.fullImageWidth = bitmapWidth;
        float f = this.fullImageHeight;
        float f2 = f / bitmapWidth;
        float f3 = this.imageHeight;
        float f4 = this.imageWidth;
        if (f2 == f3 / f4) {
            this.fullImageHeight = f3;
            this.fullImageWidth = f4;
        } else if (f / bitmapWidth < f3 / f4) {
            this.fullImageWidth = (bitmapWidth / f) * f3;
            this.fullImageHeight = f3;
        } else {
            this.fullImageHeight = (f / bitmapWidth) * f4;
            this.fullImageWidth = f4;
        }
        if (messageObject != null && messageObject.isVideo() && MediaController.getInstance().isPlayingMessage(messageObject)) {
            this.isHardwareVideo = true;
            MediaController.getInstance().setTextureView(this.overlayView.videoTextureView, this.overlayView.aspectRatioFrameLayout, this.overlayView.videoPlayerContainer, true);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.overlayView.videoPlayerContainer.getLayoutParams();
            this.overlayView.videoPlayerContainer.setTag(R.id.parent_tag, image);
            if (layoutParams.width != image.getImageWidth() || layoutParams.height != image.getImageHeight()) {
                this.overlayView.aspectRatioFrameLayout.setResizeMode(3);
                layoutParams.width = (int) image.getImageWidth();
                layoutParams.height = (int) image.getImageHeight();
                this.overlayView.videoPlayerContainer.setLayoutParams(layoutParams);
            }
            this.overlayView.videoTextureView.setScaleX(1.0f);
            this.overlayView.videoTextureView.setScaleY(1.0f);
            if (this.callback != null) {
                this.overlayView.backupImageView.setImageBitmap(this.callback.getCurrentTextureView().getBitmap((int) this.fullImageWidth, (int) this.fullImageHeight));
                this.overlayView.backupImageView.setSize((int) this.fullImageWidth, (int) this.fullImageHeight);
                this.overlayView.backupImageView.getImageReceiver().setRoundRadius(image.getRoundRadius());
            }
            this.overlayView.videoPlayerContainer.setVisibility(0);
        } else {
            this.isHardwareVideo = false;
            ImageReceiver imageReceiver2 = new ImageReceiver();
            this.childImage = imageReceiver2;
            imageReceiver2.onAttachedToWindow();
            Drawable drawable = image.getDrawable();
            this.childImage.setImageBitmap(drawable);
            if (drawable instanceof AnimatedFileDrawable) {
                AnimatedFileDrawable animatedFileDrawable = (AnimatedFileDrawable) drawable;
                animatedFileDrawable.addSecondParentView(this.overlayView);
                animatedFileDrawable.setInvalidateParentViewWithSecond(true);
            }
            this.childImage.setImageCoords(this.imageX, this.imageY, this.imageWidth, this.imageHeight);
            this.childImage.setRoundRadius(image.getRoundRadius());
            this.fullImage.setRoundRadius(image.getRoundRadius());
            this.overlayView.videoPlayerContainer.setVisibility(8);
        }
        Callback callback = this.callback;
        if (callback != null) {
            callback.onZoomStarted(messageObject);
        }
        this.enterProgress = 0.0f;
    }

    private void setFullImage(MessageObject messageObject) {
        if (messageObject != null && messageObject.isPhoto()) {
            int[] iArr = new int[1];
            ImageLocation imageLocation = getImageLocation(messageObject, iArr);
            if (imageLocation != null) {
                this.fullImage.setImage(imageLocation, null, null, null, null, iArr[0], null, messageObject, messageObject.isWebpage() ? 1 : 0);
                this.fullImage.setCrossfadeAlpha((byte) 2);
            }
            updateViewsLocation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateViewsLocation() {
        float left = 0.0f;
        float top = 0.0f;
        for (View view = this.child; view != this.parentView; view = (View) view.getParent()) {
            if (view == null) {
                return false;
            }
            left += view.getLeft();
            top += view.getTop();
        }
        this.parentOffsetX = left;
        this.parentOffsetY = top;
        return true;
    }

    public void finishZoom() {
        if (this.finishTransition == null && this.inOverlayMode) {
            if (!updateViewsLocation()) {
                clear();
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.finishTransition = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$PinchToZoomHelper$zuCXSB7tO_ViIJwHcjVNYBtdhKs
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$finishZoom$0$PinchToZoomHelper(valueAnimator);
                }
            });
            this.finishTransition.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PinchToZoomHelper.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    PinchToZoomHelper pinchToZoomHelper = PinchToZoomHelper.this;
                    if (pinchToZoomHelper.finishTransition != null) {
                        pinchToZoomHelper.finishTransition = null;
                        pinchToZoomHelper.clear();
                    }
                }
            });
            this.finishTransition.setDuration(220L);
            this.finishTransition.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.finishTransition.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$finishZoom$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$finishZoom$0$PinchToZoomHelper(ValueAnimator valueAnimator) {
        this.finishProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidateViews();
    }

    public void clear() {
        if (this.inOverlayMode) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onZoomFinished(this.messageObject);
            }
            this.inOverlayMode = false;
        }
        ZoomOverlayView zoomOverlayView = this.overlayView;
        if (zoomOverlayView != null && zoomOverlayView.getParent() != null) {
            this.parentView.removeView(this.overlayView);
            this.overlayView.backupImageView.getImageReceiver().clearImage();
            ImageReceiver imageReceiver = this.childImage;
            if (imageReceiver != null) {
                Drawable drawable = imageReceiver.getDrawable();
                if (drawable instanceof AnimatedFileDrawable) {
                    ((AnimatedFileDrawable) drawable).removeSecondParentView(this.overlayView);
                }
            }
        }
        View view = this.child;
        if (view != null) {
            view.invalidate();
            this.child = null;
        }
        ImageReceiver imageReceiver2 = this.childImage;
        if (imageReceiver2 != null) {
            imageReceiver2.onDetachedFromWindow();
            this.childImage.clearImage();
            this.childImage = null;
        }
        ImageReceiver imageReceiver3 = this.fullImage;
        if (imageReceiver3 != null) {
            imageReceiver3.onDetachedFromWindow();
            this.fullImage.clearImage();
            this.fullImage = null;
        }
        this.messageObject = null;
    }

    public boolean isInOverlayMode() {
        return this.inOverlayMode;
    }

    public boolean isInOverlayModeFor(View child) {
        return this.inOverlayMode && child == this.child;
    }

    public boolean onTouchEvent(MotionEvent ev) {
        if (!updateViewsLocation() || this.child == null) {
            return false;
        }
        ev.offsetLocation(-this.parentOffsetX, -this.parentOffsetY);
        return this.child.onTouchEvent(ev);
    }

    public Bitmap getVideoBitmap(int w, int h) {
        ZoomOverlayView zoomOverlayView = this.overlayView;
        if (zoomOverlayView == null) {
            return null;
        }
        return zoomOverlayView.videoTextureView.getBitmap(w, h);
    }

    public ImageReceiver getPhotoImage() {
        return this.childImage;
    }

    protected boolean zoomEnabled(View child, ImageReceiver receiver) {
        if (receiver.getDrawable() instanceof AnimatedFileDrawable) {
            return !((AnimatedFileDrawable) receiver.getDrawable()).isLoadingStream();
        }
        return receiver.hasNotThumb();
    }

    private class ZoomOverlayView extends FrameLayout {
        private Paint aspectPaint;
        private Path aspectPath;
        private AspectRatioFrameLayout aspectRatioFrameLayout;
        private BackupImageView backupImageView;
        private FrameLayout videoPlayerContainer;
        private TextureView videoTextureView;

        public ZoomOverlayView(Context context) {
            super(context);
            this.aspectPath = new Path();
            this.aspectPaint = new Paint(1);
            if (Build.VERSION.SDK_INT >= 21) {
                FrameLayout frameLayout = new FrameLayout(context);
                this.videoPlayerContainer = frameLayout;
                frameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.PinchToZoomHelper.ZoomOverlayView.1
                    @Override // android.view.ViewOutlineProvider
                    @TargetApi(21)
                    public void getOutline(View view, Outline outline) {
                        ImageReceiver imageReceiver = (ImageReceiver) view.getTag(R.id.parent_tag);
                        if (imageReceiver != null) {
                            int[] roundRadius = imageReceiver.getRoundRadius();
                            int iMax = 0;
                            for (int i = 0; i < 4; i++) {
                                iMax = Math.max(iMax, roundRadius[i]);
                            }
                            outline.setRoundRect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight(), iMax);
                            return;
                        }
                        int i2 = AndroidUtilities.roundMessageSize;
                        outline.setOval(0, 0, i2, i2);
                    }
                });
                this.videoPlayerContainer.setClipToOutline(true);
            } else {
                this.videoPlayerContainer = new FrameLayout(context) { // from class: ir.eitaa.ui.PinchToZoomHelper.ZoomOverlayView.2
                    RectF rect = new RectF();

                    @Override // android.view.View
                    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
                        super.onSizeChanged(w, h, oldw, oldh);
                        ZoomOverlayView.this.aspectPath.reset();
                        ImageReceiver imageReceiver = (ImageReceiver) getTag(R.id.parent_tag);
                        if (imageReceiver == null) {
                            float f = w / 2;
                            ZoomOverlayView.this.aspectPath.addCircle(f, h / 2, f, Path.Direction.CW);
                        } else {
                            int[] roundRadius = imageReceiver.getRoundRadius();
                            int iMax = 0;
                            for (int i = 0; i < 4; i++) {
                                iMax = Math.max(iMax, roundRadius[i]);
                            }
                            this.rect.set(0.0f, 0.0f, w, h);
                            ZoomOverlayView.this.aspectPath.addRoundRect(this.rect, AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), Path.Direction.CW);
                        }
                        ZoomOverlayView.this.aspectPath.toggleInverseFillType();
                    }

                    @Override // android.view.View
                    public void setVisibility(int visibility) {
                        super.setVisibility(visibility);
                        if (visibility == 0) {
                            setLayerType(2, null);
                        }
                    }

                    @Override // android.view.ViewGroup, android.view.View
                    protected void dispatchDraw(Canvas canvas) {
                        super.dispatchDraw(canvas);
                        if (getTag() == null) {
                            canvas.drawPath(ZoomOverlayView.this.aspectPath, ZoomOverlayView.this.aspectPaint);
                        }
                    }
                };
                this.aspectPath = new Path();
                Paint paint = new Paint(1);
                this.aspectPaint = paint;
                paint.setColor(-16777216);
                this.aspectPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            BackupImageView backupImageView = new BackupImageView(context);
            this.backupImageView = backupImageView;
            this.videoPlayerContainer.addView(backupImageView);
            this.videoPlayerContainer.setWillNotDraw(false);
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(context);
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            aspectRatioFrameLayout.setBackgroundColor(0);
            this.videoPlayerContainer.addView(this.aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
            TextureView textureView = new TextureView(context);
            this.videoTextureView = textureView;
            textureView.setOpaque(false);
            this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1.0f));
            addView(this.videoPlayerContainer, LayoutHelper.createFrame(-2, -2.0f));
            setWillNotDraw(false);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            float f;
            float f2;
            PinchToZoomHelper pinchToZoomHelper;
            ClipBoundsListener clipBoundsListener;
            PinchToZoomHelper pinchToZoomHelper2 = PinchToZoomHelper.this;
            if (pinchToZoomHelper2.finishTransition == null && pinchToZoomHelper2.enterProgress != 1.0f) {
                PinchToZoomHelper.access$616(PinchToZoomHelper.this, 0.07272727f);
                if (PinchToZoomHelper.this.enterProgress > 1.0f) {
                    PinchToZoomHelper.this.enterProgress = 1.0f;
                } else {
                    PinchToZoomHelper.this.invalidateViews();
                }
            }
            float interpolation = PinchToZoomHelper.this.finishProgress * CubicBezierInterpolator.DEFAULT.getInterpolation(PinchToZoomHelper.this.enterProgress);
            float measuredHeight = getMeasuredHeight();
            if (interpolation != 1.0f && (clipBoundsListener = (pinchToZoomHelper = PinchToZoomHelper.this).clipBoundsListener) != null) {
                clipBoundsListener.getClipTopBottom(pinchToZoomHelper.clipTopBottom);
                canvas.save();
                float f3 = 1.0f - interpolation;
                float f4 = PinchToZoomHelper.this.clipTopBottom[0] * f3;
                float measuredHeight2 = (getMeasuredHeight() * interpolation) + (PinchToZoomHelper.this.clipTopBottom[1] * f3);
                canvas.clipRect(0.0f, f4, getMeasuredWidth(), measuredHeight2);
                drawImage(canvas);
                super.dispatchDraw(canvas);
                canvas.restore();
                f2 = f4;
                f = measuredHeight2;
            } else {
                drawImage(canvas);
                super.dispatchDraw(canvas);
                f = measuredHeight;
                f2 = 0.0f;
            }
            PinchToZoomHelper.this.drawOverlays(canvas, 1.0f - interpolation, PinchToZoomHelper.this.parentOffsetX - getLeft(), PinchToZoomHelper.this.parentOffsetY - getTop(), f2, f);
        }

        private void drawImage(Canvas canvas) {
            if (!PinchToZoomHelper.this.inOverlayMode || PinchToZoomHelper.this.child == null || PinchToZoomHelper.this.parentView == null) {
                return;
            }
            PinchToZoomHelper.this.updateViewsLocation();
            float left = PinchToZoomHelper.this.parentOffsetX - getLeft();
            float top = PinchToZoomHelper.this.parentOffsetY - getTop();
            canvas.save();
            PinchToZoomHelper pinchToZoomHelper = PinchToZoomHelper.this;
            float f = ((pinchToZoomHelper.pinchScale * pinchToZoomHelper.finishProgress) + 1.0f) - PinchToZoomHelper.this.finishProgress;
            PinchToZoomHelper pinchToZoomHelper2 = PinchToZoomHelper.this;
            canvas.scale(f, f, pinchToZoomHelper2.pinchCenterX + left, pinchToZoomHelper2.pinchCenterY + top);
            PinchToZoomHelper pinchToZoomHelper3 = PinchToZoomHelper.this;
            float f2 = (pinchToZoomHelper3.pinchTranslationX * pinchToZoomHelper3.finishProgress) + left;
            PinchToZoomHelper pinchToZoomHelper4 = PinchToZoomHelper.this;
            canvas.translate(f2, (pinchToZoomHelper4.pinchTranslationY * pinchToZoomHelper4.finishProgress) + top);
            if (PinchToZoomHelper.this.fullImage != null && PinchToZoomHelper.this.fullImage.hasNotThumb()) {
                if (PinchToZoomHelper.this.progressToFullView != 1.0f) {
                    PinchToZoomHelper.access$1416(PinchToZoomHelper.this, 0.10666667f);
                    if (PinchToZoomHelper.this.progressToFullView > 1.0f) {
                        PinchToZoomHelper.this.progressToFullView = 1.0f;
                    } else {
                        PinchToZoomHelper.this.invalidateViews();
                    }
                }
                PinchToZoomHelper.this.fullImage.setAlpha(PinchToZoomHelper.this.progressToFullView);
            }
            float f3 = PinchToZoomHelper.this.imageX;
            float f4 = PinchToZoomHelper.this.imageY;
            if (PinchToZoomHelper.this.imageHeight != PinchToZoomHelper.this.fullImageHeight || PinchToZoomHelper.this.imageWidth != PinchToZoomHelper.this.fullImageWidth) {
                float f5 = f < 1.0f ? 0.0f : f < 1.4f ? (f - 1.0f) / 0.4f : 1.0f;
                float f6 = (PinchToZoomHelper.this.fullImageHeight - PinchToZoomHelper.this.imageHeight) / 2.0f;
                float f7 = ((PinchToZoomHelper.this.fullImageWidth - PinchToZoomHelper.this.imageWidth) / 2.0f) * f5;
                float f8 = PinchToZoomHelper.this.imageX - f7;
                float f9 = f6 * f5;
                float f10 = PinchToZoomHelper.this.imageY - f9;
                if (PinchToZoomHelper.this.childImage != null) {
                    PinchToZoomHelper.this.childImage.setImageCoords(f8, f10, PinchToZoomHelper.this.imageWidth + (f7 * 2.0f), PinchToZoomHelper.this.imageHeight + (f9 * 2.0f));
                }
                f4 = f10;
                f3 = f8;
            }
            if (!PinchToZoomHelper.this.isHardwareVideo) {
                if (PinchToZoomHelper.this.childImage != null) {
                    if (PinchToZoomHelper.this.progressToFullView != 1.0f) {
                        PinchToZoomHelper.this.childImage.draw(canvas);
                        PinchToZoomHelper.this.fullImage.setImageCoords(PinchToZoomHelper.this.childImage.getImageX(), PinchToZoomHelper.this.childImage.getImageY(), PinchToZoomHelper.this.childImage.getImageWidth(), PinchToZoomHelper.this.childImage.getImageHeight());
                        PinchToZoomHelper.this.fullImage.draw(canvas);
                    } else {
                        PinchToZoomHelper.this.fullImage.setImageCoords(PinchToZoomHelper.this.childImage.getImageX(), PinchToZoomHelper.this.childImage.getImageY(), PinchToZoomHelper.this.childImage.getImageWidth(), PinchToZoomHelper.this.childImage.getImageHeight());
                        PinchToZoomHelper.this.fullImage.draw(canvas);
                    }
                }
            } else {
                FrameLayout frameLayout = this.videoPlayerContainer;
                PinchToZoomHelper pinchToZoomHelper5 = PinchToZoomHelper.this;
                frameLayout.setPivotX(pinchToZoomHelper5.pinchCenterX - pinchToZoomHelper5.imageX);
                FrameLayout frameLayout2 = this.videoPlayerContainer;
                PinchToZoomHelper pinchToZoomHelper6 = PinchToZoomHelper.this;
                frameLayout2.setPivotY(pinchToZoomHelper6.pinchCenterY - pinchToZoomHelper6.imageY);
                this.videoPlayerContainer.setScaleY(f);
                this.videoPlayerContainer.setScaleX(f);
                FrameLayout frameLayout3 = this.videoPlayerContainer;
                float f11 = f3 + left;
                PinchToZoomHelper pinchToZoomHelper7 = PinchToZoomHelper.this;
                frameLayout3.setTranslationX(f11 + (pinchToZoomHelper7.pinchTranslationX * f * pinchToZoomHelper7.finishProgress));
                FrameLayout frameLayout4 = this.videoPlayerContainer;
                float f12 = f4 + top;
                PinchToZoomHelper pinchToZoomHelper8 = PinchToZoomHelper.this;
                frameLayout4.setTranslationY(f12 + (pinchToZoomHelper8.pinchTranslationY * f * pinchToZoomHelper8.finishProgress));
            }
            canvas.restore();
        }
    }

    private ImageLocation getImageLocation(MessageObject message, int[] size) {
        TLRPC$Message tLRPC$Message = message.messageOwner;
        if (tLRPC$Message instanceof TLRPC$TL_messageService) {
            if (tLRPC$Message.action instanceof TLRPC$TL_messageActionUserUpdatedPhoto) {
                return null;
            }
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(message.photoThumbs, AndroidUtilities.getPhotoSize());
            if (closestPhotoSizeWithSize != null) {
                if (size != null) {
                    size[0] = closestPhotoSizeWithSize.size;
                    if (size[0] == 0) {
                        size[0] = -1;
                    }
                }
                return ImageLocation.getForObject(closestPhotoSizeWithSize, message.photoThumbsObject);
            }
            if (size != null) {
                size[0] = -1;
            }
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if (((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null) || ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWebPage) && tLRPC$MessageMedia.webpage != null)) {
                if (message.isGif()) {
                    return ImageLocation.getForDocument(message.getDocument());
                }
                TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(message.photoThumbs, AndroidUtilities.getPhotoSize(), false, null, true);
                if (closestPhotoSizeWithSize2 != null) {
                    if (size != null) {
                        size[0] = closestPhotoSizeWithSize2.size;
                        if (size[0] == 0) {
                            size[0] = -1;
                        }
                    }
                    return ImageLocation.getForObject(closestPhotoSizeWithSize2, message.photoThumbsObject);
                }
                if (size != null) {
                    size[0] = -1;
                }
            } else {
                if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaInvoice) {
                    return ImageLocation.getForWebFile(WebFile.createWithWebDocument(((TLRPC$TL_messageMediaInvoice) tLRPC$MessageMedia).photo));
                }
                if (message.getDocument() != null) {
                    TLRPC$Document document = message.getDocument();
                    if (MessageObject.isDocumentHasThumb(message.getDocument())) {
                        TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
                        if (size != null) {
                            size[0] = closestPhotoSizeWithSize3.size;
                            if (size[0] == 0) {
                                size[0] = -1;
                            }
                        }
                        return ImageLocation.getForDocument(closestPhotoSizeWithSize3, document);
                    }
                }
            }
        }
        return null;
    }

    public void setClipBoundsListener(ClipBoundsListener clipBoundsListener) {
        this.clipBoundsListener = clipBoundsListener;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public boolean checkPinchToZoom(MotionEvent ev, View child, ImageReceiver image, MessageObject messageObject) {
        if (!zoomEnabled(child, image)) {
            return false;
        }
        if (ev.getActionMasked() == 0 || ev.getActionMasked() == 5) {
            if (!this.isInPinchToZoomTouchMode && ev.getPointerCount() == 2) {
                this.pinchStartDistance = (float) Math.hypot(ev.getX(1) - ev.getX(0), ev.getY(1) - ev.getY(0));
                float x = (ev.getX(0) + ev.getX(1)) / 2.0f;
                this.pinchCenterX = x;
                this.pinchStartCenterX = x;
                float y = (ev.getY(0) + ev.getY(1)) / 2.0f;
                this.pinchCenterY = y;
                this.pinchStartCenterY = y;
                this.pinchScale = 1.0f;
                this.pointerId1 = ev.getPointerId(0);
                this.pointerId2 = ev.getPointerId(1);
                this.isInPinchToZoomTouchMode = true;
            }
        } else if (ev.getActionMasked() == 2 && this.isInPinchToZoomTouchMode) {
            int i = -1;
            int i2 = -1;
            for (int i3 = 0; i3 < ev.getPointerCount(); i3++) {
                if (this.pointerId1 == ev.getPointerId(i3)) {
                    i = i3;
                }
                if (this.pointerId2 == ev.getPointerId(i3)) {
                    i2 = i3;
                }
            }
            if (i == -1 || i2 == -1) {
                this.isInPinchToZoomTouchMode = false;
                child.getParent().requestDisallowInterceptTouchEvent(false);
                finishZoom();
                return false;
            }
            float fHypot = ((float) Math.hypot(ev.getX(i2) - ev.getX(i), ev.getY(i2) - ev.getY(i))) / this.pinchStartDistance;
            this.pinchScale = fHypot;
            if (fHypot > 1.005f && !isInOverlayMode()) {
                this.pinchStartDistance = (float) Math.hypot(ev.getX(i2) - ev.getX(i), ev.getY(i2) - ev.getY(i));
                float x2 = (ev.getX(i) + ev.getX(i2)) / 2.0f;
                this.pinchCenterX = x2;
                this.pinchStartCenterX = x2;
                float y2 = (ev.getY(i) + ev.getY(i2)) / 2.0f;
                this.pinchCenterY = y2;
                this.pinchStartCenterY = y2;
                this.pinchScale = 1.0f;
                this.pinchTranslationX = 0.0f;
                this.pinchTranslationY = 0.0f;
                child.getParent().requestDisallowInterceptTouchEvent(true);
                startZoom(child, image, messageObject);
            }
            float x3 = (ev.getX(i) + ev.getX(i2)) / 2.0f;
            float y3 = (ev.getY(i) + ev.getY(i2)) / 2.0f;
            float f = this.pinchStartCenterX - x3;
            float f2 = this.pinchStartCenterY - y3;
            float f3 = this.pinchScale;
            this.pinchTranslationX = (-f) / f3;
            this.pinchTranslationY = (-f2) / f3;
            invalidateViews();
        } else if ((ev.getActionMasked() == 1 || ((ev.getActionMasked() == 6 && checkPointerIds(ev)) || ev.getActionMasked() == 3)) && this.isInPinchToZoomTouchMode) {
            this.isInPinchToZoomTouchMode = false;
            child.getParent().requestDisallowInterceptTouchEvent(false);
            finishZoom();
        }
        return isInOverlayModeFor(child);
    }

    private boolean checkPointerIds(MotionEvent ev) {
        if (ev.getPointerCount() < 2) {
            return false;
        }
        if (this.pointerId1 == ev.getPointerId(0) && this.pointerId2 == ev.getPointerId(1)) {
            return true;
        }
        return this.pointerId1 == ev.getPointerId(1) && this.pointerId2 == ev.getPointerId(0);
    }

    protected void invalidateViews() {
        ZoomOverlayView zoomOverlayView = this.overlayView;
        if (zoomOverlayView != null) {
            zoomOverlayView.invalidate();
        }
    }

    public View getChild() {
        return this.child;
    }
}
