package ir.eitaa.ui;

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
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.NotificationsCheckCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextDetailSettingsCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
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
    private ArrayList<NotificationException> exceptionChannels;
    private ArrayList<NotificationException> exceptionChats;
    private ArrayList<NotificationException> exceptionUsers;
    private int groupRow;
    private int inappPreviewRow;
    private int inappPriorityRow;
    private int inappSectionRow;
    private int inappSoundRow;
    private int inappVibrateRow;
    private int inchatSoundRow;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private int notificationsForegroundConnectionRow;
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
    private boolean reseting;
    private int rowCount;

    public static class NotificationException {
        public long did;
        public boolean hasCustom;
        public int muteUntil;
        public int notify;
    }

    public NotificationsSettingsActivity(Bundle arg) {
        super(arg);
        this.reseting = false;
        this.exceptionUsers = null;
        this.exceptionChats = null;
        this.exceptionChannels = null;
        this.rowCount = 0;
    }

    public NotificationsSettingsActivity() {
        this.reseting = false;
        this.exceptionUsers = null;
        this.exceptionChats = null;
        this.exceptionChannels = null;
        this.rowCount = 0;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        MessagesController.getInstance(this.currentAccount).loadSignUpNotificationsSettings();
        loadExceptions();
        if (UserConfig.getActivatedAccountsCount() > 1) {
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.accountsSectionRow = i;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.accountsAllRow = i2;
            this.rowCount = i3 + 1;
            this.accountsInfoRow = i3;
        } else {
            this.accountsSectionRow = -1;
            this.accountsAllRow = -1;
            this.accountsInfoRow = -1;
        }
        int i4 = this.rowCount;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.notificationsSectionRow = i4;
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.privateRow = i5;
        int i7 = i6 + 1;
        this.rowCount = i7;
        this.groupRow = i6;
        int i8 = i7 + 1;
        this.rowCount = i8;
        this.channelsRow = i7;
        this.rowCount = i8 + 1;
        this.notificationsSection2Row = i8;
        if (MessagesController.getInstance(this.currentAccount).callsEnabled) {
            int i9 = this.rowCount;
            int i10 = i9 + 1;
            this.rowCount = i10;
            this.callsSectionRow = i9;
            int i11 = i10 + 1;
            this.rowCount = i11;
            this.callsVibrateRow = i10;
            int i12 = i11 + 1;
            this.rowCount = i12;
            this.callsRingtoneRow = i11;
            this.rowCount = i12 + 1;
            this.eventsSection2Row = i12;
        } else {
            this.callsSectionRow = -1;
            this.callsVibrateRow = -1;
            this.callsRingtoneRow = -1;
            this.eventsSection2Row = -1;
        }
        int i13 = this.rowCount;
        int i14 = i13 + 1;
        this.rowCount = i14;
        this.badgeNumberSection = i13;
        int i15 = i14 + 1;
        this.rowCount = i15;
        this.badgeNumberShowRow = i14;
        int i16 = i15 + 1;
        this.rowCount = i16;
        this.badgeNumberMutedRow = i15;
        int i17 = i16 + 1;
        this.rowCount = i17;
        this.badgeNumberMessagesRow = i16;
        int i18 = i17 + 1;
        this.rowCount = i18;
        this.badgeNumberSection2Row = i17;
        int i19 = i18 + 1;
        this.rowCount = i19;
        this.inappSectionRow = i18;
        int i20 = i19 + 1;
        this.rowCount = i20;
        this.inappSoundRow = i19;
        int i21 = i20 + 1;
        this.rowCount = i21;
        this.inappVibrateRow = i20;
        int i22 = i21 + 1;
        this.rowCount = i22;
        this.inappPreviewRow = i21;
        int i23 = i22 + 1;
        this.rowCount = i23;
        this.inchatSoundRow = i22;
        int i24 = Build.VERSION.SDK_INT;
        if (i24 >= 21) {
            this.rowCount = i23 + 1;
            this.inappPriorityRow = i23;
        } else {
            this.inappPriorityRow = -1;
        }
        int i25 = this.rowCount;
        int i26 = i25 + 1;
        this.rowCount = i26;
        this.callsSection2Row = i25;
        int i27 = i26 + 1;
        this.rowCount = i27;
        this.eventsSectionRow = i26;
        int i28 = i27 + 1;
        this.rowCount = i28;
        this.contactJoinedRow = i27;
        int i29 = i28 + 1;
        this.rowCount = i29;
        this.pinnedMessageRow = i28;
        int i30 = i29 + 1;
        this.rowCount = i30;
        this.otherSection2Row = i29;
        int i31 = i30 + 1;
        this.rowCount = i31;
        this.otherSectionRow = i30;
        int i32 = i31 + 1;
        this.rowCount = i32;
        this.notificationsServiceRow = i31;
        int i33 = i32 + 1;
        this.rowCount = i33;
        this.notificationsServiceConnectionRow = i32;
        if (i24 >= 23) {
            this.rowCount = i33 + 1;
            this.notificationsForegroundConnectionRow = i33;
        } else {
            this.notificationsForegroundConnectionRow = -1;
        }
        this.androidAutoAlertRow = -1;
        int i34 = this.rowCount;
        int i35 = i34 + 1;
        this.rowCount = i35;
        this.repeatRow = i34;
        int i36 = i35 + 1;
        this.rowCount = i36;
        this.resetSection2Row = i35;
        int i37 = i36 + 1;
        this.rowCount = i37;
        this.resetSectionRow = i36;
        int i38 = i37 + 1;
        this.rowCount = i38;
        this.resetNotificationsRow = i37;
        this.rowCount = i38 + 1;
        this.resetNotificationsSectionRow = i38;
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.notificationsSettingsUpdated);
        return super.onFragmentCreate();
    }

    private void loadExceptions() {
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$O_whSoFP23B2hV9h5e4W7G6-HxY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadExceptions$1$NotificationsSettingsActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0121, code lost:
    
        if (r4.deleted != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x014c, code lost:
    
        if (r4.deleted != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x014e, code lost:
    
        r7 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x027e A[LOOP:3: B:114:0x027c->B:115:0x027e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0225  */
    /* renamed from: lambda$loadExceptions$1, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadExceptions$1$NotificationsSettingsActivity() {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.NotificationsSettingsActivity.lambda$loadExceptions$1$NotificationsSettingsActivity():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadExceptions$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadExceptions$0$NotificationsSettingsActivity(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.notificationsSettingsUpdated);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("NotificationsAndSounds", R.string.NotificationsAndSounds));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.NotificationsSettingsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    NotificationsSettingsActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false) { // from class: ir.eitaa.ui.NotificationsSettingsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$F1KI6dNA_R63lpS69b_iLZgT94k
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$8$NotificationsSettingsActivity(context, view, i, f, f2);
            }
        });
        if (getArguments() != null && getArguments().getBoolean("fromForegroundNotification")) {
            this.listView.scrollToPosition(this.notificationsServiceRow);
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$NotificationsSettingsActivity(final Context context, View view, final int i, float f, float f2) {
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
                showExceptionsAlert(i);
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
                builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$Xvwj1iWE6_-NtDA8Djvkou6zp2E
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        this.f$0.lambda$createView$4$NotificationsSettingsActivity(dialogInterface, i4);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                }
            } else if (i == this.inappSoundRow) {
                SharedPreferences notificationsSettings2 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit = notificationsSettings2.edit();
                z = notificationsSettings2.getBoolean("EnableInAppSounds", true);
                editorEdit.putBoolean("EnableInAppSounds", !z);
                editorEdit.commit();
            } else if (i == this.inappVibrateRow) {
                SharedPreferences notificationsSettings3 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit2 = notificationsSettings3.edit();
                z = notificationsSettings3.getBoolean("EnableInAppVibrate", true);
                editorEdit2.putBoolean("EnableInAppVibrate", !z);
                editorEdit2.commit();
            } else if (i == this.inappPreviewRow) {
                SharedPreferences notificationsSettings4 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit3 = notificationsSettings4.edit();
                z = notificationsSettings4.getBoolean("EnableInAppPreview", true);
                editorEdit3.putBoolean("EnableInAppPreview", !z);
                editorEdit3.commit();
            } else if (i == this.inchatSoundRow) {
                SharedPreferences notificationsSettings5 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit4 = notificationsSettings5.edit();
                z = notificationsSettings5.getBoolean("EnableInChatSound", true);
                editorEdit4.putBoolean("EnableInChatSound", !z);
                editorEdit4.commit();
                getNotificationsController().setInChatSoundEnabled(!z);
            } else if (i == this.inappPriorityRow) {
                SharedPreferences notificationsSettings6 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit5 = notificationsSettings6.edit();
                z = notificationsSettings6.getBoolean("EnableInAppPriority", false);
                editorEdit5.putBoolean("EnableInAppPriority", !z);
                editorEdit5.commit();
            } else if (i == this.contactJoinedRow) {
                SharedPreferences notificationsSettings7 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit6 = notificationsSettings7.edit();
                z = notificationsSettings7.getBoolean("EnableContactJoined", true);
                MessagesController.getInstance(this.currentAccount).enableJoined = !z;
                editorEdit6.putBoolean("EnableContactJoined", !z);
                editorEdit6.commit();
            } else if (i == this.pinnedMessageRow) {
                SharedPreferences notificationsSettings8 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit7 = notificationsSettings8.edit();
                z = notificationsSettings8.getBoolean("PinnedMessages", true);
                editorEdit7.putBoolean("PinnedMessages", !z);
                editorEdit7.commit();
            } else if (i == this.androidAutoAlertRow) {
                SharedPreferences notificationsSettings9 = MessagesController.getNotificationsSettings(this.currentAccount);
                SharedPreferences.Editor editorEdit8 = notificationsSettings9.edit();
                z = notificationsSettings9.getBoolean("EnableAutoNotifications", false);
                editorEdit8.putBoolean("EnableAutoNotifications", !z);
                editorEdit8.commit();
            } else if (i == this.badgeNumberShowRow) {
                SharedPreferences.Editor editorEdit9 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                z = getNotificationsController().showBadgeNumber;
                getNotificationsController().showBadgeNumber = !z;
                editorEdit9.putBoolean("badgeNumber", getNotificationsController().showBadgeNumber);
                editorEdit9.commit();
                getNotificationsController().updateBadge();
            } else if (i == this.badgeNumberMutedRow) {
                SharedPreferences.Editor editorEdit10 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                z = getNotificationsController().showBadgeMuted;
                getNotificationsController().showBadgeMuted = !z;
                editorEdit10.putBoolean("badgeNumberMuted", getNotificationsController().showBadgeMuted);
                editorEdit10.commit();
                getNotificationsController().updateBadge();
                getMessagesStorage().updateMutedDialogsFiltersCounters();
            } else if (i == this.badgeNumberMessagesRow) {
                SharedPreferences.Editor editorEdit11 = MessagesController.getNotificationsSettings(this.currentAccount).edit();
                z = getNotificationsController().showBadgeMessages;
                getNotificationsController().showBadgeMessages = !z;
                editorEdit11.putBoolean("badgeNumberMessages", getNotificationsController().showBadgeMessages);
                editorEdit11.commit();
                getNotificationsController().updateBadge();
            } else if (i == this.notificationsServiceConnectionRow) {
                SharedPreferences notificationsSettings10 = MessagesController.getNotificationsSettings(this.currentAccount);
                z = notificationsSettings10.getBoolean("pushConnection", getMessagesController().backgroundConnection);
                SharedPreferences.Editor editorEdit12 = notificationsSettings10.edit();
                editorEdit12.putBoolean("pushConnection", !z);
                editorEdit12.commit();
                if ((!z) != 0 && Build.VERSION.SDK_INT >= 23) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(getParentActivity());
                    builder2.setMessage(LocaleController.getString("IgnoreBatteryOptimizationDetail", R.string.IgnoreBatteryOptimizationDetail));
                    builder2.setTitle(LocaleController.getString("IgnoreBatteryOptimization", R.string.IgnoreBatteryOptimization));
                    builder2.setPositiveButton(LocaleController.getString("Settings", R.string.Settings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$b_RuBr_ydRp_BUVcB-_xZtqCaiA
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            context.startActivity(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"));
                        }
                    });
                    builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                    showDialog(builder2.create());
                }
            } else if (i == this.notificationsForegroundConnectionRow) {
                SharedPreferences globalNotificationsSettings = MessagesController.getGlobalNotificationsSettings();
                z = globalNotificationsSettings.getBoolean("foregroundConnection", false);
                SharedPreferences.Editor editorEdit13 = globalNotificationsSettings.edit();
                editorEdit13.putBoolean("foregroundConnection", !z);
                editorEdit13.commit();
                MessagesController.getInstance(this.currentAccount).foregroundConnection = !z;
                if ((!z) != 0) {
                    MessagesController.getNotificationsSettings(this.currentAccount).edit().putBoolean("pushConnection", true).commit();
                    this.adapter.notifyItemChanged(this.notificationsServiceConnectionRow);
                }
            } else if (i == this.accountsAllRow) {
                SharedPreferences globalNotificationsSettings2 = MessagesController.getGlobalNotificationsSettings();
                boolean z2 = globalNotificationsSettings2.getBoolean("AllAccounts", true);
                SharedPreferences.Editor editorEdit14 = globalNotificationsSettings2.edit();
                editorEdit14.putBoolean("AllAccounts", !z2);
                editorEdit14.commit();
                SharedConfig.showNotificationsForAllAccounts = !z2;
                for (int i4 = 0; i4 < 3; i4++) {
                    if (SharedConfig.showNotificationsForAllAccounts) {
                        NotificationsController.getInstance(i4).showNotifications();
                    } else if (i4 == this.currentAccount) {
                        NotificationsController.getInstance(i4).showNotifications();
                    } else {
                        NotificationsController.getInstance(i4).hideNotifications();
                    }
                }
                z = z2;
            } else if (i == this.notificationsServiceRow) {
                SharedPreferences notificationsSettings11 = MessagesController.getNotificationsSettings(this.currentAccount);
                z = notificationsSettings11.getBoolean("pushService", getMessagesController().keepAliveService);
                SharedPreferences.Editor editorEdit15 = notificationsSettings11.edit();
                editorEdit15.putBoolean("pushService", !z);
                editorEdit15.commit();
                ApplicationLoader.startPushService();
            } else if (i == this.callsVibrateRow) {
                if (getParentActivity() == null) {
                    return;
                } else {
                    showDialog(AlertsCreator.createVibrationSelectDialog(getParentActivity(), 0L, i == this.callsVibrateRow ? "vibrate_calls" : null, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$EEXNDo8XCdxPBV_aPIOhSIqMPzc
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$createView$6$NotificationsSettingsActivity(i);
                        }
                    }));
                }
            } else if (i == this.repeatRow) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(getParentActivity());
                builder3.setTitle(LocaleController.getString("RepeatNotifications", R.string.RepeatNotifications));
                builder3.setItems(new CharSequence[]{LocaleController.getString("RepeatDisabled", R.string.RepeatDisabled), LocaleController.formatPluralString("Minutes", 5), LocaleController.formatPluralString("Minutes", 10), LocaleController.formatPluralString("Minutes", 30), LocaleController.formatPluralString("Hours", 1), LocaleController.formatPluralString("Hours", 2), LocaleController.formatPluralString("Hours", 4)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$PUgq6H464pJIg2rwK4qx2JsCnWA
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i5) {
                        this.f$0.lambda$createView$7$NotificationsSettingsActivity(i, dialogInterface, i5);
                    }
                });
                builder3.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                showDialog(builder3.create());
            }
        }
        if (view instanceof TextCheckCell) {
            ((TextCheckCell) view).setChecked(!z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$NotificationsSettingsActivity(DialogInterface dialogInterface, int i) {
        if (this.reseting) {
            return;
        }
        this.reseting = true;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_resetNotifySettings
            public static int constructor = -612493497;

            @Override // ir.eitaa.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
            }

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$JxP0gvpfK9z1woIMXZ4aAA3yh6s
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$3$NotificationsSettingsActivity(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$NotificationsSettingsActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$etJLZum0BB08ZTUV9AK49dhnwOA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$2$NotificationsSettingsActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$NotificationsSettingsActivity() {
        getMessagesController().enableJoined = true;
        this.reseting = false;
        SharedPreferences.Editor editorEdit = MessagesController.getNotificationsSettings(this.currentAccount).edit();
        editorEdit.clear();
        editorEdit.commit();
        this.exceptionChats.clear();
        this.exceptionUsers.clear();
        this.adapter.notifyDataSetChanged();
        if (getParentActivity() != null) {
            Toast.makeText(getParentActivity(), LocaleController.getString("ResetNotificationsText", R.string.ResetNotificationsText), 0).show();
        }
        getMessagesStorage().updateMutedDialogsFiltersCounters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$NotificationsSettingsActivity(int i) {
        this.adapter.notifyItemChanged(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$NotificationsSettingsActivity(int i, DialogInterface dialogInterface, int i2) {
        MessagesController.getNotificationsSettings(this.currentAccount).edit().putInt("repeat_messages", i2 != 1 ? i2 == 2 ? 10 : i2 == 3 ? 30 : i2 == 4 ? 60 : i2 == 5 ? R.styleable.AppCompatTheme_windowNoTitle : i2 == 6 ? 240 : 0 : 5).commit();
        this.adapter.notifyItemChanged(i);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
        Ringtone ringtone;
        if (resultCode == -1) {
            Uri uri = (Uri) data.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
            String title = null;
            if (uri != null && (ringtone = RingtoneManager.getRingtone(getParentActivity(), uri)) != null) {
                if (requestCode == this.callsRingtoneRow) {
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
            if (requestCode == this.callsRingtoneRow) {
                if (title != null && uri != null) {
                    editorEdit.putString("CallsRingtone", title);
                    editorEdit.putString("CallsRingtonePath", uri.toString());
                } else {
                    editorEdit.putString("CallsRingtone", "NoSound");
                    editorEdit.putString("CallsRingtonePath", "NoSound");
                }
            }
            editorEdit.commit();
            this.adapter.notifyItemChanged(requestCode);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a A[PHI: r7
      0x001a: PHI (r7v3 java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException>) = 
      (r7v1 java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException>)
      (r7v1 java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException>)
      (r7v2 java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException>)
      (r7v2 java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException>)
      (r7v8 java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException>)
      (r7v8 java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException>)
     binds: [B:18:0x0037, B:20:0x003d, B:13:0x0022, B:15:0x0028, B:5:0x0007, B:7:0x000d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showExceptionsAlert(int r7) {
        /*
            r6 = this;
            int r0 = r6.privateRow
            r1 = 0
            if (r7 != r0) goto L1c
            java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException> r7 = r6.exceptionUsers
            if (r7 == 0) goto L1a
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L1a
            int r0 = r7.size()
            java.lang.String r2 = "ChatsException"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.formatPluralString(r2, r0)
            goto L49
        L1a:
            r0 = r1
            goto L49
        L1c:
            int r0 = r6.groupRow
            if (r7 != r0) goto L35
            java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException> r7 = r6.exceptionChats
            if (r7 == 0) goto L1a
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L1a
            int r0 = r7.size()
            java.lang.String r2 = "Groups"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.formatPluralString(r2, r0)
            goto L49
        L35:
            java.util.ArrayList<ir.eitaa.ui.NotificationsSettingsActivity$NotificationException> r7 = r6.exceptionChannels
            if (r7 == 0) goto L1a
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L1a
            int r0 = r7.size()
            java.lang.String r2 = "Channels"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.formatPluralString(r2, r0)
        L49:
            if (r0 != 0) goto L4c
            return
        L4c:
            ir.eitaa.ui.ActionBar.AlertDialog$Builder r2 = new ir.eitaa.ui.ActionBar.AlertDialog$Builder
            android.app.Activity r3 = r6.getParentActivity()
            r2.<init>(r3)
            int r3 = r7.size()
            r4 = 0
            r5 = 1
            if (r3 != r5) goto L72
            r3 = 2131692809(0x7f0f0d09, float:1.9014729E38)
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r4] = r0
            java.lang.String r0 = "NotificationsExceptionsSingleAlert"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.formatString(r0, r3, r5)
            android.text.SpannableStringBuilder r0 = ir.eitaa.messenger.AndroidUtilities.replaceTags(r0)
            r2.setMessage(r0)
            goto L86
        L72:
            r3 = 2131692808(0x7f0f0d08, float:1.9014727E38)
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r4] = r0
            java.lang.String r0 = "NotificationsExceptionsAlert"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.formatString(r0, r3, r5)
            android.text.SpannableStringBuilder r0 = ir.eitaa.messenger.AndroidUtilities.replaceTags(r0)
            r2.setMessage(r0)
        L86:
            r0 = 2131692807(0x7f0f0d07, float:1.9014725E38)
            java.lang.String r3 = "NotificationsExceptions"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r3, r0)
            r2.setTitle(r0)
            r0 = 2131694802(0x7f0f14d2, float:1.901877E38)
            java.lang.String r3 = "ViewExceptions"
            java.lang.String r0 = ir.eitaa.messenger.LocaleController.getString(r3, r0)
            ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$UjC2QC7q75zIttiUCIb7tohxTSY r3 = new ir.eitaa.ui.-$$Lambda$NotificationsSettingsActivity$UjC2QC7q75zIttiUCIb7tohxTSY
            r3.<init>()
            r2.setNeutralButton(r0, r3)
            r7 = 2131692856(0x7f0f0d38, float:1.9014824E38)
            java.lang.String r0 = "OK"
            java.lang.String r7 = ir.eitaa.messenger.LocaleController.getString(r0, r7)
            r2.setNegativeButton(r7, r1)
            ir.eitaa.ui.ActionBar.AlertDialog r7 = r2.create()
            r6.showDialog(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.NotificationsSettingsActivity.showExceptionsAlert(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showExceptionsAlert$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showExceptionsAlert$9$NotificationsSettingsActivity(ArrayList arrayList, DialogInterface dialogInterface, int i) {
        presentFragment(new NotificationsCustomSettingsActivity(-1, arrayList));
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.notificationsSettingsUpdated) {
            this.adapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return (adapterPosition == NotificationsSettingsActivity.this.notificationsSectionRow || adapterPosition == NotificationsSettingsActivity.this.notificationsSection2Row || adapterPosition == NotificationsSettingsActivity.this.inappSectionRow || adapterPosition == NotificationsSettingsActivity.this.eventsSectionRow || adapterPosition == NotificationsSettingsActivity.this.otherSectionRow || adapterPosition == NotificationsSettingsActivity.this.resetSectionRow || adapterPosition == NotificationsSettingsActivity.this.eventsSection2Row || adapterPosition == NotificationsSettingsActivity.this.badgeNumberSection || adapterPosition == NotificationsSettingsActivity.this.otherSection2Row || adapterPosition == NotificationsSettingsActivity.this.resetSection2Row || adapterPosition == NotificationsSettingsActivity.this.callsSection2Row || adapterPosition == NotificationsSettingsActivity.this.callsSectionRow || adapterPosition == NotificationsSettingsActivity.this.badgeNumberSection2Row || adapterPosition == NotificationsSettingsActivity.this.accountsSectionRow || adapterPosition == NotificationsSettingsActivity.this.accountsInfoRow || adapterPosition == NotificationsSettingsActivity.this.resetNotificationsSectionRow) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return NotificationsSettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View headerCell;
            View shadowSectionCell;
            if (viewType == 0) {
                headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 1) {
                headerCell = new TextCheckCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 2) {
                headerCell = new TextDetailSettingsCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 3) {
                headerCell = new NotificationsCheckCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                if (viewType == 4) {
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                } else if (viewType == 5) {
                    headerCell = new TextSettingsCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                } else {
                    shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                    shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                }
                return new RecyclerListView.Holder(shadowSectionCell);
            }
            shadowSectionCell = headerCell;
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String string;
            ArrayList arrayList;
            int i;
            String pluralString;
            switch (holder.getItemViewType()) {
                case 0:
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (position != NotificationsSettingsActivity.this.notificationsSectionRow) {
                        if (position != NotificationsSettingsActivity.this.inappSectionRow) {
                            if (position != NotificationsSettingsActivity.this.eventsSectionRow) {
                                if (position != NotificationsSettingsActivity.this.otherSectionRow) {
                                    if (position != NotificationsSettingsActivity.this.resetSectionRow) {
                                        if (position != NotificationsSettingsActivity.this.callsSectionRow) {
                                            if (position != NotificationsSettingsActivity.this.badgeNumberSection) {
                                                if (position == NotificationsSettingsActivity.this.accountsSectionRow) {
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
                    TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) NotificationsSettingsActivity.this).currentAccount);
                    if (position != NotificationsSettingsActivity.this.inappSoundRow) {
                        if (position != NotificationsSettingsActivity.this.inappVibrateRow) {
                            if (position != NotificationsSettingsActivity.this.inappPreviewRow) {
                                if (position != NotificationsSettingsActivity.this.inappPriorityRow) {
                                    if (position != NotificationsSettingsActivity.this.contactJoinedRow) {
                                        if (position != NotificationsSettingsActivity.this.pinnedMessageRow) {
                                            if (position != NotificationsSettingsActivity.this.androidAutoAlertRow) {
                                                if (position != NotificationsSettingsActivity.this.notificationsServiceRow) {
                                                    if (position != NotificationsSettingsActivity.this.notificationsServiceConnectionRow) {
                                                        if (position != NotificationsSettingsActivity.this.notificationsForegroundConnectionRow) {
                                                            if (position == NotificationsSettingsActivity.this.badgeNumberShowRow) {
                                                                textCheckCell.setTextAndCheck(LocaleController.getString("BadgeNumberShow", R.string.BadgeNumberShow), NotificationsSettingsActivity.this.getNotificationsController().showBadgeNumber, true);
                                                                break;
                                                            } else if (position == NotificationsSettingsActivity.this.badgeNumberMutedRow) {
                                                                textCheckCell.setTextAndCheck(LocaleController.getString("BadgeNumberMutedChats", R.string.BadgeNumberMutedChats), NotificationsSettingsActivity.this.getNotificationsController().showBadgeMuted, true);
                                                                break;
                                                            } else if (position == NotificationsSettingsActivity.this.badgeNumberMessagesRow) {
                                                                textCheckCell.setTextAndCheck(LocaleController.getString("BadgeNumberUnread", R.string.BadgeNumberUnread), NotificationsSettingsActivity.this.getNotificationsController().showBadgeMessages, false);
                                                                break;
                                                            } else if (position != NotificationsSettingsActivity.this.inchatSoundRow) {
                                                                if (position != NotificationsSettingsActivity.this.callsVibrateRow) {
                                                                    if (position == NotificationsSettingsActivity.this.accountsAllRow) {
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
                                                            textCheckCell.setTextAndValueAndCheck(LocaleController.getString("NotificationsForegroundConnection", R.string.NotificationsForegroundConnection), LocaleController.getString("NotificationsForegroundConnectionInfo", R.string.NotificationsForegroundConnectionInfo), MessagesController.getGlobalNotificationsSettings().getBoolean("foregroundConnection", false), true, true);
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
                    TextDetailSettingsCell textDetailSettingsCell = (TextDetailSettingsCell) holder.itemView;
                    textDetailSettingsCell.setMultilineDetail(true);
                    if (position == NotificationsSettingsActivity.this.resetNotificationsRow) {
                        textDetailSettingsCell.setTextAndValue(LocaleController.getString("ResetAllNotifications", R.string.ResetAllNotifications), LocaleController.getString("UndoAllCustom", R.string.UndoAllCustom), false);
                        break;
                    }
                    break;
                case 3:
                    NotificationsCheckCell notificationsCheckCell = (NotificationsCheckCell) holder.itemView;
                    SharedPreferences notificationsSettings2 = MessagesController.getNotificationsSettings(((BaseFragment) NotificationsSettingsActivity.this).currentAccount);
                    int currentTime = ConnectionsManager.getInstance(((BaseFragment) NotificationsSettingsActivity.this).currentAccount).getCurrentTime();
                    if (position != NotificationsSettingsActivity.this.privateRow) {
                        if (position == NotificationsSettingsActivity.this.groupRow) {
                            string = LocaleController.getString("NotificationsGroups", R.string.NotificationsGroups);
                            arrayList = NotificationsSettingsActivity.this.exceptionChats;
                            i = notificationsSettings2.getInt("EnableGroup2", 0);
                        } else {
                            string = LocaleController.getString("NotificationsChannels", R.string.NotificationsChannels);
                            arrayList = NotificationsSettingsActivity.this.exceptionChannels;
                            i = notificationsSettings2.getInt("EnableChannel2", 0);
                        }
                    } else {
                        string = LocaleController.getString("NotificationsPrivateChats", R.string.NotificationsPrivateChats);
                        arrayList = NotificationsSettingsActivity.this.exceptionUsers;
                        i = notificationsSettings2.getInt("EnableAll2", 0);
                    }
                    String str = string;
                    boolean z = i < currentTime;
                    int i2 = (!z && i - 31536000 < currentTime) ? 2 : 0;
                    StringBuilder sb = new StringBuilder();
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z = i < currentTime;
                        if (z) {
                            sb.append(LocaleController.getString("NotificationsOn", R.string.NotificationsOn));
                        } else if (i - 31536000 >= currentTime) {
                            sb.append(LocaleController.getString("NotificationsOff", R.string.NotificationsOff));
                        } else {
                            sb.append(LocaleController.formatString("NotificationsOffUntil", R.string.NotificationsOffUntil, LocaleController.stringForMessageListDate(i)));
                        }
                        if (sb.length() != 0) {
                            sb.append(", ");
                        }
                        sb.append(LocaleController.formatPluralString("Exception", arrayList.size()));
                    } else {
                        sb.append(LocaleController.getString("TapToChange", R.string.TapToChange));
                    }
                    notificationsCheckCell.setTextAndValueAndCheck(str, sb, z, i2, position != NotificationsSettingsActivity.this.channelsRow);
                    break;
                case 4:
                    if (position == NotificationsSettingsActivity.this.resetNotificationsSectionRow) {
                        holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                        break;
                    } else {
                        holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                        break;
                    }
                case 5:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                    SharedPreferences notificationsSettings3 = MessagesController.getNotificationsSettings(((BaseFragment) NotificationsSettingsActivity.this).currentAccount);
                    if (position != NotificationsSettingsActivity.this.callsRingtoneRow) {
                        if (position != NotificationsSettingsActivity.this.callsVibrateRow) {
                            if (position == NotificationsSettingsActivity.this.repeatRow) {
                                int i3 = notificationsSettings3.getInt("repeat_messages", 60);
                                if (i3 == 0) {
                                    pluralString = LocaleController.getString("RepeatNotificationsNever", R.string.RepeatNotificationsNever);
                                } else if (i3 < 60) {
                                    pluralString = LocaleController.formatPluralString("Minutes", i3);
                                } else {
                                    pluralString = LocaleController.formatPluralString("Hours", i3 / 60);
                                }
                                textSettingsCell.setTextAndValue(LocaleController.getString("RepeatNotifications", R.string.RepeatNotifications), pluralString, false);
                                break;
                            }
                        } else {
                            int i4 = notificationsSettings3.getInt("vibrate_calls", 0);
                            if (i4 != 0) {
                                if (i4 != 1) {
                                    if (i4 != 2) {
                                        if (i4 != 3) {
                                            if (i4 == 4) {
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
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    if (position == NotificationsSettingsActivity.this.accountsInfoRow) {
                        textInfoPrivacyCell.setText(LocaleController.getString("ShowNotificationsForInfo", R.string.ShowNotificationsForInfo));
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == NotificationsSettingsActivity.this.eventsSectionRow || position == NotificationsSettingsActivity.this.otherSectionRow || position == NotificationsSettingsActivity.this.resetSectionRow || position == NotificationsSettingsActivity.this.callsSectionRow || position == NotificationsSettingsActivity.this.badgeNumberSection || position == NotificationsSettingsActivity.this.inappSectionRow || position == NotificationsSettingsActivity.this.notificationsSectionRow || position == NotificationsSettingsActivity.this.accountsSectionRow) {
                return 0;
            }
            if (position == NotificationsSettingsActivity.this.inappSoundRow || position == NotificationsSettingsActivity.this.inappVibrateRow || position == NotificationsSettingsActivity.this.notificationsServiceConnectionRow || position == NotificationsSettingsActivity.this.notificationsForegroundConnectionRow || position == NotificationsSettingsActivity.this.inappPreviewRow || position == NotificationsSettingsActivity.this.contactJoinedRow || position == NotificationsSettingsActivity.this.pinnedMessageRow || position == NotificationsSettingsActivity.this.notificationsServiceRow || position == NotificationsSettingsActivity.this.badgeNumberMutedRow || position == NotificationsSettingsActivity.this.badgeNumberMessagesRow || position == NotificationsSettingsActivity.this.badgeNumberShowRow || position == NotificationsSettingsActivity.this.inappPriorityRow || position == NotificationsSettingsActivity.this.inchatSoundRow || position == NotificationsSettingsActivity.this.androidAutoAlertRow || position == NotificationsSettingsActivity.this.accountsAllRow) {
                return 1;
            }
            if (position == NotificationsSettingsActivity.this.resetNotificationsRow) {
                return 2;
            }
            if (position == NotificationsSettingsActivity.this.privateRow || position == NotificationsSettingsActivity.this.groupRow || position == NotificationsSettingsActivity.this.channelsRow) {
                return 3;
            }
            if (position == NotificationsSettingsActivity.this.eventsSection2Row || position == NotificationsSettingsActivity.this.notificationsSection2Row || position == NotificationsSettingsActivity.this.otherSection2Row || position == NotificationsSettingsActivity.this.resetSection2Row || position == NotificationsSettingsActivity.this.callsSection2Row || position == NotificationsSettingsActivity.this.badgeNumberSection2Row || position == NotificationsSettingsActivity.this.resetNotificationsSectionRow) {
                return 4;
            }
            return position == NotificationsSettingsActivity.this.accountsInfoRow ? 6 : 5;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCheckCell.class, TextDetailSettingsCell.class, TextSettingsCell.class, NotificationsCheckCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteLinkText"));
        return arrayList;
    }
}
