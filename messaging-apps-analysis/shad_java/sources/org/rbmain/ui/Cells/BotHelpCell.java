package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.FileRefController;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$BotInfo;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$Photo;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_photo;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LinkSpanDrawable;
import org.rbmain.ui.Components.TypefaceSpan;

/* loaded from: classes4.dex */
public class BotHelpCell extends View {
    private boolean animating;
    private String currentPhotoKey;
    private BotHelpCellDelegate delegate;
    private int height;
    private int imagePadding;
    private ImageReceiver imageReceiver;
    private boolean isPhotoVisible;
    private boolean isTextVisible;
    private LinkSpanDrawable.LinkCollector links;
    private String oldText;
    private int photoHeight;
    private LinkSpanDrawable<ClickableSpan> pressedLink;
    private Theme.ResourcesProvider resourcesProvider;
    private Drawable selectorDrawable;
    private int selectorDrawableRadius;
    private StaticLayout textLayout;
    private int textX;
    private int textY;
    private int width;

    public interface BotHelpCellDelegate {
        void didPressUrl(String str);
    }

    public BotHelpCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.links = new LinkSpanDrawable.LinkCollector(this);
        this.imagePadding = AndroidUtilities.dp(4.0f);
        this.resourcesProvider = resourcesProvider;
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.imageReceiver = imageReceiver;
        imageReceiver.setInvalidateAll(true);
        this.imageReceiver.setCrossfadeWithOldImage(true);
        this.imageReceiver.setCrossfadeDuration(300);
        int color = Theme.getColor(Theme.key_listSelector, resourcesProvider);
        int i = SharedConfig.bubbleRadius;
        this.selectorDrawableRadius = i;
        Drawable drawableCreateRadSelectorDrawable = Theme.createRadSelectorDrawable(color, i, i);
        this.selectorDrawable = drawableCreateRadSelectorDrawable;
        drawableCreateRadSelectorDrawable.setCallback(this);
    }

    public void setDelegate(BotHelpCellDelegate botHelpCellDelegate) {
        this.delegate = botHelpCellDelegate;
    }

    private void resetPressedLink() {
        if (this.pressedLink != null) {
            this.pressedLink = null;
        }
        this.links.clear();
        invalidate();
    }

    public void setText(boolean z, String str) {
        setText(z, str, null, null);
    }

    public void setText(boolean z, String str, TLObject tLObject, TLRPC$BotInfo tLRPC$BotInfo) {
        int iMin;
        boolean z2 = tLObject != null;
        boolean z3 = !TextUtils.isEmpty(str);
        if ((str == null || str.length() == 0) && !z2) {
            setVisibility(8);
            return;
        }
        String str2 = str == null ? BuildConfig.FLAVOR : str;
        if (str2.equals(this.oldText) && this.isPhotoVisible == z2) {
            return;
        }
        this.isPhotoVisible = z2;
        this.isTextVisible = z3;
        if (z2) {
            String keyForParentObject = FileRefController.getKeyForParentObject(tLRPC$BotInfo);
            if (!CallProxy$$ExternalSyntheticBackport0.m(this.currentPhotoKey, keyForParentObject)) {
                this.currentPhotoKey = keyForParentObject;
                if (tLObject instanceof TLRPC$TL_photo) {
                    TLRPC$Photo tLRPC$Photo = (TLRPC$Photo) tLObject;
                    this.imageReceiver.setImage(ImageLocation.getForPhoto(FileLoader.getClosestPhotoSizeWithSize(tLRPC$Photo.sizes, 400), tLRPC$Photo), "400_400", null, "jpg", tLRPC$BotInfo, 0);
                } else if (tLObject instanceof TLRPC$Document) {
                    TLRPC$Document tLRPC$Document = (TLRPC$Document) tLObject;
                    TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(tLRPC$Document.thumbs, 400);
                    BitmapDrawable bitmapDrawable = null;
                    if (SharedConfig.getDevicePerformanceClass() != 0) {
                        Iterator<TLRPC$PhotoSize> it = tLRPC$Document.thumbs.iterator();
                        while (it.hasNext()) {
                            TLRPC$PhotoSize next = it.next();
                            if (next instanceof TLRPC$TL_photoStrippedSize) {
                                bitmapDrawable = new BitmapDrawable(getResources(), ImageLoader.getStrippedPhotoBitmap(next.bytes, "b"));
                            }
                        }
                    }
                    this.imageReceiver.setImage(ImageLocation.getForDocument(tLRPC$Document), ImageLoader.AUTOPLAY_FILTER, ImageLocation.getForDocument(MessageObject.getDocumentVideoThumb(tLRPC$Document), tLRPC$Document), null, ImageLocation.getForDocument(closestPhotoSizeWithSize, tLRPC$Document), "86_86_b", bitmapDrawable, tLRPC$Document.size, "mp4", tLRPC$BotInfo, 0);
                }
                int iDp = AndroidUtilities.dp(SharedConfig.bubbleRadius) - AndroidUtilities.dp(2.0f);
                int iDp2 = AndroidUtilities.dp(4.0f);
                if (!this.isTextVisible) {
                    iDp2 = iDp;
                }
                this.imageReceiver.setRoundRadius(iDp, iDp, iDp2, iDp2);
            }
        }
        this.oldText = AndroidUtilities.getSafeString(str2);
        setVisibility(0);
        if (AndroidUtilities.isTablet()) {
            iMin = AndroidUtilities.getMinTabletSide();
        } else {
            Point point = AndroidUtilities.displaySize;
            iMin = Math.min(point.x, point.y);
        }
        int i = (int) (iMin * 0.7f);
        if (this.isTextVisible) {
            String[] strArrSplit = str2.split("\n");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = LocaleController.getString(R.string.BotInfoTitle);
            if (z) {
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.append((CharSequence) "\n\n");
            }
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                spannableStringBuilder.append((CharSequence) strArrSplit[i2].trim());
                if (i2 != strArrSplit.length - 1) {
                    spannableStringBuilder.append((CharSequence) "\n");
                }
            }
            MessageObject.addLinks(false, spannableStringBuilder);
            if (z) {
                spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), 0, string.length(), 33);
            }
            Emoji.replaceEmoji(spannableStringBuilder, Theme.chat_msgTextPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
            try {
                StaticLayout staticLayout = new StaticLayout(spannableStringBuilder, Theme.chat_msgTextPaint, i - (this.isPhotoVisible ? AndroidUtilities.dp(5.0f) : 0), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                this.textLayout = staticLayout;
                this.width = 0;
                this.height = staticLayout.getHeight() + AndroidUtilities.dp(22.0f);
                int lineCount = this.textLayout.getLineCount();
                for (int i3 = 0; i3 < lineCount; i3++) {
                    this.width = (int) Math.ceil(Math.max(this.width, this.textLayout.getLineWidth(i3) + this.textLayout.getLineLeft(i3)));
                }
                if (this.width > i || this.isPhotoVisible) {
                    this.width = i;
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        } else if (this.isPhotoVisible) {
            this.width = i;
        }
        int iDp3 = this.width + AndroidUtilities.dp(22.0f);
        this.width = iDp3;
        if (this.isPhotoVisible) {
            int i4 = this.height;
            double d = iDp3;
            Double.isNaN(d);
            int i5 = (int) (d * 0.5625d);
            this.photoHeight = i5;
            this.height = i4 + i5 + AndroidUtilities.dp(4.0f);
        }
    }

    public CharSequence getText() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout == null) {
            return null;
        }
        return staticLayout.getText();
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0120  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.BotHelpCell.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), this.height + AndroidUtilities.dp(8.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = (getWidth() - this.width) / 2;
        int iDp = this.photoHeight + AndroidUtilities.dp(2.0f);
        Drawable shadowDrawable = Theme.chat_msgInMediaDrawable.getShadowDrawable();
        if (shadowDrawable != null) {
            shadowDrawable.setBounds(width, iDp, this.width + width, this.height + iDp);
            shadowDrawable.draw(canvas);
        }
        Point point = AndroidUtilities.displaySize;
        int measuredWidth = point.x;
        int measuredHeight = point.y;
        if (getParent() instanceof View) {
            View view = (View) getParent();
            measuredWidth = view.getMeasuredWidth();
            measuredHeight = view.getMeasuredHeight();
        }
        int i = measuredHeight;
        Theme.MessageDrawable messageDrawable = (Theme.MessageDrawable) getThemedDrawable("drawableMsgInMedia");
        messageDrawable.setTop((int) getY(), measuredWidth, i, false, false);
        messageDrawable.setBounds(width, 0, this.width + width, this.height);
        messageDrawable.draw(canvas);
        Drawable drawable = this.selectorDrawable;
        if (drawable != null) {
            int i2 = this.selectorDrawableRadius;
            int i3 = SharedConfig.bubbleRadius;
            if (i2 != i3) {
                this.selectorDrawableRadius = i3;
                Theme.setMaskDrawableRad(drawable, i3, i3);
            }
            this.selectorDrawable.setBounds(AndroidUtilities.dp(2.0f) + width, AndroidUtilities.dp(2.0f), (this.width + width) - AndroidUtilities.dp(2.0f), this.height - AndroidUtilities.dp(2.0f));
            this.selectorDrawable.draw(canvas);
        }
        this.imageReceiver.setImageCoords(width + r3, this.imagePadding, this.width - (r3 * 2), this.photoHeight - r3);
        this.imageReceiver.draw(canvas);
        Theme.chat_msgTextPaint.setColor(getThemedColor(Theme.key_chat_messageTextIn));
        Theme.chat_msgTextPaint.linkColor = getThemedColor(Theme.key_chat_messageLinkIn);
        canvas.save();
        int iDp2 = AndroidUtilities.dp(this.isPhotoVisible ? 14.0f : 11.0f) + width;
        this.textX = iDp2;
        float f = iDp2;
        int iDp3 = AndroidUtilities.dp(11.0f) + iDp;
        this.textY = iDp3;
        canvas.translate(f, iDp3);
        if (this.links.draw(canvas)) {
            invalidate();
        }
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageReceiver.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.imageReceiver.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            accessibilityNodeInfo.setText(staticLayout.getText());
        }
    }

    public boolean animating() {
        return this.animating;
    }

    public void setAnimating(boolean z) {
        this.animating = z;
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i, this.resourcesProvider);
    }

    private Drawable getThemedDrawable(String str) {
        Theme.ResourcesProvider resourcesProvider = this.resourcesProvider;
        Drawable drawable = resourcesProvider != null ? resourcesProvider.getDrawable(str) : null;
        return drawable != null ? drawable : Theme.getThemeDrawable(str);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.selectorDrawable || super.verifyDrawable(drawable);
    }
}
