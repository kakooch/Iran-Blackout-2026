package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.arch.core.util.Function;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.DialogObject;
import ir.eitaa.messenger.DispatchQueue;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MediaDataController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.UserObject;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$Dialog;
import ir.eitaa.tgnet.TLRPC$EncryptedChat;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_channels_exportMessageLink;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_dialog;
import ir.eitaa.tgnet.TLRPC$TL_encryptedChat;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_exportedMessageLink;
import ir.eitaa.tgnet.TLRPC$TL_topPeer;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Adapters.DialogsSearchAdapter;
import ir.eitaa.ui.Adapters.SearchAdapterHelper;
import ir.eitaa.ui.Cells.GraySectionCell;
import ir.eitaa.ui.Cells.HintDialogCell;
import ir.eitaa.ui.Cells.ShareDialogCell;
import ir.eitaa.ui.ChatActivity;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.DialogsActivity;
import ir.eitaa.ui.LaunchActivity;
import ir.eitaa.ui.MessageStatisticActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ShareAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private AnimatorSet animatorSet;
    private float captionEditTextTopOffset;
    private float chatActivityEnterViewAnimateFromTop;
    private EditTextEmoji commentTextView;
    private boolean copyLinkOnEnd;
    private float currentPanTranslationY;
    private boolean darkTheme;
    private ShareAlertDelegate delegate;
    private TLRPC$TL_exportedMessageLink exportedMessageLink;
    private FrameLayout frameLayout;
    private FrameLayout frameLayout2;
    private RecyclerListView gridView;
    private int hasPoll;
    private boolean isChannel;
    private boolean isCheck;
    int lastOffset;
    private GridLayoutManager layoutManager;
    private String[] linkToCopy;
    private ShareDialogsAdapter listAdapter;
    private boolean loadingLink;
    private Paint paint;
    private boolean panTranslationMoveLayout;
    private Activity parentActivity;
    private ChatActivity parentFragment;
    private TextView pickerBottomLayout;
    private int previousScrollOffsetY;
    private ArrayList<DialogsSearchAdapter.RecentSearchObject> recentSearchObjects;
    private LongSparseArray<DialogsSearchAdapter.RecentSearchObject> recentSearchObjectsById;
    private RectF rect;
    RecyclerItemsEnterAnimator recyclerItemsEnterAnimator;
    private final Theme.ResourcesProvider resourcesProvider;
    private int scrollOffsetY;
    private ShareSearchAdapter searchAdapter;
    private EmptyTextProgressView searchEmptyView;
    private RecyclerListView searchGridView;
    private boolean searchIsVisible;
    private FillLastGridLayoutManager searchLayoutManager;
    SearchField searchView;
    private View selectedCountView;
    private LongSparseArray<TLRPC$Dialog> selectedDialogs;
    private ArrayList<MessageObject> sendingMessageObjects;
    private String[] sendingText;
    private View[] shadow;
    private AnimatorSet[] shadowAnimation;
    private Drawable shadowDrawable;
    private LinearLayout sharesCountLayout;
    private SwitchView switchView;
    private TextPaint textPaint;
    private ValueAnimator topBackgroundAnimator;
    private int topBeforeSwitch;
    private boolean updateSearchAdapter;
    private FrameLayout writeButtonContainer;

    public static class DialogSearchResult {
        public int date;
        public TLRPC$Dialog dialog = new TLRPC$TL_dialog();
        public CharSequence name;
        public TLObject object;
    }

    public interface ShareAlertDelegate {

        /* renamed from: ir.eitaa.ui.Components.ShareAlert$ShareAlertDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didShare(ShareAlertDelegate shareAlertDelegate) {
            }
        }

        boolean didCopy();

        void didShare();
    }

    static /* synthetic */ boolean lambda$new$6(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    protected void onSend(LongSparseArray<TLRPC$Dialog> dids, int count) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SwitchView extends FrameLayout {
        private AnimatorSet animator;
        private int currentTab;
        private int lastColor;
        private SimpleTextView leftTab;
        private LinearGradient linearGradient;
        private Paint paint;
        private RectF rect;
        private SimpleTextView rightTab;
        private View searchBackground;
        private View slidingView;

        protected void onTabSwitch(int num) {
            throw null;
        }

        public SwitchView(Context context) {
            super(context);
            this.paint = new Paint(1);
            this.rect = new RectF();
            View view = new View(context);
            this.searchBackground = view;
            view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), ShareAlert.this.getThemedColor(ShareAlert.this.darkTheme ? "voipgroup_searchBackground" : "dialogSearchBackground")));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 0.0f, 14.0f, 0.0f));
            View view2 = new View(context) { // from class: ir.eitaa.ui.Components.ShareAlert.SwitchView.1
                @Override // android.view.View
                public void setTranslationX(float translationX) {
                    super.setTranslationX(translationX);
                    invalidate();
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    super.onDraw(canvas);
                    int offsetColor = AndroidUtilities.getOffsetColor(-9057429, -10513163, getTranslationX() / getMeasuredWidth(), 1.0f);
                    int offsetColor2 = AndroidUtilities.getOffsetColor(-11554882, -4629871, getTranslationX() / getMeasuredWidth(), 1.0f);
                    if (offsetColor != SwitchView.this.lastColor) {
                        SwitchView.this.linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{offsetColor, offsetColor2}, (float[]) null, Shader.TileMode.CLAMP);
                        SwitchView.this.paint.setShader(SwitchView.this.linearGradient);
                    }
                    SwitchView.this.rect.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                    canvas.drawRoundRect(SwitchView.this.rect, AndroidUtilities.dp(18.0f), AndroidUtilities.dp(18.0f), SwitchView.this.paint);
                }
            };
            this.slidingView = view2;
            addView(view2, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 0.0f, 14.0f, 0.0f));
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.leftTab = simpleTextView;
            simpleTextView.setTextColor(ShareAlert.this.getThemedColor("voipgroup_nameText"));
            this.leftTab.setTextSize(13);
            this.leftTab.setLeftDrawable(R.drawable.msg_tabs_mic1);
            this.leftTab.setText(LocaleController.getString("VoipGroupInviteCanSpeak", R.string.VoipGroupInviteCanSpeak));
            this.leftTab.setGravity(17);
            addView(this.leftTab, LayoutHelper.createFrame(-1, -1.0f, 51, 14.0f, 0.0f, 0.0f, 0.0f));
            this.leftTab.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$SwitchView$4whOx2-ok-iWVFETJIxRSDqgj70
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.lambda$new$0$ShareAlert$SwitchView(view3);
                }
            });
            SimpleTextView simpleTextView2 = new SimpleTextView(context);
            this.rightTab = simpleTextView2;
            simpleTextView2.setTextColor(ShareAlert.this.getThemedColor("voipgroup_nameText"));
            this.rightTab.setTextSize(13);
            this.rightTab.setLeftDrawable(R.drawable.msg_tabs_mic2);
            this.rightTab.setText(LocaleController.getString("VoipGroupInviteListenOnly", R.string.VoipGroupInviteListenOnly));
            this.rightTab.setGravity(17);
            addView(this.rightTab, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 14.0f, 0.0f));
            this.rightTab.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$SwitchView$vFbHRCxTWuxlghsa0RVXrdWR4ZI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.lambda$new$1$ShareAlert$SwitchView(view3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ShareAlert$SwitchView(View view) {
            switchToTab(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$ShareAlert$SwitchView(View view) {
            switchToTab(1);
        }

        private void switchToTab(int tab) {
            if (this.currentTab == tab) {
                return;
            }
            this.currentTab = tab;
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animator = animatorSet2;
            Animator[] animatorArr = new Animator[1];
            View view = this.slidingView;
            Property property = View.TRANSLATION_X;
            float[] fArr = new float[1];
            fArr[0] = this.currentTab == 0 ? 0.0f : view.getMeasuredWidth();
            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
            animatorSet2.playTogether(animatorArr);
            this.animator.setDuration(180L);
            this.animator.setInterpolator(CubicBezierInterpolator.EASE_OUT);
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ShareAlert.SwitchView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    SwitchView.this.animator = null;
                }
            });
            this.animator.start();
            onTabSwitch(this.currentTab);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = (View.MeasureSpec.getSize(widthMeasureSpec) - AndroidUtilities.dp(28.0f)) / 2;
            ((FrameLayout.LayoutParams) this.leftTab.getLayoutParams()).width = size;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.rightTab.getLayoutParams();
            layoutParams.width = size;
            layoutParams.leftMargin = AndroidUtilities.dp(14.0f) + size;
            ((FrameLayout.LayoutParams) this.slidingView.getLayoutParams()).width = size;
            AnimatorSet animatorSet = this.animator;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            this.slidingView.setTranslationX(this.currentTab == 0 ? 0.0f : r1.width);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SearchField extends FrameLayout {
        private ImageView clearSearchImageView;
        private CloseProgressDrawable2 progressDrawable;
        private View searchBackground;
        private EditTextBoldCursor searchEditText;
        private ImageView searchIconImageView;

        public SearchField(Context context) {
            super(context);
            View view = new View(context);
            this.searchBackground = view;
            view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), ShareAlert.this.getThemedColor(ShareAlert.this.darkTheme ? "voipgroup_searchBackground" : "dialogSearchBackground")));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 11.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.searchIconImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
            this.searchIconImageView.setColorFilter(new PorterDuffColorFilter(ShareAlert.this.getThemedColor(ShareAlert.this.darkTheme ? "voipgroup_mutedIcon" : "dialogSearchIcon"), PorterDuff.Mode.MULTIPLY));
            addView(this.searchIconImageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 11.0f, 0.0f, 0.0f));
            ImageView imageView2 = new ImageView(context);
            this.clearSearchImageView = imageView2;
            imageView2.setScaleType(ImageView.ScaleType.CENTER);
            ImageView imageView3 = this.clearSearchImageView;
            CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
            this.progressDrawable = closeProgressDrawable2;
            imageView3.setImageDrawable(closeProgressDrawable2);
            this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
            this.clearSearchImageView.setScaleX(0.1f);
            this.clearSearchImageView.setScaleY(0.1f);
            this.clearSearchImageView.setAlpha(0.0f);
            this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(ShareAlert.this.getThemedColor(ShareAlert.this.darkTheme ? "voipgroup_searchPlaceholder" : "dialogSearchIcon"), PorterDuff.Mode.MULTIPLY));
            addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 11.0f, 14.0f, 0.0f));
            this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$SearchField$4OtsHhhIerooUgEDPXLlsJNoONY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$0$ShareAlert$SearchField(view2);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setHintTextColor(ShareAlert.this.getThemedColor(ShareAlert.this.darkTheme ? "voipgroup_searchPlaceholder" : "dialogSearchHint"));
            this.searchEditText.setTextColor(ShareAlert.this.getThemedColor(ShareAlert.this.darkTheme ? "voipgroup_searchText" : "dialogSearchText"));
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            this.searchEditText.setHint(LocaleController.getString("ShareSendTo", R.string.ShareSendTo));
            this.searchEditText.setCursorColor(ShareAlert.this.getThemedColor(ShareAlert.this.darkTheme ? "voipgroup_searchText" : "featuredStickers_addedIcon"));
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 9.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.Components.ShareAlert.SearchField.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) throws InterruptedException {
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    if (!TextUtils.isEmpty(SearchField.this.searchEditText.getText())) {
                        ShareAlert.this.checkCurrentList(false);
                    }
                    if (ShareAlert.this.updateSearchAdapter) {
                        String string = SearchField.this.searchEditText.getText().toString();
                        if (string.length() != 0) {
                            if (ShareAlert.this.searchEmptyView != null) {
                                ShareAlert.this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                            }
                        } else if (ShareAlert.this.gridView.getAdapter() != ShareAlert.this.listAdapter) {
                            int currentTop = ShareAlert.this.getCurrentTop();
                            ShareAlert.this.searchEmptyView.setText(LocaleController.getString("NoChats", R.string.NoChats));
                            ShareAlert.this.searchEmptyView.showTextView();
                            ShareAlert.this.checkCurrentList(false);
                            ShareAlert.this.listAdapter.notifyDataSetChanged();
                            if (currentTop > 0) {
                                ShareAlert.this.layoutManager.scrollToPositionWithOffset(0, -currentTop);
                            }
                        }
                        if (ShareAlert.this.searchAdapter != null) {
                            ShareAlert.this.searchAdapter.searchDialogs(string);
                        }
                    }
                }
            });
            this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$SearchField$zCHOyk6JiGqZf3MDXiWoXVMJAfY
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$1$ShareAlert$SearchField(textView, i, keyEvent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ShareAlert$SearchField(View view) {
            ShareAlert.this.updateSearchAdapter = true;
            this.searchEditText.setText("");
            AndroidUtilities.showKeyboard(this.searchEditText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$1$ShareAlert$SearchField(TextView textView, int i, KeyEvent keyEvent) {
            if (keyEvent == null) {
                return false;
            }
            if ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 84) && (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            AndroidUtilities.hideKeyboard(this.searchEditText);
            return false;
        }

        public void hideKeyboard() {
            AndroidUtilities.hideKeyboard(this.searchEditText);
        }
    }

    public static ShareAlert createShareAlert(final Context context, MessageObject messageObject, final String text, boolean channel, final String copyLink, boolean fullScreen) {
        ArrayList arrayList;
        if (messageObject != null) {
            arrayList = new ArrayList();
            arrayList.add(messageObject);
        } else {
            arrayList = null;
        }
        return new ShareAlert(context, null, arrayList, text, null, channel, copyLink, null, fullScreen, false);
    }

    public ShareAlert(final Context context, ArrayList<MessageObject> messages, final String text, boolean channel, final String copyLink, boolean fullScreen) {
        this(context, messages, text, channel, copyLink, fullScreen, null);
    }

    public ShareAlert(final Context context, ArrayList<MessageObject> messages, final String text, boolean channel, final String copyLink, boolean fullScreen, Theme.ResourcesProvider resourcesProvider) {
        this(context, null, messages, text, null, channel, copyLink, null, fullScreen, false, resourcesProvider);
    }

    public ShareAlert(final Context context, ChatActivity fragment, ArrayList<MessageObject> messages, final String text, final String text2, boolean channel, final String copyLink, final String copyLink2, boolean fullScreen, boolean forCall) {
        this(context, fragment, messages, text, text2, channel, copyLink, copyLink2, fullScreen, forCall, null);
    }

    public ShareAlert(final Context context, ChatActivity fragment, ArrayList<MessageObject> messages, final String text, final String text2, boolean channel, final String copyLink, final String copyLink2, boolean fullScreen, boolean forCall, Theme.ResourcesProvider resourcesProvider) {
        boolean z;
        super(context, true, resourcesProvider);
        this.sendingText = new String[2];
        this.shadow = new View[2];
        this.shadowAnimation = new AnimatorSet[2];
        this.selectedDialogs = new LongSparseArray<>();
        this.rect = new RectF();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        this.linkToCopy = new String[2];
        this.recentSearchObjects = new ArrayList<>();
        this.recentSearchObjectsById = new LongSparseArray<>();
        this.isCheck = true;
        this.lastOffset = ConnectionsManager.DEFAULT_DATACENTER_ID;
        this.resourcesProvider = resourcesProvider;
        if (messages != null) {
            Iterator<MessageObject> it = messages.iterator();
            while (it.hasNext()) {
                if (it.next().isLiveStream()) {
                    z = false;
                    break;
                }
            }
            z = true;
        } else {
            z = true;
        }
        if (context instanceof Activity) {
            this.parentActivity = (Activity) context;
        }
        this.darkTheme = forCall;
        this.parentFragment = fragment;
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor(this.darkTheme ? "voipgroup_inviteMembersBackground" : "dialogBackground"), PorterDuff.Mode.MULTIPLY));
        this.isFullscreen = fullScreen;
        String[] strArr = this.linkToCopy;
        strArr[0] = copyLink;
        strArr[1] = copyLink2;
        this.sendingMessageObjects = messages;
        this.searchAdapter = new ShareSearchAdapter(context);
        this.isChannel = channel;
        String[] strArr2 = this.sendingText;
        strArr2[0] = text;
        strArr2[1] = text2;
        this.useSmoothKeyboard = true;
        ArrayList<MessageObject> arrayList = this.sendingMessageObjects;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                MessageObject messageObject = this.sendingMessageObjects.get(i);
                if (messageObject.isPoll()) {
                    int i2 = messageObject.isPublicPoll() ? 2 : 1;
                    this.hasPoll = i2;
                    if (i2 == 2) {
                        break;
                    }
                }
            }
        }
        if (channel) {
            this.loadingLink = true;
            TLRPC$TL_channels_exportMessageLink tLRPC$TL_channels_exportMessageLink = new TLRPC$TL_channels_exportMessageLink();
            tLRPC$TL_channels_exportMessageLink.id = messages.get(0).getId();
            tLRPC$TL_channels_exportMessageLink.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(messages.get(0).messageOwner.peer_id.channel_id);
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_channels_exportMessageLink, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$l4sWOb-Y6DXR6BdL6kzRJo1BdY0
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$1$ShareAlert(context, tLObject, tLRPC$TL_error);
                }
            });
        }
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.eitaa.ui.Components.ShareAlert.1
            private int fromOffsetTop;
            private int fromScrollY;
            private boolean fullHeight;
            private int previousTopOffset;
            private int toOffsetTop;
            private int toScrollY;
            private int topOffset;
            private boolean ignoreLayout = false;
            private RectF rect1 = new RectF();
            AdjustPanLayoutHelper adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: ir.eitaa.ui.Components.ShareAlert.1.1
                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionStart(boolean keyboardVisible, int contentHeight) {
                    super.onTransitionStart(keyboardVisible, contentHeight);
                    if (ShareAlert.this.previousScrollOffsetY == ShareAlert.this.scrollOffsetY) {
                        AnonymousClass1.this.fromScrollY = -1;
                    } else {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.fromScrollY = ShareAlert.this.previousScrollOffsetY;
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        anonymousClass12.toScrollY = ShareAlert.this.scrollOffsetY;
                        ShareAlert.this.panTranslationMoveLayout = true;
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        ShareAlert.this.scrollOffsetY = anonymousClass13.fromScrollY;
                    }
                    if (AnonymousClass1.this.topOffset != AnonymousClass1.this.previousTopOffset) {
                        AnonymousClass1.this.fromOffsetTop = 0;
                        AnonymousClass1.this.toOffsetTop = 0;
                        ShareAlert.this.panTranslationMoveLayout = true;
                        if (!keyboardVisible) {
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            AnonymousClass1.access$3320(anonymousClass14, anonymousClass14.topOffset - AnonymousClass1.this.previousTopOffset);
                        } else {
                            AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                            AnonymousClass1.access$3312(anonymousClass15, anonymousClass15.topOffset - AnonymousClass1.this.previousTopOffset);
                        }
                        AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                        ShareAlert.this.scrollOffsetY = keyboardVisible ? anonymousClass16.fromScrollY : anonymousClass16.toScrollY;
                    } else {
                        AnonymousClass1.this.fromOffsetTop = -1;
                    }
                    ShareAlert.this.gridView.setTopGlowOffset((int) (ShareAlert.this.currentPanTranslationY + ShareAlert.this.scrollOffsetY));
                    ShareAlert.this.frameLayout.setTranslationY(ShareAlert.this.currentPanTranslationY + ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.searchEmptyView.setTranslationY(ShareAlert.this.currentPanTranslationY + ShareAlert.this.scrollOffsetY);
                    invalidate();
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionEnd() {
                    super.onTransitionEnd();
                    ShareAlert.this.panTranslationMoveLayout = false;
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.previousScrollOffsetY = shareAlert.scrollOffsetY;
                    ShareAlert.this.gridView.setTopGlowOffset(ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.frameLayout.setTranslationY(ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.searchEmptyView.setTranslationY(ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.gridView.setTranslationY(0.0f);
                    ShareAlert.this.searchGridView.setTranslationY(0.0f);
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected void onPanTranslationUpdate(float y, float progress, boolean keyboardVisible) {
                    super.onPanTranslationUpdate(y, progress, keyboardVisible);
                    for (int i3 = 0; i3 < ((BottomSheet) ShareAlert.this).containerView.getChildCount(); i3++) {
                        if (((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.pickerBottomLayout && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.shadow[1] && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.sharesCountLayout && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.frameLayout2 && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.writeButtonContainer && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.selectedCountView) {
                            ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3).setTranslationY(y);
                        }
                    }
                    ShareAlert.this.currentPanTranslationY = y;
                    if (AnonymousClass1.this.fromScrollY != -1) {
                        if (!keyboardVisible) {
                            progress = 1.0f - progress;
                        }
                        float f = 1.0f - progress;
                        ShareAlert.this.scrollOffsetY = (int) ((r5.fromScrollY * f) + (AnonymousClass1.this.toScrollY * progress));
                        float f2 = ShareAlert.this.currentPanTranslationY + ((AnonymousClass1.this.fromScrollY - AnonymousClass1.this.toScrollY) * f);
                        ShareAlert.this.gridView.setTranslationY(f2);
                        if (keyboardVisible) {
                            ShareAlert.this.searchGridView.setTranslationY(f2);
                        } else {
                            ShareAlert.this.searchGridView.setTranslationY(f2 + ShareAlert.this.gridView.getPaddingTop());
                        }
                    } else if (AnonymousClass1.this.fromOffsetTop != -1) {
                        float f3 = 1.0f - progress;
                        ShareAlert.this.scrollOffsetY = (int) ((r5.fromOffsetTop * f3) + (AnonymousClass1.this.toOffsetTop * progress));
                        if (!keyboardVisible) {
                            f3 = progress;
                        }
                        if (keyboardVisible) {
                            ShareAlert.this.gridView.setTranslationY(ShareAlert.this.currentPanTranslationY - ((AnonymousClass1.this.fromOffsetTop - AnonymousClass1.this.toOffsetTop) * progress));
                        } else {
                            ShareAlert.this.gridView.setTranslationY(ShareAlert.this.currentPanTranslationY + ((AnonymousClass1.this.toOffsetTop - AnonymousClass1.this.fromOffsetTop) * f3));
                        }
                    }
                    ShareAlert.this.gridView.setTopGlowOffset((int) (ShareAlert.this.scrollOffsetY + ShareAlert.this.currentPanTranslationY));
                    ShareAlert.this.frameLayout.setTranslationY(ShareAlert.this.scrollOffsetY + ShareAlert.this.currentPanTranslationY);
                    ShareAlert.this.searchEmptyView.setTranslationY(ShareAlert.this.scrollOffsetY + ShareAlert.this.currentPanTranslationY);
                    ShareAlert.this.frameLayout2.invalidate();
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.setCurrentPanTranslationY(shareAlert.currentPanTranslationY);
                    invalidate();
                }

                @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                protected boolean heightAnimationEnabled() {
                    if (ShareAlert.this.isDismissed()) {
                        return false;
                    }
                    return !ShareAlert.this.commentTextView.isPopupVisible();
                }
            };

            static /* synthetic */ int access$3312(AnonymousClass1 anonymousClass1, int i3) {
                int i4 = anonymousClass1.toOffsetTop + i3;
                anonymousClass1.toOffsetTop = i4;
                return i4;
            }

            static /* synthetic */ int access$3320(AnonymousClass1 anonymousClass1, int i3) {
                int i4 = anonymousClass1.toOffsetTop - i3;
                anonymousClass1.toOffsetTop = i4;
                return i4;
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                this.adjustPanLayoutHelper.setResizableView(this);
                this.adjustPanLayoutHelper.onAttach();
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                this.adjustPanLayoutHelper.onDetach();
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) throws InterruptedException {
                int size2;
                if (getLayoutParams().height > 0) {
                    size2 = getLayoutParams().height;
                } else {
                    size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                }
                ShareAlert.this.layoutManager.setNeedFixGap(getLayoutParams().height <= 0);
                ShareAlert.this.searchLayoutManager.setNeedFixGap(getLayoutParams().height <= 0);
                if (Build.VERSION.SDK_INT >= 21 && !((BottomSheet) ShareAlert.this).isFullscreen) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) ShareAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) ShareAlert.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                int paddingTop = size2 - getPaddingTop();
                int iDp = AndroidUtilities.dp(103.0f) + AndroidUtilities.dp(48.0f) + (Math.max(2, (int) Math.ceil(Math.max(ShareAlert.this.searchAdapter.getItemCount(), ShareAlert.this.listAdapter.getItemCount() - 1) / 4.0f)) * AndroidUtilities.dp(103.0f)) + ((BottomSheet) ShareAlert.this).backgroundPaddingTop;
                int iDp2 = (iDp < paddingTop ? 0 : paddingTop - ((paddingTop / 5) * 3)) + AndroidUtilities.dp(8.0f);
                if (ShareAlert.this.gridView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    ShareAlert.this.gridView.setPadding(0, iDp2, 0, AndroidUtilities.dp(48.0f));
                    this.ignoreLayout = false;
                }
                if (((BottomSheet) ShareAlert.this).keyboardVisible && getLayoutParams().height <= 0 && ShareAlert.this.searchGridView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    ShareAlert.this.searchGridView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
                    this.ignoreLayout = false;
                }
                boolean z2 = iDp >= size2;
                this.fullHeight = z2;
                this.topOffset = (z2 || !SharedConfig.smoothKeyboard) ? 0 : size2 - iDp;
                this.ignoreLayout = true;
                ShareAlert.this.checkCurrentList(false);
                this.ignoreLayout = false;
                setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), size2);
                onMeasureInternal(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }

            private void onMeasureInternal(int widthMeasureSpec, int heightMeasureSpec) {
                int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
                int size3 = View.MeasureSpec.getSize(heightMeasureSpec);
                int i3 = size2 - (((BottomSheet) ShareAlert.this).backgroundPaddingLeft * 2);
                int iMeasureKeyboardHeight = SharedConfig.smoothKeyboard ? 0 : measureKeyboardHeight();
                if (!ShareAlert.this.commentTextView.isWaitingForKeyboardOpen() && iMeasureKeyboardHeight <= AndroidUtilities.dp(20.0f) && !ShareAlert.this.commentTextView.isPopupShowing() && !ShareAlert.this.commentTextView.isAnimatePopupClosing()) {
                    this.ignoreLayout = true;
                    ShareAlert.this.commentTextView.hideEmojiView();
                    this.ignoreLayout = false;
                }
                this.ignoreLayout = true;
                if (iMeasureKeyboardHeight > AndroidUtilities.dp(20.0f)) {
                    ShareAlert.this.commentTextView.hideEmojiView();
                    if (ShareAlert.this.pickerBottomLayout != null) {
                        ShareAlert.this.pickerBottomLayout.setVisibility(8);
                        if (ShareAlert.this.sharesCountLayout != null) {
                            ShareAlert.this.sharesCountLayout.setVisibility(8);
                        }
                    }
                } else {
                    if (!AndroidUtilities.isInMultiwindow) {
                        size3 -= (SharedConfig.smoothKeyboard && ((BottomSheet) ShareAlert.this).keyboardVisible) ? 0 : ShareAlert.this.commentTextView.getEmojiPadding();
                        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
                    }
                    int i4 = ShareAlert.this.commentTextView.isPopupShowing() ? 8 : 0;
                    if (ShareAlert.this.pickerBottomLayout != null) {
                        ShareAlert.this.pickerBottomLayout.setVisibility(i4);
                        if (ShareAlert.this.sharesCountLayout != null) {
                            ShareAlert.this.sharesCountLayout.setVisibility(i4);
                        }
                    }
                }
                this.ignoreLayout = false;
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt != null && childAt.getVisibility() != 8) {
                        if (ShareAlert.this.commentTextView != null && ShareAlert.this.commentTextView.isPopupView(childAt)) {
                            if (AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                                if (AndroidUtilities.isTablet()) {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(AndroidUtilities.isTablet() ? 200.0f : 320.0f), (size3 - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                                } else {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec((size3 - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                                }
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                            }
                        } else {
                            measureChildWithMargins(childAt, widthMeasureSpec, 0, heightMeasureSpec, 0);
                        }
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
                /*
                    Method dump skipped, instructions count: 252
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ShareAlert.AnonymousClass1.onLayout(boolean, int, int, int, int):void");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (!this.fullHeight) {
                    if (ev.getAction() == 0 && ev.getY() < this.topOffset - AndroidUtilities.dp(30.0f)) {
                        ShareAlert.this.dismiss();
                        return true;
                    }
                } else if (ev.getAction() == 0 && ShareAlert.this.scrollOffsetY != 0 && ev.getY() < ShareAlert.this.scrollOffsetY - AndroidUtilities.dp(30.0f)) {
                    ShareAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !ShareAlert.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x00ad A[PHI: r0 r1 r2
              0x00ad: PHI (r0v7 int) = (r0v6 int), (r0v6 int), (r0v28 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x00ad: PHI (r1v11 int) = (r1v10 int), (r1v10 int), (r1v31 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x00ad: PHI (r2v8 int) = (r2v7 int), (r2v7 int), (r2v20 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r14) {
                /*
                    Method dump skipped, instructions count: 467
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ShareAlert.AnonymousClass1.onDraw(android.graphics.Canvas):void");
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                canvas.save();
                canvas.clipRect(0.0f, getPaddingTop() + ShareAlert.this.currentPanTranslationY, getMeasuredWidth(), getMeasuredHeight() + ShareAlert.this.currentPanTranslationY + AndroidUtilities.dp(50.0f));
                super.dispatchDraw(canvas);
                canvas.restore();
            }
        };
        this.containerView = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setWillNotDraw(false);
        this.containerView.setClipChildren(false);
        ViewGroup viewGroup = this.containerView;
        int i3 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i3, 0, i3, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        frameLayout.setBackgroundColor(getThemedColor(this.darkTheme ? "voipgroup_inviteMembersBackground" : "dialogBackground"));
        if (this.darkTheme && this.linkToCopy[1] != null) {
            SwitchView switchView = new SwitchView(context) { // from class: ir.eitaa.ui.Components.ShareAlert.2
                @Override // ir.eitaa.ui.Components.ShareAlert.SwitchView
                protected void onTabSwitch(int num) {
                    if (ShareAlert.this.pickerBottomLayout == null) {
                        return;
                    }
                    if (num == 0) {
                        ShareAlert.this.pickerBottomLayout.setText(LocaleController.getString("VoipGroupCopySpeakerLink", R.string.VoipGroupCopySpeakerLink).toUpperCase());
                    } else {
                        ShareAlert.this.pickerBottomLayout.setText(LocaleController.getString("VoipGroupCopyListenLink", R.string.VoipGroupCopyListenLink).toUpperCase());
                    }
                }
            };
            this.switchView = switchView;
            this.frameLayout.addView(switchView, LayoutHelper.createFrame(-1, 36.0f, 51, 0.0f, 11.0f, 0.0f, 0.0f));
        }
        SearchField searchField = new SearchField(context);
        this.searchView = searchField;
        this.frameLayout.addView(searchField, LayoutHelper.createFrame(-1, 58.0f, 83, z ? 48.0f : 0.0f, 0.0f, 0.0f, 0.0f));
        final Switch r3 = new Switch(context);
        r3.setChecked(true, true);
        r3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.ShareAlert.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ShareAlert.this.isCheck = !r3.isCheck;
                r3.setChecked(ShareAlert.this.isCheck, true);
            }
        });
        this.frameLayout.addView(r3, LayoutHelper.createFrame(40, -2.0f, 51, 7.0f, 14.0f, 0.0f, 0.0f));
        r3.setVisibility(z ? 0 : 8);
        TextView textView = new TextView(context);
        textView.setPadding(AndroidUtilities.dp(7.0f), AndroidUtilities.dp(7.0f), 0, 0);
        textView.setTextColor(1711276032);
        textView.setText(LocaleController.getString("Quote", R.string.Quote));
        this.frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2, 51));
        textView.setVisibility(z ? 0 : 8);
        RecyclerListView recyclerListView = new RecyclerListView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ShareAlert.4
            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float x, float y) {
                return y >= ((float) (AndroidUtilities.dp((!ShareAlert.this.darkTheme || ShareAlert.this.linkToCopy[1] == null) ? 58.0f : 111.0f) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
            }
        };
        this.gridView = recyclerListView;
        recyclerListView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
        this.gridView.setClipToPadding(false);
        RecyclerListView recyclerListView2 = this.gridView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        this.layoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.ShareAlert.5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                if (position == 0) {
                    return ShareAlert.this.layoutManager.getSpanCount();
                }
                return 1;
            }
        });
        this.gridView.setHorizontalScrollBarEnabled(false);
        this.gridView.setVerticalScrollBarEnabled(false);
        this.gridView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.Components.ShareAlert.6
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                RecyclerListView.Holder holder = (RecyclerListView.Holder) parent.getChildViewHolder(view);
                if (holder != null) {
                    int adapterPosition = holder.getAdapterPosition() % 4;
                    outRect.left = adapterPosition == 0 ? 0 : AndroidUtilities.dp(4.0f);
                    outRect.right = adapterPosition != 3 ? AndroidUtilities.dp(4.0f) : 0;
                } else {
                    outRect.left = AndroidUtilities.dp(4.0f);
                    outRect.right = AndroidUtilities.dp(4.0f);
                }
            }
        });
        this.containerView.addView(this.gridView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        RecyclerListView recyclerListView3 = this.gridView;
        ShareDialogsAdapter shareDialogsAdapter = new ShareDialogsAdapter(context);
        this.listAdapter = shareDialogsAdapter;
        recyclerListView3.setAdapter(shareDialogsAdapter);
        this.gridView.setGlowColor(getThemedColor(this.darkTheme ? "voipgroup_inviteMembersBackground" : "dialogScrollGlow"));
        this.gridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$SZrtx6m82rZz-lk-J0_-VbeqLgs
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) throws InterruptedException {
                this.f$0.lambda$new$2$ShareAlert(view, i4);
            }
        });
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ShareAlert.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy != 0) {
                    ShareAlert.this.updateLayout();
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.previousScrollOffsetY = shareAlert.scrollOffsetY;
                }
            }
        });
        RecyclerListView recyclerListView4 = new RecyclerListView(context, resourcesProvider) { // from class: ir.eitaa.ui.Components.ShareAlert.8
            @Override // ir.eitaa.ui.Components.RecyclerListView, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                ShareAlert.this.recyclerItemsEnterAnimator.dispatchDraw();
                super.dispatchDraw(canvas);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                ShareAlert.this.recyclerItemsEnterAnimator.onDetached();
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float x, float y) {
                return y >= ((float) (AndroidUtilities.dp((!ShareAlert.this.darkTheme || ShareAlert.this.linkToCopy[1] == null) ? 58.0f : 111.0f) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
            }
        };
        this.searchGridView = recyclerListView4;
        recyclerListView4.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
        this.searchGridView.setClipToPadding(false);
        RecyclerListView recyclerListView5 = this.searchGridView;
        FillLastGridLayoutManager fillLastGridLayoutManager = new FillLastGridLayoutManager(getContext(), 4, 0, this.searchGridView);
        this.searchLayoutManager = fillLastGridLayoutManager;
        recyclerListView5.setLayoutManager(fillLastGridLayoutManager);
        this.searchLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.eitaa.ui.Components.ShareAlert.9
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return ShareAlert.this.searchAdapter.getSpanSize(4, position);
            }
        });
        this.searchGridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$1lwjSFaqycD4VZ-H3HY9mIxSppU
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) throws InterruptedException {
                this.f$0.lambda$new$3$ShareAlert(view, i4);
            }
        });
        this.searchGridView.setHasFixedSize(true);
        this.searchGridView.setItemAnimator(null);
        this.searchGridView.setHorizontalScrollBarEnabled(false);
        this.searchGridView.setVerticalScrollBarEnabled(false);
        this.searchGridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.ShareAlert.10
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy != 0) {
                    ShareAlert.this.updateLayout();
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.previousScrollOffsetY = shareAlert.scrollOffsetY;
                }
            }
        });
        this.searchGridView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ir.eitaa.ui.Components.ShareAlert.11
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                RecyclerListView.Holder holder = (RecyclerListView.Holder) parent.getChildViewHolder(view);
                if (holder != null) {
                    int adapterPosition = holder.getAdapterPosition() % 4;
                    outRect.left = adapterPosition == 0 ? 0 : AndroidUtilities.dp(4.0f);
                    outRect.right = adapterPosition != 3 ? AndroidUtilities.dp(4.0f) : 0;
                } else {
                    outRect.left = AndroidUtilities.dp(4.0f);
                    outRect.right = AndroidUtilities.dp(4.0f);
                }
            }
        });
        this.searchGridView.setAdapter(this.searchAdapter);
        this.searchGridView.setGlowColor(getThemedColor(this.darkTheme ? "voipgroup_inviteMembersBackground" : "dialogScrollGlow"));
        this.recyclerItemsEnterAnimator = new RecyclerItemsEnterAnimator(this.searchGridView, true);
        FlickerLoadingView flickerLoadingView = new FlickerLoadingView(context, resourcesProvider);
        flickerLoadingView.setViewType(12);
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context, flickerLoadingView, resourcesProvider);
        this.searchEmptyView = emptyTextProgressView;
        emptyTextProgressView.setShowAtCenter(true);
        this.searchEmptyView.showTextView();
        this.searchEmptyView.setText(LocaleController.getString("NoChats", R.string.NoChats));
        this.searchGridView.setEmptyView(this.searchEmptyView);
        this.searchGridView.setHideIfEmpty(false);
        this.searchGridView.setAnimateEmptyView(true, 0);
        this.containerView.addView(this.searchEmptyView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 52.0f, 0.0f, 0.0f));
        this.containerView.addView(this.searchGridView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp((!this.darkTheme || this.linkToCopy[1] == null) ? 58.0f : 111.0f);
        this.shadow[0] = new View(context);
        this.shadow[0].setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.shadow[0].setAlpha(0.0f);
        this.shadow[0].setTag(1);
        this.containerView.addView(this.shadow[0], layoutParams);
        this.containerView.addView(this.frameLayout, LayoutHelper.createFrame(-1, (!this.darkTheme || this.linkToCopy[1] == null) ? 58 : R.styleable.AppCompatTheme_windowActionBar, 51));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams2.bottomMargin = AndroidUtilities.dp(48.0f);
        this.shadow[1] = new View(context);
        this.shadow[1].setBackgroundColor(getThemedColor("dialogShadowLine"));
        this.containerView.addView(this.shadow[1], layoutParams2);
        if (this.isChannel || this.linkToCopy[0] != null) {
            TextView textView2 = new TextView(context);
            this.pickerBottomLayout = textView2;
            textView2.setBackgroundDrawable(Theme.createSelectorWithBackgroundDrawable(getThemedColor(this.darkTheme ? "voipgroup_inviteMembersBackground" : "dialogBackground"), getThemedColor(this.darkTheme ? "voipgroup_listSelector" : "listSelectorSDK21")));
            this.pickerBottomLayout.setTextColor(getThemedColor(this.darkTheme ? "voipgroup_listeningText" : "dialogTextBlue2"));
            this.pickerBottomLayout.setTextSize(1, 14.0f);
            this.pickerBottomLayout.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            this.pickerBottomLayout.setTypeface(AndroidUtilities.getFontFamily(true));
            this.pickerBottomLayout.setGravity(17);
            if (this.darkTheme && this.linkToCopy[1] != null) {
                this.pickerBottomLayout.setText(LocaleController.getString("VoipGroupCopySpeakerLink", R.string.VoipGroupCopySpeakerLink).toUpperCase());
            } else {
                this.pickerBottomLayout.setText(LocaleController.getString("CopyLink", R.string.CopyLink).toUpperCase());
            }
            this.pickerBottomLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$w3OlV9Vf-v81gH4MCWHJ5n9wsCs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$4$ShareAlert(view);
                }
            });
            this.containerView.addView(this.pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
            ChatActivity chatActivity = this.parentFragment;
            if (chatActivity != null && ChatObject.hasAdminRights(chatActivity.getCurrentChat()) && this.sendingMessageObjects.size() > 0 && this.sendingMessageObjects.get(0).messageOwner.forwards > 0) {
                final MessageObject messageObject2 = this.sendingMessageObjects.get(0);
                if (!messageObject2.isForwarded()) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    this.sharesCountLayout = linearLayout;
                    linearLayout.setOrientation(0);
                    this.sharesCountLayout.setGravity(16);
                    this.sharesCountLayout.setBackgroundDrawable(Theme.createSelectorDrawable(getThemedColor(this.darkTheme ? "voipgroup_listSelector" : "listSelectorSDK21"), 2));
                    this.containerView.addView(this.sharesCountLayout, LayoutHelper.createFrame(-2, 48.0f, 85, 6.0f, 0.0f, -6.0f, 0.0f));
                    this.sharesCountLayout.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$hHJrHk2VPgRxavXcN_mTgTYbJlU
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$new$5$ShareAlert(messageObject2, view);
                        }
                    });
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(R.drawable.share_arrow);
                    imageView.setColorFilter(new PorterDuffColorFilter(getThemedColor(this.darkTheme ? "voipgroup_listeningText" : "dialogTextBlue2"), PorterDuff.Mode.MULTIPLY));
                    this.sharesCountLayout.addView(imageView, LayoutHelper.createLinear(-2, -1, 16, 20, 0, 0, 0));
                    TextView textView3 = new TextView(context);
                    textView3.setText(String.format("%d", Integer.valueOf(messageObject2.messageOwner.forwards)));
                    textView3.setTextSize(1, 14.0f);
                    textView3.setTextColor(getThemedColor(this.darkTheme ? "voipgroup_listeningText" : "dialogTextBlue2"));
                    textView3.setGravity(16);
                    textView3.setTypeface(AndroidUtilities.getFontFamily(true));
                    this.sharesCountLayout.addView(textView3, LayoutHelper.createLinear(-2, -1, 16, 8, 0, 20, 0));
                }
            }
        } else {
            this.shadow[1].setAlpha(0.0f);
        }
        AnonymousClass12 anonymousClass12 = new AnonymousClass12(context);
        this.frameLayout2 = anonymousClass12;
        anonymousClass12.setWillNotDraw(false);
        this.frameLayout2.setAlpha(0.0f);
        this.frameLayout2.setVisibility(4);
        this.containerView.addView(this.frameLayout2, LayoutHelper.createFrame(-1, -2, 83));
        this.frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$Xxpvfn4Np6pwFoe4zOIT84RK9dM
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ShareAlert.lambda$new$6(view, motionEvent);
            }
        });
        AnonymousClass13 anonymousClass13 = new AnonymousClass13(context, sizeNotifierFrameLayout, null, 1, resourcesProvider);
        this.commentTextView = anonymousClass13;
        if (forCall) {
            anonymousClass13.getEditText().setTextColor(getThemedColor("voipgroup_nameText"));
        }
        this.commentTextView.setHint(LocaleController.getString("ShareComment", R.string.ShareComment));
        this.commentTextView.onResume();
        this.frameLayout2.addView(this.commentTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 0.0f, 84.0f, 0.0f));
        this.frameLayout2.setClipChildren(false);
        this.commentTextView.setClipChildren(false);
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.ShareAlert.14
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                super.onInitializeAccessibilityNodeInfo(info);
                info.setText(LocaleController.formatPluralString("AccDescrShareInChats", ShareAlert.this.selectedDialogs.size()));
                info.setClassName(Button.class.getName());
                info.setLongClickable(true);
                info.setClickable(true);
            }
        };
        this.writeButtonContainer = frameLayout2;
        frameLayout2.setFocusable(true);
        this.writeButtonContainer.setFocusableInTouchMode(true);
        this.writeButtonContainer.setVisibility(4);
        this.writeButtonContainer.setScaleX(0.2f);
        this.writeButtonContainer.setScaleY(0.2f);
        this.writeButtonContainer.setAlpha(0.0f);
        this.containerView.addView(this.writeButtonContainer, LayoutHelper.createFrame(60, 60.0f, 85, 0.0f, 0.0f, 6.0f, 10.0f));
        ImageView imageView2 = new ImageView(context);
        int iDp = AndroidUtilities.dp(56.0f);
        int themedColor = getThemedColor("dialogFloatingButton");
        int i4 = Build.VERSION.SDK_INT;
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, themedColor, getThemedColor(i4 >= 21 ? "dialogFloatingButtonPressed" : "dialogFloatingButton"));
        if (i4 < 21) {
            Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate2, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        imageView2.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        imageView2.setImageResource(R.drawable.attach_send);
        imageView2.setImportantForAccessibility(2);
        imageView2.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogFloatingIcon"), PorterDuff.Mode.MULTIPLY));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        if (i4 >= 21) {
            imageView2.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.Components.ShareAlert.15
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        this.writeButtonContainer.addView(imageView2, LayoutHelper.createFrame(i4 >= 21 ? 56 : 60, i4 < 21 ? 60.0f : 56.0f, 51, i4 >= 21 ? 2.0f : 0.0f, 0.0f, 0.0f, 0.0f));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$vg_Xk7Ed5cgkXGoN5dgnJ6KsxjY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$7$ShareAlert(view);
            }
        });
        this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
        this.textPaint.setTypeface(AndroidUtilities.getFontFamily(true));
        View view = new View(context) { // from class: ir.eitaa.ui.Components.ShareAlert.16
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                String str = String.format("%d", Integer.valueOf(Math.max(1, ShareAlert.this.selectedDialogs.size())));
                int iMax = Math.max(AndroidUtilities.dp(16.0f) + ((int) Math.ceil(ShareAlert.this.textPaint.measureText(str))), AndroidUtilities.dp(24.0f));
                int measuredWidth = getMeasuredWidth() / 2;
                int measuredHeight = getMeasuredHeight() / 2;
                ShareAlert.this.textPaint.setColor(ShareAlert.this.getThemedColor("dialogRoundCheckBoxCheck"));
                Paint paint = ShareAlert.this.paint;
                ShareAlert shareAlert = ShareAlert.this;
                paint.setColor(shareAlert.getThemedColor(shareAlert.darkTheme ? "voipgroup_inviteMembersBackground" : "dialogBackground"));
                int i5 = iMax / 2;
                ShareAlert.this.rect.set(measuredWidth - i5, 0.0f, i5 + measuredWidth, getMeasuredHeight());
                canvas.drawRoundRect(ShareAlert.this.rect, AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), ShareAlert.this.paint);
                ShareAlert.this.paint.setColor(ShareAlert.this.getThemedColor("dialogRoundCheckBox"));
                ShareAlert.this.rect.set(r5 + AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), r2 - AndroidUtilities.dp(2.0f), getMeasuredHeight() - AndroidUtilities.dp(2.0f));
                canvas.drawRoundRect(ShareAlert.this.rect, AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), ShareAlert.this.paint);
                canvas.drawText(str, measuredWidth - (r1 / 2), AndroidUtilities.dp(16.2f), ShareAlert.this.textPaint);
            }
        };
        this.selectedCountView = view;
        view.setAlpha(0.0f);
        this.selectedCountView.setScaleX(0.2f);
        this.selectedCountView.setScaleY(0.2f);
        this.containerView.addView(this.selectedCountView, LayoutHelper.createFrame(42, 24.0f, 85, 0.0f, 0.0f, -8.0f, 9.0f));
        updateSelectedCount(0);
        DialogsActivity.loadDialogs(AccountInstance.getInstance(this.currentAccount));
        if (this.listAdapter.dialogs.isEmpty()) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.dialogsNeedReload);
        }
        DialogsSearchAdapter.loadRecentSearch(this.currentAccount, 0, new DialogsSearchAdapter.OnRecentSearchLoaded() { // from class: ir.eitaa.ui.Components.ShareAlert.17
            @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.OnRecentSearchLoaded
            public void setRecentSearch(ArrayList<DialogsSearchAdapter.RecentSearchObject> arrayList2, LongSparseArray<DialogsSearchAdapter.RecentSearchObject> hashMap) {
                ShareAlert.this.recentSearchObjects = arrayList2;
                ShareAlert.this.recentSearchObjectsById = hashMap;
                for (int i5 = 0; i5 < ShareAlert.this.recentSearchObjects.size(); i5++) {
                    DialogsSearchAdapter.RecentSearchObject recentSearchObject = (DialogsSearchAdapter.RecentSearchObject) ShareAlert.this.recentSearchObjects.get(i5);
                    TLObject tLObject = recentSearchObject.object;
                    if (tLObject instanceof TLRPC$User) {
                        MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).putUser((TLRPC$User) recentSearchObject.object, true);
                    } else if (tLObject instanceof TLRPC$Chat) {
                        MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).putChat((TLRPC$Chat) recentSearchObject.object, true);
                    } else if (tLObject instanceof TLRPC$EncryptedChat) {
                        MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).putEncryptedChat((TLRPC$EncryptedChat) recentSearchObject.object, true);
                    }
                }
                ShareAlert.this.searchAdapter.notifyDataSetChanged();
            }
        });
        MediaDataController.getInstance(this.currentAccount).loadHints(true);
        AndroidUtilities.updateViewVisibilityAnimated(this.gridView, true, 1.0f, false);
        AndroidUtilities.updateViewVisibilityAnimated(this.searchGridView, false, 1.0f, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ShareAlert(final Context context, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$PCXEEaLa0-CSjy7SnAqeL7TQYlg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$ShareAlert(tLObject, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$ShareAlert(TLObject tLObject, Context context) {
        if (tLObject != null) {
            this.exportedMessageLink = (TLRPC$TL_exportedMessageLink) tLObject;
            if (this.copyLinkOnEnd) {
                copyLink(context);
            }
        }
        this.loadingLink = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$ShareAlert(View view, int i) throws InterruptedException {
        TLRPC$Dialog item;
        if (i >= 0 && (item = this.listAdapter.getItem(i)) != null) {
            selectDialog((ShareDialogCell) view, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$3$ShareAlert(View view, int i) throws InterruptedException {
        TLRPC$Dialog item;
        if (i >= 0 && (item = this.searchAdapter.getItem(i)) != null) {
            selectDialog((ShareDialogCell) view, item);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$4$ShareAlert(View view) {
        if (this.selectedDialogs.size() == 0) {
            if (this.isChannel || this.linkToCopy[0] != null) {
                dismiss();
                if (this.linkToCopy[0] == null && this.loadingLink) {
                    this.copyLinkOnEnd = true;
                    Toast.makeText(getContext(), LocaleController.getString("Loading", R.string.Loading), 0).show();
                } else {
                    copyLink(getContext());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$5$ShareAlert(MessageObject messageObject, View view) {
        this.parentFragment.presentFragment(new MessageStatisticActivity(messageObject));
    }

    /* renamed from: ir.eitaa.ui.Components.ShareAlert$12, reason: invalid class name */
    class AnonymousClass12 extends FrameLayout {
        private int color;
        private final Paint p;

        AnonymousClass12(Context context) {
            super(context);
            this.p = new Paint();
        }

        @Override // android.view.View
        public void setVisibility(int visibility) {
            super.setVisibility(visibility);
            if (visibility != 0) {
                ShareAlert.this.shadow[1].setTranslationY(0.0f);
            }
        }

        @Override // android.view.View
        public void setAlpha(float alpha) {
            super.setAlpha(alpha);
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (ShareAlert.this.chatActivityEnterViewAnimateFromTop != 0.0f && ShareAlert.this.chatActivityEnterViewAnimateFromTop != ShareAlert.this.frameLayout2.getTop() + ShareAlert.this.chatActivityEnterViewAnimateFromTop) {
                if (ShareAlert.this.topBackgroundAnimator != null) {
                    ShareAlert.this.topBackgroundAnimator.cancel();
                }
                ShareAlert shareAlert = ShareAlert.this;
                shareAlert.captionEditTextTopOffset = shareAlert.chatActivityEnterViewAnimateFromTop - (ShareAlert.this.frameLayout2.getTop() + ShareAlert.this.captionEditTextTopOffset);
                ShareAlert shareAlert2 = ShareAlert.this;
                shareAlert2.topBackgroundAnimator = ValueAnimator.ofFloat(shareAlert2.captionEditTextTopOffset, 0.0f);
                ShareAlert.this.topBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$12$BAwpUw85z4Fx-y7Z2R-qqBZOFTw
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onDraw$0$ShareAlert$12(valueAnimator);
                    }
                });
                ShareAlert.this.topBackgroundAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                ShareAlert.this.topBackgroundAnimator.setDuration(200L);
                ShareAlert.this.topBackgroundAnimator.start();
                ShareAlert.this.chatActivityEnterViewAnimateFromTop = 0.0f;
            }
            float measuredHeight = (ShareAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(48.0f)) * (1.0f - getAlpha());
            ShareAlert.this.shadow[1].setTranslationY((-(ShareAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(48.0f))) + ShareAlert.this.captionEditTextTopOffset + ShareAlert.this.currentPanTranslationY + measuredHeight);
            ShareAlert shareAlert3 = ShareAlert.this;
            int themedColor = shareAlert3.getThemedColor(shareAlert3.darkTheme ? "voipgroup_inviteMembersBackground" : "dialogBackground");
            if (this.color != themedColor) {
                this.color = themedColor;
                this.p.setColor(themedColor);
            }
            canvas.drawRect(0.0f, ShareAlert.this.captionEditTextTopOffset + measuredHeight, getMeasuredWidth(), getMeasuredHeight(), this.p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onDraw$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onDraw$0$ShareAlert$12(ValueAnimator valueAnimator) {
            ShareAlert.this.captionEditTextTopOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ShareAlert.this.frameLayout2.invalidate();
            invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            canvas.save();
            canvas.clipRect(0.0f, ShareAlert.this.captionEditTextTopOffset, getMeasuredWidth(), getMeasuredHeight());
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: ir.eitaa.ui.Components.ShareAlert$13, reason: invalid class name */
    class AnonymousClass13 extends EditTextEmoji {
        private ValueAnimator messageEditTextAnimator;
        private int messageEditTextPredrawHeigth;
        private int messageEditTextPredrawScrollY;
        private boolean shouldAnimateEditTextWithBounds;

        AnonymousClass13(Context context, SizeNotifierFrameLayout parent, BaseFragment fragment, int style, Theme.ResourcesProvider resourcesProvider) {
            super(context, parent, fragment, style, resourcesProvider);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (this.shouldAnimateEditTextWithBounds) {
                final EditTextCaption editText = ShareAlert.this.commentTextView.getEditText();
                editText.setOffsetY(editText.getOffsetY() - ((this.messageEditTextPredrawHeigth - editText.getMeasuredHeight()) + (this.messageEditTextPredrawScrollY - editText.getScrollY())));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(editText.getOffsetY(), 0.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$13$dzXCY5mEd5GyumWQZjizNObW3l8
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        editText.setOffsetY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                ValueAnimator valueAnimator = this.messageEditTextAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                this.messageEditTextAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(200L);
                valueAnimatorOfFloat.setInterpolator(CubicBezierInterpolator.DEFAULT);
                valueAnimatorOfFloat.start();
                this.shouldAnimateEditTextWithBounds = false;
            }
            super.dispatchDraw(canvas);
        }

        @Override // ir.eitaa.ui.Components.EditTextEmoji
        protected void onLineCountChanged(int oldLineCount, int newLineCount) {
            if (!TextUtils.isEmpty(getEditText().getText())) {
                this.shouldAnimateEditTextWithBounds = true;
                this.messageEditTextPredrawHeigth = getEditText().getMeasuredHeight();
                this.messageEditTextPredrawScrollY = getEditText().getScrollY();
                invalidate();
            } else {
                getEditText().animate().cancel();
                getEditText().setOffsetY(0.0f);
                this.shouldAnimateEditTextWithBounds = false;
            }
            ShareAlert.this.chatActivityEnterViewAnimateFromTop = r2.frameLayout2.getTop() + ShareAlert.this.captionEditTextTopOffset;
            ShareAlert.this.frameLayout2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$7$ShareAlert(View view) {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.selectedDialogs.size()) {
                if (this.sendingMessageObjects != null) {
                    while (i < this.selectedDialogs.size()) {
                        long jKeyAt = this.selectedDialogs.keyAt(i);
                        if (this.frameLayout2.getTag() != null && this.commentTextView.length() > 0) {
                            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.commentTextView.getText().toString(), jKeyAt, null, null, null, true, null, null, null, true, 0, null);
                        }
                        SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.sendingMessageObjects, jKeyAt, !this.isCheck, false, true, 0);
                        i++;
                    }
                    onSend(this.selectedDialogs, this.sendingMessageObjects.size());
                } else {
                    SwitchView switchView = this.switchView;
                    int i3 = switchView != null ? switchView.currentTab : 0;
                    if (this.sendingText[i3] != null) {
                        while (i < this.selectedDialogs.size()) {
                            long jKeyAt2 = this.selectedDialogs.keyAt(i);
                            if (this.frameLayout2.getTag() != null && this.commentTextView.length() > 0) {
                                SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.commentTextView.getText().toString(), jKeyAt2, null, null, null, true, null, null, null, true, 0, null);
                            }
                            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.sendingText[i3], jKeyAt2, null, null, null, true, null, null, null, true, 0, null);
                            i++;
                        }
                    }
                    onSend(this.selectedDialogs, 1);
                }
                ShareAlertDelegate shareAlertDelegate = this.delegate;
                if (shareAlertDelegate != null) {
                    shareAlertDelegate.didShare();
                }
                dismiss();
                return;
            }
            if (AlertsCreator.checkSlowMode(getContext(), this.currentAccount, this.selectedDialogs.keyAt(i2), this.frameLayout2.getTag() != null && this.commentTextView.length() > 0)) {
                return;
            } else {
                i2++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectDialog(ShareDialogCell shareDialogCell, TLRPC$Dialog tLRPC$Dialog) throws InterruptedException {
        if (this.hasPoll != 0 && DialogObject.isChatDialog(tLRPC$Dialog.id)) {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Long.valueOf(-tLRPC$Dialog.id));
            boolean z = ChatObject.isChannel(chat) && this.hasPoll == 2 && !chat.megagroup;
            if (z || !ChatObject.canSendPolls(chat)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), this.resourcesProvider);
                builder.setTitle(LocaleController.getString("SendMessageTitle", R.string.SendMessageTitle));
                if (z) {
                    builder.setMessage(LocaleController.getString("PublicPollCantForward", R.string.PublicPollCantForward));
                } else if (ChatObject.isActionBannedByDefault(chat, 10)) {
                    builder.setMessage(LocaleController.getString("ErrorSendRestrictedPollsAll", R.string.ErrorSendRestrictedPollsAll));
                } else {
                    builder.setMessage(LocaleController.getString("ErrorSendRestrictedPolls", R.string.ErrorSendRestrictedPolls));
                }
                builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                builder.show();
                return;
            }
        }
        if (this.selectedDialogs.indexOfKey(tLRPC$Dialog.id) >= 0) {
            this.selectedDialogs.remove(tLRPC$Dialog.id);
            if (shareDialogCell != null) {
                shareDialogCell.setChecked(false, true);
            }
            updateSelectedCount(1);
        } else {
            this.selectedDialogs.put(tLRPC$Dialog.id, tLRPC$Dialog);
            if (shareDialogCell != null) {
                shareDialogCell.setChecked(true, true);
            }
            updateSelectedCount(2);
            long j = UserConfig.getInstance(this.currentAccount).clientUserId;
            if (this.searchIsVisible) {
                TLRPC$Dialog tLRPC$Dialog2 = (TLRPC$Dialog) this.listAdapter.dialogsMap.get(tLRPC$Dialog.id);
                if (tLRPC$Dialog2 == null) {
                    this.listAdapter.dialogsMap.put(tLRPC$Dialog.id, tLRPC$Dialog);
                    this.listAdapter.dialogs.add(!this.listAdapter.dialogs.isEmpty() ? 1 : 0, tLRPC$Dialog);
                } else if (tLRPC$Dialog2.id != j) {
                    this.listAdapter.dialogs.remove(tLRPC$Dialog2);
                    this.listAdapter.dialogs.add(!this.listAdapter.dialogs.isEmpty() ? 1 : 0, tLRPC$Dialog2);
                }
                this.listAdapter.notifyDataSetChanged();
                this.updateSearchAdapter = false;
                this.searchView.searchEditText.setText("");
                checkCurrentList(false);
                this.searchView.hideKeyboard();
            }
        }
        DialogsSearchAdapter.CategoryAdapterRecycler categoryAdapterRecycler = this.searchAdapter.categoryAdapter;
        if (categoryAdapterRecycler != null) {
            categoryAdapterRecycler.notifyItemRangeChanged(0, categoryAdapterRecycler.getItemCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCurrentTop() {
        if (this.gridView.getChildCount() == 0) {
            return -1000;
        }
        int top = 0;
        View childAt = this.gridView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.gridView.findContainingViewHolder(childAt);
        if (holder == null) {
            return -1000;
        }
        int paddingTop = this.gridView.getPaddingTop();
        if (holder.getLayoutPosition() == 0 && childAt.getTop() >= 0) {
            top = childAt.getTop();
        }
        return paddingTop - top;
    }

    public void setDelegate(ShareAlertDelegate shareAlertDelegate) {
        this.delegate = shareAlertDelegate;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    public void dismissInternal() {
        super.dismissInternal();
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null) {
            editTextEmoji.onDestroy();
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null && editTextEmoji.isPopupShowing()) {
            this.commentTextView.hidePopup(true);
        } else {
            super.onBackPressed();
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        int i = NotificationCenter.dialogsNeedReload;
        if (id == i) {
            ShareDialogsAdapter shareDialogsAdapter = this.listAdapter;
            if (shareDialogsAdapter != null) {
                shareDialogsAdapter.fetchDialogs();
            }
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void updateLayout() {
        if (this.panTranslationMoveLayout) {
            return;
        }
        RecyclerListView recyclerListView = this.searchIsVisible ? this.searchGridView : this.gridView;
        if (recyclerListView.getChildCount() <= 0) {
            return;
        }
        View childAt = recyclerListView.getChildAt(0);
        for (int i = 0; i < recyclerListView.getChildCount(); i++) {
            if (recyclerListView.getChildAt(i).getTop() < childAt.getTop()) {
                childAt = recyclerListView.getChildAt(i);
            }
        }
        RecyclerListView.Holder holder = (RecyclerListView.Holder) recyclerListView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        int i2 = (top <= 0 || holder == null || holder.getAdapterPosition() != 0) ? 0 : top;
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            this.lastOffset = childAt.getTop();
            runShadowAnimation(0, false);
        } else {
            this.lastOffset = ConnectionsManager.DEFAULT_DATACENTER_ID;
            runShadowAnimation(0, true);
            top = i2;
        }
        int i3 = this.scrollOffsetY;
        if (i3 != top) {
            this.previousScrollOffsetY = i3;
            RecyclerListView recyclerListView2 = this.gridView;
            float f = top;
            int i4 = (int) (this.currentPanTranslationY + f);
            this.scrollOffsetY = i4;
            recyclerListView2.setTopGlowOffset(i4);
            RecyclerListView recyclerListView3 = this.searchGridView;
            int i5 = (int) (f + this.currentPanTranslationY);
            this.scrollOffsetY = i5;
            recyclerListView3.setTopGlowOffset(i5);
            this.frameLayout.setTranslationY(this.scrollOffsetY + this.currentPanTranslationY);
            this.searchEmptyView.setTranslationY(this.scrollOffsetY + this.currentPanTranslationY);
            this.containerView.invalidate();
        }
    }

    private void runShadowAnimation(final int num, final boolean show) {
        if ((!show || this.shadow[num].getTag() == null) && (show || this.shadow[num].getTag() != null)) {
            return;
        }
        this.shadow[num].setTag(show ? null : 1);
        if (show) {
            this.shadow[num].setVisibility(0);
        }
        AnimatorSet[] animatorSetArr = this.shadowAnimation;
        if (animatorSetArr[num] != null) {
            animatorSetArr[num].cancel();
        }
        this.shadowAnimation[num] = new AnimatorSet();
        AnimatorSet animatorSet = this.shadowAnimation[num];
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow[num];
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        this.shadowAnimation[num].setDuration(150L);
        this.shadowAnimation[num].addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ShareAlert.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (ShareAlert.this.shadowAnimation[num] == null || !ShareAlert.this.shadowAnimation[num].equals(animation)) {
                    return;
                }
                if (!show) {
                    ShareAlert.this.shadow[num].setVisibility(4);
                }
                ShareAlert.this.shadowAnimation[num] = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (ShareAlert.this.shadowAnimation[num] == null || !ShareAlert.this.shadowAnimation[num].equals(animation)) {
                    return;
                }
                ShareAlert.this.shadowAnimation[num] = null;
            }
        });
        this.shadowAnimation[num].start();
    }

    private void copyLink(Context context) {
        String str;
        final boolean z = false;
        if (this.exportedMessageLink == null && this.linkToCopy[0] == null) {
            return;
        }
        try {
            SwitchView switchView = this.switchView;
            if (switchView != null) {
                str = this.linkToCopy[switchView.currentTab];
            } else {
                str = this.linkToCopy[0];
            }
            ClipboardManager clipboardManager = (ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard");
            if (str == null) {
                str = this.exportedMessageLink.link;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText("label", str));
            ShareAlertDelegate shareAlertDelegate = this.delegate;
            if ((shareAlertDelegate == null || !shareAlertDelegate.didCopy()) && (this.parentActivity instanceof LaunchActivity)) {
                TLRPC$TL_exportedMessageLink tLRPC$TL_exportedMessageLink = this.exportedMessageLink;
                if (tLRPC$TL_exportedMessageLink != null && tLRPC$TL_exportedMessageLink.link.contains("/c/")) {
                    z = true;
                }
                ((LaunchActivity) this.parentActivity).showBulletin(new Function() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$Q5AlI_rXtAkw--E_d4ZOPbYbAx4
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return this.f$0.lambda$copyLink$8$ShareAlert(z, (BulletinFactory) obj);
                    }
                });
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$copyLink$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Bulletin lambda$copyLink$8$ShareAlert(boolean z, BulletinFactory bulletinFactory) {
        return bulletinFactory.createCopyLinkBulletin(z, this.resourcesProvider);
    }

    private boolean showCommentTextView(final boolean show) {
        if (show == (this.frameLayout2.getTag() != null)) {
            return false;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.frameLayout2.setTag(show ? 1 : null);
        if (this.commentTextView.getEditText().isFocused()) {
            AndroidUtilities.hideKeyboard(this.commentTextView.getEditText());
        }
        this.commentTextView.hidePopup(true);
        if (show) {
            this.frameLayout2.setVisibility(0);
            this.writeButtonContainer.setVisibility(0);
        }
        TextView textView = this.pickerBottomLayout;
        if (textView != null) {
            ViewCompat.setImportantForAccessibility(textView, show ? 4 : 1);
        }
        LinearLayout linearLayout = this.sharesCountLayout;
        if (linearLayout != null) {
            ViewCompat.setImportantForAccessibility(linearLayout, show ? 4 : 1);
        }
        this.animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.frameLayout2;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = show ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr));
        FrameLayout frameLayout2 = this.writeButtonContainer;
        Property property2 = View.SCALE_X;
        float[] fArr2 = new float[1];
        fArr2[0] = show ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2));
        FrameLayout frameLayout3 = this.writeButtonContainer;
        Property property3 = View.SCALE_Y;
        float[] fArr3 = new float[1];
        fArr3[0] = show ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property3, fArr3));
        FrameLayout frameLayout4 = this.writeButtonContainer;
        Property property4 = View.ALPHA;
        float[] fArr4 = new float[1];
        fArr4[0] = show ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout4, (Property<FrameLayout, Float>) property4, fArr4));
        View view = this.selectedCountView;
        Property property5 = View.SCALE_X;
        float[] fArr5 = new float[1];
        fArr5[0] = show ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property5, fArr5));
        View view2 = this.selectedCountView;
        Property property6 = View.SCALE_Y;
        float[] fArr6 = new float[1];
        fArr6[0] = show ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) property6, fArr6));
        View view3 = this.selectedCountView;
        Property property7 = View.ALPHA;
        float[] fArr7 = new float[1];
        fArr7[0] = show ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) property7, fArr7));
        TextView textView2 = this.pickerBottomLayout;
        if (textView2 == null || textView2.getVisibility() != 0) {
            View view4 = this.shadow[1];
            Property property8 = View.ALPHA;
            float[] fArr8 = new float[1];
            fArr8[0] = show ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(view4, (Property<View, Float>) property8, fArr8));
        }
        this.animatorSet.playTogether(arrayList);
        this.animatorSet.setInterpolator(new DecelerateInterpolator());
        this.animatorSet.setDuration(180L);
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.ShareAlert.19
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (animation.equals(ShareAlert.this.animatorSet)) {
                    if (!show) {
                        ShareAlert.this.frameLayout2.setVisibility(4);
                        ShareAlert.this.writeButtonContainer.setVisibility(4);
                    }
                    ShareAlert.this.animatorSet = null;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (animation.equals(ShareAlert.this.animatorSet)) {
                    ShareAlert.this.animatorSet = null;
                }
            }
        });
        this.animatorSet.start();
        return true;
    }

    public void updateSelectedCount(int animated) {
        if (this.selectedDialogs.size() == 0) {
            this.selectedCountView.setPivotX(0.0f);
            this.selectedCountView.setPivotY(0.0f);
            showCommentTextView(false);
            return;
        }
        this.selectedCountView.invalidate();
        if (!showCommentTextView(true) && animated != 0) {
            this.selectedCountView.setPivotX(AndroidUtilities.dp(21.0f));
            this.selectedCountView.setPivotY(AndroidUtilities.dp(12.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] animatorArr = new Animator[2];
            View view = this.selectedCountView;
            Property property = View.SCALE_X;
            float[] fArr = new float[2];
            fArr[0] = animated == 1 ? 1.1f : 0.9f;
            fArr[1] = 1.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
            View view2 = this.selectedCountView;
            Property property2 = View.SCALE_Y;
            float[] fArr2 = new float[2];
            fArr2[0] = animated != 1 ? 0.9f : 1.1f;
            fArr2[1] = 1.0f;
            animatorArr[1] = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property2, fArr2);
            animatorSet.playTogether(animatorArr);
            animatorSet.setInterpolator(new OvershootInterpolator());
            animatorSet.setDuration(180L);
            animatorSet.start();
            return;
        }
        this.selectedCountView.setPivotX(0.0f);
        this.selectedCountView.setPivotY(0.0f);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        EditTextEmoji editTextEmoji = this.commentTextView;
        if (editTextEmoji != null) {
            AndroidUtilities.hideKeyboard(editTextEmoji.getEditText());
        }
        super.dismiss();
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.dialogsNeedReload);
    }

    private class ShareDialogsAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private ArrayList<TLRPC$Dialog> dialogs = new ArrayList<>();
        private LongSparseArray<TLRPC$Dialog> dialogsMap = new LongSparseArray<>();

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position == 0 ? 1 : 0;
        }

        public ShareDialogsAdapter(Context context) {
            this.context = context;
            fetchDialogs();
        }

        public void fetchDialogs() {
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
            this.dialogs.clear();
            this.dialogsMap.clear();
            long j = UserConfig.getInstance(((BottomSheet) ShareAlert.this).currentAccount).clientUserId;
            if (!MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).dialogsForward.isEmpty()) {
                TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).dialogsForward.get(0);
                this.dialogs.add(tLRPC$Dialog);
                this.dialogsMap.put(tLRPC$Dialog.id, tLRPC$Dialog);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<TLRPC$Dialog> allDialogs = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getAllDialogs();
            for (int i = 0; i < allDialogs.size(); i++) {
                TLRPC$Dialog tLRPC$Dialog2 = allDialogs.get(i);
                if ((!MessagesController.getInstance(UserConfig.selectedAccount).isLockedDialog(tLRPC$Dialog2) || SharedConfig.showLockedChatsWhenForward) && (tLRPC$Dialog2 instanceof TLRPC$TL_dialog)) {
                    long j2 = tLRPC$Dialog2.id;
                    if (j2 != j && !DialogObject.isEncryptedDialog(j2)) {
                        if (!DialogObject.isUserDialog(tLRPC$Dialog2.id)) {
                            TLRPC$Chat chat = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getChat(Long.valueOf(-tLRPC$Dialog2.id));
                            if (chat != null && !ChatObject.isNotInChat(chat) && ((!chat.gigagroup || ChatObject.hasAdminRights(chat)) && (!ChatObject.isChannel(chat) || chat.creator || (((tLRPC$TL_chatAdminRights = chat.admin_rights) != null && tLRPC$TL_chatAdminRights.post_messages) || chat.megagroup)))) {
                                if (tLRPC$Dialog2.folder_id == 1) {
                                    arrayList.add(tLRPC$Dialog2);
                                } else {
                                    this.dialogs.add(tLRPC$Dialog2);
                                }
                                this.dialogsMap.put(tLRPC$Dialog2.id, tLRPC$Dialog2);
                            }
                        } else {
                            if (tLRPC$Dialog2.folder_id == 1) {
                                arrayList.add(tLRPC$Dialog2);
                            } else {
                                this.dialogs.add(tLRPC$Dialog2);
                            }
                            this.dialogsMap.put(tLRPC$Dialog2.id, tLRPC$Dialog2);
                        }
                    }
                }
            }
            this.dialogs.addAll(arrayList);
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.dialogs.size();
            return size != 0 ? size + 1 : size;
        }

        public TLRPC$Dialog getItem(int position) {
            int i = position - 1;
            if (i < 0 || i >= this.dialogs.size()) {
                return null;
            }
            return this.dialogs.get(i);
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shareDialogCell;
            if (i == 0) {
                shareDialogCell = new ShareDialogCell(this.context, ShareAlert.this.darkTheme ? 1 : 0, ShareAlert.this.resourcesProvider);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(100.0f)));
            } else {
                shareDialogCell = new View(this.context);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp((!ShareAlert.this.darkTheme || ShareAlert.this.linkToCopy[1] == null) ? 56.0f : 109.0f)));
            }
            return new RecyclerListView.Holder(shareDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder.getItemViewType() == 0) {
                ShareDialogCell shareDialogCell = (ShareDialogCell) holder.itemView;
                TLRPC$Dialog item = getItem(position);
                shareDialogCell.setDialog(item.id, ShareAlert.this.selectedDialogs.indexOfKey(item.id) >= 0, null);
            }
        }
    }

    public class ShareSearchAdapter extends RecyclerListView.SelectionAdapter {
        DialogsSearchAdapter.CategoryAdapterRecycler categoryAdapter;
        private Context context;
        int itemsCount;
        private int lastGlobalSearchId;
        int lastItemCont;
        private int lastLocalSearchId;
        private int lastSearchId;
        private String lastSearchText;
        private SearchAdapterHelper searchAdapterHelper;
        private Runnable searchRunnable;
        private Runnable searchRunnable2;
        private ArrayList<Object> searchResult = new ArrayList<>();
        int hintsCell = -1;
        int resentTitleCell = -1;
        int firstEmptyViewCell = -1;
        int recentDialogsStartRow = -1;
        int searchResultsStartRow = -1;
        int lastFilledItem = -1;
        boolean internalDialogsIsSearching = false;

        public ShareSearchAdapter(Context context) {
            this.context = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate() { // from class: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.1
                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ LongSparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onDataSetChanged(int r3) throws java.lang.InterruptedException {
                    /*
                        r2 = this;
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r0 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.access$11002(r0, r3)
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r0 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        int r0 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.access$11100(r0)
                        if (r0 == r3) goto L16
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        java.util.ArrayList r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.access$11200(r3)
                        r3.clear()
                    L16:
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        int r0 = r3.lastItemCont
                        int r3 = r3.getItemCount()
                        if (r3 != 0) goto L3c
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        ir.eitaa.ui.Adapters.SearchAdapterHelper r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.access$11300(r3)
                        boolean r3 = r3.isSearchInProgress()
                        if (r3 != 0) goto L3c
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        boolean r1 = r3.internalDialogsIsSearching
                        if (r1 != 0) goto L3c
                        ir.eitaa.ui.Components.ShareAlert r3 = ir.eitaa.ui.Components.ShareAlert.this
                        ir.eitaa.ui.Components.EmptyTextProgressView r3 = ir.eitaa.ui.Components.ShareAlert.access$1900(r3)
                        r3.showTextView()
                        goto L45
                    L3c:
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        ir.eitaa.ui.Components.ShareAlert r3 = ir.eitaa.ui.Components.ShareAlert.this
                        ir.eitaa.ui.Components.RecyclerItemsEnterAnimator r3 = r3.recyclerItemsEnterAnimator
                        r3.showItemsAnimated(r0)
                    L45:
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        r3.notifyDataSetChanged()
                        ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter r3 = ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.this
                        ir.eitaa.ui.Components.ShareAlert r3 = ir.eitaa.ui.Components.ShareAlert.this
                        r0 = 1
                        ir.eitaa.ui.Components.ShareAlert.access$1700(r3, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.AnonymousClass1.onDataSetChanged(int):void");
                }

                @Override // ir.eitaa.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public boolean canApplySearchResults(int searchId) {
                    return searchId == ShareSearchAdapter.this.lastSearchId;
                }
            });
        }

        private void searchDialogsInternal(final String query, final int searchId) {
            MessagesStorage.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$ShareSearchAdapter$BAfO3YQev56i1RLuoAbAlrnHn9I
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogsInternal$1$ShareAlert$ShareSearchAdapter(query, searchId);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:118:0x02c8  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x039f  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x041c A[Catch: Exception -> 0x0438, LOOP:7: B:149:0x0358->B:182:0x041c, LOOP_END, TryCatch #0 {Exception -> 0x0438, blocks: (B:3:0x0002, B:5:0x0011, B:7:0x001e, B:9:0x002c, B:16:0x003a, B:18:0x0041, B:19:0x0043, B:20:0x0068, B:22:0x006e, B:24:0x0086, B:26:0x0090, B:27:0x0098, B:29:0x009e, B:31:0x00a9, B:32:0x00b1, B:35:0x00c2, B:36:0x00e7, B:38:0x00ed, B:41:0x0101, B:43:0x0108, B:47:0x0113, B:49:0x011d, B:52:0x0136, B:54:0x013c, B:58:0x0154, B:65:0x0164, B:67:0x016b, B:69:0x0185, B:71:0x018d, B:73:0x01bf, B:72:0x0198, B:75:0x01cd, B:78:0x01e4, B:80:0x01f1, B:82:0x01f7, B:83:0x021d, B:85:0x0223, B:90:0x023a, B:92:0x0242, B:95:0x0259, B:97:0x025f, B:100:0x0275, B:101:0x0278, B:103:0x027f, B:105:0x028c, B:107:0x0292, B:109:0x0298, B:111:0x029c, B:113:0x02a0, B:115:0x02a4, B:117:0x02a8, B:120:0x02ce, B:122:0x02d6, B:123:0x02dc, B:125:0x02e2, B:127:0x02ec, B:129:0x02f0, B:131:0x02fe, B:133:0x0302, B:134:0x0305, B:135:0x0308, B:136:0x031f, B:138:0x0325, B:141:0x0331, B:144:0x0345, B:146:0x034e, B:150:0x035a, B:152:0x0362, B:155:0x0379, B:157:0x037f, B:161:0x0397, B:166:0x03a2, B:168:0x03a9, B:170:0x03bd, B:171:0x03c4, B:173:0x03cf, B:175:0x0402, B:177:0x0410, B:179:0x0414, B:174:0x03db, B:182:0x041c, B:185:0x042a), top: B:190:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:207:0x0164 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:230:0x03a2 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01cd A[Catch: Exception -> 0x0438, LOOP:2: B:46:0x0111->B:75:0x01cd, LOOP_END, TryCatch #0 {Exception -> 0x0438, blocks: (B:3:0x0002, B:5:0x0011, B:7:0x001e, B:9:0x002c, B:16:0x003a, B:18:0x0041, B:19:0x0043, B:20:0x0068, B:22:0x006e, B:24:0x0086, B:26:0x0090, B:27:0x0098, B:29:0x009e, B:31:0x00a9, B:32:0x00b1, B:35:0x00c2, B:36:0x00e7, B:38:0x00ed, B:41:0x0101, B:43:0x0108, B:47:0x0113, B:49:0x011d, B:52:0x0136, B:54:0x013c, B:58:0x0154, B:65:0x0164, B:67:0x016b, B:69:0x0185, B:71:0x018d, B:73:0x01bf, B:72:0x0198, B:75:0x01cd, B:78:0x01e4, B:80:0x01f1, B:82:0x01f7, B:83:0x021d, B:85:0x0223, B:90:0x023a, B:92:0x0242, B:95:0x0259, B:97:0x025f, B:100:0x0275, B:101:0x0278, B:103:0x027f, B:105:0x028c, B:107:0x0292, B:109:0x0298, B:111:0x029c, B:113:0x02a0, B:115:0x02a4, B:117:0x02a8, B:120:0x02ce, B:122:0x02d6, B:123:0x02dc, B:125:0x02e2, B:127:0x02ec, B:129:0x02f0, B:131:0x02fe, B:133:0x0302, B:134:0x0305, B:135:0x0308, B:136:0x031f, B:138:0x0325, B:141:0x0331, B:144:0x0345, B:146:0x034e, B:150:0x035a, B:152:0x0362, B:155:0x0379, B:157:0x037f, B:161:0x0397, B:166:0x03a2, B:168:0x03a9, B:170:0x03bd, B:171:0x03c4, B:173:0x03cf, B:175:0x0402, B:177:0x0410, B:179:0x0414, B:174:0x03db, B:182:0x041c, B:185:0x042a), top: B:190:0x0002 }] */
        /* JADX WARN: Type inference failed for: r11v23 */
        /* JADX WARN: Type inference failed for: r11v24 */
        /* JADX WARN: Type inference failed for: r11v29 */
        /* JADX WARN: Type inference failed for: r11v31 */
        /* JADX WARN: Type inference failed for: r20v0, types: [ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter] */
        /* renamed from: lambda$searchDialogsInternal$1, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$searchDialogsInternal$1$ShareAlert$ShareSearchAdapter(java.lang.String r21, int r22) {
            /*
                Method dump skipped, instructions count: 1085
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.lambda$searchDialogsInternal$1$ShareAlert$ShareSearchAdapter(java.lang.String, int):void");
        }

        static /* synthetic */ int lambda$searchDialogsInternal$0(Object obj, Object obj2) {
            int i = ((DialogSearchResult) obj).date;
            int i2 = ((DialogSearchResult) obj2).date;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }

        private void updateSearchResults(final ArrayList<Object> result, final int searchId) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$ShareSearchAdapter$ZFGkIpYODiAsn5kvcMe5BGh8FVE
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$updateSearchResults$2$ShareAlert$ShareSearchAdapter(searchId, result);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$updateSearchResults$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$updateSearchResults$2$ShareAlert$ShareSearchAdapter(int i, ArrayList arrayList) throws InterruptedException {
            if (i != this.lastSearchId) {
                return;
            }
            getItemCount();
            boolean z = false;
            this.internalDialogsIsSearching = false;
            this.lastLocalSearchId = i;
            if (this.lastGlobalSearchId != i) {
                this.searchAdapterHelper.clear();
            }
            if (ShareAlert.this.gridView.getAdapter() != ShareAlert.this.searchAdapter) {
                ShareAlert shareAlert = ShareAlert.this;
                shareAlert.topBeforeSwitch = shareAlert.getCurrentTop();
                ShareAlert.this.searchAdapter.notifyDataSetChanged();
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                TLObject tLObject = ((DialogSearchResult) arrayList.get(i2)).object;
                if (tLObject instanceof TLRPC$User) {
                    MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).putUser((TLRPC$User) tLObject, true);
                } else if (tLObject instanceof TLRPC$Chat) {
                    MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).putChat((TLRPC$Chat) tLObject, true);
                }
            }
            if (!this.searchResult.isEmpty() && arrayList.isEmpty()) {
                z = true;
            }
            if (this.searchResult.isEmpty()) {
                arrayList.isEmpty();
            }
            if (z) {
                ShareAlert shareAlert2 = ShareAlert.this;
                shareAlert2.topBeforeSwitch = shareAlert2.getCurrentTop();
            }
            this.searchResult = arrayList;
            this.searchAdapterHelper.mergeResults(arrayList);
            int i3 = this.lastItemCont;
            if (getItemCount() == 0 && !this.searchAdapterHelper.isSearchInProgress() && !this.internalDialogsIsSearching) {
                ShareAlert.this.searchEmptyView.showTextView();
            } else {
                ShareAlert.this.recyclerItemsEnterAnimator.showItemsAnimated(i3);
            }
            notifyDataSetChanged();
            ShareAlert.this.checkCurrentList(true);
        }

        public void searchDialogs(final String query) throws InterruptedException {
            if (query == null || !query.equals(this.lastSearchText)) {
                this.lastSearchText = query;
                if (this.searchRunnable != null) {
                    Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                    this.searchRunnable = null;
                }
                Runnable runnable = this.searchRunnable2;
                if (runnable != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable);
                    this.searchRunnable2 = null;
                }
                this.searchResult.clear();
                this.searchAdapterHelper.mergeResults(null);
                this.searchAdapterHelper.queryServerSearch(null, true, true, true, true, false, 0L, false, 0, 0);
                notifyDataSetChanged();
                ShareAlert.this.checkCurrentList(true);
                if (TextUtils.isEmpty(query)) {
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.topBeforeSwitch = shareAlert.getCurrentTop();
                    this.lastSearchId = -1;
                    this.internalDialogsIsSearching = false;
                } else {
                    this.internalDialogsIsSearching = true;
                    final int i = this.lastSearchId + 1;
                    this.lastSearchId = i;
                    ShareAlert.this.searchEmptyView.showProgress(false);
                    DispatchQueue dispatchQueue = Utilities.searchQueue;
                    Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$ShareSearchAdapter$Dl-C2u7hEjTMI5HX3S2M3I0H0lk
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$searchDialogs$4$ShareAlert$ShareSearchAdapter(query, i);
                        }
                    };
                    this.searchRunnable = runnable2;
                    dispatchQueue.postRunnable(runnable2, 300L);
                }
                ShareAlert.this.checkCurrentList(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchDialogs$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchDialogs$4$ShareAlert$ShareSearchAdapter(final String str, final int i) {
            this.searchRunnable = null;
            searchDialogsInternal(str, i);
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$ShareSearchAdapter$U1ZrfLxOBwLc5-4tt9o1bD7lgeQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$3$ShareAlert$ShareSearchAdapter(i, str);
                }
            };
            this.searchRunnable2 = runnable;
            AndroidUtilities.runOnUIThread(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$searchDialogs$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$searchDialogs$3$ShareAlert$ShareSearchAdapter(int i, String str) {
            this.searchRunnable2 = null;
            if (i != this.lastSearchId) {
                return;
            }
            this.searchAdapterHelper.queryServerSearch(str, true, true, true, true, false, 0L, false, 0, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            this.itemsCount = 0;
            this.hintsCell = -1;
            this.resentTitleCell = -1;
            this.recentDialogsStartRow = -1;
            this.searchResultsStartRow = -1;
            this.lastFilledItem = -1;
            if (TextUtils.isEmpty(this.lastSearchText)) {
                int i = this.itemsCount;
                int i2 = i + 1;
                this.itemsCount = i2;
                this.firstEmptyViewCell = i;
                this.itemsCount = i2 + 1;
                this.hintsCell = i2;
                if (ShareAlert.this.recentSearchObjects.size() > 0) {
                    int i3 = this.itemsCount;
                    int i4 = i3 + 1;
                    this.itemsCount = i4;
                    this.resentTitleCell = i3;
                    this.recentDialogsStartRow = i4;
                    this.itemsCount = i4 + ShareAlert.this.recentSearchObjects.size();
                }
                int i5 = this.itemsCount;
                int i6 = i5 + 1;
                this.itemsCount = i6;
                this.lastFilledItem = i5;
                this.lastItemCont = i6;
                return i6;
            }
            int i7 = this.itemsCount;
            int i8 = i7 + 1;
            this.itemsCount = i8;
            this.firstEmptyViewCell = i7;
            this.searchResultsStartRow = i8;
            int size = i8 + this.searchResult.size() + this.searchAdapterHelper.getLocalServerSearch().size();
            this.itemsCount = size;
            if (size == 1) {
                this.firstEmptyViewCell = -1;
                this.itemsCount = 0;
                this.lastItemCont = 0;
                return 0;
            }
            int i9 = size + 1;
            this.itemsCount = i9;
            this.lastFilledItem = size;
            this.lastItemCont = i9;
            return i9;
        }

        public TLRPC$Dialog getItem(int position) {
            int i = this.recentDialogsStartRow;
            if (position >= i && i >= 0) {
                TLObject tLObject = ((DialogsSearchAdapter.RecentSearchObject) ShareAlert.this.recentSearchObjects.get(position - this.recentDialogsStartRow)).object;
                TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
                if (tLObject instanceof TLRPC$User) {
                    tLRPC$TL_dialog.id = ((TLRPC$User) tLObject).id;
                } else {
                    tLRPC$TL_dialog.id = -((TLRPC$Chat) tLObject).id;
                }
                return tLRPC$TL_dialog;
            }
            int i2 = position - 1;
            TLRPC$TL_dialog tLRPC$TL_dialog2 = null;
            if (i2 < 0) {
                return null;
            }
            if (i2 < this.searchResult.size()) {
                return ((DialogSearchResult) this.searchResult.get(i2)).dialog;
            }
            int size = i2 - this.searchResult.size();
            ArrayList<TLObject> localServerSearch = this.searchAdapterHelper.getLocalServerSearch();
            if (size < localServerSearch.size()) {
                TLObject tLObject2 = localServerSearch.get(size);
                tLRPC$TL_dialog2 = new TLRPC$TL_dialog();
                if (tLObject2 instanceof TLRPC$User) {
                    tLRPC$TL_dialog2.id = ((TLRPC$User) tLObject2).id;
                } else {
                    tLRPC$TL_dialog2.id = -((TLRPC$Chat) tLObject2).id;
                }
            }
            return tLRPC$TL_dialog2;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return (holder.getItemViewType() == 1 || holder.getItemViewType() == 4) ? false : true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v3, types: [android.view.ViewGroup, androidx.recyclerview.widget.RecyclerView, ir.eitaa.ui.Components.RecyclerListView, ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter$2] */
        /* JADX WARN: Type inference failed for: r5v4, types: [ir.eitaa.ui.Cells.GraySectionCell] */
        /* JADX WARN: Type inference failed for: r5v5, types: [ir.eitaa.ui.Components.ShareAlert$ShareSearchAdapter$5] */
        /* JADX WARN: Type inference failed for: r5v6, types: [android.view.View] */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ShareDialogCell shareDialogCell;
            if (i != 0) {
                boolean z = true;
                if (i == 2) {
                    ?? r5 = new RecyclerListView(this.context, ShareAlert.this.resourcesProvider) { // from class: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.2
                        @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
                        public boolean onInterceptTouchEvent(MotionEvent e) {
                            if (getParent() != null && getParent().getParent() != null) {
                                ViewParent parent = getParent().getParent();
                                boolean z2 = true;
                                if (!canScrollHorizontally(-1) && !canScrollHorizontally(1)) {
                                    z2 = false;
                                }
                                parent.requestDisallowInterceptTouchEvent(z2);
                            }
                            return super.onInterceptTouchEvent(e);
                        }
                    };
                    r5.setItemAnimator(null);
                    r5.setLayoutAnimation(null);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.context) { // from class: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.3
                        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                        public boolean supportsPredictiveItemAnimations() {
                            return false;
                        }
                    };
                    linearLayoutManager.setOrientation(0);
                    r5.setLayoutManager(linearLayoutManager);
                    DialogsSearchAdapter.CategoryAdapterRecycler categoryAdapterRecycler = new DialogsSearchAdapter.CategoryAdapterRecycler(this.context, ((BottomSheet) ShareAlert.this).currentAccount, z) { // from class: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.4
                        @Override // ir.eitaa.ui.Adapters.DialogsSearchAdapter.CategoryAdapterRecycler, androidx.recyclerview.widget.RecyclerView.Adapter
                        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                            TLRPC$Chat chat;
                            String firstName;
                            HintDialogCell hintDialogCell = (HintDialogCell) holder.itemView;
                            TLRPC$TL_topPeer tLRPC$TL_topPeer = MediaDataController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).hints.get(position);
                            TLRPC$Peer tLRPC$Peer = tLRPC$TL_topPeer.peer;
                            long j = tLRPC$Peer.user_id;
                            TLRPC$User user = null;
                            if (j != 0) {
                                user = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getUser(Long.valueOf(tLRPC$TL_topPeer.peer.user_id));
                                chat = null;
                            } else {
                                long j2 = tLRPC$Peer.channel_id;
                                if (j2 != 0) {
                                    j = -j2;
                                    chat = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getChat(Long.valueOf(tLRPC$TL_topPeer.peer.channel_id));
                                } else {
                                    long j3 = tLRPC$Peer.chat_id;
                                    if (j3 != 0) {
                                        j = -j3;
                                        chat = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getChat(Long.valueOf(tLRPC$TL_topPeer.peer.chat_id));
                                    } else {
                                        chat = null;
                                        j = 0;
                                    }
                                }
                            }
                            boolean z2 = j == hintDialogCell.getDialogId();
                            hintDialogCell.setTag(Long.valueOf(j));
                            if (user != null) {
                                firstName = UserObject.getFirstName(user);
                            } else {
                                firstName = chat != null ? chat.title : "";
                            }
                            hintDialogCell.setDialog(j, true, firstName);
                            hintDialogCell.setChecked(ShareAlert.this.selectedDialogs.indexOfKey(j) >= 0, z2);
                        }
                    };
                    this.categoryAdapter = categoryAdapterRecycler;
                    r5.setAdapter(categoryAdapterRecycler);
                    r5.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ShareAlert$ShareSearchAdapter$VJBmlltTMLPdeQSRlztiYt6OtCU
                        @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
                        public final void onItemClick(View view, int i2) throws InterruptedException {
                            this.f$0.lambda$onCreateViewHolder$5$ShareAlert$ShareSearchAdapter(view, i2);
                        }
                    });
                    shareDialogCell = r5;
                } else if (i == 3) {
                    ?? graySectionCell = new GraySectionCell(this.context, ShareAlert.this.resourcesProvider);
                    graySectionCell.setText(LocaleController.getString("Recent", R.string.Recent));
                    shareDialogCell = graySectionCell;
                } else if (i != 4) {
                    ?? view = new View(this.context);
                    view.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp((!ShareAlert.this.darkTheme || ShareAlert.this.linkToCopy[1] == null) ? 56.0f : 109.0f)));
                    shareDialogCell = view;
                } else {
                    shareDialogCell = new View(this.context) { // from class: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.5
                        @Override // android.view.View
                        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(ShareAlert.this.searchLayoutManager.lastItemHeight, 1073741824));
                        }
                    };
                }
            } else {
                ShareDialogCell shareDialogCell2 = new ShareDialogCell(this.context, ShareAlert.this.darkTheme ? 1 : 0, ShareAlert.this.resourcesProvider);
                shareDialogCell2.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(100.0f)));
                shareDialogCell = shareDialogCell2;
            }
            return new RecyclerListView.Holder(shareDialogCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0028 A[PHI: r1
          0x0028: PHI (r1v5 long) = (r1v2 long), (r1v3 long) binds: [B:6:0x0026, B:9:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
        /* renamed from: lambda$onCreateViewHolder$5, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ void lambda$onCreateViewHolder$5$ShareAlert$ShareSearchAdapter(android.view.View r7, int r8) throws java.lang.InterruptedException {
            /*
                r6 = this;
                ir.eitaa.ui.Components.ShareAlert r0 = ir.eitaa.ui.Components.ShareAlert.this
                int r0 = ir.eitaa.ui.Components.ShareAlert.access$12300(r0)
                ir.eitaa.messenger.MediaDataController r0 = ir.eitaa.messenger.MediaDataController.getInstance(r0)
                java.util.ArrayList<ir.eitaa.tgnet.TLRPC$TL_topPeer> r0 = r0.hints
                java.lang.Object r8 = r0.get(r8)
                ir.eitaa.tgnet.TLRPC$TL_topPeer r8 = (ir.eitaa.tgnet.TLRPC$TL_topPeer) r8
                ir.eitaa.tgnet.TLRPC$TL_dialog r0 = new ir.eitaa.tgnet.TLRPC$TL_dialog
                r0.<init>()
                ir.eitaa.tgnet.TLRPC$Peer r8 = r8.peer
                long r1 = r8.user_id
                r3 = 0
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L22
                goto L32
            L22:
                long r1 = r8.channel_id
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L2a
            L28:
                long r1 = -r1
                goto L32
            L2a:
                long r1 = r8.chat_id
                int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r8 == 0) goto L31
                goto L28
            L31:
                r1 = r3
            L32:
                r0.id = r1
                ir.eitaa.ui.Components.ShareAlert r8 = ir.eitaa.ui.Components.ShareAlert.this
                r3 = 0
                ir.eitaa.ui.Components.ShareAlert.access$12400(r8, r3, r0)
                ir.eitaa.ui.Cells.HintDialogCell r7 = (ir.eitaa.ui.Cells.HintDialogCell) r7
                ir.eitaa.ui.Components.ShareAlert r8 = ir.eitaa.ui.Components.ShareAlert.this
                androidx.collection.LongSparseArray r8 = ir.eitaa.ui.Components.ShareAlert.access$8700(r8)
                int r8 = r8.indexOfKey(r1)
                r0 = 1
                if (r8 < 0) goto L4b
                r8 = 1
                goto L4c
            L4b:
                r8 = 0
            L4c:
                r7.setChecked(r8, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.Components.ShareAlert.ShareSearchAdapter.lambda$onCreateViewHolder$5$ShareAlert$ShareSearchAdapter(android.view.View, int):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            long j;
            CharSequence name;
            int iIndexOfIgnoreCase;
            TLRPC$User user;
            int iIndexOfIgnoreCase2;
            if (holder.getItemViewType() == 0) {
                ShareDialogCell shareDialogCell = (ShareDialogCell) holder.itemView;
                String name2 = null;
                long j2 = 0;
                if (TextUtils.isEmpty(this.lastSearchText)) {
                    int i = this.recentDialogsStartRow;
                    if (i >= 0 && position >= i) {
                        TLObject tLObject = ((DialogsSearchAdapter.RecentSearchObject) ShareAlert.this.recentSearchObjects.get(position - i)).object;
                        if (tLObject instanceof TLRPC$User) {
                            TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                            j2 = tLRPC$User.id;
                            name2 = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
                        } else if (tLObject instanceof TLRPC$Chat) {
                            TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
                            j2 = -tLRPC$Chat.id;
                            name2 = tLRPC$Chat.title;
                        } else if ((tLObject instanceof TLRPC$TL_encryptedChat) && (user = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getUser(Long.valueOf(((TLRPC$TL_encryptedChat) tLObject).user_id))) != null) {
                            j2 = user.id;
                            name2 = ContactsController.formatName(user.first_name, user.last_name);
                        }
                        String lastFoundUsername = this.searchAdapterHelper.getLastFoundUsername();
                        if (!TextUtils.isEmpty(lastFoundUsername) && name2 != null && (iIndexOfIgnoreCase2 = AndroidUtilities.indexOfIgnoreCase(name2.toString(), lastFoundUsername)) != -1) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name2);
                            spannableStringBuilder.setSpan(new ForegroundColorSpanThemable("windowBackgroundWhiteBlueText4", ShareAlert.this.resourcesProvider), iIndexOfIgnoreCase2, lastFoundUsername.length() + iIndexOfIgnoreCase2, 33);
                            name2 = spannableStringBuilder;
                        }
                    }
                    shareDialogCell.setDialog((int) j2, ShareAlert.this.selectedDialogs.indexOfKey(j2) >= 0, name2);
                    return;
                }
                int i2 = position - 1;
                if (i2 < this.searchResult.size()) {
                    DialogSearchResult dialogSearchResult = (DialogSearchResult) this.searchResult.get(i2);
                    j = dialogSearchResult.dialog.id;
                    name = dialogSearchResult.name;
                } else {
                    TLObject tLObject2 = this.searchAdapterHelper.getLocalServerSearch().get(i2 - this.searchResult.size());
                    if (tLObject2 instanceof TLRPC$User) {
                        TLRPC$User tLRPC$User2 = (TLRPC$User) tLObject2;
                        j = tLRPC$User2.id;
                        name = ContactsController.formatName(tLRPC$User2.first_name, tLRPC$User2.last_name);
                    } else {
                        TLRPC$Chat tLRPC$Chat2 = (TLRPC$Chat) tLObject2;
                        j = -tLRPC$Chat2.id;
                        name = tLRPC$Chat2.title;
                    }
                    String lastFoundUsername2 = this.searchAdapterHelper.getLastFoundUsername();
                    if (!TextUtils.isEmpty(lastFoundUsername2) && name != null && (iIndexOfIgnoreCase = AndroidUtilities.indexOfIgnoreCase(name.toString(), lastFoundUsername2)) != -1) {
                        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(name);
                        spannableStringBuilder2.setSpan(new ForegroundColorSpanThemable("windowBackgroundWhiteBlueText4", ShareAlert.this.resourcesProvider), iIndexOfIgnoreCase, lastFoundUsername2.length() + iIndexOfIgnoreCase, 33);
                        name = spannableStringBuilder2;
                    }
                }
                shareDialogCell.setDialog(j, ShareAlert.this.selectedDialogs.indexOfKey(j) >= 0, name);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == this.lastFilledItem) {
                return 4;
            }
            if (position == this.firstEmptyViewCell) {
                return 1;
            }
            if (position == this.hintsCell) {
                return 2;
            }
            return position == this.resentTitleCell ? 3 : 0;
        }

        public int getSpanSize(int spanCount, int position) {
            if (position == this.hintsCell || position == this.resentTitleCell || position == this.firstEmptyViewCell || position == this.lastFilledItem) {
                return spanCount;
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCurrentList(boolean force) throws InterruptedException {
        boolean z = true;
        if (!TextUtils.isEmpty(this.searchView.searchEditText.getText()) || (this.keyboardVisible && this.searchView.searchEditText.hasFocus())) {
            this.updateSearchAdapter = true;
            AndroidUtilities.updateViewVisibilityAnimated(this.gridView, false, 0.98f, true);
            AndroidUtilities.updateViewVisibilityAnimated(this.searchGridView, true);
        } else {
            AndroidUtilities.updateViewVisibilityAnimated(this.gridView, true, 0.98f, true);
            AndroidUtilities.updateViewVisibilityAnimated(this.searchGridView, false);
            z = false;
        }
        if (this.searchIsVisible != z || force) {
            this.searchIsVisible = z;
            this.searchAdapter.notifyDataSetChanged();
            this.listAdapter.notifyDataSetChanged();
            if (this.searchIsVisible) {
                if (this.lastOffset == Integer.MAX_VALUE) {
                    ((LinearLayoutManager) this.searchGridView.getLayoutManager()).scrollToPositionWithOffset(0, -this.searchGridView.getPaddingTop());
                } else {
                    ((LinearLayoutManager) this.searchGridView.getLayoutManager()).scrollToPositionWithOffset(0, this.lastOffset - this.searchGridView.getPaddingTop());
                }
                this.searchAdapter.searchDialogs(this.searchView.searchEditText.getText().toString());
                return;
            }
            if (this.lastOffset == Integer.MAX_VALUE) {
                this.layoutManager.scrollToPositionWithOffset(0, 0);
            } else {
                this.layoutManager.scrollToPositionWithOffset(0, 0);
            }
        }
    }
}
