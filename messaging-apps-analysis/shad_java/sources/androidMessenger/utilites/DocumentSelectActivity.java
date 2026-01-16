package androidMessenger.utilites;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Environment;
import android.os.StatFs;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidMessenger.utilites.DocumentSelectActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.rghapp.imageeditor.NumberTextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.model.FragmentType;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.SharedDocumentCell;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes.dex */
public class DocumentSelectActivity extends BaseFragment {
    private boolean canSelectOnlyImageFiles;
    private File currentDir;
    private DocumentSelectActivityDelegate delegate;
    private EmptyTextProgressView emptyView;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean scrolling;
    private NumberTextView selectedMessagesCountTextView;
    private ArrayList<ListItem> items = new ArrayList<>();
    private boolean receiverRegistered = false;
    private ArrayList<HistoryEntry> history = new ArrayList<>();
    private HashMap<String, ListItem> selectedFiles = new HashMap<>();
    private ArrayList<View> actionModeViews = new ArrayList<>();
    private ArrayList<ListItem> recentItems = new ArrayList<>();
    private int maxSelectedFiles = -1;
    private BroadcastReceiver receiver = new AnonymousClass1();

    public interface DocumentSelectActivityDelegate {
        void didSelectFiles(DocumentSelectActivity documentSelectActivity, ArrayList<String> arrayList);

        void startDocumentSelectActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListItem {
        long date;
        String ext;
        File file;
        int icon;
        String subtitle;
        String thumb;
        String title;

        private ListItem(DocumentSelectActivity documentSelectActivity) {
            this.subtitle = BuildConfig.FLAVOR;
            this.ext = BuildConfig.FLAVOR;
        }

        /* synthetic */ ListItem(DocumentSelectActivity documentSelectActivity, AnonymousClass1 anonymousClass1) {
            this(documentSelectActivity);
        }
    }

    private class HistoryEntry {
        File dir;
        int scrollItem;
        int scrollOffset;
        String title;

        private HistoryEntry(DocumentSelectActivity documentSelectActivity) {
        }

        /* synthetic */ HistoryEntry(DocumentSelectActivity documentSelectActivity, AnonymousClass1 anonymousClass1) {
            this(documentSelectActivity);
        }
    }

