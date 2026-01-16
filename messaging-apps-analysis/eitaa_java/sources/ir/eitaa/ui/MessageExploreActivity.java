package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageLoader;
import ir.eitaa.messenger.ImageLocation;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Ads_Ad;
import ir.eitaa.tgnet.TLRPC$Ads_Location;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$MessageMedia;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_ads_AdPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_getAdsPack;
import ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationTrends;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerEmpty;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto;
import ir.eitaa.tgnet.TLRPC$TL_shop_exploreMessages;
import ir.eitaa.tgnet.TLRPC$messages_Messages;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BackDrawable;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.BubbleFreeMessageCell;
import ir.eitaa.ui.Cells.LoadingCell;
import ir.eitaa.ui.Components.AnimatedFileDrawable;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.Components.ShareAlert;
import ir.eitaa.ui.Components.SimpleAdsList;
import ir.eitaa.ui.Components.VideoPlayer;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class MessageExploreActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private static boolean mutePlay = true;
    private SimpleAdsList adsList;
    private AspectRatioFrameLayout aspectRatioFrameLayout;
    private Animator bufferingAnimation;
    private FrameLayout contentView;
    private int currentType;
    private Runnable delayed;
    private LongSparseArray<MessageObject.GroupedMessages> groupedMessagesMap;
    private boolean keepScreenOnFlagSet;
    private int lastReqId;
    private RecyclerListView listView;
    private boolean loading;
    private ArrayList<MessageObject> messagesObject;
    private int msg_id;
    private ImageView muteIcon;
    private Animator muteIconAnimation;
    private PhotoVideoAdapter photoVideoAdapter;
    private MessageObject playingMessageObject;
    private int selectedMessageId;
    private FrameLayout videoPlayerContainer;
    private TextureView videoTextureView;
    private TextView videoTimeTV;
    private int reqId = 0;
    public ArrayList<Integer> categoriesId = new ArrayList<>();
    private ArrayList<MessageObject> messages = new ArrayList<>();
    private SparseArray<MessageObject> messagesDict = new SparseArray<>();
    private boolean endReached = false;
    private VideoPlayer videoPlayer = null;
    private CountDownLatch syncLatch = null;
    private String adTitle = "";
    private ArrayList<TLRPC$Ads_Ad> loadedAds = new ArrayList<>();
    private boolean cancelFileLoadOnPause = true;
    private Runnable updateVideoProgressRunnable = new Runnable() { // from class: ir.eitaa.ui.MessageExploreActivity.9
        @Override // java.lang.Runnable
        public void run() {
            MessageExploreActivity.this.updateVideoPlayerTime();
            if (MessageExploreActivity.this.playingMessageObject != null) {
                AndroidUtilities.runOnUIThread(MessageExploreActivity.this.updateVideoProgressRunnable, 17L);
            }
        }
    };
    private TLRPC$InputPeer peer = new TLRPC$TL_inputPeerEmpty();

    public MessageExploreActivity(int type, ArrayList<MessageObject> messagesObject, LongSparseArray<MessageObject.GroupedMessages> groupedMessagesMap, int selectedMessageId) {
        this.currentType = 0;
        this.groupedMessagesMap = new LongSparseArray<>();
        this.currentType = type;
        this.messagesObject = messagesObject;
        this.selectedMessageId = selectedMessageId;
        this.groupedMessagesMap = groupedMessagesMap;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didUpdateMessagesViews);
        if (this.currentType == 1) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.mediaDidLoad);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didReceiveNewMessages);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.updateInterfaces);
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messageReceivedByServer);
        }
        ArrayList<MessageObject> arrayList = this.messagesObject;
        if (arrayList != null) {
            if (this.currentType == 0 && arrayList.size() > 0) {
                MessageObject messageObject = this.messagesObject.get(0);
                addMessage(messageObject, true);
                this.msg_id = messageObject.getId();
                this.peer = MessagesController.getInstance(this.currentAccount).getInputPeer((int) messageObject.getDialogId());
            } else if (this.currentType == 1) {
                for (int i = 0; i < this.messagesObject.size(); i++) {
                    addMessage(this.messagesObject.get(i), false);
                }
            }
        }
        if (this.currentType == 0) {
            this.loading = true;
            new Thread(new Runnable() { // from class: ir.eitaa.ui.MessageExploreActivity.1
                @Override // java.lang.Runnable
                public void run() throws InterruptedException {
                    MessageExploreActivity.this.syncLatch = new CountDownLatch(2);
                    MessageExploreActivity.this.loadMessages();
                    MessageExploreActivity.this.loadAds();
                    try {
                        MessageExploreActivity.this.syncLatch.await(60L, TimeUnit.SECONDS);
                    } catch (InterruptedException unused) {
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.MessageExploreActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MessageExploreActivity.this.finishFragment();
                            }
                        });
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.MessageExploreActivity.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MessageExploreActivity.this.photoVideoAdapter != null) {
                                MessageExploreActivity.this.photoVideoAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                }
            }).start();
        }
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didUpdateMessagesViews);
        if (this.currentType == 1) {
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.mediaDidLoad);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didReceiveNewMessages);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.updateInterfaces);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messageReceivedByServer);
        }
        ArrayList<MessageObject> arrayList = this.messages;
        if (arrayList != null) {
            Iterator<MessageObject> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().shortCaption = true;
            }
        }
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        RecyclerListView recyclerListView;
        if (id == NotificationCenter.didUpdateMessagesViews) {
            LongSparseArray longSparseArray = (LongSparseArray) args[0];
            Iterator<MessageObject> it = this.messages.iterator();
            boolean z = false;
            while (it.hasNext()) {
                MessageObject next = it.next();
                SparseIntArray sparseIntArray = (SparseIntArray) longSparseArray.get(next.getDialogId());
                if (sparseIntArray != null) {
                    for (int i = 0; i < sparseIntArray.size(); i++) {
                        int iKeyAt = sparseIntArray.keyAt(i);
                        if (iKeyAt == next.getId()) {
                            int i2 = sparseIntArray.get(iKeyAt);
                            TLRPC$Message tLRPC$Message = next.messageOwner;
                            if (i2 > tLRPC$Message.views) {
                                tLRPC$Message.views = i2;
                                z = true;
                            }
                        }
                    }
                }
            }
            if (z) {
                updateVisibleRows();
                return;
            }
            return;
        }
        if (id == NotificationCenter.mediaDidLoad) {
            ((Long) args[0]).longValue();
            if (((Integer) args[3]).intValue() == this.classGuid && ((Integer) args[4]).intValue() == 0) {
                this.loading = false;
                ArrayList arrayList = (ArrayList) args[2];
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    addMessage((MessageObject) arrayList.get(i3), false);
                }
                this.endReached = ((Boolean) args[5]).booleanValue();
                if (!this.loading && (recyclerListView = this.listView) != null) {
                    recyclerListView.getEmptyView();
                }
                PhotoVideoAdapter photoVideoAdapter = this.photoVideoAdapter;
                if (photoVideoAdapter != null) {
                    photoVideoAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    private void updateVisibleRows() {
        LinearLayoutManager linearLayoutManager;
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView == null || recyclerListView.getLayoutManager() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.listView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager) || (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()) < (iFindFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) || this.listView.isComputingLayout()) {
            return;
        }
        this.photoVideoAdapter.notifyItemRangeChanged(iFindFirstVisibleItemPosition, (iFindLastVisibleItemPosition - iFindFirstVisibleItemPosition) + 1);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws Resources.NotFoundException {
        MessageObject messageObject;
        Theme.createChatResources(context, false);
        this.videoPlayerContainer = null;
        if (this.currentType == 0) {
            this.actionBar.setTitle(LocaleController.getString("Recommended", R.string.Recommended));
        } else {
            this.actionBar.setTitle(LocaleController.getString("Explore", R.string.Explore));
        }
        this.actionBar.setBackButtonDrawable(new BackDrawable(false));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.MessageExploreActivity.2
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    MessageExploreActivity.this.finishFragment();
                } else if (id == 1372) {
                    MessageExploreActivity.this.presentFragment(new TrendsActivity());
                }
            }
        });
        if (this.currentType == 0) {
            this.actionBar.createMenu().addItem(1372, R.drawable.ic_whatshot);
        }
        if (this.inPreviewMode) {
            this.actionBar.setAddToContainer(false);
        }
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.MessageExploreActivity.3
            @Override // android.view.ViewGroup
            protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
                MessageObject messageObject2 = MessageExploreActivity.this.playingMessageObject;
                boolean z = messageObject2 != null && messageObject2.eventId == 0 && messageObject2.isVideo();
                if (child != MessageExploreActivity.this.videoPlayerContainer) {
                    if (z && child == MessageExploreActivity.this.listView && MessageExploreActivity.this.videoPlayerContainer != null && MessageExploreActivity.this.videoPlayerContainer.getTag() != null) {
                        super.drawChild(canvas, MessageExploreActivity.this.videoPlayerContainer, drawingTime);
                    }
                    return super.drawChild(canvas, child, drawingTime);
                }
                if (child.getTag() != null) {
                    return false;
                }
                float translationY = child.getTranslationY();
                child.setTranslationY(-AndroidUtilities.dp(1000.0f));
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                child.setTranslationY(translationY);
                return zDrawChild;
            }
        };
        this.contentView = frameLayout;
        this.fragmentView = frameLayout;
        if (this.inPreviewMode && Build.VERSION.SDK_INT >= 21) {
            frameLayout.setPadding(0, AndroidUtilities.statusBarHeight, 0, 0);
        }
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.photo_placeholder_in);
        this.contentView.addView(imageView, LayoutHelper.createFrame(-1, -1.0f));
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        this.photoVideoAdapter = new PhotoVideoAdapter(context);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.MessageExploreActivity.4
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View child, long drawingTime) {
                boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
                if (child instanceof BubbleFreeMessageCell) {
                    MessageExploreActivity.this.updateVideoPlayerContainerPosition((BubbleFreeMessageCell) child);
                }
                return zDrawChild;
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setBackgroundColor(0);
        this.listView.setItemAnimator(null);
        this.listView.setLayoutAnimation(null);
        this.listView.setClipToPadding(false);
        this.listView.setLayoutManager(linearLayoutManager);
        this.contentView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.photoVideoAdapter);
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.MessageExploreActivity.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int iAbs = iFindFirstVisibleItemPosition == -1 ? 0 : Math.abs(linearLayoutManager.findLastVisibleItemPosition() - iFindFirstVisibleItemPosition) + 1;
                int itemCount = recyclerView.getAdapter().getItemCount();
                if (iAbs != 0 && iFindFirstVisibleItemPosition + iAbs > itemCount - 2 && !MessageExploreActivity.this.loading && !MessageExploreActivity.this.endReached) {
                    MessageExploreActivity.this.loading = true;
                    MessageExploreActivity.this.loadMessages();
                }
                MessageExploreActivity.this.checkVideoPlay(true);
            }
        });
        createTextureView(true);
        if (this.selectedMessageId != 0) {
            for (int i = 0; i < this.photoVideoAdapter.getItemCount(); i++) {
                if ((this.photoVideoAdapter.getItem(i) instanceof MessageObject) && (messageObject = (MessageObject) this.photoVideoAdapter.getItem(i)) != null && messageObject.getId() == this.selectedMessageId) {
                    this.listView.scrollToPosition(i);
                }
            }
        }
        return this.contentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        stopPlayingVideo();
        if (!AndroidUtilities.isTablet()) {
            getParentActivity().setRequestedOrientation(2);
        }
        super.onPause();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (!AndroidUtilities.isTablet()) {
            getParentActivity().setRequestedOrientation(1);
        }
        this.cancelFileLoadOnPause = true;
        checkVideoPlay(false);
    }

    private TextureView createTextureView(boolean add) {
        if (this.parentLayout == null) {
            return null;
        }
        if (this.videoPlayerContainer == null) {
            FrameLayout frameLayout = new FrameLayout(getParentActivity()) { // from class: ir.eitaa.ui.MessageExploreActivity.6
                @Override // android.view.View
                public void setTranslationY(float translationY) {
                    super.setTranslationY(translationY);
                    ((BaseFragment) MessageExploreActivity.this).fragmentView.invalidate();
                }
            };
            this.videoPlayerContainer = frameLayout;
            frameLayout.setWillNotDraw(false);
            AspectRatioFrameLayout aspectRatioFrameLayout = new AspectRatioFrameLayout(getParentActivity());
            this.aspectRatioFrameLayout = aspectRatioFrameLayout;
            aspectRatioFrameLayout.setBackgroundColor(0);
            if (add) {
                this.videoPlayerContainer.addView(this.aspectRatioFrameLayout, LayoutHelper.createFrame(-1, -1, 17));
            }
            TextureView textureView = new TextureView(getParentActivity());
            this.videoTextureView = textureView;
            textureView.setOpaque(false);
            this.aspectRatioFrameLayout.addView(this.videoTextureView, LayoutHelper.createFrame(-1, -1.0f));
            ImageView imageView = new ImageView(getParentActivity());
            this.muteIcon = imageView;
            this.aspectRatioFrameLayout.addView(imageView, LayoutHelper.createFrame(-2, -2.0f, 85, 8.0f, 8.0f, 8.0f, 8.0f));
            TextView textView = new TextView(getParentActivity());
            this.videoTimeTV = textView;
            textView.setTextColor(-1);
            this.videoTimeTV.setShadowLayer(AndroidUtilities.dp(1.0f), 0.0f, 0.0f, -16777216);
            this.aspectRatioFrameLayout.addView(this.videoTimeTV, LayoutHelper.createFrame(-2, -2.0f, LocaleController.isRTL ? 51 : 53, 8.0f, 8.0f, 8.0f, 8.0f));
        }
        ViewGroup viewGroup = (ViewGroup) this.videoPlayerContainer.getParent();
        if (viewGroup != null && viewGroup != this.fragmentView) {
            viewGroup.removeView(this.videoPlayerContainer);
            viewGroup = null;
        }
        if (viewGroup == null) {
            FrameLayout frameLayout2 = this.contentView;
            FrameLayout frameLayout3 = this.videoPlayerContainer;
            int i = AndroidUtilities.roundMessageSize;
            frameLayout2.addView(frameLayout3, 1, new FrameLayout.LayoutParams(i, i));
        }
        this.videoPlayerContainer.setTag(null);
        this.aspectRatioFrameLayout.setDrawingReady(false);
        return this.videoTextureView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkVideoPlay(boolean playWithDelay) {
        boolean z;
        BubbleFreeMessageCell bubbleFreeMessageCell;
        MessageObject messageObject;
        if (this.playingMessageObject != null) {
            int childCount = this.listView.getChildCount();
            boolean z2 = false;
            int i = 0;
            while (true) {
                z = true;
                if (i >= childCount) {
                    z = false;
                    break;
                }
                View childAt = this.listView.getChildAt(i);
                if ((childAt instanceof BubbleFreeMessageCell) && (messageObject = (bubbleFreeMessageCell = (BubbleFreeMessageCell) childAt).getMessageObject()) != null && messageObject == this.playingMessageObject) {
                    ImageReceiver photoImage = bubbleFreeMessageCell.getPhotoImage();
                    int imageHeight = (int) photoImage.getImageHeight();
                    int top = bubbleFreeMessageCell.getTop() + ((int) photoImage.getImageY());
                    if (Math.min(top + imageHeight, this.listView.getHeight()) - Math.max(top, 0) < imageHeight / 3) {
                        z2 = true;
                    }
                } else {
                    i++;
                }
            }
            if (z2 || !z) {
                stopPlayingVideo();
            }
        }
        if (this.playingMessageObject == null) {
            Runnable runnable = this.delayed;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageExploreActivity$BiFkAfrS2FYh0TkrGk50c5Zrk1U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkVideoPlay$0$MessageExploreActivity();
                }
            };
            this.delayed = runnable2;
            if (playWithDelay) {
                AndroidUtilities.runOnUIThread(runnable2, 200L);
            } else {
                runnable2.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkVideoPlay$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkVideoPlay$0$MessageExploreActivity() {
        BubbleFreeMessageCell bubbleFreeMessageCell;
        MessageObject messageObject;
        int childCount = this.listView.getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            View childAt = this.listView.getChildAt(i);
            if ((childAt instanceof BubbleFreeMessageCell) && (messageObject = (bubbleFreeMessageCell = (BubbleFreeMessageCell) childAt).getMessageObject()) != null && messageObject.isVideo()) {
                ImageReceiver photoImage = bubbleFreeMessageCell.getPhotoImage();
                int imageHeight = (int) photoImage.getImageHeight();
                int top = bubbleFreeMessageCell.getTop() + ((int) photoImage.getImageY());
                if (Math.min(top + imageHeight, this.listView.getHeight()) - Math.max(top, 0) >= imageHeight / 3) {
                    Log.v("videoDemo", "play: true");
                    this.playingMessageObject = messageObject;
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (z) {
            playVideo(this.playingMessageObject);
        }
        this.delayed = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoPlayerContainerPosition(BubbleFreeMessageCell messageCell) {
        MessageObject messageObject = messageCell.getMessageObject();
        if (messageObject == null || this.playingMessageObject != messageObject || this.videoPlayerContainer == null) {
            return;
        }
        ImageReceiver photoImage = messageCell.getPhotoImage();
        float imageX = photoImage.getImageX() + messageCell.getX();
        float top = (messageCell.getTop() + photoImage.getImageY()) - 0;
        if (this.videoPlayerContainer.getTranslationX() == imageX && this.videoPlayerContainer.getTranslationY() == top) {
            return;
        }
        Log.v("ExploreActivity", "newX: " + imageX + ", newY: " + top);
        this.videoPlayerContainer.setTranslationX(imageX);
        this.videoPlayerContainer.setTranslationY(top);
        this.fragmentView.invalidate();
        this.videoPlayerContainer.invalidate();
    }

    public void updateTextureViewPosition() {
        boolean z;
        Log.v("ExploreActivity", "updateTextureViewPosition");
        if (this.fragmentView == null) {
            return;
        }
        int childCount = this.listView.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                z = false;
                break;
            }
            View childAt = this.listView.getChildAt(i);
            if (childAt instanceof BubbleFreeMessageCell) {
                BubbleFreeMessageCell bubbleFreeMessageCell = (BubbleFreeMessageCell) childAt;
                MessageObject messageObject = bubbleFreeMessageCell.getMessageObject();
                if (this.videoPlayerContainer != null && messageObject != null && messageObject == this.playingMessageObject) {
                    ImageReceiver photoImage = bubbleFreeMessageCell.getPhotoImage();
                    this.videoPlayerContainer.setTranslationX(photoImage.getImageX() + bubbleFreeMessageCell.getX());
                    this.videoPlayerContainer.setTranslationY(bubbleFreeMessageCell.getTop() + photoImage.getImageY());
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.videoPlayerContainer.getLayoutParams();
                    this.videoPlayerContainer.setTag(R.id.parent_tag, 1);
                    if (layoutParams.width != photoImage.getImageWidth() || layoutParams.height != photoImage.getImageHeight()) {
                        this.aspectRatioFrameLayout.setResizeMode(0);
                        layoutParams.width = (int) photoImage.getImageWidth();
                        layoutParams.height = (int) photoImage.getImageHeight();
                        this.videoPlayerContainer.setLayoutParams(layoutParams);
                    }
                    this.fragmentView.invalidate();
                    this.videoPlayerContainer.invalidate();
                    z = true;
                }
            }
            i++;
        }
        if (this.videoPlayerContainer != null) {
            if (z) {
                setCurrentVideoVisible(true);
                this.listView.invalidate();
            } else {
                setCurrentVideoVisible(false);
                this.videoPlayerContainer.setTranslationY(-1000.0f);
                this.fragmentView.invalidate();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMuteIcon() {
        Animator animator = this.muteIconAnimation;
        if (animator != null) {
            animator.cancel();
        }
        this.muteIcon.setAlpha(1.0f);
        this.muteIcon.setVisibility(0);
        this.muteIcon.setImageResource(mutePlay ? R.drawable.volume_off : R.drawable.volume_on);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.muteIcon, "alpha", 1.0f, 0.0f);
        this.muteIconAnimation = objectAnimatorOfFloat;
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.MessageExploreActivity.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                MessageExploreActivity.this.muteIcon.setVisibility(8);
            }
        });
        this.muteIconAnimation.setDuration(6000L);
        this.muteIconAnimation.start();
    }

    private void stopPlayingVideo() {
        MessageObject messageObject;
        BubbleFreeMessageCell bubbleFreeMessageCell;
        MessageObject messageObject2;
        Bitmap animatedBitmap;
        if (this.keepScreenOnFlagSet) {
            try {
                getParentActivity().getWindow().clearFlags(128);
                this.keepScreenOnFlagSet = false;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        if (this.playingMessageObject == null) {
            return;
        }
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null && this.videoPlayerContainer != null) {
            int childCount = recyclerListView.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = this.listView.getChildAt(i);
                if ((childAt instanceof BubbleFreeMessageCell) && (messageObject2 = (bubbleFreeMessageCell = (BubbleFreeMessageCell) childAt).getMessageObject()) != null && this.playingMessageObject == messageObject2) {
                    bubbleFreeMessageCell.getPhotoImage().setVisible(true, true);
                    AnimatedFileDrawable animation = bubbleFreeMessageCell.getPhotoImage().getAnimation();
                    if (animation != null && (animatedBitmap = animation.getAnimatedBitmap()) != null) {
                        try {
                            Bitmap bitmap = this.videoTextureView.getBitmap(animatedBitmap.getWidth(), animatedBitmap.getHeight());
                            new Canvas(animatedBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                            bitmap.recycle();
                        } catch (Throwable th) {
                            FileLog.e(th);
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        VideoPlayer videoPlayer = this.videoPlayer;
        if (videoPlayer != null) {
            videoPlayer.releasePlayer(false);
            this.videoPlayer = null;
        }
        if (this.cancelFileLoadOnPause && (messageObject = this.playingMessageObject) != null) {
            FileLoader.getInstance(messageObject.currentAccount).cancelLoadFile(this.playingMessageObject.getDocument());
        }
        this.playingMessageObject = null;
        updateTextureViewPosition();
    }

    private void setCurrentVideoVisible(boolean visible) {
        if (visible) {
            AspectRatioFrameLayout aspectRatioFrameLayout = this.aspectRatioFrameLayout;
            if (aspectRatioFrameLayout != null) {
                if (aspectRatioFrameLayout.getParent() == null) {
                    this.videoPlayerContainer.addView(this.aspectRatioFrameLayout);
                }
                VideoPlayer videoPlayer = this.videoPlayer;
                if (videoPlayer != null) {
                    videoPlayer.setTextureView(this.videoTextureView);
                    return;
                }
                return;
            }
            return;
        }
        if (this.aspectRatioFrameLayout.getParent() != null) {
            this.videoPlayerContainer.removeView(this.aspectRatioFrameLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011b  */
    /* JADX WARN: Type inference failed for: r0v26, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r0v3, types: [ir.eitaa.ui.Components.VideoPlayer] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void playVideo(ir.eitaa.messenger.MessageObject r10) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MessageExploreActivity.playVideo(ir.eitaa.messenger.MessageObject):void");
    }

    public void setVideoState(boolean buffering) {
        Animator animator = this.bufferingAnimation;
        if (animator != null) {
            animator.cancel();
        }
        if (buffering) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.videoTimeTV, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setRepeatCount(-1);
            objectAnimatorOfFloat.setRepeatMode(2);
            objectAnimatorOfFloat.setDuration(1000L);
            objectAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            this.bufferingAnimation = objectAnimatorOfFloat;
            objectAnimatorOfFloat.start();
            return;
        }
        this.videoTimeTV.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVideoPlayerTime() {
        long currentPosition;
        MessageObject messageObject;
        VideoPlayer videoPlayer = this.videoPlayer;
        long j = 0;
        if (videoPlayer != null) {
            currentPosition = videoPlayer.getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            }
            long duration = this.videoPlayer.getDuration();
            if (duration >= 0) {
                j = duration;
            }
        } else {
            currentPosition = 0;
        }
        RecyclerListView recyclerListView = this.listView;
        if (recyclerListView != null) {
            int childCount = recyclerListView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.listView.getChildAt(i);
                if ((childAt instanceof BubbleFreeMessageCell) && (messageObject = ((BubbleFreeMessageCell) childAt).getMessageObject()) != null && this.playingMessageObject == messageObject) {
                    long j2 = (j - currentPosition) / 1000;
                    this.videoTimeTV.setText(String.format(Locale.getDefault(), "%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
                }
            }
        }
    }

    private boolean addMessage(MessageObject messageObject, boolean isNew) {
        if (isNew) {
            this.messages.add(0, messageObject);
        } else {
            this.messages.add(messageObject);
        }
        this.messagesDict.put(messageObject.getId(), messageObject);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[PHI: r5
      0x0068: PHI (r5v16 long) = (r5v14 long), (r5v15 long) binds: [B:13:0x0066, B:16:0x006f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadMessages() {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MessageExploreActivity.loadMessages():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessages$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessages$2$MessageExploreActivity(final int i, final TLRPC$TL_shop_exploreMessages tLRPC$TL_shop_exploreMessages, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageExploreActivity$op9k2ADv3vdRtiqFGsSajFKe6iQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadMessages$1$MessageExploreActivity(i, tLRPC$TL_error, tLObject, tLRPC$TL_shop_exploreMessages);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadMessages$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadMessages$1$MessageExploreActivity(int i, TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_shop_exploreMessages tLRPC$TL_shop_exploreMessages) {
        if (i == this.lastReqId && tLRPC$TL_error == null) {
            TLRPC$messages_Messages tLRPC$messages_Messages = (TLRPC$messages_Messages) tLObject;
            MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(tLRPC$messages_Messages.users, tLRPC$messages_Messages.chats, true, true);
            MessagesController.getInstance(this.currentAccount).putUsers(tLRPC$messages_Messages.users, false);
            MessagesController.getInstance(this.currentAccount).putChats(tLRPC$messages_Messages.chats, false);
            int i2 = tLRPC$TL_shop_exploreMessages.offset_id;
            for (int i3 = 0; i3 < tLRPC$messages_Messages.messages.size(); i3++) {
                TLRPC$Message tLRPC$Message = tLRPC$messages_Messages.messages.get(i3);
                addMessage(new MessageObject(this.currentAccount, tLRPC$Message, false, true), false);
                long dialogId = MessageObject.getDialogId(tLRPC$Message);
                ConcurrentHashMap<Long, Integer> concurrentHashMap = tLRPC$Message.out ? MessagesController.getInstance(this.currentAccount).dialogs_read_outbox_max : MessagesController.getInstance(this.currentAccount).dialogs_read_inbox_max;
                Integer numValueOf = (Integer) concurrentHashMap.get(Long.valueOf(dialogId));
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(MessagesStorage.getInstance(this.currentAccount).getDialogReadMax(tLRPC$Message.out, dialogId));
                    concurrentHashMap.put(Long.valueOf(dialogId), numValueOf);
                }
                tLRPC$Message.unread = numValueOf.intValue() < tLRPC$Message.id;
            }
            this.endReached = tLRPC$messages_Messages.messages.size() == 0;
            this.loading = false;
            this.syncLatch.countDown();
        }
        this.reqId = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToChat(long dialog_id, int message_id) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAds() {
        if (this.currentType != 0) {
            return;
        }
        TLRPC$TL_ads_getAdsPack tLRPC$TL_ads_getAdsPack = new TLRPC$TL_ads_getAdsPack();
        TLRPC$Ads_Location tLRPC$Ads_Location = new TLRPC$Ads_Location() { // from class: ir.eitaa.tgnet.TLRPC$TL_ads_inputAdsLocationRecommend
            public static int constructor = -1829372741;

            @Override // ir.eitaa.tgnet.TLObject
            public void serializeToStream(AbstractSerializedData stream) {
                stream.writeInt32(constructor);
            }
        };
        tLRPC$TL_ads_getAdsPack.location = tLRPC$Ads_Location;
        tLRPC$Ads_Location.groupTitle = "";
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_ads_getAdsPack, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$MessageExploreActivity$oBqiGzbFo1MgGdTwFr7KS_1mqiE
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadAds$4$MessageExploreActivity(tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$4$MessageExploreActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$MessageExploreActivity$4imG68fhyOpB91zh6PUVcLM5pSg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAds$3$MessageExploreActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAds$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAds$3$MessageExploreActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_ads_AdPack tLRPC$TL_ads_AdPack = (TLRPC$TL_ads_AdPack) tLObject;
            ArrayList arrayList = new ArrayList();
            Iterator<TLRPC$Ads_Ad> it = tLRPC$TL_ads_AdPack.ads.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            ImageLoader.saveAdsThumbs(arrayList);
            if (arrayList.size() != 0) {
                this.loadedAds.addAll(arrayList);
                this.adTitle = tLRPC$TL_ads_AdPack.title;
            }
            this.syncLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class PhotoVideoAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return true;
        }

        public PhotoVideoAdapter(Context context) {
            this.mContext = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$0$MessageExploreActivity$PhotoVideoAdapter(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
            Browser.performAdAction(this.mContext, tLRPC$Ads_Ad, MessageExploreActivity.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View loadingCell;
            if (viewType == 1) {
                BubbleFreeMessageCell bubbleFreeMessageCell = new BubbleFreeMessageCell(this.mContext);
                if (MessageExploreActivity.this.currentType == 0) {
                    bubbleFreeMessageCell.viewLocationFlags = 1;
                }
                loadingCell = bubbleFreeMessageCell;
            } else if (viewType == 4) {
                MessageExploreActivity.this.adsList = new SimpleAdsList(this.mContext);
                MessageExploreActivity.this.adsList.showCellsAsSquare(true);
                MessageExploreActivity.this.adsList.setDelegate(new SimpleAdsList.Delegate() { // from class: ir.eitaa.ui.-$$Lambda$MessageExploreActivity$PhotoVideoAdapter$cDr-GCalv-nYoXBdx8huMHQT26M
                    @Override // ir.eitaa.ui.Components.SimpleAdsList.Delegate
                    public final void onAdClicked(TLRPC$Ads_Ad tLRPC$Ads_Ad) {
                        this.f$0.lambda$onCreateViewHolder$0$MessageExploreActivity$PhotoVideoAdapter(tLRPC$Ads_Ad);
                    }
                });
                MessageExploreActivity.this.adsList.location = new TLRPC$TL_ads_inputAdsLocationTrends();
                loadingCell = MessageExploreActivity.this.adsList;
                MessageExploreActivity.this.adsList.showAds(MessageExploreActivity.this.loadedAds);
                MessageExploreActivity.this.adsList.setTitle(MessageExploreActivity.this.adTitle);
            } else {
                loadingCell = new LoadingCell(this.mContext);
            }
            return new RecyclerListView.Holder(loadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() == 1) {
                MessageObject messageObject = (MessageObject) getItem(position);
                BubbleFreeMessageCell bubbleFreeMessageCell = (BubbleFreeMessageCell) holder.itemView;
                bubbleFreeMessageCell.setMessageObject(messageObject, MessageExploreActivity.this.groupedMessagesMap != null ? (MessageObject.GroupedMessages) MessageExploreActivity.this.groupedMessagesMap.get(messageObject.getGroupId()) : null);
                if (MessageExploreActivity.this.playingMessageObject == messageObject) {
                    bubbleFreeMessageCell.getPhotoImage().setVisible(false, true);
                }
                bubbleFreeMessageCell.setDelegate(new AnonymousClass1(bubbleFreeMessageCell));
            }
        }

        /* renamed from: ir.eitaa.ui.MessageExploreActivity$PhotoVideoAdapter$1, reason: invalid class name */
        class AnonymousClass1 implements BubbleFreeMessageCell.Delegate {
            final /* synthetic */ BubbleFreeMessageCell val$cell;

            AnonymousClass1(final BubbleFreeMessageCell val$cell) {
                this.val$cell = val$cell;
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didClickedImage(BubbleFreeMessageCell cell) {
                if (cell.getMessageObject() != null) {
                    if (MessageExploreActivity.this.playingMessageObject != null && MessageExploreActivity.this.playingMessageObject.equals(cell.getMessageObject())) {
                        boolean unused = MessageExploreActivity.mutePlay = !MessageExploreActivity.mutePlay;
                        if (MessageExploreActivity.this.videoPlayer != null) {
                            MessageExploreActivity.this.videoPlayer.setMute(MessageExploreActivity.mutePlay);
                        }
                        MessageExploreActivity.this.updateMuteIcon();
                        return;
                    }
                    didClickedViewMessage(cell);
                }
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didClickedAvatar(BubbleFreeMessageCell cell) {
                MessageExploreActivity.this.goToChat(cell.getMessageObject().getDialogId(), 0);
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void didClickedShareOut(ir.eitaa.ui.Cells.BubbleFreeMessageCell r9) {
                /*
                    Method dump skipped, instructions count: 340
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MessageExploreActivity.PhotoVideoAdapter.AnonymousClass1.didClickedShareOut(ir.eitaa.ui.Cells.BubbleFreeMessageCell):void");
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didClickedSave(BubbleFreeMessageCell cell) {
                if (cell.getMessageObject().savedToCloud) {
                    return;
                }
                try {
                    cell.performHapticFeedback(3, 2);
                } catch (Exception unused) {
                }
                ArrayList<MessageObject> arrayList = new ArrayList<>();
                arrayList.add(cell.getMessageObject());
                SendMessagesHelper.getInstance(((BaseFragment) MessageExploreActivity.this).currentAccount).sendMessage(arrayList, UserConfig.getInstance(((BaseFragment) MessageExploreActivity.this).currentAccount).getClientUserId(), true, false, true, 0);
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didClickedPay(BubbleFreeMessageCell cell) {
                Bundle bundle = new Bundle();
                String strHasPayLink = MessageObject.hasPayLink(cell.getMessageObject().messageOwner);
                if (strHasPayLink == null || strHasPayLink.isEmpty()) {
                    return;
                }
                bundle.putString("link", strHasPayLink);
                MessageExploreActivity.this.presentFragment(new PaymentActivity(bundle));
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didClickedViewMessage(BubbleFreeMessageCell cell) {
                boolean zCopyFile = false;
                MessageExploreActivity.this.cancelFileLoadOnPause = false;
                MessageObject messageObject = cell.getMessageObject();
                TLRPC$MessageMedia tLRPC$MessageMedia = messageObject.messageOwner.media;
                if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaPhoto) && tLRPC$MessageMedia.photo != null && !messageObject.photoThumbs.isEmpty()) {
                    TLRPC$PhotoSize closestPhotoSizeWithSize = FileLoader.getClosestPhotoSizeWithSize(messageObject.photoThumbs, AndroidUtilities.photoSize.intValue());
                    String attachFileName = FileLoader.getAttachFileName(closestPhotoSizeWithSize);
                    File directory = FileLoader.getDirectory(57);
                    File file = new File(FileLoader.getDirectory(0), attachFileName);
                    File file2 = new File(directory, attachFileName);
                    if (!file.exists()) {
                        if (!file2.exists()) {
                            FileLoader.getInstance(((BaseFragment) MessageExploreActivity.this).currentAccount).loadFile(ImageLocation.getForPhoto(closestPhotoSizeWithSize, messageObject.messageOwner.media.photo), messageObject, "jpg", 0, 0);
                        } else {
                            try {
                                zCopyFile = AndroidUtilities.copyFile(file2, file);
                            } catch (IOException unused) {
                            }
                            if (!zCopyFile) {
                                FileLoader.getInstance(((BaseFragment) MessageExploreActivity.this).currentAccount).loadFile(ImageLocation.getForPhoto(closestPhotoSizeWithSize, messageObject.previousMedia.photo), messageObject, "jpg", 0, 0);
                            }
                        }
                    }
                }
                MessageExploreActivity.this.goToChat(messageObject.getDialogId(), messageObject.getId());
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didClickedForward(BubbleFreeMessageCell cell) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(cell.getMessageObject());
                MessageExploreActivity.this.showDialog(new ShareAlert(PhotoVideoAdapter.this.mContext, arrayList, null, true, null, false));
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didClickedMenu(BubbleFreeMessageCell cell) {
                ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                final MessageObject messageObject = cell.getMessageObject();
                if (messageObject == null) {
                    return;
                }
                arrayList.add(LocaleController.getString("SaveToGallery", R.string.SaveToGallery));
                arrayList2.add(1);
                arrayList.add(LocaleController.getString("ReportChat", R.string.ReportChat));
                arrayList2.add(23);
                if (arrayList2.isEmpty()) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MessageExploreActivity.this.getParentActivity());
                builder.setItems((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$MessageExploreActivity$PhotoVideoAdapter$1$0PYraiCLeBs7rA4PKejbnz2ohKM
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$didClickedMenu$0$MessageExploreActivity$PhotoVideoAdapter$1(messageObject, arrayList2, dialogInterface, i);
                    }
                });
                builder.setTitle(LocaleController.getString("Message", R.string.Message));
                MessageExploreActivity.this.showDialog(builder.create());
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
            /* renamed from: lambda$didClickedMenu$0, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public /* synthetic */ void lambda$didClickedMenu$0$MessageExploreActivity$PhotoVideoAdapter$1(ir.eitaa.messenger.MessageObject r5, java.util.ArrayList r6, android.content.DialogInterface r7, int r8) {
                /*
                    r4 = this;
                    if (r5 == 0) goto Leb
                    if (r8 < 0) goto Leb
                    int r7 = r6.size()
                    if (r8 < r7) goto Lc
                    goto Leb
                Lc:
                    java.lang.Object r6 = r6.get(r8)
                    java.lang.Integer r6 = (java.lang.Integer) r6
                    int r6 = r6.intValue()
                    r7 = 23
                    r8 = 1
                    if (r6 == r8) goto L38
                    if (r6 == r7) goto L1f
                    goto Leb
                L1f:
                    ir.eitaa.ui.MessageExploreActivity$PhotoVideoAdapter r6 = ir.eitaa.ui.MessageExploreActivity.PhotoVideoAdapter.this
                    ir.eitaa.ui.MessageExploreActivity r6 = ir.eitaa.ui.MessageExploreActivity.this
                    android.app.Activity r6 = r6.getParentActivity()
                    long r7 = r5.getDialogId()
                    int r5 = r5.getId()
                    ir.eitaa.ui.MessageExploreActivity$PhotoVideoAdapter r0 = ir.eitaa.ui.MessageExploreActivity.PhotoVideoAdapter.this
                    ir.eitaa.ui.MessageExploreActivity r0 = ir.eitaa.ui.MessageExploreActivity.this
                    ir.eitaa.ui.Components.AlertsCreator.createEitaaReportAlert(r6, r7, r5, r0)
                    goto Leb
                L38:
                    int r6 = android.os.Build.VERSION.SDK_INT
                    r0 = 0
                    if (r6 < r7) goto L5e
                    ir.eitaa.ui.MessageExploreActivity$PhotoVideoAdapter r6 = ir.eitaa.ui.MessageExploreActivity.PhotoVideoAdapter.this
                    ir.eitaa.ui.MessageExploreActivity r6 = ir.eitaa.ui.MessageExploreActivity.this
                    android.app.Activity r6 = r6.getParentActivity()
                    java.lang.String r7 = "android.permission.WRITE_EXTERNAL_STORAGE"
                    int r6 = r6.checkSelfPermission(r7)
                    if (r6 == 0) goto L5e
                    ir.eitaa.ui.MessageExploreActivity$PhotoVideoAdapter r5 = ir.eitaa.ui.MessageExploreActivity.PhotoVideoAdapter.this
                    ir.eitaa.ui.MessageExploreActivity r5 = ir.eitaa.ui.MessageExploreActivity.this
                    android.app.Activity r5 = r5.getParentActivity()
                    java.lang.String[] r6 = new java.lang.String[r8]
                    r6[r0] = r7
                    r7 = 4
                    r5.requestPermissions(r6, r7)
                    return
                L5e:
                    r5.isVideo()
                    ir.eitaa.tgnet.TLRPC$Message r6 = r5.messageOwner
                    java.lang.String r6 = r6.attachPath
                    boolean r6 = android.text.TextUtils.isEmpty(r6)
                    r7 = 0
                    if (r6 != 0) goto L7b
                    java.io.File r6 = new java.io.File
                    ir.eitaa.tgnet.TLRPC$Message r1 = r5.messageOwner
                    java.lang.String r1 = r1.attachPath
                    r6.<init>(r1)
                    boolean r1 = r6.exists()
                    if (r1 != 0) goto L7c
                L7b:
                    r6 = r7
                L7c:
                    if (r6 != 0) goto L86
                    ir.eitaa.tgnet.TLRPC$Document r6 = r5.getDocument()
                    java.io.File r6 = ir.eitaa.messenger.FileLoader.getPathToAttach(r6)
                L86:
                    boolean r1 = r6.exists()
                    if (r1 != 0) goto Lca
                    ir.eitaa.tgnet.TLRPC$Message r1 = r5.messageOwner
                    ir.eitaa.tgnet.TLRPC$MessageMedia r1 = r1.media
                    boolean r2 = r1 instanceof ir.eitaa.tgnet.TLRPC$TL_messageMediaPhoto
                    if (r2 == 0) goto Lca
                    ir.eitaa.tgnet.TLRPC$Photo r1 = r1.photo
                    java.util.ArrayList<ir.eitaa.tgnet.TLRPC$PhotoSize> r1 = r1.sizes
                    int r2 = r1.size()
                    if (r2 <= 0) goto Lca
                    int r2 = ir.eitaa.messenger.AndroidUtilities.getPhotoSize()
                    ir.eitaa.tgnet.TLRPC$PhotoSize r1 = ir.eitaa.messenger.FileLoader.getClosestPhotoSizeWithSize(r1, r2)
                    if (r1 == 0) goto Lca
                    java.io.File r6 = new java.io.File
                    r2 = 57
                    java.io.File r2 = ir.eitaa.messenger.FileLoader.getDirectory(r2)
                    java.lang.String r3 = ir.eitaa.messenger.FileLoader.getAttachFileName(r1, r7)
                    r6.<init>(r2, r3)
                    boolean r2 = r6.exists()
                    if (r2 != 0) goto Lca
                    java.io.File r6 = new java.io.File
                    java.io.File r2 = ir.eitaa.messenger.FileLoader.getDirectory(r0)
                    java.lang.String r1 = ir.eitaa.messenger.FileLoader.getAttachFileName(r1, r7)
                    r6.<init>(r2, r1)
                Lca:
                    boolean r1 = r6.exists()
                    if (r1 == 0) goto Le8
                    java.lang.String r6 = r6.toString()
                    ir.eitaa.ui.MessageExploreActivity$PhotoVideoAdapter r1 = ir.eitaa.ui.MessageExploreActivity.PhotoVideoAdapter.this
                    ir.eitaa.ui.MessageExploreActivity r1 = ir.eitaa.ui.MessageExploreActivity.this
                    android.app.Activity r1 = r1.getParentActivity()
                    boolean r5 = r5.isVideo()
                    if (r5 == 0) goto Le3
                    goto Le4
                Le3:
                    r8 = 0
                Le4:
                    ir.eitaa.messenger.MediaController.saveFile(r6, r1, r8, r7, r7)
                    goto Leb
                Le8:
                    r4.showDownloadError(r5)
                Leb:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.MessageExploreActivity.PhotoVideoAdapter.AnonymousClass1.lambda$didClickedMenu$0$MessageExploreActivity$PhotoVideoAdapter$1(ir.eitaa.messenger.MessageObject, java.util.ArrayList, android.content.DialogInterface, int):void");
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didSwipedMediaPage(BubbleFreeMessageCell cell, float progress) {
                if (progress == 1.0f) {
                    MessageExploreActivity.this.checkVideoPlay(false);
                }
                MessageExploreActivity.this.updateVideoPlayerContainerPosition(cell);
            }

            @Override // ir.eitaa.ui.Cells.BubbleFreeMessageCell.Delegate
            public void didPressedUrl(BubbleFreeMessageCell cell, String url) {
                if (url.startsWith("#")) {
                    long j = cell.getMessageObject().messageOwner.dialog_id;
                    long j2 = j >> 32;
                    if (j == 0 || j2 == 1) {
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong("chat_id", -j);
                    ChatActivity chatActivity = new ChatActivity(bundle);
                    chatActivity.searchString = url;
                    MessageExploreActivity.this.presentFragment(chatActivity);
                    return;
                }
                if (url.startsWith("@")) {
                    MessagesController.getInstance(((BaseFragment) MessageExploreActivity.this).currentAccount).openByUserName(url.substring(1), MessageExploreActivity.this, 0);
                } else {
                    Browser.openUrl(PhotoVideoAdapter.this.mContext, url);
                }
            }

            private void showDownloadError(MessageObject currentMessageObject) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MessageExploreActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                if (currentMessageObject != null && currentMessageObject.isVideo() && FileLoader.getInstance(currentMessageObject.currentAccount).isLoadingFile(FileLoader.getAttachFileName(this.val$cell.getMessageObject().getDocument()))) {
                    builder.setMessage(LocaleController.getString("PleaseStreamDownload", R.string.PleaseStreamDownload));
                } else {
                    builder.setMessage(LocaleController.getString("PleaseDownload", R.string.PleaseDownload));
                }
                MessageExploreActivity.this.showDialog(builder.create());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object getItem(int position) {
            if (MessageExploreActivity.this.loadedAds.size() != 0) {
                if (MessageExploreActivity.this.messages.isEmpty()) {
                    if (position == 0) {
                        return 4;
                    }
                } else {
                    if (position == 0) {
                        return MessageExploreActivity.this.messages.get(0);
                    }
                    if (position != 1) {
                        if (position > 1 && position < MessageExploreActivity.this.messages.size() + 1) {
                            return MessageExploreActivity.this.messages.get(position - 1);
                        }
                    } else {
                        return 4;
                    }
                }
                return 2;
            }
            if (position < MessageExploreActivity.this.messages.size()) {
                return MessageExploreActivity.this.messages.get(position);
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (MessageExploreActivity.this.loadedAds.size() == 0) {
                return position < MessageExploreActivity.this.messages.size() ? 1 : 2;
            }
            if (MessageExploreActivity.this.messages.isEmpty()) {
                if (position == 0) {
                    return 4;
                }
            } else {
                if (position == 0) {
                    return 1;
                }
                if (position == 1) {
                    return 4;
                }
                if (position > 1 && position < MessageExploreActivity.this.messages.size() + 1) {
                    return 1;
                }
            }
            return 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (((BaseFragment) MessageExploreActivity.this).inPreviewMode) {
                return MessageExploreActivity.this.messages.size();
            }
            int i = 1;
            int size = MessageExploreActivity.this.messages.size() + (MessageExploreActivity.this.loadedAds.size() != 0 ? 1 : 0);
            if (!MessageExploreActivity.this.messages.isEmpty() && MessageExploreActivity.this.endReached) {
                i = 0;
            }
            return size + i;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUBACKGROUND, null, null, null, null, "actionBarDefaultSubmenuBackground"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SUBMENUITEM, null, null, null, null, "actionBarDefaultSubmenuItem"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleFreeMessageCell.class}, Theme.freeBubbleChat_backgroundColorPaint, null, null, "chat_inBubble"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleFreeMessageCell.class}, null, new Drawable[]{Theme.chat_msgInViewsDrawable}, null, "chat_inViews"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleFreeMessageCell.class}, null, new Drawable[]{Theme.dialogs_verifiedCheckDrawable}, null, "chats_verifiedCheck"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleFreeMessageCell.class}, null, new Drawable[]{Theme.dialogs_verifiedDrawable}, null, "chats_verifiedBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{BubbleFreeMessageCell.class}, Theme.messageExplore_namePaint, null, null, "chat_messageLinkIn"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{BubbleFreeMessageCell.class}, Theme.messageExplore_captionPaint, null, null, "chat_messageTextIn"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LINKCOLOR, new Class[]{BubbleFreeMessageCell.class}, Theme.messageExplore_captionPaint, null, null, "chat_messageLinkIn"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleFreeMessageCell.class}, Theme.chat_urlPaint, null, null, "chat_linkSelectBackground"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{BubbleFreeMessageCell.class}, null, null, null, "actionBarDefaultSubmenuItemIcon"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{BubbleFreeMessageCell.class}, Theme.dialogs_timePaint, null, null, "chats_date"));
        return arrayList;
    }
}
