package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.BuildVars;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_confirmPhone;
import ir.eitaa.tgnet.TLRPC$TL_account_sendConfirmPhoneCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeFlashCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_codeTypeSms;
import ir.eitaa.tgnet.TLRPC$TL_auth_resendCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCode;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeApp;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeFlashCall;
import ir.eitaa.tgnet.TLRPC$TL_auth_sentCodeTypeSms;
import ir.eitaa.tgnet.TLRPC$TL_codeSettings;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$auth_CodeType;
import ir.eitaa.tgnet.TLRPC$auth_SentCodeType;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RLottieDrawable;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RadialProgressView;
import ir.eitaa.ui.Components.SlideView;
import ir.eitaa.ui.Components.URLSpanNoUnderline;
import ir.eitaa.ui.LoginActivity;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class CancelAccountDeletionActivity extends BaseFragment {
    private int currentViewNum;
    private View doneButton;
    private Dialog errorDialog;
    private String hash;
    private String phone;
    private AlertDialog progressDialog;
    private int scrollHeight;
    private SlideView[] views;

    private static class ProgressView extends View {
        private Paint paint;
        private Paint paint2;
        private float progress;

        public ProgressView(Context context) {
            super(context);
            this.paint = new Paint();
            this.paint2 = new Paint();
            this.paint.setColor(Theme.getColor("login_progressInner"));
            this.paint2.setColor(Theme.getColor("login_progressOuter"));
        }

        public void setProgress(float value) {
            this.progress = value;
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float measuredWidth = (int) (getMeasuredWidth() * this.progress);
            canvas.drawRect(0.0f, 0.0f, measuredWidth, getMeasuredHeight(), this.paint2);
            canvas.drawRect(measuredWidth, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
        }
    }

    public CancelAccountDeletionActivity(Bundle args) {
        super(args);
        this.currentViewNum = 0;
        this.views = new SlideView[5];
        this.hash = args.getString("hash");
        this.phone = args.getString("phone");
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                break;
            }
            if (slideViewArr[i] != null) {
                slideViewArr[i].onDestroyActivity();
            }
            i++;
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
        this.actionBar.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.CancelAccountDeletionActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == 1) {
                    CancelAccountDeletionActivity.this.views[CancelAccountDeletionActivity.this.currentViewNum].onNextPressed();
                } else if (id == -1) {
                    CancelAccountDeletionActivity.this.finishFragment();
                }
            }
        });
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        this.doneButton = actionBarMenuItemAddItemWithWidth;
        actionBarMenuItemAddItemWithWidth.setVisibility(8);
        ScrollView scrollView = new ScrollView(context) { // from class: ir.eitaa.ui.CancelAccountDeletionActivity.2
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View child, Rect rectangle, boolean immediate) {
                if (CancelAccountDeletionActivity.this.currentViewNum == 1 || CancelAccountDeletionActivity.this.currentViewNum == 2 || CancelAccountDeletionActivity.this.currentViewNum == 4) {
                    rectangle.bottom += AndroidUtilities.dp(40.0f);
                }
                return super.requestChildRectangleOnScreen(child, rectangle, immediate);
            }

            @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                CancelAccountDeletionActivity.this.scrollHeight = View.MeasureSpec.getSize(heightMeasureSpec) - AndroidUtilities.dp(30.0f);
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        };
        scrollView.setFillViewport(true);
        this.fragmentView = scrollView;
        FrameLayout frameLayout = new FrameLayout(context);
        scrollView.addView(frameLayout, LayoutHelper.createScroll(-1, -2, 51));
        this.views[0] = new PhoneView(context);
        this.views[1] = new LoginActivitySmsView(context, 1);
        this.views[2] = new LoginActivitySmsView(context, 2);
        this.views[3] = new LoginActivitySmsView(context, 3);
        this.views[4] = new LoginActivitySmsView(context, 4);
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i < slideViewArr.length) {
                slideViewArr[i].setVisibility(i == 0 ? 0 : 8);
                frameLayout.addView(this.views[i], LayoutHelper.createFrame(-1, i == 0 ? -2.0f : -1.0f, 51, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 30.0f, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 0.0f));
                i++;
            } else {
                this.actionBar.setTitle(slideViewArr[0].getHeaderName());
                return this.fragmentView;
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        if (dialog == this.errorDialog) {
            finishFragment();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                return true;
            }
            if (slideViewArr[i] != null) {
                slideViewArr[i].onDestroyActivity();
            }
            i++;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen) {
            this.views[this.currentViewNum].onShow();
        }
    }

    public void needShowProgress() {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCacnel(false);
        this.progressDialog.show();
    }

    public void needHideProgress() {
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

    public void setPage(int page, boolean animated, Bundle params, boolean back) {
        if (page == 3 || page == 0) {
            this.doneButton.setVisibility(8);
        } else {
            this.doneButton.setVisibility(0);
        }
        SlideView[] slideViewArr = this.views;
        final SlideView slideView = slideViewArr[this.currentViewNum];
        final SlideView slideView2 = slideViewArr[page];
        this.currentViewNum = page;
        slideView2.setParams(params, false);
        this.actionBar.setTitle(slideView2.getHeaderName());
        slideView2.onShow();
        int i = AndroidUtilities.displaySize.x;
        if (back) {
            i = -i;
        }
        slideView2.setX(i);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(300L);
        Animator[] animatorArr = new Animator[2];
        float[] fArr = new float[1];
        fArr[0] = back ? AndroidUtilities.displaySize.x : -AndroidUtilities.displaySize.x;
        animatorArr[0] = ObjectAnimator.ofFloat(slideView, "translationX", fArr);
        animatorArr[1] = ObjectAnimator.ofFloat(slideView2, "translationX", 0.0f);
        animatorSet.playTogether(animatorArr);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.CancelAccountDeletionActivity.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                slideView2.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                slideView.setVisibility(8);
                slideView.setX(0.0f);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillNextCodeParams(Bundle params, TLRPC$TL_auth_sentCode res) {
        params.putString("phoneHash", res.phone_code_hash);
        TLRPC$auth_CodeType tLRPC$auth_CodeType = res.next_type;
        if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeCall) {
            params.putInt("nextType", 4);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeFlashCall) {
            params.putInt("nextType", 3);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeSms) {
            params.putInt("nextType", 2);
        }
        if (res.type instanceof TLRPC$TL_auth_sentCodeTypeApp) {
            params.putInt("type", 1);
            params.putInt("length", res.type.length);
            setPage(1, true, params, false);
            return;
        }
        if (res.timeout == 0) {
            res.timeout = 60;
        }
        params.putInt("timeout", res.timeout * 1000);
        TLRPC$auth_SentCodeType tLRPC$auth_SentCodeType = res.type;
        if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeCall) {
            params.putInt("type", 4);
            params.putInt("length", res.type.length);
            setPage(4, true, params, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeFlashCall) {
            params.putInt("type", 3);
            params.putString("pattern", res.type.pattern);
            setPage(3, true, params, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeSms) {
            params.putInt("type", 2);
            params.putInt("length", res.type.length);
            setPage(2, true, params, false);
        }
    }

    public class PhoneView extends SlideView {
        private boolean nextPressed;
        private RadialProgressView progressBar;

        public PhoneView(Context context) {
            super(context);
            this.nextPressed = false;
            setOrientation(1);
            FrameLayout frameLayout = new FrameLayout(context);
            addView(frameLayout, LayoutHelper.createLinear(-1, 200));
            RadialProgressView radialProgressView = new RadialProgressView(context);
            this.progressBar = radialProgressView;
            frameLayout.addView(radialProgressView, LayoutHelper.createFrame(-2, -2, 17));
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onNextPressed() {
            if (CancelAccountDeletionActivity.this.getParentActivity() == null || this.nextPressed) {
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            final TLRPC$TL_account_sendConfirmPhoneCode tLRPC$TL_account_sendConfirmPhoneCode = new TLRPC$TL_account_sendConfirmPhoneCode();
            tLRPC$TL_account_sendConfirmPhoneCode.hash = CancelAccountDeletionActivity.this.hash;
            TLRPC$TL_codeSettings tLRPC$TL_codeSettings = new TLRPC$TL_codeSettings();
            tLRPC$TL_account_sendConfirmPhoneCode.settings = tLRPC$TL_codeSettings;
            tLRPC$TL_codeSettings.allow_flashcall = false;
            tLRPC$TL_codeSettings.allow_app_hash = ApplicationLoader.hasPlayServices;
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
            if (tLRPC$TL_account_sendConfirmPhoneCode.settings.allow_app_hash) {
                sharedPreferences.edit().putString("sms_hash", BuildVars.SMS_HASH).commit();
            } else {
                sharedPreferences.edit().remove("sms_hash").commit();
            }
            if (tLRPC$TL_account_sendConfirmPhoneCode.settings.allow_flashcall) {
                try {
                    String line1Number = telephonyManager.getLine1Number();
                    if (!TextUtils.isEmpty(line1Number)) {
                        tLRPC$TL_account_sendConfirmPhoneCode.settings.current_number = PhoneNumberUtils.compare(CancelAccountDeletionActivity.this.phone, line1Number);
                        TLRPC$TL_codeSettings tLRPC$TL_codeSettings2 = tLRPC$TL_account_sendConfirmPhoneCode.settings;
                        if (!tLRPC$TL_codeSettings2.current_number) {
                            tLRPC$TL_codeSettings2.allow_flashcall = false;
                        }
                    } else {
                        tLRPC$TL_account_sendConfirmPhoneCode.settings.current_number = false;
                    }
                } catch (Exception e) {
                    tLRPC$TL_account_sendConfirmPhoneCode.settings.allow_flashcall = false;
                    FileLog.e(e);
                }
            }
            final Bundle bundle = new Bundle();
            bundle.putString("phone", CancelAccountDeletionActivity.this.phone);
            this.nextPressed = true;
            ConnectionsManager.getInstance(((BaseFragment) CancelAccountDeletionActivity.this).currentAccount).sendRequest(tLRPC$TL_account_sendConfirmPhoneCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$PhoneView$rXPiHI8Mdzjsfsj-FeUK0wBPDgY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$1$CancelAccountDeletionActivity$PhoneView(bundle, tLRPC$TL_account_sendConfirmPhoneCode, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$1$CancelAccountDeletionActivity$PhoneView(final Bundle bundle, final TLRPC$TL_account_sendConfirmPhoneCode tLRPC$TL_account_sendConfirmPhoneCode, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$PhoneView$GAZsaRCNPmL5Nleajfp6lGwBq8c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$0$CancelAccountDeletionActivity$PhoneView(tLRPC$TL_error, bundle, tLObject, tLRPC$TL_account_sendConfirmPhoneCode);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$0$CancelAccountDeletionActivity$PhoneView(TLRPC$TL_error tLRPC$TL_error, Bundle bundle, TLObject tLObject, TLRPC$TL_account_sendConfirmPhoneCode tLRPC$TL_account_sendConfirmPhoneCode) {
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                CancelAccountDeletionActivity.this.fillNextCodeParams(bundle, (TLRPC$TL_auth_sentCode) tLObject);
            } else {
                CancelAccountDeletionActivity cancelAccountDeletionActivity = CancelAccountDeletionActivity.this;
                cancelAccountDeletionActivity.errorDialog = AlertsCreator.processError(((BaseFragment) cancelAccountDeletionActivity).currentAccount, tLRPC$TL_error, CancelAccountDeletionActivity.this, tLRPC$TL_account_sendConfirmPhoneCode, new Object[0]);
            }
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("CancelAccountReset", R.string.CancelAccountReset);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            onNextPressed();
        }
    }

    public class LoginActivitySmsView extends SlideView implements NotificationCenter.NotificationCenterDelegate {
        private ImageView blackImageView;
        private RLottieImageView blueImageView;
        private EditTextBoldCursor[] codeField;
        private LinearLayout codeFieldContainer;
        private int codeTime;
        private Timer codeTimer;
        private TextView confirmTextView;
        private int currentType;
        RLottieDrawable hintDrawable;
        private boolean ignoreOnTextChange;
        private double lastCodeTime;
        private double lastCurrentTime;
        private String lastError;
        private int length;
        private boolean nextPressed;
        private int nextType;
        private String pattern;
        private String phone;
        private String phoneHash;
        private TextView problemText;
        private ProgressView progressView;
        private int time;
        private TextView timeText;
        private Timer timeTimer;
        private int timeout;
        private final Object timerSync;
        private TextView titleTextView;
        private boolean waitingForEvent;

        @Override // ir.eitaa.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        static /* synthetic */ int access$1526(LoginActivitySmsView loginActivitySmsView, double d) {
            double d2 = loginActivitySmsView.codeTime;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            loginActivitySmsView.codeTime = i;
            return i;
        }

        static /* synthetic */ int access$2126(LoginActivitySmsView loginActivitySmsView, double d) {
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
            textView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
            this.confirmTextView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText6"));
            this.confirmTextView.setHighlightColor(Theme.getColor("windowBackgroundWhiteLinkSelection"));
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
                    RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.sms_incoming_info, "2131624023", AndroidUtilities.dp(48.0f), AndroidUtilities.dp(48.0f), true, (int[]) null);
                    this.hintDrawable = rLottieDrawable;
                    rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor("chats_actionBackground"));
                    this.hintDrawable.setLayerColor("Phone.**", Theme.getColor("chats_actionBackground"));
                    this.blueImageView.setAnimation(this.hintDrawable);
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(48, 48.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
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
            TextView textView3 = new TextView(context) { // from class: ir.eitaa.ui.CancelAccountDeletionActivity.LoginActivitySmsView.1
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
                this.timeText.setPadding(0, AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(10.0f));
                this.timeText.setTextSize(1, 15.0f);
                this.timeText.setTypeface(AndroidUtilities.getFontFamily(false));
                this.timeText.setGravity(49);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, 49));
            }
            TextView textView4 = new TextView(context) { // from class: ir.eitaa.ui.CancelAccountDeletionActivity.LoginActivitySmsView.2
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.problemText = textView4;
            textView4.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
            this.problemText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.problemText.setPadding(0, AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(10.0f));
            this.problemText.setTextSize(1, 15.0f);
            this.problemText.setTypeface(AndroidUtilities.getFontFamily(false));
            this.problemText.setGravity(49);
            if (this.currentType == 1) {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCodeSms", R.string.DidNotGetTheCodeSms));
            } else {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCode", R.string.DidNotGetTheCode));
            }
            addView(this.problemText, LayoutHelper.createLinear(-2, -2, 49));
            this.problemText.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$7MZRO24dxUBYKwhVX8Pt2U-HPkw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws PackageManager.NameNotFoundException {
                    this.f$0.lambda$new$0$CancelAccountDeletionActivity$LoginActivitySmsView(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$CancelAccountDeletionActivity$LoginActivitySmsView(View view) throws PackageManager.NameNotFoundException {
            if (this.nextPressed) {
                return;
            }
            int i = this.nextType;
            if (!((i == 4 && this.currentType == 2) || i == 0)) {
                resendCode();
                return;
            }
            try {
                PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
                String str = String.format(Locale.US, "%s (%d)", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"reports@stel.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Android cancel account deletion issue " + str + " " + this.phone);
                intent.putExtra("android.intent.extra.TEXT", "Phone: " + this.phone + "\nApp version: " + str + "\nOS version: SDK " + Build.VERSION.SDK_INT + "\nDevice Name: " + Build.MANUFACTURER + Build.MODEL + "\nLocale: " + Locale.getDefault() + "\nError: " + this.lastError);
                getContext().startActivity(Intent.createChooser(intent, "Send email..."));
            } catch (Exception unused) {
                AlertsCreator.showSimpleAlert(CancelAccountDeletionActivity.this, LocaleController.getString("NoMailInstalled", R.string.NoMailInstalled));
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            RLottieImageView rLottieImageView;
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            if (this.currentType == 3 || (rLottieImageView = this.blueImageView) == null) {
                return;
            }
            int measuredHeight = rLottieImageView.getMeasuredHeight() + this.titleTextView.getMeasuredHeight() + this.confirmTextView.getMeasuredHeight() + AndroidUtilities.dp(35.0f);
            if (this.timeText.getVisibility() == 0) {
                measuredHeight += this.timeText.getMeasuredHeight();
            }
            int iDp = AndroidUtilities.dp(80.0f);
            int iDp2 = AndroidUtilities.dp(340.0f);
            if (CancelAccountDeletionActivity.this.scrollHeight - measuredHeight >= iDp) {
                setMeasuredDimension(getMeasuredWidth(), Math.min(CancelAccountDeletionActivity.this.scrollHeight, iDp2));
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

        /* JADX INFO: Access modifiers changed from: private */
        public void resendCode() {
            final Bundle bundle = new Bundle();
            bundle.putString("phone", this.phone);
            this.nextPressed = true;
            CancelAccountDeletionActivity.this.needShowProgress();
            final TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
            tLRPC$TL_auth_resendCode.phone_number = this.phone;
            tLRPC$TL_auth_resendCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) CancelAccountDeletionActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$Pb4Z3TjapTukPiWGdIXAT0j6KXY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$resendCode$3$CancelAccountDeletionActivity$LoginActivitySmsView(bundle, tLRPC$TL_auth_resendCode, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$3$CancelAccountDeletionActivity$LoginActivitySmsView(final Bundle bundle, final TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$tuH1MBHXI0IUzB8f-2sEl5dqCGk
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resendCode$2$CancelAccountDeletionActivity$LoginActivitySmsView(tLRPC$TL_error, bundle, tLObject, tLRPC$TL_auth_resendCode);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$2$CancelAccountDeletionActivity$LoginActivitySmsView(TLRPC$TL_error tLRPC$TL_error, Bundle bundle, TLObject tLObject, TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode) {
            AlertDialog alertDialog;
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                CancelAccountDeletionActivity.this.fillNextCodeParams(bundle, (TLRPC$TL_auth_sentCode) tLObject);
            } else if (tLRPC$TL_error.text != null && (alertDialog = (AlertDialog) AlertsCreator.processError(((BaseFragment) CancelAccountDeletionActivity.this).currentAccount, tLRPC$TL_error, CancelAccountDeletionActivity.this, tLRPC$TL_auth_resendCode, new Object[0])) != null && tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                alertDialog.setPositiveButtonListener(new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$RllAzIB_tVWAKEnlQRJwcwp_fWM
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$resendCode$1$CancelAccountDeletionActivity$LoginActivitySmsView(dialogInterface, i);
                    }
                });
            }
            CancelAccountDeletionActivity.this.needHideProgress();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$resendCode$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$resendCode$1$CancelAccountDeletionActivity$LoginActivitySmsView(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            CancelAccountDeletionActivity.this.finishFragment();
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public String getHeaderName() {
            if (this.currentType == 1) {
                return this.phone;
            }
            return LocaleController.getString("CancelAccountReset", R.string.CancelAccountReset);
        }

        @Override // ir.eitaa.ui.Components.SlideView
        public void setParams(Bundle params, boolean restore) {
            int i;
            int i2;
            if (params == null) {
                return;
            }
            this.waitingForEvent = true;
            int i3 = this.currentType;
            if (i3 == 2) {
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i3 == 3) {
                AndroidUtilities.setWaitingForCall(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
            }
            this.phone = params.getString("phone");
            this.phoneHash = params.getString("phoneHash");
            int i4 = params.getInt("timeout");
            this.time = i4;
            this.timeout = i4;
            this.nextType = params.getInt("nextType");
            this.pattern = params.getString("pattern");
            int i5 = params.getInt("length");
            this.length = i5;
            if (i5 == 0) {
                this.length = 5;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            if (editTextBoldCursorArr != null && editTextBoldCursorArr.length == this.length) {
                int i6 = 0;
                while (true) {
                    EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                    if (i6 >= editTextBoldCursorArr2.length) {
                        break;
                    }
                    editTextBoldCursorArr2[i6].setText("");
                    i6++;
                }
            } else {
                this.codeField = new EditTextBoldCursor[this.length];
                final int i7 = 0;
                while (i7 < this.length) {
                    this.codeField[i7] = new EditTextBoldCursor(getContext());
                    this.codeField[i7].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                    this.codeField[i7].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
                    this.codeField[i7].setCursorSize(AndroidUtilities.dp(20.0f));
                    this.codeField[i7].setTypeface(AndroidUtilities.getFontFamily(false));
                    this.codeField[i7].setCursorWidth(1.5f);
                    Drawable drawableMutate = getResources().getDrawable(R.drawable.search_dark_activated).mutate();
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor("windowBackgroundWhiteInputFieldActivated"), PorterDuff.Mode.MULTIPLY));
                    this.codeField[i7].setBackgroundDrawable(drawableMutate);
                    this.codeField[i7].setImeOptions(268435461);
                    this.codeField[i7].setTextSize(1, 20.0f);
                    this.codeField[i7].setMaxLines(1);
                    this.codeField[i7].setTypeface(AndroidUtilities.getFontFamily(true));
                    this.codeField[i7].setPadding(0, 0, 0, 0);
                    this.codeField[i7].setGravity(49);
                    if (this.currentType == 3) {
                        this.codeField[i7].setEnabled(false);
                        this.codeField[i7].setInputType(0);
                        this.codeField[i7].setVisibility(8);
                    } else {
                        this.codeField[i7].setInputType(3);
                    }
                    this.codeFieldContainer.addView(this.codeField[i7], LayoutHelper.createLinear(34, 36, 1, 0, 0, i7 != this.length - 1 ? 7 : 0, 0));
                    this.codeField[i7].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.CancelAccountDeletionActivity.LoginActivitySmsView.3
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
                                    String string = s.toString();
                                    LoginActivitySmsView.this.ignoreOnTextChange = true;
                                    for (int i8 = 0; i8 < Math.min(LoginActivitySmsView.this.length - i7, length); i8++) {
                                        if (i8 != 0) {
                                            LoginActivitySmsView.this.codeField[i7 + i8].setText(string.substring(i8, i8 + 1));
                                        } else {
                                            s.replace(0, length, string.substring(i8, i8 + 1));
                                        }
                                    }
                                    LoginActivitySmsView.this.ignoreOnTextChange = false;
                                }
                                if (i7 != LoginActivitySmsView.this.length - 1) {
                                    LoginActivitySmsView.this.codeField[i7 + 1].setSelection(LoginActivitySmsView.this.codeField[i7 + 1].length());
                                    LoginActivitySmsView.this.codeField[i7 + 1].requestFocus();
                                }
                                if ((i7 == LoginActivitySmsView.this.length - 1 || (i7 == LoginActivitySmsView.this.length - 2 && length >= 2)) && LoginActivitySmsView.this.getCode().length() == LoginActivitySmsView.this.length) {
                                    LoginActivitySmsView.this.onNextPressed();
                                }
                            }
                        }
                    });
                    this.codeField[i7].setOnKeyListener(new View.OnKeyListener() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$QfxhFY8k9G8sWlF4IKIPJs0fbzg
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i8, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$4$CancelAccountDeletionActivity$LoginActivitySmsView(i7, view, i8, keyEvent);
                        }
                    });
                    this.codeField[i7].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$eDRRh3nkAgX3Yu307NosePiBQSk
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView, int i8, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$5$CancelAccountDeletionActivity$LoginActivitySmsView(textView, i8, keyEvent);
                        }
                    });
                    i7++;
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
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(AndroidUtilities.replaceTags(LocaleController.formatString("CancelAccountResetInfo2", R.string.CancelAccountResetInfo2, PhoneFormat.getInstance().format("+" + str))));
            int iIndexOf = TextUtils.indexOf((CharSequence) spannableStringBuilder, '*');
            int iLastIndexOf = TextUtils.lastIndexOf(spannableStringBuilder, '*');
            if (iIndexOf != -1 && iLastIndexOf != -1 && iIndexOf != iLastIndexOf) {
                this.confirmTextView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
                spannableStringBuilder.replace(iLastIndexOf, iLastIndexOf + 1, (CharSequence) "");
                spannableStringBuilder.replace(iIndexOf, iIndexOf + 1, (CharSequence) "");
                spannableStringBuilder.setSpan(new URLSpanNoUnderline("et://settings/change_number"), iIndexOf, iLastIndexOf - 1, 33);
            }
            this.confirmTextView.setText(spannableStringBuilder);
            if (this.currentType != 3) {
                AndroidUtilities.showKeyboard(this.codeField[0]);
                this.codeField[0].requestFocus();
            } else {
                AndroidUtilities.hideKeyboard(this.codeField[0]);
            }
            destroyTimer();
            destroyCodeTimer();
            this.lastCurrentTime = System.currentTimeMillis();
            int i8 = this.currentType;
            if (i8 == 1) {
                this.problemText.setVisibility(0);
                this.timeText.setVisibility(8);
                return;
            }
            if (i8 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) {
                this.problemText.setVisibility(8);
                this.timeText.setVisibility(0);
                int i9 = this.nextType;
                if (i9 == 4) {
                    this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 1, 0));
                } else if (i9 == 2) {
                    this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 1, 0));
                }
                createTimer();
                return;
            }
            if (i8 == 2 && ((i = this.nextType) == 4 || i == 3)) {
                this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                createTimer();
                return;
            }
            if (i8 == 4 && this.nextType == 2) {
                this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                createTimer();
                return;
            }
            this.timeText.setVisibility(8);
            this.problemText.setVisibility(8);
            createCodeTimer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setParams$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$setParams$4$CancelAccountDeletionActivity$LoginActivitySmsView(int i, View view, int i2, KeyEvent keyEvent) {
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
        /* renamed from: lambda$setParams$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$setParams$5$CancelAccountDeletionActivity$LoginActivitySmsView(TextView textView, int i, KeyEvent keyEvent) {
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

        /* renamed from: ir.eitaa.ui.CancelAccountDeletionActivity$LoginActivitySmsView$4, reason: invalid class name */
        class AnonymousClass4 extends TimerTask {
            AnonymousClass4() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$4$mVAvHqLFrF5j3EFNz-5vxVle_h0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$CancelAccountDeletionActivity$LoginActivitySmsView$4();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$CancelAccountDeletionActivity$LoginActivitySmsView$4() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivitySmsView.this.lastCodeTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivitySmsView.this.lastCodeTime = dCurrentTimeMillis;
                LoginActivitySmsView.access$1526(LoginActivitySmsView.this, dCurrentTimeMillis - d);
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
            Timer timer = new Timer();
            this.timeTimer = timer;
            timer.schedule(new AnonymousClass5(), 0L, 1000L);
        }

        /* renamed from: ir.eitaa.ui.CancelAccountDeletionActivity$LoginActivitySmsView$5, reason: invalid class name */
        class AnonymousClass5 extends TimerTask {
            AnonymousClass5() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LoginActivitySmsView.this.timeTimer == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$5$if6_s3Z3E507ltGHjN6ByJCjgYg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$2$CancelAccountDeletionActivity$LoginActivitySmsView$5();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$2, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$2$CancelAccountDeletionActivity$LoginActivitySmsView$5() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivitySmsView.this.lastCurrentTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivitySmsView.access$2126(LoginActivitySmsView.this, dCurrentTimeMillis - d);
                LoginActivitySmsView.this.lastCurrentTime = dCurrentTimeMillis;
                if (LoginActivitySmsView.this.time >= 1000) {
                    int i = (LoginActivitySmsView.this.time / 1000) / 60;
                    int i2 = (LoginActivitySmsView.this.time / 1000) - (i * 60);
                    if (LoginActivitySmsView.this.nextType == 4 || LoginActivitySmsView.this.nextType == 3) {
                        LoginActivitySmsView.this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, Integer.valueOf(i), Integer.valueOf(i2)));
                    } else if (LoginActivitySmsView.this.nextType == 2) {
                        LoginActivitySmsView.this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, Integer.valueOf(i), Integer.valueOf(i2)));
                    }
                    if (LoginActivitySmsView.this.progressView != null) {
                        LoginActivitySmsView.this.progressView.setProgress(1.0f - (LoginActivitySmsView.this.time / LoginActivitySmsView.this.timeout));
                        return;
                    }
                    return;
                }
                if (LoginActivitySmsView.this.progressView != null) {
                    LoginActivitySmsView.this.progressView.setProgress(1.0f);
                }
                LoginActivitySmsView.this.destroyTimer();
                if (LoginActivitySmsView.this.currentType != 3) {
                    if (LoginActivitySmsView.this.currentType == 2 || LoginActivitySmsView.this.currentType == 4) {
                        if (LoginActivitySmsView.this.nextType == 4 || LoginActivitySmsView.this.nextType == 2) {
                            if (LoginActivitySmsView.this.nextType == 4) {
                                LoginActivitySmsView.this.timeText.setText(LocaleController.getString("Calling", R.string.Calling));
                            } else {
                                LoginActivitySmsView.this.timeText.setText(LocaleController.getString("SendingSms", R.string.SendingSms));
                            }
                            LoginActivitySmsView.this.createCodeTimer();
                            TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
                            tLRPC$TL_auth_resendCode.phone_number = LoginActivitySmsView.this.phone;
                            tLRPC$TL_auth_resendCode.phone_code_hash = LoginActivitySmsView.this.phoneHash;
                            ConnectionsManager.getInstance(((BaseFragment) CancelAccountDeletionActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$5$SAXsDvqZTHNIPLwenwUwhhgFA2I
                                @Override // ir.eitaa.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$run$1$CancelAccountDeletionActivity$LoginActivitySmsView$5(tLObject, tLRPC$TL_error);
                                }
                            }, 2);
                            return;
                        }
                        if (LoginActivitySmsView.this.nextType == 3) {
                            AndroidUtilities.setWaitingForSms(false);
                            NotificationCenter.getGlobalInstance().removeObserver(LoginActivitySmsView.this, NotificationCenter.didReceiveSmsCode);
                            LoginActivitySmsView.this.waitingForEvent = false;
                            LoginActivitySmsView.this.destroyCodeTimer();
                            LoginActivitySmsView.this.resendCode();
                            return;
                        }
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
            public /* synthetic */ void lambda$run$1$CancelAccountDeletionActivity$LoginActivitySmsView$5(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                if (tLRPC$TL_error == null || tLRPC$TL_error.text == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$5$zN5M0dwbHlf0U5kAX-QgxSOP9vs
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0$CancelAccountDeletionActivity$LoginActivitySmsView$5(tLRPC$TL_error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: lambda$run$0, reason: merged with bridge method [inline-methods] */
            public /* synthetic */ void lambda$run$0$CancelAccountDeletionActivity$LoginActivitySmsView$5(TLRPC$TL_error tLRPC$TL_error) {
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
            if (this.nextPressed) {
                return;
            }
            String code = getCode();
            if (TextUtils.isEmpty(code)) {
                AndroidUtilities.shakeView(this.codeFieldContainer, 2.0f, 0);
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
            final TLRPC$TL_account_confirmPhone tLRPC$TL_account_confirmPhone = new TLRPC$TL_account_confirmPhone();
            tLRPC$TL_account_confirmPhone.phone_code = code;
            tLRPC$TL_account_confirmPhone.phone_code_hash = this.phoneHash;
            destroyTimer();
            CancelAccountDeletionActivity.this.needShowProgress();
            ConnectionsManager.getInstance(((BaseFragment) CancelAccountDeletionActivity.this).currentAccount).sendRequest(tLRPC$TL_account_confirmPhone, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$EXCfYmyBtKdXJSHK-YG_MlNSH2w
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$7$CancelAccountDeletionActivity$LoginActivitySmsView(tLRPC$TL_account_confirmPhone, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$7$CancelAccountDeletionActivity$LoginActivitySmsView(final TLRPC$TL_account_confirmPhone tLRPC$TL_account_confirmPhone, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$OSMeGLKfpsQKe691IFrQQu--ZjU
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$6$CancelAccountDeletionActivity$LoginActivitySmsView(tLRPC$TL_error, tLRPC$TL_account_confirmPhone);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onNextPressed$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onNextPressed$6$CancelAccountDeletionActivity$LoginActivitySmsView(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_account_confirmPhone tLRPC$TL_account_confirmPhone) {
            int i;
            int i2;
            CancelAccountDeletionActivity.this.needHideProgress();
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                CancelAccountDeletionActivity cancelAccountDeletionActivity = CancelAccountDeletionActivity.this;
                cancelAccountDeletionActivity.errorDialog = AlertsCreator.showSimpleAlert(cancelAccountDeletionActivity, LocaleController.formatString("CancelLinkSuccess", R.string.CancelLinkSuccess, PhoneFormat.getInstance().format("+" + this.phone)));
                return;
            }
            this.lastError = tLRPC$TL_error.text;
            int i3 = this.currentType;
            if ((i3 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) || ((i3 == 2 && ((i = this.nextType) == 4 || i == 3)) || (i3 == 4 && this.nextType == 2))) {
                createTimer();
            }
            int i4 = this.currentType;
            if (i4 == 2) {
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i4 == 3) {
                AndroidUtilities.setWaitingForCall(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = true;
            if (this.currentType != 3) {
                AlertsCreator.processError(((BaseFragment) CancelAccountDeletionActivity.this).currentAccount, tLRPC$TL_error, CancelAccountDeletionActivity.this, tLRPC$TL_account_confirmPhone, new Object[0]);
            }
            if (!tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") && !tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                    onBackPressed(true);
                    CancelAccountDeletionActivity.this.setPage(0, true, null, true);
                    return;
                }
                return;
            }
            int i5 = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i5 < editTextBoldCursorArr.length) {
                    editTextBoldCursorArr[i5].setText("");
                    i5++;
                } else {
                    editTextBoldCursorArr[0].requestFocus();
                    return;
                }
            }
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$LoginActivitySmsView$XnM-YFYkVNzYmU4c9ViIbrtDRBo
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$8$CancelAccountDeletionActivity$LoginActivitySmsView();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onShow$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onShow$8$CancelAccountDeletionActivity$LoginActivitySmsView() {
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
                    this.ignoreOnTextChange = true;
                    this.codeField[0].setText(str);
                    this.ignoreOnTextChange = false;
                    onNextPressed();
                }
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        SlideView[] slideViewArr = this.views;
        PhoneView phoneView = (PhoneView) slideViewArr[0];
        LoginActivitySmsView loginActivitySmsView = (LoginActivitySmsView) slideViewArr[1];
        LoginActivitySmsView loginActivitySmsView2 = (LoginActivitySmsView) slideViewArr[2];
        LoginActivitySmsView loginActivitySmsView3 = (LoginActivitySmsView) slideViewArr[3];
        LoginActivitySmsView loginActivitySmsView4 = (LoginActivitySmsView) slideViewArr[4];
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$CancelAccountDeletionActivity$o7Kyjv2lCIhYoDdoi1bK16a15hQ
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$0$CancelAccountDeletionActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(phoneView.progressBar, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "progressCircle"));
        arrayList.add(new ThemeDescription(loginActivitySmsView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
        arrayList.add(new ThemeDescription(loginActivitySmsView.confirmTextView, ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, "windowBackgroundWhiteLinkText"));
        arrayList.add(new ThemeDescription(loginActivitySmsView.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        if (loginActivitySmsView.codeField != null) {
            for (int i = 0; i < loginActivitySmsView.codeField.length; i++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView.codeField[i], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView.codeField[i], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
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
            for (int i2 = 0; i2 < loginActivitySmsView2.codeField.length; i2++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView2.codeField[i2], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.codeField[i2], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
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
            for (int i3 = 0; i3 < loginActivitySmsView3.codeField.length; i3++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView3.codeField[i3], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.codeField[i3], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
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
            for (int i4 = 0; i4 < loginActivitySmsView4.codeField.length; i4++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView4.codeField[i4], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.codeField[i4], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
            }
        }
        arrayList.add(new ThemeDescription(loginActivitySmsView4.timeText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteGrayText6"));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressInner"));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "login_progressOuter"));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.blackImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, "chats_actionBackground"));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.blueImageView, 0, null, null, null, themeDescriptionDelegate, "chats_actionBackground"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$0$CancelAccountDeletionActivity() {
        LoginActivity.LoginActivitySmsView loginActivitySmsView;
        RLottieDrawable rLottieDrawable;
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                return;
            }
            if ((slideViewArr[i] instanceof LoginActivity.LoginActivitySmsView) && (rLottieDrawable = (loginActivitySmsView = (LoginActivity.LoginActivitySmsView) slideViewArr[i]).hintDrawable) != null) {
                rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor("chats_actionBackground"));
                loginActivitySmsView.hintDrawable.setLayerColor("Phone.**", Theme.getColor("chats_actionBackground"));
            }
            i++;
        }
    }
}
