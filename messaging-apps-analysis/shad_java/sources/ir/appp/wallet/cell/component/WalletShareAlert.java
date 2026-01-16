package ir.appp.wallet.cell.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
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
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.wallet.cell.component.WalletShareAlert;
import ir.medu.shad.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.AndroidUtilities;
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
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWallet;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.AdjustPanLayoutHelper;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Adapters.SearchAdapterHelper;
import org.rbmain.ui.Cells.ShareDialogCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.CloseProgressDrawable2;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.CubicBezierInterpolator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.EditTextCaption;
import org.rbmain.ui.Components.EditTextEmoji;
import org.rbmain.ui.Components.EmptyTextProgressView;
import org.rbmain.ui.Components.ForegroundColorSpanThemable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ShareAlert;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;
import org.rbmain.ui.DialogsActivity;

/* loaded from: classes3.dex */
public class WalletShareAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private AnimatorSet animatorSet;
    private float captionEditTextTopOffset;
    private float chatActivityEnterViewAnimateFromTop;
    private EditTextEmoji commentTextView;
    private float currentPanTranslationY;
    private ShareAlertDelegate delegate;
    private FrameLayout frameLayout;
    private FrameLayout frameLayout2;
    private RecyclerListView gridView;
    private GridLayoutManager layoutManager;
    private ShareDialogsAdapter listAdapter;
    private Paint paint;
    private boolean panTranslationMoveLayout;
    private TextView pickerBottomLayout;
    private int previousScrollOffsetY;
    private RectF rect;
    private int scrollOffsetY;
    private ShareSearchAdapter searchAdapter;
    private EmptyTextProgressView searchEmptyView;
    private View selectedCountView;
    private LongSparseArray<TLRPC$Dialog> selectedDialogs;
    private TLRPC$TL_messageMediaWallet sendingMediaWallet;
    private View[] shadow;
    private AnimatorSet[] shadowAnimation;
    private Drawable shadowDrawable;
    private LinearLayout sharesCountLayout;
    private TextPaint textPaint;
    private ValueAnimator topBackgroundAnimator;
    private int topBeforeSwitch;
    private FrameLayout writeButtonContainer;

    public interface ShareAlertDelegate {
        void didShare();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$1(View view, MotionEvent motionEvent) {
        return true;
    }

    @Override // org.rbmain.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    protected void onSend(LongSparseArray<TLRPC$Dialog> longSparseArray, int i) {
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
            view.setBackgroundDrawable(Theme.createRoundRectDrawable(AndroidUtilities.dp(18.0f), Theme.getColor(Theme.key_dialogSearchBackground)));
            addView(this.searchBackground, LayoutHelper.createFrame(-1, 36.0f, 51, 14.0f, 11.0f, 14.0f, 0.0f));
            ImageView imageView = new ImageView(context);
            this.searchIconImageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.searchIconImageView.setImageResource(R.drawable.smiles_inputsearch);
            ImageView imageView2 = this.searchIconImageView;
            int i = Theme.key_dialogSearchIcon;
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            addView(this.searchIconImageView, LayoutHelper.createFrame(36, 36.0f, 51, 16.0f, 11.0f, 0.0f, 0.0f));
            ImageView imageView3 = new ImageView(context);
            this.clearSearchImageView = imageView3;
            imageView3.setScaleType(ImageView.ScaleType.CENTER);
            ImageView imageView4 = this.clearSearchImageView;
            CloseProgressDrawable2 closeProgressDrawable2 = new CloseProgressDrawable2();
            this.progressDrawable = closeProgressDrawable2;
            imageView4.setImageDrawable(closeProgressDrawable2);
            this.progressDrawable.setSide(AndroidUtilities.dp(7.0f));
            this.clearSearchImageView.setScaleX(0.1f);
            this.clearSearchImageView.setScaleY(0.1f);
            this.clearSearchImageView.setAlpha(0.0f);
            this.clearSearchImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            addView(this.clearSearchImageView, LayoutHelper.createFrame(36, 36.0f, 53, 14.0f, 11.0f, 14.0f, 0.0f));
            this.clearSearchImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$SearchField$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$0(view2);
                }
            });
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context, WalletShareAlert.this) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.SearchField.1
                @Override // org.rbmain.ui.Components.EditTextEffects, android.view.View
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setLocation(motionEventObtain.getRawX(), motionEventObtain.getRawY() - ((BottomSheet) WalletShareAlert.this).containerView.getTranslationY());
                    if (motionEventObtain.getAction() == 1) {
                        motionEventObtain.setAction(3);
                    }
                    WalletShareAlert.this.gridView.dispatchTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                    return super.dispatchTouchEvent(motionEvent);
                }
            };
            this.searchEditText = editTextBoldCursor;
            editTextBoldCursor.setTextSize(1, 16.0f);
            this.searchEditText.setHintTextColor(Theme.getColor(Theme.key_dialogSearchHint));
            this.searchEditText.setTextColor(Theme.getColor(Theme.key_dialogSearchText));
            this.searchEditText.setBackgroundDrawable(null);
            this.searchEditText.setPadding(0, 0, 0, 0);
            this.searchEditText.setMaxLines(1);
            this.searchEditText.setLines(1);
            this.searchEditText.setSingleLine(true);
            this.searchEditText.setImeOptions(268435459);
            this.searchEditText.setHint(LocaleController.getString("ShareSendTo", R.string.ShareSendTo));
            this.searchEditText.setCursorColor(Theme.getColor(Theme.key_featuredStickers_addedIcon));
            this.searchEditText.setCursorSize(AndroidUtilities.dp(20.0f));
            this.searchEditText.setCursorWidth(1.5f);
            addView(this.searchEditText, LayoutHelper.createFrame(-1, 40.0f, 51, 54.0f, 9.0f, 46.0f, 0.0f));
            this.searchEditText.addTextChangedListener(new TextWatcher(WalletShareAlert.this) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.SearchField.2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    boolean z = SearchField.this.searchEditText.length() > 0;
                    if (z != (SearchField.this.clearSearchImageView.getAlpha() != 0.0f)) {
                        SearchField.this.clearSearchImageView.animate().alpha(z ? 1.0f : 0.0f).setDuration(150L).scaleX(z ? 1.0f : 0.1f).scaleY(z ? 1.0f : 0.1f).start();
                    }
                    String string = SearchField.this.searchEditText.getText().toString();
                    if (string.length() != 0) {
                        if (WalletShareAlert.this.searchEmptyView != null) {
                            WalletShareAlert.this.searchEmptyView.setText(LocaleController.getString("NoResult", R.string.NoResult));
                        }
                    } else if (WalletShareAlert.this.gridView.getAdapter() != WalletShareAlert.this.listAdapter) {
                        int currentTop = WalletShareAlert.this.getCurrentTop();
                        WalletShareAlert.this.searchEmptyView.setText(LocaleController.getString("NoChats", R.string.NoChats));
                        WalletShareAlert.this.searchEmptyView.showTextView();
                        WalletShareAlert.this.gridView.setAdapter(WalletShareAlert.this.listAdapter);
                        WalletShareAlert.this.listAdapter.notifyDataSetChanged();
                        if (currentTop > 0) {
                            WalletShareAlert.this.layoutManager.scrollToPositionWithOffset(0, -currentTop);
                        }
                    }
                    if (WalletShareAlert.this.searchAdapter != null) {
                        WalletShareAlert.this.searchAdapter.searchDialogs(string);
                    }
                }
            });
            this.searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$SearchField$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$1(textView, i2, keyEvent);
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

    public WalletShareAlert(Context context, TLRPC$TL_messageMediaWallet tLRPC$TL_messageMediaWallet, boolean z) {
        super(context, true);
        this.shadow = new View[2];
        this.shadowAnimation = new AnimatorSet[2];
        this.selectedDialogs = new LongSparseArray<>();
        this.rect = new RectF();
        this.paint = new Paint(1);
        this.textPaint = new TextPaint(1);
        if (context instanceof Activity) {
        }
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        int i = Theme.key_dialogBackground;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
        this.isFullscreen = z;
        this.sendingMediaWallet = tLRPC$TL_messageMediaWallet;
        this.searchAdapter = new ShareSearchAdapter(context);
        this.useSmoothKeyboard = true;
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.1
            private int fromOffsetTop;
            private int fromScrollY;
            private boolean fullHeight;
            private int previousTopOffset;
            private int toOffsetTop;
            private int toScrollY;
            private int topOffset;
            private boolean ignoreLayout = false;
            private RectF rect1 = new RectF();
            AdjustPanLayoutHelper adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.1.1
                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionStart(boolean z2, int i2) {
                    super.onTransitionStart(z2, i2);
                    if (WalletShareAlert.this.previousScrollOffsetY <= 0 || WalletShareAlert.this.previousScrollOffsetY == WalletShareAlert.this.scrollOffsetY || !z2) {
                        AnonymousClass1.this.fromScrollY = -1;
                    } else {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.fromScrollY = WalletShareAlert.this.previousScrollOffsetY;
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        anonymousClass12.toScrollY = WalletShareAlert.this.scrollOffsetY;
                        WalletShareAlert.this.panTranslationMoveLayout = true;
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        WalletShareAlert.this.scrollOffsetY = anonymousClass13.fromScrollY;
                    }
                    if (AnonymousClass1.this.topOffset != AnonymousClass1.this.previousTopOffset) {
                        AnonymousClass1.this.fromOffsetTop = 0;
                        AnonymousClass1.this.toOffsetTop = 0;
                        WalletShareAlert.this.panTranslationMoveLayout = true;
                        if (!z2) {
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            AnonymousClass1.access$2220(anonymousClass14, anonymousClass14.topOffset - AnonymousClass1.this.previousTopOffset);
                        } else {
                            AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                            AnonymousClass1.access$2212(anonymousClass15, anonymousClass15.topOffset - AnonymousClass1.this.previousTopOffset);
                        }
                        AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                        WalletShareAlert.this.scrollOffsetY = z2 ? anonymousClass16.fromScrollY : anonymousClass16.toScrollY;
                    } else {
                        AnonymousClass1.this.fromOffsetTop = -1;
                    }
                    WalletShareAlert.this.gridView.setTopGlowOffset((int) (WalletShareAlert.this.currentPanTranslationY + WalletShareAlert.this.scrollOffsetY));
                    WalletShareAlert.this.frameLayout.setTranslationY(WalletShareAlert.this.currentPanTranslationY + WalletShareAlert.this.scrollOffsetY);
                    WalletShareAlert.this.searchEmptyView.setTranslationY(WalletShareAlert.this.currentPanTranslationY + WalletShareAlert.this.scrollOffsetY);
                    invalidate();
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onTransitionEnd() {
                    super.onTransitionEnd();
                    WalletShareAlert.this.panTranslationMoveLayout = false;
                    WalletShareAlert.this.updateLayout();
                    WalletShareAlert walletShareAlert = WalletShareAlert.this;
                    walletShareAlert.previousScrollOffsetY = walletShareAlert.scrollOffsetY;
                    WalletShareAlert.this.gridView.setTopGlowOffset(WalletShareAlert.this.scrollOffsetY);
                    WalletShareAlert.this.frameLayout.setTranslationY(WalletShareAlert.this.scrollOffsetY);
                    WalletShareAlert.this.searchEmptyView.setTranslationY(WalletShareAlert.this.scrollOffsetY);
                    WalletShareAlert.this.gridView.setTranslationY(0.0f);
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected void onPanTranslationUpdate(float f, float f2, boolean z2) {
                    super.onPanTranslationUpdate(f, f2, z2);
                    for (int i2 = 0; i2 < ((BottomSheet) WalletShareAlert.this).containerView.getChildCount(); i2++) {
                        if (((BottomSheet) WalletShareAlert.this).containerView.getChildAt(i2) != WalletShareAlert.this.pickerBottomLayout && ((BottomSheet) WalletShareAlert.this).containerView.getChildAt(i2) != WalletShareAlert.this.shadow[1] && ((BottomSheet) WalletShareAlert.this).containerView.getChildAt(i2) != WalletShareAlert.this.sharesCountLayout && ((BottomSheet) WalletShareAlert.this).containerView.getChildAt(i2) != WalletShareAlert.this.frameLayout2 && ((BottomSheet) WalletShareAlert.this).containerView.getChildAt(i2) != WalletShareAlert.this.writeButtonContainer && ((BottomSheet) WalletShareAlert.this).containerView.getChildAt(i2) != WalletShareAlert.this.selectedCountView) {
                            ((BottomSheet) WalletShareAlert.this).containerView.getChildAt(i2).setTranslationY(f);
                        }
                    }
                    WalletShareAlert.this.currentPanTranslationY = f;
                    if (AnonymousClass1.this.fromScrollY != -1 && z2) {
                        float f3 = 1.0f - f2;
                        WalletShareAlert.this.scrollOffsetY = (int) ((r5.fromScrollY * f3) + (AnonymousClass1.this.toScrollY * f2));
                        WalletShareAlert.this.gridView.setTranslationY(WalletShareAlert.this.currentPanTranslationY + ((AnonymousClass1.this.fromScrollY - AnonymousClass1.this.toScrollY) * f3));
                    } else if (AnonymousClass1.this.fromOffsetTop != -1) {
                        float f4 = 1.0f - f2;
                        WalletShareAlert.this.scrollOffsetY = (int) ((r5.fromOffsetTop * f4) + (AnonymousClass1.this.toOffsetTop * f2));
                        if (!z2) {
                            f4 = f2;
                        }
                        if (z2) {
                            WalletShareAlert.this.gridView.setTranslationY(WalletShareAlert.this.currentPanTranslationY - ((AnonymousClass1.this.fromOffsetTop - AnonymousClass1.this.toOffsetTop) * f2));
                        } else {
                            WalletShareAlert.this.gridView.setTranslationY(WalletShareAlert.this.currentPanTranslationY + ((AnonymousClass1.this.toOffsetTop - AnonymousClass1.this.fromOffsetTop) * f4));
                        }
                    }
                    WalletShareAlert.this.gridView.setTopGlowOffset((int) (WalletShareAlert.this.scrollOffsetY + WalletShareAlert.this.currentPanTranslationY));
                    WalletShareAlert.this.frameLayout.setTranslationY(WalletShareAlert.this.scrollOffsetY + WalletShareAlert.this.currentPanTranslationY);
                    WalletShareAlert.this.searchEmptyView.setTranslationY(WalletShareAlert.this.scrollOffsetY + WalletShareAlert.this.currentPanTranslationY);
                    WalletShareAlert.this.frameLayout2.invalidate();
                    WalletShareAlert walletShareAlert = WalletShareAlert.this;
                    walletShareAlert.setCurrentPanTranslationY(walletShareAlert.currentPanTranslationY);
                    invalidate();
                }

                @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                protected boolean heightAnimationEnabled() {
                    if (WalletShareAlert.this.isDismissed()) {
                        return false;
                    }
                    return !WalletShareAlert.this.commentTextView.isPopupVisible();
                }
            };

            static /* synthetic */ int access$2212(AnonymousClass1 anonymousClass1, int i2) {
                int i3 = anonymousClass1.toOffsetTop + i2;
                anonymousClass1.toOffsetTop = i3;
                return i3;
            }

            static /* synthetic */ int access$2220(AnonymousClass1 anonymousClass1, int i2) {
                int i3 = anonymousClass1.toOffsetTop - i2;
                anonymousClass1.toOffsetTop = i3;
                return i3;
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
            protected void onMeasure(int i2, int i3) {
                int size;
                if (getLayoutParams().height > 0) {
                    size = getLayoutParams().height;
                } else {
                    size = View.MeasureSpec.getSize(i3);
                }
                int i4 = 0;
                if (Build.VERSION.SDK_INT >= 21 && !((BottomSheet) WalletShareAlert.this).isFullscreen) {
                    this.ignoreLayout = true;
                    setPadding(((BottomSheet) WalletShareAlert.this).backgroundPaddingLeft, AndroidUtilities.statusBarHeight, ((BottomSheet) WalletShareAlert.this).backgroundPaddingLeft, 0);
                    this.ignoreLayout = false;
                }
                int paddingTop = size - getPaddingTop();
                int iDp = AndroidUtilities.dp(103.0f) + AndroidUtilities.dp(48.0f) + (Math.max(2, (int) Math.ceil(Math.max(WalletShareAlert.this.searchAdapter.getItemCount(), WalletShareAlert.this.listAdapter.getItemCount() - 1) / 4.0f)) * AndroidUtilities.dp(103.0f)) + ((BottomSheet) WalletShareAlert.this).backgroundPaddingTop;
                int iDp2 = (iDp < paddingTop ? 0 : paddingTop - ((paddingTop / 5) * 3)) + AndroidUtilities.dp(8.0f);
                if (WalletShareAlert.this.gridView.getPaddingTop() != iDp2) {
                    this.ignoreLayout = true;
                    WalletShareAlert.this.gridView.setPadding(0, iDp2, 0, AndroidUtilities.dp(48.0f));
                    this.ignoreLayout = false;
                }
                boolean z2 = iDp >= size;
                this.fullHeight = z2;
                if (!z2 && SharedConfig.smoothKeyboard) {
                    i4 = size - iDp;
                }
                this.topOffset = i4;
                setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
                onMeasureInternal(i2, View.MeasureSpec.makeMeasureSpec(Math.min(iDp, size), 1073741824));
            }

            private void onMeasureInternal(int i2, int i3) {
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                int i4 = size - (((BottomSheet) WalletShareAlert.this).backgroundPaddingLeft * 2);
                int iMeasureKeyboardHeight = SharedConfig.smoothKeyboard ? 0 : measureKeyboardHeight();
                if (!WalletShareAlert.this.commentTextView.isWaitingForKeyboardOpen() && iMeasureKeyboardHeight <= AndroidUtilities.dp(20.0f) && !WalletShareAlert.this.commentTextView.isPopupShowing() && !WalletShareAlert.this.commentTextView.isAnimatePopupClosing()) {
                    this.ignoreLayout = true;
                    WalletShareAlert.this.commentTextView.hideEmojiView();
                    this.ignoreLayout = false;
                }
                this.ignoreLayout = true;
                if (iMeasureKeyboardHeight > AndroidUtilities.dp(20.0f)) {
                    WalletShareAlert.this.commentTextView.hideEmojiView();
                    if (WalletShareAlert.this.pickerBottomLayout != null) {
                        WalletShareAlert.this.pickerBottomLayout.setVisibility(8);
                        if (WalletShareAlert.this.sharesCountLayout != null) {
                            WalletShareAlert.this.sharesCountLayout.setVisibility(8);
                        }
                    }
                } else {
                    if (!AndroidUtilities.isInMultiwindow) {
                        size2 -= (SharedConfig.smoothKeyboard && ((BottomSheet) WalletShareAlert.this).keyboardVisible) ? 0 : WalletShareAlert.this.commentTextView.getEmojiPadding();
                        i3 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                    }
                    int i5 = WalletShareAlert.this.commentTextView.isPopupShowing() ? 8 : 0;
                    if (WalletShareAlert.this.pickerBottomLayout != null) {
                        WalletShareAlert.this.pickerBottomLayout.setVisibility(i5);
                        if (WalletShareAlert.this.sharesCountLayout != null) {
                            WalletShareAlert.this.sharesCountLayout.setVisibility(i5);
                        }
                    }
                }
                this.ignoreLayout = false;
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = getChildAt(i6);
                    if (childAt != null && childAt.getVisibility() != 8) {
                        if (WalletShareAlert.this.commentTextView != null && WalletShareAlert.this.commentTextView.isPopupView(childAt)) {
                            if (AndroidUtilities.isInMultiwindow || AndroidUtilities.isTablet()) {
                                if (AndroidUtilities.isTablet()) {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(Math.min(AndroidUtilities.dp(AndroidUtilities.isTablet() ? 200.0f : 320.0f), (size2 - AndroidUtilities.statusBarHeight) + getPaddingTop()), 1073741824));
                                } else {
                                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - AndroidUtilities.statusBarHeight) + getPaddingTop(), 1073741824));
                                }
                            } else {
                                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getLayoutParams().height, 1073741824));
                            }
                        } else {
                            measureChildWithMargins(childAt, i2, 0, i3, 0);
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
                throw new UnsupportedOperationException("Method not decompiled: ir.appp.wallet.cell.component.WalletShareAlert.AnonymousClass1.onLayout(boolean, int, int, int, int):void");
            }

            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (!this.fullHeight) {
                    if (motionEvent.getAction() == 0 && motionEvent.getY() < this.topOffset - AndroidUtilities.dp(30.0f)) {
                        WalletShareAlert.this.dismiss();
                        return true;
                    }
                } else if (motionEvent.getAction() == 0 && WalletShareAlert.this.scrollOffsetY != 0 && motionEvent.getY() < WalletShareAlert.this.scrollOffsetY - AndroidUtilities.dp(30.0f)) {
                    WalletShareAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !WalletShareAlert.this.isDismissed() && super.onTouchEvent(motionEvent);
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
              0x00ad: PHI (r1v11 int) = (r1v10 int), (r1v10 int), (r1v30 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]
              0x00ad: PHI (r2v8 int) = (r2v7 int), (r2v7 int), (r2v27 int) binds: [B:3:0x0056, B:5:0x005c, B:7:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
            @Override // android.view.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            protected void onDraw(android.graphics.Canvas r14) {
                /*
                    Method dump skipped, instructions count: 435
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.appp.wallet.cell.component.WalletShareAlert.AnonymousClass1.onDraw(android.graphics.Canvas):void");
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                canvas.save();
                canvas.clipRect(0.0f, getPaddingTop() + WalletShareAlert.this.currentPanTranslationY, getMeasuredWidth(), getMeasuredHeight() + WalletShareAlert.this.currentPanTranslationY + AndroidUtilities.dp(50.0f));
                super.dispatchDraw(canvas);
                canvas.restore();
            }
        };
        this.containerView = sizeNotifierFrameLayout;
        sizeNotifierFrameLayout.setWillNotDraw(false);
        this.containerView.setClipChildren(false);
        ViewGroup viewGroup = this.containerView;
        int i2 = this.backgroundPaddingLeft;
        viewGroup.setPadding(i2, 0, i2, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        this.frameLayout = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor(i));
        final SearchField searchField = new SearchField(context);
        this.frameLayout.addView(searchField, LayoutHelper.createFrame(-1, 58, 83));
        RecyclerListView recyclerListView = new RecyclerListView(this, context) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.2
            @Override // org.rbmain.ui.Components.RecyclerListView
            protected boolean allowSelectChildAtPosition(float f, float f2) {
                return f2 >= ((float) (AndroidUtilities.dp(58.0f) + (Build.VERSION.SDK_INT >= 21 ? AndroidUtilities.statusBarHeight : 0)));
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
        this.layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ir.appp.wallet.cell.component.WalletShareAlert.3
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i3) {
                if (i3 == 0) {
                    return WalletShareAlert.this.layoutManager.getSpanCount();
                }
                return 1;
            }
        });
        this.gridView.setHorizontalScrollBarEnabled(false);
        this.gridView.setVerticalScrollBarEnabled(false);
        this.gridView.addItemDecoration(new RecyclerView.ItemDecoration(this) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.4
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
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
        this.gridView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.gridView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$$ExternalSyntheticLambda2
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i3) {
                this.f$0.lambda$new$0(searchField, view, i3);
            }
        });
        this.gridView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert.5
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                WalletShareAlert.this.updateLayout();
                if (i4 != 0) {
                    WalletShareAlert walletShareAlert = WalletShareAlert.this;
                    walletShareAlert.previousScrollOffsetY = walletShareAlert.scrollOffsetY;
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
        layoutParams.topMargin = AndroidUtilities.dp(58.0f);
        this.shadow[0] = new View(context);
        View view = this.shadow[0];
        int i3 = Theme.key_dialogShadowLine;
        view.setBackgroundColor(Theme.getColor(i3));
        this.shadow[0].setAlpha(0.0f);
        this.shadow[0].setTag(1);
        this.containerView.addView(this.shadow[0], layoutParams);
        this.containerView.addView(this.frameLayout, LayoutHelper.createFrame(-1, 58, 51));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, AndroidUtilities.getShadowHeight(), 83);
        layoutParams2.bottomMargin = AndroidUtilities.dp(48.0f);
        this.shadow[1] = new View(context);
        this.shadow[1].setBackgroundColor(Theme.getColor(i3));
        this.containerView.addView(this.shadow[1], layoutParams2);
        this.shadow[1].setAlpha(0.0f);
        AnonymousClass6 anonymousClass6 = new AnonymousClass6(context);
        this.frameLayout2 = anonymousClass6;
        anonymousClass6.setWillNotDraw(false);
        this.frameLayout2.setAlpha(0.0f);
        this.frameLayout2.setVisibility(4);
        this.containerView.addView(this.frameLayout2, LayoutHelper.createFrame(-1, -2, 83));
        this.frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return WalletShareAlert.lambda$new$1(view2, motionEvent);
            }
        });
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(context, sizeNotifierFrameLayout, null, 1);
        this.commentTextView = anonymousClass7;
        anonymousClass7.setHint(LocaleController.getString("ShareComment", R.string.ShareComment));
        this.commentTextView.onResume();
        this.frameLayout2.addView(this.commentTextView, LayoutHelper.createFrame(-1, -2.0f, 51, 0.0f, 0.0f, 84.0f, 0.0f));
        this.frameLayout2.setClipChildren(false);
        this.commentTextView.setClipChildren(false);
        FrameLayout frameLayout2 = new FrameLayout(context) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.8
            @Override // android.view.View
            public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                accessibilityNodeInfo.setText(LocaleController.formatPluralString("AccDescrShareInChats", WalletShareAlert.this.selectedDialogs.size()));
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
        ImageView imageView = new ImageView(context);
        int iDp = AndroidUtilities.dp(56.0f);
        int i4 = Theme.key_dialogFloatingButton;
        int color = Theme.getColor(i4);
        int i5 = Build.VERSION.SDK_INT;
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(iDp, color, Theme.getColor(i5 >= 21 ? Theme.key_dialogFloatingButtonPressed : i4));
        if (i5 < 21) {
            Drawable drawableMutate2 = context.getResources().getDrawable(R.drawable.floating_shadow_profile).mutate();
            drawableMutate2.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate2, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        imageView.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        imageView.setImageResource(R.drawable.attach_send);
        imageView.setImportantForAccessibility(2);
        imageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogFloatingIcon), PorterDuff.Mode.MULTIPLY));
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        if (i5 >= 21) {
            imageView.setOutlineProvider(new ViewOutlineProvider(this) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.9
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        this.writeButtonContainer.addView(imageView, LayoutHelper.createFrame(i5 >= 21 ? 56 : 60, i5 >= 21 ? 56.0f : 60.0f, 51, i5 >= 21 ? 2.0f : 0.0f, 0.0f, 0.0f, 0.0f));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$2(view2);
            }
        });
        this.textPaint.setTextSize(AndroidUtilities.dp(12.0f));
        this.textPaint.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        View view2 = new View(context) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.10
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                String str = String.format("%d", Integer.valueOf(Math.max(1, WalletShareAlert.this.selectedDialogs.size())));
                int iMax = Math.max(AndroidUtilities.dp(16.0f) + ((int) Math.ceil(WalletShareAlert.this.textPaint.measureText(str))), AndroidUtilities.dp(24.0f));
                int measuredWidth = getMeasuredWidth() / 2;
                int measuredHeight = getMeasuredHeight() / 2;
                WalletShareAlert.this.textPaint.setColor(Theme.getColor(Theme.key_dialogRoundCheckBoxCheck));
                WalletShareAlert.this.paint.setColor(Theme.getColor(Theme.key_dialogBackground));
                int i6 = iMax / 2;
                WalletShareAlert.this.rect.set(measuredWidth - i6, 0.0f, i6 + measuredWidth, getMeasuredHeight());
                canvas.drawRoundRect(WalletShareAlert.this.rect, AndroidUtilities.dp(12.0f), AndroidUtilities.dp(12.0f), WalletShareAlert.this.paint);
                WalletShareAlert.this.paint.setColor(Theme.getColor(Theme.key_dialogRoundCheckBox));
                WalletShareAlert.this.rect.set(r5 + AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), r2 - AndroidUtilities.dp(2.0f), getMeasuredHeight() - AndroidUtilities.dp(2.0f));
                canvas.drawRoundRect(WalletShareAlert.this.rect, AndroidUtilities.dp(10.0f), AndroidUtilities.dp(10.0f), WalletShareAlert.this.paint);
                canvas.drawText(str, measuredWidth - (r1 / 2), AndroidUtilities.dp(16.2f), WalletShareAlert.this.textPaint);
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
    public /* synthetic */ void lambda$new$0(SearchField searchField, View view, int i) {
        TLRPC$Dialog item;
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
        int i2 = UserConfig.getInstance(this.currentAccount).clientUserId;
        if (this.gridView.getAdapter() == this.searchAdapter) {
            TLRPC$Dialog tLRPC$Dialog = (TLRPC$Dialog) this.listAdapter.dialogsMap.get(item.id);
            if (tLRPC$Dialog == null) {
                this.listAdapter.dialogsMap.put(item.id, item);
                this.listAdapter.dialogs.add(!this.listAdapter.dialogs.isEmpty() ? 1 : 0, item);
            } else if (tLRPC$Dialog.id != i2) {
                this.listAdapter.dialogs.remove(tLRPC$Dialog);
                this.listAdapter.dialogs.add(!this.listAdapter.dialogs.isEmpty() ? 1 : 0, tLRPC$Dialog);
            }
            searchField.searchEditText.setText(BuildConfig.FLAVOR);
            this.gridView.setAdapter(this.listAdapter);
            searchField.hideKeyboard();
        }
    }

    /* renamed from: ir.appp.wallet.cell.component.WalletShareAlert$6, reason: invalid class name */
    class AnonymousClass6 extends FrameLayout {
        private int color;
        private final Paint p;

        AnonymousClass6(Context context) {
            super(context);
            this.p = new Paint();
        }

        @Override // android.view.View
        public void setVisibility(int i) {
            super.setVisibility(i);
            if (i != 0) {
                WalletShareAlert.this.shadow[1].setTranslationY(0.0f);
            }
        }

        @Override // android.view.View
        public void setAlpha(float f) {
            super.setAlpha(f);
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (WalletShareAlert.this.chatActivityEnterViewAnimateFromTop != 0.0f && WalletShareAlert.this.chatActivityEnterViewAnimateFromTop != WalletShareAlert.this.frameLayout2.getTop() + WalletShareAlert.this.chatActivityEnterViewAnimateFromTop) {
                if (WalletShareAlert.this.topBackgroundAnimator != null) {
                    WalletShareAlert.this.topBackgroundAnimator.cancel();
                }
                WalletShareAlert walletShareAlert = WalletShareAlert.this;
                walletShareAlert.captionEditTextTopOffset = walletShareAlert.chatActivityEnterViewAnimateFromTop - (WalletShareAlert.this.frameLayout2.getTop() + WalletShareAlert.this.captionEditTextTopOffset);
                WalletShareAlert walletShareAlert2 = WalletShareAlert.this;
                walletShareAlert2.topBackgroundAnimator = ValueAnimator.ofFloat(walletShareAlert2.captionEditTextTopOffset, 0.0f);
                WalletShareAlert.this.topBackgroundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$6$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.f$0.lambda$onDraw$0(valueAnimator);
                    }
                });
                WalletShareAlert.this.topBackgroundAnimator.setInterpolator(CubicBezierInterpolator.DEFAULT);
                WalletShareAlert.this.topBackgroundAnimator.setDuration(200L);
                WalletShareAlert.this.topBackgroundAnimator.start();
                WalletShareAlert.this.chatActivityEnterViewAnimateFromTop = 0.0f;
            }
            float measuredHeight = (WalletShareAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(48.0f)) * (1.0f - getAlpha());
            WalletShareAlert.this.shadow[1].setTranslationY((-(WalletShareAlert.this.frameLayout2.getMeasuredHeight() - AndroidUtilities.dp(48.0f))) + WalletShareAlert.this.captionEditTextTopOffset + WalletShareAlert.this.currentPanTranslationY + measuredHeight);
            int color = Theme.getColor(Theme.key_dialogBackground);
            if (this.color != color) {
                this.color = color;
                this.p.setColor(color);
            }
            canvas.drawRect(0.0f, WalletShareAlert.this.captionEditTextTopOffset + measuredHeight, getMeasuredWidth(), getMeasuredHeight(), this.p);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDraw$0(ValueAnimator valueAnimator) {
            WalletShareAlert.this.captionEditTextTopOffset = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WalletShareAlert.this.frameLayout2.invalidate();
            invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            canvas.save();
            canvas.clipRect(0.0f, WalletShareAlert.this.captionEditTextTopOffset, getMeasuredWidth(), getMeasuredHeight());
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    /* renamed from: ir.appp.wallet.cell.component.WalletShareAlert$7, reason: invalid class name */
    class AnonymousClass7 extends EditTextEmoji {
        private ValueAnimator messageEditTextAnimator;
        private int messageEditTextPredrawHeigth;
        private int messageEditTextPredrawScrollY;
        private boolean shouldAnimateEditTextWithBounds;

        AnonymousClass7(Context context, SizeNotifierFrameLayout sizeNotifierFrameLayout, BaseFragment baseFragment, int i) {
            super(context, sizeNotifierFrameLayout, baseFragment, i);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            if (this.shouldAnimateEditTextWithBounds) {
                final EditTextCaption editText = WalletShareAlert.this.commentTextView.getEditText();
                editText.setOffsetY(editText.getOffsetY() - ((this.messageEditTextPredrawHeigth - editText.getMeasuredHeight()) + (this.messageEditTextPredrawScrollY - editText.getScrollY())));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(editText.getOffsetY(), 0.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$7$$ExternalSyntheticLambda0
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        WalletShareAlert.AnonymousClass7.lambda$dispatchDraw$0(editText, valueAnimator);
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
            WalletShareAlert.this.chatActivityEnterViewAnimateFromTop = r2.frameLayout2.getTop() + WalletShareAlert.this.captionEditTextTopOffset;
            WalletShareAlert.this.frameLayout2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(View view) {
        int i = 0;
        while (true) {
            if (i >= this.selectedDialogs.size()) {
                if (this.sendingMediaWallet != null) {
                    for (int i2 = 0; i2 < this.selectedDialogs.size(); i2++) {
                        long jKeyAt = this.selectedDialogs.keyAt(i2);
                        if (this.frameLayout2.getTag() != null && this.commentTextView.length() > 0) {
                            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.commentTextView.getText().toString(), jKeyAt, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                        }
                        SendMessagesHelper.getInstance(this.currentAccount).sendMessage(this.sendingMediaWallet, jKeyAt, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
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
            if (AlertsCreator.checkSlowMode(getContext(), this.currentAccount, this.selectedDialogs.keyAt(i), this.frameLayout2.getTag() != null && this.commentTextView.length() > 0)) {
                return;
            } else {
                i++;
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
        this.shadowAnimation[i].addListener(new AnimatorListenerAdapter() { // from class: ir.appp.wallet.cell.component.WalletShareAlert.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (WalletShareAlert.this.shadowAnimation[i] == null || !WalletShareAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                if (!z) {
                    WalletShareAlert.this.shadow[i].setVisibility(4);
                }
                WalletShareAlert.this.shadowAnimation[i] = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (WalletShareAlert.this.shadowAnimation[i] == null || !WalletShareAlert.this.shadowAnimation[i].equals(animator)) {
                    return;
                }
                WalletShareAlert.this.shadowAnimation[i] = null;
            }
        });
        this.shadowAnimation[i].start();
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
        this.animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.appp.wallet.cell.component.WalletShareAlert.12
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator.equals(WalletShareAlert.this.animatorSet)) {
                    if (!z) {
                        WalletShareAlert.this.frameLayout2.setVisibility(4);
                        WalletShareAlert.this.writeButtonContainer.setVisibility(4);
                    }
                    WalletShareAlert.this.animatorSet = null;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (animator.equals(WalletShareAlert.this.animatorSet)) {
                    WalletShareAlert.this.animatorSet = null;
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
            long j;
            int i;
            TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
            this.dialogs.clear();
            this.dialogsMap.clear();
            int i2 = UserConfig.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).clientUserId;
            if (!MessagesController.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).dialogsForward.isEmpty()) {
                TLRPC$Dialog tLRPC$Dialog = MessagesController.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).dialogsForward.get(0);
                this.dialogs.add(tLRPC$Dialog);
                this.dialogsMap.put(tLRPC$Dialog.id, tLRPC$Dialog);
            }
            ArrayList arrayList = new ArrayList();
            ArrayList<TLRPC$Dialog> allDialogs = MessagesController.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).getAllDialogs();
            for (int i3 = 0; i3 < allDialogs.size(); i3++) {
                TLRPC$Dialog tLRPC$Dialog2 = allDialogs.get(i3);
                if ((tLRPC$Dialog2 instanceof TLRPC$TL_dialog) && (i = (int) (j = tLRPC$Dialog2.id)) != i2) {
                    int i4 = (int) (j >> 32);
                    if (i != 0 && i4 != 1) {
                        if (i <= 0) {
                            TLRPC$Chat chat = MessagesController.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).getChat(Integer.valueOf(-i));
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
                shareDialogCell = new ShareDialogCell(this.context, 0);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(100.0f)));
            } else {
                shareDialogCell = new View(this.context);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
            }
            return new RecyclerListView.Holder(shareDialogCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() == 0) {
                ShareDialogCell shareDialogCell = (ShareDialogCell) viewHolder.itemView;
                TLRPC$Dialog item = getItem(i);
                shareDialogCell.setDialog((int) item.id, WalletShareAlert.this.selectedDialogs.indexOfKey(item.id) >= 0, null);
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

        static /* synthetic */ int access$7910(ShareSearchAdapter shareSearchAdapter) {
            int i = shareSearchAdapter.waitingResponseCount;
            shareSearchAdapter.waitingResponseCount = i - 1;
            return i;
        }

        public ShareSearchAdapter(Context context) {
            this.context = context;
            SearchAdapterHelper searchAdapterHelper = new SearchAdapterHelper(false);
            this.searchAdapterHelper = searchAdapterHelper;
            searchAdapterHelper.setDelegate(new SearchAdapterHelper.SearchAdapterHelperDelegate(WalletShareAlert.this) { // from class: ir.appp.wallet.cell.component.WalletShareAlert.ShareSearchAdapter.1
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
                    ShareSearchAdapter.access$7910(ShareSearchAdapter.this);
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
            MessagesStorage.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).getStorageQueue().postRunnable(new Runnable() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda2
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
                AccountInstance.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).getDialogsProxy().localSearch(strArr[0], null, null, arrayList);
                Collections.sort(arrayList, new Comparator() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda4
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return WalletShareAlert.ShareSearchAdapter.lambda$searchDialogsInternal$0(obj, obj2);
                    }
                });
                updateSearchResults(arrayList, i);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$searchDialogsInternal$0(Object obj, Object obj2) {
            int i = ((ShareAlert.DialogSearchResult) obj).date;
            int i2 = ((ShareAlert.DialogSearchResult) obj2).date;
            if (i < i2) {
                return 1;
            }
            return i > i2 ? -1 : 0;
        }

        private void updateSearchResults(final ArrayList<Object> arrayList, final int i) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda1
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
            if (WalletShareAlert.this.gridView.getAdapter() != WalletShareAlert.this.searchAdapter) {
                WalletShareAlert walletShareAlert = WalletShareAlert.this;
                walletShareAlert.topBeforeSwitch = walletShareAlert.getCurrentTop();
                WalletShareAlert.this.gridView.setAdapter(WalletShareAlert.this.searchAdapter);
                WalletShareAlert.this.searchAdapter.notifyDataSetChanged();
            }
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    break;
                }
                TLObject tLObject = ((ShareAlert.DialogSearchResult) arrayList.get(i2)).object;
                if (tLObject instanceof TLRPC$User) {
                    MessagesController.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).putUser((TLRPC$User) tLObject, true);
                } else if (tLObject instanceof TLRPC$Chat) {
                    MessagesController.getInstance(((BottomSheet) WalletShareAlert.this).currentAccount).putChat((TLRPC$Chat) tLObject, true);
                }
                i2++;
            }
            boolean z = !this.searchResult.isEmpty() && arrayList.isEmpty();
            boolean z2 = this.searchResult.isEmpty() && arrayList.isEmpty();
            if (z) {
                WalletShareAlert walletShareAlert2 = WalletShareAlert.this;
                walletShareAlert2.topBeforeSwitch = walletShareAlert2.getCurrentTop();
            }
            this.searchResult = arrayList;
            this.searchAdapterHelper.mergeResults(arrayList);
            notifyDataSetChanged();
            if (!z2 && !z && WalletShareAlert.this.topBeforeSwitch > 0) {
                WalletShareAlert.this.layoutManager.scrollToPositionWithOffset(0, -WalletShareAlert.this.topBeforeSwitch);
                WalletShareAlert.this.topBeforeSwitch = -1000;
            }
            WalletShareAlert.this.searchEmptyView.showTextView();
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
                    WalletShareAlert walletShareAlert = WalletShareAlert.this;
                    walletShareAlert.topBeforeSwitch = walletShareAlert.getCurrentTop();
                    this.lastSearchId = -1;
                    notifyDataSetChanged();
                    return;
                }
                final int i = this.lastSearchId + 1;
                this.lastSearchId = i;
                DispatchQueue dispatchQueue = Utilities.searchQueue;
                Runnable runnable2 = new Runnable() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda3
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
            Runnable runnable = new Runnable() { // from class: ir.appp.wallet.cell.component.WalletShareAlert$ShareSearchAdapter$$ExternalSyntheticLambda0
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
                return ((ShareAlert.DialogSearchResult) this.searchResult.get(i2)).dialog;
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
                shareDialogCell = new ShareDialogCell(this.context, 0);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(100.0f)));
            } else {
                shareDialogCell = new View(this.context);
                shareDialogCell.setLayoutParams(new RecyclerView.LayoutParams(-1, AndroidUtilities.dp(56.0f)));
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
                    ShareAlert.DialogSearchResult dialogSearchResult = (ShareAlert.DialogSearchResult) this.searchResult.get(i2);
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
                shareDialogCell.setDialog((int) j2, WalletShareAlert.this.selectedDialogs.indexOfKey(j2) >= 0, name);
            }
        }
    }
}
