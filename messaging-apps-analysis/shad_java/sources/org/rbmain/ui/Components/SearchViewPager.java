package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.MenuDrawable;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.DialogsSearchAdapter;
import org.rbmain.ui.Adapters.FiltersView;
import org.rbmain.ui.Cells.ContextLinkCell;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Cells.SharedAudioCell;
import org.rbmain.ui.Cells.SharedDocumentCell;
import org.rbmain.ui.Cells.SharedLinkCell;
import org.rbmain.ui.Cells.SharedPhotoVideoCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.ViewPagerFixed;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.FilteredSearchView;

/* loaded from: classes5.dex */
public class SearchViewPager extends ViewPagerFixed implements FilteredSearchView.UiCallback {
    private boolean attached;
    int currentAccount;
    private ArrayList<FiltersView.MediaFilterData> currentSearchFilters;
    public DialogsSearchAdapter dialogsSearchAdapter;
    public StickerEmptyView emptyView;
    private FilteredSearchView.Delegate filteredSearchViewDelegate;
    private final int folderId;
    private ActionBarMenuItem forwardItem;
    private ActionBarMenuItem gotoItem;
    private boolean isActionModeShowed;
    private RecyclerItemsEnterAnimator itemsEnterAnimator;
    private int keyboardSize;
    private boolean lastSearchScrolledToTop;
    String lastSearchString;
    private FilteredSearchView noMediaFiltersSearchView;
    BaseFragment parent;
    public FrameLayout searchContainer;
    public RecyclerListView searchListView;
    private LinearLayoutManager searchlayoutManager;
    private HashMap<FilteredSearchView.MessageHashId, MessageObject> selectedFiles;
    private NumberTextView selectedMessagesCountTextView;
    private boolean showOnlyDialogsAdapter;

    public interface ChatPreviewDelegate {
        void finish();

        void move(float f);

