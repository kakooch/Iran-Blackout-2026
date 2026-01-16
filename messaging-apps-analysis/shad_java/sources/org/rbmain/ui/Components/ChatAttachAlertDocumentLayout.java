package org.rbmain.ui.Components;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.SharedDocumentCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.ChatAttachAlert;
import org.rbmain.ui.Components.ChatAttachAlertDocumentLayout;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.PhotoPickerActivity;

/* loaded from: classes5.dex */
public class ChatAttachAlertDocumentLayout extends ChatAttachAlert.AttachAlertLayout {
    private boolean allowMusic;
    private boolean canSelectOnlyImageFiles;
    private File currentDir;
    private DocumentSelectActivityDelegate delegate;
    private ImageView emptyImageView;
    private TextView emptySubtitleTextView;
    private TextView emptyTitleTextView;
    private LinearLayout emptyView;
    private boolean hasFiles;
    private ArrayList<HistoryEntry> history;
    private boolean ignoreLayout;
    private ArrayList<ListItem> items;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int maxSelectedFiles;
    private BroadcastReceiver receiver;
    private boolean receiverRegistered;
    private ArrayList<ListItem> recentItems;
    private boolean scrolling;
    private SearchAdapter searchAdapter;
    private ActionBarMenuItem searchItem;
    private boolean searching;
    private HashMap<String, ListItem> selectedFiles;
    private ArrayList<String> selectedFilesOrder;
    private boolean sendPressed;
    private boolean sortByName;
    private ActionBarMenuItem sortItem;

    public interface DocumentSelectActivityDelegate {

