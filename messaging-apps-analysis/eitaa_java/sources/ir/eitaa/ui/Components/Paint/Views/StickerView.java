package ir.eitaa.ui.Components.Paint.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.tgnet.TLRPC$TL_maskCoords;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.Paint.Views.EntityView;
import ir.eitaa.ui.Components.Point;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.Rect;
import ir.eitaa.ui.Components.Size;

/* loaded from: classes3.dex */
public class StickerView extends EntityView {
    private int anchor;
    private Size baseSize;
    private ImageReceiver centerImage;
    private FrameLayoutDrawer containerView;
    private boolean mirrored;
    private Object parentObject;
    private TLRPC$Document sticker;

    protected void didSetAnimatedSticker(RLottieDrawable drawable) {
    }

    private class FrameLayoutDrawer extends FrameLayout {
        public FrameLayoutDrawer(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            StickerView.this.stickerDraw(canvas);
        }
    }

    public StickerView(Context context, Point position, float angle, float scale, Size baseSize, TLRPC$Document sticker, Object parentObject) {
        super(context, position);
        this.anchor = -1;
        int i = 0;
        this.mirrored = false;
        this.centerImage = new ImageReceiver();
        setRotation(angle);
        setScale(scale);
        this.sticker = sticker;
        this.baseSize = baseSize;
        this.parentObject = parentObject;
        while (true) {
            if (i >= sticker.attributes.size()) {
                break;
            }
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = sticker.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                TLRPC$TL_maskCoords tLRPC$TL_maskCoords = tLRPC$DocumentAttribute.mask_coords;
                if (tLRPC$TL_maskCoords != null) {
                    this.anchor = tLRPC$TL_maskCoords.n;
                }
            } else {
                i++;
            }
        }
        FrameLayoutDrawer frameLayoutDrawer = new FrameLayoutDrawer(context);
        this.containerView = frameLayoutDrawer;
        addView(frameLayoutDrawer, LayoutHelper.createFrame(-1, -1.0f));
        this.centerImage.setAspectFit(true);
        this.centerImage.setInvalidateAll(true);
        this.centerImage.setParentView(this.containerView);
        this.centerImage.setImage(ImageLocation.getForDocument(sticker), (String) null, ImageLocation.getForDocument(FileLoader.getClosestPhotoSizeWithSize(sticker.thumbs, 90), sticker), (String) null, "webp", parentObject, 1);
        this.centerImage.setDelegate(new ImageReceiver.ImageReceiverDelegate() { // from class: ir.eitaa.ui.Components.Paint.Views.-$$Lambda$StickerView$iCja4PVKmg-tnz_vreXXP9wjlMo
            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public final void didSetImage(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
                this.f$0.lambda$new$0$StickerView(imageReceiver, z, z2, z3);
            }

            @Override // ir.eitaa.messenger.ImageReceiver.ImageReceiverDelegate
            public /* synthetic */ void onAnimationReady(ImageReceiver imageReceiver) {
                ImageReceiver.ImageReceiverDelegate.CC.$default$onAnimationReady(this, imageReceiver);
            }
        });
        updatePosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$StickerView(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) {
        RLottieDrawable lottieAnimation;
        if (!z || z2 || (lottieAnimation = imageReceiver.getLottieAnimation()) == null) {
            return;
        }
        didSetAnimatedSticker(lottieAnimation);
    }

