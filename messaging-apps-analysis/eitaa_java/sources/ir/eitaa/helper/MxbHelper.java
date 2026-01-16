package ir.eitaa.helper;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_mbpUserRegisterInfos;
import ir.eitaa.tgnet.TLRPC$TL_mxbCreateUser;
import ir.eitaa.tgnet.TLRPC$TL_mxbUser;
import ir.eitaa.tgnet.TLRPC$TL_mxpGetUserRegisterInfo;
import ir.eitaa.tgnet.TLRPC$TL_users_getFullUser;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;

/* loaded from: classes.dex */
public class MxbHelper {
    private static MxbHelper instance;
    public ContentValues messengersIc;
    public ContentValues messengersName;

    public interface MxbDelegate {
        void onMxbPressed(String phone);
    }

    private MxbHelper() {
        ContentValues contentValues = new ContentValues();
        this.messengersName = contentValues;
        contentValues.put("1", LocaleController.getString("Bale", R.string.Bale));
        this.messengersName.put("2", LocaleController.getString("IGap", R.string.IGap));
        this.messengersName.put("3", LocaleController.getString("Gap", R.string.Gap));
        this.messengersName.put("4", LocaleController.getString("AppName", R.string.AppName));
        this.messengersName.put("5", LocaleController.getString("Rubica", R.string.Rubica));
        this.messengersName.put("6", LocaleController.getString("Soroush", R.string.Soroush));
        this.messengersName.put("7", LocaleController.getString("Chavosh", R.string.Chavosh));
        this.messengersName.put("8", LocaleController.getString("Chavosh", R.string.Chavosh));
        ContentValues contentValues2 = new ContentValues();
        this.messengersIc = contentValues2;
        contentValues2.put("1", Integer.valueOf(R.drawable.bale_ic));
        this.messengersIc.put("2", Integer.valueOf(R.drawable.igap_ic));
        this.messengersIc.put("3", Integer.valueOf(R.drawable.gap_ic));
        this.messengersIc.put("4", Integer.valueOf(R.drawable.ic_launcher_dr));
        this.messengersIc.put("5", Integer.valueOf(R.drawable.rubica_ic));
        this.messengersIc.put("6", Integer.valueOf(R.drawable.soroush_ic));
        ContentValues contentValues3 = this.messengersIc;
        Integer numValueOf = Integer.valueOf(R.drawable.chavosh_ic);
        contentValues3.put("7", numValueOf);
        this.messengersIc.put("8", numValueOf);
    }

    public static MxbHelper getInstance() {
        if (instance == null) {
            instance = new MxbHelper();
        }
        return instance;
    }

