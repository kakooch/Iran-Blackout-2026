package ir.eitaa.ui;

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
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Property;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.Log;
import ir.eitaa.SQLite.SQLitePreparedStatement;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$TL_contacts_search;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputMessagesFilterEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messages_search;
import ir.eitaa.tgnet.TLRPC$TL_messages_searchGlobalExt;
import ir.eitaa.tgnet.TLRPC$TL_webPageEmpty;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$WebPage;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Adapters.DialogsSearchAdapter;
import ir.eitaa.ui.Adapters.FiltersView;
import ir.eitaa.ui.Cells.ChatActionCell;
import ir.eitaa.ui.Cells.ChatMessageCell;
import ir.eitaa.ui.Cells.ContextLinkCell;
import ir.eitaa.ui.Cells.DialogCell;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Cells.ProfileSearchCell;
import ir.eitaa.ui.Cells.SharedAudioCell;
import ir.eitaa.ui.Cells.SharedDocumentCell;
import ir.eitaa.ui.Cells.SharedLinkCell;
import ir.eitaa.ui.Cells.SharedMediaSectionCell;
import ir.eitaa.ui.Cells.SharedPhotoVideoCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.ColoredImageSpan;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.EmbedBottomSheet;
import ir.eitaa.ui.Components.FlickerLoadingView;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.SearchViewPager;
import ir.eitaa.ui.Components.StickerEmptyView;
import ir.eitaa.ui.PhotoViewer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes3.dex */
public class FilteredSearchView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private static SpannableStringBuilder arrowSpan;
    public static ArrayList<TLObject> globalSearch = new ArrayList<>();
    public static int searchType = 0;
    RecyclerView.Adapter adapter;
    private int animationIndex;
    private ImageView background;
    private SearchViewPager.ChatPreviewDelegate chatPreviewDelegate;
    Runnable clearCurrentResultsRunnable;
    private int columnsCount;
    private String currentDataQuery;
    boolean currentIncludeFolder;
    long currentSearchDialogId;
    FiltersView.MediaFilterData currentSearchFilter;
    long currentSearchMaxDate;
    long currentSearchMinDate;
    String currentSearchString;
    private Delegate delegate;
    private OnlyUserFiltersAdapter dialogsAdapter;
    StickerEmptyView emptyView;
    private boolean endReached;
    private boolean firstLoading;
    private AnimatorSet floatingDateAnimation;
    private final ChatActionCell floatingDateView;
    private Runnable hideFloatingDateRunnable;
    public GraySectionCell hintCell;
    boolean ignoreRequestLayout;
    private boolean isLoading;
    int lastAccount;
    private String lastFoundUsername;
    String lastMessagesSearchString;
    String lastSearchFilterQueryString;
    public final LinearLayoutManager layoutManager;
    private final FlickerLoadingView loadingView;
    boolean localTipArchive;
    ArrayList<Object> localTipChats;
    ArrayList<FiltersView.DateData> localTipDates;
    private final MessageHashId messageHashIdTmp;
    public ArrayList<MessageObject> messages;
    public SparseArray<MessageObject> messagesById;
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
    private long selfUserId;
    private SharedDocumentsAdapter sharedAudioAdapter;
    private SharedDocumentsAdapter sharedDocumentsAdapter;
    private SharedLinksAdapter sharedLinksAdapter;
    private SharedPhotoVideoAdapter sharedPhotoVideoAdapter;
    private SharedDocumentsAdapter sharedVoiceAdapter;
    private int totalCount;
    private UiCallback uiCallback;

    public interface Delegate {
        void updateFiltersView(boolean showMediaFilters, ArrayList<Object> users, ArrayList<FiltersView.DateData> dates, boolean archive);
    }

    public interface UiCallback {
        boolean actionModeShowing();

        void goToMessage(MessageObject messageObject);

        void goToMessage(ChatActivity chatActivity);

        boolean isSelected(MessageHashId messageHashId);

        void showActionMode();

        void toggleItemSelection(MessageObject item, View view, int a);
    }

    public OnlyUserFiltersAdapter getDialogsAdapter() {
        return this.dialogsAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$FilteredSearchView() {
        hideFloatingDateView(true);
    }

    public FilteredSearchView(BaseFragment fragment) {
        super(fragment.getParentActivity());
        this.lastFoundUsername = null;
        this.messages = new ArrayList<>();
        this.messagesById = new SparseArray<>();
        this.sections = new ArrayList<>();
        this.sectionArrays = new HashMap<>();
        this.columnsCount = 3;
        this.messageHashIdTmp = new MessageHashId(0, 0L);
        this.localTipChats = new ArrayList<>();
        this.localTipDates = new ArrayList<>();
        this.clearCurrentResultsRunnable = new Runnable() { // from class: ir.eitaa.ui.FilteredSearchView.1
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
        this.provider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.FilteredSearchView.2
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public int getTotalImageCount() {
                return FilteredSearchView.this.totalCount;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean loadMore() {
                if (FilteredSearchView.this.endReached) {
                    return true;
                }
                FilteredSearchView filteredSearchView = FilteredSearchView.this;
                filteredSearchView.search(filteredSearchView.currentSearchDialogId, filteredSearchView.currentSearchMinDate, filteredSearchView.currentSearchMaxDate, filteredSearchView.currentSearchFilter, filteredSearchView.currentIncludeFolder, filteredSearchView.lastMessagesSearchString, false);
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ir.eitaa.ui.PhotoViewer.PlaceProviderObject getPlaceForPhoto(ir.eitaa.messenger.MessageObject r10, ir.eitaa.tgnet.TLRPC$FileLocation r11, int r12, boolean r13) {
                /*
                    Method dump skipped, instructions count: 273
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.FilteredSearchView.AnonymousClass2.getPlaceForPhoto(ir.eitaa.messenger.MessageObject, ir.eitaa.tgnet.TLRPC$FileLocation, int, boolean):ir.eitaa.ui.PhotoViewer$PlaceProviderObject");
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public CharSequence getTitleFor(int i) {
                return FilteredSearchView.createFromInfoString(FilteredSearchView.this.messages.get(i));
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public CharSequence getSubtitleFor(int i) {
                return LocaleController.formatDateAudio(FilteredSearchView.this.messages.get(i).messageOwner.date, false);
            }
        };
        this.firstLoading = true;
        this.animationIndex = -1;
        this.hideFloatingDateRunnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$QvLS0RgBg5s8dyxxw6ksLuMPFsk
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$FilteredSearchView();
            }
        };
        this.parentFragment = fragment;
        Activity parentActivity = fragment.getParentActivity();
        this.parentActivity = parentActivity;
        setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.selfUserId = UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
        RecyclerListView recyclerListView = new RecyclerListView(parentActivity) { // from class: ir.eitaa.ui.FilteredSearchView.3
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
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
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                ChatMessageCell chatMessageCell;
                ImageReceiver avatarImage;
                View view;
                RecyclerView.ViewHolder childViewHolder;
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if (getAdapter() == FilteredSearchView.this.sharedPhotoVideoAdapter && getChildViewHolder(child).getItemViewType() == 1) {
                    return true;
                }
                if ((child instanceof ChatMessageCell) && (avatarImage = (chatMessageCell = (ChatMessageCell) child).getAvatarImage()) != null) {
                    int top = child.getTop();
                    if (chatMessageCell.isPinnedBottom() && (childViewHolder = FilteredSearchView.this.recyclerListView.getChildViewHolder(child)) != null && FilteredSearchView.this.recyclerListView.findViewHolderForAdapterPosition(childViewHolder.getAdapterPosition() + 1) != null) {
                        avatarImage.setImageY(-AndroidUtilities.dp(1000.0f));
                        avatarImage.draw(canvas);
                        return zDrawChild;
                    }
                    if (chatMessageCell.isPinnedTop() && (childViewHolder = FilteredSearchView.this.recyclerListView.getChildViewHolder(child)) != null) {
                        do {
                            RecyclerView.ViewHolder childViewHolder2 = FilteredSearchView.this.recyclerListView.findViewHolderForAdapterPosition(childViewHolder2.getAdapterPosition() - 1);
                            if (childViewHolder2 == null) {
                                break;
                            }
                            top = childViewHolder2.itemView.getTop();
                            view = childViewHolder2.itemView;
                            if (!(view instanceof ChatMessageCell)) {
                                break;
                            }
                        } while (((ChatMessageCell) view).isPinnedTop());
                    }
                    int y = (int) (child.getY() + chatMessageCell.getLayoutHeight() + chatMessageCell.getTransitionParams().deltaBottom);
                    int measuredHeight = FilteredSearchView.this.recyclerListView.getMeasuredHeight() - FilteredSearchView.this.recyclerListView.getPaddingBottom();
                    Log.i("avatar", "child.getTop() = " + top);
                    Log.i("avatar", "chatMessageCell.getLayoutHeight() = " + chatMessageCell.getLayoutHeight());
                    Log.i("avatar", "recyclerListView.getHeight() = " + FilteredSearchView.this.recyclerListView.getHeight());
                    Log.i("avatar", "recyclerListView.getPaddingBottom() = " + FilteredSearchView.this.recyclerListView.getPaddingBottom());
                    Log.i("avatar", "y = " + y);
                    Log.i("avatar", "maxY = " + measuredHeight);
                    if (y > measuredHeight) {
                        Log.i("avatar", "y = maxY");
                        y = measuredHeight;
                    }
                    if (y - AndroidUtilities.dp(48.0f) < top) {
                        y = AndroidUtilities.dp(48.0f) + top;
                        Log.i("avatar", "y = top + AndroidUtilites.dp(48) " + y);
                    }
                    avatarImage.setImageY(y - AndroidUtilities.dp(48.0f));
                    Log.i("avatar", "setImageY = " + (y - AndroidUtilities.dp(48.0f)));
                    Log.i("avatar", "cell id = " + chatMessageCell.getMessageObject().messageOwner.id);
                    Log.i("avatar", "///////////////////////////////////////////////////////////////");
                    avatarImage.draw(canvas);
                }
                return zDrawChild;
            }
        };
        this.recyclerListView = recyclerListView;
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$xJvRbCoiGrivdcsfYXlHuYgneY0
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) throws Resources.NotFoundException {
                this.f$0.lambda$new$1$FilteredSearchView(view, i);
            }
        });
        this.recyclerListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListenerExtended() { // from class: ir.eitaa.ui.FilteredSearchView.4
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public boolean onItemClick(View view, int position, float x, float y) {
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
                        if (dialogCell.isPointInsideAvatar(x, y)) {
                            FilteredSearchView.this.chatPreviewDelegate.startChatPreview(dialogCell);
                            return true;
                        }
                    }
                    FilteredSearchView.this.onItemLongClick(((DialogCell) view).getMessage(), view, 0);
                }
                return true;
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public void onMove(float dx, float dy) {
                FilteredSearchView.this.chatPreviewDelegate.move(dy);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListenerExtended
            public void onLongClickRelease() {
                FilteredSearchView.this.chatPreviewDelegate.finish();
            }
        });
        this.recyclerListView.setPadding(0, 0, 0, AndroidUtilities.dp(3.0f));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(parentActivity);
        this.layoutManager = linearLayoutManager;
        this.recyclerListView.setLayoutManager(linearLayoutManager);
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(parentActivity) { // from class: ir.eitaa.ui.FilteredSearchView.5
            @Override // ir.eitaa.ui.Components.FlickerLoadingView
            public int getColumnsCount() {
                return FilteredSearchView.this.columnsCount;
            }
        };
        this.loadingView = flickerLoadingView;
        addView(flickerLoadingView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 20.0f, 0.0f, 0.0f));
        ImageView imageView = new ImageView(parentActivity);
        this.background = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.background.setVisibility(8);
        addView(this.background, LayoutHelper.createFrame(-1, -1.0f));
        GraySectionCell graySectionCell = new GraySectionCell(getContext());
        this.hintCell = graySectionCell;
        addView(graySectionCell, LayoutHelper.createFrame(-1, 20.0f, 48, 0.0f, 0.0f, 0.0f, 0.0f));
        addView(this.recyclerListView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 20.0f, 0.0f, 0.0f));
        this.recyclerListView.setSectionsType(2);
        this.recyclerListView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.FilteredSearchView.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == 1) {
                    AndroidUtilities.hideKeyboard(FilteredSearchView.this.parentActivity.getCurrentFocus());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
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
                        filteredSearchView2.search(filteredSearchView2.currentSearchDialogId, filteredSearchView2.currentSearchMinDate, filteredSearchView2.currentSearchMaxDate, filteredSearchView2.currentSearchFilter, filteredSearchView2.currentIncludeFolder, filteredSearchView2.lastMessagesSearchString, false);
                    }
                    FilteredSearchView filteredSearchView3 = FilteredSearchView.this;
                    if (filteredSearchView3.adapter != filteredSearchView3.sharedPhotoVideoAdapter) {
                        FilteredSearchView filteredSearchView4 = FilteredSearchView.this;
                        if (filteredSearchView4.adapter != filteredSearchView4.dialogsAdapter) {
                            return;
                        }
                    }
                    if (dy != 0 && !FilteredSearchView.this.messages.isEmpty()) {
                        FilteredSearchView.this.showFloatingDateView();
                    }
                    RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition);
                    if (viewHolderFindViewHolderForAdapterPosition == null || viewHolderFindViewHolderForAdapterPosition.getItemViewType() != 4) {
                        return;
                    }
                    View view = viewHolderFindViewHolderForAdapterPosition.itemView;
                    if (!(view instanceof ChatMessageCell) || (messageObject = ((ChatMessageCell) view).getMessageObject()) == null) {
                        return;
                    }
                    FilteredSearchView.this.floatingDateView.setCustomDate(messageObject.messageOwner.date, false, true);
                }
            }
        });
        ChatActionCell chatActionCell = new ChatActionCell(parentActivity);
        this.floatingDateView = chatActionCell;
        chatActionCell.setCustomDate((int) (System.currentTimeMillis() / 1000), false, false);
        chatActionCell.setAlpha(0.0f);
        chatActionCell.setOverrideColor("chat_mediaTimeBackground", "chat_mediaTimeText");
        chatActionCell.setTranslationY(-AndroidUtilities.dp(48.0f));
        addView(chatActionCell, LayoutHelper.createFrame(-2, -2.0f, 49, 0.0f, 4.0f, 0.0f, 0.0f));
        if (this.dialogsAdapter == null) {
            this.dialogsAdapter = new OnlyUserFiltersAdapter();
        }
        this.sharedPhotoVideoAdapter = new SharedPhotoVideoAdapter(getContext());
        this.sharedDocumentsAdapter = new SharedDocumentsAdapter(getContext(), 1);
        this.sharedLinksAdapter = new SharedLinksAdapter(getContext());
        this.sharedAudioAdapter = new SharedDocumentsAdapter(getContext(), 4);
        this.sharedVoiceAdapter = new SharedDocumentsAdapter(getContext(), 2);
        StickerEmptyView stickerEmptyView = new StickerEmptyView(parentActivity, flickerLoadingView, 1);
        this.emptyView = stickerEmptyView;
        addView(stickerEmptyView, LayoutHelper.createFrame(-1, -1.0f, 17, 0.0f, 32.0f, 0.0f, 32.0f));
        this.recyclerListView.setEmptyView(this.emptyView);
        this.emptyView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$FilteredSearchView(View view, int i) throws Resources.NotFoundException {
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
            return;
        }
        if (view instanceof ContextLinkCell) {
            onItemClick(i, view, ((ContextLinkCell) view).getMessageObject(), 0);
            return;
        }
        if (view instanceof DialogCell) {
            onItemClick(i, view, ((DialogCell) view).getMessage(), 0);
            return;
        }
        if (view instanceof ProfileSearchCell) {
            ProfileSearchCell profileSearchCell = (ProfileSearchCell) view;
            TLRPC$User user = profileSearchCell.getUser();
            TLRPC$Chat chat = profileSearchCell.getChat();
            Bundle bundle = new Bundle();
            if (user != null) {
                bundle.putLong("user_id", user.id);
                putRecentSearch(user.id, user);
            } else if (chat != null) {
                bundle.putLong("chat_id", chat.id);
                putRecentSearch(-chat.id, chat);
            }
            if (AccountInstance.getInstance(UserConfig.selectedAccount).getMessagesController().checkCanOpenChat(bundle, this.parentFragment)) {
                this.uiCallback.goToMessage(new ChatActivity(bundle));
                return;
            }
            return;
        }
        if (view instanceof ChatMessageCell) {
            ChatMessageCell chatMessageCell = (ChatMessageCell) view;
            Bundle bundle2 = new Bundle();
            if (chatMessageCell.getMessageObject().isFromUser()) {
                bundle2.putLong("user_id", chatMessageCell.getMessageObject().getDialogId());
            } else {
                bundle2.putLong("chat_id", chatMessageCell.getMessageObject().getChatId());
            }
            bundle2.putInt("message_id", chatMessageCell.getMessageObject().messageOwner.id);
            this.parentFragment.presentFragment(new ChatActivity(bundle2));
        }
    }

    public void putRecentSearch(final long did, TLObject object) {
        DialogsSearchAdapter.RecentSearchObject recentSearchObject = DialogsSearchAdapter.recentSearchObjectsById.get(did);
        if (recentSearchObject == null) {
            recentSearchObject = new DialogsSearchAdapter.RecentSearchObject();
            DialogsSearchAdapter.recentSearchObjectsById.put(did, recentSearchObject);
        } else {
            DialogsSearchAdapter.recentSearchObjects.remove(recentSearchObject);
        }
        DialogsSearchAdapter.recentSearchObjects.add(0, recentSearchObject);
        recentSearchObject.did = did;
        recentSearchObject.object = object;
        recentSearchObject.date = (int) (System.currentTimeMillis() / 1000);
        MessagesStorage.getInstance(UserConfig.selectedAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$23Rv8ZMznXHtWs2K7JBvuU4rtXU
            @Override // java.lang.Runnable
            public final void run() {
                FilteredSearchView.lambda$putRecentSearch$2(did);
            }
        });
    }

    static /* synthetic */ void lambda$putRecentSearch$2(long j) {
        try {
            SQLitePreparedStatement sQLitePreparedStatementExecuteFast = MessagesStorage.getInstance(UserConfig.selectedAccount).getDatabase().executeFast("REPLACE INTO search_recent VALUES(?, ?)");
            sQLitePreparedStatementExecuteFast.requery();
            sQLitePreparedStatementExecuteFast.bindLong(1, j);
            sQLitePreparedStatementExecuteFast.bindInteger(2, (int) (System.currentTimeMillis() / 1000));
            sQLitePreparedStatementExecuteFast.step();
            sQLitePreparedStatementExecuteFast.dispose();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.text.SpannableStringBuilder] */
    public static CharSequence createFromInfoString(MessageObject messageObject) {
        if (arrowSpan == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-");
            arrowSpan = spannableStringBuilder;
            spannableStringBuilder.setSpan(new ColoredImageSpan(ContextCompat.getDrawable(ApplicationLoader.applicationContext, R.drawable.search_arrow).mutate()), 0, 1, 0);
        }
        ?? name = 0;
        TLRPC$User user = messageObject.messageOwner.from_id.user_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getUser(Long.valueOf(messageObject.messageOwner.from_id.user_id)) : null;
        TLRPC$Chat chat = messageObject.messageOwner.from_id.chat_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(messageObject.messageOwner.peer_id.chat_id)) : null;
        if (chat == null) {
            chat = messageObject.messageOwner.from_id.channel_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(messageObject.messageOwner.peer_id.channel_id)) : null;
        }
        TLRPC$Chat chat2 = messageObject.messageOwner.peer_id.channel_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(messageObject.messageOwner.peer_id.channel_id)) : null;
        if (chat2 == null) {
            chat2 = messageObject.messageOwner.peer_id.chat_id != 0 ? MessagesController.getInstance(UserConfig.selectedAccount).getChat(Long.valueOf(messageObject.messageOwner.peer_id.chat_id)) : null;
        }
        if (user != null && chat2 != null) {
            name = new SpannableStringBuilder();
            name.append(ContactsController.formatName(user.first_name, user.last_name)).append(' ').append((CharSequence) arrowSpan).append(' ').append((CharSequence) chat2.title);
        } else if (user != null) {
            name = ContactsController.formatName(user.first_name, user.last_name);
        } else if (chat != null) {
            name = chat.title;
        }
        return name == 0 ? "" : name;
    }

    public void search(final long dialogId, final long minDate, final long maxDate, final FiltersView.MediaFilterData currentSearchFilter, boolean includeFolder, final String query, boolean clearOldResults) {
        Locale locale = Locale.ENGLISH;
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(dialogId);
        objArr[1] = Long.valueOf(minDate);
        objArr[2] = Long.valueOf(maxDate);
        objArr[3] = Integer.valueOf(currentSearchFilter == null ? -1 : currentSearchFilter.filterType);
        objArr[4] = query;
        objArr[5] = Boolean.valueOf(includeFolder);
        final String str = String.format(locale, "%d%d%d%d%s%s", objArr);
        String str2 = this.lastSearchFilterQueryString;
        boolean z = str2 != null && str2.equals(str);
        this.currentSearchFilter = currentSearchFilter;
        this.currentSearchDialogId = dialogId;
        this.currentSearchMinDate = minDate;
        this.currentSearchMaxDate = maxDate;
        this.currentSearchString = query;
        this.currentIncludeFolder = includeFolder;
        this.loadingView.setViewType(1);
        Runnable runnable = this.searchRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
        }
        AndroidUtilities.cancelRunOnUIThread(this.clearCurrentResultsRunnable);
        if (clearOldResults || (currentSearchFilter == null && dialogId == 0 && minDate == 0 && maxDate == 0)) {
            this.messages.clear();
            this.sections.clear();
            this.sectionArrays.clear();
            this.isLoading = true;
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
            this.emptyView.setVisibility(8);
            this.requestIndex++;
            this.firstLoading = true;
            if (this.recyclerListView.getPinnedHeader() != null) {
                this.recyclerListView.getPinnedHeader().setAlpha(0.0f);
            }
            this.localTipChats.clear();
            this.localTipDates.clear();
            if (!clearOldResults || query.length() == 0) {
                this.emptyView.setVisibility(8);
                return;
            }
        } else if (clearOldResults && !this.messages.isEmpty()) {
            return;
        }
        this.isLoading = true;
        if (!z) {
            this.clearCurrentResultsRunnable.run();
            this.emptyView.showProgress(true, !clearOldResults);
        }
        if (TextUtils.isEmpty(query)) {
            this.localTipDates.clear();
            this.localTipChats.clear();
            Delegate delegate = this.delegate;
            if (delegate != null) {
                delegate.updateFiltersView(false, null, null, false);
            }
        }
        final int i = 1 + this.requestIndex;
        this.requestIndex = i;
        final int i2 = UserConfig.selectedAccount;
        final boolean z2 = z;
        Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$7T8eO2EugIIjpP1pWvc_fWXGwDw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$search$7$FilteredSearchView(dialogId, query, currentSearchFilter, i2, minDate, maxDate, z2, str, i);
            }
        };
        this.searchRunnable = runnable2;
        AndroidUtilities.runOnUIThread(runnable2, (!z || this.messages.isEmpty()) ? 350L : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$search$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$7$FilteredSearchView(final long j, final String str, final FiltersView.MediaFilterData mediaFilterData, final int i, final long j2, long j3, final boolean z, String str2, final int i2) {
        TLRPC$TL_messages_searchGlobalExt tLRPC$TL_messages_searchGlobalExt;
        if (j != 0) {
            TLRPC$TL_messages_search tLRPC$TL_messages_search = new TLRPC$TL_messages_search();
            tLRPC$TL_messages_search.q = str;
            tLRPC$TL_messages_search.limit = 20;
            tLRPC$TL_messages_search.filter = mediaFilterData == null ? new TLRPC$TL_inputMessagesFilterEmpty() : mediaFilterData.filter;
            tLRPC$TL_messages_search.peer = AccountInstance.getInstance(i).getMessagesController().getInputPeer(j);
            if (j2 > 0) {
                tLRPC$TL_messages_search.min_date = (int) (j2 / 1000);
            }
            if (j3 > 0) {
                tLRPC$TL_messages_search.max_date = (int) (j3 / 1000);
            }
            if (z && str.equals(this.lastMessagesSearchString) && !this.messages.isEmpty()) {
                tLRPC$TL_messages_search.offset_id = this.messages.get(r1.size() - 1).getId();
                tLRPC$TL_messages_searchGlobalExt = tLRPC$TL_messages_search;
            } else {
                tLRPC$TL_messages_search.offset_id = 0;
                tLRPC$TL_messages_searchGlobalExt = tLRPC$TL_messages_search;
            }
        } else {
            TLRPC$TL_messages_searchGlobalExt tLRPC$TL_messages_searchGlobalExt2 = new TLRPC$TL_messages_searchGlobalExt();
            tLRPC$TL_messages_searchGlobalExt2.limit = 20;
            tLRPC$TL_messages_searchGlobalExt2.q = str;
            tLRPC$TL_messages_searchGlobalExt2.flags = mediaFilterData.filterType | searchType;
            this.lastFoundUsername = str;
            if (z && str.equals(this.lastMessagesSearchString) && !this.messages.isEmpty()) {
                MessageObject messageObject = this.messages.get(r1.size() - 1);
                tLRPC$TL_messages_searchGlobalExt2.offset_id = messageObject.getId();
                TLRPC$Message tLRPC$Message = messageObject.messageOwner;
                tLRPC$TL_messages_searchGlobalExt2.offset_date = tLRPC$Message.date;
                tLRPC$TL_messages_searchGlobalExt2.offset_peer = MessagesController.getInstance(i).getInputPeer(MessageObject.getPeerId(tLRPC$Message.peer_id));
                tLRPC$TL_messages_searchGlobalExt = tLRPC$TL_messages_searchGlobalExt2;
            } else {
                tLRPC$TL_messages_searchGlobalExt2.offset_id = 0;
                tLRPC$TL_messages_searchGlobalExt2.offset_peer = new TLRPC$TL_inputPeerEmpty();
                tLRPC$TL_messages_searchGlobalExt = tLRPC$TL_messages_searchGlobalExt2;
            }
        }
        TLRPC$TL_messages_searchGlobalExt tLRPC$TL_messages_searchGlobalExt3 = tLRPC$TL_messages_searchGlobalExt;
        if (mediaFilterData.filterType != 0) {
            globalSearch.clear();
            this.lastMessagesSearchString = str;
            this.lastSearchFilterQueryString = str2;
            final ArrayList arrayList = new ArrayList();
            FiltersView.fillTipDates(this.lastMessagesSearchString, arrayList);
            final ArrayList arrayList2 = null;
            ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_messages_searchGlobalExt3, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$ak26QXk27mjLvupi1uCz0K5rfQ4
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$search$4$FilteredSearchView(i, str, i2, z, mediaFilterData, j, j2, arrayList2, arrayList, tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        this.lastMessagesSearchString = str;
        this.lastSearchFilterQueryString = str2;
        final ArrayList arrayList3 = new ArrayList();
        FiltersView.fillTipDates(this.lastMessagesSearchString, arrayList3);
        TLRPC$TL_contacts_search tLRPC$TL_contacts_search = new TLRPC$TL_contacts_search();
        tLRPC$TL_contacts_search.q = str;
        tLRPC$TL_contacts_search.limit = 50;
        final ArrayList arrayList4 = null;
        ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_contacts_search, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$O-1seOYukc2yMbudRt764TQIsTQ
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$search$6$FilteredSearchView(i, i2, mediaFilterData, j, j2, z, arrayList4, str, arrayList3, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$4$FilteredSearchView(final int i, final String str, final int i2, final boolean z, final FiltersView.MediaFilterData mediaFilterData, final long j, final long j2, final ArrayList arrayList, final ArrayList arrayList2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        final ArrayList arrayList3 = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            int size = tLRPC$messages_Messages.messages.size();
            for (int i3 = 0; i3 < size; i3++) {
                MessageObject messageObject = new MessageObject(i, tLRPC$messages_Messages.messages.get(i3), false, true);
                messageObject.setQuery(str);
                messageObject.messageOwner.reply_to = null;
                arrayList3.add(messageObject);
            }
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$EXfRb7bX0K8IItsiWlcSQwqDUV0
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f$0.lambda$search$3$FilteredSearchView(i2, tLRPC$TL_error, tLObject, i, z, str, arrayList3, mediaFilterData, j, j2, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$3$FilteredSearchView(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, final int i2, boolean z, String str, ArrayList arrayList, FiltersView.MediaFilterData mediaFilterData, long j, long j2, ArrayList arrayList2, ArrayList arrayList3) throws Resources.NotFoundException {
        boolean z2;
        if (i != this.requestIndex) {
            return;
        }
        this.isLoading = false;
        if (tLRPC$TL_error != null) {
            this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
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
        for (int i3 = 0; i3 < size; i3++) {
            MessageObject messageObject = (MessageObject) arrayList.get(i3);
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
        this.endReached = tLRPC$messages_Messages.messages.size() == 0;
        if (this.messages.isEmpty()) {
            if (mediaFilterData != null) {
                if (TextUtils.isEmpty(this.currentDataQuery) && j == 0 && j2 == 0) {
                    this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle", R.string.SearchEmptyViewTitle));
                    int i4 = mediaFilterData.filterType;
                    if (i4 == 1) {
                        LocaleController.getString("SearchEmptyViewFilteredSubtitleFiles", R.string.SearchEmptyViewFilteredSubtitleFiles);
                    } else if (i4 == 0) {
                        LocaleController.getString("SearchEmptyViewFilteredSubtitleMedia", R.string.SearchEmptyViewFilteredSubtitleMedia);
                    } else if (i4 == 2) {
                        LocaleController.getString("SearchEmptyViewFilteredSubtitleLinks", R.string.SearchEmptyViewFilteredSubtitleLinks);
                    } else if (i4 == 3) {
                        LocaleController.getString("SearchEmptyViewFilteredSubtitleMusic", R.string.SearchEmptyViewFilteredSubtitleMusic);
                    } else {
                        LocaleController.getString("SearchEmptyViewFilteredSubtitleVoice", R.string.SearchEmptyViewFilteredSubtitleVoice);
                    }
                } else {
                    this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
                }
            } else {
                this.emptyView.title.setText(LocaleController.getString("SearchEmptyViewTitle2", R.string.SearchEmptyViewTitle2));
                this.emptyView.subtitle.setVisibility(8);
            }
        }
        if (mediaFilterData != null) {
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
                int i5 = 0;
                while (true) {
                    if (i5 >= this.localTipChats.size()) {
                        z2 = false;
                        break;
                    } else {
                        if ((this.localTipChats.get(i5) instanceof TLRPC$User) && UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser().id == ((TLRPC$User) this.localTipChats.get(i5)).id) {
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    this.localTipChats.add(0, UserConfig.getInstance(UserConfig.selectedAccount).getCurrentUser());
                }
            }
            this.localTipDates.clear();
            this.localTipDates.addAll(arrayList3);
            this.localTipArchive = false;
            if (str.length() >= 3 && (LocaleController.getString("ArchiveSearchFilter", R.string.ArchiveSearchFilter).toLowerCase().startsWith(str) || "archive".startsWith(str))) {
                this.localTipArchive = true;
            }
            Delegate delegate = this.delegate;
            if (delegate != null) {
                delegate.updateFiltersView(TextUtils.isEmpty(this.currentDataQuery), this.localTipChats, this.localTipDates, this.localTipArchive);
            }
        }
        this.firstLoading = false;
        final View view = null;
        final int childAdapterPosition = -1;
        for (int i6 = 0; i6 < size; i6++) {
            View childAt = this.recyclerListView.getChildAt(i6);
            if (childAt instanceof FlickerLoadingView) {
                childAdapterPosition = this.recyclerListView.getChildAdapterPosition(childAt);
                view = childAt;
            }
        }
        if (view != null) {
            this.recyclerListView.removeView(view);
        }
        if ((this.loadingView.getVisibility() == 0 && this.recyclerListView.getChildCount() == 0) || (this.recyclerListView.getAdapter() != this.sharedPhotoVideoAdapter && view != null)) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.FilteredSearchView.7
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FilteredSearchView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    int childCount = FilteredSearchView.this.recyclerListView.getChildCount();
                    AnimatorSet animatorSet = new AnimatorSet();
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View childAt2 = FilteredSearchView.this.recyclerListView.getChildAt(i7);
                        if (view == null || FilteredSearchView.this.recyclerListView.getChildAdapterPosition(childAt2) >= childAdapterPosition) {
                            childAt2.setAlpha(0.0f);
                            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt2, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
                            objectAnimatorOfFloat.setStartDelay((int) ((Math.min(FilteredSearchView.this.recyclerListView.getMeasuredHeight(), Math.max(0, childAt2.getTop())) / FilteredSearchView.this.recyclerListView.getMeasuredHeight()) * 100.0f));
                            objectAnimatorOfFloat.setDuration(200L);
                            animatorSet.playTogether(objectAnimatorOfFloat);
                        }
                    }
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.FilteredSearchView.7.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
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
                            objectAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.FilteredSearchView.7.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$6$FilteredSearchView(final int i, final int i2, final FiltersView.MediaFilterData mediaFilterData, final long j, final long j2, final boolean z, final ArrayList arrayList, final String str, final ArrayList arrayList2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$XMe51Lug51wX3tEh5LXUcOy6NSs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$search$5$FilteredSearchView(tLRPC$TL_error, tLObject, i, i2, mediaFilterData, j, j2, z, arrayList, str, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0202  */
    /* renamed from: lambda$search$5, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$search$5$FilteredSearchView(ir.eitaa.tgnet.TLRPC$TL_error r17, ir.eitaa.tgnet.TLObject r18, final int r19, int r20, ir.eitaa.ui.Adapters.FiltersView.MediaFilterData r21, long r22, long r24, boolean r26, java.util.ArrayList r27, java.lang.String r28, java.util.ArrayList r29) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.FilteredSearchView.lambda$search$5$FilteredSearchView(ir.eitaa.tgnet.TLRPC$TL_error, ir.eitaa.tgnet.TLObject, int, int, ir.eitaa.ui.Adapters.FiltersView$MediaFilterData, long, long, boolean, java.util.ArrayList, java.lang.String, java.util.ArrayList):void");
    }

    public void update() {
        RecyclerView.Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void setKeyboardHeight(int keyboardSize, boolean animated) {
        this.emptyView.setKeyboardHeight(keyboardSize, animated);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void messagesDeleted(long r10, java.util.ArrayList<java.lang.Integer> r12) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
        L3:
            java.util.ArrayList<ir.eitaa.messenger.MessageObject> r3 = r9.messages
            int r3 = r3.size()
            if (r1 >= r3) goto L83
            java.util.ArrayList<ir.eitaa.messenger.MessageObject> r3 = r9.messages
            java.lang.Object r3 = r3.get(r1)
            ir.eitaa.messenger.MessageObject r3 = (ir.eitaa.messenger.MessageObject) r3
            long r4 = r3.getDialogId()
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L29
            long r4 = -r4
            int r5 = (int) r4
            long r6 = (long) r5
            int r4 = ir.eitaa.messenger.UserConfig.selectedAccount
            boolean r4 = ir.eitaa.messenger.ChatObject.isChannel(r6, r4)
            if (r4 == 0) goto L29
            goto L2a
        L29:
            r5 = 0
        L2a:
            long r4 = (long) r5
            r6 = 1
            int r7 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r7 != 0) goto L81
            r4 = 0
        L31:
            int r5 = r12.size()
            if (r4 >= r5) goto L81
            int r5 = r3.getId()
            java.lang.Object r7 = r12.get(r4)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r5 != r7) goto L7e
            java.util.ArrayList<ir.eitaa.messenger.MessageObject> r2 = r9.messages
            r2.remove(r1)
            android.util.SparseArray<ir.eitaa.messenger.MessageObject> r2 = r9.messagesById
            int r5 = r3.getId()
            r2.remove(r5)
            java.util.HashMap<java.lang.String, java.util.ArrayList<ir.eitaa.messenger.MessageObject>> r2 = r9.sectionArrays
            java.lang.String r5 = r3.monthKey
            java.lang.Object r2 = r2.get(r5)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r2.remove(r3)
            int r2 = r2.size()
            if (r2 != 0) goto L76
            java.util.ArrayList<java.lang.String> r2 = r9.sections
            java.lang.String r5 = r3.monthKey
            r2.remove(r5)
            java.util.HashMap<java.lang.String, java.util.ArrayList<ir.eitaa.messenger.MessageObject>> r2 = r9.sectionArrays
            java.lang.String r5 = r3.monthKey
            r2.remove(r5)
        L76:
            int r1 = r1 + (-1)
            int r2 = r9.totalCount
            int r2 = r2 - r6
            r9.totalCount = r2
            r2 = 1
        L7e:
            int r4 = r4 + 1
            goto L31
        L81:
            int r1 = r1 + r6
            goto L3
        L83:
            if (r2 == 0) goto L8c
            androidx.recyclerview.widget.RecyclerView$Adapter r10 = r9.adapter
            if (r10 == 0) goto L8c
            r10.notifyDataSetChanged()
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.FilteredSearchView.messagesDeleted(long, java.util.ArrayList):void");
    }

    private class SharedPhotoVideoAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
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
                sharedPhotoVideoCell.setDelegate(new SharedPhotoVideoCell.SharedPhotoVideoCellDelegate() { // from class: ir.eitaa.ui.FilteredSearchView.SharedPhotoVideoAdapter.1
                    @Override // ir.eitaa.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public void didClickItem(SharedPhotoVideoCell cell, int index, MessageObject messageObject, int a) throws Resources.NotFoundException {
                        FilteredSearchView.this.onItemClick(index, cell, messageObject, a);
                    }

                    @Override // ir.eitaa.ui.Cells.SharedPhotoVideoCell.SharedPhotoVideoCellDelegate
                    public boolean didLongClickItem(SharedPhotoVideoCell cell, int index, MessageObject messageObject, int a) throws Resources.NotFoundException {
                        if (!FilteredSearchView.this.uiCallback.actionModeShowing()) {
                            return FilteredSearchView.this.onItemLongClick(messageObject, cell, a);
                        }
                        didClickItem(cell, index, messageObject, a);
                        return true;
                    }
                });
                frameLayout = sharedPhotoVideoCell;
            } else if (i == 2) {
                FrameLayout graySectionCell = new GraySectionCell(this.mContext);
                graySectionCell.setBackgroundColor(Theme.getColor("graySection") & (-218103809));
                frameLayout = graySectionCell;
            } else {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(this.mContext) { // from class: ir.eitaa.ui.FilteredSearchView.SharedPhotoVideoAdapter.2
                    @Override // ir.eitaa.ui.Components.FlickerLoadingView
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() == 0) {
                FilteredSearchView filteredSearchView = FilteredSearchView.this;
                ArrayList<MessageObject> arrayList = filteredSearchView.messages;
                SharedPhotoVideoCell sharedPhotoVideoCell = (SharedPhotoVideoCell) holder.itemView;
                sharedPhotoVideoCell.setItemsCount(filteredSearchView.columnsCount);
                sharedPhotoVideoCell.setIsFirst(position == 0);
                for (int i = 0; i < FilteredSearchView.this.columnsCount; i++) {
                    int i2 = (FilteredSearchView.this.columnsCount * position) + i;
                    if (i2 < arrayList.size()) {
                        MessageObject messageObject = arrayList.get(i2);
                        sharedPhotoVideoCell.setItem(i, FilteredSearchView.this.messages.indexOf(messageObject), messageObject);
                        if (FilteredSearchView.this.uiCallback.actionModeShowing()) {
                            FilteredSearchView.this.messageHashIdTmp.set(messageObject.getId(), messageObject.getDialogId());
                            sharedPhotoVideoCell.setChecked(i, FilteredSearchView.this.uiCallback.isSelected(FilteredSearchView.this.messageHashIdTmp), true);
                        } else {
                            sharedPhotoVideoCell.setChecked(i, false, true);
                        }
                    } else {
                        sharedPhotoVideoCell.setItem(i, i2, null);
                    }
                }
                sharedPhotoVideoCell.requestLayout();
                return;
            }
            if (holder.getItemViewType() == 3) {
                DialogCell dialogCell = (DialogCell) holder.itemView;
                dialogCell.useSeparator = position != getItemCount() - 1;
                MessageObject messageObject2 = FilteredSearchView.this.messages.get(position);
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
            if (holder.getItemViewType() == 1) {
                ((FlickerLoadingView) holder.itemView).skipDrawItemsCount(FilteredSearchView.this.columnsCount - ((FilteredSearchView.this.columnsCount * ((int) Math.ceil(FilteredSearchView.this.messages.size() / FilteredSearchView.this.columnsCount))) - FilteredSearchView.this.messages.size()));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position < ((int) Math.ceil((double) (((float) FilteredSearchView.this.messages.size()) / ((float) FilteredSearchView.this.columnsCount)))) ? 0 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onItemClick(int index, View view, MessageObject message, int a) throws Resources.NotFoundException {
        if (message == null) {
            return;
        }
        if (this.uiCallback.actionModeShowing()) {
            this.uiCallback.toggleItemSelection(message, view, a);
            return;
        }
        if (view instanceof DialogCell) {
            this.uiCallback.goToMessage(message);
            return;
        }
        int i = this.currentSearchFilter.filterType;
        if (i == 0) {
            PhotoViewer.getInstance().setParentActivity(this.parentActivity);
            PhotoViewer.getInstance().openPhoto(this.messages, index, 0L, 0L, this.provider);
            this.photoViewerClassGuid = PhotoViewer.getInstance().getClassGuid();
            return;
        }
        if (i == 3 || i == 5) {
            if (view instanceof SharedAudioCell) {
                ((SharedAudioCell) view).didPressedButton();
                return;
            }
            return;
        }
        if (i != 1) {
            if (i == 2) {
                try {
                    TLRPC$MessageMedia tLRPC$MessageMedia = message.messageOwner.media;
                    String link = null;
                    TLRPC$WebPage tLRPC$WebPage = tLRPC$MessageMedia != null ? tLRPC$MessageMedia.webpage : null;
                    if (tLRPC$WebPage != null && !(tLRPC$WebPage instanceof TLRPC$TL_webPageEmpty)) {
                        if (tLRPC$WebPage.cached_page != null) {
                            ArticleViewer.getInstance().setParentActivity(this.parentActivity, this.parentFragment);
                            ArticleViewer.getInstance().open(message);
                            return;
                        }
                        String str = tLRPC$WebPage.embed_url;
                        if (str != null && str.length() != 0) {
                            openWebView(tLRPC$WebPage, message);
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
            TLRPC$Document document = message.getDocument();
            if (sharedDocumentCell.isLoaded()) {
                if (message.canPreviewDocument()) {
                    PhotoViewer.getInstance().setParentActivity(this.parentActivity);
                    int iIndexOf = this.messages.indexOf(message);
                    if (iIndexOf < 0) {
                        ArrayList<MessageObject> arrayList = new ArrayList<>();
                        arrayList.add(message);
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
                AndroidUtilities.openDocument(message, this.parentActivity, this.parentFragment);
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int section, int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            return true;
        }

        /* renamed from: ir.eitaa.ui.FilteredSearchView$SharedLinksAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements SharedLinkCell.SharedLinkCellDelegate {
            AnonymousClass1() {
            }

            @Override // ir.eitaa.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
            public void needOpenWebView(TLRPC$WebPage webPage, MessageObject message) {
                FilteredSearchView.this.openWebView(webPage, message);
            }

            @Override // ir.eitaa.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
            public boolean canPerformActions() {
                return !FilteredSearchView.this.uiCallback.actionModeShowing();
            }

            @Override // ir.eitaa.ui.Cells.SharedLinkCell.SharedLinkCellDelegate
            public void onLinkPress(final String urlFinal, boolean longPress) {
                if (!longPress) {
                    FilteredSearchView.this.openUrl(urlFinal);
                    return;
                }
                BottomSheet.Builder builder = new BottomSheet.Builder(FilteredSearchView.this.parentActivity);
                builder.setTitle(urlFinal);
                builder.setItems(new CharSequence[]{LocaleController.getString("Open", R.string.Open), LocaleController.getString("Copy", R.string.Copy)}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FilteredSearchView$SharedLinksAdapter$1$ipLwF_jbvKUvMiRyAcbdX59uGQo
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onLinkPress$0$FilteredSearchView$SharedLinksAdapter$1(urlFinal, dialogInterface, i);
                    }
                });
                FilteredSearchView.this.parentFragment.showDialog(builder.create());
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$onLinkPress$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$onLinkPress$0$FilteredSearchView$SharedLinksAdapter$1(String str, DialogInterface dialogInterface, int i) {
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            if (section >= FilteredSearchView.this.sections.size()) {
                return 1;
            }
            FilteredSearchView filteredSearchView = FilteredSearchView.this;
            return filteredSearchView.sectionArrays.get(filteredSearchView.sections.get(section)).size() + (section == 0 ? 0 : 1);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int section, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor("graySection") & (-218103809));
            }
            if (section == 0) {
                view.setAlpha(0.0f);
                return view;
            }
            if (section < FilteredSearchView.this.sections.size()) {
                view.setAlpha(1.0f);
                ((GraySectionCell) view).setText(LocaleController.formatSectionDate(FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(section)).get(0).messageOwner.date));
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() != 2) {
                ArrayList<MessageObject> arrayList = FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(section));
                int itemViewType = holder.getItemViewType();
                boolean z = false;
                if (itemViewType == 0) {
                    ((GraySectionCell) holder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                    return;
                }
                if (itemViewType != 1) {
                    return;
                }
                if (section != 0) {
                    position--;
                }
                final SharedLinkCell sharedLinkCell = (SharedLinkCell) holder.itemView;
                final MessageObject messageObject = arrayList.get(position);
                final boolean z2 = sharedLinkCell.getMessage() != null && sharedLinkCell.getMessage().getId() == messageObject.getId();
                if (position != arrayList.size() - 1 || (section == FilteredSearchView.this.sections.size() - 1 && FilteredSearchView.this.isLoading)) {
                    z = true;
                }
                sharedLinkCell.setLink(messageObject, z);
                sharedLinkCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.FilteredSearchView.SharedLinksAdapter.2
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            if (section < FilteredSearchView.this.sections.size()) {
                return (section == 0 || position != 0) ? 1 : 0;
            }
            return 2;
        }
    }

    private class SharedDocumentsAdapter extends RecyclerListView.SectionsAdapter {
        private int currentType;
        private Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public Object getItem(int section, int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public String getLetter(int position) {
            return null;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.FastScrollAdapter
        public int getPositionForScrollProgress(float progress) {
            return 0;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder, int section, int row) {
            return section == 0 || row != 0;
        }

        public SharedDocumentsAdapter(Context context, int type) {
            this.mContext = context;
            this.currentType = type;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getCountForSection(int section) {
            if (section >= FilteredSearchView.this.sections.size()) {
                return 1;
            }
            FilteredSearchView filteredSearchView = FilteredSearchView.this;
            return filteredSearchView.sectionArrays.get(filteredSearchView.sections.get(section)).size() + (section == 0 ? 0 : 1);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public View getSectionHeaderView(int section, View view) {
            if (view == null) {
                view = new GraySectionCell(this.mContext);
                view.setBackgroundColor(Theme.getColor("graySection") & (-218103809));
            }
            if (section == 0) {
                view.setAlpha(0.0f);
                return view;
            }
            if (section < FilteredSearchView.this.sections.size()) {
                view.setAlpha(1.0f);
                ((GraySectionCell) view).setText(LocaleController.formatSectionDate(FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(section)).get(0).messageOwner.date));
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
                    graySectionCell = new SharedAudioCell(this.mContext, i2, null) { // from class: ir.eitaa.ui.FilteredSearchView.SharedDocumentsAdapter.1
                        @Override // ir.eitaa.ui.Cells.SharedAudioCell
                        public boolean needPlayMessage(MessageObject messageObject) throws IOException {
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
                            long j = filteredSearchView.currentSearchDialogId;
                            long j2 = filteredSearchView.currentSearchMinDate;
                            MediaController.PlaylistGlobalSearchParams playlistGlobalSearchParams = new MediaController.PlaylistGlobalSearchParams(str, j, j2, j2, filteredSearchView.currentSearchFilter);
                            playlistGlobalSearchParams.endReached = FilteredSearchView.this.endReached;
                            playlistGlobalSearchParams.nextSearchRate = FilteredSearchView.this.nextSearchRate;
                            playlistGlobalSearchParams.totalCount = FilteredSearchView.this.totalCount;
                            playlistGlobalSearchParams.folderId = FilteredSearchView.this.currentIncludeFolder ? 1 : 0;
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public void onBindViewHolder(int section, int position, RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() != 2) {
                ArrayList<MessageObject> arrayList = FilteredSearchView.this.sectionArrays.get(FilteredSearchView.this.sections.get(section));
                int itemViewType = holder.getItemViewType();
                boolean z = false;
                if (itemViewType == 0) {
                    ((GraySectionCell) holder.itemView).setText(LocaleController.formatSectionDate(arrayList.get(0).messageOwner.date));
                    return;
                }
                if (itemViewType == 1) {
                    if (section != 0) {
                        position--;
                    }
                    final SharedDocumentCell sharedDocumentCell = (SharedDocumentCell) holder.itemView;
                    final MessageObject messageObject = arrayList.get(position);
                    final boolean z2 = sharedDocumentCell.getMessage() != null && sharedDocumentCell.getMessage().getId() == messageObject.getId();
                    if (position != arrayList.size() - 1 || (section == FilteredSearchView.this.sections.size() - 1 && FilteredSearchView.this.isLoading)) {
                        z = true;
                    }
                    sharedDocumentCell.setDocument(messageObject, z);
                    sharedDocumentCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.FilteredSearchView.SharedDocumentsAdapter.2
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
                if (section != 0) {
                    position--;
                }
                final SharedAudioCell sharedAudioCell = (SharedAudioCell) holder.itemView;
                final MessageObject messageObject2 = arrayList.get(position);
                final boolean z3 = sharedAudioCell.getMessage() != null && sharedAudioCell.getMessage().getId() == messageObject2.getId();
                if (position != arrayList.size() - 1 || (section == FilteredSearchView.this.sections.size() - 1 && FilteredSearchView.this.isLoading)) {
                    z = true;
                }
                sharedAudioCell.setMessageObject(messageObject2, z);
                sharedAudioCell.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: ir.eitaa.ui.FilteredSearchView.SharedDocumentsAdapter.3
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

        @Override // ir.eitaa.ui.Components.RecyclerListView.SectionsAdapter
        public int getItemViewType(int section, int position) {
            if (section >= FilteredSearchView.this.sections.size()) {
                return 2;
            }
            if (section != 0 && position == 0) {
                return 0;
            }
            int i = this.currentType;
            return (i == 2 || i == 4) ? 3 : 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openUrl(String link) {
        if (AndroidUtilities.shouldShowUrlInAlert(link)) {
            AlertsCreator.showOpenUrlAlert(this.parentFragment, link, true, true);
        } else {
            Browser.openUrl(this.parentActivity, link);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openWebView(TLRPC$WebPage webPage, MessageObject message) {
        EmbedBottomSheet.show(this.parentActivity, message, this.provider, webPage.site_name, webPage.description, webPage.url, webPage.embed_url, webPage.embed_width, webPage.embed_height, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = UserConfig.selectedAccount;
        this.lastAccount = i;
        NotificationCenter.getInstance(i).addObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getInstance(this.lastAccount).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.lastAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.lastAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.lastAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        this.hintCell.setBackgroundColor(Theme.getColor("graySection"));
        this.hintCell.setTextColor("key_graySectionText");
        this.emptyView.updateNoResultColor();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NotificationCenter.getInstance(this.lastAccount).removeObserver(this, NotificationCenter.emojiLoaded);
        NotificationCenter.getInstance(this.lastAccount).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(this.lastAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(this.lastAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.lastAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        ChatMessageCell chatMessageCell;
        MessageObject messageObject;
        AnimatedFileDrawable animation;
        RecyclerListView recyclerListView;
        ChatMessageCell chatMessageCell2;
        MessageObject messageObject2;
        AnimatedFileDrawable animation2;
        ChatMessageCell chatMessageCell3;
        MessageObject messageObject3;
        if (id == NotificationCenter.emojiLoaded) {
            int childCount = this.recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (this.recyclerListView.getChildAt(i) instanceof DialogCell) {
                    ((DialogCell) this.recyclerListView.getChildAt(i)).update(0);
                }
                this.recyclerListView.getChildAt(i).invalidate();
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingProgressDidChanged) {
            Integer num = (Integer) args[0];
            RecyclerListView recyclerListView2 = this.recyclerListView;
            if (recyclerListView2 == null || recyclerListView2.getAdapter() == null) {
                return;
            }
            int itemCount = this.recyclerListView.getAdapter().getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                View childAt = this.recyclerListView.getChildAt(i2);
                if ((childAt instanceof ChatMessageCell) && (messageObject3 = (chatMessageCell3 = (ChatMessageCell) childAt).getMessageObject()) != null && messageObject3.getId() == num.intValue()) {
                    MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                    if (playingMessageObject == null || chatMessageCell3.getSeekBar().isDragging()) {
                        return;
                    }
                    messageObject3.audioProgress = playingMessageObject.audioProgress;
                    messageObject3.audioProgressSec = playingMessageObject.audioProgressSec;
                    messageObject3.audioPlayerDuration = playingMessageObject.audioPlayerDuration;
                    chatMessageCell3.updatePlayingMessageProgress();
                    return;
                }
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidStart) {
            if (((MessageObject) args[0]).eventId == 0 && (recyclerListView = this.recyclerListView) != null) {
                int childCount2 = recyclerListView.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = this.recyclerListView.getChildAt(i3);
                    if ((childAt2 instanceof ChatMessageCell) && (messageObject2 = (chatMessageCell2 = (ChatMessageCell) childAt2).getMessageObject()) != null) {
                        boolean zIsVideo = messageObject2.isVideo();
                        if (messageObject2.isRoundVideo() || zIsVideo) {
                            chatMessageCell2.checkVideoPlayback(!r8.equals(messageObject2), null);
                            if (!MediaController.getInstance().isPlayingMessage(messageObject2)) {
                                if (zIsVideo && !MediaController.getInstance().isGoingToShowMessageObject(messageObject2) && (animation2 = chatMessageCell2.getPhotoImage().getAnimation()) != null) {
                                    animation2.start();
                                }
                                if (messageObject2.audioProgress != 0.0f) {
                                    messageObject2.resetPlayingProgress();
                                    chatMessageCell2.invalidate();
                                }
                            } else if (zIsVideo) {
                                chatMessageCell2.updateButtonState(false, true, false);
                            }
                        } else if (messageObject2.isVoice() || messageObject2.isMusic()) {
                            chatMessageCell2.updateButtonState(false, true, false);
                        }
                    }
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidReset || id == NotificationCenter.messagePlayingPlayStateChanged) {
            ((Integer) args[0]).intValue();
            RecyclerListView recyclerListView3 = this.recyclerListView;
            if (recyclerListView3 != null) {
                int childCount3 = recyclerListView3.getChildCount();
                for (int i4 = 0; i4 < childCount3; i4++) {
                    View childAt3 = this.recyclerListView.getChildAt(i4);
                    if ((childAt3 instanceof ChatMessageCell) && (messageObject = (chatMessageCell = (ChatMessageCell) childAt3).getMessageObject()) != null) {
                        if (messageObject.isVoice() || messageObject.isMusic()) {
                            chatMessageCell.updateButtonState(false, true, false);
                        } else if (messageObject.isVideo()) {
                            chatMessageCell.updateButtonState(false, true, false);
                            if (!MediaController.getInstance().isPlayingMessage(messageObject) && !MediaController.getInstance().isGoingToShowMessageObject(messageObject) && (animation = chatMessageCell.getPhotoImage().getAnimation()) != null) {
                                animation.start();
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean onItemLongClick(MessageObject item, View view, int a) {
        if (!this.uiCallback.actionModeShowing()) {
            this.uiCallback.showActionMode();
        }
        if (!this.uiCallback.actionModeShowing()) {
            return true;
        }
        this.uiCallback.toggleItemSelection(item, view, a);
        return true;
    }

    public static class MessageHashId {
        public long dialogId;
        public int messageId;

        public MessageHashId(int messageId, long dialogId) {
            this.dialogId = dialogId;
            this.messageId = messageId;
        }

        public void set(int messageId, long dialogId) {
            this.dialogId = dialogId;
            this.messageId = messageId;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || MessageHashId.class != o.getClass()) {
                return false;
            }
            MessageHashId messageHashId = (MessageHashId) o;
            return this.dialogId == messageHashId.dialogId && this.messageId == messageHashId.messageId;
        }

        public int hashCode() {
            return this.messageId;
        }
    }

    class OnlyUserFiltersAdapter extends RecyclerListView.SelectionAdapter {
        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        OnlyUserFiltersAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View dialogCell;
            if (i == 0) {
                dialogCell = new DialogCell(null, viewGroup.getContext(), true, false);
            } else if (i == 3) {
                FlickerLoadingView flickerLoadingView = new FlickerLoadingView(viewGroup.getContext());
                flickerLoadingView.setIsSingleCell(true);
                flickerLoadingView.setViewType(1);
                dialogCell = flickerLoadingView;
            } else if (i == 4) {
                ChatMessageCell chatMessageCell = new ChatMessageCell(viewGroup.getContext());
                chatMessageCell.shouldDrawMenu = false;
                dialogCell = chatMessageCell;
            } else if (i != 5) {
                GraySectionCell graySectionCell = new GraySectionCell(viewGroup.getContext());
                graySectionCell.setText(LocaleController.getString("SearchMessages", R.string.SearchMessages));
                dialogCell = graySectionCell;
            } else {
                dialogCell = new ProfileSearchCell(viewGroup.getContext());
            }
            dialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(dialogCell);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01bc  */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v17 */
        /* JADX WARN: Type inference failed for: r0v18, types: [ir.eitaa.tgnet.TLRPC$Chat] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r12v1, types: [android.text.SpannableStringBuilder] */
        /* JADX WARN: Type inference failed for: r3v18, types: [android.text.SpannableStringBuilder] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(final androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 560
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.FilteredSearchView.OnlyUserFiltersAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        public void setExpandedViewMode(boolean expandedViewMode) {
            if (SharedConfig.expandedViewMode == expandedViewMode) {
                return;
            }
            SharedConfig.updateExpandedViewMode(expandedViewMode);
            updateVisibleRows();
        }

        private void updateVisibleRows() {
            LinearLayoutManager linearLayoutManager;
            int iFindFirstVisibleItemPosition;
            int iFindLastVisibleItemPosition;
            RecyclerListView recyclerListView = FilteredSearchView.this.recyclerListView;
            if (recyclerListView == null || recyclerListView.getLayoutManager() == null) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = FilteredSearchView.this.recyclerListView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager) || (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) < (iFindFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition())) {
                return;
            }
            notifyItemRangeChanged(iFindFirstVisibleItemPosition, (iFindLastVisibleItemPosition - iFindFirstVisibleItemPosition) + 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (FilteredSearchView.globalSearch.size() != 0) {
                return 5;
            }
            if (position >= FilteredSearchView.this.messages.size()) {
                return 3;
            }
            return SharedConfig.expandedViewMode ? 4 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (FilteredSearchView.this.messages.isEmpty() && FilteredSearchView.globalSearch.isEmpty()) {
                return 0;
            }
            if (!FilteredSearchView.globalSearch.isEmpty()) {
                return FilteredSearchView.globalSearch.size();
            }
            return FilteredSearchView.this.messages.size() + (!FilteredSearchView.this.endReached ? 1 : 0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        RecyclerView.Adapter adapter;
        int i = this.columnsCount;
        if (!AndroidUtilities.isTablet() && getResources().getConfiguration().orientation == 2) {
            this.columnsCount = 6;
        } else {
            this.columnsCount = 3;
        }
        if (i != this.columnsCount && (adapter = this.adapter) == this.sharedPhotoVideoAdapter) {
            this.ignoreRequestLayout = true;
            adapter.notifyDataSetChanged();
            this.ignoreRequestLayout = false;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreRequestLayout) {
            return;
        }
        super.requestLayout();
    }

    public void setDelegate(Delegate delegate, boolean update) {
        this.delegate = delegate;
        if (!update || delegate == null || this.localTipChats.isEmpty()) {
            return;
        }
        delegate.updateFiltersView(false, this.localTipChats, this.localTipDates, this.localTipArchive);
    }

    public void setUiCallback(UiCallback callback) {
        this.uiCallback = callback;
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
        this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.FilteredSearchView.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                FilteredSearchView.this.floatingDateAnimation = null;
            }
        });
        this.floatingDateAnimation.start();
    }

    private void hideFloatingDateView(boolean animated) {
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
        if (animated) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.floatingDateAnimation = animatorSet2;
            animatorSet2.setDuration(180L);
            this.floatingDateAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.floatingDateView, (Property<ChatActionCell, Float>) View.TRANSLATION_Y, -AndroidUtilities.dp(48.0f)));
            this.floatingDateAnimation.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.floatingDateAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.FilteredSearchView.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
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

    public void setHintText(int position) {
        String string;
        if (LocaleController.isRTL) {
            position = Math.abs(position - 5);
        }
        if (position == 0) {
            string = LocaleController.getString("SearchFilterDialogsDescription", R.string.SearchFilterDialogsDescription);
        } else if (position == 1) {
            string = LocaleController.getString("SearchFilterTitlesDescription", R.string.SearchFilterTitlesDescription);
        } else if (position == 2) {
            string = LocaleController.getString("SearchFilterPrivateDescription", R.string.SearchFilterPrivateDescription);
        } else if (position == 3) {
            string = LocaleController.getString("SearchFilterPublicDescription", R.string.SearchFilterPublicDescription);
        } else {
            string = LocaleController.getString("SearchFilterGlobalDescription", R.string.SearchFilterGlobalDescription);
        }
        this.hintCell.setText(string);
    }

    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this, 0, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this, 0, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"dateTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText3"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_PROGRESSBAR, new Class[]{SharedDocumentCell.class}, new String[]{"progressView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_startStopLoadIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"statusImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_startStopLoadIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedDocumentCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"thumbImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_folderIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedDocumentCell.class}, new String[]{"extTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "files_iconText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{LoadingCell.class}, new String[]{"progressBar"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_titleTextPaint, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_descriptionTextPaint, null, null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedLinkCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, new String[]{"titleTextPaint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, null, null, null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, Theme.linkSelectionPaint, null, null, "windowBackgroundWhiteLinkSelection"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_linkPlaceholderText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{SharedLinkCell.class}, new String[]{"letterDrawable"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "sharedMedia_linkPlaceholder"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_SECTIONS, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{SharedMediaSectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, Theme.avatarDrawables, null, "avatar_text"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_countPaint, null, null, "chats_unreadCounter"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_countGrayPaint, null, null, "chats_unreadCounterMuted"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_countTextPaint, null, null, "chats_unreadCounterText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_lockDrawable}, null, "chats_secretIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_groupDrawable, Theme.dialogs_broadcastDrawable, Theme.dialogs_botDrawable}, null, "chats_nameIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_scamDrawable, Theme.dialogs_fakeDrawable, Theme.dialogs_shopDrawable}, null, "chats_draft"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_pinnedDrawable, Theme.dialogs_reorderDrawable}, null, "chats_pinnedIcon"));
        TextPaint[] textPaintArr = Theme.dialogs_namePaint;
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr[0], textPaintArr[1], Theme.dialogs_searchNamePaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_name"));
        TextPaint[] textPaintArr2 = Theme.dialogs_nameEncryptedPaint;
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, (String[]) null, new Paint[]{textPaintArr2[0], textPaintArr2[1], Theme.dialogs_searchNameEncryptedPaint}, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_secretName"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_messagePaint[1], null, null, "chats_message_threeLines"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_messagePaint[0], null, null, "chats_message"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_messageNamePaint, null, null, "chats_nameMessage_threeLines"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, "chats_draft"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, (String[]) null, Theme.dialogs_messagePrintingPaint, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "chats_actionMessage"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_timePaint, null, null, "chats_date"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_pinnedPaint, null, null, "chats_pinnedOverlay"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_tabletSeletedPaint, null, null, "chats_tabletSelectedOverlay"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_checkDrawable}, null, "chats_sentCheck"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_checkReadDrawable, Theme.dialogs_halfCheckDrawable}, null, "chats_sentReadCheck"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_clockDrawable}, null, "chats_sentClock"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, Theme.dialogs_errorPaint, null, null, "chats_sentError"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_errorDrawable}, null, "chats_sentErrorIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedCheckDrawable}, null, "chats_verifiedCheck"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class, ProfileSearchCell.class}, null, new Drawable[]{Theme.dialogs_verifiedDrawable}, null, "chats_verifiedBackground"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_muteDrawable}, null, "chats_muteIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, new Drawable[]{Theme.dialogs_mentionDrawable}, null, "chats_mentionIcon"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, "chats_archivePinBackground"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, "chats_archiveBackground"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, "chats_onlineCircle"));
        arrayList.add(new ThemeDescription(this.recyclerListView, 0, new Class[]{DialogCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOX, new Class[]{DialogCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{DialogCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "key_graySectionText"));
        arrayList.add(new ThemeDescription(this.recyclerListView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR | ThemeDescription.FLAG_SECTIONS, new Class[]{GraySectionCell.class}, null, null, null, "graySection"));
        arrayList.add(new ThemeDescription(this.emptyView.title, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.emptyView.subtitle, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText"));
        return arrayList;
    }
}
