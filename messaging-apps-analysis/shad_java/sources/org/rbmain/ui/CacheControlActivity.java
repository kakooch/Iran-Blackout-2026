package org.rbmain.ui;

import android.animation.TimeInterpolator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.CacheControlActivity;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.TextCheckBoxCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SlideChooseView;
import org.rbmain.ui.Components.UndoView;
import org.rbmain.ui.StorageDiagramView;

/* loaded from: classes4.dex */
public class CacheControlActivity extends BaseFragment {
    private View actionTextView;
    private BottomSheet bottomSheet;
    private View bottomSheetView;
    private int cacheInfoRow;
    private UndoView cacheRemovedTooltip;
    private int databaseInfoRow;
    private int databaseRow;
    private int deviseStorageHeaderRow;
    long fragmentCreateTime;
    private int keepMediaChooserRow;
    private int keepMediaHeaderRow;
    private int keepMediaInfoRow;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int rowCount;
    private int storageUsageRow;
    private long databaseSize = -1;
    private long cacheSize = -1;
    private long documentsSize = -1;
    private long audioSize = -1;
    private long musicSize = -1;
    private long photoSize = -1;
    private long videoSize = -1;
    private long stickersSize = -1;
    private long totalSize = -1;
    private long totalDeviceSize = -1;
    private long totalDeviceFreeSize = -1;
    private StorageDiagramView.ClearViewData[] clearViewData = new StorageDiagramView.ClearViewData[7];
    private boolean calculating = true;
    private volatile boolean canceled = false;

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.keepMediaHeaderRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.keepMediaChooserRow = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.keepMediaInfoRow = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.deviseStorageHeaderRow = i3;
        int i5 = i4 + 1;
        this.rowCount = i5;
        this.storageUsageRow = i4;
        this.rowCount = i5 + 1;
        this.cacheInfoRow = i5;
        this.databaseRow = -1;
        this.databaseInfoRow = -1;
        this.databaseSize = MessagesStorage.getInstance(this.currentAccount).getDatabaseSize();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onFragmentCreate$1();
            }
        });
        this.fragmentCreateTime = System.currentTimeMillis();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFragmentCreate$1() {
        File file;
        long blockSize;
        long availableBlocks;
        long blockCount;
        int i = 0;
        this.cacheSize = getDirectorySize(FileLoader.checkDirectory(4), 0);
        if (this.canceled) {
            return;
        }
        this.photoSize = getDirectorySize(FileLoader.checkDirectory(0), 0);
        if (this.canceled) {
            return;
        }
        this.videoSize = getDirectorySize(FileLoader.checkDirectory(2), 0);
        if (this.canceled) {
            return;
        }
        this.documentsSize = getDirectorySize(FileLoader.checkDirectory(3), 1);
        if (this.canceled) {
            return;
        }
        this.musicSize = getDirectorySize(FileLoader.checkDirectory(3), 2);
        if (this.canceled) {
            return;
        }
        this.stickersSize = getDirectorySize(new File(FileLoader.checkDirectory(4), "acache"), 0);
        if (this.canceled) {
            return;
        }
        long directorySize = getDirectorySize(FileLoader.checkDirectory(1), 0);
        this.audioSize = directorySize;
        this.totalSize = this.cacheSize + this.videoSize + directorySize + this.photoSize + this.documentsSize + this.musicSize + this.stickersSize;
        if (Build.VERSION.SDK_INT >= 19) {
            ArrayList<File> rootDirs = AndroidUtilities.getRootDirs();
            file = rootDirs.get(0);
            file.getAbsolutePath();
            if (!TextUtils.isEmpty(SharedConfig.storageCacheDir)) {
                int size = rootDirs.size();
                while (true) {
                    if (i < size) {
                        File file2 = rootDirs.get(i);
                        if (file2.getAbsolutePath().startsWith(SharedConfig.storageCacheDir)) {
                            file = file2;
                            break;
                        }
                        i++;
                    }
                }
            }
        } else {
            file = new File(SharedConfig.storageCacheDir);
        }
        try {
            StatFs statFs = new StatFs(file.getPath());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 18) {
                blockSize = statFs.getBlockSizeLong();
            } else {
                blockSize = statFs.getBlockSize();
            }
            if (i2 >= 18) {
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                availableBlocks = statFs.getAvailableBlocks();
            }
            if (i2 >= 18) {
                blockCount = statFs.getBlockCountLong();
            } else {
                blockCount = statFs.getBlockCount();
            }
            this.totalDeviceSize = blockCount * blockSize;
            this.totalDeviceFreeSize = availableBlocks * blockSize;
        } catch (Exception e) {
            FileLog.e(e);
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onFragmentCreate$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFragmentCreate$0() {
        this.calculating = false;
        updateStorageUsageRow();
    }

    private void updateStorageUsageRow() {
        View viewFindViewByPosition = this.layoutManager.findViewByPosition(this.storageUsageRow);
        if (viewFindViewByPosition instanceof StroageUsageView) {
            StroageUsageView stroageUsageView = (StroageUsageView) viewFindViewByPosition;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Build.VERSION.SDK_INT >= 19 && jCurrentTimeMillis - this.fragmentCreateTime > 250) {
                TransitionSet transitionSet = new TransitionSet();
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.setDuration(250L);
                changeBounds.excludeTarget((View) stroageUsageView.legendLayout, true);
                Fade fade = new Fade(1);
                fade.setDuration(290L);
                transitionSet.addTransition(new Fade(2).setDuration(250L)).addTransition(changeBounds).addTransition(fade);
                transitionSet.setOrdering(0);
                transitionSet.setInterpolator((TimeInterpolator) CubicBezierInterpolator.EASE_OUT);
                TransitionManager.beginDelayedTransition(this.listView, transitionSet);
            }
            stroageUsageView.setStorageUsage(this.calculating, this.databaseSize, this.totalSize, this.totalDeviceFreeSize, this.totalDeviceSize);
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.listView.findViewHolderForAdapterPosition(this.storageUsageRow);
            if (viewHolderFindViewHolderForAdapterPosition != null) {
                stroageUsageView.setEnabled(this.listAdapter.isEnabled(viewHolderFindViewHolderForAdapterPosition));
                return;
            }
            return;
        }
        this.listAdapter.notifyDataSetChanged();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.canceled = true;
    }

    private long getDirectorySize(File file, int i) {
        if (file == null || this.canceled) {
            return 0L;
        }
        if (file.isDirectory()) {
            return Utilities.getDirSize(file.getAbsolutePath(), i, false);
        }
        if (file.isFile()) {
            return 0 + file.length();
        }
        return 0L;
    }

    private void cleanupFolders() {
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCancel(false);
        alertDialog.showDelayed(500L);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanupFolders$3(alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$cleanupFolders$3(final org.rbmain.ui.ActionBar.AlertDialog r17) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.CacheControlActivity.lambda$cleanupFolders$3(org.rbmain.ui.ActionBar.AlertDialog):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanupFolders$2(boolean z, AlertDialog alertDialog, long j) {
        if (z) {
            ImageLoader.getInstance().clearMemory();
        }
        if (this.listAdapter != null) {
            updateStorageUsageRow();
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.cacheRemovedTooltip.setInfoText(LocaleController.formatString("CacheWasCleared", R.string.CacheWasCleared, AndroidUtilities.formatFileSize(j)));
        this.cacheRemovedTooltip.showWithAction(0L, 19, null, null);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("StorageUsage", R.string.StorageUsage));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.CacheControlActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    CacheControlActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda10
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$6(context, view, i);
            }
        });
        UndoView undoView = new UndoView(context);
        this.cacheRemovedTooltip = undoView;
        frameLayout2.addView(undoView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(Context context, View view, int i) {
        long j;
        String string;
        int i2;
        if (getParentActivity() == null) {
            return;
        }
        if (i == this.databaseRow) {
            clearDatabase();
            return;
        }
        if (i == this.storageUsageRow) {
            long j2 = 0;
            if (this.totalSize <= 0 || getParentActivity() == null) {
                return;
            }
            BottomSheet bottomSheet = new BottomSheet(this, getParentActivity(), false) { // from class: org.rbmain.ui.CacheControlActivity.2
                @Override // org.rbmain.ui.ActionBar.BottomSheet
                protected boolean canDismissWithSwipe() {
                    return false;
                }
            };
            this.bottomSheet = bottomSheet;
            bottomSheet.setAllowNestedScroll(true);
            this.bottomSheet.setApplyBottomPadding(false);
            LinearLayout linearLayout = new LinearLayout(getParentActivity());
            this.bottomSheetView = linearLayout;
            linearLayout.setOrientation(1);
            StorageDiagramView storageDiagramView = new StorageDiagramView(context);
            linearLayout.addView(storageDiagramView, LayoutHelper.createLinear(-2, -2, 1, 0, 16, 0, 16));
            int i3 = 0;
            CheckBoxCell checkBoxCell = null;
            while (i3 < 7) {
                if (i3 == 0) {
                    j = this.photoSize;
                    string = LocaleController.getString("LocalPhotoCache", R.string.LocalPhotoCache);
                    i2 = Theme.key_statisticChartLine_blue;
                } else if (i3 == 1) {
                    j = this.videoSize;
                    string = LocaleController.getString("LocalVideoCache", R.string.LocalVideoCache);
                    i2 = Theme.key_statisticChartLine_golden;
                } else if (i3 == 2) {
                    j = this.documentsSize;
                    string = LocaleController.getString("LocalDocumentCache", R.string.LocalDocumentCache);
                    i2 = Theme.key_statisticChartLine_green;
                } else if (i3 == 3) {
                    j = this.musicSize;
                    string = LocaleController.getString("LocalMusicCache", R.string.LocalMusicCache);
                    i2 = Theme.key_statisticChartLine_indigo;
                } else if (i3 == 4) {
                    j = this.audioSize;
                    string = LocaleController.getString("LocalAudioCache", R.string.LocalAudioCache);
                    i2 = Theme.key_statisticChartLine_red;
                } else if (i3 == 5) {
                    j = this.stickersSize;
                    string = LocaleController.getString("AnimatedStickers", R.string.AnimatedStickers);
                    i2 = Theme.key_statisticChartLine_lightgreen;
                } else if (i3 == 6) {
                    j = this.cacheSize;
                    string = LocaleController.getString("LocalCache", R.string.LocalCache);
                    i2 = Theme.key_statisticChartLine_lightblue;
                } else {
                    j = j2;
                    string = null;
                    i2 = -1;
                }
                if (j > j2) {
                    this.clearViewData[i3] = new StorageDiagramView.ClearViewData(storageDiagramView);
                    StorageDiagramView.ClearViewData[] clearViewDataArr = this.clearViewData;
                    clearViewDataArr[i3].size = j;
                    clearViewDataArr[i3].color = i2;
                    checkBoxCell = new CheckBoxCell(getParentActivity(), 4, 21);
                    checkBoxCell.setTag(Integer.valueOf(i3));
                    checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                    linearLayout.addView(checkBoxCell, LayoutHelper.createLinear(-1, 50));
                    checkBoxCell.setText(string, AndroidUtilities.formatFileSize(j), true, true);
                    checkBoxCell.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
                    checkBoxCell.setCheckBoxColor(i2, Theme.key_windowBackgroundWhiteGrayIcon, Theme.key_checkboxCheck);
                    checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$4(view2);
                        }
                    });
                } else {
                    this.clearViewData[i3] = null;
                }
                i3++;
                j2 = 0;
            }
            if (checkBoxCell != null) {
                checkBoxCell.setNeedDivider(false);
            }
            storageDiagramView.setData(this.clearViewData);
            BottomSheet.BottomSheetCell bottomSheetCell = new BottomSheet.BottomSheetCell(getParentActivity(), 2);
            bottomSheetCell.setTextAndIcon(LocaleController.getString("ClearMediaCache", R.string.ClearMediaCache), 0);
            this.actionTextView = bottomSheetCell.getTextView();
            bottomSheetCell.getTextView().setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$5(view2);
                }
            });
            linearLayout.addView(bottomSheetCell, LayoutHelper.createLinear(-1, 50));
            NestedScrollView nestedScrollView = new NestedScrollView(context);
            nestedScrollView.setVerticalScrollBarEnabled(false);
            nestedScrollView.addView(linearLayout);
            this.bottomSheet.setCustomView(nestedScrollView);
            showDialog(this.bottomSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(View view) {
        int i = 0;
        int i2 = 0;
        while (true) {
            StorageDiagramView.ClearViewData[] clearViewDataArr = this.clearViewData;
            if (i >= clearViewDataArr.length) {
                break;
            }
            if (clearViewDataArr[i] != null && clearViewDataArr[i].clear) {
                i2++;
            }
            i++;
        }
        CheckBoxCell checkBoxCell = (CheckBoxCell) view;
        int iIntValue = ((Integer) checkBoxCell.getTag()).intValue();
        if (i2 == 1 && this.clearViewData[iIntValue].clear) {
            AndroidUtilities.shakeView(checkBoxCell.getCheckBoxView(), 2.0f, 0);
            return;
        }
        this.clearViewData[iIntValue].setClear(!r0[iIntValue].clear);
        checkBoxCell.setChecked(this.clearViewData[iIntValue].clear, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(View view) {
        try {
            Dialog dialog = this.visibleDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        cleanupFolders();
    }

    private void clearDatabase() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("LocalDatabaseClearTextTitle", R.string.LocalDatabaseClearTextTitle));
        builder.setMessage(LocaleController.getString("LocalDatabaseClearText", R.string.LocalDatabaseClearText));
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("CacheClear", R.string.CacheClear), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$clearDatabase$9(dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearDatabase$9(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCancel(false);
        alertDialog.showDelayed(500L);
        MessagesController.getInstance(this.currentAccount).clearQueryTime();
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$clearDatabase$8(alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearDatabase$8(final AlertDialog alertDialog) {
        Runnable runnable;
        try {
            try {
                getCoreMainClass().clearDataBaseAndStorageForDebug();
                runnable = new Runnable() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$clearDatabase$7(alertDialog);
                    }
                };
            } catch (Exception e) {
                FileLog.e(e);
                runnable = new Runnable() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$clearDatabase$7(alertDialog);
                    }
                };
            }
            AndroidUtilities.runOnUIThread(runnable);
        } catch (Throwable th) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$clearDatabase$7(alertDialog);
                }
            });
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearDatabase$7(AlertDialog alertDialog) {
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        if (this.listAdapter != null) {
            this.databaseSize = MessagesStorage.getInstance(this.currentAccount).getDatabaseSize();
            this.listAdapter.notifyDataSetChanged();
        }
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didClearDatabase, new Object[0]);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == CacheControlActivity.this.databaseRow || (adapterPosition == CacheControlActivity.this.storageUsageRow && CacheControlActivity.this.totalSize > 0 && !CacheControlActivity.this.calculating);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CacheControlActivity.this.rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onCreateViewHolder$0(int i) {
            if (i == 0) {
                SharedConfig.setKeepMedia(3);
                return;
            }
            if (i == 1) {
                SharedConfig.setKeepMedia(0);
            } else if (i == 2) {
                SharedConfig.setKeepMedia(1);
            } else if (i == 3) {
                SharedConfig.setKeepMedia(2);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View textSettingsCell;
            if (i == 0) {
                textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 2) {
                textSettingsCell = new StroageUsageView(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 3) {
                textSettingsCell = new HeaderCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            } else if (i == 4) {
                SlideChooseView slideChooseView = new SlideChooseView(this.mContext);
                slideChooseView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                MessagesController.getGlobalMainSettings();
                slideChooseView.setCallback(new SlideChooseView.Callback() { // from class: org.rbmain.ui.CacheControlActivity$ListAdapter$$ExternalSyntheticLambda0
                    @Override // org.rbmain.ui.Components.SlideChooseView.Callback
                    public final void onOptionSelected(int i2) {
                        CacheControlActivity.ListAdapter.lambda$onCreateViewHolder$0(i2);
                    }

                    @Override // org.rbmain.ui.Components.SlideChooseView.Callback
                    public /* synthetic */ void onTouchEnd() {
                        SlideChooseView.Callback.CC.$default$onTouchEnd(this);
                    }
                });
                int i2 = SharedConfig.keepMedia;
                slideChooseView.setOptions(i2 == 3 ? 0 : i2 + 1, LocaleController.formatPluralString("Days", 3), LocaleController.formatPluralString("Weeks", 1), LocaleController.formatPluralString("Months", 1), LocaleController.getString("KeepMediaForever", R.string.KeepMediaForever));
                textSettingsCell = slideChooseView;
            } else {
                textSettingsCell = new TextInfoPrivacyCell(this.mContext);
            }
            return new RecyclerListView.Holder(textSettingsCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) viewHolder.itemView;
                if (i == CacheControlActivity.this.databaseRow) {
                    textSettingsCell.setTextAndValue(LocaleController.getString("ClearLocalDatabase", R.string.ClearLocalDatabase), AndroidUtilities.formatFileSize(CacheControlActivity.this.databaseSize), false);
                    return;
                }
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType == 2) {
                    ((StroageUsageView) viewHolder.itemView).setStorageUsage(CacheControlActivity.this.calculating, CacheControlActivity.this.databaseSize, CacheControlActivity.this.totalSize, CacheControlActivity.this.totalDeviceFreeSize, CacheControlActivity.this.totalDeviceSize);
                    return;
                }
                if (itemViewType != 3) {
                    return;
                }
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != CacheControlActivity.this.keepMediaHeaderRow) {
                    if (i == CacheControlActivity.this.deviseStorageHeaderRow) {
                        headerCell.setText(LocaleController.getString("DeviceStorage", R.string.DeviceStorage));
                        return;
                    }
                    return;
                }
                headerCell.setText(LocaleController.getString("KeepMedia", R.string.KeepMedia));
                return;
            }
            TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) viewHolder.itemView;
            if (i != CacheControlActivity.this.databaseInfoRow) {
                if (i != CacheControlActivity.this.cacheInfoRow) {
                    if (i == CacheControlActivity.this.keepMediaInfoRow) {
                        textInfoPrivacyCell.setText(AndroidUtilities.replaceTags(LocaleController.getString("KeepMediaInfo", R.string.KeepMediaInfo)));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                        return;
                    }
                    return;
                }
                textInfoPrivacyCell.setText(BuildConfig.FLAVOR);
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                return;
            }
            textInfoPrivacyCell.setText(LocaleController.getString("LocalDatabaseInfo", R.string.LocalDatabaseInfo));
            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == CacheControlActivity.this.databaseInfoRow || i == CacheControlActivity.this.cacheInfoRow || i == CacheControlActivity.this.keepMediaInfoRow) {
                return 1;
            }
            if (i == CacheControlActivity.this.storageUsageRow) {
                return 2;
            }
            if (i == CacheControlActivity.this.keepMediaHeaderRow || i == CacheControlActivity.this.deviseStorageHeaderRow) {
                return 3;
            }
            return i == CacheControlActivity.this.keepMediaChooserRow ? 4 : 0;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.CacheControlActivity$$ExternalSyntheticLambda9
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$10();
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, SlideChooseView.class, StroageUsageView.class, HeaderCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
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
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        int i4 = Theme.key_windowBackgroundWhiteValueText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"paintFill"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_player_progressBackground));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"paintProgress"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_player_progress));
        int i5 = Theme.key_windowBackgroundWhiteGrayText;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"rubikaCacheTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"freeSizeTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"calculationgTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SlideChooseView.class}, null, null, null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SlideChooseView.class}, null, null, null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SlideChooseView.class}, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, i5));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{CheckBoxCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{CheckBoxCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{CheckBoxCell.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{StorageDiagramView.class}, null, null, null, i3));
        arrayList.add(new ThemeDescription((View) null, 0, new Class[]{TextCheckBoxCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_dialogBackground));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_blue));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_green));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_red));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_golden));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_lightblue));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_lightgreen));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_orange));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, Theme.key_statisticChartLine_indigo));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$10() {
        BottomSheet bottomSheet = this.bottomSheet;
        if (bottomSheet != null) {
            bottomSheet.setBackgroundColor(Theme.getColor(Theme.key_dialogBackground));
        }
        View view = this.actionTextView;
        if (view != null) {
            view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        }
    }
}
