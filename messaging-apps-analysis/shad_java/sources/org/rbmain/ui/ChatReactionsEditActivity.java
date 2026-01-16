package org.rbmain.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatReactions;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsAll;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsNone;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsSome;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.AvailableReactionCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.RadioCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SimpleThemeDescription;

/* loaded from: classes4.dex */
public class ChatReactionsEditActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private RadioCell allReactions;
    private ArrayList<TLRPC$TL_availableReaction> availableReactions;
    private int chatId;
    private List<String> chatReactions;
    private LinearLayout contentView;
    LinearLayout contorlsLayout;
    private TLRPC$Chat currentChat;
    private RadioCell disableReactions;
    private TextCheckCell enableReactionsCell;
    private TLRPC$ChatFull info;
    boolean isChannel;
    private RecyclerView.Adapter listAdapter;
    private RecyclerListView listView;
    ArrayList<RadioCell> radioCells;
    int selectedType;
    private RadioCell someReactions;
    int startFromType;

    public ChatReactionsEditActivity(Bundle bundle) {
        super(bundle);
        this.chatReactions = new ArrayList();
        this.availableReactions = new ArrayList<>();
        this.selectedType = -1;
        this.radioCells = new ArrayList<>();
        this.chatId = bundle.getInt("chat_id", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004a, code lost:
    
        if (r0 == null) goto L10;
     */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFragmentCreate() {
        /*
            r10 = this;
            org.rbmain.messenger.MessagesController r0 = r10.getMessagesController()
            int r1 = r10.chatId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            r10.currentChat = r0
            if (r0 != 0) goto L4d
            androidMessenger.proxy.DialogsProxy r0 = r10.getDialogsProxy()
            int r1 = r10.chatId
            org.rbmain.tgnet.TLRPC$Chat r0 = r0.getChat(r1)
            r10.currentChat = r0
            r1 = 0
            if (r0 == 0) goto L4c
            org.rbmain.messenger.MessagesController r0 = r10.getMessagesController()
            org.rbmain.tgnet.TLRPC$Chat r2 = r10.currentChat
            r3 = 1
            r0.putChat(r2, r3)
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r10.info
            if (r0 != 0) goto L4d
            int r0 = r10.currentAccount
            org.rbmain.messenger.MessagesStorage r4 = org.rbmain.messenger.MessagesStorage.getInstance(r0)
            int r5 = r10.chatId
            org.rbmain.tgnet.TLRPC$Chat r0 = r10.currentChat
            boolean r6 = org.rbmain.messenger.ChatObject.isChannel(r0)
            java.util.concurrent.CountDownLatch r7 = new java.util.concurrent.CountDownLatch
            r7.<init>(r3)
            r8 = 0
            r9 = 0
            org.rbmain.tgnet.TLRPC$ChatFull r0 = r4.loadChatInfo(r5, r6, r7, r8, r9)
            r10.info = r0
            if (r0 != 0) goto L4d
        L4c:
            return r1
        L4d:
            org.rbmain.messenger.NotificationCenter r0 = r10.getNotificationCenter()
            int r1 = org.rbmain.messenger.NotificationCenter.reactionsDidLoad
            r0.addObserver(r10, r1)
            boolean r0 = super.onFragmentCreate()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ChatReactionsEditActivity.onFragmentCreate():boolean");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.isChannel = ChatObject.isChannelAndNotMegaGroup(this.chatId, this.currentAccount);
        this.actionBar.setTitle(LocaleController.getString("Reactions", R.string.Reactions));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ChatReactionsEditActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    ChatReactionsEditActivity.this.finishFragment();
                }
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        this.availableReactions.addAll(getMediaDataController().getEnabledReactionsList());
        if (this.isChannel) {
            TextCheckCell textCheckCell = new TextCheckCell(context);
            this.enableReactionsCell = textCheckCell;
            textCheckCell.setHeight(56);
            this.enableReactionsCell.setTextAndCheck(LocaleController.getString("EnableReactions", R.string.EnableReactions), !this.chatReactions.isEmpty(), false);
            TextCheckCell textCheckCell2 = this.enableReactionsCell;
            textCheckCell2.setBackgroundColor(Theme.getColor(textCheckCell2.isChecked() ? Theme.key_windowBackgroundChecked : Theme.key_windowBackgroundUnchecked));
            this.enableReactionsCell.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.enableReactionsCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$0(view);
                }
            });
            linearLayout.addView(this.enableReactionsCell, LayoutHelper.createLinear(-1, -2));
        }
        HeaderCell headerCell = new HeaderCell(context);
        headerCell.setText(LocaleController.getString("AvailableReactions", R.string.AvailableReactions));
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.contorlsLayout = linearLayout2;
        linearLayout2.setOrientation(1);
        RadioCell radioCell = new RadioCell(context);
        this.allReactions = radioCell;
        radioCell.setText(LocaleController.getString("AllReactions", R.string.AllReactions), false, true);
        RadioCell radioCell2 = new RadioCell(context);
        this.someReactions = radioCell2;
        radioCell2.setText(LocaleController.getString("SomeReactions", R.string.SomeReactions), false, true);
        RadioCell radioCell3 = new RadioCell(context);
        this.disableReactions = radioCell3;
        radioCell3.setText(LocaleController.getString("NoReactions", R.string.NoReactions), false, false);
        this.contorlsLayout.addView(headerCell, LayoutHelper.createLinear(-1, -2));
        this.contorlsLayout.addView(this.allReactions, LayoutHelper.createLinear(-1, -2));
        this.contorlsLayout.addView(this.someReactions, LayoutHelper.createLinear(-1, -2));
        this.contorlsLayout.addView(this.disableReactions, LayoutHelper.createLinear(-1, -2));
        this.radioCells.clear();
        this.radioCells.add(this.allReactions);
        this.radioCells.add(this.someReactions);
        this.radioCells.add(this.disableReactions);
        this.allReactions.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$2(view);
            }
        });
        this.someReactions.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$4(view);
            }
        });
        this.disableReactions.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$6(view);
            }
        });
        int i = Theme.key_windowBackgroundWhite;
        headerCell.setBackgroundColor(Theme.getColor(i));
        RadioCell radioCell4 = this.allReactions;
        int color = Theme.getColor(i);
        int i2 = Theme.key_listSelector;
        radioCell4.setBackground(Theme.createSelectorWithBackgroundDrawable(color, Theme.getColor(i2)));
        this.someReactions.setBackground(Theme.createSelectorWithBackgroundDrawable(Theme.getColor(i), Theme.getColor(i2)));
        this.disableReactions.setBackground(Theme.createSelectorWithBackgroundDrawable(Theme.getColor(i), Theme.getColor(i2)));
        setCheckedEnableReactionCell(this.startFromType, false);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerListView recyclerListView2 = this.listView;
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() { // from class: org.rbmain.ui.ChatReactionsEditActivity.2
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
                if (i3 == 0) {
                    return new RecyclerListView.Holder(new TextInfoPrivacyCell(context));
                }
                if (i3 == 1) {
                    return new RecyclerListView.Holder(new HeaderCell(context, 23));
                }
                if (i3 != 3) {
                    return new RecyclerListView.Holder(new AvailableReactionCell(context, false, false));
                }
                FrameLayout frameLayout = new FrameLayout(context);
                if (ChatReactionsEditActivity.this.contorlsLayout.getParent() != null) {
                    ((ViewGroup) ChatReactionsEditActivity.this.contorlsLayout.getParent()).removeView(ChatReactionsEditActivity.this.contorlsLayout);
                }
                frameLayout.addView(ChatReactionsEditActivity.this.contorlsLayout);
                frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                return new RecyclerListView.Holder(frameLayout);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
                int itemViewType = getItemViewType(i3);
                if (itemViewType != 0) {
                    if (itemViewType == 1) {
                        HeaderCell headerCell2 = (HeaderCell) viewHolder.itemView;
                        headerCell2.setText(LocaleController.getString("OnlyAllowThisReactions", R.string.OnlyAllowThisReactions));
                        headerCell2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                        return;
                    } else {
                        if (itemViewType != 2) {
                            return;
                        }
                        AvailableReactionCell availableReactionCell = (AvailableReactionCell) viewHolder.itemView;
                        TLRPC$TL_availableReaction tLRPC$TL_availableReaction = (TLRPC$TL_availableReaction) ChatReactionsEditActivity.this.availableReactions.get(i3 - (ChatReactionsEditActivity.this.isChannel ? 2 : 3));
                        availableReactionCell.bind(tLRPC$TL_availableReaction, ChatReactionsEditActivity.this.chatReactions.contains(tLRPC$TL_availableReaction.reaction_id), ((BaseFragment) ChatReactionsEditActivity.this).currentAccount);
                        return;
                    }
                }
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                textInfoPrivacyCell.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText4));
                ChatReactionsEditActivity chatReactionsEditActivity = ChatReactionsEditActivity.this;
                if (chatReactionsEditActivity.isChannel) {
                    textInfoPrivacyCell.setText(ChatObject.isChannelAndNotMegaGroup(chatReactionsEditActivity.currentChat) ? LocaleController.getString("EnableReactionsChannelInfo", R.string.EnableReactionsChannelInfo) : LocaleController.getString("EnableReactionsGroupInfo", R.string.EnableReactionsGroupInfo));
                    return;
                }
                int i4 = chatReactionsEditActivity.selectedType;
                if (i4 == 1) {
                    textInfoPrivacyCell.setText(LocaleController.getString("EnableSomeReactionsInfo", R.string.EnableSomeReactionsInfo));
                } else if (i4 == 0) {
                    textInfoPrivacyCell.setText(LocaleController.getString("EnableAllReactionsInfo", R.string.EnableAllReactionsInfo));
                } else if (i4 == 2) {
                    textInfoPrivacyCell.setText(LocaleController.getString("DisableReactionsInfo", R.string.DisableReactionsInfo));
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                ChatReactionsEditActivity chatReactionsEditActivity = ChatReactionsEditActivity.this;
                if (chatReactionsEditActivity.isChannel) {
                    return (chatReactionsEditActivity.chatReactions.isEmpty() ? 0 : ChatReactionsEditActivity.this.availableReactions.size() + 1) + 1;
                }
                return (chatReactionsEditActivity.chatReactions.isEmpty() ? 0 : ChatReactionsEditActivity.this.availableReactions.size() + 1) + 2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemViewType(int i3) {
                if (ChatReactionsEditActivity.this.isChannel) {
                    if (i3 == 0) {
                        return 0;
                    }
                    return i3 == 1 ? 1 : 2;
                }
                if (i3 == 0) {
                    return 3;
                }
                if (i3 == 1) {
                    return 0;
                }
                return i3 == 2 ? 1 : 2;
            }
        };
        this.listAdapter = adapter;
        recyclerListView2.setAdapter(adapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$createView$7(view, i3);
            }
        });
        linearLayout.addView(this.listView, LayoutHelper.createLinear(-1, 0, 1.0f));
        this.contentView = linearLayout;
        this.fragmentView = linearLayout;
        updateColors();
        return this.contentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(View view) {
        setCheckedEnableReactionCell(this.enableReactionsCell.isChecked() ? 2 : 1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1() {
        setCheckedEnableReactionCell(0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3() {
        setCheckedEnableReactionCell(1, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(View view) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5() {
        setCheckedEnableReactionCell(2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(View view) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(View view, int i) {
        boolean z = this.isChannel;
        if (i <= (z ? 1 : 2)) {
            return;
        }
        AvailableReactionCell availableReactionCell = (AvailableReactionCell) view;
        TLRPC$TL_availableReaction tLRPC$TL_availableReaction = this.availableReactions.get(i - (z ? 2 : 3));
        boolean z2 = !this.chatReactions.contains(tLRPC$TL_availableReaction.reaction_id);
        if (z2) {
            this.chatReactions.add(tLRPC$TL_availableReaction.reaction_id);
        } else {
            this.chatReactions.remove(tLRPC$TL_availableReaction.reaction_id);
            if (this.chatReactions.isEmpty()) {
                RecyclerView.Adapter adapter = this.listAdapter;
                if (adapter != null) {
                    adapter.notifyItemRangeRemoved(this.isChannel ? 1 : 2, this.availableReactions.size() + 1);
                }
                setCheckedEnableReactionCell(2, true);
            }
        }
        availableReactionCell.setChecked(z2, true);
    }

    private void setCheckedEnableReactionCell(int i, boolean z) {
        RecyclerView.Adapter adapter;
        if (this.selectedType == i) {
            return;
        }
        TextCheckCell textCheckCell = this.enableReactionsCell;
        if (textCheckCell != null) {
            boolean z2 = i == 1;
            textCheckCell.setChecked(z2);
            int color = Theme.getColor(z2 ? Theme.key_windowBackgroundChecked : Theme.key_windowBackgroundUnchecked);
            if (z2) {
                this.enableReactionsCell.setBackgroundColorAnimated(z2, color);
            } else {
                this.enableReactionsCell.setBackgroundColorAnimatedReverse(color);
            }
        }
        this.selectedType = i;
        int i2 = 0;
        while (i2 < this.radioCells.size()) {
            this.radioCells.get(i2).setChecked(i == i2, z);
            i2++;
        }
        if (i == 1) {
            if (z) {
                this.chatReactions.clear();
                Iterator<TLRPC$TL_availableReaction> it = this.availableReactions.iterator();
                while (it.hasNext()) {
                    TLRPC$TL_availableReaction next = it.next();
                    if (next.reaction.equals("👍") || next.reaction.equals("👎")) {
                        this.chatReactions.add(next.reaction_id);
                    }
                }
                if (this.chatReactions.isEmpty() && this.availableReactions.size() >= 2) {
                    this.chatReactions.add(this.availableReactions.get(0).reaction_id);
                    this.chatReactions.add(this.availableReactions.get(1).reaction_id);
                }
            }
            RecyclerView.Adapter adapter2 = this.listAdapter;
            if (adapter2 != null && z) {
                adapter2.notifyItemRangeInserted(this.isChannel ? 1 : 2, this.availableReactions.size() + 1);
            }
        } else if (!this.chatReactions.isEmpty()) {
            this.chatReactions.clear();
            RecyclerView.Adapter adapter3 = this.listAdapter;
            if (adapter3 != null && z) {
                adapter3.notifyItemRangeRemoved(this.isChannel ? 1 : 2, this.availableReactions.size() + 1);
            }
        }
        if (!this.isChannel && (adapter = this.listAdapter) != null && z) {
            adapter.notifyItemChanged(1);
        }
        RecyclerView.Adapter adapter4 = this.listAdapter;
        if (adapter4 == null || z) {
            return;
        }
        adapter4.notifyDataSetChanged();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getMessagesController().setChatReactions(this.chatId, this.selectedType, this.chatReactions);
        getNotificationCenter().removeObserver(this, NotificationCenter.reactionsDidLoad);
    }

    public void setInfo(TLRPC$ChatFull tLRPC$ChatFull) {
        this.info = tLRPC$ChatFull;
        if (tLRPC$ChatFull != null) {
            if (this.currentChat == null) {
                this.currentChat = getMessagesController().getChat(Integer.valueOf(this.chatId));
            }
            this.chatReactions = new ArrayList();
            TLRPC$ChatReactions tLRPC$ChatReactions = tLRPC$ChatFull.available_reactions;
            if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsAll) {
                this.startFromType = 0;
                return;
            }
            if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsNone) {
                this.startFromType = 2;
                return;
            }
            if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsSome) {
                TLRPC$TL_chatReactionsSome tLRPC$TL_chatReactionsSome = (TLRPC$TL_chatReactionsSome) tLRPC$ChatReactions;
                for (int i = 0; i < tLRPC$TL_chatReactionsSome.reactions.size(); i++) {
                    if (tLRPC$TL_chatReactionsSome.reactions.get(i) instanceof TLRPC$TL_reactionEmoji) {
                        this.chatReactions.add(((TLRPC$TL_reactionEmoji) tLRPC$TL_chatReactionsSome.reactions.get(i)).reactionId);
                    }
                }
                this.startFromType = 1;
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        return SimpleThemeDescription.createThemeDescriptions(new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ChatReactionsEditActivity$$ExternalSyntheticLambda7
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updateColors();
            }
        }, Theme.key_windowBackgroundWhite, Theme.key_windowBackgroundWhiteBlackText, Theme.key_windowBackgroundWhiteGrayText2, Theme.key_listSelector, Theme.key_windowBackgroundGray, Theme.key_windowBackgroundWhiteGrayText4, Theme.key_text_RedRegular, Theme.key_windowBackgroundChecked, Theme.key_windowBackgroundCheckText, Theme.key_switchTrackBlue, Theme.key_switchTrackBlueChecked, Theme.key_switchTrackBlueThumb, Theme.key_switchTrackBlueThumbChecked);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateColors() {
        this.contentView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        TextCheckCell textCheckCell = this.enableReactionsCell;
        if (textCheckCell != null) {
            textCheckCell.setColors(Theme.key_windowBackgroundCheckText, Theme.key_switchTrackBlue, Theme.key_switchTrackBlueChecked, Theme.key_switchTrackBlueThumb, Theme.key_switchTrackBlueThumbChecked);
        }
        this.listAdapter.notifyDataSetChanged();
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i2 == this.currentAccount && i == NotificationCenter.reactionsDidLoad) {
            this.availableReactions.clear();
            this.availableReactions.addAll(getMediaDataController().getEnabledReactionsList());
            this.listAdapter.notifyDataSetChanged();
        }
    }
}
