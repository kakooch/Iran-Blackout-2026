package org.rbmain.ui.Cells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_documentEmpty;
import org.rbmain.tgnet.TLRPC$TL_photoEmpty;
import org.rbmain.tgnet.TLRPC$TL_photoStrippedSize;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AnimatedEmojiSpan;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.RadialProgress2;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.TypefaceSpan;
import org.rbmain.ui.Components.URLSpanNoUnderline;
import org.rbmain.ui.Components.spoilers.SpoilerEffect;

/* loaded from: classes4.dex */
public class ChatActionCell extends BaseCell implements DownloadController.FileDownloadProgressListener, NotificationCenter.NotificationCenterDelegate {
    private static Map<Integer, String> monthsToEmoticon;
    private int TAG;
    private SpannableStringBuilder accessibilityText;
    private AnimatedEmojiSpan.EmojiGroupedSpans animatedEmojiStack;
    private AvatarDrawable avatarDrawable;
    private int backgroundButtonTop;
    private int backgroundHeight;
    private Path backgroundPath;
    private int backgroundRectHeight;
    private RectF backroundRect;
    private boolean canDrawInParent;
    private int currentAccount;
    private MessageObject currentMessageObject;
    private ImageLocation currentVideoLocation;
    private int customDate;
    private CharSequence customText;
    private ChatActionCellDelegate delegate;
    private boolean giftButtonPressed;
    private RectF giftButtonRect;
    private int giftPremiumAdditionalHeight;
    private StaticLayout giftPremiumButtonLayout;
    private float giftPremiumButtonWidth;
    private StaticLayout giftPremiumSubtitleLayout;
    private StaticLayout giftPremiumTitleLayout;
    private int giftRectSize;
    private TextPaint giftSubtitlePaint;
    private TextPaint giftTitlePaint;
    private boolean hasReplyMessage;
    private boolean imagePressed;
    private ImageReceiver imageReceiver;
    private boolean invalidateColors;
    private boolean invalidatePath;
    private View invalidateWithParent;
    private float lastTouchX;
    private float lastTouchY;
    private ArrayList<Integer> lineHeights;
    private ArrayList<Integer> lineWidths;
    private int overrideBackground;
    private Paint overrideBackgroundPaint;
    private int overrideText;
    private TextPaint overrideTextPaint;
    private URLSpan pressedLink;
    private int previousWidth;
    float progressToProgress;
    RadialProgressView progressView;
    private RadialProgress2 radialProgress;
    private RectF rect;
    private View rippleView;
    private StaticLayout settingWallpaperLayout;
    TextPaint settingWallpaperPaint;
    private float settingWallpaperProgress;
    private StaticLayout settingWallpaperProgressTextLayout;
    public List<SpoilerEffect> spoilers;
    private Stack<SpoilerEffect> spoilersPool;
    private Path starsPath;
    private int stickerSize;
    private int textHeight;
    private StaticLayout textLayout;
    TextPaint textPaint;
    private int textWidth;
    private int textX;
    private int textXLeft;
    private int textY;
    private ThemeDelegate themeDelegate;
    private float viewTop;
    private boolean visiblePartSet;
    private boolean wasLayout;

    public interface ChatActionCellDelegate {