        void startChatPreview(DialogCell dialogCell);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showActionMode$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public SearchViewPager(Context context, final BaseFragment baseFragment, int i, int i2, int i3, final ChatPreviewDelegate chatPreviewDelegate) {
        super(context);
        this.selectedFiles = new HashMap<>();
        this.currentSearchFilters = new ArrayList<>();
        this.currentAccount = UserConfig.selectedAccount;
        this.folderId = i3;
        this.parent = baseFragment;
        this.dialogsSearchAdapter = new DialogsSearchAdapter(context, i, i2, i3) { // from class: org.rbmain.ui.Components.SearchViewPager.1
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
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.searchListView = recyclerListView;
        recyclerListView.setPivotY(0.0f);
        this.searchListView.setAdapter(this.dialogsSearchAdapter);
        int i4 = 1;
        this.searchListView.setVerticalScrollBarEnabled(true);
        this.searchListView.setInstantClick(true);
        this.searchListView.setVerticalScrollbarPosition(LocaleController.isRTL ? 1 : 2);
        RecyclerListView recyclerListView2 = this.searchListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.searchlayoutManager = linearLayoutManager;
        recyclerListView2.setLayoutManager(linearLayoutManager);
        this.searchListView.setAnimateEmptyView(true, 0);
        this.searchListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.SearchViewPager.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
                if (i5 == 1) {
                    AndroidUtilities.hideKeyboard(baseFragment.getParentActivity().getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
                int iAbs = Math.abs(SearchViewPager.this.searchlayoutManager.findLastVisibleItemPosition() - SearchViewPager.this.searchlayoutManager.findFirstVisibleItemPosition()) + 1;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (iAbs <= 0 || SearchViewPager.this.searchlayoutManager.findLastVisibleItemPosition() != itemCount - 1 || SearchViewPager.this.dialogsSearchAdapter.isMessagesSearchEndReached() || SearchViewPager.this.dialogsSearchAdapter.isSearching()) {
                    return;
                }
                SearchViewPager searchViewPager = SearchViewPager.this;
                searchViewPager.dialogsSearchAdapter.loadMoreSearchMessages(searchViewPager.lastSearchString);
            }
        });
        FilteredSearchView filteredSearchView = new FilteredSearchView(this.parent);
        this.noMediaFiltersSearchView = filteredSearchView;
        filteredSearchView.setUiCallback(this);
        this.noMediaFiltersSearchView.setVisibility(8);
        this.noMediaFiltersSearchView.setChatPreviewDelegate(chatPreviewDelegate);
        FrameLayout frameLayout = new FrameLayout(context);
        this.searchContainer = frameLayout;
        frameLayout.addView(this.searchListView);
        this.searchContainer.addView(this.noMediaFiltersSearchView);
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context);
        flickerLoadingView.setViewType(1);
        StickerEmptyView stickerEmptyView = new StickerEmptyView(context, flickerLoadingView, i4) { // from class: org.rbmain.ui.Components.SearchViewPager.3
            @Override // org.rbmain.ui.Components.StickerEmptyView, android.view.View
            public void setVisibility(int i5) {
                if (SearchViewPager.this.noMediaFiltersSearchView.getTag() != null) {
                    super.setVisibility(8);
                } else {
                    super.setVisibility(i5);
                }
            }
        };
        this.emptyView = stickerEmptyView;
        stickerEmptyView.title.setText(LocaleController.getString("NoResult", R.string.NoResult));
        this.emptyView.subtitle.setVisibility(8);
        this.emptyView.setVisibility(8);
        this.emptyView.addView(flickerLoadingView, 0);
        this.emptyView.showProgress(true, false);
        this.searchContainer.addView(this.emptyView);
        this.searchListView.setEmptyView(this.emptyView);
        this.itemsEnterAnimator = new RecyclerItemsEnterAnimator(this.searchListView, true);
        setAdapter(new ViewPagerFixed.Adapter() { // from class: org.rbmain.ui.Components.SearchViewPager.4
            @Override // org.rbmain.ui.Components.ViewPagerFixed.Adapter
            public int getItemViewType(int i5) {
                if (i5 == 0) {
                    return 1;
                }
                return i5 + 2;
            }

            @Override // org.rbmain.ui.Components.ViewPagerFixed.Adapter
            public String getItemTitle(int i5) {
                if (i5 == 0) {
                    return LocaleController.getString("SearchAllChatsShort", R.string.SearchAllChatsShort);
                }
                return FiltersView.filters[i5 - 1].getTitle();
            }

            @Override // org.rbmain.ui.Components.ViewPagerFixed.Adapter
            public int getItemCount() {
                if (SearchViewPager.this.showOnlyDialogsAdapter) {
                    return 1;
                }
                return 1 + FiltersView.filters.length;
            }

            @Override // org.rbmain.ui.Components.ViewPagerFixed.Adapter
            public View createView(int i5) {
                if (i5 == 1) {
                    return SearchViewPager.this.searchContainer;
                }
                FilteredSearchView filteredSearchView2 = new FilteredSearchView(SearchViewPager.this.parent);
                filteredSearchView2.setChatPreviewDelegate(chatPreviewDelegate);
                filteredSearchView2.setUiCallback(SearchViewPager.this);
                return filteredSearchView2;
            }

            @Override // org.rbmain.ui.Components.ViewPagerFixed.Adapter
            public void bindView(View view, int i5, int i6) {
                SearchViewPager searchViewPager = SearchViewPager.this;
                searchViewPager.search(view, i5, searchViewPager.lastSearchString, true);
            }
        });
    }

