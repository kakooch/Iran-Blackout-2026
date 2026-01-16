package ir.eitaa.ui.Cells;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.StateSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.StaticLayoutEx;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import java.util.Locale;

/* loaded from: classes3.dex */
public class MediaChatInfoCell extends LinearLayout implements NotificationCenter.NotificationCenterDelegate {
    private static final int[] STATE_PRESSED = {R.attr.state_pressed};
    private ImageReceiver avatarImage;
    private Drawable buttonsBackground;
    private int buttonsPadding;
    private TextPaint buttonsPaint;
    private TextPaint chatSubtitlePaint;
    private StaticLayout chatTitleLayout;
    private TextPaint chatTitlePaint;
    private int chatTitleX;
    private int chatTitleY;
    private TLRPC$Chat currentChat;
    private MediaChatInfoCellDelegate delegate;
    private StaticLayout descriptionLayout;
    private TextPaint descriptionPaint;
    private Spannable descriptionText;
    private int descriptionY;
    private StaticLayout joinButtonLayout;
    private boolean joinButtonPressed;
    private String joinButtonText;
    private int joinButtonX;
    private int joinButtonY;
    private boolean markedAsRead;
    private boolean messageButtonPressed;
    private StaticLayout messageButtonTextLayout;
    private float messageButtonTextLayoutLeft;
    private int messageButtonWidth;
    private int messageButtonX;
    private int messageButtonY;
    private String originalDescription;
    private Paint paint;
    private int postCountNum;
    private RectF rect;
    private boolean shortDescription;
    private StaticLayout subscribersCountLayout;
    private int subscribersCountNum;
    private int subscribersCountX;
    private int subscribersCountY;
    private int unreadCount;
    private StaticLayout unreadCountLayout;
    private int unreadCountLayoutAlpha;
    private float unreadCountLayoutLeft;
    private boolean verified;
    private Drawable verifiedDrawable;

    public interface MediaChatInfoCellDelegate {
        void didPressUrl(String url);

        void onAvatarImageClicked();

        void onJoinButtonClicked();

        void onMessageButtonClicked();
    }

