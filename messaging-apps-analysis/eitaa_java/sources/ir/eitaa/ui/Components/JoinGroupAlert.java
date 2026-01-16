package ir.eitaa.ui.Components;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_importChatInvite;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.JoinSheetUserCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.MediaChannelActivity;

/* loaded from: classes3.dex */
public class JoinGroupAlert extends BottomSheet {
    private TLRPC$ChatInvite chatInvite;
    private BaseFragment fragment;
    private String hash;

    public JoinGroupAlert(final Context context, TLRPC$ChatInvite invite, String group, BaseFragment parentFragment) {
        String str;
        int i;
        super(context, false);
        setApplyBottomPadding(false);
        setApplyTopPadding(false);
        this.fragment = parentFragment;
        this.chatInvite = invite;
        this.hash = group;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        setCustomView(linearLayout);
        BackupImageView backupImageView = new BackupImageView(context);
        backupImageView.setRoundRadius(AndroidUtilities.dp(35.0f));
        linearLayout.addView(backupImageView, LayoutHelper.createLinear(70, 70, 49, 0, 29, 0, 0));
        if (invite.chat != null) {
            AvatarDrawable avatarDrawable = new AvatarDrawable(invite.chat);
            TLRPC$Chat tLRPC$Chat = invite.chat;
            str = tLRPC$Chat.title;
            i = tLRPC$Chat.participants_count;
            backupImageView.setForUserOrChat(tLRPC$Chat, avatarDrawable, invite);
        } else {
            AvatarDrawable avatarDrawable2 = new AvatarDrawable();
            avatarDrawable2.setInfo(0L, invite.title, null);
            String str2 = invite.title;
            int i2 = invite.participants_count;
            backupImageView.setImage(ImageLocation.getForLocal(invite.chatPhoto.photo_small), "50_50", (String) null, avatarDrawable2, invite);
            str = str2;
            i = i2;
        }
        TextView textView = new TextView(context);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setTextSize(1, 17.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setText(str);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 49, 10, 9, 10, i > 0 ? 0 : 20));
        if (i > 0) {
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 14.0f);
            textView2.setTypeface(AndroidUtilities.getFontFamily(false));
            textView2.setTextColor(Theme.getColor("dialogTextGray3"));
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            if (invite.channel || (ChatObject.isChannel(invite.chat) && !invite.chat.megagroup)) {
                textView2.setText(LocaleController.formatPluralString("Subscribers", i));
            } else {
                textView2.setText(LocaleController.formatPluralString("Members", i));
            }
            linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 49, 10, 3, 10, 20));
        }
        if (!invite.participants.isEmpty()) {
            RecyclerListView recyclerListView = new RecyclerListView(context);
            recyclerListView.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
            recyclerListView.setNestedScrollingEnabled(false);
            recyclerListView.setClipToPadding(false);
            recyclerListView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerListView.setHorizontalScrollBarEnabled(false);
            recyclerListView.setVerticalScrollBarEnabled(false);
            recyclerListView.setAdapter(new UsersAdapter(context));
            recyclerListView.setGlowColor(Theme.getColor("dialogScrollGlow"));
            linearLayout.addView(recyclerListView, LayoutHelper.createLinear(-2, 90, 49, 0, 0, 0, 7));
        }
        View view = new View(context);
        view.setBackgroundColor(Theme.getColor("dialogShadowLine"));
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight()));
        PickerBottomLayout pickerBottomLayout = new PickerBottomLayout(context, false);
        linearLayout.addView(pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        pickerBottomLayout.cancelButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        pickerBottomLayout.cancelButton.setTextColor(Theme.getColor("dialogTextBlue2"));
        pickerBottomLayout.cancelButton.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        pickerBottomLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinGroupAlert$EnnUBvwNfNoG7PqpZzkkXL9eQIs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0$JoinGroupAlert(view2);
            }
        });
        pickerBottomLayout.doneButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        pickerBottomLayout.doneButton.setVisibility(0);
        pickerBottomLayout.doneButtonBadgeTextView.setVisibility(8);
        pickerBottomLayout.doneButtonTextView.setTextColor(Theme.getColor("dialogTextBlue2"));
        if ((invite.channel && !invite.megagroup) || (ChatObject.isChannel(invite.chat) && !invite.chat.megagroup)) {
            pickerBottomLayout.doneButtonTextView.setText(LocaleController.getString("ProfileJoinChannel", R.string.ProfileJoinChannel).toUpperCase());
        } else {
            pickerBottomLayout.doneButtonTextView.setText(LocaleController.getString("JoinGroup", R.string.JoinGroup));
        }
        pickerBottomLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinGroupAlert$mctkAmzovmjHfPFdY2cVIpCuNzQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$3$JoinGroupAlert(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$JoinGroupAlert(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$JoinGroupAlert(View view) {
        dismiss();
        final TLRPC$TL_messages_importChatInvite tLRPC$TL_messages_importChatInvite = new TLRPC$TL_messages_importChatInvite();
        tLRPC$TL_messages_importChatInvite.hash = this.hash;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_importChatInvite, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinGroupAlert$RBrOQ_Q5nsVVlfeZdj-wVyvC1iY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$2$JoinGroupAlert(tLRPC$TL_messages_importChatInvite, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$JoinGroupAlert(final TLRPC$TL_messages_importChatInvite tLRPC$TL_messages_importChatInvite, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$Updates) tLObject, false);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$JoinGroupAlert$nRANZWgxAqqqvJmwsyc-MIb2ocE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1$JoinGroupAlert(tLRPC$TL_error, tLObject, tLRPC$TL_messages_importChatInvite);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$JoinGroupAlert(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_messages_importChatInvite tLRPC$TL_messages_importChatInvite) {
        BaseFragment chatActivity;
        BaseFragment baseFragment = this.fragment;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        if (tLRPC$TL_error == null) {
            TLRPC$Updates tLRPC$Updates = (TLRPC$Updates) tLObject;
            if (tLRPC$Updates.chats.isEmpty()) {
                return;
            }
            TLRPC$Chat tLRPC$Chat = tLRPC$Updates.chats.get(0);
            tLRPC$Chat.left = false;
            tLRPC$Chat.kicked = false;
            MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$Updates.users, false);
            MessagesController.getInstance(this.currentAccount).putChats(tLRPC$Updates.chats, false);
            Bundle bundle = new Bundle();
            bundle.putLong("chat_id", tLRPC$Chat.id);
            if (MessagesController.getInstance(this.currentAccount).checkCanOpenChat(bundle, this.fragment)) {
                if (tLRPC$Chat.isMediaContent) {
                    bundle.putInt("dialog_id", -((int) tLRPC$Chat.id));
                    chatActivity = new MediaChannelActivity(bundle);
                } else {
                    chatActivity = new ChatActivity(bundle);
                }
                BaseFragment baseFragment2 = this.fragment;
                baseFragment2.presentFragment(chatActivity, baseFragment2 instanceof ChatActivity);
                return;
            }
            return;
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this.fragment, tLRPC$TL_messages_importChatInvite, Boolean.valueOf(this.chatInvite.channel));
    }

    private class UsersAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return false;
        }

        public UsersAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = JoinGroupAlert.this.chatInvite.participants.size();
            return size != (JoinGroupAlert.this.chatInvite.chat != null ? JoinGroupAlert.this.chatInvite.chat.participants_count : JoinGroupAlert.this.chatInvite.participants_count) ? size + 1 : size;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            JoinSheetUserCell joinSheetUserCell = new JoinSheetUserCell(this.context);
            joinSheetUserCell.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(100.0f), AndroidUtilities.dp(90.0f)));
            return new RecyclerListView.Holder(joinSheetUserCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            JoinSheetUserCell joinSheetUserCell = (JoinSheetUserCell) holder.itemView;
            if (position < JoinGroupAlert.this.chatInvite.participants.size()) {
                joinSheetUserCell.setUser(JoinGroupAlert.this.chatInvite.participants.get(position));
            } else {
                joinSheetUserCell.setCount((JoinGroupAlert.this.chatInvite.chat != null ? JoinGroupAlert.this.chatInvite.chat.participants_count : JoinGroupAlert.this.chatInvite.participants_count) - JoinGroupAlert.this.chatInvite.participants.size());
            }
        }
    }
}
