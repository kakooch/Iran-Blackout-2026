package org.rbmain.ui.Components;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.proxy.DialogsProxy;
import androidx.core.graphics.ColorUtils;
import androidx.core.widget.NestedScrollView;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_exportChatInvite;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.LinkActionView;
import org.rbmain.ui.ManageLinksActivity;

/* loaded from: classes5.dex */
public class PermanentLinkBottomSheet extends BottomSheet {
    private int chatId;
    private BaseFragment fragment;
    private final RLottieImageView imageView;
    TLRPC$TL_chatInviteExported invite;
    private final LinkActionView linkActionView;
    boolean linkGenerating;
    RLottieDrawable linkIcon;
    private final TextView manage;
    private final TextView subtitle;
    private final TextView titleView;

    public PermanentLinkBottomSheet(Context context, boolean z, final BaseFragment baseFragment, final TLRPC$ChatFull tLRPC$ChatFull, int i, boolean z2) {
        int i2;
        String str;
        TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported;
        super(context, z);
        this.chatId = i;
        setAllowNestedScroll(true);
        setApplyBottomPadding(false);
        LinkActionView linkActionView = new LinkActionView(context, baseFragment, this, i, true, z2);
        this.linkActionView = linkActionView;
        linkActionView.setPermanent(true);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.shared_link_enter, "2131820639", AndroidUtilities.dp(90.0f), AndroidUtilities.dp(90.0f), false, null);
        this.linkIcon = rLottieDrawable;
        rLottieDrawable.setCustomEndFrame(42);
        rLottieImageView.setAnimation(this.linkIcon);
        linkActionView.setUsers(0, null);
        linkActionView.hideRevokeOption(true);
        linkActionView.setDelegate(new LinkActionView.Delegate() { // from class: org.rbmain.ui.Components.PermanentLinkBottomSheet$$ExternalSyntheticLambda5
            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void editLink() {
                LinkActionView.Delegate.CC.$default$editLink(this);
            }

            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void removeLink() {
                LinkActionView.Delegate.CC.$default$removeLink(this);
            }

            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public final void revokeLink() {
                this.f$0.lambda$new$0();
            }

            @Override // org.rbmain.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void showUsersForPermanentLink() {
                LinkActionView.Delegate.CC.$default$showUsersForPermanentLink(this);
            }
        });
        TextView textView = new TextView(context);
        this.titleView = textView;
        textView.setText(LocaleController.getString("InviteLink", R.string.InviteLink));
        textView.setTextSize(24.0f);
        textView.setGravity(1);
        textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        TextView textView2 = new TextView(context);
        this.subtitle = textView2;
        if (z2) {
            i2 = R.string.LinkInfoChannel;
            str = "LinkInfoChannel";
        } else {
            i2 = R.string.LinkInfo;
            str = "LinkInfo";
        }
        textView2.setText(LocaleController.getString(str, i2));
        textView2.setTextSize(14.0f);
        textView2.setGravity(1);
        textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText));
        TextView textView3 = new TextView(context);
        this.manage = textView3;
        textView3.setText(LocaleController.getString("ManageInviteLinks", R.string.ManageInviteLinks));
        textView3.setTextSize(14.0f);
        int i3 = Theme.key_windowBackgroundWhiteBlueText;
        textView3.setTextColor(Theme.getColor(i3));
        textView3.setBackground(Theme.createRadSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor(i3), 76), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f)));
        textView3.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f));
        textView3.setVisibility(8);
        textView3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.PermanentLinkBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(tLRPC$ChatFull, baseFragment, view);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(rLottieImageView, LayoutHelper.createLinear(90, 90, 1, 0, 24, 0, 0));
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2, 1, 60, 16, 60, 0));
        linearLayout.addView(textView2, LayoutHelper.createLinear(-1, -2, 1, 60, 16, 60, 0));
        linearLayout.addView(linkActionView, LayoutHelper.createLinear(-1, -2));
        linearLayout.addView(textView3, LayoutHelper.createLinear(-2, -2, 1, 60, 26, 60, 26));
        NestedScrollView nestedScrollView = new NestedScrollView(context);
        nestedScrollView.setVerticalScrollBarEnabled(false);
        nestedScrollView.addView(linearLayout);
        setCustomView(nestedScrollView);
        TLRPC$Chat chat = MessagesController.getInstance(UserConfig.selectedAccount).getChat(Integer.valueOf(i));
        if (chat != null && chat.username != null) {
            linkActionView.setLink("https://rubika.ir/" + chat.username);
            textView3.setVisibility(8);
        } else if (tLRPC$ChatFull != null && (tLRPC$TL_chatInviteExported = tLRPC$ChatFull.exported_invite) != null) {
            linkActionView.setLink(tLRPC$TL_chatInviteExported.link);
        } else {
            generateLink(false);
        }
        lambda$getThemeDescriptions$5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        generateLink(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(TLRPC$ChatFull tLRPC$ChatFull, BaseFragment baseFragment, View view) {
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(tLRPC$ChatFull.id, 0, 0);
        manageLinksActivity.setInfo(tLRPC$ChatFull, tLRPC$ChatFull.exported_invite);
        baseFragment.presentFragment(manageLinksActivity);
        dismiss();
    }

    private void generateLink(final boolean z) {
        if (this.linkGenerating) {
            return;
        }
        this.linkGenerating = true;
        TLRPC$TL_messages_exportChatInvite tLRPC$TL_messages_exportChatInvite = new TLRPC$TL_messages_exportChatInvite();
        tLRPC$TL_messages_exportChatInvite.legacy_revoke_permanent = true;
        tLRPC$TL_messages_exportChatInvite.peer = MessagesController.getInstance(this.currentAccount).getInputPeer(-this.chatId);
        tLRPC$TL_messages_exportChatInvite.newRequest = z;
        DialogsProxy.getInstance(this.currentAccount).setGroupOrChannelLinks(tLRPC$TL_messages_exportChatInvite, new RequestDelegate() { // from class: org.rbmain.ui.Components.PermanentLinkBottomSheet$$ExternalSyntheticLambda3
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateLink$3(z, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateLink$3(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.PermanentLinkBottomSheet$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateLink$2(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$generateLink$2(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            this.linkActionView.setUnSetLink(false);
            this.invite = (TLRPC$TL_chatInviteExported) tLObject;
            TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount).getChatFull(this.chatId);
            if (chatFull != null) {
                chatFull.exported_invite = this.invite;
            }
            this.linkActionView.setLink(this.invite.link);
            if (z && this.fragment != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage(LocaleController.getString("RevokeAlertNewLink", R.string.RevokeAlertNewLink));
                builder.setTitle(LocaleController.getString("RevokeLink", R.string.RevokeLink));
                builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                this.fragment.showDialog(builder.create());
            }
        } else if (tLRPC$TL_error.code == 100) {
            this.linkActionView.setUnSetLink(true);
            this.linkActionView.setLink(null);
        }
        this.linkGenerating = false;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.PermanentLinkBottomSheet$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$4();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$4() {
        this.linkIcon.start();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.Components.PermanentLinkBottomSheet$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$5();
            }
        };
        arrayList.add(new ThemeDescription(this.titleView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText));
        TextView textView = this.manage;
        int i = ThemeDescription.FLAG_TEXTCOLOR;
        int i2 = Theme.key_windowBackgroundWhiteBlueText;
        arrayList.add(new ThemeDescription(textView, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_featuredStickers_addButton));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_featuredStickers_buttonText));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, i2));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateColors, reason: merged with bridge method [inline-methods] */
    public void lambda$getThemeDescriptions$5() {
        this.imageView.setBackground(Theme.createCircleDrawable(AndroidUtilities.dp(90.0f), Theme.getColor(Theme.key_featuredStickers_addButton)));
        this.manage.setBackground(Theme.createRadSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText), 76), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f)));
        int color = Theme.getColor(Theme.key_featuredStickers_buttonText);
        this.linkIcon.setLayerColor("Top.**", color);
        this.linkIcon.setLayerColor("Bottom.**", color);
        this.linkIcon.setLayerColor("Center.**", color);
        this.linkActionView.updateColors();
        setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }
}
