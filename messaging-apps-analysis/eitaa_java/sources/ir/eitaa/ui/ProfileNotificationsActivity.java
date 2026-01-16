package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.NotificationsController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$TL_peerNotifySettings;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.RadioCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckBoxCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextColorCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Cells.UserCell2;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.NotificationsSettingsActivity;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ProfileNotificationsActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ListAdapter adapter;
    private boolean addingException;
    private AnimatorSet animatorSet;
    private int avatarRow;
    private int avatarSectionRow;
    private int callsRow;
    private int callsVibrateRow;
    private int colorRow;
    private boolean customEnabled;
    private int customInfoRow;
    private int customRow;
    private ProfileNotificationsActivityDelegate delegate;
    private long dialogId;
    private int enableRow;
    private int generalRow;
    private int ledInfoRow;
    private int ledRow;
    private RecyclerListView listView;
    private boolean notificationsEnabled;
    private int popupDisabledRow;
    private int popupEnabledRow;
    private int popupInfoRow;
    private int popupRow;
    private int previewRow;
    private int priorityInfoRow;
    private int priorityRow;
    private int ringtoneInfoRow;
    private int ringtoneRow;
    private int rowCount;
    private int smartRow;
    private int soundRow;
    private int vibrateRow;

    public interface ProfileNotificationsActivityDelegate {
        void didCreateNewException(NotificationsSettingsActivity.NotificationException exception);
    }

    public ProfileNotificationsActivity(Bundle args) {
        super(args);
        this.dialogId = args.getLong("dialog_id");
        this.addingException = args.getBoolean("exception", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFragmentCreate() {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProfileNotificationsActivity.onFragmentCreate():boolean");
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
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ProfileNotificationsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    if (!ProfileNotificationsActivity.this.addingException && ProfileNotificationsActivity.this.notificationsEnabled && ProfileNotificationsActivity.this.customEnabled) {
                        MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt("notify2_" + ProfileNotificationsActivity.this.dialogId, 0).commit();
                    }
                } else if (id == 1) {
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    SharedPreferences.Editor editorEdit = notificationsSettings.edit();
                    editorEdit.putBoolean("custom_" + ProfileNotificationsActivity.this.dialogId, true);
                    TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).dialogs_dict.get(ProfileNotificationsActivity.this.dialogId);
                    if (ProfileNotificationsActivity.this.notificationsEnabled) {
                        editorEdit.putInt("notify2_" + ProfileNotificationsActivity.this.dialogId, 0);
                        MessagesStorage.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).setDialogNotificationFlags(ProfileNotificationsActivity.this.dialogId, 0L);
                        if (tLRPC$Dialog != null) {
                            tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
                        }
                    } else {
                        editorEdit.putInt("notify2_" + ProfileNotificationsActivity.this.dialogId, 2);
                        NotificationsController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).removeNotificationsForDialog(ProfileNotificationsActivity.this.dialogId);
                        MessagesStorage.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).setDialogNotificationFlags(ProfileNotificationsActivity.this.dialogId, 1L);
                        if (tLRPC$Dialog != null) {
                            TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                            tLRPC$Dialog.notify_settings = tLRPC$TL_peerNotifySettings;
                            tLRPC$TL_peerNotifySettings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                        }
                    }
                    editorEdit.commit();
                    NotificationsController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).updateServerNotificationsSettings(ProfileNotificationsActivity.this.dialogId);
                    if (ProfileNotificationsActivity.this.delegate != null) {
                        NotificationsSettingsActivity.NotificationException notificationException = new NotificationsSettingsActivity.NotificationException();
                        notificationException.did = ProfileNotificationsActivity.this.dialogId;
                        notificationException.hasCustom = true;
                        int i = notificationsSettings.getInt("notify2_" + ProfileNotificationsActivity.this.dialogId, 0);
                        notificationException.notify = i;
                        if (i != 0) {
                            notificationException.muteUntil = notificationsSettings.getInt("notifyuntil_" + ProfileNotificationsActivity.this.dialogId, 0);
                        }
                        ProfileNotificationsActivity.this.delegate.didCreateNewException(notificationException);
                    }
                }
                ProfileNotificationsActivity.this.finishFragment();
            }
        });
        if (this.addingException) {
            this.actionBar.setTitle(LocaleController.getString("NotificationsNewException", R.string.NotificationsNewException));
            this.actionBar.createMenu().addItem(1, LocaleController.getString("Done", R.string.Done).toUpperCase());
        } else {
            this.actionBar.setTitle(LocaleController.getString("CustomNotifications", R.string.CustomNotifications));
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        frameLayout2.addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setLayoutManager(new LinearLayoutManager(context) { // from class: ir.eitaa.ui.ProfileNotificationsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setOnItemClickListener(new AnonymousClass3(context));
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.ProfileNotificationsActivity$3, reason: invalid class name */
    class AnonymousClass3 implements RecyclerListView.OnItemClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass3(final Context val$context) {
            this.val$context = val$context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
        public void onItemClick(View view, int position) {
            if (position != ProfileNotificationsActivity.this.customRow || !(view instanceof TextCheckBoxCell)) {
                if (ProfileNotificationsActivity.this.customEnabled && view.isEnabled()) {
                    Uri uri = null;
                    if (position != ProfileNotificationsActivity.this.soundRow) {
                        if (position != ProfileNotificationsActivity.this.ringtoneRow) {
                            if (position != ProfileNotificationsActivity.this.vibrateRow) {
                                if (position != ProfileNotificationsActivity.this.enableRow) {
                                    if (position != ProfileNotificationsActivity.this.previewRow) {
                                        if (position != ProfileNotificationsActivity.this.callsVibrateRow) {
                                            if (position != ProfileNotificationsActivity.this.priorityRow) {
                                                if (position != ProfileNotificationsActivity.this.smartRow) {
                                                    if (position != ProfileNotificationsActivity.this.colorRow) {
                                                        if (position != ProfileNotificationsActivity.this.popupEnabledRow) {
                                                            if (position == ProfileNotificationsActivity.this.popupDisabledRow) {
                                                                MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt("popup_" + ProfileNotificationsActivity.this.dialogId, 2).commit();
                                                                ((RadioCell) view).setChecked(true, true);
                                                                View viewFindViewWithTag = ProfileNotificationsActivity.this.listView.findViewWithTag(1);
                                                                if (viewFindViewWithTag != null) {
                                                                    ((RadioCell) viewFindViewWithTag).setChecked(false, true);
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt("popup_" + ProfileNotificationsActivity.this.dialogId, 1).commit();
                                                        ((RadioCell) view).setChecked(true, true);
                                                        View viewFindViewWithTag2 = ProfileNotificationsActivity.this.listView.findViewWithTag(2);
                                                        if (viewFindViewWithTag2 != null) {
                                                            ((RadioCell) viewFindViewWithTag2).setChecked(false, true);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    if (ProfileNotificationsActivity.this.getParentActivity() == null) {
                                                        return;
                                                    }
                                                    ProfileNotificationsActivity profileNotificationsActivity = ProfileNotificationsActivity.this;
                                                    profileNotificationsActivity.showDialog(AlertsCreator.createColorSelectDialog(profileNotificationsActivity.getParentActivity(), ProfileNotificationsActivity.this.dialogId, -1, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileNotificationsActivity$3$mYTsx8g8HQcQwmwJOCElj-MR5iw
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            this.f$0.lambda$onItemClick$5$ProfileNotificationsActivity$3();
                                                        }
                                                    }));
                                                    return;
                                                }
                                                if (ProfileNotificationsActivity.this.getParentActivity() == null) {
                                                    return;
                                                }
                                                final Activity parentActivity = ProfileNotificationsActivity.this.getParentActivity();
                                                SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                                                int i = notificationsSettings.getInt("smart_max_count_" + ProfileNotificationsActivity.this.dialogId, 2);
                                                final int i2 = ((((notificationsSettings.getInt("smart_delay_" + ProfileNotificationsActivity.this.dialogId, 180) / 60) - 1) * 10) + (i != 0 ? i : 2)) - 1;
                                                RecyclerListView recyclerListView = new RecyclerListView(ProfileNotificationsActivity.this.getParentActivity());
                                                recyclerListView.setLayoutManager(new LinearLayoutManager(this.val$context, 1, false));
                                                recyclerListView.setClipToPadding(true);
                                                recyclerListView.setAdapter(new RecyclerListView.SelectionAdapter() { // from class: ir.eitaa.ui.ProfileNotificationsActivity.3.1
                                                    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                                                    public int getItemCount() {
                                                        return 100;
                                                    }

                                                    @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
                                                    public boolean isEnabled(RecyclerView.ViewHolder holder) {
                                                        return true;
                                                    }

                                                    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                                                    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                                                        TextView textView = new TextView(parentActivity) { // from class: ir.eitaa.ui.ProfileNotificationsActivity.3.1.1
                                                            @Override // android.widget.TextView, android.view.View
                                                            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                                                                super.onMeasure(View.MeasureSpec.makeMeasureSpec(widthMeasureSpec, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
                                                            }
                                                        };
                                                        textView.setGravity(17);
                                                        textView.setTextSize(1, 18.0f);
                                                        textView.setSingleLine(true);
                                                        textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        textView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                                                        return new RecyclerListView.Holder(textView);
                                                    }

                                                    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                                                    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position2) {
                                                        TextView textView = (TextView) holder.itemView;
                                                        textView.setTextColor(Theme.getColor(position2 == i2 ? "dialogTextGray" : "dialogTextBlack"));
                                                        textView.setText(LocaleController.formatString("SmartNotificationsDetail", R.string.SmartNotificationsDetail, LocaleController.formatPluralString("Times", (position2 % 10) + 1), LocaleController.formatPluralString("Minutes", (position2 / 10) + 1)));
                                                    }
                                                });
                                                recyclerListView.setPadding(0, AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(8.0f));
                                                recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileNotificationsActivity$3$coMrh6F-oR94bMGw5ZmrX_rkQlI
                                                    @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                                                    public final void onItemClick(View view2, int i3) {
                                                        this.f$0.lambda$onItemClick$3$ProfileNotificationsActivity$3(view2, i3);
                                                    }
                                                });
                                                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileNotificationsActivity.this.getParentActivity());
                                                builder.setTitle(LocaleController.getString("SmartNotificationsAlert", R.string.SmartNotificationsAlert));
                                                builder.setView(recyclerListView);
                                                builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                                                builder.setNegativeButton(LocaleController.getString("SmartNotificationsDisabled", R.string.SmartNotificationsDisabled), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProfileNotificationsActivity$3$Qe_KtDcOmslRioAWH3hhHRihvcQ
                                                    @Override // android.content.DialogInterface.OnClickListener
                                                    public final void onClick(DialogInterface dialogInterface, int i3) {
                                                        this.f$0.lambda$onItemClick$4$ProfileNotificationsActivity$3(dialogInterface, i3);
                                                    }
                                                });
                                                ProfileNotificationsActivity.this.showDialog(builder.create());
                                                return;
                                            }
                                            ProfileNotificationsActivity profileNotificationsActivity2 = ProfileNotificationsActivity.this;
                                            profileNotificationsActivity2.showDialog(AlertsCreator.createPrioritySelectDialog(profileNotificationsActivity2.getParentActivity(), ProfileNotificationsActivity.this.dialogId, -1, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileNotificationsActivity$3$JHoWiUjYIJxrJYIkfnAmRVNLSkY
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.f$0.lambda$onItemClick$2$ProfileNotificationsActivity$3();
                                                }
                                            }));
                                            return;
                                        }
                                        ProfileNotificationsActivity profileNotificationsActivity3 = ProfileNotificationsActivity.this;
                                        profileNotificationsActivity3.showDialog(AlertsCreator.createVibrationSelectDialog(profileNotificationsActivity3.getParentActivity(), ProfileNotificationsActivity.this.dialogId, "calls_vibrate_" + ProfileNotificationsActivity.this.dialogId, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileNotificationsActivity$3$wOqi1-jWDS2BeTjlYnnCiXEzaPI
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                this.f$0.lambda$onItemClick$1$ProfileNotificationsActivity$3();
                                            }
                                        }));
                                        return;
                                    }
                                    TextCheckCell textCheckCell = (TextCheckCell) view;
                                    MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putBoolean("content_preview_" + ProfileNotificationsActivity.this.dialogId, !textCheckCell.isChecked()).commit();
                                    textCheckCell.setChecked(textCheckCell.isChecked() ^ true);
                                    return;
                                }
                                ProfileNotificationsActivity.this.notificationsEnabled = !r12.isChecked();
                                ((TextCheckCell) view).setChecked(ProfileNotificationsActivity.this.notificationsEnabled);
                                ProfileNotificationsActivity.this.checkRowsEnabled();
                                return;
                            }
                            ProfileNotificationsActivity profileNotificationsActivity4 = ProfileNotificationsActivity.this;
                            profileNotificationsActivity4.showDialog(AlertsCreator.createVibrationSelectDialog(profileNotificationsActivity4.getParentActivity(), ProfileNotificationsActivity.this.dialogId, false, false, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProfileNotificationsActivity$3$QlB4pd28UqJF6GuxcT-R-8KvlnI
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onItemClick$0$ProfileNotificationsActivity$3();
                                }
                            }));
                            return;
                        }
                        try {
                            Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                            intent.putExtra("android.intent.extra.ringtone.TYPE", 1);
                            intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
                            intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
                            intent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(1));
                            SharedPreferences notificationsSettings2 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                            Uri uri2 = Settings.System.DEFAULT_NOTIFICATION_URI;
                            String path = uri2 != null ? uri2.getPath() : null;
                            String string = notificationsSettings2.getString("ringtone_path_" + ProfileNotificationsActivity.this.dialogId, path);
                            if (string != null && !string.equals("NoSound")) {
                                uri = string.equals(path) ? uri2 : Uri.parse(string);
                            }
                            intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", uri);
                            ProfileNotificationsActivity.this.startActivityForResult(intent, 13);
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    try {
                        Intent intent2 = new Intent("android.intent.action.RINGTONE_PICKER");
                        intent2.putExtra("android.intent.extra.ringtone.TYPE", 2);
                        intent2.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", true);
                        intent2.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
                        intent2.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(2));
                        SharedPreferences notificationsSettings3 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                        Uri uri3 = Settings.System.DEFAULT_NOTIFICATION_URI;
                        String path2 = uri3 != null ? uri3.getPath() : null;
                        String string2 = notificationsSettings3.getString("sound_path_" + ProfileNotificationsActivity.this.dialogId, path2);
                        if (string2 != null && !string2.equals("NoSound")) {
                            uri = string2.equals(path2) ? uri3 : Uri.parse(string2);
                        }
                        intent2.putExtra("android.intent.extra.ringtone.EXISTING_URI", uri);
                        ProfileNotificationsActivity.this.startActivityForResult(intent2, 12);
                        return;
                    } catch (Exception e2) {
                        FileLog.e(e2);
                        return;
                    }
                }
                return;
            }
            SharedPreferences notificationsSettings4 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
            ProfileNotificationsActivity profileNotificationsActivity5 = ProfileNotificationsActivity.this;
            profileNotificationsActivity5.customEnabled = true ^ profileNotificationsActivity5.customEnabled;
            ProfileNotificationsActivity profileNotificationsActivity6 = ProfileNotificationsActivity.this;
            profileNotificationsActivity6.notificationsEnabled = profileNotificationsActivity6.customEnabled;
            notificationsSettings4.edit().putBoolean("custom_" + ProfileNotificationsActivity.this.dialogId, ProfileNotificationsActivity.this.customEnabled).commit();
            ((TextCheckBoxCell) view).setChecked(ProfileNotificationsActivity.this.customEnabled);
            ProfileNotificationsActivity.this.checkRowsEnabled();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$0$ProfileNotificationsActivity$3() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.vibrateRow);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$ProfileNotificationsActivity$3() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.callsVibrateRow);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$2$ProfileNotificationsActivity$3() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.priorityRow);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$3$ProfileNotificationsActivity$3(View view, int i) {
            if (i < 0 || i >= 100) {
                return;
            }
            SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
            notificationsSettings.edit().putInt("smart_max_count_" + ProfileNotificationsActivity.this.dialogId, (i % 10) + 1).commit();
            notificationsSettings.edit().putInt("smart_delay_" + ProfileNotificationsActivity.this.dialogId, ((i / 10) + 1) * 60).commit();
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.smartRow);
            }
            ProfileNotificationsActivity.this.dismissCurrentDialog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$4$ProfileNotificationsActivity$3(DialogInterface dialogInterface, int i) {
            MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt("smart_max_count_" + ProfileNotificationsActivity.this.dialogId, 0).commit();
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.smartRow);
            }
            ProfileNotificationsActivity.this.dismissCurrentDialog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$5$ProfileNotificationsActivity$3() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.colorRow);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) {
        Ringtone ringtone;
        if (resultCode != -1 || data == null) {
            return;
        }
        Uri uri = (Uri) data.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        String title = null;
        if (uri != null && (ringtone = RingtoneManager.getRingtone(ApplicationLoader.applicationContext, uri)) != null) {
            if (requestCode == 13) {
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
        if (requestCode == 12) {
            if (title != null) {
                editorEdit.putString("sound_" + this.dialogId, title);
                editorEdit.putString("sound_path_" + this.dialogId, uri.toString());
            } else {
                editorEdit.putString("sound_" + this.dialogId, "NoSound");
                editorEdit.putString("sound_path_" + this.dialogId, "NoSound");
            }
            getNotificationsController().deleteNotificationChannel(this.dialogId);
        } else if (requestCode == 13) {
            if (title != null) {
                editorEdit.putString("ringtone_" + this.dialogId, title);
                editorEdit.putString("ringtone_path_" + this.dialogId, uri.toString());
            } else {
                editorEdit.putString("ringtone_" + this.dialogId, "NoSound");
                editorEdit.putString("ringtone_path_" + this.dialogId, "NoSound");
            }
        }
        editorEdit.commit();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(requestCode == 13 ? this.ringtoneRow : this.soundRow);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.notificationsSettingsUpdated) {
            this.adapter.notifyDataSetChanged();
        }
    }

    public void setDelegate(ProfileNotificationsActivityDelegate profileNotificationsActivityDelegate) {
        this.delegate = profileNotificationsActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRowsEnabled() {
        int childCount = this.listView.getChildCount();
        ArrayList<Animator> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.getChildViewHolder(this.listView.getChildAt(i));
            int itemViewType = holder.getItemViewType();
            int adapterPosition = holder.getAdapterPosition();
            if (adapterPosition != this.customRow && adapterPosition != this.enableRow && itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextSettingsCell) holder.itemView).setEnabled(this.customEnabled && this.notificationsEnabled, arrayList);
                } else if (itemViewType == 2) {
                    ((TextInfoPrivacyCell) holder.itemView).setEnabled(this.customEnabled && this.notificationsEnabled, arrayList);
                } else if (itemViewType == 3) {
                    ((TextColorCell) holder.itemView).setEnabled(this.customEnabled && this.notificationsEnabled, arrayList);
                } else if (itemViewType == 4) {
                    ((RadioCell) holder.itemView).setEnabled(this.customEnabled && this.notificationsEnabled, arrayList);
                } else if (itemViewType == 8 && adapterPosition == this.previewRow) {
                    ((TextCheckCell) holder.itemView).setEnabled(this.customEnabled && this.notificationsEnabled, arrayList);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.animatorSet = animatorSet2;
        animatorSet2.playTogether(arrayList);
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.ProfileNotificationsActivity.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(ProfileNotificationsActivity.this.animatorSet)) {
                    ProfileNotificationsActivity.this.animatorSet = null;
                }
            }
        });
        this.animatorSet.setDuration(150L);
        this.animatorSet.start();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        public ListAdapter(Context ctx) {
            this.context = ctx;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProfileNotificationsActivity.this.rowCount;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            switch (holder.getItemViewType()) {
                case 1:
                case 3:
                case 4:
                    if (!ProfileNotificationsActivity.this.customEnabled || !ProfileNotificationsActivity.this.notificationsEnabled) {
                    }
                    break;
                case 8:
                    if (holder.getAdapterPosition() == ProfileNotificationsActivity.this.previewRow) {
                        if (!ProfileNotificationsActivity.this.customEnabled || !ProfileNotificationsActivity.this.notificationsEnabled) {
                        }
                    }
                    break;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View headerCell;
            View textInfoPrivacyCell;
            switch (viewType) {
                case 0:
                    headerCell = new HeaderCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textInfoPrivacyCell = headerCell;
                    break;
                case 1:
                    headerCell = new TextSettingsCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textInfoPrivacyCell = headerCell;
                    break;
                case 2:
                    textInfoPrivacyCell = new TextInfoPrivacyCell(this.context);
                    break;
                case 3:
                    headerCell = new TextColorCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textInfoPrivacyCell = headerCell;
                    break;
                case 4:
                    headerCell = new RadioCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textInfoPrivacyCell = headerCell;
                    break;
                case 5:
                    headerCell = new TextCheckBoxCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textInfoPrivacyCell = headerCell;
                    break;
                case 6:
                    headerCell = new UserCell2(this.context, 4, 0);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textInfoPrivacyCell = headerCell;
                    break;
                case 7:
                    textInfoPrivacyCell = new ShadowSectionCell(this.context);
                    break;
                default:
                    headerCell = new TextCheckCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    textInfoPrivacyCell = headerCell;
                    break;
            }
            textInfoPrivacyCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int i;
            switch (holder.getItemViewType()) {
                case 0:
                    HeaderCell headerCell = (HeaderCell) holder.itemView;
                    if (position != ProfileNotificationsActivity.this.generalRow) {
                        if (position != ProfileNotificationsActivity.this.popupRow) {
                            if (position != ProfileNotificationsActivity.this.ledRow) {
                                if (position == ProfileNotificationsActivity.this.callsRow) {
                                    headerCell.setText(LocaleController.getString("VoipNotificationSettings", R.string.VoipNotificationSettings));
                                    break;
                                }
                            } else {
                                headerCell.setText(LocaleController.getString("NotificationsLed", R.string.NotificationsLed));
                                break;
                            }
                        } else {
                            headerCell.setText(LocaleController.getString("ProfilePopupNotification", R.string.ProfilePopupNotification));
                            break;
                        }
                    } else {
                        headerCell.setText(LocaleController.getString("General", R.string.General));
                        break;
                    }
                    break;
                case 1:
                    TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    if (position != ProfileNotificationsActivity.this.soundRow) {
                        if (position != ProfileNotificationsActivity.this.ringtoneRow) {
                            if (position != ProfileNotificationsActivity.this.vibrateRow) {
                                if (position != ProfileNotificationsActivity.this.priorityRow) {
                                    if (position != ProfileNotificationsActivity.this.smartRow) {
                                        if (position == ProfileNotificationsActivity.this.callsVibrateRow) {
                                            int i2 = notificationsSettings.getInt("calls_vibrate_" + ProfileNotificationsActivity.this.dialogId, 0);
                                            if (i2 != 0 && i2 != 4) {
                                                if (i2 != 1) {
                                                    if (i2 != 2) {
                                                        if (i2 == 3) {
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
                                        int i3 = notificationsSettings.getInt("smart_max_count_" + ProfileNotificationsActivity.this.dialogId, 2);
                                        int i4 = notificationsSettings.getInt("smart_delay_" + ProfileNotificationsActivity.this.dialogId, 180);
                                        if (i3 == 0) {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("SmartNotifications", R.string.SmartNotifications), LocaleController.getString("SmartNotificationsDisabled", R.string.SmartNotificationsDisabled), ProfileNotificationsActivity.this.priorityRow != -1);
                                            break;
                                        } else {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("SmartNotifications", R.string.SmartNotifications), LocaleController.formatString("SmartNotificationsInfo", R.string.SmartNotificationsInfo, Integer.valueOf(i3), LocaleController.formatPluralString("Minutes", i4 / 60)), ProfileNotificationsActivity.this.priorityRow != -1);
                                            break;
                                        }
                                    }
                                } else {
                                    int i5 = notificationsSettings.getInt("priority_" + ProfileNotificationsActivity.this.dialogId, 3);
                                    if (i5 != 0) {
                                        if (i5 != 1 && i5 != 2) {
                                            if (i5 != 3) {
                                                if (i5 != 4) {
                                                    if (i5 == 5) {
                                                        textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityMedium", R.string.NotificationsPriorityMedium), false);
                                                        break;
                                                    }
                                                } else {
                                                    textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityLow", R.string.NotificationsPriorityLow), false);
                                                    break;
                                                }
                                            } else {
                                                textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPrioritySettings", R.string.NotificationsPrioritySettings), false);
                                                break;
                                            }
                                        } else {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityUrgent", R.string.NotificationsPriorityUrgent), false);
                                            break;
                                        }
                                    } else {
                                        textSettingsCell.setTextAndValue(LocaleController.getString("NotificationsImportance", R.string.NotificationsImportance), LocaleController.getString("NotificationsPriorityHigh", R.string.NotificationsPriorityHigh), false);
                                        break;
                                    }
                                }
                            } else {
                                int i6 = notificationsSettings.getInt("vibrate_" + ProfileNotificationsActivity.this.dialogId, 0);
                                if (i6 != 0 && i6 != 4) {
                                    if (i6 != 1) {
                                        if (i6 != 2) {
                                            if (i6 == 3) {
                                                textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Long", R.string.Long), (ProfileNotificationsActivity.this.smartRow == -1 && ProfileNotificationsActivity.this.priorityRow == -1) ? false : true);
                                                break;
                                            }
                                        } else {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDisabled", R.string.VibrationDisabled), (ProfileNotificationsActivity.this.smartRow == -1 && ProfileNotificationsActivity.this.priorityRow == -1) ? false : true);
                                            break;
                                        }
                                    } else {
                                        textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("Short", R.string.Short), (ProfileNotificationsActivity.this.smartRow == -1 && ProfileNotificationsActivity.this.priorityRow == -1) ? false : true);
                                        break;
                                    }
                                } else {
                                    textSettingsCell.setTextAndValue(LocaleController.getString("Vibrate", R.string.Vibrate), LocaleController.getString("VibrationDefault", R.string.VibrationDefault), (ProfileNotificationsActivity.this.smartRow == -1 && ProfileNotificationsActivity.this.priorityRow == -1) ? false : true);
                                    break;
                                }
                            }
                        } else {
                            String string = notificationsSettings.getString("ringtone_" + ProfileNotificationsActivity.this.dialogId, LocaleController.getString("DefaultRingtone", R.string.DefaultRingtone));
                            if (string.equals("NoSound")) {
                                string = LocaleController.getString("NoSound", R.string.NoSound);
                            }
                            textSettingsCell.setTextAndValue(LocaleController.getString("VoipSettingsRingtone", R.string.VoipSettingsRingtone), string, false);
                            break;
                        }
                    } else {
                        String string2 = notificationsSettings.getString("sound_" + ProfileNotificationsActivity.this.dialogId, LocaleController.getString("SoundDefault", R.string.SoundDefault));
                        if (string2.equals("NoSound")) {
                            string2 = LocaleController.getString("NoSound", R.string.NoSound);
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("Sound", R.string.Sound), string2, true);
                        break;
                    }
                    break;
                case 2:
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    if (position != ProfileNotificationsActivity.this.popupInfoRow) {
                        if (position != ProfileNotificationsActivity.this.ledInfoRow) {
                            if (position == ProfileNotificationsActivity.this.priorityInfoRow) {
                                if (ProfileNotificationsActivity.this.priorityRow == -1) {
                                    textInfoPrivacyCell.setText("");
                                } else {
                                    textInfoPrivacyCell.setText(LocaleController.getString("PriorityInfo", R.string.PriorityInfo));
                                }
                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                break;
                            } else if (position != ProfileNotificationsActivity.this.customInfoRow) {
                                if (position == ProfileNotificationsActivity.this.ringtoneInfoRow) {
                                    textInfoPrivacyCell.setText(LocaleController.getString("VoipRingtoneInfo", R.string.VoipRingtoneInfo));
                                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                    break;
                                }
                            } else {
                                textInfoPrivacyCell.setText(null);
                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                                break;
                            }
                        } else {
                            textInfoPrivacyCell.setText(LocaleController.getString("NotificationsLedInfo", R.string.NotificationsLedInfo));
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                            break;
                        }
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("ProfilePopupNotificationInfo", R.string.ProfilePopupNotificationInfo));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                        break;
                    }
                    break;
                case 3:
                    TextColorCell textColorCell = (TextColorCell) holder.itemView;
                    SharedPreferences notificationsSettings2 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    if (!notificationsSettings2.contains("color_" + ProfileNotificationsActivity.this.dialogId)) {
                        if (DialogObject.isChatDialog(ProfileNotificationsActivity.this.dialogId)) {
                            i = notificationsSettings2.getInt("GroupLed", -16776961);
                        } else {
                            i = notificationsSettings2.getInt("MessagesLed", -16776961);
                        }
                    } else {
                        i = notificationsSettings2.getInt("color_" + ProfileNotificationsActivity.this.dialogId, -16776961);
                    }
                    int i7 = 0;
                    while (true) {
                        if (i7 < 9) {
                            if (TextColorCell.colorsToSave[i7] == i) {
                                i = TextColorCell.colors[i7];
                            } else {
                                i7++;
                            }
                        }
                    }
                    textColorCell.setTextAndColor(LocaleController.getString("NotificationsLedColor", R.string.NotificationsLedColor), i, false);
                    break;
                case 4:
                    RadioCell radioCell = (RadioCell) holder.itemView;
                    SharedPreferences notificationsSettings3 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    int i8 = notificationsSettings3.getInt("popup_" + ProfileNotificationsActivity.this.dialogId, 0);
                    if (i8 == 0) {
                        i8 = notificationsSettings3.getInt(DialogObject.isChatDialog(ProfileNotificationsActivity.this.dialogId) ? "popupGroup" : "popupAll", 0) != 0 ? 1 : 2;
                    }
                    if (position != ProfileNotificationsActivity.this.popupEnabledRow) {
                        if (position == ProfileNotificationsActivity.this.popupDisabledRow) {
                            radioCell.setText(LocaleController.getString("PopupDisabled", R.string.PopupDisabled), i8 == 2, false);
                            radioCell.setTag(2);
                            break;
                        }
                    } else {
                        radioCell.setText(LocaleController.getString("PopupEnabled", R.string.PopupEnabled), i8 == 1, true);
                        radioCell.setTag(1);
                        break;
                    }
                    break;
                case 5:
                    TextCheckBoxCell textCheckBoxCell = (TextCheckBoxCell) holder.itemView;
                    MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    textCheckBoxCell.setTextAndCheck(LocaleController.getString("NotificationsEnableCustom", R.string.NotificationsEnableCustom), ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled, false);
                    break;
                case 6:
                    ((UserCell2) holder.itemView).setData(DialogObject.isUserDialog(ProfileNotificationsActivity.this.dialogId) ? MessagesController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).getUser(Long.valueOf(ProfileNotificationsActivity.this.dialogId)) : MessagesController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).getChat(Long.valueOf(-ProfileNotificationsActivity.this.dialogId)), null, null, 0);
                    break;
                case 8:
                    TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                    SharedPreferences notificationsSettings4 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    if (position == ProfileNotificationsActivity.this.enableRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("Notifications", R.string.Notifications), ProfileNotificationsActivity.this.notificationsEnabled, true);
                        break;
                    } else if (position == ProfileNotificationsActivity.this.previewRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("MessagePreview", R.string.MessagePreview), notificationsSettings4.getBoolean("content_preview_" + ProfileNotificationsActivity.this.dialogId, true), true);
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() != 0) {
                int itemViewType = holder.getItemViewType();
                boolean z = false;
                if (itemViewType == 1) {
                    TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    textSettingsCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType == 2) {
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    textInfoPrivacyCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType == 3) {
                    TextColorCell textColorCell = (TextColorCell) holder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    textColorCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType == 4) {
                    RadioCell radioCell = (RadioCell) holder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    radioCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType != 8) {
                    return;
                }
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                if (holder.getAdapterPosition() == ProfileNotificationsActivity.this.previewRow) {
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    textCheckCell.setEnabled(z, null);
                    return;
                }
                textCheckCell.setEnabled(true, null);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == ProfileNotificationsActivity.this.generalRow || position == ProfileNotificationsActivity.this.popupRow || position == ProfileNotificationsActivity.this.ledRow || position == ProfileNotificationsActivity.this.callsRow) {
                return 0;
            }
            if (position == ProfileNotificationsActivity.this.soundRow || position == ProfileNotificationsActivity.this.vibrateRow || position == ProfileNotificationsActivity.this.priorityRow || position == ProfileNotificationsActivity.this.smartRow || position == ProfileNotificationsActivity.this.ringtoneRow || position == ProfileNotificationsActivity.this.callsVibrateRow) {
                return 1;
            }
            if (position == ProfileNotificationsActivity.this.popupInfoRow || position == ProfileNotificationsActivity.this.ledInfoRow || position == ProfileNotificationsActivity.this.priorityInfoRow || position == ProfileNotificationsActivity.this.customInfoRow || position == ProfileNotificationsActivity.this.ringtoneInfoRow) {
                return 2;
            }
            if (position == ProfileNotificationsActivity.this.colorRow) {
                return 3;
            }
            if (position == ProfileNotificationsActivity.this.popupEnabledRow || position == ProfileNotificationsActivity.this.popupDisabledRow) {
                return 4;
            }
            if (position == ProfileNotificationsActivity.this.customRow) {
                return 5;
            }
            if (position == ProfileNotificationsActivity.this.avatarRow) {
                return 6;
            }
            if (position == ProfileNotificationsActivity.this.avatarSectionRow) {
                return 7;
            }
            return (position == ProfileNotificationsActivity.this.enableRow || position == ProfileNotificationsActivity.this.previewRow) ? 8 : 0;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProfileNotificationsActivity$cvShUXZpdEyE9g7RyrFj5YPhsG4
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$0$ProfileNotificationsActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextSettingsCell.class, TextColorCell.class, RadioCell.class, UserCell2.class, TextCheckCell.class, TextCheckBoxCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextColorCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundRed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundOrange"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundViolet"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundGreen"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundCyan"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundBlue"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "avatar_backgroundPink"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, "checkboxSquareUnchecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, "checkboxSquareDisabled"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, "checkboxSquareBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, "checkboxSquareCheck"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$0$ProfileNotificationsActivity() {
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof UserCell2) {
                    ((UserCell2) childAt).update(0);
                }
            }
        }
    }
}