    /* renamed from: androidMessenger.utilites.DocumentSelectActivity$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Runnable runnable = new Runnable() { // from class: androidMessenger.utilites.DocumentSelectActivity$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$onReceive$0();
                }
            };
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                DocumentSelectActivity.this.listView.postDelayed(runnable, 1000L);
            } else {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0() throws Throwable {
            try {
                if (DocumentSelectActivity.this.currentDir == null) {
                    DocumentSelectActivity.this.listRoots();
                } else {
                    DocumentSelectActivity documentSelectActivity = DocumentSelectActivity.this;
                    documentSelectActivity.listFiles(documentSelectActivity.currentDir);
                }
            } catch (Exception unused) {
            }
        }
    }

    public DocumentSelectActivity() {
        FragmentType fragmentType = FragmentType.Messenger;
        this.fragmentName = "DocumentSelectActivity";
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        loadRecentFiles();
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        try {
            if (this.receiverRegistered) {
                ApplicationLoader.applicationContext.unregisterReceiver(this.receiver);
            }
        } catch (Exception unused) {
        }
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Throwable {
        if (!this.receiverRegistered) {
            this.receiverRegistered = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
            intentFilter.addAction("android.intent.action.MEDIA_CHECKING");
            intentFilter.addAction("android.intent.action.MEDIA_EJECT");
            intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
            intentFilter.addAction("android.intent.action.MEDIA_NOFS");
            intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
            intentFilter.addAction("android.intent.action.MEDIA_SHARED");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTABLE");
            intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
            intentFilter.addDataScheme("file");
            ApplicationLoader.applicationContext.registerReceiver(this.receiver, intentFilter);
        }
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle("انتخاب فایل");
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: androidMessenger.utilites.DocumentSelectActivity.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    if (((BaseFragment) DocumentSelectActivity.this).actionBar.isActionModeShowed()) {
                        DocumentSelectActivity.this.selectedFiles.clear();
                        ((BaseFragment) DocumentSelectActivity.this).actionBar.hideActionMode();
                        int childCount = DocumentSelectActivity.this.listView.getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            View childAt = DocumentSelectActivity.this.listView.getChildAt(i2);
                            if (childAt instanceof SharedDocumentCell) {
                                ((SharedDocumentCell) childAt).setChecked(false, true);
                            }
                        }
                        return;
                    }
                    DocumentSelectActivity.this.finishFragment();
                    return;
                }
                if (i != 3 || DocumentSelectActivity.this.delegate == null) {
                    return;
                }
                DocumentSelectActivity.this.delegate.didSelectFiles(DocumentSelectActivity.this, new ArrayList<>(DocumentSelectActivity.this.selectedFiles.keySet()));
                Iterator it = DocumentSelectActivity.this.selectedFiles.values().iterator();
                while (it.hasNext()) {
                    ((ListItem) it.next()).date = System.currentTimeMillis();
                }
            }
        });
        this.selectedFiles.clear();
        this.actionModeViews.clear();
        ActionBarMenu actionBarMenuCreateActionMode = this.actionBar.createActionMode();
        NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
        this.selectedMessagesCountTextView = numberTextView;
        numberTextView.setTextSize(18);
        this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.selectedMessagesCountTextView.setTextColor(-9211021);
        this.selectedMessagesCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: androidMessenger.utilites.DocumentSelectActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return DocumentSelectActivity.lambda$createView$0(view, motionEvent);
            }
        });
        actionBarMenuCreateActionMode.addView(this.selectedMessagesCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 0, 0, 65, 0));
        this.actionModeViews.add(actionBarMenuCreateActionMode.addItemWithWidth(3, R.drawable.ic_ab_done, AndroidUtilities.dp(54.0f)));
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.emptyView = emptyTextProgressView;
        emptyTextProgressView.showTextView();
        frameLayout2.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.layoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.listView.setEmptyView(this.emptyView);
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: androidMessenger.utilites.DocumentSelectActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                DocumentSelectActivity.this.scrolling = i != 0;
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: androidMessenger.utilites.DocumentSelectActivity$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$createView$1(view, i);
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: androidMessenger.utilites.DocumentSelectActivity$$ExternalSyntheticLambda3
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) throws Throwable {
                this.f$0.lambda$createView$2(view, i);
            }
        });
        listRoots();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$1(View view, int i) {
        ListItem item;
        if (this.actionBar.isActionModeShowed() || (item = this.listAdapter.getItem(i)) == null) {
            return false;
        }
        File file = item.file;
        if (file != null && !file.isDirectory()) {
            if (!file.canRead()) {
                showErrorBox("خطا در دسترسی");
                return false;
            }
            if (this.canSelectOnlyImageFiles && item.thumb == null) {
                showErrorBox("فقط میتوانید فایل های تصویری ارسال کنید");
                return false;
            }
            if (this.maxSelectedFiles >= 0 && this.selectedFiles.size() >= this.maxSelectedFiles) {
                showErrorBox("تعداد فایل انتخابی بیشتر از حد مجاز است");
                return false;
            }
            if (file.length() == 0) {
                return false;
            }
            this.selectedFiles.put(file.toString(), item);
            this.selectedMessagesCountTextView.setNumber(1, false);
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.actionModeViews.size(); i2++) {
                View view2 = this.actionModeViews.get(i2);
                AndroidUtilities.clearDrawableAnimation(view2);
                arrayList.add(ObjectAnimator.ofFloat(view2, "scaleY", 0.1f, 1.0f));
            }
            animatorSet.playTogether(arrayList);
            animatorSet.setDuration(250L);
            animatorSet.start();
            this.scrolling = false;
            if (view instanceof SharedDocumentCell) {
                ((SharedDocumentCell) view).setChecked(true, true);
            }
            this.actionBar.showActionMode();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view, int i) throws Throwable {
        ListItem item = this.listAdapter.getItem(i);
        if (item == null) {
            return;
        }
        File file = item.file;
        if (file == null) {
            if (item.icon == R.drawable.ic_storage_gallery) {
                DocumentSelectActivityDelegate documentSelectActivityDelegate = this.delegate;
                if (documentSelectActivityDelegate != null) {
                    documentSelectActivityDelegate.startDocumentSelectActivity();
                }
                finishFragment(false);
                return;
            }
            ArrayList<HistoryEntry> arrayList = this.history;
            HistoryEntry historyEntryRemove = arrayList.remove(arrayList.size() - 1);
            this.actionBar.setTitle(historyEntryRemove.title);
            File file2 = historyEntryRemove.dir;
            if (file2 != null) {
                listFiles(file2);
            } else {
                listRoots();
            }
            this.layoutManager.scrollToPositionWithOffset(historyEntryRemove.scrollItem, historyEntryRemove.scrollOffset);
            return;
        }
        if (file.isDirectory()) {
            HistoryEntry historyEntry = new HistoryEntry(this, null);
            int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
            historyEntry.scrollItem = iFindLastVisibleItemPosition;
            View viewFindViewByPosition = this.layoutManager.findViewByPosition(iFindLastVisibleItemPosition);
            if (viewFindViewByPosition != null) {
                historyEntry.scrollOffset = viewFindViewByPosition.getTop();
            }
            historyEntry.dir = this.currentDir;
            historyEntry.title = this.actionBar.getTitle();
            this.history.add(historyEntry);
            if (!listFiles(file)) {
                this.history.remove(historyEntry);
                return;
            } else {
                this.actionBar.setTitle(item.title);
                return;
            }
        }
        if (!file.canRead()) {
            showErrorBox(LocaleController.getString("AccessError", R.string.AccessError));
            file = new File("/mnt/sdcard");
        }
        if (this.canSelectOnlyImageFiles && item.thumb == null) {
            showErrorBox(LocaleController.formatString(R.string.PassportUploadNotImage, new Object[0]) + BuildConfig.FLAVOR);
            return;
        }
        if (file.length() == 0) {
            return;
        }
        if (this.actionBar.isActionModeShowed()) {
            if (this.selectedFiles.containsKey(file.toString())) {
                this.selectedFiles.remove(file.toString());
            } else {
                if (this.maxSelectedFiles >= 0 && this.selectedFiles.size() >= this.maxSelectedFiles) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(LocaleController.formatString(R.string.PassportUploadMaxReached, this.maxSelectedFiles + BuildConfig.FLAVOR));
                    sb.append(" ");
                    showErrorBox(sb.toString());
                    return;
                }
                this.selectedFiles.put(file.toString(), item);
            }
            if (this.selectedFiles.isEmpty()) {
                this.actionBar.hideActionMode();
            } else {
                this.selectedMessagesCountTextView.setNumber(this.selectedFiles.size(), true);
            }
            this.scrolling = false;
            if (view instanceof SharedDocumentCell) {
                ((SharedDocumentCell) view).setChecked(this.selectedFiles.containsKey(item.file.toString()), true);
                return;
            }
            return;
        }
        if (this.delegate != null) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add(file.getAbsolutePath());
            this.delegate.didSelectFiles(this, arrayList2);
        }
    }

    public void loadRecentFiles() {
        try {
            for (File file : Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).listFiles()) {
                if (!file.isDirectory()) {
                    ListItem listItem = new ListItem(this, null);
                    listItem.title = file.getName();
                    listItem.file = file;
                    String name = file.getName();
                    String[] strArrSplit = name.split("\\.");
                    listItem.ext = strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 1] : "?";
                    listItem.subtitle = AndroidUtilities.formatFileSize(file.length());
                    String lowerCase = name.toLowerCase();
                    if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".jpeg")) {
                        listItem.thumb = file.getAbsolutePath();
                    }
                    this.recentItems.add(listItem);
                }
            }
            Collections.sort(this.recentItems, new Comparator() { // from class: androidMessenger.utilites.DocumentSelectActivity$$ExternalSyntheticLambda1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DocumentSelectActivity.lambda$loadRecentFiles$3((DocumentSelectActivity.ListItem) obj, (DocumentSelectActivity.ListItem) obj2);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$loadRecentFiles$3(ListItem listItem, ListItem listItem2) {
        long jLastModified = listItem.file.lastModified();
        long jLastModified2 = listItem2.file.lastModified();
        if (jLastModified == jLastModified2) {
            return 0;
        }
        return jLastModified > jLastModified2 ? -1 : 1;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        fixLayoutInternal();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            recyclerListView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: androidMessenger.utilites.DocumentSelectActivity.4
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    DocumentSelectActivity.this.listView.getViewTreeObserver().removeOnPreDrawListener(this);
                    DocumentSelectActivity.this.fixLayoutInternal();
                    return true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixLayoutInternal() {
        if (this.selectedMessagesCountTextView == null) {
            return;
        }
        if (!AndroidUtilities.isTablet() && ApplicationLoader.applicationContext.getResources().getConfiguration().orientation == 2) {
            this.selectedMessagesCountTextView.setTextSize(18);
        } else {
            this.selectedMessagesCountTextView.setTextSize(20);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() throws Throwable {
        if (this.history.size() > 0) {
            HistoryEntry historyEntryRemove = this.history.remove(r0.size() - 1);
            this.actionBar.setTitle(historyEntryRemove.title);
            File file = historyEntryRemove.dir;
            if (file != null) {
                listFiles(file);
            } else {
                listRoots();
            }
            this.layoutManager.scrollToPositionWithOffset(historyEntryRemove.scrollItem, historyEntryRemove.scrollOffset);
            return false;
        }
        return super.onBackPressed();
    }

    public void setDelegate(DocumentSelectActivityDelegate documentSelectActivityDelegate) {
        this.delegate = documentSelectActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean listFiles(File file) {
        AnonymousClass1 anonymousClass1;
        if (!file.canRead()) {
            if ((file.getAbsolutePath().startsWith(Environment.getExternalStorageDirectory().toString()) || file.getAbsolutePath().startsWith("/sdcard") || file.getAbsolutePath().startsWith("/mnt/sdcard")) && !Environment.getExternalStorageState().equals("mounted") && !Environment.getExternalStorageState().equals("mounted_ro")) {
                this.currentDir = file;
                this.items.clear();
                if ("shared".equals(Environment.getExternalStorageState())) {
                    this.emptyView.setText("USB transfer active");
                } else {
                    this.emptyView.setText("Storage not mounted");
                }
                AndroidUtilities.clearDrawableAnimation(this.listView);
                this.scrolling = true;
                this.listAdapter.notifyDataSetChanged();
                return true;
            }
            showErrorBox("خطای دسترسی");
            return false;
        }
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                showErrorBox("خطای ناشناس");
                return false;
            }
            this.currentDir = file;
            this.items.clear();
            Arrays.sort(fileArrListFiles, new Comparator() { // from class: androidMessenger.utilites.DocumentSelectActivity$$ExternalSyntheticLambda2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return DocumentSelectActivity.lambda$listFiles$4((File) obj, (File) obj2);
                }
            });
            int i = 0;
            while (true) {
                anonymousClass1 = null;
                if (i >= fileArrListFiles.length) {
                    break;
                }
                File file2 = fileArrListFiles[i];
                if (file2.getName().indexOf(46) != 0) {
                    ListItem listItem = new ListItem(this, anonymousClass1);
                    listItem.title = file2.getName();
                    listItem.file = file2;
                    if (file2.isDirectory()) {
                        listItem.icon = R.drawable.ic_directory;
                        listItem.subtitle = "پوشه";
                    } else {
                        String name = file2.getName();
                        String[] strArrSplit = name.split("\\.");
                        listItem.ext = strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 1] : "?";
                        listItem.subtitle = AndroidUtilities.formatFileSize(file2.length());
                        String lowerCase = name.toLowerCase();
                        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".jpeg")) {
                            listItem.thumb = file2.getAbsolutePath();
                        }
                    }
                    this.items.add(listItem);
                }
                i++;
            }
            ListItem listItem2 = new ListItem(this, anonymousClass1);
            listItem2.title = "..";
            if (this.history.size() > 0) {
                ArrayList<HistoryEntry> arrayList = this.history;
                File file3 = arrayList.get(arrayList.size() - 1).dir;
                if (file3 == null) {
                    listItem2.subtitle = "پوشه";
                } else {
                    listItem2.subtitle = file3.toString();
                }
            } else {
                listItem2.subtitle = "پوشه";
            }
            listItem2.icon = R.drawable.ic_directory;
            listItem2.file = null;
            this.items.add(0, listItem2);
            AndroidUtilities.clearDrawableAnimation(this.listView);
            this.scrolling = true;
            this.listAdapter.notifyDataSetChanged();
            return true;
        } catch (Exception e) {
            showErrorBox(e.getLocalizedMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$listFiles$4(File file, File file2) {
        if (file.isDirectory() != file2.isDirectory()) {
            return file.isDirectory() ? -1 : 1;
        }
        return file.getName().compareToIgnoreCase(file2.getName());
    }

    private void showErrorBox(String str) {
        if (getParentActivity() == null) {
            return;
        }
        new AlertDialog.Builder(getParentActivity()).setTitle(LocaleController.getString(R.string.AppName)).setMessage(str).setPositiveButton(LocaleController.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(2:(3:78|12|(2:14|(4:82|18|(10:91|33|(2:37|(1:39))|40|76|41|92|(1:43)(1:44)|45|101)|93)(2:94|93))(0))|70) */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0174 A[Catch: Exception -> 0x019f, TRY_LEAVE, TryCatch #1 {Exception -> 0x019f, blocks: (B:61:0x015e, B:63:0x0174), top: B:72:0x015e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void listRoots() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 454
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.utilites.DocumentSelectActivity.listRoots():void");
    }

