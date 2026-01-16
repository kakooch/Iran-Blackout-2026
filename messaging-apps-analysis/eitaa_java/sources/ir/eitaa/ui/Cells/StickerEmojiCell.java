package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DocumentObject;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SvgHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeSticker;
import ir.eitaa.ui.Components.BackupImageView;
import ir.eitaa.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class StickerEmojiCell extends FrameLayout {
    private static AccelerateInterpolator interpolator = new AccelerateInterpolator(0.5f);
    private float alpha;
    private boolean changingAlpha;
    private int currentAccount;
    private String currentEmoji;
    private TextView emojiTextView;
    private boolean fromEmojiPanel;
    private BackupImageView imageView;
    private long lastUpdateTime;
    private Object parentObject;
    private boolean recent;
    private float scale;
    private boolean scaled;
    private TLRPC$Document sticker;
    private SendMessagesHelper.ImportingSticker stickerPath;
    private long time;

    public StickerEmojiCell(Context context, boolean isEmojiPanel) {
        super(context);
        this.alpha = 1.0f;
        this.currentAccount = UserConfig.selectedAccount;
        this.fromEmojiPanel = isEmojiPanel;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setAspectFit(true);
        this.imageView.setLayerNum(1);
        addView(this.imageView, LayoutHelper.createFrame(66, 66, 17));
        TextView textView = new TextView(context);
        this.emojiTextView = textView;
        textView.setTextSize(1, 16.0f);
        this.emojiTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        addView(this.emojiTextView, LayoutHelper.createFrame(28, 28, 85));
        setFocusable(true);
    }

    public TLRPC$Document getSticker() {
        return this.sticker;
    }

    public SendMessagesHelper.ImportingSticker getStickerPath() {
        SendMessagesHelper.ImportingSticker importingSticker = this.stickerPath;
        if (importingSticker == null || !importingSticker.validated) {
            return null;
        }
        return importingSticker;
    }

    public String getEmoji() {
        return this.currentEmoji;
    }

    public Object getParentObject() {
        return this.parentObject;
    }

    public boolean isRecent() {
        return this.recent;
    }

    public void setRecent(boolean value) {
        this.recent = value;
    }

    public void setSticker(TLRPC$Document document, Object parent, boolean showEmoji) {
        setSticker(document, null, parent, null, showEmoji);
    }

    public void setSticker(SendMessagesHelper.ImportingSticker path) {
        String str = path.emoji;
        setSticker(null, path, null, str, str != null);
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

    public void setSticker(TLRPC$Document document, SendMessagesHelper.ImportingSticker path, Object parent, String emoji, boolean showEmoji) {
        boolean z;
        this.currentEmoji = emoji;
        if (path != null) {
            this.stickerPath = path;
            if (path.validated) {
                this.imageView.setImage(ImageLocation.getForPath(path.path), "80_80", null, null, DocumentObject.getSvgRectThumb("dialogBackgroundGray", 1.0f), null, path.animated ? "tgs" : null, 0, null);
            } else {
                this.imageView.setImage(null, null, null, null, DocumentObject.getSvgRectThumb("dialogBackgroundGray", 1.0f), null, path.animated ? "tgs" : null, 0, null);
            }
            if (emoji != null) {
                TextView textView = this.emojiTextView;
                textView.setText(Emoji.replaceEmoji(emoji, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
                this.emojiTextView.setVisibility(0);
                return;
            }
            this.emojiTextView.setVisibility(4);
            return;
        }
        if (document != null) {
            this.sticker = document;
            this.parentObject = parent;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(document.thumbs, 90);
            boolean z2 = this.fromEmojiPanel;
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(document, z2 ? "emptyListPlaceholder" : "windowBackgroundGray", z2 ? 0.2f : 1.0f);
            if (MessageObject.canAutoplayAnimatedSticker(document)) {
                if (svgThumb != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(document), "66_66", (String) null, svgThumb, this.parentObject);
                } else if (closestPhotoSizeWithSize != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(document), "66_66", ImageLocation.getForDocument(closestPhotoSizeWithSize, document), (String) null, 0, this.parentObject);
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(document), "66_66", (String) null, (Drawable) null, this.parentObject);
                }
            } else if (svgThumb != null) {
                if (closestPhotoSizeWithSize != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, document), (String) null, "webp", svgThumb, this.parentObject);
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(document), (String) null, "webp", svgThumb, this.parentObject);
                }
            } else if (closestPhotoSizeWithSize != null) {
                this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, document), (String) null, "webp", (Drawable) null, this.parentObject);
            } else {
                this.imageView.setImage(ImageLocation.getForDocument(document), (String) null, "webp", (Drawable) null, this.parentObject);
            }
            if (emoji != null) {
                TextView textView2 = this.emojiTextView;
                textView2.setText(Emoji.replaceEmoji(emoji, textView2.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
                this.emojiTextView.setVisibility(0);
                return;
            }
            if (showEmoji) {
                int i = 0;
                while (true) {
                    if (i >= document.attributes.size()) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = document.attributes.get(i);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                        String str = tLRPC$DocumentAttribute.alt;
                        if (str == null || str.length() <= 0) {
                            break;
                        }
                        TextView textView3 = this.emojiTextView;
                        textView3.setText(Emoji.replaceEmoji(tLRPC$DocumentAttribute.alt, textView3.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
                        z = true;
                    } else {
                        i++;
                    }
                }
                z = false;
                if (!z) {
                    this.emojiTextView.setText(Emoji.replaceEmoji(MediaDataController.getInstance(this.currentAccount).getEmojiForSticker(this.sticker.id), this.emojiTextView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
                }
                this.emojiTextView.setVisibility(0);
                return;
            }
            this.emojiTextView.setVisibility(4);
        }
    }

    public void disable() {
        this.changingAlpha = true;
        this.alpha = 0.5f;
        this.time = 0L;
        this.imageView.getImageReceiver().setAlpha(this.alpha);
        this.imageView.invalidate();
        this.lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    public void setScaled(boolean value) {
        this.scaled = value;
        this.lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }

    public boolean isDisabled() {
        return this.changingAlpha;
    }

    public boolean showingBitmap() {
        return this.imageView.getImageReceiver().getBitmap() != null;
    }

    public BackupImageView getImageView() {
        return this.imageView;
    }

    @Override // android.view.View
    public void invalidate() {
        this.emojiTextView.invalidate();
        super.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
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
            if (r6 != r7) goto La2
            boolean r6 = r4.changingAlpha
            r7 = 1061997773(0x3f4ccccd, float:0.8)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r6 != 0) goto L23
            boolean r6 = r4.scaled
            if (r6 == 0) goto L1b
            float r0 = r4.scale
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 != 0) goto L23
        L1b:
            if (r6 != 0) goto La2
            float r6 = r4.scale
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto La2
        L23:
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r4.lastUpdateTime
            long r2 = r0 - r2
            r4.lastUpdateTime = r0
            boolean r6 = r4.changingAlpha
            if (r6 == 0) goto L67
            long r6 = r4.time
            long r6 = r6 + r2
            r4.time = r6
            r0 = 1050(0x41a, double:5.19E-321)
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 <= 0) goto L3e
            r4.time = r0
        L3e:
            android.view.animation.AccelerateInterpolator r6 = ir.eitaa.ui.Cells.StickerEmojiCell.interpolator
            long r0 = r4.time
            float r7 = (float) r0
            r0 = 1149452288(0x44834000, float:1050.0)
            float r7 = r7 / r0
            float r6 = r6.getInterpolation(r7)
            r7 = 1056964608(0x3f000000, float:0.5)
            float r6 = r6 * r7
            float r6 = r6 + r7
            r4.alpha = r6
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 < 0) goto L5b
            r6 = 0
            r4.changingAlpha = r6
            r4.alpha = r8
        L5b:
            ir.eitaa.ui.Components.BackupImageView r6 = r4.imageView
            ir.eitaa.messenger.ImageReceiver r6 = r6.getImageReceiver()
            float r7 = r4.alpha
            r6.setAlpha(r7)
            goto L8c
        L67:
            boolean r6 = r4.scaled
            r0 = 1137180672(0x43c80000, float:400.0)
            if (r6 == 0) goto L7f
            float r6 = r4.scale
            int r1 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r1 == 0) goto L7f
            float r8 = (float) r2
            float r8 = r8 / r0
            float r6 = r6 - r8
            r4.scale = r6
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L8c
            r4.scale = r7
            goto L8c
        L7f:
            float r6 = r4.scale
            float r7 = (float) r2
            float r7 = r7 / r0
            float r6 = r6 + r7
            r4.scale = r6
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L8c
            r4.scale = r8
        L8c:
            ir.eitaa.ui.Components.BackupImageView r6 = r4.imageView
            float r7 = r4.scale
            r6.setScaleX(r7)
            ir.eitaa.ui.Components.BackupImageView r6 = r4.imageView
            float r7 = r4.scale
            r6.setScaleY(r7)
            ir.eitaa.ui.Components.BackupImageView r6 = r4.imageView
            r6.invalidate()
            r4.invalidate()
        La2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.StickerEmojiCell.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        String string = LocaleController.getString("AttachSticker", R.string.AttachSticker);
        if (this.sticker != null) {
            int i = 0;
            while (true) {
                if (i >= this.sticker.attributes.size()) {
                    break;
                }
                TLRPC$DocumentAttribute tLRPC$DocumentAttribute = this.sticker.attributes.get(i);
                if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                    String str = tLRPC$DocumentAttribute.alt;
                    if (str != null && str.length() > 0) {
                        TextView textView = this.emojiTextView;
                        textView.setText(Emoji.replaceEmoji(tLRPC$DocumentAttribute.alt, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
                        string = tLRPC$DocumentAttribute.alt + " " + string;
                    }
                } else {
                    i++;
                }
            }
        }
        info.setContentDescription(string);
        info.setEnabled(true);
    }
}
