package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeAudio;
import ir.eitaa.tgnet.TLRPC$TL_documentAttributeFilename;
import ir.eitaa.tgnet.TLRPC$TL_message;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaDocument;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.SharedAudioCell;
import ir.eitaa.ui.Components.ChatAttachAlert;
import ir.eitaa.ui.Components.RecyclerListView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ChatAttachAlertAudioLayout extends ChatAttachAlert.AttachAlertLayout implements NotificationCenter.NotificationCenterDelegate {
    private ArrayList<MediaController.AudioEntry> audioEntries;
    private View currentEmptyView;
    private float currentPanTranslationProgress;
    private AudioSelectDelegate delegate;
    private ImageView emptyImageView;
    private TextView emptySubtitleTextView;
    private TextView emptyTitleTextView;
    private LinearLayout emptyView;
    private FrameLayout frameLayout;
    private boolean ignoreLayout;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private boolean loadingAudio;
    private int maxSelectedFiles;
    private MessageObject playingAudio;
    private EmptyTextProgressView progressView;
    private SearchAdapter searchAdapter;
    private SearchField searchField;
    private LongSparseArray<MediaController.AudioEntry> selectedAudios;
    private ArrayList<MediaController.AudioEntry> selectedAudiosOrder;
    private boolean sendPressed;
    private View shadow;
    private AnimatorSet shadowAnimation;

    public interface AudioSelectDelegate {
        void didSelectAudio(ArrayList<MessageObject> audios, CharSequence caption, boolean notify, int scheduleDate);
    }

    static /* synthetic */ boolean lambda$new$0(View view, MotionEvent motionEvent) {
        return true;
    }

    public ChatAttachAlertAudioLayout(ChatAttachAlert alert, Context context, Theme.ResourcesProvider resourcesProvider) {
        super(alert, context, resourcesProvider);
        this.maxSelectedFiles = -1;
        this.audioEntries = new ArrayList<>();
        this.selectedAudiosOrder = new ArrayList<>();
        this.selectedAudios = new LongSparseArray<>();
        NotificationCenter.getInstance(this.parentAlert.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.parentAlert.currentAccount).addObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.parentAlert.currentAccount).addObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
        loadAudio();
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        frameLayout.setBackgroundColor(getThemedColor("dialogBackground"));
        SearchField searchField = new SearchField(context, false, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.1
            @Override // ir.eitaa.ui.Components.SearchField
            public void onTextChange(String text) {
                if (text.length() == 0 && ChatAttachAlertAudioLayout.this.listView.getAdapter() != ChatAttachAlertAudioLayout.this.listAdapter) {
                    ChatAttachAlertAudioLayout.this.listView.setAdapter(ChatAttachAlertAudioLayout.this.listAdapter);
                    ChatAttachAlertAudioLayout.this.listAdapter.notifyDataSetChanged();
                }
                if (ChatAttachAlertAudioLayout.this.searchAdapter != null) {
                    ChatAttachAlertAudioLayout.this.searchAdapter.search(text);
                }
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                ChatAttachAlertAudioLayout.this.parentAlert.makeFocusable(getSearchEditText(), true);
                return super.onInterceptTouchEvent(ev);
            }

            @Override // ir.eitaa.ui.Components.SearchField
            public void processTouchEvent(MotionEvent event) {
                MotionEvent motionEventObtain = MotionEvent.obtain(event);
                motionEventObtain.setLocation(motionEventObtain.getRawX(), (motionEventObtain.getRawY() - ChatAttachAlertAudioLayout.this.parentAlert.getSheetContainer().getTranslationY()) - AndroidUtilities.dp(58.0f));
                ChatAttachAlertAudioLayout.this.listView.dispatchTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }

            @Override // ir.eitaa.ui.Components.SearchField
            protected void onFieldTouchUp(EditTextBoldCursor editText) {
                ChatAttachAlertAudioLayout.this.parentAlert.makeFocusable(editText, true);
            }
        };
        this.searchField = searchField;
        searchField.setHint(LocaleController.getString("SearchMusic", R.string.SearchMusic));
        this.frameLayout.addView(this.searchField, LayoutHelper.createFrame(-1, -1, 51));
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context, null, resourcesProvider);
        this.progressView = emptyTextProgressView;
        emptyTextProgressView.showProgress();
        addView(this.progressView, LayoutHelper.createFrame(-1, -1.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.emptyView = linearLayout;
        linearLayout.setOrientation(1);
        this.emptyView.setGravity(17);
        this.emptyView.setVisibility(8);
        addView(this.emptyView, LayoutHelper.createFrame(-1, -1.0f));
        this.emptyView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$wlABroQbNHZTtA7Di7nqNFL9sTs
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ChatAttachAlertAudioLayout.lambda$new$0(view, motionEvent);
            }
        });
        ImageView imageView = new ImageView(context);
        this.emptyImageView = imageView;
        imageView.setImageResource(R.drawable.music_empty);
        this.emptyImageView.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogEmptyImage"), PorterDuff.Mode.MULTIPLY));
        this.emptyView.addView(this.emptyImageView, LayoutHelper.createLinear(-2, -2));
        TextView textView = new TextView(context);
        this.emptyTitleTextView = textView;
        textView.setTextColor(getThemedColor("dialogEmptyText"));
        this.emptyTitleTextView.setGravity(17);
        this.emptyTitleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.emptyTitleTextView.setTextSize(1, 17.0f);
        this.emptyTitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptyTitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 11, 0, 0));
        TextView textView2 = new TextView(context);
        this.emptySubtitleTextView = textView2;
        textView2.setTextColor(getThemedColor("dialogEmptyText"));
        this.emptySubtitleTextView.setGravity(17);
        this.emptySubtitleTextView.setTextSize(1, 15.0f);
        this.emptySubtitleTextView.setPadding(AndroidUtilities.dp(40.0f), 0, AndroidUtilities.dp(40.0f), 0);
        this.emptyView.addView(this.emptySubtitleTextView, LayoutHelper.createLinear(-2, -2, 17, 0, 6, 0, 0));
        RecyclerListView recyclerListView = new RecyclerListView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.2
            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float x, float y) {
                return y >= ((float) ((ChatAttachAlertAudioLayout.this.parentAlert.scrollOffsetY[0] + AndroidUtilities.dp(30.0f)) + ((Build.VERSION.SDK_INT < 21 || ChatAttachAlertAudioLayout.this.parentAlert.inBubbleMode) ? 0 : AndroidUtilities.statusBarHeight)));
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setClipToPadding(false);
        RecyclerListView recyclerListView2 = this.listView;
        FillLastLinearLayoutManager fillLastLinearLayoutManager = new FillLastLinearLayoutManager(getContext(), 1, false, AndroidUtilities.dp(9.0f), this.listView) { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.3
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.3.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDyToMakeVisible(View view, int snapPreference) {
                        return super.calculateDyToMakeVisible(view, snapPreference) - (ChatAttachAlertAudioLayout.this.listView.getPaddingTop() - AndroidUtilities.dp(7.0f));
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
        this.listView.setHorizontalScrollBarEnabled(false);
        this.listView.setVerticalScrollBarEnabled(false);
        addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        RecyclerListView recyclerListView3 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView3.setAdapter(listAdapter);
        this.listView.setGlowColor(getThemedColor("dialogScrollGlow"));
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$dM1cQZvQjUY8Uc0ScU7tt5ZT-MA
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$1$ChatAttachAlertAudioLayout(view, i);
            }
        });
        this.listView.setOnItemLongClickListener(new RecyclerListView.OnItemLongClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$ySywTm7ucnLMhk4coAQgocQiwNY
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemLongClickListener
            public final boolean onItemClick(View view, int i) {
                return this.f$0.lambda$new$2$ChatAttachAlertAudioLayout(view, i);
            }
        });
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                ChatAttachAlertAudioLayout chatAttachAlertAudioLayout = ChatAttachAlertAudioLayout.this;
                chatAttachAlertAudioLayout.parentAlert.updateLayout(chatAttachAlertAudioLayout, true, dy);
                ChatAttachAlertAudioLayout.this.updateEmptyViewPosition();
            }
        });
        this.searchAdapter = new SearchAdapter(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp(58.0f);
        View view = new View(context);
        this.shadow = view;
        view.setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.shadow.setAlpha(0.0f);
        this.shadow.setTag(1);
        addView(this.shadow, layoutParams);
        addView(this.frameLayout, LayoutHelper.createFrame(-1, 58, 51));
        updateEmptyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ChatAttachAlertAudioLayout(View view, int i) {
        onItemClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$2$ChatAttachAlertAudioLayout(View view, int i) {
        onItemClick(view);
        return true;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onDestroy() throws InterruptedException, IOException {
        onHide();
        NotificationCenter.getInstance(this.parentAlert.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidReset);
        NotificationCenter.getInstance(this.parentAlert.currentAccount).removeObserver(this, NotificationCenter.messagePlayingDidStart);
        NotificationCenter.getInstance(this.parentAlert.currentAccount).removeObserver(this, NotificationCenter.messagePlayingPlayStateChanged);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHide() throws InterruptedException, IOException {
        if (this.playingAudio != null && MediaController.getInstance().isPlayingMessage(this.playingAudio)) {
            MediaController.getInstance().cleanupPlayer(true, true);
        }
        this.playingAudio = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyViewPosition() {
        View childAt;
        if (this.currentEmptyView.getVisibility() == 0 && (childAt = this.listView.getChildAt(0)) != null) {
            this.currentEmptyView.setTranslationY((((r1.getMeasuredHeight() - getMeasuredHeight()) + childAt.getTop()) / 2) - (this.currentPanTranslationProgress / 2.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmptyView() {
        boolean zIsEmpty;
        if (this.loadingAudio) {
            this.currentEmptyView = this.progressView;
            this.emptyView.setVisibility(8);
        } else {
            if (this.listView.getAdapter() == this.searchAdapter) {
                this.emptyTitleTextView.setText(LocaleController.getString("NoAudioFound", R.string.NoAudioFound));
            } else {
                this.emptyTitleTextView.setText(LocaleController.getString("NoAudioFiles", R.string.NoAudioFiles));
                this.emptySubtitleTextView.setText(LocaleController.getString("NoAudioFilesInfo", R.string.NoAudioFilesInfo));
            }
            this.currentEmptyView = this.emptyView;
            this.progressView.setVisibility(8);
        }
        RecyclerView.Adapter adapter = this.listView.getAdapter();
        SearchAdapter searchAdapter = this.searchAdapter;
        if (adapter != searchAdapter) {
            zIsEmpty = this.audioEntries.isEmpty();
        } else {
            zIsEmpty = searchAdapter.searchResult.isEmpty();
        }
        this.currentEmptyView.setVisibility(zIsEmpty ? 0 : 8);
        updateEmptyViewPosition();
    }

    public void setMaxSelectedFiles(int value) {
        this.maxSelectedFiles = value;
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void scrollToTop() {
        this.listView.smoothScrollToPosition(0);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getCurrentItemTop() {
        if (this.listView.getChildCount() <= 0) {
            return ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        int i = (top <= 0 || holder == null || holder.getAdapterPosition() != 0) ? 0 : top;
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            runShadowAnimation(false);
        } else {
            runShadowAnimation(true);
            top = i;
        }
        this.frameLayout.setTranslationY(top);
        return top + AndroidUtilities.dp(12.0f);
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getFirstOffset() {
        return getListTopPadding() + AndroidUtilities.dp(4.0f);
    }

    @Override // android.view.View
    public void setTranslationY(float translationY) {
        super.setTranslationY(translationY);
        this.parentAlert.getSheetContainer().invalidate();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    boolean onDismiss() throws InterruptedException, IOException {
        if (this.playingAudio != null && MediaController.getInstance().isPlayingMessage(this.playingAudio)) {
            MediaController.getInstance().cleanupPlayer(true, true);
        }
        return super.onDismiss();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getListTopPadding() {
        return this.listView.getPaddingTop();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        updateEmptyViewPosition();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void onPreMeasure(int r4, int r5) {
        /*
            r3 = this;
            ir.eitaa.ui.Components.ChatAttachAlert r4 = r3.parentAlert
            ir.eitaa.ui.Components.SizeNotifierFrameLayout r4 = r4.sizeNotifierFrameLayout
            int r4 = r4.measureKeyboardHeight()
            r0 = 1101004800(0x41a00000, float:20.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            r1 = 1
            r2 = 0
            if (r4 <= r0) goto L1e
            r4 = 1090519040(0x41000000, float:8.0)
            int r4 = ir.eitaa.messenger.AndroidUtilities.dp(r4)
            ir.eitaa.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r2)
            goto L3c
        L1e:
            boolean r4 = ir.eitaa.messenger.AndroidUtilities.isTablet()
            if (r4 != 0) goto L32
            android.graphics.Point r4 = ir.eitaa.messenger.AndroidUtilities.displaySize
            int r0 = r4.x
            int r4 = r4.y
            if (r0 <= r4) goto L32
            float r4 = (float) r5
            r5 = 1080033280(0x40600000, float:3.5)
            float r4 = r4 / r5
            int r4 = (int) r4
            goto L37
        L32:
            int r5 = r5 / 5
            int r5 = r5 * 2
            r4 = r5
        L37:
            ir.eitaa.ui.Components.ChatAttachAlert r5 = r3.parentAlert
            r5.setAllowNestedScroll(r1)
        L3c:
            ir.eitaa.ui.Components.RecyclerListView r5 = r3.listView
            int r5 = r5.getPaddingTop()
            if (r5 == r4) goto L53
            r3.ignoreLayout = r1
            ir.eitaa.ui.Components.RecyclerListView r5 = r3.listView
            r0 = 1111490560(0x42400000, float:48.0)
            int r0 = ir.eitaa.messenger.AndroidUtilities.dp(r0)
            r5.setPadding(r2, r4, r2, r0)
            r3.ignoreLayout = r2
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.onPreMeasure(int, int):void");
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onShow() {
        this.layoutManager.scrollToPositionWithOffset(0, 0);
        this.listAdapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onHidden() {
        this.selectedAudios.clear();
        this.selectedAudiosOrder.clear();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.ignoreLayout) {
            return;
        }
        super.requestLayout();
    }

    private void runShadowAnimation(final boolean show) {
        if ((!show || this.shadow.getTag() == null) && (show || this.shadow.getTag() != null)) {
            return;
        }
        this.shadow.setTag(show ? null : 1);
        if (show) {
            this.shadow.setVisibility(0);
        }
        AnimatorSet animatorSet = this.shadowAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.shadowAnimation = animatorSet2;
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet2.playTogether(animatorArr);
        this.shadowAnimation.setDuration(150L);
        this.shadowAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ChatAttachAlertAudioLayout.this.shadowAnimation == null || !ChatAttachAlertAudioLayout.this.shadowAnimation.equals(animation)) {
                    return;
                }
                if (!show) {
                    ChatAttachAlertAudioLayout.this.shadow.setVisibility(4);
                }
                ChatAttachAlertAudioLayout.this.shadowAnimation = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (ChatAttachAlertAudioLayout.this.shadowAnimation == null || !ChatAttachAlertAudioLayout.this.shadowAnimation.equals(animation)) {
                    return;
                }
                ChatAttachAlertAudioLayout.this.shadowAnimation = null;
            }
        });
        this.shadowAnimation.start();
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        int i = NotificationCenter.messagePlayingDidReset;
        if (id == i || id == NotificationCenter.messagePlayingDidStart || id == NotificationCenter.messagePlayingPlayStateChanged) {
            if (id == i || id == NotificationCenter.messagePlayingPlayStateChanged) {
                int childCount = this.listView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.listView.getChildAt(i2);
                    if (childAt instanceof SharedAudioCell) {
                        SharedAudioCell sharedAudioCell = (SharedAudioCell) childAt;
                        if (sharedAudioCell.getMessage() != null) {
                            sharedAudioCell.updateButtonState(false, true);
                        }
                    }
                }
                return;
            }
            if (id == NotificationCenter.messagePlayingDidStart && ((MessageObject) args[0]).eventId == 0) {
                int childCount2 = this.listView.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = this.listView.getChildAt(i3);
                    if (childAt2 instanceof SharedAudioCell) {
                        SharedAudioCell sharedAudioCell2 = (SharedAudioCell) childAt2;
                        if (sharedAudioCell2.getMessage() != null) {
                            sharedAudioCell2.updateButtonState(false, true);
                        }
                    }
                }
            }
        }
    }

    private void showErrorBox(String error) {
        new AlertDialog.Builder(getContext(), this.resourcesProvider).setTitle(LocaleController.getString("AppName", R.string.AppName)).setMessage(error).setPositiveButton(LocaleController.getString("OK", R.string.OK), null).show();
    }

    private void onItemClick(View view) {
        if (view instanceof SharedAudioCell) {
            SharedAudioCell sharedAudioCell = (SharedAudioCell) view;
            MediaController.AudioEntry audioEntry = (MediaController.AudioEntry) sharedAudioCell.getTag();
            boolean z = false;
            if (this.selectedAudios.indexOfKey(audioEntry.id) >= 0) {
                this.selectedAudios.remove(audioEntry.id);
                this.selectedAudiosOrder.remove(audioEntry);
                sharedAudioCell.setChecked(false, true);
            } else {
                if (this.maxSelectedFiles >= 0) {
                    int size = this.selectedAudios.size();
                    int i = this.maxSelectedFiles;
                    if (size >= i) {
                        showErrorBox(LocaleController.formatString("PassportUploadMaxReached", R.string.PassportUploadMaxReached, LocaleController.formatPluralString("Files", i)));
                        return;
                    }
                }
                this.selectedAudios.put(audioEntry.id, audioEntry);
                this.selectedAudiosOrder.add(audioEntry);
                sharedAudioCell.setChecked(true, true);
                z = true;
            }
            this.parentAlert.updateCountButton(z ? 1 : 2);
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    int getSelectedItemsCount() {
        return this.selectedAudios.size();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void sendSelectedItems(boolean notify, int scheduleDate) {
        if (this.selectedAudios.size() == 0 || this.delegate == null || this.sendPressed) {
            return;
        }
        this.sendPressed = true;
        ArrayList<MessageObject> arrayList = new ArrayList<>();
        for (int i = 0; i < this.selectedAudiosOrder.size(); i++) {
            arrayList.add(this.selectedAudiosOrder.get(i).messageObject);
        }
        this.delegate.didSelectAudio(arrayList, this.parentAlert.commentTextView.getText().toString(), notify, scheduleDate);
    }

    public void setDelegate(AudioSelectDelegate audioSelectDelegate) {
        this.delegate = audioSelectDelegate;
    }

    private void loadAudio() {
        this.loadingAudio = true;
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$F0yWNL6qIpJCtaDPA5_8d6GfB44
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.lambda$loadAudio$4$ChatAttachAlertAudioLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* renamed from: lambda$loadAudio$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAudio$4$ChatAttachAlertAudioLayout() throws Throwable {
        Object obj;
        final ?? r4;
        int i = 2;
        int i2 = 4;
        int i3 = 5;
        String[] strArr = {"_id", "artist", "title", "_data", "duration", "album"};
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = ApplicationLoader.applicationContext.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, strArr, "is_music != 0", null, "title");
            int i4 = -2000000000;
            obj = strArr;
            while (cursorQuery.moveToNext()) {
                try {
                    try {
                        MediaController.AudioEntry audioEntry = new MediaController.AudioEntry();
                        audioEntry.id = cursorQuery.getInt(0);
                        audioEntry.author = cursorQuery.getString(1);
                        audioEntry.title = cursorQuery.getString(i);
                        audioEntry.path = cursorQuery.getString(3);
                        audioEntry.duration = (int) (cursorQuery.getLong(i2) / 1000);
                        audioEntry.genre = cursorQuery.getString(i3);
                        File file = new File(audioEntry.path);
                        TLRPC$TL_message tLRPC$TL_message = new TLRPC$TL_message();
                        tLRPC$TL_message.out = true;
                        tLRPC$TL_message.id = i4;
                        tLRPC$TL_message.peer_id = new TLRPC$TL_peerUser();
                        TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                        tLRPC$TL_message.from_id = tLRPC$TL_peerUser;
                        TLRPC$Peer tLRPC$Peer = tLRPC$TL_message.peer_id;
                        ArrayList arrayList2 = arrayList;
                        try {
                            long clientUserId = UserConfig.getInstance(this.parentAlert.currentAccount).getClientUserId();
                            tLRPC$TL_peerUser.user_id = clientUserId;
                            tLRPC$Peer.user_id = clientUserId;
                            tLRPC$TL_message.date = (int) (System.currentTimeMillis() / 1000);
                            tLRPC$TL_message.message = "";
                            tLRPC$TL_message.attachPath = audioEntry.path;
                            TLRPC$TL_messageMediaDocument tLRPC$TL_messageMediaDocument = new TLRPC$TL_messageMediaDocument();
                            tLRPC$TL_message.media = tLRPC$TL_messageMediaDocument;
                            tLRPC$TL_messageMediaDocument.flags |= 3;
                            tLRPC$TL_messageMediaDocument.document = new TLRPC$TL_document();
                            tLRPC$TL_message.flags |= 768;
                            String fileExtension = FileLoader.getFileExtension(file);
                            TLRPC$Document tLRPC$Document = tLRPC$TL_message.media.document;
                            tLRPC$Document.id = 0L;
                            tLRPC$Document.access_hash = 0L;
                            tLRPC$Document.file_reference = new byte[0];
                            tLRPC$Document.date = tLRPC$TL_message.date;
                            StringBuilder sb = new StringBuilder();
                            sb.append("audio/");
                            if (fileExtension.length() <= 0) {
                                fileExtension = "mp3";
                            }
                            sb.append(fileExtension);
                            tLRPC$Document.mime_type = sb.toString();
                            tLRPC$TL_message.media.document.size = (int) file.length();
                            tLRPC$TL_message.media.document.dc_id = 0;
                            TLRPC$TL_documentAttributeAudio tLRPC$TL_documentAttributeAudio = new TLRPC$TL_documentAttributeAudio();
                            tLRPC$TL_documentAttributeAudio.duration = audioEntry.duration;
                            tLRPC$TL_documentAttributeAudio.title = audioEntry.title;
                            tLRPC$TL_documentAttributeAudio.performer = audioEntry.author;
                            tLRPC$TL_documentAttributeAudio.flags |= 3;
                            tLRPC$TL_message.media.document.attributes.add(tLRPC$TL_documentAttributeAudio);
                            TLRPC$TL_documentAttributeFilename tLRPC$TL_documentAttributeFilename = new TLRPC$TL_documentAttributeFilename();
                            tLRPC$TL_documentAttributeFilename.file_name = file.getName();
                            tLRPC$TL_message.media.document.attributes.add(tLRPC$TL_documentAttributeFilename);
                            audioEntry.messageObject = new MessageObject(this.parentAlert.currentAccount, tLRPC$TL_message, false, true);
                            ArrayList arrayList3 = arrayList2;
                            try {
                                arrayList3.add(audioEntry);
                                i4--;
                                arrayList = arrayList3;
                                i = 2;
                                i2 = 4;
                                i3 = 5;
                                obj = arrayList3;
                            } catch (Throwable th) {
                                th = th;
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e) {
                        e = e;
                        FileLog.e(e);
                        r4 = obj;
                        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$06UZBjfxRblG8nPMRaeiFau_L9U
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$loadAudio$3$ChatAttachAlertAudioLayout(r4);
                            }
                        });
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            r4 = arrayList;
            cursorQuery.close();
        } catch (Exception e2) {
            e = e2;
            obj = arrayList;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$06UZBjfxRblG8nPMRaeiFau_L9U
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadAudio$3$ChatAttachAlertAudioLayout(r4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadAudio$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadAudio$3$ChatAttachAlertAudioLayout(ArrayList arrayList) {
        this.loadingAudio = false;
        this.audioEntries = arrayList;
        this.listAdapter.notifyDataSetChanged();
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (ChatAttachAlertAudioLayout.this.audioEntries.isEmpty()) {
                return 1;
            }
            return ChatAttachAlertAudioLayout.this.audioEntries.size() + (ChatAttachAlertAudioLayout.this.audioEntries.isEmpty() ? 0 : 2);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == 0) {
                SharedAudioCell sharedAudioCell = new SharedAudioCell(this.mContext, ChatAttachAlertAudioLayout.this.resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.ListAdapter.1
                    @Override // ir.eitaa.ui.Cells.SharedAudioCell
                    public boolean needPlayMessage(MessageObject messageObject) {
                        ChatAttachAlertAudioLayout.this.playingAudio = messageObject;
                        ArrayList<MessageObject> arrayList = new ArrayList<>();
                        arrayList.add(messageObject);
                        return MediaController.getInstance().setPlaylist(arrayList, messageObject, 0L);
                    }
                };
                sharedAudioCell.setCheckForButtonPress(true);
                view = sharedAudioCell;
            } else if (viewType == 1) {
                view = new View(this.mContext);
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
            } else {
                view = new View(this.mContext);
            }
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() == 0) {
                int i = position - 1;
                MediaController.AudioEntry audioEntry = (MediaController.AudioEntry) ChatAttachAlertAudioLayout.this.audioEntries.get(i);
                SharedAudioCell sharedAudioCell = (SharedAudioCell) holder.itemView;
                sharedAudioCell.setTag(audioEntry);
                sharedAudioCell.setMessageObject(audioEntry.messageObject, i != ChatAttachAlertAudioLayout.this.audioEntries.size() - 1);
                sharedAudioCell.setChecked(ChatAttachAlertAudioLayout.this.selectedAudios.indexOfKey(audioEntry.id) >= 0, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == getItemCount() - 1) {
                return 2;
            }
            return i == 0 ? 1 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ChatAttachAlertAudioLayout.this.updateEmptyView();
        }
    }

    public class SearchAdapter extends RecyclerListView.SelectionAdapter {
        private int lastSearchId;
        private Context mContext;
        private Runnable searchRunnable;
        private ArrayList<MediaController.AudioEntry> searchResult = new ArrayList<>();
        private int reqId = 0;

        public SearchAdapter(Context context) {
            this.mContext = context;
        }

        public void search(final String query) {
            Runnable runnable = this.searchRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.searchRunnable = null;
            }
            if (TextUtils.isEmpty(query)) {
                if (!this.searchResult.isEmpty()) {
                    this.searchResult.clear();
                }
                if (ChatAttachAlertAudioLayout.this.listView.getAdapter() != ChatAttachAlertAudioLayout.this.listAdapter) {
                    ChatAttachAlertAudioLayout.this.listView.setAdapter(ChatAttachAlertAudioLayout.this.listAdapter);
                }
                notifyDataSetChanged();
                return;
            }
            final int i = this.lastSearchId + 1;
            this.lastSearchId = i;
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$SearchAdapter$lYNDMaNZ6QMdBmYTrEiSHBYL9Y4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$1$ChatAttachAlertAudioLayout$SearchAdapter(query, i);
                }
            };
            this.searchRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$1$ChatAttachAlertAudioLayout$SearchAdapter(final String str, final int i) {
            final ArrayList arrayList = new ArrayList(ChatAttachAlertAudioLayout.this.audioEntries);
            Utilities.searchQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$SearchAdapter$kBffL-fCxMDLrMhAVAII5B613v8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$search$0$ChatAttachAlertAudioLayout$SearchAdapter(str, arrayList, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$search$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$search$0$ChatAttachAlertAudioLayout$SearchAdapter(String str, ArrayList arrayList, int i) {
            String str2;
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.length() == 0) {
                updateSearchResults(new ArrayList<>(), str, this.lastSearchId);
                return;
            }
            String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
            if (lowerCase.equals(translitString) || translitString.length() == 0) {
                translitString = null;
            }
            int i2 = (translitString != null ? 1 : 0) + 1;
            String[] strArr = new String[i2];
            strArr[0] = lowerCase;
            if (translitString != null) {
                strArr[1] = translitString;
            }
            ArrayList<MediaController.AudioEntry> arrayList2 = new ArrayList<>();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                MediaController.AudioEntry audioEntry = (MediaController.AudioEntry) arrayList.get(i3);
                int i4 = 0;
                while (true) {
                    if (i4 < i2) {
                        String str3 = strArr[i4];
                        String str4 = audioEntry.author;
                        boolean zContains = str4 != null ? str4.toLowerCase().contains(str3) : false;
                        if (!zContains && (str2 = audioEntry.title) != null) {
                            zContains = str2.toLowerCase().contains(str3);
                        }
                        if (zContains) {
                            arrayList2.add(audioEntry);
                            break;
                        }
                        i4++;
                    }
                }
            }
            updateSearchResults(arrayList2, str, i);
        }

        private void updateSearchResults(final ArrayList<MediaController.AudioEntry> result, final String query, final int searchId) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ChatAttachAlertAudioLayout$SearchAdapter$bxs6of8XvcFmHU_0igwZykGa0Jk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$2$ChatAttachAlertAudioLayout$SearchAdapter(searchId, query, result);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$2$ChatAttachAlertAudioLayout$SearchAdapter(int i, String str, ArrayList arrayList) {
            if (i != this.lastSearchId) {
                return;
            }
            if (i != -1 && ChatAttachAlertAudioLayout.this.listView.getAdapter() != ChatAttachAlertAudioLayout.this.searchAdapter) {
                ChatAttachAlertAudioLayout.this.listView.setAdapter(ChatAttachAlertAudioLayout.this.searchAdapter);
            }
            if (ChatAttachAlertAudioLayout.this.listView.getAdapter() == ChatAttachAlertAudioLayout.this.searchAdapter) {
                ChatAttachAlertAudioLayout.this.emptySubtitleTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("NoAudioFoundInfo", R.string.NoAudioFoundInfo, str)));
            }
            this.searchResult = arrayList;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            ChatAttachAlertAudioLayout.this.updateEmptyView();
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.searchResult.isEmpty()) {
                return 1;
            }
            return this.searchResult.size() + (this.searchResult.isEmpty() ? 0 : 2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if (viewType == 0) {
                SharedAudioCell sharedAudioCell = new SharedAudioCell(this.mContext, ChatAttachAlertAudioLayout.this.resourcesProvider) { // from class: ir.eitaa.ui.Components.ChatAttachAlertAudioLayout.SearchAdapter.1
                    @Override // ir.eitaa.ui.Cells.SharedAudioCell
                    public boolean needPlayMessage(MessageObject messageObject) {
                        ChatAttachAlertAudioLayout.this.playingAudio = messageObject;
                        ArrayList<MessageObject> arrayList = new ArrayList<>();
                        arrayList.add(messageObject);
                        return MediaController.getInstance().setPlaylist(arrayList, messageObject, 0L);
                    }
                };
                sharedAudioCell.setCheckForButtonPress(true);
                view = sharedAudioCell;
            } else if (viewType == 1) {
                view = new View(this.mContext);
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
            } else {
                view = new View(this.mContext);
            }
            return new RecyclerListView.Holder(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() == 0) {
                int i = position - 1;
                MediaController.AudioEntry audioEntry = this.searchResult.get(i);
                SharedAudioCell sharedAudioCell = (SharedAudioCell) holder.itemView;
                sharedAudioCell.setTag(audioEntry);
                sharedAudioCell.setMessageObject(audioEntry.messageObject, i != this.searchResult.size() - 1);
                sharedAudioCell.setChecked(ChatAttachAlertAudioLayout.this.selectedAudios.indexOfKey(audioEntry.id) >= 0, false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == getItemCount() - 1) {
                return 2;
            }
            return i == 0 ? 1 : 0;
        }
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    void onContainerTranslationUpdated(float currentPanTranslationY) {
        this.currentPanTranslationProgress = currentPanTranslationY;
        super.onContainerTranslationUpdated(currentPanTranslationY);
        updateEmptyViewPosition();
    }

    @Override // ir.eitaa.ui.Components.ChatAttachAlert.AttachAlertLayout
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.frameLayout, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "dialogBackground"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchBackground(), ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "dialogSearchBackground"));
        arrayList.add(new ThemeDescription(this.searchField, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SearchField.class}, new String[]{"searchIconImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogSearchIcon"));
        arrayList.add(new ThemeDescription(this.searchField, ThemeDescription.FLAG_IMAGECOLOR, new Class[]{SearchField.class}, new String[]{"clearSearchImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "dialogSearchIcon"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchEditText(), ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "dialogSearchText"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchEditText(), ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "dialogSearchHint"));
        arrayList.add(new ThemeDescription(this.searchField.getSearchEditText(), ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "featuredStickers_addedIcon"));
        arrayList.add(new ThemeDescription(this.emptyImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogEmptyImage"));
        arrayList.add(new ThemeDescription(this.emptyTitleTextView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogEmptyText"));
        arrayList.add(new ThemeDescription(this.emptySubtitleTextView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "dialogEmptyText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "dialogScrollGlow"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.progressView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "emptyListPlaceholder"));
        arrayList.add(new ThemeDescription(this.progressView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOX, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkbox"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{SharedAudioCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_titleTextPaint, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{SharedAudioCell.class}, Theme.chat_contextResult_descriptionTextPaint, null, null, "windowBackgroundWhiteGrayText2"));
        return arrayList;
    }
}