    private String getRootSubtitle(String str) {
        try {
            StatFs statFs = new StatFs(str);
            long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
            return blockCount == 0 ? BuildConfig.FLAVOR : LocaleController.formatString("FreeOfTotal", R.string.FreeOfTotal, AndroidUtilities.formatFileSize(statFs.getAvailableBlocks() * statFs.getBlockSize()), AndroidUtilities.formatFileSize(blockCount));
        } catch (Exception unused) {
            return str;
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = DocumentSelectActivity.this.items.size();
            return (!DocumentSelectActivity.this.history.isEmpty() || DocumentSelectActivity.this.recentItems.isEmpty()) ? size : size + DocumentSelectActivity.this.recentItems.size() + 1;
        }

        public ListItem getItem(int i) {
            int size;
            if (i < DocumentSelectActivity.this.items.size()) {
                return (ListItem) DocumentSelectActivity.this.items.get(i);
            }
            if (!DocumentSelectActivity.this.history.isEmpty() || DocumentSelectActivity.this.recentItems.isEmpty() || i == DocumentSelectActivity.this.items.size() || (size = i - (DocumentSelectActivity.this.items.size() + 1)) >= DocumentSelectActivity.this.recentItems.size()) {
                return null;
            }
            return (ListItem) DocumentSelectActivity.this.recentItems.get(size);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return getItem(i) != null ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout sharedDocumentCell;
            if (i == 0) {
                GraySectionCell graySectionCell = new GraySectionCell(this.mContext);
                graySectionCell.setText("فایل های اخیر");
                sharedDocumentCell = graySectionCell;
            } else {
                sharedDocumentCell = new SharedDocumentCell(this.mContext);
            }
            return new RecyclerListView.Holder(sharedDocumentCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 1) {
                ListItem item = getItem(i);
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
                int i2 = item.icon;
                if (i2 != 0) {
                    sharedDocumentCell.setTextAndValueAndTypeAndThumb(item.title, item.subtitle, null, null, i2, true);
                } else {
                    sharedDocumentCell.setTextAndValueAndTypeAndThumb(item.title, item.subtitle, item.ext.toUpperCase().substring(0, Math.min(item.ext.length(), 4)), item.thumb, 0, true);
                }
                sharedDocumentCell.setChecked(false, !DocumentSelectActivity.this.scrolling);
            }
        }
    }
}
