package ir.eitaa.ui.Components;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.core.widget.NestedScrollView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ExportedChatInvite;
import ir.eitaa.tgnet.TLRPC$TL_channels_exportInvite;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.LinkActionView;
import ir.eitaa.ui.ManageLinksActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class PermanentLinkBottomSheet extends BottomSheet {
    private long chatId;
    private BaseFragment fragment;
    private boolean hideRevoke;
    private final RLottieImageView imageView;
    TLRPC$ChatFull info;
    private TLRPC$ExportedChatInvite invite;
    private boolean isChannel;
    private final LinkActionView linkActionView;
    boolean linkGenerating;
    RLottieDrawable linkIcon;
    private final TextView manage;
    private final TextView subtitle;
    private final TextView titleView;

    public PermanentLinkBottomSheet(Context context, boolean needFocus, final BaseFragment fragment, final TLRPC$ChatFull info, long chatId, boolean isChannel) {
        int i;
        String str;
        super(context, needFocus);
        this.info = info;
        this.chatId = chatId;
        this.isChannel = isChannel;
        setAllowNestedScroll(true);
        setApplyBottomPadding(false);
        this.hideRevoke = !MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(info.id)).creator;
        LinkActionView linkActionView = new LinkActionView(context, fragment, this, chatId, true, isChannel);
        this.linkActionView = linkActionView;
        linkActionView.setPermanent(true);
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.shared_link_enter, "2131624020", AndroidUtilities.dp(90.0f), AndroidUtilities.dp(90.0f), false, (int[]) null);
        this.linkIcon = rLottieDrawable;
        rLottieDrawable.setCustomEndFrame(42);
        rLottieImageView.setAnimation(this.linkIcon);
        linkActionView.setUsers(0, null);
        linkActionView.hideRevokeOption(this.hideRevoke);
        linkActionView.setDelegate(new LinkActionView.Delegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$PermanentLinkBottomSheet$9hkX7BEABAx3USNGCc7wNCqwMTI
            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void editLink() {
                LinkActionView.Delegate.CC.$default$editLink(this);
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void removeLink() {
                LinkActionView.Delegate.CC.$default$removeLink(this);
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public final void revokeLink() {
                this.f$0.lambda$new$0$PermanentLinkBottomSheet();
            }

            @Override // ir.eitaa.ui.Components.LinkActionView.Delegate
            public /* synthetic */ void showUsersForPermanentLink() {
                LinkActionView.Delegate.CC.$default$showUsersForPermanentLink(this);
            }
        });
        TextView textView = new TextView(context);
        this.titleView = textView;
        textView.setText(LocaleController.getString("InviteLink", R.string.InviteLink));
        textView.setTextSize(24.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(false));
        textView.setGravity(1);
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        TextView textView2 = new TextView(context);
        this.subtitle = textView2;
        if (isChannel) {
            i = R.string.LinkInfoChannel;
            str = "LinkInfoChannel";
        } else {
            i = R.string.LinkInfo;
            str = "LinkInfo";
        }
        textView2.setText(LocaleController.getString(str, i));
        textView2.setTextSize(14.0f);
        textView2.setTypeface(AndroidUtilities.getFontFamily(false));
        textView2.setGravity(1);
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        TextView textView3 = new TextView(context);
        this.manage = textView3;
        textView3.setText(LocaleController.getString("ManageInviteLinks", R.string.ManageInviteLinks));
        textView3.setTextSize(14.0f);
        textView3.setTypeface(AndroidUtilities.getFontFamily(false));
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText"));
        textView3.setBackground(Theme.createRadSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("windowBackgroundWhiteBlueText"), 76), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f)));
        textView3.setPadding(AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(12.0f), AndroidUtilities.dp(4.0f));
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$PermanentLinkBottomSheet$woXtZ6KvThcahVjWZyJi64_4DZM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$PermanentLinkBottomSheet(info, fragment, view);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView(rLottieImageView, LayoutHelper.createLinear(90, 90, 1, 0, 24, 0, 0));
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2, 1, 60, 16, 60, 0));
        linearLayout.addView(textView2, LayoutHelper.createLinear(-1, -2, 1, 60, 16, 60, 0));
        linearLayout.addView(linkActionView, LayoutHelper.createLinear(-1, -2));
        NestedScrollView nestedScrollView = new NestedScrollView(context);
        nestedScrollView.setVerticalScrollBarEnabled(false);
        nestedScrollView.addView(linearLayout);
        setCustomView(nestedScrollView);
        TLRPC$Chat chat = MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(chatId));
        if (chat != null && chat.username != null) {
            linkActionView.setLink("https://eitaa.com/" + chat.username);
            textView3.setVisibility(8);
        } else {
            TLRPC$ExportedChatInvite tLRPC$ExportedChatInvite = info.exported_invite;
            if (tLRPC$ExportedChatInvite != null) {
                linkActionView.setLink(tLRPC$ExportedChatInvite.link);
            } else {
                generateLink(false);
            }
        }
        updateColors();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$PermanentLinkBottomSheet() {
        generateLink(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$PermanentLinkBottomSheet(TLRPC$ChatFull tLRPC$ChatFull, BaseFragment baseFragment, View view) {
        ManageLinksActivity manageLinksActivity = new ManageLinksActivity(tLRPC$ChatFull.id, 0L, 0);
        manageLinksActivity.setInfo(tLRPC$ChatFull, tLRPC$ChatFull.exported_invite);
        baseFragment.presentFragment(manageLinksActivity);
        dismiss();
    }

    private void generateLink(final boolean showDialog) {
        if (this.linkGenerating) {
            return;
        }
        this.linkGenerating = true;
        TLRPC$TL_channels_exportInvite tLRPC$TL_channels_exportInvite = new TLRPC$TL_channels_exportInvite();
        tLRPC$TL_channels_exportInvite.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(this.info.id);
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_exportInvite, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$PermanentLinkBottomSheet$NrYwC_mLSlI4WRo8ZYmS5As7ug0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$generateLink$3$PermanentLinkBottomSheet(showDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateLink$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateLink$3$PermanentLinkBottomSheet(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PermanentLinkBottomSheet$ijupcj9nv4xEz1p0_SanCPOgaik
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$generateLink$2$PermanentLinkBottomSheet(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$generateLink$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$generateLink$2$PermanentLinkBottomSheet(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            this.invite = (TLRPC$ExportedChatInvite) tLObject;
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
        }
        this.linkGenerating = false;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog
    public void show() {
        super.show();
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$PermanentLinkBottomSheet$luw01oDTmM05b9X8hLPImUW0diM
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$4$PermanentLinkBottomSheet();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$show$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$show$4$PermanentLinkBottomSheet() {
        this.linkIcon.start();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$PermanentLinkBottomSheet$nFoQbF-SOWIkqf5pszgRGV8wBhQ
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.updateColors();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.titleView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.manage, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "featuredStickers_buttonText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateColors() {
        this.imageView.setBackground(Theme.createCircleDrawable(AndroidUtilities.dp(90.0f), Theme.getColor("featuredStickers_addButton")));
        this.manage.setBackground(Theme.createRadSelectorDrawable(ColorUtils.setAlphaComponent(Theme.getColor("windowBackgroundWhiteBlueText"), 76), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f)));
        int color = Theme.getColor("featuredStickers_buttonText");
        this.linkIcon.setLayerColor("Top.**", color);
        this.linkIcon.setLayerColor("Bottom.**", color);
        this.linkIcon.setLayerColor("Center.**", color);
        this.linkActionView.updateColors();
        setBackgroundColor(Theme.getColor("dialogBackground"));
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }
}
