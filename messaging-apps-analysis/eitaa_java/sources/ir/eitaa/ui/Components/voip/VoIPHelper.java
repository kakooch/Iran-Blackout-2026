package ir.eitaa.ui.Components.voip;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$PhoneCallDiscardReason;
import ir.eitaa.tgnet.TLRPC$TL_chatFull;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_inputPhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_messageActionPhoneCall;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import ir.eitaa.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import ir.eitaa.tgnet.TLRPC$TL_phone_setCallRating;
import ir.eitaa.tgnet.TLRPC$TL_updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Components.BetterRatingView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.JoinCallAlert;
import ir.eitaa.ui.Components.JoinCallByUrlAlert;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.GroupCallActivity;
import ir.eitaa.ui.LaunchActivity;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public class VoIPHelper {
    public static long lastCallTime;

    static /* synthetic */ void lambda$showRateAlert$11(DialogInterface dialogInterface, int i) {
    }

    public static void startCall(TLRPC$User user, boolean videoCall, boolean canVideoCall, final Activity activity, TLRPC$UserFull userFull, AccountInstance accountInstance) {
        int i;
        String str;
        int i2;
        String str2;
        if (userFull != null && userFull.phone_calls_private) {
            new AlertDialog.Builder(activity).setTitle(LocaleController.getString("VoipFailed", R.string.VoipFailed)).setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("CallNotAvailable", R.string.CallNotAvailable, ContactsController.formatName(user.first_name, user.last_name)))).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).show();
            return;
        }
        if (ConnectionsManager.getInstance(UserConfig.selectedAccount).getConnectionState() != 3) {
            boolean z = Settings.System.getInt(activity.getContentResolver(), "airplane_mode_on", 0) != 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            if (z) {
                i = R.string.VoipOfflineAirplaneTitle;
                str = "VoipOfflineAirplaneTitle";
            } else {
                i = R.string.VoipOfflineTitle;
                str = "VoipOfflineTitle";
            }
            AlertDialog.Builder title = builder.setTitle(LocaleController.getString(str, i));
            if (z) {
                i2 = R.string.VoipOfflineAirplane;
                str2 = "VoipOfflineAirplane";
            } else {
                i2 = R.string.VoipOffline;
                str2 = "VoipOffline";
            }
            AlertDialog.Builder positiveButton = title.setMessage(LocaleController.getString(str2, i2)).setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            if (z) {
                final Intent intent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    positiveButton.setNeutralButton(LocaleController.getString("VoipOfflineOpenSettings", R.string.VoipOfflineOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$Lm683tFP-G6JfI3cDSSaob7FzDc
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            activity.startActivity(intent);
                        }
                    });
                }
            }
            try {
                positiveButton.show();
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (activity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (videoCall && activity.checkSelfPermission("android.permission.CAMERA") != 0) {
                arrayList.add("android.permission.CAMERA");
            }
            if (arrayList.isEmpty()) {
                initiateCall(user, null, null, videoCall, canVideoCall, false, activity, null, accountInstance);
                return;
            } else {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), videoCall ? R.styleable.AppCompatTheme_textAppearanceSearchResultTitle : R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle);
                return;
            }
        }
        initiateCall(user, null, null, videoCall, canVideoCall, false, activity, null, accountInstance);
    }

    public static void startCall(TLRPC$Chat chat, TLRPC$InputPeer peer, String hash, boolean createCall, final Activity activity, BaseFragment fragment, AccountInstance accountInstance) {
        int i;
        String str;
        int i2;
        String str2;
        if (activity == null) {
            return;
        }
        if (ConnectionsManager.getInstance(UserConfig.selectedAccount).getConnectionState() != 3) {
            boolean z = Settings.System.getInt(activity.getContentResolver(), "airplane_mode_on", 0) != 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            if (z) {
                i = R.string.VoipOfflineAirplaneTitle;
                str = "VoipOfflineAirplaneTitle";
            } else {
                i = R.string.VoipOfflineTitle;
                str = "VoipOfflineTitle";
            }
            AlertDialog.Builder title = builder.setTitle(LocaleController.getString(str, i));
            if (z) {
                i2 = R.string.VoipGroupOfflineAirplane;
                str2 = "VoipGroupOfflineAirplane";
            } else {
                i2 = R.string.VoipGroupOffline;
                str2 = "VoipGroupOffline";
            }
            AlertDialog.Builder positiveButton = title.setMessage(LocaleController.getString(str2, i2)).setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            if (z) {
                final Intent intent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    positiveButton.setNeutralButton(LocaleController.getString("VoipOfflineOpenSettings", R.string.VoipOfflineOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$tv4K47P8nxFaiDX7w37-5dqSGVQ
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            activity.startActivity(intent);
                        }
                    });
                }
            }
            try {
                positiveButton.show();
                return;
            } catch (Exception e) {
                FileLog.e(e);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList arrayList = new ArrayList();
            if (activity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (arrayList.isEmpty()) {
                initiateCall(null, chat, hash, false, false, createCall, activity, fragment, accountInstance);
                return;
            } else {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu);
                return;
            }
        }
        initiateCall(null, chat, hash, false, false, createCall, activity, fragment, accountInstance);
    }

    private static void initiateCall(final TLRPC$User user, final TLRPC$Chat chat, final String hash, final boolean videoCall, final boolean canVideoCall, final boolean createCall, final Activity activity, final BaseFragment fragment, final AccountInstance accountInstance) {
        String name;
        int i;
        String str;
        String name2;
        int i2;
        String str2;
        if (activity != null) {
            if (user == null && chat == null) {
                return;
            }
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance != null) {
                long j = user != null ? user.id : -chat.id;
                long callerId = VoIPService.getSharedInstance().getCallerId();
                if (callerId != j || sharedInstance.getAccount() != accountInstance.getCurrentAccount()) {
                    if (callerId > 0) {
                        TLRPC$User user2 = sharedInstance.getUser();
                        name = ContactsController.formatName(user2.first_name, user2.last_name);
                        if (j > 0) {
                            i = R.string.VoipOngoingAlert;
                            str = "VoipOngoingAlert";
                        } else {
                            i = R.string.VoipOngoingAlert2;
                            str = "VoipOngoingAlert2";
                        }
                    } else {
                        name = sharedInstance.getChat().title;
                        if (j > 0) {
                            i = R.string.VoipOngoingChatAlert2;
                            str = "VoipOngoingChatAlert2";
                        } else {
                            i = R.string.VoipOngoingChatAlert;
                            str = "VoipOngoingChatAlert";
                        }
                    }
                    if (user != null) {
                        name2 = ContactsController.formatName(user.first_name, user.last_name);
                    } else {
                        name2 = chat.title;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    if (callerId < 0) {
                        i2 = R.string.VoipOngoingChatAlertTitle;
                        str2 = "VoipOngoingChatAlertTitle";
                    } else {
                        i2 = R.string.VoipOngoingAlertTitle;
                        str2 = "VoipOngoingAlertTitle";
                    }
                    builder.setTitle(LocaleController.getString(str2, i2)).setMessage(AndroidUtilities.replaceTags(LocaleController.formatString(str, i, name, name2))).setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$-FImrVpnOY7H6TkiUuR5NdWD3bA
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) throws IllegalStateException, InterruptedException {
                            VoIPHelper.lambda$initiateCall$3(user, chat, hash, videoCall, canVideoCall, createCall, activity, fragment, accountInstance, dialogInterface, i3);
                        }
                    }).setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null).show();
                    return;
                }
                if (user != null || !(activity instanceof LaunchActivity)) {
                    activity.startActivity(new Intent(activity, (Class<?>) LaunchActivity.class).setAction(user != null ? "voip" : "voip_chat"));
                    return;
                }
                if (!TextUtils.isEmpty(hash)) {
                    sharedInstance.setGroupCallHash(hash);
                }
                GroupCallActivity.create((LaunchActivity) activity, AccountInstance.getInstance(UserConfig.selectedAccount), null, null, false, null);
                return;
            }
            if (VoIPService.callIShouldHavePutIntoIntent == null) {
                doInitiateCall(user, chat, hash, null, false, videoCall, canVideoCall, createCall, activity, fragment, accountInstance, true, true);
            }
        }
    }

    static /* synthetic */ void lambda$initiateCall$3(final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final String str, final boolean z, final boolean z2, final boolean z3, final Activity activity, final BaseFragment baseFragment, final AccountInstance accountInstance, DialogInterface dialogInterface, int i) throws IllegalStateException, InterruptedException {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().hangUp(new Runnable() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$ZsCR5ImMQjShepAJst25vhysmLg
                @Override // java.lang.Runnable
                public final void run() {
                    VoIPHelper.lambda$initiateCall$2(tLRPC$User, tLRPC$Chat, str, z, z2, z3, activity, baseFragment, accountInstance);
                }
            });
        } else {
            doInitiateCall(tLRPC$User, tLRPC$Chat, str, null, false, z, z2, z3, activity, baseFragment, accountInstance, true, true);
        }
    }

    static /* synthetic */ void lambda$initiateCall$2(TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, String str, boolean z, boolean z2, boolean z3, Activity activity, BaseFragment baseFragment, AccountInstance accountInstance) {
        lastCallTime = 0L;
        doInitiateCall(tLRPC$User, tLRPC$Chat, str, null, false, z, z2, z3, activity, baseFragment, accountInstance, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doInitiateCall(final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final String str, final TLRPC$InputPeer tLRPC$InputPeer, boolean z, final boolean z2, final boolean z3, final boolean z4, final Activity activity, final BaseFragment baseFragment, final AccountInstance accountInstance, boolean z5, boolean z6) {
        ChatObject.Call groupCall;
        TLRPC$ChatFull chatFull;
        int i;
        String str2;
        int i2;
        String str3;
        TLRPC$ChatFull chatFull2;
        TLRPC$Peer tLRPC$Peer;
        if (activity != null) {
            if (tLRPC$User == null && tLRPC$Chat == null) {
                return;
            }
            if (SystemClock.elapsedRealtime() - lastCallTime < (tLRPC$Chat != null ? 200 : 2000)) {
                return;
            }
            if (z5 && tLRPC$Chat != null && !z4 && (chatFull2 = accountInstance.getMessagesController().getChatFull(tLRPC$Chat.id)) != null && (tLRPC$Peer = chatFull2.groupcall_default_join_as) != null) {
                final TLRPC$InputPeer inputPeer = accountInstance.getMessagesController().getInputPeer(MessageObject.getPeerId(tLRPC$Peer));
                JoinCallAlert.checkFewUsers(activity, -tLRPC$Chat.id, accountInstance, new MessagesStorage.BooleanCallback() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$TN8HUSSvq9KNRLRYnShS5uXyYVI
                    @Override // ir.eitaa.messenger.MessagesStorage.BooleanCallback
                    public final void run(boolean z7) {
                        VoIPHelper.lambda$doInitiateCall$4(str, activity, tLRPC$Chat, tLRPC$User, inputPeer, z2, z3, baseFragment, accountInstance, z7);
                    }
                });
                return;
            }
            if (z5 && tLRPC$Chat != null) {
                JoinCallAlert.open(activity, -tLRPC$Chat.id, accountInstance, baseFragment, !z4 ? 1 : 0, null, new JoinCallAlert.JoinCallAlertDelegate() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$gZgUNEHPPpr2gWqxsOprOq07eR8
                    @Override // ir.eitaa.ui.Components.JoinCallAlert.JoinCallAlertDelegate
                    public final void didSelectChat(TLRPC$InputPeer tLRPC$InputPeer2, boolean z7, boolean z8) {
                        VoIPHelper.lambda$doInitiateCall$5(z4, activity, accountInstance, tLRPC$Chat, str, tLRPC$User, z2, z3, baseFragment, tLRPC$InputPeer2, z7, z8);
                    }
                });
                return;
            }
            if (z6 && !z && (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) && ChatObject.shouldSendAnonymously(tLRPC$Chat) && (!ChatObject.isChannel(tLRPC$Chat) || tLRPC$Chat.megagroup)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                if (ChatObject.isChannelOrGiga(tLRPC$Chat)) {
                    i = R.string.VoipChannelVoiceChat;
                    str2 = "VoipChannelVoiceChat";
                } else {
                    i = R.string.VoipGroupVoiceChat;
                    str2 = "VoipGroupVoiceChat";
                }
                AlertDialog.Builder title = builder.setTitle(LocaleController.getString(str2, i));
                if (ChatObject.isChannelOrGiga(tLRPC$Chat)) {
                    i2 = R.string.VoipChannelJoinAnonymouseAlert;
                    str3 = "VoipChannelJoinAnonymouseAlert";
                } else {
                    i2 = R.string.VoipGroupJoinAnonymouseAlert;
                    str3 = "VoipGroupJoinAnonymouseAlert";
                }
                title.setMessage(LocaleController.getString(str3, i2)).setPositiveButton(LocaleController.getString("VoipChatJoin", R.string.VoipChatJoin), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$4m_bE_6X97nSFp3JmgCIP7BUfCc
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        VoIPHelper.doInitiateCall(tLRPC$User, tLRPC$Chat, str, tLRPC$InputPeer, false, z2, z3, z4, activity, baseFragment, accountInstance, false, false);
                    }
                }).setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null).show();
                return;
            }
            if (tLRPC$Chat != null && tLRPC$InputPeer != null && (chatFull = accountInstance.getMessagesController().getChatFull(tLRPC$Chat.id)) != null) {
                if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
                    TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                    chatFull.groupcall_default_join_as = tLRPC$TL_peerUser;
                    tLRPC$TL_peerUser.user_id = tLRPC$InputPeer.user_id;
                } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
                    TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
                    chatFull.groupcall_default_join_as = tLRPC$TL_peerChat;
                    tLRPC$TL_peerChat.chat_id = tLRPC$InputPeer.chat_id;
                } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChannel) {
                    TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                    chatFull.groupcall_default_join_as = tLRPC$TL_peerChannel;
                    tLRPC$TL_peerChannel.channel_id = tLRPC$InputPeer.channel_id;
                }
                if (chatFull instanceof TLRPC$TL_chatFull) {
                    chatFull.flags |= 32768;
                } else {
                    chatFull.flags |= ConnectionsManager.FileTypeFile;
                }
            }
            boolean z7 = false;
            if (tLRPC$Chat != null && !z4 && (groupCall = accountInstance.getMessagesController().getGroupCall(tLRPC$Chat.id, false)) != null && groupCall.isScheduled()) {
                GroupCallActivity.create((LaunchActivity) activity, accountInstance, tLRPC$Chat, tLRPC$InputPeer, z, str);
                return;
            }
            lastCallTime = SystemClock.elapsedRealtime();
            Intent intent = new Intent(activity, (Class<?>) VoIPService.class);
            if (tLRPC$User != null) {
                intent.putExtra("user_id", tLRPC$User.id);
            } else {
                intent.putExtra("chat_id", tLRPC$Chat.id);
                intent.putExtra("createGroupCall", z4);
                intent.putExtra("hasFewPeers", z);
                intent.putExtra("hash", str);
                if (tLRPC$InputPeer != null) {
                    intent.putExtra("peerChannelId", tLRPC$InputPeer.channel_id);
                    intent.putExtra("peerChatId", tLRPC$InputPeer.chat_id);
                    intent.putExtra("peerUserId", tLRPC$InputPeer.user_id);
                    intent.putExtra("peerAccessHash", tLRPC$InputPeer.access_hash);
                }
            }
            intent.putExtra("is_outgoing", true);
            intent.putExtra("start_incall_activity", true);
            int i3 = Build.VERSION.SDK_INT;
            intent.putExtra("video_call", i3 >= 18 && z2);
            if (i3 >= 18 && z3) {
                z7 = true;
            }
            intent.putExtra("can_video_call", z7);
            intent.putExtra("account", UserConfig.selectedAccount);
            try {
                activity.startService(intent);
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
    }

    static /* synthetic */ void lambda$doInitiateCall$4(final String str, final Activity activity, final TLRPC$Chat tLRPC$Chat, final TLRPC$User tLRPC$User, final TLRPC$InputPeer tLRPC$InputPeer, final boolean z, final boolean z2, final BaseFragment baseFragment, final AccountInstance accountInstance, boolean z3) {
        if (!z3 && str != null) {
            JoinCallByUrlAlert joinCallByUrlAlert = new JoinCallByUrlAlert(activity, tLRPC$Chat) { // from class: ir.eitaa.ui.Components.voip.VoIPHelper.1
                @Override // ir.eitaa.ui.Components.JoinCallByUrlAlert
                protected void onJoin() {
                    VoIPHelper.doInitiateCall(tLRPC$User, tLRPC$Chat, str, tLRPC$InputPeer, true, z, z2, false, activity, baseFragment, accountInstance, false, false);
                }
            };
            if (baseFragment != null) {
                baseFragment.showDialog(joinCallByUrlAlert);
                return;
            }
            return;
        }
        doInitiateCall(tLRPC$User, tLRPC$Chat, str, tLRPC$InputPeer, !z3, z, z2, false, activity, baseFragment, accountInstance, false, false);
    }

    static /* synthetic */ void lambda$doInitiateCall$5(final boolean z, final Activity activity, final AccountInstance accountInstance, final TLRPC$Chat tLRPC$Chat, final String str, final TLRPC$User tLRPC$User, final boolean z2, final boolean z3, final BaseFragment baseFragment, final TLRPC$InputPeer tLRPC$InputPeer, boolean z4, boolean z5) {
        if (z && z5) {
            GroupCallActivity.create((LaunchActivity) activity, accountInstance, tLRPC$Chat, tLRPC$InputPeer, z4, str);
            return;
        }
        if (!z4 && str != null) {
            JoinCallByUrlAlert joinCallByUrlAlert = new JoinCallByUrlAlert(activity, tLRPC$Chat) { // from class: ir.eitaa.ui.Components.voip.VoIPHelper.2
                @Override // ir.eitaa.ui.Components.JoinCallByUrlAlert
                protected void onJoin() {
                    VoIPHelper.doInitiateCall(tLRPC$User, tLRPC$Chat, str, tLRPC$InputPeer, false, z2, z3, z, activity, baseFragment, accountInstance, false, true);
                }
            };
            if (baseFragment != null) {
                baseFragment.showDialog(joinCallByUrlAlert);
                return;
            }
            return;
        }
        doInitiateCall(tLRPC$User, tLRPC$Chat, str, tLRPC$InputPeer, z4, z2, z3, z, activity, baseFragment, accountInstance, false, true);
    }

    @TargetApi(23)
    public static void permissionDenied(final Activity activity, final Runnable onFinish, int code) {
        int i;
        String str;
        if (!activity.shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO") || (code == 102 && !activity.shouldShowRequestPermissionRationale("android.permission.CAMERA"))) {
            AlertDialog.Builder title = new AlertDialog.Builder(activity).setTitle(LocaleController.getString("AppName", R.string.AppName));
            if (code == 102) {
                i = R.string.VoipNeedMicCameraPermission;
                str = "VoipNeedMicCameraPermission";
            } else {
                i = R.string.VoipNeedMicPermission;
                str = "VoipNeedMicPermission";
            }
            title.setMessage(LocaleController.getString(str, i)).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).setNegativeButton(LocaleController.getString("Settings", R.string.Settings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$85SCEBDds7-4pTvIM3Js8hjzm44
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    VoIPHelper.lambda$permissionDenied$7(activity, dialogInterface, i2);
                }
            }).show().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$ejNMCvelLMP93Wgd9omIUxS71pc
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    VoIPHelper.lambda$permissionDenied$8(onFinish, dialogInterface);
                }
            });
        }
    }

    static /* synthetic */ void lambda$permissionDenied$7(Activity activity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
    }

    static /* synthetic */ void lambda$permissionDenied$8(Runnable runnable, DialogInterface dialogInterface) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static File getLogsDir() {
        File file = new File(ApplicationLoader.applicationContext.getCacheDir(), "voip_logs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static boolean canRateCall(TLRPC$TL_messageActionPhoneCall call) {
        TLRPC$PhoneCallDiscardReason tLRPC$PhoneCallDiscardReason = call.reason;
        if (!(tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonBusy) && !(tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonMissed)) {
            Iterator<String> it = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).getStringSet("calls_access_hashes", Collections.EMPTY_SET).iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split(" ");
                if (strArrSplit.length >= 2) {
                    if (strArrSplit[0].equals(call.call_id + "")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void showRateAlert(Context context, TLRPC$TL_messageActionPhoneCall call) throws NumberFormatException {
        Iterator<String> it = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).getStringSet("calls_access_hashes", Collections.EMPTY_SET).iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(" ");
            if (strArrSplit.length >= 2) {
                if (strArrSplit[0].equals(call.call_id + "")) {
                    try {
                        showRateAlert(context, null, call.video, call.call_id, Long.parseLong(strArrSplit[1]), UserConfig.selectedAccount, true);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        }
    }

    public static void showRateAlert(final Context context, final Runnable onDismiss, boolean isVideo, final long callID, final long accessHash, final int account, final boolean userInitiative) {
        String string;
        final File logFile = getLogFile(callID);
        int i = 1;
        final int[] iArr = {0};
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int iDp = AndroidUtilities.dp(16.0f);
        linearLayout.setPadding(iDp, iDp, iDp, 0);
        final TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setGravity(17);
        textView.setText(LocaleController.getString("VoipRateCallAlert", R.string.VoipRateCallAlert));
        linearLayout.addView(textView);
        final BetterRatingView betterRatingView = new BetterRatingView(context);
        linearLayout.addView(betterRatingView, LayoutHelper.createLinear(-2, -2, 1, 0, 16, 0, 0));
        final LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        $$Lambda$VoIPHelper$loTkXELSNzlmqIQ61JKv576e_bI __lambda_voiphelper_lotkxelsnzlmqiq61jkv576e_bi = new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$loTkXELSNzlmqIQ61JKv576e_bI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ((CheckBoxCell) view).setChecked(!view.isChecked(), true);
            }
        };
        String[] strArr = new String[9];
        strArr[0] = isVideo ? "distorted_video" : null;
        strArr[1] = isVideo ? "pixelated_video" : null;
        strArr[2] = "echo";
        strArr[3] = "noise";
        strArr[4] = "interruptions";
        strArr[5] = "distorted_speech";
        strArr[6] = "silent_local";
        strArr[7] = "silent_remote";
        strArr[8] = "dropped";
        int i2 = 0;
        for (int i3 = 9; i2 < i3; i3 = 9) {
            if (strArr[i2] != null) {
                CheckBoxCell checkBoxCell = new CheckBoxCell(context, i);
                checkBoxCell.setClipToPadding(false);
                checkBoxCell.setTag(strArr[i2]);
                switch (i2) {
                    case 0:
                        string = LocaleController.getString("RateCallVideoDistorted", R.string.RateCallVideoDistorted);
                        break;
                    case 1:
                        string = LocaleController.getString("RateCallVideoPixelated", R.string.RateCallVideoPixelated);
                        break;
                    case 2:
                        string = LocaleController.getString("RateCallEcho", R.string.RateCallEcho);
                        break;
                    case 3:
                        string = LocaleController.getString("RateCallNoise", R.string.RateCallNoise);
                        break;
                    case 4:
                        string = LocaleController.getString("RateCallInterruptions", R.string.RateCallInterruptions);
                        break;
                    case 5:
                        string = LocaleController.getString("RateCallDistorted", R.string.RateCallDistorted);
                        break;
                    case 6:
                        string = LocaleController.getString("RateCallSilentLocal", R.string.RateCallSilentLocal);
                        break;
                    case 7:
                        string = LocaleController.getString("RateCallSilentRemote", R.string.RateCallSilentRemote);
                        break;
                    case 8:
                        string = LocaleController.getString("RateCallDropped", R.string.RateCallDropped);
                        break;
                    default:
                        string = null;
                        break;
                }
                checkBoxCell.setText(string, null, false, false);
                checkBoxCell.setOnClickListener(__lambda_voiphelper_lotkxelsnzlmqiq61jkv576e_bi);
                checkBoxCell.setTag(strArr[i2]);
                linearLayout2.addView(checkBoxCell);
            }
            i2++;
            i = 1;
        }
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, -8.0f, 0.0f, -8.0f, 0.0f));
        linearLayout2.setVisibility(8);
        final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        editTextBoldCursor.setHint(LocaleController.getString("VoipFeedbackCommentHint", R.string.VoipFeedbackCommentHint));
        editTextBoldCursor.setInputType(147457);
        editTextBoldCursor.setTextColor(Theme.getColor("dialogTextBlack"));
        editTextBoldCursor.setHintTextColor(Theme.getColor("dialogTextHint"));
        editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(context, true));
        editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f));
        editTextBoldCursor.setTextSize(1, 18.0f);
        editTextBoldCursor.setVisibility(8);
        linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, -2, 8.0f, 8.0f, 8.0f, 0.0f));
        final boolean[] zArr = {true};
        final CheckBoxCell checkBoxCell2 = new CheckBoxCell(context, 1);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$M0lEtm8_R7aD8AQOxiFtiTRL9lc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoIPHelper.lambda$showRateAlert$10(zArr, checkBoxCell2, view);
            }
        };
        checkBoxCell2.setText(LocaleController.getString("CallReportIncludeLogs", R.string.CallReportIncludeLogs), null, true, false);
        checkBoxCell2.setClipToPadding(false);
        checkBoxCell2.setOnClickListener(onClickListener);
        linearLayout.addView(checkBoxCell2, LayoutHelper.createLinear(-1, -2, -8.0f, 0.0f, -8.0f, 0.0f));
        final TextView textView2 = new TextView(context);
        textView2.setTextSize(2, 14.0f);
        textView2.setTextColor(Theme.getColor("dialogTextGray3"));
        textView2.setText(LocaleController.getString("CallReportLogsExplain", R.string.CallReportLogsExplain));
        textView2.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        textView2.setOnClickListener(onClickListener);
        linearLayout.addView(textView2);
        checkBoxCell2.setVisibility(8);
        textView2.setVisibility(8);
        if (!logFile.exists()) {
            zArr[0] = false;
        }
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle(LocaleController.getString("CallMessageReportProblem", R.string.CallMessageReportProblem)).setView(linearLayout).setPositiveButton(LocaleController.getString("Send", R.string.Send), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$6ZblYWasSbRWPLZm61TtBhZu79A
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                VoIPHelper.lambda$showRateAlert$11(dialogInterface, i4);
            }
        }).setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$JjKgrXLlitpQLi7hCLZtPLSFUxw
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VoIPHelper.lambda$showRateAlert$12(onDismiss, dialogInterface);
            }
        }).create();
        if (BuildVars.LOGS_ENABLED && logFile.exists()) {
            alertDialogCreate.setNeutralButton("Send log", new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$SQ8_8Jm7juD8vcg618oSAGK6Evg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    VoIPHelper.lambda$showRateAlert$13(context, logFile, dialogInterface, i4);
                }
            });
        }
        alertDialogCreate.show();
        alertDialogCreate.getWindow().setSoftInputMode(3);
        final View button = alertDialogCreate.getButton(-1);
        button.setEnabled(false);
        betterRatingView.setOnRatingChangeListener(new BetterRatingView.OnRatingChangeListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$cGzC6RxceoUbHfA9uKWmzr9AN8k
            @Override // ir.eitaa.ui.Components.BetterRatingView.OnRatingChangeListener
            public final void onRatingChanged(int i4) {
                VoIPHelper.lambda$showRateAlert$14(button, i4);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$Pffl0AkXjkFjv-T_wTpRB26Wz9s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoIPHelper.lambda$showRateAlert$16(betterRatingView, iArr, linearLayout2, editTextBoldCursor, zArr, accessHash, callID, userInitiative, account, logFile, context, alertDialogCreate, textView, checkBoxCell2, textView2, button, view);
            }
        });
    }

    static /* synthetic */ void lambda$showRateAlert$10(boolean[] zArr, CheckBoxCell checkBoxCell, View view) {
        zArr[0] = !zArr[0];
        checkBoxCell.setChecked(zArr[0], true);
    }

    static /* synthetic */ void lambda$showRateAlert$12(Runnable runnable, DialogInterface dialogInterface) {
        if (runnable != null) {
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$showRateAlert$13(Context context, File file, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(context, (Class<?>) LaunchActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        context.startActivity(intent);
    }

    static /* synthetic */ void lambda$showRateAlert$14(View view, int i) {
        int i2;
        String str;
        view.setEnabled(i > 0);
        TextView textView = (TextView) view;
        if (i < 4) {
            i2 = R.string.Next;
            str = "Next";
        } else {
            i2 = R.string.Send;
            str = "Send";
        }
        textView.setText(LocaleController.getString(str, i2).toUpperCase());
    }

    static /* synthetic */ void lambda$showRateAlert$16(BetterRatingView betterRatingView, int[] iArr, LinearLayout linearLayout, EditTextBoldCursor editTextBoldCursor, final boolean[] zArr, long j, long j2, boolean z, int i, final File file, final Context context, AlertDialog alertDialog, TextView textView, CheckBoxCell checkBoxCell, TextView textView2, View view, View view2) {
        if (betterRatingView.getRating() >= 4 || iArr[0] == 1) {
            final int i2 = UserConfig.selectedAccount;
            final TLRPC$TL_phone_setCallRating tLRPC$TL_phone_setCallRating = new TLRPC$TL_phone_setCallRating();
            tLRPC$TL_phone_setCallRating.rating = betterRatingView.getRating();
            final ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
                CheckBoxCell checkBoxCell2 = (CheckBoxCell) linearLayout.getChildAt(i3);
                if (checkBoxCell2.isChecked()) {
                    arrayList.add("#" + checkBoxCell2.getTag());
                }
            }
            if (tLRPC$TL_phone_setCallRating.rating < 5) {
                tLRPC$TL_phone_setCallRating.comment = editTextBoldCursor.getText().toString();
            } else {
                tLRPC$TL_phone_setCallRating.comment = "";
            }
            if (!arrayList.isEmpty() && !zArr[0]) {
                tLRPC$TL_phone_setCallRating.comment += " " + TextUtils.join(" ", arrayList);
            }
            TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
            tLRPC$TL_phone_setCallRating.peer = tLRPC$TL_inputPhoneCall;
            tLRPC$TL_inputPhoneCall.access_hash = j;
            tLRPC$TL_inputPhoneCall.id = j2;
            tLRPC$TL_phone_setCallRating.user_initiative = z;
            ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_phone_setCallRating, new RequestDelegate() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$oakgivCaKc9zBdqvzPkZ7AQ004s
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    VoIPHelper.lambda$showRateAlert$15(i2, zArr, file, tLRPC$TL_phone_setCallRating, arrayList, context, tLObject, tLRPC$TL_error);
                }
            });
            alertDialog.dismiss();
            return;
        }
        iArr[0] = 1;
        betterRatingView.setVisibility(8);
        textView.setVisibility(8);
        alertDialog.setTitle(LocaleController.getString("CallReportHint", R.string.CallReportHint));
        editTextBoldCursor.setVisibility(0);
        if (file.exists()) {
            checkBoxCell.setVisibility(0);
            textView2.setVisibility(0);
        }
        linearLayout.setVisibility(0);
        ((TextView) view).setText(LocaleController.getString("Send", R.string.Send).toUpperCase());
    }

    static /* synthetic */ void lambda$showRateAlert$15(int i, boolean[] zArr, File file, TLRPC$TL_phone_setCallRating tLRPC$TL_phone_setCallRating, ArrayList arrayList, Context context, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_updates) {
            MessagesController.getInstance(i).processUpdates((TLRPC$TL_updates) tLObject, false);
        }
        if (zArr[0] && file.exists() && tLRPC$TL_phone_setCallRating.rating < 4) {
            SendMessagesHelper.prepareSendingDocument(AccountInstance.getInstance(UserConfig.selectedAccount), file.getAbsolutePath(), file.getAbsolutePath(), null, TextUtils.join(" ", arrayList), "text/plain", 4244000L, null, null, null, null, true, 0);
            Toast.makeText(context, LocaleController.getString("CallReportSent", R.string.CallReportSent), 1).show();
        }
    }

    private static File getLogFile(long callID) {
        File file;
        String[] list;
        if (BuildVars.DEBUG_VERSION && (list = (file = new File(ApplicationLoader.applicationContext.getExternalFilesDir(null), "logs")).list()) != null) {
            for (String str : list) {
                if (str.endsWith("voip" + callID + ".txt")) {
                    return new File(file, str);
                }
            }
        }
        return new File(getLogsDir(), callID + ".log");
    }

    public static void showCallDebugSettings(final Context context) {
        final SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setTextSize(1, 15.0f);
        textView.setText("Please only change these settings if you know exactly what they do.");
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2, 16.0f, 8.0f, 16.0f, 8.0f));
        final TextCheckCell textCheckCell = new TextCheckCell(context);
        textCheckCell.setTextAndCheck("Force TCP", globalMainSettings.getBoolean("dbg_force_tcp_in_calls", false), false);
        textCheckCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$3uzlfU85s4HBe1YtPEJW8YvUKv8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoIPHelper.lambda$showCallDebugSettings$17(globalMainSettings, textCheckCell, view);
            }
        });
        linearLayout.addView(textCheckCell);
        if (BuildVars.DEBUG_VERSION && BuildVars.LOGS_ENABLED) {
            final TextCheckCell textCheckCell2 = new TextCheckCell(context);
            textCheckCell2.setTextAndCheck("Dump detailed stats", globalMainSettings.getBoolean("dbg_dump_call_stats", false), false);
            textCheckCell2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$9-aslnof6aj-BhtgY8btT9dq5mw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VoIPHelper.lambda$showCallDebugSettings$18(globalMainSettings, textCheckCell2, view);
                }
            });
            linearLayout.addView(textCheckCell2);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            final TextCheckCell textCheckCell3 = new TextCheckCell(context);
            textCheckCell3.setTextAndCheck("Enable ConnectionService", globalMainSettings.getBoolean("dbg_force_connection_service", false), false);
            textCheckCell3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$nmi_tfSDC0WpZJWjR7PGM4jYZuQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VoIPHelper.lambda$showCallDebugSettings$19(globalMainSettings, textCheckCell3, view);
                }
            });
            linearLayout.addView(textCheckCell3);
        }
        new AlertDialog.Builder(context).setTitle(LocaleController.getString("DebugMenuCallSettings", R.string.DebugMenuCallSettings)).setView(linearLayout).show();
    }

    static /* synthetic */ void lambda$showCallDebugSettings$17(SharedPreferences sharedPreferences, TextCheckCell textCheckCell, View view) {
        boolean z = sharedPreferences.getBoolean("dbg_force_tcp_in_calls", false);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("dbg_force_tcp_in_calls", !z);
        editorEdit.commit();
        textCheckCell.setChecked(!z);
    }

    static /* synthetic */ void lambda$showCallDebugSettings$18(SharedPreferences sharedPreferences, TextCheckCell textCheckCell, View view) {
        boolean z = sharedPreferences.getBoolean("dbg_dump_call_stats", false);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("dbg_dump_call_stats", !z);
        editorEdit.commit();
        textCheckCell.setChecked(!z);
    }

    static /* synthetic */ void lambda$showCallDebugSettings$19(SharedPreferences sharedPreferences, TextCheckCell textCheckCell, View view) {
        boolean z = sharedPreferences.getBoolean("dbg_force_connection_service", false);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putBoolean("dbg_force_connection_service", !z);
        editorEdit.commit();
        textCheckCell.setChecked(!z);
    }

    public static int getDataSavingDefault() throws IOException {
        boolean z = DownloadController.getInstance(0).lowPreset.lessCallData;
        boolean z2 = DownloadController.getInstance(0).mediumPreset.lessCallData;
        boolean z3 = DownloadController.getInstance(0).highPreset.lessCallData;
        if (!z && !z2 && !z3) {
            return 0;
        }
        if (z && !z2 && !z3) {
            return 3;
        }
        if (z && z2 && !z3) {
            return 1;
        }
        if (z && z2 && z3) {
            return 2;
        }
        if (BuildVars.LOGS_ENABLED) {
            FileLog.w("Invalid call data saving preset configuration: " + z + "/" + z2 + "/" + z3);
        }
        return 0;
    }

    public static String getLogFilePath(String name) {
        Calendar calendar = Calendar.getInstance();
        return new File(ApplicationLoader.applicationContext.getExternalFilesDir(null), String.format(Locale.US, "logs/%02d_%02d_%04d_%02d_%02d_%02d_%s.txt", Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)), name)).getAbsolutePath();
    }

    public static String getLogFilePath(long callId, boolean stats) {
        File[] fileArrListFiles;
        File logsDir = getLogsDir();
        if (!BuildVars.DEBUG_VERSION && (fileArrListFiles = logsDir.listFiles()) != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(fileArrListFiles));
            while (arrayList.size() > 20) {
                File file = (File) arrayList.get(0);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    if (file2.getName().endsWith(".log") && file2.lastModified() < file.lastModified()) {
                        file = file2;
                    }
                }
                file.delete();
                arrayList.remove(file);
            }
        }
        return new File(logsDir, callId + ".log").getAbsolutePath();
    }

    public static void showGroupCallAlert(final BaseFragment fragment, final TLRPC$Chat currentChat, final TLRPC$InputPeer peer, boolean recreate, final AccountInstance accountInstance) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        JoinCallAlert.checkFewUsers(fragment.getParentActivity(), -currentChat.id, accountInstance, new MessagesStorage.BooleanCallback() { // from class: ir.eitaa.ui.Components.voip.-$$Lambda$VoIPHelper$W2FKTD_l3aqjEmtUzr13RhzCUGM
            @Override // ir.eitaa.messenger.MessagesStorage.BooleanCallback
            public final void run(boolean z) {
                TLRPC$Chat tLRPC$Chat = currentChat;
                TLRPC$InputPeer tLRPC$InputPeer = peer;
                BaseFragment baseFragment = fragment;
                VoIPHelper.startCall(tLRPC$Chat, tLRPC$InputPeer, null, true, baseFragment.getParentActivity(), baseFragment, accountInstance);
            }
        });
    }
}