    public static void showMxbMessengersDialog(final BaseFragment fragment, String phone) {
        final AlertDialog alertDialog = new AlertDialog(fragment.getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.show();
        TLRPC$TL_mxpGetUserRegisterInfo tLRPC$TL_mxpGetUserRegisterInfo = new TLRPC$TL_mxpGetUserRegisterInfo();
        StringBuilder sb = new StringBuilder(phone);
        if (sb.charAt(0) == '+') {
            sb.deleteCharAt(0);
        }
        tLRPC$TL_mxpGetUserRegisterInfo.phone = sb.toString();
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_mxpGetUserRegisterInfo, new RequestDelegate() { // from class: ir.eitaa.helper.-$$Lambda$MxbHelper$HfjOJb0s2gP0W5OhBnm4fC7Ew44
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.-$$Lambda$MxbHelper$eYQEHaKpgG97Yq-LOxmRrArLMrI
                    @Override // java.lang.Runnable
                    public final void run() {
                        MxbHelper.lambda$showMxbMessengersDialog$0(tLRPC$TL_error, baseFragment, tLObject, alertDialog);
                    }
                });
            }
        });
    }

    static /* synthetic */ void lambda$showMxbMessengersDialog$0(TLRPC$TL_error tLRPC$TL_error, BaseFragment baseFragment, TLObject tLObject, AlertDialog alertDialog) {
        if (tLRPC$TL_error != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
            builder.setTitle(LocaleController.getString("MXB", R.string.MXB));
            if (tLRPC$TL_error.text.equals("MXB_USER_NOT_ACIVE")) {
                builder.setMessage(LocaleController.getString("MxbNotActive", R.string.MxbNotActive));
                updateUserMxbState();
            } else if (tLRPC$TL_error.text.equals("MXB_SERVER_FAILED")) {
                builder.setMessage(LocaleController.getString("ConnectionErrorMXB", R.string.ConnectionErrorMXB));
            } else if (tLRPC$TL_error.text.equals("MXB_USER_NOT_EXIST")) {
                builder.setMessage(LocaleController.getString("MxbUserNotFound", R.string.MxbUserNotFound));
            } else {
                builder.setMessage(tLRPC$TL_error.text);
            }
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.helper.MxbHelper.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.create().show();
        } else {
            TLRPC$TL_mbpUserRegisterInfos tLRPC$TL_mbpUserRegisterInfos = (TLRPC$TL_mbpUserRegisterInfos) tLObject;
            if (tLRPC$TL_mbpUserRegisterInfos != null) {
                if (tLRPC$TL_mbpUserRegisterInfos.mxbRegisterInfos.size() == 0) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(baseFragment.getParentActivity());
                    builder2.setTitle(LocaleController.getString("MXB", R.string.MXB));
                    builder2.setMessage(LocaleController.getString("MxbNotRegistered", R.string.MxbNotRegistered));
                    builder2.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.helper.MxbHelper.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder2.create().show();
                } else {
                    AlertsCreator.createMxbDialog(baseFragment, LocaleController.getString("SendMessageToOtherMessengers", R.string.SendMessageToOtherMessengers), false, tLRPC$TL_mbpUserRegisterInfos);
                }
            } else {
                Log.d("mxp", "TL_mxpGetUserRegisterInfo response is null");
                AlertDialog.Builder builder3 = new AlertDialog.Builder(baseFragment.getParentActivity());
                builder3.setTitle(LocaleController.getString("MXB", R.string.MXB));
                builder3.setMessage(LocaleController.getString("ConnectionErrorMXB", R.string.ConnectionErrorMXB));
                builder3.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.helper.MxbHelper.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder3.create().show();
            }
        }
        alertDialog.dismiss();
    }

    public static void openChat(final BaseFragment fragment, int messengerId, String phone, int userId) {
        if (userId != -1) {
            Bundle bundle = new Bundle();
            bundle.putLong("user_id", userId);
            fragment.presentFragment(new ChatActivity(bundle));
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(fragment.getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.show();
        TLRPC$TL_mxbCreateUser tLRPC$TL_mxbCreateUser = new TLRPC$TL_mxbCreateUser();
        tLRPC$TL_mxbCreateUser.messenger_id = messengerId;
        tLRPC$TL_mxbCreateUser.phone = phone;
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_mxbCreateUser, new RequestDelegate() { // from class: ir.eitaa.helper.-$$Lambda$MxbHelper$SMQIPEpGWr_8_4bey1idBGcwMW8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MxbHelper.lambda$openChat$3(fragment, alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    static /* synthetic */ void lambda$openChat$3(final BaseFragment baseFragment, final AlertDialog alertDialog, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        final TLRPC$TL_mxbUser tLRPC$TL_mxbUser = (TLRPC$TL_mxbUser) tLObject;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.-$$Lambda$MxbHelper$KJfSWjx9Uu7mNp3iSfdoZygvWDQ
            @Override // java.lang.Runnable
            public final void run() {
                MxbHelper.lambda$openChat$2(tLRPC$TL_mxbUser, baseFragment, alertDialog);
            }
        });
    }

    static /* synthetic */ void lambda$openChat$2(TLRPC$TL_mxbUser tLRPC$TL_mxbUser, BaseFragment baseFragment, AlertDialog alertDialog) {
        if (tLRPC$TL_mxbUser != null) {
            MessagesController.getInstance(UserConfig.selectedAccount).putUser(tLRPC$TL_mxbUser.user, false);
            Bundle bundle = new Bundle();
            bundle.putLong("user_id", tLRPC$TL_mxbUser.user.id);
            baseFragment.presentFragment(new ChatActivity(bundle));
        } else {
            Log.d("RegisterConfig", "response is null");
        }
        alertDialog.dismiss();
    }

    private static void updateUserMxbState() {
        TLRPC$User user = MessagesController.getInstance(UserConfig.selectedAccount).getUser(Long.valueOf(UserConfig.getInstance(UserConfig.selectedAccount).clientUserId));
        TLRPC$TL_users_getFullUser tLRPC$TL_users_getFullUser = new TLRPC$TL_users_getFullUser();
        tLRPC$TL_users_getFullUser.id = MessagesController.getInstance(UserConfig.selectedAccount).getInputUser(user);
        ConnectionsManager.getInstance(UserConfig.selectedAccount).sendRequest(tLRPC$TL_users_getFullUser, new RequestDelegate() { // from class: ir.eitaa.helper.-$$Lambda$MxbHelper$YZABjGMkhxSF2Cpu0ZLfSDQ1N6M
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                MxbHelper.lambda$updateUserMxbState$4(tLObject, tLRPC$TL_error);
            }
        });
    }

    static /* synthetic */ void lambda$updateUserMxbState$4(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            TLRPC$UserFull tLRPC$UserFull = (TLRPC$UserFull) tLObject;
            MessagesStorage.getInstance(UserConfig.selectedAccount).updateUserInfo(tLRPC$UserFull, false);
            MessagesController.getInstance(UserConfig.selectedAccount).putUser(tLRPC$UserFull.user, false);
            UserConfig.getInstance(UserConfig.selectedAccount).setMxbState(tLRPC$UserFull.user.MXB_REGISTERED_USER);
        }
    }
}
