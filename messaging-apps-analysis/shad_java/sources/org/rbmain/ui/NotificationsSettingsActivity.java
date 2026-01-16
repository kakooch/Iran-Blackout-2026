package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.NotificationsController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_account_setContactSignUpNotification;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.NotificationsCheckCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextDetailSettingsCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class NotificationsSettingsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private int accountsAllRow;
    private int accountsInfoRow;
    private int accountsSectionRow;
    private ListAdapter adapter;
    private int androidAutoAlertRow;
    private int badgeNumberMessagesRow;
    private int badgeNumberMutedRow;
    private int badgeNumberSection;
    private int badgeNumberSection2Row;
    private int badgeNumberShowRow;
    private int callsRingtoneRow;
    private int callsSection2Row;
    private int callsSectionRow;
    private int callsVibrateRow;
    private int channelsRow;
    private int contactJoinedRow;
    private int eventsSection2Row;
    private int eventsSectionRow;
    private int groupRow;
    private int inappPreviewRow;
    private int inappPriorityRow;
    private int inappSectionRow;
    private int inappSoundRow;
    private int inappVibrateRow;
    private int inchatSoundRow;
    private RecyclerListView listView;
    private int notificationsSection2Row;
    private int notificationsSectionRow;
    private int notificationsServiceConnectionRow;
    private int notificationsServiceRow;
    private int otherSection2Row;
    private int otherSectionRow;
    private int pinnedMessageRow;
    private int privateRow;
    private int repeatRow;
    private int resetNotificationsRow;
    private int resetNotificationsSectionRow;
    private int resetSection2Row;
    private int resetSectionRow;
    private boolean reseting = false;
    private ArrayList<NotificationException> exceptionUsers = null;
    private ArrayList<NotificationException> exceptionChats = null;
    private ArrayList<NotificationException> exceptionChannels = null;
    private int rowCount = 0;

    public static class NotificationException {
        public long did;
        public boolean hasCustom;
        public int muteUntil;
        public int notify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$5(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public NotificationsSettingsActivity() {
        this.fragmentName = "NotificationsSettingsActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        MessagesController.getInstance(this.currentAccount).loadSignUpNotificationsSettings();
        loadExceptions();
        this.accountsSectionRow = -1;
        this.accountsAllRow = -1;
        this.accountsInfoRow = -1;
        int i = this.rowCount;
        int i2 = i + 1;
        this.rowCount = i2;
        this.notificationsSectionRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.privateRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.groupRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.channelsRow = i4;
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.notificationsSection2Row = i5;
        int i7 = i6 + 1;
        this.rowCount = i7;
        this.callsSectionRow = i6;
        int i8 = i7 + 1;
        this.rowCount = i8;
        this.callsVibrateRow = i7;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.callsRingtoneRow = i8;
        int i10 = i9 + 1;
        this.rowCount = i10;
        this.eventsSection2Row = i9;
        int i11 = i10 + 1;
        this.rowCount = i11;
        this.badgeNumberSection = i10;
        int i12 = i11 + 1;
        this.rowCount = i12;
        this.badgeNumberShowRow = i11;
        int i13 = i12 + 1;
        this.rowCount = i13;
        this.badgeNumberMutedRow = i12;
        int i14 = i13 + 1;
        this.rowCount = i14;
        this.badgeNumberMessagesRow = i13;
        int i15 = i14 + 1;
        this.rowCount = i15;
        this.badgeNumberSection2Row = i14;
        int i16 = i15 + 1;
        this.rowCount = i16;
        this.inappSectionRow = i15;
        int i17 = i16 + 1;
        this.rowCount = i17;
        this.inappSoundRow = i16;
        int i18 = i17 + 1;
        this.rowCount = i18;
        this.inappVibrateRow = i17;
        int i19 = i18 + 1;
        this.rowCount = i19;
        this.inappPreviewRow = i18;
        int i20 = i19 + 1;
        this.rowCount = i20;
        this.inchatSoundRow = i19;
        if (Build.VERSION.SDK_INT >= 21) {
            this.rowCount = i20 + 1;
            this.inappPriorityRow = i20;
        } else {
            this.inappPriorityRow = -1;
        }
        int i21 = this.rowCount;
        int i22 = i21 + 1;
        this.rowCount = i22;
        this.callsSection2Row = i21;
        int i23 = i22 + 1;
        this.rowCount = i23;
        this.eventsSectionRow = i22;
        int i24 = i23 + 1;
        this.rowCount = i24;
        this.contactJoinedRow = i23;
        int i25 = i24 + 1;
        this.rowCount = i25;
        this.pinnedMessageRow = i24;
        int i26 = i25 + 1;
        this.rowCount = i26;
        this.otherSection2Row = i25;
        this.otherSectionRow = -1;
        this.notificationsServiceRow = -1;
        this.notificationsServiceConnectionRow = -1;
        this.androidAutoAlertRow = -1;
        this.repeatRow = -1;
        this.resetSection2Row = -1;
        int i27 = i26 + 1;
        this.rowCount = i27;
        this.resetSectionRow = i26;
        int i28 = i27 + 1;
        this.rowCount = i28;
        this.resetNotificationsRow = i27;
        this.rowCount = i28 + 1;
        this.resetNotificationsSectionRow = i28;
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.notificationsSettingsUpdated);
        return super.onFragmentCreate();
    }

    private void loadExceptions() {
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadExceptions$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x029c A[LOOP:3: B:116:0x029a->B:117:0x029c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadExceptions$1() {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.NotificationsSettingsActivity.lambda$loadExceptions$1():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadExceptions$0(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
        MessagesController.getInstance(this.currentAccount).putUsers(arrayList, true);
        MessagesController.getInstance(this.currentAccount).putChats(arrayList2, true);
        MessagesController.getInstance(this.currentAccount).putEncryptedChats(arrayList3, true);
        this.exceptionUsers = arrayList4;
        this.exceptionChats = arrayList5;
        this.exceptionChannels = arrayList6;
        this.adapter.notifyItemChanged(this.privateRow);
        this.adapter.notifyItemChanged(this.groupRow);
        this.adapter.notifyItemChanged(this.channelsRow);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.notificationsSettingsUpdated);
        getContactProxy().saveNotificationSettings();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.NotificationsSettingsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    NotificationsSettingsActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setLayoutManager(new LinearLayoutManager(this, context, 1, false) { // from class: org.rbmain.ui.NotificationsSettingsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i, float f, float f2) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i, f, f2);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$8(view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(View view, final int i, float f, float f2) {
        ArrayList<NotificationException> arrayList;
        if (getParentActivity() == null) {
            return;
        }
        int i2 = this.privateRow;
        int i3 = 2;
        boolean z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (i == i2 || i == this.groupRow || i == this.channelsRow) {
            if (i == i2) {
                arrayList = this.exceptionUsers;
                i3 = 1;
            } else if (i == this.groupRow) {
                arrayList = this.exceptionChats;
                i3 = 0;
            } else {
                arrayList = this.exceptionChannels;
            }
            if (arrayList == null) {
                return;
            }
            NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) view;
            boolean zIsGlobalNotificationsEnabled = getNotificationsController().isGlobalNotificationsEnabled(i3);
            if ((LocaleController.isRTL && f <= AndroidUtilities.dp(76.0f)) || (!LocaleController.isRTL && f >= view.getMeasuredWidth() - AndroidUtilities.dp(76.0f))) {
                getNotificationsController().setGlobalNotificationsEnabled(i3, !zIsGlobalNotificationsEnabled ? 0 : ConnectionsManager.DEFAULT_DATACENTER_ID);
                notificationsCheckCell.setChecked(!zIsGlobalNotificationsEnabled, 0);
                this.adapter.notifyItemChanged(i);
            } else {
                presentFragment(new NotificationsCustomSettingsActivity(i3, arrayList));
            }
            z = zIsGlobalNotificationsEnabled;
        } else {
            Parcelable parcelable = null;
            parcelable = null;
            if (i == this.callsRingtoneRow) {
                try {
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(this.currentAccount);
                    Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                    intent.putExtra("android.intent.extra.ringtone.TYPE", 1);
                    intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
                    intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
                    intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(1));
                    Uri uri = Settings.System.DEFAULT_RINGTONE_URI;
                    String path = uri != null ? uri.getPath() : null;
                    String string = notificationsSettings.getString("CallsRingtonePath", path);
                    if (string != null && !string.equals("NoSound")) {
                        parcelable = string.equals(path) ? uri : Uri.parse(string);
                    }
                    intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", parcelable);
                    startActivityForResult(intent, i);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            } else if (i == this.resetNotificationsRow) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("ResetNotificationsAlertTitle", R.string.ResetNotificationsAlertTitle));
                builder.setMessage(LocaleController.getString("ResetNotificationsAlert", R.string.ResetNotificationsAlert));
                builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$createView$4(dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                }
            } else if (i == this.inappSoundRow) {
                SharedPreferences notificationsSettings2 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit = notificationsSettings2.edit();
                z = notificationsSettings2.getBoolean("EnableInAppSounds", true);
                editorEdit.putBoolean("EnableInAppSounds", !z);
                editorEdit.apply();
            } else if (i == this.inappVibrateRow) {
                SharedPreferences notificationsSettings3 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit2 = notificationsSettings3.edit();
                z = notificationsSettings3.getBoolean("EnableInAppVibrate", true);
                editorEdit2.putBoolean("EnableInAppVibrate", !z);
                editorEdit2.apply();
            } else if (i == this.inappPreviewRow) {
                SharedPreferences notificationsSettings4 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit3 = notificationsSettings4.edit();
                z = notificationsSettings4.getBoolean("EnableInAppPreview", true);
                editorEdit3.putBoolean("EnableInAppPreview", !z);
                editorEdit3.apply();
            } else if (i == this.inchatSoundRow) {
                SharedPreferences notificationsSettings5 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit4 = notificationsSettings5.edit();
                z = notificationsSettings5.getBoolean("EnableInChatSound", true);
                editorEdit4.putBoolean("EnableInChatSound", !z);
                editorEdit4.apply();
                getNotificationsController().setInChatSoundEnabled(!z);
            } else if (i == this.inappPriorityRow) {
                SharedPreferences notificationsSettings6 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit5 = notificationsSettings6.edit();
                z = notificationsSettings6.getBoolean("EnableInAppPriority", false);
                editorEdit5.putBoolean("EnableInAppPriority", !z);
                editorEdit5.apply();
            } else if (i == this.contactJoinedRow) {
                SharedPreferences notificationsSettings7 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit6 = notificationsSettings7.edit();
                z = notificationsSettings7.getBoolean("EnableContactJoined", true);
                MessagesController.getInstance(this.currentAccount).enableJoined = !z;
                editorEdit6.putBoolean("EnableContactJoined", !z);
                editorEdit6.apply();
                TLRPC$TL_account_setContactSignUpNotification tLRPC$TL_account_setContactSignUpNotification = new TLRPC$TL_account_setContactSignUpNotification();
                tLRPC$TL_account_setContactSignUpNotification.silent = z;
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_setContactSignUpNotification, new RequestDelegate() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda7
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        NotificationsSettingsActivity.lambda$createView$5(tLObject, tLRPC$TL_error);
                    }
                });
            } else if (i == this.pinnedMessageRow) {
                SharedPreferences notificationsSettings8 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit7 = notificationsSettings8.edit();
                z = notificationsSettings8.getBoolean("PinnedMessages", true);
                editorEdit7.putBoolean("PinnedMessages", !z);
                editorEdit7.apply();
            } else if (i == this.androidAutoAlertRow) {
                SharedPreferences notificationsSettings9 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit8 = notificationsSettings9.edit();
                z = notificationsSettings9.getBoolean("EnableAutoNotifications", false);
                editorEdit8.putBoolean("EnableAutoNotifications", !z);
                editorEdit8.apply();
            } else if (i == this.badgeNumberShowRow) {
                SharedPreferences.Editor editorEdit9 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                z = getNotificationsController().showBadgeNumber;
                getNotificationsController().showBadgeNumber = !z;
                editorEdit9.putBoolean("badgeNumber", getNotificationsController().showBadgeNumber);
                editorEdit9.apply();
                getNotificationsController().updateBadge();
            } else if (i == this.badgeNumberMutedRow) {
                SharedPreferences.Editor editorEdit10 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                z = getNotificationsController().showBadgeMuted;
                getNotificationsController().showBadgeMuted = !z;
                editorEdit10.putBoolean("badgeNumberMuted", getNotificationsController().showBadgeMuted);
                editorEdit10.apply();
                getNotificationsController().updateBadge();
                getMessagesStorage().updateMutedDialogsFiltersCounters();
            } else if (i == this.badgeNumberMessagesRow) {
                SharedPreferences.Editor editorEdit11 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                z = getNotificationsController().showBadgeMessages;
                getNotificationsController().showBadgeMessages = !z;
                editorEdit11.putBoolean("badgeNumberMessages", getNotificationsController().showBadgeMessages);
                editorEdit11.apply();
                getNotificationsController().updateBadge();
            } else if (i == this.notificationsServiceConnectionRow) {
                SharedPreferences notificationsSettings10 = MessagesController.getNotificationsSettings(this.currentAccount);
                boolean z2 = notificationsSettings10.getBoolean("pushConnection", getMessagesController().backgroundConnection);
                SharedPreferences.Editor editorEdit12 = notificationsSettings10.edit();
                editorEdit12.putBoolean("pushConnection", !z2);
                editorEdit12.apply();
                if (!z2) {
                    ConnectionsManager.getInstance(this.currentAccount).setPushConnectionEnabled(true);
                } else {
                    ConnectionsManager.getInstance(this.currentAccount).setPushConnectionEnabled(false);
                }
                z = z2;
            } else if (i == this.accountsAllRow) {
                SharedPreferences globalNotificationsSettings = MessagesController.getGlobalNotificationsSettings();
                boolean z3 = globalNotificationsSettings.getBoolean("AllAccounts", true);
                SharedPreferences.Editor editorEdit13 = globalNotificationsSettings.edit();
                editorEdit13.putBoolean("AllAccounts", !z3);
                editorEdit13.apply();
                SharedConfig.showNotificationsForAllAccounts = !z3;
                for (int i4 = 0; i4 < 3; i4++) {
                    if (SharedConfig.showNotificationsForAllAccounts) {
                        NotificationsController.getInstance(i4).showNotifications();
                    } else if (i4 == this.currentAccount) {
                        NotificationsController.getInstance(i4).showNotifications();
                    } else {
                        NotificationsController.getInstance(i4).hideNotifications();
                    }
                }
                z = z3;
            } else if (i == this.notificationsServiceRow) {
                SharedPreferences notificationsSettings11 = MessagesController.getNotificationsSettings(this.currentAccount);
                z = notificationsSettings11.getBoolean("pushService", getMessagesController().keepAliveService);
                SharedPreferences.Editor editorEdit14 = notificationsSettings11.edit();
                editorEdit14.putBoolean("pushService", !z);
                editorEdit14.apply();
                ApplicationLoader.startPushService();
            } else if (i == this.callsVibrateRow) {
                if (getParentActivity() == null) {
                    return;
                } else {
                    showDialog(AlertsCreator.createVibrationSelectDialog(getParentActivity(), 0L, i == this.callsVibrateRow ? "vibrate_calls" : null, new Runnable() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$6(i);
                        }
                    }));
                }
            } else if (i == this.repeatRow) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
                builder2.setTitle(LocaleController.getString("RepeatNotifications", R.string.RepeatNotifications));
                builder2.setItems(new CharSequence[]{LocaleController.getString("RepeatDisabled", R.string.RepeatDisabled), LocaleController.formatPluralString("Minutes", 5), LocaleController.formatPluralString("Minutes", 10), LocaleController.formatPluralString("Minutes", 30), LocaleController.formatPluralString("Hours", 1), LocaleController.formatPluralString("Hours", 2), LocaleController.formatPluralString("Hours", 4)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.f$0.lambda$createView$7(i, dialogInterface, i5);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder2.create());
            }
        }
        if (view instanceof TextCheckCell) {
            ((TextCheckCell) view).setChecked(!z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(DialogInterface dialogInterface, int i) {
        if (this.reseting) {
            return;
        }
        this.reseting = true;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_account_resetNotifySettings
            public static int constructor = -612493497;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i2, boolean z) {
                return TLRPC$Bool.TLdeserialize(abstractSerializedData, i2, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda6
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$3(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.NotificationsSettingsActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2() {
        getMessagesController().enableJoined = true;
        this.reseting = false;
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
        editorEdit.clear();
        editorEdit.apply();
        this.exceptionChats.clear();
        this.exceptionUsers.clear();
        this.adapter.notifyDataSetChanged();
        if (getParentActivity() != null) {
            Toast.makeText(getParentActivity(), LocaleController.getString("ResetNotificationsText", R.string.ResetNotificationsText), 0).show();
        }
        getMessagesStorage().updateMutedDialogsFiltersCounters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(int i) {
        this.adapter.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(int i, DialogInterface dialogInterface, int i2) {
        MessagesController.getNotificationsSettings(this.currentAccount).edit().putInt("repeat_messages", i2 != 1 ? i2 == 2 ? 10 : i2 == 3 ? 30 : i2 == 4 ? 60 : i2 == 5 ? 120 : i2 == 6 ? 240 : 0 : 5).apply();
        this.adapter.notifyItemChanged(i);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) {
        Ringtone ringtone;
        if (i2 == -1) {
            Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
            String title = null;
            if (uri != null && (ringtone = RingtoneManager.getRingtone(getParentActivity(), uri)) != null) {
                if (i == this.callsRingtoneRow) {
                    if (uri.equals(Settings.System.DEFAULT_RINGTONE_URI)) {
                        title = LocaleController.getString("DefaultRingtone", R.string.DefaultRingtone);
                    } else {
                        title = ringtone.getTitle(getParentActivity());
                    }
                } else if (uri.equals(Settings.System.DEFAULT_NOTIFICATION_URI)) {
                    title = LocaleController.getString("SoundDefault", R.string.SoundDefault);
                } else {
                    title = ringtone.getTitle(getParentActivity());
                }
                ringtone.stop();
            }
            SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
            if (i == this.callsRingtoneRow) {
                if (title != null && uri != null) {
                    editorEdit.putString("CallsRingtone", title);
                    editorEdit.putString("CallsRingtonePath", uri.toString());
                } else {
                    editorEdit.putString("CallsRingtone", "NoSound");
                    editorEdit.putString("CallsRingtonePath", "NoSound");
                }
            }
            editorEdit.apply();
            this.adapter.notifyItemChanged(i);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.notificationsSettingsUpdated) {
            this.adapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return (adapterPosition == NotificationsSettingsActivity.this.notificationsSectionRow || adapterPosition == NotificationsSettingsActivity.this.notificationsSection2Row || adapterPosition == NotificationsSettingsActivity.this.inappSectionRow || adapterPosition == NotificationsSettingsActivity.this.eventsSectionRow || adapterPosition == NotificationsSettingsActivity.this.otherSectionRow || adapterPosition == NotificationsSettingsActivity.this.resetSectionRow || adapterPosition == NotificationsSettingsActivity.this.badgeNumberSection || adapterPosition == NotificationsSettingsActivity.this.otherSection2Row || adapterPosition == NotificationsSettingsActivity.this.resetSection2Row || adapterPosition == NotificationsSettingsActivity.this.callsSection2Row || adapterPosition == NotificationsSettingsActivity.this.callsSectionRow || adapterPosition == NotificationsSettingsActivity.this.badgeNumberSection2Row || adapterPosition == NotificationsSettingsActivity.this.accountsSectionRow || adapterPosition == NotificationsSettingsActivity.this.accountsInfoRow || adapterPosition == NotificationsSettingsActivity.this.resetNotificationsSectionRow) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NotificationsSettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View headerCell;
            if (i == 0) {
                headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 1) {
                headerCell = new TextCheckCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 2) {
                headerCell = new TextDetailSettingsCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 3) {
                headerCell = new NotificationsCheckCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 4) {
                headerCell = new ShadowSectionCell(this.mContext);
            } else if (i == 5) {
                headerCell = new TextSettingsCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else {
                headerCell = new TextInfoPrivacyCell(this.mContext);
                headerCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
            }
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            int i2;
            String pluralString;
            switch (viewHolder.getItemViewType()) {
                case 0:
                    HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                    if (i != NotificationsSettingsActivity.this.notificationsSectionRow) {
                        if (i != NotificationsSettingsActivity.this.inappSectionRow) {
                            if (i != NotificationsSettingsActivity.this.eventsSectionRow) {
                                if (i != NotificationsSettingsActivity.this.otherSectionRow) {
                                    if (i != NotificationsSettingsActivity.this.resetSectionRow) {
                                        if (i != NotificationsSettingsActivity.this.callsSectionRow) {
                                            if (i != NotificationsSettingsActivity.this.badgeNumberSection) {
                                                if (i == NotificationsSettingsActivity.this.accountsSectionRow) {
                                                    headerCell.setText(LocaleController.getString("ShowNotificationsFor", R.string.ShowNotificationsFor));
                                                    break;
                                                }
                                            } else {
                                                headerCell.setText(LocaleController.getString("BadgeNumber", R.string.BadgeNumber));
                                                break;
                                            }
                                        } else {
                                            headerCell.setText(LocaleController.getString("VoipNotificationSettings", R.string.VoipNotificationSettings));
                                            break;
                                        }
                                    } else {
                                        headerCell.setText(LocaleController.getString("Reset", R.string.Reset));
                                        break;
                                    }
                                } else {
                                    headerCell.setText(LocaleController.getString("NotificationsOther", R.string.NotificationsOther));
                                    break;
                                }
                            } else {
                                headerCell.setText(LocaleController.getString("Events", R.string.Events));
                                break;
                            }
                        } else {
                            headerCell.setText(LocaleController.getString("InAppNotifications", R.string.InAppNotifications));
                            break;
                        }
                    } else {
                        headerCell.setText(LocaleController.getString("NotificationsForChats", R.string.NotificationsForChats));
                        break;
                    }
                    break;
                case 1:
                    TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) NotificationsSettingsActivity.this).currentAccount);
                    if (i != NotificationsSettingsActivity.this.inappSoundRow) {
                        if (i != NotificationsSettingsActivity.this.inappVibrateRow) {
                            if (i != NotificationsSettingsActivity.this.inappPreviewRow) {
                                if (i != NotificationsSettingsActivity.this.inappPriorityRow) {
                                    if (i != NotificationsSettingsActivity.this.contactJoinedRow) {
                                        if (i != NotificationsSettingsActivity.this.pinnedMessageRow) {
                                            if (i != NotificationsSettingsActivity.this.androidAutoAlertRow) {
                                                if (i != NotificationsSettingsActivity.this.notificationsServiceRow) {
                                                    if (i != NotificationsSettingsActivity.this.notificationsServiceConnectionRow) {
                                                        if (i == NotificationsSettingsActivity.this.badgeNumberShowRow) {
                                                            textCheckCell.setTextAndCheck(LocaleController.getString("BadgeNumberShow", R.string.BadgeNumberShow), NotificationsSettingsActivity.this.getNotificationsController().showBadgeNumber, true);
                                                            break;
                                                        } else if (i == NotificationsSettingsActivity.this.badgeNumberMutedRow) {
                                                            textCheckCell.setTextAndCheck(LocaleController.getString("BadgeNumberMutedChats", R.string.BadgeNumberMutedChats), NotificationsSettingsActivity.this.getNotificationsController().showBadgeMuted, true);
                                                            break;
                                                        } else if (i == NotificationsSettingsActivity.this.badgeNumberMessagesRow) {
                                                            textCheckCell.setTextAndCheck(LocaleController.getString("BadgeNumberUnread", R.string.BadgeNumberUnread), NotificationsSettingsActivity.this.getNotificationsController().showBadgeMessages, false);
                                                            break;
                                                        } else if (i != NotificationsSettingsActivity.this.inchatSoundRow) {
                                                            if (i != NotificationsSettingsActivity.this.callsVibrateRow) {
                                                                if (i == NotificationsSettingsActivity.this.accountsAllRow) {
                                                                    textCheckCell.setTextAndCheck(LocaleController.getString("AllAccounts", R.string.AllAccounts), MessagesController.getGlobalNotificationsSettings().getBoolean("AllAccounts", true), false);
                                                                    break;
                                                                }
                                                            } else {
                                                                textCheckCell.setTextAndCheck(LocaleController.getString("Vibrate", R.string.Vibrate), notificationsSettings.getBoolean("EnableCallVibrate", true), true);
                                                                break;
                                                            }
                                                        } else {
                                                            textCheckCell.setTextAndCheck(LocaleController.getString("InChatSound", R.string.InChatSound), notificationsSettings.getBoolean("EnableInChatSound", true), true);
                                                            break;
                                                        }
                                                    } else {
                                                        textCheckCell.setTextAndValueAndCheck(LocaleController.getString("NotificationsServiceConnection", R.string.NotificationsServiceConnection), LocaleController.getString("NotificationsServiceConnectionInfo", R.string.NotificationsServiceConnectionInfo), notificationsSettings.getBoolean("pushConnection", NotificationsSettingsActivity.this.getMessagesController().backgroundConnection), true, true);
                                                        break;
                                                    }
                                                } else {
                                                    textCheckCell.setTextAndValueAndCheck(LocaleController.getString("NotificationsService", R.string.NotificationsService), LocaleController.getString("NotificationsServiceInfo", R.string.NotificationsServiceInfo), notificationsSettings.getBoolean("pushService", NotificationsSettingsActivity.this.getMessagesController().keepAliveService), true, true);
                                                    break;
                                                }
                                            } else {
                                                textCheckCell.setTextAndCheck("Android Auto", notificationsSettings.getBoolean("EnableAutoNotifications", false), true);
                                                break;
                                            }
                                        } else {
                                            textCheckCell.setTextAndCheck(LocaleController.getString("PinnedMessages", R.string.PinnedMessages), notificationsSettings.getBoolean("PinnedMessages", true), false);
                                            break;
                                        }
                                    } else {
                                        textCheckCell.setTextAndCheck(LocaleController.getString("ContactJoined", R.string.ContactJoined), notificationsSettings.getBoolean("EnableContactJoined", true), true);
                                        break;
                                    }
                                } else {
                                    textCheckCell.setTextAndCheck(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), notificationsSettings.getBoolean("EnableInAppPriority", false), false);
                                    break;
                                }
                            } else {
                                textCheckCell.setTextAndCheck(LocaleController.getString("InAppPreview", R.string.InAppPreview), notificationsSettings.getBoolean("EnableInAppPreview", true), true);
                                break;
                            }
                        } else {
                            textCheckCell.setTextAndCheck(LocaleController.getString("InAppVibrate", R.string.InAppVibrate), notificationsSettings.getBoolean("EnableInAppVibrate", true), true);
                            break;
                        }
                    } else {
                        textCheckCell.setTextAndCheck(LocaleController.getString("InAppSounds", R.string.InAppSounds), notificationsSettings.getBoolean("EnableInAppSounds", true), true);
                        break;
                    }
                    break;
                case 2:
                    TextDetailSettingsCell textDetailSettingsCell = (TextDetailSettingsCell) viewHolder.itemView;
                    textDetailSettingsCell.setMultilineDetail(true);
                    if (i == NotificationsSettingsActivity.this.resetNotificationsRow) {
                        textDetailSettingsCell.setTextAndValue(LocaleController.getString("ResetAllNotifications", R.string.ResetAllNotifications), LocaleController.getString("UndoAllCustom", R.string.UndoAllCustom), false);
                        break;
                    }
                    break;
                case 3:
                    NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings2 = MessagesController.getNotificationsSettings(((BaseFragment) NotificationsSettingsActivity.this).currentAccount);
                    int currentTime = ConnectionsManager.getInstance(((BaseFragment) NotificationsSettingsActivity.this).currentAccount).getCurrentTime();
                    if (i != NotificationsSettingsActivity.this.privateRow) {
                        if (i == NotificationsSettingsActivity.this.groupRow) {
                            string = LocaleController.getString("NotificationsGroups", R.string.NotificationsGroups);
                            ArrayList unused = NotificationsSettingsActivity.this.exceptionChats;
                            i2 = notificationsSettings2.getInt("EnableGroup2", 0);
                        } else {
                            string = LocaleController.getString("NotificationsChannels", R.string.NotificationsChannels);
                            ArrayList unused2 = NotificationsSettingsActivity.this.exceptionChannels;
                            i2 = notificationsSettings2.getInt("EnableChannel2", 0);
                        }
                    } else {
                        string = LocaleController.getString("NotificationsPrivateChats", R.string.NotificationsPrivateChats);
                        ArrayList unused3 = NotificationsSettingsActivity.this.exceptionUsers;
                        i2 = notificationsSettings2.getInt("EnableAll2", 0);
                    }
                    String str = string;
                    boolean z = i2 < currentTime;
                    int i3 = (!z && i2 - 31536000 < currentTime) ? 2 : 0;
                    StringBuilder sb = new StringBuilder();
                    sb.append(LocaleController.getString("TapToChange", R.string.TapToChange));
                    notificationsCheckCell.setTextAndValueAndCheck(str, sb, z, i3, i != NotificationsSettingsActivity.this.channelsRow);
                    break;
                case 4:
                    if (i == NotificationsSettingsActivity.this.resetNotificationsSectionRow) {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                        break;
                    } else {
                        viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        break;
                    }
                case 5:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings3 = MessagesController.getNotificationsSettings(((BaseFragment) NotificationsSettingsActivity.this).currentAccount);
                    if (i != NotificationsSettingsActivity.this.callsRingtoneRow) {
                        if (i != NotificationsSettingsActivity.this.callsVibrateRow) {
                            if (i == NotificationsSettingsActivity.this.repeatRow) {
                                int i4 = notificationsSettings3.getInt("repeat_messages", 60);
                                if (i4 == 0) {
                                    pluralString = LocaleController.getString("RepeatNotificationsNever", R.string.RepeatNotificationsNever);
                                } else if (i4 < 60) {
                                    pluralString = LocaleController.formatPluralString("Minutes", i4);
                                } else {
                                    pluralString = LocaleController.formatPluralString("Hours", i4 / 60);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("RepeatNotifications", R.string.RepeatNotifications), pluralString, false);
                                break;
                            }
                        } else {
                            int i5 = i == NotificationsSettingsActivity.this.callsVibrateRow ? notificationsSettings3.getInt("vibrate_calls", 0) : 0;
                            if (i5 != 0) {
                                if (i5 != 1) {
                                    if (i5 != 2) {
                                        if (i5 != 3) {
                                            if (i5 == 4) {
                                                textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("OnlyIfSilent", R.string.OnlyIfSilent), true);
                                                break;
                                            }
                                        } else {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Long", R.string.Long), true);
                                            break;
                                        }
                                    } else {
                                        textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDisabled", R.string.VibrationDisabled), true);
                                        break;
                                    }
                                } else {
                                    textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Short", R.string.Short), true);
                                    break;
                                }
                            } else {
                                textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDefault", R.string.VibrationDefault), true);
                                break;
                            }
                        }
                    } else {
                        String string2 = notificationsSettings3.getString("CallsRingtone", LocaleController.getString("DefaultRingtone", R.string.DefaultRingtone));
                        if (string2.equals("NoSound")) {
                            string2 = LocaleController.getString("NoSound", R.string.NoSound);
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("VoipSettingsRingtone", R.string.VoipSettingsRingtone), string2, false);
                        break;
                    }
                    break;
                case 6:
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                    if (i == NotificationsSettingsActivity.this.accountsInfoRow) {
                        textInfoPrivacyCell.setText(LocaleController.getString("ShowNotificationsForInfo", R.string.ShowNotificationsForInfo));
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == NotificationsSettingsActivity.this.eventsSectionRow || i == NotificationsSettingsActivity.this.otherSectionRow || i == NotificationsSettingsActivity.this.resetSectionRow || i == NotificationsSettingsActivity.this.callsSectionRow || i == NotificationsSettingsActivity.this.badgeNumberSection || i == NotificationsSettingsActivity.this.inappSectionRow || i == NotificationsSettingsActivity.this.notificationsSectionRow || i == NotificationsSettingsActivity.this.accountsSectionRow) {
                return 0;
            }
            if (i == NotificationsSettingsActivity.this.inappSoundRow || i == NotificationsSettingsActivity.this.inappVibrateRow || i == NotificationsSettingsActivity.this.notificationsServiceConnectionRow || i == NotificationsSettingsActivity.this.inappPreviewRow || i == NotificationsSettingsActivity.this.contactJoinedRow || i == NotificationsSettingsActivity.this.pinnedMessageRow || i == NotificationsSettingsActivity.this.notificationsServiceRow || i == NotificationsSettingsActivity.this.badgeNumberMutedRow || i == NotificationsSettingsActivity.this.badgeNumberMessagesRow || i == NotificationsSettingsActivity.this.badgeNumberShowRow || i == NotificationsSettingsActivity.this.inappPriorityRow || i == NotificationsSettingsActivity.this.inchatSoundRow || i == NotificationsSettingsActivity.this.androidAutoAlertRow || i == NotificationsSettingsActivity.this.accountsAllRow) {
                return 1;
            }
            if (i == NotificationsSettingsActivity.this.resetNotificationsRow) {
                return 2;
            }
            if (i == NotificationsSettingsActivity.this.privateRow || i == NotificationsSettingsActivity.this.groupRow || i == NotificationsSettingsActivity.this.channelsRow) {
                return 3;
            }
            if (i == NotificationsSettingsActivity.this.eventsSection2Row || i == NotificationsSettingsActivity.this.notificationsSection2Row || i == NotificationsSettingsActivity.this.otherSection2Row || i == NotificationsSettingsActivity.this.resetSection2Row || i == NotificationsSettingsActivity.this.callsSection2Row || i == NotificationsSettingsActivity.this.badgeNumberSection2Row || i == NotificationsSettingsActivity.this.resetNotificationsSectionRow) {
                return 4;
            }
            return i == NotificationsSettingsActivity.this.accountsInfoRow ? 6 : 5;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCheckCell.class, TextDetailSettingsCell.class, TextSettingsCell.class, NotificationsCheckCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        int i4 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i5 = Theme.key_switchTrack;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        int i6 = Theme.key_switchTrackChecked;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        int i7 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteLinkText));
        return arrayList;
    }
}
