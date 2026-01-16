package ir.eitaa.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatThemeController;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$DraftMessage;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageAction;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_dialogFolder;
import ir.eitaa.tgnet.TLRPC$TL_messageActionSetChatTheme;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserStatus;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.DialogsAdapter;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.CheckBox2;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.PullForegroundDrawable;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.TypefaceSpan;
import ir.eitaa.ui.DialogsActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DialogCell extends BaseCell {
    private int animTime;
    private int animateFromStatusDrawableParams;
    private int animateToStatusDrawableParams;
    private boolean animatingArchiveAvatar;
    private float animatingArchiveAvatarProgress;
    private float archiveBackgroundProgress;
    private boolean archiveHidden;
    private PullForegroundDrawable archivedChatsDrawable;
    private boolean attachedToWindow;
    private AvatarDrawable avatarDrawable;
    private ImageReceiver avatarImage;
    private int avatarLeft;
    private int avatarTop;
    private int bottomClip;
    private TLRPC$Chat chat;
    private float chatCallProgress;
    private CheckBox2 checkBox;
    private int checkDrawLeft;
    private int checkDrawLeft1;
    private int checkDrawTop;
    private boolean clearingDialog;
    private float clipProgress;
    private int clockDrawLeft;
    private float cornerProgress;
    private StaticLayout countAnimationInLayout;
    private boolean countAnimationIncrement;
    private StaticLayout countAnimationStableLayout;
    private ValueAnimator countAnimator;
    private float countChangeProgress;
    private StaticLayout countLayout;
    private int countLeft;
    private int countLeftOld;
    private StaticLayout countOldLayout;
    private int countTop;
    private int countWidth;
    private int countWidthOld;
    private int currentAccount;
    private int currentDialogFolderDialogsCount;
    private int currentDialogFolderId;
    private long currentDialogId;
    private int currentEditDate;
    private float currentRevealBounceProgress;
    private float currentRevealProgress;
    public CustomDialog customDialog;
    private boolean dialogMuted;
    private float dialogMutedProgress;
    private int dialogsType;
    private TLRPC$DraftMessage draftMessage;
    private boolean drawCheck1;
    private boolean drawCheck2;
    private boolean drawClock;
    private boolean drawCount;
    private boolean drawError;
    private boolean drawMention;
    private boolean drawNameBot;
    private boolean drawNameBroadcast;
    private boolean drawNameGroup;
    private boolean drawNameLock;
    private boolean drawPin;
    private boolean drawPinBackground;
    private boolean drawPlay;
    private boolean drawReorder;
    private boolean drawRevealBackground;
    private int drawScam;
    private boolean drawVerified;
    private TLRPC$EncryptedChat encryptedChat;
    private int errorLeft;
    private int errorTop;
    private int folderId;
    public boolean fullSeparator;
    public boolean fullSeparator2;
    private int halfCheckDrawLeft;
    private boolean hasCall;
    private boolean hasLive;
    private boolean hasMessageThumb;
    private int index;
    private float innerProgress;
    private BounceInterpolator interpolator;
    private boolean isDialogCell;
    private boolean isSelected;
    private boolean isSliding;
    long lastDialogChangedTime;
    private int lastDrawSwipeMessageStringId;
    private RLottieDrawable lastDrawTranslationDrawable;
    private int lastMessageDate;
    private CharSequence lastMessageString;
    private CharSequence lastPrintString;
    private int lastSendState;
    private int lastStatusDrawableParams;
    private boolean lastUnreadState;
    private long lastUpdateTime;
    private TextPaint liveTextPaint;
    private RectF liveTextRect;
    private boolean markUnread;
    private int mentionCount;
    private StaticLayout mentionLayout;
    private int mentionLeft;
    private int mentionWidth;
    private MessageObject message;
    private int messageId;
    private StaticLayout messageLayout;
    private int messageLeft;
    private StaticLayout messageNameLayout;
    private int messageNameLeft;
    private int messageNameTop;
    private int messageTop;
    boolean moving;
    private StaticLayout nameLayout;
    private int nameLeft;
    private int nameLockLeft;
    private int nameLockTop;
    private int nameMuteLeft;
    private float onlineProgress;
    private int paintIndex;
    private DialogsActivity parentFragment;
    private int pinLeft;
    private int pinTop;
    private DialogsAdapter.DialogsPreloader preloader;
    private int printingStringType;
    private int progressStage;
    private boolean promoDialog;
    private RadialGradient radialShader;
    private RectF rect;
    private float reorderIconProgress;
    private final Theme.ResourcesProvider resourcesProvider;
    private boolean statusDrawableAnimationInProgress;
    private ValueAnimator statusDrawableAnimator;
    private int statusDrawableLeft;
    private float statusDrawableProgress;
    public boolean swipeCanceled;
    private int swipeMessageTextId;
    private StaticLayout swipeMessageTextLayout;
    private int swipeMessageWidth;
    private long t;
    private ImageReceiver thumbImage;
    private StaticLayout timeLayout;
    private int timeLeft;
    private int timeTop;
    private int topClip;
    private boolean translationAnimationStarted;
    private RLottieDrawable translationDrawable;
    private float translationX;
    private int unreadCount;
    public boolean useForceThreeLines;
    private boolean useMeForMyMessages;
    public boolean useSeparator;
    private TLRPC$User user;

    public static class BounceInterpolator implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float t) {
            if (t < 0.33f) {
                return (t / 0.33f) * 0.1f;
            }
            float f = t - 0.33f;
            return f < 0.33f ? 0.1f - ((f / 0.34f) * 0.15f) : (((f - 0.34f) / 0.33f) * 0.05f) - 0.05f;
        }
    }

    public static class CustomDialog {
        public String badge;
        public int date;
        public int id;
        public boolean isMedia;
        public String message;
        public boolean muted;
        public String name;
        public TLRPC$PhotoSize photoSize;
        public boolean pinned;
        public boolean pinnedBackground;
        public boolean sent;
        public int type;
        public int unread_count;
        public boolean verified;
    }

    @Override // ir.eitaa.ui.Cells.BaseCell, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isMoving() {
        return this.moving;
    }

    public static class FixedWidthSpan extends ReplacementSpan {
        private int width;

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        }

        public FixedWidthSpan(int w) {
            this.width = w;
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
            if (fm == null) {
                fm = paint.getFontMetricsInt();
            }
            if (fm != null) {
                int i = 1 - (fm.descent - fm.ascent);
                fm.descent = i;
                fm.bottom = i;
                fm.ascent = -1;
                fm.top = -1;
            }
            return this.width;
        }
    }

    public DialogCell(DialogsActivity fragment, Context context, boolean needCheck, boolean forceThreeLines) {
        this(fragment, context, needCheck, forceThreeLines, UserConfig.selectedAccount, null);
    }

    public DialogCell(DialogsActivity fragment, Context context, boolean needCheck, boolean forceThreeLines, int account, Theme.ResourcesProvider resourcesProvider) throws Resources.NotFoundException {
        super(context);
        this.thumbImage = new ImageReceiver(this);
        this.avatarImage = new ImageReceiver(this);
        this.avatarDrawable = new AvatarDrawable();
        this.interpolator = new BounceInterpolator();
        this.countChangeProgress = 1.0f;
        this.avatarTop = AndroidUtilities.dp(10.0f);
        this.rect = new RectF();
        this.radialShader = new RadialGradient(AndroidUtilities.dp(26.0f), AndroidUtilities.dp(26.0f), AndroidUtilities.dp(20.0f), 16777215, 872415231, Shader.TileMode.MIRROR);
        this.t = 0L;
        this.animTime = 0;
        this.lastStatusDrawableParams = -1;
        this.resourcesProvider = resourcesProvider;
        this.parentFragment = fragment;
        Theme.createDialogsResources(context);
        this.avatarImage.setRoundRadius(AndroidUtilities.dp(28.0f));
        this.thumbImage.setRoundRadius(AndroidUtilities.dp(2.0f));
        this.useForceThreeLines = forceThreeLines;
        this.currentAccount = account;
        if (needCheck) {
            CheckBox2 checkBox2 = new CheckBox2(context, 21);
            this.checkBox = checkBox2;
            checkBox2.setColor(null, "windowBackgroundWhite", "checkboxCheck");
            this.checkBox.setDrawUnchecked(false);
            this.checkBox.setDrawBackgroundAsArc(3);
            addView(this.checkBox);
        }
    }

    public void setDialog(TLRPC$Dialog dialog, int type, int folder) {
        if (this.currentDialogId != dialog.id) {
            ValueAnimator valueAnimator = this.statusDrawableAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.statusDrawableAnimator.cancel();
            }
            this.statusDrawableAnimationInProgress = false;
            this.lastStatusDrawableParams = -1;
        }
        this.currentDialogId = dialog.id;
        this.lastDialogChangedTime = System.currentTimeMillis();
        this.isDialogCell = true;
        if (dialog instanceof TLRPC$TL_dialogFolder) {
            this.currentDialogFolderId = ((TLRPC$TL_dialogFolder) dialog).folder.id;
            PullForegroundDrawable pullForegroundDrawable = this.archivedChatsDrawable;
            if (pullForegroundDrawable != null) {
                pullForegroundDrawable.setCell(this);
            }
        } else {
            this.currentDialogFolderId = 0;
        }
        this.dialogsType = type;
        this.folderId = folder;
        this.messageId = 0;
        update(0, false);
        checkOnline();
        checkGroupCall();
        checkChatTheme();
    }

    public void setDialogIndex(int i) {
        this.index = i;
    }

    public void setDialog(CustomDialog dialog) {
        this.customDialog = dialog;
        this.messageId = 0;
        update(0);
        checkOnline();
        checkGroupCall();
        checkChatTheme();
    }

    public void setDialog(CustomDialog dialog, boolean useForceThreeLines) {
        this.useForceThreeLines = useForceThreeLines;
        this.customDialog = dialog;
        this.messageId = 0;
        update(0);
        checkOnline();
        checkGroupCall();
        checkChatTheme();
    }

    private void checkOnline() {
        TLRPC$User user;
        if (this.user != null && (user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.user.id))) != null) {
            this.user = user;
        }
        this.onlineProgress = isOnline() ? 1.0f : 0.0f;
    }

    private boolean isOnline() {
        TLRPC$User tLRPC$User = this.user;
        if (tLRPC$User != null && !tLRPC$User.self) {
            TLRPC$UserStatus tLRPC$UserStatus = tLRPC$User.status;
            if (tLRPC$UserStatus != null && tLRPC$UserStatus.expires <= 0 && MessagesController.getInstance(this.currentAccount).onlinePrivacy.containsKey(Long.valueOf(this.user.id))) {
                return true;
            }
            TLRPC$UserStatus tLRPC$UserStatus2 = this.user.status;
            if (tLRPC$UserStatus2 != null && tLRPC$UserStatus2.expires > ConnectionsManager.getInstance(this.currentAccount).getCurrentTime()) {
                return true;
            }
        }
        return false;
    }

    private void checkGroupCall() {
        TLRPC$Chat tLRPC$Chat = this.chat;
        boolean z = tLRPC$Chat != null && tLRPC$Chat.call_active && tLRPC$Chat.call_not_empty;
        this.hasCall = z;
        this.chatCallProgress = z ? 1.0f : 0.0f;
    }

    private void checkChatTheme() {
        TLRPC$Message tLRPC$Message;
        MessageObject messageObject = this.message;
        if (messageObject == null || (tLRPC$Message = messageObject.messageOwner) == null) {
            return;
        }
        TLRPC$MessageAction tLRPC$MessageAction = tLRPC$Message.action;
        if ((tLRPC$MessageAction instanceof TLRPC$TL_messageActionSetChatTheme) && this.lastUnreadState) {
            ChatThemeController.getInstance(this.currentAccount).setDialogTheme(this.currentDialogId, ((TLRPC$TL_messageActionSetChatTheme) tLRPC$MessageAction).emoticon, false);
        }
    }

    public void setDialog(long dialog_id, MessageObject messageObject, int date, boolean useMe) {
        if (this.currentDialogId != dialog_id) {
            this.lastStatusDrawableParams = -1;
        }
        this.currentDialogId = dialog_id;
        this.lastDialogChangedTime = System.currentTimeMillis();
        this.message = messageObject;
        this.useMeForMyMessages = useMe;
        this.isDialogCell = false;
        this.lastMessageDate = date;
        this.currentEditDate = messageObject != null ? messageObject.messageOwner.edit_date : 0;
        this.unreadCount = 0;
        this.markUnread = false;
        this.messageId = messageObject != null ? messageObject.getId() : 0;
        this.mentionCount = 0;
        this.lastUnreadState = messageObject != null && messageObject.isUnread();
        MessageObject messageObject2 = this.message;
        if (messageObject2 != null) {
            this.lastSendState = messageObject2.messageOwner.send_state;
        }
        update(0);
    }

    public long getDialogId() {
        return this.currentDialogId;
    }

    public int getDialogIndex() {
        return this.index;
    }

    public int getMessageId() {
        return this.messageId;
    }

    public void setPreloader(DialogsAdapter.DialogsPreloader preloader) {
        this.preloader = preloader;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isSliding = false;
        this.drawRevealBackground = false;
        this.currentRevealProgress = 0.0f;
        this.attachedToWindow = false;
        this.reorderIconProgress = (this.drawPin && this.drawReorder) ? 1.0f : 0.0f;
        this.avatarImage.onDetachedFromWindow();
        this.thumbImage.onDetachedFromWindow();
        RLottieDrawable rLottieDrawable = this.translationDrawable;
        if (rLottieDrawable != null) {
            rLottieDrawable.stop();
            this.translationDrawable.setProgress(0.0f);
            this.translationDrawable.setCallback(null);
            this.translationDrawable = null;
            this.translationAnimationStarted = false;
        }
        DialogsAdapter.DialogsPreloader dialogsPreloader = this.preloader;
        if (dialogsPreloader != null) {
            dialogsPreloader.remove(this.currentDialogId);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.avatarImage.onAttachedToWindow();
        this.thumbImage.onAttachedToWindow();
        resetPinnedArchiveState();
    }

    public void resetPinnedArchiveState() {
        boolean z = SharedConfig.archiveHidden;
        this.archiveHidden = z;
        float f = z ? 0.0f : 1.0f;
        this.archiveBackgroundProgress = f;
        this.avatarDrawable.setArchivedAvatarHiddenProgress(f);
        this.clipProgress = 0.0f;
        this.isSliding = false;
        this.reorderIconProgress = (this.drawPin && this.drawReorder) ? 1.0f : 0.0f;
        this.attachedToWindow = true;
        this.cornerProgress = 0.0f;
        setTranslationX(0.0f);
        setTranslationY(0.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 != null) {
            checkBox2.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(24.0f), 1073741824));
        }
        if (isLocked()) {
            setMeasuredDimension(0, 0);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp((this.useForceThreeLines || SharedConfig.useThreeLinesLayout) ? 78.0f : 72.0f) + (this.useSeparator ? 1 : 0));
        }
        this.topClip = 0;
        this.bottomClip = getMeasuredHeight();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int iDp;
        if (this.currentDialogId == 0 && this.customDialog == null) {
            return;
        }
        if (this.checkBox != null) {
            if (LocaleController.isRTL) {
                iDp = (right - left) - AndroidUtilities.dp((this.useForceThreeLines || SharedConfig.useThreeLinesLayout) ? 43.0f : 45.0f);
            } else {
                iDp = AndroidUtilities.dp((this.useForceThreeLines || SharedConfig.useThreeLinesLayout) ? 43.0f : 45.0f);
            }
            int iDp2 = AndroidUtilities.dp((this.useForceThreeLines || SharedConfig.useThreeLinesLayout) ? 48.0f : 42.0f);
            CheckBox2 checkBox2 = this.checkBox;
            checkBox2.layout(iDp, iDp2, checkBox2.getMeasuredWidth() + iDp, this.checkBox.getMeasuredHeight() + iDp2);
        }
        if (changed) {
            try {
                buildLayout();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private CharSequence formatArchivedDialogNames() {
        TLRPC$User user;
        String strReplace;
        ArrayList<TLRPC$Dialog> dialogs = MessagesController.getInstance(this.currentAccount).getDialogs(this.currentDialogFolderId);
        this.currentDialogFolderDialogsCount = dialogs.size();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int size = dialogs.size();
        for (int i = 0; i < size; i++) {
            TLRPC$Dialog tLRPC$Dialog = dialogs.get(i);
            if (!MessagesController.getInstance(UserConfig.selectedAccount).isLockedDialog(tLRPC$Dialog)) {
                TLRPC$Chat chat = null;
                if (DialogObject.isEncryptedDialog(tLRPC$Dialog.id)) {
                    TLRPC$EncryptedChat encryptedChat = MessagesController.getInstance(this.currentAccount).getEncryptedChat(Integer.valueOf(DialogObject.getEncryptedChatId(tLRPC$Dialog.id)));
                    user = encryptedChat != null ? MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(encryptedChat.user_id)) : null;
                } else if (DialogObject.isUserDialog(tLRPC$Dialog.id)) {
                    user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(tLRPC$Dialog.id));
                } else {
                    chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-tLRPC$Dialog.id));
                    user = null;
                }
                if (chat != null) {
                    strReplace = chat.title.replace('\n', ' ');
                } else if (user == null) {
                    continue;
                } else if (UserObject.isDeleted(user)) {
                    strReplace = LocaleController.getString("HiddenName", R.string.HiddenName);
                } else {
                    strReplace = ContactsController.formatName(user.first_name, user.last_name).replace('\n', ' ');
                }
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append((CharSequence) ", ");
                }
                int length = spannableStringBuilder.length();
                int length2 = strReplace.length() + length;
                spannableStringBuilder.append((CharSequence) strReplace);
                if (tLRPC$Dialog.unread_count > 0) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(AndroidUtilities.getFontFamily(true), 0, Theme.getColor("chats_nameArchived", this.resourcesProvider)), length, length2, 33);
                }
                if (spannableStringBuilder.length() > 150) {
                    break;
                }
            }
        }
        return Emoji.replaceEmoji(spannableStringBuilder, Theme.dialogs_messagePaint[this.paintIndex].getFontMetricsInt(), AndroidUtilities.dp(17.0f), false);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(45:6|(1:12)(1:11)|13|(1:15)(1:16)|17|(1:22)(1:21)|23|(2:25|(2:32|42)(2:31|40))(2:33|(2:41|42)(2:39|40))|43|(1:45)(1:46)|47|(13:49|(1:51)|52|(2:54|(2:63|(1:65)(1:66))(2:59|(1:61)(1:62)))(2:67|(2:99|(2:108|(1:110)(1:111))(2:104|(1:106)(1:107)))(2:70|(2:87|(3:89|(1:91)(1:92)|93)(3:94|(1:96)(1:97)|98))(2:75|(3:77|(1:79)(1:80)|81)(3:82|(1:84)(1:85)|86))))|112|(3:114|(1:116)(4:117|(1:119)|120|(1:126)(1:125))|127)(3:128|(1:130)|131)|132|(1:137)(1:136)|138|(1:140)(1:141)|142|(1:144)(1:145)|146)(21:147|(2:156|(1:158)(1:159))(2:152|(1:154)(1:155))|160|(2:162|(2:164|(2:173|(1:175)(1:176))(2:169|(1:171)(1:172))))(2:177|(0)(18:179|(4:181|(1:183)(2:184|(1:186)(2:187|(1:189)(1:190)))|191|(2:193|(4:220|(1:228)(1:227)|229|(3:231|(1:233)(1:234)|235)(3:236|(1:238)(1:239)|240))(5:198|(1:206)(1:205)|207|(3:209|(1:211)(1:212)|213)(3:214|(1:216)(1:217)|218)|219)))(2:241|(4:243|(1:245)(2:246|(1:248)(2:249|(1:251)(1:252)))|253|(2:257|(2:266|(1:268)(1:269))(2:262|(1:264)(1:265)))))|271|(1:275)|276|(2:278|(2:290|(2:292|(2:300|(2:285|307))(0))(0))(0))(1:308)|(6:310|(1:312)(1:313)|314|(1:316)(1:317)|(1:319)(1:320)|321)(3:322|(4:324|(2:326|(2:332|333)(1:331))(5:334|(1:336)|337|(1:342)(1:341)|343)|344|333)(4:345|(1:347)(12:352|(3:354|(2:356|(1:358)(2:359|(1:361)(2:362|(1:364)(2:365|(2:367|(1:369)(1:370))(1:371)))))(2:372|(1:377)(1:376))|349)(7:378|(1:380)(1:381)|382|(4:387|(4:396|(2:398|(3:400|(1:404)(1:405)|406)(0))(2:408|(3:456|457|(4:606|(2:609|(2:616|(2:623|(3:(1:626)(2:627|(1:629)(2:630|(1:632)(2:633|(1:635)(2:636|(1:638)(1:639)))))|640|(1:653)(4:644|(2:646|(1:648)(1:649))|(1:651)|652))(4:654|(1:656)(2:657|(1:659)(2:660|(1:662)(2:663|(1:665)(3:666|(1:671)(1:670)|672))))|673|(1:677)))(1:622))(1:615))|678|(7:680|(3:685|(1:687)|688)(1:684)|689|(1:691)|692|(1:697)(1:696)|698)(1:699))(7:466|(1:468)(2:469|(1:(2:477|(2:483|(1:485)(1:486))(1:482))(1:487))(1:475))|488|(1:490)(2:492|(5:494|(1:496)|(1:498)(2:500|(1:502)(2:503|(1:505)(2:506|(1:508)(2:509|(1:511)(1:512)))))|499|513)(9:514|(3:551|(3:553|(5:555|(1:557)|558|(3:560|(1:562)(1:563)|564)(1:565)|(1:567)(1:568))(3:569|(1:571)|572)|573)(1:574)|575)(9:518|(2:520|(1:522)(1:523))(2:524|(2:526|(1:528)(1:529))(2:530|(1:532)(2:534|(2:536|(1:538)(1:539))(1:540))))|533|541|1217|542|(1:544)(1:545)|546|550)|576|(1:593)(6:1215|584|585|1219|586|587)|594|(1:598)|599|(3:601|(1:603)|604)|605))|491|576|(8:578|580|593|594|(2:596|598)|599|(0)|605)(7:580|593|594|(0)|599|(0)|605)))(4:422|(1:424)(1:425)|426|(0)(9:435|(1:437)|(3:439|(3:447|(2:(1:450)(1:451)|452)(1:453)|454)(1:446)|455)(0)|457|(1:459)|606|(0)|678|(0)(0))))|407|395)(1:393)|394|395)(1:386)|700|(1:702)|703)|704|(1:706)(2:707|(1:709)(2:710|(1:712)(1:713)))|714|(1:716)(2:717|(5:719|(1:(1:722)(3:723|747|(1:773)(2:752|(2:754|(1:756)(3:757|(1:759)(2:760|(3:762|(1:770)(1:769)|771))|772))(0))))(1:724)|725|747|(2:749|773)(0))(5:726|(1:728)(4:730|(2:739|(1:741)(1:742))(1:738)|743|(3:745|747|(0)(0))(4:746|725|747|(0)(0)))|729|743|(0)(0)))|774|(2:776|(5:778|(1:780)(2:781|(4:783|(1:785)|786|(1:788)))|791|(1:793)(4:795|(1:797)(2:798|(2:800|(1:802)(2:803|(2:805|(1:807)(3:808|(1:810)|811))(2:812|(1:835)(2:818|(2:825|(2:830|(1:834))(1:829))(1:824)))))(1:836))|837|(1:839))|794))(1:789)|790|791|(0)(0)|794)|348|349)|350)|351|704|(0)(0)|714|(0)(0)|774|(0)(0)|790|791|(0)(0)|794))|270|271|(2:273|275)|276|(0)(0)|(0)(0)|351|704|(0)(0)|714|(0)(0)|774|(0)(0)|790|791|(0)(0)|794)|(3:841|(1:843)(1:844)|845)(1:846)|847|(1:849)(1:850)|851|(1:853)(2:855|(1:857)(2:858|(1:860)(32:861|(1:863)|864|(2:866|(1:868)(1:869))(2:870|(2:872|(2:874|(1:876)(1:877))(2:878|(1:880)(1:881))))|882|(2:891|(2:893|(1:895))(2:896|(4:898|(1:900)(2:901|(1:903)(2:904|(1:906)(1:907)))|908|(1:910))(2:911|(2:915|(1:917)))))(2:888|(1:890))|918|1211|919|(1:926)(1:925)|927|931|(5:945|(1:947)(1:948)|949|(1:951)(1:952)|953)(5:936|(1:938)(1:939)|940|(1:942)(1:943)|944)|954|(2:956|(1:958)(1:959))|960|(2:962|(1:964)(1:965))(1:(2:(3:977|(1:979)(1:980)|981)(1:982)|(5:984|(1:986)(1:987)|988|(3:990|(1:992)(1:993)|994)(3:995|(1:997)(1:998)|999)|1000))(3:970|(2:972|(1:974))|975))|966|(7:(1:1003)|1004|(1:1006)|1007|(1:1013)(1:1012)|1014|(1:1018))|1019|(5:1209|1028|(1:1034)|1035|1039)(2:1040|(1:1046)(1:1045))|1208|1047|(1:1055)(2:(1:1060)|1061)|1062|(5:1073|(1:1076)|1077|(1:1079)(1:1080)|1081)(3:1067|(2:1069|(1:1071))|1072)|1085|(6:1087|(4:1091|(2:1098|(1:1100)(2:1101|(3:1103|(1:1105)(2:1106|(1:1108)(2:1109|(1:1111)(1:1112)))|1113)(2:1114|(1:1118))))(1:1097)|1119|(2:1121|(1:1123)))|1124|(4:1128|(1:(1:1221)(2:1130|(1:1132)(2:1222|1133)))|1134|(1:1136))|1137|(2:1143|(1:1145)))(6:1146|(4:1150|(2:1152|(1:1154))|1155|(1:1165))|1166|(4:1170|(1:1172)|1223|1173)|1174|(1:1178))|1179|(6:1213|1183|(1:1185)(1:1186)|1187|(1:1189)|1190)|1194|(1:1225)(3:(1:1202)(1:1201)|1203|(2:1205|1226)(2:1206|1207)))))|854|864|(0)(0)|882|(3:884|891|(0)(0))(0)|918|1211|919|(3:921|926|927)(0)|931|(6:933|945|(0)(0)|949|(0)(0)|953)(0)|954|(0)|960|(0)(0)|966|(0)|1019|(7:1021|1024|1209|1028|(3:1030|1032|1034)|1035|1039)(6:1024|1209|1028|(0)|1035|1039)|1208|1047|(6:1049|1051|1053|1055|1062|(7:1064|1066|1073|(1:1076)|1077|(0)(0)|1081)(0))(5:1051|1053|1055|1062|(0)(0))|1085|(0)(0)|1179|(7:1181|1213|1183|(0)(0)|1187|(0)|1190)|1194|(2:1196|1225)(1:1224)) */
    /* JADX WARN: Code restructure failed: missing block: B:1083:0x1950, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1084:0x1951, code lost:
    
        r49.messageLayout = null;
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:929:0x148b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:930:0x148c, code lost:
    
        ir.eitaa.messenger.FileLog.e(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:1002:0x17ca  */
    /* JADX WARN: Removed duplicated region for block: B:1021:0x182a  */
    /* JADX WARN: Removed duplicated region for block: B:1023:0x182e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1030:0x183d A[Catch: Exception -> 0x186b, TryCatch #1 {Exception -> 0x186b, blocks: (B:1028:0x1839, B:1030:0x183d, B:1032:0x1843, B:1035:0x1850), top: B:1209:0x1839 }] */
    /* JADX WARN: Removed duplicated region for block: B:1049:0x18b1 A[Catch: Exception -> 0x1950, TryCatch #0 {Exception -> 0x1950, blocks: (B:1047:0x18ad, B:1049:0x18b1, B:1057:0x18cc, B:1060:0x18d2, B:1062:0x18e4, B:1064:0x18e8, B:1067:0x18ed, B:1069:0x18f1, B:1071:0x18fd, B:1072:0x1908, B:1073:0x1920, B:1076:0x1926, B:1077:0x192d, B:1081:0x1943, B:1051:0x18b5, B:1053:0x18b9, B:1055:0x18be), top: B:1208:0x18ad }] */
    /* JADX WARN: Removed duplicated region for block: B:1051:0x18b5 A[Catch: Exception -> 0x1950, TryCatch #0 {Exception -> 0x1950, blocks: (B:1047:0x18ad, B:1049:0x18b1, B:1057:0x18cc, B:1060:0x18d2, B:1062:0x18e4, B:1064:0x18e8, B:1067:0x18ed, B:1069:0x18f1, B:1071:0x18fd, B:1072:0x1908, B:1073:0x1920, B:1076:0x1926, B:1077:0x192d, B:1081:0x1943, B:1051:0x18b5, B:1053:0x18b9, B:1055:0x18be), top: B:1208:0x18ad }] */
    /* JADX WARN: Removed duplicated region for block: B:1064:0x18e8 A[Catch: Exception -> 0x1950, TryCatch #0 {Exception -> 0x1950, blocks: (B:1047:0x18ad, B:1049:0x18b1, B:1057:0x18cc, B:1060:0x18d2, B:1062:0x18e4, B:1064:0x18e8, B:1067:0x18ed, B:1069:0x18f1, B:1071:0x18fd, B:1072:0x1908, B:1073:0x1920, B:1076:0x1926, B:1077:0x192d, B:1081:0x1943, B:1051:0x18b5, B:1053:0x18b9, B:1055:0x18be), top: B:1208:0x18ad }] */
    /* JADX WARN: Removed duplicated region for block: B:1073:0x1920 A[Catch: Exception -> 0x1950, TryCatch #0 {Exception -> 0x1950, blocks: (B:1047:0x18ad, B:1049:0x18b1, B:1057:0x18cc, B:1060:0x18d2, B:1062:0x18e4, B:1064:0x18e8, B:1067:0x18ed, B:1069:0x18f1, B:1071:0x18fd, B:1072:0x1908, B:1073:0x1920, B:1076:0x1926, B:1077:0x192d, B:1081:0x1943, B:1051:0x18b5, B:1053:0x18b9, B:1055:0x18be), top: B:1208:0x18ad }] */
    /* JADX WARN: Removed duplicated region for block: B:1079:0x193e  */
    /* JADX WARN: Removed duplicated region for block: B:1080:0x1941  */
    /* JADX WARN: Removed duplicated region for block: B:1087:0x195b  */
    /* JADX WARN: Removed duplicated region for block: B:1146:0x1ad4  */
    /* JADX WARN: Removed duplicated region for block: B:1181:0x1b6a  */
    /* JADX WARN: Removed duplicated region for block: B:1185:0x1b7b A[Catch: Exception -> 0x1ba8, TryCatch #3 {Exception -> 0x1ba8, blocks: (B:1183:0x1b6e, B:1185:0x1b7b, B:1187:0x1b7f, B:1189:0x1b98, B:1190:0x1b9f), top: B:1213:0x1b6e }] */
    /* JADX WARN: Removed duplicated region for block: B:1186:0x1b7e  */
    /* JADX WARN: Removed duplicated region for block: B:1189:0x1b98 A[Catch: Exception -> 0x1ba8, TryCatch #3 {Exception -> 0x1ba8, blocks: (B:1183:0x1b6e, B:1185:0x1b7b, B:1187:0x1b7f, B:1189:0x1b98, B:1190:0x1b9f), top: B:1213:0x1b6e }] */
    /* JADX WARN: Removed duplicated region for block: B:1196:0x1bb0  */
    /* JADX WARN: Removed duplicated region for block: B:1224:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x067b  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x0909  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x0a18  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0ce8  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x0cf9  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0d31  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0ed1  */
    /* JADX WARN: Removed duplicated region for block: B:699:0x0f6f  */
    /* JADX WARN: Removed duplicated region for block: B:702:0x0f77  */
    /* JADX WARN: Removed duplicated region for block: B:706:0x0f88  */
    /* JADX WARN: Removed duplicated region for block: B:707:0x0f90  */
    /* JADX WARN: Removed duplicated region for block: B:716:0x0fad  */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0fbe  */
    /* JADX WARN: Removed duplicated region for block: B:745:0x103c  */
    /* JADX WARN: Removed duplicated region for block: B:746:0x1041  */
    /* JADX WARN: Removed duplicated region for block: B:749:0x104c  */
    /* JADX WARN: Removed duplicated region for block: B:773:0x10b0  */
    /* JADX WARN: Removed duplicated region for block: B:776:0x10c7  */
    /* JADX WARN: Removed duplicated region for block: B:789:0x1120  */
    /* JADX WARN: Removed duplicated region for block: B:793:0x1126  */
    /* JADX WARN: Removed duplicated region for block: B:795:0x113c  */
    /* JADX WARN: Removed duplicated region for block: B:841:0x1235  */
    /* JADX WARN: Removed duplicated region for block: B:846:0x127c  */
    /* JADX WARN: Removed duplicated region for block: B:849:0x128a  */
    /* JADX WARN: Removed duplicated region for block: B:850:0x129a  */
    /* JADX WARN: Removed duplicated region for block: B:853:0x12b2  */
    /* JADX WARN: Removed duplicated region for block: B:855:0x12c2  */
    /* JADX WARN: Removed duplicated region for block: B:866:0x12f9  */
    /* JADX WARN: Removed duplicated region for block: B:870:0x1326  */
    /* JADX WARN: Removed duplicated region for block: B:884:0x13a8  */
    /* JADX WARN: Removed duplicated region for block: B:891:0x13c7  */
    /* JADX WARN: Removed duplicated region for block: B:893:0x13cb  */
    /* JADX WARN: Removed duplicated region for block: B:896:0x13e1  */
    /* JADX WARN: Removed duplicated region for block: B:921:0x145a A[Catch: Exception -> 0x148b, TryCatch #2 {Exception -> 0x148b, blocks: (B:919:0x143f, B:921:0x145a, B:923:0x1460, B:927:0x1471), top: B:1211:0x143f }] */
    /* JADX WARN: Removed duplicated region for block: B:926:0x146f  */
    /* JADX WARN: Removed duplicated region for block: B:933:0x1495  */
    /* JADX WARN: Removed duplicated region for block: B:945:0x157c  */
    /* JADX WARN: Removed duplicated region for block: B:947:0x15c7  */
    /* JADX WARN: Removed duplicated region for block: B:948:0x15e6  */
    /* JADX WARN: Removed duplicated region for block: B:951:0x15ff  */
    /* JADX WARN: Removed duplicated region for block: B:952:0x1624  */
    /* JADX WARN: Removed duplicated region for block: B:956:0x165c  */
    /* JADX WARN: Removed duplicated region for block: B:962:0x1681  */
    /* JADX WARN: Removed duplicated region for block: B:967:0x16b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void buildLayout() {
        /*
            Method dump skipped, instructions count: 7163
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.DialogCell.buildLayout():void");
    }

    private void drawCheckStatus(Canvas canvas, boolean drawClock, boolean drawCheck1, boolean drawCheck2, boolean moveCheck, float alpha) {
        if (alpha != 0.0f || moveCheck) {
            float f = (alpha * 0.5f) + 0.5f;
            if (drawClock) {
                BaseCell.setDrawableBounds(Theme.dialogs_clockDrawable, this.clockDrawLeft, this.checkDrawTop);
                if (alpha != 1.0f) {
                    canvas.save();
                    canvas.scale(f, f, Theme.dialogs_clockDrawable.getBounds().centerX(), Theme.dialogs_halfCheckDrawable.getBounds().centerY());
                    Theme.dialogs_clockDrawable.setAlpha((int) (255.0f * alpha));
                }
                Theme.dialogs_clockDrawable.draw(canvas);
                if (alpha != 1.0f) {
                    canvas.restore();
                    Theme.dialogs_clockDrawable.setAlpha(255);
                }
                invalidate();
                return;
            }
            if (drawCheck2) {
                if (drawCheck1) {
                    BaseCell.setDrawableBounds(Theme.dialogs_halfCheckDrawable, this.halfCheckDrawLeft, this.checkDrawTop);
                    if (moveCheck) {
                        canvas.save();
                        canvas.scale(f, f, Theme.dialogs_halfCheckDrawable.getBounds().centerX(), Theme.dialogs_halfCheckDrawable.getBounds().centerY());
                        Theme.dialogs_halfCheckDrawable.setAlpha((int) (alpha * 255.0f));
                    }
                    if (!moveCheck && alpha != 0.0f) {
                        canvas.save();
                        canvas.scale(f, f, Theme.dialogs_halfCheckDrawable.getBounds().centerX(), Theme.dialogs_halfCheckDrawable.getBounds().centerY());
                        int i = (int) (255.0f * alpha);
                        Theme.dialogs_halfCheckDrawable.setAlpha(i);
                        Theme.dialogs_checkReadDrawable.setAlpha(i);
                    }
                    Theme.dialogs_halfCheckDrawable.draw(canvas);
                    if (moveCheck) {
                        canvas.restore();
                        canvas.save();
                        canvas.translate(AndroidUtilities.dp(4.0f) * (1.0f - alpha), 0.0f);
                    }
                    BaseCell.setDrawableBounds(Theme.dialogs_checkReadDrawable, this.checkDrawLeft, this.checkDrawTop);
                    Theme.dialogs_checkReadDrawable.draw(canvas);
                    if (moveCheck) {
                        canvas.restore();
                        Theme.dialogs_halfCheckDrawable.setAlpha(255);
                    }
                    if (moveCheck || alpha == 0.0f) {
                        return;
                    }
                    canvas.restore();
                    Theme.dialogs_halfCheckDrawable.setAlpha(255);
                    Theme.dialogs_checkReadDrawable.setAlpha(255);
                    return;
                }
                BaseCell.setDrawableBounds(Theme.dialogs_checkDrawable, this.checkDrawLeft1, this.checkDrawTop);
                if (alpha != 1.0f) {
                    canvas.save();
                    canvas.scale(f, f, Theme.dialogs_checkDrawable.getBounds().centerX(), Theme.dialogs_halfCheckDrawable.getBounds().centerY());
                    Theme.dialogs_checkDrawable.setAlpha((int) (255.0f * alpha));
                }
                Theme.dialogs_checkDrawable.draw(canvas);
                if (alpha != 1.0f) {
                    canvas.restore();
                    Theme.dialogs_checkDrawable.setAlpha(255);
                }
            }
        }
    }

    public boolean isPointInsideAvatar(float x, float y) {
        return !LocaleController.isRTL ? x >= 0.0f && x < ((float) AndroidUtilities.dp(60.0f)) : x >= ((float) (getMeasuredWidth() - AndroidUtilities.dp(60.0f))) && x < ((float) getMeasuredWidth());
    }

    public void setDialogSelected(boolean value) {
        if (this.isSelected != value) {
            invalidate();
        }
        this.isSelected = value;
    }

    public void checkCurrentDialogIndex(boolean frozen) {
        MessageObject messageObjectFindFolderTopMessage;
        MessageObject messageObject;
        DialogsActivity dialogsActivity = this.parentFragment;
        if (dialogsActivity == null) {
            return;
        }
        ArrayList<TLRPC$Dialog> dialogsArray = dialogsActivity.getDialogsArray(this.currentAccount, this.dialogsType, this.folderId, frozen);
        if (this.index < dialogsArray.size()) {
            TLRPC$Dialog tLRPC$Dialog = dialogsArray.get(this.index);
            TLRPC$Dialog tLRPC$Dialog2 = this.index + 1 < dialogsArray.size() ? dialogsArray.get(this.index + 1) : null;
            TLRPC$DraftMessage draft = MediaDataController.getInstance(this.currentAccount).getDraft(this.currentDialogId, 0);
            if (this.currentDialogFolderId != 0) {
                messageObjectFindFolderTopMessage = findFolderTopMessage();
            } else {
                messageObjectFindFolderTopMessage = MessagesController.getInstance(this.currentAccount).dialogMessage.get(tLRPC$Dialog.id);
            }
            if (this.currentDialogId == tLRPC$Dialog.id && (((messageObject = this.message) == null || messageObject.getId() == tLRPC$Dialog.top_message) && ((messageObjectFindFolderTopMessage == null || messageObjectFindFolderTopMessage.messageOwner.edit_date == this.currentEditDate) && this.unreadCount == tLRPC$Dialog.unread_count && this.mentionCount == tLRPC$Dialog.unread_mentions_count && this.markUnread == tLRPC$Dialog.unread_mark && this.message == messageObjectFindFolderTopMessage && draft == this.draftMessage && this.drawPin == tLRPC$Dialog.pinned))) {
                return;
            }
            long j = this.currentDialogId;
            long j2 = tLRPC$Dialog.id;
            boolean z = j != j2;
            this.currentDialogId = j2;
            if (z) {
                this.lastDialogChangedTime = System.currentTimeMillis();
                ValueAnimator valueAnimator = this.statusDrawableAnimator;
                if (valueAnimator != null) {
                    valueAnimator.removeAllListeners();
                    this.statusDrawableAnimator.cancel();
                }
                this.statusDrawableAnimationInProgress = false;
                this.lastStatusDrawableParams = -1;
            }
            boolean z2 = tLRPC$Dialog instanceof TLRPC$TL_dialogFolder;
            if (z2) {
                this.currentDialogFolderId = ((TLRPC$TL_dialogFolder) tLRPC$Dialog).folder.id;
            } else {
                this.currentDialogFolderId = 0;
            }
            int i = this.dialogsType;
            if (i == 7 || i == 8) {
                MessagesController.DialogFilter dialogFilter = MessagesController.getInstance(this.currentAccount).selectedDialogFilter[this.dialogsType == 8 ? (char) 1 : (char) 0];
                this.fullSeparator = (tLRPC$Dialog instanceof TLRPC$TL_dialog) && tLRPC$Dialog2 != null && dialogFilter != null && dialogFilter.pinnedDialogs.indexOfKey(tLRPC$Dialog.id) >= 0 && dialogFilter.pinnedDialogs.indexOfKey(tLRPC$Dialog2.id) < 0;
                this.fullSeparator2 = false;
            } else {
                this.fullSeparator = (tLRPC$Dialog instanceof TLRPC$TL_dialog) && tLRPC$Dialog.pinned && tLRPC$Dialog2 != null && !tLRPC$Dialog2.pinned;
                this.fullSeparator2 = (!z2 || tLRPC$Dialog2 == null || tLRPC$Dialog2.pinned) ? false : true;
            }
            update(0, !z);
            if (z) {
                this.reorderIconProgress = (this.drawPin && this.drawReorder) ? 1.0f : 0.0f;
            }
            checkOnline();
            checkGroupCall();
            checkChatTheme();
        }
    }

    public void animateArchiveAvatar() {
        if (this.avatarDrawable.getAvatarType() != 2) {
            return;
        }
        this.animatingArchiveAvatar = true;
        this.animatingArchiveAvatarProgress = 0.0f;
        Theme.dialogs_archiveAvatarDrawable.setProgress(0.0f);
        Theme.dialogs_archiveAvatarDrawable.start();
        invalidate();
    }

    public void setChecked(boolean checked, boolean animated) {
        CheckBox2 checkBox2 = this.checkBox;
        if (checkBox2 == null) {
            return;
        }
        checkBox2.setChecked(checked, animated);
    }

    private MessageObject findFolderTopMessage() {
        DialogsActivity dialogsActivity = this.parentFragment;
        MessageObject messageObject = null;
        if (dialogsActivity == null) {
            return null;
        }
        ArrayList<TLRPC$Dialog> dialogsArray = dialogsActivity.getDialogsArray(this.currentAccount, this.dialogsType, this.currentDialogFolderId, false);
        if (!dialogsArray.isEmpty()) {
            int size = dialogsArray.size();
            for (int i = 0; i < size; i++) {
                TLRPC$Dialog tLRPC$Dialog = dialogsArray.get(i);
                MessageObject messageObject2 = MessagesController.getInstance(this.currentAccount).dialogMessage.get(tLRPC$Dialog.id);
                if (messageObject2 != null && (messageObject == null || messageObject2.messageOwner.date > messageObject.messageOwner.date)) {
                    messageObject = messageObject2;
                }
                if (tLRPC$Dialog.pinnedNum == 0 && messageObject != null) {
                    break;
                }
            }
        }
        return messageObject;
    }

    public boolean isFolderCell() {
        return this.currentDialogFolderId != 0;
    }

    public void update(int mask) {
        update(mask, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(int r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.DialogCell.update(int, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$update$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$update$0$DialogCell(ValueAnimator valueAnimator) {
        this.countChangeProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // android.view.View
    public void setTranslationX(float value) {
        float f = (int) value;
        this.translationX = f;
        RLottieDrawable rLottieDrawable = this.translationDrawable;
        if (rLottieDrawable != null && f == 0.0f) {
            rLottieDrawable.setProgress(0.0f);
            this.translationAnimationStarted = false;
            this.archiveHidden = SharedConfig.archiveHidden;
            this.currentRevealProgress = 0.0f;
            this.isSliding = false;
        }
        float f2 = this.translationX;
        if (f2 != 0.0f) {
            this.isSliding = true;
        } else {
            this.currentRevealBounceProgress = 0.0f;
            this.currentRevealProgress = 0.0f;
            this.drawRevealBackground = false;
        }
        if (this.isSliding && !this.swipeCanceled) {
            boolean z = this.drawRevealBackground;
            boolean z2 = Math.abs(f2) >= ((float) getMeasuredWidth()) * 0.45f;
            this.drawRevealBackground = z2;
            if (z != z2 && this.archiveHidden == SharedConfig.archiveHidden) {
                try {
                    performHapticFeedback(3, 2);
                } catch (Exception unused) {
                }
            }
        }
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0db4  */
    /* JADX WARN: Removed duplicated region for block: B:703:0x1381  */
    /* JADX WARN: Removed duplicated region for block: B:705:0x1385  */
    /* JADX WARN: Removed duplicated region for block: B:710:0x1418  */
    /* JADX WARN: Removed duplicated region for block: B:713:0x142b  */
    /* JADX WARN: Removed duplicated region for block: B:718:0x143f  */
    /* JADX WARN: Removed duplicated region for block: B:724:0x1454  */
    @Override // android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r37) {
        /*
            Method dump skipped, instructions count: 5699
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Cells.DialogCell.onDraw(android.graphics.Canvas):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createStatusDrawableAnimator(int lastStatusDrawableParams, int currentStatus) {
        this.statusDrawableProgress = 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.statusDrawableAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(220L);
        this.statusDrawableAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
        this.animateFromStatusDrawableParams = lastStatusDrawableParams;
        this.animateToStatusDrawableParams = currentStatus;
        this.statusDrawableAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Cells.-$$Lambda$DialogCell$0iFSeKnrSCg39K8jV43_yOAAjek
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$createStatusDrawableAnimator$1$DialogCell(valueAnimator);
            }
        });
        this.statusDrawableAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Cells.DialogCell.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int i = (DialogCell.this.drawClock ? 1 : 0) + (DialogCell.this.drawCheck1 ? 2 : 0) + (DialogCell.this.drawCheck2 ? 4 : 0);
                if (DialogCell.this.animateToStatusDrawableParams == i) {
                    DialogCell.this.statusDrawableAnimationInProgress = false;
                    DialogCell dialogCell = DialogCell.this;
                    dialogCell.lastStatusDrawableParams = dialogCell.animateToStatusDrawableParams;
                } else {
                    DialogCell dialogCell2 = DialogCell.this;
                    dialogCell2.createStatusDrawableAnimator(dialogCell2.animateToStatusDrawableParams, i);
                }
                DialogCell.this.invalidate();
            }
        });
        this.statusDrawableAnimationInProgress = true;
        this.statusDrawableAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createStatusDrawableAnimator$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createStatusDrawableAnimator$1$DialogCell(ValueAnimator valueAnimator) {
        this.statusDrawableProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private boolean isLocked() {
        DialogsActivity dialogsActivity;
        return MessagesController.getInstance(UserConfig.selectedAccount).isLockedDialog(Long.valueOf(this.currentDialogId)) && (dialogsActivity = this.parentFragment) != null && (dialogsActivity instanceof DialogsActivity) && !(dialogsActivity.isForward && SharedConfig.showLockedChatsWhenForward);
    }

    public void startOutAnimation() {
        PullForegroundDrawable pullForegroundDrawable = this.archivedChatsDrawable;
        if (pullForegroundDrawable != null) {
            pullForegroundDrawable.outCy = this.avatarImage.getCenterY();
            this.archivedChatsDrawable.outCx = this.avatarImage.getCenterX();
            this.archivedChatsDrawable.outRadius = this.avatarImage.getImageWidth() / 2.0f;
            this.archivedChatsDrawable.outImageSize = this.avatarImage.getBitmapWidth();
            this.archivedChatsDrawable.startOutAnimation();
        }
    }

    public void onReorderStateChanged(boolean reordering, boolean animated) {
        boolean z = this.drawPin;
        if ((!z && reordering) || this.drawReorder == reordering) {
            if (z) {
                return;
            }
            this.drawReorder = false;
        } else {
            this.drawReorder = reordering;
            if (animated) {
                this.reorderIconProgress = reordering ? 0.0f : 1.0f;
            } else {
                this.reorderIconProgress = reordering ? 1.0f : 0.0f;
            }
            invalidate();
        }
    }

    public void setSliding(boolean value) {
        this.isSliding = value;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable who) {
        if (who == this.translationDrawable || who == Theme.dialogs_archiveAvatarDrawable) {
            invalidate(who.getBounds());
        } else {
            super.invalidateDrawable(who);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        PullForegroundDrawable pullForegroundDrawable;
        super.onInitializeAccessibilityNodeInfo(info);
        if (isFolderCell() && (pullForegroundDrawable = this.archivedChatsDrawable) != null && SharedConfig.archiveHidden && pullForegroundDrawable.pullProgress == 0.0f) {
            info.setVisibleToUser(false);
        } else {
            info.addAction(16);
            info.addAction(32);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        TLRPC$User user;
        super.onPopulateAccessibilityEvent(event);
        StringBuilder sb = new StringBuilder();
        if (this.currentDialogFolderId == 1) {
            sb.append(LocaleController.getString("ArchivedChats", R.string.ArchivedChats));
            sb.append(". ");
        } else {
            if (this.encryptedChat != null) {
                sb.append(LocaleController.getString("AccDescrSecretChat", R.string.AccDescrSecretChat));
                sb.append(". ");
            }
            TLRPC$User tLRPC$User = this.user;
            if (tLRPC$User != null) {
                if (UserObject.isReplyUser(tLRPC$User)) {
                    sb.append(LocaleController.getString("RepliesTitle", R.string.RepliesTitle));
                } else {
                    if (this.user.bot) {
                        sb.append(LocaleController.getString("Bot", R.string.Bot));
                        sb.append(". ");
                    }
                    TLRPC$User tLRPC$User2 = this.user;
                    if (tLRPC$User2.self) {
                        sb.append(LocaleController.getString("SavedMessages", R.string.SavedMessages));
                    } else {
                        sb.append(ContactsController.formatName(tLRPC$User2.first_name, tLRPC$User2.last_name));
                    }
                }
                sb.append(". ");
            } else {
                TLRPC$Chat tLRPC$Chat = this.chat;
                if (tLRPC$Chat != null) {
                    if (tLRPC$Chat.broadcast) {
                        sb.append(LocaleController.getString("AccDescrChannel", R.string.AccDescrChannel));
                    } else {
                        sb.append(LocaleController.getString("AccDescrGroup", R.string.AccDescrGroup));
                    }
                    sb.append(". ");
                    sb.append(this.chat.title);
                    sb.append(". ");
                }
            }
        }
        int i = this.unreadCount;
        if (i > 0) {
            sb.append(LocaleController.formatPluralString("NewMessages", i));
            sb.append(". ");
        }
        MessageObject messageObject = this.message;
        if (messageObject == null || this.currentDialogFolderId != 0) {
            event.setContentDescription(sb.toString());
            return;
        }
        int i2 = this.lastMessageDate;
        if (i2 == 0) {
            i2 = messageObject.messageOwner.date;
        }
        String dateAudio = LocaleController.formatDateAudio(i2, true);
        if (this.message.isOut()) {
            sb.append(LocaleController.formatString("AccDescrSentDate", R.string.AccDescrSentDate, dateAudio));
        } else {
            sb.append(LocaleController.formatString("AccDescrReceivedDate", R.string.AccDescrReceivedDate, dateAudio));
        }
        sb.append(". ");
        if (this.chat != null && !this.message.isOut() && this.message.isFromUser() && this.message.messageOwner.action == null && (user = MessagesController.getInstance(this.currentAccount).getUser(Long.valueOf(this.message.messageOwner.from_id.user_id))) != null) {
            sb.append(ContactsController.formatName(user.first_name, user.last_name));
            sb.append(". ");
        }
        if (this.encryptedChat == null) {
            sb.append(this.message.messageText);
            if (!this.message.isMediaEmpty() && !TextUtils.isEmpty(this.message.caption)) {
                sb.append(". ");
                sb.append(this.message.caption);
            }
        }
        event.setContentDescription(sb.toString());
    }

    public void setClipProgress(float value) {
        this.clipProgress = value;
        invalidate();
    }

    public float getClipProgress() {
        return this.clipProgress;
    }

    public void setTopClip(int value) {
        this.topClip = value;
    }

    public void setBottomClip(int value) {
        this.bottomClip = value;
    }

    public void setArchivedPullAnimation(PullForegroundDrawable drawable) {
        this.archivedChatsDrawable = drawable;
    }

    public int getCurrentDialogFolderId() {
        return this.currentDialogFolderId;
    }

    public MessageObject getMessage() {
        return this.message;
    }
}
