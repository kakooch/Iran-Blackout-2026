package ir.eitaa.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.DownloadController;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.NotificationsCheckCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.voip.VoIPHelper;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DataSettingsActivity extends BaseFragment {
    private int audioPlayResumeRow;
    private int audioPlayResumeSection2Row;
    private int audioPlayResumeSectionRow;
    private int autoplayGifsRow;
    private int autoplayHeaderRow;
    private int autoplaySectionRow;
    private int autoplayVideoRow;
    private int callsSection2Row;
    private int callsSectionRow;
    private int clearDraftsRow;
    private int clearDraftsSectionRow;
    private int dataUsageRow;
    private int enableAllStreamInfoRow;
    private int enableAllStreamRow;
    private int enableCacheStreamRow;
    private int enableMkvRow;
    private int enableStreamRow;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int mediaDownloadSection2Row;
    private int mediaDownloadSectionRow;
    private int mobileRow;
    private int proxyRow;
    private int proxySectionRow;
    private int quickRepliesRow;
    private int resetDownloadRow;
    private int roamingRow;
    private int rowCount;
    private ArrayList<File> storageDirs;
    private int storageNumRow;
    private int storageUsageRow;
    private int streamSectionRow;
    private int usageSection2Row;
    private int usageSectionRow;
    private int useLessDataForCallsRow;
    private int videoPlayResumeRow;
    private int videoPlayResumeSection2Row;
    private int videoPlayResumeSectionRow;
    private int wifiRow;

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        DownloadController.getInstance(this.currentAccount).loadAutoDownloadConfig(true);
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.usageSectionRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.storageUsageRow = i;
        this.rowCount = i2 + 1;
        this.dataUsageRow = i2;
        this.storageNumRow = -1;
        if (Build.VERSION.SDK_INT >= 19) {
            ArrayList<File> rootDirs = AndroidUtilities.getRootDirs();
            this.storageDirs = rootDirs;
            if (rootDirs.size() > 1) {
                int i3 = this.rowCount;
                this.rowCount = i3 + 1;
                this.storageNumRow = i3;
            }
        }
        int i4 = this.rowCount;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.usageSection2Row = i4;
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.mediaDownloadSectionRow = i5;
        int i7 = i6 + 1;
        this.rowCount = i7;
        this.mobileRow = i6;
        int i8 = i7 + 1;
        this.rowCount = i8;
        this.wifiRow = i7;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.roamingRow = i8;
        int i10 = i9 + 1;
        this.rowCount = i10;
        this.resetDownloadRow = i9;
        int i11 = i10 + 1;
        this.rowCount = i11;
        this.mediaDownloadSection2Row = i10;
        int i12 = i11 + 1;
        this.rowCount = i12;
        this.autoplayHeaderRow = i11;
        int i13 = i12 + 1;
        this.rowCount = i13;
        this.autoplayGifsRow = i12;
        int i14 = i13 + 1;
        this.rowCount = i14;
        this.autoplayVideoRow = i13;
        int i15 = i14 + 1;
        this.rowCount = i15;
        this.autoplaySectionRow = i14;
        int i16 = i15 + 1;
        this.rowCount = i16;
        this.streamSectionRow = i15;
        int i17 = i16 + 1;
        this.rowCount = i17;
        this.enableStreamRow = i16;
        if (BuildVars.DEBUG_VERSION) {
            int i18 = i17 + 1;
            this.rowCount = i18;
            this.enableMkvRow = i17;
            this.rowCount = i18 + 1;
            this.enableAllStreamRow = i18;
        } else {
            this.enableAllStreamRow = -1;
            this.enableMkvRow = -1;
        }
        int i19 = this.rowCount;
        int i20 = i19 + 1;
        this.rowCount = i20;
        this.enableAllStreamInfoRow = i19;
        int i21 = i20 + 1;
        this.rowCount = i21;
        this.videoPlayResumeSectionRow = i20;
        int i22 = i21 + 1;
        this.rowCount = i22;
        this.videoPlayResumeRow = i21;
        int i23 = i22 + 1;
        this.rowCount = i23;
        this.videoPlayResumeSection2Row = i22;
        int i24 = i23 + 1;
        this.rowCount = i24;
        this.audioPlayResumeSectionRow = i23;
        int i25 = i24 + 1;
        this.rowCount = i25;
        this.audioPlayResumeRow = i24;
        this.rowCount = i25 + 1;
        this.audioPlayResumeSection2Row = i25;
        this.enableCacheStreamRow = -1;
        if (MessagesController.getInstance(this.currentAccount).callsEnabled) {
            int i26 = this.rowCount;
            int i27 = i26 + 1;
            this.rowCount = i27;
            this.callsSectionRow = i26;
            int i28 = i27 + 1;
            this.rowCount = i28;
            this.useLessDataForCallsRow = i27;
            int i29 = i28 + 1;
            this.rowCount = i29;
            this.quickRepliesRow = i28;
            this.rowCount = i29 + 1;
            this.callsSection2Row = i29;
        } else {
            this.callsSectionRow = -1;
            this.useLessDataForCallsRow = -1;
            this.quickRepliesRow = -1;
            this.callsSection2Row = -1;
        }
        int i30 = this.rowCount;
        int i31 = i30 + 1;
        this.rowCount = i31;
        this.clearDraftsRow = i30;
        this.rowCount = i31 + 1;
        this.clearDraftsSectionRow = i31;
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("DataSettings", R.string.DataSettings));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.DataSettingsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    DataSettingsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$DataSettingsActivity$Ts65Vku39zbDCOm_zh7T9Tq8c8c
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$4$DataSettingsActivity(context, view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$4$DataSettingsActivity(android.content.Context r10, android.view.View r11, final int r12, float r13, float r14) {
        /*
            Method dump skipped, instructions count: 941
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.DataSettingsActivity.lambda$createView$4$DataSettingsActivity(android.content.Context, android.view.View, int, float, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$DataSettingsActivity(DialogInterface dialogInterface, int i) {
        DownloadController.Preset preset;
        DownloadController.Preset preset2;
        String str;
        SharedPreferences.Editor editorEdit = MessagesController.getMainSettings(this.currentAccount).edit();
        for (int i2 = 0; i2 < 3; i2++) {
            if (i2 == 0) {
                preset = DownloadController.getInstance(this.currentAccount).mobilePreset;
                preset2 = DownloadController.getInstance(this.currentAccount).mediumPreset;
                str = "mobilePreset";
            } else if (i2 == 1) {
                preset = DownloadController.getInstance(this.currentAccount).wifiPreset;
                preset2 = DownloadController.getInstance(this.currentAccount).highPreset;
                str = "wifiPreset";
            } else {
                preset = DownloadController.getInstance(this.currentAccount).roamingPreset;
                preset2 = DownloadController.getInstance(this.currentAccount).lowPreset;
                str = "roamingPreset";
            }
            preset.set(preset2);
            preset.enabled = preset2.isEnabled();
            DownloadController.getInstance(this.currentAccount).currentMobilePreset = 3;
            editorEdit.putInt("currentMobilePreset", 3);
            DownloadController.getInstance(this.currentAccount).currentWifiPreset = 3;
            editorEdit.putInt("currentWifiPreset", 3);
            DownloadController.getInstance(this.currentAccount).currentRoamingPreset = 3;
            editorEdit.putInt("currentRoamingPreset", 3);
            editorEdit.putString(str, preset.toString());
        }
        editorEdit.commit();
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
        for (int i3 = 0; i3 < 3; i3++) {
            DownloadController.getInstance(this.currentAccount).savePresetToServer(i3);
        }
        this.listAdapter.notifyItemRangeChanged(this.mobileRow, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$DataSettingsActivity(SharedPreferences sharedPreferences, int i, DialogInterface dialogInterface, int i2) {
        int i3 = 3;
        if (i2 == 0) {
            i3 = 0;
        } else if (i2 != 1) {
            i3 = i2 != 2 ? i2 != 3 ? -1 : 2 : 1;
        }
        if (i3 != -1) {
            sharedPreferences.edit().putInt("VoipDataSaving", i3).commit();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$DataSettingsActivity(String str, AlertDialog.Builder builder, View view) {
        SharedConfig.storageCacheDir = str;
        SharedConfig.saveConfig();
        ImageLoader.getInstance().checkMediaPaths();
        builder.getDismissRunnable().run();
        this.listAdapter.notifyItemChanged(this.storageNumRow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$DataSettingsActivity(DialogInterface dialogInterface, int i) {
        getMediaDataController().clearAllDrafts(true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return DataSettingsActivity.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            String string;
            String string2;
            String string3;
            boolean z;
            DownloadController.Preset currentRoamingPreset;
            NotificationsCheckCell notificationsCheckCell;
            String str;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                if (position == DataSettingsActivity.this.clearDraftsSectionRow) {
                    holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                    return;
                } else {
                    holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    return;
                }
            }
            if (itemViewType == 1) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                textSettingsCell.setCanDisable(false);
                textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                if (position != DataSettingsActivity.this.storageUsageRow) {
                    if (position != DataSettingsActivity.this.useLessDataForCallsRow) {
                        if (position == DataSettingsActivity.this.dataUsageRow) {
                            textSettingsCell.setText(LocaleController.getString("NetworkUsage", R.string.NetworkUsage), DataSettingsActivity.this.storageNumRow != -1);
                            return;
                        }
                        if (position == DataSettingsActivity.this.storageNumRow) {
                            String absolutePath = ((File) DataSettingsActivity.this.storageDirs.get(0)).getAbsolutePath();
                            if (!TextUtils.isEmpty(SharedConfig.storageCacheDir)) {
                                int size = DataSettingsActivity.this.storageDirs.size();
                                int i = 0;
                                while (true) {
                                    if (i >= size) {
                                        break;
                                    }
                                    String absolutePath2 = ((File) DataSettingsActivity.this.storageDirs.get(i)).getAbsolutePath();
                                    if (absolutePath2.startsWith(SharedConfig.storageCacheDir)) {
                                        absolutePath = absolutePath2;
                                        break;
                                    }
                                    i++;
                                }
                            }
                            textSettingsCell.setTextAndValue(LocaleController.getString("StoragePath", R.string.StoragePath), absolutePath, false);
                            return;
                        }
                        if (position != DataSettingsActivity.this.proxyRow) {
                            if (position != DataSettingsActivity.this.resetDownloadRow) {
                                if (position != DataSettingsActivity.this.quickRepliesRow) {
                                    if (position != DataSettingsActivity.this.clearDraftsRow) {
                                        if (position != DataSettingsActivity.this.videoPlayResumeRow) {
                                            if (position == DataSettingsActivity.this.audioPlayResumeRow) {
                                                int i2 = ApplicationLoader.applicationContext.getSharedPreferences("AudioPlayerConfig", 0).getInt("playerResumeOption", 0);
                                                if (i2 == 0) {
                                                    string = LocaleController.getString("AlwaysAsk", R.string.AlwaysAsk);
                                                } else if (i2 == 1) {
                                                    string = LocaleController.getString("AlwaysResume", R.string.AlwaysResume);
                                                } else {
                                                    string = LocaleController.getString("AlwaysStartOver", R.string.AlwaysStartOver);
                                                }
                                                textSettingsCell.setTextAndValue(LocaleController.getString("AudioPlayerResumeOption", R.string.AudioPlayerResumeOption), string, true);
                                                return;
                                            }
                                            return;
                                        }
                                        int i3 = ApplicationLoader.applicationContext.getSharedPreferences("VideoPlayerConfig", 0).getInt("playerResumeOption", 0);
                                        if (i3 == 0) {
                                            string2 = LocaleController.getString("AlwaysAsk", R.string.AlwaysAsk);
                                        } else if (i3 == 1) {
                                            string2 = LocaleController.getString("AlwaysResume", R.string.AlwaysResume);
                                        } else {
                                            string2 = LocaleController.getString("AlwaysStartOver", R.string.AlwaysStartOver);
                                        }
                                        textSettingsCell.setTextAndValue(LocaleController.getString("VideoPlayerResumeOption", R.string.VideoPlayerResumeOption), string2, false);
                                        return;
                                    }
                                    textSettingsCell.setText(LocaleController.getString("PrivacyDeleteCloudDrafts", R.string.PrivacyDeleteCloudDrafts), false);
                                    return;
                                }
                                textSettingsCell.setText(LocaleController.getString("VoipQuickReplies", R.string.VoipQuickReplies), false);
                                return;
                            }
                            textSettingsCell.setCanDisable(true);
                            textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText"));
                            textSettingsCell.setText(LocaleController.getString("ResetAutomaticMediaDownload", R.string.ResetAutomaticMediaDownload), false);
                            return;
                        }
                        textSettingsCell.setText(LocaleController.getString("ProxySettings", R.string.ProxySettings), false);
                        return;
                    }
                    String string4 = null;
                    int i4 = MessagesController.getGlobalMainSettings().getInt("VoipDataSaving", VoIPHelper.getDataSavingDefault());
                    if (i4 == 0) {
                        string4 = LocaleController.getString("UseLessDataNever", R.string.UseLessDataNever);
                    } else if (i4 == 1) {
                        string4 = LocaleController.getString("UseLessDataOnMobile", R.string.UseLessDataOnMobile);
                    } else if (i4 == 2) {
                        string4 = LocaleController.getString("UseLessDataAlways", R.string.UseLessDataAlways);
                    } else if (i4 == 3) {
                        string4 = LocaleController.getString("UseLessDataOnRoaming", R.string.UseLessDataOnRoaming);
                    }
                    textSettingsCell.setTextAndValue(LocaleController.getString("VoipUseLessData", R.string.VoipUseLessData), string4, true);
                    return;
                }
                textSettingsCell.setText(LocaleController.getString("StorageUsage", R.string.StorageUsage), true);
                return;
            }
            if (itemViewType == 2) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position != DataSettingsActivity.this.mediaDownloadSectionRow) {
                    if (position != DataSettingsActivity.this.usageSectionRow) {
                        if (position != DataSettingsActivity.this.callsSectionRow) {
                            if (position != DataSettingsActivity.this.proxySectionRow) {
                                if (position != DataSettingsActivity.this.streamSectionRow) {
                                    if (position != DataSettingsActivity.this.videoPlayResumeSectionRow) {
                                        if (position != DataSettingsActivity.this.audioPlayResumeSectionRow) {
                                            if (position == DataSettingsActivity.this.autoplayHeaderRow) {
                                                headerCell.setText(LocaleController.getString("AutoplayMedia", R.string.AutoplayMedia));
                                                return;
                                            }
                                            return;
                                        }
                                        headerCell.setText(LocaleController.getString("AudioPlayerResumeOption", R.string.AudioPlayerResumeOption));
                                        return;
                                    }
                                    headerCell.setText(LocaleController.getString("VideoPlayerResumeOption", R.string.VideoPlayerResumeOption));
                                    return;
                                }
                                headerCell.setText(LocaleController.getString("Streaming", R.string.Streaming));
                                return;
                            }
                            headerCell.setText(LocaleController.getString("Proxy", R.string.Proxy));
                            return;
                        }
                        headerCell.setText(LocaleController.getString("Calls", R.string.Calls));
                        return;
                    }
                    headerCell.setText(LocaleController.getString("DataUsage", R.string.DataUsage));
                    return;
                }
                headerCell.setText(LocaleController.getString("AutomaticMediaDownload", R.string.AutomaticMediaDownload));
                return;
            }
            if (itemViewType == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                if (position == DataSettingsActivity.this.enableStreamRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("EnableStreaming", R.string.EnableStreaming), SharedConfig.streamMedia, DataSettingsActivity.this.enableAllStreamRow != -1);
                    return;
                }
                if (position == DataSettingsActivity.this.enableCacheStreamRow) {
                    return;
                }
                if (position != DataSettingsActivity.this.enableMkvRow) {
                    if (position != DataSettingsActivity.this.enableAllStreamRow) {
                        if (position != DataSettingsActivity.this.autoplayGifsRow) {
                            if (position == DataSettingsActivity.this.autoplayVideoRow) {
                                textCheckCell.setTextAndCheck(LocaleController.getString("AutoplayVideo", R.string.AutoplayVideo), SharedConfig.autoplayVideo, false);
                                return;
                            }
                            return;
                        }
                        textCheckCell.setTextAndCheck(LocaleController.getString("AutoplayGIF", R.string.AutoplayGIF), SharedConfig.autoplayGifs, true);
                        return;
                    }
                    textCheckCell.setTextAndCheck("(beta only) Stream All Videos", SharedConfig.streamAllVideo, false);
                    return;
                }
                textCheckCell.setTextAndCheck("(beta only) Show MKV as Video", SharedConfig.streamMkv, true);
                return;
            }
            if (itemViewType == 4) {
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
                if (position == DataSettingsActivity.this.enableAllStreamInfoRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("EnableAllStreamingInfo", R.string.EnableAllStreamingInfo));
                    return;
                }
                return;
            }
            if (itemViewType != 5) {
                return;
            }
            NotificationsCheckCell notificationsCheckCell2 = (NotificationsCheckCell) holder.itemView;
            StringBuilder sb = new StringBuilder();
            if (position != DataSettingsActivity.this.mobileRow) {
                if (position == DataSettingsActivity.this.wifiRow) {
                    string3 = LocaleController.getString("WhenConnectedOnWiFi", R.string.WhenConnectedOnWiFi);
                    z = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).wifiPreset.enabled;
                    currentRoamingPreset = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).getCurrentWiFiPreset();
                } else {
                    string3 = LocaleController.getString("WhenRoaming", R.string.WhenRoaming);
                    z = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).roamingPreset.enabled;
                    currentRoamingPreset = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).getCurrentRoamingPreset();
                }
            } else {
                string3 = LocaleController.getString("WhenUsingMobileData", R.string.WhenUsingMobileData);
                z = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).mobilePreset.enabled;
                currentRoamingPreset = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).getCurrentMobilePreset();
            }
            String str2 = string3;
            int i5 = 0;
            boolean z2 = false;
            int i6 = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                int[] iArr = currentRoamingPreset.mask;
                if (i5 >= iArr.length) {
                    break;
                }
                if (!z2 && (iArr[i5] & 1) != 0) {
                    i6++;
                    z2 = true;
                }
                if (!z3 && (iArr[i5] & 4) != 0) {
                    i6++;
                    z3 = true;
                }
                if (!z4 && (iArr[i5] & 8) != 0) {
                    i6++;
                    z4 = true;
                }
                i5++;
            }
            if (!currentRoamingPreset.enabled || i6 == 0) {
                notificationsCheckCell = notificationsCheckCell2;
                str = str2;
                sb.append(LocaleController.getString("NoMediaAutoDownload", R.string.NoMediaAutoDownload));
            } else {
                if (z2) {
                    sb.append(LocaleController.getString("AutoDownloadPhotosOn", R.string.AutoDownloadPhotosOn));
                }
                if (z3) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("AutoDownloadVideosOn", R.string.AutoDownloadVideosOn));
                    notificationsCheckCell = notificationsCheckCell2;
                    str = str2;
                    sb.append(String.format(" (%1$s)", AndroidUtilities.formatFileSize(currentRoamingPreset.sizes[DownloadController.typeToIndex(4)], true)));
                } else {
                    notificationsCheckCell = notificationsCheckCell2;
                    str = str2;
                }
                if (z4) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("AutoDownloadFilesOn", R.string.AutoDownloadFilesOn));
                    sb.append(String.format(" (%1$s)", AndroidUtilities.formatFileSize(currentRoamingPreset.sizes[DownloadController.typeToIndex(8)], true)));
                }
            }
            notificationsCheckCell.setTextAndValueAndCheck(str, sb, (z2 || z3 || z4) && z, 0, true, true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) holder.itemView;
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != DataSettingsActivity.this.enableCacheStreamRow) {
                    if (adapterPosition != DataSettingsActivity.this.enableStreamRow) {
                        if (adapterPosition != DataSettingsActivity.this.enableAllStreamRow) {
                            if (adapterPosition != DataSettingsActivity.this.enableMkvRow) {
                                if (adapterPosition != DataSettingsActivity.this.autoplayGifsRow) {
                                    if (adapterPosition == DataSettingsActivity.this.autoplayVideoRow) {
                                        textCheckCell.setChecked(SharedConfig.autoplayVideo);
                                        return;
                                    }
                                    return;
                                }
                                textCheckCell.setChecked(SharedConfig.autoplayGifs);
                                return;
                            }
                            textCheckCell.setChecked(SharedConfig.streamMkv);
                            return;
                        }
                        textCheckCell.setChecked(SharedConfig.streamAllVideo);
                        return;
                    }
                    textCheckCell.setChecked(SharedConfig.streamMedia);
                    return;
                }
                textCheckCell.setChecked(SharedConfig.saveStreamMedia);
            }
        }

        public boolean isRowEnabled(int position) {
            if (position != DataSettingsActivity.this.resetDownloadRow) {
                return position == DataSettingsActivity.this.mobileRow || position == DataSettingsActivity.this.roamingRow || position == DataSettingsActivity.this.wifiRow || position == DataSettingsActivity.this.storageUsageRow || position == DataSettingsActivity.this.useLessDataForCallsRow || position == DataSettingsActivity.this.dataUsageRow || position == DataSettingsActivity.this.clearDraftsRow || position == DataSettingsActivity.this.enableCacheStreamRow || position == DataSettingsActivity.this.enableStreamRow || position == DataSettingsActivity.this.enableAllStreamRow || position == DataSettingsActivity.this.enableMkvRow || position == DataSettingsActivity.this.quickRepliesRow || position == DataSettingsActivity.this.autoplayVideoRow || position == DataSettingsActivity.this.autoplayGifsRow || position == DataSettingsActivity.this.storageNumRow;
            }
            DownloadController downloadController = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount);
            return (downloadController.lowPreset.equals(downloadController.getCurrentRoamingPreset()) && downloadController.lowPreset.isEnabled() == downloadController.roamingPreset.enabled && downloadController.mediumPreset.equals(downloadController.getCurrentMobilePreset()) && downloadController.mediumPreset.isEnabled() == downloadController.mobilePreset.enabled && downloadController.highPreset.equals(downloadController.getCurrentWiFiPreset()) && downloadController.highPreset.isEnabled() == downloadController.wifiPreset.enabled) ? false : true;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return isRowEnabled(holder.getAdapterPosition());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View shadowSectionCell;
            if (viewType == 0) {
                shadowSectionCell = new ShadowSectionCell(this.mContext);
            } else if (viewType == 1) {
                shadowSectionCell = new TextSettingsCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 2) {
                shadowSectionCell = new HeaderCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 3) {
                shadowSectionCell = new TextCheckCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else if (viewType == 4) {
                shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
            } else {
                shadowSectionCell = new NotificationsCheckCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == DataSettingsActivity.this.mediaDownloadSection2Row || position == DataSettingsActivity.this.videoPlayResumeSection2Row || position == DataSettingsActivity.this.audioPlayResumeSection2Row || position == DataSettingsActivity.this.usageSection2Row || position == DataSettingsActivity.this.callsSection2Row || position == DataSettingsActivity.this.autoplaySectionRow || position == DataSettingsActivity.this.clearDraftsSectionRow) {
                return 0;
            }
            if (position == DataSettingsActivity.this.mediaDownloadSectionRow || position == DataSettingsActivity.this.videoPlayResumeSectionRow || position == DataSettingsActivity.this.audioPlayResumeSectionRow || position == DataSettingsActivity.this.streamSectionRow || position == DataSettingsActivity.this.callsSectionRow || position == DataSettingsActivity.this.usageSectionRow || position == DataSettingsActivity.this.autoplayHeaderRow) {
                return 2;
            }
            if (position == DataSettingsActivity.this.enableCacheStreamRow || position == DataSettingsActivity.this.enableStreamRow || position == DataSettingsActivity.this.enableAllStreamRow || position == DataSettingsActivity.this.enableMkvRow || position == DataSettingsActivity.this.autoplayGifsRow || position == DataSettingsActivity.this.autoplayVideoRow) {
                return 3;
            }
            if (position == DataSettingsActivity.this.enableAllStreamInfoRow) {
                return 4;
            }
            return (position == DataSettingsActivity.this.mobileRow || position == DataSettingsActivity.this.wifiRow || position == DataSettingsActivity.this.roamingRow) ? 5 : 1;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, TextCheckCell.class, HeaderCell.class, NotificationsCheckCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        return arrayList;
    }
}
