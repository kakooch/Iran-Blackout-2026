package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$DocumentAttribute;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_documentAttributeSticker;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes4.dex */
public class StickerEmojiCell extends FrameLayout {
    private static AccelerateInterpolator interpolator = new AccelerateInterpolator(0.5f);
    private float alpha;
    private boolean changingAlpha;
    private int currentAccount;
    private TextView emojiTextView;
    private boolean fromEmojiPanel;
    private BackupImageView imageView;
    private long lastUpdateTime;
    private Object parentObject;
    private boolean recent;
    private float scale;
    private boolean scaled;
    private TLRPC$Document sticker;
    private long time;

    public StickerEmojiCell(Context context, boolean z) {
        super(context);
        this.alpha = 1.0f;
        this.currentAccount = UserConfig.selectedAccount;
        this.fromEmojiPanel = z;
        BackupImageView backupImageView = new BackupImageView(context);
        this.imageView = backupImageView;
        backupImageView.setAspectFit(true);
        this.imageView.setLayerNum(1);
        addView(this.imageView, LayoutHelper.createFrame(66, 66, 17));
        TextView textView = new TextView(context);
        this.emojiTextView = textView;
        textView.setTextSize(1, 16.0f);
        addView(this.emojiTextView, LayoutHelper.createFrame(28, 28, 85));
        setFocusable(true);
    }

    public TLRPC$Document getSticker() {
        return this.sticker;
    }

    public Object getParentObject() {
        return this.parentObject;
    }

    public boolean isRecent() {
        return this.recent;
    }

    public void setRecent(boolean z) {
        this.recent = z;
    }

    public void setSticker(TLRPC$Document tLRPC$Document, Object obj, boolean z) {
        setSticker(tLRPC$Document, obj, null, z);
    }

    public void setSticker(TLRPC$Document tLRPC$Document, Object obj, String str, boolean z) {
        boolean z2;
        if (tLRPC$Document != null) {
            this.sticker = tLRPC$Document;
            this.parentObject = obj;
            TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 90);
            boolean z3 = this.fromEmojiPanel;
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(tLRPC$Document, z3 ? Theme.key_emptyListPlaceholder : Theme.key_windowBackgroundGray, z3 ? 0.2f : 1.0f);
            if (MessageObject.canAutoplayAnimatedSticker(tLRPC$Document)) {
                if (svgThumb != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "80_80", (String) null, svgThumb, this.parentObject);
                } else if (closestPhotoSizeWithSize != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "80_80", ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$Document), (String) null, 0, this.parentObject);
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), "80_80", (String) null, (Drawable) null, this.parentObject);
                }
            } else if (svgThumb != null) {
                if (closestPhotoSizeWithSize != null) {
                    this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$Document), (String) null, "webp", svgThumb, this.parentObject);
                } else {
                    this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), (String) null, "webp", svgThumb, this.parentObject);
                }
            } else if (closestPhotoSizeWithSize != null) {
                this.imageView.setImage(ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$Document), (String) null, "webp", (Drawable) null, this.parentObject);
            } else {
                this.imageView.setImage(ImageLocation.getForDocument(tLRPC$Document), (String) null, "webp", (Drawable) null, this.parentObject);
            }
            if (str != null) {
                TextView textView = this.emojiTextView;
                textView.setText(Emoji.replaceEmoji(str, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
                this.emojiTextView.setVisibility(0);
                return;
            }
            if (z) {
                int i = 0;
                while (true) {
                    if (i >= tLRPC$Document.attributes.size()) {
                        break;
                    }
                    TLRPC$DocumentAttribute tLRPC$DocumentAttribute = tLRPC$Document.attributes.get(i);
                    if (tLRPC$DocumentAttribute instanceof TLRPC$TL_documentAttributeSticker) {
                        String str2 = tLRPC$DocumentAttribute.alt;
                        if (str2 == null || str2.length() <= 0) {
                            break;
                        }
                        TextView textView2 = this.emojiTextView;
                        textView2.setText(Emoji.replaceEmoji(tLRPC$DocumentAttribute.alt, textView2.getPaint().getFontMetricsInt(), AndroidUtilities.dp(16.0f), false));
                        z2 = true;
                    } else {
                        i++;
                    }
                }
                z2 = false;
                if (!z2) {
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

    public void setScaled(boolean z) {
        this.scaled = z;
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
            org.rbmain.ui.Components.BackupImageView r7 = r4.imageView
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
            android.view.animation.AccelerateInterpolator r6 = org.rbmain.ui.Cells.StickerEmojiCell.interpolator
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
            org.rbmain.ui.Components.BackupImageView r6 = r4.imageView
            org.rbmain.messenger.ImageReceiver r6 = r6.getImageReceiver()
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
            org.rbmain.ui.Components.BackupImageView r6 = r4.imageView
            float r7 = r4.scale
            r6.setScaleX(r7)
            org.rbmain.ui.Components.BackupImageView r6 = r4.imageView
            float r7 = r4.scale
            r6.setScaleY(r7)
            org.rbmain.ui.Components.BackupImageView r6 = r4.imageView
            r6.invalidate()
            r4.invalidate()
        La2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.StickerEmojiCell.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
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
        accessibilityNodeInfo.setContentDescription(string);
        accessibilityNodeInfo.setEnabled(true);
    }
}