    public MediaChatInfoCell(Context context) {
        super(context);
        this.postCountNum = 233;
        this.subscribersCountNum = 1;
        this.originalDescription = null;
        this.descriptionText = null;
        this.shortDescription = true;
        this.unreadCountLayoutAlpha = 255;
        this.rect = new RectF();
        this.joinButtonText = "";
        this.buttonsPadding = AndroidUtilities.dp(8.0f);
        setWillNotDraw(false);
        setFocusable(false);
        setOrientation(1);
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.avatarImage = imageReceiver;
        imageReceiver.setRoundRadius(AndroidUtilities.dp(48.0f));
        this.paint = new Paint(1);
        TextPaint textPaint = Theme.chat_msgTextPaint;
        this.descriptionPaint = textPaint;
        textPaint.setColor(Theme.getColor("chat_messageTextIn"));
        this.descriptionPaint.linkColor = Theme.getColor("chat_messageLinkIn");
        TextPaint textPaint2 = new TextPaint(1);
        this.chatTitlePaint = textPaint2;
        textPaint2.setTextSize(AndroidUtilities.dp(18.0f));
        this.chatTitlePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.chatTitlePaint.setColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        TextPaint textPaint3 = new TextPaint(1);
        this.chatSubtitlePaint = textPaint3;
        textPaint3.setTextSize(AndroidUtilities.dp(14.0f));
        this.chatSubtitlePaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.chatSubtitlePaint.setColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        TextPaint textPaint4 = new TextPaint(1);
        this.buttonsPaint = textPaint4;
        textPaint4.setColor(Theme.getColor("featuredStickers_buttonText"));
        this.buttonsPaint.setTextSize(AndroidUtilities.dp(14.0f));
        this.buttonsPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.buttonsBackground = Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed"));
        this.verifiedDrawable = new CombinedDrawable(Theme.profile_verifiedDrawable, Theme.profile_verifiedCheckDrawable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.avatarImage.onDetachedFromWindow();
        NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.notificationsSettingsUpdated);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.notificationsSettingsUpdated);
        this.avatarImage.onAttachedToWindow();
        this.avatarImage.setParentView(this);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.notificationsSettingsUpdated && ChatObject.isChannel(this.currentChat)) {
            updateJoinButton();
        }
    }

    public void updateProfileData() {
        if (this.currentChat != null) {
            TLRPC$Chat chat = MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(this.currentChat.id));
            if (chat != null) {
                this.currentChat = chat;
            } else {
                chat = this.currentChat;
            }
            setChat(chat);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height;
        int iLastIndexOf;
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int iDp = AndroidUtilities.dp(16.0f);
        float f = iDp;
        this.avatarImage.setImageCoords(f, f, AndroidUtilities.dp(96.0f), AndroidUtilities.dp(96.0f));
        int i = size - (iDp * 2);
        int imageWidth = i - ((int) this.avatarImage.getImageWidth());
        TLRPC$Chat tLRPC$Chat = this.currentChat;
        String str = tLRPC$Chat != null ? tLRPC$Chat.title : "";
        int i2 = imageWidth - iDp;
        int iDp2 = i2 - AndroidUtilities.dp(8.0f);
        StaticLayout staticLayoutCreateStaticLayout = StaticLayoutEx.createStaticLayout(str, this.chatTitlePaint, iDp2, Layout.Alignment.ALIGN_NORMAL, 1.0f, AndroidUtilities.dp(1.0f), false, TextUtils.TruncateAt.END, iDp2, 1);
        this.chatTitleLayout = staticLayoutCreateStaticLayout;
        int height2 = staticLayoutCreateStaticLayout.getHeight();
        int[] iArr = new int[1];
        StaticLayout staticLayoutBuildStaticLayout = buildStaticLayout(LocaleController.formatPluralString("Subscribers", iArr[0]).replace(String.format(Locale.getDefault(), "%d", Integer.valueOf(iArr[0])), LocaleController.formatShortNumber(this.subscribersCountNum, iArr)), this.chatSubtitlePaint, i2, Layout.Alignment.ALIGN_CENTER);
        this.subscribersCountLayout = staticLayoutBuildStaticLayout;
        int height3 = staticLayoutBuildStaticLayout.getHeight();
        this.chatTitleX = ((int) this.avatarImage.getImageWidth()) + iDp + iDp + iDp;
        if (this.chatTitleLayout.getLineLeft(0) != 0.0f) {
            this.chatTitleX = (int) (this.chatTitleX - this.chatTitleLayout.getLineLeft(0));
        }
        this.subscribersCountX = ((int) this.avatarImage.getImageWidth()) + iDp + iDp + iDp;
        if (this.subscribersCountLayout.getLineLeft(0) != 0.0f) {
            this.subscribersCountX = (int) (this.subscribersCountX - this.subscribersCountLayout.getLineLeft(0));
        }
        int imageHeight = (((((int) this.avatarImage.getImageHeight()) - height2) - height3) / 2) + iDp;
        this.chatTitleY = imageHeight;
        this.subscribersCountY = imageHeight + height2;
        String str2 = this.originalDescription;
        if (str2 == null || str2.isEmpty()) {
            height = 0;
        } else {
            if (this.shortDescription) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.originalDescription);
                this.descriptionText = spannableStringBuilder;
                MessageObject.addLinks(false, spannableStringBuilder, false, true);
                Emoji.replaceEmoji(this.descriptionText, this.descriptionPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                StaticLayout staticLayoutBuildStaticLayout2 = buildStaticLayout(this.descriptionText, this.descriptionPaint, i);
                this.descriptionLayout = staticLayoutBuildStaticLayout2;
                if (staticLayoutBuildStaticLayout2.getLineCount() > 5) {
                    String strTrim = this.originalDescription.substring(0, this.descriptionLayout.getLineEnd(4)).trim();
                    this.descriptionLayout = buildStaticLayout(strTrim, this.descriptionPaint, i);
                    TextPaint textPaint = this.descriptionPaint;
                    int iCeil = (int) Math.ceil(textPaint.measureText(" …بیشتر"));
                    StaticLayout staticLayout = this.descriptionLayout;
                    float lineWidth = staticLayout.getLineWidth(staticLayout.getLineCount() - 1);
                    while (((int) lineWidth) + iCeil > i && (iLastIndexOf = strTrim.lastIndexOf(32)) != -1) {
                        strTrim = strTrim.substring(0, iLastIndexOf);
                        StaticLayout staticLayoutBuildStaticLayout3 = buildStaticLayout(strTrim, this.descriptionPaint, i);
                        this.descriptionLayout = staticLayoutBuildStaticLayout3;
                        lineWidth = staticLayoutBuildStaticLayout3.getLineWidth(staticLayoutBuildStaticLayout3.getLineCount() - 1);
                    }
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(strTrim);
                    SpannableString spannableString = new SpannableString("…بیشتر");
                    spannableString.setSpan(new ClickableSpan() { // from class: ir.eitaa.ui.Cells.MediaChatInfoCell.1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View widget) {
                            MediaChatInfoCell.this.shortDescription = false;
                            MediaChatInfoCell.this.requestLayout();
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint ds) {
                            super.updateDrawState(ds);
                            ds.setUnderlineText(false);
                        }
                    }, 0, spannableString.length(), 17);
                    spannableStringBuilder2.append((CharSequence) spannableString);
                    MessageObject.addLinks(false, spannableStringBuilder2, false, true);
                    Emoji.replaceEmoji(spannableStringBuilder2, this.descriptionPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                    this.descriptionText = spannableStringBuilder2;
                    this.descriptionLayout = buildStaticLayout(spannableStringBuilder2, this.descriptionPaint, i);
                }
            } else {
                SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(this.originalDescription);
                this.descriptionText = spannableStringBuilder3;
                MessageObject.addLinks(false, spannableStringBuilder3, false, true);
                Emoji.replaceEmoji(this.descriptionText, this.descriptionPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false);
                this.descriptionLayout = buildStaticLayout(this.descriptionText, this.descriptionPaint, i);
            }
            height = this.descriptionLayout.getHeight();
        }
        this.descriptionY = ((int) this.avatarImage.getImageHeight()) + iDp + iDp;
        String str3 = this.unreadCount != 0 ? String.format(Locale.getDefault(), "%d", Integer.valueOf(this.unreadCount)) : null;
        if (str3 != null) {
            this.unreadCountLayout = buildStaticLayout(str3, Theme.dialogs_countTextPaint, Math.max(AndroidUtilities.dp(12.0f), (int) Math.ceil(Theme.dialogs_countTextPaint.measureText(str3))), Layout.Alignment.ALIGN_CENTER);
        } else {
            this.unreadCountLayout = null;
        }
        String string = LocaleController.getString("SearchMessages", ir.eitaa.messenger.R.string.SearchMessages);
        int iMeasureText = (int) this.buttonsPaint.measureText(string);
        int i3 = (size - (iDp * 3)) / 2;
        this.messageButtonWidth = i3;
        this.messageButtonTextLayout = buildStaticLayout(string, this.buttonsPaint, iMeasureText, Layout.Alignment.ALIGN_CENTER);
        this.messageButtonY = this.descriptionY + height + iDp;
        this.messageButtonX = iDp;
        if (this.unreadCountLayout != null) {
            this.unreadCountLayoutLeft = iDp + ((this.messageButtonWidth - (r1.getWidth() + this.messageButtonTextLayout.getWidth())) / 2.0f);
        }
        this.messageButtonTextLayoutLeft = this.messageButtonX + ((this.messageButtonWidth - this.messageButtonTextLayout.getWidth()) / 2.0f) + (this.unreadCountLayout != null ? r2.getWidth() : 0.0f);
        this.joinButtonLayout = buildStaticLayout(this.joinButtonText, this.buttonsPaint, i3, Layout.Alignment.ALIGN_CENTER);
        this.joinButtonY = this.messageButtonY;
        this.joinButtonX = this.messageButtonWidth + iDp + iDp;
        setMeasuredDimension(size, ((int) this.avatarImage.getImageHeight()) + iDp + iDp + height + iDp + this.messageButtonTextLayout.getHeight() + (this.buttonsPadding * 2) + iDp);
    }

    private boolean checkDescriptionMotionEvent(MotionEvent event) {
        int action;
        MediaChatInfoCellDelegate mediaChatInfoCellDelegate;
        if (this.descriptionText != null && this.descriptionLayout != null && ((action = event.getAction()) == 1 || action == 0)) {
            int x = (int) event.getX();
            int offsetForHorizontal = this.descriptionLayout.getOffsetForHorizontal(this.descriptionLayout.getLineForVertical(((int) event.getY()) - this.descriptionY), x - AndroidUtilities.dp(16.0f));
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) this.descriptionText.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (clickableSpanArr.length != 0) {
                if (action == 1) {
                    ClickableSpan clickableSpan = clickableSpanArr[0];
                    if (clickableSpan instanceof URLSpanNoUnderline) {
                        String url = ((URLSpanNoUnderline) clickableSpan).getURL();
                        if ((url.startsWith("@") || url.startsWith("#") || url.startsWith("/")) && (mediaChatInfoCellDelegate = this.delegate) != null) {
                            mediaChatInfoCellDelegate.didPressUrl(url);
                        }
                    } else if (clickableSpan instanceof URLSpan) {
                        Browser.openUrl(getContext(), ((URLSpan) clickableSpan).getURL());
                    } else {
                        clickableSpan.onClick(this);
                    }
                } else {
                    Spannable spannable = this.descriptionText;
                    Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), this.descriptionText.getSpanEnd(clickableSpanArr[0]));
                }
                return true;
            }
            Selection.removeSelection(this.descriptionText);
        }
        return false;
    }

    private boolean checkButtonsMotionEvent(MotionEvent event) {
        int i;
        int i2;
        boolean z;
        int i3;
        if (this.messageButtonTextLayout == null || this.joinButtonLayout == null) {
            return false;
        }
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (action == 0) {
            int i4 = this.messageButtonX;
            if (x > i4 && x < i4 + this.messageButtonWidth && y > (i3 = this.messageButtonY) && y < i3 + this.messageButtonTextLayout.getHeight() + (this.buttonsPadding * 2)) {
                this.messageButtonPressed = true;
                invalidate();
            } else {
                int i5 = this.joinButtonX;
                if (x > i5 && x < i5 + this.joinButtonLayout.getWidth() && y > this.joinButtonY && y < this.messageButtonY + this.joinButtonLayout.getHeight() + (this.buttonsPadding * 2)) {
                    this.joinButtonPressed = true;
                    invalidate();
                }
                z = false;
            }
            z = true;
        } else {
            if (action == 1) {
                if (this.messageButtonPressed) {
                    int i6 = this.messageButtonX;
                    if (x > i6 && x < i6 + this.messageButtonWidth && y > (i2 = this.messageButtonY) && y < i2 + this.messageButtonTextLayout.getHeight() + (this.buttonsPadding * 2)) {
                        MediaChatInfoCellDelegate mediaChatInfoCellDelegate = this.delegate;
                        if (mediaChatInfoCellDelegate != null) {
                            mediaChatInfoCellDelegate.onMessageButtonClicked();
                        }
                        z = true;
                    }
                } else if (this.joinButtonPressed && x > (i = this.joinButtonX) && x < i + this.joinButtonLayout.getWidth() && y > this.joinButtonY && y < this.messageButtonY + this.joinButtonLayout.getHeight() + (this.buttonsPadding * 2)) {
                    MediaChatInfoCellDelegate mediaChatInfoCellDelegate2 = this.delegate;
                    if (mediaChatInfoCellDelegate2 != null) {
                        mediaChatInfoCellDelegate2.onJoinButtonClicked();
                    }
                    z = true;
                }
            }
            z = false;
        }
        if (action == 1 || action == 3) {
            this.messageButtonPressed = false;
            this.joinButtonPressed = false;
            invalidate();
        }
        return z;
    }

    private boolean checkAvatarImageMotionEvent(MotionEvent event) {
        event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        ImageReceiver imageReceiver = this.avatarImage;
        boolean z = false;
        if (imageReceiver != null && imageReceiver.hasBitmapImage()) {
            float f = x;
            if (f > this.avatarImage.getImageX() && f < this.avatarImage.getImageWidth() + this.avatarImage.getImageX()) {
                float f2 = y;
                if (f2 > this.avatarImage.getImageY() && f2 < this.avatarImage.getImageHeight() + this.avatarImage.getImageY()) {
                    z = true;
                    MediaChatInfoCellDelegate mediaChatInfoCellDelegate = this.delegate;
                    if (mediaChatInfoCellDelegate != null) {
                        mediaChatInfoCellDelegate.onAvatarImageClicked();
                    }
                }
            }
        }
        return z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean zCheckButtonsMotionEvent = checkButtonsMotionEvent(event);
        if (!zCheckButtonsMotionEvent) {
            zCheckButtonsMotionEvent = checkAvatarImageMotionEvent(event);
        }
        if (zCheckButtonsMotionEvent) {
            return true;
        }
        checkDescriptionMotionEvent(event);
        return true;
    }

    public void setDelegate(MediaChatInfoCellDelegate delegate) {
        this.delegate = delegate;
    }

    public void setChat(TLRPC$Chat chat) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        this.currentChat = chat;
        if (chat != null && (tLRPC$ChatPhoto = chat.photo) != null) {
            TLRPC$FileLocation tLRPC$FileLocation = tLRPC$ChatPhoto.photo_small;
            AvatarDrawable avatarDrawable = new AvatarDrawable();
            avatarDrawable.setInfo(chat);
            this.avatarImage.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), null, avatarDrawable, null, chat, 0);
        }
        if (chat != null) {
            this.verified = chat.verified;
        }
        updateJoinButton();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateJoinButton() {
        /*
            r4 = this;
            ir.eitaa.tgnet.TLRPC$Chat r0 = r4.currentChat
            if (r0 == 0) goto L64
            boolean r0 = ir.eitaa.messenger.ChatObject.isChannel(r0)
            if (r0 == 0) goto L5a
            ir.eitaa.tgnet.TLRPC$Chat r0 = r4.currentChat
            boolean r1 = r0 instanceof ir.eitaa.tgnet.TLRPC$TL_channelForbidden
            if (r1 != 0) goto L5a
            long r1 = r0.id
            long r1 = -r1
            boolean r0 = ir.eitaa.messenger.ChatObject.isNotInChat(r0)
            if (r0 == 0) goto L3a
            int r0 = ir.eitaa.messenger.UserConfig.selectedAccount
            ir.eitaa.messenger.MessagesController r0 = ir.eitaa.messenger.MessagesController.getInstance(r0)
            r3 = 0
            boolean r0 = r0.isPromoDialog(r1, r3)
            if (r0 == 0) goto L30
            int r0 = ir.eitaa.messenger.UserConfig.selectedAccount
            ir.eitaa.messenger.MessagesController r0 = ir.eitaa.messenger.MessagesController.getInstance(r0)
            boolean r0 = r0.proxyDisableJoin
            if (r0 != 0) goto L3a
        L30:
            r0 = 2131690494(0x7f0f03fe, float:1.9010033E38)
            java.lang.String r1 = "ChannelJoin"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            goto L66
        L3a:
            int r0 = ir.eitaa.messenger.UserConfig.selectedAccount
            ir.eitaa.messenger.MessagesController r0 = ir.eitaa.messenger.MessagesController.getInstance(r0)
            boolean r0 = r0.isDialogMuted(r1)
            if (r0 != 0) goto L50
            r0 = 2131690526(0x7f0f041e, float:1.9010098E38)
            java.lang.String r1 = "ChannelMute"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            goto L66
        L50:
            r0 = 2131690565(0x7f0f0445, float:1.9010177E38)
            java.lang.String r1 = "ChannelUnmute"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            goto L66
        L5a:
            r0 = 2131691055(0x7f0f062f, float:1.9011171E38)
            java.lang.String r1 = "DeleteThisGroup"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r1, r0)
            goto L66
        L64:
            java.lang.String r0 = ""
        L66:
            java.lang.String r1 = r4.joinButtonText
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L73
            r4.joinButtonText = r0
            r4.requestLayout()
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.MediaChatInfoCell.updateJoinButton():void");
    }

    public void setChatInfo(TLRPC$ChatFull chatFull) {
        this.currentChat = MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(chatFull.id));
        this.subscribersCountNum = chatFull.participants_count;
        setDescription(chatFull.about);
    }

    private void setDescription(String text) {
        this.originalDescription = text;
        requestLayout();
    }

    private StaticLayout buildStaticLayout(CharSequence source, TextPaint paint, int width) {
        return buildStaticLayout(source, paint, width, Layout.Alignment.ALIGN_NORMAL);
    }

    private StaticLayout buildStaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment alignment) {
        return new StaticLayout(source, paint, width, alignment, 1.0f, 0.0f, false);
    }

    public ImageReceiver getAvatarImage() {
        return this.avatarImage;
    }

    public void markAsRead() {
        if (this.markedAsRead || this.messageButtonTextLayout == null) {
            return;
        }
        this.markedAsRead = true;
        float f = this.unreadCountLayoutLeft;
        float f2 = this.messageButtonTextLayoutLeft;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this, "unreadCountLayoutLeft", f, f2), ObjectAnimator.ofFloat(this, "messageButtonTextLayoutLeft", f2, this.messageButtonX + ((this.messageButtonWidth - this.messageButtonTextLayout.getWidth()) / 2.0f)), ObjectAnimator.ofInt(this, "unreadCountLayoutAlpha", 255, 0));
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.MediaChatInfoCell.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                MediaChatInfoCell.this.unreadCount = 0;
            }
        });
        animatorSet.start();
    }

    @Keep
    private void setUnreadCountLayoutLeft(float unreadCountLayoutLeft) {
        this.unreadCountLayoutLeft = unreadCountLayoutLeft;
        invalidate();
    }

    @Keep
    private void setUnreadCountLayoutAlpha(int unreadCountLayoutAlpha) {
        this.unreadCountLayoutAlpha = unreadCountLayoutAlpha;
        invalidate();
    }

    @Keep
    public void setMessageButtonTextLayoutLeft(float messageButtonTextLayoutLeft) {
        this.messageButtonTextLayoutLeft = messageButtonTextLayoutLeft;
        invalidate();
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.avatarImage.hasBitmapImage()) {
            this.paint.setColor(-1728053248);
            canvas.drawCircle(this.avatarImage.getCenterX(), this.avatarImage.getCenterY(), this.avatarImage.getRoundRadius()[0] + 1, this.paint);
            this.avatarImage.draw(canvas);
        }
        if (this.subscribersCountLayout != null) {
            canvas.save();
            canvas.translate(this.subscribersCountX, this.subscribersCountY);
            this.subscribersCountLayout.draw(canvas);
            canvas.restore();
        }
        if (this.chatTitleLayout != null) {
            canvas.save();
            canvas.translate(this.chatTitleX, this.chatTitleY);
            this.chatTitleLayout.draw(canvas);
            if (this.verified) {
                int intrinsicHeight = this.verifiedDrawable.getIntrinsicHeight();
                int intrinsicWidth = this.verifiedDrawable.getIntrinsicWidth();
                int height = this.chatTitleLayout.getHeight();
                int lineRight = (int) (this.chatTitleLayout.getLineRight(0) + AndroidUtilities.dp(2.0f));
                int i = (height - intrinsicHeight) / 2;
                this.verifiedDrawable.setBounds(lineRight, i, intrinsicWidth + lineRight, intrinsicHeight + i);
                this.verifiedDrawable.draw(canvas);
            }
            canvas.restore();
        }
        if (this.subscribersCountLayout != null) {
            canvas.save();
            canvas.translate(this.subscribersCountX, this.subscribersCountY);
            this.subscribersCountLayout.draw(canvas);
            canvas.restore();
        }
        if (this.descriptionLayout != null) {
            canvas.save();
            canvas.translate(AndroidUtilities.dp(16.0f), this.descriptionY);
            this.descriptionLayout.draw(canvas);
            canvas.restore();
        }
        StaticLayout staticLayout = this.messageButtonTextLayout;
        if (staticLayout != null) {
            int height2 = staticLayout.getHeight() + (this.buttonsPadding * 2);
            this.buttonsBackground.setState(this.messageButtonPressed ? STATE_PRESSED : StateSet.WILD_CARD);
            Drawable drawable = this.buttonsBackground;
            int i2 = this.messageButtonX;
            int i3 = this.messageButtonY;
            drawable.setBounds(i2, i3, this.messageButtonWidth + i2, i3 + height2);
            this.buttonsBackground.draw(canvas);
            canvas.save();
            canvas.translate(this.messageButtonTextLayoutLeft, this.messageButtonY + this.buttonsPadding);
            this.messageButtonTextLayout.draw(canvas);
            canvas.restore();
            StaticLayout staticLayout2 = this.unreadCountLayout;
            if (staticLayout2 != null) {
                int height3 = this.messageButtonY + ((height2 - staticLayout2.getHeight()) / 2);
                float fDp = this.unreadCountLayoutLeft - AndroidUtilities.dp(5.5f);
                this.rect.set(fDp, height3 - ((AndroidUtilities.dp(23.0f) - this.unreadCountLayout.getHeight()) / 2), this.unreadCountLayout.getWidth() + fDp + AndroidUtilities.dp(11.0f), r3 + AndroidUtilities.dp(23.0f));
                int alpha = Theme.dialogs_countPaint.getAlpha();
                Theme.dialogs_countPaint.setAlpha(this.unreadCountLayoutAlpha);
                RectF rectF = this.rect;
                float f = AndroidUtilities.density;
                canvas.drawRoundRect(rectF, f * 11.5f, f * 11.5f, Theme.dialogs_countPaint);
                Theme.dialogs_countPaint.setAlpha(alpha);
                canvas.save();
                canvas.translate(this.unreadCountLayoutLeft, height3);
                int alpha2 = Theme.dialogs_countTextPaint.getAlpha();
                Theme.dialogs_countTextPaint.setAlpha(this.unreadCountLayoutAlpha);
                this.unreadCountLayout.draw(canvas);
                Theme.dialogs_countTextPaint.setAlpha(alpha2);
                canvas.restore();
            }
        }
        if (this.joinButtonLayout != null) {
            this.buttonsBackground.setState(this.joinButtonPressed ? STATE_PRESSED : StateSet.WILD_CARD);
            Drawable drawable2 = this.buttonsBackground;
            int i4 = this.joinButtonX;
            drawable2.setBounds(i4, this.joinButtonY, this.joinButtonLayout.getWidth() + i4, this.joinButtonY + this.joinButtonLayout.getHeight() + (this.buttonsPadding * 2));
            this.buttonsBackground.draw(canvas);
            canvas.save();
            canvas.translate(this.joinButtonX, this.joinButtonY + this.buttonsPadding);
            this.joinButtonLayout.draw(canvas);
            canvas.restore();
        }
    }
}
