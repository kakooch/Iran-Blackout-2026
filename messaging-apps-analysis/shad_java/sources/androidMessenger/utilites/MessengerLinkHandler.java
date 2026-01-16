package androidMessenger.utilites;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidMessenger.dialog.ThreeButtonDialog;
import androidMessenger.helper.GlideHelper;
import androidMessenger.model.GetBaseInfoOutput;
import androidMessenger.model.GetLinkObjectOutput;
import androidMessenger.model.MessangerOutput;
import androidMessenger.model.UpdateObject2;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MessengerLinkHandler;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.google.gson.Gson;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.observers.DisposableObserver;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.GetLinkFromAppUrlInput;
import ir.aaap.messengercore.model.GetLinkFromAppUrlOutput;
import ir.aaap.messengercore.model.Link;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.ProductMessageData;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.shop.PersonalDetailBottomSheet;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.ShopModels;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolveUsername;
import org.rbmain.tgnet.TLRPC$TL_contacts_resolvedPeer;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputStickerSetID;
import org.rbmain.tgnet.TLRPC$TL_messageMediaRubinoProduct;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.AudioPlayerAlert;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.ChatActivityEnterView;
import org.rbmain.ui.Components.StickersAlert;
import org.rbmain.ui.Components.voip.VoIPHelper;
import org.rbmain.ui.LiveActivity;
import org.rbmain.ui.PhotoViewer;
import org.rbmain.ui.ProfileActivity;

/* loaded from: classes.dex */
public class MessengerLinkHandler extends BaseController {
    private static final Gson gson = new Gson();
    private static volatile MessengerLinkHandler[] Instance = new MessengerLinkHandler[3];

    public interface Delegate {
        void onGetLinkAppUrl(AlertDialog alertDialog, Link link);
    }