        /* renamed from: org.rbmain.ui.Cells.ChatActionCell$ChatActionCellDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static boolean $default$canDrawOutboundsContent(ChatActionCellDelegate chatActionCellDelegate) {
                return true;
            }

            public static void $default$didClickImage(ChatActionCellDelegate chatActionCellDelegate, ChatActionCell chatActionCell) {
            }

            public static boolean $default$didLongPress(ChatActionCellDelegate chatActionCellDelegate, ChatActionCell chatActionCell, float f, float f2) {
                return false;
            }

            public static void $default$didPressReplyMessage(ChatActionCellDelegate chatActionCellDelegate, ChatActionCell chatActionCell, long j) {
            }

            public static int $default$getTopicId(ChatActionCellDelegate chatActionCellDelegate) {
                return 0;
            }

            public static void $default$needOpenInviteLink(ChatActionCellDelegate chatActionCellDelegate, TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
            }

            public static void $default$needOpenUserProfile(ChatActionCellDelegate chatActionCellDelegate, int i) {
            }
        }

        boolean canDrawOutboundsContent();

        void didClickImage(ChatActionCell chatActionCell);

        boolean didLongPress(ChatActionCell chatActionCell, float f, float f2);

        void didPressReplyMessage(ChatActionCell chatActionCell, long j);

        int getTopicId();

        void needOpenInviteLink(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported);

        void needOpenUserProfile(int i);
    }

    public interface ThemeDelegate extends Theme.ResourcesProvider {
    }

    private float getUploadingInfoProgress(MessageObject messageObject) {
        return 1.0f;
    }

    private void openPremiumGiftPreview() {
    }

    private void setStarsPaused(boolean z) {
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onFailedDownload(String str, boolean z) {
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressDownload(String str, long j, long j2) {
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onProgressUpload(String str, long j, long j2, boolean z) {
    }

    static {
        HashMap map = new HashMap();
        monthsToEmoticon = map;
        map.put(1, "1⃣");
        monthsToEmoticon.put(3, "2⃣");
        monthsToEmoticon.put(6, "3⃣");
        monthsToEmoticon.put(12, "4⃣");
        monthsToEmoticon.put(24, "5⃣");
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.startSpoilers) {
            setSpoilersSuppressed(false);
        } else if (i == NotificationCenter.stopSpoilers) {
            setSpoilersSuppressed(true);
        } else {
            int i3 = NotificationCenter.diceStickersDidLoad;
        }
    }

    public void setSpoilersSuppressed(boolean z) {
        Iterator<SpoilerEffect> it = this.spoilers.iterator();
        while (it.hasNext()) {
            it.next().setSuppressUpdates(z);
        }
    }

    public void setInvalidateWithParent(View view) {
        this.invalidateWithParent = view;
    }

    public ChatActionCell(Context context) {
        this(context, false, null);
    }

    public ChatActionCell(Context context, boolean z, ThemeDelegate themeDelegate) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.giftButtonRect = new RectF();
        this.spoilers = new ArrayList();
        this.spoilersPool = new Stack<>();
        this.overrideBackground = -1;
        this.overrideText = -1;
        this.lineWidths = new ArrayList<>();
        this.lineHeights = new ArrayList<>();
        this.backgroundPath = new Path();
        this.rect = new RectF();
        this.invalidatePath = true;
        this.invalidateColors = false;
        this.giftTitlePaint = new TextPaint(1);
        this.giftSubtitlePaint = new TextPaint(1);
        this.radialProgress = new RadialProgress2(this);
        this.starsPath = new Path();
        this.canDrawInParent = z;
        this.themeDelegate = themeDelegate;
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.imageReceiver = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.roundMessageSize / 2);
        this.avatarDrawable = new AvatarDrawable();
        this.TAG = DownloadController.getInstance(this.currentAccount).generateObserverTag();
        this.giftTitlePaint.setTextSize(TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics()));
        this.giftSubtitlePaint.setTextSize(TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics()));
        View view = new View(context);
        this.rippleView = view;
        view.setBackground(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector), 7, AndroidUtilities.dp(16.0f)));
        this.rippleView.setVisibility(8);
        addView(this.rippleView);
    }

    public void setDelegate(ChatActionCellDelegate chatActionCellDelegate) {
        this.delegate = chatActionCellDelegate;
    }

    public void setCustomDate(int i, boolean z, boolean z2) {
        String dateChat;
        if (this.customDate == i) {
            return;
        }
        if (z) {
            dateChat = i == 2147483646 ? LocaleController.getString("MessageScheduledUntilOnline", R.string.MessageScheduledUntilOnline) : LocaleController.formatString("MessageScheduledOn", R.string.MessageScheduledOn, LocaleController.formatDateChat(i));
        } else {
            dateChat = LocaleController.formatDateChat(i);
        }
        this.customDate = i;
        CharSequence charSequence = this.customText;
        if (charSequence == null || !TextUtils.equals(dateChat, charSequence)) {
            this.customText = dateChat;
            this.accessibilityText = null;
            updateTextInternal(z2);
        }
    }

    private void updateTextInternal(boolean z) {
        if (getMeasuredWidth() != 0) {
            createLayout(this.customText, getMeasuredWidth());
            invalidate();
        }
        if (this.wasLayout) {
            buildLayout();
        } else if (z) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Cells.ChatActionCell$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.requestLayout();
                }
            });
        } else {
            requestLayout();
        }
    }

    public void setCustomText(CharSequence charSequence) {
        this.customText = charSequence;
        if (charSequence != null) {
            updateTextInternal(false);
        }
    }

    public void setOverrideColor(int i, int i2) {
        this.overrideBackground = i;
        this.overrideText = i2;
    }

    public void setMessageObject(MessageObject messageObject) {
        setMessageObject(messageObject, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setMessageObject(org.rbmain.messenger.MessageObject r27, boolean r28) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatActionCell.setMessageObject(org.rbmain.messenger.MessageObject, boolean):void");
    }

    public MessageObject getMessageObject() {
        return this.currentMessageObject;
    }

    public ImageReceiver getPhotoImage() {
        return this.imageReceiver;
    }

    public void setVisiblePart(float f, int i) {
        this.visiblePartSet = true;
        this.backgroundHeight = i;
        this.viewTop = f;
    }

    @Override // org.rbmain.ui.Cells.BaseCell
    protected boolean onLongPress() {
        ChatActionCellDelegate chatActionCellDelegate = this.delegate;
        if (chatActionCellDelegate != null) {
            return chatActionCellDelegate.didLongPress(this, this.lastTouchX, this.lastTouchY);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.rippleView;
        RectF rectF = this.giftButtonRect;
        view.layout((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
        this.imageReceiver.onDetachedFromWindow();
        setStarsPaused(true);
        this.wasLayout = false;
        AnimatedEmojiSpan.release(this, this.animatedEmojiStack);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.diceStickersDidLoad);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ChatActionCellDelegate chatActionCellDelegate;
        super.onAttachedToWindow();
        this.imageReceiver.onAttachedToWindow();
        setStarsPaused(false);
        this.animatedEmojiStack = AnimatedEmojiSpan.update(0, this, (!this.canDrawInParent || (chatActionCellDelegate = this.delegate) == null || chatActionCellDelegate.canDrawOutboundsContent()) ? false : true, this.animatedEmojiStack, this.textLayout);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.diceStickersDidLoad);
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null || messageObject.type != 21) {
            return;
        }
        setMessageObject(messageObject, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0138  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatActionCell.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openLink(CharacterStyle characterStyle) {
        if (this.delegate == null || !(characterStyle instanceof URLSpan)) {
            return;
        }
        String url = ((URLSpan) characterStyle).getURL();
        if (url.startsWith("topic")) {
            URLSpan uRLSpan = this.pressedLink;
            if (uRLSpan instanceof URLSpanNoUnderline) {
                ((URLSpanNoUnderline) uRLSpan).getObject();
                return;
            }
        }
        if (url.startsWith("invite")) {
            URLSpan uRLSpan2 = this.pressedLink;
            if (uRLSpan2 instanceof URLSpanNoUnderline) {
                TLObject object = ((URLSpanNoUnderline) uRLSpan2).getObject();
                if (object instanceof TLRPC$TL_chatInviteExported) {
                    this.delegate.needOpenInviteLink((TLRPC$TL_chatInviteExported) object);
                    return;
                }
                return;
            }
        }
        if (url.startsWith("game")) {
            this.delegate.didPressReplyMessage(this, this.currentMessageObject.getReplyMsgId());
        } else if (url.startsWith("http")) {
            Browser.openUrl(getContext(), url);
        } else {
            this.delegate.needOpenUserProfile(Integer.parseInt(url));
        }
    }

    private void createLayout(CharSequence charSequence, int i) {
        TextPaint textPaint;
        ChatActionCellDelegate chatActionCellDelegate;
        int iDp = i - AndroidUtilities.dp(30.0f);
        if (iDp < 0) {
            return;
        }
        this.invalidatePath = true;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && messageObject.drawServiceWithDefaultTypeface) {
            textPaint = (TextPaint) getThemedPaint("paintChatActionText2");
        } else {
            textPaint = (TextPaint) getThemedPaint("paintChatActionText");
        }
        TextPaint textPaint2 = textPaint;
        textPaint2.linkColor = textPaint2.getColor();
        this.textLayout = new StaticLayout(charSequence, textPaint2, iDp, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        this.animatedEmojiStack = AnimatedEmojiSpan.update(0, this, (!this.canDrawInParent || (chatActionCellDelegate = this.delegate) == null || chatActionCellDelegate.canDrawOutboundsContent()) ? false : true, this.animatedEmojiStack, this.textLayout);
        this.textHeight = 0;
        this.textWidth = 0;
        try {
            int lineCount = this.textLayout.getLineCount();
            for (int i2 = 0; i2 < lineCount; i2++) {
                try {
                    float lineWidth = this.textLayout.getLineWidth(i2);
                    float f = iDp;
                    if (lineWidth > f) {
                        lineWidth = f;
                    }
                    this.textHeight = (int) Math.max(this.textHeight, Math.ceil(this.textLayout.getLineBottom(i2)));
                    this.textWidth = (int) Math.max(this.textWidth, Math.ceil(lineWidth));
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        this.textX = (i - this.textWidth) / 2;
        this.textY = AndroidUtilities.dp(7.0f);
        this.textXLeft = (i - this.textLayout.getWidth()) / 2;
        this.spoilersPool.addAll(this.spoilers);
        this.spoilers.clear();
        if (charSequence instanceof Spannable) {
            StaticLayout staticLayout = this.textLayout;
            int i3 = this.textX;
            SpoilerEffect.addSpoilers(this, staticLayout, i3, i3 + this.textWidth, (Spannable) charSequence, this.spoilersPool, this.spoilers);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iDp;
        float fDp;
        float fDp2;
        int i3;
        int iDp2;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject == null && this.customText == null) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), this.textHeight + AndroidUtilities.dp(14.0f));
            return;
        }
        int iDp3 = 0;
        if (isButtonLayout(messageObject)) {
            int iMin = Math.min((int) ((AndroidUtilities.isTablet() ? AndroidUtilities.getMinTabletSide() : AndroidUtilities.displaySize.x) * 0.6f), ((AndroidUtilities.displaySize.y - ActionBar.getCurrentActionBarHeight()) - AndroidUtilities.statusBarHeight) - AndroidUtilities.dp(64.0f));
            this.giftRectSize = iMin;
            int iDp4 = iMin - AndroidUtilities.dp(106.0f);
            this.stickerSize = iDp4;
            int i4 = messageObject.type;
            if (i4 == 21 || i4 == 22) {
                this.imageReceiver.setRoundRadius(iDp4 / 2);
            } else {
                this.imageReceiver.setRoundRadius(0);
            }
        }
        int iMax = Math.max(AndroidUtilities.dp(30.0f), View.MeasureSpec.getSize(i));
        if (this.previousWidth != iMax) {
            this.wasLayout = true;
            this.previousWidth = iMax;
            buildLayout();
        }
        if (messageObject == null) {
            iDp = 0;
        } else {
            if (messageObject.type == 11) {
                i3 = AndroidUtilities.roundMessageSize;
                iDp2 = AndroidUtilities.dp(10.0f);
            } else {
                if (isButtonLayout(messageObject)) {
                    i3 = this.giftRectSize;
                    iDp2 = AndroidUtilities.dp(12.0f);
                }
                iDp = 0;
            }
            iDp = i3 + iDp2;
        }
        if (isButtonLayout(messageObject)) {
            int imageSize = getImageSize(messageObject);
            if (messageObject.type == 22) {
                fDp = this.textY + this.textHeight + AndroidUtilities.dp(12.0f) + (AndroidUtilities.dp(16.0f) * 2) + imageSize + this.giftPremiumSubtitleLayout.getHeight() + AndroidUtilities.dp(4.0f);
            } else {
                fDp = this.textY + this.textHeight + (this.giftRectSize * 0.075f) + imageSize + AndroidUtilities.dp(4.0f) + AndroidUtilities.dp(4.0f) + this.giftPremiumSubtitleLayout.getHeight();
            }
            this.giftPremiumAdditionalHeight = 0;
            if (this.giftPremiumTitleLayout != null) {
                fDp2 = fDp + r13.getHeight();
            } else {
                fDp2 = fDp - AndroidUtilities.dp(12.0f);
                this.giftPremiumAdditionalHeight -= AndroidUtilities.dp(30.0f);
            }
            if (messageObject.type == 21) {
                fDp2 += AndroidUtilities.dp(16.0f);
            }
            if (this.giftPremiumSubtitleLayout.getLineCount() > 2) {
                this.giftPremiumAdditionalHeight += ((this.giftPremiumSubtitleLayout.getLineBottom(0) - this.giftPremiumSubtitleLayout.getLineTop(0)) * this.giftPremiumSubtitleLayout.getLineCount()) - 2;
            }
            iDp += this.giftPremiumAdditionalHeight;
            int iDp5 = this.textHeight + iDp + AndroidUtilities.dp(14.0f);
            StaticLayout staticLayout = this.giftPremiumButtonLayout;
            if (staticLayout != null) {
                float height = fDp2 + ((((iDp5 - fDp2) - (staticLayout != null ? staticLayout.getHeight() : 0)) - AndroidUtilities.dp(8.0f)) / 2.0f);
                float f = (this.previousWidth - this.giftPremiumButtonWidth) / 2.0f;
                this.giftButtonRect.set(f - AndroidUtilities.dp(18.0f), height - AndroidUtilities.dp(8.0f), f + this.giftPremiumButtonWidth + AndroidUtilities.dp(18.0f), height + (this.giftPremiumButtonLayout != null ? r6.getHeight() : 0) + AndroidUtilities.dp(8.0f));
            } else {
                iDp -= AndroidUtilities.dp(40.0f);
                this.giftPremiumAdditionalHeight -= AndroidUtilities.dp(40.0f);
            }
            getMeasuredWidth();
            getMeasuredHeight();
            if (messageObject.type == 22) {
                int iDp6 = this.textY + this.textHeight + AndroidUtilities.dp(12.0f);
                this.backgroundRectHeight = 0;
                int iDp7 = 0 + (AndroidUtilities.dp(16.0f) * 2) + imageSize;
                this.backgroundRectHeight = iDp7;
                int height2 = iDp7 + this.giftPremiumSubtitleLayout.getHeight();
                this.backgroundRectHeight = height2;
                if (this.giftPremiumButtonLayout != null) {
                    this.backgroundButtonTop = height2 + iDp6 + AndroidUtilities.dp(10.0f);
                    float f2 = (this.previousWidth - this.giftPremiumButtonWidth) / 2.0f;
                    this.giftButtonRect.set(f2 - AndroidUtilities.dp(18.0f), this.backgroundButtonTop, f2 + this.giftPremiumButtonWidth + AndroidUtilities.dp(18.0f), this.backgroundButtonTop + this.giftPremiumButtonLayout.getHeight() + (AndroidUtilities.dp(8.0f) * 2));
                    this.backgroundRectHeight = (int) (this.backgroundRectHeight + AndroidUtilities.dp(10.0f) + this.giftButtonRect.height());
                }
                int iDp8 = this.backgroundRectHeight + AndroidUtilities.dp(16.0f);
                this.backgroundRectHeight = iDp8;
                iDp3 = iDp6 + iDp8 + AndroidUtilities.dp(14.0f);
            }
        }
        if (messageObject != null && messageObject.type == 22) {
            setMeasuredDimension(iMax, iDp3);
        } else {
            setMeasuredDimension(iMax, this.textHeight + iDp + AndroidUtilities.dp(14.0f));
        }
    }

    private int getImageSize(MessageObject messageObject) {
        int i = this.stickerSize;
        int i2 = messageObject.type;
        return (i2 == 21 || i2 == 22) ? (int) (i * 0.7f) : i;
    }

    private void buildLayout() {
        CharSequence charSequenceCloneSpans;
        CharSequence charSequence;
        String string;
        TLRPC$MessageMedia tLRPC$MessageMedia;
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null) {
            if (this.delegate.getTopicId() == 0) {
                MessageObject.isTopicActionMessage(messageObject);
            }
            TLRPC$Message tLRPC$Message = messageObject.messageOwner;
            if (tLRPC$Message != null && (tLRPC$MessageMedia = tLRPC$Message.media) != null && tLRPC$MessageMedia.ttl_seconds != 0) {
                if (tLRPC$MessageMedia.photo instanceof TLRPC$TL_photoEmpty) {
                    charSequenceCloneSpans = LocaleController.getString("AttachPhotoExpired", R.string.AttachPhotoExpired);
                } else if (tLRPC$MessageMedia.document instanceof TLRPC$TL_documentEmpty) {
                    charSequenceCloneSpans = LocaleController.getString("AttachVideoExpired", R.string.AttachVideoExpired);
                } else {
                    charSequenceCloneSpans = AnimatedEmojiSpan.cloneSpans(messageObject.messageText);
                }
            } else {
                charSequenceCloneSpans = AnimatedEmojiSpan.cloneSpans(messageObject.messageText);
            }
        } else {
            charSequenceCloneSpans = this.customText;
        }
        createLayout(charSequenceCloneSpans, this.previousWidth);
        if (messageObject != null) {
            int i = messageObject.type;
            if (i == 11) {
                float fDp = this.textHeight + AndroidUtilities.dp(19.0f);
                int i2 = AndroidUtilities.roundMessageSize;
                this.imageReceiver.setImageCoords((this.previousWidth - AndroidUtilities.roundMessageSize) / 2.0f, fDp, i2, i2);
                return;
            }
            if (i == 22) {
                if (MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(messageObject.isOutOwner() ? 0L : messageObject.getDialogId())).id == UserConfig.getInstance(this.currentAccount).clientUserId) {
                    charSequence = messageObject.messageText;
                    string = null;
                } else {
                    charSequence = messageObject.messageText;
                    string = LocaleController.getString("ViewWallpaperAction", R.string.ViewWallpaperAction);
                }
                createGiftPremiumLayouts(null, charSequence, string, this.giftRectSize);
                this.textLayout = null;
                this.textHeight = 0;
                this.textY = 0;
            }
        }
    }

    private void createGiftPremiumLayouts(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        int iDp = i - AndroidUtilities.dp(16.0f);
        if (charSequence != null) {
            SpannableStringBuilder spannableStringBuilderValueOf = SpannableStringBuilder.valueOf(charSequence);
            spannableStringBuilderValueOf.setSpan(new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), 0, spannableStringBuilderValueOf.length(), 33);
            this.giftPremiumTitleLayout = new StaticLayout(spannableStringBuilderValueOf, this.giftTitlePaint, iDp, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        } else {
            this.giftPremiumTitleLayout = null;
        }
        MessageObject messageObject = this.currentMessageObject;
        if (messageObject != null && messageObject.type == 21) {
            this.giftSubtitlePaint.setTextSize(AndroidUtilities.dp(13.0f));
        } else {
            this.giftSubtitlePaint.setTextSize(AndroidUtilities.dp(15.0f));
        }
        this.giftPremiumSubtitleLayout = new StaticLayout(charSequence2, this.giftSubtitlePaint, iDp, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        if (charSequence3 != null) {
            SpannableStringBuilder spannableStringBuilderValueOf2 = SpannableStringBuilder.valueOf(charSequence3);
            spannableStringBuilderValueOf2.setSpan(new TypefaceSpan(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM)), 0, spannableStringBuilderValueOf2.length(), 33);
            StaticLayout staticLayout = new StaticLayout(spannableStringBuilderValueOf2, (TextPaint) getThemedPaint("paintChatActionText"), iDp, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
            this.giftPremiumButtonLayout = staticLayout;
            this.giftPremiumButtonWidth = measureLayoutWidth(staticLayout);
            return;
        }
        this.giftPremiumButtonLayout = null;
        this.giftPremiumButtonWidth = 0.0f;
    }

    private float measureLayoutWidth(Layout layout) {
        float f = 0.0f;
        for (int i = 0; i < layout.getLineCount(); i++) {
            float fCeil = (int) Math.ceil(layout.getLineWidth(i));
            if (fCeil > f) {
                f = fCeil;
            }
        }
        return f;
    }

    public int getCustomDate() {
        return this.customDate;
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0514  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r27) {
        /*
            Method dump skipped, instructions count: 1456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Cells.ChatActionCell.onDraw(android.graphics.Canvas):void");
    }

    public void drawBackground(Canvas canvas, boolean z) {
        Paint paint;
        Paint paint2;
        int alpha;
        Paint paint3;
        int iIntValue;
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        float f3;
        int i5;
        if (this.canDrawInParent) {
            if (hasGradientService() && !z) {
                return;
            }
            if (!hasGradientService() && z) {
                return;
            }
        }
        Paint themedPaint = getThemedPaint("paintChatActionBackground");
        this.textPaint = (TextPaint) getThemedPaint("paintChatActionText");
        int i6 = this.overrideBackground;
        if (i6 >= 0) {
            int themedColor = getThemedColor(i6);
            if (this.overrideBackgroundPaint == null) {
                Paint paint4 = new Paint(1);
                this.overrideBackgroundPaint = paint4;
                paint4.setColor(themedColor);
                TextPaint textPaint = new TextPaint(1);
                this.overrideTextPaint = textPaint;
                textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                this.overrideTextPaint.setTextSize(AndroidUtilities.dp(Math.max(16, SharedConfig.fontSize) - 2));
                this.overrideTextPaint.setColor(getThemedColor(this.overrideText));
            }
            themedPaint = this.overrideBackgroundPaint;
            this.textPaint = this.overrideTextPaint;
        }
        if (this.invalidatePath) {
            this.invalidatePath = false;
            this.lineWidths.clear();
            StaticLayout staticLayout = this.textLayout;
            int lineCount = staticLayout == null ? 0 : staticLayout.getLineCount();
            int iDp = AndroidUtilities.dp(11.0f);
            int iDp2 = AndroidUtilities.dp(8.0f);
            int i7 = 0;
            for (int i8 = 0; i8 < lineCount; i8++) {
                int iCeil = (int) Math.ceil(this.textLayout.getLineWidth(i8));
                if (i8 == 0 || (i5 = i7 - iCeil) <= 0 || i5 > iDp + iDp2) {
                    i7 = iCeil;
                }
                this.lineWidths.add(Integer.valueOf(i7));
            }
            for (int i9 = lineCount - 2; i9 >= 0; i9--) {
                int iIntValue2 = this.lineWidths.get(i9).intValue();
                int i10 = i7 - iIntValue2;
                if (i10 <= 0 || i10 > iDp + iDp2) {
                    i7 = iIntValue2;
                }
                this.lineWidths.set(i9, Integer.valueOf(i7));
            }
            int iDp3 = AndroidUtilities.dp(4.0f);
            int measuredWidth = getMeasuredWidth() / 2;
            int iDp4 = AndroidUtilities.dp(3.0f);
            int iDp5 = AndroidUtilities.dp(6.0f);
            int i11 = iDp - iDp4;
            this.lineHeights.clear();
            this.backgroundPath.reset();
            float f4 = measuredWidth;
            this.backgroundPath.moveTo(f4, iDp3);
            int i12 = 0;
            int i13 = 0;
            while (i12 < lineCount) {
                int iIntValue3 = this.lineWidths.get(i12).intValue();
                int lineBottom = this.textLayout.getLineBottom(i12);
                int i14 = iDp2;
                int i15 = lineCount - 1;
                if (i12 < i15) {
                    paint3 = themedPaint;
                    iIntValue = this.lineWidths.get(i12 + 1).intValue();
                } else {
                    paint3 = themedPaint;
                    iIntValue = 0;
                }
                int iDp6 = lineBottom - i13;
                if (i12 == 0 || iIntValue3 > i7) {
                    f = 3.0f;
                    iDp6 += AndroidUtilities.dp(3.0f);
                } else {
                    f = 3.0f;
                }
                if (i12 == i15 || iIntValue3 > iIntValue) {
                    iDp6 += AndroidUtilities.dp(f);
                }
                float f5 = (iIntValue3 / 2.0f) + f4;
                int i16 = (i12 == i15 || iIntValue3 >= iIntValue || i12 == 0 || iIntValue3 >= i7) ? i14 : iDp5;
                if (i12 == 0 || iIntValue3 > i7) {
                    f2 = f4;
                    i = lineCount;
                    i2 = i7;
                    i3 = measuredWidth;
                    i4 = lineBottom;
                    this.rect.set((f5 - iDp4) - iDp, iDp3, i11 + f5, (iDp * 2) + iDp3);
                    this.backgroundPath.arcTo(this.rect, -90.0f, 90.0f);
                } else {
                    f2 = f4;
                    if (iIntValue3 < i7) {
                        i4 = lineBottom;
                        float f6 = i11 + f5;
                        i3 = measuredWidth;
                        i = lineCount;
                        i2 = i7;
                        this.rect.set(f6, iDp3, (i16 * 2) + f6, r8 + iDp3);
                        this.backgroundPath.arcTo(this.rect, -90.0f, -90.0f);
                    } else {
                        i = lineCount;
                        i2 = i7;
                        i3 = measuredWidth;
                        i4 = lineBottom;
                    }
                }
                iDp3 += iDp6;
                if (i12 == i15 || iIntValue3 >= iIntValue) {
                    f3 = 3.0f;
                } else {
                    f3 = 3.0f;
                    iDp3 -= AndroidUtilities.dp(3.0f);
                    iDp6 -= AndroidUtilities.dp(3.0f);
                }
                if (i12 != 0 && iIntValue3 < i2) {
                    iDp3 -= AndroidUtilities.dp(f3);
                    iDp6 -= AndroidUtilities.dp(f3);
                }
                this.lineHeights.add(Integer.valueOf(iDp6));
                if (i12 == i15 || iIntValue3 > iIntValue) {
                    this.rect.set((f5 - iDp4) - iDp, iDp3 - (iDp * 2), f5 + i11, iDp3);
                    this.backgroundPath.arcTo(this.rect, 0.0f, 90.0f);
                } else if (iIntValue3 < iIntValue) {
                    float f7 = f5 + i11;
                    this.rect.set(f7, iDp3 - r2, (i16 * 2) + f7, iDp3);
                    this.backgroundPath.arcTo(this.rect, 180.0f, -90.0f);
                }
                i12++;
                i7 = iIntValue3;
                iDp2 = i14;
                themedPaint = paint3;
                f4 = f2;
                i13 = i4;
                measuredWidth = i3;
                lineCount = i;
            }
            paint = themedPaint;
            int i17 = iDp2;
            int i18 = measuredWidth;
            int i19 = lineCount - 1;
            int i20 = i19;
            while (i20 >= 0) {
                int iIntValue4 = i20 != 0 ? this.lineWidths.get(i20 - 1).intValue() : 0;
                int iIntValue5 = this.lineWidths.get(i20).intValue();
                int iIntValue6 = i20 != i19 ? this.lineWidths.get(i20 + 1).intValue() : 0;
                this.textLayout.getLineBottom(i20);
                float f8 = i18 - (iIntValue5 / 2);
                int i21 = (i20 == i19 || iIntValue5 >= iIntValue6 || i20 == 0 || iIntValue5 >= iIntValue4) ? i17 : iDp5;
                if (i20 == i19 || iIntValue5 > iIntValue6) {
                    this.rect.set(f8 - i11, iDp3 - (iDp * 2), iDp4 + f8 + iDp, iDp3);
                    this.backgroundPath.arcTo(this.rect, 90.0f, 90.0f);
                } else if (iIntValue5 < iIntValue6) {
                    float f9 = f8 - i11;
                    this.rect.set(f9 - (i21 * 2), iDp3 - r12, f9, iDp3);
                    this.backgroundPath.arcTo(this.rect, 90.0f, -90.0f);
                }
                iDp3 -= this.lineHeights.get(i20).intValue();
                if (i20 == 0 || iIntValue5 > iIntValue4) {
                    this.rect.set(f8 - i11, iDp3, f8 + iDp4 + iDp, (iDp * 2) + iDp3);
                    this.backgroundPath.arcTo(this.rect, 180.0f, 90.0f);
                } else if (iIntValue5 < iIntValue4) {
                    float f10 = f8 - i11;
                    this.rect.set(f10 - (i21 * 2), iDp3, f10, r7 + iDp3);
                    this.backgroundPath.arcTo(this.rect, 0.0f, -90.0f);
                }
                i20--;
            }
            this.backgroundPath.close();
        } else {
            paint = themedPaint;
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
        int alpha2 = -1;
        if (!z || getAlpha() == 1.0f) {
            paint2 = paint;
            alpha = -1;
        } else {
            alpha2 = paint.getAlpha();
            alpha = Theme.chat_actionBackgroundGradientDarkenPaint.getAlpha();
            paint2 = paint;
            paint2.setAlpha((int) (alpha2 * getAlpha()));
            Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha((int) (alpha * getAlpha()));
        }
        canvas.drawPath(this.backgroundPath, paint2);
        if (hasGradientService()) {
            canvas.drawPath(this.backgroundPath, Theme.chat_actionBackgroundGradientDarkenPaint);
        }
        MessageObject messageObject = this.currentMessageObject;
        if (isButtonLayout(messageObject)) {
            float width = (getWidth() - this.giftRectSize) / 2.0f;
            float fDp = this.textY + this.textHeight + AndroidUtilities.dp(12.0f);
            if (messageObject.type == 22) {
                AndroidUtilities.rectTmp.set(width, fDp, this.giftRectSize + width, this.backgroundRectHeight + fDp);
            } else {
                RectF rectF = AndroidUtilities.rectTmp;
                int i22 = this.giftRectSize;
                rectF.set(width, fDp, i22 + width, i22 + fDp + this.giftPremiumAdditionalHeight);
            }
            if (this.backroundRect == null) {
                this.backroundRect = new RectF();
            }
            this.backroundRect.set(AndroidUtilities.rectTmp);
            canvas.drawRoundRect(this.backroundRect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), paint2);
            if (hasGradientService()) {
                canvas.drawRoundRect(this.backroundRect, AndroidUtilities.dp(16.0f), AndroidUtilities.dp(16.0f), Theme.chat_actionBackgroundGradientDarkenPaint);
            }
        }
        if (alpha2 >= 0) {
            paint2.setAlpha(alpha2);
            Theme.chat_actionBackgroundGradientDarkenPaint.setAlpha(alpha);
        }
    }

    public boolean hasGradientService() {
        ThemeDelegate themeDelegate;
        return this.overrideBackgroundPaint == null && ((themeDelegate = this.themeDelegate) == null ? Theme.hasGradientService() : themeDelegate.hasGradientService());
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public void onSuccessDownload(String str) {
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
            TLRPC$PhotoSize tLRPC$PhotoSize2 = messageObject.photoThumbs.get(i);
            if (tLRPC$PhotoSize2 instanceof TLRPC$TL_photoStrippedSize) {
                tLRPC$PhotoSize = tLRPC$PhotoSize2;
                break;
            }
            i++;
        }
        this.imageReceiver.setImage(this.currentVideoLocation, ImageLoader.AUTOPLAY_FILTER, ImageLocation.getForObject(tLRPC$PhotoSize, messageObject.photoThumbsObject), "50_50_b", this.avatarDrawable, 0L, null, messageObject, 1);
        DownloadController.getInstance(this.currentAccount).removeLoadingFileObserver(this);
    }

    @Override // org.rbmain.messenger.DownloadController.FileDownloadProgressListener
    public int getObserverTag() {
        return this.TAG;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        MessageObject messageObject = this.currentMessageObject;
        if (TextUtils.isEmpty(this.customText) && messageObject == null) {
            return;
        }
        if (this.accessibilityText == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(!TextUtils.isEmpty(this.customText) ? this.customText : messageObject.messageText);
            for (final CharacterStyle characterStyle : (CharacterStyle[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ClickableSpan.class)) {
                int spanStart = spannableStringBuilder.getSpanStart(characterStyle);
                int spanEnd = spannableStringBuilder.getSpanEnd(characterStyle);
                spannableStringBuilder.removeSpan(characterStyle);
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: org.rbmain.ui.Cells.ChatActionCell.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        if (ChatActionCell.this.delegate != null) {
                            ChatActionCell.this.openLink(characterStyle);
                        }
                    }
                }, spanStart, spanEnd, 33);
            }
            this.accessibilityText = spannableStringBuilder;
        }
        if (Build.VERSION.SDK_INT < 24) {
            accessibilityNodeInfo.setContentDescription(this.accessibilityText.toString());
        } else {
            accessibilityNodeInfo.setText(this.accessibilityText);
        }
        accessibilityNodeInfo.setEnabled(true);
    }

    public void setInvalidateColors(boolean z) {
        if (this.invalidateColors == z) {
            return;
        }
        this.invalidateColors = z;
        invalidate();
    }

    private int getThemedColor(int i) {
        return Theme.getColor(i, this.themeDelegate);
    }

    private Paint getThemedPaint(String str) {
        ThemeDelegate themeDelegate = this.themeDelegate;
        Paint paint = themeDelegate != null ? themeDelegate.getPaint(str) : null;
        return paint != null ? paint : Theme.getThemePaint(str);
    }

    public void drawOutboundsContent(Canvas canvas) {
        canvas.save();
        canvas.translate(this.textXLeft, this.textY);
        AnimatedEmojiSpan.drawAnimatedEmojis(canvas, this.textLayout, this.animatedEmojiStack, 0.0f, this.spoilers, 0.0f, 0.0f, 0.0f, 1.0f);
        canvas.restore();
    }

    private boolean isButtonLayout(MessageObject messageObject) {
        int i;
        return messageObject != null && ((i = messageObject.type) == 18 || i == 21 || i == 22);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        View view = this.invalidateWithParent;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // android.view.View
    public void invalidate(Rect rect) {
        super.invalidate(rect);
        View view = this.invalidateWithParent;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        super.invalidate(i, i2, i3, i4);
        View view = this.invalidateWithParent;
        if (view != null) {
            view.invalidate();
        }
    }
}
