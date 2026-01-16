package org.rbmain.ui;

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
import ir.medu.shad.R;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.DownloadController;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
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
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.voip.VoIPHelper;

/* loaded from: classes4.dex */
public class DataSettingsActivity extends BaseFragment {
    private int autoplayGifsRow;
    private int autoplayHeaderRow;
    private int autoplaySectionRow;
    private int autoplayVideoRow;
    private int callsSection2Row;
    private int clearDraftsRow;
    private int clearDraftsSectionRow;
    private int dataUsageRow;
    private int enableAllStreamInfoRow;
    private int enableAllStreamRow;
    private int enableCacheStreamRow;
    private int enableMkvRow;
    private int enableStreamRow;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int mediaDownloadSection2Row;
    private int mediaDownloadSectionRow;
    private int mobileRow;
    private int proxyRow;
    private int proxySection2Row;
    private int proxySectionRow;
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
    private int wifiRow;

    public DataSettingsActivity() {
        this.fragmentName = "DataSettingsActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
        this.roamingRow = -1;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.resetDownloadRow = i8;
        int i10 = i9 + 1;
        this.rowCount = i10;
        this.mediaDownloadSection2Row = i9;
        int i11 = i10 + 1;
        this.rowCount = i11;
        this.autoplayHeaderRow = i10;
        int i12 = i11 + 1;
        this.rowCount = i12;
        this.autoplayGifsRow = i11;
        int i13 = i12 + 1;
        this.rowCount = i13;
        this.autoplayVideoRow = i12;
        int i14 = i13 + 1;
        this.rowCount = i14;
        this.autoplaySectionRow = i13;
        int i15 = i14 + 1;
        this.rowCount = i15;
        this.streamSectionRow = i14;
        int i16 = i15 + 1;
        this.rowCount = i16;
        this.enableStreamRow = i15;
        boolean z = BuildVars.DEBUG_VERSION;
        this.enableAllStreamRow = -1;
        this.enableMkvRow = -1;
        this.enableAllStreamInfoRow = -1;
        this.enableCacheStreamRow = -1;
        this.useLessDataForCallsRow = -1;
        this.rowCount = i16 + 1;
        this.callsSection2Row = i16;
        this.proxySectionRow = -1;
        this.proxyRow = -1;
        this.proxySection2Row = -1;
        this.clearDraftsRow = -1;
        this.clearDraftsSectionRow = -1;
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("DataSettings", R.string.DataSettings));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.DataSettingsActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    DataSettingsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.DataSettingsActivity$$ExternalSyntheticLambda6
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
                this.f$0.lambda$createView$6(context, view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$6(android.content.Context r10, android.view.View r11, final int r12, float r13, float r14) {
        /*
            Method dump skipped, instructions count: 894
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.DataSettingsActivity.lambda$createView$6(android.content.Context, android.view.View, int, float, float):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(DialogInterface dialogInterface, int i) {
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
        editorEdit.apply();
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
        for (int i3 = 0; i3 < 3; i3++) {
            DownloadController.getInstance(this.currentAccount).savePresetToServer(i3);
        }
        this.listAdapter.notifyItemRangeChanged(this.mobileRow, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(SharedPreferences sharedPreferences, int i, DialogInterface dialogInterface, int i2) {
        int i3 = 3;
        if (i2 == 0) {
            i3 = 0;
        } else if (i2 != 1) {
            i3 = i2 != 2 ? i2 != 3 ? -1 : 2 : 1;
        }
        if (i3 != -1) {
            sharedPreferences.edit().putInt("VoipDataSaving", i3).apply();
        }
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyItemChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(String str, AlertDialog.Builder builder, View view) {
        SharedConfig.storageCacheDir = str;
        SharedConfig.saveConfig();
        ImageLoader.getInstance().checkMediaPaths();
        builder.getDismissRunnable().run();
        this.listAdapter.notifyItemChanged(this.storageNumRow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(DialogInterface dialogInterface, int i) {
        getConnectionsManager().sendRequest(new TLObject() { // from class: org.rbmain.tgnet.TLRPC$TL_messages_clearAllDrafts
            public static int constructor = 2119757468;

            @Override // org.rbmain.tgnet.TLObject
            public TLObject deserializeResponse(AbstractSerializedData abstractSerializedData, int i2, boolean z) {
                return TLRPC$Bool.TLdeserialize(abstractSerializedData, i2, z);
            }

            @Override // org.rbmain.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                abstractSerializedData.writeInt32(constructor);
            }
        }, new RequestDelegate() { // from class: org.rbmain.ui.DataSettingsActivity$$ExternalSyntheticLambda5
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$4(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3() {
        getMediaDataController().clearAllDrafts(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.DataSettingsActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$3();
            }
        });
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        DownloadController.getInstance(this.currentAccount).checkAutodownloadSettings();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            String string;
            boolean z;
            DownloadController.Preset currentRoamingPreset;
            NotificationsCheckCell notificationsCheckCell;
            String str;
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                if (i == DataSettingsActivity.this.clearDraftsSectionRow) {
                    viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                } else {
                    viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
            }
            if (itemViewType == 1) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                textSettingsCell.setCanDisable(false);
                textSettingsCell.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
                if (i != DataSettingsActivity.this.storageUsageRow) {
                    if (i != DataSettingsActivity.this.useLessDataForCallsRow) {
                        if (i == DataSettingsActivity.this.dataUsageRow) {
                            textSettingsCell.setText(LocaleController.getString("NetworkUsage", R.string.NetworkUsage), DataSettingsActivity.this.storageNumRow != -1);
                            return;
                        }
                        if (i == DataSettingsActivity.this.storageNumRow) {
                            String absolutePath = ((File) DataSettingsActivity.this.storageDirs.get(0)).getAbsolutePath();
                            if (!TextUtils.isEmpty(SharedConfig.storageCacheDir)) {
                                int size = DataSettingsActivity.this.storageDirs.size();
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= size) {
                                        break;
                                    }
                                    String absolutePath2 = ((File) DataSettingsActivity.this.storageDirs.get(i2)).getAbsolutePath();
                                    if (absolutePath2.startsWith(SharedConfig.storageCacheDir)) {
                                        absolutePath = absolutePath2;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            textSettingsCell.setTextAndValue(LocaleController.getString("StoragePath", R.string.StoragePath), absolutePath, false);
                            return;
                        }
                        if (i != DataSettingsActivity.this.proxyRow) {
                            if (i != DataSettingsActivity.this.resetDownloadRow) {
                                if (i == DataSettingsActivity.this.clearDraftsRow) {
                                    textSettingsCell.setText(LocaleController.getString("PrivacyDeleteCloudDrafts", R.string.PrivacyDeleteCloudDrafts), false);
                                    return;
                                }
                                return;
                            } else {
                                textSettingsCell.setCanDisable(true);
                                textSettingsCell.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
                                textSettingsCell.setText(LocaleController.getString("ResetAutomaticMediaDownload", R.string.ResetAutomaticMediaDownload), false);
                                return;
                            }
                        }
                        textSettingsCell.setText(LocaleController.getString("ProxySettings", R.string.ProxySettings), false);
                        return;
                    }
                    String string2 = null;
                    int i3 = MessagesController.getGlobalMainSettings().getInt("VoipDataSaving", VoIPHelper.getDataSavingDefault());
                    if (i3 == 0) {
                        string2 = LocaleController.getString("UseLessDataNever", R.string.UseLessDataNever);
                    } else if (i3 == 1) {
                        string2 = LocaleController.getString("UseLessDataOnMobile", R.string.UseLessDataOnMobile);
                    } else if (i3 == 2) {
                        string2 = LocaleController.getString("UseLessDataAlways", R.string.UseLessDataAlways);
                    } else if (i3 == 3) {
                        string2 = LocaleController.getString("UseLessDataOnRoaming", R.string.UseLessDataOnRoaming);
                    }
                    textSettingsCell.setTextAndValue(LocaleController.getString("VoipUseLessData", R.string.VoipUseLessData), string2, true);
                    return;
                }
                textSettingsCell.setText(LocaleController.getString("StorageUsage", R.string.StorageUsage), true);
                return;
            }
            if (itemViewType == 2) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != DataSettingsActivity.this.mediaDownloadSectionRow) {
                    if (i != DataSettingsActivity.this.usageSectionRow) {
                        if (i != DataSettingsActivity.this.proxySectionRow) {
                            if (i != DataSettingsActivity.this.streamSectionRow) {
                                if (i == DataSettingsActivity.this.autoplayHeaderRow) {
                                    headerCell.setText(LocaleController.getString("AutoplayMedia", R.string.AutoplayMedia));
                                    return;
                                }
                                return;
                            }
                            headerCell.setText(LocaleController.getString("Streaming", R.string.Streaming));
                            return;
                        }
                        headerCell.setText(LocaleController.getString("Proxy", R.string.Proxy));
                        return;
                    }
                    headerCell.setText(LocaleController.getString("DataUsage", R.string.DataUsage));
                    return;
                }
                headerCell.setText(LocaleController.getString("AutomaticMediaDownload", R.string.AutomaticMediaDownload));
                return;
            }
            if (itemViewType == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                if (i == DataSettingsActivity.this.enableStreamRow) {
                    textCheckCell.setTextAndCheck(LocaleController.getString("EnableStreaming", R.string.EnableStreaming), SharedConfig.streamMedia, DataSettingsActivity.this.enableAllStreamRow != -1);
                    return;
                }
                if (i == DataSettingsActivity.this.enableCacheStreamRow) {
                    return;
                }
                if (i != DataSettingsActivity.this.enableMkvRow) {
                    if (i != DataSettingsActivity.this.enableAllStreamRow) {
                        if (i != DataSettingsActivity.this.autoplayGifsRow) {
                            if (i == DataSettingsActivity.this.autoplayVideoRow) {
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
                TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
                if (i == DataSettingsActivity.this.enableAllStreamInfoRow) {
                    textInfoPrivacyCell.setText(LocaleController.getString("EnableAllStreamingInfo", R.string.EnableAllStreamingInfo));
                    return;
                }
                return;
            }
            if (itemViewType != 5) {
                return;
            }
            NotificationsCheckCell notificationsCheckCell2 = (NotificationsCheckCell) viewHolder.itemView;
            StringBuilder sb = new StringBuilder();
            if (i != DataSettingsActivity.this.mobileRow) {
                if (i == DataSettingsActivity.this.wifiRow) {
                    string = LocaleController.getString("WhenConnectedOnWiFi", R.string.WhenConnectedOnWiFi);
                    z = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).wifiPreset.enabled;
                    currentRoamingPreset = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).getCurrentWiFiPreset();
                } else {
                    string = LocaleController.getString("WhenRoaming", R.string.WhenRoaming);
                    z = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).roamingPreset.enabled;
                    currentRoamingPreset = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).getCurrentRoamingPreset();
                }
            } else {
                string = LocaleController.getString("WhenUsingMobileData", R.string.WhenUsingMobileData);
                z = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).mobilePreset.enabled;
                currentRoamingPreset = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount).getCurrentMobilePreset();
            }
            String str2 = string;
            int i4 = 0;
            boolean z2 = false;
            int i5 = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                int[] iArr = currentRoamingPreset.mask;
                if (i4 >= iArr.length) {
                    break;
                }
                if (!z2 && (iArr[i4] & 1) != 0) {
                    i5++;
                    z2 = true;
                }
                if (!z3 && (iArr[i4] & 4) != 0) {
                    i5++;
                    z3 = true;
                }
                if (!z4 && (iArr[i4] & 8) != 0) {
                    i5++;
                    z4 = true;
                }
                i4++;
            }
            if (!currentRoamingPreset.enabled || i5 == 0) {
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
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() == 3) {
                TextCheckCell textCheckCell = (TextCheckCell) viewHolder.itemView;
                int adapterPosition = viewHolder.getAdapterPosition();
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

        public boolean isRowEnabled(int i) {
            if (i != DataSettingsActivity.this.resetDownloadRow) {
                return i == DataSettingsActivity.this.mobileRow || i == DataSettingsActivity.this.roamingRow || i == DataSettingsActivity.this.wifiRow || i == DataSettingsActivity.this.storageUsageRow || i == DataSettingsActivity.this.useLessDataForCallsRow || i == DataSettingsActivity.this.dataUsageRow || i == DataSettingsActivity.this.proxyRow || i == DataSettingsActivity.this.clearDraftsRow || i == DataSettingsActivity.this.enableCacheStreamRow || i == DataSettingsActivity.this.enableStreamRow || i == DataSettingsActivity.this.enableAllStreamRow || i == DataSettingsActivity.this.enableMkvRow || i == DataSettingsActivity.this.autoplayVideoRow || i == DataSettingsActivity.this.autoplayGifsRow || i == DataSettingsActivity.this.storageNumRow;
            }
            DownloadController downloadController = DownloadController.getInstance(((BaseFragment) DataSettingsActivity.this).currentAccount);
            return (downloadController.lowPreset.equals(downloadController.getCurrentRoamingPreset()) && downloadController.lowPreset.isEnabled() == downloadController.roamingPreset.enabled && downloadController.mediumPreset.equals(downloadController.getCurrentMobilePreset()) && downloadController.mediumPreset.isEnabled() == downloadController.mobilePreset.enabled && downloadController.highPreset.equals(downloadController.getCurrentWiFiPreset()) && downloadController.highPreset.isEnabled() == downloadController.wifiPreset.enabled) ? false : true;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return isRowEnabled(viewHolder.getAdapterPosition());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shadowSectionCell;
            if (i == 0) {
                shadowSectionCell = new ShadowSectionCell(this.mContext);
            } else if (i == 1) {
                shadowSectionCell = new TextSettingsCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 2) {
                shadowSectionCell = new HeaderCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 3) {
                shadowSectionCell = new TextCheckCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 4) {
                shadowSectionCell = new TextInfoPrivacyCell(this.mContext);
                shadowSectionCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
            } else {
                shadowSectionCell = new NotificationsCheckCell(this.mContext);
                shadowSectionCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            }
            shadowSectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == DataSettingsActivity.this.mediaDownloadSection2Row || i == DataSettingsActivity.this.usageSection2Row || i == DataSettingsActivity.this.callsSection2Row || i == DataSettingsActivity.this.proxySection2Row || i == DataSettingsActivity.this.autoplaySectionRow || i == DataSettingsActivity.this.clearDraftsSectionRow) {
                return 0;
            }
            if (i == DataSettingsActivity.this.mediaDownloadSectionRow || i == DataSettingsActivity.this.streamSectionRow || i == DataSettingsActivity.this.usageSectionRow || i == DataSettingsActivity.this.proxySectionRow || i == DataSettingsActivity.this.autoplayHeaderRow) {
                return 2;
            }
            if (i == DataSettingsActivity.this.enableCacheStreamRow || i == DataSettingsActivity.this.enableStreamRow || i == DataSettingsActivity.this.enableAllStreamRow || i == DataSettingsActivity.this.enableMkvRow || i == DataSettingsActivity.this.autoplayGifsRow || i == DataSettingsActivity.this.autoplayVideoRow) {
                return 3;
            }
            if (i == DataSettingsActivity.this.enableAllStreamInfoRow) {
                return 4;
            }
            return (i == DataSettingsActivity.this.mobileRow || i == DataSettingsActivity.this.wifiRow || i == DataSettingsActivity.this.roamingRow) ? 5 : 1;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, TextCheckCell.class, HeaderCell.class, NotificationsCheckCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        int i4 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i5 = Theme.key_switchTrack;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        int i6 = Theme.key_switchTrackChecked;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{NotificationsCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        int i7 = Theme.key_windowBackgroundGrayShadow;
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteValueText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        return arrayList;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        getContactProxy().saveDataSettings();
    }
}
