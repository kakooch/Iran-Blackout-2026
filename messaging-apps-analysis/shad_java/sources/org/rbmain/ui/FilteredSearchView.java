package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputMessagesFilterEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputPeerEmpty;
import org.rbmain.tgnet.TLRPC$TL_messages_search;
import org.rbmain.tgnet.TLRPC$TL_messages_searchGlobal;
import org.rbmain.tgnet.TLRPC$TL_webPageEmpty;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.tgnet.TLRPC$messages_Messages;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Adapters.FiltersView;
import org.rbmain.ui.Cells.ChatActionCell;
import org.rbmain.ui.Cells.ContextLinkCell;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.LoadingCell;
import org.rbmain.ui.Cells.ProfileSearchCell;
import org.rbmain.ui.Cells.SharedAudioCell;
import org.rbmain.ui.Cells.SharedDocumentCell;
import org.rbmain.ui.Cells.SharedLinkCell;
import org.rbmain.ui.Cells.SharedMediaSectionCell;
import org.rbmain.ui.Cells.SharedPhotoVideoCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.ColoredImageSpan;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.EmbedBottomSheet;
import org.rbmain.ui.Components.FlickerLoadingView;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.SearchViewPager;
import org.rbmain.ui.Components.StickerEmptyView;
import org.rbmain.ui.PhotoViewer;

