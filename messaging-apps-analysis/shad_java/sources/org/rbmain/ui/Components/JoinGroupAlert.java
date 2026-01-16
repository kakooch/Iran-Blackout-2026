package org.rbmain.ui.Components;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.proxy.DialogsProxy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatInvite;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_importChatInvite;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.JoinSheetUserCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes5.dex */
public class JoinGroupAlert extends BottomSheet {
    private TLRPC$ChatInvite chatInvite;
    private BaseFragment fragment;
    private String hash;

    public JoinGroupAlert(Context context, TLRPC$ChatInvite tLRPC$ChatInvite, String str, BaseFragment baseFragment) {
        String str2;
        int i;
        super(context, false);
        setApplyBottomPadding(false);
        setApplyTopPadding(false);
        this.fragment = baseFragment;
        this.chatInvite = tLRPC$ChatInvite;
        this.hash = str;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        setCustomView(linearLayout);
        BackupImageView backupImageView = new BackupImageView(context);
        backupImageView.setRoundRadius(AndroidUtilities.dp(35.0f));
        linearLayout.addView(backupImageView, LayoutHelper.createLinear(70, 70, 49, 0, 29, 0, 0));
        if (tLRPC$ChatInvite.chat != null) {
            AvatarDrawable avatarDrawable = new AvatarDrawable(tLRPC$ChatInvite.chat);
            TLRPC$Chat tLRPC$Chat = tLRPC$ChatInvite.chat;
            str2 = tLRPC$Chat.title;
            i = tLRPC$Chat.participants_count;
            backupImageView.setForUserOrChat(tLRPC$Chat, avatarDrawable, tLRPC$ChatInvite);
        } else {
            AvatarDrawable avatarDrawable2 = new AvatarDrawable();
            avatarDrawable2.setInfo(0L, tLRPC$ChatInvite.title, null);
            str2 = tLRPC$ChatInvite.title;
            i = tLRPC$ChatInvite.participants_count;
            backupImageView.setImage(ImageLocation.getForPhoto(FileLoader.getClosestPhotoSizeWithSize(tLRPC$ChatInvite.photo.sizes, 50), tLRPC$ChatInvite.photo), "50_50", avatarDrawable2, tLRPC$ChatInvite);
        }
        TextView textView = new TextView(context);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView.setTextSize(1, 17.0f);
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setText(str2);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(textView, LayoutHelper.createLinear(-2, -2, 49, 10, 9, 10, i > 0 ? 0 : 20));
        if (i > 0) {
            TextView textView2 = new TextView(context);
            textView2.setTextSize(1, 14.0f);
            textView2.setTextColor(Theme.getColor(Theme.key_dialogTextGray3));
            textView2.setSingleLine(true);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText(LocaleController.formatPluralString("Members", i));
            linearLayout.addView(textView2, LayoutHelper.createLinear(-2, -2, 49, 10, 3, 10, 20));
        }
        if (!tLRPC$ChatInvite.participants.isEmpty()) {
            RecyclerListView recyclerListView = new RecyclerListView(context);
            recyclerListView.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
            recyclerListView.setNestedScrollingEnabled(false);
            recyclerListView.setClipToPadding(false);
            recyclerListView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerListView.setHorizontalScrollBarEnabled(false);
            recyclerListView.setVerticalScrollBarEnabled(false);
            recyclerListView.setAdapter(new UsersAdapter(context));
            recyclerListView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
            linearLayout.addView(recyclerListView, LayoutHelper.createLinear(-2, 90, 49, 0, 0, 0, 7));
        }
        View view = new View(context);
        view.setBackgroundColor(Theme.getColor(Theme.key_dialogShadowLine));
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight()));
        PickerBottomLayout pickerBottomLayout = new PickerBottomLayout(context, false);
        linearLayout.addView(pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        pickerBottomLayout.cancelButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        TextView textView3 = pickerBottomLayout.cancelButton;
        int i2 = Theme.key_dialogTextBlue2;
        textView3.setTextColor(Theme.getColor(i2));
        pickerBottomLayout.cancelButton.setText(LocaleController.getString("Cancel", R.string.Cancel).toUpperCase());
        pickerBottomLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.JoinGroupAlert$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$0(view2);
            }
        });
        pickerBottomLayout.doneButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        pickerBottomLayout.doneButton.setVisibility(0);
        pickerBottomLayout.doneButtonBadgeTextView.setVisibility(8);
        pickerBottomLayout.doneButtonTextView.setTextColor(Theme.getColor(i2));
        if ((tLRPC$ChatInvite.channel && !tLRPC$ChatInvite.megagroup) || (ChatObject.isChannel(tLRPC$ChatInvite.chat) && !tLRPC$ChatInvite.chat.megagroup)) {
            pickerBottomLayout.doneButtonTextView.setText(LocaleController.getString("ProfileJoinChannel", R.string.ProfileJoinChannel).toUpperCase());
        } else {
            pickerBottomLayout.doneButtonTextView.setText(LocaleController.getString("JoinGroup", R.string.JoinGroup));
        }
        pickerBottomLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.JoinGroupAlert$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$3(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
        dismiss();
        final TLRPC$TL_messages_importChatInvite tLRPC$TL_messages_importChatInvite = new TLRPC$TL_messages_importChatInvite();
        tLRPC$TL_messages_importChatInvite.hash = this.hash;
        TLRPC$ChatInvite tLRPC$ChatInvite = this.chatInvite;
        tLRPC$TL_messages_importChatInvite.chatId = tLRPC$ChatInvite.chat.id;
        tLRPC$TL_messages_importChatInvite.isChannel = tLRPC$ChatInvite.channel;
        DialogsProxy.getInstance(this.currentAccount).joinChatByLink(tLRPC$TL_messages_importChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.Components.JoinGroupAlert$$ExternalSyntheticLambda3
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$new$2(tLRPC$TL_messages_importChatInvite, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(final TLRPC$TL_messages_importChatInvite tLRPC$TL_messages_importChatInvite, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$Updates) tLObject, false);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.JoinGroupAlert$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$1(tLRPC$TL_error, tLObject, tLRPC$TL_messages_importChatInvite);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_messages_importChatInvite tLRPC$TL_messages_importChatInvite) {
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
            bundle.putInt("chat_id", tLRPC$Chat.id);
            if (MessagesController.getInstance(this.currentAccount).checkCanOpenChat(bundle, this.fragment)) {
                ChatActivity chatActivity = new ChatActivity(bundle);
                BaseFragment baseFragment2 = this.fragment;
                baseFragment2.presentFragment(chatActivity, baseFragment2 instanceof ChatActivity);
                return;
            }
            return;
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this.fragment, tLRPC$TL_messages_importChatInvite, new Object[0]);
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

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
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
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            JoinSheetUserCell joinSheetUserCell = new JoinSheetUserCell(this.context);
            joinSheetUserCell.setLayoutParams(new RecyclerView.LayoutParams(AndroidUtilities.dp(100.0f), AndroidUtilities.dp(90.0f)));
            return new RecyclerListView.Holder(joinSheetUserCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            JoinSheetUserCell joinSheetUserCell = (JoinSheetUserCell) viewHolder.itemView;
            if (i < JoinGroupAlert.this.chatInvite.participants.size()) {
                joinSheetUserCell.setUser(JoinGroupAlert.this.chatInvite.participants.get(i));
            } else {
                joinSheetUserCell.setCount((JoinGroupAlert.this.chatInvite.chat != null ? JoinGroupAlert.this.chatInvite.chat.participants_count : JoinGroupAlert.this.chatInvite.participants_count) - JoinGroupAlert.this.chatInvite.participants.size());
            }
        }
    }
}
