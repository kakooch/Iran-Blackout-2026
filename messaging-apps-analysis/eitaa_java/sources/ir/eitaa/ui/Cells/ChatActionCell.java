package ir.eitaa.ui.Cells;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$Photo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_documentEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageActionUserUpdatedPhoto;
import ir.eitaa.tgnet.TLRPC$TL_photoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_photoStrippedSize;
import ir.eitaa.tgnet.TLRPC$VideoSize;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.PhotoViewer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatActionCell extends BaseCell implements DownloadController.FileDownloadProgressListener {
    private int TAG;
    private AvatarDrawable avatarDrawable;
    private int backgroundHeight;
    private Path backgroundPath;
    private int currentAccount;
    private MessageObject currentMessageObject;
    private ImageLocation currentVideoLocation;
    private int customDate;
    private CharSequence customText;
    private ChatActionCellDelegate delegate;
    private boolean hasReplyMessage;
    private boolean imagePressed;
    private ImageReceiver imageReceiver;
    private boolean invalidateColors;
    private boolean invalidatePath;
    private float lastTouchX;
    private float lastTouchY;
    private ArrayList<Integer> lineHeights;
    private ArrayList<Integer> lineWidths;
    private String overrideBackground;
    private Paint overrideBackgroundPaint;
    private String overrideText;
    private TextPaint overrideTextPaint;
    private URLSpan pressedLink;
    private int previousWidth;
    private RectF rect;
    private int textHeight;
    private StaticLayout textLayout;
    private int textWidth;
    private int textX;
    private int textXLeft;
    private int textY;
    private ThemeDelegate themeDelegate;
    private float viewTop;
    private boolean visiblePartSet;
    private boolean wasLayout;

    public interface ChatActionCellDelegate {

        /* renamed from: ir.eitaa.ui.Cells.ChatActionCell$ChatActionCellDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didClickImage(ChatActionCellDelegate chatActionCellDelegate, ChatActionCell chatActionCell) {
            }

            public static void $default$didLongPress(ChatActionCellDelegate chatActionCellDelegate, ChatActionCell chatActionCell, float f, float f2) {
            }

            public static void $default$didPressReplyMessage(ChatActionCellDelegate chatActionCellDelegate, ChatActionCell chatActionCell, int i) {
            }

            public static void $default$needOpenInviteLink(ChatActionCellDelegate chatActionCellDelegate, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
            }

            public static void $default$needOpenUserProfile(ChatActionCellDelegate chatActionCellDelegate, long j) {
            }
        }

        void didClickImage(ChatActionCell cell);

        void didLongPress(ChatActionCell cell, float x, float y);

        void didPressReplyMessage(ChatActionCell cell, int id);

        void needOpenInviteLink(TLRPC$TL_chatInviteExported invite);

        void needOpenUserProfile(long uid);
    }

    public interface ThemeDelegate extends Theme.ResourcesProvider {
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String fileName, boolean canceled) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String fileName, long downloadSize, long totalSize) {
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String fileName, long downloadSize, long totalSize, boolean isEncrypted) {
    }

    public ChatActionCell(Context context) {
        this(context, null);
    }

    public ChatActionCell(Context context, ThemeDelegate themeDelegate) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.lineWidths = new ArrayList<>();
        this.lineHeights = new ArrayList<>();
        this.backgroundPath = new Path();
        this.rect = new RectF();
        this.invalidatePath = true;
        this.invalidateColors = false;
        this.themeDelegate = themeDelegate;
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.imageReceiver = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.roundMessageSize / 2);
        this.avatarDrawable = new AvatarDrawable();
        this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
    }

    public void setDelegate(ChatActionCellDelegate delegate) {
        this.delegate = delegate;
    }

    public void setCustomDate(int date, boolean scheduled, boolean inLayout) {
        String dateChat;
        int i = this.customDate;
        if (i == date || i / 3600 == date / 3600) {
            return;
        }
        if (scheduled) {
            dateChat = date == 2147483646 ? LocaleController.getString("MessageScheduledUntilOnline", R.string.MessageScheduledUntilOnline) : LocaleController.formatString("MessageScheduledOn", R.string.MessageScheduledOn, LocaleController.formatDateChat(date));
        } else {
            dateChat = LocaleController.formatDateChat(date);
        }
        CharSequence charSequence = this.customText;
        if (charSequence == null || !TextUtils.equals(dateChat, charSequence)) {
            this.customDate = date;
            this.customText = dateChat;
            updateTextInternal(inLayout);
        }
    }

    private void updateTextInternal(boolean inLayout) {
        if (getMeasuredWidth() != 0) {
            createLayout(this.customText, getMeasuredWidth());
            invalidate();
        }
        if (this.wasLayout) {
            buildLayout();
        } else if (inLayout) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$bsaDT_LN_8fi7-1TYZI7luPWec8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.requestLayout();
                }
            });
        } else {
            requestLayout();
        }
    }

    public void setCustomText(CharSequence text) {
        this.customText = text;
        if (text != null) {
            updateTextInternal(false);
        }
    }

    public void setOverrideColor(String background, String text) {
        this.overrideBackground = background;
        this.overrideText = text;
    }

    public void setMessageObject(MessageObject messageObject) {
        TLRPC$PhotoSize tLRPC$PhotoSize;
        StaticLayout staticLayout;
        if (this.currentMessageObject == messageObject && (((staticLayout = this.textLayout) == null || TextUtils.equals(staticLayout.getText(), messageObject.messageText)) && (this.hasReplyMessage || messageObject.replyMessageObject == null))) {
            return;
        }
        this.currentMessageObject = messageObject;
        this.hasReplyMessage = messageObject.replyMessageObject != null;
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        this.previousWidth = 0;
        TLRPC$VideoSize tLRPC$VideoSize = null;
        if (this.currentMessageObject.type == 11) {
            this.avatarDrawable.setInfo(messageObject.getDialogId(), null, null);
            MessageObject messageObject2 = this.currentMessageObject;
            if (messageObject2.messageOwner.action instanceof TLRPC$TL_messageActionUserUpdatedPhoto) {
                this.imageReceiver.setImage(null, null, this.avatarDrawable, null, messageObject2, 0);
            } else {
                int size = messageObject2.photoThumbs.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        tLRPC$PhotoSize = null;
                        break;
                    }
                    tLRPC$PhotoSize = this.currentMessageObject.photoThumbs.get(i);
                    if (tLRPC$PhotoSize instanceof TLRPC$TL_photoStrippedSize) {
                        break;
                    } else {
                        i++;
                    }
                }
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(this.currentMessageObject.photoThumbs, 640);
                if (closestPhotoSizeWithSize != null) {
                    TLRPC$Photo tLRPC$Photo = messageObject.messageOwner.action.photo;
                    if (!tLRPC$Photo.video_sizes.isEmpty() && SharedConfig.autoplayGifs) {
                        TLRPC$VideoSize tLRPC$VideoSize2 = tLRPC$Photo.video_sizes.get(0);
                        if (messageObject.mediaExists || DownloadController.getInstance(this.currentAccount).canDownloadMedia(4, tLRPC$VideoSize2.size)) {
                            tLRPC$VideoSize = tLRPC$VideoSize2;
                        } else {
                            this.currentVideoLocation = ImageLocation.getForPhoto(tLRPC$VideoSize2, tLRPC$Photo);
                            DownloadController.getInstance(this.currentAccount).addLoadingFileObserver(FileLoader.getAttachFileName(tLRPC$VideoSize2), this.currentMessageObject, this);
                        }
                    }
                    if (tLRPC$VideoSize != null) {
                        this.imageReceiver.setImage(ImageLocation.getForPhoto(tLRPC$VideoSize, tLRPC$Photo), ImageLoader.AUTOPLAY_FILTER, ImageLocation.getForObject(tLRPC$PhotoSize, this.currentMessageObject.photoThumbsObject), "50_50_b", this.avatarDrawable, 0, null, this.currentMessageObject, 1);
                    } else {
                        this.imageReceiver.setImage(ImageLocation.getForObject(closestPhotoSizeWithSize, this.currentMessageObject.photoThumbsObject), "150_150", ImageLocation.getForObject(tLRPC$PhotoSize, this.currentMessageObject.photoThumbsObject), "50_50_b", this.avatarDrawable, 0, null, this.currentMessageObject, 1);
                    }
                } else {
                    this.imageReceiver.setImageBitmap(this.avatarDrawable);
                }
            }
            this.imageReceiver.setVisible(!PhotoViewer.isShowingImage(this.currentMessageObject), false);
        } else {
            this.imageReceiver.setImageBitmap((Bitmap) null);
        }
        requestLayout();
    }

    public MessageObject getMessageObject() {
        return this.currentMessageObject;
    }

    public ImageReceiver getPhotoImage() {
        return this.imageReceiver;
    }

    public void setVisiblePart(float visibleTop, int parentH) {
        this.visiblePartSet = true;
        this.backgroundHeight = parentH;
        this.viewTop = visibleTop;
        if (hasGradientService()) {
            invalidate();
        }
    }

    @Override // ir.eitaa.ui.Cells.BaseCell
    protected boolean onLongPress() {
        ChatActionCellDelegate chatActionCellDelegate = this.delegate;
        if (chatActionCellDelegate == null) {
            return true;
        }
        chatActionCellDelegate.didLongPress(this, this.lastTouchX, this.lastTouchY);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        this.imageReceiver.onDetachedFromWindow();
        this.wasLayout = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.imageReceiver.onAttachedToWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.ChatActionCell.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void createLayout(CharSequence text, int width) {
        int iDp = width - AndroidUtilities.dp(30.0f);
        this.invalidatePath = true;
        StaticLayout staticLayout = new StaticLayout(text, (TextPaint) getThemedPaint("paintChatActionText"), iDp, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        this.textLayout = staticLayout;
        this.textHeight = 0;
        this.textWidth = 0;
        try {
            int lineCount = staticLayout.getLineCount();
            for (int i = 0; i < lineCount; i++) {
                try {
                    float lineWidth = this.textLayout.getLineWidth(i);
                    float f = iDp;
                    if (lineWidth > f) {
                        lineWidth = f;
                    }
                    this.textHeight = (int) Math.max(this.textHeight, Math.ceil(this.textLayout.getLineBottom(i)));
                    this.textWidth = (int) Math.max(this.textWidth, Math.ceil(lineWidth));
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        this.textX = (width - this.textWidth) / 2;
        this.textY = AndroidUtilities.dp(7.0f);
        this.textXLeft = (width - this.textLayout.getWidth()) / 2;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.currentMessageObject == null && this.customText == null) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), this.textHeight + AndroidUtilities.dp(14.0f));
            return;
        }
        int iMax = Math.max(AndroidUtilities.dp(30.0f), View.MeasureSpec.getSize(widthMeasureSpec));
        if (this.previousWidth != iMax) {
            this.wasLayout = true;
            this.previousWidth = iMax;
            buildLayout();
        }
        int i = this.textHeight;
        MessageObject messageObject = this.currentMessageObject;
        setMeasuredDimension(iMax, i + ((messageObject == null || messageObject.type != 11) ? 0 : AndroidUtilities.roundMessageSize + AndroidUtilities.dp(10.0f)) + AndroidUtilities.dp(14.0f));
    }

    private void buildLayout() {
        CharSequence string;
        TLRPC$MessageMedia tLRPC$MessageMedia;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null) {
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if (tLRPC$Message != null && (tLRPC$MessageMedia = tLRPC$Message.media) != null && tLRPC$MessageMedia.ttl_seconds != 0) {
                if (tLRPC$MessageMedia.photo instanceof TLRPC$TL_photoEmpty) {
                    string = LocaleController.getString("AttachPhotoExpired", R.string.AttachPhotoExpired);
                } else if (tLRPC$MessageMedia.document instanceof TLRPC$TL_documentEmpty) {
                    string = LocaleController.getString("AttachVideoExpired", R.string.AttachVideoExpired);
                } else {
                    string = messageObject.messageText;
                }
            } else {
                string = messageObject.messageText;
            }
        } else {
            string = this.customText;
        }
        createLayout(string, this.previousWidth);
        MessageObject messageObject2 = this.currentMessageObject;
        if (messageObject2 == null || messageObject2.type != 11) {
            return;
        }
        ImageReceiver imageReceiver = this.imageReceiver;
        float f = (this.previousWidth - AndroidUtilities.roundMessageSize) / 2;
        float fDp = this.textHeight + AndroidUtilities.dp(19.0f);
        int i = AndroidUtilities.roundMessageSize;
        imageReceiver.setImageCoords(f, fDp, i, i);
    }

    public int getCustomDate() {
        return this.customDate;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        TextPaint textPaint;
        Paint paint2;
        int iIntValue;
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        float f3;
        int i5;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && messageObject.type == 11) {
            this.imageReceiver.draw(canvas);
        }
        if (this.textLayout == null) {
            return;
        }
        Paint themedPaint = getThemedPaint("paintChatActionBackground");
        TextPaint textPaint2 = (TextPaint) getThemedPaint("paintChatActionText");
        String str = this.overrideBackground;
        if (str != null) {
            int themedColor = getThemedColor(str);
            if (this.overrideBackgroundPaint == null) {
                Paint paint3 = new Paint(1);
                this.overrideBackgroundPaint = paint3;
                paint3.setColor(themedColor);
                TextPaint textPaint3 = new TextPaint(1);
                this.overrideTextPaint = textPaint3;
                textPaint3.setTypeface(AndroidUtilities.getFontFamily(true));
                this.overrideTextPaint.setTextSize(AndroidUtilities.dp(Math.max(16, SharedConfig.fontSize) - 2));
                this.overrideTextPaint.setColor(getThemedColor(this.overrideText));
            }
            themedPaint = this.overrideBackgroundPaint;
            textPaint2 = this.overrideTextPaint;
        }
        if (this.invalidatePath) {
            this.invalidatePath = false;
            this.lineWidths.clear();
            int lineCount = this.textLayout.getLineCount();
            int iDp = AndroidUtilities.dp(11.0f);
            int iDp2 = AndroidUtilities.dp(8.0f);
            int i6 = 0;
            for (int i7 = 0; i7 < lineCount; i7++) {
                int iCeil = (int) Math.ceil(this.textLayout.getLineWidth(i7));
                if (i7 == 0 || (i5 = i6 - iCeil) <= 0 || i5 > iDp + iDp2) {
                    i6 = iCeil;
                }
                this.lineWidths.add(Integer.valueOf(i6));
            }
            for (int i8 = lineCount - 2; i8 >= 0; i8--) {
                int iIntValue2 = this.lineWidths.get(i8).intValue();
                int i9 = i6 - iIntValue2;
                if (i9 <= 0 || i9 > iDp + iDp2) {
                    i6 = iIntValue2;
                }
                this.lineWidths.set(i8, Integer.valueOf(i6));
            }
            int iDp3 = AndroidUtilities.dp(4.0f);
            int measuredWidth = getMeasuredWidth() / 2;
            int iDp4 = AndroidUtilities.dp(3.0f);
            int iDp5 = AndroidUtilities.dp(6.0f);
            int i10 = iDp - iDp4;
            this.lineHeights.clear();
            this.backgroundPath.reset();
            float f4 = measuredWidth;
            this.backgroundPath.moveTo(f4, iDp3);
            int i11 = 0;
            int i12 = 0;
            while (i11 < lineCount) {
                int iIntValue3 = this.lineWidths.get(i11).intValue();
                int i13 = iDp2;
                int lineBottom = this.textLayout.getLineBottom(i11);
                TextPaint textPaint4 = textPaint2;
                int i14 = lineCount - 1;
                if (i11 < i14) {
                    paint2 = themedPaint;
                    iIntValue = this.lineWidths.get(i11 + 1).intValue();
                } else {
                    paint2 = themedPaint;
                    iIntValue = 0;
                }
                int iDp6 = lineBottom - i12;
                if (i11 == 0 || iIntValue3 > i6) {
                    f = 3.0f;
                    iDp6 += AndroidUtilities.dp(3.0f);
                } else {
                    f = 3.0f;
                }
                if (i11 == i14 || iIntValue3 > iIntValue) {
                    iDp6 += AndroidUtilities.dp(f);
                }
                float f5 = (iIntValue3 / 2.0f) + f4;
                int i15 = (i11 == i14 || iIntValue3 >= iIntValue || i11 == 0 || iIntValue3 >= i6) ? i13 : iDp5;
                if (i11 == 0 || iIntValue3 > i6) {
                    f2 = f4;
                    i = lineCount;
                    i2 = lineBottom;
                    i3 = i6;
                    i4 = measuredWidth;
                    this.rect.set((f5 - iDp4) - iDp, iDp3, i10 + f5, (iDp * 2) + iDp3);
                    this.backgroundPath.arcTo(this.rect, -90.0f, 90.0f);
                } else {
                    f2 = f4;
                    if (iIntValue3 < i6) {
                        i2 = lineBottom;
                        float f6 = i10 + f5;
                        i4 = measuredWidth;
                        i = lineCount;
                        i3 = i6;
                        this.rect.set(f6, iDp3, (i15 * 2) + f6, r8 + iDp3);
                        this.backgroundPath.arcTo(this.rect, -90.0f, -90.0f);
                    } else {
                        i = lineCount;
                        i2 = lineBottom;
                        i3 = i6;
                        i4 = measuredWidth;
                    }
                }
                iDp3 += iDp6;
                if (i11 == i14 || iIntValue3 >= iIntValue) {
                    f3 = 3.0f;
                } else {
                    f3 = 3.0f;
                    iDp3 -= AndroidUtilities.dp(3.0f);
                    iDp6 -= AndroidUtilities.dp(3.0f);
                }
                if (i11 != 0 && iIntValue3 < i3) {
                    iDp3 -= AndroidUtilities.dp(f3);
                    iDp6 -= AndroidUtilities.dp(f3);
                }
                this.lineHeights.add(Integer.valueOf(iDp6));
                if (i11 == i14 || iIntValue3 > iIntValue) {
                    this.rect.set((f5 - iDp4) - iDp, iDp3 - (iDp * 2), f5 + i10, iDp3);
                    this.backgroundPath.arcTo(this.rect, 0.0f, 90.0f);
                } else if (iIntValue3 < iIntValue) {
                    float f7 = f5 + i10;
                    this.rect.set(f7, iDp3 - r2, (i15 * 2) + f7, iDp3);
                    this.backgroundPath.arcTo(this.rect, 180.0f, -90.0f);
                }
                i11++;
                i6 = iIntValue3;
                iDp2 = i13;
                textPaint2 = textPaint4;
                themedPaint = paint2;
                f4 = f2;
                i12 = i2;
                measuredWidth = i4;
                lineCount = i;
            }
            paint = themedPaint;
            textPaint = textPaint2;
            int i16 = iDp2;
            int i17 = measuredWidth;
            int i18 = lineCount - 1;
            int i19 = i18;
            while (i19 >= 0) {
                int iIntValue4 = i19 != 0 ? this.lineWidths.get(i19 - 1).intValue() : 0;
                int iIntValue5 = this.lineWidths.get(i19).intValue();
                int iIntValue6 = i19 != i18 ? this.lineWidths.get(i19 + 1).intValue() : 0;
                this.textLayout.getLineBottom(i19);
                float f8 = i17 - (iIntValue5 / 2);
                int i20 = (i19 == i18 || iIntValue5 >= iIntValue6 || i19 == 0 || iIntValue5 >= iIntValue4) ? i16 : iDp5;
                if (i19 == i18 || iIntValue5 > iIntValue6) {
                    this.rect.set(f8 - i10, iDp3 - (iDp * 2), iDp4 + f8 + iDp, iDp3);
                    this.backgroundPath.arcTo(this.rect, 90.0f, 90.0f);
                } else if (iIntValue5 < iIntValue6) {
                    float f9 = f8 - i10;
                    this.rect.set(f9 - (i20 * 2), iDp3 - r12, f9, iDp3);
                    this.backgroundPath.arcTo(this.rect, 90.0f, -90.0f);
                }
                iDp3 -= this.lineHeights.get(i19).intValue();
                if (i19 == 0 || iIntValue5 > iIntValue4) {
                    this.rect.set(f8 - i10, iDp3, f8 + iDp4 + iDp, (iDp * 2) + iDp3);
                    this.backgroundPath.arcTo(this.rect, 180.0f, 90.0f);
                } else if (iIntValue5 < iIntValue4) {
                    float f10 = f8 - i10;
                    this.rect.set(f10 - (i20 * 2), iDp3, f10, r7 + iDp3);
                    this.backgroundPath.arcTo(this.rect, 0.0f, -90.0f);
                }
                i19--;
            }
            this.backgroundPath.close();
        } else {
            paint = themedPaint;
            textPaint = textPaint2;
        }
        if (!this.visiblePartSet) {
            this.backgroundHeight = ((ViewGroup) getParent()).getMeasuredHeight();
        }
        ThemeDelegate themeDelegate = this.themeDelegate;
        if (themeDelegate != null) {
            themeDelegate.applyServiceShaderMatrix(getMeasuredWidth(), this.backgroundHeight, 0.0f, this.viewTop + AndroidUtilities.dp(4.0f));
        } else {
            Theme.applyServiceShaderMatrix(getMeasuredWidth(), this.backgroundHeight, 0.0f, this.viewTop + AndroidUtilities.dp(4.0f));
        }
        canvas.drawPath(this.backgroundPath, paint);
        if (hasGradientService()) {
            canvas.drawPath(this.backgroundPath, Theme.chat_actionBackgroundGradientDarkenPaint);
        }
        canvas.save();
        canvas.translate(this.textXLeft, this.textY);
        if (this.textLayout.getPaint() != textPaint) {
            buildLayout();
        }
        this.textLayout.draw(canvas);
        canvas.restore();
    }

    protected boolean hasGradientService() {
        ThemeDelegate themeDelegate = this.themeDelegate;
        return themeDelegate != null ? themeDelegate.hasGradientService() : Theme.hasGradientService();
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String fileName) {
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || messageObject.type != 11) {
            return;
        }
        TLRPC$PhotoSize tLRPC$PhotoSize = null;
        int i = 0;
        int size = messageObject.photoThumbs.size();
        while (true) {
            if (i >= size) {
                break;
            }
            TLRPC$PhotoSize tLRPC$PhotoSize2 = this.currentMessageObject.photoThumbs.get(i);
            if (tLRPC$PhotoSize2 instanceof TLRPC$TL_photoStrippedSize) {
                tLRPC$PhotoSize = tLRPC$PhotoSize2;
                break;
            }
            i++;
        }
        this.imageReceiver.setImage(this.currentVideoLocation, ImageLoader.AUTOPLAY_FILTER, ImageLocation.getForObject(tLRPC$PhotoSize, this.currentMessageObject.photoThumbsObject), "50_50_b", this.avatarDrawable, 0, null, this.currentMessageObject, 1);
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
    }

    @Override // ir.eitaa.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (TextUtils.isEmpty(this.customText) && this.currentMessageObject == null) {
            return;
        }
        info.setText(!TextUtils.isEmpty(this.customText) ? this.customText : this.currentMessageObject.messageText);
        info.setEnabled(true);
    }

    public void setInvalidateColors(boolean invalidate) {
        if (this.invalidateColors == invalidate) {
            return;
        }
        this.invalidateColors = invalidate;
        invalidate();
    }

    private int getThemedColor(String key) {
        ThemeDelegate themeDelegate = this.themeDelegate;
        Integer color = themeDelegate != null ? themeDelegate.getColor(key) : null;
        return color != null ? color.intValue() : Theme.getColor(key);
    }

    private Paint getThemedPaint(String paintKey) {
        ThemeDelegate themeDelegate = this.themeDelegate;
        Paint paint = themeDelegate != null ? themeDelegate.getPaint(paintKey) : null;
        return paint != null ? paint : Theme.getThemePaint(paintKey);
    }
}
