package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.util.Consumer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.AnimationNotificationsLocker;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.DocumentObject;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LiteMode;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MediaDataController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatReactions;
import org.rbmain.tgnet.TLRPC$Reaction;
import org.rbmain.tgnet.TLRPC$TL_availableReaction;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsAll;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsNone;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsSome;
import org.rbmain.tgnet.TLRPC$TL_messageReactions;
import org.rbmain.tgnet.TLRPC$TL_reactionCustomEmoji;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.ListView.AdapterWithDiffUtils;
import org.rbmain.ui.Components.Premium.PremiumLockIconView;
import org.rbmain.ui.Components.Reactions.CustomEmojiReactionsWindow;
import org.rbmain.ui.Components.Reactions.ReactionsEffectOverlay;
import org.rbmain.ui.Components.Reactions.ReactionsLayoutInBubble;
import org.rbmain.ui.Components.ReactionsContainerLayout;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes5.dex */
public class ReactionsContainerLayout extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    public static final Property<ReactionsContainerLayout, Float> TRANSITION_PROGRESS_VALUE = new Property<ReactionsContainerLayout, Float>(Float.class, "transitionProgress") { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.1
        @Override // android.util.Property
        public Float get(ReactionsContainerLayout reactionsContainerLayout) {
            return Float.valueOf(reactionsContainerLayout.transitionProgress);
        }

