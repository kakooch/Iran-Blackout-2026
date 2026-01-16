package org.rbmain.ui.Components;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messageActionChatJoinedByRequest;
import org.rbmain.tgnet.TLRPC$TL_messageReactions;
import org.rbmain.tgnet.TLRPC$TL_messages_getMessageReactionsList;
import org.rbmain.tgnet.TLRPC$TL_messages_getMessageReadParticipants;
import org.rbmain.tgnet.TLRPC$TL_messages_messageReactionsList;
import org.rbmain.tgnet.TLRPC$TL_readParticipantDate;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$Vector;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class ReactedHeaderView extends FrameLayout {
    private AvatarsImageView avatarsImageView;
    private int currentAccount;
    private int fixedWidth;
    private FlickerLoadingView flickerLoadingView;
    private ImageView iconView;
    private boolean ignoreLayout;
    private boolean isLoaded;
    private MessageObject message;
    private BackupImageView reactView;
    private Consumer<List<UserSeen>> seenCallback;
    private List<UserSeen> seenUsers;
    private TextView titleView;
    private List<UserSeen> users;

    public ReactedHeaderView(Context context, int i, MessageObject messageObject, long j) {
        super(context);
        this.seenUsers = new ArrayList();
        this.users = new ArrayList();
        this.currentAccount = i;
        this.message = messageObject;
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        this.flickerLoadingView = flickerLoadingView;
        flickerLoadingView.setColors(Theme.key_actionBarDefaultSubmenuBackground, Theme.key_listSelector, -1);
        this.flickerLoadingView.setViewType(13);
        this.flickerLoadingView.setIsSingleCell(false);
        addView(this.flickerLoadingView, LayoutHelper.createFrame(-2, -1.0f));
        TextView textView = new TextView(context);
        this.titleView = textView;
        textView.setTextColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuItem));
        this.titleView.setTextSize(1, 16.0f);
        this.titleView.setLines(1);
        this.titleView.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.titleView, LayoutHelper.createFrameRelatively(-2.0f, -2.0f, 8388627, 40.0f, 0.0f, 62.0f, 0.0f));
        AvatarsImageView avatarsImageView = new AvatarsImageView(context, false);
        this.avatarsImageView = avatarsImageView;
        avatarsImageView.setStyle(11);
        this.avatarsImageView.setAvatarsTextSize(AndroidUtilities.dp(22.0f));
        addView(this.avatarsImageView, LayoutHelper.createFrameRelatively(56.0f, -1.0f, 8388629, 0.0f, 0.0f, 0.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        this.iconView = imageView;
        addView(imageView, LayoutHelper.createFrameRelatively(24.0f, 24.0f, 8388627, 11.0f, 0.0f, 0.0f, 0.0f));
        Drawable drawableMutate = ContextCompat.getDrawable(context, R.drawable.msg_reactions).mutate();
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_actionBarDefaultSubmenuItemIcon), PorterDuff.Mode.MULTIPLY));
        this.iconView.setImageDrawable(drawableMutate);
        this.iconView.setVisibility(8);
        BackupImageView backupImageView = new BackupImageView(context);
        this.reactView = backupImageView;
        addView(backupImageView, LayoutHelper.createFrameRelatively(24.0f, 24.0f, 8388627, 11.0f, 0.0f, 0.0f, 0.0f));
        this.titleView.setAlpha(0.0f);
        this.avatarsImageView.setAlpha(0.0f);
        setBackground(Theme.getSelectorDrawable(false));
    }

    public void setSeenCallback(Consumer<List<UserSeen>> consumer) {
        this.seenCallback = consumer;
    }

    public static class UserSeen {
        public int date;
        public TLRPC$User user;

        public UserSeen(TLRPC$User tLRPC$User, int i) {
            this.date = 0;
            this.user = tLRPC$User;
            this.date = i;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isLoaded) {
            return;
        }
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        TLRPC$Chat chat = messagesController.getChat(Integer.valueOf(this.message.getChatId()));
        TLRPC$ChatFull chatFull = messagesController.getChatFull(this.message.getChatId());
        if ((chat == null || !this.message.isOutOwner() || !this.message.isSent() || this.message.isEditing() || this.message.isSending() || this.message.isSendError() || this.message.isContentUnread() || this.message.isUnread() || ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() - this.message.messageOwner.date >= 604800 || (!ChatObject.isMegagroup(chat) && ChatObject.isChannel(chat)) || chatFull == null || chatFull.participants_count > MessagesController.getInstance(this.currentAccount).chatReadMarkSizeThreshold || (this.message.messageOwner.action instanceof TLRPC$TL_messageActionChatJoinedByRequest)) ? false : true) {
            TLRPC$TL_messages_getMessageReadParticipants tLRPC$TL_messages_getMessageReadParticipants = new TLRPC$TL_messages_getMessageReadParticipants();
            tLRPC$TL_messages_getMessageReadParticipants.msg_id = this.message.getId();
            tLRPC$TL_messages_getMessageReadParticipants.peer = MessagesController.getInstance(this.currentAccount).getInputPeer((int) this.message.getDialogId());
            final long j = this.message.messageOwner.from_id != null ? r1.user_id : 0L;
            AccountInstance.getInstance(this.currentAccount).getMessageProxy().getMessageSeen(tLRPC$TL_messages_getMessageReadParticipants, new RequestDelegate() { // from class: org.rbmain.ui.Components.ReactedHeaderView$$ExternalSyntheticLambda4
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onAttachedToWindow$1(j, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        loadReactions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$1(long j, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$Vector) {
            ArrayList<Long> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<Object> it = ((TLRPC$Vector) tLObject).objects.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof Long) {
                    long jLongValue = ((Long) next).longValue();
                    if (j != jLongValue) {
                        arrayList.add(Long.valueOf(jLongValue));
                        arrayList2.add(0);
                    }
                } else if (next instanceof TLRPC$TL_readParticipantDate) {
                    TLRPC$TL_readParticipantDate tLRPC$TL_readParticipantDate = (TLRPC$TL_readParticipantDate) next;
                    long j2 = tLRPC$TL_readParticipantDate.user_id;
                    int i = tLRPC$TL_readParticipantDate.date;
                    if (j != j2) {
                        arrayList.add(Long.valueOf(j2));
                        arrayList2.add(Integer.valueOf(i));
                    }
                }
            }
            arrayList.add(Long.valueOf(j));
            arrayList2.add(0);
            final ArrayList arrayList3 = new ArrayList();
            final Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ReactedHeaderView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onAttachedToWindow$0(arrayList3);
                }
            };
            for (Long l : arrayList) {
                TLRPC$User user = MessagesController.getInstance(this.currentAccount).getUser(l);
                int iIndexOf = arrayList.indexOf(l);
                if (!user.self && iIndexOf >= 0) {
                    arrayList3.add(new UserSeen(user, ((Integer) arrayList2.get(iIndexOf)).intValue()));
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ReactedHeaderView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToWindow$0(List list) {
        this.seenUsers.addAll(list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UserSeen userSeen = (UserSeen) it.next();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.users.size()) {
                    break;
                }
                if (this.users.get(i).user.id == userSeen.user.id) {
                    if (userSeen.date > 0) {
                        this.users.get(i).date = userSeen.date;
                    }
                    z = true;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.users.add(userSeen);
            }
        }
        Consumer<List<UserSeen>> consumer = this.seenCallback;
        if (consumer != null) {
            consumer.accept(list);
        }
        loadReactions();
    }

    private void loadReactions() {
        MessagesController messagesController = MessagesController.getInstance(this.currentAccount);
        TLRPC$TL_messages_getMessageReactionsList tLRPC$TL_messages_getMessageReactionsList = new TLRPC$TL_messages_getMessageReactionsList();
        tLRPC$TL_messages_getMessageReactionsList.peer = messagesController.getInputPeer((int) this.message.getDialogId());
        tLRPC$TL_messages_getMessageReactionsList.id = this.message.getId();
        AccountInstance.getInstance(this.currentAccount).getMessageProxy().loadReactions(tLRPC$TL_messages_getMessageReactionsList, new RequestDelegate() { // from class: org.rbmain.ui.Components.ReactedHeaderView$$ExternalSyntheticLambda3
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadReactions$3(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadReactions$3(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_messages_messageReactionsList) {
            final TLRPC$TL_messages_messageReactionsList tLRPC$TL_messages_messageReactionsList = (TLRPC$TL_messages_messageReactionsList) tLObject;
            final int i = tLRPC$TL_messages_messageReactionsList.count;
            tLRPC$TL_messages_messageReactionsList.users.size();
            post(new Runnable() { // from class: org.rbmain.ui.Components.ReactedHeaderView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadReactions$2(i, tLRPC$TL_messages_messageReactionsList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadReactions$2(int i, TLRPC$TL_messages_messageReactionsList tLRPC$TL_messages_messageReactionsList) {
        String pluralString;
        boolean z;
        boolean z2;
        if (this.seenUsers.isEmpty() || this.seenUsers.size() < i) {
            pluralString = LocaleController.formatPluralString("ReactionsCount", i);
        } else {
            pluralString = String.format(LocaleController.getPluralString("Reacted", i), i == this.seenUsers.size() ? String.valueOf(i) : i + "/" + this.seenUsers.size());
        }
        if (getMeasuredWidth() > 0) {
            this.fixedWidth = getMeasuredWidth();
        }
        this.titleView.setText(pluralString);
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions = this.message.messageOwner.reactions;
        if (tLRPC$TL_messageReactions == null || tLRPC$TL_messageReactions.results.size() != 1 || tLRPC$TL_messages_messageReactionsList.reactions.isEmpty()) {
            z = true;
        } else {
            for (TLRPC$TL_availableReaction tLRPC$TL_availableReaction : MediaDataController.getInstance(this.currentAccount).getReactionsList()) {
                if (tLRPC$TL_availableReaction.reaction.equals(tLRPC$TL_messages_messageReactionsList.reactions.get(0).reaction)) {
                    this.reactView.setImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.center_icon), "40_40_lastreactframe", "webp", (Drawable) null, tLRPC$TL_availableReaction);
                    this.reactView.setVisibility(0);
                    this.reactView.setAlpha(0.0f);
                    this.reactView.animate().alpha(1.0f).start();
                    this.iconView.setVisibility(8);
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (z) {
            this.iconView.setVisibility(0);
            this.iconView.setAlpha(0.0f);
            this.iconView.animate().alpha(1.0f).start();
        }
        Iterator<TLRPC$User> it = tLRPC$TL_messages_messageReactionsList.users.iterator();
        while (it.hasNext()) {
            TLRPC$User next = it.next();
            TLRPC$Peer tLRPC$Peer = this.message.messageOwner.from_id;
            if (tLRPC$Peer != null && next.id != tLRPC$Peer.user_id) {
                int i2 = 0;
                while (true) {
                    if (i2 >= this.users.size()) {
                        z2 = false;
                        break;
                    } else {
                        if (this.users.get(i2).user.id == next.id) {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z2) {
                    this.users.add(new UserSeen(next, 0));
                }
            }
        }
        updateView();
    }

    public List<UserSeen> getSeenUsers() {
        return this.seenUsers;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateView() {
        /*
            r6 = this;
            java.util.List<org.rbmain.ui.Components.ReactedHeaderView$UserSeen> r0 = r6.users
            int r0 = r0.size()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            r6.setEnabled(r0)
            r0 = 0
        L11:
            r3 = 3
            if (r0 >= r3) goto L39
            java.util.List<org.rbmain.ui.Components.ReactedHeaderView$UserSeen> r3 = r6.users
            int r3 = r3.size()
            if (r0 >= r3) goto L2e
            org.rbmain.ui.Components.AvatarsImageView r3 = r6.avatarsImageView
            int r4 = r6.currentAccount
            java.util.List<org.rbmain.ui.Components.ReactedHeaderView$UserSeen> r5 = r6.users
            java.lang.Object r5 = r5.get(r0)
            org.rbmain.ui.Components.ReactedHeaderView$UserSeen r5 = (org.rbmain.ui.Components.ReactedHeaderView.UserSeen) r5
            org.rbmain.tgnet.TLRPC$User r5 = r5.user
            r3.setObject(r0, r4, r5)
            goto L36
        L2e:
            org.rbmain.ui.Components.AvatarsImageView r3 = r6.avatarsImageView
            int r4 = r6.currentAccount
            r5 = 0
            r3.setObject(r0, r4, r5)
        L36:
            int r0 = r0 + 1
            goto L11
        L39:
            java.util.List<org.rbmain.ui.Components.ReactedHeaderView$UserSeen> r0 = r6.users
            int r0 = r0.size()
            r3 = 0
            r4 = 1094713344(0x41400000, float:12.0)
            if (r0 == r1) goto L4e
            r1 = 2
            if (r0 == r1) goto L49
            r0 = 0
            goto L55
        L49:
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r4)
            goto L54
        L4e:
            r0 = 1103101952(0x41c00000, float:24.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
        L54:
            float r0 = (float) r0
        L55:
            org.rbmain.ui.Components.AvatarsImageView r1 = r6.avatarsImageView
            boolean r5 = org.rbmain.messenger.LocaleController.isRTL
            if (r5 == 0) goto L60
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r4)
            float r0 = (float) r0
        L60:
            r1.setTranslationX(r0)
            org.rbmain.ui.Components.AvatarsImageView r0 = r6.avatarsImageView
            r0.commitTransition(r2)
            android.widget.TextView r0 = r6.titleView
            android.view.ViewPropertyAnimator r0 = r0.animate()
            r1 = 1065353216(0x3f800000, float:1.0)
            android.view.ViewPropertyAnimator r0 = r0.alpha(r1)
            r4 = 220(0xdc, double:1.087E-321)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r4)
            r0.start()
            org.rbmain.ui.Components.AvatarsImageView r0 = r6.avatarsImageView
            android.view.ViewPropertyAnimator r0 = r0.animate()
            android.view.ViewPropertyAnimator r0 = r0.alpha(r1)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r4)
            r0.start()
            org.rbmain.ui.Components.FlickerLoadingView r0 = r6.flickerLoadingView
            android.view.ViewPropertyAnimator r0 = r0.animate()
            android.view.ViewPropertyAnimator r0 = r0.alpha(r3)
            android.view.ViewPropertyAnimator r0 = r0.setDuration(r4)
            org.rbmain.ui.Components.HideViewAfterAnimation r1 = new org.rbmain.ui.Components.HideViewAfterAnimation
            org.rbmain.ui.Components.FlickerLoadingView r2 = r6.flickerLoadingView
            r1.<init>(r2)
            android.view.ViewPropertyAnimator r0 = r0.setListener(r1)
            r0.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ReactedHeaderView.updateView():void");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.fixedWidth;
        if (i3 > 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        if (this.flickerLoadingView.getVisibility() == 0) {
            this.ignoreLayout = true;
            this.flickerLoadingView.setVisibility(8);
            super.onMeasure(i, i2);
            this.flickerLoadingView.getLayoutParams().width = getMeasuredWidth();
            this.flickerLoadingView.setVisibility(0);
            this.ignoreLayout = false;
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }
}
