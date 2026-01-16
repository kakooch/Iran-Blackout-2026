package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.ImageReceiver;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.MessagesStorage;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SRPHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.SerializedData;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$FileLocation;
import ir.eitaa.tgnet.TLRPC$InputFile;
import ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$PhotoSize;
import ir.eitaa.tgnet.TLRPC$TL_account_deleteAccount;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword_layer84;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordInputSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_password_layer84;
import ir.eitaa.tgnet.TLRPC$TL_auth_authorization;
import ir.eitaa.tgnet.TLRPC$TL_auth_authorizationSignUpRequired;
import ir.eitaa.tgnet.TLRPC$TL_auth_cancelCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_checkPassword_layer84;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeFlashCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeSms;
import ir.eitaa.tgnet.TLRPC$TL_auth_passwordRecovery;
import ir.eitaa.tgnet.TLRPC$TL_auth_recoverPassword;
import ir.eitaa.tgnet.TLRPC$TL_auth_recoverPassword_layer84;
import ir.eitaa.tgnet.TLRPC$TL_auth_requestPasswordRecovery_layer84;
import ir.eitaa.tgnet.TLRPC$TL_auth_resendCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_sendCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeApp;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeFlashCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeSms;
import ir.eitaa.tgnet.TLRPC$TL_auth_signIn;
import ir.eitaa.tgnet.TLRPC$TL_auth_signUp_layer84;
import ir.eitaa.tgnet.TLRPC$TL_codeSettings;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_help_countriesList;
import ir.eitaa.tgnet.TLRPC$TL_help_country;
import ir.eitaa.tgnet.TLRPC$TL_help_getCountriesList;
import ir.eitaa.tgnet.TLRPC$TL_help_termsOfService;
import ir.eitaa.tgnet.TLRPC$TL_nearestDc;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$auth_Authorization;
import ir.eitaa.tgnet.TLRPC$auth_CodeType;
import ir.eitaa.tgnet.TLRPC$auth_SentCodeType;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenu;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.CheckBoxCell;
import ir.eitaa.ui.Components.AvatarDrawable;
import ir.eitaa.ui.Components.Bulletin;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.ContextProgressView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.HintEditText;
import ir.eitaa.ui.Components.ImageUpdater;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.SlideView;
import ir.eitaa.ui.Components.VerticalPositionAutoAnimator;
import ir.eitaa.ui.CountrySelectActivity;
import ir.eitaa.ui.LoginActivity;
import j$.util.Comparator;
import j$.util.function.Function;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"HardwareIds"})
/* loaded from: classes3.dex */
public class LoginActivity extends BaseFragment {
    private boolean checkPermissions;
    private boolean checkShowPermissions;
    private int currentDoneType;
    private TLRPC$TL_help_termsOfService currentTermsOfService;
    private int currentViewNum;
    private boolean[] doneButtonVisible;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimation;
    private ContextProgressView doneProgressView;
    private FrameLayout floatingButtonContainer;
    private ImageView floatingButtonIcon;
    private RadialProgressView floatingProgressView;
    private boolean needRequestPermissions;
    private boolean newAccount;
    private Dialog permissionsDialog;
    private ArrayList<String> permissionsItems;
    private Dialog permissionsShowDialog;
    private ArrayList<String> permissionsShowItems;
    private int progressRequestId;
    private boolean restoringState;
    private int scrollHeight;
    private AnimatorSet[] showDoneAnimation;
    private boolean syncContacts;
    private boolean testBackend;
    private SlideView[] views;

    private static class ProgressView extends View {
        private boolean animating;
        private final RectF boundsRect;
        private long duration;
        private final Paint paint;
        private final Paint paint2;
        private final Path path;
        private float radius;
        private final RectF rect;
        private long startTime;

        public ProgressView(Context context) {
            super(context);
            this.path = new Path();
            this.rect = new RectF();
            this.boundsRect = new RectF();
            Paint paint = new Paint(1);
            this.paint = paint;
            Paint paint2 = new Paint(1);
            this.paint2 = paint2;
            paint.setColor(Theme.getColor("login_progressInner"));
            paint2.setColor(Theme.getColor("login_progressOuter"));
        }

        public void startProgressAnimation(long duration) {
            this.animating = true;
            this.duration = duration;
            this.startTime = System.currentTimeMillis();
            invalidate();
        }

        public void resetProgressAnimation() {
            this.duration = 0L;
            this.startTime = 0L;
            this.animating = false;
            invalidate();
        }

        public boolean isProgressAnimationRunning() {
            return this.animating;
        }