/* loaded from: classes4.dex */
public class FilteredSearchView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private static SpannableStringBuilder arrowSpan;
    RecyclerView.Adapter adapter;
    private int animationIndex;
    private SearchViewPager.ChatPreviewDelegate chatPreviewDelegate;
    Runnable clearCurrentResultsRunnable;
    private int columnsCount;
    private String currentDataQuery;
    int currentSearchDialogId;
    FiltersView.MediaFilterData currentSearchFilter;
    long currentSearchMaxDate;
    long currentSearchMinDate;
    String currentSearchString;
    private Delegate delegate;
    private OnlyUserFiltersAdapter dialogsAdapter;
    StickerEmptyView emptyView;
    private boolean endReached;
    private AnimatorSet floatingDateAnimation;
    private final ChatActionCell floatingDateView;
    private Runnable hideFloatingDateRunnable;
    boolean ignoreRequestLayout;
    private boolean isLoading;
    int lastAccount;
    String lastMessagesSearchString;
    String lastSearchFilterQueryString;
    public final LinearLayoutManager layoutManager;
    private final FlickerLoadingView loadingView;
    ArrayList<Object> localTipChats;
    ArrayList<FiltersView.DateData> localTipDates;
    private final MessageHashId messageHashIdTmp;
    public ArrayList<MessageObject> messages;
    public LongSparseArray<MessageObject> messagesById;
    private int nextSearchRate;
    Activity parentActivity;
    BaseFragment parentFragment;
    private int photoViewerClassGuid;
    private PhotoViewer.PhotoViewerProvider provider;
    public RecyclerListView recyclerListView;
    private int requestIndex;
    Runnable searchRunnable;
    public HashMap<String, ArrayList<MessageObject>> sectionArrays;
    public ArrayList<String> sections;
    private SharedDocumentsAdapter sharedAudioAdapter;
    private SharedDocumentsAdapter sharedDocumentsAdapter;
    private SharedLinksAdapter sharedLinksAdapter;
    private SharedPhotoVideoAdapter sharedPhotoVideoAdapter;
    private SharedDocumentsAdapter sharedVoiceAdapter;
    private int totalCount;
    private UiCallback uiCallback;

    public interface Delegate {
        void updateFiltersView(boolean z, ArrayList<Object> arrayList, ArrayList<FiltersView.DateData> arrayList2);
    }

    public interface UiCallback {
        boolean actionModeShowing();

        int getFolderId();

        void goToMessage(MessageObject messageObject);

        boolean isSelected(MessageHashId messageHashId);

        void showActionMode();

        void toggleItemSelection(MessageObject messageObject, View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        hideFloatingDateView(true);
    }

    public FilteredSearchView(BaseFragment baseFragment) {
        super(baseFragment.getParentActivity());
        this.messages = new ArrayList<>();
        this.messagesById = new LongSparseArray<>();
        this.sections = new ArrayList<>();
        this.sectionArrays = new HashMap<>();
        this.columnsCount = 3;
        this.messageHashIdTmp = new MessageHashId(0L, 0L);
        this.localTipChats = new ArrayList<>();
        this.localTipDates = new ArrayList<>();
        this.clearCurrentResultsRunnable = new Runnable() { // from class: org.rbmain.ui.FilteredSearchView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FilteredSearchView.this.isLoading) {
                    FilteredSearchView.this.messages.clear();
                    FilteredSearchView.this.sections.clear();
                    FilteredSearchView.this.sectionArrays.clear();
                    RecyclerView.Adapter adapter = FilteredSearchView.this.adapter;
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        };
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: org.rbmain.ui.FilteredSearchView.2
            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public int getTotalImageCount() {
                return FilteredSearchView.this.totalCount;
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public boolean loadMore() {
                if (FilteredSearchView.this.endReached) {
                    return true;
                }
                FilteredSearchView filteredSearchView = FilteredSearchView.this;
                filteredSearchView.search(filteredSearchView.currentSearchDialogId, filteredSearchView.currentSearchMinDate, filteredSearchView.currentSearchMaxDate, filteredSearchView.currentSearchFilter, filteredSearchView.lastMessagesSearchString, false);
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public org.rbmain.ui.PhotoViewer.PlaceProviderObject getPlaceForPhoto(org.rbmain.messenger.MessageObject r17, org.rbmain.tgnet.TLRPC$FileLocation r18, int r19, boolean r20) {
                /*
                    Method dump skipped, instructions count: 281
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.FilteredSearchView.AnonymousClass2.getPlaceForPhoto(org.rbmain.messenger.MessageObject, org.rbmain.tgnet.TLRPC$FileLocation, int, boolean):org.rbmain.ui.PhotoViewer$PlaceProviderObject");
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public CharSequence getTitleFor(int i) {
                return FilteredSearchView.createFromInfoString(FilteredSearchView.this.messages.get(i));
            }

            @Override // org.rbmain.ui.PhotoViewer.EmptyPhotoViewerProvider, org.rbmain.ui.PhotoViewer.PhotoViewerProvider
            public CharSequence getSubtitleFor(int i) {
                return LocaleController.formatDateAudio(FilteredSearchView.this.messages.get(i).messageOwner.date, false);
            }
        };
        this.animationIndex = -1;
        this.hideFloatingDateRunnable = new Runnable() { // from class: org.rbmain.ui.FilteredSearchView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.parentFragment = baseFragment;
        Activity parentActivity = baseFragment.getParentActivity();
        this.parentActivity = parentActivity;
        setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        RecyclerListView recyclerListView = new RecyclerListView(parentActivity) { // from class: org.rbmain.ui.FilteredSearchView.3
            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                if (getAdapter() == FilteredSearchView.this.sharedPhotoVideoAdapter) {
                    for (int i = 0; i < getChildCount(); i++) {
                        if (getChildViewHolder(getChildAt(i)).getItemViewType() == 1) {
                            canvas.save();
                            canvas.translate(getChildAt(i).getX(), (getChildAt(i).getY() - getChildAt(i).getMeasuredHeight()) + AndroidUtilities.dp(2.0f));
                            getChildAt(i).draw(canvas);
                            canvas.restore();
                            invalidate();
                        }
                    }
                }
                super.dispatchDraw(canvas);
            }

            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View view, long j) {
                if (getAdapter() == FilteredSearchView.this.sharedPhotoVideoAdapter && getChildViewHolder(view).getItemViewType() == 1) {
                    return true;
                }
                return super.drawChild(canvas, view, j);
            }
        };
        this.recyclerListView = recyclerListView;
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.FilteredSearchView$$ExternalSyntheticLambda4
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$1(view, i);
            }
        });
        this.recyclerListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListenerExtended() { // from class: org.rbmain.ui.FilteredSearchView.4
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public boolean onItemClick(View view, int i, float f, float f2) {
                if (view instanceof SharedDocumentCell) {
                    FilteredSearchView.this.onItemLongClick(((SharedDocumentCell) view).getMessage(), view, 0);
                } else if (view instanceof SharedLinkCell) {
                    FilteredSearchView.this.onItemLongClick(((SharedLinkCell) view).getMessage(), view, 0);
                } else if (view instanceof SharedAudioCell) {
                    FilteredSearchView.this.onItemLongClick(((SharedAudioCell) view).getMessage(), view, 0);
                } else if (view instanceof ContextLinkCell) {
                    FilteredSearchView.this.onItemLongClick(((ContextLinkCell) view).getMessageObject(), view, 0);
                } else if (view instanceof DialogCell) {
                    if (!FilteredSearchView.this.uiCallback.actionModeShowing()) {
                        DialogCell dialogCell = (DialogCell) view;
                        if (dialogCell.isPointInsideAvatar(f, f2)) {
                            FilteredSearchView.this.chatPreviewDelegate.startChatPreview(dialogCell);
                            return true;
                        }
                    }
                    FilteredSearchView.this.onItemLongClick(((DialogCell) view).getMessage(), view, 0);
                }
                return true;
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public void onMove(float f, float f2) {
                FilteredSearchView.this.chatPreviewDelegate.move(f2);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public void onLongClickRelease() {
                FilteredSearchView.this.chatPreviewDelegate.finish();
            }
        });
        this.recyclerListView.setPadding(0, 0, 0, AndroidUtilities.dp(3.0f));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(parentActivity);
        this.layoutManager = linearLayoutManager;
        this.recyclerListView.setLayoutManager(linearLayoutManager);
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(parentActivity) { // from class: org.rbmain.ui.FilteredSearchView.5
            @Override // org.rbmain.ui.Components.FlickerLoadingView
            public int getColumnsCount() {
                return FilteredSearchView.this.columnsCount;
            }
        };
        this.loadingView = flickerLoadingView;
        addView(flickerLoadingView);
        addView(this.recyclerListView);
        this.recyclerListView.setSectionsType(2);
        this.recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.FilteredSearchView.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 1) {
                    AndroidUtilities.hideKeyboard(FilteredSearchView.this.parentActivity.getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                MessageObject messageObject;
                if (recyclerView.getAdapter() != null) {
                    FilteredSearchView filteredSearchView = FilteredSearchView.this;
                    if (filteredSearchView.adapter == null) {
                        return;
                    }
                    int iFindFirstVisibleItemPosition = filteredSearchView.layoutManager.findFirstVisibleItemPosition();
                    int iFindLastVisibleItemPosition = FilteredSearchView.this.layoutManager.findLastVisibleItemPosition();
                    int iAbs = Math.abs(iFindLastVisibleItemPosition - iFindFirstVisibleItemPosition) + 1;
                    int itemCount = recyclerView.getAdapter().getItemCount();
                    if (!FilteredSearchView.this.isLoading && iAbs > 0 && iFindLastVisibleItemPosition >= itemCount - 10 && !FilteredSearchView.this.endReached) {
                        FilteredSearchView filteredSearchView2 = FilteredSearchView.this;
                        filteredSearchView2.search(filteredSearchView2.currentSearchDialogId, filteredSearchView2.currentSearchMinDate, filteredSearchView2.currentSearchMaxDate, filteredSearchView2.currentSearchFilter, filteredSearchView2.lastMessagesSearchString, false);
                    }
                    FilteredSearchView filteredSearchView3 = FilteredSearchView.this;
                    if (filteredSearchView3.adapter == filteredSearchView3.sharedPhotoVideoAdapter) {
                        if (i2 != 0 && !FilteredSearchView.this.messages.isEmpty() && TextUtils.isEmpty(FilteredSearchView.this.currentDataQuery)) {
                            FilteredSearchView.this.showFloatingDateView();
                        }
                        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                        if (viewHolderFindViewHolderForAdapterPosition == null || viewHolderFindViewHolderForAdapterPosition.getItemViewType() != 0) {
                            return;
                        }
                        View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                        if (!(view instanceof SharedPhotoVideoCell) || (messageObject = ((SharedPhotoVideoCell) view).getMessageObject(0)) == null) {
                            return;
                        }
                        FilteredSearchView.this.floatingDateView.setCustomDate(messageObject.messageOwner.date, false, true);
                    }
                }
            }
        });
        ChatActionCell chatActionCell = new ChatActionCell(parentActivity);
        this.floatingDateView = chatActionCell;
        chatActionCell.setCustomDate((int) (System.currentTimeMillis() / 1000), false, false);
        chatActionCell.setAlpha(0.0f);
        chatActionCell.setOverrideColor(Theme.key_chat_mediaTimeBackground, Theme.key_chat_mediaTimeText);
        chatActionCell.setTranslationY(-AndroidUtilities.dp(48.0f));
        addView(chatActionCell, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 4.0f, 0.0f, 0.0f));
        this.dialogsAdapter = new OnlyUserFiltersAdapter();
        this.sharedPhotoVideoAdapter = new SharedPhotoVideoAdapter(getContext());
        this.sharedDocumentsAdapter = new SharedDocumentsAdapter(getContext(), 1);
        this.sharedLinksAdapter = new SharedLinksAdapter(getContext());
        this.sharedAudioAdapter = new SharedDocumentsAdapter(getContext(), 4);
        this.sharedVoiceAdapter = new SharedDocumentsAdapter(getContext(), 2);
        StickerEmptyView stickerEmptyView = new StickerEmptyView(parentActivity, flickerLoadingView, 1);
        this.emptyView = stickerEmptyView;
        addView(stickerEmptyView);
        this.recyclerListView.setEmptyView(this.emptyView);
        this.emptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view, int i) {
        if (view instanceof SharedDocumentCell) {
            onItemClick(i, view, ((SharedDocumentCell) view).getMessage(), 0);
            return;
        }
        if (view instanceof SharedLinkCell) {
            onItemClick(i, view, ((SharedLinkCell) view).getMessage(), 0);
            return;
        }
        if (view instanceof SharedAudioCell) {
            onItemClick(i, view, ((SharedAudioCell) view).getMessage(), 0);
        } else if (view instanceof ContextLinkCell) {
            onItemClick(i, view, ((ContextLinkCell) view).getMessageObject(), 0);
        } else if (view instanceof DialogCell) {
            onItemClick(i, view, ((DialogCell) view).getMessage(), 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.text.SpannableStringBuilder] */
    public static CharSequence createFromInfoString(MessageObject messageObject) {
        if (arrowSpan == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-");
            arrowSpan = spannableStringBuilder;
            spannableStringBuilder.setSpan(new ColoredImageSpan(ContextCompat.getDrawable(ApplicationLoader.applicationContext, R.drawable.search_arrow).mutate()), 0, 1, 0);
        }
        ?? name = 0;
        TLRPC$User user = messageObject.messageOwner.from_id.user_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getUser(Integer.valueOf(messageObject.messageOwner.from_id.user_id)) : null;
        TLRPC$Chat chat = messageObject.messageOwner.from_id.chat_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Integer.valueOf(messageObject.messageOwner.peer_id.chat_id)) : null;
        if (chat == null) {
            chat = messageObject.messageOwner.from_id.channel_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Integer.valueOf(messageObject.messageOwner.peer_id.channel_id)) : null;
        }
        TLRPC$Chat chat2 = messageObject.messageOwner.peer_id.channel_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Integer.valueOf(messageObject.messageOwner.peer_id.channel_id)) : null;
        if (chat2 == null) {
            chat2 = messageObject.messageOwner.peer_id.chat_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Integer.valueOf(messageObject.messageOwner.peer_id.chat_id)) : null;
        }
        if (user != null && chat2 != null) {
            name = new SpannableStringBuilder();
            name.append(ContactsController.formatName(user.first_name, user.last_name)).append(' ').append((CharSequence) arrowSpan).append(' ').append((CharSequence) chat2.title);
        } else if (user != null) {
            name = ContactsController.formatName(user.first_name, user.last_name);
        } else if (chat != null) {
            name = chat.title;
        }
        return name == 0 ? BuildConfig.FLAVOR : name;
    }

    public void search(final int i, final long j, final long j2, final FiltersView.MediaFilterData mediaFilterData, final String str, boolean z) {
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Long.valueOf(j2);
        objArr[3] = Integer.valueOf(mediaFilterData == null ? -1 : mediaFilterData.filterType);
        objArr[4] = str;
        final String str2 = String.format(locale, "%d%d%d%d%s", objArr);
        String str3 = this.lastSearchFilterQueryString;
        boolean z2 = str3 != null && str3.equals(str2);
        boolean z3 = !z2 && z;
        if (i == this.currentSearchDialogId && this.currentSearchMinDate == j) {
            int i2 = (this.currentSearchMaxDate > j2 ? 1 : (this.currentSearchMaxDate == j2 ? 0 : -1));
        }
        this.currentSearchFilter = mediaFilterData;
        this.currentSearchDialogId = i;
        this.currentSearchMinDate = j;
        this.currentSearchMaxDate = j2;
        this.currentSearchString = str;
        Runnable runnable = this.searchRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        AndroidUtilities.cancelRunOnUIThread(this.clearCurrentResultsRunnable);
        if (z2 && z) {
            return;
        }
        if (z3 || (mediaFilterData == null && i == 0 && j == 0 && j2 == 0)) {
            this.messages.clear();
            this.sections.clear();
            this.sectionArrays.clear();
            this.isLoading = true;
            this.emptyView.setVisibility(0);
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.requestIndex++;
            if (this.recyclerListView.getPinnedHeader() != null) {
                this.recyclerListView.getPinnedHeader().setAlpha(0.0f);
            }
            this.localTipChats.clear();
            this.localTipDates.clear();
            if (!z3) {
                return;
            }
        } else if (z && !this.messages.isEmpty()) {
            return;
        }
        this.isLoading = true;
        RecyclerView.Adapter adapter2 = this.adapter;
        if (adapter2 != null) {
            adapter2.notifyDataSetChanged();
        }
        if (!z2) {
            this.clearCurrentResultsRunnable.run();
            this.emptyView.showProgress(true, !z);
        }
        if (TextUtils.isEmpty(str)) {
            this.localTipDates.clear();
            this.localTipChats.clear();
            Delegate delegate = this.delegate;
            if (delegate != null) {
                delegate.updateFiltersView(false, null, null);
            }
        }
        final int i3 = this.requestIndex + 1;
        this.requestIndex = i3;
        final int folderId = this.uiCallback.getFolderId();
        final int i4 = UserConfig.selectedAccount;
        final boolean z4 = z2;
        Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.FilteredSearchView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws NumberFormatException {
                this.f$0.lambda$search$4(i, str, mediaFilterData, i4, j, j2, z4, folderId, str2, i3);
            }
        };
        this.searchRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, (!z2 || this.messages.isEmpty()) ? 350L : 0L);
        if (mediaFilterData == null) {
            this.loadingView.setViewType(1);
            return;
        }
        int i5 = mediaFilterData.filterType;
        if (i5 == 0) {
            if (!TextUtils.isEmpty(this.currentSearchString)) {
                this.loadingView.setViewType(1);
                return;
            } else {
                this.loadingView.setViewType(2);
                return;
            }
        }
        if (i5 == 1) {
            this.loadingView.setViewType(3);
            return;
        }
        if (i5 == 3 || i5 == 5) {
            this.loadingView.setViewType(4);
        } else if (i5 == 2) {
            this.loadingView.setViewType(5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$search$4(final int i, final String str, final FiltersView.MediaFilterData mediaFilterData, final int i2, final long j, long j2, final boolean z, int i3, String str2, final int i4) throws NumberFormatException {
        long j3;
        long j4;
        TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal;
        ArrayList<Object> arrayList = null;
        if (i != 0) {
            TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
            tLRPC$TL_messages_search.q = str;
            tLRPC$TL_messages_search.limit = 20;
            tLRPC$TL_messages_search.filter = mediaFilterData == null ? new TLRPC$TL_inputMessagesFilterEmpty() : mediaFilterData.filter;
            tLRPC$TL_messages_search.peer = AccountInstance.getInstance(i2).getMessagesController().getInputPeer(i);
            if (j > 0) {
                tLRPC$TL_messages_search.min_date = (int) (j / 1000);
            }
            if (j2 > 0) {
                tLRPC$TL_messages_search.max_date = (int) (j2 / 1000);
            }
            if (z && str.equals(this.lastMessagesSearchString) && !this.messages.isEmpty()) {
                tLRPC$TL_messages_search.offset_id = this.messages.get(r2.size() - 1).getId();
                tLRPC$TL_messages_searchGlobal = tLRPC$TL_messages_search;
            } else {
                tLRPC$TL_messages_search.offset_id = 0L;
                tLRPC$TL_messages_searchGlobal = tLRPC$TL_messages_search;
            }
        } else {
            if (TextUtils.isEmpty(str)) {
                j3 = 0;
            } else {
                ArrayList<Object> arrayList2 = new ArrayList<>();
                j3 = 0;
                MessagesStorage.getInstance(i2).localSearch(0, str, arrayList2, new ArrayList<>(), new ArrayList<>(), i3);
                arrayList = arrayList2;
            }
            TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal2 = new TLRPC$TL_messages_searchGlobal();
            tLRPC$TL_messages_searchGlobal2.limit = 20;
            tLRPC$TL_messages_searchGlobal2.q = str;
            tLRPC$TL_messages_searchGlobal2.filter = mediaFilterData == null ? new TLRPC$TL_inputMessagesFilterEmpty() : mediaFilterData.filter;
            if (j > j3) {
                j4 = 1000;
                tLRPC$TL_messages_searchGlobal2.min_date = (int) (j / 1000);
            } else {
                j4 = 1000;
            }
            if (j2 > j3) {
                tLRPC$TL_messages_searchGlobal2.max_date = (int) (j2 / j4);
            }
            if (z && str.equals(this.lastMessagesSearchString) && !this.messages.isEmpty()) {
                MessageObject messageObject = this.messages.get(r2.size() - 1);
                tLRPC$TL_messages_searchGlobal2.offset_id = messageObject.getId();
                tLRPC$TL_messages_searchGlobal2.offset_rate = this.nextSearchRate;
                TLRPC$Peer tLRPC$Peer = messageObject.messageOwner.peer_id;
                int i5 = tLRPC$Peer.channel_id;
                tLRPC$TL_messages_searchGlobal2.offset_peer = MessagesController.getInstance(i2).getInputPeer((i5 == 0 && (i5 = tLRPC$Peer.chat_id) == 0) ? tLRPC$Peer.user_id : -i5);
            } else {
                tLRPC$TL_messages_searchGlobal2.offset_rate = 0;
                tLRPC$TL_messages_searchGlobal2.offset_id = j3;
                tLRPC$TL_messages_searchGlobal2.offset_peer = new TLRPC$TL_inputPeerEmpty();
            }
            tLRPC$TL_messages_searchGlobal2.flags |= 1;
            tLRPC$TL_messages_searchGlobal2.folder_id = this.uiCallback.getFolderId();
            tLRPC$TL_messages_searchGlobal = tLRPC$TL_messages_searchGlobal2;
        }
        final ArrayList<Object> arrayList3 = arrayList;
        TLRPC$TL_messages_searchGlobal tLRPC$TL_messages_searchGlobal3 = tLRPC$TL_messages_searchGlobal;
        this.lastMessagesSearchString = str;
        this.lastSearchFilterQueryString = str2;
        final ArrayList arrayList4 = new ArrayList();
        FiltersView.fillTipDates(this.lastMessagesSearchString, arrayList4);
        ConnectionsManager.getInstance(i2).sendRequest(tLRPC$TL_messages_searchGlobal3, new RequestDelegate() { // from class: org.rbmain.ui.FilteredSearchView$$ExternalSyntheticLambda3
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$search$3(i2, str, i4, z, mediaFilterData, i, j, arrayList3, arrayList4, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$search$3(final int i, final String str, final int i2, final boolean z, final FiltersView.MediaFilterData mediaFilterData, final int i3, final long j, final ArrayList arrayList, final ArrayList arrayList2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final ArrayList arrayList3 = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            int size = tLRPC$messages_Messages.messages.size();
            for (int i4 = 0; i4 < size; i4++) {
                MessageObject messageObject = new MessageObject(i, tLRPC$messages_Messages.messages.get(i4), false, true);
                messageObject.setQuery(str);
                arrayList3.add(messageObject);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.FilteredSearchView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f$0.lambda$search$2(i2, tLRPC$TL_error, tLObject, i, z, str, arrayList3, mediaFilterData, i3, j, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$search$2(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, final int i2, boolean z, String str, ArrayList arrayList, FiltersView.MediaFilterData mediaFilterData, int i3, long j, ArrayList arrayList2, ArrayList arrayList3) throws Resources.NotFoundException {
        String string;
        if (i != this.requestIndex) {
            return;
        }
        this.isLoading = false;
        boolean z2 = true;
        if (tLRPC$TL_error != null) {
            this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
            this.emptyView.subtitle.setVisibility(0);
            this.emptyView.subtitle.setText(LocaleController.getString("SearchEmptyViewFilteredSubtitle2", R.string.SearchEmptyViewFilteredSubtitle2));
            this.emptyView.showProgress(false, true);
            return;
        }
        this.emptyView.showProgress(false);
        TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
        this.nextSearchRate = tLRPC$messages_Messages.next_rate;
        MessagesStorage.getInstance(i2).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
        MessagesController.getInstance(i2).putUsers(tLRPC$messages_Messages.users, false);
        MessagesController.getInstance(i2).putChats(tLRPC$messages_Messages.chats, false);
        if (!z) {
            this.messages.clear();
            this.messagesById.clear();
            this.sections.clear();
            this.sectionArrays.clear();
        }
        this.totalCount = tLRPC$messages_Messages.count;
        this.currentDataQuery = str;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            MessageObject messageObject = (MessageObject) arrayList.get(i4);
            ArrayList<MessageObject> arrayList4 = this.sectionArrays.get(messageObject.monthKey);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList<>();
                this.sectionArrays.put(messageObject.monthKey, arrayList4);
                this.sections.add(messageObject.monthKey);
            }
            arrayList4.add(messageObject);
            this.messages.add(messageObject);
            this.messagesById.put(messageObject.getId(), messageObject);
            if (PhotoViewer.getInstance().isVisible()) {
                PhotoViewer.getInstance().addPhoto(messageObject, this.photoViewerClassGuid);
            }
        }
        if (this.messages.size() > this.totalCount) {
            this.totalCount = this.messages.size();
        }
        this.messages.size();
        this.endReached = this.messages.size() >= this.totalCount;
        if (this.messages.isEmpty()) {
            if (mediaFilterData != null) {
                if (TextUtils.isEmpty(this.currentDataQuery) && i3 == 0 && j == 0) {
                    this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle", R.string.SearchEmptyViewTitle));
                    if (i3 == 0 && j == 0) {
                        int i5 = mediaFilterData.filterType;
                        if (i5 == 1) {
                            string = LocaleController.getString("SearchEmptyViewFilteredSubtitleFiles", R.string.SearchEmptyViewFilteredSubtitleFiles);
                        } else if (i5 == 0) {
                            string = LocaleController.getString("SearchEmptyViewFilteredSubtitleMedia", R.string.SearchEmptyViewFilteredSubtitleMedia);
                        } else if (i5 == 2) {
                            string = LocaleController.getString("SearchEmptyViewFilteredSubtitleLinks", R.string.SearchEmptyViewFilteredSubtitleLinks);
                        } else if (i5 == 3) {
                            string = LocaleController.getString("SearchEmptyViewFilteredSubtitleMusic", R.string.SearchEmptyViewFilteredSubtitleMusic);
                        } else {
                            string = LocaleController.getString("SearchEmptyViewFilteredSubtitleVoice", R.string.SearchEmptyViewFilteredSubtitleVoice);
                        }
                        this.emptyView.subtitle.setVisibility(0);
                        this.emptyView.subtitle.setText(string);
                    } else {
                        this.emptyView.subtitle.setVisibility(8);
                    }
                } else {
                    this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
                    this.emptyView.subtitle.setVisibility(0);
                    this.emptyView.subtitle.setText(LocaleController.getString("SearchEmptyViewFilteredSubtitle2", R.string.SearchEmptyViewFilteredSubtitle2));
                }
            } else {
                this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
                this.emptyView.subtitle.setVisibility(8);
            }
        }
        if (mediaFilterData != null) {
            int i6 = mediaFilterData.filterType;
            if (i6 != 0) {
                if (i6 == 1) {
                    this.adapter = this.sharedDocumentsAdapter;
                } else if (i6 == 2) {
                    this.adapter = this.sharedLinksAdapter;
                } else if (i6 == 3) {
                    this.adapter = this.sharedAudioAdapter;
                } else if (i6 == 5) {
                    this.adapter = this.sharedVoiceAdapter;
                }
            } else if (TextUtils.isEmpty(this.currentDataQuery)) {
                this.adapter = this.sharedPhotoVideoAdapter;
            } else {
                this.adapter = this.dialogsAdapter;
            }
        } else {
            this.adapter = this.dialogsAdapter;
        }
        RecyclerView.Adapter adapter = this.recyclerListView.getAdapter();
        RecyclerView.Adapter adapter2 = this.adapter;
        if (adapter != adapter2) {
            this.recyclerListView.setAdapter(adapter2);
        }
        if (!z) {
            this.localTipChats.clear();
            if (arrayList2 != null) {
                this.localTipChats.addAll(arrayList2);
            }
            if (str.length() >= 3 && (LocaleController.getString("SavedMessages", R.string.SavedMessages).toLowerCase().startsWith(str) || "saved messages".startsWith(str))) {
                int i7 = 0;
                while (true) {
                    if (i7 >= this.localTipChats.size()) {
                        z2 = false;
                        break;
                    } else if ((this.localTipChats.get(i7) instanceof TLRPC$User) && UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser().id == ((TLRPC$User) this.localTipChats.get(i7)).id) {
                        break;
                    } else {
                        i7++;
                    }
                }
                if (!z2) {
                    this.localTipChats.add(0, UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser());
                }
            }
            this.localTipDates.clear();
            this.localTipDates.addAll(arrayList3);
            Delegate delegate = this.delegate;
            if (delegate != null) {
                delegate.updateFiltersView(TextUtils.isEmpty(this.currentDataQuery), this.localTipChats, this.localTipDates);
            }
        }
        final View view = null;
        final int childAdapterPosition = -1;
        for (int i8 = 0; i8 < size; i8++) {
            View childAt = this.recyclerListView.getChildAt(i8);
            if (childAt instanceof FlickerLoadingView) {
                childAdapterPosition = this.recyclerListView.getChildAdapterPosition(childAt);
                view = childAt;
            }
        }
        if (view != null) {
            this.recyclerListView.removeView(view);
        }
        if ((this.loadingView.getVisibility() == 0 && this.recyclerListView.getChildCount() == 0) || (this.recyclerListView.getAdapter() != this.sharedPhotoVideoAdapter && view != null)) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.FilteredSearchView.7
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FilteredSearchView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    int childCount = FilteredSearchView.this.recyclerListView.getChildCount();
                    AnimatorSet animatorSet = new AnimatorSet();
                    for (int i9 = 0; i9 < childCount; i9++) {
                        View childAt2 = FilteredSearchView.this.recyclerListView.getChildAt(i9);
                        if (view == null || FilteredSearchView.this.recyclerListView.getChildAdapterPosition(childAt2) >= childAdapterPosition) {
                            childAt2.setAlpha(0.0f);
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                            objectAnimatorOfFloat.setStartDelay((int) ((Math.min(FilteredSearchView.this.recyclerListView.getMeasuredHeight(), Math.max(0, childAt2.getTop())) / FilteredSearchView.this.recyclerListView.getMeasuredHeight()) * 100.0f));
                            objectAnimatorOfFloat.setDuration(200L);
                            animatorSet.playTogether(objectAnimatorOfFloat);
                        }
                    }
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.FilteredSearchView.7.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            NotificationCenter.getInstance(i2).onAnimationFinish(FilteredSearchView.this.animationIndex);
                        }
                    });
                    FilteredSearchView.this.animationIndex = NotificationCenter.getInstance(i2).setAnimationInProgress(FilteredSearchView.this.animationIndex, null);
                    animatorSet.start();
                    View view2 = view;
                    if (view2 != null && view2.getParent() == null) {
                        FilteredSearchView.this.recyclerListView.addView(view);
                        final RecyclerView.LayoutManager layoutManager = FilteredSearchView.this.recyclerListView.getLayoutManager();
                        if (layoutManager != null) {
                            layoutManager.ignoreView(view);
                            View view3 = view;
                            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view3, (Property<View, Float>) View.ALPHA, view3.getAlpha(), 0.0f);
                            objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.FilteredSearchView.7.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    view.setAlpha(1.0f);
                                    layoutManager.stopIgnoringView(view);
                                    AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                    FilteredSearchView.this.recyclerListView.removeView(view);
                                }
                            });
                            objectAnimatorOfFloat2.start();
                        }
                    }
                    return true;
                }
            });
        }
        this.adapter.notifyDataSetChanged();
    }

    public void update() {
        RecyclerView.Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void setKeyboardHeight(int i, boolean z) {
        this.emptyView.setKeyboardHeight(i, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void messagesDeleted(int r12, java.util.ArrayList<java.lang.Long> r13) {
        /*
            r11 = this;
            r0 = 0
            r1 = 0
            r2 = 0
        L3:
            java.util.ArrayList<org.rbmain.messenger.MessageObject> r3 = r11.messages
            int r3 = r3.size()
            if (r1 >= r3) goto L81
            java.util.ArrayList<org.rbmain.messenger.MessageObject> r3 = r11.messages
            java.lang.Object r3 = r3.get(r1)
            org.rbmain.messenger.MessageObject r3 = (org.rbmain.messenger.MessageObject) r3
            long r4 = r3.getDialogId()
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L28
            long r4 = -r4
            int r5 = (int) r4
            int r4 = org.rbmain.messenger.UserConfig.selectedAccount
            boolean r4 = org.rbmain.messenger.ChatObject.isChannel(r5, r4)
            if (r4 == 0) goto L28
            goto L29
        L28:
            r5 = 0
        L29:
            r4 = 1
            if (r5 != r12) goto L7f
            r5 = 0
        L2d:
            int r6 = r13.size()
            if (r5 >= r6) goto L7f
            long r6 = r3.getId()
            java.lang.Object r8 = r13.get(r5)
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 != 0) goto L7c
            java.util.ArrayList<org.rbmain.messenger.MessageObject> r2 = r11.messages
            r2.remove(r1)
            androidx.collection.LongSparseArray<org.rbmain.messenger.MessageObject> r2 = r11.messagesById
            long r6 = r3.getId()
            r2.remove(r6)
            java.util.HashMap<java.lang.String, java.util.ArrayList<org.rbmain.messenger.MessageObject>> r2 = r11.sectionArrays
            java.lang.String r6 = r3.monthKey
            java.lang.Object r2 = r2.get(r6)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r2.remove(r3)
            int r2 = r2.size()
            if (r2 != 0) goto L74
            java.util.ArrayList<java.lang.String> r2 = r11.sections
            java.lang.String r6 = r3.monthKey
            r2.remove(r6)
            java.util.HashMap<java.lang.String, java.util.ArrayList<org.rbmain.messenger.MessageObject>> r2 = r11.sectionArrays
            java.lang.String r6 = r3.monthKey
            r2.remove(r6)
        L74:
            int r1 = r1 + (-1)
            int r2 = r11.totalCount
            int r2 = r2 - r4
            r11.totalCount = r2
            r2 = 1
        L7c:
            int r5 = r5 + 1
            goto L2d
        L7f:
            int r1 = r1 + r4
            goto L3
        L81:
            if (r2 == 0) goto L8a
            androidx.recyclerview.widget.RecyclerView$Adapter r12 = r11.adapter
            if (r12 == 0) goto L8a
            r12.notifyDataSetChanged()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.FilteredSearchView.messagesDeleted(int, java.util.ArrayList):void");
    }

    private class SharedPhotoVideoAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        public SharedPhotoVideoAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (FilteredSearchView.this.messages.isEmpty()) {
                return 0;
            }
            return ((int) Math.ceil(FilteredSearchView.this.messages.size() / FilteredSearchView.this.columnsCount)) + (!FilteredSearchView.this.endReached ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout frameLayout;
            if (i == 0) {
                SharedPhotoVideoCell sharedPhotoVideoCell = new SharedPhotoVideoCell(this.mContext, 1);
                sharedPhotoVideoCell.setDelegate(new SharedPhotoVideoCell.SharedPhotoVideoCellDelegate() { // from class: org.rbmain.ui.FilteredSearchView.SharedPhotoVideoAdapter.1
                    @Override // org.rbmain.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public void didClickItem(SharedPhotoVideoCell sharedPhotoVideoCell2, int i2, MessageObject messageObject, int i3) {
                        FilteredSearchView.this.onItemClick(i2, sharedPhotoVideoCell2, messageObject, i3);
                    }

                    @Override // org.rbmain.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public boolean didLongClickItem(SharedPhotoVideoCell sharedPhotoVideoCell2, int i2, MessageObject messageObject, int i3) {
                        if (!FilteredSearchView.this.uiCallback.actionModeShowing()) {
                            return FilteredSearchView.this.onItemLongClick(messageObject, sharedPhotoVideoCell2, i3);
                        }
                        didClickItem(sharedPhotoVideoCell2, i2, messageObject, i3);
                        return true;
                    }
                });
                frameLayout = sharedPhotoVideoCell;
            } else if (i == 2) {
                FrameLayout graySectionCell = new GraySectionCell(this.mContext);
                graySectionCell.setBackgroundColor(Theme.getColor(Theme.key_graySection) & (-218103809));
                frameLayout = graySectionCell;
            } else {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext) { // from class: org.rbmain.ui.FilteredSearchView.SharedPhotoVideoAdapter.2
                    @Override // org.rbmain.ui.Components.FlickerLoadingView
                    public int getColumnsCount() {
                        return FilteredSearchView.this.columnsCount;
                    }
                };
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.setViewType(2);
                frameLayout = flickerLoadingView;
            }
            frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(frameLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                FilteredSearchView filteredSearchView = FilteredSearchView.this;
                ArrayList<MessageObject> arrayList = filteredSearchView.messages;
                SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) viewHolder.itemView;
                sharedPhotoVideoCell.setItemsCount(filteredSearchView.columnsCount);
                sharedPhotoVideoCell.setIsFirst(i == 0);
                for (int i2 = 0; i2 < FilteredSearchView.this.columnsCount; i2++) {
                    int i3 = (FilteredSearchView.this.columnsCount * i) + i2;
                    if (i3 < arrayList.size()) {
                        MessageObject messageObject = arrayList.get(i3);
                        sharedPhotoVideoCell.setItem(i2, FilteredSearchView.this.messages.indexOf(messageObject), messageObject);
                        if (FilteredSearchView.this.uiCallback.actionModeShowing()) {
                            FilteredSearchView.this.messageHashIdTmp.set(messageObject.getId(), messageObject.getDialogId());
                            sharedPhotoVideoCell.setChecked(i2, FilteredSearchView.this.uiCallback.isSelected(FilteredSearchView.this.messageHashIdTmp), true);
                        } else {
                            sharedPhotoVideoCell.setChecked(i2, false, true);
                        }
                    } else {
                        sharedPhotoVideoCell.setItem(i2, i3, null);
                    }
                }
                sharedPhotoVideoCell.requestLayout();
                return;
            }
            if (viewHolder.getItemViewType() == 3) {
                DialogCell dialogCell = (DialogCell) viewHolder.itemView;
                dialogCell.useSeparator = i != getItemCount() - 1;
                MessageObject messageObject2 = FilteredSearchView.this.messages.get(i);
                boolean z = dialogCell.getMessage() != null && dialogCell.getMessage().getId() == messageObject2.getId();
                dialogCell.setDialog(messageObject2.getDialogId(), messageObject2, messageObject2.messageOwner.date, false);
                if (FilteredSearchView.this.uiCallback.actionModeShowing()) {
                    FilteredSearchView.this.messageHashIdTmp.set(messageObject2.getId(), messageObject2.getDialogId());
                    dialogCell.setChecked(FilteredSearchView.this.uiCallback.isSelected(FilteredSearchView.this.messageHashIdTmp), z);
                    return;
                } else {
                    dialogCell.setChecked(false, z);
                    return;
                }
            }
            if (viewHolder.getItemViewType() == 1) {
                ((FlickerLoadingView) viewHolder.itemView).skipDrawItemsCount(FilteredSearchView.this.columnsCount - ((FilteredSearchView.this.columnsCount * ((int) Math.ceil(FilteredSearchView.this.messages.size() / FilteredSearchView.this.columnsCount))) - FilteredSearchView.this.messages.size()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i < ((int) Math.ceil((double) (((float) FilteredSearchView.this.messages.size()) / ((float) FilteredSearchView.this.columnsCount)))) ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int i, View view, MessageObject messageObject, int i2) {
        if (messageObject == null) {
            return;
        }
        if (this.uiCallback.actionModeShowing()) {
            this.uiCallback.toggleItemSelection(messageObject, view, i2);
            return;
        }
        boolean z = view instanceof DialogCell;
        if (z) {
            this.uiCallback.goToMessage(messageObject);
            return;
        }
        int i3 = this.currentSearchFilter.filterType;
        if (i3 == 0) {
            if (z) {
                this.uiCallback.goToMessage(((DialogCell) view).getMessage());
                return;
            }
            PhotoViewer.getInstance().setParentActivity(this.parentActivity);
            PhotoViewer.getInstance().openPhoto(this.messages, i, 0L, 0L, this.provider);
            this.photoViewerClassGuid = PhotoViewer.getInstance().getClassGuid();
            return;
        }
        if (i3 == 3 || i3 == 5) {
            if (view instanceof SharedAudioCell) {
                ((SharedAudioCell) view).didPressedButton();
                return;
            }
            return;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                try {
                    TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                    String link = null;
                    TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia != null ? tLRPC$MessageMedia.webpage : null;
                    if (tLRPC$WebPage != null && !(tLRPC$WebPage instanceof TLRPC$TL_webPageEmpty)) {
                        if (tLRPC$WebPage.cached_page != null) {
                            ArticleViewer.getInstance().setParentActivity(this.parentActivity, this.parentFragment);
                            ArticleViewer.getInstance().open(messageObject);
                            return;
                        }
                        String str = tLRPC$WebPage.embed_url;
                        if (str != null && str.length() != 0) {
                            openWebView(tLRPC$WebPage);
                            return;
                        }
                        link = tLRPC$WebPage.url;
                    }
                    if (link == null) {
                        link = ((SharedLinkCell) view).getLink(0);
                    }
                    if (link != null) {
                        openUrl(link);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    FileLog.e(e);
                    return;
                }
            }
            return;
        }
        if (view instanceof SharedDocumentCell) {
            SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) view;
            TLRPC$Document document = messageObject.getDocument();
            if (sharedDocumentCell.isLoaded()) {
                if (messageObject.canPreviewDocument()) {
                    PhotoViewer.getInstance().setParentActivity(this.parentActivity);
                    int iIndexOf = this.messages.indexOf(messageObject);
                    if (iIndexOf < 0) {
                        ArrayList<MessageObject> arrayList = new ArrayList<>();
                        arrayList.add(messageObject);
                        PhotoViewer.getInstance().setParentActivity(this.parentActivity);
                        PhotoViewer.getInstance().openPhoto(arrayList, 0, 0L, 0L, this.provider);
                        this.photoViewerClassGuid = PhotoViewer.getInstance().getClassGuid();
                        return;
                    }
                    PhotoViewer.getInstance().setParentActivity(this.parentActivity);
                    PhotoViewer.getInstance().openPhoto(this.messages, iIndexOf, 0L, 0L, this.provider);
                    this.photoViewerClassGuid = PhotoViewer.getInstance().getClassGuid();
                    return;
                }
                AndroidUtilities.openDocument(messageObject, this.parentActivity, this.parentFragment);
                return;
            }
            if (!sharedDocumentCell.isLoading()) {
                AccountInstance.getInstance(UserConfig.selectedAccount).getFileLoader().loadFile(document, sharedDocumentCell.getMessage(), 0, 0);
                sharedDocumentCell.updateFileExistIcon(true);
            } else {
                AccountInstance.getInstance(UserConfig.selectedAccount).getFileLoader().cancelLoadFile(document);
                sharedDocumentCell.updateFileExistIcon(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SharedLinksAdapter extends RecyclerListView.SectionsAdapter {
        private Context mContext;
        private final SharedLinkCell.SharedLinkCellDelegate sharedLinkCellDelegate = new AnonymousClass1();

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int i, int i2) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            return true;
        }

        /* renamed from: org.rbmain.ui.FilteredSearchView$SharedLinksAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements SharedLinkCell.SharedLinkCellDelegate {
            AnonymousClass1() {
            }

            @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
            public void needOpenWebView(TLRPC$WebPage tLRPC$WebPage) {
                FilteredSearchView.this.openWebView(tLRPC$WebPage);
            }

            @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
            public boolean canPerformActions() {
                return !FilteredSearchView.this.uiCallback.actionModeShowing();
            }

            @Override // org.rbmain.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
            public void onLinkPress(final String str, boolean z) {
                if (!z) {
                    FilteredSearchView.this.openUrl(str);
                    return;
                }
                BottomSheet.Builder builder = new BottomSheet.Builder(FilteredSearchView.this.parentActivity);
                builder.setTitle(str);
                builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.FilteredSearchView$SharedLinksAdapter$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onLinkPress$0(str, dialogInterface, i);
                    }
                });
                FilteredSearchView.this.parentFragment.showDialog(builder.create());
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onLinkPress$0(String str, DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    FilteredSearchView.this.openUrl(str);
                    return;
                }
                if (i == 1) {
                    if (str.startsWith("mailto:")) {
                        str = str.substring(7);
                    } else if (str.startsWith("tel:")) {
                        str = str.substring(4);
                    }
                    AndroidUtilities.addToClipboard(str);
                }
            }
        }

        public SharedLinksAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            int i = 0;
            if (FilteredSearchView.this.messages.isEmpty()) {
                return 0;
            }
            if (FilteredSearchView.this.sections.isEmpty() && FilteredSearchView.this.isLoading) {
                return 0;
            }
            int size = FilteredSearchView.this.sections.size();
            if (!FilteredSearchView.this.sections.isEmpty() && !FilteredSearchView.this.endReached) {
                i = 1;
            }
            return size + i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if (i >= FilteredSearchView.this.sections.size()) {
                return 1;
            }
            FilteredSearchView filteredSearchView = FilteredSearchView.this;
            return filteredSearchView.sectionArrays.get(filteredSearchView.sections.get(i)).size() + (i == 0 ? 0 : 1);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor(Theme.key_graySection) & (-218103809));
            }
            if (i == 0) {
                view.setAlpha(0.0f);
                return view;
            }
            if (i < FilteredSearchView.this.sections.size()) {
                view.setAlpha(1.0f);
                ((GraySectionCell) view).setText(LocaleController.formatSectionDate(FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(i)).get(0).messageOwner.date));
            }
            return view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            GraySectionCell graySectionCell;
            if (i == 0) {
                graySectionCell = new GraySectionCell(this.mContext);
            } else if (i == 1) {
                SharedLinkCell sharedLinkCell = new SharedLinkCell(this.mContext, 1);
                sharedLinkCell.setDelegate(this.sharedLinkCellDelegate);
                graySectionCell = sharedLinkCell;
            } else {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                flickerLoadingView.setViewType(5);
                flickerLoadingView.setIsSingleCell(true);
                graySectionCell = flickerLoadingView;
            }
            graySectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() != 2) {
                ArrayList<MessageObject> arrayList = FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(i));
                int itemViewType = viewHolder.getItemViewType();
                boolean z = false;
                if (itemViewType == 0) {
                    ((GraySectionCell) viewHolder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                    return;
                }
                if (itemViewType != 1) {
                    return;
                }
                if (i != 0) {
                    i2--;
                }
                final SharedLinkCell sharedLinkCell = (SharedLinkCell) viewHolder.itemView;
                final MessageObject messageObject = arrayList.get(i2);
                final boolean z2 = sharedLinkCell.getMessage() != null && sharedLinkCell.getMessage().getId() == messageObject.getId();
                if (i2 != arrayList.size() - 1 || (i == FilteredSearchView.this.sections.size() - 1 && FilteredSearchView.this.isLoading)) {
                    z = true;
                }
                sharedLinkCell.setLink(messageObject, z);
                sharedLinkCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.FilteredSearchView.SharedLinksAdapter.2
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        sharedLinkCell.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (FilteredSearchView.this.uiCallback.actionModeShowing()) {
                            FilteredSearchView.this.messageHashIdTmp.set(messageObject.getId(), messageObject.getDialogId());
                            sharedLinkCell.setChecked(FilteredSearchView.this.uiCallback.isSelected(FilteredSearchView.this.messageHashIdTmp), z2);
                            return true;
                        }
                        sharedLinkCell.setChecked(false, z2);
                        return true;
                    }
                });
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (i < FilteredSearchView.this.sections.size()) {
                return (i == 0 || i2 != 0) ? 1 : 0;
            }
            return 2;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
    }

    private class SharedDocumentsAdapter extends RecyclerListView.SectionsAdapter {
        private int currentType;
        private Context mContext;

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int i, int i2) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int i) {
            return null;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder, int i, int i2) {
            return i == 0 || i2 != 0;
        }

        public SharedDocumentsAdapter(Context context, int i) {
            this.mContext = context;
            this.currentType = i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getSectionCount() {
            int i = 0;
            if (FilteredSearchView.this.sections.isEmpty()) {
                return 0;
            }
            int size = FilteredSearchView.this.sections.size();
            if (!FilteredSearchView.this.sections.isEmpty() && !FilteredSearchView.this.endReached) {
                i = 1;
            }
            return size + i;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int i) {
            if (i >= FilteredSearchView.this.sections.size()) {
                return 1;
            }
            FilteredSearchView filteredSearchView = FilteredSearchView.this;
            return filteredSearchView.sectionArrays.get(filteredSearchView.sections.get(i)).size() + (i == 0 ? 0 : 1);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int i, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor(Theme.key_graySection) & (-218103809));
            }
            if (i == 0) {
                view.setAlpha(0.0f);
                return view;
            }
            if (i < FilteredSearchView.this.sections.size()) {
                view.setAlpha(1.0f);
                ((GraySectionCell) view).setText(LocaleController.formatSectionDate(FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(i)).get(0).messageOwner.date));
            }
            return view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View graySectionCell;
            SharedDocumentCell sharedDocumentCell;
            if (i != 0) {
                int i2 = 1;
                if (i == 1) {
                    sharedDocumentCell = new SharedDocumentCell(this.mContext, 2);
                } else if (i == 2) {
                    FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext);
                    int i3 = this.currentType;
                    if (i3 == 2 || i3 == 4) {
                        flickerLoadingView.setViewType(4);
                    } else {
                        flickerLoadingView.setViewType(3);
                    }
                    flickerLoadingView.setIsSingleCell(true);
                    sharedDocumentCell = flickerLoadingView;
                } else {
                    graySectionCell = new SharedAudioCell(this.mContext, i2) { // from class: org.rbmain.ui.FilteredSearchView.SharedDocumentsAdapter.1
                        @Override // org.rbmain.ui.Cells.SharedAudioCell
                        public boolean needPlayMessage(MessageObject messageObject) {
                            if (messageObject.isVoice() || messageObject.isRoundVideo()) {
                                boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject);
                                MediaController.getInstance().setVoiceMessagesPlaylist(zPlayMessage ? FilteredSearchView.this.messages : null, false);
                                return zPlayMessage;
                            }
                            if (!messageObject.isMusic()) {
                                return false;
                            }
                            String str = FilteredSearchView.this.currentDataQuery;
                            FilteredSearchView filteredSearchView = FilteredSearchView.this;
                            int i4 = filteredSearchView.currentSearchDialogId;
                            long j = filteredSearchView.currentSearchMinDate;
                            MediaController.PlaylistGlobalSearchParams playlistGlobalSearchParams = new MediaController.PlaylistGlobalSearchParams(str, i4, j, j, filteredSearchView.currentSearchFilter);
                            playlistGlobalSearchParams.endReached = FilteredSearchView.this.endReached;
                            playlistGlobalSearchParams.nextSearchRate = FilteredSearchView.this.nextSearchRate;
                            playlistGlobalSearchParams.totalCount = FilteredSearchView.this.totalCount;
                            playlistGlobalSearchParams.folderId = FilteredSearchView.this.uiCallback.getFolderId();
                            return MediaController.getInstance().setPlaylist(FilteredSearchView.this.messages, messageObject, 0L, playlistGlobalSearchParams);
                        }
                    };
                }
                graySectionCell = sharedDocumentCell;
            } else {
                graySectionCell = new GraySectionCell(this.mContext);
            }
            graySectionCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(graySectionCell);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int i, int i2, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() != 2) {
                ArrayList<MessageObject> arrayList = FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(i));
                int itemViewType = viewHolder.getItemViewType();
                boolean z = false;
                if (itemViewType == 0) {
                    ((GraySectionCell) viewHolder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                    return;
                }
                if (itemViewType == 1) {
                    if (i != 0) {
                        i2--;
                    }
                    final SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) viewHolder.itemView;
                    final MessageObject messageObject = arrayList.get(i2);
                    final boolean z2 = sharedDocumentCell.getMessage() != null && sharedDocumentCell.getMessage().getId() == messageObject.getId();
                    if (i2 != arrayList.size() - 1 || (i == FilteredSearchView.this.sections.size() - 1 && FilteredSearchView.this.isLoading)) {
                        z = true;
                    }
                    sharedDocumentCell.setDocument(messageObject, z);
                    sharedDocumentCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.FilteredSearchView.SharedDocumentsAdapter.2
                        @Override // android.view.ViewTreeObserver.OnPreDrawListener
                        public boolean onPreDraw() {
                            sharedDocumentCell.getViewTreeObserver().removeOnPreDrawListener(this);
                            if (FilteredSearchView.this.uiCallback.actionModeShowing()) {
                                FilteredSearchView.this.messageHashIdTmp.set(messageObject.getId(), messageObject.getDialogId());
                                sharedDocumentCell.setChecked(FilteredSearchView.this.uiCallback.isSelected(FilteredSearchView.this.messageHashIdTmp), z2);
                                return true;
                            }
                            sharedDocumentCell.setChecked(false, z2);
                            return true;
                        }
                    });
                    return;
                }
                if (itemViewType != 3) {
                    return;
                }
                if (i != 0) {
                    i2--;
                }
                final SharedAudioCell sharedAudioCell = (SharedAudioCell) viewHolder.itemView;
                final MessageObject messageObject2 = arrayList.get(i2);
                final boolean z3 = sharedAudioCell.getMessage() != null && sharedAudioCell.getMessage().getId() == messageObject2.getId();
                if (i2 != arrayList.size() - 1 || (i == FilteredSearchView.this.sections.size() - 1 && FilteredSearchView.this.isLoading)) {
                    z = true;
                }
                sharedAudioCell.setMessageObject(messageObject2, z);
                sharedAudioCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.FilteredSearchView.SharedDocumentsAdapter.3
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        sharedAudioCell.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (FilteredSearchView.this.uiCallback.actionModeShowing()) {
                            FilteredSearchView.this.messageHashIdTmp.set(messageObject2.getId(), messageObject2.getDialogId());
                            sharedAudioCell.setChecked(FilteredSearchView.this.uiCallback.isSelected(FilteredSearchView.this.messageHashIdTmp), z3);
                            return true;
                        }
                        sharedAudioCell.setChecked(false, z3);
                        return true;
                    }
                });
            }
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int i, int i2) {
            if (i >= FilteredSearchView.this.sections.size()) {
                return 2;
            }
            if (i != 0 && i2 == 0) {
                return 0;
            }
            int i3 = this.currentType;
            return (i3 == 2 || i3 == 4) ? 3 : 1;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.FastScrollAdapter
        public void getPositionForScrollProgress(RecyclerListView recyclerListView, float f, int[] iArr) {
            iArr[0] = 0;
            iArr[1] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String str) {
        if (AndroidUtilities.shouldShowUrlInAlert(str)) {
            AlertsCreator.showOpenUrlAlert(this.parentFragment, str, true, true);
        } else {
            Browser.openUrl(this.parentActivity, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebView(TLRPC$WebPage tLRPC$WebPage) {
        EmbedBottomSheet.show(this.parentActivity, tLRPC$WebPage.site_name, tLRPC$WebPage.description, tLRPC$WebPage.url, tLRPC$WebPage.embed_url, tLRPC$WebPage.embed_width, tLRPC$WebPage.embed_height, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = UserConfig.selectedAccount;
        this.lastAccount = i;
        NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.emojiDidLoad);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NotificationCenter.getInstance(this.lastAccount).removeObserver(this, NotificationCenter.emojiDidLoad);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.emojiDidLoad) {
            int childCount = this.recyclerListView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (this.recyclerListView.getChildAt(i3) instanceof DialogCell) {
                    ((DialogCell) this.recyclerListView.getChildAt(i3)).update(0);
                }
                this.recyclerListView.getChildAt(i3).invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onItemLongClick(MessageObject messageObject, View view, int i) {
        if (!this.uiCallback.actionModeShowing()) {
            this.uiCallback.showActionMode();
        }
        this.uiCallback.toggleItemSelection(messageObject, view, i);
        return true;
    }

    public static class MessageHashId {
        public long dialogId;
        public long messageId;

        public MessageHashId(long j, long j2) {
            this.dialogId = j2;
            this.messageId = j;
        }

        public void set(long j, long j2) {
            this.dialogId = j2;
            this.messageId = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || MessageHashId.class != obj.getClass()) {
                return false;
            }
            MessageHashId messageHashId = (MessageHashId) obj;
            return this.dialogId == messageHashId.dialogId && this.messageId == messageHashId.messageId;
        }

        public int hashCode() {
            return (int) this.messageId;
        }
    }

    class OnlyUserFiltersAdapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        OnlyUserFiltersAdapter() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            DialogCell dialogCell;
            if (i == 0) {
                dialogCell = new DialogCell(null, viewGroup.getContext(), true, false);
            } else if (i == 3) {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(viewGroup.getContext());
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.setViewType(1);
                dialogCell = flickerLoadingView;
            } else {
                GraySectionCell graySectionCell = new GraySectionCell(viewGroup.getContext());
                graySectionCell.setText(LocaleController.getString("SearchMessages", R.string.SearchMessages));
                dialogCell = graySectionCell;
            }
            dialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(dialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                final DialogCell dialogCell = (DialogCell) viewHolder.itemView;
                final MessageObject messageObject = FilteredSearchView.this.messages.get(i);
                dialogCell.setDialog(messageObject.getDialogId(), messageObject, messageObject.messageOwner.date, false);
                dialogCell.useSeparator = i != getItemCount() - 1;
                final boolean z = dialogCell.getMessage() != null && dialogCell.getMessage().getId() == messageObject.getId();
                dialogCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: org.rbmain.ui.FilteredSearchView.OnlyUserFiltersAdapter.1
                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                    public boolean onPreDraw() {
                        dialogCell.getViewTreeObserver().removeOnPreDrawListener(this);
                        if (FilteredSearchView.this.uiCallback.actionModeShowing()) {
                            FilteredSearchView.this.messageHashIdTmp.set(messageObject.getId(), messageObject.getDialogId());
                            dialogCell.setChecked(FilteredSearchView.this.uiCallback.isSelected(FilteredSearchView.this.messageHashIdTmp), z);
                            return true;
                        }
                        dialogCell.setChecked(false, z);
                        return true;
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i >= FilteredSearchView.this.messages.size() ? 3 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (FilteredSearchView.this.messages.isEmpty()) {
                return 0;
            }
            return FilteredSearchView.this.messages.size() + (!FilteredSearchView.this.endReached ? 1 : 0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        RecyclerView.Adapter adapter;
        int i3 = this.columnsCount;
        if (!AndroidUtilities.isTablet() && getResources().getConfiguration().orientation == 2) {
            this.columnsCount = 6;
        } else {
            this.columnsCount = 3;
        }
        if (i3 != this.columnsCount && (adapter = this.adapter) == this.sharedPhotoVideoAdapter) {
            this.ignoreRequestLayout = true;
            adapter.notifyDataSetChanged();
            this.ignoreRequestLayout = false;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreRequestLayout) {
            return;
        }
        super.requestLayout();
    }

    public void setDelegate(Delegate delegate, boolean z) {
        this.delegate = delegate;
        if (!z || delegate == null || this.localTipChats.isEmpty()) {
            return;
        }
        delegate.updateFiltersView(false, this.localTipChats, this.localTipDates);
    }

    public void setUiCallback(UiCallback uiCallback) {
        this.uiCallback = uiCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFloatingDateView() {
        AndroidUtilities.cancelRunOnUIThread(this.hideFloatingDateRunnable);
        AndroidUtilities.runOnUIThread(this.hideFloatingDateRunnable, 650L);
        if (this.floatingDateView.getTag() != null) {
            return;
        }
        AnimatorSet animatorSet = this.floatingDateAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.floatingDateView.setTag(1);
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.floatingDateAnimation = animatorSet2;
        animatorSet2.setDuration(180L);
        this.floatingDateAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.TRANSLATION_Y, 0.0f));
        this.floatingDateAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
        this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.FilteredSearchView.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                FilteredSearchView.this.floatingDateAnimation = null;
            }
        });
        this.floatingDateAnimation.start();
    }

    private void hideFloatingDateView(boolean z) {
        AndroidUtilities.cancelRunOnUIThread(this.hideFloatingDateRunnable);
        if (this.floatingDateView.getTag() == null) {
            return;
        }
        this.floatingDateView.setTag(null);
        AnimatorSet animatorSet = this.floatingDateAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.floatingDateAnimation = null;
        }
        if (z) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.floatingDateAnimation = animatorSet2;
            animatorSet2.setDuration(180L);
            this.floatingDateAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)));
            this.floatingDateAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.FilteredSearchView.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FilteredSearchView.this.floatingDateAnimation = null;
                }
            });
            this.floatingDateAnimation.start();
            return;
        }
        this.floatingDateView.setAlpha(0.0f);
    }

    public void setChatPreviewDelegate(SearchViewPager.ChatPreviewDelegate chatPreviewDelegate) {
        this.chatPreviewDelegate = chatPreviewDelegate;
    }

    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this, 0, null, null, null, null, Theme.key_dialogBackground));
        arrayList.add(new ThemeDescription(this, 0, null, null, null, null, Theme.key_windowBackgroundGray));
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText3));
        int i4 = Theme.key_sharedMedia_startStopLoadIcon;
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{SharedDocumentCell.class}, new String[]{"progressView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"statusImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        int i5 = Theme.key_checkbox;
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        int i6 = Theme.key_checkboxCheck;
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_folderIcon));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_files_iconText));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_progressCircle));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_titleTextPaint, null, null, i3));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_descriptionTextPaint, null, null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i5));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, new String[]{"titleTextPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, null, null, null, Theme.key_windowBackgroundWhiteLinkText));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, Theme.linkSelectionPaint, null, null, Theme.key_windowBackgroundWhiteLinkSelection));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_sharedMedia_linkPlaceholderText));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_sharedMedia_linkPlaceholder));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, Theme.avatarDrawables, null, Theme.key_avatar_text));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_countPaint, null, null, Theme.key_chats_unreadCounter));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_countGrayPaint, null, null, Theme.key_chats_unreadCounterMuted));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_countTextPaint, null, null, Theme.key_chats_unreadCounterText));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_lockDrawable}, null, Theme.key_chats_secretIcon));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_groupDrawable, Theme.dialogs_broadcastDrawable, Theme.dialogs_botDrawable}, null, Theme.key_chats_nameIcon));
        Drawable[] drawableArr = {Theme.dialogs_scamDrawable, Theme.dialogs_fakeDrawable};
        int i7 = Theme.key_chats_draft;
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, drawableArr, null, i7));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_pinnedDrawable, Theme.dialogs_reorderDrawable}, null, Theme.key_chats_pinnedIcon));
        TextPaint[] textPaintArr = Theme.dialogs_namePaint;
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr[0], textPaintArr[1], Theme.dialogs_searchNamePaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_name));
        TextPaint[] textPaintArr2 = Theme.dialogs_nameEncryptedPaint;
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr2[0], textPaintArr2[1], Theme.dialogs_searchNameEncryptedPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_secretName));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_messagePaint[1], null, null, Theme.key_chats_message_threeLines));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_messagePaint[0], null, null, Theme.key_chats_message));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_messageNamePaint, null, null, Theme.key_chats_nameMessage_threeLines));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, i7));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, (String[]) null, Theme.dialogs_messagePrintingPaint, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_chats_actionMessage));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_timePaint, null, null, Theme.key_chats_date));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_pinnedPaint, null, null, Theme.key_chats_pinnedOverlay));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_tabletSeletedPaint, null, null, Theme.key_chats_tabletSelectedOverlay));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_checkDrawable}, null, Theme.key_chats_sentCheck));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_checkReadDrawable, Theme.dialogs_halfCheckDrawable}, null, Theme.key_chats_sentReadCheck));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_clockDrawable}, null, Theme.key_chats_sentClock));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_errorPaint, null, null, Theme.key_chats_sentError));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_errorDrawable}, null, Theme.key_chats_sentErrorIcon));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedCheckDrawable}, null, Theme.key_chats_verifiedCheck));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedDrawable}, null, Theme.key_chats_verifiedBackground));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_muteDrawable}, null, Theme.key_chats_muteIcon));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_mentionDrawable}, null, Theme.key_chats_mentionIcon));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, Theme.key_chats_archivePinBackground));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, Theme.key_chats_archiveBackground));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, Theme.key_chats_onlineCircle));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{DialogCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i2));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{DialogCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i6));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_graySectionText));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, null, null, null, Theme.key_graySection));
        arrayList.add(new ThemeDescription(this.emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText));
        return arrayList;
    }
}