    public static Link convertToCoreLink(ir.resaneh1.iptv.model.Link link) {
        if (link == null) {
            return null;
        }
        try {
            Gson gson2 = gson;
            return (Link) gson2.fromJson(gson2.toJson(link), Link.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public ir.resaneh1.iptv.model.Link convertToMessengerAppLink(Link link) {
        if (link == null) {
            return null;
        }
        try {
            return (ir.resaneh1.iptv.model.Link) gson.fromJson(new JSONObject(link).toString(), ir.resaneh1.iptv.model.Link.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ir.resaneh1.iptv.model.Link convertToAppLink(Link link) {
        if (link == null) {
            return null;
        }
        try {
            return (ir.resaneh1.iptv.model.Link) gson.fromJson(new JSONObject(link).toString(), ir.resaneh1.iptv.model.Link.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ir.resaneh1.iptv.model.Link convertToAppLink(ir.resaneh1.iptv.model.Link link) {
        if (link == null) {
            return null;
        }
        try {
            return (ir.resaneh1.iptv.model.Link) gson.fromJson(ApplicationLoader.getGson().toJson(link), ir.resaneh1.iptv.model.Link.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static MessengerLinkHandler getInstance(int i) {
        MessengerLinkHandler messengerLinkHandler = Instance[i];
        if (messengerLinkHandler == null) {
            synchronized (MessengerLinkHandler.class) {
                messengerLinkHandler = Instance[i];
                if (messengerLinkHandler == null) {
                    MessengerLinkHandler[] messengerLinkHandlerArr = Instance;
                    MessengerLinkHandler messengerLinkHandler2 = new MessengerLinkHandler(i);
                    messengerLinkHandlerArr[i] = messengerLinkHandler2;
                    messengerLinkHandler = messengerLinkHandler2;
                }
            }
        }
        return messengerLinkHandler;
    }

    public MessengerLinkHandler(int i) {
        super(i);
        this.currentAccount = i;
    }

    /* renamed from: onLinkClick, reason: merged with bridge method [inline-methods] */
    public void lambda$showDialogWithLink$30(ir.resaneh1.iptv.model.Link link) {
        new MainClickHandler().onLinkClick(convertToAppLink(link));
    }

    public void onLinkClick(BaseFragment baseFragment, ir.resaneh1.iptv.model.Link link) {
        new MainClickHandler().onLinkClick(baseFragment, convertToAppLink(link));
    }

    public void onLinkClick(Link link) {
        new MainClickHandler().onLinkClick(convertToAppLink(link));
    }

    public void onLinkClick(BaseFragment baseFragment, Link link) {
        new MainClickHandler().onLinkClick(baseFragment, convertToAppLink(link));
    }

    public void onMessengerLinkClick(final BaseFragment baseFragment, final ir.resaneh1.iptv.model.Link link) {
        if (link == null) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessengerLinkClick$0(link, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerLinkClick$0(ir.resaneh1.iptv.model.Link link, BaseFragment baseFragment) {
        ir.resaneh1.iptv.model.Link link2;
        try {
            if (PhotoViewer.hasInstance() && PhotoViewer.getInstance().isVisible()) {
                PhotoViewer.getInstance().closePhoto(false, true);
            }
            ir.resaneh1.iptv.model.Link link3 = link.if_supperted_link;
            if (link3 == null && link.not_supperted_link == null) {
                onLinkClickInternal(baseFragment, link, true);
                return;
            }
            boolean zOnLinkClickInternal = link3 != null ? onLinkClickInternal(baseFragment, link3, false) : false;
            if (!zOnLinkClickInternal) {
                zOnLinkClickInternal = onLinkClickInternal(baseFragment, link, link.not_supperted_link == null);
            }
            if (zOnLinkClickInternal || (link2 = link.not_supperted_link) == null) {
                return;
            }
            onLinkClickInternal(baseFragment, link2, true);
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean onLinkClickInternal(org.rbmain.ui.ActionBar.BaseFragment r21, final ir.resaneh1.iptv.model.Link r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.utilites.MessengerLinkHandler.onLinkClickInternal(org.rbmain.ui.ActionBar.BaseFragment, ir.resaneh1.iptv.model.Link, boolean):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToastWithBulletin(final BaseFragment baseFragment, String str, int i) {
        final Bulletin bulletinCreateCustomBulletin;
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        if (i <= 0) {
            bulletinCreateCustomBulletin = BulletinFactory.of(baseFragment).createCustomBulletin(str);
        } else {
            bulletinCreateCustomBulletin = BulletinFactory.of(baseFragment).createCustomBulletin(str, i);
        }
        AndroidUtilities.runOnUIThread(new Runnable(this) { // from class: androidMessenger.utilites.MessengerLinkHandler.2
            @Override // java.lang.Runnable
            public void run() {
                if (baseFragment.getParentActivity() != null) {
                    bulletinCreateCustomBulletin.show();
                }
            }
        }, 200L);
    }

    private void openChatProfile(BaseFragment baseFragment, String str, ChatType chatType) {
        if (str == null || chatType == null || baseFragment == null) {
            return;
        }
        if (str.equals(getCoreMainClass().getMyGuid())) {
            openChat(baseFragment, str, chatType, 0L, false, false);
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(ApplicationLoader.applicationActivity, 3);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                alertDialog.show();
            }
        });
        getCoreMainClass().refreshObjectInfo(str, chatType, true, new AnonymousClass3(alertDialog, str, chatType, baseFragment), true);
    }

    /* renamed from: androidMessenger.utilites.MessengerLinkHandler$3, reason: invalid class name */
    class AnonymousClass3 implements LoadListener<String> {
        final /* synthetic */ BaseFragment val$baseFragment;
        final /* synthetic */ AlertDialog val$loadingDialog;
        final /* synthetic */ String val$object_guid;
        final /* synthetic */ ChatType val$type;

        AnonymousClass3(AlertDialog alertDialog, String str, ChatType chatType, BaseFragment baseFragment) {
            this.val$loadingDialog = alertDialog;
            this.val$object_guid = str;
            this.val$type = chatType;
            this.val$baseFragment = baseFragment;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(String str) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            final String str2 = this.val$object_guid;
            final ChatType chatType = this.val$type;
            final BaseFragment baseFragment = this.val$baseFragment;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(alertDialog, str2, chatType, baseFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(AlertDialog alertDialog, String str, ChatType chatType, BaseFragment baseFragment) {
            MessengerLinkHandler.this.lambda$openLive$31(alertDialog);
            long dialogId = ChatConverter.getDialogId(str, chatType);
            Bundle bundle = new Bundle();
            if (dialogId < 0) {
                bundle.putInt("chat_id", (int) (-dialogId));
            } else if (dialogId != MessengerLinkHandler.this.getUserConfig().getClientUserId()) {
                bundle.putInt("user_id", (int) dialogId);
            }
            baseFragment.presentFragment(new ProfileActivity(bundle));
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            final BaseFragment baseFragment = this.val$baseFragment;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$1(alertDialog, baseFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1(AlertDialog alertDialog, BaseFragment baseFragment) {
            MessengerLinkHandler.this.lambda$openLive$31(alertDialog);
            MessengerLinkHandler.this.showToastWithBulletin(baseFragment, LocaleController.getString("NoUsernameFound", R.string.NoUsernameFound), -1);
        }
    }

    private void onAddShortcutClick(final BaseFragment baseFragment, final Link.AddShortcutDataInLink addShortcutDataInLink) {
        if (addShortcutDataInLink == null) {
            return;
        }
        if (addShortcutDataInLink.ask_create) {
            AlertsCreator.showAskAlert(baseFragment.getParentActivity(), addShortcutDataInLink.ask_dialog_text, new AlertsCreator.AskAlertDelegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda36
                @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
                public final void onAccepted() {
                    this.f$0.lambda$onAddShortcutClick$1(baseFragment, addShortcutDataInLink);
                }
            });
        } else {
            installShortcut(baseFragment.getParentActivity(), addShortcutDataInLink.link, addShortcutDataInLink.icon_url, addShortcutDataInLink.label, addShortcutDataInLink.shortcut_id, addShortcutDataInLink.icon_place_holder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAddShortcutClick$1(BaseFragment baseFragment, Link.AddShortcutDataInLink addShortcutDataInLink) {
        installShortcut(baseFragment.getParentActivity(), addShortcutDataInLink.link, addShortcutDataInLink.icon_url, addShortcutDataInLink.label, addShortcutDataInLink.shortcut_id, addShortcutDataInLink.icon_place_holder);
    }

    private void installShortcut(final Context context, final ir.resaneh1.iptv.model.Link link, String str, final String str2, final String str3, int i) {
        if (((str == null || str.isEmpty()) && i == 0) || !ShortcutManagerCompat.isRequestPinShortcutSupported(context)) {
            return;
        }
        GlideHelper.loadCircle(context, str, R.mipmap.ic_launcher, i, new GlideHelper.Delegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda2
            @Override // androidMessenger.helper.GlideHelper.Delegate
            public final void onDone(Bitmap bitmap) {
                this.f$0.lambda$installShortcut$2(context, link, str2, str3, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$installShortcut$2(Context context, ir.resaneh1.iptv.model.Link link, String str, String str2, Bitmap bitmap) {
        if (getMediaDataController().updateShortcutIfExist(context, link, bitmap, str, str2)) {
            ToastiLikeSnack.showMessageLikeToast("میانبر به روز رسانی شد");
        } else {
            getMediaDataController().installShortcut(link, bitmap, str, str2);
        }
    }

    private void openStickers(final BaseFragment baseFragment, final Link.OpenStickerData openStickerData) {
        if (openStickerData == null) {
            return;
        }
        getMessagesProxy().loadStickers(0);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                MessengerLinkHandler.lambda$openStickers$4(openStickerData, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$openStickers$4(final Link.OpenStickerData openStickerData, final BaseFragment baseFragment) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                MessengerLinkHandler.lambda$openStickers$3(openStickerData, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$openStickers$3(Link.OpenStickerData openStickerData, BaseFragment baseFragment) {
        String str = openStickerData.stickerSetId;
        if (str == null || ApplicationLoader.applicationActivity == null || baseFragment == null) {
            return;
        }
        ChatActivityEnterView chatActivityEnterView = baseFragment instanceof ChatActivity ? ((ChatActivity) baseFragment).getChatActivityEnterView() : null;
        TLRPC$TL_inputStickerSetID tLRPC$TL_inputStickerSetID = new TLRPC$TL_inputStickerSetID();
        tLRPC$TL_inputStickerSetID.access_hash = 0L;
        tLRPC$TL_inputStickerSetID.id = IdStorage.getInstance().generateStickerSetId(str);
        StickersAlert stickersAlert = new StickersAlert(baseFragment.getParentActivity(), baseFragment, tLRPC$TL_inputStickerSetID, null, chatActivityEnterView);
        stickersAlert.setCalcMandatoryInsets(false);
        baseFragment.showDialog(stickersAlert);
    }

    public void openChat(final BaseFragment baseFragment, final String str, final ChatType chatType, long j, boolean z, boolean z2) {
        long jGenerateDialogId;
        if (chatType == null || TextUtils.isEmpty(str) || baseFragment == null) {
            return;
        }
        final Bundle bundle = new Bundle();
        if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
            jGenerateDialogId = IdStorage.getInstance().generateDialogId(str);
        } else {
            jGenerateDialogId = IdStorage.getInstance().generateNegativeDialogId(str);
        }
        int i = (int) jGenerateDialogId;
        if (i > 0) {
            bundle.putInt("user_id", i);
        } else {
            bundle.putInt("chat_id", -i);
        }
        if (j > 0) {
            bundle.putLong("message_id", j);
        }
        if (getMessagesController().checkCanOpenChat(bundle, baseFragment)) {
            final AlertDialog alertDialog = new AlertDialog(ApplicationLoader.applicationActivity, 3);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    MessengerLinkHandler.lambda$openChat$5(alertDialog);
                }
            });
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$openChat$7(str, chatType, alertDialog, baseFragment, bundle);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$openChat$5(AlertDialog alertDialog) {
        try {
            alertDialog.show();
        } catch (Exception unused) {
        }
    }

    /* renamed from: androidMessenger.utilites.MessengerLinkHandler$4, reason: invalid class name */
    class AnonymousClass4 implements LoadListener<String> {
        final /* synthetic */ Bundle val$args;
        final /* synthetic */ BaseFragment val$baseFragment;
        final /* synthetic */ AlertDialog val$loadingDialog;

        AnonymousClass4(AlertDialog alertDialog, BaseFragment baseFragment, Bundle bundle) {
            this.val$loadingDialog = alertDialog;
            this.val$baseFragment = baseFragment;
            this.val$args = bundle;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(String str) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            final BaseFragment baseFragment = this.val$baseFragment;
            final Bundle bundle = this.val$args;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(alertDialog, baseFragment, bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(AlertDialog alertDialog, BaseFragment baseFragment, Bundle bundle) {
            MessengerLinkHandler.this.lambda$openLive$31(alertDialog);
            baseFragment.presentFragment(new ChatActivity(bundle));
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(final Exception exc) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            final BaseFragment baseFragment = this.val$baseFragment;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$4$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$1(alertDialog, baseFragment, exc);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1(AlertDialog alertDialog, BaseFragment baseFragment, Exception exc) {
            MessengerLinkHandler.this.lambda$openLive$31(alertDialog);
            if (MyLog.isDebugAble) {
                AlertsCreator.showSimpleToast(baseFragment, exc.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openChat$7(final String str, ChatType chatType, AlertDialog alertDialog, BaseFragment baseFragment, Bundle bundle) {
        final int iRefreshObjectInfo = getCoreMainClass().refreshObjectInfo(str, chatType, false, new AnonymousClass4(alertDialog, baseFragment, bundle), true);
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$openChat$6(iRefreshObjectInfo, str, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openChat$6(int i, String str, DialogInterface dialogInterface) {
        if (i > 0) {
            getCoreMainClass().cancelRequest(i);
            getCoreMainClass().cancelRefreshObjectInfo(str);
        }
    }

    public void startVoipCall(BaseFragment baseFragment, String str) {
        int iGenerateDialogId = (int) IdStorage.getInstance().generateDialogId(str);
        TLRPC$User user = getMessagesController().getUser(Integer.valueOf(iGenerateDialogId));
        TLRPC$UserFull userFull = getMessagesController().getUserFull(iGenerateDialogId);
        if (user != null) {
            VoIPHelper.startCall(user, false, userFull != null && userFull.video_calls_available, baseFragment.getParentActivity(), getMessagesController().getUserFull(iGenerateDialogId), getAccountInstance());
        }
    }

    public void openMusicAlert() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        BaseFragment lastFragment = ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment();
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if (lastFragment == null || playingMessageObject == null || !playingMessageObject.isMusic()) {
            return;
        }
        lastFragment.showDialog(new AudioPlayerAlert(ApplicationLoader.applicationActivity, null));
    }

    public void onCopyClicked(String str, String str2) {
        if (str == null) {
            return;
        }
        try {
            AndroidUtilities.addToClipboard(str);
            if (str2 == null) {
                str2 = "کپی شد";
            }
            ToastiLikeSnack.showMessageLikeToast(str2);
        } catch (Exception unused) {
        }
    }

    private void showMultiButtonDialogWithLink(Link.AskAlertDataInLink askAlertDataInLink) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        String str = askAlertDataInLink.message;
        ArrayList<Link.TextLinkObject> arrayList = askAlertDataInLink.buttons;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(ApplicationLoader.applicationActivity, str);
        if (askAlertDataInLink.buttons.size() >= 1) {
            final Link.TextLinkObject textLinkObject = askAlertDataInLink.buttons.get(0);
            threeButtonDialog.button1.setText(textLinkObject.text);
            threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: androidMessenger.utilites.MessengerLinkHandler.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (textLinkObject.link != null && ApplicationLoader.applicationActivity != null) {
                        MessengerLinkHandler.this.onLinkClick(ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment(), textLinkObject.link);
                    }
                    threeButtonDialog.dismiss();
                }
            });
        }
        if (askAlertDataInLink.buttons.size() >= 2) {
            final Link.TextLinkObject textLinkObject2 = askAlertDataInLink.buttons.get(1);
            threeButtonDialog.button2.setText(textLinkObject2.text);
            threeButtonDialog.button2.setOnClickListener(new View.OnClickListener() { // from class: androidMessenger.utilites.MessengerLinkHandler.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (textLinkObject2.link != null && ApplicationLoader.applicationActivity != null) {
                        MessengerLinkHandler.this.onLinkClick(ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment(), textLinkObject2.link);
                    }
                    threeButtonDialog.dismiss();
                }
            });
        }
        if (askAlertDataInLink.buttons.size() >= 3) {
            final Link.TextLinkObject textLinkObject3 = askAlertDataInLink.buttons.get(2);
            threeButtonDialog.button3.setText(textLinkObject3.text);
            threeButtonDialog.button3.setOnClickListener(new View.OnClickListener() { // from class: androidMessenger.utilites.MessengerLinkHandler.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (textLinkObject3.link != null && ApplicationLoader.applicationActivity != null) {
                        MessengerLinkHandler.this.onLinkClick(ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment(), textLinkObject3.link);
                    }
                    threeButtonDialog.dismiss();
                }
            });
        }
        threeButtonDialog.show();
    }

    public boolean openUrl(String str) {
        return openUrl(str, false, false, null, null, false);
    }

    public boolean openUrlFromMessenger(String str, String str2, long j) {
        String str3;
        if (j > 0) {
            str3 = j + BuildConfig.FLAVOR;
        } else {
            str3 = null;
        }
        return openUrl(str, false, false, str2, str3, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00de, code lost:
    
        if (r0.equals("www." + org.rbmain.messenger.LocaleController.getString(ir.medu.shad.R.string.appHostDomainPlain)) != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean openUrl(java.lang.String r7, boolean r8, boolean r9, java.lang.String r10, java.lang.String r11, boolean r12) throws java.net.URISyntaxException {
        /*
            r6 = this;
            java.lang.String r9 = "http"
            r12 = 0
            boolean r0 = r7.startsWith(r9)     // Catch: java.lang.Exception -> Lfe
            if (r0 != 0) goto L22
            java.lang.String r0 = "://"
            boolean r0 = r7.contains(r0)     // Catch: java.lang.Exception -> Lfe
            if (r0 != 0) goto L22
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r0.<init>()     // Catch: java.lang.Exception -> Lfe
            java.lang.String r1 = "http://"
            r0.append(r1)     // Catch: java.lang.Exception -> Lfe
            r0.append(r7)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Exception -> Lfe
        L22:
            android.net.Uri r0 = android.net.Uri.parse(r7)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r1 = r0.getScheme()     // Catch: java.lang.Exception -> Lfe
            java.lang.String r0 = r0.getHost()     // Catch: java.lang.Exception -> Lfe
            r2 = 0
            if (r0 == 0) goto L36
            java.lang.String r0 = r0.toLowerCase()     // Catch: java.lang.Exception -> Lfe
            goto L37
        L36:
            r0 = r2
        L37:
            if (r1 == 0) goto L3d
            java.lang.String r2 = r1.toLowerCase()     // Catch: java.lang.Exception -> Lfe
        L3d:
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> Lfe
            java.lang.String r3 = "android.intent.action.VIEW"
            r1.<init>(r3)     // Catch: java.lang.Exception -> Lfe
            android.net.Uri r3 = android.net.Uri.parse(r7)     // Catch: java.lang.Exception -> Lfe
            r1.setData(r3)     // Catch: java.lang.Exception -> Lfe
            r3 = 1
            if (r2 == 0) goto L5a
            java.lang.String r4 = "intent"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> Lfe
            if (r4 == 0) goto L5a
            android.content.Intent r1 = android.content.Intent.parseUri(r7, r3)     // Catch: java.lang.Exception -> Lfe
        L5a:
            org.rbmain.ui.LaunchActivity r4 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> Lfe
            java.lang.String r5 = "https"
            if (r4 == 0) goto La6
            if (r2 == 0) goto L6f
            r4 = 2131892951(0x7f121ad7, float:1.9420665E38)
            java.lang.String r4 = org.rbmain.messenger.LocaleController.getString(r4)     // Catch: java.lang.Exception -> Lfe
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> Lfe
            if (r4 != 0) goto L8c
        L6f:
            if (r0 == 0) goto La6
            if (r2 == 0) goto La6
            boolean r4 = r2.equals(r9)     // Catch: java.lang.Exception -> Lfe
            if (r4 != 0) goto L7f
            boolean r4 = r2.equals(r5)     // Catch: java.lang.Exception -> Lfe
            if (r4 == 0) goto La6
        L7f:
            r4 = 2131892949(0x7f121ad5, float:1.942066E38)
            java.lang.String r4 = org.rbmain.messenger.LocaleController.getString(r4)     // Catch: java.lang.Exception -> Lfe
            boolean r4 = r0.equals(r4)     // Catch: java.lang.Exception -> Lfe
            if (r4 == 0) goto La6
        L8c:
            android.content.ComponentName r7 = new android.content.ComponentName     // Catch: java.lang.Exception -> Lfe
            android.content.Context r8 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> Lfe
            java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Exception -> Lfe
            java.lang.Class<org.rbmain.ui.LaunchActivity> r9 = org.rbmain.ui.LaunchActivity.class
            java.lang.String r9 = r9.getName()     // Catch: java.lang.Exception -> Lfe
            r7.<init>(r8, r9)     // Catch: java.lang.Exception -> Lfe
            r1.setComponent(r7)     // Catch: java.lang.Exception -> Lfe
            org.rbmain.ui.LaunchActivity r7 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> Lfe
            r7.startActivity(r1)     // Catch: java.lang.Exception -> Lfe
            return r3
        La6:
            if (r8 != 0) goto Le4
            if (r2 == 0) goto Le4
            if (r0 == 0) goto Le4
            boolean r8 = r2.equals(r9)     // Catch: java.lang.Exception -> Lfe
            if (r8 != 0) goto Lb8
            boolean r8 = r2.equals(r5)     // Catch: java.lang.Exception -> Lfe
            if (r8 == 0) goto Le4
        Lb8:
            r8 = 2131892948(0x7f121ad4, float:1.9420659E38)
            java.lang.String r9 = org.rbmain.messenger.LocaleController.getString(r8)     // Catch: java.lang.Exception -> Lfe
            boolean r9 = r0.equals(r9)     // Catch: java.lang.Exception -> Lfe
            if (r9 != 0) goto Le0
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lfe
            r9.<init>()     // Catch: java.lang.Exception -> Lfe
            java.lang.String r1 = "www."
            r9.append(r1)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r8 = org.rbmain.messenger.LocaleController.getString(r8)     // Catch: java.lang.Exception -> Lfe
            r9.append(r8)     // Catch: java.lang.Exception -> Lfe
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Exception -> Lfe
            boolean r8 = r0.equals(r8)     // Catch: java.lang.Exception -> Lfe
            if (r8 == 0) goto Le4
        Le0:
            r6.getLinkAppUrl(r7)     // Catch: java.lang.Exception -> Lfe
            return r3
        Le4:
            if (r11 == 0) goto Lef
            boolean r8 = r11.isEmpty()     // Catch: java.lang.Exception -> Lf9
            if (r8 != 0) goto Lef
            r6.callMessageUrlClick(r10, r11, r7)     // Catch: java.lang.Exception -> Lf9
        Lef:
            org.rbmain.ui.LaunchActivity r8 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> Lf9
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch: java.lang.Exception -> Lf9
            org.rbmain.messenger.browser.Browser.openUrInside(r8, r7, r3, r12)     // Catch: java.lang.Exception -> Lf9
            goto L102
        Lf9:
            r7 = move-exception
            androidMessenger.utilites.MyLog.handleException(r7)     // Catch: java.lang.Exception -> Lfe
            goto L102
        Lfe:
            r7 = move-exception
            androidMessenger.utilites.MyLog.handleException(r7)
        L102:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.utilites.MessengerLinkHandler.openUrl(java.lang.String, boolean, boolean, java.lang.String, java.lang.String, boolean):boolean");
    }

    private void getLinkAppUrl(String str) {
        getLinkAppUrl(str, new Delegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda3
            @Override // androidMessenger.utilites.MessengerLinkHandler.Delegate
            public final void onGetLinkAppUrl(AlertDialog alertDialog, ir.aaap.messengercore.model.Link link) {
                this.f$0.lambda$getLinkAppUrl$8(alertDialog, link);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLinkAppUrl$8(AlertDialog alertDialog, ir.aaap.messengercore.model.Link link) {
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
        }
        onLinkClick(link);
    }

    private void getLinkAppUrl(final String str, final Delegate delegate) {
        if (ApplicationLoader.applicationActivity == null || TextUtils.isEmpty(str) || delegate == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(ApplicationLoader.applicationActivity, 3);
        alertDialog.show();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getLinkAppUrl$10(str, delegate, alertDialog);
            }
        });
    }

    /* renamed from: androidMessenger.utilites.MessengerLinkHandler$8, reason: invalid class name */
    class AnonymousClass8 implements LoadListener<GetLinkFromAppUrlOutput> {
        final /* synthetic */ Delegate val$delegate;
        final /* synthetic */ AlertDialog val$loadingDialog;

        AnonymousClass8(MessengerLinkHandler messengerLinkHandler, Delegate delegate, AlertDialog alertDialog) {
            this.val$delegate = delegate;
            this.val$loadingDialog = alertDialog;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final GetLinkFromAppUrlOutput getLinkFromAppUrlOutput) {
            final Delegate delegate = this.val$delegate;
            final AlertDialog alertDialog = this.val$loadingDialog;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$8$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MessengerLinkHandler.AnonymousClass8.lambda$onDidLoad$0(delegate, alertDialog, getLinkFromAppUrlOutput);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onDidLoad$0(Delegate delegate, AlertDialog alertDialog, GetLinkFromAppUrlOutput getLinkFromAppUrlOutput) {
            delegate.onGetLinkAppUrl(alertDialog, getLinkFromAppUrlOutput.link);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$8$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MessengerLinkHandler.AnonymousClass8.lambda$onError$1(alertDialog);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$1(AlertDialog alertDialog) {
            try {
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLinkAppUrl$10(String str, Delegate delegate, AlertDialog alertDialog) {
        final int linkFromAppUrl = getCoreMainClass().getLinkFromAppUrl(str, new AnonymousClass8(this, delegate, alertDialog));
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.f$0.lambda$getLinkAppUrl$9(linkFromAppUrl, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLinkAppUrl$9(int i, DialogInterface dialogInterface) {
        getCoreMainClass().cancelRequest(i);
    }

    public void getLinkByShareString(final String str) {
        final AlertDialog alertDialog = new AlertDialog(ApplicationLoader.applicationActivity, 3);
        alertDialog.show();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getLinkByShareString$11(str, alertDialog);
            }
        });
    }

    /* renamed from: androidMessenger.utilites.MessengerLinkHandler$9, reason: invalid class name */
    class AnonymousClass9 implements LoadListener<GetLinkObjectOutput> {
        final /* synthetic */ AlertDialog val$loadingDialog;

        AnonymousClass9(AlertDialog alertDialog) {
            this.val$loadingDialog = alertDialog;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(final GetLinkObjectOutput getLinkObjectOutput) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$9$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(getLinkObjectOutput, alertDialog);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(GetLinkObjectOutput getLinkObjectOutput, AlertDialog alertDialog) {
            ir.aaap.messengercore.model.Link link;
            if (getLinkObjectOutput.exist && (link = getLinkObjectOutput.link) != null) {
                MessengerLinkHandler messengerLinkHandler = MessengerLinkHandler.this;
                messengerLinkHandler.lambda$showDialogWithLink$30(messengerLinkHandler.convertToMessengerAppLink(link));
            }
            try {
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$9$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MessengerLinkHandler.AnonymousClass9.lambda$onError$1(alertDialog);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onError$1(AlertDialog alertDialog) {
            try {
                alertDialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getLinkByShareString$11(String str, AlertDialog alertDialog) {
        getAppRequestRx().getLinkObject(str, new AnonymousClass9(alertDialog));
    }

    private void callMessageUrlClick(final String str, final String str2, final String str3) {
        if (str == null || str3 == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$callMessageUrlClick$12(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$callMessageUrlClick$12(String str, String str2, String str3) {
        getCoreMainClass().clickMessageUrl(str, str2, str3);
    }

    public void onMessengerUsernameClicked(final BaseFragment baseFragment, final String str, final boolean z, final boolean z2, final String str2, final String str3) {
        if (baseFragment == null || str == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(baseFragment.getParentActivity(), 3);
        alertDialog.setCanCancel(false);
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessengerUsernameClicked$29(str, alertDialog, z, z2, baseFragment, str3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$29(String str, final AlertDialog alertDialog, final boolean z, final boolean z2, final BaseFragment baseFragment, final String str2, final String str3) {
        TLRPC$TL_contacts_resolveUsername tLRPC$TL_contacts_resolveUsername = new TLRPC$TL_contacts_resolveUsername();
        tLRPC$TL_contacts_resolveUsername.username = str;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                MessengerLinkHandler.lambda$onMessengerUsernameClicked$13(alertDialog);
            }
        });
        getDialogsProxy().getObjectInfoByUserName(tLRPC$TL_contacts_resolveUsername, new RequestDelegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda33
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$onMessengerUsernameClicked$28(alertDialog, z, z2, baseFragment, str2, str3, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMessengerUsernameClicked$13(AlertDialog alertDialog) {
        try {
            alertDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$28(final AlertDialog alertDialog, boolean z, final boolean z2, final BaseFragment baseFragment, final String str, final String str2, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$User tLRPC$User;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessengerUsernameClicked$14(alertDialog);
            }
        });
        if (tLObject instanceof TLRPC$TL_contacts_resolvedPeer) {
            TLRPC$TL_contacts_resolvedPeer tLRPC$TL_contacts_resolvedPeer = (TLRPC$TL_contacts_resolvedPeer) tLObject;
            ArrayList<TLRPC$Chat> arrayList = tLRPC$TL_contacts_resolvedPeer.chats;
            if (arrayList != null && !arrayList.isEmpty()) {
                final TLRPC$Chat tLRPC$Chat = tLRPC$TL_contacts_resolvedPeer.chats.get(0);
                if (tLRPC$Chat != null) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda14
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onMessengerUsernameClicked$15(tLRPC$Chat);
                        }
                    });
                    if (tLRPC$Chat.left) {
                        final TLRPC$User currentUser = getUserConfig().getCurrentUser();
                        if (!z || z2) {
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda24
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onMessengerUsernameClicked$18(z2, alertDialog, tLRPC$Chat, currentUser, baseFragment);
                                }
                            });
                            return;
                        } else {
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda23
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onMessengerUsernameClicked$24(baseFragment, tLRPC$Chat, alertDialog, currentUser);
                                }
                            });
                            return;
                        }
                    }
                    if ((str != null && !str.isEmpty()) || (str2 != null && !str2.isEmpty())) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda28
                            @Override // java.lang.Runnable
                            public final void run() {
                                MessagesController.openChatOrProfileWith((TLRPC$User) null, tLRPC$Chat, baseFragment, str2, str);
                            }
                        });
                        return;
                    } else {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda27
                            @Override // java.lang.Runnable
                            public final void run() {
                                MessagesController.openChatOrProfileWith((TLRPC$User) null, tLRPC$Chat, baseFragment, 1, false);
                            }
                        });
                        return;
                    }
                }
                return;
            }
            ArrayList<TLRPC$User> arrayList2 = tLRPC$TL_contacts_resolvedPeer.users;
            if (arrayList2 == null || arrayList2.isEmpty() || (tLRPC$User = tLRPC$TL_contacts_resolvedPeer.users.get(0)) == null) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda29
                @Override // java.lang.Runnable
                public final void run() {
                    MessengerLinkHandler.lambda$onMessengerUsernameClicked$27(tLRPC$User, baseFragment);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$15(TLRPC$Chat tLRPC$Chat) {
        getMessagesController().putChat(tLRPC$Chat, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$18(boolean z, final AlertDialog alertDialog, final TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, final BaseFragment baseFragment) {
        if (z) {
            alertDialog.show();
            getMessagesController().addUserToChat(tLRPC$Chat.id, tLRPC$User, 0, null, baseFragment, new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onMessengerUsernameClicked$17(alertDialog, tLRPC$Chat, baseFragment);
                }
            });
        } else {
            MessagesController.openChatOrProfileWith((TLRPC$User) null, tLRPC$Chat, baseFragment, 1, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$17(final AlertDialog alertDialog, final TLRPC$Chat tLRPC$Chat, final BaseFragment baseFragment) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessengerUsernameClicked$16(alertDialog, tLRPC$Chat, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$16(AlertDialog alertDialog, TLRPC$Chat tLRPC$Chat, BaseFragment baseFragment) {
        lambda$openLive$31(alertDialog);
        MessagesController.openChatOrProfileWith((TLRPC$User) null, tLRPC$Chat, baseFragment, 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$24(final BaseFragment baseFragment, final TLRPC$Chat tLRPC$Chat, final AlertDialog alertDialog, final TLRPC$User tLRPC$User) {
        AlertsCreator.showAskAlert(baseFragment.getParentActivity(), LocaleController.formatString("AreYouSureToJoinThisChannel", R.string.AreYouSureToJoinThisChannel, tLRPC$Chat.title), new AlertsCreator.AskAlertDelegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda35
            @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
            public final void onAccepted() {
                this.f$0.lambda$onMessengerUsernameClicked$22(alertDialog, tLRPC$Chat, tLRPC$User, baseFragment);
            }
        }, new AlertsCreator.DismissDelegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda37
            @Override // org.rbmain.ui.Components.AlertsCreator.DismissDelegate
            public final void onDismissed() {
                MessagesController.openChatOrProfileWith((TLRPC$User) null, tLRPC$Chat, baseFragment, 1, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$22(final AlertDialog alertDialog, final TLRPC$Chat tLRPC$Chat, TLRPC$User tLRPC$User, final BaseFragment baseFragment) {
        alertDialog.show();
        getMessagesController().addUserToChat(tLRPC$Chat.id, tLRPC$User, 0, null, baseFragment, new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessengerUsernameClicked$21(alertDialog, tLRPC$Chat, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$20(final AlertDialog alertDialog, final TLRPC$Chat tLRPC$Chat, final BaseFragment baseFragment) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessengerUsernameClicked$19(alertDialog, tLRPC$Chat, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$21(final AlertDialog alertDialog, final TLRPC$Chat tLRPC$Chat, final BaseFragment baseFragment) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onMessengerUsernameClicked$20(alertDialog, tLRPC$Chat, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onMessengerUsernameClicked$19(AlertDialog alertDialog, TLRPC$Chat tLRPC$Chat, BaseFragment baseFragment) {
        lambda$openLive$31(alertDialog);
        MessagesController.openChatOrProfileWith((TLRPC$User) null, tLRPC$Chat, baseFragment, 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMessengerUsernameClicked$27(TLRPC$User tLRPC$User, BaseFragment baseFragment) {
        MessagesController.openChatOrProfileWith(tLRPC$User, (TLRPC$Chat) null, baseFragment, tLRPC$User.bot ? 3 : 1, false);
    }

    /* renamed from: dismissDialogWithCatch, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$openLive$31(AlertDialog alertDialog) {
        try {
            alertDialog.dismiss();
        } catch (Exception unused) {
        }
    }

    private void showDialogWithLink(Context context, String str, final ir.resaneh1.iptv.model.Link link) {
        AlertsCreator.showAskAlert(context, str, new AlertsCreator.AskAlertDelegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda34
            @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
            public final void onAccepted() {
                this.f$0.lambda$showDialogWithLink$30(link);
            }
        });
    }

    private void showDialog(BaseFragment baseFragment, String str) {
        AlertsCreator.showSimpleAlert(baseFragment, str);
    }

    public void sendSms(String str, String str2) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        try {
            ApplicationLoader.applicationActivity.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void callNumber(String str) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        try {
            ApplicationLoader.applicationActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", str, null)));
        } catch (Exception unused) {
        }
    }

    public void shareStringOrLink(String str) {
        try {
            if (ApplicationLoader.applicationActivity != null) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.addFlags(MessagesController.UPDATE_MASK_CHAT_SHOW_SPAM);
                intent.putExtra("android.intent.extra.TEXT", str);
                ApplicationLoader.applicationActivity.startActivity(Intent.createChooser(intent, "اشتراک گذاری با: "));
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    private void openLive(final BaseFragment baseFragment, final Link.OpenMessengerLiveData openMessengerLiveData) {
        new GetLinkFromAppUrlInput().app_url = openMessengerLiveData.message_share_link;
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        final Message[] messageArr = new Message[1];
        getLinkAppUrl(openMessengerLiveData.message_share_link, new Delegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda4
            @Override // androidMessenger.utilites.MessengerLinkHandler.Delegate
            public final void onGetLinkAppUrl(AlertDialog alertDialog, ir.aaap.messengercore.model.Link link) {
                this.f$0.lambda$openLive$33(messageArr, openMessengerLiveData, baseFragment, alertDialog, link);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openLive$33(final Message[] messageArr, final Link.OpenMessengerLiveData openMessengerLiveData, final BaseFragment baseFragment, final AlertDialog alertDialog, final ir.aaap.messengercore.model.Link link) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openLive$32(link, messageArr, alertDialog, openMessengerLiveData, baseFragment);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openLive$32(ir.aaap.messengercore.model.Link link, Message[] messageArr, final AlertDialog alertDialog, Link.OpenMessengerLiveData openMessengerLiveData, BaseFragment baseFragment) {
        Link.OpenChatDataObject openChatDataObject;
        ir.resaneh1.iptv.model.Link linkConvertToMessengerAppLink = convertToMessengerAppLink(link);
        if (linkConvertToMessengerAppLink != null && (openChatDataObject = linkConvertToMessengerAppLink.open_chat_data) != null && openChatDataObject.message_id != 0) {
            long dialogId = ChatConverter.getDialogId(openChatDataObject.object_guid, openChatDataObject.object_type);
            CoreMainClass coreMainClass = getCoreMainClass();
            Link.OpenChatDataObject openChatDataObject2 = linkConvertToMessengerAppLink.open_chat_data;
            Message messageInstant = coreMainClass.getMessageInstant(openChatDataObject2.object_guid, openChatDataObject2.message_id);
            AnonymousClass10 anonymousClass10 = new AnonymousClass10(messageArr, dialogId, linkConvertToMessengerAppLink, alertDialog, openMessengerLiveData, baseFragment);
            if (messageInstant != null) {
                messageArr[0] = messageInstant;
                CoreMainClass coreMainClass2 = getCoreMainClass();
                Link.OpenChatDataObject openChatDataObject3 = linkConvertToMessengerAppLink.open_chat_data;
                coreMainClass2.refreshObjectInfo(openChatDataObject3.object_guid, openChatDataObject3.object_type, true, anonymousClass10, true);
            } else {
                CoreMainClass coreMainClass3 = getCoreMainClass();
                Link.OpenChatDataObject openChatDataObject4 = linkConvertToMessengerAppLink.open_chat_data;
                coreMainClass3.loadMessageForChat(openChatDataObject4.object_guid, openChatDataObject4.message_id, new AnonymousClass11(messageArr, linkConvertToMessengerAppLink, anonymousClass10, alertDialog));
            }
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$openLive$31(alertDialog);
            }
        });
    }

    /* renamed from: androidMessenger.utilites.MessengerLinkHandler$10, reason: invalid class name */
    class AnonymousClass10 implements LoadListener<String> {
        final /* synthetic */ BaseFragment val$baseFragment;
        final /* synthetic */ long val$did;
        final /* synthetic */ ir.resaneh1.iptv.model.Link val$link;
        final /* synthetic */ AlertDialog val$loadingDialog;
        final /* synthetic */ Message[] val$message;
        final /* synthetic */ Link.OpenMessengerLiveData val$open_messenger_live_data;

        AnonymousClass10(Message[] messageArr, long j, ir.resaneh1.iptv.model.Link link, AlertDialog alertDialog, Link.OpenMessengerLiveData openMessengerLiveData, BaseFragment baseFragment) {
            this.val$message = messageArr;
            this.val$did = j;
            this.val$link = link;
            this.val$loadingDialog = alertDialog;
            this.val$open_messenger_live_data = openMessengerLiveData;
            this.val$baseFragment = baseFragment;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(String str) {
            Message[] messageArr = this.val$message;
            if (messageArr[0] == null || messageArr[0].live_data == null) {
                return;
            }
            final TLRPC$Message tLRPC$MessageConvertToTlMessage = MessageConverter.convertToTlMessage(MessengerLinkHandler.this.getCoreMainClass(), this.val$did, this.val$link.open_chat_data.object_type == ChatType.Channel, this.val$message[0], null);
            final AlertDialog alertDialog = this.val$loadingDialog;
            final long j = this.val$did;
            final Link.OpenMessengerLiveData openMessengerLiveData = this.val$open_messenger_live_data;
            final BaseFragment baseFragment = this.val$baseFragment;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$10$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onDidLoad$0(alertDialog, tLRPC$MessageConvertToTlMessage, j, openMessengerLiveData, baseFragment);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDidLoad$0(AlertDialog alertDialog, TLRPC$Message tLRPC$Message, long j, Link.OpenMessengerLiveData openMessengerLiveData, BaseFragment baseFragment) {
            MessengerLinkHandler.this.lambda$openLive$31(alertDialog);
            baseFragment.presentFragment(new LiveActivity(j, new MessageObject(((BaseController) MessengerLinkHandler.this).currentAccount, tLRPC$Message, false, true), openMessengerLiveData.show_clean));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1(AlertDialog alertDialog) {
            MessengerLinkHandler.this.lambda$openLive$31(alertDialog);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$10$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$1(alertDialog);
                }
            });
        }
    }

    /* renamed from: androidMessenger.utilites.MessengerLinkHandler$11, reason: invalid class name */
    class AnonymousClass11 implements LoadListener<Integer> {
        final /* synthetic */ ir.resaneh1.iptv.model.Link val$link;
        final /* synthetic */ AlertDialog val$loadingDialog;
        final /* synthetic */ Message[] val$message;
        final /* synthetic */ LoadListener val$onObjectInfo;

        AnonymousClass11(Message[] messageArr, ir.resaneh1.iptv.model.Link link, LoadListener loadListener, AlertDialog alertDialog) {
            this.val$message = messageArr;
            this.val$link = link;
            this.val$onObjectInfo = loadListener;
            this.val$loadingDialog = alertDialog;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(Integer num) {
            Message[] messageArr = this.val$message;
            CoreMainClass coreMainClass = MessengerLinkHandler.this.getCoreMainClass();
            Link.OpenChatDataObject openChatDataObject = this.val$link.open_chat_data;
            messageArr[0] = coreMainClass.getMessageInstant(openChatDataObject.object_guid, openChatDataObject.message_id);
            CoreMainClass coreMainClass2 = MessengerLinkHandler.this.getCoreMainClass();
            Link.OpenChatDataObject openChatDataObject2 = this.val$link.open_chat_data;
            coreMainClass2.refreshObjectInfo(openChatDataObject2.object_guid, openChatDataObject2.object_type, true, this.val$onObjectInfo, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$0(AlertDialog alertDialog) {
            MessengerLinkHandler.this.lambda$openLive$31(alertDialog);
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            final AlertDialog alertDialog = this.val$loadingDialog;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$11$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onError$0(alertDialog);
                }
            });
        }
    }

    private void onUpdateClick(final BaseFragment baseFragment) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onUpdateClick$34(baseFragment);
            }
        });
    }

    /* renamed from: androidMessenger.utilites.MessengerLinkHandler$12, reason: invalid class name */
    class AnonymousClass12 extends DisposableObserver<MessangerOutput<GetBaseInfoOutput>> {
        final /* synthetic */ BaseFragment val$baseFragment;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
        }

        AnonymousClass12(BaseFragment baseFragment) {
            this.val$baseFragment = baseFragment;
        }

        @Override // io.reactivex.Observer
        public void onNext(MessangerOutput<GetBaseInfoOutput> messangerOutput) {
            GetBaseInfoOutput getBaseInfoOutput = messangerOutput.data;
            if (getBaseInfoOutput == null) {
                return;
            }
            final UpdateObject2 updateObject2 = getBaseInfoOutput.update;
            final String appVersion = UpdateUtils.getAppVersion(ApplicationLoader.applicationContext);
            final BaseFragment baseFragment = this.val$baseFragment;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.utilites.MessengerLinkHandler$12$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNext$0(appVersion, updateObject2, baseFragment);
                }
            });
            try {
                AppPreferences.getInstance(UserConfig.selectedAccount).setString(AppPreferences.Key.baseInfoObject, ApplicationLoader.getGson().toJson(messangerOutput.data));
            } catch (Exception e) {
                MyLog.handleException(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNext$0(String str, UpdateObject2 updateObject2, BaseFragment baseFragment) {
            if (UpdateUtils.versionCompare(str, updateObject2.latest_version) >= 0) {
                MessengerLinkHandler.this.showToastWithBulletin(baseFragment, LocaleController.getString("NoUpdateFound", R.string.NoUpdateFound), -1);
            } else {
                AlertsCreator.createUpdateAlert(baseFragment, updateObject2).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUpdateClick$34(BaseFragment baseFragment) {
    }

    private void openPersonalDetailBottomSheet(final Link.ProductMessageLinkData productMessageLinkData) {
        BaseFragment lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
        if (productMessageLinkData.get_address_info) {
            PersonalDetailBottomSheet personalDetailBottomSheet = new PersonalDetailBottomSheet(lastFragment.getContext(), lastFragment.getCurrentAccount());
            personalDetailBottomSheet.setDelegate(new PersonalDetailBottomSheet.PersonalDetailDelegate() { // from class: androidMessenger.utilites.MessengerLinkHandler$$ExternalSyntheticLambda5
                @Override // ir.resaneh1.iptv.fragment.rubino.shop.PersonalDetailBottomSheet.PersonalDetailDelegate
                public final void onDone(ShopModels.PersonalDetail personalDetail) {
                    this.f$0.lambda$openPersonalDetailBottomSheet$35(productMessageLinkData, personalDetail);
                }
            });
            lastFragment.showDialog(personalDetailBottomSheet);
            return;
        }
        lambda$openPersonalDetailBottomSheet$35(productMessageLinkData, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendProductMessage, reason: merged with bridge method [inline-methods] */
    public void lambda$openPersonalDetailBottomSheet$35(Link.ProductMessageLinkData productMessageLinkData, ShopModels.PersonalDetail personalDetail) {
        BaseFragment lastFragment;
        if (productMessageLinkData == null) {
            return;
        }
        ProductMessageData productMessageData = new ProductMessageData();
        ArrayList<ProductMessageData.ProductMessageVariety> arrayList = productMessageLinkData.product_varieties;
        productMessageData.product_varieties = (arrayList == null || arrayList.isEmpty()) ? null : productMessageLinkData.product_varieties;
        productMessageData.store_id = productMessageLinkData.store_id;
        productMessageData.product_id = productMessageLinkData.product_id;
        ChatType chatType = productMessageLinkData.object_type;
        productMessageData.toType = chatType;
        long dialogId = ChatConverter.getDialogId(productMessageLinkData.object_guid, chatType);
        TLRPC$TL_messageMediaRubinoProduct tLRPC$TL_messageMediaRubinoProduct = new TLRPC$TL_messageMediaRubinoProduct();
        tLRPC$TL_messageMediaRubinoProduct.productMessageData = productMessageData;
        SendMessagesHelper.getInstance(this.currentAccount).sendMessage(tLRPC$TL_messageMediaRubinoProduct, dialogId, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        if (personalDetail != null) {
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(LocaleController.getString(R.string.shop_name) + ": " + personalDetail.name + '\n' + LocaleController.getString(R.string.shop_phone) + ": " + personalDetail.phone + '\n' + LocaleController.getString(R.string.shop_address) + ": " + personalDetail.address + '\n' + LocaleController.getString(R.string.shop_postal_code) + ": " + personalDetail.postalCode, dialogId, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
        }
        if (ApplicationLoader.applicationActivity == null || ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment() == null || (lastFragment = ApplicationLoader.applicationActivity.getActionBarLayout().getLastFragment()) == null) {
            return;
        }
        openChat(lastFragment, productMessageLinkData.object_guid, productMessageLinkData.object_type, 0L, false, false);
    }
}
