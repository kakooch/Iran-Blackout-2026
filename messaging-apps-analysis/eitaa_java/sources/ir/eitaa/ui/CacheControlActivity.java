package ir.eitaa.ui;

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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.CacheControlActivity;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.TextCheckBoxCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SlideChooseView;
import ir.eitaa.ui.Components.StorageDiagramView;
import ir.eitaa.ui.Components.StroageUsageView;
import ir.eitaa.ui.Components.UndoView;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes3.dex */
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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
        int i6 = i5 + 1;
        this.rowCount = i6;
        this.cacheInfoRow = i5;
        int i7 = i6 + 1;
        this.rowCount = i7;
        this.databaseRow = i6;
        this.rowCount = i7 + 1;
        this.databaseInfoRow = i7;
        this.databaseSize = MessagesStorage.getInstance(this.currentAccount).getDatabaseSize();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$w2eEbm-j-H5PB6bCDyn1k7w6XeU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onFragmentCreate$1$CacheControlActivity();
            }
        });
        this.fragmentCreateTime = System.currentTimeMillis();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onFragmentCreate$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onFragmentCreate$1$CacheControlActivity() {
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
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$tIx7cVwCg--C1sjQ_vz8uVAVgXk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onFragmentCreate$0$CacheControlActivity();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onFragmentCreate$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onFragmentCreate$0$CacheControlActivity() {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        this.canceled = true;
    }

    private long getDirectorySize(File dir, int documentsMusicType) {
        if (dir == null || this.canceled) {
            return 0L;
        }
        if (dir.isDirectory()) {
            return Utilities.getDirSize(dir.getAbsolutePath(), documentsMusicType, false);
        }
        if (dir.isFile()) {
            return 0 + dir.length();
        }
        return 0L;
    }

    private void cleanupFolders() {
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.showDelayed(500L);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$taeCEPM7XW-1mdpSKV0ttu934cU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$cleanupFolders$3$CacheControlActivity(alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e1 A[SYNTHETIC] */
    /* renamed from: lambda$cleanupFolders$3, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$cleanupFolders$3$CacheControlActivity(final ir.eitaa.ui.ActionBar.AlertDialog r17) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.CacheControlActivity.lambda$cleanupFolders$3$CacheControlActivity(ir.eitaa.ui.ActionBar.AlertDialog):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$cleanupFolders$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$cleanupFolders$2$CacheControlActivity(boolean z, AlertDialog alertDialog, long j) {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("StorageUsage", R.string.StorageUsage));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.CacheControlActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    CacheControlActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$tWkshhiyBRaEudVGdS_910O40DY
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$createView$6$CacheControlActivity(context, view, i);
            }
        });
        UndoView undoView = new UndoView(context);
        this.cacheRemovedTooltip = undoView;
        frameLayout2.addView(undoView, LayoutHelper.createFrame(-1, -2.0f, 83, 8.0f, 0.0f, 8.0f, 8.0f));
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$CacheControlActivity(Context context, View view, int i) {
        long j;
        String string;
        String str;
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
            BottomSheet bottomSheet = new BottomSheet(getParentActivity(), false) { // from class: ir.eitaa.ui.CacheControlActivity.2
                @Override // ir.eitaa.ui.ActionBar.BottomSheet
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
            CheckBoxCell checkBoxCell = null;
            int i2 = 0;
            while (i2 < 7) {
                if (i2 == 0) {
                    j = this.photoSize;
                    string = LocaleController.getString("LocalPhotoCache", R.string.LocalPhotoCache);
                    str = "statisticChartLine_blue";
                } else if (i2 == 1) {
                    j = this.videoSize;
                    string = LocaleController.getString("LocalVideoCache", R.string.LocalVideoCache);
                    str = "statisticChartLine_golden";
                } else if (i2 == 2) {
                    j = this.documentsSize;
                    string = LocaleController.getString("LocalDocumentCache", R.string.LocalDocumentCache);
                    str = "statisticChartLine_green";
                } else if (i2 == 3) {
                    j = this.musicSize;
                    string = LocaleController.getString("LocalMusicCache", R.string.LocalMusicCache);
                    str = "statisticChartLine_indigo";
                } else if (i2 == 4) {
                    j = this.audioSize;
                    string = LocaleController.getString("LocalAudioCache", R.string.LocalAudioCache);
                    str = "statisticChartLine_red";
                } else if (i2 == 5) {
                    j = this.stickersSize;
                    string = LocaleController.getString("AnimatedStickers", R.string.AnimatedStickers);
                    str = "statisticChartLine_lightgreen";
                } else {
                    j = this.cacheSize;
                    string = LocaleController.getString("LocalCache", R.string.LocalCache);
                    str = "statisticChartLine_lightblue";
                }
                if (j > j2) {
                    this.clearViewData[i2] = new StorageDiagramView.ClearViewData(storageDiagramView);
                    StorageDiagramView.ClearViewData[] clearViewDataArr = this.clearViewData;
                    clearViewDataArr[i2].size = j;
                    clearViewDataArr[i2].color = str;
                    checkBoxCell = new CheckBoxCell(getParentActivity(), 4, 21, null);
                    checkBoxCell.setTag(Integer.valueOf(i2));
                    checkBoxCell.setBackgroundDrawable(Theme.getSelectorDrawable(false));
                    linearLayout.addView(checkBoxCell, LayoutHelper.createLinear(-1, 50));
                    checkBoxCell.setText(string, AndroidUtilities.formatFileSize(j), true, true);
                    checkBoxCell.setTextColor(Theme.getColor("dialogTextBlack"));
                    checkBoxCell.setCheckBoxColor(str, "windowBackgroundWhiteGrayIcon", "checkboxCheck");
                    checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$sHnQMld2kKg_TQ0bxbzJkptsIvA
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$createView$4$CacheControlActivity(view2);
                        }
                    });
                } else {
                    this.clearViewData[i2] = null;
                }
                i2++;
                j2 = 0;
            }
            if (checkBoxCell != null) {
                checkBoxCell.setNeedDivider(false);
            }
            storageDiagramView.setData(this.clearViewData);
            BottomSheet.BottomSheetCell bottomSheetCell = new BottomSheet.BottomSheetCell(getParentActivity(), 2);
            bottomSheetCell.setTextAndIcon(LocaleController.getString("ClearMediaCache", R.string.ClearMediaCache), 0);
            this.actionTextView = bottomSheetCell.getTextView();
            bottomSheetCell.getTextView().setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$iAQo0qCQv9DThLvZ85VLJcf6jMc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$5$CacheControlActivity(view2);
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
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$CacheControlActivity(View view) {
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
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$CacheControlActivity(View view) {
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
        builder.setPositiveButton(LocaleController.getString("CacheClear", R.string.CacheClear), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$oDhH_HdVwZT-6uL9lJQ32kZz4Qw
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$clearDatabase$9$CacheControlActivity(dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearDatabase$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearDatabase$9$CacheControlActivity(DialogInterface dialogInterface, int i) {
        if (getParentActivity() == null) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.showDelayed(500L);
        MessagesController.getInstance(this.currentAccount).clearQueryTime();
        MessagesStorage.getInstance(this.currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$V2iI0LNYrt8o7zY6jL17W02Pzww
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$clearDatabase$8$CacheControlActivity(alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01e6 A[Catch: all -> 0x023c, Exception -> 0x0240, TryCatch #0 {Exception -> 0x0240, blocks: (B:12:0x004f, B:17:0x0079, B:50:0x01f9, B:20:0x0084, B:22:0x00a1, B:43:0x0119, B:44:0x011c, B:46:0x01e6, B:49:0x01f6, B:51:0x0203), top: B:67:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f0  */
    /* renamed from: lambda$clearDatabase$8, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$clearDatabase$8$CacheControlActivity(final ir.eitaa.ui.ActionBar.AlertDialog r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.CacheControlActivity.lambda$clearDatabase$8$CacheControlActivity(ir.eitaa.ui.ActionBar.AlertDialog):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$clearDatabase$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$clearDatabase$7$CacheControlActivity(AlertDialog alertDialog) {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return adapterPosition == CacheControlActivity.this.databaseRow || (adapterPosition == CacheControlActivity.this.storageUsageRow && CacheControlActivity.this.totalSize > 0 && !CacheControlActivity.this.calculating);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return CacheControlActivity.this.rowCount;
        }

        static /* synthetic */ void lambda$onCreateViewHolder$0(int i) {
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            FrameLayout textInfoPrivacyCell;
            if (i == 0) {
                FrameLayout textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = textSettingsCell;
            } else if (i == 2) {
                FrameLayout stroageUsageView = new StroageUsageView(this.mContext);
                stroageUsageView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = stroageUsageView;
            } else if (i == 3) {
                FrameLayout headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                frameLayout = headerCell;
            } else if (i == 4) {
                SlideChooseView slideChooseView = new SlideChooseView(this.mContext);
                slideChooseView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                MessagesController.getGlobalMainSettings();
                slideChooseView.setCallback(new SlideChooseView.Callback() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$ListAdapter$7FTNhk5niCmZ4L-U-mKyj8nD5e0
                    @Override // ir.eitaa.ui.Components.SlideChooseView.Callback
                    public final void onOptionSelected(int i2) {
                        CacheControlActivity.ListAdapter.lambda$onCreateViewHolder$0(i2);
                    }

                    @Override // ir.eitaa.ui.Components.SlideChooseView.Callback
                    public /* synthetic */ void onTouchEnd() {
                        SlideChooseView.Callback.CC.$default$onTouchEnd(this);
                    }
                });
                int i2 = SharedConfig.keepMedia;
                slideChooseView.setOptions(i2 == 3 ? 0 : i2 + 1, LocaleController.formatPluralString("Days", 3), LocaleController.formatPluralString("Weeks", 1), LocaleController.formatPluralString("Months", 1), LocaleController.getString("KeepMediaForever", R.string.KeepMediaForever));
                frameLayout = slideChooseView;
            } else {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
                return new RecyclerListView.Holder(textInfoPrivacyCell);
            }
            textInfoPrivacyCell = frameLayout;
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                TextSettingsCell textSettingsCell = (TextSettingsCell) holder.itemView;
                if (position == CacheControlActivity.this.databaseRow) {
                    textSettingsCell.setTextAndValue(LocaleController.getString("ClearLocalDatabase", R.string.ClearLocalDatabase), AndroidUtilities.formatFileSize(CacheControlActivity.this.databaseSize), false);
                    return;
                }
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType == 2) {
                    ((StroageUsageView) holder.itemView).setStorageUsage(CacheControlActivity.this.calculating, CacheControlActivity.this.databaseSize, CacheControlActivity.this.totalSize, CacheControlActivity.this.totalDeviceFreeSize, CacheControlActivity.this.totalDeviceSize);
                    return;
                }
                if (itemViewType != 3) {
                    return;
                }
                HeaderCell headerCell = (HeaderCell) holder.itemView;
                if (position != CacheControlActivity.this.keepMediaHeaderRow) {
                    if (position == CacheControlActivity.this.deviseStorageHeaderRow) {
                        headerCell.setText(LocaleController.getString("DeviceStorage", R.string.DeviceStorage));
                        return;
                    }
                    return;
                }
                headerCell.setText(LocaleController.getString("KeepMedia", R.string.KeepMedia));
                return;
            }
            TextInfoPrivacyCell textInfoPrivacyCell = (TextInfoPrivacyCell) holder.itemView;
            if (position != CacheControlActivity.this.databaseInfoRow) {
                if (position != CacheControlActivity.this.cacheInfoRow) {
                    if (position == CacheControlActivity.this.keepMediaInfoRow) {
                        textInfoPrivacyCell.setText(AndroidUtilities.replaceTags(LocaleController.getString("KeepMediaInfo", R.string.KeepMediaInfo)));
                        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                        return;
                    }
                    return;
                }
                textInfoPrivacyCell.setText("");
                textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                return;
            }
            textInfoPrivacyCell.setText(LocaleController.getString("LocalDatabaseInfo", R.string.LocalDatabaseInfo));
            textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CacheControlActivity$3Ins1PQeMtBaQsMWQShF4uSpgYU
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$10$CacheControlActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, SlideChooseView.class, StroageUsageView.class, HeaderCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"paintFill"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progressBackground"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"paintProgress"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progress"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"eitaaCacheTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"freeSizeTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"calculationgTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{StroageUsageView.class}, new String[]{"paintProgress2"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "player_progressBackground2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SlideChooseView.class}, null, null, null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SlideChooseView.class}, null, null, null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{SlideChooseView.class}, null, null, null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{CheckBoxCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{CheckBoxCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{CheckBoxCell.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, new Class[]{StorageDiagramView.class}, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription((View) null, 0, new Class[]{TextCheckBoxCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_blue"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_green"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_red"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_golden"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_lightblue"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_lightgreen"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_orange"));
        arrayList.add(new ThemeDescription(this.bottomSheetView, 0, null, null, null, null, "statisticChartLine_indigo"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$10$CacheControlActivity() {
        BottomSheet bottomSheet = this.bottomSheet;
        if (bottomSheet != null) {
            bottomSheet.setBackgroundColor(Theme.getColor("dialogBackground"));
        }
        View view = this.actionTextView;
        if (view != null) {
            view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        }
    }
}
