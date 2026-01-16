package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.MenuDrawable;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.DialogsSearchAdapter;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.Cells.ContextLinkCell;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.SharedAudioCell;
import ir.eitaa.ui.Cells.SharedDocumentCell;
import ir.eitaa.ui.Cells.SharedLinkCell;
import ir.eitaa.ui.Cells.SharedPhotoVideoCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.ViewPagerFixed;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.FilteredSearchView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SearchViewPager extends ViewPagerFixed implements FilteredSearchView.UiCallback {
    public static boolean globalSearch = false;
    public static String trendString = "";
    int animateFromCount;
    private boolean attached;
    ChatPreviewDelegate chatPreviewDelegate;
    int currentAccount;
    private ArrayList<FiltersView.MediaFilterData> currentSearchFilters;
    public DialogsSearchAdapter dialogsSearchAdapter;
    public StickerEmptyView emptyView;
    private FilteredSearchView.Delegate filteredSearchViewDelegate;
    private final int folderId;
    private ActionBarMenuItem forwardItem;
    private ActionBarMenuItem gotoItem;
    GraySectionCell hintCell;
    private boolean isActionModeShowed;
    private RecyclerItemsEnterAnimator itemsEnterAnimator;
    private int keyboardSize;
    private boolean lastSearchScrolledToTop;
    String lastSearchString;
    private FilteredSearchView noMediaFiltersSearchView;
    BaseFragment parent;
    public FrameLayout searchContainer;
    private LinearLayoutManager searchLayoutManager;
    public RecyclerListView searchListView;
    private HashMap<FilteredSearchView.MessageHashId, MessageObject> selectedFiles;
    private NumberTextView selectedMessagesCountTextView;
    private boolean showOnlyDialogsAdapter;

    public interface ChatPreviewDelegate {
        void finish();

        void move(float dy);

        void startChatPreview(DialogCell cell);
    }

    static /* synthetic */ boolean lambda$showActionMode$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public SearchViewPager(Context context, final BaseFragment fragment, int type, int initialDialogsType, int folderId, final ChatPreviewDelegate chatPreviewDelegate) {
        super(context);
        this.selectedFiles = new HashMap<>();
        this.currentSearchFilters = new ArrayList<>();
        this.currentAccount = UserConfig.selectedAccount;
        this.animateFromCount = 0;
        this.folderId = folderId;
        this.parent = fragment;
        this.chatPreviewDelegate = chatPreviewDelegate;
        this.dialogsSearchAdapter = new DialogsSearchAdapter(context, type, initialDialogsType) { // from class: ir.eitaa.ui.Components.SearchViewPager.1
            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public void notifyDataSetChanged() {
                RecyclerListView recyclerListView;
                int currentItemCount = getCurrentItemCount();
                super.notifyDataSetChanged();
                if (!SearchViewPager.this.lastSearchScrolledToTop && (recyclerListView = SearchViewPager.this.searchListView) != null) {
                    recyclerListView.scrollToPosition(0);
                    SearchViewPager.this.lastSearchScrolledToTop = true;
                }
                if (getItemCount() != 0 || currentItemCount == 0 || isSearching()) {
                    return;
                }
                SearchViewPager.this.emptyView.showProgress(false, false);
            }
        };
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.SearchViewPager.2
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                SearchViewPager.this.itemsEnterAnimator.dispatchDraw();
                super.dispatchDraw(canvas);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                SearchViewPager.this.itemsEnterAnimator.onDetached();
            }
        };
        this.searchListView = recyclerListView;
        recyclerListView.setPivotY(0.0f);
        this.searchListView.setAdapter(this.dialogsSearchAdapter);
        int i = 1;
        this.searchListView.setVerticalScrollBarEnabled(true);
        this.searchListView.setInstantClick(true);
        this.searchListView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        RecyclerListView recyclerListView2 = this.searchListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.searchLayoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.searchListView.setAnimateEmptyView(true, 0);
        this.searchListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.SearchViewPager.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(fragment.getParentActivity().getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int iAbs = Math.abs(SearchViewPager.this.searchLayoutManager.findLastVisibleItemPosition() - SearchViewPager.this.searchLayoutManager.findFirstVisibleItemPosition()) + 1;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (iAbs <= 0 || SearchViewPager.this.searchLayoutManager.findLastVisibleItemPosition() != itemCount - 1 || SearchViewPager.this.dialogsSearchAdapter.isMessagesSearchEndReached()) {
                    return;
                }
                SearchViewPager.this.dialogsSearchAdapter.loadMoreSearchMessages();
            }
        });
        FilteredSearchView filteredSearchView = new FilteredSearchView(this.parent);
        this.noMediaFiltersSearchView = filteredSearchView;
        filteredSearchView.setUiCallback(this);
        this.noMediaFiltersSearchView.setVisibility(8);
        this.noMediaFiltersSearchView.setChatPreviewDelegate(chatPreviewDelegate);
        this.searchContainer = new FrameLayout(context);
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        flickerLoadingView.setViewType(1);
        StickerEmptyView stickerEmptyView = new StickerEmptyView(context, flickerLoadingView, i) { // from class: ir.eitaa.ui.Components.SearchViewPager.4
            @Override // ir.eitaa.ui.Components.StickerEmptyView, android.view.View
            public void setVisibility(int visibility) {
                if (SearchViewPager.this.noMediaFiltersSearchView.getTag() != null) {
                    super.setVisibility(8);
                } else {
                    super.setVisibility(visibility);
                }
            }
        };
        this.emptyView = stickerEmptyView;
        stickerEmptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
        this.emptyView.subtitle.setVisibility(8);
        this.emptyView.setVisibility(8);
        this.emptyView.addView(flickerLoadingView, 0);
        this.emptyView.showProgress(true, false);
        GraySectionCell graySectionCell = new GraySectionCell(getContext());
        this.hintCell = graySectionCell;
        graySectionCell.setText(LocaleController.getString("SearchFilterDialogsDescription", R.string.SearchFilterDialogsDescription));
        this.searchContainer.addView(this.hintCell, LayoutHelper.createFrame(-1, 20.0f, 48, 0.0f, 0.0f, 0.0f, 0.0f));
        this.searchContainer.addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 32.0f, 0.0f, 32.0f));
        this.searchContainer.addView(this.searchListView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 20.0f, 0.0f, 0.0f));
        this.searchContainer.addView(this.noMediaFiltersSearchView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 20.0f, 0.0f, 0.0f));
        this.searchListView.setEmptyView(this.emptyView);
        this.itemsEnterAnimator = new RecyclerItemsEnterAnimator(this.searchListView, true);
        setAdapter(new ViewPagerFixed.Adapter() { // from class: ir.eitaa.ui.Components.SearchViewPager.5
            @Override // ir.eitaa.ui.Components.ViewPagerFixed.Adapter
            public int getItemViewType(int position) {
                if (position == 0) {
                    return 1;
                }
                return position + 2;
            }

            @Override // ir.eitaa.ui.Components.ViewPagerFixed.Adapter
            public String getItemTitle(int position) {
                if (LocaleController.isRTL) {
                    if (position < getItemCount() - 1) {
                        return FiltersView.filters[position].title;
                    }
                    return LocaleController.getString("SearchFilterDialogs", R.string.SearchFilterDialogs);
                }
                if (position == 0) {
                    return LocaleController.getString("SearchFilterDialogs", R.string.SearchFilterDialogs);
                }
                return FiltersView.filters[position - 1].title;
            }

            @Override // ir.eitaa.ui.Components.ViewPagerFixed.Adapter
            public int getItemCount() {
                if (SearchViewPager.this.showOnlyDialogsAdapter) {
                    return 1;
                }
                return 1 + FiltersView.filters.length;
            }

            @Override // ir.eitaa.ui.Components.ViewPagerFixed.Adapter
            public View createView(int viewType) {
                boolean z = LocaleController.isRTL;
                if (!z && viewType == 1) {
                    return SearchViewPager.this.searchContainer;
                }
                if (z && viewType == 7) {
                    return SearchViewPager.this.searchContainer;
                }
                FilteredSearchView filteredSearchView2 = new FilteredSearchView(SearchViewPager.this.parent);
                filteredSearchView2.setChatPreviewDelegate(chatPreviewDelegate);
                filteredSearchView2.setUiCallback(SearchViewPager.this);
                return filteredSearchView2;
            }

            @Override // ir.eitaa.ui.Components.ViewPagerFixed.Adapter
            public void bindView(View view, int position, int viewType) {
                SearchViewPager searchViewPager = SearchViewPager.this;
                searchViewPager.search(view, position, searchViewPager.lastSearchString, true);
                DialogsActivity.view_ = view;
                DialogsActivity.position_ = position;
            }
        });
    }

    public void onTextChanged(String text) {
        this.lastSearchString = text;
        DialogsActivity.lastSearchString_ = text;
        search(getCurrentView(), getCurrentPosition(), text, !this.attached);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void search(View view, int position, String query, boolean reset) {
        boolean z;
        int iNeedSwitchToTheme = Theme.needSwitchToTheme();
        if (!Theme.getCurrentTheme().isDark() && iNeedSwitchToTheme != 2) {
            this.parent.getActionBar().setBackgroundColor(Theme.getColor("profile_tabSelectedLine"));
        }
        if (query == null) {
            return;
        }
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        for (int i2 = 0; i2 < this.currentSearchFilters.size(); i2++) {
            FiltersView.MediaFilterData mediaFilterData = this.currentSearchFilters.get(i2);
            int i3 = mediaFilterData.filterType;
            if (i3 == 4) {
                TLObject tLObject = mediaFilterData.chat;
                if (tLObject instanceof TLRPC$User) {
                    j = ((TLRPC$User) tLObject).id;
                } else if (tLObject instanceof TLRPC$Chat) {
                    j = -((TLRPC$Chat) tLObject).id;
                }
            } else if (i3 == 6) {
                FiltersView.DateData dateData = mediaFilterData.dateData;
                long j4 = dateData.minDate;
                long j5 = dateData.maxDate;
                j2 = j4;
                j3 = j5;
            } else if (i3 == 7) {
                i = 1;
            }
        }
        if (view.getClass().getName() == this.searchContainer.getClass().getName() && !globalSearch) {
            if (j == 0 && j2 == 0 && j3 == 0) {
                this.lastSearchScrolledToTop = false;
                this.dialogsSearchAdapter.searchDialogs(query, i);
                this.dialogsSearchAdapter.setFiltersDelegate(this.filteredSearchViewDelegate, false);
                this.noMediaFiltersSearchView.animate().setListener(null).cancel();
                this.noMediaFiltersSearchView.setDelegate(null, false);
                if (reset) {
                    this.emptyView.showProgress(!this.dialogsSearchAdapter.isSearching(), false);
                    this.emptyView.showProgress(this.dialogsSearchAdapter.isSearching(), false);
                } else if (!this.dialogsSearchAdapter.hasRecentSearch()) {
                    this.emptyView.showProgress(this.dialogsSearchAdapter.isSearching(), true);
                }
                if (reset) {
                    this.noMediaFiltersSearchView.setVisibility(8);
                } else if (this.noMediaFiltersSearchView.getVisibility() != 8) {
                    this.noMediaFiltersSearchView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.SearchViewPager.6
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            SearchViewPager.this.noMediaFiltersSearchView.setVisibility(8);
                        }
                    }).setDuration(150L).start();
                }
                this.noMediaFiltersSearchView.setTag(null);
            } else {
                this.noMediaFiltersSearchView.setTag(1);
                this.noMediaFiltersSearchView.setDelegate(this.filteredSearchViewDelegate, false);
                this.noMediaFiltersSearchView.animate().setListener(null).cancel();
                if (reset) {
                    this.noMediaFiltersSearchView.setVisibility(0);
                    this.noMediaFiltersSearchView.setAlpha(1.0f);
                    z = reset;
                } else {
                    if (this.noMediaFiltersSearchView.getVisibility() != 0) {
                        this.noMediaFiltersSearchView.setVisibility(0);
                        this.noMediaFiltersSearchView.setAlpha(0.0f);
                        z = true;
                    } else {
                        z = reset;
                    }
                    this.noMediaFiltersSearchView.animate().alpha(1.0f).setDuration(150L).start();
                }
                this.noMediaFiltersSearchView.search(j, j2, j3, null, i, query, z);
                this.emptyView.setVisibility(8);
            }
            this.emptyView.setKeyboardHeight(this.keyboardSize, false);
            this.noMediaFiltersSearchView.setKeyboardHeight(this.keyboardSize, false);
            return;
        }
        if (globalSearch) {
            globalSearch = false;
            if (LocaleController.isRTL) {
                getTabsView().scrollToTab(1, 1);
                return;
            } else {
                getTabsView().scrollToTab(4, 4);
                return;
            }
        }
        FilteredSearchView filteredSearchView = (FilteredSearchView) view;
        filteredSearchView.setKeyboardHeight(this.keyboardSize, false);
        filteredSearchView.search(j, j2, j3, FiltersView.filters[LocaleController.isRTL ? position : position - 1], i, query.equals("") ? trendString : query, reset);
        filteredSearchView.setHintText(position);
    }

    public void onResume() {
        DialogsSearchAdapter dialogsSearchAdapter = this.dialogsSearchAdapter;
        if (dialogsSearchAdapter != null) {
            dialogsSearchAdapter.notifyDataSetChanged();
        }
    }

    public void removeSearchFilter(FiltersView.MediaFilterData filterData) {
        this.currentSearchFilters.remove(filterData);
    }

    public ArrayList<FiltersView.MediaFilterData> getCurrentSearchFilters() {
        return this.currentSearchFilters;
    }

    public void clear() {
        this.currentSearchFilters.clear();
    }

    public void setFilteredSearchViewDelegate(FilteredSearchView.Delegate filteredSearchViewDelegate) {
        this.filteredSearchViewDelegate = filteredSearchViewDelegate;
    }

    private void showActionMode(boolean show) {
        if (this.isActionModeShowed == show) {
            return;
        }
        if (show && this.parent.getActionBar().isActionModeShowed()) {
            return;
        }
        if (show && !this.parent.getActionBar().actionModeIsExist("search_view_pager")) {
            ActionBarMenu actionBarMenuCreateActionMode = this.parent.getActionBar().createActionMode(true, "search_view_pager");
            NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
            this.selectedMessagesCountTextView = numberTextView;
            numberTextView.setTextSize(18);
            this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.selectedMessagesCountTextView.setTextColor(Theme.getColor("actionBarActionModeDefaultIcon"));
            actionBarMenuCreateActionMode.addView(this.selectedMessagesCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
            this.selectedMessagesCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SearchViewPager$ra1p_W8LEQ04Rpep1tYNwD1mtWM
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return SearchViewPager.lambda$showActionMode$0(view, motionEvent);
                }
            });
            this.gotoItem = actionBarMenuCreateActionMode.addItemWithWidth(200, R.drawable.msg_message, AndroidUtilities.dp(54.0f), LocaleController.getString("AccDescrGoToMessage", R.string.AccDescrGoToMessage));
            this.forwardItem = actionBarMenuCreateActionMode.addItemWithWidth(201, R.drawable.msg_forward, AndroidUtilities.dp(54.0f), LocaleController.getString("Forward", R.string.Forward));
        }
        if (this.parent.getActionBar().getBackButton().getDrawable() instanceof MenuDrawable) {
            this.parent.getActionBar().setBackButtonDrawable(new BackDrawable(false));
        }
        this.isActionModeShowed = show;
        if (show) {
            AndroidUtilities.hideKeyboard(this.parent.getParentActivity().getCurrentFocus());
            this.parent.getActionBar().showActionMode();
            this.selectedMessagesCountTextView.setNumber(this.selectedFiles.size(), false);
            this.gotoItem.setVisibility(0);
            this.forwardItem.setVisibility(0);
            return;
        }
        this.parent.getActionBar().hideActionMode();
        this.selectedFiles.clear();
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof FilteredSearchView) {
                ((FilteredSearchView) getChildAt(i)).update();
            }
        }
        FilteredSearchView filteredSearchView = this.noMediaFiltersSearchView;
        if (filteredSearchView != null) {
            filteredSearchView.update();
        }
        int size = this.viewsByType.size();
        for (int i2 = 0; i2 < size; i2++) {
            View viewValueAt = this.viewsByType.valueAt(i2);
            if (viewValueAt instanceof FilteredSearchView) {
                ((FilteredSearchView) viewValueAt).update();
            }
        }
    }

    public void onActionBarItemClick(int id) {
        if (id == 200) {
            if (this.selectedFiles.size() != 1) {
                return;
            }
            goToMessage(this.selectedFiles.values().iterator().next());
        } else if (id == 201) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlySelect", true);
            bundle.putInt("dialogsType", 3);
            DialogsActivity dialogsActivity = new DialogsActivity(bundle);
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$SearchViewPager$rJBzu74wvwRbrASRxT4bGettQAE
                @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                    this.f$0.lambda$onActionBarItemClick$1$SearchViewPager(dialogsActivity2, arrayList, charSequence, z);
                }
            });
            this.parent.presentFragment(dialogsActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onActionBarItemClick$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onActionBarItemClick$1$SearchViewPager(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
        ArrayList<MessageObject> arrayList2 = new ArrayList<>();
        Iterator<FilteredSearchView.MessageHashId> it = this.selectedFiles.keySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(this.selectedFiles.get(it.next()));
        }
        this.selectedFiles.clear();
        showActionMode(false);
        if (arrayList.size() > 1 || ((Long) arrayList.get(0)).longValue() == AccountInstance.getInstance(this.currentAccount).getUserConfig().getClientUserId() || charSequence != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                long jLongValue = ((Long) arrayList.get(i)).longValue();
                if (charSequence != null) {
                    AccountInstance.getInstance(this.currentAccount).getSendMessagesHelper().sendMessage(charSequence.toString(), jLongValue, null, null, null, true, null, null, null, true, 0, null);
                }
                AccountInstance.getInstance(this.currentAccount).getSendMessagesHelper().sendMessage(arrayList2, jLongValue, false, false, true, 0);
            }
            dialogsActivity.finishFragment();
            return;
        }
        long jLongValue2 = ((Long) arrayList.get(0)).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        if (DialogObject.isEncryptedDialog(jLongValue2)) {
            bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue2));
        } else {
            if (DialogObject.isUserDialog(jLongValue2)) {
                bundle.putLong("user_id", jLongValue2);
            } else {
                bundle.putLong("chat_id", -jLongValue2);
            }
            if (!AccountInstance.getInstance(this.currentAccount).getMessagesController().checkCanOpenChat(bundle, dialogsActivity)) {
                return;
            }
        }
        ChatActivity chatActivity = new ChatActivity(bundle);
        dialogsActivity.presentFragment(chatActivity, true);
        chatActivity.showFieldPanelForForward(true, arrayList2);
    }

    @Override // ir.eitaa.ui.FilteredSearchView.UiCallback
    public void goToMessage(ChatActivity chatActivity) {
        this.parent.presentFragment(chatActivity);
        showActionMode(false);
    }

    @Override // ir.eitaa.ui.FilteredSearchView.UiCallback
    public void goToMessage(MessageObject messageObject) {
        Bundle bundle = new Bundle();
        long dialogId = messageObject.getDialogId();
        if (DialogObject.isEncryptedDialog(dialogId)) {
            bundle.putInt("enc_id", DialogObject.getEncryptedChatId(dialogId));
        } else if (DialogObject.isUserDialog(dialogId)) {
            bundle.putLong("user_id", dialogId);
        } else {
            TLRPC$Chat chat = AccountInstance.getInstance(this.currentAccount).getMessagesController().getChat(Long.valueOf(-dialogId));
            if (chat != null && chat.migrated_to != null) {
                bundle.putLong("migrated_to", dialogId);
                dialogId = -chat.migrated_to.channel_id;
            }
            bundle.putLong("chat_id", -dialogId);
        }
        bundle.putInt("message_id", messageObject.getId());
        if (AccountInstance.getInstance(UserConfig.selectedAccount).getMessagesController().checkCanOpenChat(bundle, this.parent)) {
            this.parent.presentFragment(new ChatActivity(bundle));
        }
        showActionMode(false);
    }

    public int getFolderId() {
        return this.folderId;
    }

    @Override // ir.eitaa.ui.FilteredSearchView.UiCallback
    public boolean actionModeShowing() {
        return this.isActionModeShowed;
    }

    public void hideActionMode() {
        showActionMode(false);
    }

    @Override // ir.eitaa.ui.FilteredSearchView.UiCallback
    public void toggleItemSelection(MessageObject message, View view, int a) {
        FilteredSearchView.MessageHashId messageHashId = new FilteredSearchView.MessageHashId(message.getId(), message.getDialogId());
        if (this.selectedFiles.containsKey(messageHashId)) {
            this.selectedFiles.remove(messageHashId);
        } else if (this.selectedFiles.size() >= 100) {
            return;
        } else {
            this.selectedFiles.put(messageHashId, message);
        }
        if (this.selectedFiles.size() == 0) {
            showActionMode(false);
        } else {
            this.selectedMessagesCountTextView.setNumber(this.selectedFiles.size(), true);
            ActionBarMenuItem actionBarMenuItem = this.gotoItem;
            if (actionBarMenuItem != null) {
                actionBarMenuItem.setVisibility(this.selectedFiles.size() != 1 ? 8 : 0);
            }
        }
        if (view instanceof SharedDocumentCell) {
            ((SharedDocumentCell) view).setChecked(this.selectedFiles.containsKey(messageHashId), true);
            return;
        }
        if (view instanceof SharedPhotoVideoCell) {
            ((SharedPhotoVideoCell) view).setChecked(a, this.selectedFiles.containsKey(messageHashId), true);
            return;
        }
        if (view instanceof SharedLinkCell) {
            ((SharedLinkCell) view).setChecked(this.selectedFiles.containsKey(messageHashId), true);
            return;
        }
        if (view instanceof SharedAudioCell) {
            ((SharedAudioCell) view).setChecked(this.selectedFiles.containsKey(messageHashId), true);
        } else if (view instanceof ContextLinkCell) {
            ((ContextLinkCell) view).setChecked(this.selectedFiles.containsKey(messageHashId), true);
        } else if (view instanceof DialogCell) {
            ((DialogCell) view).setChecked(this.selectedFiles.containsKey(messageHashId), true);
        }
    }

    @Override // ir.eitaa.ui.FilteredSearchView.UiCallback
    public boolean isSelected(FilteredSearchView.MessageHashId messageHashId) {
        return this.selectedFiles.containsKey(messageHashId);
    }

    @Override // ir.eitaa.ui.FilteredSearchView.UiCallback
    public void showActionMode() {
        showActionMode(true);
    }

    @Override // ir.eitaa.ui.Components.ViewPagerFixed
    protected void onItemSelected(View currentPage, View oldPage, int position, int oldPosition) {
        if (position == 0) {
            if (this.noMediaFiltersSearchView.getVisibility() == 0) {
                this.noMediaFiltersSearchView.setDelegate(this.filteredSearchViewDelegate, false);
                this.dialogsSearchAdapter.setFiltersDelegate(null, false);
            } else {
                this.noMediaFiltersSearchView.setDelegate(null, false);
                this.dialogsSearchAdapter.setFiltersDelegate(this.filteredSearchViewDelegate, true);
            }
        } else if (currentPage instanceof FilteredSearchView) {
            ((FilteredSearchView) currentPage).setDelegate(this.filteredSearchViewDelegate, oldPosition == 0 && this.noMediaFiltersSearchView.getVisibility() != 0);
        }
        if (oldPage instanceof FilteredSearchView) {
            ((FilteredSearchView) oldPage).setDelegate(null, false);
        } else {
            this.dialogsSearchAdapter.setFiltersDelegate(null, false);
            this.noMediaFiltersSearchView.setDelegate(null, false);
        }
    }

    public void getThemeDescriptors(ArrayList<ThemeDescription> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof FilteredSearchView) {
                arrayList.addAll(((FilteredSearchView) getChildAt(i)).getThemeDescriptions());
            }
        }
        int size = this.viewsByType.size();
        for (int i2 = 0; i2 < size; i2++) {
            View viewValueAt = this.viewsByType.valueAt(i2);
            if (viewValueAt instanceof FilteredSearchView) {
                arrayList.addAll(((FilteredSearchView) viewValueAt).getThemeDescriptions());
            }
        }
        FilteredSearchView filteredSearchView = this.noMediaFiltersSearchView;
        if (filteredSearchView != null) {
            arrayList.addAll(filteredSearchView.getThemeDescriptions());
        }
        arrayList.add(new ThemeDescription(this.emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText"));
    }

    public void updateColors() {
        this.hintCell.setBackgroundColor(Theme.getColor("graySection"));
        this.hintCell.setTextColor("key_graySectionText");
        this.emptyView.updateNoResultColor();
        if (getCurrentView() instanceof FilteredSearchView) {
            ((FilteredSearchView) getCurrentView()).hintCell.setBackgroundColor(Theme.getColor("graySection"));
            ((FilteredSearchView) getCurrentView()).hintCell.setTextColor("key_graySectionText");
        }
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof FilteredSearchView) {
                RecyclerListView recyclerListView = ((FilteredSearchView) getChildAt(i)).recyclerListView;
                int childCount = recyclerListView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerListView.getChildAt(i2);
                    if (childAt instanceof DialogCell) {
                        ((DialogCell) childAt).update(0);
                    }
                }
            }
        }
        int size = this.viewsByType.size();
        for (int i3 = 0; i3 < size; i3++) {
            View viewValueAt = this.viewsByType.valueAt(i3);
            if (viewValueAt instanceof FilteredSearchView) {
                RecyclerListView recyclerListView2 = ((FilteredSearchView) viewValueAt).recyclerListView;
                int childCount2 = recyclerListView2.getChildCount();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    View childAt2 = recyclerListView2.getChildAt(i4);
                    if (childAt2 instanceof DialogCell) {
                        ((DialogCell) childAt2).update(0);
                    }
                }
            }
        }
        FilteredSearchView filteredSearchView = this.noMediaFiltersSearchView;
        if (filteredSearchView != null) {
            RecyclerListView recyclerListView3 = filteredSearchView.recyclerListView;
            int childCount3 = recyclerListView3.getChildCount();
            for (int i5 = 0; i5 < childCount3; i5++) {
                View childAt3 = recyclerListView3.getChildAt(i5);
                if (childAt3 instanceof DialogCell) {
                    ((DialogCell) childAt3).update(0);
                }
            }
        }
    }

    public void reset() {
        if (LocaleController.isRTL) {
            setPosition(5);
        } else {
            setPosition(0);
        }
        if (this.dialogsSearchAdapter.getItemCount() > 0) {
            this.searchLayoutManager.scrollToPositionWithOffset(0, 0);
        }
        this.viewsByType.clear();
    }

    @Override // ir.eitaa.ui.Components.ViewPagerFixed
    public void setPosition(int position) {
        super.setPosition(position);
        this.viewsByType.clear();
        ViewPagerFixed.TabsView tabsView = this.tabsView;
        if (tabsView != null) {
            tabsView.selectTabWithId(position, 1.0f);
        }
        invalidate();
    }

    public void setKeyboardHeight(int keyboardSize) {
        this.keyboardSize = keyboardSize;
        boolean z = getVisibility() == 0 && getAlpha() > 0.0f;
        for (int i = 0; i < getChildCount(); i++) {
            if (getChildAt(i) instanceof FilteredSearchView) {
                ((FilteredSearchView) getChildAt(i)).setKeyboardHeight(keyboardSize, z);
            } else if (getChildAt(i) == this.searchContainer) {
                this.emptyView.setKeyboardHeight(keyboardSize, z);
                this.noMediaFiltersSearchView.setKeyboardHeight(keyboardSize, z);
            }
        }
    }

    public void showOnlyDialogsAdapter(boolean showOnlyDialogsAdapter) {
        this.showOnlyDialogsAdapter = showOnlyDialogsAdapter;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void messagesDeleted(long r11, java.util.ArrayList<java.lang.Integer> r13) {
        /*
            r10 = this;
            android.util.SparseArray<android.view.View> r0 = r10.viewsByType
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L1e
            android.util.SparseArray<android.view.View> r3 = r10.viewsByType
            java.lang.Object r3 = r3.valueAt(r2)
            android.view.View r3 = (android.view.View) r3
            boolean r4 = r3 instanceof ir.eitaa.ui.FilteredSearchView
            if (r4 == 0) goto L1b
            ir.eitaa.ui.FilteredSearchView r3 = (ir.eitaa.ui.FilteredSearchView) r3
            r3.messagesDeleted(r11, r13)
        L1b:
            int r2 = r2 + 1
            goto L8
        L1e:
            r0 = 0
        L1f:
            int r2 = r10.getChildCount()
            if (r0 >= r2) goto L39
            android.view.View r2 = r10.getChildAt(r0)
            boolean r2 = r2 instanceof ir.eitaa.ui.FilteredSearchView
            if (r2 == 0) goto L36
            android.view.View r2 = r10.getChildAt(r0)
            ir.eitaa.ui.FilteredSearchView r2 = (ir.eitaa.ui.FilteredSearchView) r2
            r2.messagesDeleted(r11, r13)
        L36:
            int r0 = r0 + 1
            goto L1f
        L39:
            ir.eitaa.ui.FilteredSearchView r0 = r10.noMediaFiltersSearchView
            r0.messagesDeleted(r11, r13)
            java.util.HashMap<ir.eitaa.ui.FilteredSearchView$MessageHashId, ir.eitaa.messenger.MessageObject> r0 = r10.selectedFiles
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Ld9
            r0 = 0
            java.util.HashMap<ir.eitaa.ui.FilteredSearchView$MessageHashId, ir.eitaa.messenger.MessageObject> r2 = r10.selectedFiles
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L51:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Ld9
            java.lang.Object r3 = r2.next()
            ir.eitaa.ui.FilteredSearchView$MessageHashId r3 = (ir.eitaa.ui.FilteredSearchView.MessageHashId) r3
            java.util.HashMap<ir.eitaa.ui.FilteredSearchView$MessageHashId, ir.eitaa.messenger.MessageObject> r4 = r10.selectedFiles
            java.lang.Object r4 = r4.get(r3)
            ir.eitaa.messenger.MessageObject r4 = (ir.eitaa.messenger.MessageObject) r4
            long r5 = r4.getDialogId()
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L7b
            long r5 = -r5
            int r6 = (int) r5
            long r7 = (long) r6
            int r5 = r10.currentAccount
            boolean r5 = ir.eitaa.messenger.ChatObject.isChannel(r7, r5)
            if (r5 == 0) goto L7b
            goto L7c
        L7b:
            r6 = 0
        L7c:
            long r5 = (long) r6
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 != 0) goto La3
            r5 = 0
        L82:
            int r6 = r13.size()
            if (r5 >= r6) goto La3
            int r6 = r4.getId()
            java.lang.Object r7 = r13.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r6 != r7) goto La0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r3)
        La0:
            int r5 = r5 + 1
            goto L82
        La3:
            if (r0 == 0) goto L51
            int r3 = r0.size()
            r4 = 0
        Laa:
            if (r4 >= r3) goto Lb8
            java.util.HashMap<ir.eitaa.ui.FilteredSearchView$MessageHashId, ir.eitaa.messenger.MessageObject> r5 = r10.selectedFiles
            java.lang.Object r6 = r0.get(r4)
            r5.remove(r6)
            int r4 = r4 + 1
            goto Laa
        Lb8:
            ir.eitaa.ui.Components.NumberTextView r3 = r10.selectedMessagesCountTextView
            java.util.HashMap<ir.eitaa.ui.FilteredSearchView$MessageHashId, ir.eitaa.messenger.MessageObject> r4 = r10.selectedFiles
            int r4 = r4.size()
            r5 = 1
            r3.setNumber(r4, r5)
            ir.eitaa.ui.ActionBar.ActionBarMenuItem r3 = r10.gotoItem
            if (r3 == 0) goto L51
            java.util.HashMap<ir.eitaa.ui.FilteredSearchView$MessageHashId, ir.eitaa.messenger.MessageObject> r4 = r10.selectedFiles
            int r4 = r4.size()
            if (r4 != r5) goto Ld2
            r4 = 0
            goto Ld4
        Ld2:
            r4 = 8
        Ld4:
            r3.setVisibility(r4)
            goto L51
        Ld9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.SearchViewPager.messagesDeleted(long, java.util.ArrayList):void");
    }

    public void runResultsEnterAnimation() {
        RecyclerItemsEnterAnimator recyclerItemsEnterAnimator = this.itemsEnterAnimator;
        int i = this.animateFromCount;
        recyclerItemsEnterAnimator.showItemsAnimated(i > 0 ? i + 1 : 0);
        this.animateFromCount = this.dialogsSearchAdapter.getItemCount();
    }

    public ViewPagerFixed.TabsView getTabsView() {
        return this.tabsView;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attached = false;
    }

    public void cancelEnterAnimation() {
        this.itemsEnterAnimator.cancel();
        this.searchListView.invalidate();
        this.animateFromCount = 0;
    }
}
