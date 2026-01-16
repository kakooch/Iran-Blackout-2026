package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class StickerCell extends FrameLayout {
    private static AccelerateInterpolator interpolator = new AccelerateInterpolator(0.5f);
    private boolean clearsInputField;
    private BackupImageView imageView;
    private long lastUpdateTime;
    private Object parentObject;
    private float scale;
    private boolean scaled;
    private TLRPC$Document sticker;
    private long time;

    public StickerCell(Context context) {
        super(context);
        this.time = 0L;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setAspectFit(true);
        this.imageView.setLayerNum(1);
        addView(this.imageView, LayoutHelper.createFrame(66, 66.0f, 1, 0.0f, 5.0f, 0.0f, 0.0f));
        setFocusable(true);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(76.0f) + getPaddingLeft() + getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(78.0f), 1073741824));
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.imageView.getImageReceiver().getPressed() != z) {
            this.imageView.getImageReceiver().setPressed(z ? 1 : 0);
            this.imageView.invalidate();
        }
        super.setPressed(z);
    }

    public void setClearsInputField(boolean value) {
        this.clearsInputField = value;
    }

    public boolean isClearsInputField() {
        return this.clearsInputField;
    }

    public void setSticker(TLRPC$Document document, Object parent) {
        this.parentObject = parent;
        if (document != null) {
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(document, "windowBackgroundGray", 1.0f);
            if (MessageObject.canAutoplayAnimatedSticker(document)) {
                if (svgThumb != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(document), "80_80", (String) null, svgThumb, this.parentObject);
                } else if (closestPhotoSizeWithSize != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(document), "80_80", ImageLocation.getForDocument(closestPhotoSizeWithSize, document), (String) null, 0, this.parentObject);
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(document), "80_80", (String) null, (Drawable) null, this.parentObject);
                }
            } else if (svgThumb == null) {
                this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, document), (String) null, "webp", (Drawable) null, this.parentObject);
            } else if (closestPhotoSizeWithSize != null) {
                this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, document), (String) null, "webp", svgThumb, this.parentObject);
            } else {
                this.imageView.setImage(ImageLocation.getForDocument(document), (String) null, "webp", svgThumb, this.parentObject);
            }
        }
        this.sticker = document;
        Drawable background = getBackground();
        if (background != null) {
            background.setAlpha(230);
            background.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_stickersHintPanel"), PorterDuff.Mode.MULTIPLY));
        }
    }

    public TLRPC$Document getSticker() {
        return this.sticker;
    }

    public Object getParentObject() {
        return this.parentObject;
    }

    public void setScaled(boolean value) {
        this.scaled = value;
        this.lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    public boolean showingBitmap() {
        return this.imageView.getImageReceiver().getBitmap() != null;
    }

    public MessageObject.SendAnimationData getSendAnimationData() {
        ImageReceiver imageReceiver = this.imageView.getImageReceiver();
        if (!imageReceiver.hasNotThumb()) {
            return null;
        }
        MessageObject.SendAnimationData sendAnimationData = new MessageObject.SendAnimationData();
        this.imageView.getLocationInWindow(new int[2]);
        sendAnimationData.x = imageReceiver.getCenterX() + r2[0];
        sendAnimationData.y = imageReceiver.getCenterY() + r2[1];
        sendAnimationData.width = imageReceiver.getImageWidth();
        sendAnimationData.height = imageReceiver.getImageHeight();
        return sendAnimationData;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean drawChild(android.graphics.Canvas r5, android.view.View r6, long r7) {
        /*
            r4 = this;
            boolean r5 = super.drawChild(r5, r6, r7)
            ir.eitaa.ui.Components.BackupImageView r7 = r4.imageView
            if (r6 != r7) goto L64
            boolean r6 = r4.scaled
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 1061997773(0x3f4ccccd, float:0.8)
            if (r6 == 0) goto L17
            float r0 = r4.scale
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 != 0) goto L1f
        L17:
            if (r6 != 0) goto L64
            float r6 = r4.scale
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 == 0) goto L64
        L1f:
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r4.lastUpdateTime
            long r2 = r0 - r2
            r4.lastUpdateTime = r0
            boolean r6 = r4.scaled
            r0 = 1137180672(0x43c80000, float:400.0)
            if (r6 == 0) goto L41
            float r6 = r4.scale
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 == 0) goto L41
            float r7 = (float) r2
            float r7 = r7 / r0
            float r6 = r6 - r7
            r4.scale = r6
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L4e
            r4.scale = r8
            goto L4e
        L41:
            float r6 = r4.scale
            float r8 = (float) r2
            float r8 = r8 / r0
            float r6 = r6 + r8
            r4.scale = r6
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L4e
            r4.scale = r7
        L4e:
            ir.eitaa.ui.Components.BackupImageView r6 = r4.imageView
            float r7 = r4.scale
            r6.setScaleX(r7)
            ir.eitaa.ui.Components.BackupImageView r6 = r4.imageView
            float r7 = r4.scale
            r6.setScaleY(r7)
            ir.eitaa.ui.Components.BackupImageView r6 = r4.imageView
            r6.invalidate()
            r4.invalidate()
        L64:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.StickerCell.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (this.sticker == null) {
            return;
        }
        String str = null;
        for (int i = 0; i < this.sticker.attributes.size(); i++) {
            TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.sticker.attributes.get(i);
            if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                String str2 = tLRPC$DocumentAttribute.alt;
                str = (str2 == null || str2.length() <= 0) ? null : tLRPC$DocumentAttribute.alt;
            }
        }
        if (str != null) {
            info.setText(str + " " + LocaleController.getString("AttachSticker", R.string.AttachSticker));
        } else {
            info.setText(LocaleController.getString("AttachSticker", R.string.AttachSticker));
        }
        info.setEnabled(true);
    }
}
