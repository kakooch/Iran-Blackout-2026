package org.rbmain.ui.Components.voip;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.proxy.CallProxy;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.voip.VoIPService;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$PhoneCallDiscardReason;
import org.rbmain.tgnet.TLRPC$TL_chatFull;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_inputPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_messageActionPhoneCall;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import org.rbmain.tgnet.TLRPC$TL_phone_setCallRating;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Components.BetterRatingView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.JoinCallAlert;
import org.rbmain.ui.Components.JoinCallByUrlAlert;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.GroupCallActivity;
import org.rbmain.ui.LaunchActivity;

/* loaded from: classes5.dex */
public class VoIPHelper {
    public static long lastCallTime;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$11(DialogInterface dialogInterface, int i) {
    }

    public static void startCall(TLRPC$User tLRPC$User, boolean z, boolean z2, final Activity activity, TLRPC$UserFull tLRPC$UserFull, AccountInstance accountInstance) {
        int i;
        String str;
        int i2;
        String str2;
        if (tLRPC$UserFull != null && tLRPC$UserFull.phone_calls_private) {
            new AlertDialog.Builder(activity).setTitle(LocaleController.getString("VoipFailed", R.string.VoipFailed)).setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("CallNotAvailable", R.string.CallNotAvailable, ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name)))).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).show();
            return;
        }
        if (ConnectionsManager.getInstance(UserConfig.selectedAccount).getConnectionState() != 3) {
            boolean z3 = Settings.System.getInt(activity.getContentResolver(), "airplane_mode_on", 0) != 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            if (z3) {
                i = R.string.VoipOfflineAirplaneTitle;
                str = "VoipOfflineAirplaneTitle";
            } else {
                i = R.string.VoipOfflineTitle;
                str = "VoipOfflineTitle";
            }
            AlertDialog.Builder title = builder.setTitle(LocaleController.getString(str, i));
            if (z3) {
                i2 = R.string.VoipOfflineAirplane;
                str2 = "VoipOfflineAirplane";
            } else {
                i2 = R.string.VoipOffline;
                str2 = "VoipOffline";
            }
            AlertDialog.Builder positiveButton = title.setMessage(LocaleController.getString(str2, i2)).setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            if (z3) {
                final Intent intent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    positiveButton.setNeutralButton(LocaleController.getString("VoipOfflineOpenSettings", R.string.VoipOfflineOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda2
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
            if (z && activity.checkSelfPermission("android.permission.CAMERA") != 0) {
                arrayList.add("android.permission.CAMERA");
            }
            if (arrayList.isEmpty()) {
                initiateCall(tLRPC$User, null, null, z, z2, false, activity, null, accountInstance);
                return;
            } else {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), z ? 102 : 101);
                return;
            }
        }
        initiateCall(tLRPC$User, null, null, z, z2, false, activity, null, accountInstance);
    }

    public static void startCall(TLRPC$Chat tLRPC$Chat, TLRPC$InputPeer tLRPC$InputPeer, String str, boolean z, final Activity activity, BaseFragment baseFragment, AccountInstance accountInstance) {
        int i;
        String str2;
        int i2;
        String str3;
        if (activity == null) {
            return;
        }
        if (ConnectionsManager.getInstance(UserConfig.selectedAccount).getConnectionState() != 3) {
            boolean z2 = Settings.System.getInt(activity.getContentResolver(), "airplane_mode_on", 0) != 0;
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            if (z2) {
                i = R.string.VoipOfflineAirplaneTitle;
                str2 = "VoipOfflineAirplaneTitle";
            } else {
                i = R.string.VoipOfflineTitle;
                str2 = "VoipOfflineTitle";
            }
            AlertDialog.Builder title = builder.setTitle(LocaleController.getString(str2, i));
            if (z2) {
                i2 = R.string.VoipGroupOfflineAirplane;
                str3 = "VoipGroupOfflineAirplane";
            } else {
                i2 = R.string.VoipGroupOffline;
                str3 = "VoipGroupOffline";
            }
            AlertDialog.Builder positiveButton = title.setMessage(LocaleController.getString(str3, i2)).setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            if (z2) {
                final Intent intent = new Intent("android.settings.AIRPLANE_MODE_SETTINGS");
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    positiveButton.setNeutralButton(LocaleController.getString("VoipOfflineOpenSettings", R.string.VoipOfflineOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda1
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
                initiateCall(null, tLRPC$Chat, str, false, false, z, activity, baseFragment, accountInstance);
                return;
            } else {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 103);
                return;
            }
        }
        initiateCall(null, tLRPC$Chat, str, false, false, z, activity, baseFragment, accountInstance);
    }

    private static void initiateCall(final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final String str, final boolean z, final boolean z2, final boolean z3, final Activity activity, final BaseFragment baseFragment, final AccountInstance accountInstance) {
        String name;
        int i;
        String str2;
        String name2;
        int i2;
        String str3;
        if (activity != null) {
            if (tLRPC$User == null && tLRPC$Chat == null) {
                return;
            }
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance != null) {
                int i3 = tLRPC$User != null ? tLRPC$User.id : -tLRPC$Chat.id;
                int callerId = VoIPService.getSharedInstance().getCallerId();
                if (callerId != i3 || sharedInstance.getAccount() != accountInstance.getCurrentAccount()) {
                    if (callerId > 0) {
                        TLRPC$User user = sharedInstance.getUser();
                        name = ContactsController.formatName(user.first_name, user.last_name);
                        if (i3 > 0) {
                            i = R.string.VoipOngoingAlert;
                            str2 = "VoipOngoingAlert";
                        } else {
                            i = R.string.VoipOngoingAlert2;
                            str2 = "VoipOngoingAlert2";
                        }
                    } else {
                        name = sharedInstance.getChat().title;
                        if (i3 > 0) {
                            i = R.string.VoipOngoingChatAlert2;
                            str2 = "VoipOngoingChatAlert2";
                        } else {
                            i = R.string.VoipOngoingChatAlert;
                            str2 = "VoipOngoingChatAlert";
                        }
                    }
                    if (tLRPC$User != null) {
                        name2 = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
                    } else {
                        name2 = tLRPC$Chat.title;
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    if (callerId < 0) {
                        i2 = R.string.VoipOngoingChatAlertTitle;
                        str3 = "VoipOngoingChatAlertTitle";
                    } else {
                        i2 = R.string.VoipOngoingAlertTitle;
                        str3 = "VoipOngoingAlertTitle";
                    }
                    builder.setTitle(LocaleController.getString(str3, i2)).setMessage(AndroidUtilities.replaceTags(LocaleController.formatString(str2, i, name, name2))).setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            VoIPHelper.lambda$initiateCall$3(tLRPC$User, tLRPC$Chat, str, z, z2, z3, activity, baseFragment, accountInstance, dialogInterface, i4);
                        }
                    }).setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null).show();
                    return;
                }
                if (tLRPC$User != null || !(activity instanceof LaunchActivity)) {
                    activity.startActivity(new Intent(activity, (Class<?>) LaunchActivity.class).setAction(tLRPC$User != null ? "voip" : "voip_chat"));
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    sharedInstance.setGroupCallHash(str);
                }
                GroupCallActivity.create((LaunchActivity) activity, AccountInstance.getInstance(UserConfig.selectedAccount), null, null, false, null);
                return;
            }
            if (VoIPService.callIShouldHavePutIntoIntent == null) {
                doInitiateCall(tLRPC$User, tLRPC$Chat, str, null, false, z, z2, z3, activity, baseFragment, accountInstance, true, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initiateCall$3(final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final String str, final boolean z, final boolean z2, final boolean z3, final Activity activity, final BaseFragment baseFragment, final AccountInstance accountInstance, DialogInterface dialogInterface, int i) {
        if (VoIPService.getSharedInstance() != null) {
            VoIPService.getSharedInstance().hangUp(new Runnable() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    VoIPHelper.lambda$initiateCall$2(tLRPC$User, tLRPC$Chat, str, z, z2, z3, activity, baseFragment, accountInstance);
                }
            });
        } else {
            doInitiateCall(tLRPC$User, tLRPC$Chat, str, null, false, z, z2, z3, activity, baseFragment, accountInstance, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initiateCall$2(TLRPC$User tLRPC$User, TLRPC$Chat tLRPC$Chat, String str, boolean z, boolean z2, boolean z3, Activity activity, BaseFragment baseFragment, AccountInstance accountInstance) {
        lastCallTime = 0L;
        doInitiateCall(tLRPC$User, tLRPC$Chat, str, null, false, z, z2, z3, activity, baseFragment, accountInstance, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doInitiateCall(final TLRPC$User tLRPC$User, final TLRPC$Chat tLRPC$Chat, final String str, final TLRPC$InputPeer tLRPC$InputPeer, boolean z, final boolean z2, final boolean z3, final boolean z4, final Activity activity, final BaseFragment baseFragment, final AccountInstance accountInstance, boolean z5, boolean z6) {
        ChatObject.Call groupCall;
        TLRPC$ChatFull chatFull;
        TLRPC$ChatFull chatFull2;
        TLRPC$Peer tLRPC$Peer;
        if (activity != null) {
            if (tLRPC$User == null && tLRPC$Chat == null) {
                return;
            }
            if (SystemClock.elapsedRealtime() - lastCallTime < (tLRPC$Chat != null ? 200 : 2000)) {
                return;
            }
            boolean z7 = false;
            boolean z8 = (z5 && tLRPC$Chat != null && tLRPC$Chat.megagroup) ? false : z5;
            if (z8 && tLRPC$Chat != null && !z4 && (chatFull2 = accountInstance.getMessagesController().getChatFull(tLRPC$Chat.id)) != null && (tLRPC$Peer = chatFull2.groupcall_default_join_as) != null) {
                final TLRPC$InputPeer inputPeer = accountInstance.getMessagesController().getInputPeer(MessageObject.getPeerId(tLRPC$Peer));
                JoinCallAlert.checkFewUsers(activity, -tLRPC$Chat.id, accountInstance, new MessagesStorage.BooleanCallback() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda13
                    @Override // org.rbmain.messenger.MessagesStorage.BooleanCallback
                    public final void run(boolean z9) {
                        VoIPHelper.lambda$doInitiateCall$4(str, activity, tLRPC$Chat, tLRPC$User, inputPeer, z2, z3, baseFragment, accountInstance, z9);
                    }
                });
                return;
            }
            if (z8 && tLRPC$Chat != null) {
                JoinCallAlert.open(activity, -tLRPC$Chat.id, accountInstance, baseFragment, !z4 ? 1 : 0, null, new JoinCallAlert.JoinCallAlertDelegate() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda17
                    @Override // org.rbmain.ui.Components.JoinCallAlert.JoinCallAlertDelegate
                    public final void didSelectChat(TLRPC$InputPeer tLRPC$InputPeer2, boolean z9, boolean z10) {
                        VoIPHelper.lambda$doInitiateCall$5(z4, activity, accountInstance, tLRPC$Chat, str, tLRPC$User, z2, z3, baseFragment, tLRPC$InputPeer2, z9, z10);
                    }
                });
                return;
            }
            if (z6 && !z && (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) && ChatObject.shouldSendAnonymously(tLRPC$Chat) && (!ChatObject.isChannel(tLRPC$Chat) || tLRPC$Chat.megagroup)) {
                new AlertDialog.Builder(activity).setTitle(LocaleController.getString("VoipGroupVoiceChat", R.string.VoipGroupVoiceChat)).setMessage(LocaleController.getString("VoipGroupJoinAnonymouseAlert", R.string.VoipGroupJoinAnonymouseAlert)).setPositiveButton(LocaleController.getString("VoipChatJoin", R.string.VoipChatJoin), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
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
            int i = Build.VERSION.SDK_INT;
            intent.putExtra("video_call", i >= 18 && z2);
            if (i >= 18 && z3) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doInitiateCall$4(final String str, final Activity activity, final TLRPC$Chat tLRPC$Chat, final TLRPC$User tLRPC$User, final TLRPC$InputPeer tLRPC$InputPeer, final boolean z, final boolean z2, final BaseFragment baseFragment, final AccountInstance accountInstance, boolean z3) {
        if (!z3 && str != null) {
            JoinCallByUrlAlert joinCallByUrlAlert = new JoinCallByUrlAlert(activity, tLRPC$Chat) { // from class: org.rbmain.ui.Components.voip.VoIPHelper.1
                @Override // org.rbmain.ui.Components.JoinCallByUrlAlert
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doInitiateCall$5(final boolean z, final Activity activity, final AccountInstance accountInstance, final TLRPC$Chat tLRPC$Chat, final String str, final TLRPC$User tLRPC$User, final boolean z2, final boolean z3, final BaseFragment baseFragment, final TLRPC$InputPeer tLRPC$InputPeer, boolean z4, boolean z5) {
        if (z && z5) {
            GroupCallActivity.create((LaunchActivity) activity, accountInstance, tLRPC$Chat, tLRPC$InputPeer, z4, str);
            return;
        }
        if (!z4 && str != null) {
            JoinCallByUrlAlert joinCallByUrlAlert = new JoinCallByUrlAlert(activity, tLRPC$Chat) { // from class: org.rbmain.ui.Components.voip.VoIPHelper.2
                @Override // org.rbmain.ui.Components.JoinCallByUrlAlert
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

    public static void permissionDenied(final Activity activity, final Runnable runnable, int i) {
        int i2;
        String str;
        if (!activity.shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO") || (i == 102 && !activity.shouldShowRequestPermissionRationale("android.permission.CAMERA"))) {
            AlertDialog.Builder title = new AlertDialog.Builder(activity).setTitle(LocaleController.getString("AppName", R.string.AppName));
            if (i == 102) {
                i2 = R.string.VoipNeedMicCameraPermission;
                str = "VoipNeedMicCameraPermission";
            } else {
                i2 = R.string.VoipNeedMicPermission;
                str = "VoipNeedMicPermission";
            }
            title.setMessage(LocaleController.getString(str, i2)).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).setNegativeButton(LocaleController.getString("Settings", R.string.Settings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    VoIPHelper.lambda$permissionDenied$7(activity, dialogInterface, i3);
                }
            }).show().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    VoIPHelper.lambda$permissionDenied$8(runnable, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$permissionDenied$7(Activity activity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$permissionDenied$8(Runnable runnable, DialogInterface dialogInterface) {
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

    public static boolean canRateCall(TLRPC$TL_messageActionPhoneCall tLRPC$TL_messageActionPhoneCall) {
        TLRPC$PhoneCallDiscardReason tLRPC$PhoneCallDiscardReason = tLRPC$TL_messageActionPhoneCall.reason;
        if (!(tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonBusy) && !(tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonMissed)) {
            Iterator<String> it = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).getStringSet("calls_access_hashes", Collections.EMPTY_SET).iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split(" ");
                if (strArrSplit.length >= 2) {
                    if (strArrSplit[0].equals(tLRPC$TL_messageActionPhoneCall.call_id + BuildConfig.FLAVOR)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void showRateAlert(Context context, TLRPC$TL_messageActionPhoneCall tLRPC$TL_messageActionPhoneCall) {
        Iterator<String> it = MessagesController.getNotificationsSettings(UserConfig.selectedAccount).getStringSet("calls_access_hashes", Collections.EMPTY_SET).iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(" ");
            if (strArrSplit.length >= 2) {
                if (strArrSplit[0].equals(tLRPC$TL_messageActionPhoneCall.call_id + BuildConfig.FLAVOR)) {
                    try {
                        showRateAlert(context, null, tLRPC$TL_messageActionPhoneCall.video, tLRPC$TL_messageActionPhoneCall.call_id, Long.parseLong(strArrSplit[1]), UserConfig.selectedAccount, true);
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        }
    }

    public static void showRateAlert(final Context context, final Runnable runnable, boolean z, final String str, final long j, final int i, final boolean z2) {
        String string;
        final File logFile = getLogFile(str);
        int i2 = 1;
        final int[] iArr = {0};
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int iDp = AndroidUtilities.dp(16.0f);
        linearLayout.setPadding(iDp, iDp, iDp, 0);
        final TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        textView.setGravity(17);
        textView.setText(LocaleController.getString("VoipRateCallAlert", R.string.VoipRateCallAlert));
        linearLayout.addView(textView);
        final BetterRatingView betterRatingView = new BetterRatingView(context);
        linearLayout.addView(betterRatingView, LayoutHelper.createLinear(-2, -2, 1, 0, 16, 0, 0));
        final LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        VoIPHelper$$ExternalSyntheticLambda11 voIPHelper$$ExternalSyntheticLambda11 = new View.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoIPHelper.lambda$showRateAlert$9(view);
            }
        };
        String[] strArr = new String[9];
        strArr[0] = z ? "distorted_video" : null;
        strArr[1] = z ? "pixelated_video" : null;
        strArr[2] = "echo";
        strArr[3] = "noise";
        strArr[4] = "interruptions";
        strArr[5] = "distorted_speech";
        strArr[6] = "silent_local";
        strArr[7] = "silent_remote";
        strArr[8] = "dropped";
        int i3 = 0;
        for (int i4 = 9; i3 < i4; i4 = 9) {
            if (strArr[i3] != null) {
                CheckBoxCell checkBoxCell = new CheckBoxCell(context, i2);
                checkBoxCell.setClipToPadding(false);
                checkBoxCell.setTag(strArr[i3]);
                switch (i3) {
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
                checkBoxCell.setOnClickListener(voIPHelper$$ExternalSyntheticLambda11);
                checkBoxCell.setTag(strArr[i3]);
                linearLayout2.addView(checkBoxCell);
            }
            i3++;
            i2 = 1;
        }
        linearLayout.addView(linearLayout2, LayoutHelper.createLinear(-1, -2, -8.0f, 0.0f, -8.0f, 0.0f));
        linearLayout2.setVisibility(8);
        final EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        editTextBoldCursor.setHint(LocaleController.getString("VoipFeedbackCommentHint", R.string.VoipFeedbackCommentHint));
        editTextBoldCursor.setInputType(147457);
        editTextBoldCursor.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        editTextBoldCursor.setHintTextColor(Theme.getColor(Theme.key_dialogTextHint));
        editTextBoldCursor.setBackgroundDrawable(Theme.createEditTextDrawable(context, true));
        editTextBoldCursor.setPadding(0, AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f));
        editTextBoldCursor.setTextSize(1, 18.0f);
        editTextBoldCursor.setVisibility(8);
        linearLayout.addView(editTextBoldCursor, LayoutHelper.createLinear(-1, -2, 8.0f, 8.0f, 8.0f, 0.0f));
        final boolean[] zArr = {true};
        final CheckBoxCell checkBoxCell2 = new CheckBoxCell(context, 1);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda10
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
        textView2.setTextColor(Theme.getColor(Theme.key_dialogTextGray3));
        textView2.setText(LocaleController.getString("CallReportLogsExplain", R.string.CallReportLogsExplain));
        textView2.setPadding(AndroidUtilities.dp(8.0f), 0, AndroidUtilities.dp(8.0f), 0);
        textView2.setOnClickListener(onClickListener);
        linearLayout.addView(textView2);
        checkBoxCell2.setVisibility(8);
        textView2.setVisibility(8);
        if (!logFile.exists()) {
            zArr[0] = false;
        }
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setTitle(LocaleController.getString("CallMessageReportProblem", R.string.CallMessageReportProblem)).setView(linearLayout).setPositiveButton(LocaleController.getString("Send", R.string.Send), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                VoIPHelper.lambda$showRateAlert$11(dialogInterface, i5);
            }
        }).setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VoIPHelper.lambda$showRateAlert$12(runnable, dialogInterface);
            }
        }).create();
        if (BuildVars.LOGS_ENABLED && logFile.exists()) {
            alertDialogCreate.setNeutralButton("Send log", new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i5) {
                    VoIPHelper.lambda$showRateAlert$13(context, logFile, dialogInterface, i5);
                }
            });
        }
        alertDialogCreate.show();
        alertDialogCreate.getWindow().setSoftInputMode(3);
        final View button = alertDialogCreate.getButton(-1);
        button.setEnabled(false);
        betterRatingView.setOnRatingChangeListener(new BetterRatingView.OnRatingChangeListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda16
            @Override // org.rbmain.ui.Components.BetterRatingView.OnRatingChangeListener
            public final void onRatingChanged(int i5) {
                VoIPHelper.lambda$showRateAlert$14(button, i5);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoIPHelper.lambda$showRateAlert$16(betterRatingView, iArr, linearLayout2, editTextBoldCursor, j, str, z2, i, zArr, logFile, context, alertDialogCreate, textView, checkBoxCell2, textView2, button, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$9(View view) {
        ((CheckBoxCell) view).setChecked(!r2.isChecked(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$10(boolean[] zArr, CheckBoxCell checkBoxCell, View view) {
        zArr[0] = !zArr[0];
        checkBoxCell.setChecked(zArr[0], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$12(Runnable runnable, DialogInterface dialogInterface) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$13(Context context, File file, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(context, (Class<?>) LaunchActivity.class);
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$14(View view, int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$16(BetterRatingView betterRatingView, int[] iArr, LinearLayout linearLayout, EditTextBoldCursor editTextBoldCursor, long j, String str, boolean z, int i, final boolean[] zArr, final File file, final Context context, AlertDialog alertDialog, TextView textView, CheckBoxCell checkBoxCell, TextView textView2, View view, View view2) {
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
                tLRPC$TL_phone_setCallRating.comment = BuildConfig.FLAVOR;
            }
            if (!arrayList.isEmpty()) {
                tLRPC$TL_phone_setCallRating.comment += " " + TextUtils.join(" ", arrayList);
            }
            TLRPC$TL_inputPhoneCall tLRPC$TL_inputPhoneCall = new TLRPC$TL_inputPhoneCall();
            tLRPC$TL_phone_setCallRating.peer = tLRPC$TL_inputPhoneCall;
            tLRPC$TL_inputPhoneCall.id = str;
            tLRPC$TL_phone_setCallRating.user_initiative = z;
            CallProxy.getInstance(i).rateCall(tLRPC$TL_phone_setCallRating, new RequestDelegate() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda15
                @Override // org.rbmain.tgnet.RequestDelegate
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

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showRateAlert$15(int i, boolean[] zArr, File file, TLRPC$TL_phone_setCallRating tLRPC$TL_phone_setCallRating, ArrayList arrayList, Context context, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_updates) {
            MessagesController.getInstance(i).processUpdates((TLRPC$TL_updates) tLObject, false);
        }
        if (zArr[0] && file.exists() && tLRPC$TL_phone_setCallRating.rating < 4) {
            SendMessagesHelper.prepareSendingDocument(AccountInstance.getInstance(UserConfig.selectedAccount), file.getAbsolutePath(), file.getAbsolutePath(), null, TextUtils.join(" ", arrayList), "text/plain", 4244000L, null, null, null, null, true, 0);
            Toast.makeText(context, LocaleController.getString("CallReportSent", R.string.CallReportSent), 1).show();
        }
    }

    private static File getLogFile(String str) {
        File file;
        String[] list;
        if (BuildVars.DEBUG_VERSION && (list = (file = new File(ApplicationLoader.applicationContext.getExternalFilesDir(null), "logs")).list()) != null) {
            for (String str2 : list) {
                if (str2.endsWith("voip" + str + ".txt")) {
                    return new File(file, str2);
                }
            }
        }
        return new File(getLogsDir(), str + ".log");
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

    public static String getLogFilePath(String str) {
        Calendar calendar = Calendar.getInstance();
        return new File(ApplicationLoader.applicationContext.getExternalFilesDir(null), String.format(Locale.US, "logs/%02d_%02d_%04d_%02d_%02d_%02d_%s.txt", Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)), Integer.valueOf(calendar.get(13)), str)).getAbsolutePath();
    }

    public static String getLogFilePath(String str, boolean z) {
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
        return new File(logsDir, str + ".log").getAbsolutePath();
    }

    public static void showGroupCallAlert(final BaseFragment baseFragment, final TLRPC$Chat tLRPC$Chat, final TLRPC$InputPeer tLRPC$InputPeer, boolean z, final AccountInstance accountInstance) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        JoinCallAlert.checkFewUsers(baseFragment.getParentActivity(), -tLRPC$Chat.id, accountInstance, new MessagesStorage.BooleanCallback() { // from class: org.rbmain.ui.Components.voip.VoIPHelper$$ExternalSyntheticLambda14
            @Override // org.rbmain.messenger.MessagesStorage.BooleanCallback
            public final void run(boolean z2) {
                VoIPHelper.lambda$showGroupCallAlert$20(tLRPC$Chat, tLRPC$InputPeer, baseFragment, accountInstance, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showGroupCallAlert$20(TLRPC$Chat tLRPC$Chat, TLRPC$InputPeer tLRPC$InputPeer, BaseFragment baseFragment, AccountInstance accountInstance, boolean z) {
        startCall(tLRPC$Chat, tLRPC$InputPeer, null, true, baseFragment.getParentActivity(), baseFragment, accountInstance);
    }
}
