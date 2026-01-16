package org.rbmain.ui.Components.Reactions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$ReactionCount;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsNone;
import org.rbmain.tgnet.TLRPC$TL_messageReactions;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;
import org.rbmain.ui.Components.ReactionsContainerLayout;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class ChatSelectionReactionMenuOverlay extends FrameLayout {
    private float currentOffsetY;
    private MessageObject currentPrimaryObject;
    private boolean hiddenByScroll;
    private boolean isVisible;
    private long lastUpdate;
    private int mPadding;
    private int mSidePadding;
    private boolean messageSet;
    private ChatActivity parentFragment;
    private int[] pos;
    private ReactionsContainerLayout reactionsContainerLayout;
    private List<MessageObject> selectedMessages;
    private float toOffsetY;
    private float translationOffsetY;

    public ChatSelectionReactionMenuOverlay(ChatActivity chatActivity, Context context) {
        super(context);
        this.selectedMessages = Collections.emptyList();
        this.mPadding = 22;
        this.mSidePadding = 24;
        this.pos = new int[2];
        setVisibility(8);
        this.parentFragment = chatActivity;
        setClipToPadding(false);
        setClipChildren(false);
        chatActivity.getChatListView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.Reactions.ChatSelectionReactionMenuOverlay.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                ChatSelectionReactionMenuOverlay.this.invalidatePosition();
            }
        });
    }

    private void checkCreateReactionsLayout() {
        if (this.reactionsContainerLayout == null) {
            ReactionsContainerLayout reactionsContainerLayout = new ReactionsContainerLayout(this, this.parentFragment, getContext(), this.parentFragment.getCurrentAccount(), this.parentFragment.getResourceProvider()) { // from class: org.rbmain.ui.Components.Reactions.ChatSelectionReactionMenuOverlay.2
                float enabledAlpha = 1.0f;
                long lastUpdate;

                {
                    setWillNotDraw(false);
                }

                @Override // android.view.View
                public void draw(Canvas canvas) {
                    long jMin = Math.min(16L, System.currentTimeMillis() - this.lastUpdate);
                    this.lastUpdate = System.currentTimeMillis();
                    RectF rectF = AndroidUtilities.rectTmp;
                    rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                    canvas.saveLayerAlpha(rectF, (int) (this.enabledAlpha * 255.0f), 31);
                    super.draw(canvas);
                    canvas.restore();
                    if (!isEnabled()) {
                        float f = this.enabledAlpha;
                        if (f != 0.0f) {
                            this.enabledAlpha = Math.max(0.0f, f - (jMin / 150.0f));
                            invalidate();
                            if (this.enabledAlpha == 0.0f) {
                                setVisibility(8);
                                return;
                            }
                            return;
                        }
                    }
                    if (isEnabled()) {
                        float f2 = this.enabledAlpha;
                        if (f2 != 1.0f) {
                            this.enabledAlpha = Math.min(1.0f, f2 + (jMin / 150.0f));
                            invalidate();
                        }
                    }
                }

                @Override // android.view.View
                public void setVisibility(int i) {
                    super.setVisibility(i);
                    if (i != 8 || this.enabledAlpha == 0.0f) {
                        return;
                    }
                    this.enabledAlpha = 0.0f;
                }
            };
            this.reactionsContainerLayout = reactionsContainerLayout;
            reactionsContainerLayout.setPadding(AndroidUtilities.dp(4.0f) + (LocaleController.isRTL ? 0 : this.mSidePadding), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f) + (LocaleController.isRTL ? this.mSidePadding : 0), AndroidUtilities.dp(this.mPadding));
            this.reactionsContainerLayout.setDelegate(new AnonymousClass3());
            this.reactionsContainerLayout.setClipChildren(false);
            this.reactionsContainerLayout.setClipToPadding(false);
            addView(this.reactionsContainerLayout, LayoutHelper.createFrame(-2, this.mPadding + 70, 5));
        }
    }

    /* renamed from: org.rbmain.ui.Components.Reactions.ChatSelectionReactionMenuOverlay$3, reason: invalid class name */
    class AnonymousClass3 implements ReactionsContainerLayout.ReactionsContainerDelegate {
        AnonymousClass3() {
        }

        @Override // org.rbmain.ui.Components.ReactionsContainerLayout.ReactionsContainerDelegate
        public void onReactionClicked(View view, ReactionsLayoutInBubble.VisibleReaction visibleReaction, boolean z, boolean z2) {
            ChatSelectionReactionMenuOverlay.this.parentFragment.selectReaction(ChatSelectionReactionMenuOverlay.this.currentPrimaryObject, ChatSelectionReactionMenuOverlay.this.reactionsContainerLayout, view, 0.0f, 0.0f, visibleReaction, false, z, z2);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.Reactions.ChatSelectionReactionMenuOverlay$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws SAXException, IOException {
                    this.f$0.lambda$onReactionClicked$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReactionClicked$0() throws SAXException, IOException {
            if (ChatSelectionReactionMenuOverlay.this.reactionsContainerLayout != null) {
                ChatSelectionReactionMenuOverlay.this.reactionsContainerLayout.dismissParent(true);
            }
            hideMenu();
        }

        public void hideMenu() throws SAXException, IOException {
            ChatSelectionReactionMenuOverlay.this.parentFragment.clearSelectionMode(true);
        }
    }

    public boolean isVisible() {
        return this.isVisible && !this.hiddenByScroll;
    }

    public void invalidatePosition() {
        invalidatePosition(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0177 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void invalidatePosition(boolean r13) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.Reactions.ChatSelectionReactionMenuOverlay.invalidatePosition(boolean):void");
    }

    private MessageObject findPrimaryObject() {
        MessageObject.GroupedMessages group;
        ArrayList<MessageObject> arrayList;
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions;
        ArrayList<TLRPC$ReactionCount> arrayList2;
        if (!this.isVisible || this.selectedMessages.isEmpty()) {
            return null;
        }
        MessageObject messageObject = this.selectedMessages.get(0);
        if (messageObject.getGroupId() != 0 && (group = this.parentFragment.getGroup(messageObject.getGroupId())) != null && (arrayList = group.messages) != null) {
            Iterator<MessageObject> it = arrayList.iterator();
            while (it.hasNext()) {
                MessageObject next = it.next();
                TLRPC$Message tLRPC$Message = next.messageOwner;
                if (tLRPC$Message != null && (tLRPC$TL_messageReactions = tLRPC$Message.reactions) != null && (arrayList2 = tLRPC$TL_messageReactions.results) != null && !arrayList2.isEmpty()) {
                    return next;
                }
            }
        }
        return messageObject;
    }

    private boolean isMessageTypeAllowed(MessageObject messageObject) {
        return (MessageObject.isPhoto(messageObject.messageOwner) && MessageObject.getMedia(messageObject.messageOwner).webpage == null) || (messageObject.getDocument() != null && (MessageObject.isVideoDocument(messageObject.getDocument()) || MessageObject.isGifDocument(messageObject.getDocument())));
    }

    public void setSelectedMessages(List<MessageObject> list) {
        this.selectedMessages = list;
        boolean z = true;
        if (this.parentFragment.isSecretChat() || ((this.parentFragment.getCurrentChatInfo() != null && (this.parentFragment.getCurrentChatInfo().available_reactions instanceof TLRPC$TL_chatReactionsNone)) || list.isEmpty())) {
            z = false;
            break;
        }
        long groupId = 0;
        boolean z2 = false;
        for (MessageObject messageObject : list) {
            if (isMessageTypeAllowed(messageObject)) {
                if (!z2) {
                    groupId = messageObject.getGroupId();
                    z2 = true;
                } else if (groupId != messageObject.getGroupId() || groupId == 0) {
                }
            }
            z = false;
        }
        if (z != this.isVisible) {
            this.isVisible = z;
            this.hiddenByScroll = false;
            animateVisible(z);
        } else if (z) {
            this.currentPrimaryObject = findPrimaryObject();
        }
    }

    private void animateVisible(boolean z) {
        if (z) {
            this.currentPrimaryObject = findPrimaryObject();
            checkCreateReactionsLayout();
            invalidatePosition(false);
            setVisibility(0);
            if (this.reactionsContainerLayout.isEnabled()) {
                this.messageSet = true;
                this.reactionsContainerLayout.setMessage(this.currentPrimaryObject, this.parentFragment.getCurrentChatInfo());
                this.reactionsContainerLayout.startEnterAnimation(false);
                return;
            } else {
                this.messageSet = false;
                this.reactionsContainerLayout.setTransitionProgress(1.0f);
                return;
            }
        }
        this.messageSet = false;
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(150L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.Reactions.ChatSelectionReactionMenuOverlay$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$animateVisible$0(valueAnimator);
            }
        });
        duration.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.Reactions.ChatSelectionReactionMenuOverlay.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ChatSelectionReactionMenuOverlay.this.setVisibility(8);
                if (ChatSelectionReactionMenuOverlay.this.reactionsContainerLayout != null) {
                    ChatSelectionReactionMenuOverlay chatSelectionReactionMenuOverlay = ChatSelectionReactionMenuOverlay.this;
                    chatSelectionReactionMenuOverlay.removeView(chatSelectionReactionMenuOverlay.reactionsContainerLayout);
                    ChatSelectionReactionMenuOverlay.this.reactionsContainerLayout = null;
                }
                ChatSelectionReactionMenuOverlay.this.currentPrimaryObject = null;
            }
        });
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateVisible$0(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ReactionsContainerLayout reactionsContainerLayout = this.reactionsContainerLayout;
        if (reactionsContainerLayout != null) {
            reactionsContainerLayout.setAlpha(fFloatValue);
        }
    }

    public boolean onBackPressed() {
        ReactionsContainerLayout reactionsContainerLayout = this.reactionsContainerLayout;
        if (reactionsContainerLayout == null || reactionsContainerLayout.getReactionsWindow() == null) {
            return true;
        }
        this.reactionsContainerLayout.dismissWindow();
        return false;
    }

    public void setHiddenByScroll(boolean z) {
        this.hiddenByScroll = z;
        if (z) {
            animateVisible(false);
        }
    }
}
