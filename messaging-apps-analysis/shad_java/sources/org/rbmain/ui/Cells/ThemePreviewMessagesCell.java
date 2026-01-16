package org.rbmain.ui.Cells;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.style.CharacterStyle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.IOException;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$KeyboardButton;
import org.rbmain.tgnet.TLRPC$ReactionCount;
import org.rbmain.tgnet.TLRPC$TL_message;
import org.rbmain.tgnet.TLRPC$TL_messageEntityCustomEmoji;
import org.rbmain.tgnet.TLRPC$TL_messageEntityTextUrl;
import org.rbmain.tgnet.TLRPC$TL_messageMediaEmpty;
import org.rbmain.tgnet.TLRPC$TL_messageReplyHeader;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBarLayout;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.ChatMessageCell;
import org.rbmain.ui.Cells.TextSelectionHelper;
import org.rbmain.ui.Components.AnimatedEmojiSpan;
import org.rbmain.ui.Components.BackgroundGradientDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.MotionBackgroundDrawable;
import org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;
import org.rbmain.ui.PinchToZoomHelper;
import org.xml.sax.SAXException;

/* loaded from: classes4.dex */
public class ThemePreviewMessagesCell extends LinearLayout {
    private Drawable backgroundDrawable;
    private BackgroundGradientDrawable.Disposable backgroundGradientDisposable;
    private ChatMessageCell[] cells;
    public BaseFragment fragment;
    private Drawable oldBackgroundDrawable;
    private BackgroundGradientDrawable.Disposable oldBackgroundGradientDisposable;
    private ActionBarLayout parentLayout;
    private Drawable shadowDrawable;
    private final int type;

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    public ThemePreviewMessagesCell(Context context, ActionBarLayout actionBarLayout, int i) throws SAXException, IOException {
        int i2;
        MessageObject messageObject;
        MessageObject messageObject2;
        super(context);
        new Runnable() { // from class: org.rbmain.ui.Cells.ThemePreviewMessagesCell$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.invalidate();
            }
        };
        this.cells = new ChatMessageCell[2];
        this.type = i;
        int i3 = UserConfig.selectedAccount;
        this.parentLayout = actionBarLayout;
        setWillNotDraw(false);
        setOrientation(1);
        setPadding(0, AndroidUtilities.dp(11.0f), 0, AndroidUtilities.dp(11.0f));
        this.shadowDrawable = Theme.getThemedDrawableByKey(context, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow);
        int iCurrentTimeMillis = ((int) (System.currentTimeMillis() / 1000)) - 3600;
        if (i == 2) {
            TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
            tLRPC$TL_message.message = LocaleController.getString("DoubleTapPreviewMessage", R.string.DoubleTapPreviewMessage);
            tLRPC$TL_message.date = iCurrentTimeMillis + 60;
            tLRPC$TL_message.dialog_id = 1L;
            tLRPC$TL_message.flags = 259;
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
            tLRPC$TL_message.id = 1L;
            tLRPC$TL_message.media = new TLRPC$TL_messageMediaEmpty();
            tLRPC$TL_message.out = false;
            TLRPC$TL_peerUser tLRPC$TL_peerUser2 = new TLRPC$TL_peerUser();
            tLRPC$TL_message.peer_id = tLRPC$TL_peerUser2;
            tLRPC$TL_peerUser2.user_id = 0;
            MessageObject messageObject3 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message, true, false);
            messageObject3.resetLayout();
            messageObject3.eventId = 1L;
            messageObject3.customName = LocaleController.getString("DoubleTapPreviewSenderName", R.string.DoubleTapPreviewSenderName);
            messageObject3.customAvatarDrawable = ContextCompat.getDrawable(context, R.drawable.dino_pic);
            messageObject = messageObject3;
            i2 = i3;
            messageObject2 = null;
        } else {
            TLRPC$TL_message tLRPC$TL_message2 = new TLRPC$TL_message();
            if (i == 0) {
                tLRPC$TL_message2.message = LocaleController.getString("FontSizePreviewReply", R.string.FontSizePreviewReply);
            } else {
                tLRPC$TL_message2.message = LocaleController.getString("NewThemePreviewReply", R.string.NewThemePreviewReply);
            }
            int iIndexOf = tLRPC$TL_message2.message.indexOf("👋");
            if (iIndexOf >= 0) {
                TLRPC$TL_messageEntityCustomEmoji tLRPC$TL_messageEntityCustomEmoji = new TLRPC$TL_messageEntityCustomEmoji();
                tLRPC$TL_messageEntityCustomEmoji.offset = iIndexOf;
                tLRPC$TL_messageEntityCustomEmoji.length = 2;
                i2 = i3;
                tLRPC$TL_messageEntityCustomEmoji.document_id = 5386654653003864312L;
                tLRPC$TL_message2.entities.add(tLRPC$TL_messageEntityCustomEmoji);
            } else {
                i2 = i3;
            }
            int i4 = iCurrentTimeMillis + 60;
            tLRPC$TL_message2.date = i4;
            tLRPC$TL_message2.dialog_id = 1L;
            tLRPC$TL_message2.flags = 259;
            TLRPC$TL_peerUser tLRPC$TL_peerUser3 = new TLRPC$TL_peerUser();
            tLRPC$TL_message2.from_id = tLRPC$TL_peerUser3;
            tLRPC$TL_peerUser3.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
            tLRPC$TL_message2.id = 1L;
            tLRPC$TL_message2.media = new TLRPC$TL_messageMediaEmpty();
            tLRPC$TL_message2.out = true;
            TLRPC$TL_peerUser tLRPC$TL_peerUser4 = new TLRPC$TL_peerUser();
            tLRPC$TL_message2.peer_id = tLRPC$TL_peerUser4;
            tLRPC$TL_peerUser4.user_id = 0;
            MessageObject messageObject4 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message2, true, false);
            TLRPC$TL_message tLRPC$TL_message3 = new TLRPC$TL_message();
            if (i == 0) {
                tLRPC$TL_message3.message = LocaleController.getString("FontSizePreviewLine2", R.string.FontSizePreviewLine2);
            } else {
                String string = LocaleController.getString("NewThemePreviewLine3", R.string.NewThemePreviewLine3);
                StringBuilder sb = new StringBuilder(string);
                int iIndexOf2 = string.indexOf(42);
                int iLastIndexOf = string.lastIndexOf(42);
                if (iIndexOf2 != -1 && iLastIndexOf != -1) {
                    sb.replace(iLastIndexOf, iLastIndexOf + 1, BuildConfig.FLAVOR);
                    sb.replace(iIndexOf2, iIndexOf2 + 1, BuildConfig.FLAVOR);
                    TLRPC$TL_messageEntityTextUrl tLRPC$TL_messageEntityTextUrl = new TLRPC$TL_messageEntityTextUrl();
                    tLRPC$TL_messageEntityTextUrl.offset = iIndexOf2;
                    tLRPC$TL_messageEntityTextUrl.length = (iLastIndexOf - iIndexOf2) - 1;
                    tLRPC$TL_messageEntityTextUrl.url = "https://rubika.ir";
                    tLRPC$TL_message3.entities.add(tLRPC$TL_messageEntityTextUrl);
                }
                tLRPC$TL_message3.message = sb.toString();
            }
            int iIndexOf3 = tLRPC$TL_message3.message.indexOf("😎");
            if (iIndexOf3 >= 0) {
                TLRPC$TL_messageEntityCustomEmoji tLRPC$TL_messageEntityCustomEmoji2 = new TLRPC$TL_messageEntityCustomEmoji();
                tLRPC$TL_messageEntityCustomEmoji2.offset = iIndexOf3;
                tLRPC$TL_messageEntityCustomEmoji2.length = 2;
                tLRPC$TL_messageEntityCustomEmoji2.document_id = 5373141891321699086L;
            }
            tLRPC$TL_message3.date = iCurrentTimeMillis + 960;
            tLRPC$TL_message3.dialog_id = 1L;
            tLRPC$TL_message3.flags = 259;
            TLRPC$TL_peerUser tLRPC$TL_peerUser5 = new TLRPC$TL_peerUser();
            tLRPC$TL_message3.from_id = tLRPC$TL_peerUser5;
            tLRPC$TL_peerUser5.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
            tLRPC$TL_message3.id = 1L;
            tLRPC$TL_message3.media = new TLRPC$TL_messageMediaEmpty();
            tLRPC$TL_message3.out = true;
            TLRPC$TL_peerUser tLRPC$TL_peerUser6 = new TLRPC$TL_peerUser();
            tLRPC$TL_message3.peer_id = tLRPC$TL_peerUser6;
            tLRPC$TL_peerUser6.user_id = 0;
            MessageObject messageObject5 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message3, true, false);
            messageObject5.resetLayout();
            messageObject5.eventId = 1L;
            TLRPC$TL_message tLRPC$TL_message4 = new TLRPC$TL_message();
            if (i == 0) {
                tLRPC$TL_message4.message = LocaleController.getString("FontSizePreviewLine1", R.string.FontSizePreviewLine1);
            } else {
                tLRPC$TL_message4.message = LocaleController.getString("NewThemePreviewLine1", R.string.NewThemePreviewLine1);
            }
            tLRPC$TL_message4.date = i4;
            tLRPC$TL_message4.dialog_id = 1L;
            tLRPC$TL_message4.flags = 265;
            tLRPC$TL_message4.from_id = new TLRPC$TL_peerUser();
            tLRPC$TL_message4.id = 1L;
            TLRPC$TL_messageReplyHeader tLRPC$TL_messageReplyHeader = new TLRPC$TL_messageReplyHeader();
            tLRPC$TL_message4.reply_to = tLRPC$TL_messageReplyHeader;
            tLRPC$TL_messageReplyHeader.reply_to_msg_id = 5L;
            tLRPC$TL_message4.media = new TLRPC$TL_messageMediaEmpty();
            tLRPC$TL_message4.out = false;
            TLRPC$TL_peerUser tLRPC$TL_peerUser7 = new TLRPC$TL_peerUser();
            tLRPC$TL_message4.peer_id = tLRPC$TL_peerUser7;
            tLRPC$TL_peerUser7.user_id = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
            MessageObject messageObject6 = new MessageObject(UserConfig.selectedAccount, tLRPC$TL_message4, true, false);
            if (i == 0) {
                messageObject6.customReplyName = LocaleController.getString("FontSizePreviewName", R.string.FontSizePreviewName);
            } else {
                messageObject6.customReplyName = LocaleController.getString("NewThemePreviewName", R.string.NewThemePreviewName);
            }
            messageObject6.eventId = 1L;
            messageObject6.resetLayout();
            messageObject6.replyMessageObject = messageObject4;
            messageObject = messageObject5;
            messageObject2 = messageObject6;
        }
        int i5 = 0;
        while (true) {
            ChatMessageCell[] chatMessageCellArr = this.cells;
            if (i5 >= chatMessageCellArr.length) {
                return;
            }
            chatMessageCellArr[i5] = new ChatMessageCell(context, context, i2, i) { // from class: org.rbmain.ui.Cells.ThemePreviewMessagesCell.1
                private GestureDetector gestureDetector;
                final /* synthetic */ Context val$context;
                final /* synthetic */ int val$currentAccount;
                final /* synthetic */ int val$type;

                /* renamed from: org.rbmain.ui.Cells.ThemePreviewMessagesCell$1$1, reason: invalid class name and collision with other inner class name */
                class C00691 extends GestureDetector.SimpleOnGestureListener {
                    C00691() {
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onDoubleTap(MotionEvent motionEvent) throws SAXException, IOException {
                        if (MediaDataController.getInstance(AnonymousClass1.this.val$currentAccount).getDoubleTapReaction() == null) {
                            return false;
                        }
                        boolean zSelectReaction = getMessageObject().selectReaction(ReactionsLayoutInBubble.VisibleReaction.fromEmojicon(MediaDataController.getInstance(AnonymousClass1.this.val$currentAccount).getDoubleTapReaction()), false, false);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.setMessageObject(anonymousClass1.getMessageObject(), null, false, false);
                        requestLayout();
                        ReactionsEffectOverlay.removeCurrent(false);
                        if (zSelectReaction) {
                            ThemePreviewMessagesCell themePreviewMessagesCell = ThemePreviewMessagesCell.this;
                            ReactionsEffectOverlay.show(themePreviewMessagesCell.fragment, null, themePreviewMessagesCell.cells[1], null, motionEvent.getX(), motionEvent.getY(), ReactionsLayoutInBubble.VisibleReaction.fromEmojicon(MediaDataController.getInstance(AnonymousClass1.this.val$currentAccount).getDoubleTapReaction()), AnonymousClass1.this.val$currentAccount, 0);
                            ReactionsEffectOverlay.startAnimation();
                        }
                        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC00701());
                        return true;
                    }

                    /* renamed from: org.rbmain.ui.Cells.ThemePreviewMessagesCell$1$1$1, reason: invalid class name and collision with other inner class name */
                    class ViewTreeObserverOnPreDrawListenerC00701 implements ViewTreeObserver.OnPreDrawListener {
                        ViewTreeObserverOnPreDrawListenerC00701() {
                        }

                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public boolean onPreDraw() {
                            getViewTreeObserver().removeOnPreDrawListener(this);
                            getTransitionParams().resetAnimation();
                            getTransitionParams().animateChange();
                            getTransitionParams().animateChange = true;
                            getTransitionParams().animateChangeProgress = 0.0f;
                            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Cells.ThemePreviewMessagesCell$1$1$1$$ExternalSyntheticLambda0
                                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    this.f$0.lambda$onPreDraw$0(valueAnimator);
                                }
                            });
                            valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Cells.ThemePreviewMessagesCell.1.1.1.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    super.onAnimationEnd(animator);
                                    getTransitionParams().resetAnimation();
                                    getTransitionParams().animateChange = false;
                                    getTransitionParams().animateChangeProgress = 1.0f;
                                }
                            });
                            valueAnimatorOfFloat.start();
                            return false;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public /* synthetic */ void lambda$onPreDraw$0(ValueAnimator valueAnimator) {
                            getTransitionParams().animateChangeProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            invalidate();
                        }
                    }
                }

                {
                    this.val$context = context;
                    this.val$currentAccount = i2;
                    this.val$type = i;
                    this.gestureDetector = new GestureDetector(context, new C00691());
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell, android.view.View
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    this.gestureDetector.onTouchEvent(motionEvent);
                    return true;
                }

                @Override // android.view.ViewGroup, android.view.View
                protected void dispatchDraw(Canvas canvas) {
                    if (getAvatarImage() != null && getAvatarImage().getImageHeight() != 0.0f) {
                        getAvatarImage().setImageCoords(getAvatarImage().getImageX(), (getMeasuredHeight() - getAvatarImage().getImageHeight()) - AndroidUtilities.dp(4.0f), getAvatarImage().getImageWidth(), getAvatarImage().getImageHeight());
                        getAvatarImage().setRoundRadius((int) (getAvatarImage().getImageHeight() / 2.0f));
                        getAvatarImage().draw(canvas);
                    } else if (this.val$type == 2) {
                        invalidate();
                    }
                    super.dispatchDraw(canvas);
                }
            };
            this.cells[i5].setDelegate(new ChatMessageCell.ChatMessageCellDelegate(this) { // from class: org.rbmain.ui.Cells.ThemePreviewMessagesCell.2
                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean canDrawOutboundsContent() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$canDrawOutboundsContent(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean canPerformActions() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$canPerformActions(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didLongPress(ChatMessageCell chatMessageCell, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPress(this, chatMessageCell, f, f2);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didLongPressBotButton(ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressBotButton(this, chatMessageCell, tLRPC$KeyboardButton);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean didLongPressChannelAvatar(ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, long j, float f, float f2) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressChannelAvatar(this, chatMessageCell, tLRPC$Chat, j, f, f2);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean didLongPressUserAvatar(ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, float f, float f2) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didLongPressUserAvatar(this, chatMessageCell, tLRPC$User, f, f2);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean didPressAnimatedEmoji(ChatMessageCell chatMessageCell, AnimatedEmojiSpan animatedEmojiSpan) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressAnimatedEmoji(this, chatMessageCell, animatedEmojiSpan);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressBotButton(ChatMessageCell chatMessageCell, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressBotButton(this, chatMessageCell, tLRPC$KeyboardButton);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressCancelSendButton(ChatMessageCell chatMessageCell) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressCancelSendButton(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressChannelAvatar(ChatMessageCell chatMessageCell, TLRPC$Chat tLRPC$Chat, long j, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressChannelAvatar(this, chatMessageCell, tLRPC$Chat, j, f, f2);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressCommentButton(ChatMessageCell chatMessageCell) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressCommentButton(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressHiddenForward(ChatMessageCell chatMessageCell) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHiddenForward(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressHint(ChatMessageCell chatMessageCell, int i6) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressHint(this, chatMessageCell, i6);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressImage(ChatMessageCell chatMessageCell, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressImage(this, chatMessageCell, f, f2);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressInstantButton(ChatMessageCell chatMessageCell, int i6) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressInstantButton(this, chatMessageCell, i6);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressOther(ChatMessageCell chatMessageCell, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressOther(this, chatMessageCell, f, f2);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressReaction(ChatMessageCell chatMessageCell, TLRPC$ReactionCount tLRPC$ReactionCount, boolean z) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressReaction(this, chatMessageCell, tLRPC$ReactionCount, z);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressReplyMessage(ChatMessageCell chatMessageCell, long j) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressReplyMessage(this, chatMessageCell, j);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressSideButton(ChatMessageCell chatMessageCell) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressSideButton(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressTime(ChatMessageCell chatMessageCell) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressTime(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressUrl(ChatMessageCell chatMessageCell, CharacterStyle characterStyle, boolean z) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressUrl(this, chatMessageCell, characterStyle, z);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressUserAvatar(ChatMessageCell chatMessageCell, TLRPC$User tLRPC$User, float f, float f2) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressUserAvatar(this, chatMessageCell, tLRPC$User, f, f2);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressViaBot(ChatMessageCell chatMessageCell, String str) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressViaBot(this, chatMessageCell, str);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressViaBotNotInline(ChatMessageCell chatMessageCell, int i6) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressViaBotNotInline(this, chatMessageCell, i6);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressVoteButtons(ChatMessageCell chatMessageCell, ArrayList arrayList, int i6, int i7, int i8) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressVoteButtons(this, chatMessageCell, arrayList, i6, i7, i8);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didPressedForwardedFrom(ChatMessageCell chatMessageCell) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didPressedForwardedFrom(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void didStartVideoStream(MessageObject messageObject7) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$didStartVideoStream(this, messageObject7);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ String getAdminRank(int i6) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getAdminRank(this, i6);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ PinchToZoomHelper getPinchToZoomHelper() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getPinchToZoomHelper(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ String getProgressLoadingBotButtonUrl(ChatMessageCell chatMessageCell) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getProgressLoadingBotButtonUrl(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ CharacterStyle getProgressLoadingLink(ChatMessageCell chatMessageCell) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getProgressLoadingLink(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$getTextSelectionHelper(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean hasSelectedMessages() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$hasSelectedMessages(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void invalidateBlur() {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$invalidateBlur(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean isLandscape() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$isLandscape(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean isProgressLoading(ChatMessageCell chatMessageCell, int i6) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$isProgressLoading(this, chatMessageCell, i6);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean isReplyOrSelf() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$isReplyOrSelf(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean keyboardIsOpened() {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$keyboardIsOpened(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void needOpenWebView(MessageObject messageObject7, String str, String str2, String str3, String str4, int i6, int i7) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$needOpenWebView(this, messageObject7, str, str2, str3, str4, i6, i7);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean needPlayMessage(MessageObject messageObject7, boolean z) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$needPlayMessage(this, messageObject7, z);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void needReloadPolls() {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$needReloadPolls(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void needShowPremiumBulletin(int i6) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$needShowPremiumBulletin(this, i6);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean onAccessibilityAction(int i6, Bundle bundle) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$onAccessibilityAction(this, i6, bundle);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void onDiceFinished() {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$onDiceFinished(this);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void setShouldNotRepeatSticker(MessageObject messageObject7) {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$setShouldNotRepeatSticker(this, messageObject7);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean shouldDrawThreadProgress(ChatMessageCell chatMessageCell) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldDrawThreadProgress(this, chatMessageCell);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ boolean shouldRepeatSticker(MessageObject messageObject7) {
                    return ChatMessageCell.ChatMessageCellDelegate.CC.$default$shouldRepeatSticker(this, messageObject7);
                }

                @Override // org.rbmain.ui.Cells.ChatMessageCell.ChatMessageCellDelegate
                public /* synthetic */ void videoTimerReached() {
                    ChatMessageCell.ChatMessageCellDelegate.CC.$default$videoTimerReached(this);
                }
            });
            ChatMessageCell[] chatMessageCellArr2 = this.cells;
            chatMessageCellArr2[i5].isChat = i == 2;
            chatMessageCellArr2[i5].setFullyDraw(true);
            MessageObject messageObject7 = i5 == 0 ? messageObject2 : messageObject;
            if (messageObject7 != null) {
                this.cells[i5].setMessageObject(messageObject7, null, false, false);
                addView(this.cells[i5], LayoutHelper.createLinear(-1, -2));
            }
            i5++;
        }
    }

    public ChatMessageCell[] getCells() {
        return this.cells;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        int i = 0;
        while (true) {
            ChatMessageCell[] chatMessageCellArr = this.cells;
            if (i >= chatMessageCellArr.length) {
                return;
            }
            chatMessageCellArr[i].invalidate();
            i++;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable cachedWallpaperNonBlocking = Theme.getCachedWallpaperNonBlocking();
        if (Theme.wallpaperLoadTask != null) {
            invalidate();
        }
        if (cachedWallpaperNonBlocking != this.backgroundDrawable && cachedWallpaperNonBlocking != null) {
            if (Theme.isAnimatingColor()) {
                this.oldBackgroundDrawable = this.backgroundDrawable;
                this.oldBackgroundGradientDisposable = this.backgroundGradientDisposable;
            } else {
                BackgroundGradientDrawable.Disposable disposable = this.backgroundGradientDisposable;
                if (disposable != null) {
                    disposable.dispose();
                    this.backgroundGradientDisposable = null;
                }
            }
            this.backgroundDrawable = cachedWallpaperNonBlocking;
        }
        float themeAnimationValue = this.parentLayout.getThemeAnimationValue();
        int i = 0;
        while (i < 2) {
            Drawable drawable = i == 0 ? this.oldBackgroundDrawable : this.backgroundDrawable;
            if (drawable != null) {
                int i2 = (i != 1 || this.oldBackgroundDrawable == null || this.parentLayout == null) ? 255 : (int) (255.0f * themeAnimationValue);
                if (i2 > 0) {
                    drawable.setAlpha(i2);
                    if ((drawable instanceof ColorDrawable) || (drawable instanceof GradientDrawable) || (drawable instanceof MotionBackgroundDrawable)) {
                        drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                        if (drawable instanceof BackgroundGradientDrawable) {
                            this.backgroundGradientDisposable = ((BackgroundGradientDrawable) drawable).drawExactBoundsSize(canvas, this);
                        } else {
                            drawable.draw(canvas);
                        }
                    } else if (drawable instanceof BitmapDrawable) {
                        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                        bitmapDrawable.setFilterBitmap(true);
                        if (bitmapDrawable.getTileModeX() == Shader.TileMode.REPEAT) {
                            canvas.save();
                            float f = 2.0f / AndroidUtilities.density;
                            canvas.scale(f, f);
                            drawable.setBounds(0, 0, (int) Math.ceil(getMeasuredWidth() / f), (int) Math.ceil(getMeasuredHeight() / f));
                        } else {
                            int measuredHeight = getMeasuredHeight();
                            float fMax = Math.max(getMeasuredWidth() / drawable.getIntrinsicWidth(), measuredHeight / drawable.getIntrinsicHeight());
                            int iCeil = (int) Math.ceil(drawable.getIntrinsicWidth() * fMax);
                            int iCeil2 = (int) Math.ceil(drawable.getIntrinsicHeight() * fMax);
                            int measuredWidth = (getMeasuredWidth() - iCeil) / 2;
                            int i3 = (measuredHeight - iCeil2) / 2;
                            canvas.save();
                            canvas.clipRect(0, 0, iCeil, getMeasuredHeight());
                            drawable.setBounds(measuredWidth, i3, iCeil + measuredWidth, iCeil2 + i3);
                        }
                        drawable.draw(canvas);
                        canvas.restore();
                    }
                    if (i == 0 && this.oldBackgroundDrawable != null && themeAnimationValue >= 1.0f) {
                        BackgroundGradientDrawable.Disposable disposable2 = this.oldBackgroundGradientDisposable;
                        if (disposable2 != null) {
                            disposable2.dispose();
                            this.oldBackgroundGradientDisposable = null;
                        }
                        this.oldBackgroundDrawable = null;
                        invalidate();
                    }
                }
            }
            i++;
        }
        this.shadowDrawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        this.shadowDrawable.draw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BackgroundGradientDrawable.Disposable disposable = this.backgroundGradientDisposable;
        if (disposable != null) {
            disposable.dispose();
            this.backgroundGradientDisposable = null;
        }
        BackgroundGradientDrawable.Disposable disposable2 = this.oldBackgroundGradientDisposable;
        if (disposable2 != null) {
            disposable2.dispose();
            this.oldBackgroundGradientDisposable = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.type == 2) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.type == 2) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.type == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