    public StickerView(Context context, StickerView stickerView, Point position) {
        this(context, position, stickerView.getRotation(), stickerView.getScale(), stickerView.baseSize, stickerView.sticker, stickerView.parentObject);
        if (stickerView.mirrored) {
            mirror();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.centerImage.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.centerImage.onAttachedToWindow();
    }

    public int getAnchor() {
        return this.anchor;
    }

    public void mirror() {
        this.mirrored = !this.mirrored;
        this.containerView.invalidate();
    }

    public boolean isMirrored() {
        return this.mirrored;
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView
    protected void updatePosition() {
        Size size = this.baseSize;
        float f = size.width / 2.0f;
        float f2 = size.height / 2.0f;
        setX(this.position.x - f);
        setY(this.position.y - f2);
        updateSelectionView();
    }

    protected void stickerDraw(Canvas canvas) {
        if (this.containerView == null) {
            return;
        }
        canvas.save();
        if (this.mirrored) {
            canvas.scale(-1.0f, 1.0f);
            canvas.translate(-this.baseSize.width, 0.0f);
        }
        ImageReceiver imageReceiver = this.centerImage;
        Size size = this.baseSize;
        imageReceiver.setImageCoords(0.0f, 0.0f, (int) size.width, (int) size.height);
        this.centerImage.draw(canvas);
        canvas.restore();
    }

    public long getDuration() {
        RLottieDrawable lottieAnimation = this.centerImage.getLottieAnimation();
        if (lottieAnimation == null) {
            return 0L;
        }
        return lottieAnimation.getDuration();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) this.baseSize.width, 1073741824), View.MeasureSpec.makeMeasureSpec((int) this.baseSize.height, 1073741824));
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView
    protected Rect getSelectionBounds() {
        float scaleX = ((ViewGroup) getParent()).getScaleX();
        float measuredWidth = getMeasuredWidth() * (getScale() + 0.4f);
        Point point = this.position;
        float f = measuredWidth / 2.0f;
        float f2 = measuredWidth * scaleX;
        return new Rect((point.x - f) * scaleX, (point.y - f) * scaleX, f2, f2);
    }

    @Override // ir.eitaa.ui.Components.Paint.Views.EntityView
    protected EntityView.SelectionView createSelectionView() {
        return new StickerViewSelectionView(getContext());
    }

    public TLRPC$Document getSticker() {
        return this.sticker;
    }

    public Object getParentObject() {
        return this.parentObject;
    }

    public Size getBaseSize() {
        return this.baseSize;
    }

    public class StickerViewSelectionView extends EntityView.SelectionView {
        private Paint arcPaint;
        private RectF arcRect;

        public StickerViewSelectionView(Context context) {
            super(context);
            this.arcPaint = new Paint(1);
            this.arcRect = new RectF();
            this.arcPaint.setColor(-1);
            this.arcPaint.setStrokeWidth(AndroidUtilities.dp(1.0f));
            this.arcPaint.setStyle(Paint.Style.STROKE);
        }

        @Override // ir.eitaa.ui.Components.Paint.Views.EntityView.SelectionView
        protected int pointInsideHandle(float x, float y) {
            float fDp = AndroidUtilities.dp(1.0f);
            float fDp2 = AndroidUtilities.dp(19.5f);
            float f = fDp + fDp2;
            float f2 = f * 2.0f;
            float measuredHeight = ((getMeasuredHeight() - f2) / 2.0f) + f;
            if (x > f - fDp2 && y > measuredHeight - fDp2 && x < f + fDp2 && y < measuredHeight + fDp2) {
                return 1;
            }
            if (x > ((getMeasuredWidth() - f2) + f) - fDp2 && y > measuredHeight - fDp2 && x < f + (getMeasuredWidth() - f2) + fDp2 && y < measuredHeight + fDp2) {
                return 2;
            }
            float measuredWidth = getMeasuredWidth() / 2.0f;
            return Math.pow((double) (x - measuredWidth), 2.0d) + Math.pow((double) (y - measuredWidth), 2.0d) < Math.pow((double) measuredWidth, 2.0d) ? 3 : 0;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            float fDp = AndroidUtilities.dp(1.0f);
            float fDp2 = AndroidUtilities.dp(4.5f);
            float fDp3 = fDp + fDp2 + AndroidUtilities.dp(15.0f);
            float measuredWidth = (getMeasuredWidth() / 2) - fDp3;
            float f = (2.0f * measuredWidth) + fDp3;
            this.arcRect.set(fDp3, fDp3, f, f);
            for (int i = 0; i < 48; i++) {
                canvas.drawArc(this.arcRect, i * 8.0f, 4.0f, false, this.arcPaint);
            }
            float f2 = measuredWidth + fDp3;
            canvas.drawCircle(fDp3, f2, fDp2, this.dotPaint);
            canvas.drawCircle(fDp3, f2, fDp2, this.dotStrokePaint);
            canvas.drawCircle(f, f2, fDp2, this.dotPaint);
            canvas.drawCircle(f, f2, fDp2, this.dotStrokePaint);
        }
    }
}
