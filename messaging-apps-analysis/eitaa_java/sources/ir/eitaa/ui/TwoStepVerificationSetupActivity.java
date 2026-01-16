package ir.eitaa.ui;

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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SRPHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$SecurePasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$TL_account_confirmPasswordEmail;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_getPasswordSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordInputSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_resendPasswordEmail;
import ir.eitaa.tgnet.TLRPC$TL_account_updatePasswordSettings;
import ir.eitaa.tgnet.TLRPC$TL_auth_checkRecoveryPassword;
import ir.eitaa.tgnet.TLRPC$TL_auth_recoverPassword;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordSRP;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoUnknown;
import ir.eitaa.tgnet.TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000;
import ir.eitaa.tgnet.TLRPC$TL_secureSecretSettings;
import ir.eitaa.tgnet.TLRPC$auth_Authorization;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.TwoStepVerificationSetupActivity;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
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
    private String emailCode;
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

    static /* synthetic */ boolean lambda$createView$19(View view, MotionEvent motionEvent) {
        return true;
    }

    protected void onReset() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$TwoStepVerificationSetupActivity() throws InterruptedException {
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

    public TwoStepVerificationSetupActivity(int type, TLRPC$TL_account_password password) {
        this.fragmentsToClose = new ArrayList<>();
        this.emailCodeLength = 6;
        this.currentPasswordHash = new byte[0];
        this.finishCallback = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$dxLoX0otc2Pz7_xnTN3PchWZs4k
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$new$0$TwoStepVerificationSetupActivity();
            }
        };
        this.currentType = type;
        this.currentPassword = password;
        if (password == null && (type == 6 || type == 8)) {
            loadPasswordInfo();
        } else {
            this.waitingForEmail = !TextUtils.isEmpty(password.email_unconfirmed_pattern);
        }
    }

    public TwoStepVerificationSetupActivity(int account, int type, TLRPC$TL_account_password password) {
        this.fragmentsToClose = new ArrayList<>();
        this.emailCodeLength = 6;
        this.currentPasswordHash = new byte[0];
        this.finishCallback = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$dxLoX0otc2Pz7_xnTN3PchWZs4k
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$new$0$TwoStepVerificationSetupActivity();
            }
        };
        this.currentAccount = account;
        this.currentType = type;
        this.currentPassword = password;
        this.waitingForEmail = !TextUtils.isEmpty(password.email_unconfirmed_pattern);
        if (this.currentPassword == null) {
            int i = this.currentType;
            if (i == 6 || i == 8) {
                loadPasswordInfo();
            }
        }
    }

    public void setCurrentPasswordParams(byte[] passwordHash, long secretId, byte[] secret, boolean email) {
        this.currentPasswordHash = passwordHash;
        this.currentSecret = secret;
        this.currentSecretId = secretId;
        this.emailOnly = email;
    }

    public void setCurrentEmailCode(String code) {
        this.emailCode = code;
    }

    public void addFragmentToClose(BaseFragment fragment) {
        this.fragmentsToClose.add(fragment);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        int i = 0;
        this.doneAfterPasswordLoad = false;
        Runnable runnable = this.setAnimationRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.setAnimationRunnable = null;
        }
        if (this.animationDrawables != null) {
            while (true) {
                RLottieDrawable[] rLottieDrawableArr = this.animationDrawables;
                if (i >= rLottieDrawableArr.length) {
                    break;
                }
                rLottieDrawableArr[i].recycle();
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackgroundDrawable(null);
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        this.actionBar.setTitleColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.actionBar.setItemsColor(Theme.getColor("windowBackgroundWhiteGrayText2"), false);
        this.actionBar.setItemsBackgroundColor(Theme.getColor("actionBarWhiteSelector"), false);
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
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText2"));
        this.topButton.setTextSize(1, 14.0f);
        this.topButton.setGravity(16);
        this.topButton.setTypeface(AndroidUtilities.getFontFamily(false));
        this.topButton.setVisibility(8);
        this.actionBar.addView(this.topButton, LayoutHelper.createFrame(-2, -1.0f, 53, 0.0f, 0.0f, 22.0f, 0.0f));
        this.topButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$8KqH1R-9uD8FvbHONSNnR41SzPA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$5$TwoStepVerificationSetupActivity(view);
            }
        });
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        this.imageView = rLottieImageView;
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        TextView textView2 = new TextView(context);
        this.titleTextView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.titleTextView.setGravity(1);
        this.titleTextView.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        this.titleTextView.setTextSize(1, 24.0f);
        this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(false));
        TextView textView3 = new TextView(context);
        this.descriptionText = textView3;
        textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.descriptionText.setGravity(1);
        this.descriptionText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText.setTextSize(1, 15.0f);
        this.descriptionText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.descriptionText.setVisibility(8);
        this.descriptionText.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        TextView textView4 = new TextView(context);
        this.descriptionText2 = textView4;
        textView4.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
        this.descriptionText2.setGravity(1);
        this.descriptionText2.setTextSize(1, 14.0f);
        this.descriptionText2.setTypeface(AndroidUtilities.getFontFamily(false));
        this.descriptionText2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        this.descriptionText2.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
        this.descriptionText2.setVisibility(8);
        this.descriptionText2.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$Dx-98xJ9_6REQb_0AMcWNDjG6iY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$6$TwoStepVerificationSetupActivity(view);
            }
        });
        TextView textView5 = new TextView(context);
        this.buttonTextView = textView5;
        textView5.setMinWidth(AndroidUtilities.dp(220.0f));
        this.buttonTextView.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        this.buttonTextView.setGravity(17);
        this.buttonTextView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        this.buttonTextView.setTextSize(1, 14.0f);
        this.buttonTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        this.buttonTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$0GPIQy_15VkpETfvQvDWWuryis4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$18$TwoStepVerificationSetupActivity(view);
            }
        });
        switch (this.currentType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
                ViewGroup viewGroup = new ViewGroup(context) { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.3
                    @Override // android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        int size = View.MeasureSpec.getSize(widthMeasureSpec);
                        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                        if (TwoStepVerificationSetupActivity.this.topButton != null) {
                            ((FrameLayout.LayoutParams) TwoStepVerificationSetupActivity.this.topButton.getLayoutParams()).topMargin = AndroidUtilities.statusBarHeight;
                        }
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), heightMeasureSpec);
                        TwoStepVerificationSetupActivity.this.actionBarBackground.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredHeight() + AndroidUtilities.dp(3.0f), 1073741824));
                        TwoStepVerificationSetupActivity.this.scrollView.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), heightMeasureSpec);
                        setMeasuredDimension(size, size2);
                    }

                    @Override // android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean changed, int l, int t, int r, int b) {
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.layout(0, 0, ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredWidth(), ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredHeight());
                        TwoStepVerificationSetupActivity.this.actionBarBackground.layout(0, 0, TwoStepVerificationSetupActivity.this.actionBarBackground.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.actionBarBackground.getMeasuredHeight());
                        TwoStepVerificationSetupActivity.this.scrollView.layout(0, 0, TwoStepVerificationSetupActivity.this.scrollView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.scrollView.getMeasuredHeight());
                    }
                };
                ScrollView scrollView = new ScrollView(context) { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.4
                    private int scrollingUp;
                    private int[] location = new int[2];
                    private Rect tempRect = new Rect();
                    private boolean isLayoutDirty = true;

                    @Override // android.view.View
                    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
                        super.onScrollChanged(l, t, oldl, oldt);
                        if (TwoStepVerificationSetupActivity.this.titleTextView == null) {
                            return;
                        }
                        TwoStepVerificationSetupActivity.this.titleTextView.getLocationOnScreen(this.location);
                        boolean z = this.location[1] + TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() < ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getBottom();
                        if (z != (TwoStepVerificationSetupActivity.this.titleTextView.getTag() == null)) {
                            TwoStepVerificationSetupActivity.this.titleTextView.setTag(z ? null : 1);
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
                            fArr[0] = z ? 1.0f : 0.0f;
                            animatorArr[0] = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fArr);
                            SimpleTextView titleTextView = ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getTitleTextView();
                            Property property2 = View.ALPHA;
                            float[] fArr2 = new float[1];
                            fArr2[0] = z ? 1.0f : 0.0f;
                            animatorArr[1] = ObjectAnimator.ofFloat(titleTextView, (Property<SimpleTextView, Float>) property2, fArr2);
                            animatorSet.playTogether(animatorArr);
                            TwoStepVerificationSetupActivity.this.actionBarAnimator.setDuration(150L);
                            TwoStepVerificationSetupActivity.this.actionBarAnimator.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.4.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animation) {
                                    if (animation.equals(TwoStepVerificationSetupActivity.this.actionBarAnimator)) {
                                        TwoStepVerificationSetupActivity.this.actionBarAnimator = null;
                                    }
                                }
                            });
                            TwoStepVerificationSetupActivity.this.actionBarAnimator.start();
                        }
                    }

                    @Override // android.widget.ScrollView
                    public void scrollToDescendant(View child) {
                        child.getDrawingRect(this.tempRect);
                        offsetDescendantRectToMyCoords(child, this.tempRect);
                        this.tempRect.bottom += AndroidUtilities.dp(120.0f);
                        int iComputeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.tempRect);
                        if (iComputeScrollDeltaToGetChildRectOnScreen < 0) {
                            int measuredHeight = (getMeasuredHeight() - child.getMeasuredHeight()) / 2;
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
                    public void requestChildFocus(View child, View focused) {
                        if (Build.VERSION.SDK_INT < 29 && focused != null && !this.isLayoutDirty) {
                            scrollToDescendant(focused);
                        }
                        super.requestChildFocus(child, focused);
                    }

                    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
                    public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                        if (Build.VERSION.SDK_INT < 23) {
                            int iDp = rectangle.bottom + AndroidUtilities.dp(120.0f);
                            rectangle.bottom = iDp;
                            int i = this.scrollingUp;
                            if (i != 0) {
                                rectangle.top -= i;
                                rectangle.bottom = iDp - i;
                                this.scrollingUp = 0;
                            }
                        }
                        return super.requestChildRectangleOnScreen(child, rectangle, immediate);
                    }

                    @Override // android.widget.ScrollView, android.view.View, android.view.ViewParent
                    public void requestLayout() {
                        this.isLayoutDirty = true;
                        super.requestLayout();
                    }

                    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
                    protected void onLayout(boolean changed, int l, int t, int r, int b) {
                        this.isLayoutDirty = false;
                        super.onLayout(changed, l, t, r, b);
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
                this.passwordEditText.setTypeface(AndroidUtilities.getFontFamily(false));
                this.passwordEditText.setPadding(0, AndroidUtilities.dp(2.0f), 0, 0);
                this.passwordEditText.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
                this.passwordEditText.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.passwordEditText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.passwordEditText.setHintColor(Theme.getColor("windowBackgroundWhiteHintText"));
                this.passwordEditText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
                this.passwordEditText.setMaxLines(1);
                this.passwordEditText.setLines(1);
                this.passwordEditText.setGravity(3);
                this.passwordEditText.setCursorSize(AndroidUtilities.dp(20.0f));
                this.passwordEditText.setSingleLine(true);
                this.passwordEditText.setCursorWidth(1.5f);
                frameLayout.addView(this.passwordEditText, LayoutHelper.createFrame(220, 36, 49));
                this.passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$fHsZqXDZtWxKM7rQZ_U5YhvpGys
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView6, int i, KeyEvent keyEvent) {
                        return this.f$0.lambda$createView$20$TwoStepVerificationSetupActivity(textView6, i, keyEvent);
                    }
                });
                this.passwordEditText.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.5
                    @Override // android.view.ActionMode.Callback
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override // android.view.ActionMode.Callback
                    public void onDestroyActionMode(ActionMode mode) {
                    }

                    @Override // android.view.ActionMode.Callback
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }
                });
                ImageView imageView = new ImageView(context) { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.6
                    @Override // android.view.View
                    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
                        super.onInitializeAccessibilityNodeInfo(info);
                        info.setCheckable(true);
                        info.setChecked(TwoStepVerificationSetupActivity.this.passwordEditText.getTransformationMethod() == null);
                    }
                };
                this.showPasswordButton = imageView;
                imageView.setImageResource(R.drawable.msg_message);
                this.showPasswordButton.setScaleType(ImageView.ScaleType.CENTER);
                this.showPasswordButton.setContentDescription(LocaleController.getString("TwoStepVerificationShowPassword", R.string.TwoStepVerificationShowPassword));
                if (Build.VERSION.SDK_INT >= 21) {
                    this.showPasswordButton.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21")));
                }
                this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
                this.showPasswordButton.setVisibility(8);
                frameLayout.addView(this.showPasswordButton, LayoutHelper.createFrame(36, 36.0f, 53, 0.0f, -5.0f, 0.0f, 0.0f));
                this.showPasswordButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$7S2Bq6uhHV6gR_ILSof8Sv5RC1g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws InterruptedException {
                        this.f$0.lambda$createView$21$TwoStepVerificationSetupActivity(view);
                    }
                });
                FrameLayout frameLayout2 = new FrameLayout(context);
                linearLayout.addView(frameLayout2, LayoutHelper.createLinear(-1, -2, 51, 0, 36, 0, 22));
                frameLayout2.addView(this.buttonTextView, LayoutHelper.createFrame(-2, 42, 49));
                frameLayout2.addView(this.descriptionText2, LayoutHelper.createFrame(-2, -2, 49));
                if (this.currentType == 4) {
                    TextView textView6 = new TextView(context);
                    this.descriptionText3 = textView6;
                    textView6.setTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
                    this.descriptionText3.setGravity(1);
                    this.descriptionText3.setTextSize(1, 14.0f);
                    this.descriptionText3.setTypeface(AndroidUtilities.getFontFamily(false));
                    this.descriptionText3.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
                    this.descriptionText3.setPadding(AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(32.0f), 0);
                    this.descriptionText3.setText(LocaleController.getString("RestoreEmailTroubleNoEmail", R.string.RestoreEmailTroubleNoEmail));
                    linearLayout.addView(this.descriptionText3, LayoutHelper.createLinear(-2, -2, 49, 0, 0, 0, 25));
                    this.descriptionText3.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$cKM5_PBgmcoC7n1rUmy-qoWb-zM
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$createView$23$TwoStepVerificationSetupActivity(view);
                        }
                    });
                }
                this.fragmentView = viewGroup;
                View view = new View(context) { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.7
                    private Paint paint = new Paint();

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        this.paint.setColor(Theme.getColor("windowBackgroundWhite"));
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
            case 9:
                ViewGroup viewGroup2 = new ViewGroup(context) { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.2
                    @Override // android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        int size = View.MeasureSpec.getSize(widthMeasureSpec);
                        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), heightMeasureSpec);
                        if (size > size2) {
                            float f = size;
                            TwoStepVerificationSetupActivity.this.imageView.measure(View.MeasureSpec.makeMeasureSpec((int) (0.45f * f), 1073741824), View.MeasureSpec.makeMeasureSpec((int) (size2 * 0.68f), 1073741824));
                            int i = (int) (f * 0.6f);
                            TwoStepVerificationSetupActivity.this.titleTextView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.descriptionText.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.descriptionText2.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 0));
                            TwoStepVerificationSetupActivity.this.buttonTextView.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(42.0f), 1073741824));
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
                    protected void onLayout(boolean changed, int l, int t, int r, int b) {
                        ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.layout(0, 0, r, ((BaseFragment) TwoStepVerificationSetupActivity.this).actionBar.getMeasuredHeight());
                        int i = r - l;
                        int i2 = b - t;
                        if (r > b) {
                            int measuredHeight = (i2 - TwoStepVerificationSetupActivity.this.imageView.getMeasuredHeight()) / 2;
                            TwoStepVerificationSetupActivity.this.imageView.layout(0, measuredHeight, TwoStepVerificationSetupActivity.this.imageView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.imageView.getMeasuredHeight() + measuredHeight);
                            float f = i;
                            float f2 = 0.4f * f;
                            int i3 = (int) f2;
                            float f3 = i2;
                            int i4 = (int) (0.22f * f3);
                            TwoStepVerificationSetupActivity.this.titleTextView.layout(i3, i4, TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredWidth() + i3, TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() + i4);
                            int i5 = (int) (0.39f * f3);
                            TwoStepVerificationSetupActivity.this.descriptionText.layout(i3, i5, TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredWidth() + i3, TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredHeight() + i5);
                            int measuredWidth = (int) (f2 + (((f * 0.6f) - TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth()) / 2.0f));
                            int i6 = (int) (f3 * 0.64f);
                            TwoStepVerificationSetupActivity.this.buttonTextView.layout(measuredWidth, i6, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredHeight() + i6);
                            return;
                        }
                        float f4 = i2;
                        int i7 = (int) (0.148f * f4);
                        TwoStepVerificationSetupActivity.this.imageView.layout(0, i7, TwoStepVerificationSetupActivity.this.imageView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.imageView.getMeasuredHeight() + i7);
                        int i8 = (int) (0.458f * f4);
                        TwoStepVerificationSetupActivity.this.titleTextView.layout(0, i8, TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() + i8);
                        int measuredHeight2 = i8 + TwoStepVerificationSetupActivity.this.titleTextView.getMeasuredHeight() + AndroidUtilities.dp(12.0f);
                        TwoStepVerificationSetupActivity.this.descriptionText.layout(0, measuredHeight2, TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredWidth(), TwoStepVerificationSetupActivity.this.descriptionText.getMeasuredHeight() + measuredHeight2);
                        int measuredWidth2 = (i - TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth()) / 2;
                        int i9 = (int) (f4 * 0.791f);
                        TwoStepVerificationSetupActivity.this.buttonTextView.layout(measuredWidth2, i9, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredWidth() + measuredWidth2, TwoStepVerificationSetupActivity.this.buttonTextView.getMeasuredHeight() + i9);
                    }
                };
                viewGroup2.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$8ix4ygVgcV32hJwQdnv6SHS5bCw
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        return TwoStepVerificationSetupActivity.lambda$createView$19(view2, motionEvent);
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
        this.fragmentView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        switch (this.currentType) {
            case 0:
                if (this.currentPassword.has_password) {
                    this.actionBar.setTitle(LocaleController.getString("PleaseEnterNewFirstPassword", R.string.PleaseEnterNewFirstPassword));
                    this.titleTextView.setText(LocaleController.getString("PleaseEnterNewFirstPassword", R.string.PleaseEnterNewFirstPassword));
                } else {
                    this.actionBar.setTitle(LocaleController.getString("PleaseEnterFirstPassword", R.string.PleaseEnterFirstPassword));
                    this.titleTextView.setText(LocaleController.getString("PleaseEnterFirstPassword", R.string.PleaseEnterFirstPassword));
                }
                if (!TextUtils.isEmpty(this.emailCode)) {
                    this.topButton.setVisibility(0);
                    this.topButton.setText(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip));
                }
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                this.buttonTextView.setText(LocaleController.getString("Continue", R.string.Continue));
                this.passwordEditText.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
                this.passwordEditText.setImeOptions(268435461);
                this.passwordEditText.setInputType(129);
                this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordEditText.setTypeface(AndroidUtilities.getFontFamily(false));
                this.showPasswordButton.setVisibility(0);
                this.passwordEditText.setPadding(0, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(36.0f), 0);
                RLottieDrawable[] rLottieDrawableArr = new RLottieDrawable[6];
                this.animationDrawables = rLottieDrawableArr;
                rLottieDrawableArr[0] = new RLottieDrawable(R.raw.tsv_setup_monkey_idle1, "2131624047", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, (int[]) null);
                this.animationDrawables[1] = new RLottieDrawable(R.raw.tsv_setup_monkey_idle2, "2131624048", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, (int[]) null);
                this.animationDrawables[2] = new RLottieDrawable(R.raw.tsv_monkey_close, "2131624040", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, (int[]) null);
                this.animationDrawables[3] = new RLottieDrawable(R.raw.tsv_setup_monkey_peek, "2131624049", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, (int[]) null);
                this.animationDrawables[4] = new RLottieDrawable(R.raw.tsv_setup_monkey_close_and_peek_to_idle, "2131624046", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, (int[]) null);
                this.animationDrawables[5] = new RLottieDrawable(R.raw.tsv_setup_monkey_close_and_peek, "2131624045", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, (int[]) null);
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
                this.passwordEditText.setTypeface(AndroidUtilities.getFontFamily(false));
                this.showPasswordButton.setVisibility(0);
                this.passwordEditText.setPadding(0, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(36.0f), 0);
                this.animationDrawables = new RLottieDrawable[]{new RLottieDrawable(R.raw.tsv_setup_monkey_tracking, "2131624050", AndroidUtilities.dp(120.0f), AndroidUtilities.dp(120.0f), true, (int[]) null)};
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
                this.imageView.setAnimation(R.raw.tsv_setup_hint, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
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
                this.imageView.setAnimation(R.raw.tsv_setup_email_sent, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
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
                TextView textView7 = this.descriptionText2;
                Object[] objArr = new Object[1];
                String str = this.currentPassword.email_unconfirmed_pattern;
                if (str == null) {
                    str = "";
                }
                objArr[0] = str;
                textView7.setText(LocaleController.formatString("RestoreEmailSent", R.string.RestoreEmailSent, objArr));
                this.descriptionText2.setVisibility(0);
                this.buttonTextView.setVisibility(4);
                this.buttonTextView.setAlpha(0.0f);
                this.buttonTextView.setScaleX(0.9f);
                this.buttonTextView.setScaleY(0.9f);
                this.imageView.setAnimation(R.raw.tsv_setup_mail, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
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
                TextView textView8 = this.descriptionText2;
                Object[] objArr2 = new Object[1];
                String str2 = this.currentPassword.email_unconfirmed_pattern;
                if (str2 == null) {
                    str2 = "";
                }
                objArr2[0] = str2;
                textView8.setText(LocaleController.formatString("EmailPasswordConfirmText2", R.string.EmailPasswordConfirmText2, objArr2));
                this.descriptionText2.setVisibility(0);
                this.buttonTextView.setVisibility(4);
                this.buttonTextView.setAlpha(0.0f);
                this.buttonTextView.setScaleX(0.9f);
                this.buttonTextView.setScaleY(0.9f);
                this.imageView.setAnimation(R.raw.tsv_setup_mail, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
                this.imageView.playAnimation();
                break;
            case 6:
                this.titleTextView.setText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle));
                this.descriptionText.setText(LocaleController.getString("SetAdditionalPasswordInfo", R.string.SetAdditionalPasswordInfo));
                this.buttonTextView.setText(LocaleController.getString("TwoStepVerificationSetPassword", R.string.TwoStepVerificationSetPassword));
                this.descriptionText.setVisibility(0);
                this.imageView.setAnimation(R.raw.tsv_setup_intro, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
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
                this.imageView.setAnimation(R.raw.wallet_allset, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
                this.imageView.playAnimation();
                break;
            case 8:
                this.actionBar.setTitle(LocaleController.getString("PleaseEnterCurrentPassword", R.string.PleaseEnterCurrentPassword));
                this.titleTextView.setText(LocaleController.getString("PleaseEnterCurrentPassword", R.string.PleaseEnterCurrentPassword));
                this.descriptionText.setText(LocaleController.getString("CheckPasswordInfo", R.string.CheckPasswordInfo));
                this.descriptionText.setVisibility(0);
                this.actionBar.getTitleTextView().setAlpha(0.0f);
                this.buttonTextView.setText(LocaleController.getString("CheckPassword", R.string.CheckPassword));
                this.descriptionText2.setText(LocaleController.getString("ForgotPassword", R.string.ForgotPassword));
                this.descriptionText2.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText2"));
                this.passwordEditText.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
                this.passwordEditText.setImeOptions(268435462);
                this.passwordEditText.setInputType(129);
                this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordEditText.setTypeface(Typeface.DEFAULT);
                this.passwordEditText.setPadding(0, AndroidUtilities.dp(2.0f), AndroidUtilities.dp(36.0f), 0);
                this.imageView.setAnimation(R.raw.wallet_science, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
                this.imageView.playAnimation();
                break;
            case 9:
                this.titleTextView.setText(LocaleController.getString("CheckPasswordPerfect", R.string.CheckPasswordPerfect));
                this.descriptionText.setText(LocaleController.getString("CheckPasswordPerfectInfo", R.string.CheckPasswordPerfectInfo));
                this.buttonTextView.setText(LocaleController.getString("CheckPasswordBackToSettings", R.string.CheckPasswordBackToSettings));
                this.descriptionText.setVisibility(0);
                this.imageView.setAnimation(R.raw.wallet_perfect, R.styleable.AppCompatTheme_windowNoTitle, R.styleable.AppCompatTheme_windowNoTitle);
                this.imageView.playAnimation();
                break;
        }
        EditTextBoldCursor editTextBoldCursor2 = this.passwordEditText;
        if (editTextBoldCursor2 != null) {
            editTextBoldCursor2.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.8
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) throws InterruptedException {
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
                        if (TwoStepVerificationSetupActivity.this.emailCodeLength != 0 && s.length() == TwoStepVerificationSetupActivity.this.emailCodeLength) {
                            TwoStepVerificationSetupActivity.this.buttonTextView.callOnClick();
                        }
                        TwoStepVerificationSetupActivity.this.showDoneButton(s.length() > 0);
                        return;
                    }
                    if (TwoStepVerificationSetupActivity.this.currentType != 8 || s.length() <= 0) {
                        return;
                    }
                    TwoStepVerificationSetupActivity.this.showDoneButton(true);
                }
            });
        }
        return this.fragmentView;
    }

    /* renamed from: ir.eitaa.ui.TwoStepVerificationSetupActivity$1, reason: invalid class name */
    class AnonymousClass1 extends ActionBar.ActionBarMenuOnItemClick {
        static /* synthetic */ void lambda$onItemClick$0(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        AnonymousClass1() {
        }

        @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
        public void onItemClick(int id) {
            String string;
            if (id == -1) {
                TwoStepVerificationSetupActivity.this.finishFragment();
                return;
            }
            if (id == 2) {
                ConnectionsManager.getInstance(((BaseFragment) TwoStepVerificationSetupActivity.this).currentAccount).sendRequest(new TLRPC$TL_account_resendPasswordEmail(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$1$YSEcmeKM2WyGpmiL1ooEJS-iFC4
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        TwoStepVerificationSetupActivity.AnonymousClass1.lambda$onItemClick$0(tLObject, tLRPC$TL_error);
                    }
                });
                AlertDialog.Builder builder = new AlertDialog.Builder(TwoStepVerificationSetupActivity.this.getParentActivity());
                builder.setMessage(LocaleController.getString("ResendCodeInfo", R.string.ResendCodeInfo));
                builder.setTitle(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                TwoStepVerificationSetupActivity.this.showDialog(builder.create());
                return;
            }
            if (id == 1) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(TwoStepVerificationSetupActivity.this.getParentActivity());
                if (TwoStepVerificationSetupActivity.this.currentPassword != null && TwoStepVerificationSetupActivity.this.currentPassword.has_password) {
                    string = LocaleController.getString("CancelEmailQuestion", R.string.CancelEmailQuestion);
                } else {
                    string = LocaleController.getString("CancelPasswordQuestion", R.string.CancelPasswordQuestion);
                }
                String string2 = LocaleController.getString("CancelEmailQuestionTitle", R.string.CancelEmailQuestionTitle);
                String string3 = LocaleController.getString("Abort", R.string.Abort);
                builder2.setMessage(string);
                builder2.setTitle(string2);
                builder2.setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$1$danRFY2r5F06y2A0PvRy7ANuvb0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onItemClick$1$TwoStepVerificationSetupActivity$1(dialogInterface, i);
                    }
                });
                builder2.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                AlertDialog alertDialogCreate = builder2.create();
                TwoStepVerificationSetupActivity.this.showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onItemClick$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onItemClick$1$TwoStepVerificationSetupActivity$1(DialogInterface dialogInterface, int i) {
            TwoStepVerificationSetupActivity.this.setNewPassword(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$TwoStepVerificationSetupActivity(View view) {
        int i = this.currentType;
        if (i == 0) {
            needShowProgress();
            TLRPC$TL_auth_recoverPassword tLRPC$TL_auth_recoverPassword = new TLRPC$TL_auth_recoverPassword();
            tLRPC$TL_auth_recoverPassword.code = this.emailCode;
            getConnectionsManager().sendRequest(tLRPC$TL_auth_recoverPassword, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$TDOqTUSPlNbosHETBqqX2pXU_g0
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$createView$3$TwoStepVerificationSetupActivity(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
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
        builder.setPositiveButton(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$YGAqezT78aSEAAI5liPO-snJmYM
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$createView$4$TwoStepVerificationSetupActivity(dialogInterface, i2);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor("dialogTextRed2"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$TwoStepVerificationSetupActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$g53oTO1Jy2FasSKrZySQIAvhSOY
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$2$TwoStepVerificationSetupActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error) {
        String pluralString;
        needHideProgress();
        if (tLRPC$TL_error == null) {
            getMessagesController().removeSuggestion(0L, "VALIDATE_PASSWORD");
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$p46oMoNbzGDs8uFAPGabEanlERw
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$createView$1$TwoStepVerificationSetupActivity(dialogInterface, i);
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
        if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            showAlertWithText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
            return;
        }
        showAlertWithText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle), tLRPC$TL_error.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$TwoStepVerificationSetupActivity(DialogInterface dialogInterface, int i) {
        int size = this.fragmentsToClose.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.fragmentsToClose.get(i2).removeSelfFromStack();
        }
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.twoStepPasswordChanged, new Object[0]);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$TwoStepVerificationSetupActivity(DialogInterface dialogInterface, int i) {
        this.email = "";
        setNewPassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$TwoStepVerificationSetupActivity(View view) {
        if (this.currentType == 8) {
            TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
            twoStepVerificationActivity.setForgotPasswordOnShow();
            twoStepVerificationActivity.setPassword(this.currentPassword);
            presentFragment(twoStepVerificationActivity, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$18$TwoStepVerificationSetupActivity(View view) {
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
                    twoStepVerificationSetupActivity.setCurrentEmailCode(this.emailCode);
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
                    twoStepVerificationSetupActivity2.setCurrentEmailCode(this.emailCode);
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
                final String string2 = this.passwordEditText.getText().toString();
                if (string2.length() == 0) {
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    TLRPC$TL_auth_checkRecoveryPassword tLRPC$TL_auth_checkRecoveryPassword = new TLRPC$TL_auth_checkRecoveryPassword();
                    tLRPC$TL_auth_checkRecoveryPassword.code = string2;
                    ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_auth_checkRecoveryPassword, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$8wHr2FI3vnYwaLCyhiGiLMe3Vb4
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$createView$14$TwoStepVerificationSetupActivity(string2, tLObject, tLRPC$TL_error);
                        }
                    }, 10);
                    break;
                }
            case 5:
                if (this.passwordEditText.length() == 0) {
                    onFieldError(this.passwordEditText, false);
                    break;
                } else {
                    TLRPC$TL_account_confirmPasswordEmail tLRPC$TL_account_confirmPasswordEmail = new TLRPC$TL_account_confirmPasswordEmail();
                    tLRPC$TL_account_confirmPasswordEmail.code = this.passwordEditText.getText().toString();
                    ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_confirmPasswordEmail, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$joe4LHrYNylcEFGAlKJHljOX-xw
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                            this.f$0.lambda$createView$17$TwoStepVerificationSetupActivity(tLObject, tLRPC$TL_error);
                        }
                    }, 10);
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
            case 8:
                if (this.currentPassword == null) {
                    needShowProgress();
                    this.doneAfterPasswordLoad = true;
                    break;
                } else {
                    String string3 = this.passwordEditText.getText().toString();
                    if (string3.length() == 0) {
                        onFieldError(this.passwordEditText, false);
                        break;
                    } else {
                        final byte[] stringBytes = AndroidUtilities.getStringBytes(string3);
                        needShowProgress();
                        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$kh42jslS9xYHciNp1yGH_8wIchY
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.lambda$createView$12$TwoStepVerificationSetupActivity(stringBytes);
                            }
                        });
                        break;
                    }
                }
            case 9:
                finishFragment();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$12$TwoStepVerificationSetupActivity(byte[] bArr) {
        TLRPC$TL_account_getPasswordSettings tLRPC$TL_account_getPasswordSettings = new TLRPC$TL_account_getPasswordSettings();
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = this.currentPassword.current_algo;
        final byte[] x = tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow ? SRPHelper.getX(bArr, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo) : null;
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$vYh387ywiZvY2yH1_kRG3viR6DU
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$11$TwoStepVerificationSetupActivity(x, tLObject, tLRPC$TL_error);
            }
        };
        TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo2 = tLRPC$TL_account_password.current_algo;
        if (tLRPC$PasswordKdfAlgo2 instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
            TLRPC$TL_inputCheckPasswordSRP tLRPC$TL_inputCheckPasswordSRPStartCheck = SRPHelper.startCheck(x, tLRPC$TL_account_password.srp_id, tLRPC$TL_account_password.srp_B, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo2);
            tLRPC$TL_account_getPasswordSettings.password = tLRPC$TL_inputCheckPasswordSRPStartCheck;
            if (tLRPC$TL_inputCheckPasswordSRPStartCheck == null) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "ALGO_INVALID";
                requestDelegate.run(null, tLRPC$TL_error);
                return;
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_getPasswordSettings, requestDelegate, 10);
            return;
        }
        TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
        tLRPC$TL_error2.text = "PASSWORD_HASH_INVALID";
        requestDelegate.run(null, tLRPC$TL_error2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$11$TwoStepVerificationSetupActivity(final byte[] bArr, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$6Lu4xSrjw7xCvp9n-WJ1rKnlVnM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createView$7$TwoStepVerificationSetupActivity(bArr);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$nr3V8UD1ihmRv2LewaafXP_qObU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createView$10$TwoStepVerificationSetupActivity(tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$TwoStepVerificationSetupActivity(byte[] bArr) {
        needHideProgress();
        this.currentPasswordHash = bArr;
        getMessagesController().removeSuggestion(0L, "VALIDATE_PASSWORD");
        presentFragment(new TwoStepVerificationSetupActivity(9, this.currentPassword), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$10$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error) {
        String pluralString;
        if ("SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$WZx_YxkwgbxyJ4X_6M7mH6RtXbQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$createView$9$TwoStepVerificationSetupActivity(tLObject, tLRPC$TL_error2);
                }
            }, 8);
            return;
        }
        needHideProgress();
        if ("PASSWORD_HASH_INVALID".equals(tLRPC$TL_error.text)) {
            this.descriptionText.setText(LocaleController.getString("CheckPasswordWrong", R.string.CheckPasswordWrong));
            this.descriptionText.setTextColor(Theme.getColor("windowBackgroundWhiteRedText4"));
            onFieldError(this.passwordEditText, true);
            showDoneButton(false);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$TwoStepVerificationSetupActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$1fwFRXQmwDbpnd4vHgC8vEFMRAQ
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$8$TwoStepVerificationSetupActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
            this.buttonTextView.callOnClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$14, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$14$TwoStepVerificationSetupActivity(final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$LisUkA_hXM1z3auz9BcJv-3sya0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$13$TwoStepVerificationSetupActivity(tLObject, str, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$13$TwoStepVerificationSetupActivity(TLObject tLObject, String str, TLRPC$TL_error tLRPC$TL_error) {
        String pluralString;
        if (tLObject instanceof TLRPC$TL_boolTrue) {
            TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(this.currentAccount, 0, this.currentPassword);
            twoStepVerificationSetupActivity.fragmentsToClose.addAll(this.fragmentsToClose);
            twoStepVerificationSetupActivity.addFragmentToClose(this);
            twoStepVerificationSetupActivity.setCurrentEmailCode(str);
            presentFragment(twoStepVerificationSetupActivity, true);
            return;
        }
        if (tLRPC$TL_error == null || tLRPC$TL_error.text.startsWith("CODE_INVALID")) {
            onFieldError(this.passwordEditText, true);
            return;
        }
        if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            showAlertWithText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
            return;
        }
        showAlertWithText(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle), tLRPC$TL_error.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$17$TwoStepVerificationSetupActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$47FOkMOyP7yC92t78Vp4YPy_-xI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$16$TwoStepVerificationSetupActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$16$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error) {
        String pluralString;
        needHideProgress();
        if (tLRPC$TL_error == null) {
            if (getParentActivity() == null) {
                return;
            }
            if (this.currentPassword.has_password) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$lDUje5dMYswfOOm65jgvePcXA_M
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$createView$15$TwoStepVerificationSetupActivity(dialogInterface, i);
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
            tLRPC$TL_account_password.email_unconfirmed_pattern = "";
            TwoStepVerificationSetupActivity twoStepVerificationSetupActivity = new TwoStepVerificationSetupActivity(7, tLRPC$TL_account_password);
            twoStepVerificationSetupActivity.setCurrentPasswordParams(this.currentPasswordHash, this.currentSecretId, this.currentSecret, this.emailOnly);
            twoStepVerificationSetupActivity.fragmentsToClose.addAll(this.fragmentsToClose);
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$15$TwoStepVerificationSetupActivity(DialogInterface dialogInterface, int i) {
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
        tLRPC$TL_account_password2.email_unconfirmed_pattern = "";
        twoStepVerificationActivity.setCurrentPasswordParams(tLRPC$TL_account_password2, this.currentPasswordHash, this.currentSecretId, this.currentSecret);
        presentFragment(twoStepVerificationActivity, true);
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$20$TwoStepVerificationSetupActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5 && i != 6) {
            return false;
        }
        this.buttonTextView.callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$21$TwoStepVerificationSetupActivity(View view) throws InterruptedException {
        this.ignoreTextChange = true;
        if (this.passwordEditText.getTransformationMethod() == null) {
            this.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_messagePanelIcons"), PorterDuff.Mode.MULTIPLY));
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
            this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chat_messagePanelSend"), PorterDuff.Mode.MULTIPLY));
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
    /* renamed from: lambda$createView$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$23$TwoStepVerificationSetupActivity(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$3NC9i4ZP_-PWJCbzB3Sa4NwAt48
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createView$22$TwoStepVerificationSetupActivity(dialogInterface, i);
            }
        });
        builder.setTitle(LocaleController.getString("ResetPassword", R.string.ResetPassword));
        builder.setMessage(LocaleController.getString("RestoreEmailTroubleText2", R.string.RestoreEmailTroubleText2));
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$22$TwoStepVerificationSetupActivity(DialogInterface dialogInterface, int i) {
        onReset();
        finishFragment();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.paused = true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        this.paused = false;
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor != null && editTextBoldCursor.getVisibility() == 0) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$D98MxJwN1d-G_s5IumCJNwPTgd0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onResume$24$TwoStepVerificationSetupActivity();
                }
            }, 200L);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onResume$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onResume$24$TwoStepVerificationSetupActivity() {
        EditTextBoldCursor editTextBoldCursor = this.passwordEditText;
        if (editTextBoldCursor != null) {
            editTextBoldCursor.requestFocus();
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected boolean hideKeyboardOnShow() {
        int i = this.currentType;
        return i == 7 || i == 9;
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
        this.email = "";
        setNewPassword(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoneButton(final boolean show) {
        if (show == (this.buttonTextView.getTag() != null)) {
            return;
        }
        AnimatorSet animatorSet = this.buttonAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.buttonTextView.setTag(show ? 1 : null);
        this.buttonAnimation = new AnimatorSet();
        if (show) {
            this.buttonTextView.setVisibility(0);
            this.buttonAnimation.playTogether(ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_X, 0.9f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_Y, 0.9f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
        } else {
            this.descriptionText2.setVisibility(0);
            this.buttonAnimation.playTogether(ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_X, 0.9f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.SCALE_Y, 0.9f), ObjectAnimator.ofFloat(this.buttonTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.descriptionText2, (Property<TextView, Float>) View.ALPHA, 1.0f));
        }
        this.buttonAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.TwoStepVerificationSetupActivity.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (TwoStepVerificationSetupActivity.this.buttonAnimation == null || !TwoStepVerificationSetupActivity.this.buttonAnimation.equals(animation)) {
                    return;
                }
                if (show) {
                    TwoStepVerificationSetupActivity.this.descriptionText2.setVisibility(4);
                } else {
                    TwoStepVerificationSetupActivity.this.buttonTextView.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (TwoStepVerificationSetupActivity.this.buttonAnimation == null || !TwoStepVerificationSetupActivity.this.buttonAnimation.equals(animation)) {
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
            ir.eitaa.messenger.AndroidUtilities.cancelRunOnUIThread(r0)
        Lc:
            ir.eitaa.ui.Components.RLottieImageView r0 = r5.imageView
            ir.eitaa.ui.Components.RLottieDrawable r0 = r0.getAnimatedDrawable()
            r1 = 1
            r2 = 0
            if (r6 != 0) goto L30
            ir.eitaa.ui.Components.RLottieDrawable[] r3 = r5.animationDrawables
            r4 = r3[r2]
            if (r0 == r4) goto L30
            r3 = r3[r1]
            if (r0 == r3) goto L30
            ir.eitaa.ui.Components.EditTextBoldCursor r3 = r5.passwordEditText
            int r3 = r3.length()
            if (r3 != 0) goto L63
            if (r0 == 0) goto L30
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L63
        L30:
            java.security.SecureRandom r0 = ir.eitaa.messenger.Utilities.random
            int r0 = r0.nextInt()
            int r0 = r0 % 2
            r3 = 0
            if (r0 != 0) goto L4c
            ir.eitaa.ui.Components.RLottieImageView r0 = r5.imageView
            ir.eitaa.ui.Components.RLottieDrawable[] r1 = r5.animationDrawables
            r1 = r1[r2]
            r0.setAnimation(r1)
            ir.eitaa.ui.Components.RLottieDrawable[] r0 = r5.animationDrawables
            r0 = r0[r2]
            r0.setProgress(r3)
            goto L5c
        L4c:
            ir.eitaa.ui.Components.RLottieImageView r0 = r5.imageView
            ir.eitaa.ui.Components.RLottieDrawable[] r2 = r5.animationDrawables
            r2 = r2[r1]
            r0.setAnimation(r2)
            ir.eitaa.ui.Components.RLottieDrawable[] r0 = r5.animationDrawables
            r0 = r0[r1]
            r0.setProgress(r3)
        L5c:
            if (r6 != 0) goto L63
            ir.eitaa.ui.Components.RLottieImageView r6 = r5.imageView
            r6.playAnimation()
        L63:
            ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$Zs0ubT5VYzulDl5jiUXv84UId04 r6 = new ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$Zs0ubT5VYzulDl5jiUXv84UId04
            r6.<init>()
            r5.setAnimationRunnable = r6
            java.security.SecureRandom r0 = ir.eitaa.messenger.Utilities.random
            r1 = 2000(0x7d0, float:2.803E-42)
            int r0 = r0.nextInt(r1)
            int r0 = r0 + 5000
            long r0 = (long) r0
            ir.eitaa.messenger.AndroidUtilities.runOnUIThread(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.TwoStepVerificationSetupActivity.setRandomMonkeyIdleAnimation(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setRandomMonkeyIdleAnimation$25, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setRandomMonkeyIdleAnimation$25$TwoStepVerificationSetupActivity() {
        if (this.setAnimationRunnable == null) {
            return;
        }
        setRandomMonkeyIdleAnimation(false);
    }

    public void setCloseAfterSet(boolean value) {
        this.closeAfterSet = value;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        EditTextBoldCursor editTextBoldCursor;
        if (isOpen && (editTextBoldCursor = this.passwordEditText) != null && editTextBoldCursor.getVisibility() == 0) {
            AndroidUtilities.showKeyboard(this.passwordEditText);
        }
    }

    private void loadPasswordInfo() {
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$Q18OZHb5wX0gQz6UDvIM5Ldwpro
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPasswordInfo$27$TwoStepVerificationSetupActivity(tLObject, tLRPC$TL_error);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$27$TwoStepVerificationSetupActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$--hC4E4TmwFfPinJ3iQifsCtAec
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPasswordInfo$26$TwoStepVerificationSetupActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$26$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
                        str2 = "";
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

    private void needShowProgress() {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCacnel(false);
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

    private boolean isValidEmail(String text) {
        if (text == null || text.length() < 3) {
            return false;
        }
        int iLastIndexOf = text.lastIndexOf(46);
        int iLastIndexOf2 = text.lastIndexOf(64);
        return iLastIndexOf2 >= 0 && iLastIndexOf >= iLastIndexOf2;
    }

    private void showAlertWithText(String title, String text) {
        if (getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(title);
        builder.setMessage(text);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setNewPassword(final boolean z) {
        TLRPC$TL_account_password tLRPC$TL_account_password;
        TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings;
        if (z && this.waitingForEmail && this.currentPassword.has_password) {
            needShowProgress();
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_account_cancelPasswordEmail
                public static int constructor = -1043606090;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$Bool.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$Rnq5rNhmXdlIojJyXvYxHHjmR5o
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$setNewPassword$29$TwoStepVerificationSetupActivity(tLObject, tLRPC$TL_error);
                }
            });
            return;
        }
        final String str = this.firstPassword;
        final TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = new TLRPC$TL_account_passwordInputSettings();
        if (z) {
            UserConfig.getInstance(this.currentAccount).resetSavedPassword();
            this.currentSecret = null;
            if (this.waitingForEmail) {
                tLRPC$TL_account_passwordInputSettings.flags = 2;
                tLRPC$TL_account_passwordInputSettings.email = "";
            } else {
                tLRPC$TL_account_passwordInputSettings.flags = 3;
                tLRPC$TL_account_passwordInputSettings.hint = "";
                tLRPC$TL_account_passwordInputSettings.new_password_hash = new byte[0];
                tLRPC$TL_account_passwordInputSettings.new_algo = new TLRPC$TL_passwordKdfAlgoUnknown();
                tLRPC$TL_account_passwordInputSettings.email = "";
            }
        } else {
            if (this.hint == null && (tLRPC$TL_account_password = this.currentPassword) != null) {
                this.hint = tLRPC$TL_account_password.hint;
            }
            if (this.hint == null) {
                this.hint = "";
            }
            if (str != null) {
                tLRPC$TL_account_passwordInputSettings.flags |= 1;
                tLRPC$TL_account_passwordInputSettings.hint = this.hint;
                tLRPC$TL_account_passwordInputSettings.new_algo = this.currentPassword.new_algo;
            }
            if (this.email.length() > 0) {
                tLRPC$TL_account_passwordInputSettings.flags = 2 | tLRPC$TL_account_passwordInputSettings.flags;
                tLRPC$TL_account_passwordInputSettings.email = this.email.trim();
            }
        }
        if (this.emailCode != null) {
            TLRPC$TL_auth_recoverPassword tLRPC$TL_auth_recoverPassword = new TLRPC$TL_auth_recoverPassword();
            tLRPC$TL_auth_recoverPassword.code = this.emailCode;
            tLRPC$TL_auth_recoverPassword.new_settings = tLRPC$TL_account_passwordInputSettings;
            tLRPC$TL_auth_recoverPassword.flags |= 1;
            tLRPC$TL_account_updatePasswordSettings = tLRPC$TL_auth_recoverPassword;
        } else {
            TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings2 = new TLRPC$TL_account_updatePasswordSettings();
            byte[] bArr = this.currentPasswordHash;
            if (bArr == null || bArr.length == 0 || (z && this.waitingForEmail)) {
                tLRPC$TL_account_updatePasswordSettings2.password = new TLRPC$TL_inputCheckPasswordEmpty();
            }
            tLRPC$TL_account_updatePasswordSettings2.new_settings = tLRPC$TL_account_passwordInputSettings;
            tLRPC$TL_account_updatePasswordSettings = tLRPC$TL_account_updatePasswordSettings2;
        }
        final TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings3 = tLRPC$TL_account_updatePasswordSettings;
        needShowProgress();
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$ox5ElObJaTx4jlxvKBeDKQmFoq8
            @Override // java.lang.Runnable
            public final void run() throws NoSuchAlgorithmException {
                this.f$0.lambda$setNewPassword$35$TwoStepVerificationSetupActivity(tLRPC$TL_account_updatePasswordSettings3, z, str, tLRPC$TL_account_passwordInputSettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setNewPassword$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$29$TwoStepVerificationSetupActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$QbMwZAgS4vusMvv7b4vBHHhScI8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNewPassword$28$TwoStepVerificationSetupActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setNewPassword$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$28$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error) {
        needHideProgress();
        if (tLRPC$TL_error == null) {
            TwoStepVerificationActivity twoStepVerificationActivity = new TwoStepVerificationActivity();
            TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
            tLRPC$TL_account_password.has_recovery = false;
            tLRPC$TL_account_password.email_unconfirmed_pattern = "";
            twoStepVerificationActivity.setCurrentPasswordParams(tLRPC$TL_account_password, this.currentPasswordHash, this.currentSecretId, this.currentSecret);
            presentFragment(twoStepVerificationActivity, true);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didRemoveTwoStepPassword, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setNewPassword$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$35$TwoStepVerificationSetupActivity(TLObject tLObject, final boolean z, final String str, final TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings) throws NoSuchAlgorithmException {
        final byte[] x;
        byte[] bArr;
        byte[] bArr2;
        if (tLObject instanceof TLRPC$TL_account_updatePasswordSettings) {
            TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = (TLRPC$TL_account_updatePasswordSettings) tLObject;
            if (tLRPC$TL_account_updatePasswordSettings.password == null) {
                tLRPC$TL_account_updatePasswordSettings.password = getNewSrpPassword();
            }
        }
        if (z || str == null) {
            x = null;
            bArr = null;
        } else {
            byte[] stringBytes = AndroidUtilities.getStringBytes(str);
            TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = this.currentPassword.new_algo;
            if (tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
                bArr = stringBytes;
                x = SRPHelper.getX(stringBytes, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo);
            } else {
                bArr = stringBytes;
                x = null;
            }
        }
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$gilnD12OS08NG18L3Zg8UHf_ZjY
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$setNewPassword$34$TwoStepVerificationSetupActivity(z, x, str, tLRPC$TL_account_passwordInputSettings, tLObject2, tLRPC$TL_error);
            }
        };
        if (!z) {
            if (str != null && (bArr2 = this.currentSecret) != null && bArr2.length == 32) {
                TLRPC$SecurePasswordKdfAlgo tLRPC$SecurePasswordKdfAlgo = this.currentPassword.new_secure_algo;
                if (tLRPC$SecurePasswordKdfAlgo instanceof TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) {
                    TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000 = (TLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000) tLRPC$SecurePasswordKdfAlgo;
                    byte[] bArrComputePBKDF2 = Utilities.computePBKDF2(bArr, tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000.salt);
                    byte[] bArr3 = new byte[32];
                    System.arraycopy(bArrComputePBKDF2, 0, bArr3, 0, 32);
                    byte[] bArr4 = new byte[16];
                    System.arraycopy(bArrComputePBKDF2, 32, bArr4, 0, 16);
                    byte[] bArr5 = new byte[32];
                    System.arraycopy(this.currentSecret, 0, bArr5, 0, 32);
                    Utilities.aesCbcEncryptionByteArraySafe(bArr5, bArr3, bArr4, 0, 32, 0, 1);
                    TLRPC$TL_secureSecretSettings tLRPC$TL_secureSecretSettings = new TLRPC$TL_secureSecretSettings();
                    tLRPC$TL_account_passwordInputSettings.new_secure_settings = tLRPC$TL_secureSecretSettings;
                    tLRPC$TL_secureSecretSettings.secure_algo = tLRPC$TL_securePasswordKdfAlgoPBKDF2HMACSHA512iter100000;
                    tLRPC$TL_secureSecretSettings.secure_secret = bArr5;
                    tLRPC$TL_secureSecretSettings.secure_secret_id = this.currentSecretId;
                    tLRPC$TL_account_passwordInputSettings.flags |= 4;
                }
            }
            TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo2 = this.currentPassword.new_algo;
            if (tLRPC$PasswordKdfAlgo2 instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
                if (str != null) {
                    byte[] vBytes = SRPHelper.getVBytes(bArr, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo2);
                    tLRPC$TL_account_passwordInputSettings.new_password_hash = vBytes;
                    if (vBytes == null) {
                        TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "ALGO_INVALID";
                        requestDelegate.run(null, tLRPC$TL_error);
                    }
                }
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLObject, requestDelegate, 10);
                return;
            }
            TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
            tLRPC$TL_error2.text = "PASSWORD_HASH_INVALID";
            requestDelegate.run(null, tLRPC$TL_error2);
            return;
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLObject, requestDelegate, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setNewPassword$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$34$TwoStepVerificationSetupActivity(final boolean z, final byte[] bArr, final String str, final TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$cPKFxxz89LYN19BOhNibjUMe5b8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNewPassword$33$TwoStepVerificationSetupActivity(tLRPC$TL_error, z, tLObject, bArr, str, tLRPC$TL_account_passwordInputSettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setNewPassword$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$33$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error, final boolean z, TLObject tLObject, final byte[] bArr, String str, TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings) {
        String pluralString;
        TLRPC$TL_account_password tLRPC$TL_account_password;
        if (tLRPC$TL_error != null && "SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$FtUFo7sgusnEAkmEa4PW5kJ1dFI
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$setNewPassword$31$TwoStepVerificationSetupActivity(z, tLObject2, tLRPC$TL_error2);
                }
            }, 8);
            return;
        }
        needHideProgress();
        if (tLRPC$TL_error != null || (!(tLObject instanceof TLRPC$TL_boolTrue) && !(tLObject instanceof TLRPC$auth_Authorization))) {
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
                    notificationCenter.postNotificationName(i2, bArr, tLRPC$TL_account_passwordInputSettings.new_algo, tLRPC$TL_account_password2.new_secure_algo, tLRPC$TL_account_password2.secure_random, str2, this.hint, str2, this.firstPassword);
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
        getMessagesController().removeSuggestion(0L, "VALIDATE_PASSWORD");
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
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$QQfDxp8C54zreJib5BkCLccKTKU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    this.f$0.lambda$setNewPassword$32$TwoStepVerificationSetupActivity(bArr, dialogInterface, i4);
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
    /* renamed from: lambda$setNewPassword$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$31$TwoStepVerificationSetupActivity(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$TwoStepVerificationSetupActivity$HqEYARXVkBDFVR6ZCM5XeTltwVg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setNewPassword$30$TwoStepVerificationSetupActivity(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setNewPassword$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$30$TwoStepVerificationSetupActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            setNewPassword(z);
            NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.didSetOrRemoveTwoStepPassword, this.currentPassword);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setNewPassword$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setNewPassword$32$TwoStepVerificationSetupActivity(byte[] bArr, DialogInterface dialogInterface, int i) {
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

    private void onFieldError(TextView field, boolean clear) {
        if (getParentActivity() == null) {
            return;
        }
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        if (clear) {
            field.setText("");
        }
        AndroidUtilities.shakeView(field, 2.0f, 0);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_CHECKTAG | ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.passwordEditText, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        return arrayList;
    }
}
