package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.Transformation;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$DocumentAttribute;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageFwdHeader;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeImageSize;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeVideo;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserProfilePhoto;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LinkPath;
import ir.eitaa.ui.Components.TabIndicatorStrip;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class BubbleFreeMessageCell extends BaseCell {
    private static Drawable footerShadowDrawable;
    private static Drawable forwardIcon;
    private static Drawable headerShadowDrawable;
    private static Drawable messageIcon;
    private static OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
    private static Drawable payIcon;
    private static Drawable saveIcon;
    private static Drawable saveSelectedIcon;
    private static Drawable shareOutIcon;
    private static Drawable threeDotMenu;
    private boolean animatingForward;
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    private boolean avatarPressed;
    private Spannable boldUsername;
    private final int bottomBarHeight;
    private int bottomBarY;
    private int captionHeight;
    private StaticLayout captionLayout;
    private int captionWidth;
    private int captionX;
    private int captionY;
    private int currentAccount;
    private CharSequence currentCaption;
    private TLRPC$Chat currentChat;
    private StaticLayout currentIndexLayout;
    private TLRPC$User currentUser;
    private String currentViewsString;
    private Delegate delegate;
    private boolean drawImage;
    private boolean drawVerified;
    private Button forwardButton;
    private boolean forwardPressed;
    private MessageObject.GroupedMessages groupedMessages;
    private boolean hasPayButton;
    private final int headerHeight;
    private Path headerShadowPath;
    private boolean imagePressed;
    private boolean maybeStartTracking;
    private MediaPage[] mediaPages;
    private boolean menuPressed;
    private MessageObject messageObject;
    private StaticLayout nameLayout;
    private int nameLeft;
    private int nameTop;
    private Button payButton;
    private boolean payPressed;
    private int photoActualHeight;
    private int photoActualWidth;
    private CharacterStyle pressedLink;
    private int recommendReasonTop;
    private Button saveButton;
    private boolean savePressed;
    private Button shareOutButton;
    private boolean sharePressed;
    private boolean startedTracking;
    private int startedTrackingPointerId;
    private int startedTrackingX;
    private int startedTrackingY;
    private Paint tabIndexBackPaint;
    private RectF tabIndexRect;
    private Runnable tabIndicatorFadeOutRunnable;
    private TabIndicatorStrip tabIndicatorStrip;
    private boolean tabsAnimationInProgress;
    private TextPaint textPaint;
    private Button threeDotButton;
    private StaticLayout timeLayout;
    private int timeLeft;
    private int timeTop;
    private int timeWidth;
    private ArrayList<LinkPath> urlPath;
    private ArrayList<LinkPath> urlPathCache;
    private StaticLayout usernameLayout;
    private int usernameX;
    private int usernameY;
    private VelocityTracker velocityTracker;
    private int verifyLeft;
    private int verifyTop;
    public int viewLocationFlags;
    private Button viewMessageButton;
    private boolean viewMessagePressed;
    private StaticLayout viewsLayout;
    private int viewsLeft;
    private int viewsTop;

    public interface Delegate {
        void didClickedAvatar(BubbleFreeMessageCell cell);

        void didClickedForward(BubbleFreeMessageCell cell);

        void didClickedImage(BubbleFreeMessageCell cell);

        void didClickedMenu(BubbleFreeMessageCell cell);

        void didClickedPay(BubbleFreeMessageCell cell);

        void didClickedSave(BubbleFreeMessageCell cell);

        void didClickedShareOut(BubbleFreeMessageCell cell);

        void didClickedViewMessage(BubbleFreeMessageCell cell);

        void didPressedUrl(BubbleFreeMessageCell cell, String url);

        void didSwipedMediaPage(BubbleFreeMessageCell cell, float progress);
    }

    private class Button {
        private Animation animation;
        private int centerX;
        private int centerY;
        private Drawable drawable;
        private boolean selected;
        private Drawable selectedDrawable;
        private int x;
        private int y;
        private final int size = AndroidUtilities.dp(48.0f);
        private final int iconSize = AndroidUtilities.dp(24.0f);
        private float scale = 1.0f;

        public Button(Drawable drawable) {
            this.drawable = drawable;
        }

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
            int i = this.size;
            this.centerX = x + (i / 2);
            this.centerY = y + (i / 2);
        }

        public void playAnimation() {
            Animation animation = this.animation;
            if (animation != null) {
                animation.cancel();
            }
            Animation animation2 = new Animation() { // from class: ir.eitaa.ui.Cells.BubbleFreeMessageCell.Button.1
                @Override // android.view.animation.Animation
                protected void applyTransformation(float t, Transformation trans) {
                    Button.this.scale = t;
                    BubbleFreeMessageCell.this.invalidate();
                }
            };
            this.animation = animation2;
            animation2.setInterpolator(BubbleFreeMessageCell.overshootInterpolator);
            this.animation.setDuration(300L);
            this.animation.setAnimationListener(new Animation.AnimationListener() { // from class: ir.eitaa.ui.Cells.BubbleFreeMessageCell.Button.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation3) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation3) {
                    Button.this.scale = 0.0f;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation3) {
                    if (Button.this.animation == animation3) {
                        Button.this.scale = 1.0f;
                        Button.this.animation = null;
                    }
                }
            });
            BubbleFreeMessageCell.this.startAnimation(this.animation);
        }

        public void draw(Canvas canvas) {
            Drawable drawable;
            Drawable drawable2 = this.drawable;
            if (this.selected && (drawable = this.selectedDrawable) != null) {
                drawable2 = drawable;
            }
            if (drawable2 != null) {
                drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("actionBarDefaultSubmenuItemIcon"), PorterDuff.Mode.MULTIPLY));
                int i = this.centerX;
                int i2 = this.iconSize;
                float f = this.scale;
                int i3 = this.centerY;
                drawable2.setBounds((int) (i - ((i2 * f) / 2.0f)), (int) (i3 - ((i2 * f) / 2.0f)), (int) (i + ((i2 * f) / 2.0f)), (int) (i3 + ((i2 * f) / 2.0f)));
                drawable2.draw(canvas);
            }
        }

        public int getX() {
            return this.x;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    private class MediaPage extends ImageReceiver {
        private int dx;
        private int height;
        public MessageObject selectedMessageObject;
        private int width;
        private int x;
        private int y;

        public MediaPage(View view) {
            super(view);
        }

        public void setVisibility(int visibility) {
            setVisible(visibility == 0, true);
        }

        public void setImageCoords(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            super.setImageCoords(x + this.dx, y, width, height);
        }

        public int getMeasuredWidth() {
            return this.width;
        }

        public void setTranslationX(float dx) {
            this.dx = (int) dx;
            super.setImageCoords(this.x + r4, this.y, this.width, this.height);
            if (BubbleFreeMessageCell.this.mediaPages[0] == this) {
                float fAbs = Math.abs(BubbleFreeMessageCell.this.mediaPages[0].getTranslationX()) / BubbleFreeMessageCell.this.mediaPages[0].getMeasuredWidth();
                BubbleFreeMessageCell.this.tabIndicatorStrip.selectTabWithObject(BubbleFreeMessageCell.this.mediaPages[1].selectedMessageObject, fAbs);
                if (BubbleFreeMessageCell.this.delegate != null) {
                    BubbleFreeMessageCell.this.delegate.didSwipedMediaPage(BubbleFreeMessageCell.this, fAbs);
                }
            }
            BubbleFreeMessageCell.this.invalidate();
        }

        public float getTranslationX() {
            return this.dx;
        }

        public int getX() {
            return this.x + this.dx;
        }
    }

    public BubbleFreeMessageCell(Context context) {
        super(context);
        this.currentAccount = UserConfig.selectedAccount;
        this.mediaPages = new MediaPage[2];
        this.headerHeight = AndroidUtilities.dp(35.0f);
        this.bottomBarHeight = AndroidUtilities.dp(48.0f);
        this.timeTop = AndroidUtilities.dp(17.0f);
        this.viewsLeft = 0;
        this.viewsTop = 0;
        this.recommendReasonTop = AndroidUtilities.dp(17.0f);
        this.urlPathCache = new ArrayList<>();
        this.urlPath = new ArrayList<>();
        this.tabIndicatorStrip = new TabIndicatorStrip();
        this.tabIndexRect = new RectF();
        this.viewLocationFlags = 0;
        ImageReceiver imageReceiver = new ImageReceiver(this);
        this.avatarImage = imageReceiver;
        imageReceiver.setCrossfadeWithOldImage(false);
        this.avatarImage.setRoundRadius(AndroidUtilities.dp(20.0f));
        this.avatarDrawable = new AvatarDrawable();
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                break;
            }
            mediaPageArr[i] = new MediaPage(this);
            this.mediaPages[i].setAspectFit(true);
            this.mediaPages[i].setCrossfadeWithOldImage(false);
            i++;
        }
        if (headerShadowDrawable == null) {
            headerShadowDrawable = getResources().getDrawable(R.drawable.header_shadow).mutate();
        }
        if (footerShadowDrawable == null) {
            footerShadowDrawable = getResources().getDrawable(R.drawable.header_shadow_reverse).mutate();
        }
        if (shareOutIcon == null) {
            shareOutIcon = getResources().getDrawable(R.drawable.msg_shareout).mutate();
            threeDotMenu = getResources().getDrawable(R.drawable.ic_ab_other).mutate();
            messageIcon = getResources().getDrawable(R.drawable.msg_message).mutate();
            saveIcon = getResources().getDrawable(R.drawable.menu_saved).mutate();
            payIcon = getResources().getDrawable(R.drawable.ic_shopping).mutate();
            saveSelectedIcon = getResources().getDrawable(R.drawable.menu_selected_saved).mutate();
            forwardIcon = getResources().getDrawable(R.drawable.msg_share).mutate();
        }
        this.threeDotButton = new Button(threeDotMenu);
        this.shareOutButton = new Button(shareOutIcon);
        this.forwardButton = new Button(forwardIcon);
        this.viewMessageButton = new Button(messageIcon);
        this.payButton = new Button(payIcon);
        Button button = new Button(saveIcon);
        this.saveButton = button;
        button.selectedDrawable = saveSelectedIcon;
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setTextSize(AndroidUtilities.dp(13.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        this.textPaint.setColor(-1);
        this.textPaint.setShadowLayer(AndroidUtilities.dp(1.0f), 0.0f, 0.0f, -16777216);
        Paint paint = new Paint(1);
        this.tabIndexBackPaint = paint;
        paint.setColor(-1728053248);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.avatarImage.onDetachedFromWindow();
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            mediaPageArr[i].onDetachedFromWindow();
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.avatarImage.onAttachedToWindow();
        this.avatarImage.setParentView(this);
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                return;
            }
            mediaPageArr[i].onAttachedToWindow();
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03f0  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r22, int r23) {
        /*
            Method dump skipped, instructions count: 1297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.BubbleFreeMessageCell.onMeasure(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StaticLayout buildStaticLayout(CharSequence source, TextPaint paint, int width) {
        return buildStaticLayout(source, paint, width, Layout.Alignment.ALIGN_NORMAL);
    }

    @SuppressLint({"WrongConstant"})
    private StaticLayout buildStaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment alignment) {
        if (Build.VERSION.SDK_INT >= 24) {
            return StaticLayout.Builder.obtain(source, 0, source.length(), paint, width).setBreakStrategy(1).setHyphenationFrequency(0).setAlignment(alignment).build();
        }
        return new StaticLayout(source, paint, width, alignment, 1.0f, 0.0f, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            try {
                buildLayout();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private void buildLayout() {
        String userName;
        this.drawVerified = false;
        TLRPC$User tLRPC$User = this.currentUser;
        if (tLRPC$User != null) {
            userName = UserObject.getUserName(tLRPC$User);
            this.drawVerified = this.currentUser.verified;
        } else {
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            if (tLRPC$Chat != null) {
                String str = tLRPC$Chat.title;
                this.drawVerified = tLRPC$Chat.verified;
                userName = str;
            } else {
                userName = "DELETED";
            }
        }
        if (userName != null && userName.length() > 0) {
            int iDp = AndroidUtilities.dp(58.0f);
            int measuredWidth = ((getMeasuredWidth() - iDp) - AndroidUtilities.dp(10.0f)) - AndroidUtilities.dp(48.0f);
            if (this.drawVerified) {
                measuredWidth -= AndroidUtilities.dp(6.0f) + Theme.dialogs_verifiedDrawable.getIntrinsicWidth();
            }
            int iMax = Math.max(AndroidUtilities.dp(12.0f), measuredWidth);
            Paint.FontMetrics fontMetrics = Theme.messageExplore_namePaint.getFontMetrics();
            this.nameTop = (this.headerHeight - ((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent))) / 2;
            try {
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(Html.fromHtml("<b>" + userName.replace('\n', ' ') + "</b>"), Theme.messageExplore_namePaint, iMax - AndroidUtilities.dp(12.0f), TextUtils.TruncateAt.END);
                iMax = (int) Theme.messageExplore_namePaint.measureText(charSequenceEllipsize, 0, charSequenceEllipsize.length());
                this.nameLayout = new StaticLayout(charSequenceEllipsize, Theme.messageExplore_namePaint, iMax, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
            } catch (Exception e) {
                FileLog.e(e);
            }
            if (LocaleController.isRTL) {
                this.nameLeft = (getMeasuredWidth() - iDp) - iMax;
            } else {
                this.nameLeft = iDp;
            }
            if (this.nameLayout.getLineCount() > 0) {
                this.nameLayout.getLineRight(0);
                if (this.drawVerified) {
                    if (LocaleController.isRTL) {
                        this.verifyLeft = (this.nameLeft - Theme.dialogs_verifiedDrawable.getIntrinsicWidth()) - (AndroidUtilities.dp(6.0f) / 2);
                    } else {
                        this.verifyLeft = this.nameLeft + ((int) this.nameLayout.getLineRight(0)) + (AndroidUtilities.dp(6.0f) / 2);
                    }
                    this.verifyTop = (this.headerHeight - Theme.dialogs_verifiedDrawable.getIntrinsicHeight()) / 2;
                    return;
                }
                return;
            }
            return;
        }
        this.nameLayout = null;
    }

    public ImageReceiver getPhotoImage() {
        return this.mediaPages[0];
    }

    public MessageObject getMessageObject() {
        return this.mediaPages[0].selectedMessageObject;
    }

    public void setMessageObject(MessageObject messageObject, MessageObject.GroupedMessages groupedMessages) {
        TLRPC$FileLocation tLRPC$FileLocation;
        this.messageObject = messageObject;
        this.groupedMessages = groupedMessages;
        if (messageObject == null) {
            return;
        }
        if ((messageObject.messageOwner.flags & Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV) != 0 && !messageObject.viewsReloaded) {
            MessagesController.getInstance(this.currentAccount).addToViewsQueue(messageObject, this.viewLocationFlags);
            messageObject.viewsReloaded = true;
        }
        this.hasPayButton = MessageObject.shouldHavePayButton(messageObject.messageOwner, false);
        ArrayList arrayList = new ArrayList();
        if (groupedMessages != null) {
            arrayList.addAll(groupedMessages.messages);
        }
        this.tabIndicatorStrip.setObjects(arrayList);
        resetUrlPaths(false);
        this.drawImage = false;
        int i = 0;
        while (true) {
            MediaPage[] mediaPageArr = this.mediaPages;
            if (i >= mediaPageArr.length) {
                break;
            }
            mediaPageArr[i].setForceLoading(false);
            this.mediaPages[i].setAllowDecodeSingleFrame(false);
            this.mediaPages[i].setAllowStartAnimation(false);
            this.mediaPages[i].setNeedsQualityThumb(false);
            this.mediaPages[i].setShouldGenerateQualityThumb(false);
            this.mediaPages[i].setVisible(true, true);
            i++;
        }
        this.textPaint.setAlpha(255);
        switchToCurrentSelectedMode(messageObject, false);
        updateCurrentUserAndChat();
        TLRPC$User tLRPC$User = this.currentUser;
        if (tLRPC$User != null) {
            this.avatarDrawable.setInfo(tLRPC$User);
            if (UserObject.isUserSelf(this.currentUser)) {
                this.avatarDrawable.setAvatarType(1);
            } else {
                TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto = this.currentUser.photo;
                if (tLRPC$UserProfilePhoto != null) {
                    tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
                }
            }
            tLRPC$FileLocation = null;
        } else {
            TLRPC$Chat tLRPC$Chat = this.currentChat;
            if (tLRPC$Chat != null) {
                TLRPC$ChatPhoto tLRPC$ChatPhoto = tLRPC$Chat.photo;
                TLRPC$FileLocation tLRPC$FileLocation2 = tLRPC$ChatPhoto != null ? tLRPC$ChatPhoto.photo_small : null;
                this.avatarDrawable.setInfo(tLRPC$Chat);
                tLRPC$FileLocation = tLRPC$FileLocation2;
            } else {
                tLRPC$FileLocation = null;
            }
        }
        this.avatarImage.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", this.avatarDrawable, null, null, 0);
        this.saveButton.setSelected(messageObject.savedToCloud);
        this.currentViewsString = String.format("%s", LocaleController.formatShortNumber(Math.max(1, messageObject.messageOwner.views), null));
        this.viewsLayout = new StaticLayout(this.currentViewsString, Theme.dialogs_timePaint, (int) Math.ceil(Theme.dialogs_timePaint.measureText(r11)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        postInvalidate();
    }

    private void updateCurrentUserAndChat() {
        TLRPC$Peer tLRPC$Peer;
        TLRPC$Peer tLRPC$Peer2;
        if (this.messageObject == null) {
            return;
        }
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        TLRPC$MessageFwdHeader tLRPC$MessageFwdHeader = this.messageObject.messageOwner.fwd_from;
        int clientUserId = (int) UserConfig.getInstance(this.currentAccount).getClientUserId();
        if (tLRPC$MessageFwdHeader != null && tLRPC$MessageFwdHeader.from_id.channel_id != 0 && this.messageObject.getDialogId() == clientUserId) {
            this.currentChat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(tLRPC$MessageFwdHeader.from_id.channel_id));
            return;
        }
        if (tLRPC$MessageFwdHeader == null || (tLRPC$Peer2 = tLRPC$MessageFwdHeader.saved_from_peer) == null) {
            if (tLRPC$MessageFwdHeader != null && (tLRPC$Peer = tLRPC$MessageFwdHeader.from_id) != null && tLRPC$Peer.channel_id == 0 && this.messageObject.getDialogId() == clientUserId) {
                this.currentUser = messagesController.getUser(Long.valueOf(tLRPC$MessageFwdHeader.from_id.chat_id));
                return;
            }
            if (this.messageObject.isFromUser()) {
                this.currentUser = messagesController.getUser(Long.valueOf(this.messageObject.messageOwner.from_id.user_id));
                return;
            }
            TLRPC$Message tLRPC$Message = this.messageObject.messageOwner;
            long j = tLRPC$Message.from_id.channel_id;
            if (j < 0) {
                this.currentChat = messagesController.getChat(Long.valueOf(-j));
                return;
            } else {
                if (tLRPC$Message.post) {
                    this.currentChat = messagesController.getChat(Long.valueOf(tLRPC$Message.peer_id.channel_id));
                    return;
                }
                return;
            }
        }
        long j2 = tLRPC$Peer2.user_id;
        if (j2 != 0) {
            long j3 = tLRPC$MessageFwdHeader.from_id.user_id;
            if (j3 != 0) {
                this.currentUser = messagesController.getUser(Long.valueOf(j3));
                return;
            } else {
                this.currentUser = messagesController.getUser(Long.valueOf(j2));
                return;
            }
        }
        if (tLRPC$Peer2.channel_id != 0) {
            if (this.messageObject.isSavedFromMegagroup()) {
                long j4 = tLRPC$MessageFwdHeader.from_id.channel_id;
                if (j4 != 0) {
                    this.currentUser = messagesController.getUser(Long.valueOf(j4));
                    return;
                }
            }
            this.currentChat = messagesController.getChat(Long.valueOf(tLRPC$MessageFwdHeader.saved_from_peer.channel_id));
            return;
        }
        long j5 = tLRPC$Peer2.chat_id;
        if (j5 != 0) {
            long j6 = tLRPC$MessageFwdHeader.from_id.chat_id;
            if (j6 != 0) {
                this.currentUser = messagesController.getUser(Long.valueOf(j6));
            } else {
                this.currentChat = messagesController.getChat(Long.valueOf(j5));
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) throws Resources.NotFoundException {
        boolean zCheckCaptionMotionEvent = checkCaptionMotionEvent(event);
        if (!zCheckCaptionMotionEvent) {
            zCheckCaptionMotionEvent = checkUsernameMotionEvent(event);
        }
        if (!zCheckCaptionMotionEvent) {
            zCheckCaptionMotionEvent = checkPhotoImageMotionEvent(event);
        }
        if (!zCheckCaptionMotionEvent) {
            zCheckCaptionMotionEvent = checkButtonsMotionEvent(event);
        }
        if (event.getAction() == 3) {
            this.pressedLink = null;
            resetUrlPaths(false);
            this.imagePressed = false;
            this.payPressed = false;
            this.savePressed = false;
            this.viewMessagePressed = false;
            this.forwardPressed = false;
            this.sharePressed = false;
        }
        if (!zCheckCaptionMotionEvent) {
            float x = event.getX();
            float y = event.getY();
            if (event.getAction() == 0) {
                ImageReceiver imageReceiver = this.avatarImage;
                if (imageReceiver != null && imageReceiver.isInsideImage(x, y)) {
                    this.avatarPressed = true;
                }
            } else if (this.avatarPressed) {
                if (event.getAction() == 1) {
                    this.avatarPressed = false;
                    Delegate delegate = this.delegate;
                    if (delegate != null) {
                        delegate.didClickedAvatar(this);
                    }
                } else if (event.getAction() == 3) {
                    this.avatarPressed = false;
                } else if (event.getAction() == 2 && !this.avatarImage.isInsideImage(x, y + getTop())) {
                    this.avatarPressed = false;
                }
            }
        }
        return true;
    }

    private boolean checkUsernameMotionEvent(MotionEvent event) {
        int i;
        if ((this.boldUsername instanceof Spannable) && this.usernameLayout != null && (event.getAction() == 0 || (this.pressedLink != null && event.getAction() == 1))) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int i2 = this.usernameX;
            if (x >= i2 && x <= i2 + this.usernameLayout.getWidth() && y >= (i = this.usernameY) && y <= i + this.usernameLayout.getHeight()) {
                if (event.getAction() == 0) {
                    try {
                        int i3 = x - this.usernameX;
                        int lineForVertical = this.usernameLayout.getLineForVertical(y - this.usernameY);
                        float f = i3;
                        int offsetForHorizontal = this.usernameLayout.getOffsetForHorizontal(lineForVertical, f);
                        float lineLeft = this.usernameLayout.getLineLeft(lineForVertical);
                        if (lineLeft <= f && lineLeft + this.usernameLayout.getLineWidth(lineForVertical) >= f) {
                            Spannable spannable = this.boldUsername;
                            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                            if (!(characterStyleArr.length == 0)) {
                                this.pressedLink = characterStyleArr[0];
                                resetUrlPaths(false);
                                try {
                                    LinkPath linkPathObtainNewUrlPath = obtainNewUrlPath(false);
                                    int spanStart = spannable.getSpanStart(this.pressedLink);
                                    linkPathObtainNewUrlPath.setCurrentLayout(this.usernameLayout, spanStart, 0.0f);
                                    this.usernameLayout.getSelectionPath(spanStart, spannable.getSpanEnd(this.pressedLink), linkPathObtainNewUrlPath);
                                } catch (Exception e) {
                                    FileLog.e(e);
                                }
                                invalidate();
                                return true;
                            }
                        }
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                } else {
                    CharacterStyle characterStyle = this.pressedLink;
                    if (characterStyle != null) {
                        if (characterStyle instanceof ClickableSpan) {
                            ((ClickableSpan) characterStyle).onClick(this);
                        }
                        this.pressedLink = null;
                        resetUrlPaths(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkCaptionMotionEvent(MotionEvent event) {
        int i;
        Delegate delegate;
        if ((this.currentCaption instanceof Spannable) && this.captionLayout != null && (event.getAction() == 0 || (this.pressedLink != null && event.getAction() == 1))) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            int i2 = this.captionX;
            if (x >= i2 && x <= i2 + this.captionWidth && y >= (i = this.captionY) && y <= i + this.captionHeight) {
                if (event.getAction() == 0) {
                    try {
                        int i3 = x - this.captionX;
                        int lineForVertical = this.captionLayout.getLineForVertical(y - this.captionY);
                        float f = i3;
                        int offsetForHorizontal = this.captionLayout.getOffsetForHorizontal(lineForVertical, f);
                        float lineLeft = this.captionLayout.getLineLeft(lineForVertical);
                        if (lineLeft <= f && lineLeft + this.captionLayout.getLineWidth(lineForVertical) >= f) {
                            Spannable spannable = (Spannable) this.currentCaption;
                            CharacterStyle[] characterStyleArr = (CharacterStyle[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                            if (!(characterStyleArr.length == 0)) {
                                this.pressedLink = characterStyleArr[0];
                                resetUrlPaths(false);
                                try {
                                    LinkPath linkPathObtainNewUrlPath = obtainNewUrlPath(false);
                                    int spanStart = spannable.getSpanStart(this.pressedLink);
                                    linkPathObtainNewUrlPath.setCurrentLayout(this.captionLayout, spanStart, 0.0f);
                                    this.captionLayout.getSelectionPath(spanStart, spannable.getSpanEnd(this.pressedLink), linkPathObtainNewUrlPath);
                                } catch (Exception e) {
                                    FileLog.e(e);
                                }
                                invalidate();
                                return true;
                            }
                        }
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                } else {
                    CharacterStyle characterStyle = this.pressedLink;
                    if (characterStyle != null) {
                        if (characterStyle instanceof URLSpanNoUnderline) {
                            String url = ((URLSpanNoUnderline) characterStyle).getURL();
                            if ((url.startsWith("@") || url.startsWith("#") || url.startsWith("/")) && (delegate = this.delegate) != null) {
                                delegate.didPressedUrl(this, url);
                            }
                        }
                        CharacterStyle characterStyle2 = this.pressedLink;
                        if (characterStyle2 instanceof URLSpan) {
                            String url2 = ((URLSpan) characterStyle2).getURL();
                            Delegate delegate2 = this.delegate;
                            if (delegate2 != null) {
                                delegate2.didPressedUrl(this, url2);
                            }
                        } else if (characterStyle2 instanceof ClickableSpan) {
                            ((ClickableSpan) characterStyle2).onClick(this);
                        }
                        this.pressedLink = null;
                        resetUrlPaths(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void switchToCurrentSelectedMode(MessageObject messageObject, boolean z) throws Resources.NotFoundException {
        TLRPC$PhotoSize closestPhotoSizeWithSize;
        TLRPC$Document tLRPC$Document;
        if (messageObject == null) {
            return;
        }
        this.mediaPages[z ? 1 : 0].selectedMessageObject = messageObject;
        TLRPC$PhotoSize tLRPC$PhotoSize = null;
        if (messageObject.isVideo() || messageObject.isNewGif()) {
            this.mediaPages[z ? 1 : 0].setForcePreview(messageObject.needDrawBluredPreview());
            if (!messageObject.needDrawBluredPreview()) {
                this.mediaPages[z ? 1 : 0].setNeedsQualityThumb(true);
                this.mediaPages[z ? 1 : 0].setShouldGenerateQualityThumb(true);
            }
            this.mediaPages[z ? 1 : 0].setVisible(true, true);
            TLRPC$Document document = messageObject.getDocument();
            closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 320);
            TLRPC$PhotoSize closestPhotoSizeWithSize2 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.getPhotoSize());
            Iterator<TLRPC$DocumentAttribute> it = document.attributes.iterator();
            while (it.hasNext()) {
                TLRPC$DocumentAttribute next = it.next();
                if ((next instanceof TLRPC$TL_documentAttributeImageSize) || (next instanceof TLRPC$TL_documentAttributeVideo)) {
                    closestPhotoSizeWithSize.w = next.w;
                    closestPhotoSizeWithSize.h = next.h;
                    break;
                }
            }
            if (closestPhotoSizeWithSize.w == 0 || closestPhotoSizeWithSize.h == 0) {
                int iDp = AndroidUtilities.dp(150.0f);
                closestPhotoSizeWithSize.h = iDp;
                closestPhotoSizeWithSize.w = iDp;
            }
            this.mediaPages[z ? 1 : 0].setImage(ImageLocation.getForObject(closestPhotoSizeWithSize2, messageObject.photoThumbsObject), null, getResources().getDrawable(R.drawable.photo_placeholder_in), null, messageObject, 11);
            this.drawImage = true;
            tLRPC$Document = document;
            tLRPC$PhotoSize = closestPhotoSizeWithSize2;
        } else {
            TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null && !messageObject.photoThumbs.isEmpty()) {
                TLRPC$PhotoSize closestPhotoSizeWithSize3 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, 320);
                TLRPC$PhotoSize closestPhotoSizeWithSize4 = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.photoSize.intValue());
                this.mediaPages[z ? 1 : 0].setImage(ImageLocation.getForObject(closestPhotoSizeWithSize4, messageObject.messageOwner.media.photo), null, ImageLocation.getForObject(closestPhotoSizeWithSize3, messageObject.photoThumbsObject), null, closestPhotoSizeWithSize4.size, null, messageObject, 11);
                this.drawImage = true;
                tLRPC$Document = null;
                closestPhotoSizeWithSize = closestPhotoSizeWithSize3;
                tLRPC$PhotoSize = closestPhotoSizeWithSize4;
            } else {
                this.mediaPages[z ? 1 : 0].setImageBitmap(getResources().getDrawable(R.drawable.photo_placeholder_in));
                tLRPC$Document = null;
                closestPhotoSizeWithSize = null;
            }
        }
        if (z) {
            return;
        }
        if (tLRPC$PhotoSize != null) {
            this.photoActualWidth = tLRPC$PhotoSize.w;
            this.photoActualHeight = tLRPC$PhotoSize.h;
        } else if (tLRPC$Document == null) {
            this.photoActualHeight = 0;
        } else if (closestPhotoSizeWithSize != null) {
            this.photoActualWidth = closestPhotoSizeWithSize.w;
            this.photoActualHeight = closestPhotoSizeWithSize.h;
        } else {
            this.photoActualHeight = 0;
        }
    }

    private boolean prepareForMoving(MotionEvent ev, boolean forward) throws Resources.NotFoundException {
        MessageObject messageObject = (MessageObject) this.tabIndicatorStrip.getNextObject(forward);
        if (messageObject == null) {
            return false;
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.maybeStartTracking = false;
        this.startedTracking = true;
        this.startedTrackingX = (int) ev.getX();
        this.mediaPages[1].setVisibility(0);
        this.animatingForward = forward;
        switchToCurrentSelectedMode(messageObject, true);
        if (forward) {
            this.mediaPages[1].setTranslationX(r5[1].getMeasuredWidth());
        } else {
            this.mediaPages[1].setTranslationX(-r5[1].getMeasuredWidth());
        }
        return true;
    }

    private boolean checkPhotoImageMotionEvent(MotionEvent ev) throws Resources.NotFoundException {
        boolean z;
        if (!this.drawImage) {
            return false;
        }
        float y = (int) ev.getY();
        if ((getPhotoImage().getImageY() > y || y > getPhotoImage().getImageY() + getPhotoImage().getImageHeight()) && !this.startedTracking) {
            this.imagePressed = false;
            this.maybeStartTracking = false;
            VelocityTracker velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
            return false;
        }
        if (ev.getAction() == 0 && !this.startedTracking && !this.maybeStartTracking) {
            this.startedTrackingPointerId = ev.getPointerId(0);
            this.maybeStartTracking = true;
            this.imagePressed = true;
            this.startedTrackingX = (int) ev.getX();
            this.startedTrackingY = (int) ev.getY();
            VelocityTracker velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.clear();
            }
        } else if (ev.getAction() == 2 && ev.getPointerId(0) == this.startedTrackingPointerId) {
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            int x = (int) (ev.getX() - this.startedTrackingX);
            int iAbs = Math.abs(((int) ev.getY()) - this.startedTrackingY);
            this.velocityTracker.addMovement(ev);
            if (this.startedTracking && (((z = this.animatingForward) && x > 0) || (!z && x < 0))) {
                if (!prepareForMoving(ev, x < 0)) {
                    this.maybeStartTracking = true;
                    this.startedTracking = false;
                }
            }
            if (!this.maybeStartTracking || this.startedTracking) {
                if (this.startedTracking) {
                    if (this.animatingForward) {
                        this.mediaPages[0].setTranslationX(x);
                        this.mediaPages[1].setTranslationX(r11[1].getMeasuredWidth() + x);
                    } else {
                        this.mediaPages[0].setTranslationX(x);
                        this.mediaPages[1].setTranslationX(x - r11[1].getMeasuredWidth());
                    }
                    Math.abs(x);
                    this.mediaPages[0].getMeasuredWidth();
                }
            } else if (Math.abs(x) >= AndroidUtilities.getPixelsInCM(0.3f, true) && Math.abs(x) / 3 > iAbs) {
                prepareForMoving(ev, x < 0);
                this.imagePressed = false;
            }
        } else if (ev.getPointerId(0) == this.startedTrackingPointerId && (ev.getAction() == 3 || ev.getAction() == 1 || ev.getAction() == 6)) {
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.computeCurrentVelocity(1000);
            if (!this.startedTracking) {
                float xVelocity = this.velocityTracker.getXVelocity();
                float yVelocity = this.velocityTracker.getYVelocity();
                if (Math.abs(xVelocity) >= 3000.0f && Math.abs(xVelocity) > Math.abs(yVelocity)) {
                    prepareForMoving(ev, xVelocity < 0.0f);
                }
            }
            if (this.startedTracking) {
                float x2 = this.mediaPages[0].getX();
                AnimatorSet animatorSet = new AnimatorSet();
                float xVelocity2 = this.velocityTracker.getXVelocity();
                boolean z2 = Math.abs(x2) < ((float) this.mediaPages[0].getMeasuredWidth()) / 3.0f && (Math.abs(xVelocity2) < 3500.0f || Math.abs(xVelocity2) < Math.abs(this.velocityTracker.getYVelocity()));
                if (z2) {
                    if (this.animatingForward) {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(this.mediaPages[1], "translationX", r4[1].getMeasuredWidth()));
                    } else {
                        animatorSet.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], "translationX", 0.0f), ObjectAnimator.ofFloat(this.mediaPages[1], "translationX", -r4[1].getMeasuredWidth()));
                    }
                } else if (this.animatingForward) {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], "translationX", -r7[0].getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages[1], "translationX", 0.0f));
                } else {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(this.mediaPages[0], "translationX", r7[0].getMeasuredWidth()), ObjectAnimator.ofFloat(this.mediaPages[1], "translationX", 0.0f));
                }
                animatorSet.setInterpolator(CubicBezierInterpolator.EASE_OUT_QUINT);
                animatorSet.setDuration(200L);
                animatorSet.addListener(new AnonymousClass3(z2));
                animatorSet.start();
                this.tabsAnimationInProgress = true;
            } else {
                this.maybeStartTracking = false;
                this.startedTracking = false;
                if (this.imagePressed) {
                    Delegate delegate = this.delegate;
                    if (delegate != null) {
                        delegate.didClickedImage(this);
                    }
                    this.imagePressed = false;
                }
            }
            VelocityTracker velocityTracker3 = this.velocityTracker;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.velocityTracker = null;
            }
        }
        return this.startedTracking;
    }

    /* renamed from: ir.eitaa.ui.Cells.BubbleFreeMessageCell$3, reason: invalid class name */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean val$backAnimation;

        AnonymousClass3(final boolean val$backAnimation) {
            this.val$backAnimation = val$backAnimation;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.val$backAnimation) {
                BubbleFreeMessageCell.this.mediaPages[1].setVisibility(4);
            } else {
                MediaPage mediaPage = BubbleFreeMessageCell.this.mediaPages[0];
                BubbleFreeMessageCell.this.mediaPages[0] = BubbleFreeMessageCell.this.mediaPages[1];
                BubbleFreeMessageCell.this.mediaPages[1] = mediaPage;
                BubbleFreeMessageCell.this.mediaPages[1].setVisibility(4);
                BubbleFreeMessageCell.this.tabIndicatorStrip.selectTabWithObject(BubbleFreeMessageCell.this.mediaPages[0].selectedMessageObject, 1.0f);
                if (BubbleFreeMessageCell.this.delegate != null) {
                    BubbleFreeMessageCell.this.delegate.didSwipedMediaPage(BubbleFreeMessageCell.this, 1.0f);
                }
                String str = String.format(Locale.getDefault(), "%d/%d", Integer.valueOf(BubbleFreeMessageCell.this.tabIndicatorStrip.getCurrentIndex() + 1), Integer.valueOf(BubbleFreeMessageCell.this.groupedMessages.messages.size()));
                BubbleFreeMessageCell bubbleFreeMessageCell = BubbleFreeMessageCell.this;
                bubbleFreeMessageCell.currentIndexLayout = bubbleFreeMessageCell.buildStaticLayout(str, bubbleFreeMessageCell.textPaint, (int) BubbleFreeMessageCell.this.textPaint.measureText(str));
                if (BubbleFreeMessageCell.this.tabIndicatorFadeOutRunnable != null) {
                    BubbleFreeMessageCell bubbleFreeMessageCell2 = BubbleFreeMessageCell.this;
                    bubbleFreeMessageCell2.removeCallbacks(bubbleFreeMessageCell2.tabIndicatorFadeOutRunnable);
                }
                BubbleFreeMessageCell.this.tabIndicatorFadeOutRunnable = new Runnable() { // from class: ir.eitaa.ui.Cells.-$$Lambda$BubbleFreeMessageCell$3$wXeBSKBmkbl73v8QT_HMW8wmGFA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onAnimationEnd$0$BubbleFreeMessageCell$3();
                    }
                };
                BubbleFreeMessageCell bubbleFreeMessageCell3 = BubbleFreeMessageCell.this;
                bubbleFreeMessageCell3.postDelayed(bubbleFreeMessageCell3.tabIndicatorFadeOutRunnable, 3000L);
            }
            BubbleFreeMessageCell.this.tabsAnimationInProgress = false;
            BubbleFreeMessageCell.this.maybeStartTracking = false;
            BubbleFreeMessageCell.this.startedTracking = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onAnimationEnd$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onAnimationEnd$0$BubbleFreeMessageCell$3() {
            BubbleFreeMessageCell.this.currentIndexLayout = null;
            BubbleFreeMessageCell.this.postInvalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkButtonsMotionEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.BubbleFreeMessageCell.checkButtonsMotionEvent(android.view.MotionEvent):boolean");
    }

    private void resetUrlPaths(boolean text) {
        if (text || this.urlPath.isEmpty()) {
            return;
        }
        this.urlPathCache.addAll(this.urlPath);
        this.urlPath.clear();
    }

    private LinkPath obtainNewUrlPath(boolean text) {
        LinkPath linkPath;
        if (!this.urlPathCache.isEmpty()) {
            linkPath = this.urlPathCache.get(0);
            this.urlPathCache.remove(0);
        } else {
            linkPath = new LinkPath();
        }
        if (!text) {
            this.urlPath.add(linkPath);
        }
        return linkPath;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.drawImage) {
            int i = 0;
            while (true) {
                MediaPage[] mediaPageArr = this.mediaPages;
                if (i >= mediaPageArr.length) {
                    break;
                }
                if (mediaPageArr[i].hasBitmapImage() && this.mediaPages[i].getVisible()) {
                    this.mediaPages[i].draw(canvas);
                }
                i++;
            }
        }
        canvas.drawRect(0.0f, this.bottomBarY, getWidth(), getHeight(), Theme.freeBubbleChat_backgroundColorPaint);
        this.threeDotButton.draw(canvas);
        if (this.drawImage) {
            this.shareOutButton.draw(canvas);
        }
        this.forwardButton.draw(canvas);
        this.viewMessageButton.draw(canvas);
        this.saveButton.draw(canvas);
        if (this.hasPayButton) {
            this.payButton.draw(canvas);
        }
        this.tabIndicatorStrip.draw(canvas);
        Drawable drawable = headerShadowDrawable;
        if (drawable != null) {
            drawable.setBounds(0, this.headerHeight, getMeasuredWidth(), this.headerHeight + headerShadowDrawable.getIntrinsicHeight());
            headerShadowDrawable.draw(canvas);
        }
        Theme.freeBubbleChat_backgroundColorPaint.setColor(Theme.getColor("chat_inBubble"));
        canvas.drawPath(this.headerShadowPath, Theme.freeBubbleChat_backgroundColorPaint);
        ImageReceiver imageReceiver = this.avatarImage;
        if (imageReceiver != null) {
            imageReceiver.draw(canvas);
        }
        if (this.timeLayout != null) {
            canvas.save();
            canvas.translate(this.timeLeft, this.timeTop);
            this.timeLayout.draw(canvas);
            canvas.restore();
        }
        if (this.viewsLayout != null) {
            int iCeil = (int) Math.ceil(Theme.dialogs_timePaint.measureText(this.currentViewsString));
            if (LocaleController.isRTL) {
                this.viewsLeft = (this.timeLeft - AndroidUtilities.dp(10.0f)) - iCeil;
            } else {
                this.viewsLeft = this.timeLeft + this.timeWidth + AndroidUtilities.dp(10.0f);
            }
            canvas.save();
            canvas.translate(this.viewsLeft, this.viewsTop);
            this.viewsLayout.draw(canvas);
            canvas.restore();
            Drawable drawable2 = Theme.chat_msgInViewsDrawable;
            int intrinsicHeight = drawable2.getIntrinsicHeight();
            int height = this.viewsLayout.getHeight();
            if (LocaleController.isRTL) {
                BaseCell.setDrawableBounds(drawable2, (this.viewsLeft - drawable2.getIntrinsicWidth()) - AndroidUtilities.dp(3.0f), this.timeTop + ((height - intrinsicHeight) / 2));
            } else {
                BaseCell.setDrawableBounds(drawable2, this.viewsLeft + this.viewsLayout.getWidth() + AndroidUtilities.dp(3.0f), this.timeTop + ((height - intrinsicHeight) / 2));
            }
            drawable2.draw(canvas);
        }
        if (this.nameLayout != null) {
            canvas.save();
            canvas.translate(this.nameLeft, this.nameTop);
            this.nameLayout.draw(canvas);
            canvas.restore();
        }
        if (this.drawVerified) {
            BaseCell.setDrawableBounds(Theme.dialogs_verifiedDrawable, this.verifyLeft, this.verifyTop);
            BaseCell.setDrawableBounds(Theme.dialogs_verifiedCheckDrawable, this.verifyLeft, this.verifyTop);
            Theme.dialogs_verifiedDrawable.draw(canvas);
            Theme.dialogs_verifiedCheckDrawable.draw(canvas);
        }
        if (this.usernameLayout != null) {
            Theme.messageExplore_captionPaint.setColor(Theme.getColor("chat_messageTextIn"));
            Theme.messageExplore_captionPaint.linkColor = Theme.getColor("chat_messageLinkIn");
            canvas.save();
            canvas.translate(this.usernameX, this.usernameY);
            this.usernameLayout.draw(canvas);
            canvas.restore();
        }
        if (this.captionLayout != null) {
            Theme.messageExplore_captionPaint.setColor(Theme.getColor("chat_messageTextIn"));
            Theme.messageExplore_captionPaint.linkColor = Theme.getColor("chat_messageLinkIn");
            canvas.save();
            canvas.translate(this.captionX, this.captionY);
            if (this.pressedLink != null) {
                for (int i2 = 0; i2 < this.urlPath.size(); i2++) {
                    canvas.drawPath(this.urlPath.get(i2), Theme.chat_urlPaint);
                }
            }
            this.captionLayout.draw(canvas);
            canvas.restore();
        }
        if (this.currentIndexLayout != null && this.mediaPages[0].hasBitmapImage()) {
            float fDp = AndroidUtilities.dp(8.0f);
            float fDp2 = AndroidUtilities.dp(8.0f);
            float height2 = this.currentIndexLayout.getHeight();
            float f = (height2 / 2.0f) + fDp;
            float fMin = Math.min(this.currentIndexLayout.getWidth(), AndroidUtilities.dp(32.0f));
            canvas.save();
            if (LocaleController.isRTL) {
                canvas.translate(fDp2 + f, (((this.mediaPages[0].getImageY() + this.mediaPages[0].getImageHeight()) - fDp2) - fDp) - height2);
            } else {
                canvas.translate(((getWidth() - fMin) - fDp2) - f, (((this.mediaPages[0].getImageY() + this.mediaPages[0].getImageHeight()) - fDp2) - fDp) - height2);
            }
            canvas.save();
            canvas.translate(-f, -fDp);
            this.tabIndexRect.set(0.0f, 0.0f, fMin + (f * 2.0f), height2 + (fDp * 2.0f));
            canvas.drawRoundRect(this.tabIndexRect, f, f, this.tabIndexBackPaint);
            canvas.restore();
            this.currentIndexLayout.draw(canvas);
            canvas.restore();
        }
        Drawable drawable3 = footerShadowDrawable;
        if (drawable3 != null) {
            drawable3.setBounds(0, getMeasuredHeight() - footerShadowDrawable.getIntrinsicHeight(), getMeasuredWidth(), getMeasuredHeight());
            footerShadowDrawable.draw(canvas);
        }
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }
}
