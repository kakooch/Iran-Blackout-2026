package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
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
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.ServiceLocator;
import androidMessenger.proxy.IdStorage;
import androidx.arch.core.util.Function;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.DispatchQueue;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_channels_exportMessageLink;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_exportedMessageLink;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.AdjustPanLayoutHelper;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Cells.ShareDialogCell;
import org.rbmain.ui.ChatActivity;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ShareAlert;
import org.rbmain.ui.DialogsActivity;
import org.rbmain.ui.LaunchActivity;
import org.rbmain.ui.MessageStatisticActivity;

/* loaded from: classes5.dex */
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
    private RectF rect;
    private int scrollOffsetY;
    private ShareSearchAdapter searchAdapter;
    private EmptyTextProgressView searchEmptyView;
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
    private FrameLayout writeButtonContainer;

    public static class DialogSearchResult {
        public int date;
        public TLRPC$Dialog dialog = new TLRPC$TL_dialog();
        public CharSequence name;
        public TLObject object;
    }

    public interface ShareAlertDelegate {

        /* renamed from: org.rbmain.ui.Components.ShareAlert$ShareAlertDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$didShare(ShareAlertDelegate shareAlertDelegate) {
            }
        }

        boolean didCopy();

        void didShare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$5(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    protected void onSend(LongSparseArray<TLRPC$Dialog> longSparseArray, int i) {
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

        protected void onTabSwitch(int i) {
            throw null;
        }

        public SwitchView(ShareAlert shareAlert, Context context) {
            super(context);
            this.paint = new Paint(1);
            this.rect = new RectF();
            View view = new View(context);
            this.searchBackground = view;
            view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(shareAlert.darkTheme ? Theme.key_voipgroup_searchBackground : Theme.key_dialogSearchBackground)));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 0.0f, 14.0f, 0.0f));
            View view2 = new View(context, shareAlert) { // from class: org.rbmain.ui.Components.ShareAlert.SwitchView.1
                @Override // android.view.View
                public void setTranslationX(float f) {
                    super.setTranslationX(f);
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
            int i = Theme.key_voipgroup_nameText;
            simpleTextView.setTextColor(Theme.getColor(i));
            this.leftTab.setTextSize(13);
            this.leftTab.setLeftDrawable(R.drawable.msg_tabs_mic1);
            this.leftTab.setText(LocaleController.getString("VoipGroupInviteCanSpeak", R.string.VoipGroupInviteCanSpeak));
            this.leftTab.setGravity(17);
            addView(this.leftTab, LayoutHelper.createFrame(-1, -1.0f, 51, 14.0f, 0.0f, 0.0f, 0.0f));
            this.leftTab.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ShareAlert$SwitchView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.lambda$new$0(view3);
                }
            });
            SimpleTextView simpleTextView2 = new SimpleTextView(context);
            this.rightTab = simpleTextView2;
            simpleTextView2.setTextColor(Theme.getColor(i));
            this.rightTab.setTextSize(13);
            this.rightTab.setLeftDrawable(R.drawable.msg_tabs_mic2);
            this.rightTab.setText(LocaleController.getString("VoipGroupInviteListenOnly", R.string.VoipGroupInviteListenOnly));
            this.rightTab.setGravity(17);
            addView(this.rightTab, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 14.0f, 0.0f));
            this.rightTab.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ShareAlert$SwitchView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    this.f$0.lambda$new$1(view3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            switchToTab(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(View view) {
            switchToTab(1);
        }

        private void switchToTab(int i) {
            if (this.currentTab == i) {
                return;
            }
            this.currentTab = i;
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
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ShareAlert.SwitchView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    SwitchView.this.animator = null;
                }
            });
            this.animator.start();
            onTabSwitch(this.currentTab);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = (View.MeasureSpec.getSize(i) - AndroidUtilities.dp(28.0f)) / 2;
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
            super.onMeasure(i, i2);
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
            view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_searchBackground : Theme.key_dialogSearchBackground)));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 11.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.searchIconImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
            this.searchIconImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_mutedIcon : Theme.key_dialogSearchIcon), PorterDuff.Mode.MULTIPLY));
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
            this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_searchPlaceholder : Theme.key_dialogSearchIcon), PorterDuff.Mode.MULTIPLY));
            addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 11.0f, 14.0f, 0.0f));
            this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ShareAlert$SearchField$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$0(view2);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context, ShareAlert.this) { // from class: org.rbmain.ui.Components.ShareAlert.SearchField.1
                @Override // org.rbmain.ui.Components.EditTextEffects, android.view.View
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setLocation(motionEventObtain.getRawX(), motionEventObtain.getRawY() - ((BottomSheet) ShareAlert.this).containerView.getTranslationY());
                    if (motionEventObtain.getAction() == 1) {
                        motionEventObtain.setAction(3);
                    }
                    ShareAlert.this.gridView.dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    return super.dispatchTouchEvent(motionEvent);
                }
            };
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setHintTextColor(Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_searchPlaceholder : Theme.key_dialogSearchHint));
            this.searchEditText.setTextColor(Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_searchText : Theme.key_dialogSearchText));
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            this.searchEditText.setHint(LocaleController.getString("ShareSendTo", R.string.ShareSendTo));
            this.searchEditText.setCursorColor(Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_searchText : Theme.key_featuredStickers_addedIcon));
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 9.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher(ShareAlert.this) { // from class: org.rbmain.ui.Components.ShareAlert.SearchField.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    String string = SearchField.this.searchEditText.getText().toString();
                    if (string.length() != 0) {
                        if (ShareAlert.this.searchEmptyView != null) {
                            ShareAlert.this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                        }
                    } else if (ShareAlert.this.gridView.getAdapter() != ShareAlert.this.listAdapter) {
                        int currentTop = ShareAlert.this.getCurrentTop();
                        ShareAlert.this.searchEmptyView.setText(LocaleController.getString("NoChats", R.string.NoChats));
                        ShareAlert.this.searchEmptyView.showTextView();
                        ShareAlert.this.gridView.setAdapter(ShareAlert.this.listAdapter);
                        ShareAlert.this.listAdapter.notifyDataSetChanged();
                        if (currentTop > 0) {
                            ShareAlert.this.layoutManager.scrollToPositionWithOffset(0, -currentTop);
                        }
                    }
                    if (ShareAlert.this.searchAdapter != null) {
                        ShareAlert.this.searchAdapter.searchDialogs(string);
                    }
                }
            });
            this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.Components.ShareAlert$SearchField$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$1(textView, i, keyEvent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            this.searchEditText.setText(BuildConfig.FLAVOR);
            AndroidUtilities.showKeyboard(this.searchEditText);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$1(TextView textView, int i, KeyEvent keyEvent) {
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

    public static ShareAlert createShareAlert(Context context, MessageObject messageObject, String str, boolean z, String str2, boolean z2) {
        ArrayList arrayList;
        if (messageObject != null) {
            arrayList = new ArrayList();
            arrayList.add(messageObject);
        } else {
            arrayList = null;
        }
        return new ShareAlert(context, null, arrayList, str, null, z, str2, null, z2, false);
    }

    public ShareAlert(Context context, ArrayList<MessageObject> arrayList, String str, boolean z, String str2, boolean z2) {
        this(context, null, arrayList, str, null, z, str2, null, z2, false);
    }

    public ShareAlert(final Context context, ChatActivity chatActivity, ArrayList<MessageObject> arrayList, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3) {
        super(context, true);
        this.sendingText = new String[2];
        this.shadow = new View[2];
        this.shadowAnimation = new AnimatorSet[2];
        this.selectedDialogs = new LongSparseArray<>();
        this.rect = new RectF();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        this.linkToCopy = new String[2];
        if (context instanceof Activity) {
            this.parentActivity = (Activity) context;
        }
        this.darkTheme = z3;
        this.parentFragment = chatActivity;
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_inviteMembersBackground : Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
        this.isFullscreen = z2;
        String[] strArr = this.linkToCopy;
        strArr[0] = str3;
        strArr[1] = str4;
        this.sendingMessageObjects = arrayList;
        this.searchAdapter = new ShareSearchAdapter(context);
        this.isChannel = z;
        String[] strArr2 = this.sendingText;
        strArr2[0] = str;
        strArr2[1] = str2;
        this.useSmoothKeyboard = true;
        ArrayList<MessageObject> arrayList2 = this.sendingMessageObjects;
        if (arrayList2 != null) {
            int size = arrayList2.size();
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
        if (z) {
            this.loadingLink = true;
            TLRPC$TL_channels_exportMessageLink tLRPC$TL_channels_exportMessageLink = new TLRPC$TL_channels_exportMessageLink();
            tLRPC$TL_channels_exportMessageLink.id = arrayList.get(0).getId();
            tLRPC$TL_channels_exportMessageLink.channel = MessagesController.getInstance(this.currentAccount).getInputChannel(arrayList.get(0).messageOwner.peer_id.channel_id);
            ServiceLocator.getInstance(this.currentAccount).getMessageProxy().getMessageUrl(tLRPC$TL_channels_exportMessageLink, new RequestDelegate() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda6
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$1(context, tLObject, tLRPC$TL_error);
                }
            });
        }
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: org.rbmain.ui.Components.ShareAlert.1
            private int fromOffsetTop;
            private int fromScrollY;
            private boolean fullHeight;
            private int previousTopOffset;
            private int toOffsetTop;
            private int toScrollY;
            private int topOffset;
            private boolean ignoreLayout = false;
            private RectF rect1 = new RectF();
            AdjustPanLayoutHelper adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: org.rbmain.ui.Components.ShareAlert.1.1
                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionStart(boolean z4, int i3) {
                    super.onTransitionStart(z4, i3);
                    if (ShareAlert.this.previousScrollOffsetY <= 0 || ShareAlert.this.previousScrollOffsetY == ShareAlert.this.scrollOffsetY || !z4) {
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
                        if (!z4) {
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            AnonymousClass1.access$2320(anonymousClass14, anonymousClass14.topOffset - AnonymousClass1.this.previousTopOffset);
                        } else {
                            AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                            AnonymousClass1.access$2312(anonymousClass15, anonymousClass15.topOffset - AnonymousClass1.this.previousTopOffset);
                        }
                        AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                        ShareAlert.this.scrollOffsetY = z4 ? anonymousClass16.fromScrollY : anonymousClass16.toScrollY;
                    } else {
                        AnonymousClass1.this.fromOffsetTop = -1;
                    }
                    ShareAlert.this.gridView.setTopGlowOffset((int) (ShareAlert.this.currentPanTranslationY + ShareAlert.this.scrollOffsetY));
                    ShareAlert.this.frameLayout.setTranslationY(ShareAlert.this.currentPanTranslationY + ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.searchEmptyView.setTranslationY(ShareAlert.this.currentPanTranslationY + ShareAlert.this.scrollOffsetY);
                    invalidate();
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionEnd() {
                    super.onTransitionEnd();
                    ShareAlert.this.panTranslationMoveLayout = false;
                    ShareAlert.this.updateLayout();
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.previousScrollOffsetY = shareAlert.scrollOffsetY;
                    ShareAlert.this.gridView.setTopGlowOffset(ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.frameLayout.setTranslationY(ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.searchEmptyView.setTranslationY(ShareAlert.this.scrollOffsetY);
                    ShareAlert.this.gridView.setTranslationY(0.0f);
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onPanTranslationUpdate(float f, float f2, boolean z4) {
                    super.onPanTranslationUpdate(f, f2, z4);
                    for (int i3 = 0; i3 < ((BottomSheet) ShareAlert.this).containerView.getChildCount(); i3++) {
                        if (((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.pickerBottomLayout && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.shadow[1] && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.sharesCountLayout && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.frameLayout2 && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.writeButtonContainer && ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3) != ShareAlert.this.selectedCountView) {
                            ((BottomSheet) ShareAlert.this).containerView.getChildAt(i3).setTranslationY(f);
                        }
                    }
                    ShareAlert.this.currentPanTranslationY = f;
                    if (AnonymousClass1.this.fromScrollY != -1 && z4) {
                        float f3 = 1.0f - f2;
                        ShareAlert.this.scrollOffsetY = (int) ((r5.fromScrollY * f3) + (AnonymousClass1.this.toScrollY * f2));
                        ShareAlert.this.gridView.setTranslationY(ShareAlert.this.currentPanTranslationY + ((AnonymousClass1.this.fromScrollY - AnonymousClass1.this.toScrollY) * f3));
                    } else if (AnonymousClass1.this.fromOffsetTop != -1) {
                        float f4 = 1.0f - f2;
                        ShareAlert.this.scrollOffsetY = (int) ((r5.fromOffsetTop * f4) + (AnonymousClass1.this.toOffsetTop * f2));
                        if (!z4) {
                            f4 = f2;
                        }
                        if (z4) {
                            ShareAlert.this.gridView.setTranslationY(ShareAlert.this.currentPanTranslationY - ((AnonymousClass1.this.fromOffsetTop - AnonymousClass1.this.toOffsetTop) * f2));
                        } else {
                            ShareAlert.this.gridView.setTranslationY(ShareAlert.this.currentPanTranslationY + ((AnonymousClass1.this.toOffsetTop - AnonymousClass1.this.fromOffsetTop) * f4));
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

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected boolean heightAnimationEnabled() {
                    if (ShareAlert.this.isDismissed()) {
                        return false;
                    }
                    return !ShareAlert.this.commentTextView.isPopupVisible();
                }
            };

            static /* synthetic */ int access$2312(AnonymousClass1 anonymousClass1, int i3) {
                int i4 = anonymousClass1.toOffsetTop + i3;
                anonymousClass1.toOffsetTop = i4;
                return i4;
            }

            static /* synthetic */ int access$2320(AnonymousClass1 anonymousClass1, int i3) {
                int i4 = anonymousClass1.toOffsetTop - i3;
                anonymousClass1.toOffsetTop = i4;
                return i4;
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                this.adjustPanLayoutHelper.setResizableView(this);
                this.adjustPanLayoutHelper.onAttach();
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                this.adjustPanLayoutHelper.onDetach();
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i3, int i4) {
                int size2;
                if (getLayoutParams().height > 0) {
                    size2 = getLayoutParams().height;
                } else {
                    size2 = View.MeasureSpec.getSize(i4);
                }
                int i5 = 0;
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
                boolean z4 = iDp >= size2;
                this.fullHeight = z4;
                if (!z4 && SharedConfig.smoothKeyboard) {
                    i5 = size2 - iDp;
                }
                this.topOffset = i5;
                setMeasuredDimension(View.MeasureSpec.getSize(i3), size2);
                onMeasureInternal(i3, View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size2), 1073741824));
            }

            private void onMeasureInternal(int i3, int i4) {
                int size2 = View.MeasureSpec.getSize(i3);
                int size3 = View.MeasureSpec.getSize(i4);
                int i5 = size2 - (((BottomSheet) ShareAlert.this).backgroundPaddingLeft * 2);
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
                        i4 = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
                    }
                    int i6 = ShareAlert.this.commentTextView.isPopupShowing() ? 8 : 0;
                    if (ShareAlert.this.pickerBottomLayout != null) {
                        ShareAlert.this.pickerBottomLayout.setVisibility(i6);
                        if (ShareAlert.this.sharesCountLayout != null) {
                            ShareAlert.this.sharesCountLayout.setVisibility(i6);
                        }
                    }
                }
                this.ignoreLayout = false;
                int childCount = getChildCount();
                for (int i7 = 0; i7 < childCount; i7++) {
                    View childAt = getChildAt(i7);
                    if (childAt != null && childAt.getVisibility() != 8) {
                        if (ShareAlert.this.commentTextView != null && ShareAlert.this.commentTextView.isPopupView(childAt)) {
                            if (AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                                if (AndroidUtilities.isTablet()) {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(AndroidUtilities.isTablet() ? 200.0f : 320.0f), (size3 - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                                } else {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec((size3 - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                                }
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                            }
                        } else {
                            measureChildWithMargins(childAt, i3, 0, i4, 0);
                        }
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:32:0x0090  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00ad  */
            /* JADX WARN: Removed duplicated region for block: B:43:0x00c5  */
            /* JADX WARN: Removed duplicated region for block: B:47:0x00d7  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x00e0  */
            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onLayout(boolean r11, int r12, int r13, int r14, int r15) {
                /*
                    Method dump skipped, instructions count: 252
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ShareAlert.AnonymousClass1.onLayout(boolean, int, int, int, int):void");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (!this.fullHeight) {
                    if (motionEvent.getAction() == 0 && motionEvent.getY() < this.topOffset - AndroidUtilities.dp(30.0f)) {
                        ShareAlert.this.dismiss();
                        return true;
                    }
                } else if (motionEvent.getAction() == 0 && ShareAlert.this.scrollOffsetY != 0 && motionEvent.getY() < ShareAlert.this.scrollOffsetY - AndroidUtilities.dp(30.0f)) {
                    ShareAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !ShareAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x00ad A[PHI: r0 r1 r2
              0x00ad: PHI (r0v7 int) = (r0v6 int), (r0v6 int), (r0v32 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x00ad: PHI (r1v11 int) = (r1v10 int), (r1v10 int), (r1v34 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x00ad: PHI (r2v8 int) = (r2v7 int), (r2v7 int), (r2v27 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r14) {
                /*
                    Method dump skipped, instructions count: 468
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.Components.ShareAlert.AnonymousClass1.onDraw(android.graphics.Canvas):void");
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
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
        frameLayout.setBackgroundColor(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_inviteMembersBackground : Theme.key_dialogBackground));
        if (this.darkTheme && this.linkToCopy[1] != null) {
            SwitchView switchView = new SwitchView(context) { // from class: org.rbmain.ui.Components.ShareAlert.2
                @Override // org.rbmain.ui.Components.ShareAlert.SwitchView
                protected void onTabSwitch(int i4) {
                    if (ShareAlert.this.pickerBottomLayout == null) {
                        return;
                    }
                    if (i4 == 0) {
                        ShareAlert.this.pickerBottomLayout.setText(LocaleController.getString("VoipGroupCopySpeakerLink", R.string.VoipGroupCopySpeakerLink).toUpperCase());
                    } else {
                        ShareAlert.this.pickerBottomLayout.setText(LocaleController.getString("VoipGroupCopyListenLink", R.string.VoipGroupCopyListenLink).toUpperCase());
                    }
                }
            };
            this.switchView = switchView;
            this.frameLayout.addView(switchView, LayoutHelper.createFrame(-1, 36.0f, 51, 0.0f, 11.0f, 0.0f, 0.0f));
        }
        final SearchField searchField = new SearchField(context);
        this.frameLayout.addView(searchField, LayoutHelper.createFrame(-1, 58, 83));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: org.rbmain.ui.Components.ShareAlert.3
            @Override // org.rbmain.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float f, float f2) {
                return f2 >= ((float) (AndroidUtilities.dp((!ShareAlert.this.darkTheme || ShareAlert.this.linkToCopy[1] == null) ? 58.0f : 111.0f) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
            }

            @Override // org.rbmain.ui.Components.RecyclerListView, android.view.View
            public void setTranslationY(float f) {
                super.setTranslationY(f);
                getLocationInWindow(new int[2]);
            }
        };
        this.gridView = recyclerListView;
        recyclerListView.setTag(13);
        this.gridView.setPadding(0, 0, 0, AndroidUtilities.dp(48.0f));
        this.gridView.setClipToPadding(false);
        RecyclerListView recyclerListView2 = this.gridView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        this.layoutManager = gridLayoutManager;
        recyclerListView2.setLayoutManager(gridLayoutManager);
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: org.rbmain.ui.Components.ShareAlert.4
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i4) {
                if (i4 == 0) {
                    return ShareAlert.this.layoutManager.getSpanCount();
                }
                return 1;
            }
        });
        this.gridView.setHorizontalScrollBarEnabled(false);
        this.gridView.setVerticalScrollBarEnabled(false);
        this.gridView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: org.rbmain.ui.Components.ShareAlert.5
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(android.graphics.Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                RecyclerListView.Holder holder = (RecyclerListView.Holder) recyclerView.getChildViewHolder(view);
                if (holder != null) {
                    int adapterPosition = holder.getAdapterPosition() % 4;
                    rect.left = adapterPosition == 0 ? 0 : AndroidUtilities.dp(4.0f);
                    rect.right = adapterPosition != 3 ? AndroidUtilities.dp(4.0f) : 0;
                } else {
                    rect.left = AndroidUtilities.dp(4.0f);
                    rect.right = AndroidUtilities.dp(4.0f);
                }
            }
        });
        this.containerView.addView(this.gridView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
        RecyclerListView recyclerListView3 = this.gridView;
        ShareDialogsAdapter shareDialogsAdapter = new ShareDialogsAdapter(context);
        this.listAdapter = shareDialogsAdapter;
        recyclerListView3.setAdapter(shareDialogsAdapter);
        this.gridView.setGlowColor(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_inviteMembersBackground : Theme.key_dialogScrollGlow));
        this.gridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda7
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                this.f$0.lambda$new$2(searchField, view, i4);
            }
        });
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: org.rbmain.ui.Components.ShareAlert.6
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i4, int i5) {
                ShareAlert.this.updateLayout();
                if (i5 != 0) {
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.previousScrollOffsetY = shareAlert.scrollOffsetY;
                }
            }
        });
        EmptyTextProgressView emptyTextProgressView = new EmptyTextProgressView(context);
        this.searchEmptyView = emptyTextProgressView;
        emptyTextProgressView.setShowAtCenter(true);
        this.searchEmptyView.showTextView();
        this.searchEmptyView.setText(LocaleController.getString("NoChats", R.string.NoChats));
        this.gridView.setEmptyView(this.searchEmptyView);
        this.containerView.addView(this.searchEmptyView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 52.0f, 0.0f, 0.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 51);
        layoutParams.topMargin = AndroidUtilities.dp((!this.darkTheme || this.linkToCopy[1] == null) ? 58.0f : 111.0f);
        this.shadow[0] = new View(context);
        View view = this.shadow[0];
        int i4 = Theme.key_dialogShadowLine;
        view.setBackgroundColor(Theme.getColor(i4));
        this.shadow[0].setAlpha(0.0f);
        this.shadow[0].setTag(1);
        this.containerView.addView(this.shadow[0], layoutParams);
        this.containerView.addView(this.frameLayout, LayoutHelper.createFrame(-1, (!this.darkTheme || this.linkToCopy[1] == null) ? 58 : 111, 51));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams2.bottomMargin = AndroidUtilities.dp(48.0f);
        this.shadow[1] = new View(context);
        this.shadow[1].setBackgroundColor(Theme.getColor(i4));
        this.containerView.addView(this.shadow[1], layoutParams2);
        if (this.isChannel || this.linkToCopy[0] != null) {
            TextView textView = new TextView(context);
            this.pickerBottomLayout = textView;
            textView.setBackgroundDrawable(Theme.createSelectorWithBackgroundDrawable(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_inviteMembersBackground : Theme.key_dialogBackground), Theme.getColor(this.darkTheme ? Theme.key_voipgroup_listSelector : Theme.key_listSelector)));
            this.pickerBottomLayout.setTextColor(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_listeningText : Theme.key_dialogTextBlue2));
            this.pickerBottomLayout.setTextSize(1, 14.0f);
            this.pickerBottomLayout.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
            this.pickerBottomLayout.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.pickerBottomLayout.setGravity(17);
            if (this.darkTheme && this.linkToCopy[1] != null) {
                this.pickerBottomLayout.setText(LocaleController.getString("VoipGroupCopySpeakerLink", R.string.VoipGroupCopySpeakerLink).toUpperCase());
            } else {
                this.pickerBottomLayout.setText(LocaleController.getString("Copy", R.string.Copy).toUpperCase());
            }
            this.pickerBottomLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$3(view2);
                }
            });
            this.containerView.addView(this.pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
            ChatActivity chatActivity2 = this.parentFragment;
            if (chatActivity2 != null && ChatObject.hasAdminRights(chatActivity2.getCurrentChat()) && this.sendingMessageObjects.size() > 0 && this.sendingMessageObjects.get(0).messageOwner.forwards > 0) {
                final MessageObject messageObject2 = this.sendingMessageObjects.get(0);
                if (!messageObject2.isForwarded()) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    this.sharesCountLayout = linearLayout;
                    linearLayout.setOrientation(0);
                    this.sharesCountLayout.setGravity(16);
                    this.sharesCountLayout.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_listSelector : Theme.key_listSelector), 2));
                    this.containerView.addView(this.sharesCountLayout, LayoutHelper.createFrame(-2, 48.0f, 85, 6.0f, 0.0f, -6.0f, 0.0f));
                    this.sharesCountLayout.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.lambda$new$4(messageObject2, view2);
                        }
                    });
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(R.drawable.share_arrow);
                    imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_listeningText : Theme.key_dialogTextBlue2), PorterDuff.Mode.MULTIPLY));
                    this.sharesCountLayout.addView(imageView, LayoutHelper.createLinear(-2, -1, 16, 20, 0, 0, 0));
                    TextView textView2 = new TextView(context);
                    textView2.setText(String.format("%d", Integer.valueOf(messageObject2.messageOwner.forwards)));
                    textView2.setTextSize(1, 14.0f);
                    textView2.setTextColor(Theme.getColor(this.darkTheme ? Theme.key_voipgroup_listeningText : Theme.key_dialogTextBlue2));
                    textView2.setGravity(16);
                    textView2.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                    this.sharesCountLayout.addView(textView2, LayoutHelper.createLinear(-2, -1, 16, 8, 0, 20, 0));
                }
            }
        } else {
            this.shadow[1].setAlpha(0.0f);
        }
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(context);
        this.frameLayout2 = anonymousClass7;
        anonymousClass7.setWillNotDraw(false);
        this.frameLayout2.setAlpha(0.0f);
        this.frameLayout2.setVisibility(4);
        this.containerView.addView(this.frameLayout2, LayoutHelper.createFrame(-1, -2, 83));
        this.frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ShareAlert.lambda$new$5(view2, motionEvent);
            }
        });
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(context, sizeNotifierFrameLayout, null, 1);
        this.commentTextView = anonymousClass8;
        if (z3) {
            anonymousClass8.getEditText().setTextColor(Theme.getColor(Theme.key_voipgroup_nameText));
        }
        this.commentTextView.setHint(LocaleController.getString("ShareComment", R.string.ShareComment));
        this.commentTextView.onResume();
        this.frameLayout2.addView(this.commentTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 0.0f, 84.0f, 0.0f));
        this.frameLayout2.setClipChildren(false);
        this.commentTextView.setClipChildren(false);
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: org.rbmain.ui.Components.ShareAlert.9
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                accessibilityNodeInfo.setText(LocaleController.formatPluralString("AccDescrShareInChats", ShareAlert.this.selectedDialogs.size()));
                accessibilityNodeInfo.setClassName(Button.class.getName());
                accessibilityNodeInfo.setLongClickable(true);
                accessibilityNodeInfo.setClickable(true);
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
        int i5 = Theme.key_dialogFloatingButton;
        int color = Theme.getColor(i5);
        int i6 = Build.VERSION.SDK_INT;
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, color, Theme.getColor(i6 >= 21 ? Theme.key_dialogFloatingButtonPressed : i5));
        if (i6 < 21) {
            Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate2, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        imageView2.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        imageView2.setImageResource(R.drawable.attach_send);
        imageView2.setImportantForAccessibility(2);
        imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingIcon), PorterDuff.Mode.MULTIPLY));
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        if (i6 >= 21) {
            imageView2.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.Components.ShareAlert.10
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        this.writeButtonContainer.addView(imageView2, LayoutHelper.createFrame(i6 >= 21 ? 56 : 60, i6 < 21 ? 60.0f : 56.0f, 51, i6 >= 21 ? 2.0f : 0.0f, 0.0f, 0.0f, 0.0f));
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$6(view2);
            }
        });
        this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
        this.textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        View view2 = new View(context) { // from class: org.rbmain.ui.Components.ShareAlert.11
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                String str5 = String.format("%d", Integer.valueOf(Math.max(1, ShareAlert.this.selectedDialogs.size())));
                int iMax = Math.max(AndroidUtilities.dp(16.0f) + ((int) Math.ceil(ShareAlert.this.textPaint.measureText(str5))), AndroidUtilities.dp(24.0f));
                int measuredWidth = getMeasuredWidth() / 2;
                int measuredHeight = getMeasuredHeight() / 2;
                ShareAlert.this.textPaint.setColor(Theme.getColor(Theme.key_dialogRoundCheckBoxCheck));
                ShareAlert.this.paint.setColor(Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_inviteMembersBackground : Theme.key_dialogBackground));
                int i7 = iMax / 2;
                ShareAlert.this.rect.set(measuredWidth - i7, 0.0f, i7 + measuredWidth, getMeasuredHeight());
                canvas.drawRoundRect(ShareAlert.this.rect, AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), ShareAlert.this.paint);
                ShareAlert.this.paint.setColor(Theme.getColor(Theme.key_dialogRoundCheckBox));
                ShareAlert.this.rect.set(r5 + AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), r2 - AndroidUtilities.dp(2.0f), getMeasuredHeight() - AndroidUtilities.dp(2.0f));
                canvas.drawRoundRect(ShareAlert.this.rect, AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), ShareAlert.this.paint);
                canvas.drawText(str5, measuredWidth - (r1 / 2), AndroidUtilities.dp(16.2f), ShareAlert.this.textPaint);
            }
        };
        this.selectedCountView = view2;
        view2.setAlpha(0.0f);
        this.selectedCountView.setScaleX(0.2f);
        this.selectedCountView.setScaleY(0.2f);
        this.containerView.addView(this.selectedCountView, LayoutHelper.createFrame(42, 24.0f, 85, 0.0f, 0.0f, -8.0f, 9.0f));
        updateSelectedCount(0);
        DialogsActivity.loadDialogs(AccountInstance.getInstance(this.currentAccount));
        if (this.listAdapter.dialogs.isEmpty()) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.dialogsNeedReload);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(final Context context, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0(tLObject, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(TLObject tLObject, Context context) {
        if (tLObject != null) {
            this.exportedMessageLink = (TLRPC$TL_exportedMessageLink) tLObject;
            if (this.copyLinkOnEnd) {
                copyLink(context);
            }
        }
        this.loadingLink = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(SearchField searchField, View view, int i) {
        TLRPC$Dialog item;
        int i2;
        if (i < 0) {
            return;
        }
        RecyclerView.Adapter adapter = this.gridView.getAdapter();
        ShareDialogsAdapter shareDialogsAdapter = this.listAdapter;
        if (adapter == shareDialogsAdapter) {
            item = shareDialogsAdapter.getItem(i);
        } else {
            item = this.searchAdapter.getItem(i);
        }
        if (item == null) {
            return;
        }
        if (this.hasPoll != 0 && (i2 = (int) item.id) < 0) {
            TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount).getChat(Integer.valueOf(-i2));
            boolean z = ChatObject.isChannel(chat) && this.hasPoll == 2 && !chat.megagroup;
            if (z || !ChatObject.canSendPolls(chat)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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
        ShareDialogCell shareDialogCell = (ShareDialogCell) view;
        if (this.selectedDialogs.indexOfKey(item.id) >= 0) {
            this.selectedDialogs.remove(item.id);
            shareDialogCell.setChecked(false, true);
            updateSelectedCount(1);
            return;
        }
        this.selectedDialogs.put(item.id, item);
        shareDialogCell.setChecked(true, true);
        updateSelectedCount(2);
        int i3 = UserConfig.getInstance(this.currentAccount).clientUserId;
        if (this.gridView.getAdapter() == this.searchAdapter) {
            TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) this.listAdapter.dialogsMap.get(item.id);
            if (tLRPC$Dialog == null) {
                this.listAdapter.dialogsMap.put(item.id, item);
                this.listAdapter.dialogs.add(!this.listAdapter.dialogs.isEmpty() ? 1 : 0, item);
            } else if (tLRPC$Dialog.id != i3) {
                this.listAdapter.dialogs.remove(tLRPC$Dialog);
                this.listAdapter.dialogs.add(!this.listAdapter.dialogs.isEmpty() ? 1 : 0, tLRPC$Dialog);
            }
            searchField.searchEditText.setText(BuildConfig.FLAVOR);
            this.gridView.setAdapter(this.listAdapter);
            searchField.hideKeyboard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3(View view) {
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
    public /* synthetic */ void lambda$new$4(MessageObject messageObject, View view) {
        this.parentFragment.presentFragment(new MessageStatisticActivity(messageObject));
    }

    /* renamed from: org.rbmain.ui.Components.ShareAlert$7, reason: invalid class name */
    class AnonymousClass7 extends FrameLayout {
        private int color;
        private final Paint p;

        AnonymousClass7(Context context) {
            super(context);
            this.p = new Paint();
        }

        @Override // android.view.View
        public void setVisibility(int i) {
            super.setVisibility(i);
            if (i != 0) {
                ShareAlert.this.shadow[1].setTranslationY(0.0f);
            }
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
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
                ShareAlert.this.topBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ShareAlert$7$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onDraw$0(valueAnimator);
                    }
                });
                ShareAlert.this.topBackgroundAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                ShareAlert.this.topBackgroundAnimator.setDuration(200L);
                ShareAlert.this.topBackgroundAnimator.start();
                ShareAlert.this.chatActivityEnterViewAnimateFromTop = 0.0f;
            }
            float measuredHeight = (ShareAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(48.0f)) * (1.0f - getAlpha());
            ShareAlert.this.shadow[1].setTranslationY((-(ShareAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(48.0f))) + ShareAlert.this.captionEditTextTopOffset + ShareAlert.this.currentPanTranslationY + measuredHeight);
            int color = Theme.getColor(ShareAlert.this.darkTheme ? Theme.key_voipgroup_inviteMembersBackground : Theme.key_dialogBackground);
            if (this.color != color) {
                this.color = color;
                this.p.setColor(color);
            }
            canvas.drawRect(0.0f, ShareAlert.this.captionEditTextTopOffset + measuredHeight, getMeasuredWidth(), getMeasuredHeight(), this.p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDraw$0(ValueAnimator valueAnimator) {
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

    /* renamed from: org.rbmain.ui.Components.ShareAlert$8, reason: invalid class name */
    class AnonymousClass8 extends EditTextEmoji {
        private ValueAnimator messageEditTextAnimator;
        private int messageEditTextPredrawHeigth;
        private int messageEditTextPredrawScrollY;
        private boolean shouldAnimateEditTextWithBounds;

        AnonymousClass8(Context context, SizeNotifierFrameLayout sizeNotifierFrameLayout, BaseFragment baseFragment, int i) {
            super(context, sizeNotifierFrameLayout, baseFragment, i);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (this.shouldAnimateEditTextWithBounds) {
                final EditTextCaption editText = ShareAlert.this.commentTextView.getEditText();
                editText.setOffsetY(editText.getOffsetY() - ((this.messageEditTextPredrawHeigth - editText.getMeasuredHeight()) + (this.messageEditTextPredrawScrollY - editText.getScrollY())));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(editText.getOffsetY(), 0.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: org.rbmain.ui.Components.ShareAlert$8$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ShareAlert.AnonymousClass8.lambda$dispatchDraw$0(editText, valueAnimator);
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

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$dispatchDraw$0(EditTextCaption editTextCaption, ValueAnimator valueAnimator) {
            editTextCaption.setOffsetY(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        @Override // org.rbmain.ui.Components.EditTextEmoji
        protected void onLineCountChanged(int i, int i2) {
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
    public /* synthetic */ void lambda$new$6(View view) {
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.selectedDialogs.size()) {
                if (this.sendingMessageObjects != null) {
                    while (i < this.selectedDialogs.size()) {
                        long jKeyAt = this.selectedDialogs.keyAt(i);
                        if (this.frameLayout2.getTag() != null && this.commentTextView.length() > 0) {
                            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.commentTextView.getText().toString(), jKeyAt, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                        }
                        SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.sendingMessageObjects, jKeyAt, true, 0);
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
                                SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.commentTextView.getText().toString(), jKeyAt2, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                            }
                            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.sendingText[i3], jKeyAt2, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
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
        if (holder.getAdapterPosition() == 0 && childAt.getTop() >= 0) {
            top = childAt.getTop();
        }
        return paddingTop - top;
    }

    public void setDelegate(ShareAlertDelegate shareAlertDelegate) {
        this.delegate = shareAlertDelegate;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
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

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        int i3 = NotificationCenter.dialogsNeedReload;
        if (i == i3) {
            ShareDialogsAdapter shareDialogsAdapter = this.listAdapter;
            if (shareDialogsAdapter != null) {
                shareDialogsAdapter.fetchDialogs();
            }
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.gridView.getChildCount() <= 0 || this.panTranslationMoveLayout) {
            return;
        }
        View childAt = this.gridView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.gridView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
        int i = (top <= 0 || holder == null || holder.getAdapterPosition() != 0) ? 0 : top;
        if (top >= 0 && holder != null && holder.getAdapterPosition() == 0) {
            runShadowAnimation(0, false);
        } else {
            runShadowAnimation(0, true);
            top = i;
        }
        int i2 = this.scrollOffsetY;
        if (i2 != top) {
            this.previousScrollOffsetY = i2;
            RecyclerListView recyclerListView = this.gridView;
            int i3 = (int) (top + this.currentPanTranslationY);
            this.scrollOffsetY = i3;
            recyclerListView.setTopGlowOffset(i3);
            this.frameLayout.setTranslationY(this.scrollOffsetY + this.currentPanTranslationY);
            this.searchEmptyView.setTranslationY(this.scrollOffsetY + this.currentPanTranslationY);
            this.containerView.invalidate();
        }
    }

    private void runShadowAnimation(final int i, final boolean z) {
        if ((!z || this.shadow[i].getTag() == null) && (z || this.shadow[i].getTag() != null)) {
            return;
        }
        this.shadow[i].setTag(z ? null : 1);
        if (z) {
            this.shadow[i].setVisibility(0);
        }
        AnimatorSet[] animatorSetArr = this.shadowAnimation;
        if (animatorSetArr[i] != null) {
            animatorSetArr[i].cancel();
        }
        this.shadowAnimation[i] = new AnimatorSet();
        AnimatorSet animatorSet = this.shadowAnimation[i];
        Animator[] animatorArr = new Animator[1];
        View view = this.shadow[i];
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
        animatorSet.playTogether(animatorArr);
        this.shadowAnimation[i].setDuration(150L);
        this.shadowAnimation[i].addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ShareAlert.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ShareAlert.this.shadowAnimation[i] == null || !ShareAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                if (!z) {
                    ShareAlert.this.shadow[i].setVisibility(4);
                }
                ShareAlert.this.shadowAnimation[i] = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (ShareAlert.this.shadowAnimation[i] == null || !ShareAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                ShareAlert.this.shadowAnimation[i] = null;
            }
        });
        this.shadowAnimation[i].start();
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
                ((LaunchActivity) this.parentActivity).showBulletin(new Function() { // from class: org.rbmain.ui.Components.ShareAlert$$ExternalSyntheticLambda4
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return this.f$0.lambda$copyLink$7(z, (BulletinFactory) obj);
                    }
                });
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bulletin lambda$copyLink$7(boolean z, BulletinFactory bulletinFactory) {
        return bulletinFactory.createCopyLinkBulletin(z, this.resourcesProvider);
    }

    private boolean showCommentTextView(final boolean z) {
        if (z == (this.frameLayout2.getTag() != null)) {
            return false;
        }
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.frameLayout2.setTag(z ? 1 : null);
        if (this.commentTextView.getEditText().isFocused()) {
            AndroidUtilities.hideKeyboard(this.commentTextView.getEditText());
        }
        this.commentTextView.hidePopup(true);
        if (z) {
            this.frameLayout2.setVisibility(0);
            this.writeButtonContainer.setVisibility(0);
        }
        TextView textView = this.pickerBottomLayout;
        if (textView != null) {
            ViewCompat.setImportantForAccessibility(textView, z ? 4 : 1);
        }
        LinearLayout linearLayout = this.sharesCountLayout;
        if (linearLayout != null) {
            ViewCompat.setImportantForAccessibility(linearLayout, z ? 4 : 1);
        }
        this.animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.frameLayout2;
        Property property = View.ALPHA;
        float[] fArr = new float[1];
        fArr[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout, (Property<FrameLayout, Float>) property, fArr));
        FrameLayout frameLayout2 = this.writeButtonContainer;
        Property property2 = View.SCALE_X;
        float[] fArr2 = new float[1];
        fArr2[0] = z ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout2, (Property<FrameLayout, Float>) property2, fArr2));
        FrameLayout frameLayout3 = this.writeButtonContainer;
        Property property3 = View.SCALE_Y;
        float[] fArr3 = new float[1];
        fArr3[0] = z ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout3, (Property<FrameLayout, Float>) property3, fArr3));
        FrameLayout frameLayout4 = this.writeButtonContainer;
        Property property4 = View.ALPHA;
        float[] fArr4 = new float[1];
        fArr4[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(frameLayout4, (Property<FrameLayout, Float>) property4, fArr4));
        View view = this.selectedCountView;
        Property property5 = View.SCALE_X;
        float[] fArr5 = new float[1];
        fArr5[0] = z ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(view, (Property<View, Float>) property5, fArr5));
        View view2 = this.selectedCountView;
        Property property6 = View.SCALE_Y;
        float[] fArr6 = new float[1];
        fArr6[0] = z ? 1.0f : 0.2f;
        arrayList.add(ObjectAnimator.ofFloat(view2, (Property<View, Float>) property6, fArr6));
        View view3 = this.selectedCountView;
        Property property7 = View.ALPHA;
        float[] fArr7 = new float[1];
        fArr7[0] = z ? 1.0f : 0.0f;
        arrayList.add(ObjectAnimator.ofFloat(view3, (Property<View, Float>) property7, fArr7));
        TextView textView2 = this.pickerBottomLayout;
        if (textView2 == null || textView2.getVisibility() != 0) {
            View view4 = this.shadow[1];
            Property property8 = View.ALPHA;
            float[] fArr8 = new float[1];
            fArr8[0] = z ? 1.0f : 0.0f;
            arrayList.add(ObjectAnimator.ofFloat(view4, (Property<View, Float>) property8, fArr8));
        }
        this.animatorSet.playTogether(arrayList);
        this.animatorSet.setInterpolator(new DecelerateInterpolator());
        this.animatorSet.setDuration(180L);
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.ShareAlert.13
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(ShareAlert.this.animatorSet)) {
                    if (!z) {
                        ShareAlert.this.frameLayout2.setVisibility(4);
                        ShareAlert.this.writeButtonContainer.setVisibility(4);
                    }
                    ShareAlert.this.animatorSet = null;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (animator.equals(ShareAlert.this.animatorSet)) {
                    ShareAlert.this.animatorSet = null;
                }
            }
        });
        this.animatorSet.start();
        return true;
    }

    public void updateSelectedCount(int i) {
        if (this.selectedDialogs.size() == 0) {
            this.selectedCountView.setPivotX(0.0f);
            this.selectedCountView.setPivotY(0.0f);
            showCommentTextView(false);
            return;
        }
        this.selectedCountView.invalidate();
        if (!showCommentTextView(true) && i != 0) {
            this.selectedCountView.setPivotX(AndroidUtilities.dp(21.0f));
            this.selectedCountView.setPivotY(AndroidUtilities.dp(12.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] animatorArr = new Animator[2];
            View view = this.selectedCountView;
            Property property = View.SCALE_X;
            float[] fArr = new float[2];
            fArr[0] = i == 1 ? 1.1f : 0.9f;
            fArr[1] = 1.0f;
            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
            View view2 = this.selectedCountView;
            Property property2 = View.SCALE_Y;
            float[] fArr2 = new float[2];
            fArr2[0] = i != 1 ? 0.9f : 1.1f;
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

    @Override // org.rbmain.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
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
        public int getItemViewType(int i) {
            return i == 0 ? 1 : 0;
        }

        public ShareDialogsAdapter(Context context) {
            this.context = context;
            fetchDialogs();
        }

        public void fetchDialogs() {
            int i;
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
            this.dialogs.clear();
            this.dialogsMap.clear();
            int i2 = UserConfig.getInstance(((BottomSheet) ShareAlert.this).currentAccount).clientUserId;
            if (!MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).dialogsForward.isEmpty()) {
                TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).dialogsForward.get(0);
                this.dialogs.add(tLRPC$Dialog);
                this.dialogsMap.put(tLRPC$Dialog.id, tLRPC$Dialog);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<TLRPC$Dialog> allDialogs = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getAllDialogs();
            for (int i3 = 0; i3 < allDialogs.size(); i3++) {
                TLRPC$Dialog tLRPC$Dialog2 = allDialogs.get(i3);
                if ((tLRPC$Dialog2 instanceof TLRPC$TL_dialog) && (i = (int) tLRPC$Dialog2.id) != i2 && ServiceLocator.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getCoreMainClass().canSendMessage(IdStorage.getInstance().getDialogId(i))) {
                    int i4 = (int) (tLRPC$Dialog2.id >> 32);
                    if (i != 0 && i4 != 1) {
                        if (i <= 0) {
                            TLRPC$Chat chat = MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getChat(Integer.valueOf(-i));
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

        public TLRPC$Dialog getItem(int i) {
            int i2 = i - 1;
            if (i2 < 0 || i2 >= this.dialogs.size()) {
                return null;
            }
            return this.dialogs.get(i2);
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shareDialogCell;
            if (i == 0) {
                shareDialogCell = new ShareDialogCell(this.context, ShareAlert.this.darkTheme ? 1 : 0);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(100.0f)));
            } else {
                shareDialogCell = new View(this.context);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp((!ShareAlert.this.darkTheme || ShareAlert.this.linkToCopy[1] == null) ? 56.0f : 109.0f)));
            }
            return new RecyclerListView.Holder(shareDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ShareDialogCell shareDialogCell = (ShareDialogCell) viewHolder.itemView;
                TLRPC$Dialog item = getItem(i);
                shareDialogCell.setDialog((int) item.id, ShareAlert.this.selectedDialogs.indexOfKey(item.id) >= 0, null);
            }
        }
    }

    public class ShareSearchAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;
        private int lastGlobalSearchId;
        private int lastLocalSearchId;
        private int lastSearchId;
        private String lastSearchText;
        private SearchAdapterHelper searchAdapterHelper;
        private ArrayList<Object> searchResult = new ArrayList<>();
        private Runnable searchRunnable;
        private Runnable searchRunnable2;
        private int waitingResponseCount;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return i == 0 ? 1 : 0;
        }

        static /* synthetic */ int access$8310(ShareSearchAdapter shareSearchAdapter) {
            int i = shareSearchAdapter.waitingResponseCount;
            shareSearchAdapter.waitingResponseCount = i - 1;
            return i;
        }

        public ShareSearchAdapter(Context context) {
            this.context = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate(ShareAlert.this) { // from class: org.rbmain.ui.Components.ShareAlert.ShareSearchAdapter.1
                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeCallParticipants() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeCallParticipants(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ SparseArray getExcludeUsers() {
                    return SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$getExcludeUsers(this);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public /* synthetic */ void onSetHashtags(ArrayList arrayList, HashMap map) {
                    SearchAdapterHelper.SearchAdapterHelperDelegate.CC.$default$onSetHashtags(this, arrayList, map);
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public void onDataSetChanged(int i) {
                    ShareSearchAdapter.access$8310(ShareSearchAdapter.this);
                    ShareSearchAdapter.this.lastGlobalSearchId = i;
                    if (ShareSearchAdapter.this.lastLocalSearchId != i) {
                        ShareSearchAdapter.this.searchResult.clear();
                    }
                    ShareSearchAdapter.this.notifyDataSetChanged();
                }

                @Override // org.rbmain.ui.Adapters.SearchAdapterHelper.SearchAdapterHelperDelegate
                public boolean canApplySearchResults(int i) {
                    return i == ShareSearchAdapter.this.lastSearchId;
                }
            });
        }

        private void searchDialogsInternal(final String str, final int i) {
            MessagesStorage.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: org.rbmain.ui.Components.ShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogsInternal$1(str, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogsInternal$1(String str, int i) {
            try {
                String lowerCase = str.trim().toLowerCase();
                if (lowerCase.length() == 0) {
                    this.lastSearchId = -1;
                    updateSearchResults(new ArrayList<>(), this.lastSearchId);
                    return;
                }
                String translitString = LocaleController.getInstance().getTranslitString(lowerCase);
                if (lowerCase.equals(translitString) || translitString.length() == 0) {
                    translitString = null;
                }
                String[] strArr = new String[(translitString != null ? 1 : 0) + 1];
                strArr[0] = lowerCase;
                if (translitString != null) {
                    strArr[1] = translitString;
                }
                ArrayList<Object> arrayList = new ArrayList<>();
                AccountInstance.getInstance(((BottomSheet) ShareAlert.this).currentAccount).getDialogsProxy().localSearch(strArr[0], null, null, arrayList);
                Collections.sort(arrayList, new Comparator() { // from class: org.rbmain.ui.Components.ShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda4
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ShareAlert.ShareSearchAdapter.lambda$searchDialogsInternal$0(obj, obj2);
                    }
                });
                updateSearchResults(arrayList, i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$searchDialogsInternal$0(Object obj, Object obj2) {
            int i = ((DialogSearchResult) obj).date;
            int i2 = ((DialogSearchResult) obj2).date;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }

        private void updateSearchResults(final ArrayList<Object> arrayList, final int i) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.ShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$updateSearchResults$2(i, arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$updateSearchResults$2(int i, ArrayList arrayList) {
            if (i != this.lastSearchId) {
                return;
            }
            this.lastLocalSearchId = i;
            if (this.lastGlobalSearchId != i) {
                this.searchAdapterHelper.clear();
            }
            if (ShareAlert.this.gridView.getAdapter() != ShareAlert.this.searchAdapter) {
                ShareAlert shareAlert = ShareAlert.this;
                shareAlert.topBeforeSwitch = shareAlert.getCurrentTop();
                ShareAlert.this.gridView.setAdapter(ShareAlert.this.searchAdapter);
                ShareAlert.this.searchAdapter.notifyDataSetChanged();
            }
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                }
                TLObject tLObject = ((DialogSearchResult) arrayList.get(i2)).object;
                if (tLObject instanceof TLRPC$User) {
                    MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).putUser((TLRPC$User) tLObject, true);
                } else if (tLObject instanceof TLRPC$Chat) {
                    MessagesController.getInstance(((BottomSheet) ShareAlert.this).currentAccount).putChat((TLRPC$Chat) tLObject, true);
                }
                i2++;
            }
            boolean z = !this.searchResult.isEmpty() && arrayList.isEmpty();
            boolean z2 = this.searchResult.isEmpty() && arrayList.isEmpty();
            if (z) {
                ShareAlert shareAlert2 = ShareAlert.this;
                shareAlert2.topBeforeSwitch = shareAlert2.getCurrentTop();
            }
            this.searchResult = arrayList;
            this.searchAdapterHelper.mergeResults(arrayList);
            notifyDataSetChanged();
            if (!z2 && !z && ShareAlert.this.topBeforeSwitch > 0) {
                ShareAlert.this.layoutManager.scrollToPositionWithOffset(0, -ShareAlert.this.topBeforeSwitch);
                ShareAlert.this.topBeforeSwitch = -1000;
            }
            ShareAlert.this.searchEmptyView.showTextView();
        }

        public void searchDialogs(final String str) {
            if (str == null || !str.equals(this.lastSearchText)) {
                this.lastSearchText = str;
                if (this.searchRunnable != null) {
                    Utilities.searchQueue.cancelRunnable(this.searchRunnable);
                    this.searchRunnable = null;
                }
                Runnable runnable = this.searchRunnable2;
                if (runnable != null) {
                    AndroidUtilities.cancelRunOnUIThread(runnable);
                    this.searchRunnable2 = null;
                }
                if (TextUtils.isEmpty(str)) {
                    this.searchResult.clear();
                    this.searchAdapterHelper.mergeResults(null);
                    this.searchAdapterHelper.queryServerSearch(null, true, true, true, true, false, 0, false, 0, 0);
                    ShareAlert shareAlert = ShareAlert.this;
                    shareAlert.topBeforeSwitch = shareAlert.getCurrentTop();
                    this.lastSearchId = -1;
                    notifyDataSetChanged();
                    return;
                }
                final int i = this.lastSearchId + 1;
                this.lastSearchId = i;
                DispatchQueue dispatchQueue = Utilities.searchQueue;
                Runnable runnable2 = new Runnable() { // from class: org.rbmain.ui.Components.ShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$searchDialogs$4(str, i);
                    }
                };
                this.searchRunnable = runnable2;
                dispatchQueue.postRunnable(runnable2, 600L);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$4(final String str, final int i) {
            this.searchRunnable = null;
            searchDialogsInternal(str, i);
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.Components.ShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$searchDialogs$3(i, str);
                }
            };
            this.searchRunnable2 = runnable;
            AndroidUtilities.runOnUIThread(runnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$searchDialogs$3(int i, String str) {
            this.searchRunnable2 = null;
            if (i != this.lastSearchId) {
                return;
            }
            this.searchAdapterHelper.queryServerSearch(str, true, true, true, true, false, 0, false, 0, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int size = this.searchResult.size() + this.searchAdapterHelper.getLocalServerSearch().size();
            return size != 0 ? size + 1 : size;
        }

        public TLRPC$Dialog getItem(int i) {
            int i2 = i - 1;
            TLRPC$TL_dialog tLRPC$TL_dialog = null;
            if (i2 < 0) {
                return null;
            }
            if (i2 < this.searchResult.size()) {
                return ((DialogSearchResult) this.searchResult.get(i2)).dialog;
            }
            int size = i2 - this.searchResult.size();
            ArrayList<TLObject> localServerSearch = this.searchAdapterHelper.getLocalServerSearch();
            if (size < localServerSearch.size()) {
                TLObject tLObject = localServerSearch.get(size);
                tLRPC$TL_dialog = new TLRPC$TL_dialog();
                if (tLObject instanceof TLRPC$User) {
                    tLRPC$TL_dialog.id = ((TLRPC$User) tLObject).id;
                } else {
                    tLRPC$TL_dialog.id = -((TLRPC$Chat) tLObject).id;
                }
            }
            return tLRPC$TL_dialog;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() != 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shareDialogCell;
            if (i == 0) {
                shareDialogCell = new ShareDialogCell(this.context, ShareAlert.this.darkTheme ? 1 : 0);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(100.0f)));
            } else {
                shareDialogCell = new View(this.context);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp((!ShareAlert.this.darkTheme || ShareAlert.this.linkToCopy[1] == null) ? 56.0f : 109.0f)));
            }
            return new RecyclerListView.Holder(shareDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            long j;
            CharSequence name;
            long j2;
            int iIndexOfIgnoreCase;
            if (viewHolder.getItemViewType() == 0) {
                int i2 = i - 1;
                ShareDialogCell shareDialogCell = (ShareDialogCell) viewHolder.itemView;
                if (i2 < this.searchResult.size()) {
                    DialogSearchResult dialogSearchResult = (DialogSearchResult) this.searchResult.get(i2);
                    j2 = dialogSearchResult.dialog.id;
                    name = dialogSearchResult.name;
                } else {
                    TLObject tLObject = this.searchAdapterHelper.getLocalServerSearch().get(i2 - this.searchResult.size());
                    if (tLObject instanceof TLRPC$User) {
                        TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                        j = tLRPC$User.id;
                        name = ContactsController.formatName(tLRPC$User.first_name, tLRPC$User.last_name);
                    } else {
                        TLRPC$Chat tLRPC$Chat = (TLRPC$Chat) tLObject;
                        j = -tLRPC$Chat.id;
                        name = tLRPC$Chat.title;
                    }
                    String lastFoundUsername = this.searchAdapterHelper.getLastFoundUsername();
                    if (!TextUtils.isEmpty(lastFoundUsername) && name != null && (iIndexOfIgnoreCase = AndroidUtilities.indexOfIgnoreCase(name.toString(), lastFoundUsername)) != -1) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
                        spannableStringBuilder.setSpan(new ForegroundColorSpanThemable(Theme.key_windowBackgroundWhiteBlueText4), iIndexOfIgnoreCase, lastFoundUsername.length() + iIndexOfIgnoreCase, 33);
                        name = spannableStringBuilder;
                    }
                    j2 = j;
                }
                shareDialogCell.setDialog((int) j2, ShareAlert.this.selectedDialogs.indexOfKey(j2) >= 0, name);
            }
        }
    }
}
