package ir.eitaa.ui.explore.activity;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.URLSpan;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.collection.LongSparseArray;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$KeyboardButton;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_messages_searchGlobalExt;
import ir.eitaa.tgnet.TLRPC$TL_reactionCount;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuSubItem;
import ir.eitaa.ui.ActionBar.ActionBarPopupWindow;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.TextSelectionHelper;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.AnimationProperties;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.PhotoViewer;
import ir.eitaa.ui.PinchToZoomHelper;
import ir.eitaa.ui.explore.cells.KavoshCell;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class KavoshActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate, DialogsActivity.DialogsActivityDelegate {
    KavoshRVAdapter adapter;
    private int appScreenHeight;
    public ArrayList<Integer> categoriesId;
    private boolean endReached;
    private FrameLayout frameLayout;
    private String hashtag;
    private ArrayList<Boolean> inScreenStates;
    private boolean isPhotoViewerOpen;
    RecyclerView listView;
    private int listViewPaddingTop;
    private ProgressBar loadingView;
    private ArrayList<MessageObject> messages;
    public SparseArray<MessageObject> messagesById;
    private SparseArray<MessageObject> messagesDict;
    private TLRPC$InputPeer peer;
    private PhotoViewer.PhotoViewerProvider photoViewerProvider;
    private int reqId;
    private AnimatorSet scrimAnimatorSet;
    private Paint scrimPaint;
    private ActionBarPopupWindow scrimPopupWindow;
    private ActionBarMenuSubItem[] scrimPopupWindowItems;
    private int scrimPopupX;
    private int scrimPopupY;
    private View scrimView;
    public HashMap<String, ArrayList<MessageObject>> sectionArrays;
    public ArrayList<String> sections;
    private MessageObject selectedMessageForPlaying;
    private MessageObject selectedObject;

    public KavoshActivity(MessageObject messageObject) {
        this.messages = new ArrayList<>();
        this.listViewPaddingTop = 8;
        this.messagesById = new SparseArray<>();
        this.sections = new ArrayList<>();
        this.sectionArrays = new HashMap<>();
        this.categoriesId = new ArrayList<>();
        this.inScreenStates = new ArrayList<>();
        this.reqId = 0;
        this.messagesDict = new SparseArray<>();
        this.endReached = false;
        this.hashtag = null;
        this.isPhotoViewerOpen = false;
        this.photoViewerProvider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.12
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean validateGroupId(long groupId) {
                return false;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject2, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
                KavoshCell kavoshCell;
                MessageObject messageObject3;
                int childCount = KavoshActivity.this.listView.getChildCount();
                int i = 0;
                while (true) {
                    ImageReceiver photoImage = null;
                    if (i >= childCount) {
                        return null;
                    }
                    View childAt = KavoshActivity.this.listView.getChildAt(i);
                    if ((childAt instanceof KavoshCell) && messageObject2 != null && (messageObject3 = (kavoshCell = (KavoshCell) childAt).getMessageObject()) != null && messageObject3.getId() == messageObject2.getId()) {
                        photoImage = kavoshCell.getPhotoImage();
                    }
                    if (photoImage != null) {
                        int[] iArr = new int[2];
                        childAt.getLocationInWindow(iArr);
                        PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                        placeProviderObject.viewX = iArr[0];
                        placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT < 21 ? AndroidUtilities.statusBarHeight : 0);
                        placeProviderObject.parentView = KavoshActivity.this.listView;
                        placeProviderObject.imageReceiver = photoImage;
                        placeProviderObject.thumb = photoImage.getBitmapSafe();
                        placeProviderObject.radius = photoImage.getRoundRadius();
                        return placeProviderObject;
                    }
                    i++;
                }
            }
        };
        this.messages.add(new MessageObject(this.currentAccount, messageObject.messageOwner, false, true, 2));
        this.inScreenStates.add(Boolean.TRUE);
        this.peer = new TLRPC$TL_inputPeerEmpty();
    }

    public KavoshActivity(String hashtag) {
        this.messages = new ArrayList<>();
        this.listViewPaddingTop = 8;
        this.messagesById = new SparseArray<>();
        this.sections = new ArrayList<>();
        this.sectionArrays = new HashMap<>();
        this.categoriesId = new ArrayList<>();
        this.inScreenStates = new ArrayList<>();
        this.reqId = 0;
        this.messagesDict = new SparseArray<>();
        this.endReached = false;
        this.hashtag = null;
        this.isPhotoViewerOpen = false;
        this.photoViewerProvider = new PhotoViewer.EmptyPhotoViewerProvider() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.12
            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public boolean validateGroupId(long groupId) {
                return false;
            }

            @Override // ir.eitaa.ui.PhotoViewer.EmptyPhotoViewerProvider, ir.eitaa.ui.PhotoViewer.PhotoViewerProvider
            public PhotoViewer.PlaceProviderObject getPlaceForPhoto(MessageObject messageObject2, TLRPC$FileLocation fileLocation, int index, boolean needPreview) {
                KavoshCell kavoshCell;
                MessageObject messageObject3;
                int childCount = KavoshActivity.this.listView.getChildCount();
                int i = 0;
                while (true) {
                    ImageReceiver photoImage = null;
                    if (i >= childCount) {
                        return null;
                    }
                    View childAt = KavoshActivity.this.listView.getChildAt(i);
                    if ((childAt instanceof KavoshCell) && messageObject2 != null && (messageObject3 = (kavoshCell = (KavoshCell) childAt).getMessageObject()) != null && messageObject3.getId() == messageObject2.getId()) {
                        photoImage = kavoshCell.getPhotoImage();
                    }
                    if (photoImage != null) {
                        int[] iArr = new int[2];
                        childAt.getLocationInWindow(iArr);
                        PhotoViewer.PlaceProviderObject placeProviderObject = new PhotoViewer.PlaceProviderObject();
                        placeProviderObject.viewX = iArr[0];
                        placeProviderObject.viewY = iArr[1] - (Build.VERSION.SDK_INT < 21 ? AndroidUtilities.statusBarHeight : 0);
                        placeProviderObject.parentView = KavoshActivity.this.listView;
                        placeProviderObject.imageReceiver = photoImage;
                        placeProviderObject.thumb = photoImage.getBitmapSafe();
                        placeProviderObject.radius = photoImage.getRoundRadius();
                        return placeProviderObject;
                    }
                    i++;
                }
            }
        };
        this.peer = new TLRPC$TL_inputPeerEmpty();
        this.hashtag = hashtag;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onResume() {
        super.onResume();
        getParentActivity().setRequestedOrientation(1);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateMessagesViews);
        NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(UserConfig.selectedAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateMessagesViews);
        NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.messagePlayingProgressDidChanged);
        NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(UserConfig.selectedAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        ActionBar actionBar = this.actionBar;
        String str = this.hashtag;
        if (str == null) {
            str = "کاوش";
        }
        actionBar.setTitle(str);
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    KavoshActivity.this.finishFragment();
                }
            }
        });
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.2
            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                return super.drawChild(canvas, child, drawingTime);
            }
        };
        this.frameLayout = sizeNotifierFrameLayout;
        this.fragmentView = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.frameLayout.setLayoutParams(LayoutHelper.createFrame(-1, -1.0f));
        this.adapter = new KavoshRVAdapter(context);
        RecyclerView recyclerView = new RecyclerView(context) { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                KavoshCell kavoshCell;
                ImageReceiver avatarImage;
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if ((child instanceof KavoshCell) && (avatarImage = (kavoshCell = (KavoshCell) child).getAvatarImage()) != null) {
                    avatarImage.setImageCoords(kavoshCell.getParentWidth() - AndroidUtilities.dp(40.0f), ((int) (kavoshCell.currentMessageObject.type == 0 ? 0.0f : kavoshCell.captionY + AndroidUtilities.dp(4.0f))) + child.getTop(), AndroidUtilities.dp(32.0f), AndroidUtilities.dp(32.0f));
                    avatarImage.draw(canvas);
                }
                return zDrawChild;
            }
        };
        this.listView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
        this.frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 17, 8.0f, this.listViewPaddingTop, 8.0f, 0.0f));
        this.listView.post(new Runnable() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.4
            @Override // java.lang.Runnable
            public void run() {
                KavoshActivity kavoshActivity = KavoshActivity.this;
                kavoshActivity.appScreenHeight = kavoshActivity.listView.getMeasuredHeight();
            }
        });
        ProgressBar progressBar = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        this.loadingView = progressBar;
        progressBar.setIndeterminate(true);
        if (Build.VERSION.SDK_INT >= 21) {
            this.loadingView.setIndeterminateTintList(ColorStateList.valueOf(Theme.getColor("chats_actionBackground")));
        }
        this.loadingView.setPadding(0, 0, 0, 0);
        this.frameLayout.addView(this.loadingView, LayoutHelper.createFrame(-1, -2, 80));
        String str2 = this.hashtag;
        if (str2 != null) {
            search(str2);
        }
        return this.fragmentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) throws Resources.NotFoundException {
        KavoshCell kavoshCell;
        MessageObject messageObject;
        AnimatedFileDrawable animation;
        RecyclerView recyclerView;
        KavoshCell kavoshCell2;
        MessageObject messageObject2;
        AnimatedFileDrawable animation2;
        KavoshCell kavoshCell3;
        MessageObject messageObject3;
        if (id == NotificationCenter.messagePlayingProgressDidChanged) {
            Integer num = (Integer) args[0];
            RecyclerView recyclerView2 = this.listView;
            if (recyclerView2 == null || recyclerView2.getAdapter() == null) {
                return;
            }
            int itemCount = this.listView.getAdapter().getItemCount();
            for (int i = 0; i < itemCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if ((childAt instanceof KavoshCell) && (messageObject3 = (kavoshCell3 = (KavoshCell) childAt).getMessageObject()) != null && messageObject3.getId() == num.intValue()) {
                    MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
                    if (playingMessageObject == null || kavoshCell3.getSeekBar().isDragging()) {
                        return;
                    }
                    messageObject3.audioProgress = playingMessageObject.audioProgress;
                    messageObject3.audioProgressSec = playingMessageObject.audioProgressSec;
                    messageObject3.audioPlayerDuration = playingMessageObject.audioPlayerDuration;
                    kavoshCell3.updatePlayingMessageProgress();
                    return;
                }
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingDidStart) {
            if (((MessageObject) args[0]).eventId == 0 && (recyclerView = this.listView) != null) {
                int childCount = recyclerView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt2 = this.listView.getChildAt(i2);
                    if ((childAt2 instanceof KavoshCell) && (messageObject2 = (kavoshCell2 = (KavoshCell) childAt2).getMessageObject()) != null) {
                        boolean zIsVideo = messageObject2.isVideo();
                        if (messageObject2.isRoundVideo() || zIsVideo) {
                            kavoshCell2.checkVideoPlayback(!r9.equals(messageObject2), null);
                            if (!MediaController.getInstance().isPlayingMessage(messageObject2)) {
                                if (zIsVideo && !MediaController.getInstance().isGoingToShowMessageObject(messageObject2) && (animation2 = kavoshCell2.getPhotoImage().getAnimation()) != null) {
                                    animation2.start();
                                }
                                if (messageObject2.audioProgress != 0.0f) {
                                    messageObject2.resetPlayingProgress();
                                    kavoshCell2.invalidate();
                                }
                            } else if (zIsVideo) {
                                kavoshCell2.updateButtonState(false, true, false);
                            }
                        } else if (messageObject2.isVoice() || messageObject2.isMusic()) {
                            kavoshCell2.updateButtonState(false, true, false);
                        }
                    }
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.messagePlayingPlayStateChanged || id == NotificationCenter.messagePlayingDidReset) {
            RecyclerView recyclerView3 = this.listView;
            if (recyclerView3 != null) {
                int childCount2 = recyclerView3.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt3 = this.listView.getChildAt(i3);
                    if ((childAt3 instanceof KavoshCell) && (messageObject = (kavoshCell = (KavoshCell) childAt3).getMessageObject()) != null) {
                        if (messageObject.isVoice() || messageObject.isMusic()) {
                            kavoshCell.updateButtonState(false, true, false);
                        } else if (messageObject.isVideo()) {
                            kavoshCell.updateButtonState(false, true, false);
                            if (!MediaController.getInstance().isPlayingMessage(messageObject) && !MediaController.getInstance().isGoingToShowMessageObject(messageObject) && (animation = kavoshCell.getPhotoImage().getAnimation()) != null) {
                                animation.start();
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        if (id == NotificationCenter.didUpdateMessagesViews) {
            LongSparseArray longSparseArray = (LongSparseArray) args[0];
            Iterator<MessageObject> it = this.messages.iterator();
            boolean z = false;
            while (it.hasNext()) {
                MessageObject next = it.next();
                SparseIntArray sparseIntArray = (SparseIntArray) longSparseArray.get(next.getDialogId());
                if (sparseIntArray != null) {
                    for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                        int iKeyAt = sparseIntArray.keyAt(i4);
                        if (iKeyAt == next.getId()) {
                            int i5 = sparseIntArray.get(iKeyAt);
                            TLRPC$Message tLRPC$Message = next.messageOwner;
                            if (i5 > tLRPC$Message.views) {
                                tLRPC$Message.views = i5;
                                z = true;
                            }
                        }
                    }
                }
            }
            if (z) {
                updateVisibleRowsViews();
            }
        }
    }

    private void updateVisibleRowsViews() {
        LinearLayoutManager linearLayoutManager;
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        RecyclerView recyclerView = this.listView;
        if (recyclerView == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.listView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) < (iFindFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) || this.listView.isComputingLayout()) {
            return;
        }
        for (iFindFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition(); iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition; iFindFirstVisibleItemPosition++) {
            ((KavoshCell) this.listView.findViewHolderForAdapterPosition(iFindFirstVisibleItemPosition).itemView).updateViewsLayout(this.messages.get(iFindFirstVisibleItemPosition).messageOwner.views);
        }
    }

    class KavoshRVAdapter extends RecyclerView.Adapter<RecyclerListView.Holder> {
        Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position;
        }

        public KavoshRVAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerListView.Holder onCreateViewHolder(ViewGroup parent, final int viewType) {
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = AndroidUtilities.dp(24.0f);
            KavoshCell kavoshCell = new KavoshCell(this.context) { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.KavoshRVAdapter.1
                @Override // ir.eitaa.ui.explore.cells.KavoshCell, android.view.View
                protected void onDraw(Canvas canvas) throws InterruptedException, Resources.NotFoundException, IOException {
                    super.onDraw(canvas);
                    int i = this.documentAttachType;
                    if (i == 4 || i == 5) {
                        int i2 = viewType;
                        int measuredHeight = ((BaseFragment) KavoshActivity.this).actionBar.getMeasuredHeight() + AndroidUtilities.dp(8.0f);
                        float imageHeight = getPhotoImage().getImageHeight();
                        int[] iArr = new int[2];
                        getLocationOnScreen(iArr);
                        int i3 = iArr[1] - measuredHeight;
                        if (KavoshActivity.this.appScreenHeight - (KavoshActivity.this.appScreenHeight - i3) <= KavoshActivity.this.appScreenHeight - imageHeight) {
                            KavoshActivity.this.inScreenStates.set(i2, Boolean.TRUE);
                        }
                        if (i3 < 0) {
                            double dAbs = Math.abs(i3);
                            double d = imageHeight;
                            Double.isNaN(d);
                            if (dAbs > d * 0.7d) {
                                KavoshActivity.this.inScreenStates.set(i2, Boolean.FALSE);
                                if (MediaController.getInstance().isPlayingMessage(KavoshActivity.this.selectedMessageForPlaying)) {
                                    KavoshActivity.this.selectedMessageForPlaying = null;
                                }
                            }
                        }
                        if ((i2 != 0 || !((Boolean) KavoshActivity.this.inScreenStates.get(i2)).booleanValue()) && ((Boolean) KavoshActivity.this.inScreenStates.get(i2)).booleanValue() && !((Boolean) KavoshActivity.this.inScreenStates.get(i2 - 1)).booleanValue() && !MediaController.getInstance().isPlayingMessage(this.currentMessageObject) && SharedConfig.shouldPlayWithSound && KavoshActivity.this.selectedMessageForPlaying == null && !KavoshActivity.this.isPhotoViewerOpen) {
                            playVideo(true);
                            Log.e("ViewLocation", "| inScreen: " + KavoshActivity.this.inScreenStates.get(i2) + " | Position: " + i2 + " | Played");
                        }
                        if (((Boolean) KavoshActivity.this.inScreenStates.get(i2)).booleanValue() || !MediaController.getInstance().isPlayingMessage(this.currentMessageObject)) {
                            return;
                        }
                        stopVideo();
                    }
                }
            };
            kavoshCell.setLayoutParams(layoutParams);
            return new RecyclerListView.Holder(kavoshCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerListView.Holder holder, int position) throws Resources.NotFoundException {
            if (holder.getAdapterPosition() == KavoshActivity.this.messages.size() - 1) {
                KavoshActivity.this.search(null);
            }
            int adapterPosition = holder.getAdapterPosition();
            final KavoshCell kavoshCell = (KavoshCell) holder.itemView;
            MessageObject messageObject = (MessageObject) KavoshActivity.this.messages.get(adapterPosition);
            kavoshCell.setDelegate(new KavoshCell.KavoshCellDelegate() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.KavoshRVAdapter.2
                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public boolean canPerformActions() {
                    return true;
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didLongPress(KavoshCell kavoshCell2, float f, float f2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didLongPress(this, kavoshCell2, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ boolean didLongPressChannelAvatar(KavoshCell kavoshCell2, TLRPC$Chat tLRPC$Chat, int i, float f, float f2) {
                    return KavoshCell.KavoshCellDelegate.CC.$default$didLongPressChannelAvatar(this, kavoshCell2, tLRPC$Chat, i, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ boolean didLongPressUserAvatar(KavoshCell kavoshCell2, TLRPC$User tLRPC$User, float f, float f2) {
                    return KavoshCell.KavoshCellDelegate.CC.$default$didLongPressUserAvatar(this, kavoshCell2, tLRPC$User, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressBotButton(KavoshCell kavoshCell2, TLRPC$KeyboardButton tLRPC$KeyboardButton) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressBotButton(this, kavoshCell2, tLRPC$KeyboardButton);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressCancelSendButton(KavoshCell kavoshCell2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressCancelSendButton(this, kavoshCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressCommentButton(KavoshCell kavoshCell2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressCommentButton(this, kavoshCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressHiddenForward(KavoshCell kavoshCell2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressHiddenForward(this, kavoshCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressHint(KavoshCell kavoshCell2, int i) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressHint(this, kavoshCell2, i);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressInstantButton(KavoshCell kavoshCell2, int i) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressInstantButton(this, kavoshCell2, i);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressReaction(KavoshCell kavoshCell2, TLRPC$TL_reactionCount tLRPC$TL_reactionCount) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressReaction(this, kavoshCell2, tLRPC$TL_reactionCount);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressReplyMessage(KavoshCell kavoshCell2, int i) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressReplyMessage(this, kavoshCell2, i);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressSideButton(KavoshCell kavoshCell2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressSideButton(this, kavoshCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressTime(KavoshCell kavoshCell2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressTime(this, kavoshCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressUserAvatar(KavoshCell kavoshCell2, TLRPC$User tLRPC$User, float f, float f2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressUserAvatar(this, kavoshCell2, tLRPC$User, f, f2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didPressVoteButtons(KavoshCell kavoshCell2, ArrayList arrayList, int i, int i2, int i3) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didPressVoteButtons(this, kavoshCell2, arrayList, i, i2, i3);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void didStartVideoStream(MessageObject messageObject2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$didStartVideoStream(this, messageObject2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ String getAdminRank(long j) {
                    return KavoshCell.KavoshCellDelegate.CC.$default$getAdminRank(this, j);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ PinchToZoomHelper getPinchToZoomHelper() {
                    return KavoshCell.KavoshCellDelegate.CC.$default$getPinchToZoomHelper(this);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ TextSelectionHelper.ChatListTextSelectionHelper getTextSelectionHelper() {
                    return KavoshCell.KavoshCellDelegate.CC.$default$getTextSelectionHelper(this);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ boolean isLandscape() {
                    return KavoshCell.KavoshCellDelegate.CC.$default$isLandscape(this);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ boolean keyboardIsOpened() {
                    return KavoshCell.KavoshCellDelegate.CC.$default$keyboardIsOpened(this);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void needOpenWebView(MessageObject messageObject2, String str, String str2, String str3, String str4, int i, int i2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$needOpenWebView(this, messageObject2, str, str2, str3, str4, i, i2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void needReloadPolls() {
                    KavoshCell.KavoshCellDelegate.CC.$default$needReloadPolls(this);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void onDiceFinished() {
                    KavoshCell.KavoshCellDelegate.CC.$default$onDiceFinished(this);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void setShouldNotRepeatSticker(MessageObject messageObject2) {
                    KavoshCell.KavoshCellDelegate.CC.$default$setShouldNotRepeatSticker(this, messageObject2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ boolean shouldDrawThreadProgress(KavoshCell kavoshCell2) {
                    return KavoshCell.KavoshCellDelegate.CC.$default$shouldDrawThreadProgress(this, kavoshCell2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ boolean shouldRepeatSticker(MessageObject messageObject2) {
                    return KavoshCell.KavoshCellDelegate.CC.$default$shouldRepeatSticker(this, messageObject2);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public /* synthetic */ void videoTimerReached() {
                    KavoshCell.KavoshCellDelegate.CC.$default$videoTimerReached(this);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public void didPressVolumeButton(MessageObject messageObject2) {
                    KavoshActivity.this.selectedMessageForPlaying = messageObject2;
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public void didPressChannelAvatar(KavoshCell cell, TLRPC$Chat chat, int postId, float touchX, float touchY) {
                    if (chat != null) {
                        Bundle bundle = new Bundle();
                        bundle.putLong("chat_id", (int) chat.id);
                        if (postId != 0) {
                            bundle.putLong("message_id", postId);
                        }
                        if (MessagesController.getInstance(UserConfig.selectedAccount).checkCanOpenChat(bundle, KavoshActivity.this)) {
                            KavoshActivity.this.presentFragment(new ChatActivity(bundle), false);
                        }
                    }
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public void didPressOther(KavoshCell cell, float otherX, float otherY) {
                    KavoshActivity.this.createMenu(cell.currentMessageObject, cell, otherX, otherY);
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public void didPressForwardButton(MessageObject currentMessageObject) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(kavoshCell.getMessageObject());
                    KavoshActivity.this.showDialog(new ShareAlert(KavoshRVAdapter.this.context, arrayList, null, true, null, false));
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public void didPressUrl(KavoshCell cell, CharacterStyle url, boolean longPress) {
                    String url2;
                    if (url instanceof URLSpanNoUnderline) {
                        url2 = ((URLSpanNoUnderline) url).getURL();
                    } else {
                        url2 = url instanceof URLSpan ? ((URLSpan) url).getURL() : "";
                    }
                    if (url2.startsWith("#")) {
                        KavoshActivity.this.presentFragment(new KavoshActivity(url2));
                    } else if (url2.startsWith("@")) {
                        MessagesController.getInstance(((BaseFragment) KavoshActivity.this).currentAccount).openByUserName(url2.substring(1), KavoshActivity.this, 0);
                    } else {
                        Browser.openUrl(KavoshRVAdapter.this.context, url2);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:44:0x00c1  */
                /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
                /* JADX WARN: Removed duplicated region for block: B:51:0x00db  */
                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void didPressImage(ir.eitaa.ui.explore.cells.KavoshCell r10, float r11, float r12) throws java.lang.InterruptedException, android.content.res.Resources.NotFoundException, java.io.IOException {
                    /*
                        Method dump skipped, instructions count: 304
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.explore.activity.KavoshActivity.KavoshRVAdapter.AnonymousClass2.didPressImage(ir.eitaa.ui.explore.cells.KavoshCell, float, float):void");
                }

                @Override // ir.eitaa.ui.explore.cells.KavoshCell.KavoshCellDelegate
                public boolean needPlayMessage(MessageObject messageObject2) throws IOException {
                    ArrayList<MessageObject> arrayList = new ArrayList<>();
                    arrayList.add(messageObject2);
                    if (messageObject2.isVoice() || messageObject2.isRoundVideo()) {
                        boolean zPlayMessage = MediaController.getInstance().playMessage(messageObject2);
                        MediaController.getInstance().setVoiceMessagesPlaylist(arrayList, false);
                        return zPlayMessage;
                    }
                    if (messageObject2.isMusic()) {
                        return MediaController.getInstance().setPlaylist(arrayList, messageObject2, 0L);
                    }
                    return false;
                }
            });
            messageObject.forceDrawAvatarAndShare = true;
            kavoshCell.setFullyDraw(true);
            kavoshCell.setMessageObject(messageObject, null, false, false);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return KavoshActivity.this.messages.size();
        }
    }

    public void search(final String text) {
        updateLoadingState(true);
        final int i = UserConfig.selectedAccount;
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$KavoshActivity$lvd0dAEc0_z-Jev06Rk0Gjrbb-g
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$search$5$KavoshActivity(text, i);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$5$KavoshActivity(String str, final int i) {
        if (str == null) {
            str = "#ایران";
        }
        TLRPC$TL_messages_searchGlobalExt tLRPC$TL_messages_searchGlobalExt = new TLRPC$TL_messages_searchGlobalExt();
        tLRPC$TL_messages_searchGlobalExt.limit = 20;
        tLRPC$TL_messages_searchGlobalExt.q = str;
        tLRPC$TL_messages_searchGlobalExt.flags = 262144;
        tLRPC$TL_messages_searchGlobalExt.offset_id = 0;
        tLRPC$TL_messages_searchGlobalExt.offset_peer = new TLRPC$TL_inputPeerEmpty();
        new ArrayList();
        ConnectionsManager.getInstance(i).sendRequest(tLRPC$TL_messages_searchGlobalExt, new RequestDelegate() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$KavoshActivity$ZK_P2KYJRsQU3l_LwFPoHltVTJU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$search$4$KavoshActivity(i, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$4$KavoshActivity(int i, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        getParentActivity().runOnUiThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.6
            @Override // java.lang.Runnable
            public void run() {
                KavoshActivity.this.updateLoadingState(false);
            }
        });
        final ArrayList arrayList = new ArrayList();
        if (tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            MessagesController.getInstance(i).putChats(tLRPC$messages_Messages.chats, false);
            MessagesController.getInstance(i).putUsers(tLRPC$messages_Messages.users, false);
            MessagesStorage.getInstance(i).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
            int iMin = Math.min(tLRPC$messages_Messages.chats.size(), tLRPC$messages_Messages.messages.size());
            for (int i2 = 0; i2 < iMin; i2++) {
                arrayList.add(new MessageObject(i, tLRPC$messages_Messages.messages.get(i2), false, true, 2));
            }
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$KavoshActivity$fIMr_TZf6BWQXE5moyUF19Wxkjg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$2$KavoshActivity(tLRPC$TL_error);
                }
            });
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$KavoshActivity$A5Vby34GMglTBlzjl4gLPfp2Y6c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$search$3$KavoshActivity(tLObject, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$2$KavoshActivity(TLRPC$TL_error tLRPC$TL_error) {
        Toast.makeText(getParentActivity(), "Error: " + tLRPC$TL_error.text, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$search$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$search$3$KavoshActivity(TLObject tLObject, ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            MessageObject messageObject = (MessageObject) arrayList.get(i);
            ArrayList<MessageObject> arrayList2 = this.sectionArrays.get(messageObject.monthKey);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList<>();
                this.sectionArrays.put(messageObject.monthKey, arrayList2);
                this.sections.add(messageObject.monthKey);
            }
            arrayList2.add(messageObject);
            this.messages.add(messageObject);
            this.messagesById.put(messageObject.getId(), messageObject);
            this.inScreenStates.add(Boolean.FALSE);
        }
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void createMenu(final MessageObject messageObject, View view, float f, float f2) {
        int y;
        this.selectedObject = messageObject;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        arrayList2.add(LocaleController.getString("ShowInChat", ir.eitaa.messenger.R.string.ShowInChat));
        arrayList3.add(44);
        arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.msg_message));
        arrayList2.add(LocaleController.getString("Save", ir.eitaa.messenger.R.string.Save));
        arrayList3.add(1402);
        arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.menu_saved));
        if (messageObject.type == 0 || messageObject.caption != null) {
            arrayList2.add(LocaleController.getString("Copy", ir.eitaa.messenger.R.string.Copy));
            arrayList3.add(3);
            arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.msg_copy));
        }
        if (messageObject.isMusic()) {
            arrayList2.add(LocaleController.getString("SaveToMusic", ir.eitaa.messenger.R.string.SaveToMusic));
            arrayList3.add(10);
            arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.msg_download));
        } else if (messageObject.isVideo()) {
            if (!messageObject.needDrawBluredPreview()) {
                arrayList2.add(LocaleController.getString("SaveToGallery", ir.eitaa.messenger.R.string.SaveToGallery));
                arrayList3.add(4);
                arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.msg_gallery));
            }
        } else if (messageObject.isDocument() || messageObject.getDocument() != null) {
            arrayList2.add(LocaleController.getString("SaveToDownloads", ir.eitaa.messenger.R.string.SaveToDownloads));
            arrayList3.add(10);
            arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.msg_download));
        }
        if (messageObject.type != 0) {
            arrayList2.add(LocaleController.getString("ShareFile", ir.eitaa.messenger.R.string.ShareFile));
            arrayList3.add(6);
            arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.msg_shareout));
        }
        arrayList2.add(LocaleController.getString("ReportChat", ir.eitaa.messenger.R.string.ReportChat));
        arrayList3.add(23);
        arrayList.add(Integer.valueOf(ir.eitaa.messenger.R.drawable.msg_report));
        this.scrimPaint = new Paint() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.7
            @Override // android.graphics.Paint
            public void setAlpha(int a) {
                super.setAlpha(a);
                if (((BaseFragment) KavoshActivity.this).fragmentView != null) {
                    ((BaseFragment) KavoshActivity.this).fragmentView.invalidate();
                }
            }
        };
        final Rect rect = new Rect();
        ActionBarPopupWindow.ActionBarPopupWindowLayout actionBarPopupWindowLayout = new ActionBarPopupWindow.ActionBarPopupWindowLayout(getParentActivity(), ir.eitaa.messenger.R.drawable.popup_fixed_alert, null);
        actionBarPopupWindowLayout.setMinimumWidth(AndroidUtilities.dp(200.0f));
        Rect rect2 = new Rect();
        getParentActivity().getResources().getDrawable(ir.eitaa.messenger.R.drawable.popup_fixed_alert).mutate().getPadding(rect2);
        actionBarPopupWindowLayout.setBackgroundColor(getThemedColor("actionBarDefaultSubmenuBackground"));
        this.scrimPopupWindowItems = new ActionBarMenuSubItem[arrayList2.size() + (messageObject.isSponsored() ? 1 : 0)];
        int size = arrayList2.size();
        final int i = 0;
        while (i < size) {
            ActionBarMenuSubItem actionBarMenuSubItem = new ActionBarMenuSubItem(getParentActivity(), i == 0, i == size + (-1), (Theme.ResourcesProvider) null);
            actionBarMenuSubItem.setMinimumWidth(AndroidUtilities.dp(200.0f));
            actionBarMenuSubItem.setTextAndIcon((CharSequence) arrayList2.get(i), ((Integer) arrayList.get(i)).intValue());
            this.scrimPopupWindowItems[i] = actionBarMenuSubItem;
            actionBarPopupWindowLayout.addView(actionBarMenuSubItem);
            actionBarMenuSubItem.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$KavoshActivity$kER5K5gzczIgVdHP54joD6vi07c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createMenu$6$KavoshActivity(messageObject, i, arrayList3, view2);
                }
            });
            i++;
        }
        LinearLayout linearLayout = new LinearLayout(getParentActivity()) { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.8
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEvent(KeyEvent event) {
                if (event.getKeyCode() == 4 && event.getRepeatCount() == 0 && KavoshActivity.this.scrimPopupWindow != null && KavoshActivity.this.scrimPopupWindow.isShowing()) {
                    KavoshActivity.this.scrimPopupWindow.dismiss();
                }
                return super.dispatchKeyEvent(event);
            }
        };
        linearLayout.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.9
            private int[] pos = new int[2];

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == 0) {
                    if (KavoshActivity.this.scrimPopupWindow != null && KavoshActivity.this.scrimPopupWindow.isShowing()) {
                        View contentView = KavoshActivity.this.scrimPopupWindow.getContentView();
                        contentView.getLocationInWindow(this.pos);
                        Rect rect3 = rect;
                        int[] iArr = this.pos;
                        rect3.set(iArr[0], iArr[1], iArr[0] + contentView.getMeasuredWidth(), this.pos[1] + contentView.getMeasuredHeight());
                        if (!rect.contains((int) event.getX(), (int) event.getY())) {
                            KavoshActivity.this.scrimPopupWindow.dismiss();
                        }
                    }
                } else if (event.getActionMasked() == 4 && KavoshActivity.this.scrimPopupWindow != null && KavoshActivity.this.scrimPopupWindow.isShowing()) {
                    KavoshActivity.this.scrimPopupWindow.dismiss();
                }
                return false;
            }
        });
        linearLayout.setOrientation(1);
        linearLayout.addView(actionBarPopupWindowLayout, LayoutHelper.createLinear(-1, -2, 0, 0, 0, 0, 0));
        int i2 = -2;
        ActionBarPopupWindow actionBarPopupWindow = new ActionBarPopupWindow(linearLayout, i2, i2) { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.10
            @Override // ir.eitaa.ui.ActionBar.ActionBarPopupWindow, android.widget.PopupWindow
            public void dismiss() {
                super.dismiss();
                if (KavoshActivity.this.scrimPopupWindow != this) {
                    return;
                }
                KavoshActivity.this.scrimPopupWindow = null;
                KavoshActivity.this.scrimPopupWindowItems = null;
                if (KavoshActivity.this.scrimAnimatorSet != null) {
                    KavoshActivity.this.scrimAnimatorSet.cancel();
                    KavoshActivity.this.scrimAnimatorSet = null;
                }
                if (KavoshActivity.this.scrimView instanceof KavoshCell) {
                    ((KavoshCell) KavoshActivity.this.scrimView).setInvalidatesParent(false);
                }
                KavoshActivity.this.scrimAnimatorSet = new AnimatorSet();
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add(ObjectAnimator.ofInt(KavoshActivity.this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0));
                KavoshActivity.this.scrimAnimatorSet.playTogether(arrayList4);
                KavoshActivity.this.scrimAnimatorSet.setDuration(220L);
                KavoshActivity.this.scrimAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.10.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animation) {
                        KavoshActivity.this.scrimView = null;
                        ((BaseFragment) KavoshActivity.this).fragmentView.invalidate();
                        KavoshActivity.this.listView.invalidate();
                    }
                });
                KavoshActivity.this.scrimAnimatorSet.start();
            }
        };
        this.scrimPopupWindow = actionBarPopupWindow;
        actionBarPopupWindow.setPauseNotifications(true);
        this.scrimPopupWindow.setDismissAnimationDuration(220);
        this.scrimPopupWindow.setOutsideTouchable(true);
        this.scrimPopupWindow.setClippingEnabled(true);
        this.scrimPopupWindow.setAnimationStyle(ir.eitaa.messenger.R.style.PopupContextAnimation);
        this.scrimPopupWindow.setFocusable(true);
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(1000.0f), Integer.MIN_VALUE));
        this.scrimPopupWindow.setInputMethodMode(2);
        this.scrimPopupWindow.setSoftInputMode(0);
        this.scrimPopupWindow.getContentView().setFocusableInTouchMode(true);
        actionBarPopupWindowLayout.setFitItems(true);
        int left = (((view.getLeft() + ((int) f)) - linearLayout.getMeasuredWidth()) + rect2.left) - AndroidUtilities.dp(28.0f);
        if (left < AndroidUtilities.dp(6.0f)) {
            left = AndroidUtilities.dp(6.0f);
        } else if (left > (this.listView.getMeasuredWidth() - AndroidUtilities.dp(6.0f)) - linearLayout.getMeasuredWidth()) {
            left = (this.listView.getMeasuredWidth() - AndroidUtilities.dp(6.0f)) - linearLayout.getMeasuredWidth();
        }
        if (AndroidUtilities.isTablet()) {
            int[] iArr = new int[2];
            this.fragmentView.getLocationInWindow(iArr);
            left += iArr[0];
        }
        int height = this.frameLayout.getHeight();
        int measuredHeight = linearLayout.getMeasuredHeight();
        if (measuredHeight < height) {
            y = (int) (this.listView.getY() + view.getTop() + f2);
            if ((measuredHeight - rect2.top) - rect2.bottom > AndroidUtilities.dp(240.0f)) {
                y += AndroidUtilities.dp(240.0f) - measuredHeight;
            }
            if (y < this.listView.getY() + AndroidUtilities.dp(24.0f)) {
                y = (int) (this.listView.getY() + AndroidUtilities.dp(24.0f));
            } else {
                int i3 = height - measuredHeight;
                if (y > i3 - AndroidUtilities.dp(8.0f)) {
                    y = i3 - AndroidUtilities.dp(8.0f);
                }
            }
        } else {
            y = this.inBubbleMode ? 0 : AndroidUtilities.statusBarHeight;
        }
        ActionBarPopupWindow actionBarPopupWindow2 = this.scrimPopupWindow;
        RecyclerView recyclerView = this.listView;
        this.scrimPopupX = left;
        this.scrimPopupY = y;
        actionBarPopupWindow2.showAtLocation(recyclerView, 51, left, y);
        this.listView.stopScroll();
        this.scrimView = view;
        if (view instanceof KavoshCell) {
            ((KavoshCell) view).setInvalidatesParent(true);
        }
        this.frameLayout.invalidate();
        this.listView.invalidate();
        AnimatorSet animatorSet = this.scrimAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.scrimAnimatorSet = new AnimatorSet();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(ObjectAnimator.ofInt(this.scrimPaint, AnimationProperties.PAINT_ALPHA, 0, 50));
        this.scrimAnimatorSet.playTogether(arrayList4);
        this.scrimAnimatorSet.setDuration(150L);
        this.scrimAnimatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createMenu$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createMenu$6$KavoshActivity(MessageObject messageObject, int i, ArrayList arrayList, View view) {
        ActionBarPopupWindow actionBarPopupWindow = this.scrimPopupWindow;
        if (actionBarPopupWindow != null) {
            actionBarPopupWindow.dismiss();
        }
        this.frameLayout.invalidate();
        this.listView.invalidate();
        if (messageObject == null || i >= arrayList.size()) {
            return;
        }
        processSelectedOption(((Integer) arrayList.get(i)).intValue());
    }

    private void processSelectedOption(int option) {
        String string;
        if (this.selectedObject == null || getParentActivity() == null) {
            return;
        }
        boolean zCopyFile = false;
        if (option == 3) {
            if (this.selectedObject.isDice()) {
                AndroidUtilities.addToClipboard(this.selectedObject.getDiceEmoji());
                return;
            }
            MessageObject messageObject = this.selectedObject;
            CharSequence charSequence = messageObject.caption;
            if (charSequence != null) {
                AndroidUtilities.addToClipboard(charSequence);
                return;
            } else {
                AndroidUtilities.addToClipboard(getMessageContent(messageObject, 0L, false));
                return;
            }
        }
        if (option == 4) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && ((i <= 28 || BuildVars.NO_SCOPED_STORAGE) && getParentActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
                getParentActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
                this.selectedObject = null;
                return;
            } else {
                saveMessageToGallery(this.selectedObject);
                if (getParentActivity() != null) {
                    BulletinFactory.createSaveToGalleryBulletin(this, this.selectedObject.isVideo(), null).show();
                    return;
                }
                return;
            }
        }
        if (option == 6) {
            String str = this.selectedObject.messageOwner.attachPath;
            string = (str == null || str.length() <= 0 || new File(str).exists()) ? str : null;
            if (string == null || string.length() == 0) {
                string = FileLoader.getPathToMessage(this.selectedObject.messageOwner).toString();
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(this.selectedObject.getDocument().mime_type);
            File file = new File(string);
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(getParentActivity(), "ir.eitaa.messenger.provider", file));
                    intent.setFlags(1);
                } catch (Exception unused) {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                }
            } else {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            }
            try {
                getParentActivity().startActivityForResult(Intent.createChooser(intent, LocaleController.getString("ShareFile", ir.eitaa.messenger.R.string.ShareFile)), 500);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        if (option == 10) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23 && ((i2 <= 28 || BuildVars.NO_SCOPED_STORAGE) && getParentActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)) {
                getParentActivity().requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 4);
                this.selectedObject = null;
                return;
            }
            final boolean zIsMusic = this.selectedObject.isMusic();
            boolean zIsDocument = this.selectedObject.isDocument();
            if (zIsMusic || zIsDocument) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.selectedObject);
                MediaController.saveFilesFromMessages(getParentActivity(), getAccountInstance(), arrayList, new MessagesStorage.IntCallback() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$KavoshActivity$wpvwU38PlsBjTDPq3pDxRKIXnl8
                    @Override // ir.eitaa.messenger.MessagesStorage.IntCallback
                    public final void run(int i3) {
                        this.f$0.lambda$processSelectedOption$7$KavoshActivity(zIsMusic, i3);
                    }
                });
                return;
            }
            final boolean zIsVideo = this.selectedObject.isVideo();
            final boolean zIsPhoto = this.selectedObject.isPhoto();
            final boolean zIsGif = this.selectedObject.isGif();
            String documentFileName = FileLoader.getDocumentFileName(this.selectedObject.getDocument());
            if (TextUtils.isEmpty(documentFileName)) {
                documentFileName = this.selectedObject.getFileName();
            }
            String str2 = documentFileName;
            String str3 = this.selectedObject.messageOwner.attachPath;
            string = (str3 == null || str3.length() <= 0 || new File(str3).exists()) ? str3 : null;
            MediaController.saveFile((string == null || string.length() == 0) ? FileLoader.getPathToMessage(this.selectedObject.messageOwner).toString() : string, getParentActivity(), 2, str2, this.selectedObject.getDocument() != null ? this.selectedObject.getDocument().mime_type : "", new Runnable() { // from class: ir.eitaa.ui.explore.activity.-$$Lambda$KavoshActivity$5arEKwRxqlVCd9H3Xc4pFJUxNHc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processSelectedOption$8$KavoshActivity(zIsPhoto, zIsVideo, zIsGif);
                }
            });
            return;
        }
        if (option == 23) {
            AlertsCreator.createEitaaReportAlert(getParentActivity(), this.selectedObject.getDialogId(), this.selectedObject.getId(), this, null);
            return;
        }
        if (option == 44) {
            MessageObject messageObject2 = this.selectedObject;
            TLRPC$MessageMedia tLRPC$MessageMedia = messageObject2.messageOwner.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null && !messageObject2.photoThumbs.isEmpty()) {
                TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(this.selectedObject.photoThumbs, AndroidUtilities.photoSize.intValue());
                String attachFileName = FileLoader.getAttachFileName(closestPhotoSizeWithSize);
                File directory = FileLoader.getDirectory(57);
                File file2 = new File(FileLoader.getDirectory(0), attachFileName);
                File file3 = new File(directory, attachFileName);
                if (!file2.exists()) {
                    if (file3.exists()) {
                        try {
                            zCopyFile = AndroidUtilities.copyFile(file3, file2);
                        } catch (IOException unused3) {
                        }
                        if (!zCopyFile) {
                            FileLoader.getInstance(this.currentAccount).loadFile(ImageLocation.getForPhoto(closestPhotoSizeWithSize, this.selectedObject.previousMedia.photo), this.selectedObject, "jpg", 0, 0);
                        }
                    } else {
                        FileLoader.getInstance(this.currentAccount).loadFile(ImageLocation.getForPhoto(closestPhotoSizeWithSize, this.selectedObject.messageOwner.media.photo), this.selectedObject, "jpg", 0, 0);
                    }
                }
            }
            goToChat(this.selectedObject.getDialogId(), this.selectedObject.getId());
            return;
        }
        if (option == 1402 && !this.selectedObject.savedToCloud) {
            ArrayList<MessageObject> arrayList2 = new ArrayList<>();
            arrayList2.add(this.selectedObject);
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(arrayList2, UserConfig.getInstance(this.currentAccount).getClientUserId(), true, false, true, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedOption$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedOption$7$KavoshActivity(boolean z, int i) {
        if (getParentActivity() == null || this.fragmentView == null || i <= 0) {
            return;
        }
        BulletinFactory.of(this).createDownloadBulletin(z ? BulletinFactory.FileType.AUDIOS : BulletinFactory.FileType.UNKNOWNS, i, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$processSelectedOption$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$processSelectedOption$8$KavoshActivity(boolean z, boolean z2, boolean z3) {
        BulletinFactory.FileType fileType;
        if (getParentActivity() == null) {
            return;
        }
        if (z) {
            fileType = BulletinFactory.FileType.PHOTO_TO_DOWNLOADS;
        } else if (z2) {
            fileType = BulletinFactory.FileType.VIDEO_TO_DOWNLOADS;
        } else if (z3) {
            fileType = BulletinFactory.FileType.GIF;
        } else {
            fileType = BulletinFactory.FileType.UNKNOWN;
        }
        BulletinFactory.of(this).createDownloadBulletin(fileType, null).show();
    }

    private void goToChat(long dialog_id, int message_id) {
        TLRPC$Chat chat;
        Bundle bundle = new Bundle();
        long j = dialog_id >> 32;
        if (dialog_id == 0) {
            bundle.putLong("enc_id", j);
        } else if (j == 1) {
            bundle.putLong("chat_id", dialog_id);
        } else if (dialog_id > 0) {
            bundle.putLong("user_id", dialog_id);
        } else if (dialog_id < 0) {
            if (message_id != 0 && (chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-dialog_id))) != null && chat.migrated_to != null) {
                bundle.putLong("migrated_to", dialog_id);
                dialog_id = -chat.migrated_to.channel_id;
            }
            bundle.putLong("chat_id", -dialog_id);
        }
        if (message_id != 0) {
            bundle.putInt("message_id", message_id);
        }
        if (MessagesController.getInstance(this.currentAccount).checkCanOpenChat(bundle, this)) {
            presentFragment(new ChatActivity(bundle));
        }
    }

    private String getMessageContent(MessageObject messageObject, long previousUid, boolean name) {
        TLRPC$Chat chat;
        String str = "";
        if (name) {
            long fromChatId = messageObject.getFromChatId();
            if (previousUid != fromChatId) {
                if (fromChatId > 0) {
                    TLRPC$User user = getMessagesController().getUser(Long.valueOf(fromChatId));
                    if (user != null) {
                        str = ContactsController.formatName(user.first_name, user.last_name) + ":\n";
                    }
                } else if (fromChatId < 0 && (chat = getMessagesController().getChat(Long.valueOf(-fromChatId))) != null) {
                    str = chat.title + ":\n";
                }
            }
        }
        String restrictionReason = MessagesController.getRestrictionReason(messageObject.messageOwner.restriction_reason);
        if (!TextUtils.isEmpty(restrictionReason)) {
            return str + restrictionReason;
        }
        if ((messageObject.type == 0 || messageObject.isAnimatedEmoji()) && messageObject.messageOwner.message != null) {
            return str + messageObject.messageOwner.message;
        }
        TLRPC$Message tLRPC$Message = messageObject.messageOwner;
        if (tLRPC$Message.media != null && tLRPC$Message.message != null) {
            return str + messageObject.messageOwner.message;
        }
        return str + ((Object) messageObject.messageText);
    }

    private void saveMessageToGallery(MessageObject messageObject) {
        String string = messageObject.messageOwner.attachPath;
        if (!TextUtils.isEmpty(string) && !new File(string).exists()) {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            string = FileLoader.getPathToMessage(messageObject.messageOwner).toString();
        }
        MediaController.saveFile(string, getParentActivity(), messageObject.isVideo() ? 1 : 0, null, null);
    }

    @Override // ir.eitaa.ui.DialogsActivity.DialogsActivityDelegate
    public void didSelectDialogs(DialogsActivity fragment, ArrayList<Long> dids, CharSequence message, boolean param) {
        if (this.selectedObject == null) {
            return;
        }
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        arrayList.add(this.selectedObject);
        if (dids.size() > 1 || dids.get(0).longValue() == getUserConfig().getClientUserId() || message != null) {
            for (int i = 0; i < dids.size(); i++) {
                long jLongValue = dids.get(i).longValue();
                if (message != null) {
                    getSendMessagesHelper().sendMessage(message.toString(), jLongValue, null, null, null, true, null, null, null, true, 0, null);
                }
                getSendMessagesHelper().sendMessage(arrayList, jLongValue, false, false, true, 0);
            }
            fragment.finishFragment();
            return;
        }
        long jLongValue2 = dids.get(0).longValue();
        Bundle bundle = new Bundle();
        bundle.putBoolean("scrollToTopOnResume", false);
        if (DialogObject.isEncryptedDialog(jLongValue2)) {
            bundle.putInt("enc_id", DialogObject.getEncryptedChatId(jLongValue2));
        } else {
            if (DialogObject.isUserDialog(jLongValue2)) {
                bundle.putLong("user_id", jLongValue2);
            } else {
                bundle.putLong("chat_id", -jLongValue2);
            }
            if (!getMessagesController().checkCanOpenChat(bundle, fragment)) {
                return;
            }
        }
        ChatActivity chatActivity = new ChatActivity(bundle);
        if (presentFragment(chatActivity, true)) {
            chatActivity.showFieldPanelForForward(true, arrayList);
        } else {
            fragment.finishFragment();
        }
    }

    void openPhotoViewerForMessage(KavoshCell cell, MessageObject message) throws InterruptedException, Resources.NotFoundException, IOException {
        if (cell == null) {
            int childCount = this.listView.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = this.listView.getChildAt(i);
                if (childAt instanceof KavoshCell) {
                    KavoshCell kavoshCell = (KavoshCell) childAt;
                    if (kavoshCell.getMessageObject().equals(message)) {
                        cell = kavoshCell;
                        break;
                    }
                }
                i++;
            }
        }
        PhotoViewer.getInstance().setParentActivity(getParentActivity());
        MessageObject playingMessageObject = MediaController.getInstance().getPlayingMessageObject();
        if (cell != null && playingMessageObject != null && playingMessageObject.isVideo()) {
            getFileLoader().setLoadingVideoForPlayer(playingMessageObject.getDocument(), false);
            MediaController.getInstance().cleanupPlayer(true, true, false, playingMessageObject.equals(message));
        }
        if (MediaController.getInstance().getVideoPlayer() != null) {
            MediaController.getInstance().getVideoPlayer().setMute(false);
        }
        PhotoViewer.getInstance().openPhoto(message, 0L, 0L, this.photoViewerProvider, false);
        PhotoViewer.getInstance().setOnCloseListener(new PhotoViewer.OnPhotoCloseListener() { // from class: ir.eitaa.ui.explore.activity.KavoshActivity.11
            @Override // ir.eitaa.ui.PhotoViewer.OnPhotoCloseListener
            public void onClose() {
                KavoshActivity.this.isPhotoViewerOpen = false;
            }
        });
        MediaController.getInstance().resetGoingToShowMessageObject();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadingState(boolean state) {
        if (state) {
            this.loadingView.setVisibility(0);
            this.listView.setPadding(0, 0, 0, this.loadingView.getMeasuredHeight());
        } else {
            this.loadingView.setVisibility(4);
            this.listView.setPadding(0, 0, 0, 0);
        }
    }
}