    public void onTextChanged(String str) {
        this.lastSearchString = str;
        search(getCurrentView(), getCurrentPosition(), str, !this.attached);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void search(View view, int i, String str, boolean z) {
        boolean z2;
        long j = 0;
        long j2 = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.currentSearchFilters.size(); i3++) {
            FiltersView.MediaFilterData mediaFilterData = this.currentSearchFilters.get(i3);
            int i4 = mediaFilterData.filterType;
            if (i4 == 4) {
                TLObject tLObject = mediaFilterData.chat;
                if (tLObject instanceof TLRPC$User) {
                    i2 = ((TLRPC$User) tLObject).id;
                } else if (tLObject instanceof TLRPC$Chat) {
                    i2 = -((TLRPC$Chat) tLObject).id;
                }
            } else if (i4 == 6) {
                FiltersView.DateData dateData = mediaFilterData.dateData;
                long j3 = dateData.minDate;
                long j4 = dateData.maxDate;
                j = j3;
                j2 = j4;
            }
        }
        boolean z3 = true;
        if (view == this.searchContainer) {
            if (i2 == 0 && j == 0 && j2 == 0) {
                this.lastSearchScrolledToTop = false;
                this.dialogsSearchAdapter.searchDialogs(str);
                this.dialogsSearchAdapter.setFiltersDelegate(this.filteredSearchViewDelegate, false);
                this.noMediaFiltersSearchView.animate().setListener(null).cancel();
                this.noMediaFiltersSearchView.setDelegate(null, false);
                if (z) {
                    this.emptyView.showProgress(!this.dialogsSearchAdapter.isSearching(), false);
                    this.emptyView.showProgress(this.dialogsSearchAdapter.isSearching(), false);
                } else if (!this.dialogsSearchAdapter.hasRecentSearch()) {
                    this.emptyView.showProgress(this.dialogsSearchAdapter.isSearching(), true);
                }
                if (z) {
                    this.noMediaFiltersSearchView.setVisibility(8);
                } else if (this.noMediaFiltersSearchView.getVisibility() != 8) {
                    this.noMediaFiltersSearchView.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.SearchViewPager.5
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            SearchViewPager.this.noMediaFiltersSearchView.setVisibility(8);
                        }
                    }).setDuration(150L).start();
                }
                this.noMediaFiltersSearchView.setTag(null);
            } else {
                this.noMediaFiltersSearchView.setTag(1);
                this.noMediaFiltersSearchView.setDelegate(this.filteredSearchViewDelegate, false);
                this.noMediaFiltersSearchView.animate().setListener(null).cancel();
                if (z) {
                    this.noMediaFiltersSearchView.setVisibility(0);
                    this.noMediaFiltersSearchView.setAlpha(1.0f);
                    z2 = z;
                } else {
                    if (this.noMediaFiltersSearchView.getVisibility() != 0) {
                        this.noMediaFiltersSearchView.setVisibility(0);
                        this.noMediaFiltersSearchView.setAlpha(0.0f);
                    } else {
                        z3 = z;
                    }
                    this.noMediaFiltersSearchView.animate().alpha(1.0f).setDuration(150L).start();
                    z2 = z3;
                }
                this.noMediaFiltersSearchView.search(i2, j, j2, null, str, z2);
                this.emptyView.setVisibility(8);
            }
            this.emptyView.setKeyboardHeight(this.keyboardSize, false);
            this.noMediaFiltersSearchView.setKeyboardHeight(this.keyboardSize, false);
            return;
        }
        FilteredSearchView filteredSearchView = (FilteredSearchView) view;
        filteredSearchView.setKeyboardHeight(this.keyboardSize, false);
        filteredSearchView.search(i2, j, j2, FiltersView.filters[i - 1], str, z);
    }

    public void onResume() {
        DialogsSearchAdapter dialogsSearchAdapter = this.dialogsSearchAdapter;
        if (dialogsSearchAdapter != null) {
            dialogsSearchAdapter.notifyDataSetChanged();
        }
    }

    public void removeSearchFilter(FiltersView.MediaFilterData mediaFilterData) {
        this.currentSearchFilters.remove(mediaFilterData);
    }

    public ArrayList<FiltersView.MediaFilterData> getCurrentSearchFilters() {
        return this.currentSearchFilters;
    }

    public void clear() {
        this.currentSearchFilters.clear();
    }

    public void setFilteredSearchViewDelegate(FilteredSearchView.Delegate delegate) {
        this.filteredSearchViewDelegate = delegate;
    }

    private void showActionMode(boolean z) {
        if (this.isActionModeShowed == z) {
            return;
        }
        if (z && !this.parent.getActionBar().actionModeIsExist("search_view_pager")) {
            ActionBarMenu actionBarMenuCreateActionMode = this.parent.getActionBar().createActionMode(true, "search_view_pager");
            NumberTextView numberTextView = new NumberTextView(actionBarMenuCreateActionMode.getContext());
            this.selectedMessagesCountTextView = numberTextView;
            numberTextView.setTextSize(18);
            this.selectedMessagesCountTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.selectedMessagesCountTextView.setTextColor(Theme.getColor(Theme.key_actionBarActionModeDefaultIcon));
            actionBarMenuCreateActionMode.addView(this.selectedMessagesCountTextView, LayoutHelper.createLinear(0, -1, 1.0f, 72, 0, 0, 0));
            this.selectedMessagesCountTextView.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.SearchViewPager$$ExternalSyntheticLambda0
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
        this.isActionModeShowed = z;
        if (z) {
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

    public void onActionBarItemClick(int i) {
        if (i == 200) {
            if (this.selectedFiles.size() != 1) {
                return;
            }
            goToMessage(this.selectedFiles.values().iterator().next());
        } else if (i == 201) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("onlySelect", true);
            bundle.putInt("dialogsType", 3);
            DialogsActivity dialogsActivity = new DialogsActivity(bundle);
            dialogsActivity.setDelegate(new DialogsActivity.DialogsActivityDelegate() { // from class: org.rbmain.ui.Components.SearchViewPager$$ExternalSyntheticLambda1
                @Override // org.rbmain.ui.DialogsActivity.DialogsActivityDelegate
                public final void didSelectDialogs(DialogsActivity dialogsActivity2, ArrayList arrayList, CharSequence charSequence, boolean z) {
                    this.f$0.lambda$onActionBarItemClick$1(dialogsActivity2, arrayList, charSequence, z);
                }
            });
            this.parent.presentFragment(dialogsActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActionBarItemClick$1(DialogsActivity dialogsActivity, ArrayList arrayList, CharSequence charSequence, boolean z) {
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
                    AccountInstance.getInstance(this.currentAccount).getSendMessagesHelper().sendMessage(charSequence.toString(), jLongValue, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                }
                AccountInstance.getInstance(this.currentAccount).getSendMessagesHelper().sendMessage(arrayList2, jLongValue, true, 0);
            }
            dialogsActivity.finishFragment();
            return;
        }
        long jLongValue2 = ((Long) arrayList.get(0)).longValue();
        int i2 = (int) jLongValue2;
        int i3 = (int) (jLongValue2 >> 32);
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", true);
        if (i2 == 0) {
            bundle.putInt("enc_id", i3);
        } else if (i2 > 0) {
            bundle.putInt("user_id", i2);
        } else if (i2 < 0) {
            bundle.putInt("chat_id", -i2);
        }
        if (i2 == 0 || AccountInstance.getInstance(this.currentAccount).getMessagesController().checkCanOpenChat(bundle, dialogsActivity)) {
            ChatActivity chatActivity = new ChatActivity(bundle);
            dialogsActivity.presentFragment(chatActivity, true);
            chatActivity.showFieldPanelForForward(true, arrayList2);
        }
    }

    @Override // org.rbmain.ui.FilteredSearchView.UiCallback
    public void goToMessage(MessageObject messageObject) {
        Bundle bundle = new Bundle();
        int dialogId = (int) messageObject.getDialogId();
        int dialogId2 = (int) (messageObject.getDialogId() >> 32);
        if (dialogId == 0) {
            bundle.putInt("enc_id", dialogId2);
        } else if (dialogId > 0) {
            bundle.putInt("user_id", dialogId);
        } else if (dialogId < 0) {
            TLRPC$Chat chat = AccountInstance.getInstance(this.currentAccount).getMessagesController().getChat(Integer.valueOf(-dialogId));
            if (chat != null && chat.migrated_to != null) {
                bundle.putInt("migrated_to", dialogId);
                dialogId = -chat.migrated_to.channel_id;
            }
            bundle.putInt("chat_id", -dialogId);
        }
        bundle.putLong("message_id", messageObject.getId());
        this.parent.presentFragment(new ChatActivity(bundle));
        showActionMode(false);
    }

    @Override // org.rbmain.ui.FilteredSearchView.UiCallback
    public int getFolderId() {
        return this.folderId;
    }

    @Override // org.rbmain.ui.FilteredSearchView.UiCallback
    public boolean actionModeShowing() {
        return this.isActionModeShowed;
    }

    public void hideActionMode() {
        showActionMode(false);
    }

    @Override // org.rbmain.ui.FilteredSearchView.UiCallback
    public void toggleItemSelection(MessageObject messageObject, View view, int i) {
        FilteredSearchView.MessageHashId messageHashId = new FilteredSearchView.MessageHashId(messageObject.getId(), messageObject.getDialogId());
        if (this.selectedFiles.containsKey(messageHashId)) {
            this.selectedFiles.remove(messageHashId);
        } else if (this.selectedFiles.size() >= 100) {
            return;
        } else {
            this.selectedFiles.put(messageHashId, messageObject);
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
            ((SharedPhotoVideoCell) view).setChecked(i, this.selectedFiles.containsKey(messageHashId), true);
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

    @Override // org.rbmain.ui.FilteredSearchView.UiCallback
    public boolean isSelected(FilteredSearchView.MessageHashId messageHashId) {
        return this.selectedFiles.containsKey(messageHashId);
    }

    @Override // org.rbmain.ui.FilteredSearchView.UiCallback
    public void showActionMode() {
        showActionMode(true);
    }

    @Override // org.rbmain.ui.Components.ViewPagerFixed
    protected void onItemSelected(View view, View view2, int i, int i2) {
        if (i == 0) {
            if (this.noMediaFiltersSearchView.getVisibility() == 0) {
                this.noMediaFiltersSearchView.setDelegate(this.filteredSearchViewDelegate, false);
                this.dialogsSearchAdapter.setFiltersDelegate(null, false);
            } else {
                this.noMediaFiltersSearchView.setDelegate(null, false);
                this.dialogsSearchAdapter.setFiltersDelegate(this.filteredSearchViewDelegate, true);
            }
        } else if (view instanceof FilteredSearchView) {
            ((FilteredSearchView) view).setDelegate(this.filteredSearchViewDelegate, i2 == 0 && this.noMediaFiltersSearchView.getVisibility() != 0);
        }
        if (view2 instanceof FilteredSearchView) {
            ((FilteredSearchView) view2).setDelegate(null, false);
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
        arrayList.add(new ThemeDescription(this.emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText));
    }

    public void updateColors() {
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
        setPosition(0);
        if (this.dialogsSearchAdapter.getItemCount() > 0) {
            this.searchlayoutManager.scrollToPositionWithOffset(0, 0);
        }
        this.viewsByType.clear();
    }

    @Override // org.rbmain.ui.Components.ViewPagerFixed
    public void setPosition(int i) {
        super.setPosition(i);
        this.viewsByType.clear();
        ViewPagerFixed.TabsView tabsView = this.tabsView;
        if (tabsView != null) {
            tabsView.selectTabWithId(i, 1.0f);
        }
        invalidate();
    }

    public void setKeyboardHeight(int i) {
        this.keyboardSize = i;
        boolean z = getVisibility() == 0 && getAlpha() > 0.0f;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof FilteredSearchView) {
                ((FilteredSearchView) getChildAt(i2)).setKeyboardHeight(i, z);
            } else if (getChildAt(i2) == this.searchContainer) {
                this.emptyView.setKeyboardHeight(i, z);
                this.noMediaFiltersSearchView.setKeyboardHeight(i, z);
            }
        }
    }

    public void showOnlyDialogsAdapter(boolean z) {
        this.showOnlyDialogsAdapter = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void messagesDeleted(int r12, java.util.ArrayList<java.lang.Long> r13) {
        /*
            r11 = this;
            android.util.SparseArray<android.view.View> r0 = r11.viewsByType
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L1e
            android.util.SparseArray<android.view.View> r3 = r11.viewsByType
            java.lang.Object r3 = r3.valueAt(r2)
            android.view.View r3 = (android.view.View) r3
            boolean r4 = r3 instanceof org.rbmain.ui.FilteredSearchView
            if (r4 == 0) goto L1b
            org.rbmain.ui.FilteredSearchView r3 = (org.rbmain.ui.FilteredSearchView) r3
            r3.messagesDeleted(r12, r13)
        L1b:
            int r2 = r2 + 1
            goto L8
        L1e:
            r0 = 0
        L1f:
            int r2 = r11.getChildCount()
            if (r0 >= r2) goto L39
            android.view.View r2 = r11.getChildAt(r0)
            boolean r2 = r2 instanceof org.rbmain.ui.FilteredSearchView
            if (r2 == 0) goto L36
            android.view.View r2 = r11.getChildAt(r0)
            org.rbmain.ui.FilteredSearchView r2 = (org.rbmain.ui.FilteredSearchView) r2
            r2.messagesDeleted(r12, r13)
        L36:
            int r0 = r0 + 1
            goto L1f
        L39:
            org.rbmain.ui.FilteredSearchView r0 = r11.noMediaFiltersSearchView
            r0.messagesDeleted(r12, r13)
            java.util.HashMap<org.rbmain.ui.FilteredSearchView$MessageHashId, org.rbmain.messenger.MessageObject> r0 = r11.selectedFiles
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Ld7
            r0 = 0
            java.util.HashMap<org.rbmain.ui.FilteredSearchView$MessageHashId, org.rbmain.messenger.MessageObject> r2 = r11.selectedFiles
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L51:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto Ld7
            java.lang.Object r3 = r2.next()
            org.rbmain.ui.FilteredSearchView$MessageHashId r3 = (org.rbmain.ui.FilteredSearchView.MessageHashId) r3
            java.util.HashMap<org.rbmain.ui.FilteredSearchView$MessageHashId, org.rbmain.messenger.MessageObject> r4 = r11.selectedFiles
            java.lang.Object r4 = r4.get(r3)
            org.rbmain.messenger.MessageObject r4 = (org.rbmain.messenger.MessageObject) r4
            long r5 = r4.getDialogId()
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 >= 0) goto L7a
            long r5 = -r5
            int r6 = (int) r5
            int r5 = r11.currentAccount
            boolean r5 = org.rbmain.messenger.ChatObject.isChannel(r6, r5)
            if (r5 == 0) goto L7a
            goto L7b
        L7a:
            r6 = 0
        L7b:
            if (r6 != r12) goto La1
            r5 = 0
        L7e:
            int r6 = r13.size()
            if (r5 >= r6) goto La1
            long r6 = r4.getId()
            java.lang.Object r8 = r13.get(r5)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L9e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r3)
        L9e:
            int r5 = r5 + 1
            goto L7e
        La1:
            if (r0 == 0) goto L51
            int r3 = r0.size()
            r4 = 0
        La8:
            if (r4 >= r3) goto Lb6
            java.util.HashMap<org.rbmain.ui.FilteredSearchView$MessageHashId, org.rbmain.messenger.MessageObject> r5 = r11.selectedFiles
            java.lang.Object r6 = r0.get(r4)
            r5.remove(r6)
            int r4 = r4 + 1
            goto La8
        Lb6:
            org.rbmain.ui.Components.NumberTextView r3 = r11.selectedMessagesCountTextView
            java.util.HashMap<org.rbmain.ui.FilteredSearchView$MessageHashId, org.rbmain.messenger.MessageObject> r4 = r11.selectedFiles
            int r4 = r4.size()
            r5 = 1
            r3.setNumber(r4, r5)
            org.rbmain.ui.ActionBar.ActionBarMenuItem r3 = r11.gotoItem
            if (r3 == 0) goto L51
            java.util.HashMap<org.rbmain.ui.FilteredSearchView$MessageHashId, org.rbmain.messenger.MessageObject> r4 = r11.selectedFiles
            int r4 = r4.size()
            if (r4 != r5) goto Ld0
            r4 = 0
            goto Ld2
        Ld0:
            r4 = 8
        Ld2:
            r3.setVisibility(r4)
            goto L51
        Ld7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.SearchViewPager.messagesDeleted(int, java.util.ArrayList):void");
    }

    public void runResultsEnterAnimation() {
        this.dialogsSearchAdapter.getItemCount();
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
    }
}
