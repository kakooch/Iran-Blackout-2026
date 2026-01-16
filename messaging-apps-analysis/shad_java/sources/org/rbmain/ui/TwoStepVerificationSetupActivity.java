package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Vibrator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Property;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.proxy.ContactsProxy;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SRPHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$PasswordKdfAlgo;
import org.rbmain.tgnet.TLRPC$SecurePasswordKdfAlgo;
import org.rbmain.tgnet.TLRPC$TL_account_cancelPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_confirmPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_getPassword;
import org.rbmain.tgnet.TLRPC$TL_account_password;
import org.rbmain.tgnet.TLRPC$TL_account_passwordInputSettings;
import org.rbmain.tgnet.TLRPC$TL_account_resendPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_updatePasswordSettings;
import org.rbmain.tgnet.TLRPC$TL_auth_recoverPassword;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputCheckPasswordEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputCheckPasswordSRP;
import org.rbmain.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import org.rbmain.tgnet.TLRPC$TL_passwordKdfAlgoUnknown;
import org.rbmain.tgnet.TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000;
import org.rbmain.tgnet.TLRPC$TL_secureSecretSettings;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;

/* loaded from: classes4.dex */
public class TwoStepVerificationSetupActivity extends BaseFragment {
    private AnimatorSet actionBarAnimator;
    private View actionBarBackground;
    private RLottieDrawable[] animationDrawables;
    private AnimatorSet buttonAnimation;
    private TextView buttonTextView;
    private boolean closeAfterSet;
    private TLRPC$TL_account_password currentPassword;
    private byte[] currentPasswordHash;
    private byte[] currentSecret;
    private long currentSecretId;
    private int currentType;
    private TextView descriptionText;
    private TextView descriptionText2;
    private TextView descriptionText3;
    private boolean doneAfterPasswordLoad;
    private String email;
    private int emailCodeLength;
    private boolean emailOnly;
    private Runnable finishCallback;
    private String firstPassword;
    private ArrayList<BaseFragment> fragmentsToClose;
    private String hint;
    private boolean ignoreTextChange;
    private RLottieImageView imageView;
    private EditTextBoldCursor passwordEditText;
    private boolean paused;
    private AlertDialog progressDialog;
    private ScrollView scrollView;
    private Runnable setAnimationRunnable;
    private ImageView showPasswordButton;
    private TextView titleTextView;
    private TextView topButton;
    private boolean waitingForEmail;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$10(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor == null) {
            return;
        }
        if (editTextBoldCursor.length() != 0) {
            this.animationDrawables[2].setCustomEndFrame(49);
            this.animationDrawables[2].setProgress(0.0f, false);
            this.imageView.playAnimation();
            return;
        }
        setRandomMonkeyIdleAnimation(true);
    }

    public TwoStepVerificationSetupActivity(int i, TLRPC$TL_account_password tLRPC$TL_account_password) {
        this.fragmentsToClose = new ArrayList<>();
        this.emailCodeLength = 6;
        this.currentPasswordHash = new byte[0];
        this.finishCallback = new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.currentType = i;
        this.currentPassword = tLRPC$TL_account_password;
        if (tLRPC$TL_account_password == null && i == 6) {
            loadPasswordInfo();
        } else {
            this.waitingForEmail = !TextUtils.isEmpty(tLRPC$TL_account_password.email_unconfirmed_pattern);
        }
    }

    public TwoStepVerificationSetupActivity(int i, int i2, TLRPC$TL_account_password tLRPC$TL_account_password) {
        this.fragmentsToClose = new ArrayList<>();
        this.emailCodeLength = 6;
        this.currentPasswordHash = new byte[0];
        this.finishCallback = new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        this.currentAccount = i;
        this.currentType = i2;
        this.currentPassword = tLRPC$TL_account_password;
        this.waitingForEmail = !TextUtils.isEmpty(tLRPC$TL_account_password.email_unconfirmed_pattern);
        if (this.currentPassword == null && this.currentType == 6) {
            loadPasswordInfo();
        }
    }

    public void setCurrentPasswordParams(byte[] bArr, long j, byte[] bArr2, boolean z) {
        this.currentPasswordHash = bArr;
        this.currentSecret = bArr2;
        this.currentSecretId = j;
        this.emailOnly = z;
    }

    public void addFragmentToClose(BaseFragment baseFragment) {
        this.fragmentsToClose.add(baseFragment);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        this.doneAfterPasswordLoad = false;
        Runnable runnable = this.setAnimationRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.setAnimationRunnable = null;
        }
        if (this.animationDrawables != null) {
            int i = 0;
            while (true) {
                RLottieDrawable[] rLottieDrawableArr = this.animationDrawables;
                if (i >= rLottieDrawableArr.length) {
                    break;
                }
                rLottieDrawableArr[i].recycle(false);
                i++;
            }
            this.animationDrawables = null;
        }
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.progressDialog = null;
        }
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackgroundDrawable(null);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        ActionBar actionBar = this.actionBar;
        int i = Theme.key_windowBackgroundWhiteBlackText;
        actionBar.setTitleColor(Theme.getColor(i));
        this.actionBar.setItemsColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor(Theme.key_actionBarWhiteSelector), false);
        this.actionBar.setCastShadows(false);
        this.actionBar.setAddToContainer(false);
        if (!AndroidUtilities.isTablet()) {
            this.actionBar.showActionModeTop();
        }
        this.actionBar.setActionBarMenuOnItemClick(new AnonymousClass1());
        if (this.currentType == 5) {
            ActionBarMenuItem actionBarMenuItemAddItem = this.actionBar.createMenu().addItem(0, R.drawable.ic_ab_other);
            actionBarMenuItemAddItem.addSubItem(2, LocaleController.getString("ResendCode", R.string.ResendCode));
            actionBarMenuItemAddItem.addSubItem(1, LocaleController.getString("AbortPasswordMenu", R.string.AbortPasswordMenu));
        }
        TextView textView = new TextView(context);
        this.topButton = textView;
        textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText2));
        this.topButton.setTextSize(1, 14.0f);
        this.topButton.setGravity(16);
        this.topButton.setVisibility(8);
        ActionBar actionBar2 = this.actionBar;
        TextView textView2 = this.topButton;
        boolean z = LocaleController.isRTL;
        actionBar2.addView(textView2, LayoutHelper.createFrame(-2, -1.0f, (z ? 3 : 5) | 48, z ? 22.0f : 0.0f, 0.0f, z ? 0.0f : 22.0f, 0.0f));
        this.topButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$2(view);
            }
        });
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        TextView textView3 = new TextView(context);
        this.titleTextView = textView3;
        textView3.setTextColor(Theme.getColor(i));
        this.titleTextView.setGravity(1);
        this.titleTextView.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        this.titleTextView.setTextSize(1, 24.0f);
        TextView textView4 = new TextView(context);
        this.descriptionText = textView4;
        int i2 = Theme.key_windowBackgroundWhiteGrayText6;
        textView4.setTextColor(Theme.getColor(i2));
        this.descriptionText.setGravity(1);
        this.descriptionText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText.setTextSize(1, 15.0f);
        this.descriptionText.setVisibility(8);
        this.descriptionText.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        TextView textView5 = new TextView(context);
        this.descriptionText2 = textView5;
        textView5.setTextColor(Theme.getColor(i2));
        this.descriptionText2.setGravity(1);
        this.descriptionText2.setTextSize(1, 14.0f);
        this.descriptionText2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText2.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        this.descriptionText2.setVisibility(8);
        TextView textView6 = new TextView(context);
        this.buttonTextView = textView6;
        textView6.setMinWidth(AndroidUtilities.dp(220.0f));
        this.buttonTextView.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        this.buttonTextView.setGravity(17);
        this.buttonTextView.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        this.buttonTextView.setTextSize(1, 14.0f);
        this.buttonTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        this.buttonTextView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$9(view);
            }
        });
        switch (this.currentType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                ViewGroup viewGroup = new ViewGroup(context) { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.3
                    @Override // android.view.View
                    protected void onMeasure(int i3, int i4) {
                        int size = View.MeasureSpec.getSize(i3);
                        int size2 = View.MeasureSpec.getSize(i4);
                        if (TwoStepVerificationSetupActivity.this.topButton != null) {
                            ((FrameLayout.LayoutParams) TwoStepVerificationSetupActivity.this.topButton.getLayoutParams()).topMargin = AndroidUtilities.statusBarHeight;
                        }
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i4);
                        TwoStepVerificationSetupActivity.this.actionBarBackground.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredHeight() + AndroidUtilities.dp(3.0f), 1073741824));
                        TwoStepVerificationSetupActivity.this.scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i4);
                        setMeasuredDimension(size, size2);
                    }

                    @Override // android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.layout(0, 0, ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredWidth(), ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredHeight());
                        TwoStepVerificationSetupActivity.this.actionBarBackground.layout(0, 0, TwoStepVerificationSetupActivity.this.actionBarBackground.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.actionBarBackground.getMeasuredHeight());
                        TwoStepVerificationSetupActivity.this.scrollView.layout(0, 0, TwoStepVerificationSetupActivity.this.scrollView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.scrollView.getMeasuredHeight());
                    }
                };
                ScrollView scrollView = new ScrollView(context) { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.4
                    private int scrollingUp;
                    private int[] location = new int[2];
                    private Rect tempRect = new Rect();
                    private boolean isLayoutDirty = true;

                    @Override // android.view.View
                    protected void onScrollChanged(int i3, int i4, int i5, int i6) {
                        super.onScrollChanged(i3, i4, i5, i6);
                        if (TwoStepVerificationSetupActivity.this.titleTextView == null) {
                            return;
                        }
                        TwoStepVerificationSetupActivity.this.titleTextView.getLocationOnScreen(this.location);
                        boolean z2 = this.location[1] + TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() < ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getBottom();
                        if (z2 != (TwoStepVerificationSetupActivity.this.titleTextView.getTag() == null)) {
                            TwoStepVerificationSetupActivity.this.titleTextView.setTag(z2 ? null : 1);
                            if (TwoStepVerificationSetupActivity.this.actionBarAnimator != null) {
                                TwoStepVerificationSetupActivity.this.actionBarAnimator.cancel();
                                TwoStepVerificationSetupActivity.this.actionBarAnimator = null;
                            }
                            TwoStepVerificationSetupActivity.this.actionBarAnimator = new AnimatorSet();
                            AnimatorSet animatorSet = TwoStepVerificationSetupActivity.this.actionBarAnimator;
                            Animator[] animatorArr = new Animator[2];
                            View view = TwoStepVerificationSetupActivity.this.actionBarBackground;
                            Property property = View.ALPHA;
                            float[] fArr = new float[1];
                            fArr[0] = z2 ? 1.0f : 0.0f;
                            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                            SimpleTextView titleTextView = ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getTitleTextView();
                            Property property2 = View.ALPHA;
                            float[] fArr2 = new float[1];
                            fArr2[0] = z2 ? 1.0f : 0.0f;
                            animatorArr[1] = ObjectAnimator.ofFloat(titleTextView, (Property<SimpleTextView, Float>) property2, fArr2);
                            animatorSet.playTogether(animatorArr);
                            TwoStepVerificationSetupActivity.this.actionBarAnimator.setDuration(150L);
                            TwoStepVerificationSetupActivity.this.actionBarAnimator.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.4.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator) {
                                    if (animator.equals(TwoStepVerificationSetupActivity.this.actionBarAnimator)) {
                                        TwoStepVerificationSetupActivity.this.actionBarAnimator = null;
                                    }
                                }
                            });
                            TwoStepVerificationSetupActivity.this.actionBarAnimator.start();
                        }
                    }

                    @Override // android.widget.ScrollView
                    public void scrollToDescendant(View view) {
                        view.getDrawingRect(this.tempRect);
                        offsetDescendantRectToMyCoords(view, this.tempRect);
                        this.tempRect.bottom += AndroidUtilities.dp(120.0f);
                        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.tempRect);
                        if (iComputeScrollDeltaToGetChildRectOnScreen < 0) {
                            int measuredHeight = (getMeasuredHeight() - view.getMeasuredHeight()) / 2;
                            this.scrollingUp = measuredHeight;
                            iComputeScrollDeltaToGetChildRectOnScreen -= measuredHeight;
                        } else {
                            this.scrollingUp = 0;
                        }
                        if (iComputeScrollDeltaToGetChildRectOnScreen != 0) {
                            smoothScrollBy(0, iComputeScrollDeltaToGetChildRectOnScreen);
                        }
                    }

                    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
                    public void requestChildFocus(View view, View view2) {
                        if (Build.VERSION.SDK_INT < 29 && view2 != null && !this.isLayoutDirty) {
                            scrollToDescendant(view2);
                        }
                        super.requestChildFocus(view, view2);
                    }

                    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
                    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
                        if (Build.VERSION.SDK_INT < 23) {
                            int iDp = rect.bottom + AndroidUtilities.dp(120.0f);
                            rect.bottom = iDp;
                            int i3 = this.scrollingUp;
                            if (i3 != 0) {
                                rect.top -= i3;
                                rect.bottom = iDp - i3;
                                this.scrollingUp = 0;
                            }
                        }
                        return super.requestChildRectangleOnScreen(view, rect, z2);
                    }

                    @Override // android.widget.ScrollView, android.view.View, android.view.ViewParent
                    public void requestLayout() {
                        this.isLayoutDirty = true;
                        super.requestLayout();
                    }

                    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
                        this.isLayoutDirty = false;
                        super.onLayout(z2, i3, i4, i5, i6);
                    }
                };
                this.scrollView = scrollView;
                scrollView.setVerticalScrollBarEnabled(false);
                viewGroup.addView(this.scrollView);
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                this.scrollView.addView(linearLayout, LayoutHelper.createScroll(-1, -1, 51));
                linearLayout.addView(this.imageView, LayoutHelper.createLinear(-2, -2, 49, 0, 69, 0, 0));
                linearLayout.addView(this.titleTextView, LayoutHelper.createLinear(-2, -2, 49, 0, 8, 0, 0));
                linearLayout.addView(this.descriptionText, LayoutHelper.createLinear(-2, -2, 49, 0, 9, 0, 0));
                FrameLayout frameLayout = new FrameLayout(context);
                linearLayout.addView(frameLayout, LayoutHelper.createLinear(220, 36, 49, 40, 32, 40, 0));
                EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
                this.passwordEditText = editTextBoldCursor;
                editTextBoldCursor.setTextSize(1, 17.0f);
                this.passwordEditText.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
                EditTextBoldCursor editTextBoldCursor2 = this.passwordEditText;
                int i3 = Theme.key_windowBackgroundWhiteHintText;
                editTextBoldCursor2.setHintTextColor(Theme.getColor(i3));
                this.passwordEditText.setCursorColor(Theme.getColor(i));
                this.passwordEditText.setTextColor(Theme.getColor(i));
                this.passwordEditText.setHintColor(Theme.getColor(i3));
                this.passwordEditText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
                this.passwordEditText.setMaxLines(1);
                this.passwordEditText.setLines(1);
                this.passwordEditText.setGravity(3);
                this.passwordEditText.setCursorSize(AndroidUtilities.dp(20.0f));
                this.passwordEditText.setSingleLine(true);
                this.passwordEditText.setCursorWidth(1.5f);
                frameLayout.addView(this.passwordEditText, LayoutHelper.createFrame(220, 36, 49));
                this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda9
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView7, int i4, KeyEvent keyEvent) {
                        return this.f$0.lambda$createView$11(textView7, i4, keyEvent);
                    }
                });
                this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback(this) { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.5
                    @Override // android.view.ActionMode.Callback
                    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public void onDestroyActionMode(ActionMode actionMode) {
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                        return false;
                    }
                });
                ImageView imageView = new ImageView(context) { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.6
                    @Override // android.view.View
                    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                        accessibilityNodeInfo.setCheckable(true);
                        accessibilityNodeInfo.setChecked(TwoStepVerificationSetupActivity.this.passwordEditText.getTransformationMethod() == null);
                    }
                };
                this.showPasswordButton = imageView;
                imageView.setImageResource(R.drawable.msg_message);
                this.showPasswordButton.setScaleType(ImageView.ScaleType.CENTER);
                this.showPasswordButton.setContentDescription(LocaleController.getString("TwoStepVerificationShowPassword", R.string.TwoStepVerificationShowPassword));
                if (Build.VERSION.SDK_INT >= 21) {
                    this.showPasswordButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector)));
                }
                this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelIcons), PorterDuff.Mode.MULTIPLY));
                this.showPasswordButton.setVisibility(8);
                frameLayout.addView(this.showPasswordButton, LayoutHelper.createFrame(36, 36.0f, 53, 0.0f, -5.0f, 0.0f, 0.0f));
                this.showPasswordButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$createView$12(view);
                    }
                });
                FrameLayout frameLayout2 = new FrameLayout(context);
                linearLayout.addView(frameLayout2, LayoutHelper.createLinear(-1, -2, 51, 0, 36, 0, 22));
                frameLayout2.addView(this.buttonTextView, LayoutHelper.createFrame(-2, 42, 49));
                frameLayout2.addView(this.descriptionText2, LayoutHelper.createFrame(-2, -2, 49));
                if (this.currentType == 4) {
                    TextView textView7 = new TextView(context);
                    this.descriptionText3 = textView7;
                    textView7.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkText));
                    this.descriptionText3.setGravity(1);
                    this.descriptionText3.setTextSize(1, 14.0f);
                    this.descriptionText3.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
                    this.descriptionText3.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
                    this.descriptionText3.setText(LocaleController.getString("RestoreEmailTroubleNoEmail", R.string.RestoreEmailTroubleNoEmail));
                    linearLayout.addView(this.descriptionText3, LayoutHelper.createLinear(-2, -2, 49, 0, 0, 0, 25));
                    this.descriptionText3.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$createView$13(view);
                        }
                    });
                }
                this.fragmentView = viewGroup;
                View view = new View(context) { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.7
                    private Paint paint = new Paint();

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        this.paint.setColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                        int measuredHeight = getMeasuredHeight() - AndroidUtilities.dp(3.0f);
                        canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), measuredHeight, this.paint);
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).parentLayout.drawHeaderShadow(canvas, measuredHeight);
                    }
                };
                this.actionBarBackground = view;
                view.setAlpha(0.0f);
                viewGroup.addView(this.actionBarBackground);
                viewGroup.addView(this.actionBar);
                break;
            case 6:
            case 7:
                ViewGroup viewGroup2 = new ViewGroup(context) { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.2
                    @Override // android.view.View
                    protected void onMeasure(int i4, int i5) {
                        int size = View.MeasureSpec.getSize(i4);
                        int size2 = View.MeasureSpec.getSize(i5);
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), i5);
                        if (size > size2) {
                            float f = size;
                            TwoStepVerificationSetupActivity.this.imageView.measure(View.MeasureSpec.makeMeasureSpec((int) (0.45f * f), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size2 * 0.68f), 1073741824));
                            int i6 = (int) (f * 0.6f);
                            TwoStepVerificationSetupActivity.this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.descriptionText.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.descriptionText2.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.buttonTextView.measure(View.MeasureSpec.makeMeasureSpec(i6, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824));
                        } else {
                            TwoStepVerificationSetupActivity.this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size2 * 0.399f), 1073741824));
                            TwoStepVerificationSetupActivity.this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.descriptionText.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.descriptionText2.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.buttonTextView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824));
                        }
                        setMeasuredDimension(size, size2);
                    }

                    @Override // android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean z2, int i4, int i5, int i6, int i7) {
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.layout(0, 0, i6, ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredHeight());
                        int i8 = i6 - i4;
                        int i9 = i7 - i5;
                        if (i6 > i7) {
                            int measuredHeight = (i9 - TwoStepVerificationSetupActivity.this.imageView.getMeasuredHeight()) / 2;
                            TwoStepVerificationSetupActivity.this.imageView.layout(0, measuredHeight, TwoStepVerificationSetupActivity.this.imageView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.imageView.getMeasuredHeight() + measuredHeight);
                            float f = i8;
                            float f2 = 0.4f * f;
                            int i10 = (int) f2;
                            float f3 = i9;
                            int i11 = (int) (0.22f * f3);
                            TwoStepVerificationSetupActivity.this.titleTextView.layout(i10, i11, TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredWidth() + i10, TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() + i11);
                            int i12 = (int) (0.39f * f3);
                            TwoStepVerificationSetupActivity.this.descriptionText.layout(i10, i12, TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredWidth() + i10, TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredHeight() + i12);
                            int measuredWidth = (int) (f2 + (((f * 0.6f) - TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i13 = (int) (f3 * 0.64f);
                            TwoStepVerificationSetupActivity.this.buttonTextView.layout(measuredWidth, i13, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredHeight() + i13);
                            return;
                        }
                        float f4 = i9;
                        int i14 = (int) (0.148f * f4);
                        TwoStepVerificationSetupActivity.this.imageView.layout(0, i14, TwoStepVerificationSetupActivity.this.imageView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.imageView.getMeasuredHeight() + i14);
                        int i15 = (int) (0.458f * f4);
                        TwoStepVerificationSetupActivity.this.titleTextView.layout(0, i15, TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() + i15);
                        int measuredHeight2 = i15 + TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() + AndroidUtilities.dp(12.0f);
                        TwoStepVerificationSetupActivity.this.descriptionText.layout(0, measuredHeight2, TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredHeight() + measuredHeight2);
                        int measuredWidth2 = (i8 - TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i16 = (int) (f4 * 0.791f);
                        TwoStepVerificationSetupActivity.this.buttonTextView.layout(measuredWidth2, i16, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth2, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredHeight() + i16);
                    }
                };
                viewGroup2.setOnTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        return TwoStepVerificationSetupActivity.lambda$createView$10(view2, motionEvent);
                    }
                });
                viewGroup2.addView(this.actionBar);
                viewGroup2.addView(this.imageView);
                viewGroup2.addView(this.titleTextView);
                viewGroup2.addView(this.descriptionText);
                viewGroup2.addView(this.buttonTextView);
                this.fragmentView = viewGroup2;
                break;
        }
        this.fragmentView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        switch (this.currentType) {
            case 0:
                if (this.currentPassword.has_password) {
                    this.actionBar.setTitle(LocaleController.getString("PleaseEnterNewFirstPassword", R.string.PleaseEnterNewFirstPassword));
                    this.titleTextView.setText(LocaleController.getString("PleaseEnterNewFirstPassword", R.string.PleaseEnterNewFirstPassword));
                } else {
                    this.actionBar.setTitle(LocaleController.getString("PleaseEnterFirstPassword", R.string.PleaseEnterFirstPassword));
                    this.titleTextView.setText(LocaleController.getString("PleaseEnterFirstPassword", R.string.PleaseEnterFirstPassword));
                }
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                this.buttonTextView.setText(LocaleController.getString("Continue", R.string.Continue));
                this.passwordEditText.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
                this.passwordEditText.setImeOptions(268435461);
                this.passwordEditText.setInputType(129);
                this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordEditText.setTypeface(Typeface.DEFAULT);
                this.showPasswordButton.setVisibility(0);
                this.passwordEditText.setPadding(0, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(36.0f), 0);
                RLottieDrawable[] rLottieDrawableArr = new RLottieDrawable[6];
                this.animationDrawables = rLottieDrawableArr;
                rLottieDrawableArr[0] = new RLottieDrawable(R.raw.tsv_setup_monkey_idle1, "2131820675", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, null);
                this.animationDrawables[1] = new RLottieDrawable(R.raw.tsv_setup_monkey_idle2, "2131820676", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, null);
                this.animationDrawables[2] = new RLottieDrawable(R.raw.tsv_monkey_close, "2131820668", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, null);
                this.animationDrawables[3] = new RLottieDrawable(R.raw.tsv_setup_monkey_peek, "2131820677", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, null);
                this.animationDrawables[4] = new RLottieDrawable(R.raw.tsv_setup_monkey_close_and_peek_to_idle, "2131820674", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, null);
                this.animationDrawables[5] = new RLottieDrawable(R.raw.tsv_setup_monkey_close_and_peek, "2131820673", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, null);
                this.animationDrawables[2].setOnFinishCallback(this.finishCallback, 97);
                setRandomMonkeyIdleAnimation(true);
                break;
            case 1:
                this.actionBar.setTitle(LocaleController.getString("PleaseReEnterPassword", R.string.PleaseReEnterPassword));
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                this.titleTextView.setText(LocaleController.getString("PleaseReEnterPassword", R.string.PleaseReEnterPassword));
                this.buttonTextView.setText(LocaleController.getString("Continue", R.string.Continue));
                this.passwordEditText.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
                this.passwordEditText.setImeOptions(268435461);
                this.passwordEditText.setInputType(129);
                this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordEditText.setTypeface(Typeface.DEFAULT);
                this.showPasswordButton.setVisibility(0);
                this.passwordEditText.setPadding(0, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(36.0f), 0);
                this.animationDrawables = new RLottieDrawable[]{new RLottieDrawable(R.raw.tsv_setup_monkey_tracking, "2131820678", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, null)};
                this.animationDrawables[0].setPlayInDirectionOfCustomEndFrame(true);
                this.animationDrawables[0].setCustomEndFrame(19);
                this.imageView.setAnimation(this.animationDrawables[0]);
                this.imageView.playAnimation();
                break;
            case 2:
                this.actionBar.setTitle(LocaleController.getString("PasswordHint", R.string.PasswordHint));
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                this.topButton.setVisibility(0);
                this.topButton.setText(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip));
                this.titleTextView.setText(LocaleController.getString("PasswordHint", R.string.PasswordHint));
                this.buttonTextView.setText(LocaleController.getString("Continue", R.string.Continue));
                this.passwordEditText.setHint(LocaleController.getString("PasswordHintPlaceholder", R.string.PasswordHintPlaceholder));
                this.passwordEditText.setImeOptions(268435461);
                this.imageView.setAnimation(R.raw.tsv_setup_hint, 120, 120);
                this.imageView.playAnimation();
                break;
            case 3:
                this.actionBar.setTitle(LocaleController.getString("RecoveryEmailTitle", R.string.RecoveryEmailTitle));
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                if (!this.emailOnly) {
                    this.topButton.setVisibility(0);
                    this.topButton.setText(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip));
                }
                this.titleTextView.setText(LocaleController.getString("RecoveryEmailTitle", R.string.RecoveryEmailTitle));
                this.buttonTextView.setText(LocaleController.getString("Continue", R.string.Continue));
                this.passwordEditText.setHint(LocaleController.getString("PaymentShippingEmailPlaceholder", R.string.PaymentShippingEmailPlaceholder));
                this.passwordEditText.setImeOptions(268435461);
                this.passwordEditText.setInputType(33);
                this.imageView.setAnimation(R.raw.tsv_setup_email_sent, 120, 120);
                this.imageView.playAnimation();
                break;
            case 4:
                this.actionBar.setTitle(LocaleController.getString("PasswordRecovery", R.string.PasswordRecovery));
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                this.titleTextView.setText(LocaleController.getString("PasswordRecovery", R.string.PasswordRecovery));
                this.buttonTextView.setText(LocaleController.getString("Continue", R.string.Continue));
                this.passwordEditText.setHint(LocaleController.getString("EnterCode", R.string.EnterCode));
                this.passwordEditText.setInputType(3);
                this.passwordEditText.setImeOptions(268435462);
                TextView textView8 = this.descriptionText2;
                Object[] objArr = new Object[1];
                String str = this.currentPassword.email_unconfirmed_pattern;
                if (str == null) {
                    str = BuildConfig.FLAVOR;
                }
                objArr[0] = str;
                textView8.setText(LocaleController.formatString("RestoreEmailSent", R.string.RestoreEmailSent, objArr));
                this.descriptionText2.setVisibility(0);
                this.buttonTextView.setVisibility(4);
                this.buttonTextView.setAlpha(0.0f);
                this.buttonTextView.setScaleX(0.9f);
                this.buttonTextView.setScaleY(0.9f);
                this.imageView.setAnimation(R.raw.tsv_setup_mail, 120, 120);
                this.imageView.playAnimation();
                break;
            case 5:
                this.actionBar.setTitle(LocaleController.getString("VerificationCode", R.string.VerificationCode));
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                this.titleTextView.setText(LocaleController.getString("VerificationCode", R.string.VerificationCode));
                this.buttonTextView.setText(LocaleController.getString("Continue", R.string.Continue));
                this.passwordEditText.setHint(LocaleController.getString("EnterCode", R.string.EnterCode));
                this.passwordEditText.setInputType(3);
                this.passwordEditText.setImeOptions(268435462);
                TextView textView9 = this.descriptionText2;
                Object[] objArr2 = new Object[1];
                String str2 = this.currentPassword.email_unconfirmed_pattern;
                if (str2 == null) {
                    str2 = BuildConfig.FLAVOR;
                }
                objArr2[0] = str2;
                textView9.setText(LocaleController.formatString("EmailPasswordConfirmText2", R.string.EmailPasswordConfirmText2, objArr2));
                this.descriptionText2.setVisibility(0);
                this.buttonTextView.setVisibility(4);
                this.buttonTextView.setAlpha(0.0f);
                this.buttonTextView.setScaleX(0.9f);
                this.buttonTextView.setScaleY(0.9f);
                this.imageView.setAnimation(R.raw.tsv_setup_mail, 120, 120);
                this.imageView.playAnimation();
                break;
            case 6:
                this.titleTextView.setText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle));
                this.descriptionText.setText(LocaleController.getString("SetAdditionalPasswordInfo", R.string.SetAdditionalPasswordInfo));
                this.buttonTextView.setText(LocaleController.getString("TwoStepVerificationSetPassword", R.string.TwoStepVerificationSetPassword));
                this.descriptionText.setVisibility(0);
                this.imageView.setAnimation(R.raw.tsv_setup_intro, 120, 120);
                this.imageView.playAnimation();
                break;
            case 7:
                this.titleTextView.setText(LocaleController.getString("TwoStepVerificationPasswordSet", R.string.TwoStepVerificationPasswordSet));
                this.descriptionText.setText(LocaleController.getString("TwoStepVerificationPasswordSetInfo", R.string.TwoStepVerificationPasswordSetInfo));
                if (this.closeAfterSet) {
                    this.buttonTextView.setText(LocaleController.getString("TwoStepVerificationPasswordReturnPassport", R.string.TwoStepVerificationPasswordReturnPassport));
                } else {
                    this.buttonTextView.setText(LocaleController.getString("TwoStepVerificationPasswordReturnSettings", R.string.TwoStepVerificationPasswordReturnSettings));
                }
                this.descriptionText.setVisibility(0);
                this.imageView.setAnimation(R.raw.wallet_allset, 120, 120);
                this.imageView.playAnimation();
                break;
        }
        EditTextBoldCursor editTextBoldCursor3 = this.passwordEditText;
        if (editTextBoldCursor3 != null) {
            editTextBoldCursor3.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.8
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (TwoStepVerificationSetupActivity.this.ignoreTextChange) {
                        return;
                    }
                    if (TwoStepVerificationSetupActivity.this.currentType == 0) {
                        RLottieDrawable animatedDrawable = TwoStepVerificationSetupActivity.this.imageView.getAnimatedDrawable();
                        if (TwoStepVerificationSetupActivity.this.passwordEditText.length() > 0) {
                            if (TwoStepVerificationSetupActivity.this.passwordEditText.getTransformationMethod() == null) {
                                if (animatedDrawable == TwoStepVerificationSetupActivity.this.animationDrawables[3] || animatedDrawable == TwoStepVerificationSetupActivity.this.animationDrawables[5]) {
                                    return;
                                }
                                TwoStepVerificationSetupActivity.this.imageView.setAnimation(TwoStepVerificationSetupActivity.this.animationDrawables[5]);
                                TwoStepVerificationSetupActivity.this.animationDrawables[5].setProgress(0.0f, false);
                                TwoStepVerificationSetupActivity.this.imageView.playAnimation();
                                return;
                            }
                            if (animatedDrawable != TwoStepVerificationSetupActivity.this.animationDrawables[3]) {
                                if (animatedDrawable != TwoStepVerificationSetupActivity.this.animationDrawables[2]) {
                                    TwoStepVerificationSetupActivity.this.imageView.setAnimation(TwoStepVerificationSetupActivity.this.animationDrawables[2]);
                                    TwoStepVerificationSetupActivity.this.animationDrawables[2].setCustomEndFrame(49);
                                    TwoStepVerificationSetupActivity.this.animationDrawables[2].setProgress(0.0f, false);
                                    TwoStepVerificationSetupActivity.this.imageView.playAnimation();
                                    return;
                                }
                                if (TwoStepVerificationSetupActivity.this.animationDrawables[2].getCurrentFrame() < 49) {
                                    TwoStepVerificationSetupActivity.this.animationDrawables[2].setCustomEndFrame(49);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if ((animatedDrawable != TwoStepVerificationSetupActivity.this.animationDrawables[3] || TwoStepVerificationSetupActivity.this.passwordEditText.getTransformationMethod() != null) && animatedDrawable != TwoStepVerificationSetupActivity.this.animationDrawables[5]) {
                            TwoStepVerificationSetupActivity.this.animationDrawables[2].setCustomEndFrame(-1);
                            if (animatedDrawable != TwoStepVerificationSetupActivity.this.animationDrawables[2]) {
                                TwoStepVerificationSetupActivity.this.imageView.setAnimation(TwoStepVerificationSetupActivity.this.animationDrawables[2]);
                                TwoStepVerificationSetupActivity.this.animationDrawables[2].setCurrentFrame(49, false);
                            }
                            TwoStepVerificationSetupActivity.this.imageView.playAnimation();
                            return;
                        }
                        TwoStepVerificationSetupActivity.this.imageView.setAnimation(TwoStepVerificationSetupActivity.this.animationDrawables[4]);
                        TwoStepVerificationSetupActivity.this.animationDrawables[4].setProgress(0.0f, false);
                        TwoStepVerificationSetupActivity.this.imageView.playAnimation();
                        return;
                    }
                    if (TwoStepVerificationSetupActivity.this.currentType == 1) {
                        try {
                            TwoStepVerificationSetupActivity.this.animationDrawables[0].setCustomEndFrame((int) ((Math.min(1.0f, TwoStepVerificationSetupActivity.this.passwordEditText.getLayout().getLineWidth(0) / TwoStepVerificationSetupActivity.this.passwordEditText.getWidth()) * 142.0f) + 18.0f));
                            TwoStepVerificationSetupActivity.this.imageView.playAnimation();
                            return;
                        } catch (Exception e) {
                            FileLog.e(e);
                            return;
                        }
                    }
                    if (TwoStepVerificationSetupActivity.this.currentType == 5 || TwoStepVerificationSetupActivity.this.currentType == 4) {
                        if (TwoStepVerificationSetupActivity.this.emailCodeLength != 0 && editable.length() == TwoStepVerificationSetupActivity.this.emailCodeLength) {
                            TwoStepVerificationSetupActivity.this.buttonTextView.callOnClick();
                        }
                        TwoStepVerificationSetupActivity.this.showDoneButton(editable.length() > 0);
                    }
                }
            });
        }
        return this.fragmentView;
    }

    /* renamed from: org.rbmain.ui.TwoStepVerificationSetupActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        AnonymousClass1() {
        }

        @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int i) {
            String string;
            if (i == -1) {
                TwoStepVerificationSetupActivity.this.finishFragment();
                return;
            }
            if (i == 2) {
                TLRPC$TL_account_resendPasswordEmail tLRPC$TL_account_resendPasswordEmail = new TLRPC$TL_account_resendPasswordEmail();
                tLRPC$TL_account_resendPasswordEmail.password = TwoStepVerificationSetupActivity.this.currentPassword.has_password ? TwoStepVerificationSetupActivity.this.currentPasswordHash : null;
                TwoStepVerificationSetupActivity.this.needShowProgress();
                ContactsProxy.getInstance(((BaseFragment) TwoStepVerificationSetupActivity.this).currentAccount).resendCodeRecoveryEmail(tLRPC$TL_account_resendPasswordEmail, new RequestDelegate() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$1$$ExternalSyntheticLambda2
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onItemClick$1(tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            if (i == 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationSetupActivity.this.getParentActivity());
                if (TwoStepVerificationSetupActivity.this.currentPassword != null && TwoStepVerificationSetupActivity.this.currentPassword.has_password) {
                    string = LocaleController.getString("CancelEmailQuestion", R.string.CancelEmailQuestion);
                } else {
                    string = LocaleController.getString("CancelPasswordQuestion", R.string.CancelPasswordQuestion);
                }
                String string2 = LocaleController.getString("CancelEmailQuestionTitle", R.string.CancelEmailQuestionTitle);
                String string3 = LocaleController.getString("Accept", R.string.Accept);
                builder.setMessage(string);
                builder.setTitle(string2);
                builder.setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$1$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        this.f$0.lambda$onItemClick$2(dialogInterface, i2);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder.create();
                TwoStepVerificationSetupActivity.this.showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$1(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onItemClick$0(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(TLRPC$TL_error tLRPC$TL_error) {
            TwoStepVerificationSetupActivity.this.needHideProgress();
            if (tLRPC$TL_error != null) {
                TwoStepVerificationSetupActivity.this.showAlertWithText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle), tLRPC$TL_error.text);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationSetupActivity.this.getParentActivity());
            builder.setMessage(LocaleController.getString("ResendCodeInfo", R.string.ResendCodeInfo));
            builder.setTitle(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            TwoStepVerificationSetupActivity.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$2(DialogInterface dialogInterface, int i) {
            TwoStepVerificationSetupActivity.this.setNewPassword(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(View view) {
        int i = this.currentType;
        if (i != 3) {
            if (i == 2) {
                onHintDone();
                return;
            }
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setMessage(LocaleController.getString("YourEmailSkipWarningText", R.string.YourEmailSkipWarningText));
        builder.setTitle(LocaleController.getString("YourEmailSkipWarning", R.string.YourEmailSkipWarning));
        builder.setPositiveButton(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$createView$1(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(DialogInterface dialogInterface, int i) {
        this.email = BuildConfig.FLAVOR;
        setNewPassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$9(View view) {
        if (getParentActivity() == null) {
        }
        switch (this.currentType) {
            case 0:
                if (this.passwordEditText.length() == 0) {
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(this.currentAccount, 1, this.currentPassword);
                    twoStepVerificationSetupActivity.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, this.emailOnly);
                    twoStepVerificationSetupActivity.firstPassword = this.passwordEditText.getText().toString();
                    twoStepVerificationSetupActivity.fragmentsToClose.addAll(this.fragmentsToClose);
                    twoStepVerificationSetupActivity.fragmentsToClose.add(this);
                    twoStepVerificationSetupActivity.closeAfterSet = this.closeAfterSet;
                    presentFragment(twoStepVerificationSetupActivity);
                    break;
                }
            case 1:
                if (!this.firstPassword.equals(this.passwordEditText.getText().toString())) {
                    try {
                        Toast.makeText(getParentActivity(), LocaleController.getString("PasswordDoNotMatch", R.string.PasswordDoNotMatch), 0).show();
                    } catch (Exception e) {
                        FileLog.e(e);
                    }
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    TwoStepVerificationSetupActivity twoStepVerificationSetupActivity2 = new TwoStepVerificationSetupActivity(this.currentAccount, 2, this.currentPassword);
                    twoStepVerificationSetupActivity2.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, this.emailOnly);
                    twoStepVerificationSetupActivity2.firstPassword = this.firstPassword;
                    twoStepVerificationSetupActivity2.fragmentsToClose.addAll(this.fragmentsToClose);
                    twoStepVerificationSetupActivity2.fragmentsToClose.add(this);
                    twoStepVerificationSetupActivity2.closeAfterSet = this.closeAfterSet;
                    presentFragment(twoStepVerificationSetupActivity2);
                    break;
                }
            case 2:
                if (this.passwordEditText.getText().toString().toLowerCase().equals(this.firstPassword.toLowerCase())) {
                    try {
                        Toast.makeText(getParentActivity(), LocaleController.getString("PasswordAsHintError", R.string.PasswordAsHintError), 0).show();
                    } catch (Exception e2) {
                        FileLog.e(e2);
                    }
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    this.hint = this.passwordEditText.getText().toString();
                    onHintDone();
                    break;
                }
            case 3:
                String string = this.passwordEditText.getText().toString();
                this.email = string;
                if (!isValidEmail(string)) {
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    setNewPassword(false);
                    break;
                }
            case 4:
                String string2 = this.passwordEditText.getText().toString();
                if (string2.length() == 0) {
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    TLRPC$TL_auth_recoverPassword tLRPC$TL_auth_recoverPassword = new TLRPC$TL_auth_recoverPassword();
                    tLRPC$TL_auth_recoverPassword.code = string2;
                    ContactsProxy.getInstance(this.currentAccount).disableTwoStepByForgetPassword(tLRPC$TL_auth_recoverPassword, new RequestDelegate() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda21
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$createView$5(tLObject, tLRPC$TL_error);
                        }
                    });
                    break;
                }
            case 5:
                if (this.passwordEditText.length() == 0) {
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    TLRPC$TL_account_confirmPasswordEmail tLRPC$TL_account_confirmPasswordEmail = new TLRPC$TL_account_confirmPasswordEmail();
                    tLRPC$TL_account_confirmPasswordEmail.code = this.passwordEditText.getText().toString();
                    tLRPC$TL_account_confirmPasswordEmail.password = this.currentPassword.has_password ? this.currentPasswordHash : null;
                    ContactsProxy.getInstance(this.currentAccount).confirmPasswordEmail(tLRPC$TL_account_confirmPasswordEmail, new RequestDelegate() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda23
                        @Override // org.rbmain.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$createView$8(tLObject, tLRPC$TL_error);
                        }
                    });
                    needShowProgress();
                    break;
                }
            case 6:
                TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
                if (tLRPC$TL_account_password == null) {
                    needShowProgress();
                    this.doneAfterPasswordLoad = true;
                    break;
                } else {
                    TwoStepVerificationSetupActivity twoStepVerificationSetupActivity3 = new TwoStepVerificationSetupActivity(this.currentAccount, 0, tLRPC$TL_account_password);
                    twoStepVerificationSetupActivity3.closeAfterSet = this.closeAfterSet;
                    presentFragment(twoStepVerificationSetupActivity3, true);
                    break;
                }
            case 7:
                if (this.closeAfterSet) {
                    finishFragment();
                    break;
                } else {
                    TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
                    twoStepVerificationActivity.setCurrentPasswordParams(this.currentPassword, this.currentPasswordHash, this.currentSecretId, this.currentSecret);
                    presentFragment(twoStepVerificationActivity, true);
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$4(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$createView$3(dialogInterface, i);
                }
            });
            builder.setMessage(LocaleController.getString("PasswordReset", R.string.PasswordReset));
            builder.setTitle(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle));
            Dialog dialogShowDialog = showDialog(builder.create());
            if (dialogShowDialog != null) {
                dialogShowDialog.setCanceledOnTouchOutside(false);
                dialogShowDialog.setCancelable(false);
                return;
            }
            return;
        }
        if (tLRPC$TL_error.text.startsWith("CODE_INVALID")) {
            onFieldError(this.passwordEditText, true);
        } else if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            showAlertWithText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle), LocaleController.formatString("FloodWait", R.string.FloodWait, new Object[0]));
        } else {
            showAlertWithText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle), tLRPC$TL_error.text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(DialogInterface dialogInterface, int i) {
        int size = this.fragmentsToClose.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.fragmentsToClose.get(i2).removeSelfFromStack();
        }
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.twoStepPasswordChanged, new Object[0]);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$7(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(TLRPC$TL_error tLRPC$TL_error) {
        needHideProgress();
        if (tLRPC$TL_error == null) {
            if (getParentActivity() == null) {
                return;
            }
            if (this.currentPassword.has_password) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$createView$6(dialogInterface, i);
                    }
                });
                if (this.currentPassword.has_recovery) {
                    builder.setMessage(LocaleController.getString("YourEmailSuccessChangedText", R.string.YourEmailSuccessChangedText));
                } else {
                    builder.setMessage(LocaleController.getString("YourEmailSuccessText", R.string.YourEmailSuccessText));
                }
                builder.setTitle(LocaleController.getString("YourPasswordSuccess", R.string.YourPasswordSuccess));
                Dialog dialogShowDialog = showDialog(builder.create());
                if (dialogShowDialog != null) {
                    dialogShowDialog.setCanceledOnTouchOutside(false);
                    dialogShowDialog.setCancelable(false);
                    return;
                }
                return;
            }
            int size = this.fragmentsToClose.size();
            for (int i = 0; i < size; i++) {
                this.fragmentsToClose.get(i).removeSelfFromStack();
            }
            TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
            tLRPC$TL_account_password.has_password = true;
            tLRPC$TL_account_password.has_recovery = true;
            tLRPC$TL_account_password.email_unconfirmed_pattern = BuildConfig.FLAVOR;
            TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(7, tLRPC$TL_account_password);
            twoStepVerificationSetupActivity.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, this.emailOnly);
            twoStepVerificationSetupActivity.closeAfterSet = this.closeAfterSet;
            presentFragment(twoStepVerificationSetupActivity, true);
            NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
            int i2 = NotificationCenter.twoStepPasswordChanged;
            TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
            notificationCenter.postNotificationName(i2, this.currentPasswordHash, tLRPC$TL_account_password2.new_algo, tLRPC$TL_account_password2.new_secure_algo, tLRPC$TL_account_password2.secure_random, this.email, this.hint, null, this.firstPassword);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
            return;
        }
        if (tLRPC$TL_error.text.startsWith("CODE_INVALID")) {
            onFieldError(this.passwordEditText, true);
        } else if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWait", R.string.FloodWait, new Object[0]));
        } else {
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(DialogInterface dialogInterface, int i) {
        int size = this.fragmentsToClose.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.fragmentsToClose.get(i2).removeSelfFromStack();
        }
        NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
        int i3 = NotificationCenter.twoStepPasswordChanged;
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        notificationCenter.postNotificationName(i3, this.currentPasswordHash, tLRPC$TL_account_password.new_algo, tLRPC$TL_account_password.new_secure_algo, tLRPC$TL_account_password.secure_random, this.email, this.hint, null, this.firstPassword);
        TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
        TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
        tLRPC$TL_account_password2.has_password = true;
        tLRPC$TL_account_password2.has_recovery = true;
        tLRPC$TL_account_password2.email_unconfirmed_pattern = BuildConfig.FLAVOR;
        twoStepVerificationActivity.setCurrentPasswordParams(tLRPC$TL_account_password2, this.currentPasswordHash, this.currentSecretId, this.currentSecret);
        presentFragment(twoStepVerificationActivity, true);
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$11(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 && i != 6) {
            return false;
        }
        this.buttonTextView.callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$12(View view) {
        this.ignoreTextChange = true;
        if (this.passwordEditText.getTransformationMethod() == null) {
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelIcons), PorterDuff.Mode.MULTIPLY));
            if (this.currentType == 0 && this.passwordEditText.length() > 0) {
                this.animationDrawables[3].setCustomEndFrame(-1);
                RLottieDrawable animatedDrawable = this.imageView.getAnimatedDrawable();
                RLottieDrawable[] rLottieDrawableArr = this.animationDrawables;
                if (animatedDrawable != rLottieDrawableArr[3]) {
                    this.imageView.setAnimation(rLottieDrawableArr[3]);
                    this.animationDrawables[3].setCurrentFrame(18, false);
                }
                this.imageView.playAnimation();
            }
        } else {
            this.passwordEditText.setTransformationMethod(null);
            this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelSend), PorterDuff.Mode.MULTIPLY));
            if (this.currentType == 0 && this.passwordEditText.length() > 0) {
                this.animationDrawables[3].setCustomEndFrame(18);
                RLottieDrawable animatedDrawable2 = this.imageView.getAnimatedDrawable();
                RLottieDrawable[] rLottieDrawableArr2 = this.animationDrawables;
                if (animatedDrawable2 != rLottieDrawableArr2[3]) {
                    this.imageView.setAnimation(rLottieDrawableArr2[3]);
                }
                this.animationDrawables[3].setProgress(0.0f, false);
                this.imageView.playAnimation();
            }
        }
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        editTextBoldCursor.setSelection(editTextBoldCursor.length());
        this.ignoreTextChange = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$13(View view) {
        showAlertWithText(LocaleController.getString("RestorePasswordNoEmailTitle", R.string.RestorePasswordNoEmailTitle), LocaleController.getString("RestoreEmailTroubleText", R.string.RestoreEmailTroubleText));
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.paused = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.paused = false;
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor != null && editTextBoldCursor.getVisibility() == 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$14();
                }
            }, 200L);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$14() {
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected boolean hideKeyboardOnShow() {
        return this.currentType == 7;
    }

    private void onHintDone() {
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        if (!tLRPC$TL_account_password.has_recovery) {
            TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(this.currentAccount, 3, tLRPC$TL_account_password);
            twoStepVerificationSetupActivity.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, this.emailOnly);
            twoStepVerificationSetupActivity.firstPassword = this.firstPassword;
            twoStepVerificationSetupActivity.hint = this.hint;
            twoStepVerificationSetupActivity.fragmentsToClose.addAll(this.fragmentsToClose);
            twoStepVerificationSetupActivity.fragmentsToClose.add(this);
            twoStepVerificationSetupActivity.closeAfterSet = this.closeAfterSet;
            presentFragment(twoStepVerificationSetupActivity);
            return;
        }
        this.email = BuildConfig.FLAVOR;
        setNewPassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoneButton(final boolean z) {
        if (z == (this.buttonTextView.getTag() != null)) {
            return;
        }
        AnimatorSet animatorSet = this.buttonAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.buttonTextView.setTag(z ? 1 : null);
        this.buttonAnimation = new AnimatorSet();
        if (z) {
            this.buttonTextView.setVisibility(0);
            this.buttonAnimation.playTogether(ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_X, 0.9f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_Y, 0.9f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
        } else {
            this.descriptionText2.setVisibility(0);
            this.buttonAnimation.playTogether(ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_X, 0.9f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_Y, 0.9f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.ALPHA, 1.0f));
        }
        this.buttonAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TwoStepVerificationSetupActivity.this.buttonAnimation == null || !TwoStepVerificationSetupActivity.this.buttonAnimation.equals(animator)) {
                    return;
                }
                if (z) {
                    TwoStepVerificationSetupActivity.this.descriptionText2.setVisibility(4);
                } else {
                    TwoStepVerificationSetupActivity.this.buttonTextView.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (TwoStepVerificationSetupActivity.this.buttonAnimation == null || !TwoStepVerificationSetupActivity.this.buttonAnimation.equals(animator)) {
                    return;
                }
                TwoStepVerificationSetupActivity.this.buttonAnimation = null;
            }
        });
        this.buttonAnimation.setDuration(150L);
        this.buttonAnimation.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setRandomMonkeyIdleAnimation(boolean r6) {
        /*
            r5 = this;
            int r0 = r5.currentType
            if (r0 == 0) goto L5
            return
        L5:
            java.lang.Runnable r0 = r5.setAnimationRunnable
            if (r0 == 0) goto Lc
            org.rbmain.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
        Lc:
            org.rbmain.ui.Components.RLottieImageView r0 = r5.imageView
            org.rbmain.ui.Components.RLottieDrawable r0 = r0.getAnimatedDrawable()
            r1 = 1
            r2 = 0
            if (r6 != 0) goto L30
            org.rbmain.ui.Components.RLottieDrawable[] r3 = r5.animationDrawables
            r4 = r3[r2]
            if (r0 == r4) goto L30
            r3 = r3[r1]
            if (r0 == r3) goto L30
            org.rbmain.ui.Components.EditTextBoldCursor r3 = r5.passwordEditText
            int r3 = r3.length()
            if (r3 != 0) goto L63
            if (r0 == 0) goto L30
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L63
        L30:
            java.security.SecureRandom r0 = org.rbmain.messenger.Utilities.random
            int r0 = r0.nextInt()
            int r0 = r0 % 2
            r3 = 0
            if (r0 != 0) goto L4c
            org.rbmain.ui.Components.RLottieImageView r0 = r5.imageView
            org.rbmain.ui.Components.RLottieDrawable[] r1 = r5.animationDrawables
            r1 = r1[r2]
            r0.setAnimation(r1)
            org.rbmain.ui.Components.RLottieDrawable[] r0 = r5.animationDrawables
            r0 = r0[r2]
            r0.setProgress(r3)
            goto L5c
        L4c:
            org.rbmain.ui.Components.RLottieImageView r0 = r5.imageView
            org.rbmain.ui.Components.RLottieDrawable[] r2 = r5.animationDrawables
            r2 = r2[r1]
            r0.setAnimation(r2)
            org.rbmain.ui.Components.RLottieDrawable[] r0 = r5.animationDrawables
            r0 = r0[r1]
            r0.setProgress(r3)
        L5c:
            if (r6 != 0) goto L63
            org.rbmain.ui.Components.RLottieImageView r6 = r5.imageView
            r6.playAnimation()
        L63:
            org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda10 r6 = new org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda10
            r6.<init>()
            r5.setAnimationRunnable = r6
            java.security.SecureRandom r0 = org.rbmain.messenger.Utilities.random
            r1 = 2000(0x7d0, float:2.803E-42)
            int r0 = r0.nextInt(r1)
            int r0 = r0 + 5000
            long r0 = (long) r0
            org.rbmain.messenger.AndroidUtilities.runOnUIThread(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.TwoStepVerificationSetupActivity.setRandomMonkeyIdleAnimation(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRandomMonkeyIdleAnimation$15() {
        if (this.setAnimationRunnable == null) {
            return;
        }
        setRandomMonkeyIdleAnimation(false);
    }

    public void setCloseAfterSet(boolean z) {
        this.closeAfterSet = z;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        EditTextBoldCursor editTextBoldCursor;
        if (z && (editTextBoldCursor = this.passwordEditText) != null && editTextBoldCursor.getVisibility() == 0) {
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    private void loadPasswordInfo() {
        ContactsProxy.getInstance(this.currentAccount).getPasswordSettings(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda20
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPasswordInfo$17(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPasswordInfo$17(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPasswordInfo$16(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPasswordInfo$16(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            if (!TwoStepVerificationActivity.canHandleCurrentPassword(tLRPC$TL_account_password, false)) {
                AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
                return;
            }
            this.waitingForEmail = !TextUtils.isEmpty(this.currentPassword.email_unconfirmed_pattern);
            TwoStepVerificationActivity.initPasswordNewAlgo(this.currentPassword);
            if (!this.paused && this.closeAfterSet) {
                TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
                if (tLRPC$TL_account_password2.has_password) {
                    TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = tLRPC$TL_account_password2.current_algo;
                    TLRPC$SecurePasswordKdfAlgo tLRPC$SecurePasswordKdfAlgo = tLRPC$TL_account_password2.new_secure_algo;
                    byte[] bArr = tLRPC$TL_account_password2.secure_random;
                    String str = tLRPC$TL_account_password2.has_recovery ? "1" : null;
                    String str2 = tLRPC$TL_account_password2.hint;
                    if (str2 == null) {
                        str2 = BuildConfig.FLAVOR;
                    }
                    if (!this.waitingForEmail && tLRPC$PasswordKdfAlgo != null) {
                        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.twoStepPasswordChanged, null, tLRPC$PasswordKdfAlgo, tLRPC$SecurePasswordKdfAlgo, bArr, str, str2, null, null);
                        finishFragment();
                    }
                }
            }
            if (this.doneAfterPasswordLoad) {
                needHideProgress();
                this.buttonTextView.callOnClick();
            }
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowProgress() {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCancel(false);
        this.progressDialog.show();
    }

    protected void needHideProgress() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.progressDialog = null;
    }

    private boolean isValidEmail(String str) {
        if (str == null || str.length() < 3) {
            return false;
        }
        int iLastIndexOf = str.lastIndexOf(46);
        int iLastIndexOf2 = str.lastIndexOf(64);
        return iLastIndexOf2 >= 0 && iLastIndexOf >= iLastIndexOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertWithText(String str, String str2) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(str);
        builder.setMessage(str2);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewPassword(final boolean z) {
        TLRPC$TL_account_password tLRPC$TL_account_password;
        if (z && this.waitingForEmail && this.currentPassword.has_password) {
            needShowProgress();
            TLRPC$TL_account_cancelPasswordEmail tLRPC$TL_account_cancelPasswordEmail = new TLRPC$TL_account_cancelPasswordEmail();
            tLRPC$TL_account_cancelPasswordEmail.password = this.currentPasswordHash;
            ContactsProxy.getInstance(this.currentAccount).abortSetRecoveryEmail(tLRPC$TL_account_cancelPasswordEmail, new RequestDelegate() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda22
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$setNewPassword$19(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        final String str = this.firstPassword;
        final TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = new TLRPC$TL_account_updatePasswordSettings();
        byte[] bArr = this.currentPasswordHash;
        if (bArr == null || bArr.length == 0) {
            tLRPC$TL_account_updatePasswordSettings.password = new TLRPC$TL_inputCheckPasswordEmpty();
        }
        TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = new TLRPC$TL_account_passwordInputSettings();
        tLRPC$TL_account_updatePasswordSettings.new_settings = tLRPC$TL_account_passwordInputSettings;
        if (z) {
            UserConfig.getInstance(this.currentAccount).resetSavedPassword();
            this.currentSecret = null;
            if (this.waitingForEmail) {
                TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings2 = tLRPC$TL_account_updatePasswordSettings.new_settings;
                tLRPC$TL_account_passwordInputSettings2.flags = 2;
                tLRPC$TL_account_passwordInputSettings2.email = BuildConfig.FLAVOR;
                tLRPC$TL_account_updatePasswordSettings.password = new TLRPC$TL_inputCheckPasswordEmpty();
            } else {
                TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings3 = tLRPC$TL_account_updatePasswordSettings.new_settings;
                tLRPC$TL_account_passwordInputSettings3.flags = 3;
                tLRPC$TL_account_passwordInputSettings3.hint = BuildConfig.FLAVOR;
                tLRPC$TL_account_passwordInputSettings3.new_password_hash = new byte[0];
                tLRPC$TL_account_passwordInputSettings3.new_algo = new TLRPC$TL_passwordKdfAlgoUnknown();
                tLRPC$TL_account_updatePasswordSettings.new_settings.email = BuildConfig.FLAVOR;
            }
        } else {
            if (this.hint == null && (tLRPC$TL_account_password = this.currentPassword) != null) {
                this.hint = tLRPC$TL_account_password.hint;
            }
            if (this.hint == null) {
                this.hint = BuildConfig.FLAVOR;
            }
            if (str != null) {
                tLRPC$TL_account_passwordInputSettings.flags |= 1;
                tLRPC$TL_account_passwordInputSettings.hint = this.hint;
                tLRPC$TL_account_passwordInputSettings.new_algo = this.currentPassword.new_algo;
            }
            if (this.email.length() > 0) {
                TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings4 = tLRPC$TL_account_updatePasswordSettings.new_settings;
                tLRPC$TL_account_passwordInputSettings4.flags = 2 | tLRPC$TL_account_passwordInputSettings4.flags;
                tLRPC$TL_account_passwordInputSettings4.email = this.email.trim();
            }
        }
        needShowProgress();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNewPassword$25(tLRPC$TL_account_updatePasswordSettings, str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$19(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNewPassword$18(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$18(TLRPC$TL_error tLRPC$TL_error) {
        needHideProgress();
        if (tLRPC$TL_error == null) {
            TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
            TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
            tLRPC$TL_account_password.has_recovery = false;
            tLRPC$TL_account_password.email_unconfirmed_pattern = BuildConfig.FLAVOR;
            twoStepVerificationActivity.setCurrentPasswordParams(tLRPC$TL_account_password, this.currentPasswordHash, this.currentSecretId, this.currentSecret);
            presentFragment(twoStepVerificationActivity, true);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didRemoveTwoStepPassword, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$25(final TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings, final String str, final boolean z) {
        byte[] bArr;
        tLRPC$TL_account_updatePasswordSettings.newPass = str;
        byte[] stringBytes = null;
        tLRPC$TL_account_updatePasswordSettings.oldPass = this.currentPassword.has_password ? this.currentPasswordHash : null;
        tLRPC$TL_account_updatePasswordSettings.abort = z;
        if (tLRPC$TL_account_updatePasswordSettings.password == null) {
            tLRPC$TL_account_updatePasswordSettings.password = getNewSrpPassword();
        }
        if (!z && str != null) {
            stringBytes = AndroidUtilities.getStringBytes(str);
        }
        final byte[] bArr2 = stringBytes;
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda25
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setNewPassword$24(z, bArr2, str, tLRPC$TL_account_updatePasswordSettings, tLObject, tLRPC$TL_error);
            }
        };
        if (!z) {
            if (str != null && (bArr = this.currentSecret) != null && bArr.length == 32) {
                TLRPC$SecurePasswordKdfAlgo tLRPC$SecurePasswordKdfAlgo = this.currentPassword.new_secure_algo;
                if (tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) {
                    TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 = (TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) tLRPC$SecurePasswordKdfAlgo;
                    byte[] bArrComputePBKDF2 = Utilities.computePBKDF2(stringBytes, tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt);
                    byte[] bArr3 = new byte[32];
                    System.arraycopy(bArrComputePBKDF2, 0, bArr3, 0, 32);
                    byte[] bArr4 = new byte[16];
                    System.arraycopy(bArrComputePBKDF2, 32, bArr4, 0, 16);
                    byte[] bArr5 = new byte[32];
                    System.arraycopy(this.currentSecret, 0, bArr5, 0, 32);
                    Utilities.aesCbcEncryptionByteArraySafe(bArr5, bArr3, bArr4, 0, 32, 0, 1);
                    tLRPC$TL_account_updatePasswordSettings.new_settings.new_secure_settings = new TLRPC$TL_secureSecretSettings();
                    TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = tLRPC$TL_account_updatePasswordSettings.new_settings;
                    TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings = tLRPC$TL_account_passwordInputSettings.new_secure_settings;
                    tLRPC$TL_secureSecretSettings.secure_algo = tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000;
                    tLRPC$TL_secureSecretSettings.secure_secret = bArr5;
                    tLRPC$TL_secureSecretSettings.secure_secret_id = this.currentSecretId;
                    tLRPC$TL_account_passwordInputSettings.flags |= 4;
                }
            }
            ContactsProxy.getInstance(this.currentAccount).setTwoStepPassword(tLRPC$TL_account_updatePasswordSettings, requestDelegate);
            return;
        }
        ContactsProxy.getInstance(this.currentAccount).setTwoStepPassword(tLRPC$TL_account_updatePasswordSettings, requestDelegate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$24(final boolean z, final byte[] bArr, final String str, final TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNewPassword$23(tLRPC$TL_error, z, tLObject, bArr, str, tLRPC$TL_account_updatePasswordSettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$23(TLRPC$TL_error tLRPC$TL_error, final boolean z, TLObject tLObject, final byte[] bArr, String str, TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings) {
        String pluralString;
        TLRPC$TL_account_password tLRPC$TL_account_password;
        if (tLRPC$TL_error != null && "SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda24
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$setNewPassword$21(z, tLObject2, tLRPC$TL_error2);
                }
            }, 8);
            return;
        }
        needHideProgress();
        if (tLRPC$TL_error != null || !(tLObject instanceof TLRPC$TL_boolTrue)) {
            if (tLRPC$TL_error != null) {
                if ("EMAIL_UNCONFIRMED".equals(tLRPC$TL_error.text) || tLRPC$TL_error.text.startsWith("EMAIL_UNCONFIRMED_")) {
                    NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.twoStepPasswordChanged, new Object[0]);
                    int size = this.fragmentsToClose.size();
                    for (int i = 0; i < size; i++) {
                        this.fragmentsToClose.get(i).removeSelfFromStack();
                    }
                    NotificationCenter notificationCenter = NotificationCenter.getInstance(this.currentAccount);
                    int i2 = NotificationCenter.twoStepPasswordChanged;
                    TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
                    String str2 = this.email;
                    notificationCenter.postNotificationName(i2, bArr, tLRPC$TL_account_updatePasswordSettings.new_settings.new_algo, tLRPC$TL_account_password2.new_secure_algo, tLRPC$TL_account_password2.secure_random, str2, this.hint, str2, this.firstPassword);
                    TLRPC$TL_account_password tLRPC$TL_account_password3 = this.currentPassword;
                    tLRPC$TL_account_password3.email_unconfirmed_pattern = this.email;
                    TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(5, tLRPC$TL_account_password3);
                    twoStepVerificationSetupActivity.setCurrentPasswordParams(bArr != null ? bArr : this.currentPasswordHash, this.currentSecretId, this.currentSecret, this.emailOnly);
                    twoStepVerificationSetupActivity.closeAfterSet = this.closeAfterSet;
                    presentFragment(twoStepVerificationSetupActivity, true);
                    return;
                }
                if ("EMAIL_INVALID".equals(tLRPC$TL_error.text)) {
                    showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("PasswordEmailInvalid", R.string.PasswordEmailInvalid));
                    return;
                }
                if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                    int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
                    if (iIntValue < 60) {
                        pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                    } else {
                        pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                    }
                    showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                    return;
                }
                showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                return;
            }
            return;
        }
        if (z) {
            int size2 = this.fragmentsToClose.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.fragmentsToClose.get(i3).removeSelfFromStack();
            }
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didRemoveTwoStepPassword, new Object[0]);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, new Object[0]);
            finishFragment();
            return;
        }
        if (getParentActivity() == null) {
            return;
        }
        if (this.currentPassword.has_password) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$setNewPassword$22(bArr, dialogInterface, i4);
                }
            });
            if (str == null && (tLRPC$TL_account_password = this.currentPassword) != null && tLRPC$TL_account_password.has_password) {
                builder.setMessage(LocaleController.getString("YourEmailSuccessText", R.string.YourEmailSuccessText));
            } else {
                builder.setMessage(LocaleController.getString("YourPasswordChangedSuccessText", R.string.YourPasswordChangedSuccessText));
            }
            builder.setTitle(LocaleController.getString("YourPasswordSuccess", R.string.YourPasswordSuccess));
            Dialog dialogShowDialog = showDialog(builder.create());
            if (dialogShowDialog != null) {
                dialogShowDialog.setCanceledOnTouchOutside(false);
                dialogShowDialog.setCancelable(false);
                return;
            }
            return;
        }
        int size3 = this.fragmentsToClose.size();
        for (int i4 = 0; i4 < size3; i4++) {
            this.fragmentsToClose.get(i4).removeSelfFromStack();
        }
        TLRPC$TL_account_password tLRPC$TL_account_password4 = this.currentPassword;
        tLRPC$TL_account_password4.has_password = true;
        if (!tLRPC$TL_account_password4.has_recovery) {
            tLRPC$TL_account_password4.has_recovery = !TextUtils.isEmpty(tLRPC$TL_account_password4.email_unconfirmed_pattern);
        }
        if (this.closeAfterSet) {
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.twoStepPasswordChanged, new Object[0]);
        }
        TwoStepVerificationSetupActivity twoStepVerificationSetupActivity2 = new TwoStepVerificationSetupActivity(7, this.currentPassword);
        twoStepVerificationSetupActivity2.setCurrentPasswordParams(bArr != null ? bArr : this.currentPasswordHash, this.currentSecretId, this.currentSecret, this.emailOnly);
        twoStepVerificationSetupActivity2.closeAfterSet = this.closeAfterSet;
        presentFragment(twoStepVerificationSetupActivity2, true);
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$21(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.TwoStepVerificationSetupActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNewPassword$20(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$20(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            setNewPassword(z);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setNewPassword$22(byte[] bArr, DialogInterface dialogInterface, int i) {
        int size = this.fragmentsToClose.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.fragmentsToClose.get(i2).removeSelfFromStack();
        }
        TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        tLRPC$TL_account_password.has_password = true;
        if (!tLRPC$TL_account_password.has_recovery) {
            tLRPC$TL_account_password.has_recovery = !TextUtils.isEmpty(tLRPC$TL_account_password.email_unconfirmed_pattern);
        }
        TLRPC$TL_account_password tLRPC$TL_account_password2 = this.currentPassword;
        if (bArr == null) {
            bArr = this.currentPasswordHash;
        }
        twoStepVerificationActivity.setCurrentPasswordParams(tLRPC$TL_account_password2, bArr, this.currentSecretId, this.currentSecret);
        presentFragment(twoStepVerificationActivity, true);
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
    }

    protected TLRPC$TL_inputCheckPasswordSRP getNewSrpPassword() {
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = tLRPC$TL_account_password.current_algo;
        if (!(tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow)) {
            return null;
        }
        return SRPHelper.startCheck(this.currentPasswordHash, tLRPC$TL_account_password.srp_id, tLRPC$TL_account_password.srp_B, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo);
    }

    private void onFieldError(TextView textView, boolean z) {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        if (z) {
            textView.setText(BuildConfig.FLAVOR);
        }
        AndroidUtilities.shakeView(textView, 2.0f, 0);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText6));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteHintText));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputField));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
        return arrayList;
    }
}