        @Override // android.util.Property
        public void set(ReactionsContainerLayout reactionsContainerLayout, Float f) {
            reactionsContainerLayout.setTransitionProgress(f.floatValue());
        }
    };
    private boolean allReactionsAvailable;
    private boolean allReactionsIsDefault;
    private List<ReactionsLayoutInBubble.VisibleReaction> allReactionsList;
    private boolean animatePopup;
    private final boolean animationEnabled;
    private Paint bgPaint;
    public int bigCircleOffset;
    private float bigCircleRadius;
    ValueAnimator cancelPressedAnimation;
    private float cancelPressedProgress;
    ChatScrimPopupContainerLayout chatScrimPopupContainerLayout;
    private boolean clicked;
    private int currentAccount;
    private float customEmojiReactionsEnterProgress;
    private InternalImageView customEmojiReactionsIconView;
    FrameLayout customReactionsContainer;
    private ReactionsContainerDelegate delegate;
    public final float durationScale;
    private float flipVerticalProgress;
    BaseFragment fragment;
    private boolean isFlippedVertically;
    long lastReactionSentTime;
    private long lastUpdate;
    HashSet<View> lastVisibleViews;
    HashSet<View> lastVisibleViewsTmp;
    private float leftAlpha;
    private Paint leftShadowPaint;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView.Adapter listAdapter;
    private int[] location;
    private Path mPath;
    private MessageObject messageObject;
    private boolean mirrorX;
    public ReactionHolderView nextRecentReaction;
    final AnimationNotificationsLocker notificationsLocker;
    private float otherViewsScale;
    ChatScrimPopupContainerLayout parentLayout;
    FrameLayout premiumLockContainer;
    private PremiumLockIconView premiumLockIconView;
    private List<TLRPC$TL_availableReaction> premiumLockedReactions;
    private boolean prepareAnimation;
    private float pressedProgress;
    private ReactionsLayoutInBubble.VisibleReaction pressedReaction;
    private int pressedReactionPosition;
    private float pressedViewScale;
    ValueAnimator pullingDownBackAnimator;
    float pullingLeftOffset;
    public float radius;
    CustomEmojiReactionsWindow reactionsWindow;
    public RectF rect;
    public final RecyclerListView recyclerListView;
    Theme.ResourcesProvider resourcesProvider;
    private float rightAlpha;
    private Paint rightShadowPaint;
    private Paint selectedPaint;
    HashSet<ReactionsLayoutInBubble.VisibleReaction> selectedReactions;
    private Drawable shadow;
    private android.graphics.Rect shadowPad;
    boolean skipDraw;
    private float smallCircleRadius;
    private float transitionProgress;
    private List<ReactionsLayoutInBubble.VisibleReaction> visibleReactionsList;
    private long waitingLoadingChatId;

    public interface ReactionsContainerDelegate {
        void onReactionClicked(View view, ReactionsLayoutInBubble.VisibleReaction visibleReaction, boolean z, boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUnlockPremium(float f, float f2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ReactionsContainerLayout(BaseFragment baseFragment, Context context, int i, Theme.ResourcesProvider resourcesProvider) {
        super(context);
        this.bgPaint = new Paint(1);
        this.leftShadowPaint = new Paint(1);
        this.rightShadowPaint = new Paint(1);
        this.transitionProgress = 1.0f;
        this.rect = new RectF();
        this.mPath = new Path();
        this.radius = AndroidUtilities.dp(72.0f);
        float fDp = AndroidUtilities.dp(8.0f);
        this.bigCircleRadius = fDp;
        this.smallCircleRadius = fDp / 2.0f;
        this.bigCircleOffset = AndroidUtilities.dp(36.0f);
        this.visibleReactionsList = new ArrayList(20);
        this.premiumLockedReactions = new ArrayList(10);
        this.allReactionsList = new ArrayList(20);
        this.selectedReactions = new HashSet<>();
        this.location = new int[2];
        this.shadowPad = new android.graphics.Rect();
        new ArrayList();
        this.lastVisibleViews = new HashSet<>();
        this.lastVisibleViewsTmp = new HashSet<>();
        this.notificationsLocker = new AnimationNotificationsLocker();
        this.durationScale = Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        Paint paint = new Paint(1);
        this.selectedPaint = paint;
        paint.setColor(Theme.getColor(Theme.key_listSelector, resourcesProvider));
        this.resourcesProvider = resourcesProvider;
        this.currentAccount = i;
        this.fragment = baseFragment;
        int i2 = 0;
        Object[] objArr = 0;
        ReactionHolderView reactionHolderView = new ReactionHolderView(context, false);
        this.nextRecentReaction = reactionHolderView;
        reactionHolderView.setVisibility(8);
        ReactionHolderView reactionHolderView2 = this.nextRecentReaction;
        reactionHolderView2.touchable = false;
        reactionHolderView2.pressedBackupImageView.setVisibility(8);
        addView(this.nextRecentReaction);
        this.animationEnabled = SharedConfig.animationsEnabled() && SharedConfig.getDevicePerformanceClass() != 0;
        this.shadow = ContextCompat.getDrawable(context, R.drawable.reactions_bubble_shadow).mutate();
        android.graphics.Rect rect = this.shadowPad;
        int iDp = AndroidUtilities.dp(7.0f);
        rect.bottom = iDp;
        rect.right = iDp;
        rect.top = iDp;
        rect.left = iDp;
        this.shadow.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelShadow), PorterDuff.Mode.MULTIPLY));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.2
            @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean drawChild(Canvas canvas, View view, long j) {
                if (ReactionsContainerLayout.this.pressedReaction != null && (view instanceof ReactionHolderView) && ((ReactionHolderView) view).currentReaction.equals(ReactionsContainerLayout.this.pressedReaction)) {
                    return true;
                }
                return super.drawChild(canvas, view, j);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    if (motionEvent.getAction() != 1 || ReactionsContainerLayout.this.getPullingLeftProgress() <= 0.95f) {
                        ReactionsContainerLayout.this.animatePullingBack();
                    } else {
                        ReactionsContainerLayout.this.showCustomEmojiReactionDialog();
                    }
                }
                return super.dispatchTouchEvent(motionEvent);
            }
        };
        this.recyclerListView = recyclerListView;
        recyclerListView.setClipChildren(false);
        recyclerListView.setClipToPadding(false);
        this.linearLayoutManager = new LinearLayoutManager(context, i2, objArr == true ? 1 : 0) { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.3
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public int scrollHorizontallyBy(int i3, RecyclerView.Recycler recycler, RecyclerView.State state) {
                int i4;
                if (i3 < 0) {
                    ReactionsContainerLayout reactionsContainerLayout = ReactionsContainerLayout.this;
                    if (reactionsContainerLayout.pullingLeftOffset != 0.0f) {
                        float pullingLeftProgress = reactionsContainerLayout.getPullingLeftProgress();
                        ReactionsContainerLayout reactionsContainerLayout2 = ReactionsContainerLayout.this;
                        reactionsContainerLayout2.pullingLeftOffset += i3;
                        if ((pullingLeftProgress > 1.0f) != (reactionsContainerLayout2.getPullingLeftProgress() > 1.0f)) {
                            ReactionsContainerLayout.this.recyclerListView.performHapticFeedback(3);
                        }
                        ReactionsContainerLayout reactionsContainerLayout3 = ReactionsContainerLayout.this;
                        float f = reactionsContainerLayout3.pullingLeftOffset;
                        if (f < 0.0f) {
                            i4 = (int) f;
                            reactionsContainerLayout3.pullingLeftOffset = 0.0f;
                        } else {
                            i4 = 0;
                        }
                        FrameLayout frameLayout = reactionsContainerLayout3.customReactionsContainer;
                        if (frameLayout != null) {
                            frameLayout.invalidate();
                        }
                        ReactionsContainerLayout.this.recyclerListView.invalidate();
                        i3 = i4;
                    }
                }
                int iScrollHorizontallyBy = super.scrollHorizontallyBy(i3, recycler, state);
                if (i3 > 0 && iScrollHorizontallyBy == 0 && ReactionsContainerLayout.this.recyclerListView.getScrollState() == 1 && ReactionsContainerLayout.this.showCustomEmojiReaction()) {
                    ValueAnimator valueAnimator = ReactionsContainerLayout.this.pullingDownBackAnimator;
                    if (valueAnimator != null) {
                        valueAnimator.removeAllListeners();
                        ReactionsContainerLayout.this.pullingDownBackAnimator.cancel();
                    }
                    float pullingLeftProgress2 = ReactionsContainerLayout.this.getPullingLeftProgress();
                    float f2 = pullingLeftProgress2 > 1.0f ? 0.05f : 0.6f;
                    ReactionsContainerLayout reactionsContainerLayout4 = ReactionsContainerLayout.this;
                    reactionsContainerLayout4.pullingLeftOffset += i3 * f2;
                    if ((pullingLeftProgress2 > 1.0f) != (reactionsContainerLayout4.getPullingLeftProgress() > 1.0f)) {
                        ReactionsContainerLayout.this.recyclerListView.performHapticFeedback(3);
                    }
                    FrameLayout frameLayout2 = ReactionsContainerLayout.this.customReactionsContainer;
                    if (frameLayout2 != null) {
                        frameLayout2.invalidate();
                    }
                    ReactionsContainerLayout.this.recyclerListView.invalidate();
                }
                return iScrollHorizontallyBy;
            }
        };
        recyclerListView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect rect2, View view, RecyclerView recyclerView, RecyclerView.State state) {
                super.getItemOffsets(rect2, view, recyclerView, state);
                if (!ReactionsContainerLayout.this.showCustomEmojiReaction()) {
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                    if (childAdapterPosition == 0) {
                        rect2.left = AndroidUtilities.dp(6.0f);
                    }
                    rect2.right = AndroidUtilities.dp(4.0f);
                    if (childAdapterPosition == ReactionsContainerLayout.this.listAdapter.getItemCount() - 1) {
                        if (ReactionsContainerLayout.this.showUnlockPremiumButton() || ReactionsContainerLayout.this.showCustomEmojiReaction()) {
                            rect2.right = AndroidUtilities.dp(2.0f);
                            return;
                        } else {
                            rect2.right = AndroidUtilities.dp(6.0f);
                            return;
                        }
                    }
                    return;
                }
                rect2.left = 0;
                rect2.right = 0;
            }
        });
        recyclerListView.setLayoutManager(this.linearLayoutManager);
        recyclerListView.setOverScrollMode(2);
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(context);
        this.listAdapter = anonymousClass5;
        recyclerListView.setAdapter(anonymousClass5);
        recyclerListView.addOnScrollListener(new LeftRightShadowsListener());
        recyclerListView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                if (recyclerView.getChildCount() > 2) {
                    recyclerView.getLocationInWindow(ReactionsContainerLayout.this.location);
                    int i5 = ReactionsContainerLayout.this.location[0];
                    View childAt = recyclerView.getChildAt(0);
                    childAt.getLocationInWindow(ReactionsContainerLayout.this.location);
                    float fMin = ((1.0f - Math.min(1.0f, (-Math.min(ReactionsContainerLayout.this.location[0] - i5, 0.0f)) / childAt.getWidth())) * 0.39999998f) + 0.6f;
                    if (Float.isNaN(fMin)) {
                        fMin = 1.0f;
                    }
                    ReactionsContainerLayout.this.setChildScale(childAt, fMin);
                    View childAt2 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
                    childAt2.getLocationInWindow(ReactionsContainerLayout.this.location);
                    float fMin2 = ((1.0f - Math.min(1.0f, (-Math.min((i5 + recyclerView.getWidth()) - (ReactionsContainerLayout.this.location[0] + childAt2.getWidth()), 0.0f)) / childAt2.getWidth())) * 0.39999998f) + 0.6f;
                    if (Float.isNaN(fMin2)) {
                        fMin2 = 1.0f;
                    }
                    ReactionsContainerLayout.this.setChildScale(childAt2, fMin2);
                }
                for (int i6 = 1; i6 < ReactionsContainerLayout.this.recyclerListView.getChildCount() - 1; i6++) {
                    ReactionsContainerLayout.this.setChildScale(ReactionsContainerLayout.this.recyclerListView.getChildAt(i6), 1.0f);
                }
                ReactionsContainerLayout.this.invalidate();
            }
        });
        recyclerListView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.7
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect rect2, View view, RecyclerView recyclerView, RecyclerView.State state) {
                int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
                if (childAdapterPosition == 0) {
                    rect2.left = AndroidUtilities.dp(8.0f);
                }
                if (childAdapterPosition == ReactionsContainerLayout.this.listAdapter.getItemCount() - 1) {
                    rect2.right = AndroidUtilities.dp(8.0f);
                }
            }
        });
        recyclerListView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$$ExternalSyntheticLambda2
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$new$0(view, i3);
            }
        });
        recyclerListView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$$ExternalSyntheticLambda3
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i3) {
                return this.f$0.lambda$new$1(view, i3);
            }
        });
        addView(recyclerListView, LayoutHelper.createFrame(-1, -1.0f));
        setClipChildren(false);
        setClipToPadding(false);
        invalidateShaders();
        int paddingTop = (recyclerListView.getLayoutParams().height - recyclerListView.getPaddingTop()) - recyclerListView.getPaddingBottom();
        this.nextRecentReaction.getLayoutParams().width = paddingTop - AndroidUtilities.dp(12.0f);
        this.nextRecentReaction.getLayoutParams().height = paddingTop;
        this.bgPaint.setColor(Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground, resourcesProvider));
        MediaDataController.getInstance(i).preloadDefaultReactions();
    }

    /* renamed from: org.rbmain.ui.Components.ReactionsContainerLayout$5, reason: invalid class name */
    class AnonymousClass5 extends AdapterWithDiffUtils {
        ArrayList<InnerItem> items = new ArrayList<>();
        ArrayList<InnerItem> oldItems = new ArrayList<>();
        final /* synthetic */ Context val$context;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        AnonymousClass5(Context context) {
            this.val$context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View reactionHolderView;
            if (i == 1) {
                ReactionsContainerLayout.this.premiumLockContainer = new FrameLayout(this.val$context);
                ReactionsContainerLayout.this.premiumLockIconView = new PremiumLockIconView(this.val$context, PremiumLockIconView.TYPE_REACTIONS);
                ReactionsContainerLayout.this.premiumLockIconView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
                ReactionsContainerLayout.this.premiumLockIconView.setScaleX(0.0f);
                ReactionsContainerLayout.this.premiumLockIconView.setScaleY(0.0f);
                ReactionsContainerLayout.this.premiumLockIconView.setPadding(AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f), AndroidUtilities.dp(1.0f));
                ReactionsContainerLayout reactionsContainerLayout = ReactionsContainerLayout.this;
                reactionsContainerLayout.premiumLockContainer.addView(reactionsContainerLayout.premiumLockIconView, LayoutHelper.createFrame(26, 26, 17));
                ReactionsContainerLayout.this.premiumLockIconView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$5$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0(view);
                    }
                });
                reactionHolderView = ReactionsContainerLayout.this.premiumLockContainer;
            } else if (i != 2) {
                reactionHolderView = ReactionsContainerLayout.this.new ReactionHolderView(this.val$context, true);
            } else {
                ReactionsContainerLayout.this.customReactionsContainer = ReactionsContainerLayout.this.new CustomReactionsContainer(this.val$context);
                ReactionsContainerLayout.this.customEmojiReactionsIconView = ReactionsContainerLayout.this.new InternalImageView(this.val$context);
                ReactionsContainerLayout.this.customEmojiReactionsIconView.setImageResource(R.drawable.msg_reactions_expand);
                ReactionsContainerLayout.this.customEmojiReactionsIconView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ReactionsContainerLayout.this.customEmojiReactionsIconView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
                ReactionsContainerLayout.this.customEmojiReactionsIconView.setBackground(Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(28.0f), 0, ColorUtils.setAlphaComponent(Theme.getColor(Theme.key_listSelector), 40)));
                ReactionsContainerLayout.this.customEmojiReactionsIconView.setPadding(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
                ReactionsContainerLayout.this.customEmojiReactionsIconView.setContentDescription(LocaleController.getString(R.string.AccDescrExpandPanel));
                ReactionsContainerLayout reactionsContainerLayout2 = ReactionsContainerLayout.this;
                reactionsContainerLayout2.customReactionsContainer.addView(reactionsContainerLayout2.customEmojiReactionsIconView, LayoutHelper.createFrame(30, 30, 17));
                ReactionsContainerLayout.this.customEmojiReactionsIconView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$5$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$1(view);
                    }
                });
                reactionHolderView = ReactionsContainerLayout.this.customReactionsContainer;
            }
            int paddingTop = (ReactionsContainerLayout.this.getLayoutParams().height - ReactionsContainerLayout.this.getPaddingTop()) - ReactionsContainerLayout.this.getPaddingBottom();
            reactionHolderView.setLayoutParams(new RecyclerView.LayoutParams(paddingTop - AndroidUtilities.dp(12.0f), paddingTop));
            return new RecyclerListView.Holder(reactionHolderView);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            view.getLocationOnScreen(new int[2]);
            ReactionsContainerLayout.this.showUnlockPremium(r0[0] + (view.getMeasuredWidth() / 2.0f), r0[1] + (view.getMeasuredHeight() / 2.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$1(View view) {
            ReactionsContainerLayout.this.showCustomEmojiReactionDialog();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ReactionHolderView reactionHolderView = (ReactionHolderView) viewHolder.itemView;
                reactionHolderView.setScaleX(1.0f);
                reactionHolderView.setScaleY(1.0f);
                reactionHolderView.setReaction(this.items.get(i).reaction, i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return this.items.get(i).viewType;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            this.oldItems.clear();
            this.oldItems.addAll(this.items);
            this.items.clear();
            for (int i = 0; i < ReactionsContainerLayout.this.visibleReactionsList.size(); i++) {
                this.items.add(new InnerItem(this, 0, (ReactionsLayoutInBubble.VisibleReaction) ReactionsContainerLayout.this.visibleReactionsList.get(i)));
            }
            if (ReactionsContainerLayout.this.showUnlockPremiumButton()) {
                this.items.add(new InnerItem(this, 1, null));
            }
            if (ReactionsContainerLayout.this.showCustomEmojiReaction()) {
                this.items.add(new InnerItem(this, 2, null));
            }
            setItems(this.oldItems, this.items);
        }

        /* renamed from: org.rbmain.ui.Components.ReactionsContainerLayout$5$InnerItem */
        class InnerItem extends AdapterWithDiffUtils.Item {
            ReactionsLayoutInBubble.VisibleReaction reaction;

            public InnerItem(AnonymousClass5 anonymousClass5, int i, ReactionsLayoutInBubble.VisibleReaction visibleReaction) {
                super(i, false);
                this.reaction = visibleReaction;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || InnerItem.class != obj.getClass()) {
                    return false;
                }
                InnerItem innerItem = (InnerItem) obj;
                int i = this.viewType;
                int i2 = innerItem.viewType;
                if (i != i2 || i != 0) {
                    return i == i2;
                }
                ReactionsLayoutInBubble.VisibleReaction visibleReaction = this.reaction;
                return visibleReaction != null && visibleReaction.equals(innerItem.reaction);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i) {
        ReactionsContainerDelegate reactionsContainerDelegate = this.delegate;
        if (reactionsContainerDelegate == null || !(view instanceof ReactionHolderView)) {
            return;
        }
        reactionsContainerDelegate.onReactionClicked(this, ((ReactionHolderView) view).currentReaction, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(View view, int i) {
        ReactionsContainerDelegate reactionsContainerDelegate = this.delegate;
        if (reactionsContainerDelegate == null || !(view instanceof ReactionHolderView)) {
            return false;
        }
        reactionsContainerDelegate.onReactionClicked(this, ((ReactionHolderView) view).currentReaction, true, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animatePullingBack() {
        float f = this.pullingLeftOffset;
        if (f != 0.0f) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
            this.pullingDownBackAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f$0.lambda$animatePullingBack$2(valueAnimator);
                }
            });
            this.pullingDownBackAnimator.setDuration(150L);
            this.pullingDownBackAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animatePullingBack$2(ValueAnimator valueAnimator) {
        this.pullingLeftOffset = ((Float) this.pullingDownBackAnimator.getAnimatedValue()).floatValue();
        FrameLayout frameLayout = this.customReactionsContainer;
        if (frameLayout != null) {
            frameLayout.invalidate();
        }
        invalidate();
    }

    public void dismissWindow() {
        this.reactionsWindow.dismiss();
    }

    public CustomEmojiReactionsWindow getReactionsWindow() {
        return this.reactionsWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCustomEmojiReactionDialog() {
        if (this.reactionsWindow != null) {
            return;
        }
        CustomEmojiReactionsWindow customEmojiReactionsWindow = new CustomEmojiReactionsWindow(this.fragment, this.allReactionsList, this.selectedReactions, this, this.resourcesProvider);
        this.reactionsWindow = customEmojiReactionsWindow;
        customEmojiReactionsWindow.onDismissListener(new Runnable() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showCustomEmojiReactionDialog$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCustomEmojiReactionDialog$3() {
        this.reactionsWindow = null;
    }

    public boolean showCustomEmojiReaction() {
        boolean z = MessagesController.getInstance(this.currentAccount).premiumLocked;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showUnlockPremiumButton() {
        return (this.premiumLockedReactions.isEmpty() || MessagesController.getInstance(this.currentAccount).premiumLocked) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildScale(View view, float f) {
        if (view instanceof ReactionHolderView) {
            ((ReactionHolderView) view).sideScale = f;
        } else {
            view.setScaleX(f);
            view.setScaleY(f);
        }
    }

    public void setDelegate(ReactionsContainerDelegate reactionsContainerDelegate) {
        this.delegate = reactionsContainerDelegate;
    }

    public boolean isFlippedVertically() {
        return this.isFlippedVertically;
    }

    public void setFlippedVertically(boolean z) {
        this.isFlippedVertically = z;
        invalidate();
    }

    public void setMirrorX(boolean z) {
        this.mirrorX = z;
        invalidate();
    }

    private void setVisibleReactionsList(List<ReactionsLayoutInBubble.VisibleReaction> list) {
        this.visibleReactionsList.clear();
        if (showCustomEmojiReaction()) {
            int iDp = (AndroidUtilities.displaySize.x - AndroidUtilities.dp(36.0f)) / AndroidUtilities.dp(34.0f);
            if (iDp > 7) {
                iDp = 7;
            }
            if (iDp < 1) {
                iDp = 1;
            }
            int i = 0;
            while (i < Math.min(list.size(), iDp)) {
                this.visibleReactionsList.add(list.get(i));
                i++;
            }
            if (i < list.size()) {
                this.nextRecentReaction.setReaction(list.get(i), -1);
            }
        } else {
            this.visibleReactionsList.addAll(list);
        }
        this.allReactionsIsDefault = true;
        for (int i2 = 0; i2 < this.visibleReactionsList.size(); i2++) {
            if (this.visibleReactionsList.get(i2).documentId != 0) {
                this.allReactionsIsDefault = false;
            }
        }
        this.allReactionsList.clear();
        this.allReactionsList.addAll(list);
        if (((getLayoutParams().height - getPaddingTop()) - getPaddingBottom()) * list.size() < AndroidUtilities.dp(200.0f)) {
            getLayoutParams().width = -2;
        }
        this.listAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void dispatchDraw(android.graphics.Canvas r20) {
        /*
            Method dump skipped, instructions count: 1211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ReactionsContainerLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    private void drawBubbles(Canvas canvas, float f, float f2, float f3, int i) {
        canvas.save();
        float f4 = this.rect.bottom;
        CubicBezierInterpolator cubicBezierInterpolator = CubicBezierInterpolator.DEFAULT;
        canvas.clipRect(0.0f, AndroidUtilities.lerp(f4, 0.0f, cubicBezierInterpolator.getInterpolation(this.flipVerticalProgress)) - ((int) Math.ceil((this.rect.height() / 2.0f) * (1.0f - this.transitionProgress))), getMeasuredWidth(), AndroidUtilities.lerp(getMeasuredHeight() + AndroidUtilities.dp(8.0f), getPaddingTop() - expandSize(), cubicBezierInterpolator.getInterpolation(this.flipVerticalProgress)));
        float width = (LocaleController.isRTL || this.mirrorX) ? this.bigCircleOffset : getWidth() - this.bigCircleOffset;
        float fLerp = AndroidUtilities.lerp((getHeight() - getPaddingBottom()) + expandSize(), getPaddingTop() - expandSize(), cubicBezierInterpolator.getInterpolation(this.flipVerticalProgress));
        int iDp = AndroidUtilities.dp(3.0f);
        this.shadow.setAlpha(i);
        this.bgPaint.setAlpha(i);
        float f5 = iDp;
        float f6 = f5 * f2;
        this.shadow.setBounds((int) ((width - f) - f6), (int) ((fLerp - f) - f6), (int) (width + f + f6), (int) (fLerp + f + f6));
        this.shadow.draw(canvas);
        canvas.drawCircle(width, fLerp, f, this.bgPaint);
        float width2 = (LocaleController.isRTL || this.mirrorX) ? this.bigCircleOffset - this.bigCircleRadius : (getWidth() - this.bigCircleOffset) + this.bigCircleRadius;
        float fLerp2 = AndroidUtilities.lerp(((getHeight() - this.smallCircleRadius) - f5) + expandSize(), (this.smallCircleRadius + f5) - expandSize(), cubicBezierInterpolator.getInterpolation(this.flipVerticalProgress));
        float f7 = (-AndroidUtilities.dp(1.0f)) * f2;
        this.shadow.setBounds((int) ((width2 - f) - f7), (int) ((fLerp2 - f) - f7), (int) (width2 + f + f7), (int) (f + fLerp2 + f7));
        this.shadow.draw(canvas);
        canvas.drawCircle(width2, fLerp2, f3, this.bgPaint);
        canvas.restore();
        this.shadow.setAlpha(255);
        this.bgPaint.setAlpha(255);
    }

    private void checkPressedProgressForOtherViews(View view) {
        int childAdapterPosition = this.recyclerListView.getChildAdapterPosition(view);
        float measuredWidth = ((view.getMeasuredWidth() * (this.pressedViewScale - 1.0f)) / 3.0f) - ((view.getMeasuredWidth() * (1.0f - this.otherViewsScale)) * (Math.abs(this.pressedReactionPosition - childAdapterPosition) - 1));
        if (childAdapterPosition < this.pressedReactionPosition) {
            view.setPivotX(0.0f);
            view.setTranslationX(-measuredWidth);
        } else {
            view.setPivotX(view.getMeasuredWidth());
            view.setTranslationX(measuredWidth);
        }
        view.setScaleX(this.otherViewsScale);
        view.setScaleY(this.otherViewsScale);
    }

    private void checkPressedProgress(Canvas canvas, ReactionHolderView reactionHolderView) {
        AnimatedEmojiDrawable animatedEmojiDrawable;
        float fClamp = this.pullingLeftOffset != 0.0f ? Utilities.clamp(reactionHolderView.getLeft() / (getMeasuredWidth() - AndroidUtilities.dp(34.0f)), 1.0f, 0.0f) * getPullingLeftProgress() * AndroidUtilities.dp(46.0f) : 0.0f;
        if (reactionHolderView.currentReaction.equals(this.pressedReaction)) {
            BackupImageView backupImageView = reactionHolderView.loopImageView.getVisibility() == 0 ? reactionHolderView.loopImageView : reactionHolderView.enterImageView;
            reactionHolderView.setPivotX(reactionHolderView.getMeasuredWidth() >> 1);
            reactionHolderView.setPivotY(backupImageView.getY() + backupImageView.getMeasuredHeight());
            reactionHolderView.setScaleX(this.pressedViewScale);
            reactionHolderView.setScaleY(this.pressedViewScale);
            if (!this.clicked) {
                if (this.cancelPressedAnimation == null) {
                    reactionHolderView.pressedBackupImageView.setVisibility(0);
                    reactionHolderView.pressedBackupImageView.setAlpha(1.0f);
                    if (reactionHolderView.pressedBackupImageView.getImageReceiver().hasBitmapImage() || ((animatedEmojiDrawable = reactionHolderView.pressedBackupImageView.animatedEmojiDrawable) != null && animatedEmojiDrawable.getImageReceiver() != null && reactionHolderView.pressedBackupImageView.animatedEmojiDrawable.getImageReceiver().hasBitmapImage())) {
                        backupImageView.setAlpha(0.0f);
                    }
                } else {
                    reactionHolderView.pressedBackupImageView.setAlpha(1.0f - this.cancelPressedProgress);
                    backupImageView.setAlpha(this.cancelPressedProgress);
                }
                if (this.pressedProgress == 1.0f) {
                    this.clicked = true;
                    if (System.currentTimeMillis() - this.lastReactionSentTime > 300) {
                        this.lastReactionSentTime = System.currentTimeMillis();
                        this.delegate.onReactionClicked(reactionHolderView, reactionHolderView.currentReaction, true, false);
                    }
                }
            }
            canvas.save();
            float x = this.recyclerListView.getX() + reactionHolderView.getX();
            float measuredWidth = ((reactionHolderView.getMeasuredWidth() * reactionHolderView.getScaleX()) - reactionHolderView.getMeasuredWidth()) / 2.0f;
            float f = x - measuredWidth;
            if (f < 0.0f && reactionHolderView.getTranslationX() >= 0.0f) {
                reactionHolderView.setTranslationX((-f) - fClamp);
            } else if (reactionHolderView.getMeasuredWidth() + x + measuredWidth > getMeasuredWidth() && reactionHolderView.getTranslationX() <= 0.0f) {
                reactionHolderView.setTranslationX((((getMeasuredWidth() - x) - reactionHolderView.getMeasuredWidth()) - measuredWidth) - fClamp);
            } else {
                reactionHolderView.setTranslationX(0.0f - fClamp);
            }
            canvas.translate(this.recyclerListView.getX() + reactionHolderView.getX(), this.recyclerListView.getY() + reactionHolderView.getY());
            canvas.scale(reactionHolderView.getScaleX(), reactionHolderView.getScaleY(), reactionHolderView.getPivotX(), reactionHolderView.getPivotY());
            reactionHolderView.draw(canvas);
            canvas.restore();
            return;
        }
        int childAdapterPosition = this.recyclerListView.getChildAdapterPosition(reactionHolderView);
        float measuredWidth2 = ((reactionHolderView.getMeasuredWidth() * (this.pressedViewScale - 1.0f)) / 3.0f) - ((reactionHolderView.getMeasuredWidth() * (1.0f - this.otherViewsScale)) * (Math.abs(this.pressedReactionPosition - childAdapterPosition) - 1));
        if (childAdapterPosition < this.pressedReactionPosition) {
            reactionHolderView.setPivotX(0.0f);
            reactionHolderView.setTranslationX(-measuredWidth2);
        } else {
            reactionHolderView.setPivotX(reactionHolderView.getMeasuredWidth() - fClamp);
            reactionHolderView.setTranslationX(measuredWidth2 - fClamp);
        }
        reactionHolderView.setPivotY(reactionHolderView.enterImageView.getY() + reactionHolderView.enterImageView.getMeasuredHeight());
        reactionHolderView.setScaleX(this.otherViewsScale);
        reactionHolderView.setScaleY(this.otherViewsScale);
        reactionHolderView.enterImageView.setScaleX(reactionHolderView.sideScale);
        reactionHolderView.enterImageView.setScaleY(reactionHolderView.sideScale);
        reactionHolderView.pressedBackupImageView.setVisibility(4);
        reactionHolderView.enterImageView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getPullingLeftProgress() {
        return Utilities.clamp(this.pullingLeftOffset / AndroidUtilities.dp(42.0f), 2.0f, 0.0f);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        invalidateShaders();
    }

    private void invalidateShaders() {
        int iDp = AndroidUtilities.dp(24.0f);
        float height = getHeight() / 2.0f;
        int color = Theme.getColor(Theme.key_actionBarDefaultSubmenuBackground);
        this.leftShadowPaint.setShader(new LinearGradient(0.0f, height, iDp, height, color, 0, Shader.TileMode.CLAMP));
        this.rightShadowPaint.setShader(new LinearGradient(getWidth(), height, getWidth() - iDp, height, color, 0, Shader.TileMode.CLAMP));
        invalidate();
    }

    public void setTransitionProgress(float f) {
        this.transitionProgress = f;
        ChatScrimPopupContainerLayout chatScrimPopupContainerLayout = this.parentLayout;
        if (chatScrimPopupContainerLayout != null) {
            if (!this.animatePopup || !allowSmoothEnterTransition()) {
                f = 1.0f;
            }
            chatScrimPopupContainerLayout.setReactionsTransitionProgress(f);
        }
        invalidate();
    }

    public void setMessage(MessageObject messageObject, TLRPC$ChatFull tLRPC$ChatFull) {
        this.messageObject = messageObject;
        ArrayList arrayList = new ArrayList();
        if (messageObject.isForwardedChannelPost() && (tLRPC$ChatFull = MessagesController.getInstance(this.currentAccount).getChatFull(-messageObject.getFromChatId())) == null) {
            this.waitingLoadingChatId = -messageObject.getFromChatId();
            MessagesController.getInstance(this.currentAccount).loadFullChat(-messageObject.getFromChatId(), 0, true);
            setVisibility(4);
            return;
        }
        if (tLRPC$ChatFull != null) {
            TLRPC$ChatReactions tLRPC$ChatReactions = tLRPC$ChatFull.available_reactions;
            if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsAll) {
                TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(tLRPC$ChatFull.id));
                if (chat != null && !ChatObject.isChannelAndNotMegaGroup(chat)) {
                    this.allReactionsAvailable = true;
                } else {
                    this.allReactionsAvailable = false;
                }
                fillRecentReactionsList(arrayList);
            } else if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsSome) {
                Iterator<TLRPC$Reaction> it = ((TLRPC$TL_chatReactionsSome) tLRPC$ChatReactions).reactions.iterator();
                while (it.hasNext()) {
                    TLRPC$Reaction next = it.next();
                    Iterator<TLRPC$TL_availableReaction> it2 = MediaDataController.getInstance(this.currentAccount).getEnabledReactionsList().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            TLRPC$TL_availableReaction next2 = it2.next();
                            if ((next instanceof TLRPC$TL_reactionEmoji) && next2.reaction.equals(((TLRPC$TL_reactionEmoji) next).emoticon)) {
                                arrayList.add(ReactionsLayoutInBubble.VisibleReaction.fromTLReaction(next));
                                break;
                            } else if (next instanceof TLRPC$TL_reactionCustomEmoji) {
                                arrayList.add(ReactionsLayoutInBubble.VisibleReaction.fromTLReaction(next));
                                break;
                            }
                        }
                    }
                }
            } else if (BuildVars.DEBUG_PRIVATE_VERSION) {
                throw new RuntimeException("Unknown chat reactions type: " + tLRPC$ChatFull.available_reactions);
            }
        } else {
            this.allReactionsAvailable = true;
            fillRecentReactionsList(arrayList);
        }
        filterReactions(arrayList);
        setVisibleReactionsList(arrayList);
        TLRPC$TL_messageReactions tLRPC$TL_messageReactions = messageObject.messageOwner.reactions;
        if (tLRPC$TL_messageReactions == null || tLRPC$TL_messageReactions.results == null) {
            return;
        }
        for (int i = 0; i < messageObject.messageOwner.reactions.results.size(); i++) {
            if (messageObject.messageOwner.reactions.results.get(i).chosen) {
                this.selectedReactions.add(ReactionsLayoutInBubble.VisibleReaction.fromTLReaction(messageObject.messageOwner.reactions.results.get(i).reaction));
            }
        }
    }

    private void filterReactions(List<ReactionsLayoutInBubble.VisibleReaction> list) {
        HashSet hashSet = new HashSet();
        int i = 0;
        while (i < list.size()) {
            if (hashSet.contains(list.get(i))) {
                i--;
                list.remove(i);
            }
            hashSet.add(list.get(i));
            i++;
        }
    }

    private void fillRecentReactionsList(List<ReactionsLayoutInBubble.VisibleReaction> list) {
        int i = 0;
        if (!this.allReactionsAvailable) {
            List<TLRPC$TL_availableReaction> enabledReactionsList = MediaDataController.getInstance(this.currentAccount).getEnabledReactionsList();
            while (i < enabledReactionsList.size()) {
                list.add(ReactionsLayoutInBubble.VisibleReaction.fromEmojicon(enabledReactionsList.get(i)));
                i++;
            }
            return;
        }
        ArrayList<TLRPC$Reaction> topReactions = MediaDataController.getInstance(this.currentAccount).getTopReactions();
        HashSet hashSet = new HashSet();
        int i2 = 0;
        for (int i3 = 0; i3 < topReactions.size(); i3++) {
            ReactionsLayoutInBubble.VisibleReaction visibleReactionFromTLReaction = ReactionsLayoutInBubble.VisibleReaction.fromTLReaction(topReactions.get(i3));
            if (!hashSet.contains(visibleReactionFromTLReaction) && (UserConfig.getInstance(this.currentAccount).isPremium() || visibleReactionFromTLReaction.documentId == 0)) {
                hashSet.add(visibleReactionFromTLReaction);
                list.add(visibleReactionFromTLReaction);
                i2++;
            }
            if (i2 == 16) {
                break;
            }
        }
        ArrayList<TLRPC$Reaction> recentReactions = MediaDataController.getInstance(this.currentAccount).getRecentReactions();
        for (int i4 = 0; i4 < recentReactions.size(); i4++) {
            ReactionsLayoutInBubble.VisibleReaction visibleReactionFromTLReaction2 = ReactionsLayoutInBubble.VisibleReaction.fromTLReaction(recentReactions.get(i4));
            if (!hashSet.contains(visibleReactionFromTLReaction2)) {
                hashSet.add(visibleReactionFromTLReaction2);
                list.add(visibleReactionFromTLReaction2);
            }
        }
        List<TLRPC$TL_availableReaction> enabledReactionsList2 = MediaDataController.getInstance(this.currentAccount).getEnabledReactionsList();
        while (i < enabledReactionsList2.size()) {
            ReactionsLayoutInBubble.VisibleReaction visibleReactionFromEmojicon = ReactionsLayoutInBubble.VisibleReaction.fromEmojicon(enabledReactionsList2.get(i));
            if (!hashSet.contains(visibleReactionFromEmojicon)) {
                hashSet.add(visibleReactionFromEmojicon);
                list.add(visibleReactionFromEmojicon);
            }
            i++;
        }
    }

    public void startEnterAnimation(boolean z) {
        ObjectAnimator duration;
        this.animatePopup = z;
        setTransitionProgress(0.0f);
        setAlpha(1.0f);
        this.notificationsLocker.lock();
        if (allowSmoothEnterTransition()) {
            duration = ObjectAnimator.ofFloat(this, TRANSITION_PROGRESS_VALUE, 0.0f, 1.0f).setDuration(250L);
            duration.setInterpolator(new OvershootInterpolator(0.5f));
        } else {
            duration = ObjectAnimator.ofFloat(this, TRANSITION_PROGRESS_VALUE, 0.0f, 1.0f).setDuration(250L);
            duration.setInterpolator(new OvershootInterpolator(0.5f));
        }
        duration.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ReactionsContainerLayout.this.notificationsLocker.unlock();
            }
        });
        duration.start();
    }

    public int getTotalWidth() {
        int itemsCount = getItemsCount();
        if (!showCustomEmojiReaction()) {
            return (AndroidUtilities.dp(36.0f) * itemsCount) + (AndroidUtilities.dp(2.0f) * (itemsCount - 1)) + AndroidUtilities.dp(16.0f);
        }
        return (AndroidUtilities.dp(36.0f) * itemsCount) - AndroidUtilities.dp(4.0f);
    }

    public int getItemsCount() {
        return this.visibleReactionsList.size() + (showCustomEmojiReaction() ? 1 : 0) + 1;
    }

    public void setCustomEmojiEnterProgress(float f) {
        this.customEmojiReactionsEnterProgress = f;
        ChatScrimPopupContainerLayout chatScrimPopupContainerLayout = this.chatScrimPopupContainerLayout;
        if (chatScrimPopupContainerLayout != null) {
            chatScrimPopupContainerLayout.setPopupAlpha(1.0f - f);
        }
        invalidate();
    }

    public void dismissParent(boolean z) {
        CustomEmojiReactionsWindow customEmojiReactionsWindow = this.reactionsWindow;
        if (customEmojiReactionsWindow != null) {
            customEmojiReactionsWindow.dismiss(z);
            this.reactionsWindow = null;
        }
    }

    public void prepareAnimation(boolean z) {
        this.prepareAnimation = z;
        invalidate();
    }

    public void setSkipDraw(boolean z) {
        if (this.skipDraw != z) {
            this.skipDraw = z;
            if (!z) {
                for (int i = 0; i < this.recyclerListView.getChildCount(); i++) {
                    if (this.recyclerListView.getChildAt(i) instanceof ReactionHolderView) {
                        ReactionHolderView reactionHolderView = (ReactionHolderView) this.recyclerListView.getChildAt(i);
                        if (reactionHolderView.hasEnterAnimation && (reactionHolderView.loopImageView.getImageReceiver().getLottieAnimation() != null || reactionHolderView.loopImageView.getImageReceiver().getAnimation() != null)) {
                            reactionHolderView.loopImageView.setVisibility(0);
                            reactionHolderView.enterImageView.setVisibility(4);
                            if (reactionHolderView.shouldSwitchToLoopView) {
                                reactionHolderView.switchedToLoopView = true;
                            }
                        }
                        reactionHolderView.invalidate();
                    }
                }
            }
            invalidate();
        }
    }

    public void onCustomEmojiWindowOpened() {
        animatePullingBack();
    }

    public void setChatScrimView(ChatScrimPopupContainerLayout chatScrimPopupContainerLayout) {
        this.chatScrimPopupContainerLayout = chatScrimPopupContainerLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class LeftRightShadowsListener extends RecyclerView.OnScrollListener {
        private ValueAnimator leftAnimator;
        private boolean leftVisible;
        private ValueAnimator rightAnimator;
        private boolean rightVisible;

        private LeftRightShadowsListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            boolean z = ReactionsContainerLayout.this.linearLayoutManager.findFirstVisibleItemPosition() != 0;
            if (z != this.leftVisible) {
                ValueAnimator valueAnimator = this.leftAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.leftAnimator = startAnimator(ReactionsContainerLayout.this.leftAlpha, z ? 1.0f : 0.0f, new Consumer() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$LeftRightShadowsListener$$ExternalSyntheticLambda1
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        this.f$0.lambda$onScrolled$0((Float) obj);
                    }
                }, new Runnable() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$LeftRightShadowsListener$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onScrolled$1();
                    }
                });
                this.leftVisible = z;
            }
            boolean z2 = ReactionsContainerLayout.this.linearLayoutManager.findLastVisibleItemPosition() != ReactionsContainerLayout.this.listAdapter.getItemCount() - 1;
            if (z2 != this.rightVisible) {
                ValueAnimator valueAnimator2 = this.rightAnimator;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                this.rightAnimator = startAnimator(ReactionsContainerLayout.this.rightAlpha, z2 ? 1.0f : 0.0f, new Consumer() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$LeftRightShadowsListener$$ExternalSyntheticLambda2
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        this.f$0.lambda$onScrolled$2((Float) obj);
                    }
                }, new Runnable() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$LeftRightShadowsListener$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onScrolled$3();
                    }
                });
                this.rightVisible = z2;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScrolled$0(Float f) {
            ReactionsContainerLayout.this.leftShadowPaint.setAlpha((int) (ReactionsContainerLayout.this.leftAlpha = f.floatValue() * 255.0f));
            ReactionsContainerLayout.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScrolled$1() {
            this.leftAnimator = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScrolled$2(Float f) {
            ReactionsContainerLayout.this.rightShadowPaint.setAlpha((int) (ReactionsContainerLayout.this.rightAlpha = f.floatValue() * 255.0f));
            ReactionsContainerLayout.this.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onScrolled$3() {
            this.rightAnimator = null;
        }

        private ValueAnimator startAnimator(float f, float f2, final Consumer<Float> consumer, final Runnable runnable) {
            ValueAnimator duration = ValueAnimator.ofFloat(f, f2).setDuration((long) (Math.abs(f2 - f) * 150.0f));
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$LeftRightShadowsListener$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ReactionsContainerLayout.LeftRightShadowsListener.lambda$startAnimator$4(consumer, valueAnimator);
                }
            });
            duration.addListener(new AnimatorListenerAdapter(this) { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.LeftRightShadowsListener.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    runnable.run();
                }
            });
            duration.start();
            return duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$startAnimator$4(Consumer consumer, ValueAnimator valueAnimator) {
            consumer.accept((Float) valueAnimator.getAnimatedValue());
        }
    }

    public final class ReactionHolderView extends FrameLayout {
        public ReactionsLayoutInBubble.VisibleReaction currentReaction;
        public boolean drawSelected;
        public BackupImageView enterImageView;
        public boolean hasEnterAnimation;
        private boolean isEnter;
        Runnable longPressRunnable;
        public BackupImageView loopImageView;
        Runnable playRunnable;
        public int position;
        private ImageReceiver preloadImageReceiver;
        boolean pressed;
        public BackupImageView pressedBackupImageView;
        float pressedX;
        float pressedY;
        public boolean selected;
        public boolean shouldSwitchToLoopView;
        public float sideScale;
        public boolean switchedToLoopView;
        boolean touchable;
        public boolean waitingAnimation;

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            ReactionsLayoutInBubble.VisibleReaction visibleReaction = this.currentReaction;
            if (visibleReaction != null) {
                String str = visibleReaction.emojicon;
                if (str != null) {
                    accessibilityNodeInfo.setText(str);
                    accessibilityNodeInfo.setEnabled(true);
                } else {
                    accessibilityNodeInfo.setText(LocaleController.getString(R.string.AccDescrCustomEmoji));
                    accessibilityNodeInfo.setEnabled(true);
                }
            }
        }

        ReactionHolderView(Context context, boolean z) {
            super(context);
            this.preloadImageReceiver = new ImageReceiver();
            this.sideScale = 1.0f;
            this.drawSelected = true;
            this.playRunnable = new Runnable() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.ReactionHolderView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ReactionHolderView.this.enterImageView.getImageReceiver().getLottieAnimation() != null && !ReactionHolderView.this.enterImageView.getImageReceiver().getLottieAnimation().isRunning() && !ReactionHolderView.this.enterImageView.getImageReceiver().getLottieAnimation().isGeneratingCache()) {
                        ReactionHolderView.this.enterImageView.getImageReceiver().getLottieAnimation().start();
                    }
                    ReactionHolderView.this.waitingAnimation = false;
                }
            };
            this.longPressRunnable = new Runnable() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.ReactionHolderView.4
                @Override // java.lang.Runnable
                public void run() {
                    ReactionHolderView.this.performHapticFeedback(0);
                    ReactionsContainerLayout reactionsContainerLayout = ReactionsContainerLayout.this;
                    reactionsContainerLayout.pressedReactionPosition = reactionsContainerLayout.visibleReactionsList.indexOf(ReactionHolderView.this.currentReaction);
                    ReactionHolderView reactionHolderView = ReactionHolderView.this;
                    ReactionsContainerLayout.this.pressedReaction = reactionHolderView.currentReaction;
                    ReactionsContainerLayout.this.invalidate();
                }
            };
            this.touchable = true;
            this.enterImageView = new AnonymousClass2(context, ReactionsContainerLayout.this);
            this.loopImageView = new BackupImageView(context);
            this.enterImageView.getImageReceiver().setAutoRepeat(0);
            this.enterImageView.getImageReceiver().setAllowStartLottieAnimation(false);
            this.pressedBackupImageView = new BackupImageView(context, ReactionsContainerLayout.this) { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.ReactionHolderView.3
                @Override // android.view.View
                public void invalidate() {
                    super.invalidate();
                    ReactionsContainerLayout.this.invalidate();
                }
            };
            addView(this.enterImageView, LayoutHelper.createFrame(34, 34, 17));
            addView(this.pressedBackupImageView, LayoutHelper.createFrame(34, 34, 17));
            addView(this.loopImageView, LayoutHelper.createFrame(34, 34, 17));
            this.enterImageView.setLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
            this.loopImageView.setLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
            this.pressedBackupImageView.setLayerNum(ConnectionsManager.DEFAULT_DATACENTER_ID);
        }

        /* renamed from: org.rbmain.ui.Components.ReactionsContainerLayout$ReactionHolderView$2, reason: invalid class name */
        class AnonymousClass2 extends BackupImageView {
            AnonymousClass2(Context context, ReactionsContainerLayout reactionsContainerLayout) {
                super(context);
            }

            @Override // android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                if (this.imageReceiver.getLottieAnimation() != null && !ReactionHolderView.this.waitingAnimation) {
                    this.imageReceiver.getLottieAnimation().start();
                }
                ReactionHolderView reactionHolderView = ReactionHolderView.this;
                if (reactionHolderView.shouldSwitchToLoopView && !reactionHolderView.switchedToLoopView && this.imageReceiver.getLottieAnimation() != null && this.imageReceiver.getLottieAnimation().isLastFrame() && ReactionHolderView.this.loopImageView.imageReceiver.getLottieAnimation() != null && ReactionHolderView.this.loopImageView.imageReceiver.getLottieAnimation().hasBitmap()) {
                    ReactionHolderView reactionHolderView2 = ReactionHolderView.this;
                    reactionHolderView2.switchedToLoopView = true;
                    reactionHolderView2.loopImageView.imageReceiver.getLottieAnimation().setCurrentFrame(0, false, true);
                    ReactionHolderView.this.loopImageView.setVisibility(0);
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$ReactionHolderView$2$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$dispatchDraw$0();
                        }
                    });
                }
                invalidate();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$dispatchDraw$0() {
                ReactionHolderView.this.enterImageView.setVisibility(4);
            }

            @Override // android.view.View
            public void invalidate() {
                super.invalidate();
                ReactionsContainerLayout.this.invalidate();
            }

            @Override // android.view.View
            public void invalidate(android.graphics.Rect rect) {
                super.invalidate(rect);
                ReactionsContainerLayout.this.invalidate();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReaction(ReactionsLayoutInBubble.VisibleReaction visibleReaction, int i) {
            ReactionsLayoutInBubble.VisibleReaction visibleReaction2 = this.currentReaction;
            if (visibleReaction2 != null && visibleReaction2.equals(visibleReaction)) {
                updateImage(visibleReaction);
                return;
            }
            this.position = i;
            resetAnimation();
            this.currentReaction = visibleReaction;
            this.selected = ReactionsContainerLayout.this.selectedReactions.contains(visibleReaction);
            this.hasEnterAnimation = this.currentReaction.emojicon != null && (ReactionsContainerLayout.this.showCustomEmojiReaction() || ReactionsContainerLayout.this.allReactionsIsDefault) && LiteMode.isEnabled(LiteMode.FLAG_ANIMATED_EMOJI_REACTIONS);
            if (this.currentReaction.emojicon != null) {
                updateImage(visibleReaction);
                this.pressedBackupImageView.setAnimatedEmojiDrawable(null);
                if (this.enterImageView.getImageReceiver().getLottieAnimation() != null) {
                    this.enterImageView.getImageReceiver().getLottieAnimation().setCurrentFrame(0, false);
                }
            } else {
                this.pressedBackupImageView.getImageReceiver().clearImage();
                this.loopImageView.getImageReceiver().clearImage();
                AnimatedEmojiDrawable animatedEmojiDrawable = new AnimatedEmojiDrawable(4, ReactionsContainerLayout.this.currentAccount, this.currentReaction.documentId);
                animatedEmojiDrawable.setColorFilter(Theme.chat_animatedEmojiTextColorFilter);
                this.pressedBackupImageView.setAnimatedEmojiDrawable(animatedEmojiDrawable);
                AnimatedEmojiDrawable animatedEmojiDrawable2 = new AnimatedEmojiDrawable(3, ReactionsContainerLayout.this.currentAccount, this.currentReaction.documentId);
                animatedEmojiDrawable2.setColorFilter(Theme.chat_animatedEmojiTextColorFilter);
                this.loopImageView.setAnimatedEmojiDrawable(animatedEmojiDrawable2);
            }
            setFocusable(true);
            this.shouldSwitchToLoopView = this.hasEnterAnimation && ReactionsContainerLayout.this.showCustomEmojiReaction();
            if (!this.hasEnterAnimation) {
                this.enterImageView.setVisibility(8);
                this.loopImageView.setVisibility(0);
                this.switchedToLoopView = true;
            } else {
                this.switchedToLoopView = false;
                this.enterImageView.setVisibility(0);
                this.loopImageView.setVisibility(8);
            }
            if (this.selected) {
                ViewGroup.LayoutParams layoutParams = this.loopImageView.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = this.loopImageView.getLayoutParams();
                int iDp = AndroidUtilities.dp(26.0f);
                layoutParams2.height = iDp;
                layoutParams.width = iDp;
                ViewGroup.LayoutParams layoutParams3 = this.enterImageView.getLayoutParams();
                ViewGroup.LayoutParams layoutParams4 = this.enterImageView.getLayoutParams();
                int iDp2 = AndroidUtilities.dp(26.0f);
                layoutParams4.height = iDp2;
                layoutParams3.width = iDp2;
                return;
            }
            ViewGroup.LayoutParams layoutParams5 = this.loopImageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams6 = this.loopImageView.getLayoutParams();
            int iDp3 = AndroidUtilities.dp(34.0f);
            layoutParams6.height = iDp3;
            layoutParams5.width = iDp3;
            ViewGroup.LayoutParams layoutParams7 = this.enterImageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams8 = this.enterImageView.getLayoutParams();
            int iDp4 = AndroidUtilities.dp(34.0f);
            layoutParams8.height = iDp4;
            layoutParams7.width = iDp4;
        }

        private void updateImage(ReactionsLayoutInBubble.VisibleReaction visibleReaction) {
            TLRPC$TL_availableReaction tLRPC$TL_availableReaction;
            if (this.currentReaction.emojicon == null || (tLRPC$TL_availableReaction = MediaDataController.getInstance(ReactionsContainerLayout.this.currentAccount).getReactionsMap().get(this.currentReaction.emojicon)) == null) {
                return;
            }
            SvgHelper.SvgDrawable svgThumb = DocumentObject.getSvgThumb(tLRPC$TL_availableReaction.activate_animation, Theme.key_windowBackgroundWhiteGrayIcon, 0.2f);
            if (!LiteMode.isEnabled(LiteMode.FLAG_ANIMATED_EMOJI_REACTIONS)) {
                if (SharedConfig.getDevicePerformanceClass() <= 0) {
                    this.loopImageView.getImageReceiver().setImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.select_animation), "60_60_pcache", null, null, this.hasEnterAnimation ? null : Emoji.getEmojiDrawable(visibleReaction.emojicon), 0L, "tgs", this.currentReaction, 0);
                } else {
                    this.enterImageView.getImageReceiver().setImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.appear_animation), "30_30_nolimit", null, null, Emoji.getEmojiDrawable(visibleReaction.emojicon), 0L, "tgs", visibleReaction, 0);
                    this.loopImageView.getImageReceiver().setImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.select_animation), "60_60_pcache", null, null, this.hasEnterAnimation ? null : Emoji.getEmojiDrawable(visibleReaction.emojicon), 0L, "tgs", this.currentReaction, 0);
                }
            } else {
                this.enterImageView.getImageReceiver().setImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.appear_animation), "30_30_nolimit", null, null, Emoji.getEmojiDrawable(visibleReaction.emojicon), 0L, "tgs", visibleReaction, 0);
                this.loopImageView.getImageReceiver().setImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.select_animation), "60_60_pcache", null, null, this.hasEnterAnimation ? null : Emoji.getEmojiDrawable(visibleReaction.emojicon), 0L, "tgs", this.currentReaction, 0);
            }
            this.pressedBackupImageView.getImageReceiver().setImage(ImageLocation.getForDocument(tLRPC$TL_availableReaction.select_animation), "60_60_pcache", null, null, svgThumb, 0L, "tgs", visibleReaction, 0);
            this.preloadImageReceiver.setAllowStartLottieAnimation(false);
            MediaDataController.getInstance(ReactionsContainerLayout.this.currentAccount).preloadImage(this.preloadImageReceiver, ImageLocation.getForDocument(tLRPC$TL_availableReaction.around_animation), ReactionsEffectOverlay.getFilterForAroundAnimation());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            resetAnimation();
            this.preloadImageReceiver.onAttachedToWindow();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.preloadImageReceiver.onDetachedFromWindow();
        }

        public boolean play(int i) {
            if (!ReactionsContainerLayout.this.animationEnabled) {
                resetAnimation();
                this.isEnter = true;
                if (!this.hasEnterAnimation) {
                    this.loopImageView.setVisibility(0);
                    this.loopImageView.setScaleY(1.0f);
                    this.loopImageView.setScaleX(1.0f);
                }
                return false;
            }
            AndroidUtilities.cancelRunOnUIThread(this.playRunnable);
            if (this.hasEnterAnimation) {
                if (this.enterImageView.getImageReceiver().getLottieAnimation() != null && !this.enterImageView.getImageReceiver().getLottieAnimation().isGeneratingCache() && !this.isEnter) {
                    this.isEnter = true;
                    if (i == 0) {
                        this.waitingAnimation = false;
                        this.enterImageView.getImageReceiver().getLottieAnimation().stop();
                        this.enterImageView.getImageReceiver().getLottieAnimation().setCurrentFrame(0, false);
                        this.playRunnable.run();
                    } else {
                        this.waitingAnimation = true;
                        this.enterImageView.getImageReceiver().getLottieAnimation().stop();
                        this.enterImageView.getImageReceiver().getLottieAnimation().setCurrentFrame(0, false);
                        AndroidUtilities.runOnUIThread(this.playRunnable, i);
                    }
                    return true;
                }
                if (this.enterImageView.getImageReceiver().getLottieAnimation() != null && this.isEnter && !this.enterImageView.getImageReceiver().getLottieAnimation().isRunning() && !this.enterImageView.getImageReceiver().getLottieAnimation().isGeneratingCache()) {
                    this.enterImageView.getImageReceiver().getLottieAnimation().setCurrentFrame(this.enterImageView.getImageReceiver().getLottieAnimation().getFramesCount() - 1, false);
                }
                this.loopImageView.setScaleY(1.0f);
                this.loopImageView.setScaleX(1.0f);
            } else if (!this.isEnter) {
                this.loopImageView.setScaleY(0.0f);
                this.loopImageView.setScaleX(0.0f);
                this.loopImageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(150L).setStartDelay((long) (i * ReactionsContainerLayout.this.durationScale)).start();
                this.isEnter = true;
            }
            return false;
        }

        public void resetAnimation() {
            if (this.hasEnterAnimation) {
                AndroidUtilities.cancelRunOnUIThread(this.playRunnable);
                if (this.enterImageView.getImageReceiver().getLottieAnimation() != null && !this.enterImageView.getImageReceiver().getLottieAnimation().isGeneratingCache()) {
                    this.enterImageView.getImageReceiver().getLottieAnimation().stop();
                    if (ReactionsContainerLayout.this.animationEnabled) {
                        this.enterImageView.getImageReceiver().getLottieAnimation().setCurrentFrame(0, false, true);
                    } else {
                        this.enterImageView.getImageReceiver().getLottieAnimation().setCurrentFrame(this.enterImageView.getImageReceiver().getLottieAnimation().getFramesCount() - 1, false, true);
                    }
                }
                this.loopImageView.setVisibility(4);
                this.enterImageView.setVisibility(0);
                this.switchedToLoopView = false;
                this.loopImageView.setScaleY(1.0f);
                this.loopImageView.setScaleX(1.0f);
            } else {
                this.loopImageView.animate().cancel();
                this.loopImageView.setScaleY(0.0f);
                this.loopImageView.setScaleX(0.0f);
            }
            this.isEnter = false;
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!this.touchable || ReactionsContainerLayout.this.cancelPressedAnimation != null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.pressed = true;
                this.pressedX = motionEvent.getX();
                this.pressedY = motionEvent.getY();
                if (this.sideScale == 1.0f) {
                    AndroidUtilities.runOnUIThread(this.longPressRunnable, ViewConfiguration.getLongPressTimeout());
                }
            }
            float scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2.0f;
            if ((motionEvent.getAction() == 2 && (Math.abs(this.pressedX - motionEvent.getX()) > scaledTouchSlop || Math.abs(this.pressedY - motionEvent.getY()) > scaledTouchSlop)) || motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                if (motionEvent.getAction() == 1 && this.pressed && ((ReactionsContainerLayout.this.pressedReaction == null || ReactionsContainerLayout.this.pressedProgress > 0.8f) && ReactionsContainerLayout.this.delegate != null)) {
                    ReactionsContainerLayout.this.clicked = true;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ReactionsContainerLayout reactionsContainerLayout = ReactionsContainerLayout.this;
                    if (jCurrentTimeMillis - reactionsContainerLayout.lastReactionSentTime > 300) {
                        reactionsContainerLayout.lastReactionSentTime = System.currentTimeMillis();
                        ReactionsContainerLayout.this.delegate.onReactionClicked(this, this.currentReaction, ReactionsContainerLayout.this.pressedProgress > 0.8f, false);
                    }
                }
                if (!ReactionsContainerLayout.this.clicked) {
                    ReactionsContainerLayout.this.cancelPressed();
                }
                AndroidUtilities.cancelRunOnUIThread(this.longPressRunnable);
                this.pressed = false;
            }
            return true;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (this.selected && this.drawSelected) {
                canvas.drawCircle(getMeasuredWidth() >> 1, getMeasuredHeight() >> 1, (getMeasuredWidth() >> 1) - AndroidUtilities.dp(1.0f), ReactionsContainerLayout.this.selectedPaint);
            }
            AnimatedEmojiDrawable animatedEmojiDrawable = this.loopImageView.animatedEmojiDrawable;
            if (animatedEmojiDrawable != null && animatedEmojiDrawable.getImageReceiver() != null) {
                if (this.position == 0) {
                    this.loopImageView.animatedEmojiDrawable.getImageReceiver().setRoundRadius(AndroidUtilities.dp(6.0f), 0, 0, AndroidUtilities.dp(6.0f));
                } else {
                    this.loopImageView.animatedEmojiDrawable.getImageReceiver().setRoundRadius(this.selected ? AndroidUtilities.dp(6.0f) : 0);
                }
            }
            super.dispatchDraw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelPressed() {
        if (this.pressedReaction != null) {
            this.cancelPressedProgress = 0.0f;
            final float f = this.pressedProgress;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.cancelPressedAnimation = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.9
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ReactionsContainerLayout.this.cancelPressedProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ReactionsContainerLayout reactionsContainerLayout = ReactionsContainerLayout.this;
                    reactionsContainerLayout.pressedProgress = f * (1.0f - reactionsContainerLayout.cancelPressedProgress);
                    ReactionsContainerLayout.this.invalidate();
                }
            });
            this.cancelPressedAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout.10
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ReactionsContainerLayout reactionsContainerLayout = ReactionsContainerLayout.this;
                    reactionsContainerLayout.cancelPressedAnimation = null;
                    reactionsContainerLayout.pressedProgress = 0.0f;
                    ReactionsContainerLayout.this.pressedReaction = null;
                    ReactionsContainerLayout.this.invalidate();
                }
            });
            this.cancelPressedAnimation.setDuration(150L);
            this.cancelPressedAnimation.setInterpolator(CubicBezierInterpolator.DEFAULT);
            this.cancelPressedAnimation.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.chatInfoDidLoad);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.chatInfoDidLoad);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.chatInfoDidLoad) {
            TLRPC$ChatFull tLRPC$ChatFull = (TLRPC$ChatFull) objArr[0];
            if (tLRPC$ChatFull.id != this.waitingLoadingChatId || getVisibility() == 0 || (tLRPC$ChatFull.available_reactions instanceof TLRPC$TL_chatReactionsNone)) {
                return;
            }
            setMessage(this.messageObject, null);
            setVisibility(0);
            startEnterAnimation(false);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getAlpha() < 0.5f) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        if (getAlpha() != f && f == 0.0f) {
            this.lastVisibleViews.clear();
            for (int i = 0; i < this.recyclerListView.getChildCount(); i++) {
                if (this.recyclerListView.getChildAt(i) instanceof ReactionHolderView) {
                    ((ReactionHolderView) this.recyclerListView.getChildAt(i)).resetAnimation();
                }
            }
        }
        super.setAlpha(f);
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        if (f != getTranslationX()) {
            super.setTranslationX(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class InternalImageView extends ImageView {
        ValueAnimator valueAnimator;

        public InternalImageView(Context context) {
            super(context);
        }

        public void play(int i, boolean z) {
            invalidate();
            ValueAnimator valueAnimator = this.valueAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllListeners();
                this.valueAnimator.cancel();
            }
            if (z) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getScaleX(), 1.0f);
                this.valueAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setInterpolator(AndroidUtilities.overshootInterpolator);
                this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ReactionsContainerLayout$InternalImageView$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$play$0(valueAnimator2);
                    }
                });
                this.valueAnimator.setStartDelay((long) (i * ReactionsContainerLayout.this.durationScale));
                this.valueAnimator.setDuration(300L);
                this.valueAnimator.start();
                return;
            }
            setScaleX(1.0f);
            setScaleY(1.0f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$play$0(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            setScaleX(fFloatValue);
            setScaleY(fFloatValue);
            ReactionsContainerLayout.this.customReactionsContainer.invalidate();
        }

        public void resetAnimation() {
            setScaleX(0.0f);
            setScaleY(0.0f);
            ReactionsContainerLayout.this.customReactionsContainer.invalidate();
            ValueAnimator valueAnimator = this.valueAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
        }
    }

    private class CustomReactionsContainer extends FrameLayout {
        Paint backgroundPaint;

        public CustomReactionsContainer(Context context) {
            super(context);
            this.backgroundPaint = new Paint(1);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            super.dispatchDraw(canvas);
            this.backgroundPaint.setColor(ColorUtils.blendARGB(Theme.getColor(Theme.key_actionBarDefaultSubmenuItemIcon, ReactionsContainerLayout.this.resourcesProvider), Theme.getColor(Theme.key_dialogBackground, ReactionsContainerLayout.this.resourcesProvider), 0.7f));
            float measuredHeight = getMeasuredHeight() / 2.0f;
            float measuredWidth = getMeasuredWidth() / 2.0f;
            View childAt = getChildAt(0);
            float measuredWidth2 = (getMeasuredWidth() - AndroidUtilities.dpf2(6.0f)) / 2.0f;
            float fExpandSize = ReactionsContainerLayout.this.expandSize();
            RectF rectF = AndroidUtilities.rectTmp;
            rectF.set(measuredWidth - measuredWidth2, (measuredHeight - measuredWidth2) - fExpandSize, measuredWidth + measuredWidth2, measuredHeight + measuredWidth2 + fExpandSize);
            canvas.save();
            canvas.scale(childAt.getScaleX(), childAt.getScaleY(), measuredWidth, measuredHeight);
            canvas.drawRoundRect(rectF, measuredWidth2, measuredWidth2, this.backgroundPaint);
            canvas.restore();
            canvas.save();
            canvas.translate(0.0f, fExpandSize);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public float expandSize() {
        return (int) (getPullingLeftProgress() * AndroidUtilities.dp(6.0f));
    }

    public void setParentLayout(ChatScrimPopupContainerLayout chatScrimPopupContainerLayout) {
        this.parentLayout = chatScrimPopupContainerLayout;
    }

    public static boolean allowSmoothEnterTransition() {
        return SharedConfig.deviceIsHigh();
    }
}
