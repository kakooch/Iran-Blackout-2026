package org.rbmain.ui;

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
import io.github.inflationx.calligraphy3.BuildConfig;
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
import org.rbmain.messenger.NotificationsSettingsFacade;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettings;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.RadioCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckBoxCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextColorCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Cells.UserCell2;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.NotificationsSettingsActivity;

/* loaded from: classes4.dex */
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
    private long dialog_id;
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
        void didCreateNewException(NotificationsSettingsActivity.NotificationException notificationException);
    }

    public ProfileNotificationsActivity(Bundle bundle) {
        super(bundle);
        this.dialog_id = bundle.getLong("dialog_id");
        this.addingException = bundle.getBoolean("exception", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onFragmentCreate() {
        /*
            Method dump skipped, instructions count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.ProfileNotificationsActivity.onFragmentCreate():boolean");
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.notificationsSettingsUpdated);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ProfileNotificationsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    if (!ProfileNotificationsActivity.this.addingException && ProfileNotificationsActivity.this.notificationsEnabled && ProfileNotificationsActivity.this.customEnabled) {
                        MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + ProfileNotificationsActivity.this.dialog_id, 0).apply();
                    }
                } else if (i == 1) {
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    SharedPreferences.Editor editorEdit = notificationsSettings.edit();
                    editorEdit.putBoolean(NotificationsSettingsFacade.PROPERTY_CUSTOM + ProfileNotificationsActivity.this.dialog_id, true);
                    TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).dialogs_dict.get(ProfileNotificationsActivity.this.dialog_id);
                    if (ProfileNotificationsActivity.this.notificationsEnabled) {
                        editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + ProfileNotificationsActivity.this.dialog_id, 0);
                        MessagesStorage.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).setDialogFlags(ProfileNotificationsActivity.this.dialog_id, 0L);
                        if (tLRPC$Dialog != null) {
                            tLRPC$Dialog.notify_settings = new TLRPC$TL_peerNotifySettings();
                        }
                    } else {
                        editorEdit.putInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + ProfileNotificationsActivity.this.dialog_id, 2);
                        NotificationsController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).removeNotificationsForDialog(ProfileNotificationsActivity.this.dialog_id);
                        MessagesStorage.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).setDialogFlags(ProfileNotificationsActivity.this.dialog_id, 1L);
                        if (tLRPC$Dialog != null) {
                            TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
                            tLRPC$Dialog.notify_settings = tLRPC$TL_peerNotifySettings;
                            tLRPC$TL_peerNotifySettings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
                        }
                    }
                    editorEdit.apply();
                    NotificationsController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).updateServerNotificationsSettings(ProfileNotificationsActivity.this.dialog_id);
                    if (ProfileNotificationsActivity.this.delegate != null) {
                        NotificationsSettingsActivity.NotificationException notificationException = new NotificationsSettingsActivity.NotificationException();
                        notificationException.did = ProfileNotificationsActivity.this.dialog_id;
                        notificationException.hasCustom = true;
                        int i2 = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY + ProfileNotificationsActivity.this.dialog_id, 0);
                        notificationException.notify = i2;
                        if (i2 != 0) {
                            notificationException.muteUntil = notificationsSettings.getInt(NotificationsSettingsFacade.PROPERTY_NOTIFY_UNTIL + ProfileNotificationsActivity.this.dialog_id, 0);
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
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        frameLayout2.addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setLayoutManager(new LinearLayoutManager(this, context) { // from class: org.rbmain.ui.ProfileNotificationsActivity.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean supportsPredictiveItemAnimations() {
                return false;
            }
        });
        this.listView.setOnItemClickListener(new AnonymousClass3(context));
        return this.fragmentView;
    }

    /* renamed from: org.rbmain.ui.ProfileNotificationsActivity$3, reason: invalid class name */
    class AnonymousClass3 implements RecyclerListView.OnItemClickListener {
        final /* synthetic */ Context val$context;

        AnonymousClass3(Context context) {
            this.val$context = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
        public void onItemClick(View view, int i) {
            if (i != ProfileNotificationsActivity.this.customRow || !(view instanceof TextCheckBoxCell)) {
                if (ProfileNotificationsActivity.this.customEnabled && view.isEnabled()) {
                    Uri uri = null;
                    if (i != ProfileNotificationsActivity.this.soundRow) {
                        if (i != ProfileNotificationsActivity.this.ringtoneRow) {
                            if (i != ProfileNotificationsActivity.this.vibrateRow) {
                                if (i != ProfileNotificationsActivity.this.enableRow) {
                                    if (i != ProfileNotificationsActivity.this.previewRow) {
                                        if (i != ProfileNotificationsActivity.this.callsVibrateRow) {
                                            if (i != ProfileNotificationsActivity.this.priorityRow) {
                                                if (i != ProfileNotificationsActivity.this.smartRow) {
                                                    if (i != ProfileNotificationsActivity.this.colorRow) {
                                                        if (i != ProfileNotificationsActivity.this.popupEnabledRow) {
                                                            if (i == ProfileNotificationsActivity.this.popupDisabledRow) {
                                                                MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt("popup_" + ProfileNotificationsActivity.this.dialog_id, 2).apply();
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
                                                        MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt("popup_" + ProfileNotificationsActivity.this.dialog_id, 1).apply();
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
                                                    profileNotificationsActivity.showDialog(AlertsCreator.createColorSelectDialog(profileNotificationsActivity.getParentActivity(), ProfileNotificationsActivity.this.dialog_id, -1, new Runnable() { // from class: org.rbmain.ui.ProfileNotificationsActivity$3$$ExternalSyntheticLambda1
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            this.f$0.lambda$onItemClick$5();
                                                        }
                                                    }));
                                                    return;
                                                }
                                                if (ProfileNotificationsActivity.this.getParentActivity() == null) {
                                                    return;
                                                }
                                                final Activity parentActivity = ProfileNotificationsActivity.this.getParentActivity();
                                                SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                                                int i2 = notificationsSettings.getInt("smart_max_count_" + ProfileNotificationsActivity.this.dialog_id, 2);
                                                final int i3 = ((((notificationsSettings.getInt("smart_delay_" + ProfileNotificationsActivity.this.dialog_id, 180) / 60) - 1) * 10) + (i2 != 0 ? i2 : 2)) - 1;
                                                RecyclerListView recyclerListView = new RecyclerListView(ProfileNotificationsActivity.this.getParentActivity());
                                                recyclerListView.setLayoutManager(new LinearLayoutManager(this.val$context, 1, false));
                                                recyclerListView.setClipToPadding(true);
                                                recyclerListView.setAdapter(new RecyclerListView.SelectionAdapter(this) { // from class: org.rbmain.ui.ProfileNotificationsActivity.3.1
                                                    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                                                    public int getItemCount() {
                                                        return 100;
                                                    }

                                                    @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
                                                    public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
                                                        return true;
                                                    }

                                                    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                                                    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
                                                        TextView textView = new TextView(this, parentActivity) { // from class: org.rbmain.ui.ProfileNotificationsActivity.3.1.1
                                                            @Override // android.widget.TextView, android.view.View
                                                            protected void onMeasure(int i5, int i6) {
                                                                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f), 1073741824));
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
                                                    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
                                                        TextView textView = (TextView) viewHolder.itemView;
                                                        textView.setTextColor(Theme.getColor(i4 == i3 ? Theme.key_dialogTextGray : Theme.key_dialogTextBlack));
                                                        textView.setText(LocaleController.formatString("SmartNotificationsDetail", R.string.SmartNotificationsDetail, LocaleController.formatPluralString("Times", (i4 % 10) + 1), LocaleController.formatPluralString("Minutes", (i4 / 10) + 1)));
                                                    }
                                                });
                                                recyclerListView.setPadding(0, AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(8.0f));
                                                recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.ProfileNotificationsActivity$3$$ExternalSyntheticLambda5
                                                    @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
                                                    public final void onItemClick(View view2, int i4) {
                                                        this.f$0.lambda$onItemClick$3(view2, i4);
                                                    }
                                                });
                                                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileNotificationsActivity.this.getParentActivity());
                                                builder.setTitle(LocaleController.getString("SmartNotificationsAlert", R.string.SmartNotificationsAlert));
                                                builder.setView(recyclerListView);
                                                builder.setPositiveButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                                                builder.setNegativeButton(LocaleController.getString("SmartNotificationsDisabled", R.string.SmartNotificationsDisabled), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ProfileNotificationsActivity$3$$ExternalSyntheticLambda0
                                                    @Override // android.content.DialogInterface.OnClickListener
                                                    public final void onClick(DialogInterface dialogInterface, int i4) {
                                                        this.f$0.lambda$onItemClick$4(dialogInterface, i4);
                                                    }
                                                });
                                                ProfileNotificationsActivity.this.showDialog(builder.create());
                                                return;
                                            }
                                            ProfileNotificationsActivity profileNotificationsActivity2 = ProfileNotificationsActivity.this;
                                            profileNotificationsActivity2.showDialog(AlertsCreator.createPrioritySelectDialog(profileNotificationsActivity2.getParentActivity(), ProfileNotificationsActivity.this.dialog_id, -1, new Runnable() { // from class: org.rbmain.ui.ProfileNotificationsActivity$3$$ExternalSyntheticLambda3
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.f$0.lambda$onItemClick$2();
                                                }
                                            }));
                                            return;
                                        }
                                        ProfileNotificationsActivity profileNotificationsActivity3 = ProfileNotificationsActivity.this;
                                        profileNotificationsActivity3.showDialog(AlertsCreator.createVibrationSelectDialog(profileNotificationsActivity3.getParentActivity(), ProfileNotificationsActivity.this.dialog_id, "calls_vibrate_" + ProfileNotificationsActivity.this.dialog_id, new Runnable() { // from class: org.rbmain.ui.ProfileNotificationsActivity$3$$ExternalSyntheticLambda4
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                this.f$0.lambda$onItemClick$1();
                                            }
                                        }));
                                        return;
                                    }
                                    TextCheckCell textCheckCell = (TextCheckCell) view;
                                    MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putBoolean(NotificationsSettingsFacade.PROPERTY_CONTENT_PREVIEW + ProfileNotificationsActivity.this.dialog_id, !textCheckCell.isChecked()).apply();
                                    textCheckCell.setChecked(textCheckCell.isChecked() ^ true);
                                    return;
                                }
                                ProfileNotificationsActivity.this.notificationsEnabled = !r12.isChecked();
                                ((TextCheckCell) view).setChecked(ProfileNotificationsActivity.this.notificationsEnabled);
                                ProfileNotificationsActivity.this.checkRowsEnabled();
                                return;
                            }
                            ProfileNotificationsActivity profileNotificationsActivity4 = ProfileNotificationsActivity.this;
                            profileNotificationsActivity4.showDialog(AlertsCreator.createVibrationSelectDialog(profileNotificationsActivity4.getParentActivity(), ProfileNotificationsActivity.this.dialog_id, false, false, new Runnable() { // from class: org.rbmain.ui.ProfileNotificationsActivity$3$$ExternalSyntheticLambda2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onItemClick$0();
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
                            String string = notificationsSettings2.getString("ringtone_path_" + ProfileNotificationsActivity.this.dialog_id, path);
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
                        String string2 = notificationsSettings3.getString("sound_path_" + ProfileNotificationsActivity.this.dialog_id, path2);
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
            notificationsSettings4.edit().putBoolean(NotificationsSettingsFacade.PROPERTY_CUSTOM + ProfileNotificationsActivity.this.dialog_id, ProfileNotificationsActivity.this.customEnabled).apply();
            ((TextCheckBoxCell) view).setChecked(ProfileNotificationsActivity.this.customEnabled);
            ProfileNotificationsActivity.this.checkRowsEnabled();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.vibrateRow);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.callsVibrateRow);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$2() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.priorityRow);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$3(View view, int i) {
            if (i < 0 || i >= 100) {
                return;
            }
            SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
            notificationsSettings.edit().putInt("smart_max_count_" + ProfileNotificationsActivity.this.dialog_id, (i % 10) + 1).apply();
            notificationsSettings.edit().putInt("smart_delay_" + ProfileNotificationsActivity.this.dialog_id, ((i / 10) + 1) * 60).apply();
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.smartRow);
            }
            ProfileNotificationsActivity.this.dismissCurrentDialog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$4(DialogInterface dialogInterface, int i) {
            MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).edit().putInt("smart_max_count_" + ProfileNotificationsActivity.this.dialog_id, 0).apply();
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.smartRow);
            }
            ProfileNotificationsActivity.this.dismissCurrentDialog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$5() {
            if (ProfileNotificationsActivity.this.adapter != null) {
                ProfileNotificationsActivity.this.adapter.notifyItemChanged(ProfileNotificationsActivity.this.colorRow);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) {
        Ringtone ringtone;
        if (i2 != -1 || intent == null) {
            return;
        }
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        String title = null;
        if (uri != null && (ringtone = RingtoneManager.getRingtone(ApplicationLoader.applicationContext, uri)) != null) {
            if (i == 13) {
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
        if (i == 12) {
            if (title != null) {
                editorEdit.putString("sound_" + this.dialog_id, title);
                editorEdit.putString("sound_path_" + this.dialog_id, uri.toString());
            } else {
                editorEdit.putString("sound_" + this.dialog_id, "NoSound");
                editorEdit.putString("sound_path_" + this.dialog_id, "NoSound");
            }
            getNotificationsController().deleteNotificationChannel(this.dialog_id);
        } else if (i == 13) {
            if (title != null) {
                editorEdit.putString("ringtone_" + this.dialog_id, title);
                editorEdit.putString("ringtone_path_" + this.dialog_id, uri.toString());
            } else {
                editorEdit.putString("ringtone_" + this.dialog_id, "NoSound");
                editorEdit.putString("ringtone_path_" + this.dialog_id, "NoSound");
            }
        }
        editorEdit.apply();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(i == 13 ? this.ringtoneRow : this.soundRow);
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.notificationsSettingsUpdated) {
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
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.ProfileNotificationsActivity.4
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

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ProfileNotificationsActivity.this.rowCount;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            switch (viewHolder.getItemViewType()) {
                case 1:
                case 3:
                case 4:
                    if (!ProfileNotificationsActivity.this.customEnabled || !ProfileNotificationsActivity.this.notificationsEnabled) {
                    }
                    break;
                case 8:
                    if (viewHolder.getAdapterPosition() == ProfileNotificationsActivity.this.previewRow) {
                        if (!ProfileNotificationsActivity.this.customEnabled || !ProfileNotificationsActivity.this.notificationsEnabled) {
                        }
                    }
                    break;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View headerCell;
            switch (i) {
                case 0:
                    headerCell = new HeaderCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 1:
                    headerCell = new TextSettingsCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 2:
                    headerCell = new TextInfoPrivacyCell(this.context);
                    break;
                case 3:
                    headerCell = new TextColorCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 4:
                    headerCell = new RadioCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 5:
                    headerCell = new TextCheckBoxCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 6:
                    headerCell = new UserCell2(this.context, 4, 0);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
                case 7:
                    headerCell = new ShadowSectionCell(this.context);
                    break;
                default:
                    headerCell = new TextCheckCell(this.context);
                    headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                    break;
            }
            headerCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int i2;
            switch (viewHolder.getItemViewType()) {
                case 0:
                    HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                    if (i != ProfileNotificationsActivity.this.generalRow) {
                        if (i != ProfileNotificationsActivity.this.popupRow) {
                            if (i != ProfileNotificationsActivity.this.ledRow) {
                                if (i == ProfileNotificationsActivity.this.callsRow) {
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
                    TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    if (i != ProfileNotificationsActivity.this.soundRow) {
                        if (i != ProfileNotificationsActivity.this.ringtoneRow) {
                            if (i != ProfileNotificationsActivity.this.vibrateRow) {
                                if (i != ProfileNotificationsActivity.this.priorityRow) {
                                    if (i != ProfileNotificationsActivity.this.smartRow) {
                                        if (i == ProfileNotificationsActivity.this.callsVibrateRow) {
                                            int i3 = notificationsSettings.getInt("calls_vibrate_" + ProfileNotificationsActivity.this.dialog_id, 0);
                                            if (i3 != 0 && i3 != 4) {
                                                if (i3 != 1) {
                                                    if (i3 != 2) {
                                                        if (i3 == 3) {
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
                                        int i4 = notificationsSettings.getInt("smart_max_count_" + ProfileNotificationsActivity.this.dialog_id, 2);
                                        int i5 = notificationsSettings.getInt("smart_delay_" + ProfileNotificationsActivity.this.dialog_id, 180);
                                        if (i4 == 0) {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("SmartNotifications", R.string.SmartNotifications), LocaleController.getString("SmartNotificationsDisabled", R.string.SmartNotificationsDisabled), ProfileNotificationsActivity.this.priorityRow != -1);
                                            break;
                                        } else {
                                            textSettingsCell.setTextAndValue(LocaleController.getString("SmartNotifications", R.string.SmartNotifications), LocaleController.formatString("SmartNotificationsInfo", R.string.SmartNotificationsInfo, Integer.valueOf(i4), LocaleController.formatPluralString("Minutes", i5 / 60)), ProfileNotificationsActivity.this.priorityRow != -1);
                                            break;
                                        }
                                    }
                                } else {
                                    int i6 = notificationsSettings.getInt("priority_" + ProfileNotificationsActivity.this.dialog_id, 3);
                                    if (i6 != 0) {
                                        if (i6 != 1 && i6 != 2) {
                                            if (i6 != 3) {
                                                if (i6 != 4) {
                                                    if (i6 == 5) {
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
                                int i7 = notificationsSettings.getInt("vibrate_" + ProfileNotificationsActivity.this.dialog_id, 0);
                                if (i7 != 0 && i7 != 4) {
                                    if (i7 != 1) {
                                        if (i7 != 2) {
                                            if (i7 == 3) {
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
                            String string = notificationsSettings.getString("ringtone_" + ProfileNotificationsActivity.this.dialog_id, LocaleController.getString("DefaultRingtone", R.string.DefaultRingtone));
                            if (string.equals("NoSound")) {
                                string = LocaleController.getString("NoSound", R.string.NoSound);
                            }
                            textSettingsCell.setTextAndValue(LocaleController.getString("VoipSettingsRingtone", R.string.VoipSettingsRingtone), string, false);
                            break;
                        }
                    } else {
                        String string2 = notificationsSettings.getString("sound_" + ProfileNotificationsActivity.this.dialog_id, LocaleController.getString("SoundDefault", R.string.SoundDefault));
                        if (string2.equals("NoSound")) {
                            string2 = LocaleController.getString("NoSound", R.string.NoSound);
                        }
                        textSettingsCell.setTextAndValue(LocaleController.getString("Sound", R.string.Sound), string2, true);
                        break;
                    }
                    break;
                case 2:
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                    if (i != ProfileNotificationsActivity.this.popupInfoRow) {
                        if (i != ProfileNotificationsActivity.this.ledInfoRow) {
                            if (i == ProfileNotificationsActivity.this.priorityInfoRow) {
                                if (ProfileNotificationsActivity.this.priorityRow == -1) {
                                    textInfoPrivacyCell.setText(BuildConfig.FLAVOR);
                                } else {
                                    textInfoPrivacyCell.setText(LocaleController.getString("PriorityInfo", R.string.PriorityInfo));
                                }
                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                break;
                            } else if (i != ProfileNotificationsActivity.this.customInfoRow) {
                                if (i == ProfileNotificationsActivity.this.ringtoneInfoRow) {
                                    textInfoPrivacyCell.setText(LocaleController.getString("VoipRingtoneInfo", R.string.VoipRingtoneInfo));
                                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                    break;
                                }
                            } else {
                                textInfoPrivacyCell.setText(null);
                                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                                break;
                            }
                        } else {
                            textInfoPrivacyCell.setText(LocaleController.getString("NotificationsLedInfo", R.string.NotificationsLedInfo));
                            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                            break;
                        }
                    } else {
                        textInfoPrivacyCell.setText(LocaleController.getString("ProfilePopupNotificationInfo", R.string.ProfilePopupNotificationInfo));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.context, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        break;
                    }
                    break;
                case 3:
                    TextColorCell textColorCell = (TextColorCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings2 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    if (!notificationsSettings2.contains("color_" + ProfileNotificationsActivity.this.dialog_id)) {
                        if (((int) ProfileNotificationsActivity.this.dialog_id) < 0) {
                            i2 = notificationsSettings2.getInt("GroupLed", -16776961);
                        } else {
                            i2 = notificationsSettings2.getInt("MessagesLed", -16776961);
                        }
                    } else {
                        i2 = notificationsSettings2.getInt("color_" + ProfileNotificationsActivity.this.dialog_id, -16776961);
                    }
                    int i8 = 0;
                    while (true) {
                        if (i8 < 9) {
                            if (TextColorCell.colorsToSave[i8] == i2) {
                                i2 = TextColorCell.colors[i8];
                            } else {
                                i8++;
                            }
                        }
                    }
                    textColorCell.setTextAndColor(LocaleController.getString("NotificationsLedColor", R.string.NotificationsLedColor), i2, false);
                    break;
                case 4:
                    RadioCell radioCell = (RadioCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings3 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    int i9 = notificationsSettings3.getInt("popup_" + ProfileNotificationsActivity.this.dialog_id, 0);
                    if (i9 == 0) {
                        i9 = notificationsSettings3.getInt(((int) ProfileNotificationsActivity.this.dialog_id) < 0 ? "popupGroup" : "popupAll", 0) != 0 ? 1 : 2;
                    }
                    if (i != ProfileNotificationsActivity.this.popupEnabledRow) {
                        if (i == ProfileNotificationsActivity.this.popupDisabledRow) {
                            radioCell.setText(LocaleController.getString("PopupDisabled", R.string.PopupDisabled), i9 == 2, false);
                            radioCell.setTag(2);
                            break;
                        }
                    } else {
                        radioCell.setText(LocaleController.getString("PopupEnabled", R.string.PopupEnabled), i9 == 1, true);
                        radioCell.setTag(1);
                        break;
                    }
                    break;
                case 5:
                    TextCheckBoxCell textCheckBoxCell = (TextCheckBoxCell) viewHolder.itemView;
                    MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    textCheckBoxCell.setTextAndCheck(LocaleController.getString("NotificationsEnableCustom", R.string.NotificationsEnableCustom), ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled, false);
                    break;
                case 6:
                    UserCell2 userCell2 = (UserCell2) viewHolder.itemView;
                    int i10 = (int) ProfileNotificationsActivity.this.dialog_id;
                    userCell2.setData(i10 > 0 ? MessagesController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).getUser(Integer.valueOf(i10)) : MessagesController.getInstance(((BaseFragment) ProfileNotificationsActivity.this).currentAccount).getChat(Integer.valueOf(-i10)), null, null, 0);
                    break;
                case 8:
                    TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                    SharedPreferences notificationsSettings4 = MessagesController.getNotificationsSettings(((BaseFragment) ProfileNotificationsActivity.this).currentAccount);
                    if (i == ProfileNotificationsActivity.this.enableRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("Notifications", R.string.Notifications), ProfileNotificationsActivity.this.notificationsEnabled, true);
                        break;
                    } else if (i == ProfileNotificationsActivity.this.previewRow) {
                        textCheckCell.setTextAndCheck(LocaleController.getString("MessagePreview", R.string.MessagePreview), notificationsSettings4.getBoolean(NotificationsSettingsFacade.PROPERTY_CONTENT_PREVIEW + ProfileNotificationsActivity.this.dialog_id, true), true);
                        break;
                    }
                    break;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() != 0) {
                int itemViewType = viewHolder.getItemViewType();
                boolean z = false;
                if (itemViewType == 1) {
                    TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    textSettingsCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType == 2) {
                    TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    textInfoPrivacyCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType == 3) {
                    TextColorCell textColorCell = (TextColorCell) viewHolder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    textColorCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType == 4) {
                    RadioCell radioCell = (RadioCell) viewHolder.itemView;
                    if (ProfileNotificationsActivity.this.customEnabled && ProfileNotificationsActivity.this.notificationsEnabled) {
                        z = true;
                    }
                    radioCell.setEnabled(z, null);
                    return;
                }
                if (itemViewType != 8) {
                    return;
                }
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                if (viewHolder.getAdapterPosition() == ProfileNotificationsActivity.this.previewRow) {
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
        public int getItemViewType(int i) {
            if (i == ProfileNotificationsActivity.this.generalRow || i == ProfileNotificationsActivity.this.popupRow || i == ProfileNotificationsActivity.this.ledRow || i == ProfileNotificationsActivity.this.callsRow) {
                return 0;
            }
            if (i == ProfileNotificationsActivity.this.soundRow || i == ProfileNotificationsActivity.this.vibrateRow || i == ProfileNotificationsActivity.this.priorityRow || i == ProfileNotificationsActivity.this.smartRow || i == ProfileNotificationsActivity.this.ringtoneRow || i == ProfileNotificationsActivity.this.callsVibrateRow) {
                return 1;
            }
            if (i == ProfileNotificationsActivity.this.popupInfoRow || i == ProfileNotificationsActivity.this.ledInfoRow || i == ProfileNotificationsActivity.this.priorityInfoRow || i == ProfileNotificationsActivity.this.customInfoRow || i == ProfileNotificationsActivity.this.ringtoneInfoRow) {
                return 2;
            }
            if (i == ProfileNotificationsActivity.this.colorRow) {
                return 3;
            }
            if (i == ProfileNotificationsActivity.this.popupEnabledRow || i == ProfileNotificationsActivity.this.popupDisabledRow) {
                return 4;
            }
            if (i == ProfileNotificationsActivity.this.customRow) {
                return 5;
            }
            if (i == ProfileNotificationsActivity.this.avatarRow) {
                return 6;
            }
            if (i == ProfileNotificationsActivity.this.avatarSectionRow) {
                return 7;
            }
            return (i == ProfileNotificationsActivity.this.enableRow || i == ProfileNotificationsActivity.this.previewRow) ? 8 : 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ProfileNotificationsActivity$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$0();
            }
        };
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextSettingsCell.class, TextColorCell.class, RadioCell.class, UserCell2.class, TextCheckCell.class, TextCheckBoxCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
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
        int i3 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextColorCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackground));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackgroundChecked));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteGrayText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, new String[]{"statusOnlineColor"}, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{UserCell2.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundRed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundOrange));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundViolet));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundGreen));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundCyan));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundBlue));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_avatar_backgroundPink));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, Theme.key_checkboxSquareUnchecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, Theme.key_checkboxSquareDisabled));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, Theme.key_checkboxSquareBackground));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckBoxCell.class}, null, null, null, Theme.key_checkboxSquareCheck));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$0() {
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
