package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.SharedDocumentCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.FilteredSearchView;
import ir.eitaa.ui.PhotoPickerActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public class ChatAttachAlertDocumentLayout extends ChatAttachAlert.AttachAlertLayout {
    private float additionalTranslationY;
    private boolean allowMusic;
    private boolean canSelectOnlyImageFiles;
    private File currentDir;
    private DocumentSelectActivityDelegate delegate;
    private StickerEmptyView emptyView;
    private FiltersView filtersView;
    private AnimatorSet filtersViewAnimator;
    private boolean hasFiles;
    private ArrayList<HistoryEntry> history;
    private boolean ignoreLayout;
    private ArrayList<ListItem> items;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private FlickerLoadingView loadingView;
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
    private HashMap<FilteredSearchView.MessageHashId, MessageObject> selectedMessages;
    private boolean sendPressed;
    private boolean sortByName;
    private ActionBarMenuItem sortItem;

    public interface DocumentSelectActivityDelegate {

        /* renamed from: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout$DocumentSelectActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$startMusicSelectActivity(DocumentSelectActivityDelegate documentSelectActivityDelegate) {
            }
        }

        void didSelectFiles(ArrayList<String> files, String caption, ArrayList<MessageObject> fmessages, boolean notify, int scheduleDate);

        void didSelectPhotos(ArrayList<SendMessagesHelper.SendingMediaInfo> photos, boolean notify, int scheduleDate);

        void startDocumentSelectActivity();

        void startMusicSelectActivity();
    }

    static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
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
            this.subtitle = "";
            this.ext = "";
        }

        /* synthetic */ ListItem(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class HistoryEntry {
        File dir;
        int scrollItem;
        int scrollOffset;
        String title;

        private HistoryEntry() {
        }

        /* synthetic */ HistoryEntry(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context arg0, Intent intent) {
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$1$KPuO9EIc65mWXzuD0AzrN2lsvwc
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.lambda$onReceive$0$ChatAttachAlertDocumentLayout$1();
                }
            };
            if ("android.intent.action.MEDIA_UNMOUNTED".equals(intent.getAction())) {
                ChatAttachAlertDocumentLayout.this.listView.postDelayed(runnable, 1000L);
            } else {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onReceive$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onReceive$0$ChatAttachAlertDocumentLayout$1() throws Throwable {
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

    public ChatAttachAlertDocumentLayout(ChatAttachAlert alert, Context context, boolean music, Theme.ResourcesProvider resourcesProvider) throws Throwable {
        super(alert, context, resourcesProvider);
        this.items = new ArrayList<>();
        this.receiverRegistered = false;
        this.history = new ArrayList<>();
        this.selectedFiles = new HashMap<>();
        this.selectedFilesOrder = new ArrayList<>();
        this.selectedMessages = new HashMap<>();
        this.recentItems = new ArrayList<>();
        this.maxSelectedFiles = -1;
        this.receiver = new AnonymousClass1();
        this.allowMusic = music;
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
        ActionBarMenuItem actionBarMenuItemSearchListener = actionBarMenuCreateMenu.addItem(0, R.drawable.ic_ab_search).setIsSearchField(true).setActionBarMenuItemSearchListener(new ActionBarMenuItem.ActionBarMenuItemSearchListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.2
            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchExpand() {
                ChatAttachAlertDocumentLayout.this.searching = true;
                ChatAttachAlertDocumentLayout.this.sortItem.setVisibility(8);
                ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout = ChatAttachAlertDocumentLayout.this;
                chatAttachAlertDocumentLayout.parentAlert.makeFocusable(chatAttachAlertDocumentLayout.searchItem.getSearchField(), true);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchCollapse() {
                ChatAttachAlertDocumentLayout.this.searching = false;
                ChatAttachAlertDocumentLayout.this.sortItem.setVisibility(0);
                if (ChatAttachAlertDocumentLayout.this.listView.getAdapter() != ChatAttachAlertDocumentLayout.this.listAdapter) {
                    ChatAttachAlertDocumentLayout.this.listView.setAdapter(ChatAttachAlertDocumentLayout.this.listAdapter);
                }
                ChatAttachAlertDocumentLayout.this.listAdapter.notifyDataSetChanged();
                ChatAttachAlertDocumentLayout.this.searchAdapter.search(null, true);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onTextChanged(EditText editText) {
                ChatAttachAlertDocumentLayout.this.searchAdapter.search(editText.getText().toString(), false);
            }

            @Override // ir.eitaa.ui.ActionBar.ActionBarMenuItem.ActionBarMenuItemSearchListener
            public void onSearchFilterCleared(FiltersView.MediaFilterData filterData) {
                ChatAttachAlertDocumentLayout.this.searchAdapter.removeSearchFilter(filterData);
                ChatAttachAlertDocumentLayout.this.searchAdapter.search(ChatAttachAlertDocumentLayout.this.searchItem.getSearchField().getText().toString(), false);
                ChatAttachAlertDocumentLayout.this.searchAdapter.updateFiltersView(true, null, null, true);
            }
        });
        this.searchItem = actionBarMenuItemSearchListener;
        actionBarMenuItemSearchListener.setSearchFieldHint(LocaleController.getString("Search", R.string.Search));
        this.searchItem.setContentDescription(LocaleController.getString("Search", R.string.Search));
        EditTextBoldCursor searchField = this.searchItem.getSearchField();
        searchField.setTextColor(getThemedColor("dialogTextBlack"));
        searchField.setCursorColor(getThemedColor("dialogTextBlack"));
        searchField.setHintTextColor(getThemedColor("chat_messagePanelHint"));
        ActionBarMenuItem actionBarMenuItemAddItem = actionBarMenuCreateMenu.addItem(6, this.sortByName ? R.drawable.contacts_sort_time : R.drawable.contacts_sort_name);
        this.sortItem = actionBarMenuItemAddItem;
        actionBarMenuItemAddItem.setContentDescription(LocaleController.getString("AccDescrContactSorting", R.string.AccDescrContactSorting));
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context, resourcesProvider);
        this.loadingView = flickerLoadingView;
        addView(flickerLoadingView);
        int i = 1;
        StickerEmptyView stickerEmptyView = new StickerEmptyView(context, this.loadingView, i, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.3
            @Override // android.view.View
            public void setTranslationY(float translationY) {
                super.setTranslationY(translationY + ChatAttachAlertDocumentLayout.this.additionalTranslationY);
            }

            @Override // android.view.View
            public float getTranslationY() {
                return super.getTranslationY() - ChatAttachAlertDocumentLayout.this.additionalTranslationY;
            }
        };
        this.emptyView = stickerEmptyView;
        addView(stickerEmptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setVisibility(8);
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$Zg1OG8gexyOOcxlxCvOC6kr5Saw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChatAttachAlertDocumentLayout.lambda$new$0(view, motionEvent);
            }
        });
        RecyclerListView recyclerListView = new RecyclerListView(context, resourcesProvider);
        this.listView = recyclerListView;
        recyclerListView.setSectionsType(2);
        this.listView.setVerticalScrollBarEnabled(false);
        RecyclerListView recyclerListView2 = this.listView;
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(context, i, false, AndroidUtilities.dp(56.0f), this.listView) { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.4
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.4.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view, int snapPreference) {
                        return super.calculateDyToMakeVisible(view, snapPreference) - (ChatAttachAlertDocumentLayout.this.listView.getPaddingTop() - AndroidUtilities.dp(56.0f));
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int calculateTimeForDeceleration(int dx) {
                        return super.calculateTimeForDeceleration(dx) * 2;
                    }
                };
                linearSmoothScroller.setTargetPosition(position);
                startSmoothScroll(linearSmoothScroller);
            }
        };
        this.layoutManager = fillLastLinearLayoutManager;
        recyclerListView2.setLayoutManager(fillLastLinearLayoutManager);
        this.listView.setClipToPadding(false);
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
        addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.searchAdapter = new SearchAdapter(context);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                ChatAttachAlertDocumentLayout chatAttachAlertDocumentLayout = ChatAttachAlertDocumentLayout.this;
                chatAttachAlertDocumentLayout.parentAlert.updateLayout(chatAttachAlertDocumentLayout, true, dy);
                ChatAttachAlertDocumentLayout.this.updateEmptyViewPosition();
                if (ChatAttachAlertDocumentLayout.this.listView.getAdapter() == ChatAttachAlertDocumentLayout.this.searchAdapter) {
                    int iFindFirstVisibleItemPosition = ChatAttachAlertDocumentLayout.this.layoutManager.findFirstVisibleItemPosition();
                    int iFindLastVisibleItemPosition = ChatAttachAlertDocumentLayout.this.layoutManager.findLastVisibleItemPosition();
                    int iAbs = Math.abs(iFindLastVisibleItemPosition - iFindFirstVisibleItemPosition) + 1;
                    int itemCount = recyclerView.getAdapter().getItemCount();
                    if (iAbs <= 0 || iFindLastVisibleItemPosition < itemCount - 10) {
                        return;
                    }
                    ChatAttachAlertDocumentLayout.this.searchAdapter.loadMore();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                RecyclerListView.Holder holder;
                if (newState == 0) {
                    int iDp = AndroidUtilities.dp(13.0f);
                    int backgroundPaddingTop = ChatAttachAlertDocumentLayout.this.parentAlert.getBackgroundPaddingTop();
                    if (((ChatAttachAlertDocumentLayout.this.parentAlert.scrollOffsetY[0] - backgroundPaddingTop) - iDp) + backgroundPaddingTop < ActionBar.getCurrentActionBarHeight() && (holder = (RecyclerListView.Holder) ChatAttachAlertDocumentLayout.this.listView.findViewHolderForAdapterPosition(0)) != null && holder.itemView.getTop() > AndroidUtilities.dp(56.0f)) {
                        ChatAttachAlertDocumentLayout.this.listView.smoothScrollBy(0, holder.itemView.getTop() - AndroidUtilities.dp(56.0f));
                    }
                }
                if (newState == 1 && ChatAttachAlertDocumentLayout.this.searching && ChatAttachAlertDocumentLayout.this.listView.getAdapter() == ChatAttachAlertDocumentLayout.this.searchAdapter) {
                    AndroidUtilities.hideKeyboard(ChatAttachAlertDocumentLayout.this.parentAlert.getCurrentFocus());
                }
                ChatAttachAlertDocumentLayout.this.scrolling = newState != 0;
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$qz5P4t0xsdk7lfij7cpoCqcjIvw
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) throws Throwable {
                this.f$0.lambda$new$1$ChatAttachAlertDocumentLayout(view, i2);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$-jca5zvcSMXxp7x94CIN4t6NttE
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i2) {
                return this.f$0.lambda$new$2$ChatAttachAlertDocumentLayout(view, i2);
            }
        });
        FiltersView filtersView = new FiltersView(context, resourcesProvider);
        this.filtersView = filtersView;
        filtersView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$Hmtu0b8jIF33HMZXF-NoVkub0M0
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$new$3$ChatAttachAlertDocumentLayout(view, i2);
            }
        });
        this.filtersView.setBackgroundColor(getThemedColor("dialogBackground"));
        addView(this.filtersView, LayoutHelper.createFrame(-1, -2, 48));
        this.filtersView.setTranslationY(-AndroidUtilities.dp(44.0f));
        this.filtersView.setVisibility(4);
        listRoots();
        updateSearchButton();
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatAttachAlertDocumentLayout(View view, int i) throws Throwable {
        Object item;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        ListAdapter listAdapter = this.listAdapter;
        if (adapter == listAdapter) {
            item = listAdapter.getItem(i);
        } else {
            item = this.searchAdapter.getItem(i);
        }
        if (item instanceof ListItem) {
            ListItem listItem = (ListItem) item;
            File file = listItem.file;
            Object[] objArr = 0;
            if (file == null) {
                int i2 = listItem.icon;
                if (i2 == R.drawable.files_gallery) {
                    final HashMap map = new HashMap();
                    final ArrayList arrayList = new ArrayList();
                    BaseFragment baseFragment = this.parentAlert.baseFragment;
                    ChatActivity chatActivity = baseFragment instanceof ChatActivity ? (ChatActivity) baseFragment : null;
                    PhotoPickerActivity photoPickerActivity = new PhotoPickerActivity(0, MediaController.allMediaAlbumEntry, map, arrayList, 0, chatActivity != null, chatActivity, false);
                    photoPickerActivity.setDocumentsPicker(true);
                    photoPickerActivity.setDelegate(new PhotoPickerActivity.PhotoPickerActivityDelegate() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.6
                        @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                        public void onCaptionChanged(CharSequence text) {
                        }

                        @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                        public void selectedPhotosChanged() {
                        }

                        @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                        public void actionButtonPressed(boolean canceled, boolean notify, int scheduleDate) {
                            if (canceled) {
                                return;
                            }
                            ChatAttachAlertDocumentLayout.this.sendSelectedPhotos(map, arrayList, notify, scheduleDate);
                        }

                        @Override // ir.eitaa.ui.PhotoPickerActivity.PhotoPickerActivityDelegate
                        public void onOpenInPressed() {
                            ChatAttachAlertDocumentLayout.this.delegate.startDocumentSelectActivity();
                        }
                    });
                    photoPickerActivity.setMaxSelectedPhotos(this.maxSelectedFiles, false);
                    this.parentAlert.baseFragment.presentFragment(photoPickerActivity);
                    this.parentAlert.dismiss();
                    return;
                }
                if (i2 == R.drawable.files_music) {
                    DocumentSelectActivityDelegate documentSelectActivityDelegate = this.delegate;
                    if (documentSelectActivityDelegate != null) {
                        documentSelectActivityDelegate.startMusicSelectActivity();
                        return;
                    }
                    return;
                }
                if (!BuildVars.NO_SCOPED_STORAGE && i2 == R.drawable.files_storage) {
                    this.delegate.startDocumentSelectActivity();
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
                RecyclerView.ViewHolder viewHolderFindContainingViewHolder = this.listView.findContainingViewHolder(childAt);
                if (viewHolderFindContainingViewHolder != null) {
                    historyEntry.scrollItem = viewHolderFindContainingViewHolder.getAdapterPosition();
                    historyEntry.scrollOffset = childAt.getTop();
                    historyEntry.dir = this.currentDir;
                    historyEntry.title = this.parentAlert.actionBar.getTitle();
                    this.history.add(historyEntry);
                    if (!listFiles(file)) {
                        this.history.remove(historyEntry);
                        return;
                    } else {
                        this.parentAlert.actionBar.setTitle(listItem.title);
                        return;
                    }
                }
                return;
            }
            onItemClick(view, listItem);
            return;
        }
        onItemClick(view, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$2$ChatAttachAlertDocumentLayout(View view, int i) {
        Object item;
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        ListAdapter listAdapter = this.listAdapter;
        if (adapter == listAdapter) {
            item = listAdapter.getItem(i);
        } else {
            item = this.searchAdapter.getItem(i);
        }
        return onItemClick(view, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ChatAttachAlertDocumentLayout(View view, int i) {
        this.filtersView.cancelClickRunnables(true);
        this.searchAdapter.addSearchFilter(this.filtersView.getFilterAt(i));
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
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

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onMenuItemClick(int id) {
        if (id == 6) {
            SharedConfig.toggleSortFilesByName();
            this.sortByName = SharedConfig.sortFilesByName;
            sortRecentItems();
            sortFileItems();
            this.listAdapter.notifyDataSetChanged();
            this.sortItem.setIcon(this.sortByName ? R.drawable.contacts_sort_time : R.drawable.contacts_sort_name);
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
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
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        this.parentAlert.getSheetContainer().invalidate();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.listView.getPaddingTop();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(5.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r4, int r5) {
        /*
            r3 = this;
            ir.eitaa.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            ir.eitaa.ui.ActionBar.ActionBar r4 = r4.actionBar
            boolean r4 = r4.isSearchFieldVisible()
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L45
            ir.eitaa.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            ir.eitaa.ui.Components.SizeNotifierFrameLayout r4 = r4.sizeNotifierFrameLayout
            int r4 = r4.measureKeyboardHeight()
            r2 = 1101004800(0x41a00000, float:20.0)
            int r2 = ir.eitaa.messenger.AndroidUtilities.dp(r2)
            if (r4 <= r2) goto L1d
            goto L45
        L1d:
            boolean r4 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r4 != 0) goto L31
            android.graphics.Point r4 = ir.eitaa.messenger.AndroidUtilities.displaySize
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
            int r5 = ir.eitaa.messenger.AndroidUtilities.dp(r5)
            int r4 = r4 - r5
            if (r4 >= 0) goto L3f
            r4 = 0
        L3f:
            ir.eitaa.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r0)
            goto L50
        L45:
            r4 = 1113587712(0x42600000, float:56.0)
            int r4 = ir.eitaa.messenger.AndroidUtilities.dp(r4)
            ir.eitaa.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r1)
        L50:
            ir.eitaa.ui.Components.RecyclerListView r5 = r3.listView
            int r5 = r5.getPaddingTop()
            if (r5 == r4) goto L67
            r3.ignoreLayout = r0
            ir.eitaa.ui.Components.RecyclerListView r5 = r3.listView
            r0 = 1111490560(0x42400000, float:48.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            r5.setPadding(r1, r4, r1, r0)
            r3.ignoreLayout = r1
        L67:
            ir.eitaa.ui.Adapters.FiltersView r4 = r3.filtersView
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r4 = (android.widget.FrameLayout.LayoutParams) r4
            int r5 = ir.eitaa.ui.ActionBar.ActionBar.getCurrentActionBarHeight()
            r4.topMargin = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.onPreMeasure(int, int):void");
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
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

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.listView.smoothScrollToPosition(0);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getSelectedItemsCount() {
        return this.selectedFiles.size() + this.selectedMessages.size();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void sendSelectedItems(boolean notify, int scheduleDate) {
        if ((this.selectedFiles.size() == 0 && this.selectedMessages.size() == 0) || this.delegate == null || this.sendPressed) {
            return;
        }
        this.sendPressed = true;
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        Iterator<FilteredSearchView.MessageHashId> it = this.selectedMessages.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.selectedMessages.get(it.next()));
        }
        this.delegate.didSelectFiles(new ArrayList<>(this.selectedFilesOrder), this.parentAlert.commentTextView.getText().toString(), arrayList, notify, scheduleDate);
        this.parentAlert.dismiss();
    }

    private boolean onItemClick(View view, Object object) {
        boolean z;
        boolean z2 = false;
        if (object instanceof ListItem) {
            ListItem listItem = (ListItem) object;
            File file = listItem.file;
            if (file == null || file.isDirectory()) {
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
        } else {
            if (!(object instanceof MessageObject)) {
                return false;
            }
            MessageObject messageObject = (MessageObject) object;
            FilteredSearchView.MessageHashId messageHashId = new FilteredSearchView.MessageHashId(messageObject.getId(), messageObject.getDialogId());
            if (this.selectedMessages.containsKey(messageHashId)) {
                this.selectedMessages.remove(messageHashId);
            } else {
                if (this.selectedMessages.size() >= 100) {
                    return false;
                }
                this.selectedMessages.put(messageHashId, messageObject);
                z2 = true;
            }
            z = z2;
        }
        if (view instanceof SharedDocumentCell) {
            ((SharedDocumentCell) view).setChecked(z, true);
        }
        this.parentAlert.updateCountButton(z ? 1 : 2);
        return true;
    }

    public void setMaxSelectedFiles(int value) {
        this.maxSelectedFiles = value;
    }

    public void setCanSelectOnlyImageFiles(boolean value) {
        this.canSelectOnlyImageFiles = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSelectedPhotos(HashMap<Object, Object> photos, ArrayList<Object> order, boolean notify, int scheduleDate) {
        if (photos.isEmpty() || this.delegate == null || this.sendPressed) {
            return;
        }
        this.sendPressed = true;
        ArrayList<SendMessagesHelper.SendingMediaInfo> arrayList = new ArrayList<>();
        for (int i = 0; i < order.size(); i++) {
            Object obj = photos.get(order.get(i));
            SendMessagesHelper.SendingMediaInfo sendingMediaInfo = new SendMessagesHelper.SendingMediaInfo();
            arrayList.add(sendingMediaInfo);
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
        this.delegate.didSelectPhotos(arrayList, notify, scheduleDate);
    }

    public void loadRecentFiles() {
        try {
            File[] fileArrListFiles = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
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
            }
            sortRecentItems();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void sortRecentItems() {
        Collections.sort(this.recentItems, new $$Lambda$ChatAttachAlertDocumentLayout$Pm3LUTmLMAMA7y69KDq5pgz_MI(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sortRecentItems$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$sortRecentItems$4$ChatAttachAlertDocumentLayout(ListItem listItem, ListItem listItem2) {
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
        Collections.sort(this.items, new $$Lambda$ChatAttachAlertDocumentLayout$J2mYoroTGL7QArpEXtHjQ_AFtWk(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sortFileItems$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ int lambda$sortFileItems$5$ChatAttachAlertDocumentLayout(ListItem listItem, ListItem listItem2) {
        File file = listItem.file;
        if (file == null) {
            return -1;
        }
        if (listItem2.file == null) {
            return 1;
        }
        boolean zIsDirectory = file.isDirectory();
        if (zIsDirectory != listItem2.file.isDirectory()) {
            return zIsDirectory ? -1 : 1;
        }
        if (zIsDirectory || this.sortByName) {
            return listItem.file.getName().compareToIgnoreCase(listItem2.file.getName());
        }
        long jLastModified = listItem.file.lastModified();
        long jLastModified2 = listItem2.file.lastModified();
        if (jLastModified == jLastModified2) {
            return 0;
        }
        return jLastModified > jLastModified2 ? -1 : 1;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
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

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() throws Throwable {
        this.selectedFiles.clear();
        this.selectedMessages.clear();
        this.searchAdapter.currentSearchFilters.clear();
        this.selectedFilesOrder.clear();
        this.history.clear();
        listRoots();
        updateSearchButton();
        updateEmptyView();
        this.parentAlert.actionBar.setTitle(LocaleController.getString("SelectFile", R.string.SelectFile));
        this.sortItem.setVisibility(0);
        this.layoutManager.scrollToPositionWithOffset(0, 0);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHide() {
        this.sortItem.setVisibility(8);
        this.searchItem.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyViewPosition() {
        View childAt;
        if (this.emptyView.getVisibility() == 0 && (childAt = this.listView.getChildAt(0)) != null) {
            float translationY = this.emptyView.getTranslationY();
            this.additionalTranslationY = ((this.emptyView.getMeasuredHeight() - getMeasuredHeight()) + childAt.getTop()) / 2;
            this.emptyView.setTranslationY(translationY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyView() {
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchAdapter;
        boolean z = true;
        if (adapter != searchAdapter ? this.listAdapter.getItemCount() != 1 : !searchAdapter.searchResult.isEmpty() || !this.searchAdapter.sections.isEmpty()) {
            z = false;
        }
        this.emptyView.setVisibility(z ? 0 : 8);
        updateEmptyViewPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSearchButton() {
        ActionBarMenuItem actionBarMenuItem = this.searchItem;
        if (actionBarMenuItem == null || actionBarMenuItem.isSearchFieldVisible()) {
            return;
        }
        this.searchItem.setVisibility((this.hasFiles || this.history.isEmpty()) ? 0 : 8);
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

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public boolean onBackPressed() {
        if (canClosePicker()) {
            return super.onBackPressed();
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateEmptyViewPosition();
    }

    public void setDelegate(DocumentSelectActivityDelegate documentSelectActivityDelegate) {
        this.delegate = documentSelectActivityDelegate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean listFiles(File dir) {
        AnonymousClass1 anonymousClass1;
        this.hasFiles = false;
        if (!dir.canRead()) {
            if ((dir.getAbsolutePath().startsWith(Environment.getExternalStorageDirectory().toString()) || dir.getAbsolutePath().startsWith("/sdcard") || dir.getAbsolutePath().startsWith("/mnt/sdcard")) && !Environment.getExternalStorageState().equals("mounted") && !Environment.getExternalStorageState().equals("mounted_ro")) {
                this.currentDir = dir;
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
            File[] fileArrListFiles = dir.listFiles();
            if (fileArrListFiles == null) {
                showErrorBox(LocaleController.getString("UnknownError", R.string.UnknownError));
                return false;
            }
            this.currentDir = dir;
            this.items.clear();
            int i = 0;
            while (true) {
                anonymousClass1 = null;
                if (i >= fileArrListFiles.length) {
                    break;
                }
                File file = fileArrListFiles[i];
                if (file.getName().indexOf(46) != 0) {
                    ListItem listItem = new ListItem(anonymousClass1);
                    listItem.title = file.getName();
                    listItem.file = file;
                    if (file.isDirectory()) {
                        listItem.icon = R.drawable.files_folder;
                        listItem.subtitle = LocaleController.getString("Folder", R.string.Folder);
                    } else {
                        this.hasFiles = true;
                        String name = file.getName();
                        String[] strArrSplit = name.split("\\.");
                        listItem.ext = strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 1] : "?";
                        listItem.subtitle = AndroidUtilities.formatFileSize(file.length());
                        String lowerCase = name.toLowerCase();
                        if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".jpeg")) {
                            listItem.thumb = file.getAbsolutePath();
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
                File file2 = arrayList.get(arrayList.size() - 1).dir;
                if (file2 == null) {
                    listItem2.subtitle = LocaleController.getString("Folder", R.string.Folder);
                } else {
                    listItem2.subtitle = file2.toString();
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

    private void showErrorBox(String error) {
        new AlertDialog.Builder(getContext(), this.resourcesProvider).setTitle(LocaleController.getString("AppName", R.string.AppName)).setMessage(error).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0243 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b1 A[Catch: Exception -> 0x01d0, TRY_LEAVE, TryCatch #0 {Exception -> 0x01d0, blocks: (B:70:0x01a2, B:72:0x01b1), top: B:94:0x01a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x022f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x019e -> B:94:0x01a2). Please report as a decompilation issue!!! */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void listRoots() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 591
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.listRoots():void");
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = ChatAttachAlertDocumentLayout.this.items.size();
            if (ChatAttachAlertDocumentLayout.this.history.isEmpty() && !ChatAttachAlertDocumentLayout.this.recentItems.isEmpty()) {
                size += ChatAttachAlertDocumentLayout.this.recentItems.size() + 2;
            }
            return size + 1;
        }

        public ListItem getItem(int position) {
            int size;
            int size2 = ChatAttachAlertDocumentLayout.this.items.size();
            if (position < size2) {
                return (ListItem) ChatAttachAlertDocumentLayout.this.items.get(position);
            }
            if (!ChatAttachAlertDocumentLayout.this.history.isEmpty() || ChatAttachAlertDocumentLayout.this.recentItems.isEmpty() || position == size2 || position == size2 + 1 || (size = position - (ChatAttachAlertDocumentLayout.this.items.size() + 2)) >= ChatAttachAlertDocumentLayout.this.recentItems.size()) {
                return null;
            }
            return (ListItem) ChatAttachAlertDocumentLayout.this.recentItems.get(size);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == getItemCount() - 1) {
                return 3;
            }
            int size = ChatAttachAlertDocumentLayout.this.items.size();
            if (position == size) {
                return 2;
            }
            return position == size + 1 ? 0 : 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View headerCell;
            View sharedDocumentCell;
            if (viewType != 0) {
                if (viewType == 1) {
                    sharedDocumentCell = new SharedDocumentCell(this.mContext, 1, ChatAttachAlertDocumentLayout.this.resourcesProvider);
                } else if (viewType == 2) {
                    sharedDocumentCell = new ShadowSectionCell(this.mContext);
                    CombinedDrawable combinedDrawable = new CombinedDrawable(new ColorDrawable(ChatAttachAlertDocumentLayout.this.getThemedColor("windowBackgroundGray")), Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                    combinedDrawable.setFullsize(true);
                    sharedDocumentCell.setBackgroundDrawable(combinedDrawable);
                } else {
                    headerCell = new View(this.mContext);
                }
                headerCell = sharedDocumentCell;
            } else {
                headerCell = new HeaderCell(this.mContext, ChatAttachAlertDocumentLayout.this.resourcesProvider);
            }
            return new RecyclerListView.Holder(headerCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) holder.itemView;
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
            ListItem item = getItem(position);
            SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) holder.itemView;
            int i = item.icon;
            if (i != 0) {
                sharedDocumentCell.setTextAndValueAndTypeAndThumb(item.title, item.subtitle, null, null, i, position != ChatAttachAlertDocumentLayout.this.items.size() - 1);
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

    public class SearchAdapter extends RecyclerListView.SectionsAdapter {
        private String currentDataQuery;
        private long currentSearchDialogId;
        private FiltersView.MediaFilterData currentSearchFilter;
        private long currentSearchMaxDate;
        private long currentSearchMinDate;
        private boolean endReached;
        private boolean isLoading;
        private String lastMessagesSearchString;
        private String lastSearchFilterQueryString;
        private Runnable localSearchRunnable;
        private Context mContext;
        private int nextSearchRate;
        private int requestIndex;
        private Runnable searchRunnable;
        private ArrayList<ListItem> searchResult = new ArrayList<>();
        private final FilteredSearchView.MessageHashId messageHashIdTmp = new FilteredSearchView.MessageHashId(0, 0);
        private ArrayList<Object> localTipChats = new ArrayList<>();
        private ArrayList<FiltersView.DateData> localTipDates = new ArrayList<>();
        public ArrayList<MessageObject> messages = new ArrayList<>();
        public SparseArray<MessageObject> messagesById = new SparseArray<>();
        public ArrayList<String> sections = new ArrayList<>();
        public HashMap<String, ArrayList<MessageObject>> sectionArrays = new HashMap<>();
        private ArrayList<FiltersView.MediaFilterData> currentSearchFilters = new ArrayList<>();
        private boolean firstLoading = true;
        private int animationIndex = -1;
        private Runnable clearCurrentResultsRunnable = new Runnable() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                if (SearchAdapter.this.isLoading) {
                    SearchAdapter.this.messages.clear();
                    SearchAdapter.this.sections.clear();
                    SearchAdapter.this.sectionArrays.clear();
                    SearchAdapter.this.notifyDataSetChanged();
                }
            }
        };

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return 0;
        }

        public SearchAdapter(Context context) {
            this.mContext = context;
        }

        public void search(final String query, boolean reset) {
            long j;
            Runnable runnable = this.localSearchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.localSearchRunnable = null;
            }
            if (TextUtils.isEmpty(query)) {
                if (!this.searchResult.isEmpty()) {
                    this.searchResult.clear();
                }
                if (ChatAttachAlertDocumentLayout.this.listView.getAdapter() != ChatAttachAlertDocumentLayout.this.listAdapter) {
                    ChatAttachAlertDocumentLayout.this.listView.setAdapter(ChatAttachAlertDocumentLayout.this.listAdapter);
                }
                notifyDataSetChanged();
            } else {
                Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$SearchAdapter$YUFREQsFjcrFgzGzqCIHocUzHpo
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$search$1$ChatAttachAlertDocumentLayout$SearchAdapter(query);
                    }
                };
                this.localSearchRunnable = runnable2;
                AndroidUtilities.runOnUIThread(runnable2, 300L);
            }
            if (ChatAttachAlertDocumentLayout.this.canSelectOnlyImageFiles || !ChatAttachAlertDocumentLayout.this.history.isEmpty()) {
                return;
            }
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            for (int i = 0; i < this.currentSearchFilters.size(); i++) {
                FiltersView.MediaFilterData mediaFilterData = this.currentSearchFilters.get(i);
                int i2 = mediaFilterData.filterType;
                if (i2 == 4) {
                    TLObject tLObject = mediaFilterData.chat;
                    if (tLObject instanceof TLRPC$User) {
                        j = ((TLRPC$User) tLObject).id;
                    } else if (tLObject instanceof TLRPC$Chat) {
                        j = -((TLRPC$Chat) tLObject).id;
                    }
                    j4 = j;
                } else if (i2 == 6) {
                    FiltersView.DateData dateData = mediaFilterData.dateData;
                    j2 = dateData.minDate;
                    j3 = dateData.maxDate;
                }
            }
            searchGlobal(j4, j2, j3, FiltersView.filters[2], query, reset);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$1$ChatAttachAlertDocumentLayout$SearchAdapter(final String str) {
            final ArrayList arrayList = new ArrayList(ChatAttachAlertDocumentLayout.this.items);
            if (ChatAttachAlertDocumentLayout.this.history.isEmpty()) {
                arrayList.addAll(0, ChatAttachAlertDocumentLayout.this.recentItems);
            }
            final boolean z = !this.currentSearchFilters.isEmpty();
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$SearchAdapter$_mA3RyizHwE2MZ5gedonia44LEk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$0$ChatAttachAlertDocumentLayout$SearchAdapter(str, z, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$0$ChatAttachAlertDocumentLayout$SearchAdapter(String str, boolean z, ArrayList arrayList) {
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
            if (!z) {
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
            }
            updateSearchResults(arrayList2, str);
        }

        public void loadMore() {
            FiltersView.MediaFilterData mediaFilterData;
            if (ChatAttachAlertDocumentLayout.this.searchAdapter.isLoading || ChatAttachAlertDocumentLayout.this.searchAdapter.endReached || (mediaFilterData = this.currentSearchFilter) == null) {
                return;
            }
            searchGlobal(this.currentSearchDialogId, this.currentSearchMinDate, this.currentSearchMaxDate, mediaFilterData, this.lastMessagesSearchString, false);
        }

        public void removeSearchFilter(FiltersView.MediaFilterData filterData) {
            this.currentSearchFilters.remove(filterData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSearchFilter(FiltersView.MediaFilterData filter) {
            if (!this.currentSearchFilters.isEmpty()) {
                for (int i = 0; i < this.currentSearchFilters.size(); i++) {
                    if (filter.isSameType(this.currentSearchFilters.get(i))) {
                        return;
                    }
                }
            }
            this.currentSearchFilters.add(filter);
            ChatAttachAlertDocumentLayout.this.parentAlert.actionBar.setSearchFilter(filter);
            ChatAttachAlertDocumentLayout.this.parentAlert.actionBar.setSearchFieldText("");
            updateFiltersView(true, null, null, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void updateFiltersView(boolean r9, java.util.ArrayList<java.lang.Object> r10, java.util.ArrayList<ir.eitaa.ui.Adapters.FiltersView.DateData> r11, boolean r12) {
            /*
                Method dump skipped, instructions count: 502
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.updateFiltersView(boolean, java.util.ArrayList, java.util.ArrayList, boolean):void");
        }

        private void searchGlobal(final long dialogId, final long minDate, final long maxDate, FiltersView.MediaFilterData searchFilter, final String query, boolean clearOldResults) {
            final String str = String.format(Locale.ENGLISH, "%d%d%d%d%s", Long.valueOf(dialogId), Long.valueOf(minDate), Long.valueOf(maxDate), Integer.valueOf(searchFilter.filterType), query);
            String str2 = this.lastSearchFilterQueryString;
            boolean z = str2 != null && str2.equals(str);
            boolean z2 = !z && clearOldResults;
            if (dialogId == this.currentSearchDialogId && this.currentSearchMinDate == minDate) {
                int i = (this.currentSearchMaxDate > maxDate ? 1 : (this.currentSearchMaxDate == maxDate ? 0 : -1));
            }
            this.currentSearchFilter = searchFilter;
            this.currentSearchDialogId = dialogId;
            this.currentSearchMinDate = minDate;
            this.currentSearchMaxDate = maxDate;
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            AndroidUtilities.cancelRunOnUIThread(this.clearCurrentResultsRunnable);
            if (z && clearOldResults) {
                return;
            }
            if (z2) {
                this.messages.clear();
                this.sections.clear();
                this.sectionArrays.clear();
                this.isLoading = true;
                ChatAttachAlertDocumentLayout.this.emptyView.setVisibility(0);
                notifyDataSetChanged();
                this.requestIndex++;
                this.firstLoading = true;
                if (ChatAttachAlertDocumentLayout.this.listView.getPinnedHeader() != null) {
                    ChatAttachAlertDocumentLayout.this.listView.getPinnedHeader().setAlpha(0.0f);
                }
                this.localTipChats.clear();
                this.localTipDates.clear();
            }
            this.isLoading = true;
            notifyDataSetChanged();
            if (!z) {
                this.clearCurrentResultsRunnable.run();
                ChatAttachAlertDocumentLayout.this.emptyView.showProgress(true, !clearOldResults);
            }
            if (TextUtils.isEmpty(query)) {
                this.localTipDates.clear();
                this.localTipChats.clear();
                updateFiltersView(false, null, null, true);
                return;
            }
            final int i2 = 1 + this.requestIndex;
            this.requestIndex = i2;
            final AccountInstance accountInstance = AccountInstance.getInstance(UserConfig.selectedAccount);
            final boolean z3 = z;
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$SearchAdapter$F37PKoAHWv4CboskBRtl0bQx9oY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchGlobal$4$ChatAttachAlertDocumentLayout$SearchAdapter(dialogId, query, accountInstance, minDate, maxDate, z3, str, i2);
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, (!z || this.messages.isEmpty()) ? 350L : 0L);
            ChatAttachAlertDocumentLayout.this.loadingView.setViewType(3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00e2 A[PHI: r4
          0x00e2: PHI (r4v4 long) = (r4v1 long), (r4v2 long) binds: [B:33:0x00e0, B:36:0x00e8] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: lambda$searchGlobal$4, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$searchGlobal$4$ChatAttachAlertDocumentLayout$SearchAdapter(final long r21, final java.lang.String r23, final ir.eitaa.messenger.AccountInstance r24, final long r25, long r27, final boolean r29, java.lang.String r30, final int r31) {
            /*
                Method dump skipped, instructions count: 306
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.lambda$searchGlobal$4$ChatAttachAlertDocumentLayout$SearchAdapter(long, java.lang.String, ir.eitaa.messenger.AccountInstance, long, long, boolean, java.lang.String, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchGlobal$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchGlobal$3$ChatAttachAlertDocumentLayout$SearchAdapter(final AccountInstance accountInstance, final String str, final int i, final boolean z, final long j, final long j2, final ArrayList arrayList, final ArrayList arrayList2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            final ArrayList arrayList3 = new ArrayList();
            if (tLRPC$TL_error == null) {
                TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
                int size = tLRPC$messages_Messages.messages.size();
                for (int i2 = 0; i2 < size; i2++) {
                    MessageObject messageObject = new MessageObject(accountInstance.getCurrentAccount(), tLRPC$messages_Messages.messages.get(i2), false, true);
                    messageObject.setQuery(str);
                    arrayList3.add(messageObject);
                }
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$SearchAdapter$at5Men-3i2niX9iPEUPrf6nHEEg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchGlobal$2$ChatAttachAlertDocumentLayout$SearchAdapter(i, tLRPC$TL_error, tLObject, accountInstance, z, str, arrayList3, j, j2, arrayList, arrayList2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchGlobal$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchGlobal$2$ChatAttachAlertDocumentLayout$SearchAdapter(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, final AccountInstance accountInstance, boolean z, String str, ArrayList arrayList, long j, long j2, ArrayList arrayList2, ArrayList arrayList3) {
            boolean z2;
            if (i != this.requestIndex) {
                return;
            }
            this.isLoading = false;
            if (tLRPC$TL_error != null) {
                ChatAttachAlertDocumentLayout.this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
                ChatAttachAlertDocumentLayout.this.emptyView.subtitle.setVisibility(0);
                ChatAttachAlertDocumentLayout.this.emptyView.showProgress(false, true);
                return;
            }
            ChatAttachAlertDocumentLayout.this.emptyView.showProgress(false);
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            this.nextSearchRate = tLRPC$messages_Messages.next_rate;
            accountInstance.getMessagesStorage().putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
            accountInstance.getMessagesController().putUsers(tLRPC$messages_Messages.users, false);
            accountInstance.getMessagesController().putChats(tLRPC$messages_Messages.chats, false);
            if (!z) {
                this.messages.clear();
                this.messagesById.clear();
                this.sections.clear();
                this.sectionArrays.clear();
            }
            int size = tLRPC$messages_Messages.count;
            this.currentDataQuery = str;
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                MessageObject messageObject = (MessageObject) arrayList.get(i2);
                ArrayList<MessageObject> arrayList4 = this.sectionArrays.get(messageObject.monthKey);
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList<>();
                    this.sectionArrays.put(messageObject.monthKey, arrayList4);
                    this.sections.add(messageObject.monthKey);
                }
                arrayList4.add(messageObject);
                this.messages.add(messageObject);
                this.messagesById.put(messageObject.getId(), messageObject);
            }
            if (this.messages.size() > size) {
                size = this.messages.size();
            }
            this.endReached = this.messages.size() >= size;
            if (this.messages.isEmpty()) {
                if (!TextUtils.isEmpty(this.currentDataQuery) || j != 0 || j2 != 0) {
                    ChatAttachAlertDocumentLayout.this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
                    ChatAttachAlertDocumentLayout.this.emptyView.subtitle.setVisibility(0);
                } else {
                    ChatAttachAlertDocumentLayout.this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle", R.string.SearchEmptyViewTitle));
                    ChatAttachAlertDocumentLayout.this.emptyView.subtitle.setVisibility(0);
                }
            }
            if (!z) {
                this.localTipChats.clear();
                if (arrayList2 != null) {
                    this.localTipChats.addAll(arrayList2);
                }
                if (str.length() >= 3 && (LocaleController.getString("SavedMessages", R.string.SavedMessages).toLowerCase().startsWith(str) || "saved messages".startsWith(str))) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= this.localTipChats.size()) {
                            z2 = false;
                            break;
                        } else {
                            if ((this.localTipChats.get(i3) instanceof TLRPC$User) && UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser().id == ((TLRPC$User) this.localTipChats.get(i3)).id) {
                                z2 = true;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z2) {
                        this.localTipChats.add(0, UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser());
                    }
                }
                this.localTipDates.clear();
                this.localTipDates.addAll(arrayList3);
                updateFiltersView(TextUtils.isEmpty(this.currentDataQuery), this.localTipChats, this.localTipDates, true);
            }
            this.firstLoading = false;
            final View view = null;
            final int childAdapterPosition = -1;
            for (int i4 = 0; i4 < size2; i4++) {
                View childAt = ChatAttachAlertDocumentLayout.this.listView.getChildAt(i4);
                if (childAt instanceof FlickerLoadingView) {
                    childAdapterPosition = ChatAttachAlertDocumentLayout.this.listView.getChildAdapterPosition(childAt);
                    view = childAt;
                }
            }
            if (view != null) {
                ChatAttachAlertDocumentLayout.this.listView.removeView(view);
            }
            if ((ChatAttachAlertDocumentLayout.this.loadingView.getVisibility() == 0 && ChatAttachAlertDocumentLayout.this.listView.getChildCount() <= 1) || view != null) {
                ChatAttachAlertDocumentLayout.this.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.3
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        ChatAttachAlertDocumentLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
                        int childCount = ChatAttachAlertDocumentLayout.this.listView.getChildCount();
                        AnimatorSet animatorSet = new AnimatorSet();
                        for (int i5 = 0; i5 < childCount; i5++) {
                            View childAt2 = ChatAttachAlertDocumentLayout.this.listView.getChildAt(i5);
                            if (view == null || ChatAttachAlertDocumentLayout.this.listView.getChildAdapterPosition(childAt2) >= childAdapterPosition) {
                                childAt2.setAlpha(0.0f);
                                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                                objectAnimatorOfFloat.setStartDelay((int) ((Math.min(ChatAttachAlertDocumentLayout.this.listView.getMeasuredHeight(), Math.max(0, childAt2.getTop())) / ChatAttachAlertDocumentLayout.this.listView.getMeasuredHeight()) * 100.0f));
                                objectAnimatorOfFloat.setDuration(200L);
                                animatorSet.playTogether(objectAnimatorOfFloat);
                            }
                        }
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.3.1
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animation) {
                                accountInstance.getNotificationCenter().onAnimationFinish(SearchAdapter.this.animationIndex);
                            }
                        });
                        SearchAdapter.this.animationIndex = accountInstance.getNotificationCenter().setAnimationInProgress(SearchAdapter.this.animationIndex, null);
                        animatorSet.start();
                        View view2 = view;
                        if (view2 != null && view2.getParent() == null) {
                            ChatAttachAlertDocumentLayout.this.listView.addView(view);
                            final RecyclerView.LayoutManager layoutManager = ChatAttachAlertDocumentLayout.this.listView.getLayoutManager();
                            if (layoutManager != null) {
                                layoutManager.ignoreView(view);
                                View view3 = view;
                                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, view3.getAlpha(), 0.0f);
                                objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.3.2
                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                    public void onAnimationEnd(Animator animation) {
                                        view.setAlpha(1.0f);
                                        layoutManager.stopIgnoringView(view);
                                        ChatAttachAlertDocumentLayout.this.listView.removeView(view);
                                    }
                                });
                                objectAnimatorOfFloat2.start();
                            }
                        }
                        return true;
                    }
                });
            }
            notifyDataSetChanged();
        }

        private void updateSearchResults(final ArrayList<ListItem> result, String query) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertDocumentLayout$SearchAdapter$J8An0WUHk30W9RduzPjj-OtAwWw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$5$ChatAttachAlertDocumentLayout$SearchAdapter(result);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$5$ChatAttachAlertDocumentLayout$SearchAdapter(ArrayList arrayList) {
            if (ChatAttachAlertDocumentLayout.this.searching && ChatAttachAlertDocumentLayout.this.listView.getAdapter() != ChatAttachAlertDocumentLayout.this.searchAdapter) {
                ChatAttachAlertDocumentLayout.this.listView.setAdapter(ChatAttachAlertDocumentLayout.this.searchAdapter);
            }
            this.searchResult = arrayList;
            notifyDataSetChanged();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            int itemViewType = holder.getItemViewType();
            return itemViewType == 1 || itemViewType == 4;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            if (this.sections.isEmpty()) {
                return 2;
            }
            return 2 + this.sections.size() + (!this.endReached ? 1 : 0);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int section, int position) {
            ArrayList<MessageObject> arrayList;
            if (section == 0) {
                if (position < this.searchResult.size()) {
                    return this.searchResult.get(position);
                }
                return null;
            }
            int i = section - 1;
            if (i >= this.sections.size() || (arrayList = this.sectionArrays.get(this.sections.get(i))) == null) {
                return null;
            }
            return arrayList.get(position - ((i == 0 && this.searchResult.isEmpty()) ? 0 : 1));
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            if (section == 0) {
                return this.searchResult.size();
            }
            int i = section - 1;
            int i2 = 1;
            if (i >= this.sections.size()) {
                return 1;
            }
            ArrayList<MessageObject> arrayList = this.sectionArrays.get(this.sections.get(i));
            if (arrayList == null) {
                return 0;
            }
            int size = arrayList.size();
            if (i == 0 && this.searchResult.isEmpty()) {
                i2 = 0;
            }
            return size + i2;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int section, View view) {
            String sectionDate;
            GraySectionCell graySectionCell = (GraySectionCell) view;
            if (graySectionCell == null) {
                graySectionCell = new GraySectionCell(this.mContext, ChatAttachAlertDocumentLayout.this.resourcesProvider);
                graySectionCell.setBackgroundColor(ChatAttachAlertDocumentLayout.this.getThemedColor("graySection") & (-218103809));
            }
            if (section == 0 || (section == 1 && this.searchResult.isEmpty())) {
                graySectionCell.setAlpha(0.0f);
                return graySectionCell;
            }
            int i = section - 1;
            if (i < this.sections.size()) {
                graySectionCell.setAlpha(1.0f);
                ArrayList<MessageObject> arrayList = this.sectionArrays.get(this.sections.get(i));
                if (arrayList != null) {
                    MessageObject messageObject = arrayList.get(0);
                    if (i == 0 && !this.searchResult.isEmpty()) {
                        sectionDate = LocaleController.getString("GlobalSearch", R.string.GlobalSearch);
                    } else {
                        sectionDate = LocaleController.formatSectionDate(messageObject.messageOwner.date);
                    }
                    graySectionCell.setText(sectionDate);
                }
            }
            return view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARN: Type inference failed for: r1v1, types: [ir.eitaa.ui.Cells.SharedDocumentCell] */
        /* JADX WARN: Type inference failed for: r4v8, types: [ir.eitaa.ui.Components.FlickerLoadingView] */
        /* JADX WARN: Type inference failed for: r4v9, types: [android.view.View] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(android.view.ViewGroup r4, int r5) {
            /*
                r3 = this;
                if (r5 == 0) goto L3a
                r4 = 2
                r0 = 1
                if (r5 == r0) goto L26
                if (r5 == r4) goto L13
                r1 = 4
                if (r5 == r1) goto L26
                android.view.View r4 = new android.view.View
                android.content.Context r5 = r3.mContext
                r4.<init>(r5)
                goto L45
            L13:
                ir.eitaa.ui.Components.FlickerLoadingView r4 = new ir.eitaa.ui.Components.FlickerLoadingView
                android.content.Context r5 = r3.mContext
                ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout r1 = ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.this
                ir.eitaa.ui.ActionBar.Theme$ResourcesProvider r1 = r1.resourcesProvider
                r4.<init>(r5, r1)
                r5 = 3
                r4.setViewType(r5)
                r4.setIsSingleCell(r0)
                goto L45
            L26:
                ir.eitaa.ui.Cells.SharedDocumentCell r1 = new ir.eitaa.ui.Cells.SharedDocumentCell
                android.content.Context r2 = r3.mContext
                if (r5 != r0) goto L2d
                r4 = 1
            L2d:
                ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout r5 = ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.this
                ir.eitaa.ui.ActionBar.Theme$ResourcesProvider r5 = r5.resourcesProvider
                r1.<init>(r2, r4, r5)
                r4 = 0
                r1.setDrawDownloadIcon(r4)
                r4 = r1
                goto L45
            L3a:
                ir.eitaa.ui.Cells.GraySectionCell r4 = new ir.eitaa.ui.Cells.GraySectionCell
                android.content.Context r5 = r3.mContext
                ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout r0 = ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.this
                ir.eitaa.ui.ActionBar.Theme$ResourcesProvider r0 = r0.resourcesProvider
                r4.<init>(r5, r0)
            L45:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r5 = new androidx.recyclerview.widget.RecyclerView$LayoutParams
                r0 = -1
                r1 = -2
                r5.<init>(r0, r1)
                r4.setLayoutParams(r5)
                ir.eitaa.ui.Components.RecyclerListView$Holder r5 = new ir.eitaa.ui.Components.RecyclerListView$Holder
                r5.<init>(r4)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.onCreateViewHolder(android.view.ViewGroup, int):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            String sectionDate;
            int itemViewType = holder.getItemViewType();
            if (itemViewType == 2 || itemViewType == 3) {
                return;
            }
            boolean z = false;
            if (itemViewType == 0) {
                int i = section - 1;
                ArrayList<MessageObject> arrayList = this.sectionArrays.get(this.sections.get(i));
                if (arrayList == null) {
                    return;
                }
                MessageObject messageObject = arrayList.get(0);
                if (i == 0 && !this.searchResult.isEmpty()) {
                    sectionDate = LocaleController.getString("GlobalSearch", R.string.GlobalSearch);
                } else {
                    sectionDate = LocaleController.formatSectionDate(messageObject.messageOwner.date);
                }
                ((GraySectionCell) holder.itemView).setText(sectionDate);
                return;
            }
            if (itemViewType == 1 || itemViewType == 4) {
                final SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) holder.itemView;
                if (section == 0) {
                    ListItem listItem = (ListItem) getItem(position);
                    SharedDocumentCell sharedDocumentCell2 = (SharedDocumentCell) holder.itemView;
                    int i2 = listItem.icon;
                    if (i2 != 0) {
                        sharedDocumentCell2.setTextAndValueAndTypeAndThumb(listItem.title, listItem.subtitle, null, null, i2, false);
                    } else {
                        sharedDocumentCell2.setTextAndValueAndTypeAndThumb(listItem.title, listItem.subtitle, listItem.ext.toUpperCase().substring(0, Math.min(listItem.ext.length(), 4)), listItem.thumb, 0, false);
                    }
                    if (listItem.file != null) {
                        sharedDocumentCell2.setChecked(ChatAttachAlertDocumentLayout.this.selectedFiles.containsKey(listItem.file.toString()), !ChatAttachAlertDocumentLayout.this.scrolling);
                        return;
                    } else {
                        sharedDocumentCell2.setChecked(false, !ChatAttachAlertDocumentLayout.this.scrolling);
                        return;
                    }
                }
                int i3 = section - 1;
                if (i3 != 0 || !this.searchResult.isEmpty()) {
                    position--;
                }
                ArrayList<MessageObject> arrayList2 = this.sectionArrays.get(this.sections.get(i3));
                if (arrayList2 == null) {
                    return;
                }
                final MessageObject messageObject2 = arrayList2.get(position);
                final boolean z2 = sharedDocumentCell.getMessage() != null && sharedDocumentCell.getMessage().getId() == messageObject2.getId();
                if (position != arrayList2.size() - 1 || (i3 == this.sections.size() - 1 && this.isLoading)) {
                    z = true;
                }
                sharedDocumentCell.setDocument(messageObject2, z);
                sharedDocumentCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertDocumentLayout.SearchAdapter.4
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        sharedDocumentCell.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (ChatAttachAlertDocumentLayout.this.parentAlert.actionBar.isActionModeShowed()) {
                            SearchAdapter.this.messageHashIdTmp.set(messageObject2.getId(), messageObject2.getDialogId());
                            sharedDocumentCell.setChecked(ChatAttachAlertDocumentLayout.this.selectedMessages.containsKey(SearchAdapter.this.messageHashIdTmp), z2);
                            return true;
                        }
                        sharedDocumentCell.setChecked(false, z2);
                        return true;
                    }
                });
            }
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            if (section == 0) {
                return 1;
            }
            if (section == getSectionCount() - 1) {
                return 3;
            }
            int i = section - 1;
            if (i < this.sections.size()) {
                return (!(i == 0 && this.searchResult.isEmpty()) && position == 0) ? 0 : 4;
            }
            return 2;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ChatAttachAlertDocumentLayout.this.updateEmptyView();
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.searchItem.getSearchField(), ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "dialogTextBlack"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "dialogScrollGlow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_folderIcon"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_IMAGECOLOR | ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_folderIconBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_iconText"));
        return arrayList;
    }
}