        /* renamed from: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$DocumentSelectActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$startMusicSelectActivity(DocumentSelectActivityDelegate documentSelectActivityDelegate) {
            }
        }

        void didSelectFiles(ArrayList<String> arrayList, String str, boolean z, int i);

        void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList, boolean z, int i);

        void startDocumentSelectActivity();

        void startMusicSelectActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int needsActionBar() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ListItem {
        public String ext;
        public File file;
        public int icon;
        public String subtitle;
        public String thumb;
        public String title;

        private ListItem() {
            this.subtitle = BuildConfig.FLAVOR;
            this.ext = BuildConfig.FLAVOR;
        }

        /* synthetic */ ListItem(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class HistoryEntry {
        File dir;
        String title;

        private HistoryEntry() {
        }

        /* synthetic */ HistoryEntry(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* renamed from: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$onReceive$0();
                }
            };
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                ChatAttachAlertDocumentLayout.this.listView.postDelayed(runnable, 1000L);
            } else {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0() throws Throwable {
            try {
                if (ChatAttachAlertDocumentLayout.this.currentDir == null) {
                    ChatAttachAlertDocumentLayout.this.listRoots();
                } else {
                    ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout = ChatAttachAlertDocumentLayout.this;
                    chatAttachAlertDocumentLayout.listFiles(chatAttachAlertDocumentLayout.currentDir);
                }
                ChatAttachAlertDocumentLayout.this.updateSearchButton();
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    public ChatAttachAlertDocumentLayout(ChatAttachAlert chatAttachAlert, Context context, boolean z) throws Throwable {
        super(chatAttachAlert, context);
        this.items = new ArrayList<>();
        this.receiverRegistered = false;
        this.history = new ArrayList<>();
        this.selectedFiles = new HashMap<>();
        this.selectedFilesOrder = new ArrayList<>();
        this.recentItems = new ArrayList<>();
        this.maxSelectedFiles = -1;
        this.receiver = new AnonymousClass1();
        this.allowMusic = z;
        this.sortByName = SharedConfig.sortFilesByName;
        loadRecentFiles();
        this.searching = false;
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
        ActionBarMenu actionBarMenuCreateMenu = this.parentAlert.actionBar.createMenu();
        ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.2
            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                ChatAttachAlertDocumentLayout.this.searching = true;
                ChatAttachAlertDocumentLayout.this.sortItem.setVisibility(8);
                ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout = ChatAttachAlertDocumentLayout.this;
                chatAttachAlertDocumentLayout.parentAlert.makeFocusable(chatAttachAlertDocumentLayout.searchItem.getSearchField(), true);
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                ChatAttachAlertDocumentLayout.this.searching = false;
                ChatAttachAlertDocumentLayout.this.sortItem.setVisibility(0);
                if (ChatAttachAlertDocumentLayout.this.listView.getAdapter() != ChatAttachAlertDocumentLayout.this.listAdapter) {
                    ChatAttachAlertDocumentLayout.this.listView.setAdapter(ChatAttachAlertDocumentLayout.this.listAdapter);
                }
                ChatAttachAlertDocumentLayout.this.listAdapter.notifyDataSetChanged();
                ChatAttachAlertDocumentLayout.this.searchAdapter.search(null);
            }

            @Override // org.rbmain.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                ChatAttachAlertDocumentLayout.this.searchAdapter.search(editText.getText().toString());
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
        EditTextBoldCursor searchField = this.searchItem.getSearchField();
        int i = Theme.key_dialogTextBlack;
        searchField.setTextColor(Theme.getColor(i));
        searchField.setCursorColor(Theme.getColor(i));
        searchField.setHintTextColor(Theme.getColor(Theme.key_chat_messagePanelHint));
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(6, this.sortByName ? R.drawable.contacts_sort_time : R.drawable.contacts_sort_name);
        this.sortItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("AccDescrContactSorting", R.string.AccDescrContactSorting));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyView = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyView.setGravity(17);
        this.emptyView.setVisibility(8);
        addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChatAttachAlertDocumentLayout.lambda$new$0(view, motionEvent);
            }
        });
        ImageView imageView = new ImageView(context);
        this.emptyImageView = imageView;
        imageView.setImageResource(R.drawable.files_empty);
        this.emptyImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogEmptyImage), PorterDuff.Mode.MULTIPLY));
        this.emptyView.addView(this.emptyImageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.emptyTitleTextView = textView;
        int i2 = Theme.key_dialogEmptyText;
        textView.setTextColor(Theme.getColor(i2));
        this.emptyTitleTextView.setGravity(17);
        this.emptyTitleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.emptyTitleTextView.setTextSize(1, 17.0f);
        this.emptyTitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptyTitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 11, 0, 0));
        TextView textView2 = new TextView(context);
        this.emptySubtitleTextView = textView2;
        textView2.setTextColor(Theme.getColor(i2));
        this.emptySubtitleTextView.setGravity(17);
        this.emptySubtitleTextView.setTextSize(1, 15.0f);
        this.emptySubtitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptySubtitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 6, 0, 0));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(context, 1, false, AndroidUtilities.dp(56.0f), this.listView) { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.3
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i3) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.3.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view, int i4) {
                        return super.calculateDyToMakeVisible(view, i4) - (ChatAttachAlertDocumentLayout.this.listView.getPaddingTop() - AndroidUtilities.dp(56.0f));
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int calculateTimeForDeceleration(int i4) {
                        return super.calculateTimeForDeceleration(i4) * 2;
                    }
                };
                linearSmoothScroller.setTargetPosition(i3);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        this.layoutManager = fillLastLinearLayoutManager;
        recyclerListView2.setLayoutManager(fillLastLinearLayoutManager);
        this.listView.setEmptyView(this.emptyView);
        this.listView.setClipToPadding(false);
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
        addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.searchAdapter = new SearchAdapter(context);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout = ChatAttachAlertDocumentLayout.this;
                chatAttachAlertDocumentLayout.parentAlert.updateLayout(chatAttachAlertDocumentLayout, true, i4);
                ChatAttachAlertDocumentLayout.this.updateEmptyViewPosition();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                RecyclerListView.Holder holder;
                if (i3 == 0) {
                    int iDp = AndroidUtilities.dp(13.0f);
                    int backgroundPaddingTop = ChatAttachAlertDocumentLayout.this.parentAlert.getBackgroundPaddingTop();
                    if (((ChatAttachAlertDocumentLayout.this.parentAlert.scrollOffsetY[0] - backgroundPaddingTop) - iDp) + backgroundPaddingTop < ActionBar.getCurrentActionBarHeight() && (holder = (RecyclerListView.Holder) ChatAttachAlertDocumentLayout.this.listView.findViewHolderForAdapterPosition(0)) != null && holder.itemView.getTop() > AndroidUtilities.dp(56.0f)) {
                        ChatAttachAlertDocumentLayout.this.listView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(56.0f));
                    }
                }
                if (i3 == 1 && ChatAttachAlertDocumentLayout.this.searching && ChatAttachAlertDocumentLayout.this.listView.getAdapter() == ChatAttachAlertDocumentLayout.this.searchAdapter) {
                    AndroidUtilities.hideKeyboard(ChatAttachAlertDocumentLayout.this.parentAlert.getCurrentFocus());
                }
                ChatAttachAlertDocumentLayout.this.scrolling = i3 != 0;
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$$ExternalSyntheticLambda3
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) throws Throwable {
                this.f$0.lambda$new$1(view, i3);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i3) {
                return this.f$0.lambda$new$2(view, i3);
            }
        });
        listRoots();
        updateSearchButton();
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$new$1(View view, int i) throws Throwable {
        ListItem item;
        int i2;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        ListAdapter listAdapter = this.listAdapter;
        if (adapter == listAdapter) {
            item = listAdapter.getItem(i);
        } else {
            item = this.searchAdapter.getItem(i);
        }
        if (item == null) {
            return;
        }
        File file = item.file;
        boolean zIsExternalStorageManager = Build.VERSION.SDK_INT >= 30 ? Environment.isExternalStorageManager() : false;
        if (!BuildVars.NO_SCOPED_STORAGE && (((i2 = item.icon) == R.drawable.files_storage || i2 == R.drawable.files_internal) && !zIsExternalStorageManager)) {
            this.delegate.startDocumentSelectActivity();
            return;
        }
        Object[] objArr = 0;
        if (file == null) {
            int i3 = item.icon;
            if (i3 == R.drawable.files_gallery) {
                final HashMap map = new HashMap();
                final ArrayList arrayList = new ArrayList();
                BaseFragment baseFragment = this.parentAlert.baseFragment;
                ChatActivity chatActivity = baseFragment instanceof ChatActivity ? (ChatActivity) baseFragment : null;
                PhotoPickerActivity photoPickerActivity = new PhotoPickerActivity(0, MediaController.allMediaAlbumEntry, map, arrayList, 0, chatActivity != null, chatActivity);
                photoPickerActivity.setDocumentsPicker(true);
                photoPickerActivity.setDelegate(new PhotoPickerActivity.PhotoPickerActivityDelegate() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.5
                    @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                    public void onCaptionChanged(CharSequence charSequence) {
                    }

                    @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                    public void selectedPhotosChanged() {
                    }

                    @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                    public void actionButtonPressed(boolean z, boolean z2, int i4) {
                        if (z) {
                            return;
                        }
                        ChatAttachAlertDocumentLayout.this.sendSelectedPhotos(map, arrayList, z2, i4);
                    }

                    @Override // org.rbmain.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                    public void onOpenInPressed() {
                        ChatAttachAlertDocumentLayout.this.delegate.startDocumentSelectActivity();
                    }
                });
                photoPickerActivity.setMaxSelectedPhotos(this.maxSelectedFiles, false);
                this.parentAlert.baseFragment.presentFragment(photoPickerActivity);
                this.parentAlert.dismiss();
                return;
            }
            if (i3 == R.drawable.files_music) {
                DocumentSelectActivityDelegate documentSelectActivityDelegate = this.delegate;
                if (documentSelectActivityDelegate != null) {
                    documentSelectActivityDelegate.startMusicSelectActivity();
                    return;
                }
                return;
            }
            int topForScroll = getTopForScroll();
            ArrayList<HistoryEntry> arrayList2 = this.history;
            HistoryEntry historyEntryRemove = arrayList2.remove(arrayList2.size() - 1);
            this.parentAlert.actionBar.setTitle(historyEntryRemove.title);
            File file2 = historyEntryRemove.dir;
            if (file2 != null) {
                listFiles(file2);
            } else {
                listRoots();
            }
            updateSearchButton();
            this.layoutManager.scrollToPositionWithOffset(0, topForScroll);
            return;
        }
        if (file.isDirectory()) {
            HistoryEntry historyEntry = new HistoryEntry(objArr == true ? 1 : 0);
            View childAt = this.listView.getChildAt(0);
            this.listView.findContainingViewHolder(childAt).getAdapterPosition();
            childAt.getTop();
            historyEntry.dir = this.currentDir;
            historyEntry.title = this.parentAlert.actionBar.getTitle();
            this.history.add(historyEntry);
            if (!listFiles(file)) {
                this.history.remove(historyEntry);
                return;
            } else {
                this.parentAlert.actionBar.setTitle(item.title);
                return;
            }
        }
        onItemClick(view, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(View view, int i) {
        ListItem item;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        ListAdapter listAdapter = this.listAdapter;
        if (adapter == listAdapter) {
            item = listAdapter.getItem(i);
        } else {
            item = this.searchAdapter.getItem(i);
        }
        return onItemClick(view, item);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onDestroy() {
        try {
            if (this.receiverRegistered) {
                ApplicationLoader.applicationContext.unregisterReceiver(this.receiver);
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.parentAlert.actionBar.closeSearchField();
        ActionBarMenu actionBarMenuCreateMenu = this.parentAlert.actionBar.createMenu();
        actionBarMenuCreateMenu.removeView(this.sortItem);
        actionBarMenuCreateMenu.removeView(this.searchItem);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onMenuItemClick(int i) {
        if (i == 6) {
            SharedConfig.toggleSortFilesByName();
            this.sortByName = SharedConfig.sortFilesByName;
            sortRecentItems();
            sortFileItems();
            this.listAdapter.notifyDataSetChanged();
            this.sortItem.setIcon(this.sortByName ? R.drawable.contacts_sort_time : R.drawable.contacts_sort_name);
        }
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        if (this.listView.getChildCount() <= 0) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int y = ((int) childAt.getY()) - AndroidUtilities.dp(8.0f);
        if (y > 0 && holder != null && holder.getAdapterPosition() == 0) {
            i = y;
        }
        if (y < 0 || holder == null || holder.getAdapterPosition() != 0) {
            y = i;
        }
        return y + AndroidUtilities.dp(13.0f);
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        this.parentAlert.getSheetContainer().invalidate();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.listView.getPaddingTop();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(5.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r4, int r5) {
        /*
            r3 = this;
            org.rbmain.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            org.rbmain.ui.ActionBar.ActionBar r4 = r4.actionBar
            boolean r4 = r4.isSearchFieldVisible()
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L45
            org.rbmain.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            org.rbmain.ui.Components.SizeNotifierFrameLayout r4 = r4.sizeNotifierFrameLayout
            int r4 = r4.measureKeyboardHeight()
            r2 = 1101004800(0x41a00000, float:20.0)
            int r2 = org.rbmain.messenger.AndroidUtilities.dp(r2)
            if (r4 <= r2) goto L1d
            goto L45
        L1d:
            boolean r4 = org.rbmain.messenger.AndroidUtilities.isTablet()
            if (r4 != 0) goto L31
            android.graphics.Point r4 = org.rbmain.messenger.AndroidUtilities.displaySize
            int r2 = r4.x
            int r4 = r4.y
            if (r2 <= r4) goto L31
            float r4 = (float) r5
            r5 = 1080033280(0x40600000, float:3.5)
            float r4 = r4 / r5
            int r4 = (int) r4
            goto L35
        L31:
            int r5 = r5 / 5
            int r4 = r5 * 2
        L35:
            r5 = 1065353216(0x3f800000, float:1.0)
            int r5 = org.rbmain.messenger.AndroidUtilities.dp(r5)
            int r4 = r4 - r5
            if (r4 >= 0) goto L3f
            r4 = 0
        L3f:
            org.rbmain.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r0)
            goto L50
        L45:
            r4 = 1113587712(0x42600000, float:56.0)
            int r4 = org.rbmain.messenger.AndroidUtilities.dp(r4)
            org.rbmain.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r1)
        L50:
            org.rbmain.ui.Components.RecyclerListView r5 = r3.listView
            int r5 = r5.getPaddingTop()
            if (r5 == r4) goto L67
            r3.ignoreLayout = r0
            org.rbmain.ui.Components.RecyclerListView r5 = r3.listView
            r0 = 1111490560(0x42400000, float:48.0)
            int r0 = org.rbmain.messenger.AndroidUtilities.dp(r0)
            r5.setPadding(r1, r4, r1, r0)
            r3.ignoreLayout = r1
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.onPreMeasure(int, int):void");
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getButtonsHideOffset() {
        return AndroidUtilities.dp(62.0f);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.listView.smoothScrollToPosition(0);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getSelectedItemsCount() {
        return this.selectedFiles.size();
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void sendSelectedItems(boolean z, int i) {
        if (this.selectedFiles.size() == 0 || this.delegate == null || this.sendPressed) {
            return;
        }
        this.sendPressed = true;
        this.delegate.didSelectFiles(new ArrayList<>(this.selectedFilesOrder), this.parentAlert.commentTextView.getText().toString(), z, i);
        this.parentAlert.dismiss();
    }

    private boolean onItemClick(View view, ListItem listItem) {
        File file;
        boolean z;
        if (listItem == null || (file = listItem.file) == null || file.isDirectory()) {
            return false;
        }
        String absolutePath = listItem.file.getAbsolutePath();
        if (this.selectedFiles.containsKey(absolutePath)) {
            this.selectedFiles.remove(absolutePath);
            this.selectedFilesOrder.remove(absolutePath);
            z = false;
        } else {
            if (!listItem.file.canRead()) {
                showErrorBox(LocaleController.getString("AccessError", R.string.AccessError));
                return false;
            }
            if (this.canSelectOnlyImageFiles && listItem.thumb == null) {
                showErrorBox(LocaleController.formatString("PassportUploadNotImage", R.string.PassportUploadNotImage, new Object[0]));
                return false;
            }
            if (listItem.file.length() > FileLoader.MAX_FILE_SIZE) {
                showErrorBox(LocaleController.formatString("FileUploadLimit", R.string.FileUploadLimit, AndroidUtilities.formatFileSize(FileLoader.MAX_FILE_SIZE)));
                return false;
            }
            if (this.maxSelectedFiles >= 0) {
                int size = this.selectedFiles.size();
                int i = this.maxSelectedFiles;
                if (size >= i) {
                    showErrorBox(LocaleController.formatString("PassportUploadMaxReached", R.string.PassportUploadMaxReached, LocaleController.formatPluralString("Files", i)));
                    return false;
                }
            }
            if (listItem.file.length() == 0) {
                return false;
            }
            this.selectedFiles.put(absolutePath, listItem);
            this.selectedFilesOrder.add(absolutePath);
            z = true;
        }
        this.scrolling = false;
        if (view instanceof SharedDocumentCell) {
            ((SharedDocumentCell) view).setChecked(z, true);
        }
        this.parentAlert.updateCountButton(z ? 1 : 2);
        return true;
    }

    public void setMaxSelectedFiles(int i) {
        this.maxSelectedFiles = i;
    }

    public void setCanSelectOnlyImageFiles(boolean z) {
        this.canSelectOnlyImageFiles = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSelectedPhotos(HashMap<Object, Object> map, ArrayList<Object> arrayList, boolean z, int i) {
        if (map.isEmpty() || this.delegate == null || this.sendPressed) {
            return;
        }
        this.sendPressed = true;
        ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Object obj = map.get(arrayList.get(i2));
            SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
            arrayList2.add(sendingMediaInfo);
            if (obj instanceof MediaController.PhotoEntry) {
                MediaController.PhotoEntry photoEntry = (MediaController.PhotoEntry) obj;
                String str = photoEntry.imagePath;
                if (str != null) {
                    sendingMediaInfo.path = str;
                } else {
                    sendingMediaInfo.path = photoEntry.path;
                }
                sendingMediaInfo.thumbPath = photoEntry.thumbPath;
                sendingMediaInfo.videoEditedInfo = photoEntry.editedInfo;
                sendingMediaInfo.isVideo = photoEntry.isVideo;
                CharSequence charSequence = photoEntry.caption;
                sendingMediaInfo.caption = charSequence != null ? charSequence.toString() : null;
                sendingMediaInfo.entities = photoEntry.entities;
                sendingMediaInfo.masks = photoEntry.stickers;
                sendingMediaInfo.ttl = photoEntry.ttl;
            }
        }
        this.delegate.didSelectPhotos(arrayList2, z, i);
    }

    public void loadRecentFiles() {
        try {
            for (File file : Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).listFiles()) {
                if (!file.isDirectory()) {
                    ListItem listItem = new ListItem(null);
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
            sortRecentItems();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void sortRecentItems() {
        Collections.sort(this.recentItems, new Comparator() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$$ExternalSyntheticLambda2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.lambda$sortRecentItems$3((ChatAttachAlertDocumentLayout.ListItem) obj, (ChatAttachAlertDocumentLayout.ListItem) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$sortRecentItems$3(ListItem listItem, ListItem listItem2) {
        if (this.sortByName) {
            return listItem.file.getName().compareToIgnoreCase(listItem2.file.getName());
        }
        long jLastModified = listItem.file.lastModified();
        long jLastModified2 = listItem2.file.lastModified();
        if (jLastModified == jLastModified2) {
            return 0;
        }
        return jLastModified > jLastModified2 ? -1 : 1;
    }

    private void sortFileItems() {
        if (this.currentDir == null) {
            return;
        }
        Collections.sort(this.items, new Comparator() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f$0.lambda$sortFileItems$4((ChatAttachAlertDocumentLayout.ListItem) obj, (ChatAttachAlertDocumentLayout.ListItem) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$sortFileItems$4(ListItem listItem, ListItem listItem2) {
        File file = listItem.file;
        if (file == null) {
            return -1;
        }
        File file2 = listItem2.file;
        if (file2 == null) {
            return 1;
        }
        if (file == null && file2 == null) {
            return 0;
        }
        boolean zIsDirectory = file.isDirectory();
        boolean zIsDirectory2 = listItem2.file.isDirectory();
        if (zIsDirectory != zIsDirectory2) {
            return zIsDirectory ? -1 : 1;
        }
        if ((zIsDirectory && zIsDirectory2) || this.sortByName) {
            return listItem.file.getName().compareToIgnoreCase(listItem2.file.getName());
        }
        long jLastModified = listItem.file.lastModified();
        long jLastModified2 = listItem2.file.lastModified();
        if (jLastModified == jLastModified2) {
            return 0;
        }
        return jLastModified > jLastModified2 ? -1 : 1;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
        SearchAdapter searchAdapter = this.searchAdapter;
        if (searchAdapter != null) {
            searchAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() throws Throwable {
        this.selectedFiles.clear();
        this.selectedFilesOrder.clear();
        this.history.clear();
        listRoots();
        updateSearchButton();
        updateEmptyView();
        this.parentAlert.actionBar.setTitle(LocaleController.getString("SelectFile", R.string.SelectFile));
        this.sortItem.setVisibility(0);
        this.layoutManager.scrollToPositionWithOffset(0, 0);
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHide() {
        this.sortItem.setVisibility(8);
        this.searchItem.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyViewPosition() {
        View childAt;
        if (this.emptyView.getVisibility() == 0 && (childAt = this.listView.getChildAt(0)) != null) {
            this.emptyView.setTranslationY(((r1.getMeasuredHeight() - getMeasuredHeight()) + childAt.getTop()) / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyView() {
        boolean zIsEmpty;
        if (this.searching) {
            this.emptyTitleTextView.setText(LocaleController.getString("NoFilesFound", R.string.NoFilesFound));
        } else {
            this.emptyTitleTextView.setText(LocaleController.getString("NoFilesFound", R.string.NoFilesFound));
            this.emptySubtitleTextView.setText(LocaleController.getString("NoFilesInfo", R.string.NoFilesInfo));
        }
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchAdapter;
        if (adapter != searchAdapter) {
            zIsEmpty = this.listAdapter.getItemCount() == 1;
        } else {
            zIsEmpty = searchAdapter.searchResult.isEmpty();
        }
        this.emptyView.setVisibility(zIsEmpty ? 0 : 8);
        updateEmptyViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSearchButton() {
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        if (actionBarMenuItem == null) {
            return;
        }
        if (!actionBarMenuItem.isSearchFieldVisible()) {
            this.searchItem.setVisibility(this.hasFiles ? 0 : 8);
        }
        if (this.history.isEmpty()) {
            this.searchItem.setSearchFieldHint(LocaleController.getString("SearchRecentFiles", R.string.SearchRecentFiles));
        } else {
            this.searchItem.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        }
    }

    private int getTopForScroll() {
        View childAt = this.listView.getChildAt(0);
        RecyclerView.ViewHolder viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(childAt);
        int i = -this.listView.getPaddingTop();
        return (viewHolderFindContainingViewHolder == null || viewHolderFindContainingViewHolder.getAdapterPosition() != 0) ? i : i + childAt.getTop();
    }

    private boolean canClosePicker() throws Throwable {
        if (this.history.size() <= 0) {
            return true;
        }
        ArrayList<HistoryEntry> arrayList = this.history;
        HistoryEntry historyEntryRemove = arrayList.remove(arrayList.size() - 1);
        this.parentAlert.actionBar.setTitle(historyEntryRemove.title);
        int topForScroll = getTopForScroll();
        File file = historyEntryRemove.dir;
        if (file != null) {
            listFiles(file);
        } else {
            listRoots();
        }
        updateSearchButton();
        this.layoutManager.scrollToPositionWithOffset(0, topForScroll);
        return false;
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    public boolean onBackPressed() {
        if (canClosePicker()) {
            return super.onBackPressed();
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateEmptyViewPosition();
    }

    public void setDelegate(DocumentSelectActivityDelegate documentSelectActivityDelegate) {
        this.delegate = documentSelectActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean listFiles(File file) {
        AnonymousClass1 anonymousClass1;
        this.hasFiles = false;
        if (!file.canRead()) {
            if ((file.getAbsolutePath().startsWith(Environment.getExternalStorageDirectory().toString()) || file.getAbsolutePath().startsWith("/sdcard") || file.getAbsolutePath().startsWith("/mnt/sdcard")) && !Environment.getExternalStorageState().equals("mounted") && !Environment.getExternalStorageState().equals("mounted_ro")) {
                this.currentDir = file;
                this.items.clear();
                Environment.getExternalStorageState();
                AndroidUtilities.clearDrawableAnimation(this.listView);
                this.scrolling = true;
                this.listAdapter.notifyDataSetChanged();
                return true;
            }
            showErrorBox(LocaleController.getString("AccessError", R.string.AccessError));
            return false;
        }
        try {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                showErrorBox(LocaleController.getString("UnknownError", R.string.UnknownError));
                return false;
            }
            this.currentDir = file;
            this.items.clear();
            int i = 0;
            while (true) {
                anonymousClass1 = null;
                if (i >= fileArrListFiles.length) {
                    break;
                }
                File file2 = fileArrListFiles[i];
                if (file2.getName().indexOf(46) != 0) {
                    ListItem listItem = new ListItem(anonymousClass1);
                    listItem.title = file2.getName();
                    listItem.file = file2;
                    if (file2.isDirectory()) {
                        listItem.icon = R.drawable.files_folder;
                        listItem.subtitle = LocaleController.getString("Folder", R.string.Folder);
                    } else {
                        this.hasFiles = true;
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
            ListItem listItem2 = new ListItem(anonymousClass1);
            listItem2.title = "..";
            if (this.history.size() > 0) {
                ArrayList<HistoryEntry> arrayList = this.history;
                File file3 = arrayList.get(arrayList.size() - 1).dir;
                if (file3 == null) {
                    listItem2.subtitle = LocaleController.getString("Folder", R.string.Folder);
                } else {
                    listItem2.subtitle = file3.toString();
                }
            } else {
                listItem2.subtitle = LocaleController.getString("Folder", R.string.Folder);
            }
            listItem2.icon = R.drawable.files_folder;
            listItem2.file = null;
            this.items.add(0, listItem2);
            sortFileItems();
            updateSearchButton();
            AndroidUtilities.clearDrawableAnimation(this.listView);
            this.scrolling = true;
            int topForScroll = getTopForScroll();
            this.listAdapter.notifyDataSetChanged();
            this.layoutManager.scrollToPositionWithOffset(0, topForScroll);
            return true;
        } catch (Exception e) {
            showErrorBox(e.getLocalizedMessage());
            return false;
        }
    }

    private void showErrorBox(String str) {
        new AlertDialog.Builder(getContext()).setTitle(LocaleController.getString("AppName", R.string.AppName)).setMessage(str).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0198 A[Catch: Exception -> 0x01be, TRY_LEAVE, TryCatch #1 {Exception -> 0x01be, blocks: (B:67:0x0180, B:69:0x0198), top: B:92:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x022f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x017d -> B:92:0x0180). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void listRoots() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout.listRoots():void");
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = ChatAttachAlertDocumentLayout.this.items.size();
            if (ChatAttachAlertDocumentLayout.this.history.isEmpty() && !ChatAttachAlertDocumentLayout.this.recentItems.isEmpty()) {
                size += ChatAttachAlertDocumentLayout.this.recentItems.size() + 2;
            }
            return size + 1;
        }

        public ListItem getItem(int i) {
            int size;
            int size2 = ChatAttachAlertDocumentLayout.this.items.size();
            if (i < size2) {
                return (ListItem) ChatAttachAlertDocumentLayout.this.items.get(i);
            }
            if (!ChatAttachAlertDocumentLayout.this.history.isEmpty() || ChatAttachAlertDocumentLayout.this.recentItems.isEmpty() || i == size2 || i == size2 + 1 || (size = i - (ChatAttachAlertDocumentLayout.this.items.size() + 2)) >= ChatAttachAlertDocumentLayout.this.recentItems.size()) {
                return null;
            }
            return (ListItem) ChatAttachAlertDocumentLayout.this.recentItems.get(size);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == getItemCount() - 1) {
                return 3;
            }
            int size = ChatAttachAlertDocumentLayout.this.items.size();
            if (i == size) {
                return 2;
            }
            return i == size + 1 ? 0 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View headerCell;
            View sharedDocumentCell;
            if (i != 0) {
                if (i == 1) {
                    sharedDocumentCell = new SharedDocumentCell(this.mContext, 1);
                } else if (i == 2) {
                    sharedDocumentCell = new ShadowSectionCell(this.mContext);
                    CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray)), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                    combinedDrawable.setFullsize(true);
                    sharedDocumentCell.setBackgroundDrawable(combinedDrawable);
                } else {
                    headerCell = new View(this.mContext);
                }
                headerCell = sharedDocumentCell;
            } else {
                headerCell = new HeaderCell(this.mContext);
            }
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (ChatAttachAlertDocumentLayout.this.sortByName) {
                    headerCell.setText(LocaleController.getString("RecentFilesAZ", R.string.RecentFilesAZ));
                    return;
                } else {
                    headerCell.setText(LocaleController.getString("RecentFiles", R.string.RecentFiles));
                    return;
                }
            }
            if (itemViewType != 1) {
                return;
            }
            ListItem item = getItem(i);
            SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
            int i2 = item.icon;
            if (i2 != 0) {
                sharedDocumentCell.setTextAndValueAndTypeAndThumb(item.title, item.subtitle, null, null, i2, i != ChatAttachAlertDocumentLayout.this.items.size() - 1);
            } else {
                sharedDocumentCell.setTextAndValueAndTypeAndThumb(item.title, item.subtitle, item.ext.toUpperCase().substring(0, Math.min(item.ext.length(), 4)), item.thumb, 0, false);
            }
            if (item.file != null) {
                sharedDocumentCell.setChecked(ChatAttachAlertDocumentLayout.this.selectedFiles.containsKey(item.file.toString()), !ChatAttachAlertDocumentLayout.this.scrolling);
            } else {
                sharedDocumentCell.setChecked(false, !ChatAttachAlertDocumentLayout.this.scrolling);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ChatAttachAlertDocumentLayout.this.updateEmptyView();
        }
    }

    public class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;
        private ArrayList<ListItem> searchResult = new ArrayList<>();
        private Runnable searchRunnable;

        public SearchAdapter(Context context) {
            this.mContext = context;
        }

        public void search(final String str) {
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable = null;
            }
            if (TextUtils.isEmpty(str)) {
                if (!this.searchResult.isEmpty()) {
                    this.searchResult.clear();
                }
                if (ChatAttachAlertDocumentLayout.this.listView.getAdapter() != ChatAttachAlertDocumentLayout.this.listAdapter) {
                    ChatAttachAlertDocumentLayout.this.listView.setAdapter(ChatAttachAlertDocumentLayout.this.listAdapter);
                }
                notifyDataSetChanged();
                return;
            }
            Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$SearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$1(str);
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$search$1(final String str) {
            final ArrayList arrayList = new ArrayList(ChatAttachAlertDocumentLayout.this.items);
            if (ChatAttachAlertDocumentLayout.this.history.isEmpty()) {
                arrayList.addAll(0, ChatAttachAlertDocumentLayout.this.recentItems);
            }
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$SearchAdapter$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$0(str, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$search$0(String str, ArrayList arrayList) {
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.length() == 0) {
                updateSearchResults(new ArrayList<>(), str);
                return;
            }
            String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
            if (lowerCase.equals(translitString) || translitString.length() == 0) {
                translitString = null;
            }
            int i = (translitString != null ? 1 : 0) + 1;
            String[] strArr = new String[i];
            strArr[0] = lowerCase;
            if (translitString != null) {
                strArr[1] = translitString;
            }
            ArrayList<ListItem> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ListItem listItem = (ListItem) arrayList.get(i2);
                File file = listItem.file;
                if (file != null && !file.isDirectory()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < i) {
                            String str2 = strArr[i3];
                            String str3 = listItem.title;
                            if (str3 != null ? str3.toLowerCase().contains(str2) : false) {
                                arrayList2.add(listItem);
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
            updateSearchResults(arrayList2, str);
        }

        private void updateSearchResults(final ArrayList<ListItem> arrayList, final String str) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ChatAttachAlertDocumentLayout$SearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$2(str, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$2(String str, ArrayList arrayList) {
            if (ChatAttachAlertDocumentLayout.this.searching) {
                if (ChatAttachAlertDocumentLayout.this.listView.getAdapter() != ChatAttachAlertDocumentLayout.this.searchAdapter) {
                    ChatAttachAlertDocumentLayout.this.listView.setAdapter(ChatAttachAlertDocumentLayout.this.searchAdapter);
                }
                ChatAttachAlertDocumentLayout.this.emptySubtitleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("NoFilesFoundInfo", R.string.NoFilesFoundInfo, str)));
            }
            this.searchResult = arrayList;
            notifyDataSetChanged();
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.searchResult.size() + 1;
        }

        public ListItem getItem(int i) {
            if (i < this.searchResult.size()) {
                return this.searchResult.get(i);
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View sharedDocumentCell;
            if (i == 0) {
                sharedDocumentCell = new SharedDocumentCell(this.mContext, 1);
            } else {
                sharedDocumentCell = new View(this.mContext);
            }
            return new RecyclerListView.Holder(sharedDocumentCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ListItem item = getItem(i);
                SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
                int i2 = item.icon;
                if (i2 != 0) {
                    sharedDocumentCell.setTextAndValueAndTypeAndThumb(item.title, item.subtitle, null, null, i2, false);
                } else {
                    sharedDocumentCell.setTextAndValueAndTypeAndThumb(item.title, item.subtitle, item.ext.toUpperCase().substring(0, Math.min(item.ext.length(), 4)), item.thumb, 0, false);
                }
                if (item.file != null) {
                    sharedDocumentCell.setChecked(ChatAttachAlertDocumentLayout.this.selectedFiles.containsKey(item.file.toString()), !ChatAttachAlertDocumentLayout.this.scrolling);
                } else {
                    sharedDocumentCell.setChecked(false, !ChatAttachAlertDocumentLayout.this.scrolling);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i < this.searchResult.size() ? 0 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ChatAttachAlertDocumentLayout.this.updateEmptyView();
        }
    }

    @Override // org.rbmain.ui.Components.ChatAttachAlert.AttachAlertLayout
    ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.searchItem.getSearchField(), ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, Theme.key_dialogTextBlack));
        arrayList.add(new ThemeDescription(this.emptyImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_dialogEmptyImage));
        TextView textView = this.emptyTitleTextView;
        int i = ThemeDescription.FLAG_IMAGECOLOR;
        int i2 = Theme.key_dialogEmptyText;
        arrayList.add(new ThemeDescription(textView, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.emptySubtitleTextView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, Theme.key_dialogScrollGlow));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkbox));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkboxCheck));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_folderIcon));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_folderIconBackground));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_iconText));
        return arrayList;
    }
}