        @Override // android.view.View
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            this.path.rewind();
            float f = h;
            this.radius = f / 2.0f;
            this.boundsRect.set(0.0f, 0.0f, w, f);
            this.rect.set(this.boundsRect);
            Path path = this.path;
            RectF rectF = this.boundsRect;
            float f2 = this.radius;
            path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float fMin = this.duration > 0 ? Math.min(1.0f, (System.currentTimeMillis() - this.startTime) / this.duration) : 0.0f;
            canvas.clipPath(this.path);
            RectF rectF = this.boundsRect;
            float f = this.radius;
            canvas.drawRoundRect(rectF, f, f, this.paint);
            RectF rectF2 = this.rect;
            rectF2.right = this.boundsRect.right * fMin;
            float f2 = this.radius;
            canvas.drawRoundRect(rectF2, f2, f2, this.paint2);
            boolean z = this.animating & (this.duration > 0 && fMin < 1.0f);
            this.animating = z;
            if (z) {
                postInvalidateOnAnimation();
            }
        }
    }

    public LoginActivity() {
        this.views = new SlideView[11];
        this.permissionsItems = new ArrayList<>();
        this.permissionsShowItems = new ArrayList<>();
        this.checkPermissions = true;
        this.checkShowPermissions = true;
        this.syncContacts = true;
        this.testBackend = false;
        this.showDoneAnimation = new AnimatorSet[2];
        this.doneButtonVisible = new boolean[]{true, false};
    }

    public LoginActivity(int account) {
        this.views = new SlideView[11];
        this.permissionsItems = new ArrayList<>();
        this.permissionsShowItems = new ArrayList<>();
        this.checkPermissions = true;
        this.checkShowPermissions = true;
        this.syncContacts = true;
        this.testBackend = false;
        this.showDoneAnimation = new AnimatorSet[2];
        this.doneButtonVisible = new boolean[]{true, false};
        this.currentAccount = account;
        this.newAccount = true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                return;
            }
            if (slideViewArr[i] != null) {
                slideViewArr[i].onDestroyActivity();
            }
            i++;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.LoginActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == 1) {
                    LoginActivity.this.onDoneButtonPressed();
                } else if (id == -1 && LoginActivity.this.onBackPressed()) {
                    LoginActivity.this.finishFragment();
                }
            }
        });
        this.currentDoneType = 0;
        boolean[] zArr = this.doneButtonVisible;
        zArr[0] = true;
        zArr[1] = false;
        ActionBarMenu actionBarMenuCreateMenu = this.actionBar.createMenu();
        this.actionBar.setAllowOverlayTitle(true);
        this.doneItem = actionBarMenuCreateMenu.addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        ContextProgressView contextProgressView = new ContextProgressView(context, 1);
        this.doneProgressView = contextProgressView;
        contextProgressView.setAlpha(0.0f);
        this.doneProgressView.setScaleX(0.1f);
        this.doneProgressView.setScaleY(0.1f);
        this.doneProgressView.setVisibility(4);
        this.doneItem.setAlpha(0.0f);
        this.doneItem.setScaleX(0.1f);
        this.doneItem.setScaleY(0.1f);
        this.doneItem.addView(this.doneProgressView, LayoutHelper.createFrame(-1, -1.0f));
        this.doneItem.setContentDescription(LocaleController.getString("Done", R.string.Done));
        this.doneItem.setVisibility(this.doneButtonVisible[1] ? 0 : 8);
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.LoginActivity.2
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) LoginActivity.this.floatingButtonContainer.getLayoutParams();
                if (Bulletin.getVisibleBulletin() != null && Bulletin.getVisibleBulletin().isShowing()) {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    marginLayoutParams.bottomMargin = (AndroidUtilities.dp(14.0f) + Bulletin.getVisibleBulletin().getLayout().getMeasuredHeight()) - AndroidUtilities.dp(10.0f);
                } else {
                    marginLayoutParams.bottomMargin = AndroidUtilities.dp(14.0f);
                }
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        };
        this.fragmentView = frameLayout;
        ScrollView scrollView = new ScrollView(context) { // from class: ir.eitaa.ui.LoginActivity.3
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                if (LoginActivity.this.currentViewNum == 1 || LoginActivity.this.currentViewNum == 2 || LoginActivity.this.currentViewNum == 4) {
                    rectangle.bottom += AndroidUtilities.dp(40.0f);
                }
                return super.requestChildRectangleOnScreen(child, rectangle, immediate);
            }

            @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                LoginActivity.this.scrollHeight = View.MeasureSpec.getSize(heightMeasureSpec) - AndroidUtilities.dp(30.0f);
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        };
        scrollView.setFillViewport(true);
        frameLayout.addView(scrollView, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        scrollView.addView(frameLayout2, LayoutHelper.createScroll(-1, -2, 51));
        this.views[0] = new PhoneView(context);
        this.views[1] = new LoginActivitySmsView(context, 1);
        this.views[2] = new LoginActivitySmsView(context, 2);
        this.views[3] = new LoginActivitySmsView(context, 3);
        this.views[4] = new LoginActivitySmsView(context, 4);
        this.views[5] = new LoginActivityRegisterView(context);
        this.views[6] = new LoginActivityPasswordView(context);
        this.views[7] = new LoginActivityRecoverView(context);
        this.views[8] = new LoginActivityResetWaitView(context);
        this.views[9] = new LoginActivityNewPasswordView(context, 0);
        this.views[10] = new LoginActivityNewPasswordView(context, 1);
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                break;
            }
            slideViewArr[i].setVisibility(i == 0 ? 0 : 8);
            frameLayout2.addView(this.views[i], LayoutHelper.createFrame(-1, -1.0f, 51, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 30.0f, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 0.0f));
            i++;
        }
        Bundle bundleLoadCurrentState = loadCurrentState();
        if (bundleLoadCurrentState != null) {
            this.currentViewNum = bundleLoadCurrentState.getInt("currentViewNum", 0);
            this.syncContacts = bundleLoadCurrentState.getInt("syncContacts", 1) == 1;
            int i2 = this.currentViewNum;
            if (i2 >= 1 && i2 <= 4) {
                int i3 = bundleLoadCurrentState.getInt("open");
                if (i3 != 0 && Math.abs((System.currentTimeMillis() / 1000) - i3) >= 86400) {
                    this.currentViewNum = 0;
                    clearCurrentState();
                    bundleLoadCurrentState = null;
                }
            } else if (i2 == 6) {
                if (((LoginActivityPasswordView) this.views[6]).currentPassword == null) {
                    this.currentViewNum = 0;
                    clearCurrentState();
                    bundleLoadCurrentState = null;
                }
            } else if (i2 == 7 && ((LoginActivityRecoverView) this.views[7]).passwordString == null) {
                this.currentViewNum = 0;
                clearCurrentState();
                bundleLoadCurrentState = null;
            }
        }
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.floatingButtonContainer = frameLayout3;
        frameLayout3.setVisibility(this.doneButtonVisible[0] ? 0 : 8);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor("chats_actionBackground"), Theme.getColor("chats_actionPressedBackground"));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        this.floatingButtonContainer.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        if (i4 >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[]{android.R.attr.state_pressed}, ObjectAnimator.ofFloat(this.floatingButtonIcon, "translationZ", AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButtonIcon, "translationZ", AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.floatingButtonContainer.setStateListAnimator(stateListAnimator);
            this.floatingButtonContainer.setOutlineProvider(new ViewOutlineProvider() { // from class: ir.eitaa.ui.LoginActivity.4
                @Override // android.view.ViewOutlineProvider
                @SuppressLint({"NewApi"})
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        VerticalPositionAutoAnimator.attach(this.floatingButtonContainer);
        frameLayout.addView(this.floatingButtonContainer, LayoutHelper.createFrame(i4 >= 21 ? 56 : 60, i4 >= 21 ? 56.0f : 60.0f, 85, 0.0f, 0.0f, 14.0f, 14.0f));
        this.floatingButtonContainer.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$FAK9WI5HLTLwmmQrc0ecc0C8npo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0$LoginActivity(view);
            }
        });
        ImageView imageView = new ImageView(context);
        this.floatingButtonIcon = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.floatingButtonIcon.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionIcon"), PorterDuff.Mode.MULTIPLY));
        this.floatingButtonIcon.setImageResource(R.drawable.actionbtn_next);
        this.floatingButtonContainer.setContentDescription(LocaleController.getString("Done", R.string.Done));
        this.floatingButtonContainer.addView(this.floatingButtonIcon, LayoutHelper.createFrame(i4 >= 21 ? 56 : 60, i4 >= 21 ? 56.0f : 60.0f));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.floatingProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(22.0f));
        this.floatingProgressView.setProgressColor(Theme.getColor("chats_actionIcon"));
        this.floatingProgressView.setAlpha(0.0f);
        this.floatingProgressView.setScaleX(0.1f);
        this.floatingProgressView.setScaleY(0.1f);
        this.floatingProgressView.setVisibility(4);
        this.floatingButtonContainer.addView(this.floatingProgressView, LayoutHelper.createFrame(-1, -1.0f));
        int i5 = 1;
        if (bundleLoadCurrentState != null) {
            this.restoringState = true;
        }
        int i6 = 0;
        while (true) {
            SlideView[] slideViewArr2 = this.views;
            if (i6 < slideViewArr2.length) {
                if (bundleLoadCurrentState != null && (i6 < i5 || i6 > 4 || i6 == this.currentViewNum)) {
                    slideViewArr2[i6].restoreStateParams(bundleLoadCurrentState);
                }
                if (this.currentViewNum == i6) {
                    this.actionBar.setBackButtonImage((this.views[i6].needBackButton() || this.newAccount) ? R.drawable.ic_ab_back : 0);
                    this.views[i6].setVisibility(0);
                    this.views[i6].onShow();
                    this.currentDoneType = 0;
                    i5 = 1;
                    if (i6 == 1 || i6 == 2 || i6 == 3 || i6 == 4 || i6 == 8) {
                        showDoneButton(false, false);
                    } else {
                        showDoneButton(true, false);
                    }
                    if (i6 != 1 && i6 != 2) {
                        if (i6 == 3 || i6 == 4) {
                        }
                    }
                    this.currentDoneType = 1;
                } else {
                    i5 = 1;
                    this.views[i6].setVisibility(8);
                }
                i6++;
            } else {
                this.restoringState = false;
                this.actionBar.setTitle(slideViewArr2[this.currentViewNum].getHeaderName());
                return this.fragmentView;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$LoginActivity(View view) {
        onDoneButtonPressed();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() throws InterruptedException, IOException {
        super.onPause();
        if (this.newAccount) {
            ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() throws InterruptedException, IOException {
        SlideView slideView;
        int i;
        super.onResume();
        if (this.newAccount) {
            ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        this.fragmentView.requestLayout();
        try {
            int i2 = this.currentViewNum;
            if (i2 >= 1 && i2 <= 4) {
                SlideView[] slideViewArr = this.views;
                if ((slideViewArr[i2] instanceof LoginActivitySmsView) && (i = ((LoginActivitySmsView) slideViewArr[i2]).openTime) != 0 && Math.abs((System.currentTimeMillis() / 1000) - i) >= 86400) {
                    this.views[this.currentViewNum].onBackPressed(true);
                    setPage(0, false, null, true);
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
        int i3 = this.currentViewNum;
        if (i3 != 0 || this.needRequestPermissions || (slideView = this.views[i3]) == null) {
            return;
        }
        slideView.onShow();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 6) {
            this.checkPermissions = false;
            int i = this.currentViewNum;
            if (i == 0) {
                this.views[i].onNextPressed();
                return;
            }
            return;
        }
        if (requestCode == 7) {
            this.checkShowPermissions = false;
            int i2 = this.currentViewNum;
            if (i2 == 0) {
                ((PhoneView) this.views[i2]).fillNumber();
            }
        }
    }

    private Bundle loadCurrentState() {
        if (this.newAccount) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, ?> entry : ApplicationLoader.applicationContext.getSharedPreferences("logininfo2", 0).getAll().entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                String[] strArrSplit = key.split("_\\|_");
                if (strArrSplit.length == 1) {
                    if (value instanceof String) {
                        bundle.putString(key, (String) value);
                    } else if (value instanceof Integer) {
                        bundle.putInt(key, ((Integer) value).intValue());
                    }
                } else if (strArrSplit.length == 2) {
                    Bundle bundle2 = bundle.getBundle(strArrSplit[0]);
                    if (bundle2 == null) {
                        bundle2 = new Bundle();
                        bundle.putBundle(strArrSplit[0], bundle2);
                    }
                    if (value instanceof String) {
                        bundle2.putString(strArrSplit[1], (String) value);
                    } else if (value instanceof Integer) {
                        bundle2.putInt(strArrSplit[1], ((Integer) value).intValue());
                    }
                }
            }
            return bundle;
        } catch (Exception e) {
            FileLog.e(e);
            return null;
        }
    }

    private void clearCurrentState() {
        SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("logininfo2", 0).edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    private void putBundleToEditor(Bundle bundle, SharedPreferences.Editor editor, String prefix) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                if (prefix != null) {
                    editor.putString(prefix + "_|_" + str, (String) obj);
                } else {
                    editor.putString(str, (String) obj);
                }
            } else if (obj instanceof Integer) {
                if (prefix != null) {
                    editor.putInt(prefix + "_|_" + str, ((Integer) obj).intValue());
                } else {
                    editor.putInt(str, ((Integer) obj).intValue());
                }
            } else if (obj instanceof Bundle) {
                putBundleToEditor((Bundle) obj, editor, str);
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (dialog == this.permissionsDialog && !this.permissionsItems.isEmpty() && getParentActivity() != null) {
                    getParentActivity().requestPermissions((String[]) this.permissionsItems.toArray(new String[0]), 6);
                } else {
                    if (dialog != this.permissionsShowDialog || this.permissionsShowItems.isEmpty() || getParentActivity() == null) {
                        return;
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$6dr-2yljlJ79Jkq2lqAmHBgRjCw
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDialogDismiss$1$LoginActivity();
                        }
                    }, 200L);
                    getParentActivity().requestPermissions((String[]) this.permissionsShowItems.toArray(new String[0]), 7);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDialogDismiss$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDialogDismiss$1$LoginActivity() {
        this.needRequestPermissions = false;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        int i = this.currentViewNum;
        int i2 = 0;
        if (i != 0) {
            if (i == 6) {
                this.views[i].onBackPressed(true);
                setPage(0, true, null, true);
            } else if (i == 7 || i == 8) {
                this.views[i].onBackPressed(true);
                setPage(6, true, null, true);
            } else if (i < 1 || i > 4) {
                if (i == 5) {
                    ((LoginActivityRegisterView) this.views[i]).wrongNumber.callOnClick();
                } else if (i == 9) {
                    this.views[i].onBackPressed(true);
                    setPage(7, true, null, true);
                } else if (i == 10 || i == 11) {
                    this.views[i].onBackPressed(true);
                    setPage(9, true, null, true);
                }
            } else if (this.views[i].onBackPressed(false)) {
                setPage(0, true, null, true);
            }
            return false;
        }
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i2 < slideViewArr.length) {
                if (slideViewArr[i2] != null) {
                    slideViewArr[i2].onDestroyActivity();
                }
                i2++;
            } else {
                clearCurrentState();
                return true;
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, int resultCode, Intent data) throws InterruptedException, Resources.NotFoundException {
        LoginActivityRegisterView loginActivityRegisterView = (LoginActivityRegisterView) this.views[5];
        if (loginActivityRegisterView != null) {
            loginActivityRegisterView.imageUpdater.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowAlert(String title, String text) {
        if (text == null || getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(title);
        builder.setMessage(text);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFieldError(View view) {
        try {
            Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
        } catch (Throwable unused) {
        }
        AndroidUtilities.shakeView(view, 2.0f, 0);
    }

    public static void needShowInvalidAlert(final BaseFragment fragment, final String phoneNumber, final boolean banned) {
        if (fragment == null || fragment.getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(fragment.getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (banned) {
            builder.setMessage(LocaleController.getString("BannedPhoneNumber", R.string.BannedPhoneNumber));
        } else {
            builder.setMessage(LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
        }
        builder.setNeutralButton(LocaleController.getString("BotHelp", R.string.BotHelp), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$APu8bPYNs_hSc5vVlU28DK8PLjA
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) throws PackageManager.NameNotFoundException {
                LoginActivity.lambda$needShowInvalidAlert$2(banned, phoneNumber, fragment, dialogInterface, i);
            }
        });
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        fragment.showDialog(builder.create());
    }

    static /* synthetic */ void lambda$needShowInvalidAlert$2(boolean z, String str, BaseFragment baseFragment, DialogInterface dialogInterface, int i) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
            String str2 = String.format(Locale.US, "%s (%d)", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra("android.intent.extra.EMAIL", new String[]{"support@eitaa.com"});
            if (z) {
                intent.putExtra("android.intent.extra.SUBJECT", "Banned phone number: " + str);
                intent.putExtra("android.intent.extra.TEXT", "I'm trying to use my mobile phone number: " + str + "\nBut Eitaa says it's banned. Please help.\n\nApp version: " + str2 + "\nOS version: SDK " + Build.VERSION.SDK_INT + "\nDevice Name: " + Build.MANUFACTURER + Build.MODEL + "\nLocale: " + Locale.getDefault());
            } else {
                intent.putExtra("android.intent.extra.SUBJECT", "Invalid phone number: " + str);
                intent.putExtra("android.intent.extra.TEXT", "I'm trying to use my mobile phone number: " + str + "\nBut Eitaa says it's invalid. Please help.\n\nApp version: " + str2 + "\nOS version: SDK " + Build.VERSION.SDK_INT + "\nDevice Name: " + Build.MANUFACTURER + Build.MODEL + "\nLocale: " + Locale.getDefault());
            }
            baseFragment.getParentActivity().startActivity(Intent.createChooser(intent, "Send email..."));
        } catch (Exception unused) {
            AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("NoMailInstalled", R.string.NoMailInstalled));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            baseFragment.showDialog(builder.create());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoneButton(final boolean show, boolean animated) {
        TimeInterpolator timeInterpolator;
        int i = this.currentDoneType;
        final boolean z = i == 0;
        if (this.doneButtonVisible[i] == show) {
            return;
        }
        AnimatorSet[] animatorSetArr = this.showDoneAnimation;
        if (animatorSetArr[i] != null) {
            animatorSetArr[i].cancel();
        }
        boolean[] zArr = this.doneButtonVisible;
        int i2 = this.currentDoneType;
        zArr[i2] = show;
        if (!animated) {
            if (show) {
                if (z) {
                    this.floatingButtonContainer.setVisibility(0);
                    this.floatingButtonContainer.setTranslationY(0.0f);
                    return;
                } else {
                    this.doneItem.setVisibility(0);
                    this.doneItem.setScaleX(1.0f);
                    this.doneItem.setScaleY(1.0f);
                    this.doneItem.setAlpha(1.0f);
                    return;
                }
            }
            if (z) {
                this.floatingButtonContainer.setVisibility(8);
                this.floatingButtonContainer.setTranslationY(AndroidUtilities.dpf2(70.0f));
                return;
            } else {
                this.doneItem.setVisibility(8);
                this.doneItem.setScaleX(0.1f);
                this.doneItem.setScaleY(0.1f);
                this.doneItem.setAlpha(0.0f);
                return;
            }
        }
        this.showDoneAnimation[i2] = new AnimatorSet();
        if (show) {
            if (z) {
                this.floatingButtonContainer.setVisibility(0);
                this.showDoneAnimation[this.currentDoneType].play(ObjectAnimator.ofFloat(this.floatingButtonContainer, (Property<FrameLayout, Float>) View.TRANSLATION_Y, 0.0f));
            } else {
                this.doneItem.setVisibility(0);
                this.showDoneAnimation[this.currentDoneType].playTogether(ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 1.0f));
            }
        } else if (z) {
            this.showDoneAnimation[this.currentDoneType].play(ObjectAnimator.ofFloat(this.floatingButtonContainer, (Property<FrameLayout, Float>) View.TRANSLATION_Y, AndroidUtilities.dpf2(70.0f)));
        } else {
            this.showDoneAnimation[this.currentDoneType].playTogether(ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f));
        }
        this.showDoneAnimation[this.currentDoneType].addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.LoginActivity.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LoginActivity.this.showDoneAnimation[!z ? 1 : 0] == null || !LoginActivity.this.showDoneAnimation[!z ? 1 : 0].equals(animator) || show) {
                    return;
                }
                if (z) {
                    LoginActivity.this.floatingButtonContainer.setVisibility(8);
                } else {
                    LoginActivity.this.doneItem.setVisibility(8);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (LoginActivity.this.showDoneAnimation[!z ? 1 : 0] == null || !LoginActivity.this.showDoneAnimation[!z ? 1 : 0].equals(animator)) {
                    return;
                }
                LoginActivity.this.showDoneAnimation[!z ? 1 : 0] = null;
            }
        });
        int i3 = ImageReceiver.DEFAULT_CROSSFADE_DURATION;
        if (!z) {
            timeInterpolator = null;
        } else if (show) {
            i3 = 200;
            timeInterpolator = AndroidUtilities.decelerateInterpolator;
        } else {
            timeInterpolator = AndroidUtilities.accelerateInterpolator;
        }
        this.showDoneAnimation[this.currentDoneType].setDuration(i3);
        this.showDoneAnimation[this.currentDoneType].setInterpolator(timeInterpolator);
        this.showDoneAnimation[this.currentDoneType].start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDoneButtonPressed() {
        if (this.doneButtonVisible[this.currentDoneType]) {
            if (this.doneProgressView.getTag() != null) {
                if (getParentActivity() == null) {
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("StopLoading", R.string.StopLoading));
                builder.setPositiveButton(LocaleController.getString("WaitMore", R.string.WaitMore), null);
                builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$waW3xhuhJCYrKCNa8n_Fhb5qeek
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onDoneButtonPressed$3$LoginActivity(dialogInterface, i);
                    }
                });
                showDialog(builder.create());
                return;
            }
            this.views[this.currentViewNum].onNextPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onDoneButtonPressed$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onDoneButtonPressed$3$LoginActivity(DialogInterface dialogInterface, int i) {
        this.views[this.currentViewNum].onCancelPressed();
        needHideProgress(true);
    }

    private void showEditDoneProgress(final boolean show, boolean animated) {
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        final boolean z = this.currentDoneType == 0;
        if (animated) {
            this.doneItemAnimation = new AnimatorSet();
            if (show) {
                this.doneProgressView.setTag(1);
                if (z) {
                    this.floatingProgressView.setVisibility(0);
                    this.floatingButtonContainer.setEnabled(false);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
                } else {
                    this.doneProgressView.setVisibility(0);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
                }
            } else {
                this.doneProgressView.setTag(null);
                if (z) {
                    this.floatingButtonIcon.setVisibility(0);
                    this.floatingButtonContainer.setEnabled(true);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                } else {
                    this.doneItem.getContentView().setVisibility(0);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 1.0f));
                }
            }
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.LoginActivity.6
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (LoginActivity.this.doneItemAnimation == null || !LoginActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    if (z) {
                        if (!show) {
                            LoginActivity.this.floatingProgressView.setVisibility(4);
                            return;
                        } else {
                            LoginActivity.this.floatingButtonIcon.setVisibility(4);
                            return;
                        }
                    }
                    if (!show) {
                        LoginActivity.this.doneProgressView.setVisibility(4);
                    } else {
                        LoginActivity.this.doneItem.getContentView().setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (LoginActivity.this.doneItemAnimation == null || !LoginActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    LoginActivity.this.doneItemAnimation = null;
                }
            });
            this.doneItemAnimation.setDuration(150L);
            this.doneItemAnimation.start();
            return;
        }
        if (show) {
            if (z) {
                this.floatingProgressView.setVisibility(0);
                this.floatingButtonIcon.setVisibility(4);
                this.floatingButtonContainer.setEnabled(false);
                this.floatingButtonIcon.setScaleX(0.1f);
                this.floatingButtonIcon.setScaleY(0.1f);
                this.floatingButtonIcon.setAlpha(0.0f);
                this.floatingProgressView.setScaleX(1.0f);
                this.floatingProgressView.setScaleY(1.0f);
                this.floatingProgressView.setAlpha(1.0f);
                return;
            }
            this.doneProgressView.setVisibility(0);
            this.doneItem.getContentView().setVisibility(4);
            this.doneItem.getContentView().setScaleX(0.1f);
            this.doneItem.getContentView().setScaleY(0.1f);
            this.doneItem.getContentView().setAlpha(0.0f);
            this.doneProgressView.setScaleX(1.0f);
            this.doneProgressView.setScaleY(1.0f);
            this.doneProgressView.setAlpha(1.0f);
            return;
        }
        this.doneProgressView.setTag(null);
        if (z) {
            this.floatingProgressView.setVisibility(4);
            this.floatingButtonIcon.setVisibility(0);
            this.floatingButtonContainer.setEnabled(true);
            this.floatingProgressView.setScaleX(0.1f);
            this.floatingProgressView.setScaleY(0.1f);
            this.floatingProgressView.setAlpha(0.0f);
            this.floatingButtonIcon.setScaleX(1.0f);
            this.floatingButtonIcon.setScaleY(1.0f);
            this.floatingButtonIcon.setAlpha(1.0f);
            return;
        }
        this.doneItem.getContentView().setVisibility(0);
        this.doneProgressView.setVisibility(4);
        this.doneProgressView.setScaleX(0.1f);
        this.doneProgressView.setScaleY(0.1f);
        this.doneProgressView.setAlpha(0.0f);
        this.doneItem.getContentView().setScaleX(1.0f);
        this.doneItem.getContentView().setScaleY(1.0f);
        this.doneItem.getContentView().setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowProgress(final int reqiestId) {
        needShowProgress(reqiestId, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowProgress(final int reqiestId, boolean animated) {
        this.progressRequestId = reqiestId;
        showEditDoneProgress(true, animated);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needHideProgress(boolean cancel) {
        needHideProgress(cancel, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needHideProgress(boolean cancel, boolean animated) {
        if (this.progressRequestId != 0) {
            if (cancel) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.progressRequestId, true);
            }
            this.progressRequestId = 0;
        }
        showEditDoneProgress(false, animated);
    }

    public void setPage(int page, boolean animated, Bundle params, boolean back) {
        final boolean z = page == 0 || page == 5 || page == 6 || page == 7 || page == 9 || page == 10 || page == 11;
        if (z) {
            if (page == 0) {
                this.checkPermissions = true;
                this.checkShowPermissions = true;
            }
            this.currentDoneType = 1;
            showDoneButton(false, animated);
            this.currentDoneType = 0;
            showEditDoneProgress(false, false);
            if (!animated) {
                showDoneButton(true, false);
            }
        } else {
            this.currentDoneType = 0;
            showDoneButton(false, animated);
            if (page != 8) {
                this.currentDoneType = 1;
            }
        }
        int i = this.currentViewNum;
        boolean z2 = i != page;
        int i2 = R.drawable.ic_ab_back;
        if (z2) {
            SlideView[] slideViewArr = this.views;
            final SlideView slideView = slideViewArr[i];
            SlideView slideView2 = slideViewArr[page];
            this.currentViewNum = page;
            ActionBar actionBar = this.actionBar;
            if (!slideView2.needBackButton() && !this.newAccount) {
                i2 = 0;
            }
            actionBar.setBackButtonImage(i2);
            slideView2.setParams(params, false);
            this.actionBar.setTitle(slideView2.getHeaderName());
            setParentActivityTitle(slideView2.getHeaderName());
            slideView2.onShow();
            int i3 = AndroidUtilities.displaySize.x;
            if (back) {
                i3 = -i3;
            }
            slideView2.setX(i3);
            slideView2.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.LoginActivity.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (LoginActivity.this.currentDoneType == 0 && z) {
                        LoginActivity.this.showDoneButton(true, true);
                    }
                    slideView.setVisibility(8);
                    slideView.setX(0.0f);
                }
            });
            Animator[] animatorArr = new Animator[2];
            Property property = View.TRANSLATION_X;
            float[] fArr = new float[1];
            fArr[0] = back ? AndroidUtilities.displaySize.x : -AndroidUtilities.displaySize.x;
            animatorArr[0] = ObjectAnimator.ofFloat(slideView, (Property<SlideView, Float>) property, fArr);
            animatorArr[1] = ObjectAnimator.ofFloat(slideView2, (Property<SlideView, Float>) View.TRANSLATION_X, 0.0f);
            animatorSet.playTogether(animatorArr);
            animatorSet.setDuration(300L);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.start();
            return;
        }
        ActionBar actionBar2 = this.actionBar;
        if (!this.views[page].needBackButton() && !this.newAccount) {
            i2 = 0;
        }
        actionBar2.setBackButtonImage(i2);
        this.views[this.currentViewNum].setVisibility(8);
        this.currentViewNum = page;
        this.views[page].setParams(params, false);
        this.views[page].setVisibility(0);
        this.actionBar.setTitle(this.views[page].getHeaderName());
        setParentActivityTitle(this.views[page].getHeaderName());
        this.views[page].onShow();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle outState) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("currentViewNum", this.currentViewNum);
            bundle.putInt("syncContacts", this.syncContacts ? 1 : 0);
            for (int i = 0; i <= this.currentViewNum; i++) {
                SlideView slideView = this.views[i];
                if (slideView != null) {
                    slideView.saveStateParams(bundle);
                }
            }
            SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("logininfo2", 0).edit();
            editorEdit.clear();
            putBundleToEditor(bundle, editorEdit, null);
            editorEdit.commit();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void needFinishActivity(boolean afterSignup) {
        clearCurrentState();
        if (getParentActivity() instanceof LaunchActivity) {
            if (this.newAccount) {
                this.newAccount = false;
                ((LaunchActivity) getParentActivity()).switchToAccount(this.currentAccount, false);
                finishFragment();
                return;
            } else {
                Bundle bundle = new Bundle();
                bundle.putBoolean("afterSignup", afterSignup);
                presentFragment(new DialogsActivity(bundle), true);
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
                return;
            }
        }
        if (getParentActivity() instanceof ExternalActionActivity) {
            ((ExternalActionActivity) getParentActivity()).onFinishLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAuthSuccess(TLRPC$TL_auth_authorization res) throws InterruptedException {
        onAuthSuccess(res, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAuthSuccess(TLRPC$TL_auth_authorization res, boolean afterSignup) throws InterruptedException {
        ConnectionsManager.getInstance(this.currentAccount).setUserId(res.user.id);
        UserConfig.getInstance(this.currentAccount).clearConfig();
        MessagesController.getInstance(this.currentAccount).cleanup();
        UserConfig.getInstance(this.currentAccount).syncContacts = this.syncContacts;
        UserConfig.getInstance(this.currentAccount).setCurrentUser(res.user);
        UserConfig.getInstance(this.currentAccount).setMxbState(res.user.MXB_REGISTERED_USER);
        UserConfig.getInstance(this.currentAccount).saveConfig(true);
        MessagesStorage.getInstance(this.currentAccount).cleanup(true);
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        arrayList.add(res.user);
        MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(arrayList, null, true, true);
        MessagesController.getInstance(this.currentAccount).putUser(res.user, false);
        ContactsController.getInstance(this.currentAccount).checkAppAccount();
        MessagesController.getInstance(this.currentAccount).checkPromoInfo(true);
        MessagesController.getInstance(this.currentAccount).sendDeviceUserIds();
        ConnectionsManager.getInstance(this.currentAccount).updateDcSettings();
        needFinishActivity(afterSignup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillNextCodeParams(Bundle params, TLRPC$TL_auth_sentCode res) {
        params.putString("phoneHash", res.phone_code_hash);
        if (res.timeout == 0) {
            res.timeout = 60;
        }
        params.putInt("timeout", res.timeout * 1000);
        params.putInt("length", res.type.length);
        params.putString("pattern", res.type.pattern);
        params.putString("message", res.message);
        TLRPC$auth_CodeType tLRPC$auth_CodeType = res.next_type;
        if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeCall) {
            params.putInt("nextType", 4);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeFlashCall) {
            params.putInt("nextType", 3);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeSms) {
            params.putInt("nextType", 2);
        }
        TLRPC$auth_SentCodeType tLRPC$auth_SentCodeType = res.type;
        if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeApp) {
            params.putInt("type", 1);
            setPage(1, true, params, false);
            return;
        }
        if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeCall) {
            params.putInt("type", 4);
            setPage(4, true, params, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeFlashCall) {
            params.putInt("type", 3);
            setPage(3, true, params, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeSms) {
            params.putInt("type", 2);
            setPage(2, true, params, false);
        }
    }

    public class PhoneView extends SlideView implements AdapterView.OnItemSelectedListener {
        private CheckBoxCell checkBoxCell;
        private EditTextBoldCursor codeField;
        private HashMap<String, CountrySelectActivity.Country> codesMap;
        private ArrayList<CountrySelectActivity.Country> countriesArray;
        private TextView countryButton;
        private int countryState;
        private boolean ignoreOnPhoneChange;
        private boolean ignoreOnTextChange;
        private boolean ignoreSelection;
        private boolean nextPressed;
        private boolean numberFilled;
        private HintEditText phoneField;
        private HashMap<String, String> phoneFormatMap;
        private CheckBoxCell testBackendCheckBox;
        private TextView textView;
        private TextView textView2;
        private View view;

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        public PhoneView(Context context) throws IOException {
            super(context);
            this.countryState = 0;
            this.countriesArray = new ArrayList<>();
            this.codesMap = new HashMap<>();
            this.phoneFormatMap = new HashMap<>();
            this.ignoreSelection = false;
            this.ignoreOnTextChange = false;
            this.ignoreOnPhoneChange = false;
            this.nextPressed = false;
            setOrientation(1);
            TextView textView = new TextView(context);
            this.countryButton = textView;
            textView.setTextSize(1, 18.0f);
            this.countryButton.setTypeface(AndroidUtilities.getFontFamily(false));
            this.countryButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
            this.countryButton.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.countryButton.setMaxLines(1);
            this.countryButton.setSingleLine(true);
            this.countryButton.setEllipsize(TextUtils.TruncateAt.END);
            this.countryButton.setGravity((LocaleController.isRTL ? 5 : 3) | 1);
            this.countryButton.setBackground(Theme.createSelectorDrawable(Theme.getColor("listSelectorSDK21"), 7));
            addView(this.countryButton, LayoutHelper.createLinear(-1, 36, 0.0f, 0.0f, 0.0f, 14.0f));
            this.countryButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$6pgNvaezEqte4pQ2OLNWtF4ukWs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$2$LoginActivity$PhoneView(view);
                }
            });
            View view = new View(context);
            this.view = view;
            view.setPadding(AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(12.0f), 0);
            this.view.setBackgroundColor(Theme.getColor("windowBackgroundWhiteGrayLine"));
            addView(this.view, LayoutHelper.createLinear(-1, 1, 4.0f, -17.5f, 4.0f, 0.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            addView(linearLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 20.0f, 0.0f, 0.0f));
            TextView textView2 = new TextView(context);
            this.textView = textView2;
            textView2.setText("+");
            this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.textView.setTextSize(1, 18.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            linearLayout.addView(this.textView, LayoutHelper.createLinear(-2, -2));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.codeField = editTextBoldCursor;
            editTextBoldCursor.setInputType(3);
            this.codeField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.codeField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.codeField.setCursorWidth(1.5f);
            this.codeField.setPadding(AndroidUtilities.dp(10.0f), 0, 0, 0);
            this.codeField.setTextSize(1, 18.0f);
            this.codeField.setTypeface(AndroidUtilities.getFontFamily(false));
            this.codeField.setMaxLines(1);
            this.codeField.setGravity(19);
            this.codeField.setImeOptions(268435461);
            this.codeField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
            linearLayout.addView(this.codeField, LayoutHelper.createLinear(55, 36, -9.0f, 0.0f, 16.0f, 0.0f));
            this.codeField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.LoginActivity.PhoneView.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String str;
                    boolean z;
                    if (PhoneView.this.ignoreOnTextChange) {
                        return;
                    }
                    PhoneView.this.ignoreOnTextChange = true;
                    String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(PhoneView.this.codeField.getText().toString());
                    PhoneView.this.codeField.setText(strStripExceptNumbers);
                    if (strStripExceptNumbers.length() == 0) {
                        PhoneView.this.countryButton.setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                        PhoneView.this.phoneField.setHintText((String) null);
                        PhoneView.this.countryState = 1;
                    } else {
                        int i = 4;
                        if (strStripExceptNumbers.length() > 4) {
                            while (true) {
                                if (i < 1) {
                                    str = null;
                                    z = false;
                                    break;
                                }
                                String strSubstring = strStripExceptNumbers.substring(0, i);
                                if (((CountrySelectActivity.Country) PhoneView.this.codesMap.get(strSubstring)) != null) {
                                    String str2 = strStripExceptNumbers.substring(i) + PhoneView.this.phoneField.getText().toString();
                                    PhoneView.this.codeField.setText(strSubstring);
                                    z = true;
                                    str = str2;
                                    strStripExceptNumbers = strSubstring;
                                    break;
                                }
                                i--;
                            }
                            if (!z) {
                                str = strStripExceptNumbers.substring(1) + PhoneView.this.phoneField.getText().toString();
                                EditTextBoldCursor editTextBoldCursor2 = PhoneView.this.codeField;
                                strStripExceptNumbers = strStripExceptNumbers.substring(0, 1);
                                editTextBoldCursor2.setText(strStripExceptNumbers);
                            }
                        } else {
                            str = null;
                            z = false;
                        }
                        CountrySelectActivity.Country country = (CountrySelectActivity.Country) PhoneView.this.codesMap.get(strStripExceptNumbers);
                        if (country != null) {
                            PhoneView.this.ignoreSelection = true;
                            PhoneView.this.countryButton.setText(country.name);
                            String str3 = (String) PhoneView.this.phoneFormatMap.get(strStripExceptNumbers);
                            PhoneView.this.phoneField.setHintText(str3 != null ? str3.replace('X', (char) 8211) : null);
                            PhoneView.this.countryState = 0;
                        } else {
                            PhoneView.this.countryButton.setText(LocaleController.getString("WrongCountry", R.string.WrongCountry));
                            PhoneView.this.phoneField.setHintText((String) null);
                            PhoneView.this.countryState = 2;
                        }
                        if (!z) {
                            PhoneView.this.codeField.setSelection(PhoneView.this.codeField.getText().length());
                        }
                        if (str != null) {
                            PhoneView.this.phoneField.requestFocus();
                            PhoneView.this.phoneField.setText(str);
                            PhoneView.this.phoneField.setSelection(PhoneView.this.phoneField.length());
                        }
                    }
                    PhoneView.this.ignoreOnTextChange = false;
                }
            });
            this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$htAByigqaQD6Vzz1jQNltq4zh0o
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$3$LoginActivity$PhoneView(textView3, i, keyEvent);
                }
            });
            HintEditText hintEditText = new HintEditText(context) { // from class: ir.eitaa.ui.LoginActivity.PhoneView.2
                @Override // android.widget.TextView, android.view.View
                public boolean onTouchEvent(MotionEvent event) {
                    if (event.getAction() == 0 && !AndroidUtilities.showKeyboard(this)) {
                        clearFocus();
                        requestFocus();
                    }
                    return super.onTouchEvent(event);
                }
            };
            this.phoneField = hintEditText;
            hintEditText.setInputType(3);
            this.phoneField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.phoneField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.phoneField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.phoneField.setPadding(0, 0, 0, 0);
            this.phoneField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.phoneField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.phoneField.setCursorWidth(1.5f);
            this.phoneField.setTextSize(1, 18.0f);
            this.phoneField.setTypeface(AndroidUtilities.getFontFamily(false));
            this.phoneField.setMaxLines(1);
            this.phoneField.setGravity(19);
            this.phoneField.setImeOptions(268435461);
            linearLayout.addView(this.phoneField, LayoutHelper.createFrame(-1, 36.0f));
            this.phoneField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.LoginActivity.PhoneView.3
                private int actionPosition;
                private int characterAction = -1;

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (count == 0 && after == 1) {
                        this.characterAction = 1;
                        return;
                    }
                    if (count == 1 && after == 0) {
                        if (s.charAt(start) == ' ' && start > 0) {
                            this.characterAction = 3;
                            this.actionPosition = start - 1;
                            return;
                        } else {
                            this.characterAction = 2;
                            return;
                        }
                    }
                    this.characterAction = -1;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    int i;
                    int i2;
                    if (PhoneView.this.ignoreOnPhoneChange) {
                        return;
                    }
                    int selectionStart = PhoneView.this.phoneField.getSelectionStart();
                    String string = PhoneView.this.phoneField.getText().toString();
                    if (this.characterAction == 3) {
                        string = string.substring(0, this.actionPosition) + string.substring(this.actionPosition + 1);
                        selectionStart--;
                    }
                    StringBuilder sb = new StringBuilder(string.length());
                    int i3 = 0;
                    while (i3 < string.length()) {
                        int i4 = i3 + 1;
                        String strSubstring = string.substring(i3, i4);
                        if ("0123456789".contains(strSubstring)) {
                            sb.append(strSubstring);
                        }
                        i3 = i4;
                    }
                    PhoneView.this.ignoreOnPhoneChange = true;
                    String hintText = PhoneView.this.phoneField.getHintText();
                    if (hintText != null) {
                        int i5 = 0;
                        while (true) {
                            if (i5 >= sb.length()) {
                                break;
                            }
                            if (i5 < hintText.length()) {
                                if (hintText.charAt(i5) == ' ') {
                                    sb.insert(i5, ' ');
                                    i5++;
                                    if (selectionStart == i5 && (i2 = this.characterAction) != 2 && i2 != 3) {
                                        selectionStart++;
                                    }
                                }
                                i5++;
                            } else {
                                sb.insert(i5, ' ');
                                if (selectionStart == i5 + 1 && (i = this.characterAction) != 2 && i != 3) {
                                    selectionStart++;
                                }
                            }
                        }
                    }
                    s.replace(0, s.length(), sb);
                    if (selectionStart >= 0) {
                        PhoneView.this.phoneField.setSelection(Math.min(selectionStart, PhoneView.this.phoneField.length()));
                    }
                    PhoneView.this.phoneField.onTextChange();
                    PhoneView.this.ignoreOnPhoneChange = false;
                }
            });
            this.phoneField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$_FXC5rcgh8grV2PUv8gpB25l6M4
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$4$LoginActivity$PhoneView(textView3, i, keyEvent);
                }
            });
            this.phoneField.setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$-_7xHzx6t2K493u3cx4u8zKXMuA
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view2, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$5$LoginActivity$PhoneView(view2, i, keyEvent);
                }
            });
            TextView textView3 = new TextView(context);
            this.textView2 = textView3;
            textView3.setText(LocaleController.getString("StartText", R.string.StartText));
            this.textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.textView2.setTextSize(1, 14.0f);
            this.textView2.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView2.setGravity(LocaleController.isRTL ? 5 : 3);
            this.textView2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.textView2, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 0, 28, 0, 10));
            if (LoginActivity.this.newAccount) {
                CheckBoxCell checkBoxCell = new CheckBoxCell(context, 2);
                this.checkBoxCell = checkBoxCell;
                checkBoxCell.setText(LocaleController.getString("SyncContacts", R.string.SyncContacts), "", LoginActivity.this.syncContacts, false);
                addView(this.checkBoxCell, LayoutHelper.createLinear(-2, -1, 51, 0, 0, 0, 0));
                this.checkBoxCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.LoginActivity.PhoneView.4
                    private Toast visibleToast;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        if (LoginActivity.this.getParentActivity() == null) {
                            return;
                        }
                        LoginActivity.this.syncContacts = !r0.syncContacts;
                        ((CheckBoxCell) v).setChecked(LoginActivity.this.syncContacts, true);
                        try {
                            Toast toast = this.visibleToast;
                            if (toast != null) {
                                toast.cancel();
                            }
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                        if (LoginActivity.this.syncContacts) {
                            BulletinFactory.of((FrameLayout) ((BaseFragment) LoginActivity.this).fragmentView, null).createSimpleBulletin(R.raw.contacts_sync_on, LocaleController.getString("SyncContactsOn", R.string.SyncContactsOn)).show();
                        } else {
                            BulletinFactory.of((FrameLayout) ((BaseFragment) LoginActivity.this).fragmentView, null).createSimpleBulletin(R.raw.contacts_sync_off, LocaleController.getString("SyncContactsOff", R.string.SyncContactsOff)).show();
                        }
                    }
                });
            }
            if (BuildVars.DEBUG_PRIVATE_VERSION) {
                CheckBoxCell checkBoxCell2 = new CheckBoxCell(context, 2);
                this.testBackendCheckBox = checkBoxCell2;
                checkBoxCell2.setText("Test Backend", "", LoginActivity.this.testBackend, false);
                addView(this.testBackendCheckBox, LayoutHelper.createLinear(-2, -1, 51, 0, 0, 0, 0));
                this.testBackendCheckBox.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$pH6HIt_gKUEzf7PNK7xjzmp8Pxs
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.lambda$new$6$LoginActivity$PhoneView(view2);
                    }
                });
            }
            final HashMap map = new HashMap();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("countries.txt")));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.split(";");
                    CountrySelectActivity.Country country = new CountrySelectActivity.Country();
                    country.name = strArrSplit[2];
                    country.code = strArrSplit[0];
                    country.shortname = strArrSplit[1];
                    this.countriesArray.add(0, country);
                    this.codesMap.put(strArrSplit[0], country);
                    if (strArrSplit.length > 3) {
                        this.phoneFormatMap.put(strArrSplit[0], strArrSplit[3]);
                    }
                    map.put(strArrSplit[1], strArrSplit[2]);
                }
                bufferedReader.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
            Collections.sort(this.countriesArray, Comparator.CC.comparing(new Function() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$D0aEx7gHvA8XlB2WJdsta-fBobY
                @Override // j$.util.function.Function
                public /* synthetic */ Function andThen(Function function) {
                    return Function.CC.$default$andThen(this, function);
                }

                @Override // j$.util.function.Function
                public final Object apply(Object obj) {
                    return ((CountrySelectActivity.Country) obj).name;
                }

                @Override // j$.util.function.Function
                public /* synthetic */ Function compose(Function function) {
                    return Function.CC.$default$compose(this, function);
                }
            }));
            try {
            } catch (Exception e2) {
                FileLog.e(e2);
            }
            LoginActivity.this.getAccountInstance().getConnectionsManager().sendRequest(new TLObject() { // from class: ir.eitaa.tgnet.TLRPC$TL_help_getNearestDc
                public static int constructor = 531836966;

                @Override // ir.eitaa.tgnet.TLObject
                public TLObject deserializeResponse(AbstractSerializedData stream, int constructor2, boolean exception) {
                    return TLRPC$TL_nearestDc.TLdeserialize(stream, constructor2, exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                }
            }, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$e7j9Lv7Lt4ws9WU6-AcCsIU8AUw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$9$LoginActivity$PhoneView(map, tLObject, tLRPC$TL_error);
                }
            }, 10);
            if (this.codeField.length() == 0) {
                this.countryButton.setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                this.phoneField.setHintText((String) null);
                this.countryState = 1;
            }
            if (this.codeField.length() != 0) {
                this.phoneField.requestFocus();
                HintEditText hintEditText2 = this.phoneField;
                hintEditText2.setSelection(hintEditText2.length());
            } else {
                this.codeField.requestFocus();
            }
            TLRPC$TL_help_getCountriesList tLRPC$TL_help_getCountriesList = new TLRPC$TL_help_getCountriesList();
            tLRPC$TL_help_getCountriesList.lang_code = "";
            LoginActivity.this.getConnectionsManager().sendRequest(tLRPC$TL_help_getCountriesList, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$yEuVDq7deBPbFXEEoO0ohdUaQFU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$11$LoginActivity$PhoneView(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$LoginActivity$PhoneView(View view) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(true, this.countriesArray);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$hkvRzPv8joOiYkQZLUr98xk2VvI
                @Override // ir.eitaa.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(CountrySelectActivity.Country country) {
                    this.f$0.lambda$new$1$LoginActivity$PhoneView(country);
                }
            });
            LoginActivity.this.presentFragment(countrySelectActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$LoginActivity$PhoneView(CountrySelectActivity.Country country) {
            selectCountry(country);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$wG-Va_iaQSq-1m20z6dyIYrQFDY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$LoginActivity$PhoneView();
                }
            }, 300L);
            this.phoneField.requestFocus();
            HintEditText hintEditText = this.phoneField;
            hintEditText.setSelection(hintEditText.length());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$LoginActivity$PhoneView() {
            AndroidUtilities.showKeyboard(this.phoneField);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$3$LoginActivity$PhoneView(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            this.phoneField.requestFocus();
            HintEditText hintEditText = this.phoneField;
            hintEditText.setSelection(hintEditText.length());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$4$LoginActivity$PhoneView(TextView textView, int i, KeyEvent keyEvent) throws IOException {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$5$LoginActivity$PhoneView(View view, int i, KeyEvent keyEvent) {
            if (i != 67 || this.phoneField.length() != 0) {
                return false;
            }
            this.codeField.requestFocus();
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            editTextBoldCursor.setSelection(editTextBoldCursor.length());
            this.codeField.dispatchKeyEvent(keyEvent);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$6$LoginActivity$PhoneView(View view) {
            if (LoginActivity.this.getParentActivity() == null) {
                return;
            }
            LoginActivity.this.testBackend = !r0.testBackend;
            ((CheckBoxCell) view).setChecked(LoginActivity.this.testBackend, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$9$LoginActivity$PhoneView(final HashMap map, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$Wffytg8eeTAlFF5iHGHpdXi3wTY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$8$LoginActivity$PhoneView(tLObject, map);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$8$LoginActivity$PhoneView(TLObject tLObject, HashMap map) {
            if (tLObject == null) {
                return;
            }
            TLRPC$TL_nearestDc tLRPC$TL_nearestDc = (TLRPC$TL_nearestDc) tLObject;
            if (this.codeField.length() == 0) {
                setCountry(map, tLRPC$TL_nearestDc.country.toUpperCase());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$11, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$11$LoginActivity$PhoneView(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$6LJQ0DpvcHuLLks90641ci4uYE8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$10$LoginActivity$PhoneView(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$10, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$10$LoginActivity$PhoneView(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
            if (tLRPC$TL_error == null) {
                this.countriesArray.clear();
                this.codesMap.clear();
                this.phoneFormatMap.clear();
                TLRPC$TL_help_countriesList tLRPC$TL_help_countriesList = (TLRPC$TL_help_countriesList) tLObject;
                for (int i = 0; i < tLRPC$TL_help_countriesList.countries.size(); i++) {
                    TLRPC$TL_help_country tLRPC$TL_help_country = tLRPC$TL_help_countriesList.countries.get(i);
                    for (int i2 = 0; i2 < tLRPC$TL_help_country.country_codes.size(); i2++) {
                        CountrySelectActivity.Country country = new CountrySelectActivity.Country();
                        country.name = tLRPC$TL_help_country.default_name;
                        country.code = tLRPC$TL_help_country.country_codes.get(i2).country_code;
                        this.countriesArray.add(country);
                        this.codesMap.put(tLRPC$TL_help_country.country_codes.get(i2).country_code, country);
                        if (tLRPC$TL_help_country.country_codes.get(i2).patterns.size() > 0) {
                            this.phoneFormatMap.put(tLRPC$TL_help_country.country_codes.get(i2).country_code, tLRPC$TL_help_country.country_codes.get(i2).patterns.get(0));
                        }
                    }
                }
            }
        }

        public void selectCountry(CountrySelectActivity.Country country) {
            this.ignoreOnTextChange = true;
            String str = country.code;
            this.codeField.setText(str);
            this.countryButton.setText(country.name);
            String str2 = this.phoneFormatMap.get(str);
            this.phoneField.setHintText(str2 != null ? str2.replace('X', (char) 8211) : null);
            this.countryState = 0;
            this.ignoreOnTextChange = false;
        }

        private void setCountry(HashMap<String, String> languageMap, String country) {
            if (languageMap.get(country) == null || this.countriesArray == null) {
                return;
            }
            CountrySelectActivity.Country country2 = null;
            int i = 0;
            while (true) {
                if (i < this.countriesArray.size()) {
                    if (this.countriesArray.get(i) != null && this.countriesArray.get(i).name.equals(country)) {
                        country2 = this.countriesArray.get(i);
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            if (country2 != null) {
                this.codeField.setText(country2.code);
                this.countryState = 0;
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            if (this.ignoreSelection) {
                this.ignoreSelection = false;
                return;
            }
            this.ignoreOnTextChange = true;
            this.codeField.setText(this.countriesArray.get(i).code);
            this.ignoreOnTextChange = false;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() throws IOException {
            String str;
            if (LoginActivity.this.getParentActivity() == null || this.nextPressed) {
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            if (BuildVars.DEBUG_VERSION) {
                FileLog.d("sim status = " + telephonyManager.getSimState());
            }
            int simState = telephonyManager.getSimState();
            boolean z = (simState == 1 || simState == 0 || telephonyManager.getPhoneType() == 0 || AndroidUtilities.isAirplaneModeOn()) ? false : true;
            int i = this.countryState;
            if (i == 1) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                return;
            }
            if (i == 2 && !BuildVars.DEBUG_VERSION) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("WrongCountry", R.string.WrongCountry));
                return;
            }
            if (this.codeField.length() == 0) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                return;
            }
            if (this.phoneField.length() == 0) {
                LoginActivity.this.onFieldError(this.phoneField);
                return;
            }
            String strStripExceptNumbers = PhoneFormat.stripExceptNumbers("" + ((Object) this.codeField.getText()) + ((Object) this.phoneField.getText()));
            boolean z2 = BuildVars.DEBUG_PRIVATE_VERSION && LoginActivity.this.getConnectionsManager().isTestBackend();
            if (z2 != LoginActivity.this.testBackend) {
                LoginActivity.this.getConnectionsManager().switchBackend(false);
                z2 = LoginActivity.this.testBackend;
            }
            if (LoginActivity.this.getParentActivity() instanceof LaunchActivity) {
                for (final int i2 = 0; i2 < 3; i2++) {
                    UserConfig userConfig = UserConfig.getInstance(i2);
                    if (userConfig.isClientActivated() && (str = userConfig.getCurrentUser().phone) != null && PhoneNumberUtils.compare(strStripExceptNumbers, str) && ConnectionsManager.getInstance(i2).isTestBackend() == z2) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
                        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        builder.setMessage(LocaleController.getString("AccountAlreadyLoggedIn", R.string.AccountAlreadyLoggedIn));
                        builder.setPositiveButton(LocaleController.getString("AccountSwitch", R.string.AccountSwitch), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$-NiJiLV2bH0W7kI8YtFT9eBXlQg
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                this.f$0.lambda$onNextPressed$12$LoginActivity$PhoneView(i2, dialogInterface, i3);
                            }
                        });
                        builder.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                        LoginActivity.this.showDialog(builder.create());
                        return;
                    }
                }
            }
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).cleanup(false);
            final TLRPC$TL_auth_sendCode tLRPC$TL_auth_sendCode = new TLRPC$TL_auth_sendCode();
            tLRPC$TL_auth_sendCode.api_hash = BuildVars.APP_HASH;
            tLRPC$TL_auth_sendCode.api_id = BuildVars.APP_ID;
            tLRPC$TL_auth_sendCode.phone_number = strStripExceptNumbers;
            TLRPC$TL_codeSettings tLRPC$TL_codeSettings = new TLRPC$TL_codeSettings();
            tLRPC$TL_auth_sendCode.settings = tLRPC$TL_codeSettings;
            tLRPC$TL_codeSettings.allow_flashcall = z;
            tLRPC$TL_codeSettings.allow_app_hash = ApplicationLoader.hasPlayServices;
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
            if (tLRPC$TL_auth_sendCode.settings.allow_app_hash) {
                sharedPreferences.edit().putString("sms_hash", BuildVars.SMS_HASH).commit();
            } else {
                sharedPreferences.edit().remove("sms_hash").commit();
            }
            if (tLRPC$TL_auth_sendCode.settings.allow_flashcall) {
                try {
                    String line1Number = telephonyManager.getLine1Number();
                    if (!TextUtils.isEmpty(line1Number)) {
                        tLRPC$TL_auth_sendCode.settings.current_number = PhoneNumberUtils.compare(strStripExceptNumbers, line1Number);
                        TLRPC$TL_codeSettings tLRPC$TL_codeSettings2 = tLRPC$TL_auth_sendCode.settings;
                        if (!tLRPC$TL_codeSettings2.current_number) {
                            tLRPC$TL_codeSettings2.allow_flashcall = false;
                        }
                    } else if (UserConfig.getActivatedAccountsCount() > 0) {
                        tLRPC$TL_auth_sendCode.settings.allow_flashcall = false;
                    } else {
                        tLRPC$TL_auth_sendCode.settings.current_number = false;
                    }
                } catch (Exception e) {
                    tLRPC$TL_auth_sendCode.settings.allow_flashcall = false;
                    FileLog.e(e);
                }
            }
            final Bundle bundle = new Bundle();
            bundle.putString("phone", "+" + ((Object) this.codeField.getText()) + " " + ((Object) this.phoneField.getText()));
            try {
                bundle.putString("ephone", "+" + PhoneFormat.stripExceptNumbers(this.codeField.getText().toString()) + " " + PhoneFormat.stripExceptNumbers(this.phoneField.getText().toString()));
            } catch (Exception e2) {
                FileLog.e(e2);
                bundle.putString("ephone", "+" + strStripExceptNumbers);
            }
            bundle.putString("phoneFormated", strStripExceptNumbers);
            this.nextPressed = true;
            LoginActivity.this.needShowProgress(ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_sendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$cQlq9Y9m_jXqd9bUwfLdrrorNFc
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$14$LoginActivity$PhoneView(bundle, tLRPC$TL_auth_sendCode, tLObject, tLRPC$TL_error);
                }
            }, 27));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$12, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$12$LoginActivity$PhoneView(int i, DialogInterface dialogInterface, int i2) {
            if (UserConfig.selectedAccount != i) {
                ((LaunchActivity) LoginActivity.this.getParentActivity()).switchToAccount(i, false);
            }
            LoginActivity.this.finishFragment();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$14, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$14$LoginActivity$PhoneView(final Bundle bundle, final TLRPC$TL_auth_sendCode tLRPC$TL_auth_sendCode, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$zLMi-luaFm4iL-IsMHFBVQkhVxQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$13$LoginActivity$PhoneView(tLRPC$TL_error, bundle, tLObject, tLRPC$TL_auth_sendCode);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$13, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$13$LoginActivity$PhoneView(TLRPC$TL_error tLRPC$TL_error, Bundle bundle, TLObject tLObject, TLRPC$TL_auth_sendCode tLRPC$TL_auth_sendCode) {
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                LoginActivity.this.fillNextCodeParams(bundle, (TLRPC$TL_auth_sentCode) tLObject);
            } else {
                String str = tLRPC$TL_error.text;
                if (str != null) {
                    if (str.contains("PHONE_NUMBER_INVALID")) {
                        LoginActivity.needShowInvalidAlert(LoginActivity.this, tLRPC$TL_auth_sendCode.phone_number, false);
                    } else if (tLRPC$TL_error.text.contains("PHONE_PASSWORD_FLOOD")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("FloodWait", R.string.FloodWait));
                    } else if (tLRPC$TL_error.text.contains("PHONE_NUMBER_FLOOD")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("PhoneNumberFlood", R.string.PhoneNumberFlood));
                    } else if (tLRPC$TL_error.text.contains("PHONE_NUMBER_BANNED")) {
                        LoginActivity.needShowInvalidAlert(LoginActivity.this, tLRPC$TL_auth_sendCode.phone_number, true);
                    } else if (tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") || tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
                    } else if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired));
                    } else if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("FloodWait", R.string.FloodWait));
                    } else if (tLRPC$TL_error.code != -1000) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                    }
                }
            }
            LoginActivity.this.needHideProgress(false);
        }

        public void fillNumber() {
            boolean z;
            boolean z2;
            if (this.numberFilled) {
                return;
            }
            try {
                this.codeField.setText("98");
                this.countryButton.setText("Iran");
                TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
                if (telephonyManager.getSimState() == 1 || telephonyManager.getPhoneType() == 0) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    z = LoginActivity.this.getParentActivity().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                    if (LoginActivity.this.checkShowPermissions && !z) {
                        LoginActivity.this.permissionsShowItems.clear();
                        if (!z) {
                            LoginActivity.this.permissionsShowItems.add("android.permission.READ_PHONE_STATE");
                        }
                        if (LoginActivity.this.permissionsShowItems.isEmpty()) {
                            return;
                        }
                        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                        if (!globalMainSettings.getBoolean("firstloginshow", true) && !LoginActivity.this.getParentActivity().shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE")) {
                            LoginActivity.this.getParentActivity().requestPermissions((String[]) LoginActivity.this.permissionsShowItems.toArray(new String[0]), 7);
                            return;
                        }
                        globalMainSettings.edit().putBoolean("firstloginshow", false).commit();
                        LoginActivity.this.needRequestPermissions = true;
                        return;
                    }
                } else {
                    z = true;
                }
                this.numberFilled = true;
                if (LoginActivity.this.newAccount || !z) {
                    return;
                }
                String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(telephonyManager.getLine1Number());
                String strSubstring = null;
                if (TextUtils.isEmpty(strStripExceptNumbers)) {
                    return;
                }
                int i = 4;
                if (strStripExceptNumbers.length() > 4) {
                    while (true) {
                        if (i < 1) {
                            z2 = false;
                            break;
                        }
                        String strSubstring2 = strStripExceptNumbers.substring(0, i);
                        if (this.codesMap.get(strSubstring2) != null) {
                            strSubstring = strStripExceptNumbers.substring(i);
                            this.codeField.setText(strSubstring2);
                            z2 = true;
                            break;
                        }
                        i--;
                    }
                    if (!z2) {
                        strSubstring = strStripExceptNumbers.substring(1);
                        this.codeField.setText(strStripExceptNumbers.substring(0, 1));
                    }
                }
                if (strSubstring != null) {
                    this.phoneField.requestFocus();
                    this.phoneField.setText(strSubstring);
                    HintEditText hintEditText = this.phoneField;
                    hintEditText.setSelection(hintEditText.length());
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            fillNumber();
            CheckBoxCell checkBoxCell = this.checkBoxCell;
            if (checkBoxCell != null) {
                checkBoxCell.setChecked(LoginActivity.this.syncContacts, false);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$PhoneView$edn0MzCrqhgqxMzf9p3CDat2SGA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$15$LoginActivity$PhoneView();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onShow$15, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onShow$15$LoginActivity$PhoneView() {
            if (this.phoneField != null) {
                if (LoginActivity.this.needRequestPermissions) {
                    this.codeField.clearFocus();
                    this.phoneField.clearFocus();
                } else {
                    if (this.codeField.length() != 0) {
                        this.phoneField.requestFocus();
                        HintEditText hintEditText = this.phoneField;
                        hintEditText.setSelection(hintEditText.length());
                        AndroidUtilities.showKeyboard(this.phoneField);
                        return;
                    }
                    this.codeField.requestFocus();
                    AndroidUtilities.showKeyboard(this.codeField);
                }
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("YourPhone", R.string.YourPhone);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            String string = this.codeField.getText().toString();
            if (string.length() != 0) {
                bundle.putString("phoneview_code", string);
            }
            String string2 = this.phoneField.getText().toString();
            if (string2.length() != 0) {
                bundle.putString("phoneview_phone", string2);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            String string = bundle.getString("phoneview_code");
            if (string != null) {
                this.codeField.setText(string);
            }
            String string2 = bundle.getString("phoneview_phone");
            if (string2 != null) {
                this.phoneField.setText(string2);
            }
        }
    }

    public class LoginActivitySmsView extends SlideView implements NotificationCenter.NotificationCenterDelegate {
        private ImageView blackImageView;
        private RLottieImageView blueImageView;
        private String catchedPhone;
        private EditTextBoldCursor[] codeField;
        private LinearLayout codeFieldContainer;
        private int codeTime;
        private Timer codeTimer;
        private TextView confirmTextView;
        private Bundle currentParams;
        private int currentType;
        private String emailPhone;
        RLottieDrawable hintDrawable;
        private boolean ignoreOnTextChange;
        private double lastCodeTime;
        private double lastCurrentTime;
        private String lastError;
        private int length;
        private String message;
        private boolean nextPressed;
        private int nextType;
        private int openTime;
        private String pattern;
        private String phone;
        private String phoneHash;
        private TextView problemText;
        private ProgressView progressView;
        private String requestPhone;
        private Timer smsCodeTimer;
        private int time;
        private TextView timeText;
        private Timer timeTimer;
        private final Object timerSync;
        private TextView titleTextView;
        private boolean waitingForEvent;

        static /* synthetic */ void lambda$onBackPressed$12(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        static /* synthetic */ int access$4726(LoginActivitySmsView loginActivitySmsView, double d) {
            double d2 = loginActivitySmsView.codeTime;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            loginActivitySmsView.codeTime = i;
            return i;
        }

        static /* synthetic */ int access$5326(LoginActivitySmsView loginActivitySmsView, double d) {
            double d2 = loginActivitySmsView.time;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            loginActivitySmsView.time = i;
            return i;
        }

        public LoginActivitySmsView(Context context, final int type) {
            super(context);
            this.timerSync = new Object();
            this.time = 60000;
            this.codeTime = 15000;
            this.lastError = "";
            this.pattern = "*";
            this.currentType = type;
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            TextView textView2 = new TextView(context);
            this.titleTextView = textView2;
            textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.titleTextView.setTextSize(1, 18.0f);
            this.titleTextView.setTypeface(AndroidUtilities.getFontFamily(true));
            this.titleTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.titleTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.titleTextView.setGravity(49);
            if (this.currentType == 3) {
                this.confirmTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
                FrameLayout frameLayout = new FrameLayout(context);
                addView(frameLayout, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.phone_activate);
                boolean z = LocaleController.isRTL;
                if (z) {
                    frameLayout.addView(imageView, LayoutHelper.createFrame(64, 76.0f, 19, 2.0f, 2.0f, 0.0f, 0.0f));
                    frameLayout.addView(this.confirmTextView, LayoutHelper.createFrame(-1, -2.0f, LocaleController.isRTL ? 5 : 3, 82.0f, 0.0f, 0.0f, 0.0f));
                } else {
                    frameLayout.addView(this.confirmTextView, LayoutHelper.createFrame(-1, -2.0f, z ? 5 : 3, 0.0f, 0.0f, 82.0f, 0.0f));
                    frameLayout.addView(imageView, LayoutHelper.createFrame(64, 76.0f, 21, 0.0f, 2.0f, 0.0f, 2.0f));
                }
            } else {
                this.confirmTextView.setGravity(49);
                FrameLayout frameLayout2 = new FrameLayout(context);
                addView(frameLayout2, LayoutHelper.createLinear(-2, -2, 49));
                if (this.currentType == 1) {
                    ImageView imageView2 = new ImageView(context);
                    this.blackImageView = imageView2;
                    imageView2.setImageResource(R.drawable.sms_devices);
                    this.blackImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteBlackText"), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blackImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    RLottieImageView rLottieImageView = new RLottieImageView(context);
                    this.blueImageView = rLottieImageView;
                    rLottieImageView.setImageResource(R.drawable.sms_bubble);
                    this.blueImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("chats_actionBackground"), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    this.titleTextView.setText(LocaleController.getString("SentAppCodeTitle", R.string.SentAppCodeTitle));
                } else {
                    this.blueImageView = new RLottieImageView(context);
                    RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.sms_incoming_info, "2131624023", AndroidUtilities.dp(64.0f), AndroidUtilities.dp(64.0f), true, (int[]) null);
                    this.hintDrawable = rLottieDrawable;
                    rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor("chats_actionBackground"));
                    this.hintDrawable.setLayerColor("Phone.**", Theme.getColor("chats_actionBackground"));
                    this.blueImageView.setAnimation(this.hintDrawable);
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(64, 64.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    this.titleTextView.setText(LocaleController.getString("SentSmsCodeTitle", R.string.SentSmsCodeTitle));
                }
                addView(this.titleTextView, LayoutHelper.createLinear(-2, -2, 49, 0, 18, 0, 0));
                addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, 49, 0, 17, 0, 0));
            }
            LinearLayout linearLayout = new LinearLayout(context);
            this.codeFieldContainer = linearLayout;
            linearLayout.setOrientation(0);
            addView(this.codeFieldContainer, LayoutHelper.createLinear(-2, 36, 1));
            if (this.currentType == 3) {
                this.codeFieldContainer.setVisibility(8);
            }
            TextView textView3 = new TextView(context) { // from class: ir.eitaa.ui.LoginActivity.LoginActivitySmsView.1
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.timeText = textView3;
            textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.timeText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            if (this.currentType == 3) {
                this.timeText.setTextSize(1, 14.0f);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
                this.progressView = new ProgressView(context);
                this.timeText.setGravity(LocaleController.isRTL ? 5 : 3);
                addView(this.progressView, LayoutHelper.createLinear(-1, 3, 0.0f, 12.0f, 0.0f, 0.0f));
            } else {
                this.timeText.setPadding(0, AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(10.0f));
                this.timeText.setTextSize(1, 15.0f);
                this.timeText.setTypeface(AndroidUtilities.getFontFamily(false));
                this.timeText.setGravity(49);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, 49));
            }
            TextView textView4 = new TextView(context) { // from class: ir.eitaa.ui.LoginActivity.LoginActivitySmsView.2
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.problemText = textView4;
            textView4.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.problemText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.problemText.setPadding(0, AndroidUtilities.dp(32.0f), 0, AndroidUtilities.dp(10.0f));
            this.problemText.setTextSize(1, 15.0f);
            this.problemText.setTypeface(AndroidUtilities.getFontFamily(false));
            this.problemText.setGravity(49);
            if (this.currentType == 1) {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCodeSms", R.string.DidNotGetTheCodeSms));
            } else {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCode", R.string.DidNotGetTheCode));
            }
            addView(this.problemText, LayoutHelper.createLinear(-2, -2, 49, 32, 16, 32, 16));
            this.problemText.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$If3TkEJxjc1zPV1KX1nXyoyGROo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws PackageManager.NameNotFoundException {
                    this.f$0.lambda$new$2$LoginActivity$LoginActivitySmsView(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$LoginActivity$LoginActivitySmsView(View view) throws PackageManager.NameNotFoundException {
            if (this.nextPressed) {
                return;
            }
            int i = this.currentType;
            if (i == 2 && this.nextType == 2) {
                if (this.smsCodeTimer != null) {
                    return;
                }
                createSmsCodeTimer();
                TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
                tLRPC$TL_auth_resendCode.phone_number = this.requestPhone;
                tLRPC$TL_auth_resendCode.phone_code_hash = this.phoneHash;
                ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$EI2YZLSZnL0J6oyuJ_wJYYsjBzU
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$new$1$LoginActivity$LoginActivitySmsView(tLObject, tLRPC$TL_error);
                    }
                }, 10);
                return;
            }
            if (!(this.nextType == 4 && i == 4)) {
                if (LoginActivity.this.doneProgressView.getTag() != null) {
                    return;
                }
                resendCode();
                return;
            }
            try {
                PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
                String str = String.format(Locale.US, "%s (%d)", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"reports@stel.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Android registration/login issue " + str + " " + this.emailPhone);
                intent.putExtra("android.intent.extra.TEXT", "Phone: " + this.requestPhone + "\nApp version: " + str + "\nOS version: SDK " + Build.VERSION.SDK_INT + "\nDevice Name: " + Build.MANUFACTURER + Build.MODEL + "\nLocale: " + Locale.getDefault() + "\nError: " + this.lastError);
                getContext().startActivity(Intent.createChooser(intent, "Send email..."));
            } catch (Exception unused) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("NoMailInstalled", R.string.NoMailInstalled));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$LoginActivity$LoginActivitySmsView(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            if (tLRPC$TL_error == null || tLRPC$TL_error.text == null) {
                return;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$wqgZvelXN6IuwnZDXxaf3czIYT0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$LoginActivity$LoginActivitySmsView(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$LoginActivity$LoginActivitySmsView(TLRPC$TL_error tLRPC$TL_error) {
            this.lastError = tLRPC$TL_error.text;
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            RLottieImageView rLottieImageView;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (this.currentType == 3 || (rLottieImageView = this.blueImageView) == null) {
                return;
            }
            int measuredHeight = rLottieImageView.getMeasuredHeight() + this.titleTextView.getMeasuredHeight() + this.confirmTextView.getMeasuredHeight() + AndroidUtilities.dp(35.0f);
            int iDp = AndroidUtilities.dp(80.0f);
            int iDp2 = AndroidUtilities.dp(291.0f);
            if (LoginActivity.this.scrollHeight - measuredHeight >= iDp) {
                setMeasuredDimension(getMeasuredWidth(), Math.min(LoginActivity.this.scrollHeight, iDp2));
            } else {
                setMeasuredDimension(getMeasuredWidth(), measuredHeight + iDp);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            int i;
            super.onLayout(changed, l, t, r, b);
            if (this.currentType == 3 || this.blueImageView == null) {
                return;
            }
            int bottom = this.confirmTextView.getBottom();
            int measuredHeight = getMeasuredHeight() - bottom;
            if (this.problemText.getVisibility() == 0) {
                int measuredHeight2 = this.problemText.getMeasuredHeight();
                i = (measuredHeight + bottom) - measuredHeight2;
                TextView textView = this.problemText;
                textView.layout(textView.getLeft(), i, this.problemText.getRight(), measuredHeight2 + i);
            } else if (this.timeText.getVisibility() == 0) {
                int measuredHeight3 = this.timeText.getMeasuredHeight();
                i = (measuredHeight + bottom) - measuredHeight3;
                TextView textView2 = this.timeText;
                textView2.layout(textView2.getLeft(), i, this.timeText.getRight(), measuredHeight3 + i);
            } else {
                i = measuredHeight + bottom;
            }
            int measuredHeight4 = this.codeFieldContainer.getMeasuredHeight();
            int i2 = (((i - bottom) - measuredHeight4) / 2) + bottom;
            LinearLayout linearLayout = this.codeFieldContainer;
            linearLayout.layout(linearLayout.getLeft(), i2, this.codeFieldContainer.getRight(), measuredHeight4 + i2);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resendCode() {
            final Bundle bundle = new Bundle();
            bundle.putString("phone", this.phone);
            bundle.putString("ephone", this.emailPhone);
            bundle.putString("phoneFormated", this.requestPhone);
            this.nextPressed = true;
            TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
            tLRPC$TL_auth_resendCode.phone_number = this.requestPhone;
            tLRPC$TL_auth_resendCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$7oHSIOxjsZOpS10Hd4WNmXe0JFg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$resendCode$4$LoginActivity$LoginActivitySmsView(bundle, tLObject, tLRPC$TL_error);
                }
            }, 10);
            LoginActivity.this.needShowProgress(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$4$LoginActivity$LoginActivitySmsView(final Bundle bundle, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$9Zo1exEto_F6ni0qGYyHkX03O9U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resendCode$3$LoginActivity$LoginActivitySmsView(tLRPC$TL_error, bundle, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$3$LoginActivity$LoginActivitySmsView(TLRPC$TL_error tLRPC$TL_error, Bundle bundle, TLObject tLObject) {
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                LoginActivity.this.fillNextCodeParams(bundle, (TLRPC$TL_auth_sentCode) tLObject);
            } else {
                String str = tLRPC$TL_error.text;
                if (str != null) {
                    if (str.contains("PHONE_NUMBER_INVALID")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                    } else if (tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") || tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
                    } else if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                        onBackPressed(true);
                        LoginActivity.this.setPage(0, true, null, true);
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired));
                    } else if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("FloodWait", R.string.FloodWait));
                    } else if (tLRPC$TL_error.code != -1000) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text);
                    }
                }
            }
            LoginActivity.this.needHideProgress(false);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            if (this.currentType == 1) {
                return this.phone;
            }
            return LocaleController.getString("YourCode", R.string.YourCode);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            String string;
            if (params == null) {
                return;
            }
            this.waitingForEvent = true;
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
            }
            this.currentParams = params;
            this.phone = params.getString("phone");
            this.emailPhone = params.getString("ephone");
            this.requestPhone = params.getString("phoneFormated");
            this.phoneHash = params.getString("phoneHash");
            this.time = params.getInt("timeout");
            this.openTime = (int) (System.currentTimeMillis() / 1000);
            this.nextType = params.getInt("nextType");
            this.pattern = params.getString("pattern");
            this.message = params.getString("message");
            int i2 = params.getInt("length");
            this.length = i2;
            if (i2 == 0) {
                this.length = 5;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            CharSequence charSequenceReplaceTags = "";
            if (editTextBoldCursorArr != null && editTextBoldCursorArr.length == this.length) {
                int i3 = 0;
                while (true) {
                    EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                    if (i3 >= editTextBoldCursorArr2.length) {
                        break;
                    }
                    editTextBoldCursorArr2[i3].setText("");
                    i3++;
                }
            } else {
                this.codeField = new EditTextBoldCursor[this.length];
                final int i4 = 0;
                while (i4 < this.length) {
                    this.codeField[i4] = new EditTextBoldCursor(getContext());
                    this.codeField[i4].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                    this.codeField[i4].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                    this.codeField[i4].setCursorSize(AndroidUtilities.dp(20.0f));
                    this.codeField[i4].setCursorWidth(1.5f);
                    Drawable drawableMutate = getResources().getDrawable(R.drawable.search_dark_activated).mutate();
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteInputFieldActivated"), PorterDuff.Mode.MULTIPLY));
                    this.codeField[i4].setBackgroundDrawable(drawableMutate);
                    this.codeField[i4].setImeOptions(268435461);
                    this.codeField[i4].setTextSize(1, 20.0f);
                    this.codeField[i4].setMaxLines(1);
                    this.codeField[i4].setTypeface(AndroidUtilities.getFontFamily(true));
                    this.codeField[i4].setPadding(0, 0, 0, 0);
                    this.codeField[i4].setGravity(49);
                    if (this.currentType == 3) {
                        this.codeField[i4].setEnabled(false);
                        this.codeField[i4].setInputType(0);
                        this.codeField[i4].setVisibility(8);
                    } else {
                        this.codeField[i4].setInputType(3);
                    }
                    this.codeFieldContainer.addView(this.codeField[i4], LayoutHelper.createLinear(34, 36, 1, 0, 0, i4 != this.length - 1 ? 7 : 0, 0));
                    this.codeField[i4].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.LoginActivity.LoginActivitySmsView.3
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable s) {
                            int length;
                            if (!LoginActivitySmsView.this.ignoreOnTextChange && (length = s.length()) >= 1) {
                                if (length > 1) {
                                    String string2 = s.toString();
                                    LoginActivitySmsView.this.ignoreOnTextChange = true;
                                    for (int i5 = 0; i5 < Math.min(LoginActivitySmsView.this.length - i4, length); i5++) {
                                        if (i5 != 0) {
                                            LoginActivitySmsView.this.codeField[i4 + i5].setText(string2.substring(i5, i5 + 1));
                                        } else {
                                            s.replace(0, length, string2.substring(i5, i5 + 1));
                                        }
                                    }
                                    LoginActivitySmsView.this.ignoreOnTextChange = false;
                                }
                                if (i4 != LoginActivitySmsView.this.length - 1) {
                                    LoginActivitySmsView.this.codeField[i4 + 1].setSelection(LoginActivitySmsView.this.codeField[i4 + 1].length());
                                    LoginActivitySmsView.this.codeField[i4 + 1].requestFocus();
                                }
                                if ((i4 == LoginActivitySmsView.this.length - 1 || (i4 == LoginActivitySmsView.this.length - 2 && length >= 2)) && LoginActivitySmsView.this.getCode().length() == LoginActivitySmsView.this.length) {
                                    LoginActivitySmsView.this.onNextPressed();
                                }
                            }
                        }
                    });
                    this.codeField[i4].setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$iGyQ9jdVQIJJLSKLWSxVW2D9pAU
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i5, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$5$LoginActivity$LoginActivitySmsView(i4, view, i5, keyEvent);
                        }
                    });
                    this.codeField[i4].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$WOTYeE9Ye1ARFPMzBmC_Oeb84Q8
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$6$LoginActivity$LoginActivitySmsView(textView, i5, keyEvent);
                        }
                    });
                    i4++;
                }
            }
            ProgressView progressView = this.progressView;
            if (progressView != null) {
                progressView.setVisibility(this.nextType != 0 ? 0 : 8);
            }
            if (this.phone == null) {
                return;
            }
            String str = PhoneFormat.getInstance().format(this.phone);
            int i5 = this.currentType;
            if (i5 == 1) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.getString("SentAppCode", R.string.SentAppCode));
            } else if (i5 == 2) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentSmsCode", R.string.SentSmsCode, LocaleController.addNbsp(str)));
            } else if (i5 == 3) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentCallCode", R.string.SentCallCode, LocaleController.addNbsp(str)));
            } else if (i5 == 4) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentCallOnly", R.string.SentCallOnly, LocaleController.addNbsp(str)));
            }
            this.confirmTextView.setText(charSequenceReplaceTags);
            if (this.currentType != 3) {
                AndroidUtilities.showKeyboard(this.codeField[0]);
                this.codeField[0].requestFocus();
            } else {
                AndroidUtilities.hideKeyboard(this.codeField[0]);
            }
            destroyTimer();
            destroyCodeTimer();
            this.lastCurrentTime = System.currentTimeMillis();
            int i6 = this.nextType;
            if (i6 == 2) {
                this.problemText.setVisibility(8);
                this.timeText.setVisibility(0);
                this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 1, 0));
                strSubstring = restore ? AndroidUtilities.obtainLoginPhoneCall(this.pattern) : null;
                if (strSubstring != null) {
                    this.ignoreOnTextChange = true;
                    this.codeField[0].setText(strSubstring);
                    this.ignoreOnTextChange = false;
                    onNextPressed();
                    return;
                }
                String str2 = this.catchedPhone;
                if (str2 != null) {
                    this.ignoreOnTextChange = true;
                    this.codeField[0].setText(str2);
                    this.ignoreOnTextChange = false;
                    onNextPressed();
                    return;
                }
                createTimer();
                return;
            }
            if (i6 == 4 || i6 == 3) {
                this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
                String string2 = sharedPreferences.getString("sms_hash", null);
                if (!TextUtils.isEmpty(string2) && (string = sharedPreferences.getString("sms_hash_code", null)) != null) {
                    if (string.contains(string2 + "|")) {
                        strSubstring = string.substring(string.indexOf(124) + 1);
                    }
                }
                if (strSubstring != null) {
                    this.codeField[0].setText(strSubstring);
                    onNextPressed();
                    return;
                } else {
                    createTimer();
                    return;
                }
            }
            this.timeText.setVisibility(8);
            this.problemText.setVisibility(8);
            createCodeTimer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setParams$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$setParams$5$LoginActivity$LoginActivitySmsView(int i, View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67 || this.codeField[i].length() != 0 || i <= 0) {
                return false;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            int i3 = i - 1;
            editTextBoldCursorArr[i3].setSelection(editTextBoldCursorArr[i3].length());
            this.codeField[i3].requestFocus();
            this.codeField[i3].dispatchKeyEvent(keyEvent);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setParams$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$setParams$6$LoginActivity$LoginActivitySmsView(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createCodeTimer() {
            if (this.codeTimer != null) {
                return;
            }
            this.codeTime = 15000;
            this.codeTimer = new Timer();
            this.lastCodeTime = System.currentTimeMillis();
            this.codeTimer.schedule(new AnonymousClass4(), 0L, 1000L);
        }

        /* renamed from: ir.eitaa.ui.LoginActivity$LoginActivitySmsView$4, reason: invalid class name */
        class AnonymousClass4 extends TimerTask {
            AnonymousClass4() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$4$onGTlWQd1Vdxi8FbDjm7Tr_6zUU
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$LoginActivity$LoginActivitySmsView$4();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$LoginActivity$LoginActivitySmsView$4() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivitySmsView.this.lastCodeTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivitySmsView.this.lastCodeTime = dCurrentTimeMillis;
                LoginActivitySmsView.access$4726(LoginActivitySmsView.this, dCurrentTimeMillis - d);
                if (LoginActivitySmsView.this.codeTime <= 1000) {
                    LoginActivitySmsView.this.problemText.setVisibility(0);
                    LoginActivitySmsView.this.timeText.setVisibility(8);
                    LoginActivitySmsView.this.destroyCodeTimer();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyCodeTimer() {
            try {
                synchronized (this.timerSync) {
                    Timer timer = this.codeTimer;
                    if (timer != null) {
                        timer.cancel();
                        this.codeTimer = null;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        private void createTimer() {
            if (this.timeTimer != null) {
                return;
            }
            ProgressView progressView = this.progressView;
            if (progressView != null) {
                progressView.resetProgressAnimation();
            }
            this.problemText.setVisibility(8);
            this.timeText.setVisibility(0);
            Timer timer = new Timer();
            this.timeTimer = timer;
            timer.schedule(new AnonymousClass5(), 0L, 1000L);
        }

        /* renamed from: ir.eitaa.ui.LoginActivity$LoginActivitySmsView$5, reason: invalid class name */
        class AnonymousClass5 extends TimerTask {
            AnonymousClass5() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LoginActivitySmsView.this.timeTimer == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$5$S70om7hSHzMo8MgkbLS91yiWaxc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$2$LoginActivity$LoginActivitySmsView$5();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$2$LoginActivity$LoginActivitySmsView$5() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivitySmsView.this.lastCurrentTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivitySmsView.this.lastCurrentTime = dCurrentTimeMillis;
                LoginActivitySmsView.access$5326(LoginActivitySmsView.this, dCurrentTimeMillis - d);
                if (LoginActivitySmsView.this.time >= 1000) {
                    int i = (LoginActivitySmsView.this.time / 1000) / 60;
                    int i2 = (LoginActivitySmsView.this.time / 1000) - (i * 60);
                    if (LoginActivitySmsView.this.nextType == 4 || LoginActivitySmsView.this.nextType == 3) {
                        TextView textView = LoginActivitySmsView.this.timeText;
                        StringBuilder sb = new StringBuilder();
                        sb.append(LocaleController.formatString("CallAvailableIn", R.string.CallAvailableIn, Integer.valueOf(i), Integer.valueOf(i2)));
                        sb.append(" ");
                        sb.append(LoginActivitySmsView.this.message != null ? LoginActivitySmsView.this.message : "");
                        textView.setText(sb.toString());
                    } else if (LoginActivitySmsView.this.nextType == 2) {
                        LoginActivitySmsView.this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, Integer.valueOf(i), Integer.valueOf(i2)));
                    }
                    if (LoginActivitySmsView.this.progressView == null || LoginActivitySmsView.this.progressView.isProgressAnimationRunning()) {
                        return;
                    }
                    LoginActivitySmsView.this.progressView.startProgressAnimation(LoginActivitySmsView.this.time - 1000);
                    return;
                }
                LoginActivitySmsView.this.destroyTimer();
                if (LoginActivitySmsView.this.currentType != 3) {
                    if (LoginActivitySmsView.this.nextType == 4 || LoginActivitySmsView.this.nextType == 2) {
                        if (LoginActivitySmsView.this.nextType == 4) {
                            LoginActivitySmsView.this.problemText.setText(LocaleController.getString("RequestMissedCall", R.string.RequestMissedCall));
                            LoginActivitySmsView.this.problemText.setVisibility(0);
                            LoginActivitySmsView.this.timeText.setVisibility(8);
                            LoginActivitySmsView.this.destroyCodeTimer();
                            return;
                        }
                        LoginActivitySmsView.this.timeText.setText(LocaleController.getString("SendingSms", R.string.SendingSms));
                        LoginActivitySmsView.this.createCodeTimer();
                        TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
                        tLRPC$TL_auth_resendCode.phone_number = LoginActivitySmsView.this.requestPhone;
                        tLRPC$TL_auth_resendCode.phone_code_hash = LoginActivitySmsView.this.phoneHash;
                        ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$5$vfQQFmAQXJK2jjEp9yEft_1Eris
                            @Override // ir.eitaa.tgnet.RequestDelegate
                            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                this.f$0.lambda$run$1$LoginActivity$LoginActivitySmsView$5(tLObject, tLRPC$TL_error);
                            }
                        }, 10);
                        return;
                    }
                    if (LoginActivitySmsView.this.nextType == 3) {
                        AndroidUtilities.setWaitingForSms(false);
                        NotificationCenter.getGlobalInstance().removeObserver(LoginActivitySmsView.this, NotificationCenter.didReceiveSmsCode);
                        LoginActivitySmsView.this.waitingForEvent = false;
                        LoginActivitySmsView.this.destroyCodeTimer();
                        LoginActivitySmsView.this.timeText.setVisibility(8);
                        LoginActivitySmsView.this.problemText.setText(LocaleController.getString("RequestCallButton", R.string.RequestCallButton));
                        LoginActivitySmsView.this.problemText.setVisibility(0);
                        return;
                    }
                    return;
                }
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(LoginActivitySmsView.this, NotificationCenter.didReceiveCall);
                LoginActivitySmsView.this.waitingForEvent = false;
                LoginActivitySmsView.this.destroyCodeTimer();
                LoginActivitySmsView.this.resendCode();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$1, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$1$LoginActivity$LoginActivitySmsView$5(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                if (tLRPC$TL_error == null || tLRPC$TL_error.text == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$5$_nTgCIAgoTtbDX85J2yg1NpHXkQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$LoginActivity$LoginActivitySmsView$5(tLRPC$TL_error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$LoginActivity$LoginActivitySmsView$5(TLRPC$TL_error tLRPC$TL_error) {
                LoginActivitySmsView.this.lastError = tLRPC$TL_error.text;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyTimer() {
            try {
                synchronized (this.timerSync) {
                    Timer timer = this.timeTimer;
                    if (timer != null) {
                        timer.cancel();
                        this.timeTimer = null;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        private void createSmsCodeTimer() {
            if (this.smsCodeTimer != null) {
                return;
            }
            this.codeTime = this.time;
            this.smsCodeTimer = new Timer();
            this.lastCodeTime = System.currentTimeMillis();
            this.smsCodeTimer.schedule(new AnonymousClass6(), 0L, 1000L);
        }

        /* renamed from: ir.eitaa.ui.LoginActivity$LoginActivitySmsView$6, reason: invalid class name */
        class AnonymousClass6 extends TimerTask {
            AnonymousClass6() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$6$lvOuBrPOgC6zNfrhFHzAu0CYJsA
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$LoginActivity$LoginActivitySmsView$6();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$LoginActivity$LoginActivitySmsView$6() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivitySmsView.this.lastCodeTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivitySmsView.this.lastCodeTime = dCurrentTimeMillis;
                LoginActivitySmsView.access$4726(LoginActivitySmsView.this, dCurrentTimeMillis - d);
                int i = (LoginActivitySmsView.this.codeTime / 1000) / 60;
                int i2 = (LoginActivitySmsView.this.codeTime / 1000) - (i * 60);
                if (LoginActivitySmsView.this.currentType == 2 && LoginActivitySmsView.this.nextType == 2) {
                    LoginActivitySmsView.this.problemText.setText(LocaleController.formatString("SmsText2", R.string.SmsText2, Integer.valueOf(i), Integer.valueOf(i2)));
                }
                if (LoginActivitySmsView.this.codeTime <= 1000) {
                    if (LoginActivitySmsView.this.currentType != 2 || LoginActivitySmsView.this.nextType != 2) {
                        LoginActivitySmsView.this.problemText.setVisibility(0);
                        LoginActivitySmsView.this.timeText.setVisibility(8);
                    } else {
                        LoginActivitySmsView.this.problemText.setText(LocaleController.getString("SmsTextAgain", R.string.SmsTextAgain));
                    }
                    LoginActivitySmsView.this.destroySmsCodeTimer();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroySmsCodeTimer() {
            try {
                synchronized (this.timerSync) {
                    Timer timer = this.smsCodeTimer;
                    if (timer != null) {
                        timer.cancel();
                        this.smsCodeTimer = null;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getCode() {
            if (this.codeField == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i < editTextBoldCursorArr.length) {
                    sb.append(PhoneFormat.stripExceptNumbers(editTextBoldCursorArr[i].getText().toString()));
                    i++;
                } else {
                    return sb.toString();
                }
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed || LoginActivity.this.currentViewNum < 1 || LoginActivity.this.currentViewNum > 4) {
                return;
            }
            String code = getCode();
            if (TextUtils.isEmpty(code)) {
                LoginActivity.this.onFieldError(this.codeFieldContainer);
                return;
            }
            this.nextPressed = true;
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            final TLRPC$TL_auth_signIn tLRPC$TL_auth_signIn = new TLRPC$TL_auth_signIn();
            tLRPC$TL_auth_signIn.phone_number = this.requestPhone;
            tLRPC$TL_auth_signIn.phone_code = code;
            tLRPC$TL_auth_signIn.phone_code_hash = this.phoneHash;
            destroyTimer();
            LoginActivity.this.needShowProgress(ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_signIn, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$yMLozjxYW_e0uAEb17fHprT-oDQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$10$LoginActivity$LoginActivitySmsView(tLRPC$TL_auth_signIn, tLObject, tLRPC$TL_error);
                }
            }, 10), false);
            LoginActivity.this.showDoneButton(true, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$10, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$10$LoginActivity$LoginActivitySmsView(final TLRPC$TL_auth_signIn tLRPC$TL_auth_signIn, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$yc0expNwCT2ZVlfqrbG8gIHqRZ0
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$onNextPressed$9$LoginActivity$LoginActivitySmsView(tLRPC$TL_error, tLObject, tLRPC$TL_auth_signIn);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$9$LoginActivity$LoginActivitySmsView(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, final TLRPC$TL_auth_signIn tLRPC$TL_auth_signIn) throws InterruptedException {
            int i;
            EditTextBoldCursor[] editTextBoldCursorArr;
            int i2;
            boolean z = false;
            if (tLRPC$TL_error == null) {
                this.nextPressed = false;
                LoginActivity.this.showDoneButton(false, true);
                destroyTimer();
                destroyCodeTimer();
                if (!(tLObject instanceof TLRPC$TL_auth_authorizationSignUpRequired)) {
                    LoginActivity.this.onAuthSuccess((TLRPC$TL_auth_authorization) tLObject);
                } else {
                    TLRPC$TL_help_termsOfService tLRPC$TL_help_termsOfService = ((TLRPC$TL_auth_authorizationSignUpRequired) tLObject).terms_of_service;
                    if (tLRPC$TL_help_termsOfService != null) {
                        LoginActivity.this.currentTermsOfService = tLRPC$TL_help_termsOfService;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("phoneFormated", this.requestPhone);
                    bundle.putString("phoneHash", this.phoneHash);
                    bundle.putString("code", tLRPC$TL_auth_signIn.phone_code);
                    LoginActivity.this.setPage(5, true, bundle, false);
                }
            } else {
                String str = tLRPC$TL_error.text;
                this.lastError = str;
                if (str.contains("SESSION_PASSWORD_NEEDED")) {
                    TLRPC$TL_account_getPassword_layer84 tLRPC$TL_account_getPassword_layer84 = new TLRPC$TL_account_getPassword_layer84();
                    tLRPC$TL_account_getPassword_layer84.phone_code = tLRPC$TL_auth_signIn.phone_code;
                    int i3 = tLRPC$TL_account_getPassword_layer84.flags | 1;
                    tLRPC$TL_account_getPassword_layer84.flags = i3;
                    tLRPC$TL_account_getPassword_layer84.phone_number = this.requestPhone;
                    tLRPC$TL_account_getPassword_layer84.flags = i3 | 2;
                    ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_account_getPassword_layer84, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$cpFCnwClwZVaUfajGCg1Xxf9H7g
                        @Override // ir.eitaa.tgnet.RequestDelegate
                        public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                            this.f$0.lambda$onNextPressed$8$LoginActivity$LoginActivitySmsView(tLRPC$TL_auth_signIn, tLObject2, tLRPC$TL_error2);
                        }
                    }, 10);
                    destroyTimer();
                    destroyCodeTimer();
                } else {
                    this.nextPressed = false;
                    LoginActivity.this.showDoneButton(false, true);
                    int i4 = this.currentType;
                    if ((i4 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) || ((i4 == 2 && ((i = this.nextType) == 4 || i == 3)) || (i4 == 4 && this.nextType == 2))) {
                        createTimer();
                    }
                    int i5 = this.currentType;
                    if (i5 == 2) {
                        AndroidUtilities.setWaitingForSms(true);
                        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
                    } else if (i5 == 3) {
                        AndroidUtilities.setWaitingForCall(true);
                        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
                    }
                    this.waitingForEvent = true;
                    if (this.currentType != 3) {
                        if (tLRPC$TL_error.text.contains("PHONE_NUMBER_INVALID")) {
                            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                        } else if (tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") || tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
                            int i6 = 0;
                            while (true) {
                                editTextBoldCursorArr = this.codeField;
                                if (i6 >= editTextBoldCursorArr.length) {
                                    break;
                                }
                                editTextBoldCursorArr[i6].setText("");
                                i6++;
                            }
                            editTextBoldCursorArr[0].requestFocus();
                        } else if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                            onBackPressed(true);
                            LoginActivity.this.setPage(0, true, null, true);
                            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired));
                        } else if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("FloodWait", R.string.FloodWait));
                        } else {
                            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred) + "\n" + tLRPC$TL_error.text);
                        }
                    }
                    if (z || this.currentType != 3) {
                    }
                    AndroidUtilities.endIncomingCall();
                    return;
                }
            }
            z = true;
            if (z) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$8$LoginActivity$LoginActivitySmsView(final TLRPC$TL_auth_signIn tLRPC$TL_auth_signIn, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$2sHJb3fhJomgs1dCxI6pehx9mGE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$7$LoginActivity$LoginActivitySmsView(tLRPC$TL_error, tLObject, tLRPC$TL_auth_signIn);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$7$LoginActivity$LoginActivitySmsView(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_auth_signIn tLRPC$TL_auth_signIn) {
            this.nextPressed = false;
            LoginActivity.this.showDoneButton(false, true);
            if (tLRPC$TL_error != null) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                return;
            }
            TLRPC$TL_account_password_layer84 tLRPC$TL_account_password_layer84 = (TLRPC$TL_account_password_layer84) tLObject;
            Bundle bundle = new Bundle();
            bundle.putString("current_salt", Utilities.bytesToHex(tLRPC$TL_account_password_layer84.current_salt));
            bundle.putString("hint", tLRPC$TL_account_password_layer84.hint);
            bundle.putString("email_unconfirmed_pattern", tLRPC$TL_account_password_layer84.email_unconfirmed_pattern);
            bundle.putString("phoneFormated", this.requestPhone);
            bundle.putString("phoneHash", this.phoneHash);
            bundle.putString("code", tLRPC$TL_auth_signIn.phone_code);
            bundle.putInt("has_recovery", tLRPC$TL_account_password_layer84.has_recovery ? 1 : 0);
            LoginActivity.this.setPage(6, true, bundle, false);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean onBackPressed(boolean force) {
            if (!force) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("StopVerification", R.string.StopVerification));
                builder.setPositiveButton(LocaleController.getString("Continue", R.string.Continue), null);
                builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$9yIvUFSK9-nbRPWuAz1lYPoHxrQ
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onBackPressed$11$LoginActivity$LoginActivitySmsView(dialogInterface, i);
                    }
                });
                LoginActivity.this.showDialog(builder.create());
                return false;
            }
            this.nextPressed = false;
            LoginActivity.this.needHideProgress(true);
            TLRPC$TL_auth_cancelCode tLRPC$TL_auth_cancelCode = new TLRPC$TL_auth_cancelCode();
            tLRPC$TL_auth_cancelCode.phone_number = this.requestPhone;
            tLRPC$TL_auth_cancelCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_cancelCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$-bgHuXPYZwbeREv2-kQ3nbk5V4A
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    LoginActivity.LoginActivitySmsView.lambda$onBackPressed$12(tLObject, tLRPC$TL_error);
                }
            }, 10);
            destroyTimer();
            destroyCodeTimer();
            this.currentParams = null;
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onBackPressed$11, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onBackPressed$11$LoginActivity$LoginActivitySmsView(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            LoginActivity.this.setPage(0, true, null, true);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onDestroyActivity() {
            super.onDestroyActivity();
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            destroyTimer();
            destroyCodeTimer();
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            if (this.currentType == 3) {
                return;
            }
            RLottieDrawable rLottieDrawable = this.hintDrawable;
            if (rLottieDrawable != null) {
                rLottieDrawable.setCurrentFrame(0);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivitySmsView$ugLqTK3wn18PYUOlmp1lgsHqNFQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$13$LoginActivity$LoginActivitySmsView();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onShow$13, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onShow$13$LoginActivity$LoginActivitySmsView() {
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            if (editTextBoldCursorArr != null) {
                for (int length = editTextBoldCursorArr.length - 1; length >= 0; length--) {
                    if (length == 0 || this.codeField[length].length() != 0) {
                        this.codeField[length].requestFocus();
                        EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                        editTextBoldCursorArr2[length].setSelection(editTextBoldCursorArr2[length].length());
                        AndroidUtilities.showKeyboard(this.codeField[length]);
                        break;
                    }
                }
            }
            RLottieDrawable rLottieDrawable = this.hintDrawable;
            if (rLottieDrawable != null) {
                rLottieDrawable.start();
            }
        }

        @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int id, int account, Object... args) {
            EditTextBoldCursor[] editTextBoldCursorArr;
            if (!this.waitingForEvent || (editTextBoldCursorArr = this.codeField) == null) {
                return;
            }
            if (id == NotificationCenter.didReceiveSmsCode) {
                editTextBoldCursorArr[0].setText("" + args[0]);
                onNextPressed();
                return;
            }
            if (id == NotificationCenter.didReceiveCall) {
                String str = "" + args[0];
                if (AndroidUtilities.checkPhonePattern(this.pattern, str)) {
                    if (!this.pattern.equals("*")) {
                        this.catchedPhone = str;
                        AndroidUtilities.endIncomingCall();
                    }
                    this.ignoreOnTextChange = true;
                    this.codeField[0].setText(str);
                    this.ignoreOnTextChange = false;
                    onNextPressed();
                }
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            String code = getCode();
            if (code.length() != 0) {
                bundle.putString("smsview_code_" + this.currentType, code);
            }
            String str = this.catchedPhone;
            if (str != null) {
                bundle.putString("catchedPhone", str);
            }
            if (this.currentParams != null) {
                bundle.putBundle("smsview_params_" + this.currentType, this.currentParams);
            }
            int i = this.time;
            if (i != 0) {
                bundle.putInt("time", i);
            }
            int i2 = this.openTime;
            if (i2 != 0) {
                bundle.putInt("open", i2);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            EditTextBoldCursor[] editTextBoldCursorArr;
            Bundle bundle2 = bundle.getBundle("smsview_params_" + this.currentType);
            this.currentParams = bundle2;
            if (bundle2 != null) {
                setParams(bundle2, true);
            }
            String string = bundle.getString("catchedPhone");
            if (string != null) {
                this.catchedPhone = string;
            }
            String string2 = bundle.getString("smsview_code_" + this.currentType);
            if (string2 != null && (editTextBoldCursorArr = this.codeField) != null) {
                editTextBoldCursorArr[0].setText(string2);
            }
            int i = bundle.getInt("time");
            if (i != 0) {
                this.time = i;
            }
            int i2 = bundle.getInt("open");
            if (i2 != 0) {
                this.openTime = i2;
            }
        }
    }

    public class LoginActivityPasswordView extends SlideView {
        private TextView cancelButton;
        private EditTextBoldCursor codeField;
        private TextView confirmTextView;
        private Bundle currentParams;
        private TLRPC$TL_account_password currentPassword;
        private byte[] current_salt;
        private String email_unconfirmed_pattern;
        private boolean has_recovery;
        private String hint;
        private boolean nextPressed;
        private String passwordString;
        private String phoneCode;
        private String phoneHash;
        private String requestPhone;
        private TextView resetAccountButton;
        private TextView resetAccountText;

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        public LoginActivityPasswordView(Context context) {
            super(context);
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.confirmTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.confirmTextView.setText(LocaleController.getString("LoginPasswordText", R.string.LoginPasswordText));
            addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.codeField = editTextBoldCursor;
            editTextBoldCursor.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.codeField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.codeField.setCursorWidth(1.5f);
            this.codeField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.codeField.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
            this.codeField.setImeOptions(268435461);
            this.codeField.setTextSize(1, 18.0f);
            this.codeField.setMaxLines(1);
            this.codeField.setPadding(0, 0, 0, 0);
            this.codeField.setInputType(129);
            this.codeField.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.codeField.setTypeface(AndroidUtilities.getFontFamily(false));
            this.codeField.setGravity(LocaleController.isRTL ? 5 : 3);
            addView(this.codeField, LayoutHelper.createLinear(-1, 36, 1, 0, 20, 0, 0));
            this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$4wFoLsHXB3CESHitXefQ4WjdMsE
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$0$LoginActivity$LoginActivityPasswordView(textView2, i, keyEvent);
                }
            });
            TextView textView2 = new TextView(context);
            this.cancelButton = textView2;
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.cancelButton.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.cancelButton.setText(LocaleController.getString("ForgotPassword", R.string.ForgotPassword));
            this.cancelButton.setTextSize(1, 14.0f);
            this.cancelButton.setTypeface(AndroidUtilities.getFontFamily(false));
            this.cancelButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.cancelButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.cancelButton, LayoutHelper.createLinear(-1, -2, (LocaleController.isRTL ? 5 : 3) | 48));
            this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$3awOEG-hQtLndiDhz-nMVooshVs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$4$LoginActivity$LoginActivityPasswordView(view);
                }
            });
            TextView textView3 = new TextView(context);
            this.resetAccountButton = textView3;
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountButton.setTextColor(Theme.getColor("windowBackgroundWhiteRedText6"));
            this.resetAccountButton.setVisibility(8);
            this.resetAccountButton.setText(LocaleController.getString("ResetMyAccount", R.string.ResetMyAccount));
            this.resetAccountButton.setTypeface(AndroidUtilities.getFontFamily(true));
            this.resetAccountButton.setTextSize(1, 14.0f);
            this.resetAccountButton.setTypeface(AndroidUtilities.getFontFamily(false));
            this.resetAccountButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.resetAccountButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.resetAccountButton, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 34, 0, 0));
            this.resetAccountButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$2K4oD0maeZTzM5FXeDOfE6OGjaI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$8$LoginActivity$LoginActivityPasswordView(view);
                }
            });
            TextView textView4 = new TextView(context);
            this.resetAccountText = textView4;
            textView4.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountText.setVisibility(8);
            this.resetAccountText.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.resetAccountText.setText(LocaleController.getString("ResetMyAccountText", R.string.ResetMyAccountText));
            this.resetAccountText.setTextSize(1, 14.0f);
            this.resetAccountText.setTypeface(AndroidUtilities.getFontFamily(false));
            this.resetAccountText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.resetAccountText, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 7, 0, 14));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$0$LoginActivity$LoginActivityPasswordView(TextView textView, int i, KeyEvent keyEvent) throws UnsupportedEncodingException {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$4$LoginActivity$LoginActivityPasswordView(View view) {
            if (LoginActivity.this.doneProgressView.getTag() != null) {
                return;
            }
            if (this.has_recovery) {
                LoginActivity.this.needShowProgress(0);
                TLRPC$TL_auth_requestPasswordRecovery_layer84 tLRPC$TL_auth_requestPasswordRecovery_layer84 = new TLRPC$TL_auth_requestPasswordRecovery_layer84();
                tLRPC$TL_auth_requestPasswordRecovery_layer84.phone_code = this.phoneCode;
                int i = tLRPC$TL_auth_requestPasswordRecovery_layer84.flags | 1;
                tLRPC$TL_auth_requestPasswordRecovery_layer84.flags = i;
                tLRPC$TL_auth_requestPasswordRecovery_layer84.phone_number = this.requestPhone;
                tLRPC$TL_auth_requestPasswordRecovery_layer84.flags = i | 2;
                ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_requestPasswordRecovery_layer84, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$k0jC_b-k1ST63V9AvBX7Bbyd7dw
                    @Override // ir.eitaa.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$new$3$LoginActivity$LoginActivityPasswordView(tLObject, tLRPC$TL_error);
                    }
                }, 10);
                return;
            }
            this.resetAccountText.setVisibility(0);
            this.resetAccountButton.setVisibility(0);
            AndroidUtilities.hideKeyboard(this.codeField);
            LoginActivity.this.needShowAlert(LocaleController.getString("RestorePasswordNoEitle", R.string.RestorePasswordNoEmailTitle), LocaleController.getString("RestorePasswordNoEmailText", R.string.RestorePasswordNoEmailText));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$3$LoginActivity$LoginActivityPasswordView(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$dDHtNEW9Sguje4S4OE6jovXkypM
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$2$LoginActivity$LoginActivityPasswordView(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$LoginActivity$LoginActivityPasswordView(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
            String pluralString;
            LoginActivity.this.needHideProgress(false);
            if (tLRPC$TL_error == null) {
                final TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery = (TLRPC$TL_auth_passwordRecovery) tLObject;
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
                builder.setMessage(LocaleController.formatString("RestoreEmailSent", R.string.RestoreEmailSent, tLRPC$TL_auth_passwordRecovery.email_pattern));
                builder.setTitle(LocaleController.getString("RestoreEmailSentTitle", R.string.RestoreEmailSentTitle));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$i7GdFPzLrasRNE-EqEFJq3gtnH8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$new$1$LoginActivity$LoginActivityPasswordView(tLRPC$TL_auth_passwordRecovery, dialogInterface, i);
                    }
                });
                Dialog dialogShowDialog = LoginActivity.this.showDialog(builder.create());
                if (dialogShowDialog != null) {
                    dialogShowDialog.setCanceledOnTouchOutside(false);
                    dialogShowDialog.setCancelable(false);
                    return;
                }
                return;
            }
            if (!tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                return;
            }
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$LoginActivity$LoginActivityPasswordView(TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery, DialogInterface dialogInterface, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("email_unconfirmed_pattern", tLRPC$TL_auth_passwordRecovery.email_pattern);
            bundle.putString("password", this.passwordString);
            bundle.putString("phoneFormated", this.requestPhone);
            bundle.putString("code", this.phoneCode);
            LoginActivity.this.setPage(7, true, bundle, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$8$LoginActivity$LoginActivityPasswordView(View view) {
            if (LoginActivity.this.doneProgressView.getTag() != null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
            builder.setMessage(LocaleController.getString("ResetMyAccountWarningText", R.string.ResetMyAccountWarningText));
            builder.setTitle(LocaleController.getString("ResetMyAccountWarning", R.string.ResetMyAccountWarning));
            builder.setPositiveButton(LocaleController.getString("ResetMyAccountWarningReset", R.string.ResetMyAccountWarningReset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$B1_lAdQftSDk7Ea-QDW1FT6EeWQ
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$new$7$LoginActivity$LoginActivityPasswordView(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            LoginActivity.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$7$LoginActivity$LoginActivityPasswordView(DialogInterface dialogInterface, int i) {
            LoginActivity.this.needShowProgress(0);
            TLRPC$TL_account_deleteAccount tLRPC$TL_account_deleteAccount = new TLRPC$TL_account_deleteAccount();
            tLRPC$TL_account_deleteAccount.reason = "Forgot password";
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_account_deleteAccount, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$e03UNqo6ZqpF4dCApfYMR_OzKmI
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$6$LoginActivity$LoginActivityPasswordView(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$6$LoginActivity$LoginActivityPasswordView(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$Dy0aLCHACFhwiZM6SAbsWQ5bwv0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$5$LoginActivity$LoginActivityPasswordView(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$5$LoginActivity$LoginActivityPasswordView(TLRPC$TL_error tLRPC$TL_error) {
            LoginActivity.this.needHideProgress(false);
            if (tLRPC$TL_error == null) {
                Bundle bundle = new Bundle();
                bundle.putString("phoneFormated", this.requestPhone);
                bundle.putString("phoneHash", this.phoneHash);
                bundle.putString("code", this.phoneCode);
                LoginActivity.this.setPage(5, true, bundle, false);
                return;
            }
            if (tLRPC$TL_error.text.equals("2FA_RECENT_CONFIRM")) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ResetAccountCancelledAlert", R.string.ResetAccountCancelledAlert));
                return;
            }
            if (!tLRPC$TL_error.text.startsWith("2FA_CONFIRM_WAIT_")) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("phoneFormated", this.requestPhone);
            bundle2.putString("phoneHash", this.phoneHash);
            bundle2.putString("code", this.phoneCode);
            bundle2.putInt("startTime", ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).getCurrentTime());
            bundle2.putInt("waitTime", Utilities.parseInt(tLRPC$TL_error.text.replace("2FA_CONFIRM_WAIT_", "")).intValue());
            LoginActivity.this.setPage(8, true, bundle2, false);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("LoginPassword", R.string.LoginPassword);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            if (params == null) {
                return;
            }
            if (params.isEmpty()) {
                this.resetAccountButton.setVisibility(0);
                this.resetAccountText.setVisibility(0);
                AndroidUtilities.hideKeyboard(this.codeField);
                return;
            }
            this.resetAccountButton.setVisibility(8);
            this.resetAccountText.setVisibility(8);
            this.codeField.setText("");
            this.currentParams = params;
            this.current_salt = Utilities.hexToBytes(params.getString("current_salt"));
            this.hint = this.currentParams.getString("hint");
            this.has_recovery = this.currentParams.getInt("has_recovery") == 1;
            this.email_unconfirmed_pattern = this.currentParams.getString("email_unconfirmed_pattern");
            this.requestPhone = params.getString("phoneFormated");
            this.phoneHash = params.getString("phoneHash");
            this.phoneCode = params.getString("code");
            String str = this.hint;
            if (str != null && str.length() > 0) {
                this.codeField.setHint(this.hint);
            } else {
                this.codeField.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
            }
        }

        private void onPasscodeError(boolean clear) {
            if (LoginActivity.this.getParentActivity() == null) {
                return;
            }
            if (clear) {
                this.codeField.setText("");
            }
            LoginActivity.this.onFieldError(this.confirmTextView);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() throws UnsupportedEncodingException {
            if (this.nextPressed) {
                return;
            }
            String string = this.codeField.getText().toString();
            if (string.length() == 0) {
                onPasscodeError(false);
                return;
            }
            this.nextPressed = true;
            LoginActivity.this.needShowProgress(0);
            byte[] bytes = null;
            try {
                bytes = string.getBytes("UTF-8");
            } catch (Exception e) {
                FileLog.e(e);
            }
            LoginActivity.this.needShowProgress(0);
            byte[] bArr = this.current_salt;
            int length = (bArr.length * 2) + bytes.length;
            final byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bytes, 0, bArr2, this.current_salt.length, bytes.length);
            byte[] bArr3 = this.current_salt;
            System.arraycopy(bArr3, 0, bArr2, length - bArr3.length, bArr3.length);
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$UNW62ZcsAq5gHa2g2GxdHnuoTDw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$12$LoginActivity$LoginActivityPasswordView(bArr2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$12, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$12$LoginActivity$LoginActivityPasswordView(byte[] bArr) {
            TLRPC$TL_auth_checkPassword_layer84 tLRPC$TL_auth_checkPassword_layer84 = new TLRPC$TL_auth_checkPassword_layer84();
            tLRPC$TL_auth_checkPassword_layer84.password_hash = Utilities.computeSHA256(bArr, 0, bArr.length);
            tLRPC$TL_auth_checkPassword_layer84.phone_code = this.phoneCode;
            int i = tLRPC$TL_auth_checkPassword_layer84.flags | 1;
            tLRPC$TL_auth_checkPassword_layer84.flags = i;
            tLRPC$TL_auth_checkPassword_layer84.phone_number = this.requestPhone;
            tLRPC$TL_auth_checkPassword_layer84.flags = i | 2;
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_checkPassword_layer84, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$oyl2HlBO0ZehEXHOXWu1w1wgUUE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$11$LoginActivity$LoginActivityPasswordView(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$11, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$11$LoginActivity$LoginActivityPasswordView(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$TBqF_LYQ1RYrKnq_71eHFG1PprY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$10$LoginActivity$LoginActivityPasswordView(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$10, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$10$LoginActivity$LoginActivityPasswordView(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            String pluralString;
            this.nextPressed = false;
            if (tLObject instanceof TLRPC$TL_auth_authorization) {
                LoginActivity.this.showDoneButton(false, true);
                postDelayed(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$48VPEfd5SDyoBvEb0of-c8oS2pk
                    @Override // java.lang.Runnable
                    public final void run() throws InterruptedException {
                        this.f$0.lambda$onNextPressed$9$LoginActivity$LoginActivityPasswordView(tLObject);
                    }
                }, 150L);
                return;
            }
            LoginActivity.this.needHideProgress(false);
            if (tLRPC$TL_error.text.equals("PASSWORD_HASH_INVALID")) {
                onPasscodeError(true);
                return;
            }
            if (!tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                return;
            }
            int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
            if (iIntValue < 60) {
                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
            } else {
                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
            }
            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$9$LoginActivity$LoginActivityPasswordView(TLObject tLObject) throws InterruptedException {
            LoginActivity.this.needHideProgress(false, false);
            AndroidUtilities.hideKeyboard(this.codeField);
            LoginActivity.this.onAuthSuccess((TLRPC$TL_auth_authorization) tLObject);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean onBackPressed(boolean force) {
            this.nextPressed = false;
            LoginActivity.this.needHideProgress(true);
            this.currentParams = null;
            return true;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityPasswordView$uiszbZbDcxqTAJB9K8C5-GMF9FY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$13$LoginActivity$LoginActivityPasswordView();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onShow$13, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onShow$13$LoginActivity$LoginActivityPasswordView() {
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            if (editTextBoldCursor != null) {
                editTextBoldCursor.requestFocus();
                EditTextBoldCursor editTextBoldCursor2 = this.codeField;
                editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
                AndroidUtilities.showKeyboard(this.codeField);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            String string = this.codeField.getText().toString();
            if (string.length() != 0) {
                bundle.putString("passview_code", string);
            }
            Bundle bundle2 = this.currentParams;
            if (bundle2 != null) {
                bundle.putBundle("passview_params", bundle2);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle("passview_params");
            this.currentParams = bundle2;
            if (bundle2 != null) {
                setParams(bundle2, true);
            }
            String string = bundle.getString("passview_code");
            if (string != null) {
                this.codeField.setText(string);
            }
        }
    }

    public class LoginActivityResetWaitView extends SlideView {
        private TextView confirmTextView;
        private Bundle currentParams;
        private String phoneCode;
        private String phoneHash;
        private String requestPhone;
        private TextView resetAccountButton;
        private TextView resetAccountText;
        private TextView resetAccountTime;
        private int startTime;
        private Runnable timeRunnable;
        private int waitTime;

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        public LoginActivityResetWaitView(Context context) {
            super(context);
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.confirmTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
            TextView textView2 = new TextView(context);
            this.resetAccountText = textView2;
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountText.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.resetAccountText.setText(LocaleController.getString("ResetAccountStatus", R.string.ResetAccountStatus));
            this.resetAccountText.setTextSize(1, 14.0f);
            this.resetAccountText.setTypeface(AndroidUtilities.getFontFamily(false));
            this.resetAccountText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.resetAccountText, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 24, 0, 0));
            TextView textView3 = new TextView(context);
            this.resetAccountTime = textView3;
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountTime.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.resetAccountTime.setTextSize(1, 14.0f);
            this.resetAccountTime.setTypeface(AndroidUtilities.getFontFamily(false));
            this.resetAccountTime.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.resetAccountTime, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 2, 0, 0));
            TextView textView4 = new TextView(context);
            this.resetAccountButton = textView4;
            textView4.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountButton.setText(LocaleController.getString("ResetAccountButton", R.string.ResetAccountButton));
            this.resetAccountButton.setTypeface(AndroidUtilities.getFontFamily(true));
            this.resetAccountButton.setTextSize(1, 14.0f);
            this.resetAccountButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.resetAccountButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.resetAccountButton, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 7, 0, 0));
            this.resetAccountButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityResetWaitView$eruH9p7TX1fsOFO8V5ZvTBNqPfc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$3$LoginActivity$LoginActivityResetWaitView(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$3$LoginActivity$LoginActivityResetWaitView(View view) {
            if (LoginActivity.this.doneProgressView.getTag() == null && Math.abs(ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).getCurrentTime() - this.startTime) >= this.waitTime) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
                builder.setMessage(LocaleController.getString("ResetMyAccountWarningText", R.string.ResetMyAccountWarningText));
                builder.setTitle(LocaleController.getString("ResetMyAccountWarning", R.string.ResetMyAccountWarning));
                builder.setPositiveButton(LocaleController.getString("ResetMyAccountWarningReset", R.string.ResetMyAccountWarningReset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityResetWaitView$Qc9c6P1bKm1FJIt22k_IarQTgaU
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$new$2$LoginActivity$LoginActivityResetWaitView(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                LoginActivity.this.showDialog(builder.create());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$LoginActivity$LoginActivityResetWaitView(DialogInterface dialogInterface, int i) {
            LoginActivity.this.needShowProgress(0);
            TLRPC$TL_account_deleteAccount tLRPC$TL_account_deleteAccount = new TLRPC$TL_account_deleteAccount();
            tLRPC$TL_account_deleteAccount.reason = "Forgot password";
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_account_deleteAccount, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityResetWaitView$KNntDPQM4HKjN3_IxS-9JGmoXss
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$1$LoginActivity$LoginActivityResetWaitView(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$LoginActivity$LoginActivityResetWaitView(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityResetWaitView$Nk4sj0Sz2y0pV79yyejWsxivVPk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0$LoginActivity$LoginActivityResetWaitView(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$LoginActivity$LoginActivityResetWaitView(TLRPC$TL_error tLRPC$TL_error) {
            LoginActivity.this.needHideProgress(false);
            if (tLRPC$TL_error == null) {
                Bundle bundle = new Bundle();
                bundle.putString("phoneFormated", this.requestPhone);
                bundle.putString("phoneHash", this.phoneHash);
                bundle.putString("code", this.phoneCode);
                LoginActivity.this.setPage(5, true, bundle, false);
                return;
            }
            if (tLRPC$TL_error.text.equals("2FA_RECENT_CONFIRM")) {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ResetAccountCancelledAlert", R.string.ResetAccountCancelledAlert));
            } else {
                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("ResetAccount", R.string.ResetAccount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateTimeText() {
            int iMax = Math.max(0, this.waitTime - (ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).getCurrentTime() - this.startTime));
            int i = iMax / 86400;
            int i2 = iMax - (86400 * i);
            int i3 = i2 / 3600;
            int i4 = (i2 - (i3 * 3600)) / 60;
            int i5 = iMax % 60;
            if (i != 0) {
                this.resetAccountTime.setText(AndroidUtilities.replaceTags(LocaleController.formatPluralString("DaysBold", i) + " " + LocaleController.formatPluralString("HoursBold", i3) + " " + LocaleController.formatPluralString("MinutesBold", i4)));
            } else {
                this.resetAccountTime.setText(AndroidUtilities.replaceTags(LocaleController.formatPluralString("HoursBold", i3) + " " + LocaleController.formatPluralString("MinutesBold", i4) + " " + LocaleController.formatPluralString("SecondsBold", i5)));
            }
            if (iMax > 0) {
                this.resetAccountButton.setTag("windowBackgroundWhiteGrayText6");
                this.resetAccountButton.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            } else {
                this.resetAccountButton.setTag("windowBackgroundWhiteRedText6");
                this.resetAccountButton.setTextColor(Theme.getColor("windowBackgroundWhiteRedText6"));
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            if (params == null) {
                return;
            }
            this.currentParams = params;
            this.requestPhone = params.getString("phoneFormated");
            this.phoneHash = params.getString("phoneHash");
            this.phoneCode = params.getString("code");
            this.startTime = params.getInt("startTime");
            this.waitTime = params.getInt("waitTime");
            this.confirmTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ResetAccountInfo", R.string.ResetAccountInfo, LocaleController.addNbsp(PhoneFormat.getInstance().format("+" + this.requestPhone)))));
            updateTimeText();
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.LoginActivity.LoginActivityResetWaitView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LoginActivityResetWaitView.this.timeRunnable != this) {
                        return;
                    }
                    LoginActivityResetWaitView.this.updateTimeText();
                    AndroidUtilities.runOnUIThread(LoginActivityResetWaitView.this.timeRunnable, 1000L);
                }
            };
            this.timeRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 1000L);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean onBackPressed(boolean force) {
            LoginActivity.this.needHideProgress(true);
            AndroidUtilities.cancelRunOnUIThread(this.timeRunnable);
            this.timeRunnable = null;
            this.currentParams = null;
            return true;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            Bundle bundle2 = this.currentParams;
            if (bundle2 != null) {
                bundle.putBundle("resetview_params", bundle2);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle("resetview_params");
            this.currentParams = bundle2;
            if (bundle2 != null) {
                setParams(bundle2, true);
            }
        }
    }

    public class LoginActivityRecoverView extends SlideView {
        private TextView cancelButton;
        private EditTextBoldCursor codeField;
        private TextView confirmTextView;
        private Bundle currentParams;
        private boolean nextPressed;
        private String passwordString;
        private String phoneCode;
        private String requestPhone;

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        public LoginActivityRecoverView(Context context) {
            super(context);
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.confirmTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.confirmTextView.setText(LocaleController.getString("RestoreEmailSentInfo", R.string.RestoreEmailSentInfo));
            addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.codeField = editTextBoldCursor;
            editTextBoldCursor.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.codeField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.codeField.setCursorWidth(1.5f);
            this.codeField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.codeField.setHint(LocaleController.getString("PasswordCode", R.string.PasswordCode));
            this.codeField.setImeOptions(268435461);
            this.codeField.setTextSize(1, 18.0f);
            this.codeField.setMaxLines(1);
            this.codeField.setPadding(0, 0, 0, 0);
            this.codeField.setInputType(3);
            this.codeField.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.codeField.setTypeface(AndroidUtilities.getFontFamily(false));
            this.codeField.setGravity(LocaleController.isRTL ? 5 : 3);
            addView(this.codeField, LayoutHelper.createLinear(-1, 36, 1, 0, 20, 0, 0));
            this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRecoverView$iM4Pl4Sih0t0ZvbE_gGY_JI0tVU
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$0$LoginActivity$LoginActivityRecoverView(textView2, i, keyEvent);
                }
            });
            TextView textView2 = new TextView(context);
            this.cancelButton = textView2;
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 80);
            this.cancelButton.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.cancelButton.setTextSize(1, 14.0f);
            this.cancelButton.setTypeface(AndroidUtilities.getFontFamily(false));
            this.cancelButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.cancelButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.cancelButton, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 80, 0, 0, 0, 14));
            this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRecoverView$knT_NpKMO0wW13ycGhva0ndp3JM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$2$LoginActivity$LoginActivityRecoverView(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$0$LoginActivity$LoginActivityRecoverView(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$2$LoginActivity$LoginActivityRecoverView(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
            builder.setMessage(LocaleController.getString("RestoreEmailTroubleText", R.string.RestoreEmailTroubleText));
            builder.setTitle(LocaleController.getString("RestorePasswordNoEmailTitle", R.string.RestorePasswordNoEmailTitle));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRecoverView$Bh55tg27G1GdoTLrT7XNePBsDYQ
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$new$1$LoginActivity$LoginActivityRecoverView(dialogInterface, i);
                }
            });
            Dialog dialogShowDialog = LoginActivity.this.showDialog(builder.create());
            if (dialogShowDialog != null) {
                dialogShowDialog.setCanceledOnTouchOutside(false);
                dialogShowDialog.setCancelable(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$LoginActivity$LoginActivityRecoverView(DialogInterface dialogInterface, int i) {
            LoginActivity.this.setPage(6, true, new Bundle(), true);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("LoginPassword", R.string.LoginPassword);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            if (params == null) {
                return;
            }
            this.codeField.setText("");
            this.currentParams = params;
            this.passwordString = params.getString("password");
            this.requestPhone = this.currentParams.getString("phoneFormated", null);
            this.phoneCode = params.getString("code", null);
            this.cancelButton.setText(LocaleController.formatString("RestoreEmailTrouble", R.string.RestoreEmailTrouble, this.currentParams.getString("email_unconfirmed_pattern")));
            AndroidUtilities.showKeyboard(this.codeField);
            this.codeField.requestFocus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onPasscodeError(boolean clear) {
            if (LoginActivity.this.getParentActivity() == null) {
                return;
            }
            Vibrator vibrator = (Vibrator) LoginActivity.this.getParentActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            if (clear) {
                this.codeField.setText("");
            }
            AndroidUtilities.shakeView(this.confirmTextView, 2.0f, 0);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            String string = this.codeField.getText().toString();
            if (string.length() == 0) {
                onPasscodeError(false);
                return;
            }
            this.nextPressed = true;
            LoginActivity.this.needShowProgress(0);
            TLRPC$TL_auth_recoverPassword_layer84 tLRPC$TL_auth_recoverPassword_layer84 = new TLRPC$TL_auth_recoverPassword_layer84();
            tLRPC$TL_auth_recoverPassword_layer84.code = string;
            String str = this.requestPhone;
            if (str != null) {
                tLRPC$TL_auth_recoverPassword_layer84.phone_number = str;
                tLRPC$TL_auth_recoverPassword_layer84.flags |= 2;
            }
            String str2 = this.phoneCode;
            if (str2 != null) {
                tLRPC$TL_auth_recoverPassword_layer84.phone_code = str2;
                tLRPC$TL_auth_recoverPassword_layer84.flags |= 1;
            }
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_recoverPassword_layer84, new RequestDelegate() { // from class: ir.eitaa.ui.LoginActivity.LoginActivityRecoverView.1
                @Override // ir.eitaa.tgnet.RequestDelegate
                public void run(final TLObject response, final TLRPC$TL_error error) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.LoginActivity.LoginActivityRecoverView.1.1
                        @Override // java.lang.Runnable
                        public void run() throws InterruptedException {
                            String pluralString;
                            LoginActivity.this.needHideProgress(false);
                            LoginActivityRecoverView.this.nextPressed = false;
                            TLRPC$TL_error tLRPC$TL_error = error;
                            if (tLRPC$TL_error == null) {
                                LoginActivity.this.onAuthSuccess((TLRPC$TL_auth_authorization) response);
                                return;
                            }
                            if (tLRPC$TL_error.text.startsWith("CODE_INVALID")) {
                                LoginActivityRecoverView.this.onPasscodeError(true);
                                return;
                            }
                            if (!error.text.startsWith("FLOOD_WAIT")) {
                                LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), error.text);
                                return;
                            }
                            int iIntValue = Utilities.parseInt(error.text).intValue();
                            if (iIntValue < 60) {
                                pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                            } else {
                                pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                            }
                            LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                        }
                    });
                }
            }, 10);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean onBackPressed(boolean force) {
            LoginActivity.this.needHideProgress(true);
            this.currentParams = null;
            this.nextPressed = false;
            return true;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRecoverView$RAI0s_fQQyymSCqjhr2v8ZFEjYs
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$3$LoginActivity$LoginActivityRecoverView();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onShow$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onShow$3$LoginActivity$LoginActivityRecoverView() {
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            if (editTextBoldCursor != null) {
                editTextBoldCursor.requestFocus();
                EditTextBoldCursor editTextBoldCursor2 = this.codeField;
                editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            String string = this.codeField.getText().toString();
            if (string != null && string.length() != 0) {
                bundle.putString("recoveryview_code", string);
            }
            Bundle bundle2 = this.currentParams;
            if (bundle2 != null) {
                bundle.putBundle("recoveryview_params", bundle2);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle("recoveryview_params");
            this.currentParams = bundle2;
            if (bundle2 != null) {
                setParams(bundle2, true);
            }
            String string = bundle.getString("recoveryview_code");
            if (string != null) {
                this.codeField.setText(string);
            }
        }
    }

    public class LoginActivityNewPasswordView extends SlideView {
        private TextView cancelButton;
        private EditTextBoldCursor[] codeField;
        private TextView confirmTextView;
        private Bundle currentParams;
        private TLRPC$TL_account_password currentPassword;
        private int currentStage;
        private String emailCode;
        private String newPassword;
        private boolean nextPressed;
        private String passwordString;

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        public LoginActivityNewPasswordView(Context context, int stage) {
            super(context);
            this.currentStage = stage;
            setOrientation(1);
            this.codeField = new EditTextBoldCursor[stage == 1 ? 1 : 2];
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.confirmTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
            final int i = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i >= editTextBoldCursorArr.length) {
                    break;
                }
                editTextBoldCursorArr[i] = new EditTextBoldCursor(context);
                this.codeField[i].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.codeField[i].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                this.codeField[i].setCursorSize(AndroidUtilities.dp(20.0f));
                this.codeField[i].setCursorWidth(1.5f);
                this.codeField[i].setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
                this.codeField[i].setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
                this.codeField[i].setImeOptions(268435461);
                this.codeField[i].setTextSize(1, 18.0f);
                this.codeField[i].setTypeface(AndroidUtilities.getFontFamily(false));
                this.codeField[i].setMaxLines(1);
                this.codeField[i].setPadding(0, 0, 0, 0);
                if (stage == 0) {
                    this.codeField[i].setInputType(129);
                }
                this.codeField[i].setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.codeField[i].setTypeface(AndroidUtilities.getFontFamily(false));
                this.codeField[i].setGravity(LocaleController.isRTL ? 5 : 3);
                addView(this.codeField[i], LayoutHelper.createLinear(-1, 36, 1, 0, i == 0 ? 20 : 30, 0, 0));
                this.codeField[i].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$HfVuL9QBFZZ14519MXJ7XB2JY4k
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                        return this.f$0.lambda$new$0$LoginActivity$LoginActivityNewPasswordView(i, textView2, i2, keyEvent);
                    }
                });
                if (stage != 0) {
                    this.codeField[i].setHint(LocaleController.getString("PasswordHintPlaceholder", R.string.PasswordHintPlaceholder));
                } else if (i == 0) {
                    this.codeField[i].setHint(LocaleController.getString("PleaseEnterNewFirstPasswordHint", R.string.PleaseEnterNewFirstPasswordHint));
                } else {
                    this.codeField[i].setHint(LocaleController.getString("PleaseEnterNewSecondPasswordHint", R.string.PleaseEnterNewSecondPasswordHint));
                }
                i++;
            }
            if (stage == 0) {
                this.confirmTextView.setText(LocaleController.getString("PleaseEnterNewFirstPasswordLogin", R.string.PleaseEnterNewFirstPasswordLogin));
            } else {
                this.confirmTextView.setText(LocaleController.getString("PasswordHintTextLogin", R.string.PasswordHintTextLogin));
            }
            TextView textView2 = new TextView(context);
            this.cancelButton = textView2;
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 80);
            this.cancelButton.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.cancelButton.setTextSize(1, 14.0f);
            this.cancelButton.setTypeface(AndroidUtilities.getFontFamily(false));
            this.cancelButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.cancelButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            this.cancelButton.setText(LocaleController.getString("YourEmailSkip", R.string.YourEmailSkip));
            addView(this.cancelButton, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 80, 0, 6, 0, 14));
            this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$FlmnxFAgKjblOD1mQsbWojf0aBg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1$LoginActivity$LoginActivityNewPasswordView(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$0$LoginActivity$LoginActivityNewPasswordView(int i, TextView textView, int i2, KeyEvent keyEvent) {
            if (i == 0) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (editTextBoldCursorArr.length == 2) {
                    editTextBoldCursorArr[1].requestFocus();
                    return true;
                }
            }
            if (i2 != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$1$LoginActivity$LoginActivityNewPasswordView(View view) {
            if (this.currentStage == 0) {
                recoverPassword(null, null);
            } else {
                recoverPassword(this.newPassword, null);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("NewPassword", R.string.NewPassword);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            if (params == null) {
                return;
            }
            int i = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i >= editTextBoldCursorArr.length) {
                    break;
                }
                editTextBoldCursorArr[i].setText("");
                i++;
            }
            this.currentParams = params;
            this.emailCode = params.getString("emailCode");
            String string = this.currentParams.getString("password");
            this.passwordString = string;
            if (string != null) {
                SerializedData serializedData = new SerializedData(Utilities.hexToBytes(string));
                TLRPC$TL_account_password tLRPC$TL_account_passwordTLdeserialize = TLRPC$TL_account_password.TLdeserialize(serializedData, serializedData.readInt32(false), false);
                this.currentPassword = tLRPC$TL_account_passwordTLdeserialize;
                TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_passwordTLdeserialize);
            }
            this.newPassword = this.currentParams.getString("new_password");
            AndroidUtilities.showKeyboard(this.codeField[0]);
            this.codeField[0].requestFocus();
        }

        private void onPasscodeError(boolean clear, int num) {
            if (LoginActivity.this.getParentActivity() == null) {
                return;
            }
            Vibrator vibrator = (Vibrator) LoginActivity.this.getParentActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            AndroidUtilities.shakeView(this.codeField[num], 2.0f, 0);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            String string = this.codeField[0].getText().toString();
            if (string.length() == 0) {
                onPasscodeError(false, 0);
                return;
            }
            if (this.currentStage == 0) {
                if (!string.equals(this.codeField[1].getText().toString())) {
                    onPasscodeError(false, 1);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("emailCode", this.emailCode);
                bundle.putString("new_password", string);
                bundle.putString("password", this.passwordString);
                LoginActivity.this.setPage(10, true, bundle, false);
                return;
            }
            this.nextPressed = true;
            LoginActivity.this.needShowProgress(0);
            recoverPassword(this.newPassword, string);
        }

        private void recoverPassword(final String password, final String hint) {
            final TLRPC$TL_auth_recoverPassword tLRPC$TL_auth_recoverPassword = new TLRPC$TL_auth_recoverPassword();
            tLRPC$TL_auth_recoverPassword.code = this.emailCode;
            if (!TextUtils.isEmpty(password)) {
                tLRPC$TL_auth_recoverPassword.flags |= 1;
                TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = new TLRPC$TL_account_passwordInputSettings();
                tLRPC$TL_auth_recoverPassword.new_settings = tLRPC$TL_account_passwordInputSettings;
                tLRPC$TL_account_passwordInputSettings.flags |= 1;
                tLRPC$TL_account_passwordInputSettings.hint = hint != null ? hint : "";
                tLRPC$TL_account_passwordInputSettings.new_algo = this.currentPassword.new_algo;
            }
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$97_FE-7IQiFOMgKFAKdZpv7s5s8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$recoverPassword$7$LoginActivity$LoginActivityNewPasswordView(password, hint, tLRPC$TL_auth_recoverPassword);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$recoverPassword$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$recoverPassword$7$LoginActivity$LoginActivityNewPasswordView(final String str, final String str2, TLRPC$TL_auth_recoverPassword tLRPC$TL_auth_recoverPassword) {
            byte[] stringBytes = str != null ? AndroidUtilities.getStringBytes(str) : null;
            RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$sWjzb8foCrA3LMzoiRC_UbrXPaI
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$recoverPassword$6$LoginActivity$LoginActivityNewPasswordView(str, str2, tLObject, tLRPC$TL_error);
                }
            };
            TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = this.currentPassword.new_algo;
            if (tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
                if (str != null) {
                    tLRPC$TL_auth_recoverPassword.new_settings.new_password_hash = SRPHelper.getVBytes(stringBytes, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo);
                    if (tLRPC$TL_auth_recoverPassword.new_settings.new_password_hash == null) {
                        TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                        tLRPC$TL_error.text = "ALGO_INVALID";
                        requestDelegate.run(null, tLRPC$TL_error);
                    }
                }
                ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_recoverPassword, requestDelegate, 10);
                return;
            }
            TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
            tLRPC$TL_error2.text = "PASSWORD_HASH_INVALID";
            requestDelegate.run(null, tLRPC$TL_error2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$recoverPassword$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$recoverPassword$6$LoginActivity$LoginActivityNewPasswordView(final String str, final String str2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$BX8c3-hgyz8SkWAJOHNG17KF_6U
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$recoverPassword$5$LoginActivity$LoginActivityNewPasswordView(tLRPC$TL_error, str, str2, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$recoverPassword$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$recoverPassword$5$LoginActivity$LoginActivityNewPasswordView(TLRPC$TL_error tLRPC$TL_error, final String str, final String str2, final TLObject tLObject) {
            String pluralString;
            if (tLRPC$TL_error == null || (!"SRP_ID_INVALID".equals(tLRPC$TL_error.text) && !"NEW_SALT_INVALID".equals(tLRPC$TL_error.text))) {
                LoginActivity.this.needHideProgress(false);
                if (tLObject instanceof TLRPC$auth_Authorization) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
                    builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$Qdh-FepXpD1q8pmyOC-W256C4mY
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) throws InterruptedException {
                            this.f$0.lambda$recoverPassword$4$LoginActivity$LoginActivityNewPasswordView(tLObject, dialogInterface, i);
                        }
                    });
                    if (TextUtils.isEmpty(str)) {
                        builder.setMessage(LocaleController.getString("PasswordReset", R.string.PasswordReset));
                    } else {
                        builder.setMessage(LocaleController.getString("YourPasswordChangedSuccessText", R.string.YourPasswordChangedSuccessText));
                    }
                    builder.setTitle(LocaleController.getString("TwoStepVerificationTitle", R.string.TwoStepVerificationTitle));
                    Dialog dialogShowDialog = LoginActivity.this.showDialog(builder.create());
                    if (dialogShowDialog != null) {
                        dialogShowDialog.setCanceledOnTouchOutside(false);
                        dialogShowDialog.setCancelable(false);
                        return;
                    }
                    return;
                }
                if (tLRPC$TL_error != null) {
                    this.nextPressed = false;
                    if (!tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                        LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                        return;
                    }
                    int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
                    if (iIntValue < 60) {
                        pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                    } else {
                        pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                    }
                    LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                    return;
                }
                return;
            }
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$R1w-wdbD6e3zb3isjXTCUOz4HN8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$recoverPassword$3$LoginActivity$LoginActivityNewPasswordView(str, str2, tLObject2, tLRPC$TL_error2);
                }
            }, 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$recoverPassword$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$recoverPassword$3$LoginActivity$LoginActivityNewPasswordView(final String str, final String str2, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$-cjmqgHHOfbwPVJ6sInUhS7kzAA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$recoverPassword$2$LoginActivity$LoginActivityNewPasswordView(tLRPC$TL_error, tLObject, str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$recoverPassword$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$recoverPassword$2$LoginActivity$LoginActivityNewPasswordView(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str, String str2) {
            if (tLRPC$TL_error == null) {
                TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
                this.currentPassword = tLRPC$TL_account_password;
                TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
                recoverPassword(str, str2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$recoverPassword$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$recoverPassword$4$LoginActivity$LoginActivityNewPasswordView(TLObject tLObject, DialogInterface dialogInterface, int i) throws InterruptedException {
            LoginActivity.this.onAuthSuccess((TLRPC$TL_auth_authorization) tLObject);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean onBackPressed(boolean force) {
            LoginActivity.this.needHideProgress(true);
            this.currentParams = null;
            this.nextPressed = false;
            return true;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityNewPasswordView$fWD7QFw_S3S8A3V3AQ0_8OYOpUE
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$8$LoginActivity$LoginActivityNewPasswordView();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onShow$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onShow$8$LoginActivity$LoginActivityNewPasswordView() {
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            if (editTextBoldCursorArr != null) {
                editTextBoldCursorArr[0].requestFocus();
                EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                editTextBoldCursorArr2[0].setSelection(editTextBoldCursorArr2[0].length());
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            if (this.currentParams != null) {
                bundle.putBundle("recoveryview_params" + this.currentStage, this.currentParams);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle("recoveryview_params" + this.currentStage);
            this.currentParams = bundle2;
            if (bundle2 != null) {
                setParams(bundle2, true);
            }
        }
    }

    public class LoginActivityRegisterView extends SlideView implements ImageUpdater.ImageUpdaterDelegate {
        private TLRPC$FileLocation avatar;
        private TLRPC$FileLocation avatarBig;
        private AvatarDrawable avatarDrawable;
        private RLottieDrawable cameraDrawable;
        private Bundle currentParams;
        private EditTextBoldCursor firstNameField;
        private ImageUpdater imageUpdater;
        private EditTextBoldCursor lastNameField;
        private boolean nextPressed;
        private String phoneCode;
        private String phoneHash;
        private TextView privacyView;
        private String requestPhone;
        private TextView textView;
        private TextView wrongNumber;

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* synthetic */ void didStartUpload(boolean z) {
            ImageUpdater.ImageUpdaterDelegate.CC.$default$didStartUpload(this, z);
        }

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* bridge */ /* synthetic */ String getInitialSearchString() {
            return ImageUpdater.ImageUpdaterDelegate.CC.$default$getInitialSearchString(this);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* synthetic */ void onUploadProgressChanged(float f) {
            ImageUpdater.ImageUpdaterDelegate.CC.$default$onUploadProgressChanged(this, f);
        }

        public class LinkSpan extends ClickableSpan {
            public LinkSpan() {
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                LoginActivityRegisterView.this.showTermsOfService(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showTermsOfService(boolean needAccept) {
            if (LoginActivity.this.currentTermsOfService == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("TermsOfService", R.string.TermsOfService));
            if (needAccept) {
                builder.setPositiveButton(LocaleController.getString("Accept", R.string.Accept), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$Oe0GkeqV3qG8YzSlwBodGWc7Yl8
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showTermsOfService$0$LoginActivity$LoginActivityRegisterView(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Decline", R.string.Decline), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$D1UEs0HDXnm8VZHt0ro-hXnC1sI
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showTermsOfService$3$LoginActivity$LoginActivityRegisterView(dialogInterface, i);
                    }
                });
            } else {
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(LoginActivity.this.currentTermsOfService.text);
            MessageObject.addEntitiesToText(spannableStringBuilder, LoginActivity.this.currentTermsOfService.entities, false, false, false, false);
            builder.setMessage(spannableStringBuilder);
            LoginActivity.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showTermsOfService$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showTermsOfService$0$LoginActivity$LoginActivityRegisterView(DialogInterface dialogInterface, int i) {
            LoginActivity.this.currentTermsOfService.popup = false;
            onNextPressed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showTermsOfService$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showTermsOfService$3$LoginActivity$LoginActivityRegisterView(DialogInterface dialogInterface, int i) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("TermsOfService", R.string.TermsOfService));
            builder.setMessage(LocaleController.getString("TosDecline", R.string.TosDecline));
            builder.setPositiveButton(LocaleController.getString("SignUp", R.string.SignUp), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$l82lYtNh-lZ4DaMnUZVvj-jl8P4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.f$0.lambda$showTermsOfService$1$LoginActivity$LoginActivityRegisterView(dialogInterface2, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Decline", R.string.Decline), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$LWlSfh5dC091wjMtTNZUt4khC2c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.f$0.lambda$showTermsOfService$2$LoginActivity$LoginActivityRegisterView(dialogInterface2, i2);
                }
            });
            LoginActivity.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showTermsOfService$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showTermsOfService$1$LoginActivity$LoginActivityRegisterView(DialogInterface dialogInterface, int i) {
            LoginActivity.this.currentTermsOfService.popup = false;
            onNextPressed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$showTermsOfService$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$showTermsOfService$2$LoginActivity$LoginActivityRegisterView(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            LoginActivity.this.setPage(0, true, null, true);
        }

        public LoginActivityRegisterView(Context context) {
            super(context);
            this.nextPressed = false;
            setOrientation(1);
            ImageUpdater imageUpdater = new ImageUpdater(false);
            this.imageUpdater = imageUpdater;
            imageUpdater.setOpenWithFrontfaceCamera(true);
            this.imageUpdater.setSearchAvailable(false);
            this.imageUpdater.setUploadAfterSelect(false);
            ImageUpdater imageUpdater2 = this.imageUpdater;
            imageUpdater2.parentFragment = LoginActivity.this;
            imageUpdater2.setDelegate(this);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setText(LocaleController.getString("RegisterText2", R.string.RegisterText2));
            this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.textView.setTextSize(1, 14.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            addView(this.textView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 0, 0, 0, 0));
            FrameLayout frameLayout = new FrameLayout(context);
            addView(frameLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 21.0f, 0.0f, 0.0f));
            this.avatarDrawable = new AvatarDrawable();
            new Paint(1).setColor(1426063360);
            this.cameraDrawable = new RLottieDrawable(R.raw.camera, "2131623944", AndroidUtilities.dp(60.0f), AndroidUtilities.dp(60.0f), false, (int[]) null);
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.firstNameField = editTextBoldCursor;
            editTextBoldCursor.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.firstNameField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.firstNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.firstNameField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.firstNameField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.firstNameField.setCursorWidth(1.5f);
            this.firstNameField.setHint(LocaleController.getString("FirstName", R.string.FirstName));
            this.firstNameField.setImeOptions(268435461);
            this.firstNameField.setTextSize(1, 17.0f);
            this.firstNameField.setTypeface(AndroidUtilities.getFontFamily(false));
            this.firstNameField.setMaxLines(1);
            this.firstNameField.setInputType(8192);
            frameLayout.addView(this.firstNameField, LayoutHelper.createFrame(-1, 36.0f, 49, 20.0f, 5.0f, 20.0f, 0.0f));
            this.firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$8-Vw6A2XGubip7AgSc1Y69jYJTA
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$4$LoginActivity$LoginActivityRegisterView(textView2, i, keyEvent);
                }
            });
            EditTextBoldCursor editTextBoldCursor2 = new EditTextBoldCursor(context);
            this.lastNameField = editTextBoldCursor2;
            editTextBoldCursor2.setHint(LocaleController.getString("LastName", R.string.LastName));
            this.lastNameField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.lastNameField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.lastNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.lastNameField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.lastNameField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.lastNameField.setCursorWidth(1.5f);
            this.lastNameField.setImeOptions(268435462);
            this.lastNameField.setTextSize(1, 17.0f);
            this.lastNameField.setTypeface(AndroidUtilities.getFontFamily(false));
            this.lastNameField.setMaxLines(1);
            this.lastNameField.setInputType(8192);
            frameLayout.addView(this.lastNameField, LayoutHelper.createFrame(-1, 36.0f, 49, 20.0f, 51.0f, 20.0f, 0.0f));
            this.lastNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$pbsj3W12-DeURNNAsM3ajf3livc
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$5$LoginActivity$LoginActivityRegisterView(textView2, i, keyEvent);
                }
            });
            TextView textView2 = new TextView(context);
            this.wrongNumber = textView2;
            textView2.setText(LocaleController.getString("CancelRegistration", R.string.CancelRegistration));
            this.wrongNumber.setGravity((LocaleController.isRTL ? 5 : 3) | 1);
            this.wrongNumber.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.wrongNumber.setTextSize(1, 14.0f);
            this.wrongNumber.setTypeface(AndroidUtilities.getFontFamily(false));
            this.wrongNumber.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.wrongNumber.setPadding(0, AndroidUtilities.dp(24.0f), 0, 0);
            this.wrongNumber.setVisibility(8);
            addView(this.wrongNumber, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 20, 0, 0));
            this.wrongNumber.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$7Gf0gqmZj381BM_6_ZJCgx4V1Ew
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$6$LoginActivity$LoginActivityRegisterView(view);
                }
            });
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setClipToPadding(false);
            frameLayout2.setPadding(0, AndroidUtilities.dp(28.0f), AndroidUtilities.dp(100.0f), AndroidUtilities.dp(16.0f));
            addView(frameLayout2, LayoutHelper.createLinear(-1, -1, 83));
            TextView textView3 = new TextView(context);
            this.privacyView = textView3;
            textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.privacyView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
            this.privacyView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
            this.privacyView.setTextSize(1, 14.0f);
            this.privacyView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.privacyView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            VerticalPositionAutoAnimator.attach(this.privacyView);
            frameLayout2.addView(this.privacyView, LayoutHelper.createFrame(-2, -2, 83));
            String string = LocaleController.getString("TermsOfServiceLogin", R.string.TermsOfServiceLogin);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            int iIndexOf = string.indexOf(42);
            int iLastIndexOf = string.lastIndexOf(42);
            if (iIndexOf != -1 && iLastIndexOf != -1 && iIndexOf != iLastIndexOf) {
                spannableStringBuilder.replace(iLastIndexOf, iLastIndexOf + 1, (CharSequence) "");
                spannableStringBuilder.replace(iIndexOf, iIndexOf + 1, (CharSequence) "");
                spannableStringBuilder.setSpan(new LinkSpan(), iIndexOf, iLastIndexOf - 1, 33);
            }
            this.privacyView.setText(spannableStringBuilder);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$4$LoginActivity$LoginActivityRegisterView(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            this.lastNameField.requestFocus();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$new$5$LoginActivity$LoginActivityRegisterView(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$6$LoginActivity$LoginActivityRegisterView(View view) {
            if (LoginActivity.this.doneProgressView.getTag() != null) {
                return;
            }
            onBackPressed(false);
        }

        @Override // ir.eitaa.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void didUploadPhoto(final TLRPC$InputFile photo, final TLRPC$InputFile video, double videoStartTimestamp, String videoPath, final TLRPC$PhotoSize bigSize, final TLRPC$PhotoSize smallSize) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$zjpoLFhIfkkc8VCKtBzt05cN_UY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$7$LoginActivity$LoginActivityRegisterView(smallSize, bigSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$didUploadPhoto$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$didUploadPhoto$7$LoginActivity$LoginActivityRegisterView(TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
            this.avatar = tLRPC$PhotoSize.location;
            this.avatarBig = tLRPC$PhotoSize2.location;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean onBackPressed(boolean force) {
            if (force) {
                LoginActivity.this.needHideProgress(true);
                this.nextPressed = false;
                this.currentParams = null;
                return true;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this.getParentActivity());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("AreYouSureRegistration", R.string.AreYouSureRegistration));
            builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$99ejP-XRx99gJLDTTcobzIT4_RM
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onBackPressed$8$LoginActivity$LoginActivityRegisterView(dialogInterface, i);
                }
            });
            builder.setPositiveButton(LocaleController.getString("Continue", R.string.Continue), null);
            LoginActivity.this.showDialog(builder.create());
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onBackPressed$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onBackPressed$8$LoginActivity$LoginActivityRegisterView(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            LoginActivity.this.setPage(0, true, null, true);
            hidePrivacyView();
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("YourName", R.string.YourName);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            if (this.privacyView != null) {
                if (LoginActivity.this.restoringState) {
                    this.privacyView.setAlpha(1.0f);
                } else {
                    this.privacyView.setAlpha(0.0f);
                    this.privacyView.animate().alpha(1.0f).setDuration(200L).setStartDelay(300L).setInterpolator(AndroidUtilities.decelerateInterpolator).start();
                }
            }
            EditTextBoldCursor editTextBoldCursor = this.firstNameField;
            if (editTextBoldCursor != null) {
                editTextBoldCursor.requestFocus();
                EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
                editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$_fzNeRIK5Ls3GfBaxlKZq4lwdtY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$9$LoginActivity$LoginActivityRegisterView();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onShow$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onShow$9$LoginActivity$LoginActivityRegisterView() {
            EditTextBoldCursor editTextBoldCursor = this.firstNameField;
            if (editTextBoldCursor != null) {
                editTextBoldCursor.requestFocus();
                EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
                editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            if (params == null) {
                return;
            }
            this.firstNameField.setText("");
            this.lastNameField.setText("");
            this.requestPhone = params.getString("phoneFormated");
            this.phoneHash = params.getString("phoneHash");
            this.phoneCode = params.getString("code");
            this.currentParams = params;
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            if (LoginActivity.this.currentTermsOfService != null && LoginActivity.this.currentTermsOfService.popup) {
                showTermsOfService(true);
                return;
            }
            if (this.firstNameField.length() == 0) {
                LoginActivity.this.onFieldError(this.firstNameField);
                return;
            }
            this.nextPressed = true;
            TLRPC$TL_auth_signUp_layer84 tLRPC$TL_auth_signUp_layer84 = new TLRPC$TL_auth_signUp_layer84();
            tLRPC$TL_auth_signUp_layer84.phone_code = this.phoneCode;
            tLRPC$TL_auth_signUp_layer84.phone_code_hash = this.phoneHash;
            tLRPC$TL_auth_signUp_layer84.phone_number = this.requestPhone;
            tLRPC$TL_auth_signUp_layer84.first_name = this.firstNameField.getText().toString();
            tLRPC$TL_auth_signUp_layer84.last_name = this.lastNameField.getText().toString();
            LoginActivity.this.needShowProgress(0);
            ConnectionsManager.getInstance(((BaseFragment) LoginActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_signUp_layer84, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$wEF7Q1TvJ8Z9S8M6rihKodIX7kQ
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$12$LoginActivity$LoginActivityRegisterView(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$12, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$12$LoginActivity$LoginActivityRegisterView(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$HPpdfjV05vEgGeuo3WjTVQkf8wA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$11$LoginActivity$LoginActivityRegisterView(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$11, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$11$LoginActivity$LoginActivityRegisterView(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            this.nextPressed = false;
            if (!(tLObject instanceof TLRPC$TL_auth_authorization)) {
                LoginActivity.this.needHideProgress(false);
                if (tLRPC$TL_error.text.contains("PHONE_NUMBER_INVALID")) {
                    LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                    return;
                }
                if (tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") || tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                    LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
                    return;
                }
                if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                    LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired));
                    return;
                }
                if (tLRPC$TL_error.text.contains("FIRSTNAME_INVALID")) {
                    LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidFirstName", R.string.InvalidFirstName));
                    return;
                } else if (tLRPC$TL_error.text.contains("LASTNAME_INVALID")) {
                    LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidLastName", R.string.InvalidLastName));
                    return;
                } else {
                    LoginActivity.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                    return;
                }
            }
            hidePrivacyView();
            LoginActivity.this.showDoneButton(false, true);
            postDelayed(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$LoginActivityRegisterView$8CyU-eVp5JvaQntF3HBCEo7Yw6E
                @Override // java.lang.Runnable
                public final void run() throws InterruptedException {
                    this.f$0.lambda$onNextPressed$10$LoginActivity$LoginActivityRegisterView(tLObject);
                }
            }, 150L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$10, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$10$LoginActivity$LoginActivityRegisterView(TLObject tLObject) throws InterruptedException {
            LoginActivity.this.needHideProgress(false, false);
            AndroidUtilities.hideKeyboard(((BaseFragment) LoginActivity.this).fragmentView.findFocus());
            LoginActivity.this.onAuthSuccess((TLRPC$TL_auth_authorization) tLObject, true);
            if (this.avatarBig != null) {
                MessagesController.getInstance(((BaseFragment) LoginActivity.this).currentAccount).uploadAndApplyUserAvatar(this.avatarBig);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            String string = this.firstNameField.getText().toString();
            if (string.length() != 0) {
                bundle.putString("registerview_first", string);
            }
            String string2 = this.lastNameField.getText().toString();
            if (string2.length() != 0) {
                bundle.putString("registerview_last", string2);
            }
            if (LoginActivity.this.currentTermsOfService != null) {
                SerializedData serializedData = new SerializedData(LoginActivity.this.currentTermsOfService.getObjectSize());
                LoginActivity.this.currentTermsOfService.serializeToStream(serializedData);
                bundle.putString("terms", Base64.encodeToString(serializedData.toByteArray(), 0));
                serializedData.cleanup();
            }
            Bundle bundle2 = this.currentParams;
            if (bundle2 != null) {
                bundle.putBundle("registerview_params", bundle2);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            byte[] bArrDecode;
            Bundle bundle2 = bundle.getBundle("registerview_params");
            this.currentParams = bundle2;
            if (bundle2 != null) {
                setParams(bundle2, true);
            }
            try {
                String string = bundle.getString("terms");
                if (string != null && (bArrDecode = Base64.decode(string, 0)) != null) {
                    SerializedData serializedData = new SerializedData(bArrDecode);
                    LoginActivity.this.currentTermsOfService = TLRPC$TL_help_termsOfService.TLdeserialize(serializedData, serializedData.readInt32(false), false);
                    serializedData.cleanup();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
            String string2 = bundle.getString("registerview_first");
            if (string2 != null) {
                this.firstNameField.setText(string2);
            }
            String string3 = bundle.getString("registerview_last");
            if (string3 != null) {
                this.lastNameField.setText(string3);
            }
        }

        private void hidePrivacyView() {
            this.privacyView.animate().alpha(0.0f).setDuration(150L).setStartDelay(0L).setInterpolator(AndroidUtilities.accelerateInterpolator).start();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i < slideViewArr.length) {
                if (slideViewArr[i] == null) {
                    return new ArrayList<>();
                }
                i++;
            } else {
                PhoneView phoneView = (PhoneView) slideViewArr[0];
                LoginActivitySmsView loginActivitySmsView = (LoginActivitySmsView) slideViewArr[1];
                LoginActivitySmsView loginActivitySmsView2 = (LoginActivitySmsView) slideViewArr[2];
                LoginActivitySmsView loginActivitySmsView3 = (LoginActivitySmsView) slideViewArr[3];
                LoginActivitySmsView loginActivitySmsView4 = (LoginActivitySmsView) slideViewArr[4];
                LoginActivityRegisterView loginActivityRegisterView = (LoginActivityRegisterView) slideViewArr[5];
                LoginActivityPasswordView loginActivityPasswordView = (LoginActivityPasswordView) slideViewArr[6];
                LoginActivityRecoverView loginActivityRecoverView = (LoginActivityRecoverView) slideViewArr[7];
                LoginActivityResetWaitView loginActivityResetWaitView = (LoginActivityResetWaitView) slideViewArr[8];
                ArrayList<ThemeDescription> arrayList = new ArrayList<>();
                ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LoginActivity$aQC4hTQV_D9kkHThnieIfTi6Pz4
                    @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                    public final void didSetColor() {
                        this.f$0.lambda$getThemeDescriptions$4$LoginActivity();
                    }

                    @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                    public /* synthetic */ void onAnimationProgress(float f) {
                        ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
                    }
                };
                arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
                arrayList.add(new ThemeDescription(this.floatingButtonIcon, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionIcon"));
                arrayList.add(new ThemeDescription(this.floatingButtonIcon, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "chats_actionBackground"));
                arrayList.add(new ThemeDescription(this.floatingButtonIcon, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "chats_actionPressedBackground"));
                arrayList.add(new ThemeDescription(this.floatingProgressView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "chats_actionIcon"));
                arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
                arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
                arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
                arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
                arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
                arrayList.add(new ThemeDescription(phoneView.countryButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(phoneView.countryButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "listSelectorSDK21"));
                arrayList.add(new ThemeDescription(phoneView.view, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhiteGrayLine"));
                arrayList.add(new ThemeDescription(phoneView.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(phoneView.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(phoneView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(phoneView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(phoneView.textView2, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.codeField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.cancelButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.resetAccountButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteRedText6"));
                arrayList.add(new ThemeDescription(loginActivityPasswordView.resetAccountText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.firstNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.firstNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.lastNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.lastNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.wrongNumber, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.privacyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityRegisterView.privacyView, ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, "windowBackgroundWhiteLinkText"));
                arrayList.add(new ThemeDescription(loginActivityRecoverView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityRecoverView.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivityRecoverView.codeField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(loginActivityRecoverView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(loginActivityRecoverView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(loginActivityRecoverView.cancelButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                arrayList.add(new ThemeDescription(loginActivityResetWaitView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityResetWaitView.resetAccountText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityResetWaitView.resetAccountTime, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityResetWaitView.resetAccountButton, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivityResetWaitView.resetAccountButton, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, "windowBackgroundWhiteRedText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                if (loginActivitySmsView.codeField != null) {
                    for (int i2 = 0; i2 < loginActivitySmsView.codeField.length; i2++) {
                        arrayList.add(new ThemeDescription(loginActivitySmsView.codeField[i2], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                        arrayList.add(new ThemeDescription(loginActivitySmsView.codeField[i2], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                    }
                }
                arrayList.add(new ThemeDescription(loginActivitySmsView.timeText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressInner"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressOuter"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.blackImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionBackground"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                if (loginActivitySmsView2.codeField != null) {
                    for (int i3 = 0; i3 < loginActivitySmsView2.codeField.length; i3++) {
                        arrayList.add(new ThemeDescription(loginActivitySmsView2.codeField[i3], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                        arrayList.add(new ThemeDescription(loginActivitySmsView2.codeField[i3], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                    }
                }
                arrayList.add(new ThemeDescription(loginActivitySmsView2.timeText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressInner"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressOuter"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.blackImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionBackground"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                if (loginActivitySmsView3.codeField != null) {
                    for (int i4 = 0; i4 < loginActivitySmsView3.codeField.length; i4++) {
                        arrayList.add(new ThemeDescription(loginActivitySmsView3.codeField[i4], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                        arrayList.add(new ThemeDescription(loginActivitySmsView3.codeField[i4], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                    }
                }
                arrayList.add(new ThemeDescription(loginActivitySmsView3.timeText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressInner"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressOuter"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.blackImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionBackground"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                if (loginActivitySmsView4.codeField != null) {
                    for (int i5 = 0; i5 < loginActivitySmsView4.codeField.length; i5++) {
                        arrayList.add(new ThemeDescription(loginActivitySmsView4.codeField[i5], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                        arrayList.add(new ThemeDescription(loginActivitySmsView4.codeField[i5], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                    }
                }
                arrayList.add(new ThemeDescription(loginActivitySmsView4.timeText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressInner"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressOuter"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.blackImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionBackground"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.blueImageView, 0, null, null, null, themeDescriptionDelegate, "chats_actionBackground"));
                for (int i6 = 0; i6 < 2; i6++) {
                    SlideView[] slideViewArr2 = this.views;
                    int i7 = i6 + 9;
                    if (slideViewArr2[i7] != null) {
                        LoginActivityNewPasswordView loginActivityNewPasswordView = (LoginActivityNewPasswordView) slideViewArr2[i7];
                        arrayList.add(new ThemeDescription(loginActivityNewPasswordView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
                        for (int i8 = 0; i8 < loginActivityNewPasswordView.codeField.length; i8++) {
                            arrayList.add(new ThemeDescription(loginActivityNewPasswordView.codeField[i8], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                            arrayList.add(new ThemeDescription(loginActivityNewPasswordView.codeField[i8], ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                            arrayList.add(new ThemeDescription(loginActivityNewPasswordView.codeField[i8], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
                            arrayList.add(new ThemeDescription(loginActivityNewPasswordView.codeField[i8], ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
                        }
                        arrayList.add(new ThemeDescription(loginActivityNewPasswordView.cancelButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
                    }
                }
                return arrayList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$4$LoginActivity() {
        LoginActivitySmsView loginActivitySmsView;
        RLottieDrawable rLottieDrawable;
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                return;
            }
            if ((slideViewArr[i] instanceof LoginActivitySmsView) && (rLottieDrawable = (loginActivitySmsView = (LoginActivitySmsView) slideViewArr[i]).hintDrawable) != null) {
                rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor("chats_actionBackground"));
                loginActivitySmsView.hintDrawable.setLayerColor("Phone.**", Theme.getColor("chats_actionBackground"));
            }
            i++;
        }
    }
}
