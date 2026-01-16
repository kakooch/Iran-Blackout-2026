package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
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
import android.graphics.Typeface;
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
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidMessenger.ServiceLocator;
import androidMessenger.helper.GlideHelper;
import androidMessenger.proxy.ContactsProxy;
import androidMessenger.proxy.IdStorage;
import androidMessenger.utilites.MyLog;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.exceptions.LogInException;
import ir.aaap.messengercore.model.api.SendCodeOutput;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.helper.FlavorHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.ContactsController;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.ImageReceiver;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.SerializedData;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputFile;
import org.rbmain.tgnet.TLRPC$PhotoSize;
import org.rbmain.tgnet.TLRPC$TL_account_deleteAccount;
import org.rbmain.tgnet.TLRPC$TL_auth_authorization;
import org.rbmain.tgnet.TLRPC$TL_auth_cancelCode;
import org.rbmain.tgnet.TLRPC$TL_auth_codeTypeCall;
import org.rbmain.tgnet.TLRPC$TL_auth_codeTypeFlashCall;
import org.rbmain.tgnet.TLRPC$TL_auth_codeTypeSms;
import org.rbmain.tgnet.TLRPC$TL_auth_passwordRecovery;
import org.rbmain.tgnet.TLRPC$TL_auth_recoverPassword;
import org.rbmain.tgnet.TLRPC$TL_auth_requestPasswordRecovery;
import org.rbmain.tgnet.TLRPC$TL_auth_resendCode;
import org.rbmain.tgnet.TLRPC$TL_auth_sendCode;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCode;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeApp;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeCall;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeFlashCall;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeSms;
import org.rbmain.tgnet.TLRPC$TL_auth_signIn;
import org.rbmain.tgnet.TLRPC$TL_auth_signUp;
import org.rbmain.tgnet.TLRPC$TL_codeSettings;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_help_termsOfService;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$auth_CodeType;
import org.rbmain.tgnet.TLRPC$auth_SentCodeType;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenu;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BackDrawable;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.CheckBoxCell;
import org.rbmain.ui.Components.AvatarDrawable;
import org.rbmain.ui.Components.BackupImageView;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.HintEditText;
import org.rbmain.ui.Components.ImageUpdater;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RadialProgressView;
import org.rbmain.ui.Components.SlideView;
import org.rbmain.ui.Components.VerticalPositionAutoAnimator;
import org.rbmain.ui.CountrySelectActivity;
import org.rbmain.ui.LoginActivityAppp;

/* loaded from: classes4.dex */
public class LoginActivityAppp extends BaseFragment {
    private boolean checkPermissions;
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
    private AnimatorSet pagesAnimation;
    private Dialog permissionsDialog;
    private ArrayList<String> permissionsItems;
    private Dialog permissionsShowDialog;
    private ArrayList<String> permissionsShowItems;
    private int progressRequestId;
    private boolean restoringState;
    private int scrollHeight;
    private AnimatorSet[] showDoneAnimation;
    private boolean syncContacts;
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
            paint.setColor(Theme.getColor(Theme.key_login_progressInner));
            paint2.setColor(Theme.getColor(Theme.key_login_progressOuter));
        }

        public void startProgressAnimation(long j) {
            this.animating = true;
            this.duration = j;
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
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            this.path.rewind();
            float f = i2;
            this.radius = f / 2.0f;
            this.boundsRect.set(0.0f, 0.0f, i, f);
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

    public LoginActivityAppp() {
        this.views = new SlideView[9];
        this.permissionsItems = new ArrayList<>();
        this.permissionsShowItems = new ArrayList<>();
        this.checkPermissions = true;
        this.syncContacts = true;
        this.showDoneAnimation = new AnimatorSet[2];
        this.doneButtonVisible = new boolean[]{true, false};
    }

    public LoginActivityAppp(int i) {
        this.views = new SlideView[9];
        this.permissionsItems = new ArrayList<>();
        this.permissionsShowItems = new ArrayList<>();
        this.checkPermissions = true;
        this.syncContacts = true;
        this.showDoneAnimation = new AnimatorSet[2];
        this.doneButtonVisible = new boolean[]{true, false};
        this.currentAccount = i;
        this.newAccount = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected ActionBar createActionBar(Context context) {
        ActionBar actionBar = new ActionBar(this, context) { // from class: org.rbmain.ui.LoginActivityAppp.1
            @Override // org.rbmain.ui.ActionBar.ActionBar, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return super.onTouchEvent(motionEvent);
            }
        };
        boolean z = false;
        actionBar.setBackgroundColor(0);
        actionBar.setItemsColor(Theme.getColor(Theme.key_actionBarDefaultIcon), false);
        actionBar.setBackButtonDrawable(new BackDrawable(false));
        actionBar.setCastShadows(false);
        actionBar.setAddToContainer(false);
        actionBar.setClipContent(true);
        if (Build.VERSION.SDK_INT >= 21 && !AndroidUtilities.isTablet() && !this.inBubbleMode) {
            z = true;
        }
        actionBar.setOccupyStatusBar(z);
        return actionBar;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.LoginActivityAppp.2
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == 1) {
                    LoginActivityAppp.this.onDoneButtonPressed();
                } else if (i == -1 && LoginActivityAppp.this.onBackPressed()) {
                    LoginActivityAppp.this.finishFragment();
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
        FrameLayout frameLayout = new FrameLayout(context) { // from class: org.rbmain.ui.LoginActivityAppp.3
            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) LoginActivityAppp.this.floatingButtonContainer.getLayoutParams();
                if (Bulletin.getVisibleBulletin() != null && Bulletin.getVisibleBulletin().isShowing()) {
                    super.onMeasure(i, i2);
                    marginLayoutParams.bottomMargin = (AndroidUtilities.dp(14.0f) + Bulletin.getVisibleBulletin().getLayout().getMeasuredHeight()) - AndroidUtilities.dp(10.0f);
                } else {
                    marginLayoutParams.bottomMargin = AndroidUtilities.dp(14.0f);
                }
                super.onMeasure(i, i2);
            }
        };
        this.fragmentView = frameLayout;
        FirebaseEventSender.setKey("fragmentView", "fragmentView init");
        final ScrollView scrollView = new ScrollView(context) { // from class: org.rbmain.ui.LoginActivityAppp.4
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
                if (LoginActivityAppp.this.currentViewNum == 1 || LoginActivityAppp.this.currentViewNum == 2 || LoginActivityAppp.this.currentViewNum == 4) {
                    rect.bottom += AndroidUtilities.dp(40.0f);
                }
                return super.requestChildRectangleOnScreen(view, rect, z);
            }

            @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                LoginActivityAppp.this.scrollHeight = View.MeasureSpec.getSize(i2) - AndroidUtilities.dp(30.0f);
                super.onMeasure(i, i2);
            }
        };
        scrollView.setFillViewport(true);
        frameLayout.addView(scrollView, LayoutHelper.createFrame(-1, -1.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        scrollView.addView(frameLayout2, LayoutHelper.createScroll(-1, -2, 51));
        this.views[0] = new PhoneView(context);
        this.views[1] = new LoginActivityApppSmsView(context, 1);
        this.views[2] = new LoginActivityApppSmsView(context, 2);
        this.views[3] = new LoginActivityApppSmsView(context, 3);
        this.views[4] = new LoginActivityApppSmsView(context, 4);
        this.views[5] = new LoginActivityApppRegisterView(context);
        this.views[6] = new LoginActivityApppPasswordView(context);
        this.views[7] = new LoginActivityApppRecoverView(context);
        this.views[8] = new LoginActivityApppResetWaitView(context);
        this.views[0].getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: org.rbmain.ui.LoginActivityAppp$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f$0.lambda$createView$0(scrollView);
            }
        });
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getParentActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        FrameLayout frameLayout3 = new FrameLayout(context);
        final int i2 = 125;
        View view = new View(context) { // from class: org.rbmain.ui.LoginActivityAppp.5
            @Override // android.view.View
            protected void onMeasure(int i3, int i4) {
                super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(((AndroidUtilities.dp(i2) - ActionBar.getCurrentActionBarHeight()) + (LoginActivityAppp.this.scrollHeight + AndroidUtilities.dp(30.0f))) - AndroidUtilities.statusBarHeight, 1073741824));
            }
        };
        float f = 125;
        frameLayout2.addView(view, new FrameLayout.LayoutParams(10, ((AndroidUtilities.dp(f) - ActionBar.getCurrentActionBarHeight()) + i) - AndroidUtilities.statusBarHeight));
        frameLayout2.addView(frameLayout3, LayoutHelper.createFrame(-1, f, 48, 0.0f, 0.0f, 0.0f, 0.0f));
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        frameLayout3.addView(imageView, LayoutHelper.createFrame(-1, f, 48, 0.0f, 0.0f, 0.0f, 0.0f));
        GlideHelper.loadResourceFitCenter(context, imageView, R.drawable.bg_login_header);
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout3.addView(imageView2, LayoutHelper.createFrame(-1, FlavorHelper.isRubx() ? f : 80.0f, 17, 0.0f, 0.0f, 0.0f, 0.0f));
        GlideHelper.loadResourceFitCenter(context, imageView2, R.mipmap.ic_launcher);
        int i3 = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i3 >= slideViewArr.length) {
                break;
            }
            slideViewArr[i3].setVisibility(i3 == 0 ? 0 : 8);
            frameLayout2.addView(this.views[i3], LayoutHelper.createFrame(-1, -1.0f, 51, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 155, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 0.0f));
            i3++;
        }
        Bundle bundleLoadCurrentState = loadCurrentState();
        if (bundleLoadCurrentState != null) {
            this.currentViewNum = bundleLoadCurrentState.getInt("currentViewNum", 0);
            this.syncContacts = bundleLoadCurrentState.getInt("syncContacts", 1) == 1;
            int i4 = this.currentViewNum;
            if (i4 >= 1 && i4 <= 4) {
                int i5 = bundleLoadCurrentState.getInt("open");
                if (i5 != 0 && Math.abs((System.currentTimeMillis() / 1000) - i5) >= 86400) {
                    this.currentViewNum = 0;
                    bundleLoadCurrentState = null;
                    clearCurrentState();
                }
            } else if (i4 == 6) {
                LoginActivityApppPasswordView loginActivityApppPasswordView = (LoginActivityApppPasswordView) this.views[6];
                if (loginActivityApppPasswordView.passwordType == 0 || loginActivityApppPasswordView.current_salt1 == null || loginActivityApppPasswordView.current_salt2 == null) {
                    this.currentViewNum = 0;
                    bundleLoadCurrentState = null;
                    clearCurrentState();
                }
            }
        }
        FrameLayout frameLayout4 = new FrameLayout(context);
        this.floatingButtonContainer = frameLayout4;
        frameLayout4.setVisibility(this.doneButtonVisible[0] ? 0 : 8);
        Drawable drawableCreateSimpleSelectorCircleDrawable = Theme.createSimpleSelectorCircleDrawable(AndroidUtilities.dp(56.0f), Theme.getColor(Theme.key_chats_actionBackground), Theme.getColor(Theme.key_chats_actionPressedBackground));
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 21) {
            Drawable drawableMutate = context.getResources().getDrawable(R.drawable.floating_shadow).mutate();
            drawableMutate.setColorFilter(new PorterDuffColorFilter(-16777216, PorterDuff.Mode.MULTIPLY));
            CombinedDrawable combinedDrawable = new CombinedDrawable(drawableMutate, drawableCreateSimpleSelectorCircleDrawable, 0, 0);
            combinedDrawable.setIconSize(AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
            drawableCreateSimpleSelectorCircleDrawable = combinedDrawable;
        }
        this.floatingButtonContainer.setBackgroundDrawable(drawableCreateSimpleSelectorCircleDrawable);
        if (i6 >= 21) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(new int[]{android.R.attr.state_pressed}, ObjectAnimator.ofFloat(this.floatingButtonIcon, "translationZ", AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f)).setDuration(200L));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this.floatingButtonIcon, "translationZ", AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f)).setDuration(200L));
            this.floatingButtonContainer.setStateListAnimator(stateListAnimator);
            this.floatingButtonContainer.setOutlineProvider(new ViewOutlineProvider(this) { // from class: org.rbmain.ui.LoginActivityAppp.6
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setOval(0, 0, AndroidUtilities.dp(56.0f), AndroidUtilities.dp(56.0f));
                }
            });
        }
        VerticalPositionAutoAnimator.attach(this.floatingButtonContainer);
        frameLayout.addView(this.floatingButtonContainer, LayoutHelper.createFrame(i6 >= 21 ? 56 : 60, i6 >= 21 ? 56.0f : 60.0f, 85, 0.0f, 0.0f, 14.0f, 14.0f));
        this.floatingButtonContainer.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$createView$1(view2);
            }
        });
        ImageView imageView3 = new ImageView(context);
        this.floatingButtonIcon = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.CENTER);
        ImageView imageView4 = this.floatingButtonIcon;
        int i7 = Theme.key_chats_actionIcon;
        imageView4.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i7), PorterDuff.Mode.MULTIPLY));
        this.floatingButtonIcon.setImageResource(R.drawable.actionbtn_next);
        this.floatingButtonContainer.setContentDescription(LocaleController.getString("Done", R.string.Done));
        this.floatingButtonContainer.addView(this.floatingButtonIcon, LayoutHelper.createFrame(i6 >= 21 ? 56 : 60, i6 >= 21 ? 56.0f : 60.0f));
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.floatingProgressView = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(22.0f));
        this.floatingProgressView.setProgressColor(Theme.getColor(i7));
        this.floatingProgressView.setAlpha(0.0f);
        this.floatingProgressView.setScaleX(0.1f);
        this.floatingProgressView.setScaleY(0.1f);
        this.floatingProgressView.setVisibility(4);
        this.floatingButtonContainer.addView(this.floatingProgressView, LayoutHelper.createFrame(-1, -1.0f));
        if (bundleLoadCurrentState != null) {
            this.restoringState = true;
        }
        int i8 = 0;
        while (true) {
            SlideView[] slideViewArr2 = this.views;
            if (i8 < slideViewArr2.length) {
                if (bundleLoadCurrentState != null && (i8 < 1 || i8 > 4 || i8 == this.currentViewNum)) {
                    slideViewArr2[i8].restoreStateParams(bundleLoadCurrentState);
                }
                if (this.currentViewNum == i8) {
                    this.actionBar.setBackButtonImage((this.views[i8].needBackButton() || this.newAccount) ? R.drawable.ic_ab_back : 0);
                    this.views[i8].setVisibility(0);
                    this.views[i8].onShow();
                    this.currentDoneType = 0;
                    if (i8 == 1 || i8 == 2 || i8 == 3 || i8 == 4 || i8 == 8) {
                        showDoneButton(false, false);
                    } else {
                        showDoneButton(true, false);
                    }
                    if (i8 != 1 && i8 != 2) {
                        if (i8 == 3 || i8 == 4) {
                        }
                    }
                    this.currentDoneType = 1;
                } else {
                    this.views[i8].setVisibility(8);
                }
                i8++;
            } else {
                this.restoringState = false;
                this.actionBar.setTitle(slideViewArr2[this.currentViewNum].getHeaderName());
                return this.fragmentView;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(ScrollView scrollView) {
        this.views[this.currentViewNum].setTranslationY((-(scrollView.getScrollY() * 1.0f)) / 10.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(View view) {
        onDoneButtonPressed();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        if (this.newAccount) {
            ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        SlideView slideView;
        int i;
        super.onResume();
        if (this.newAccount) {
            ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        View view = this.fragmentView;
        if (view != null) {
            view.requestLayout();
        }
        try {
            int i2 = this.currentViewNum;
            if (i2 >= 1 && i2 <= 4) {
                SlideView[] slideViewArr = this.views;
                if ((slideViewArr[i2] instanceof LoginActivityApppSmsView) && (i = ((LoginActivityApppSmsView) slideViewArr[i2]).openTime) != 0 && Math.abs((System.currentTimeMillis() / 1000) - i) >= 86400) {
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        int i2;
        if (i != 6) {
            if (i == 7 && (i2 = this.currentViewNum) == 0) {
                ((PhoneView) this.views[i2]).fillNumber();
                return;
            }
            return;
        }
        this.checkPermissions = false;
        int i3 = this.currentViewNum;
        if (i3 == 0) {
            this.views[i3].onNextPressed();
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
        editorEdit.apply();
    }

    private void putBundleToEditor(Bundle bundle, SharedPreferences.Editor editor, String str) {
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                if (str != null) {
                    editor.putString(str + "_|_" + str2, (String) obj);
                } else {
                    editor.putString(str2, (String) obj);
                }
            } else if (obj instanceof Integer) {
                if (str != null) {
                    editor.putInt(str + "_|_" + str2, ((Integer) obj).intValue());
                } else {
                    editor.putInt(str2, ((Integer) obj).intValue());
                }
            } else if (obj instanceof Bundle) {
                putBundleToEditor((Bundle) obj, editor, str2);
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (dialog == this.permissionsDialog && !this.permissionsItems.isEmpty() && getParentActivity() != null) {
                    getParentActivity().requestPermissions((String[]) this.permissionsItems.toArray(new String[0]), 6);
                } else {
                    if (dialog != this.permissionsShowDialog || this.permissionsShowItems.isEmpty() || getParentActivity() == null) {
                        return;
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDialogDismiss$2();
                        }
                    }, 200L);
                    getParentActivity().requestPermissions((String[]) this.permissionsShowItems.toArray(new String[0]), 7);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDialogDismiss$2() {
        this.needRequestPermissions = false;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
                    ((LoginActivityApppRegisterView) this.views[i]).wrongNumber.callOnClick();
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, int i2, Intent intent) throws IllegalAccessException, NoSuchFieldException, Resources.NotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException {
        LoginActivityApppRegisterView loginActivityApppRegisterView = (LoginActivityApppRegisterView) this.views[5];
        if (loginActivityApppRegisterView != null) {
            loginActivityApppRegisterView.imageUpdater.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowAlert(String str, String str2) {
        if (str2 == null || getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(str);
        builder.setMessage(str2);
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

    public static void needShowInvalidAlert(BaseFragment baseFragment, String str, boolean z) {
        if (baseFragment == null || baseFragment.getParentActivity() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getParentActivity());
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        if (str != null && str.equals(LogInException.ErrorEnum.phoneIsNotCorrect.name())) {
            builder.setMessage(LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
        } else if (str != null && str.equals(LogInException.ErrorEnum.CodeIsInvalid.name())) {
            builder.setMessage(LocaleController.getString("InvalidCode", R.string.InvalidCode));
        } else if (str != null && str.equals(LogInException.ErrorEnum.CodeIsExpired.name())) {
            builder.setMessage(LocaleController.getString("CodeExpired", R.string.CodeExpired));
        } else if (str != null && str.equals(LogInException.ErrorEnum.CodeIsUsed.name())) {
            builder.setMessage(LocaleController.getString("CodeIsUsedError", R.string.CodeIsUsedError));
        } else {
            builder.setMessage(LocaleController.getString("conneciton_server_failed_message", R.string.conneciton_server_failed_message));
        }
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        baseFragment.showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDoneButton(final boolean z, boolean z2) {
        TimeInterpolator timeInterpolator;
        int i = this.currentDoneType;
        final boolean z3 = i == 0;
        if (this.doneButtonVisible[i] == z) {
            return;
        }
        AnimatorSet[] animatorSetArr = this.showDoneAnimation;
        if (animatorSetArr[i] != null) {
            animatorSetArr[i].cancel();
        }
        boolean[] zArr = this.doneButtonVisible;
        int i2 = this.currentDoneType;
        zArr[i2] = z;
        if (!z2) {
            if (z) {
                if (z3) {
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
            if (z3) {
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
        if (z) {
            if (z3) {
                this.floatingButtonContainer.setVisibility(0);
                this.showDoneAnimation[this.currentDoneType].play(ObjectAnimator.ofFloat(this.floatingButtonContainer, (Property<FrameLayout, Float>) View.TRANSLATION_Y, 0.0f));
            } else {
                this.doneItem.setVisibility(0);
                this.showDoneAnimation[this.currentDoneType].playTogether(ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 1.0f));
            }
        } else if (z3) {
            this.showDoneAnimation[this.currentDoneType].play(ObjectAnimator.ofFloat(this.floatingButtonContainer, (Property<FrameLayout, Float>) View.TRANSLATION_Y, AndroidUtilities.dpf2(70.0f)));
        } else {
            this.showDoneAnimation[this.currentDoneType].playTogether(ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneItem, (Property<ActionBarMenuItem, Float>) View.ALPHA, 0.0f));
        }
        this.showDoneAnimation[this.currentDoneType].addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.LoginActivityAppp.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (LoginActivityAppp.this.showDoneAnimation[!z3 ? 1 : 0] == null || !LoginActivityAppp.this.showDoneAnimation[!z3 ? 1 : 0].equals(animator) || z) {
                    return;
                }
                if (z3) {
                    LoginActivityAppp.this.floatingButtonContainer.setVisibility(8);
                } else {
                    LoginActivityAppp.this.doneItem.setVisibility(8);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (LoginActivityAppp.this.showDoneAnimation[!z3 ? 1 : 0] == null || !LoginActivityAppp.this.showDoneAnimation[!z3 ? 1 : 0].equals(animator)) {
                    return;
                }
                LoginActivityAppp.this.showDoneAnimation[!z3 ? 1 : 0] = null;
            }
        });
        int i3 = ImageReceiver.DEFAULT_CROSSFADE_DURATION;
        if (!z3) {
            timeInterpolator = null;
        } else if (z) {
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
                builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onDoneButtonPressed$3(dialogInterface, i);
                    }
                });
                showDialog(builder.create());
                return;
            }
            this.views[this.currentViewNum].onNextPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDoneButtonPressed$3(DialogInterface dialogInterface, int i) {
        this.views[this.currentViewNum].onCancelPressed();
        needHideProgress(true);
    }

    private void showEditDoneProgress(final boolean z, boolean z2) {
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        final boolean z3 = this.currentDoneType == 0;
        if (z2) {
            this.doneItemAnimation = new AnimatorSet();
            if (z) {
                this.doneProgressView.setTag(1);
                if (z3) {
                    this.floatingProgressView.setVisibility(0);
                    this.floatingButtonContainer.setEnabled(false);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
                } else {
                    this.doneProgressView.setVisibility(0);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
                }
            } else {
                this.doneProgressView.setTag(null);
                if (z3) {
                    this.floatingButtonIcon.setVisibility(0);
                    this.floatingButtonContainer.setEnabled(true);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.floatingProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.floatingButtonIcon, (Property<ImageView, Float>) View.ALPHA, 1.0f));
                } else {
                    this.doneItem.getContentView().setVisibility(0);
                    this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneProgressView, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 1.0f));
                }
            }
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.LoginActivityAppp.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (LoginActivityAppp.this.doneItemAnimation == null || !LoginActivityAppp.this.doneItemAnimation.equals(animator)) {
                        return;
                    }
                    if (z3) {
                        if (!z) {
                            LoginActivityAppp.this.floatingProgressView.setVisibility(4);
                            return;
                        } else {
                            LoginActivityAppp.this.floatingButtonIcon.setVisibility(4);
                            return;
                        }
                    }
                    if (!z) {
                        LoginActivityAppp.this.doneProgressView.setVisibility(4);
                    } else {
                        LoginActivityAppp.this.doneItem.getContentView().setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (LoginActivityAppp.this.doneItemAnimation == null || !LoginActivityAppp.this.doneItemAnimation.equals(animator)) {
                        return;
                    }
                    LoginActivityAppp.this.doneItemAnimation = null;
                }
            });
            this.doneItemAnimation.setDuration(150L);
            this.doneItemAnimation.start();
            return;
        }
        if (z) {
            if (z3) {
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
        if (z3) {
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
    public void needShowProgress(int i) {
        needShowProgress(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needShowProgress(int i, boolean z) {
        this.progressRequestId = i;
        showEditDoneProgress(true, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needHideProgress(boolean z) {
        needHideProgress(z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needHideProgress(boolean z, boolean z2) {
        if (this.progressRequestId != 0) {
            if (z) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.progressRequestId, true);
            }
            this.progressRequestId = 0;
        }
        showEditDoneProgress(false, z2);
    }

    public void setPage(int i, boolean z, Bundle bundle, boolean z2) {
        final boolean z3 = i == 0 || i == 5 || i == 6 || i == 7;
        if (z3) {
            if (i == 0) {
                this.checkPermissions = true;
            }
            this.currentDoneType = 1;
            showDoneButton(false, z);
            this.currentDoneType = 0;
            showEditDoneProgress(false, false);
            if (!z) {
                showDoneButton(true, false);
            }
        } else {
            this.currentDoneType = 0;
            showDoneButton(false, z);
            if (i != 8) {
                this.currentDoneType = 1;
            }
        }
        int i2 = R.drawable.ic_ab_back;
        if (z) {
            SlideView[] slideViewArr = this.views;
            final SlideView slideView = slideViewArr[this.currentViewNum];
            SlideView slideView2 = slideViewArr[i];
            this.currentViewNum = i;
            ActionBar actionBar = this.actionBar;
            if (!slideView2.needBackButton() && !this.newAccount) {
                i2 = 0;
            }
            actionBar.setBackButtonImage(i2);
            slideView2.setParams(bundle, false);
            if (slideView2 == slideView) {
                return;
            }
            this.actionBar.setTitle(slideView2.getHeaderName());
            setParentActivityTitle(slideView2.getHeaderName());
            slideView2.onShow();
            int i3 = AndroidUtilities.displaySize.x;
            if (z2) {
                i3 = -i3;
            }
            slideView2.setX(i3);
            slideView2.setVisibility(0);
            AnimatorSet animatorSet = new AnimatorSet();
            this.pagesAnimation = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.LoginActivityAppp.9
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (LoginActivityAppp.this.currentDoneType == 0 && z3) {
                        LoginActivityAppp.this.showDoneButton(true, true);
                    }
                    slideView.setVisibility(8);
                    slideView.setX(0.0f);
                }
            });
            AnimatorSet animatorSet2 = this.pagesAnimation;
            Animator[] animatorArr = new Animator[2];
            Property property = View.TRANSLATION_X;
            float[] fArr = new float[1];
            fArr[0] = z2 ? AndroidUtilities.displaySize.x : -AndroidUtilities.displaySize.x;
            animatorArr[0] = ObjectAnimator.ofFloat(slideView, (Property<SlideView, Float>) property, fArr);
            animatorArr[1] = ObjectAnimator.ofFloat(slideView2, (Property<SlideView, Float>) View.TRANSLATION_X, 0.0f);
            animatorSet2.playTogether(animatorArr);
            this.pagesAnimation.setDuration(300L);
            this.pagesAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
            this.pagesAnimation.start();
            return;
        }
        ActionBar actionBar2 = this.actionBar;
        if (!this.views[i].needBackButton() && !this.newAccount) {
            i2 = 0;
        }
        actionBar2.setBackButtonImage(i2);
        this.views[this.currentViewNum].setVisibility(8);
        this.currentViewNum = i;
        this.views[i].setParams(bundle, false);
        this.views[i].setVisibility(0);
        this.actionBar.setTitle(this.views[i].getHeaderName());
        setParentActivityTitle(this.views[i].getHeaderName());
        this.views[i].onShow();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void saveSelfArgs(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("currentViewNum", this.currentViewNum);
            bundle2.putInt("syncContacts", this.syncContacts ? 1 : 0);
            for (int i = 0; i <= this.currentViewNum; i++) {
                SlideView slideView = this.views[i];
                if (slideView != null) {
                    slideView.saveStateParams(bundle2);
                }
            }
            SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("logininfo2", 0).edit();
            editorEdit.clear();
            putBundleToEditor(bundle2, editorEdit, null);
            editorEdit.apply();
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    private void needFinishActivity(boolean z) {
        clearCurrentState();
        if (getParentActivity() instanceof LaunchActivity) {
            if (this.newAccount) {
                this.newAccount = false;
                ((LaunchActivity) getParentActivity()).switchToAccount(this.currentAccount, true);
                finishFragment();
                return;
            } else {
                new Bundle().putBoolean("afterSignup", z);
                ((LaunchActivity) getParentActivity()).rubinoInit();
                ServiceLocator.getInstance(this.currentAccount).onAuthSuccess();
                presentFragment(((LaunchActivity) getParentActivity()).createMainTabFragment(), true);
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
                return;
            }
        }
        if (getParentActivity() instanceof ExternalActionActivity) {
            ((ExternalActionActivity) getParentActivity()).onFinishLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAuthSuccess(TLRPC$TL_auth_authorization tLRPC$TL_auth_authorization) {
        onAuthSuccess(tLRPC$TL_auth_authorization, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAuthSuccess(TLRPC$TL_auth_authorization tLRPC$TL_auth_authorization, boolean z) {
        ConnectionsManager.getInstance(this.currentAccount).setUserId(tLRPC$TL_auth_authorization.user.id);
        UserConfig.getInstance(this.currentAccount).clearConfig();
        MessagesController.getInstance(this.currentAccount).cleanup();
        UserConfig.getInstance(this.currentAccount).syncContacts = this.syncContacts;
        UserConfig.getInstance(this.currentAccount).setCurrentUser(tLRPC$TL_auth_authorization.user);
        UserConfig.getInstance(this.currentAccount).saveConfig(true);
        MessagesStorage.getInstance(this.currentAccount).cleanup(true);
        ArrayList<TLRPC$User> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$TL_auth_authorization.user);
        MessagesStorage.getInstance(this.currentAccount).putUsersAndChats(arrayList, null, true, true);
        MessagesController.getInstance(this.currentAccount).putUser(tLRPC$TL_auth_authorization.user, false);
        ContactsController.getInstance(this.currentAccount).checkAppAccount();
        MessagesController.getInstance(this.currentAccount).checkPromoInfo(true);
        ConnectionsManager.getInstance(this.currentAccount).updateDcSettings();
        needFinishActivity(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillNextCodeParams(Bundle bundle, TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode) {
        bundle.putString("phoneHash", tLRPC$TL_auth_sentCode.phone_code_hash);
        TLRPC$auth_CodeType tLRPC$auth_CodeType = tLRPC$TL_auth_sentCode.next_type;
        if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeCall) {
            bundle.putInt("nextType", 4);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeFlashCall) {
            bundle.putInt("nextType", 3);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeSms) {
            bundle.putInt("nextType", 2);
        }
        if (tLRPC$TL_auth_sentCode.type instanceof TLRPC$TL_auth_sentCodeTypeApp) {
            bundle.putInt("type", 1);
            bundle.putInt("length", tLRPC$TL_auth_sentCode.type.length);
            setPage(1, true, bundle, false);
            return;
        }
        if (tLRPC$TL_auth_sentCode.timeout == 0) {
            tLRPC$TL_auth_sentCode.timeout = 120;
        }
        bundle.putInt("timeout", tLRPC$TL_auth_sentCode.timeout * CloseCodes.NORMAL_CLOSURE);
        TLRPC$auth_SentCodeType tLRPC$auth_SentCodeType = tLRPC$TL_auth_sentCode.type;
        if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeCall) {
            bundle.putInt("type", 4);
            bundle.putInt("length", tLRPC$TL_auth_sentCode.type.length);
            setPage(4, true, bundle, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeFlashCall) {
            bundle.putInt("type", 3);
            bundle.putString("pattern", tLRPC$TL_auth_sentCode.type.pattern);
            setPage(3, true, bundle, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeSms) {
            bundle.putInt("type", 2);
            bundle.putInt("length", tLRPC$TL_auth_sentCode.type.length);
            setPage(2, true, bundle, false);
        }
    }

    public class PhoneView extends SlideView implements AdapterView.OnItemSelectedListener {
        private CheckBoxCell checkBoxCell;
        private EditTextBoldCursor codeField;
        private HashMap<String, String> codesMap;
        private ArrayList<String> countriesArray;
        private HashMap<String, String> countriesMap;
        private TextView countryButton;
        private int countryState;
        private boolean ignoreOnPhoneChange;
        private boolean ignoreOnTextChange;
        private boolean ignoreSelection;
        private boolean nextPressed;
        private HintEditText phoneField;
        private HashMap<String, String> phoneFormatMap;
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
            this.countriesMap = new HashMap<>();
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
            this.countryButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
            TextView textView2 = this.countryButton;
            int i = Theme.key_windowBackgroundWhiteBlackText;
            textView2.setTextColor(Theme.getColor(i));
            this.countryButton.setMaxLines(1);
            this.countryButton.setSingleLine(true);
            this.countryButton.setEllipsize(TextUtils.TruncateAt.END);
            this.countryButton.setGravity((LocaleController.isRTL ? 5 : 3) | 1);
            this.countryButton.setBackground(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector), 7));
            addView(this.countryButton, LayoutHelper.createLinear(-1, 36, 0.0f, 0.0f, 0.0f, 14.0f));
            this.countryButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$2(view);
                }
            });
            View view = new View(context);
            this.view = view;
            view.setPadding(AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(12.0f), 0);
            this.view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayLine));
            addView(this.view, LayoutHelper.createLinear(-1, 1, 4.0f, -17.5f, 4.0f, 0.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            addView(linearLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 20.0f, 0.0f, 0.0f));
            TextView textView3 = new TextView(context);
            this.textView = textView3;
            textView3.setText("+");
            this.textView.setTextColor(Theme.getColor(i));
            this.textView.setTextSize(1, 18.0f);
            linearLayout.addView(this.textView, LayoutHelper.createLinear(-2, -2));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.codeField = editTextBoldCursor;
            editTextBoldCursor.setInputType(3);
            this.codeField.setTextColor(Theme.getColor(i));
            this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.codeField.setCursorColor(Theme.getColor(i));
            this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.codeField.setCursorWidth(1.5f);
            this.codeField.setPadding(AndroidUtilities.dp(10.0f), 0, 0, 0);
            this.codeField.setTextSize(1, 18.0f);
            this.codeField.setMaxLines(1);
            this.codeField.setGravity(19);
            this.codeField.setImeOptions(268435461);
            this.codeField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
            linearLayout.addView(this.codeField, LayoutHelper.createLinear(55, 36, -9.0f, 0.0f, 16.0f, 0.0f));
            this.codeField.addTextChangedListener(new TextWatcher(LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.PhoneView.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String str;
                    boolean z;
                    int iIndexOf;
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
                        int i2 = 4;
                        if (strStripExceptNumbers.length() > 4) {
                            while (true) {
                                if (i2 < 1) {
                                    str = null;
                                    z = false;
                                    break;
                                }
                                String strSubstring = strStripExceptNumbers.substring(0, i2);
                                if (((String) PhoneView.this.codesMap.get(strSubstring)) != null) {
                                    String str2 = strStripExceptNumbers.substring(i2) + PhoneView.this.phoneField.getText().toString();
                                    PhoneView.this.codeField.setText(strSubstring);
                                    z = true;
                                    str = str2;
                                    strStripExceptNumbers = strSubstring;
                                    break;
                                }
                                i2--;
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
                        String str3 = (String) PhoneView.this.codesMap.get(strStripExceptNumbers);
                        if (str3 == null || (iIndexOf = PhoneView.this.countriesArray.indexOf(str3)) == -1) {
                            PhoneView.this.countryButton.setText(LocaleController.getString("WrongCountry", R.string.WrongCountry));
                            PhoneView.this.phoneField.setHintText((String) null);
                            PhoneView.this.countryState = 2;
                        } else {
                            PhoneView.this.ignoreSelection = true;
                            PhoneView.this.countryButton.setText((CharSequence) PhoneView.this.countriesArray.get(iIndexOf));
                            String str4 = (String) PhoneView.this.phoneFormatMap.get(strStripExceptNumbers);
                            PhoneView.this.phoneField.setHintText(str4 != null ? str4.replace('X', (char) 8211) : null);
                            PhoneView.this.countryState = 0;
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
            this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda3
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView4, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$3(textView4, i2, keyEvent);
                }
            });
            HintEditText hintEditText = new HintEditText(this, context, LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.PhoneView.2
                @Override // org.rbmain.ui.Components.EditTextBoldCursor, android.widget.TextView, android.view.View
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 && !AndroidUtilities.showKeyboard(this)) {
                        clearFocus();
                        requestFocus();
                    }
                    return super.onTouchEvent(motionEvent);
                }
            };
            this.phoneField = hintEditText;
            hintEditText.setInputType(3);
            this.phoneField.setTextColor(Theme.getColor(i));
            this.phoneField.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
            this.phoneField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.phoneField.setPadding(0, 0, 0, 0);
            this.phoneField.setCursorColor(Theme.getColor(i));
            this.phoneField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.phoneField.setCursorWidth(1.5f);
            this.phoneField.setTextSize(1, 18.0f);
            this.phoneField.setMaxLines(1);
            this.phoneField.setGravity(19);
            this.phoneField.setImeOptions(268435461);
            linearLayout.addView(this.phoneField, LayoutHelper.createFrame(-1, 36.0f));
            this.phoneField.addTextChangedListener(new TextWatcher(LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.PhoneView.3
                private int actionPosition;
                private int characterAction = -1;

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    if (i3 == 0 && i4 == 1) {
                        this.characterAction = 1;
                        return;
                    }
                    if (i3 == 1 && i4 == 0) {
                        if (charSequence.charAt(i2) == ' ' && i2 > 0) {
                            this.characterAction = 3;
                            this.actionPosition = i2 - 1;
                            return;
                        } else {
                            this.characterAction = 2;
                            return;
                        }
                    }
                    this.characterAction = -1;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    int i2;
                    int i3;
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
                    int i4 = 0;
                    while (i4 < string.length()) {
                        int i5 = i4 + 1;
                        String strSubstring = string.substring(i4, i5);
                        if ("0123456789".contains(strSubstring)) {
                            sb.append(strSubstring);
                        }
                        i4 = i5;
                    }
                    PhoneView.this.ignoreOnPhoneChange = true;
                    String hintText = PhoneView.this.phoneField.getHintText();
                    if (hintText != null) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= sb.length()) {
                                break;
                            }
                            if (i6 < hintText.length()) {
                                if (hintText.charAt(i6) == ' ') {
                                    sb.insert(i6, ' ');
                                    i6++;
                                    if (selectionStart == i6 && (i3 = this.characterAction) != 2 && i3 != 3) {
                                        selectionStart++;
                                    }
                                }
                                i6++;
                            } else {
                                sb.insert(i6, ' ');
                                if (selectionStart == i6 + 1 && (i2 = this.characterAction) != 2 && i2 != 3) {
                                    selectionStart++;
                                }
                            }
                        }
                    }
                    editable.replace(0, editable.length(), sb);
                    if (selectionStart >= 0) {
                        PhoneView.this.phoneField.setSelection(Math.min(selectionStart, PhoneView.this.phoneField.length()));
                    }
                    PhoneView.this.phoneField.onTextChange();
                    PhoneView.this.ignoreOnPhoneChange = false;
                }
            });
            this.phoneField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda4
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView4, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$4(textView4, i2, keyEvent);
                }
            });
            this.phoneField.setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view2, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$5(view2, i2, keyEvent);
                }
            });
            TextView textView4 = new TextView(context);
            this.textView2 = textView4;
            textView4.setText(LocaleController.getString("StartText", R.string.StartText));
            this.textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
            this.textView2.setTextSize(1, 14.0f);
            this.textView2.setGravity(LocaleController.isRTL ? 5 : 3);
            this.textView2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.textView2, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 0, 28, 0, 10));
            if (LoginActivityAppp.this.newAccount) {
                CheckBoxCell checkBoxCell = new CheckBoxCell(context, 2);
                this.checkBoxCell = checkBoxCell;
                checkBoxCell.setText(LocaleController.getString("SyncContacts", R.string.SyncContacts), BuildConfig.FLAVOR, LoginActivityAppp.this.syncContacts, false);
                addView(this.checkBoxCell, LayoutHelper.createLinear(-2, -1, 51, 0, 0, 0, 0));
                this.checkBoxCell.setOnClickListener(new View.OnClickListener(LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.PhoneView.4
                    private Toast visibleToast;

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (LoginActivityAppp.this.getParentActivity() == null) {
                            return;
                        }
                        LoginActivityAppp.this.syncContacts = !r0.syncContacts;
                        ((CheckBoxCell) view2).setChecked(LoginActivityAppp.this.syncContacts, true);
                        try {
                            Toast toast = this.visibleToast;
                            if (toast != null) {
                                toast.cancel();
                            }
                        } catch (Exception e) {
                            FileLog.e(e);
                        }
                        if (LoginActivityAppp.this.syncContacts) {
                            BulletinFactory.of((FrameLayout) LoginActivityAppp.this.fragmentView, null).createSimpleBulletin(R.raw.contacts_sync_on, LocaleController.getString("SyncContactsOn", R.string.SyncContactsOn)).show();
                        } else {
                            BulletinFactory.of((FrameLayout) LoginActivityAppp.this.fragmentView, null).createSimpleBulletin(R.raw.contacts_sync_off, LocaleController.getString("SyncContactsOff", R.string.SyncContactsOff)).show();
                        }
                    }
                });
            }
            HashMap map = new HashMap();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("countries.txt")));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.split(";");
                    this.countriesArray.add(0, strArrSplit[2]);
                    this.countriesMap.put(strArrSplit[2], strArrSplit[0]);
                    this.codesMap.put(strArrSplit[0], strArrSplit[2]);
                    if (strArrSplit.length > 3) {
                        this.phoneFormatMap.put(strArrSplit[0], strArrSplit[3]);
                    }
                    map.put(strArrSplit[1], strArrSplit[2]);
                }
                bufferedReader.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
            Collections.sort(this.countriesArray, ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda6.INSTANCE);
            selectCountry(LocaleController.getString("DefaultCountry", R.string.DefaultCountry), LocaleController.getString("IRCodeField", R.string.IRCodeField));
            if (this.codeField.length() == 0) {
                this.countryButton.setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                this.phoneField.setHintText((String) null);
                this.countryState = 1;
            }
            if (this.codeField.length() != 0) {
                this.phoneField.requestFocus();
                HintEditText hintEditText2 = this.phoneField;
                hintEditText2.setSelection(hintEditText2.length());
                return;
            }
            this.codeField.requestFocus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(View view) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(true);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda7
                @Override // org.rbmain.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(String str, String str2) {
                    this.f$0.lambda$new$1(str, str2);
                }
            });
            LoginActivityAppp.this.presentFragment(countrySelectActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(String str, String str2) {
            selectCountry(str, str2);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0();
                }
            }, 300L);
            this.phoneField.requestFocus();
            HintEditText hintEditText = this.phoneField;
            hintEditText.setSelection(hintEditText.length());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0() {
            AndroidUtilities.showKeyboard(this.phoneField);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$3(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            this.phoneField.requestFocus();
            HintEditText hintEditText = this.phoneField;
            hintEditText.setSelection(hintEditText.length());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$4(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$5(View view, int i, KeyEvent keyEvent) {
            if (i != 67 || this.phoneField.length() != 0) {
                return false;
            }
            this.codeField.requestFocus();
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            editTextBoldCursor.setSelection(editTextBoldCursor.length());
            this.codeField.dispatchKeyEvent(keyEvent);
            return true;
        }

        public void selectCountry(String str, String str2) {
            if (this.countriesArray.indexOf(str) != -1) {
                this.ignoreOnTextChange = true;
                String str3 = this.countriesMap.get(str);
                this.codeField.setText(str3);
                this.countryButton.setText(str);
                String str4 = this.phoneFormatMap.get(str3);
                this.phoneField.setHintText(str4 != null ? str4.replace('X', (char) 8211) : null);
                this.countryState = 0;
                this.ignoreOnTextChange = false;
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.ignoreSelection) {
                this.ignoreSelection = false;
                return;
            }
            this.ignoreOnTextChange = true;
            this.codeField.setText(this.countriesMap.get(this.countriesArray.get(i)));
            this.ignoreOnTextChange = false;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onNextPressed() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            if (LoginActivityAppp.this.getParentActivity() == null || this.nextPressed) {
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            if (BuildVars.DEBUG_VERSION) {
                FileLog.d("sim status = " + telephonyManager.getSimState());
            }
            int simState = telephonyManager.getSimState();
            boolean z5 = (simState == 1 || simState == 0 || telephonyManager.getPhoneType() == 0 || AndroidUtilities.isAirplaneModeOn()) ? false : true;
            int i = Build.VERSION.SDK_INT;
            if (i < 23 || !z5) {
                z = true;
                z2 = true;
                z3 = true;
            } else {
                z2 = LoginActivityAppp.this.getParentActivity().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                z3 = LoginActivityAppp.this.getParentActivity().checkSelfPermission("android.permission.CALL_PHONE") == 0;
                z = i < 28 || LoginActivityAppp.this.getParentActivity().checkSelfPermission("android.permission.READ_CALL_LOG") == 0;
                if (LoginActivityAppp.this.checkPermissions && this.codeField.getText().length() > 0 && !String.valueOf(this.codeField.getText()).equals("98")) {
                    LoginActivityAppp.this.permissionsItems.clear();
                    if (!z2) {
                        LoginActivityAppp.this.permissionsItems.add("android.permission.READ_PHONE_STATE");
                    }
                    if (!z3) {
                        LoginActivityAppp.this.permissionsItems.add("android.permission.CALL_PHONE");
                    }
                    if (!z) {
                        LoginActivityAppp.this.permissionsItems.add("android.permission.READ_CALL_LOG");
                    }
                    if (!LoginActivityAppp.this.permissionsItems.isEmpty()) {
                        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                        if (!globalMainSettings.getBoolean("firstlogin", true) && !LoginActivityAppp.this.getParentActivity().shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE") && !LoginActivityAppp.this.getParentActivity().shouldShowRequestPermissionRationale("android.permission.READ_CALL_LOG")) {
                            try {
                                LoginActivityAppp.this.getParentActivity().requestPermissions((String[]) LoginActivityAppp.this.permissionsItems.toArray(new String[0]), 6);
                            } catch (Exception unused) {
                                z4 = false;
                            }
                        } else {
                            globalMainSettings.edit().putBoolean("firstlogin", false).apply();
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
                            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                            if (!z2 && (!z3 || !z)) {
                                builder.setMessage(LocaleController.getString("AllowReadCallAndLog", R.string.AllowReadCallAndLog));
                            } else if (!z3 || !z) {
                                builder.setMessage(LocaleController.getString("AllowReadCallLog", R.string.AllowReadCallLog));
                            } else {
                                builder.setMessage(LocaleController.getString("AllowReadCall", R.string.AllowReadCall));
                            }
                            LoginActivityAppp loginActivityAppp = LoginActivityAppp.this;
                            loginActivityAppp.permissionsDialog = loginActivityAppp.showDialog(builder.create());
                        }
                        z4 = true;
                        if (z4) {
                            return;
                        }
                    }
                }
            }
            int i2 = this.countryState;
            if (i2 == 1) {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                return;
            }
            if (i2 == 2 && !BuildVars.DEBUG_VERSION) {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("WrongCountry", R.string.WrongCountry));
                return;
            }
            if (this.codeField.length() == 0) {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                return;
            }
            if (this.phoneField.length() == 0) {
                LoginActivityAppp.this.onFieldError(this.phoneField);
                return;
            }
            String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(BuildConfig.FLAVOR + ((Object) this.codeField.getText()) + this.phoneField.getText().toString().replaceFirst("^0+(?!$)", BuildConfig.FLAVOR));
            if (LoginActivityAppp.this.getParentActivity() instanceof LaunchActivity) {
                for (final int i3 = 0; i3 < 3; i3++) {
                    UserConfig userConfig = UserConfig.getInstance(i3);
                    if (userConfig.isClientActivated() && PhoneNumberUtils.compare(strStripExceptNumbers, userConfig.getCurrentUser().phone)) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
                        builder2.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        builder2.setMessage(LocaleController.getString("AccountAlreadyLoggedIn", R.string.AccountAlreadyLoggedIn));
                        builder2.setPositiveButton(LocaleController.getString("AccountSwitch", R.string.AccountSwitch), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i4) {
                                this.f$0.lambda$onNextPressed$6(i3, dialogInterface, i4);
                            }
                        });
                        builder2.setNegativeButton(LocaleController.getString("OK", R.string.OK), null);
                        LoginActivityAppp.this.showDialog(builder2.create());
                        return;
                    }
                }
            }
            ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).cleanup(false);
            TLRPC$TL_auth_sendCode tLRPC$TL_auth_sendCode = new TLRPC$TL_auth_sendCode();
            tLRPC$TL_auth_sendCode.api_hash = BuildVars.APP_HASH;
            tLRPC$TL_auth_sendCode.api_id = BuildVars.APP_ID;
            tLRPC$TL_auth_sendCode.phone_number = strStripExceptNumbers;
            TLRPC$TL_codeSettings tLRPC$TL_codeSettings = new TLRPC$TL_codeSettings();
            tLRPC$TL_auth_sendCode.settings = tLRPC$TL_codeSettings;
            tLRPC$TL_codeSettings.allow_flashcall = z5 && z2 && z3 && z;
            tLRPC$TL_codeSettings.allow_app_hash = ApplicationLoader.hasPlayServices;
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
            if (tLRPC$TL_auth_sendCode.settings.allow_app_hash) {
                sharedPreferences.edit().putString("sms_hash", BuildVars.SMS_HASH).apply();
            } else {
                sharedPreferences.edit().remove("sms_hash").apply();
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
            Bundle bundle = new Bundle();
            bundle.putString("phone", strStripExceptNumbers);
            try {
                bundle.putString("ephone", "+" + PhoneFormat.stripExceptNumbers(this.codeField.getText().toString()) + " " + PhoneFormat.stripExceptNumbers(this.phoneField.getText().toString()));
            } catch (Exception e2) {
                FileLog.e(e2);
                bundle.putString("ephone", "+" + strStripExceptNumbers);
            }
            bundle.putString("phoneFormated", strStripExceptNumbers);
            this.nextPressed = true;
            LoginActivityAppp.this.getAccountInstance().getCoreMainClass().sendCode(strStripExceptNumbers, null, new AnonymousClass5(bundle, strStripExceptNumbers));
            LoginActivityAppp.this.needShowProgress(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$6(int i, DialogInterface dialogInterface, int i2) {
            if (UserConfig.selectedAccount != i) {
                ((LaunchActivity) LoginActivityAppp.this.getParentActivity()).switchToAccount(i, false);
            }
            LoginActivityAppp.this.finishFragment();
        }

        /* renamed from: org.rbmain.ui.LoginActivityAppp$PhoneView$5, reason: invalid class name */
        class AnonymousClass5 implements LoadListener<SendCodeOutput> {
            final /* synthetic */ Bundle val$params;
            final /* synthetic */ String val$phone;

            AnonymousClass5(Bundle bundle, String str) {
                this.val$params = bundle;
                this.val$phone = str;
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(final SendCodeOutput sendCodeOutput) {
                final Bundle bundle = this.val$params;
                final String str = this.val$phone;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDidLoad$0(sendCodeOutput, bundle, str);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDidLoad$0(SendCodeOutput sendCodeOutput, Bundle bundle, String str) {
                SendCodeOutput.Status status = sendCodeOutput.status;
                if (status == SendCodeOutput.Status.OK) {
                    PhoneView.this.nextPressed = false;
                    TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode = new TLRPC$TL_auth_sentCode();
                    tLRPC$TL_auth_sentCode.next_type = new TLRPC$TL_auth_codeTypeSms();
                    TLRPC$TL_auth_sentCodeTypeSms tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$TL_auth_sentCodeTypeSms();
                    tLRPC$TL_auth_sentCode.type = tLRPC$TL_auth_sentCodeTypeSms;
                    tLRPC$TL_auth_sentCodeTypeSms.length = sendCodeOutput.code_digits_count;
                    tLRPC$TL_auth_sentCode.phone_code_hash = sendCodeOutput.phone_code_hash;
                    TLRPC$TL_auth_sentCodeTypeSms tLRPC$TL_auth_sentCodeTypeSms2 = new TLRPC$TL_auth_sentCodeTypeSms();
                    tLRPC$TL_auth_sentCode.type = tLRPC$TL_auth_sentCodeTypeSms2;
                    tLRPC$TL_auth_sentCodeTypeSms2.length = sendCodeOutput.code_digits_count;
                    LoginActivityAppp.this.fillNextCodeParams(bundle, tLRPC$TL_auth_sentCode);
                    LoginActivityAppp.this.needHideProgress(false);
                    return;
                }
                if (status == SendCodeOutput.Status.SendPassKey) {
                    PhoneView.this.nextPressed = false;
                    LoginActivityAppp.this.showDoneButton(false, true);
                    Bundle bundle2 = new Bundle();
                    String str2 = sendCodeOutput.hint_pass_key;
                    if (str2 == null) {
                        str2 = BuildConfig.FLAVOR;
                    }
                    bundle2.putString("hint", str2);
                    bundle2.putString("phoneFormated", str);
                    bundle2.putString("phoneHash", sendCodeOutput.phone_code_hash);
                    bundle2.putInt("has_recovery", sendCodeOutput.has_confirmed_recovery_email ? 1 : 0);
                    bundle2.putString("no_recovery_alert", sendCodeOutput.no_recovery_alert);
                    LoginActivityAppp.this.setPage(6, true, bundle2, false);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(final Exception exc) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$5$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onError$1(exc);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onError$1(Exception exc) {
                PhoneView.this.nextPressed = false;
                LoginActivityAppp.needShowInvalidAlert(LoginActivityAppp.this, exc instanceof LogInException ? ((LogInException) exc).errorMessage.name() : exc.getMessage(), false);
                LoginActivityAppp.this.needHideProgress(false);
            }
        }

        public void fillNumber() {
            boolean z;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
                if (telephonyManager.getSimState() == 1 || telephonyManager.getPhoneType() == 0) {
                    return;
                }
                boolean z2 = Build.VERSION.SDK_INT < 23 || LoginActivityAppp.this.getParentActivity().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                if (LoginActivityAppp.this.newAccount || !z2) {
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
                            z = false;
                            break;
                        }
                        String strSubstring2 = strStripExceptNumbers.substring(0, i);
                        if (this.codesMap.get(strSubstring2) != null) {
                            strSubstring = strStripExceptNumbers.substring(i);
                            this.codeField.setText(strSubstring2);
                            z = true;
                            break;
                        }
                        i--;
                    }
                    if (!z) {
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

        @Override // org.rbmain.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            fillNumber();
            CheckBoxCell checkBoxCell = this.checkBoxCell;
            if (checkBoxCell != null) {
                checkBoxCell.setChecked(LoginActivityAppp.this.syncContacts, false);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$PhoneView$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$7();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onShow$7() {
            if (this.phoneField != null) {
                if (LoginActivityAppp.this.needRequestPermissions) {
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

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("YourPhone", R.string.YourPhone);
        }

        @Override // org.rbmain.ui.Components.SlideView
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

        @Override // org.rbmain.ui.Components.SlideView
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

    public class LoginActivityApppSmsView extends SlideView implements NotificationCenter.NotificationCenterDelegate {
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
        private boolean nextPressed;
        private int nextType;
        private int openTime;
        private String passKey;
        private String pattern;
        private String phone;
        private String phoneHash;
        private TextView problemText;
        private ProgressView progressView;
        private String requestPhone;
        private int time;
        private TextView timeText;
        private Timer timeTimer;
        private final Object timerSync;
        private TextView titleTextView;
        private boolean waitingForEvent;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBackPressed$4(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        static /* synthetic */ int access$4726(LoginActivityApppSmsView loginActivityApppSmsView, double d) {
            double d2 = loginActivityApppSmsView.codeTime;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            loginActivityApppSmsView.codeTime = i;
            return i;
        }

        static /* synthetic */ int access$5326(LoginActivityApppSmsView loginActivityApppSmsView, double d) {
            double d2 = loginActivityApppSmsView.time;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            loginActivityApppSmsView.time = i;
            return i;
        }

        public LoginActivityApppSmsView(Context context, int i) {
            super(context);
            this.timerSync = new Object();
            this.time = 60000;
            this.codeTime = 15000;
            this.lastError = BuildConfig.FLAVOR;
            this.pattern = "*";
            this.currentType = i;
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            int i2 = Theme.key_windowBackgroundWhiteGrayText6;
            textView.setTextColor(Theme.getColor(i2));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            TextView textView2 = new TextView(context);
            this.titleTextView = textView2;
            int i3 = Theme.key_windowBackgroundWhiteBlackText;
            textView2.setTextColor(Theme.getColor(i3));
            this.titleTextView.setTextSize(1, 18.0f);
            this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
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
                    this.blackImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i3), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blackImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    RLottieImageView rLottieImageView = new RLottieImageView(context);
                    this.blueImageView = rLottieImageView;
                    rLottieImageView.setImageResource(R.drawable.sms_bubble);
                    this.blueImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_actionBackground), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    this.titleTextView.setText(LocaleController.getString("SentAppCodeTitle", R.string.SentAppCodeTitle));
                } else {
                    this.blueImageView = new RLottieImageView(context);
                    RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.sms_incoming_info, "2131820642", AndroidUtilities.dp(64.0f), AndroidUtilities.dp(64.0f), true, null);
                    this.hintDrawable = rLottieDrawable;
                    int i4 = Theme.key_chats_actionBackground;
                    rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor(i4));
                    this.hintDrawable.setLayerColor("Phone.**", Theme.getColor(i4));
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
            AppCompatTextView appCompatTextView = new AppCompatTextView(this, context, LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppSmsView.1
                @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
                protected void onMeasure(int i5, int i6) {
                    super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.timeText = appCompatTextView;
            appCompatTextView.setTextColor(Theme.getColor(i2));
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
                this.timeText.setGravity(49);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, 49));
            }
            AppCompatTextView appCompatTextView2 = new AppCompatTextView(this, context, LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppSmsView.2
                @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
                protected void onMeasure(int i5, int i6) {
                    super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }

                @Override // android.widget.TextView, android.view.View
                public void setEnabled(boolean z2) {
                    super.setEnabled(z2);
                    if (z2) {
                        setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4));
                    } else {
                        setTextColor(Theme.getColor(Theme.key_graySectionText));
                    }
                }
            };
            this.problemText = appCompatTextView2;
            appCompatTextView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4));
            this.problemText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.problemText.setPadding(0, AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(10.0f));
            this.problemText.setTextSize(1, 15.0f);
            this.problemText.setGravity(49);
            if (this.currentType == 1) {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCodeSms", R.string.DidNotGetTheCodeSms));
            } else {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCode", R.string.DidNotGetTheCode));
            }
            addView(this.problemText, LayoutHelper.createLinear(-2, -2, 49));
            this.problemText.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws PackageManager.NameNotFoundException {
                    this.f$0.lambda$new$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) throws PackageManager.NameNotFoundException {
            if (this.nextPressed) {
                return;
            }
            int i = this.nextType;
            if (!((i == 4 && this.currentType == 2) || i == 0)) {
                if (LoginActivityAppp.this.doneProgressView.getTag() != null) {
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
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"sms@stel.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Android registration/login issue " + str + " " + this.emailPhone);
                intent.putExtra("android.intent.extra.TEXT", "Phone: " + this.requestPhone + "\nApp version: " + str + "\nOS version: SDK " + Build.VERSION.SDK_INT + "\nDevice Name: " + Build.MANUFACTURER + Build.MODEL + "\nLocale: " + Locale.getDefault() + "\nError: " + this.lastError);
                getContext().startActivity(Intent.createChooser(intent, "Send email..."));
            } catch (Exception unused) {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("NoMailInstalled", R.string.NoMailInstalled));
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            RLottieImageView rLottieImageView;
            super.onMeasure(i, i2);
            if (this.currentType == 3 || (rLottieImageView = this.blueImageView) == null) {
                return;
            }
            int measuredHeight = rLottieImageView.getMeasuredHeight() + this.titleTextView.getMeasuredHeight() + this.confirmTextView.getMeasuredHeight() + AndroidUtilities.dp(35.0f);
            int iDp = AndroidUtilities.dp(80.0f);
            int iDp2 = AndroidUtilities.dp(291.0f);
            if (LoginActivityAppp.this.scrollHeight - measuredHeight >= iDp) {
                setMeasuredDimension(getMeasuredWidth(), Math.min(LoginActivityAppp.this.scrollHeight, iDp2));
            } else {
                setMeasuredDimension(getMeasuredWidth(), measuredHeight + iDp);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5;
            super.onLayout(z, i, i2, i3, i4);
            if (this.currentType == 3 || this.blueImageView == null) {
                return;
            }
            int bottom = this.confirmTextView.getBottom();
            int measuredHeight = getMeasuredHeight() - bottom;
            if (this.problemText.getVisibility() == 0) {
                int measuredHeight2 = this.problemText.getMeasuredHeight();
                i5 = (measuredHeight + bottom) - measuredHeight2;
                TextView textView = this.problemText;
                textView.layout(textView.getLeft(), i5, this.problemText.getRight(), measuredHeight2 + i5);
            } else if (this.timeText.getVisibility() == 0) {
                int measuredHeight3 = this.timeText.getMeasuredHeight();
                i5 = (measuredHeight + bottom) - measuredHeight3;
                TextView textView2 = this.timeText;
                textView2.layout(textView2.getLeft(), i5, this.timeText.getRight(), measuredHeight3 + i5);
            } else {
                i5 = measuredHeight + bottom;
            }
            int measuredHeight4 = this.codeFieldContainer.getMeasuredHeight();
            int i6 = (((i5 - bottom) - measuredHeight4) / 2) + bottom;
            LinearLayout linearLayout = this.codeFieldContainer;
            linearLayout.layout(linearLayout.getLeft(), i6, this.codeFieldContainer.getRight(), measuredHeight4 + i6);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resendCode() {
            Bundle bundle = new Bundle();
            bundle.putString("phone", this.phone);
            bundle.putString("ephone", this.emailPhone);
            bundle.putString("phoneFormated", this.requestPhone);
            bundle.putString("passKey", this.passKey);
            this.nextPressed = true;
            LoginActivityAppp.this.getAccountInstance().getCoreMainClass().sendCode(this.requestPhone, this.passKey, new AnonymousClass3(bundle));
        }

        /* renamed from: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$3, reason: invalid class name */
        class AnonymousClass3 implements LoadListener<SendCodeOutput> {
            final /* synthetic */ Bundle val$params;

            AnonymousClass3(Bundle bundle) {
                this.val$params = bundle;
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(final SendCodeOutput sendCodeOutput) {
                final Bundle bundle = this.val$params;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDidLoad$0(sendCodeOutput, bundle);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDidLoad$0(SendCodeOutput sendCodeOutput, Bundle bundle) {
                LoginActivityApppSmsView.this.nextPressed = false;
                if (sendCodeOutput.status != SendCodeOutput.Status.OK) {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("FloodWait", R.string.FloodWait));
                } else {
                    TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode = new TLRPC$TL_auth_sentCode();
                    tLRPC$TL_auth_sentCode.next_type = new TLRPC$TL_auth_codeTypeSms();
                    TLRPC$TL_auth_sentCodeTypeSms tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$TL_auth_sentCodeTypeSms();
                    tLRPC$TL_auth_sentCode.type = tLRPC$TL_auth_sentCodeTypeSms;
                    tLRPC$TL_auth_sentCodeTypeSms.length = sendCodeOutput.code_digits_count;
                    tLRPC$TL_auth_sentCode.phone_code_hash = sendCodeOutput.phone_code_hash;
                    LoginActivityAppp.this.fillNextCodeParams(bundle, tLRPC$TL_auth_sentCode);
                }
                LoginActivityAppp.this.needHideProgress(false);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(final Exception exc) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onError$1(exc);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onError$1(Exception exc) {
                LoginActivityApppSmsView.this.nextPressed = false;
                LoginActivityAppp.needShowInvalidAlert(LoginActivityAppp.this, exc instanceof LogInException ? ((LogInException) exc).errorMessage.name() : exc.getMessage(), false);
                LoginActivityAppp.this.needHideProgress(false);
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            if (this.currentType == 1) {
                return this.phone;
            }
            return LocaleController.getString("YourCode", R.string.YourCode);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void setParams(Bundle bundle, boolean z) {
            int i;
            String string;
            int i2;
            if (bundle == null) {
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
            this.currentParams = bundle;
            this.phone = bundle.getString("phone");
            this.emailPhone = bundle.getString("ephone");
            this.requestPhone = bundle.getString("phoneFormated");
            try {
                this.passKey = bundle.getString("passKey");
            } catch (Exception unused) {
            }
            this.phoneHash = bundle.getString("phoneHash");
            this.time = bundle.getInt("timeout");
            this.openTime = (int) (System.currentTimeMillis() / 1000);
            this.nextType = bundle.getInt("nextType");
            this.pattern = bundle.getString("pattern");
            int i4 = bundle.getInt("length");
            this.length = i4;
            if (i4 == 0) {
                this.length = 5;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            CharSequence charSequenceReplaceTags = BuildConfig.FLAVOR;
            if (editTextBoldCursorArr != null && editTextBoldCursorArr.length == this.length) {
                int i5 = 0;
                while (true) {
                    EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                    if (i5 >= editTextBoldCursorArr2.length) {
                        break;
                    }
                    editTextBoldCursorArr2[i5].setText(BuildConfig.FLAVOR);
                    i5++;
                }
            } else {
                this.codeField = new EditTextBoldCursor[this.length];
                this.codeFieldContainer.removeAllViews();
                final int i6 = 0;
                while (i6 < this.length) {
                    this.codeField[i6] = new EditTextBoldCursor(getContext());
                    EditTextBoldCursor editTextBoldCursor = this.codeField[i6];
                    int i7 = Theme.key_windowBackgroundWhiteBlackText;
                    editTextBoldCursor.setTextColor(Theme.getColor(i7));
                    this.codeField[i6].setCursorColor(Theme.getColor(i7));
                    this.codeField[i6].setCursorSize(AndroidUtilities.dp(20.0f));
                    this.codeField[i6].setCursorWidth(1.5f);
                    Drawable drawableMutate = getResources().getDrawable(R.drawable.search_dark_activated).mutate();
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundWhiteInputFieldActivated), PorterDuff.Mode.MULTIPLY));
                    this.codeField[i6].setBackgroundDrawable(drawableMutate);
                    this.codeField[i6].setImeOptions(268435461);
                    this.codeField[i6].setTextSize(1, 20.0f);
                    this.codeField[i6].setMaxLines(1);
                    this.codeField[i6].setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                    this.codeField[i6].setPadding(0, 0, 0, 0);
                    this.codeField[i6].setGravity(49);
                    if (this.currentType == 3) {
                        this.codeField[i6].setEnabled(false);
                        this.codeField[i6].setInputType(0);
                        this.codeField[i6].setVisibility(8);
                    } else {
                        this.codeField[i6].setInputType(3);
                    }
                    this.codeFieldContainer.addView(this.codeField[i6], LayoutHelper.createLinear(34, 36, 1, 0, 0, i6 != this.length - 1 ? 7 : 0, 0));
                    this.codeField[i6].addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppSmsView.4
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            int length;
                            if (!LoginActivityApppSmsView.this.ignoreOnTextChange && (length = editable.length()) >= 1) {
                                if (length > 1) {
                                    String string2 = editable.toString();
                                    LoginActivityApppSmsView.this.ignoreOnTextChange = true;
                                    for (int i8 = 0; i8 < Math.min(LoginActivityApppSmsView.this.length - i6, length); i8++) {
                                        if (i8 != 0) {
                                            LoginActivityApppSmsView.this.codeField[i6 + i8].setText(string2.substring(i8, i8 + 1));
                                        } else {
                                            editable.replace(0, length, string2.substring(i8, i8 + 1));
                                        }
                                    }
                                    LoginActivityApppSmsView.this.ignoreOnTextChange = false;
                                }
                                if (i6 != LoginActivityApppSmsView.this.length - 1) {
                                    LoginActivityApppSmsView.this.codeField[i6 + 1].setSelection(LoginActivityApppSmsView.this.codeField[i6 + 1].length());
                                    LoginActivityApppSmsView.this.codeField[i6 + 1].requestFocus();
                                }
                                if ((i6 == LoginActivityApppSmsView.this.length - 1 || (i6 == LoginActivityApppSmsView.this.length - 2 && length >= 2)) && LoginActivityApppSmsView.this.getCode().length() == LoginActivityApppSmsView.this.length) {
                                    LoginActivityApppSmsView.this.onNextPressed();
                                }
                            }
                        }
                    });
                    this.codeField[i6].setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i8, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$1(i6, view, i8, keyEvent);
                        }
                    });
                    this.codeField[i6].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$$ExternalSyntheticLambda3
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView, int i8, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$2(textView, i8, keyEvent);
                        }
                    });
                    i6++;
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
            int i8 = this.currentType;
            if (i8 == 1) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.getString("SentAppCode", R.string.SentAppCode));
            } else if (i8 == 2) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentSmsCode", R.string.SentSmsCode, LocaleController.addNbsp(str)));
            } else if (i8 == 3) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentCallCode", R.string.SentCallCode, LocaleController.addNbsp(str)));
            } else if (i8 == 4) {
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
            int i9 = this.currentType;
            if (i9 == 1) {
                this.problemText.setEnabled(true);
                this.timeText.setVisibility(8);
                return;
            }
            if (i9 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) {
                this.problemText.setEnabled(false);
                this.timeText.setVisibility(0);
                int i10 = this.nextType;
                if (i10 == 4) {
                    this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 1, 0));
                } else if (i10 == 2) {
                    this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 1, 0));
                }
                strSubstring = z ? AndroidUtilities.obtainLoginPhoneCall(this.pattern) : null;
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
            if (i9 == 2 && ((i = this.nextType) == 4 || i == 3)) {
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
            if (i9 == 4 && this.nextType == 2) {
                this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                createTimer();
                return;
            }
            this.timeText.setVisibility(8);
            this.problemText.setEnabled(false);
            createCodeTimer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$setParams$1(int i, View view, int i2, KeyEvent keyEvent) {
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
        public /* synthetic */ boolean lambda$setParams$2(TextView textView, int i, KeyEvent keyEvent) {
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
            this.codeTime = (MyLog.isDebugAble ? 15 : 60) * CloseCodes.NORMAL_CLOSURE;
            this.codeTimer = new Timer();
            this.lastCodeTime = System.currentTimeMillis();
            this.codeTimer.schedule(new AnonymousClass5(), 0L, 1000L);
        }

        /* renamed from: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$5, reason: invalid class name */
        class AnonymousClass5 extends TimerTask {
            AnonymousClass5() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivityApppSmsView.this.lastCodeTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivityApppSmsView.this.lastCodeTime = dCurrentTimeMillis;
                LoginActivityApppSmsView.access$4726(LoginActivityApppSmsView.this, dCurrentTimeMillis - d);
                if (LoginActivityApppSmsView.this.codeTime <= 1000) {
                    LoginActivityApppSmsView.this.problemText.setEnabled(true);
                    LoginActivityApppSmsView.this.timeText.setVisibility(8);
                    LoginActivityApppSmsView.this.destroyCodeTimer();
                    LoginActivityApppSmsView.this.problemText.setText(LocaleController.getString("LoginRemainingText", R.string.LoginRemainingText));
                    return;
                }
                LoginActivityApppSmsView.this.problemText.setText(LocaleController.formatString("LoginRemainingTime", R.string.LoginRemainingTime, NumberUtils.toPersian((LoginActivityApppSmsView.this.codeTime / CloseCodes.NORMAL_CLOSURE) + BuildConfig.FLAVOR)));
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
            Timer timer = new Timer();
            this.timeTimer = timer;
            timer.schedule(new AnonymousClass6(), 0L, 1000L);
        }

        /* renamed from: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$6, reason: invalid class name */
        class AnonymousClass6 extends TimerTask {
            AnonymousClass6() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LoginActivityApppSmsView.this.timeTimer == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$6$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$2();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$2() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivityApppSmsView.this.lastCurrentTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivityApppSmsView.this.lastCurrentTime = dCurrentTimeMillis;
                LoginActivityApppSmsView.access$5326(LoginActivityApppSmsView.this, dCurrentTimeMillis - d);
                if (LoginActivityApppSmsView.this.time >= 1000) {
                    int i = (LoginActivityApppSmsView.this.time / CloseCodes.NORMAL_CLOSURE) / 60;
                    int i2 = (LoginActivityApppSmsView.this.time / CloseCodes.NORMAL_CLOSURE) - (i * 60);
                    if (LoginActivityApppSmsView.this.nextType == 4 || LoginActivityApppSmsView.this.nextType == 3) {
                        LoginActivityApppSmsView.this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, Integer.valueOf(i), Integer.valueOf(i2)));
                    } else if (LoginActivityApppSmsView.this.nextType == 2) {
                        LoginActivityApppSmsView.this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, Integer.valueOf(i), Integer.valueOf(i2)));
                    }
                    if (LoginActivityApppSmsView.this.progressView == null || LoginActivityApppSmsView.this.progressView.isProgressAnimationRunning()) {
                        return;
                    }
                    LoginActivityApppSmsView.this.progressView.startProgressAnimation(LoginActivityApppSmsView.this.time - 1000);
                    return;
                }
                LoginActivityApppSmsView.this.destroyTimer();
                if (LoginActivityApppSmsView.this.currentType != 3) {
                    if (LoginActivityApppSmsView.this.currentType == 2 || LoginActivityApppSmsView.this.currentType == 4) {
                        if (LoginActivityApppSmsView.this.nextType == 4 || LoginActivityApppSmsView.this.nextType == 2) {
                            if (LoginActivityApppSmsView.this.nextType == 4) {
                                LoginActivityApppSmsView.this.timeText.setText(LocaleController.getString("Calling", R.string.Calling));
                            } else {
                                LoginActivityApppSmsView.this.timeText.setText(LocaleController.getString("SendingSms", R.string.SendingSms));
                            }
                            LoginActivityApppSmsView.this.createCodeTimer();
                            TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
                            tLRPC$TL_auth_resendCode.phone_number = LoginActivityApppSmsView.this.requestPhone;
                            tLRPC$TL_auth_resendCode.phone_code_hash = LoginActivityApppSmsView.this.phoneHash;
                            ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$6$$ExternalSyntheticLambda2
                                @Override // org.rbmain.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$run$1(tLObject, tLRPC$TL_error);
                                }
                            }, 10);
                            return;
                        }
                        if (LoginActivityApppSmsView.this.nextType == 3) {
                            AndroidUtilities.setWaitingForSms(false);
                            NotificationCenter.getGlobalInstance().removeObserver(LoginActivityApppSmsView.this, NotificationCenter.didReceiveSmsCode);
                            LoginActivityApppSmsView.this.waitingForEvent = false;
                            LoginActivityApppSmsView.this.destroyCodeTimer();
                            LoginActivityApppSmsView.this.resendCode();
                            return;
                        }
                        return;
                    }
                    return;
                }
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(LoginActivityApppSmsView.this, NotificationCenter.didReceiveCall);
                LoginActivityApppSmsView.this.waitingForEvent = false;
                LoginActivityApppSmsView.this.destroyCodeTimer();
                LoginActivityApppSmsView.this.resendCode();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$1(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                if (tLRPC$TL_error == null || tLRPC$TL_error.text == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$6$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0(tLRPC$TL_error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(TLRPC$TL_error tLRPC$TL_error) {
                LoginActivityApppSmsView.this.lastError = tLRPC$TL_error.text;
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
                return BuildConfig.FLAVOR;
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

        @Override // org.rbmain.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed || LoginActivityAppp.this.currentViewNum < 1 || LoginActivityAppp.this.currentViewNum > 4) {
                return;
            }
            String code = getCode();
            if (TextUtils.isEmpty(code)) {
                LoginActivityAppp.this.onFieldError(this.codeFieldContainer);
                return;
            }
            this.nextPressed = true;
            setInputsEnabled(false);
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            TLRPC$TL_auth_signIn tLRPC$TL_auth_signIn = new TLRPC$TL_auth_signIn();
            tLRPC$TL_auth_signIn.phone_number = this.requestPhone;
            tLRPC$TL_auth_signIn.phone_code = code;
            tLRPC$TL_auth_signIn.phone_code_hash = this.phoneHash;
            destroyTimer();
            LoginActivityAppp.this.getAccountInstance().getCoreMainClass().signIn(UserConfig.getActivatedAccountsCount() > 0, this.requestPhone, this.phoneHash, code, new AnonymousClass7());
            LoginActivityAppp.this.needShowProgress(1, false);
            LoginActivityAppp.this.showDoneButton(true, true);
        }

        /* renamed from: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$7, reason: invalid class name */
        class AnonymousClass7 implements LoadListener<String> {
            AnonymousClass7() {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                if (str != null && !str.isEmpty()) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$7$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDidLoad$0();
                        }
                    });
                } else {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$7$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onDidLoad$1();
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDidLoad$0() {
                LoginActivityApppSmsView.this.setInputsEnabled(true);
                LoginActivityApppSmsView.this.nextPressed = false;
                LoginActivityAppp.this.showDoneButton(false, true);
                LoginActivityApppSmsView.this.destroyTimer();
                LoginActivityApppSmsView.this.destroyCodeTimer();
                TLRPC$TL_auth_authorization tLRPC$TL_auth_authorization = new TLRPC$TL_auth_authorization();
                if (!LoginActivityAppp.this.newAccount) {
                    IdStorage.getInstance().clear();
                }
                tLRPC$TL_auth_authorization.user = LoginActivityAppp.this.getDialogsProxy().getCurrentUser(false);
                LoginActivityAppp.this.onAuthSuccess(tLRPC$TL_auth_authorization);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDidLoad$1() {
                LoginActivityApppSmsView.this.setInputsEnabled(true);
                LoginActivityApppSmsView.this.nextPressed = false;
                LoginActivityAppp.this.showDoneButton(false, true);
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(LoginActivityApppSmsView.this, NotificationCenter.didReceiveSmsCode);
                LoginActivityApppSmsView.this.waitingForEvent = true;
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred));
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(final Exception exc) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$7$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onError$2(exc);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onError$2(Exception exc) {
                LoginActivityApppSmsView.this.setInputsEnabled(true);
                LoginActivityApppSmsView.this.nextPressed = false;
                LoginActivityAppp.this.showDoneButton(false, true);
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(LoginActivityApppSmsView.this, NotificationCenter.didReceiveSmsCode);
                LoginActivityApppSmsView.this.waitingForEvent = true;
                if (!(exc instanceof LogInException)) {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred));
                    return;
                }
                LogInException.ErrorEnum errorEnum = ((LogInException) exc).errorMessage;
                if (errorEnum == LogInException.ErrorEnum.CodeIsExpired) {
                    LoginActivityApppSmsView.this.onBackPressed(true);
                    LoginActivityAppp.this.setPage(0, true, null, true);
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired));
                } else if (errorEnum == LogInException.ErrorEnum.CodeIsUsed) {
                    LoginActivityApppSmsView.this.destroyCodeTimer();
                    LoginActivityApppSmsView.this.problemText.setEnabled(true);
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeIsUsedError", R.string.CodeIsUsedError));
                } else {
                    if (errorEnum == LogInException.ErrorEnum.CodeIsInvalid) {
                        LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
                        for (int i = 0; i < LoginActivityApppSmsView.this.codeField.length; i++) {
                            LoginActivityApppSmsView.this.codeField[i].setText(BuildConfig.FLAVOR);
                        }
                        LoginActivityApppSmsView.this.codeField[0].requestFocus();
                        return;
                    }
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ErrorOccurred", R.string.ErrorOccurred));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInputsEnabled(boolean z) {
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            if (editTextBoldCursorArr != null) {
                for (int length = editTextBoldCursorArr.length - 1; length >= 0; length--) {
                    this.codeField[length].setEnabled(z);
                    this.codeField[length].setAlpha(z ? 1.0f : 0.5f);
                }
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean onBackPressed(boolean z) {
            if (!z) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("StopVerification", R.string.StopVerification));
                builder.setPositiveButton(LocaleController.getString("Continue", R.string.Continue), null);
                builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onBackPressed$3(dialogInterface, i);
                    }
                });
                LoginActivityAppp.this.showDialog(builder.create());
                return false;
            }
            this.nextPressed = false;
            LoginActivityAppp.this.needHideProgress(true);
            TLRPC$TL_auth_cancelCode tLRPC$TL_auth_cancelCode = new TLRPC$TL_auth_cancelCode();
            tLRPC$TL_auth_cancelCode.phone_number = this.requestPhone;
            tLRPC$TL_auth_cancelCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).sendRequest(tLRPC$TL_auth_cancelCode, new RequestDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$$ExternalSyntheticLambda5
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    LoginActivityAppp.LoginActivityApppSmsView.lambda$onBackPressed$4(tLObject, tLRPC$TL_error);
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
        public /* synthetic */ void lambda$onBackPressed$3(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            LoginActivityAppp.this.setPage(0, true, null, true);
        }

        @Override // org.rbmain.ui.Components.SlideView
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

        @Override // org.rbmain.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            if (this.currentType == 3) {
                return;
            }
            RLottieDrawable rLottieDrawable = this.hintDrawable;
            if (rLottieDrawable != null) {
                rLottieDrawable.setCurrentFrame(0);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppSmsView$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$5();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onShow$5() {
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

        @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int i, int i2, Object... objArr) {
            EditTextBoldCursor[] editTextBoldCursorArr;
            if (!this.waitingForEvent || (editTextBoldCursorArr = this.codeField) == null) {
                return;
            }
            if (i == NotificationCenter.didReceiveSmsCode) {
                editTextBoldCursorArr[0].setText(BuildConfig.FLAVOR + objArr[0]);
                onNextPressed();
                return;
            }
            if (i == NotificationCenter.didReceiveCall) {
                String str = BuildConfig.FLAVOR + objArr[0];
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

        @Override // org.rbmain.ui.Components.SlideView
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

        @Override // org.rbmain.ui.Components.SlideView
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

    public class LoginActivityApppPasswordView extends SlideView {
        private TextView cancelButton;
        private EditTextBoldCursor codeField;
        private TextView confirmTextView;
        private Bundle currentParams;
        private byte[] current_salt1;
        private byte[] current_salt2;
        private boolean has_recovery;
        private boolean nextPressed;
        private String noRecoveryAlert;
        private String passKey;
        private int passwordType;
        private String phoneCode;
        private String phoneHash;
        private String requestPhone;
        private TextView resetAccountButton;
        private TextView resetAccountText;
        private ImageView showPasswordButton;

        @Override // org.rbmain.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        public LoginActivityApppPasswordView(Context context) {
            super(context);
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            int i = Theme.key_windowBackgroundWhiteGrayText6;
            textView.setTextColor(Theme.getColor(i));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.confirmTextView.setText(LocaleController.getString("LoginPasswordText", R.string.LoginPasswordText));
            addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
            FrameLayout frameLayout = new FrameLayout(context);
            addView(frameLayout, LayoutHelper.createLinear(-1, 36, 49, 0, 20, 0, 0));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.codeField = editTextBoldCursor;
            int i2 = Theme.key_windowBackgroundWhiteBlackText;
            editTextBoldCursor.setTextColor(Theme.getColor(i2));
            this.codeField.setCursorColor(Theme.getColor(i2));
            this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.codeField.setCursorWidth(1.5f);
            this.codeField.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
            this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.codeField.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
            this.codeField.setImeOptions(268435461);
            this.codeField.setTextSize(1, 18.0f);
            this.codeField.setMaxLines(1);
            this.codeField.setPadding(AndroidUtilities.dp(36.0f), 0, 0, 0);
            this.codeField.setInputType(129);
            this.codeField.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.codeField.setTypeface(Typeface.DEFAULT);
            this.codeField.setGravity(LocaleController.isRTL ? 5 : 3);
            frameLayout.addView(this.codeField, LayoutHelper.createLinear(-1, 36, 1, 0, 0, 0, 0));
            this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda5
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$0(textView2, i3, keyEvent);
                }
            });
            ImageView imageView = new ImageView(context, LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppPasswordView.1
                @Override // android.view.View
                public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
                    super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
                    accessibilityNodeInfo.setCheckable(true);
                    accessibilityNodeInfo.setChecked(LoginActivityApppPasswordView.this.codeField.getTransformationMethod() == null);
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
            this.showPasswordButton.setVisibility(0);
            frameLayout.addView(this.showPasswordButton, LayoutHelper.createFrame(36, 36.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
            this.showPasswordButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$1(view);
                }
            });
            TextView textView2 = new TextView(context);
            this.cancelButton = textView2;
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.cancelButton.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4));
            this.cancelButton.setText(LocaleController.getString("ForgotPassword", R.string.ForgotPassword));
            this.cancelButton.setTextSize(1, 14.0f);
            this.cancelButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.cancelButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.cancelButton, LayoutHelper.createLinear(-1, -2, (LocaleController.isRTL ? 5 : 3) | 48));
            this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$5(view);
                }
            });
            TextView textView3 = new TextView(context);
            this.resetAccountButton = textView3;
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountButton.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
            this.resetAccountButton.setVisibility(8);
            this.resetAccountButton.setText(LocaleController.getString("ResetMyAccount", R.string.ResetMyAccount));
            this.resetAccountButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.resetAccountButton.setTextSize(1, 14.0f);
            this.resetAccountButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.resetAccountButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.resetAccountButton, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 34, 0, 0));
            this.resetAccountButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$9(view);
                }
            });
            TextView textView4 = new TextView(context);
            this.resetAccountText = textView4;
            textView4.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountText.setVisibility(8);
            this.resetAccountText.setTextColor(Theme.getColor(i));
            this.resetAccountText.setText(LocaleController.getString("ResetMyAccountText", R.string.ResetMyAccountText));
            this.resetAccountText.setTextSize(1, 14.0f);
            this.resetAccountText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.resetAccountText, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 7, 0, 14));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$0(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(View view) {
            if (this.codeField.getTransformationMethod() == null) {
                this.codeField.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelIcons), PorterDuff.Mode.MULTIPLY));
            } else {
                this.codeField.setTransformationMethod(null);
                this.showPasswordButton.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chat_messagePanelSend), PorterDuff.Mode.MULTIPLY));
            }
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            editTextBoldCursor.setSelection(editTextBoldCursor.length());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$5(View view) {
            if (LoginActivityAppp.this.doneProgressView.getTag() != null) {
                return;
            }
            if (this.has_recovery) {
                LoginActivityAppp.this.needShowProgress(0);
                TLRPC$TL_auth_requestPasswordRecovery tLRPC$TL_auth_requestPasswordRecovery = new TLRPC$TL_auth_requestPasswordRecovery();
                tLRPC$TL_auth_requestPasswordRecovery.phoneNumber = this.requestPhone;
                ContactsProxy.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).requestLoginForgetPassword(tLRPC$TL_auth_requestPasswordRecovery, new RequestDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda10
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$new$4(tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            AndroidUtilities.hideKeyboard(this.codeField);
            LoginActivityAppp loginActivityAppp = LoginActivityAppp.this;
            String string = LocaleController.getString("RestorePasswordNoEitle", R.string.RestorePasswordNoEmailTitle);
            String str = this.noRecoveryAlert;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            loginActivityAppp.needShowAlert(string, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$4(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$3(tLRPC$TL_error, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$3(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
            LoginActivityAppp.this.needHideProgress(false);
            if (tLRPC$TL_error == null) {
                final TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery = (TLRPC$TL_auth_passwordRecovery) tLObject;
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
                builder.setMessage(LocaleController.formatString("RestoreEmailSent", R.string.RestoreEmailSent, tLRPC$TL_auth_passwordRecovery.email_pattern));
                builder.setTitle(LocaleController.getString("RestoreEmailSentTitle", R.string.RestoreEmailSentTitle));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$new$2(tLRPC$TL_auth_passwordRecovery, dialogInterface, i);
                    }
                });
                Dialog dialogShowDialog = LoginActivityAppp.this.showDialog(builder.create());
                if (dialogShowDialog != null) {
                    dialogShowDialog.setCanceledOnTouchOutside(false);
                    dialogShowDialog.setCancelable(false);
                    return;
                }
                return;
            }
            LoginActivityAppp.needShowInvalidAlert(LoginActivityAppp.this, tLRPC$TL_error.text, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(TLRPC$TL_auth_passwordRecovery tLRPC$TL_auth_passwordRecovery, DialogInterface dialogInterface, int i) {
            Bundle bundle = new Bundle();
            bundle.putString("email_unconfirmed_pattern", tLRPC$TL_auth_passwordRecovery.email_pattern);
            bundle.putString("forget_password_code_hash", tLRPC$TL_auth_passwordRecovery.forget_password_code_hash);
            bundle.putString("requestPhone", this.requestPhone);
            LoginActivityAppp.this.setPage(7, true, bundle, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$9(View view) {
            if (LoginActivityAppp.this.doneProgressView.getTag() != null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
            builder.setMessage(LocaleController.getString("ResetMyAccountWarningText", R.string.ResetMyAccountWarningText));
            builder.setTitle(LocaleController.getString("ResetMyAccountWarning", R.string.ResetMyAccountWarning));
            builder.setPositiveButton(LocaleController.getString("ResetMyAccountWarningReset", R.string.ResetMyAccountWarningReset), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$new$8(dialogInterface, i);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            LoginActivityAppp.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$8(DialogInterface dialogInterface, int i) {
            LoginActivityAppp.this.needShowProgress(0);
            TLRPC$TL_account_deleteAccount tLRPC$TL_account_deleteAccount = new TLRPC$TL_account_deleteAccount();
            tLRPC$TL_account_deleteAccount.reason = "Forgot password";
            ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).sendRequest(tLRPC$TL_account_deleteAccount, new RequestDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda11
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$7(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$7(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$6(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$6(TLRPC$TL_error tLRPC$TL_error) {
            LoginActivityAppp.this.needHideProgress(false);
            if (tLRPC$TL_error == null) {
                Bundle bundle = new Bundle();
                bundle.putString("phoneFormated", this.requestPhone);
                bundle.putString("phoneHash", this.phoneHash);
                bundle.putString("code", this.phoneCode);
                LoginActivityAppp.this.setPage(5, true, bundle, false);
                return;
            }
            if (tLRPC$TL_error.text.equals("2FA_RECENT_CONFIRM")) {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ResetAccountCancelledAlert", R.string.ResetAccountCancelledAlert));
                return;
            }
            if (!tLRPC$TL_error.text.startsWith("2FA_CONFIRM_WAIT_")) {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("phoneFormated", this.requestPhone);
            bundle2.putString("phoneHash", this.phoneHash);
            bundle2.putString("code", this.phoneCode);
            bundle2.putInt("startTime", ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).getCurrentTime());
            bundle2.putInt("waitTime", Utilities.parseInt(tLRPC$TL_error.text.replace("2FA_CONFIRM_WAIT_", BuildConfig.FLAVOR)).intValue());
            LoginActivityAppp.this.setPage(8, true, bundle2, false);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("LoginPassword", R.string.LoginPassword);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void setParams(Bundle bundle, boolean z) {
            if (bundle == null) {
                return;
            }
            if (bundle.isEmpty()) {
                AndroidUtilities.hideKeyboard(this.codeField);
                return;
            }
            this.resetAccountButton.setVisibility(8);
            this.resetAccountText.setVisibility(8);
            this.codeField.setText(BuildConfig.FLAVOR);
            this.currentParams = bundle;
            this.current_salt1 = Utilities.hexToBytes(bundle.getString("current_salt1"));
            this.current_salt2 = Utilities.hexToBytes(this.currentParams.getString("current_salt2"));
            Utilities.hexToBytes(this.currentParams.getString("current_p"));
            this.currentParams.getInt("current_g");
            Utilities.hexToBytes(this.currentParams.getString("current_srp_B"));
            this.currentParams.getLong("current_srp_id");
            this.passwordType = this.currentParams.getInt("passwordType");
            String string = this.currentParams.getString("hint");
            this.has_recovery = this.currentParams.getInt("has_recovery") == 1;
            this.requestPhone = bundle.getString("phoneFormated");
            this.phoneHash = bundle.getString("phoneHash");
            this.phoneCode = bundle.getString("code");
            this.noRecoveryAlert = bundle.getString("no_recovery_alert");
            if (string != null && string.length() > 0) {
                this.codeField.setHint(string);
            } else {
                this.codeField.setHint(LocaleController.getString("LoginPassword", R.string.LoginPassword));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onPasscodeError(boolean z) {
            if (LoginActivityAppp.this.getParentActivity() == null) {
                return;
            }
            if (z) {
                this.codeField.setText(BuildConfig.FLAVOR);
            }
            LoginActivityAppp.this.onFieldError(this.confirmTextView);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            final String string = this.codeField.getText().toString();
            this.passKey = string;
            if (string.length() == 0) {
                onPasscodeError(false);
                return;
            }
            this.nextPressed = true;
            LoginActivityAppp.this.needShowProgress(0);
            Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$10(string);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$10(String str) {
            Bundle bundle = new Bundle();
            bundle.putString("phone", this.requestPhone);
            try {
                bundle.putString("ephone", this.requestPhone);
            } catch (Exception e) {
                FileLog.e(e);
                bundle.putString("ephone", this.requestPhone);
            }
            bundle.putString("phoneFormated", this.requestPhone);
            bundle.putString("passKey", this.passKey);
            this.nextPressed = true;
            LoginActivityAppp.this.getAccountInstance().getCoreMainClass().sendCode(this.requestPhone, str, new AnonymousClass2(bundle));
        }

        /* renamed from: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$2, reason: invalid class name */
        class AnonymousClass2 implements LoadListener<SendCodeOutput> {
            final /* synthetic */ Bundle val$params;

            AnonymousClass2(Bundle bundle) {
                this.val$params = bundle;
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(final SendCodeOutput sendCodeOutput) {
                final Bundle bundle = this.val$params;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$2$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDidLoad$1(sendCodeOutput, bundle);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDidLoad$1(SendCodeOutput sendCodeOutput, Bundle bundle) {
                if (sendCodeOutput.status == SendCodeOutput.Status.OK) {
                    LoginActivityApppPasswordView.this.nextPressed = false;
                    TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode = new TLRPC$TL_auth_sentCode();
                    tLRPC$TL_auth_sentCode.next_type = new TLRPC$TL_auth_codeTypeSms();
                    TLRPC$TL_auth_sentCodeTypeSms tLRPC$TL_auth_sentCodeTypeSms = new TLRPC$TL_auth_sentCodeTypeSms();
                    tLRPC$TL_auth_sentCode.type = tLRPC$TL_auth_sentCodeTypeSms;
                    tLRPC$TL_auth_sentCodeTypeSms.length = sendCodeOutput.code_digits_count;
                    tLRPC$TL_auth_sentCode.phone_code_hash = sendCodeOutput.phone_code_hash;
                    LoginActivityAppp.this.fillNextCodeParams(bundle, tLRPC$TL_auth_sentCode);
                    LoginActivityAppp.this.needHideProgress(false);
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$2$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onDidLoad$0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDidLoad$0() {
                LoginActivityApppPasswordView.this.nextPressed = false;
                LoginActivityApppPasswordView.this.onPasscodeError(true);
                LoginActivityAppp.this.needHideProgress(false);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(final Exception exc) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$2$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onError$2(exc);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onError$2(Exception exc) {
                LoginActivityApppPasswordView.this.nextPressed = false;
                LoginActivityAppp.needShowInvalidAlert(LoginActivityAppp.this, exc instanceof LogInException ? ((LogInException) exc).errorMessage.name() : exc.getMessage(), false);
                LoginActivityAppp.this.needHideProgress(false);
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean onBackPressed(boolean z) {
            this.nextPressed = false;
            LoginActivityAppp.this.needHideProgress(true);
            this.currentParams = null;
            return true;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppPasswordView$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$11();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onShow$11() {
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            if (editTextBoldCursor != null) {
                editTextBoldCursor.requestFocus();
                EditTextBoldCursor editTextBoldCursor2 = this.codeField;
                editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
                AndroidUtilities.showKeyboard(this.codeField);
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
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

        @Override // org.rbmain.ui.Components.SlideView
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

    public class LoginActivityApppResetWaitView extends SlideView {
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

        @Override // org.rbmain.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        public LoginActivityApppResetWaitView(Context context) {
            super(context);
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            int i = Theme.key_windowBackgroundWhiteGrayText6;
            textView.setTextColor(Theme.getColor(i));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
            TextView textView2 = new TextView(context);
            this.resetAccountText = textView2;
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountText.setTextColor(Theme.getColor(i));
            this.resetAccountText.setText(LocaleController.getString("ResetAccountStatus", R.string.ResetAccountStatus));
            this.resetAccountText.setTextSize(1, 14.0f);
            this.resetAccountText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.resetAccountText, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 24, 0, 0));
            TextView textView3 = new TextView(context);
            this.resetAccountTime = textView3;
            textView3.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountTime.setTextColor(Theme.getColor(i));
            this.resetAccountTime.setTextSize(1, 14.0f);
            this.resetAccountTime.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.resetAccountTime, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 2, 0, 0));
            TextView textView4 = new TextView(context);
            this.resetAccountButton = textView4;
            textView4.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            this.resetAccountButton.setText(LocaleController.getString("ResetAccountButton", R.string.ResetAccountButton));
            this.resetAccountButton.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.resetAccountButton.setTextSize(1, 14.0f);
            this.resetAccountButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.resetAccountButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.resetAccountButton, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 7, 0, 0));
            this.resetAccountButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppResetWaitView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$3(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$3(View view) {
            if (LoginActivityAppp.this.doneProgressView.getTag() == null && Math.abs(ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).getCurrentTime() - this.startTime) >= this.waitTime) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
                builder.setMessage(LocaleController.getString("ResetMyAccountWarningText", R.string.ResetMyAccountWarningText));
                builder.setTitle(LocaleController.getString("ResetMyAccountWarning", R.string.ResetMyAccountWarning));
                builder.setPositiveButton(LocaleController.getString("ResetMyAccountWarningReset", R.string.ResetMyAccountWarningReset), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppResetWaitView$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$new$2(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                LoginActivityAppp.this.showDialog(builder.create());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(DialogInterface dialogInterface, int i) {
            LoginActivityAppp.this.needShowProgress(0);
            TLRPC$TL_account_deleteAccount tLRPC$TL_account_deleteAccount = new TLRPC$TL_account_deleteAccount();
            tLRPC$TL_account_deleteAccount.reason = "Forgot password";
            ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).sendRequest(tLRPC$TL_account_deleteAccount, new RequestDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppResetWaitView$$ExternalSyntheticLambda3
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$new$1(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppResetWaitView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0(tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(TLRPC$TL_error tLRPC$TL_error) {
            LoginActivityAppp.this.needHideProgress(false);
            if (tLRPC$TL_error == null) {
                Bundle bundle = new Bundle();
                bundle.putString("phoneFormated", this.requestPhone);
                bundle.putString("phoneHash", this.phoneHash);
                bundle.putString("code", this.phoneCode);
                LoginActivityAppp.this.setPage(5, true, bundle, false);
                return;
            }
            if (tLRPC$TL_error.text.equals("2FA_RECENT_CONFIRM")) {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("ResetAccountCancelledAlert", R.string.ResetAccountCancelledAlert));
            } else {
                LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("ResetAccount", R.string.ResetAccount);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateTimeText() {
            int iMax = Math.max(0, this.waitTime - (ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).getCurrentTime() - this.startTime));
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
                TextView textView = this.resetAccountButton;
                int i6 = Theme.key_windowBackgroundWhiteGrayText6;
                textView.setTag(Integer.valueOf(i6));
                this.resetAccountButton.setTextColor(Theme.getColor(i6));
                return;
            }
            TextView textView2 = this.resetAccountButton;
            int i7 = Theme.key_text_RedRegular;
            textView2.setTag(Integer.valueOf(i7));
            this.resetAccountButton.setTextColor(Theme.getColor(i7));
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void setParams(Bundle bundle, boolean z) {
            if (bundle == null) {
                return;
            }
            this.currentParams = bundle;
            this.requestPhone = bundle.getString("phoneFormated");
            this.phoneHash = bundle.getString("phoneHash");
            this.phoneCode = bundle.getString("code");
            this.startTime = bundle.getInt("startTime");
            this.waitTime = bundle.getInt("waitTime");
            this.confirmTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("ResetAccountInfo", R.string.ResetAccountInfo, LocaleController.addNbsp(PhoneFormat.getInstance().format("+" + this.requestPhone)))));
            updateTimeText();
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppResetWaitView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LoginActivityApppResetWaitView.this.timeRunnable != this) {
                        return;
                    }
                    LoginActivityApppResetWaitView.this.updateTimeText();
                    AndroidUtilities.runOnUIThread(LoginActivityApppResetWaitView.this.timeRunnable, 1000L);
                }
            };
            this.timeRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 1000L);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean onBackPressed(boolean z) {
            LoginActivityAppp.this.needHideProgress(true);
            AndroidUtilities.cancelRunOnUIThread(this.timeRunnable);
            this.timeRunnable = null;
            this.currentParams = null;
            return true;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            Bundle bundle2 = this.currentParams;
            if (bundle2 != null) {
                bundle.putBundle("resetview_params", bundle2);
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void restoreStateParams(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle("resetview_params");
            this.currentParams = bundle2;
            if (bundle2 != null) {
                setParams(bundle2, true);
            }
        }
    }

    public class LoginActivityApppRecoverView extends SlideView {
        private TextView cancelButton;
        private EditTextBoldCursor codeField;
        private TextView confirmTextView;
        private Bundle currentParams;
        private boolean nextPressed;

        @Override // org.rbmain.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        public LoginActivityApppRecoverView(Context context) {
            super(context);
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.confirmTextView.setText(LocaleController.getString("RestoreEmailSentInfo", R.string.RestoreEmailSentInfo));
            addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.codeField = editTextBoldCursor;
            int i = Theme.key_windowBackgroundWhiteBlackText;
            editTextBoldCursor.setTextColor(Theme.getColor(i));
            this.codeField.setCursorColor(Theme.getColor(i));
            this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.codeField.setCursorWidth(1.5f);
            this.codeField.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
            this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.codeField.setHint(LocaleController.getString("PasswordCode", R.string.PasswordCode));
            this.codeField.setImeOptions(268435461);
            this.codeField.setTextSize(1, 18.0f);
            this.codeField.setMaxLines(1);
            this.codeField.setPadding(0, 0, 0, 0);
            this.codeField.setInputType(3);
            this.codeField.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.codeField.setTypeface(Typeface.DEFAULT);
            this.codeField.setGravity(LocaleController.isRTL ? 5 : 3);
            addView(this.codeField, LayoutHelper.createLinear(-1, 36, 1, 0, 20, 0, 0));
            this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRecoverView$$ExternalSyntheticLambda3
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView2, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$0(textView2, i2, keyEvent);
                }
            });
            TextView textView2 = new TextView(context);
            this.cancelButton = textView2;
            textView2.setGravity((LocaleController.isRTL ? 5 : 3) | 80);
            this.cancelButton.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4));
            this.cancelButton.setTextSize(1, 14.0f);
            this.cancelButton.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.cancelButton.setPadding(0, AndroidUtilities.dp(14.0f), 0, 0);
            addView(this.cancelButton, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 80, 0, 0, 0, 14));
            this.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRecoverView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$2(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$0(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
            builder.setMessage(LocaleController.getString("RestoreEmailTroubleText", R.string.RestoreEmailTroubleText));
            builder.setTitle(LocaleController.getString("RestorePasswordNoEmailTitle", R.string.RestorePasswordNoEmailTitle));
            builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRecoverView$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$new$1(dialogInterface, i);
                }
            });
            Dialog dialogShowDialog = LoginActivityAppp.this.showDialog(builder.create());
            if (dialogShowDialog != null) {
                dialogShowDialog.setCanceledOnTouchOutside(false);
                dialogShowDialog.setCancelable(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(DialogInterface dialogInterface, int i) {
            LoginActivityAppp.this.setPage(0, true, null, true);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("LoginPassword", R.string.LoginPassword);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void setParams(Bundle bundle, boolean z) {
            if (bundle == null) {
                return;
            }
            this.codeField.setText(BuildConfig.FLAVOR);
            this.currentParams = bundle;
            this.cancelButton.setText(LocaleController.formatString("RestoreEmailTrouble", R.string.RestoreEmailTrouble, bundle.getString("email_unconfirmed_pattern")));
            AndroidUtilities.showKeyboard(this.codeField);
            this.codeField.requestFocus();
        }

        private void onPasscodeError(boolean z) {
            if (LoginActivityAppp.this.getParentActivity() == null) {
                return;
            }
            Vibrator vibrator = (Vibrator) LoginActivityAppp.this.getParentActivity().getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            if (z) {
                this.codeField.setText(BuildConfig.FLAVOR);
            }
            AndroidUtilities.shakeView(this.confirmTextView, 2.0f, 0);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            if (this.codeField.getText().toString().length() == 0) {
                onPasscodeError(false);
                return;
            }
            this.nextPressed = true;
            String string = this.codeField.getText().toString();
            if (string.length() != 0) {
                LoginActivityAppp.this.needShowProgress(0);
                TLRPC$TL_auth_recoverPassword tLRPC$TL_auth_recoverPassword = new TLRPC$TL_auth_recoverPassword();
                tLRPC$TL_auth_recoverPassword.code = string;
                tLRPC$TL_auth_recoverPassword.phoneNumber = this.currentParams.getString("requestPhone");
                tLRPC$TL_auth_recoverPassword.hashCode = this.currentParams.getString("forget_password_code_hash");
                ContactsProxy.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).requestDisableTwoStep(tLRPC$TL_auth_recoverPassword, new RequestDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRecoverView$$ExternalSyntheticLambda6
                    @Override // org.rbmain.tgnet.RequestDelegate
                    public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                        this.f$0.lambda$onNextPressed$5(tLObject, tLRPC$TL_error);
                    }
                });
                return;
            }
            onPasscodeError(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$5(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRecoverView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$4(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$4(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            LoginActivityAppp.this.needHideProgress(false);
            this.nextPressed = false;
            if (tLObject instanceof TLRPC$TL_auth_authorization) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRecoverView$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onNextPressed$3(dialogInterface, i);
                    }
                });
                builder.setMessage(LocaleController.getString("PasswordReset", R.string.PasswordReset));
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                Dialog dialogShowDialog = LoginActivityAppp.this.showDialog(builder.create());
                if (dialogShowDialog != null) {
                    dialogShowDialog.setCanceledOnTouchOutside(false);
                    dialogShowDialog.setCancelable(false);
                    return;
                }
                return;
            }
            if (tLRPC$TL_error.text.startsWith("CODE_INVALID")) {
                onPasscodeError(true);
            }
            LoginActivityAppp.needShowInvalidAlert(LoginActivityAppp.this, tLRPC$TL_error.text, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$3(DialogInterface dialogInterface, int i) {
            LoginActivityAppp.this.setPage(0, true, null, true);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean onBackPressed(boolean z) {
            LoginActivityAppp.this.needHideProgress(true);
            this.currentParams = null;
            this.nextPressed = false;
            return true;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRecoverView$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$6();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onShow$6() {
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            if (editTextBoldCursor != null) {
                editTextBoldCursor.requestFocus();
                EditTextBoldCursor editTextBoldCursor2 = this.codeField;
                editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
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

        @Override // org.rbmain.ui.Components.SlideView
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

    public class LoginActivityApppRegisterView extends SlideView implements ImageUpdater.ImageUpdaterDelegate {
        private TLRPC$FileLocation avatar;
        private AnimatorSet avatarAnimation;
        private TLRPC$FileLocation avatarBig;
        private AvatarDrawable avatarDrawable;
        private RLottieImageView avatarEditor;
        private BackupImageView avatarImage;
        private View avatarOverlay;
        private RadialProgressView avatarProgressView;
        private RLottieDrawable cameraDrawable;
        private Bundle currentParams;
        private EditTextBoldCursor firstNameField;
        private ImageUpdater imageUpdater;
        private EditTextBoldCursor lastNameField;
        private boolean nextPressed;
        private String phoneHash;
        private TextView privacyView;
        private String requestPhone;
        private TextView textView;
        private TextView wrongNumber;

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* synthetic */ void didStartUpload(boolean z) {
            ImageUpdater.ImageUpdaterDelegate.CC.$default$didStartUpload(this, z);
        }

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* bridge */ /* synthetic */ String getInitialSearchString() {
            return ImageUpdater.ImageUpdaterDelegate.CC.$default$getInitialSearchString(this);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public /* synthetic */ void onUploadProgressChanged(float f) {
            ImageUpdater.ImageUpdaterDelegate.CC.$default$onUploadProgressChanged(this, f);
        }

        public class LinkSpan extends ClickableSpan {
            public LinkSpan() {
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setUnderlineText(false);
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                LoginActivityApppRegisterView.this.showTermsOfService(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showTermsOfService(boolean z) {
            if (LoginActivityAppp.this.currentTermsOfService == null) {
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
            builder.setTitle(LocaleController.getString("TermsOfService", R.string.TermsOfService));
            if (z) {
                builder.setPositiveButton(LocaleController.getString("Accept", R.string.Accept), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showTermsOfService$0(dialogInterface, i);
                    }
                });
                builder.setNegativeButton(LocaleController.getString("Decline", R.string.Decline), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$showTermsOfService$3(dialogInterface, i);
                    }
                });
            } else {
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(LoginActivityAppp.this.currentTermsOfService.text);
            MessageObject.addEntitiesToText(spannableStringBuilder, LoginActivityAppp.this.currentTermsOfService.entities, false, false, false, false);
            builder.setMessage(spannableStringBuilder);
            LoginActivityAppp.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showTermsOfService$0(DialogInterface dialogInterface, int i) {
            LoginActivityAppp.this.currentTermsOfService.popup = false;
            onNextPressed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showTermsOfService$3(DialogInterface dialogInterface, int i) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
            builder.setTitle(LocaleController.getString("TermsOfService", R.string.TermsOfService));
            builder.setMessage(LocaleController.getString("TosDecline", R.string.TosDecline));
            builder.setPositiveButton(LocaleController.getString("SignUp", R.string.SignUp), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.f$0.lambda$showTermsOfService$1(dialogInterface2, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Decline", R.string.Decline), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface2, int i2) {
                    this.f$0.lambda$showTermsOfService$2(dialogInterface2, i2);
                }
            });
            LoginActivityAppp.this.showDialog(builder.create());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showTermsOfService$1(DialogInterface dialogInterface, int i) {
            LoginActivityAppp.this.currentTermsOfService.popup = false;
            onNextPressed();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$showTermsOfService$2(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            LoginActivityAppp.this.setPage(0, true, null, true);
        }

        public LoginActivityApppRegisterView(Context context) {
            super(context);
            this.nextPressed = false;
            setOrientation(1);
            ImageUpdater imageUpdater = new ImageUpdater(false);
            this.imageUpdater = imageUpdater;
            imageUpdater.setOpenWithFrontfaceCamera(true);
            this.imageUpdater.setSearchAvailable(false);
            this.imageUpdater.setUploadAfterSelect(false);
            ImageUpdater imageUpdater2 = this.imageUpdater;
            imageUpdater2.parentFragment = LoginActivityAppp.this;
            imageUpdater2.setDelegate(this);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setText(LocaleController.getString("RegisterText2", R.string.RegisterText2));
            TextView textView2 = this.textView;
            int i = Theme.key_windowBackgroundWhiteGrayText6;
            textView2.setTextColor(Theme.getColor(i));
            this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.textView.setTextSize(1, 14.0f);
            addView(this.textView, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 0, 0, 0, 0));
            FrameLayout frameLayout = new FrameLayout(context);
            addView(frameLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 21.0f, 0.0f, 0.0f));
            this.avatarDrawable = new AvatarDrawable();
            BackupImageView backupImageView = new BackupImageView(context, LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppRegisterView.1
                @Override // android.view.View
                public void invalidate() {
                    if (LoginActivityApppRegisterView.this.avatarOverlay != null) {
                        LoginActivityApppRegisterView.this.avatarOverlay.invalidate();
                    }
                    super.invalidate();
                }

                @Override // android.view.View
                public void invalidate(int i2, int i3, int i4, int i5) {
                    if (LoginActivityApppRegisterView.this.avatarOverlay != null) {
                        LoginActivityApppRegisterView.this.avatarOverlay.invalidate();
                    }
                    super.invalidate(i2, i3, i4, i5);
                }
            };
            this.avatarImage = backupImageView;
            backupImageView.setRoundRadius(AndroidUtilities.dp(32.0f));
            this.avatarDrawable.setInfo(5L, null, null);
            this.avatarImage.setImageDrawable(this.avatarDrawable);
            frameLayout.addView(this.avatarImage, LayoutHelper.createFrame(64, 64.0f, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 16.0f, 0.0f, 0.0f));
            Paint paint = new Paint(1);
            paint.setColor(1426063360);
            View view = new View(context, LoginActivityAppp.this, paint) { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppRegisterView.2
                final /* synthetic */ Paint val$paint;

                {
                    this.val$paint = paint;
                }

                @Override // android.view.View
                protected void onDraw(Canvas canvas) {
                    if (LoginActivityApppRegisterView.this.avatarImage == null || LoginActivityApppRegisterView.this.avatarProgressView.getVisibility() != 0) {
                        return;
                    }
                    this.val$paint.setAlpha((int) (LoginActivityApppRegisterView.this.avatarImage.getImageReceiver().getCurrentAlpha() * 85.0f * LoginActivityApppRegisterView.this.avatarProgressView.getAlpha()));
                    canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, getMeasuredWidth() / 2.0f, this.val$paint);
                }
            };
            this.avatarOverlay = view;
            frameLayout.addView(view, LayoutHelper.createFrame(64, 64.0f, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 16.0f, 0.0f, 0.0f));
            this.avatarOverlay.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$6(view2);
                }
            });
            this.cameraDrawable = new RLottieDrawable(R.raw.camera, "2131820554", AndroidUtilities.dp(60.0f), AndroidUtilities.dp(60.0f), false, null);
            RLottieImageView rLottieImageView = new RLottieImageView(context, LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppRegisterView.3
                @Override // android.view.View
                public void invalidate(int i2, int i3, int i4, int i5) {
                    super.invalidate(i2, i3, i4, i5);
                    LoginActivityApppRegisterView.this.avatarOverlay.invalidate();
                }

                @Override // android.view.View
                public void invalidate() {
                    super.invalidate();
                    LoginActivityApppRegisterView.this.avatarOverlay.invalidate();
                }
            };
            this.avatarEditor = rLottieImageView;
            rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.avatarEditor.setAnimation(this.cameraDrawable);
            this.avatarEditor.setEnabled(false);
            this.avatarEditor.setClickable(false);
            this.avatarEditor.setPadding(AndroidUtilities.dp(2.0f), 0, 0, AndroidUtilities.dp(1.0f));
            frameLayout.addView(this.avatarEditor, LayoutHelper.createFrame(64, 64.0f, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 16.0f, 0.0f, 0.0f));
            RadialProgressView radialProgressView = new RadialProgressView(context, LoginActivityAppp.this) { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppRegisterView.4
                @Override // org.rbmain.ui.Components.RadialProgressView, android.view.View
                public void setAlpha(float f) {
                    super.setAlpha(f);
                    LoginActivityApppRegisterView.this.avatarOverlay.invalidate();
                }
            };
            this.avatarProgressView = radialProgressView;
            radialProgressView.setSize(AndroidUtilities.dp(30.0f));
            this.avatarProgressView.setProgressColor(-1);
            frameLayout.addView(this.avatarProgressView, LayoutHelper.createFrame(64, 64.0f, (LocaleController.isRTL ? 5 : 3) | 48, 0.0f, 16.0f, 0.0f, 0.0f));
            showAvatarProgress(false, false);
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.firstNameField = editTextBoldCursor;
            int i2 = Theme.key_windowBackgroundWhiteHintText;
            editTextBoldCursor.setHintTextColor(Theme.getColor(i2));
            EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
            int i3 = Theme.key_windowBackgroundWhiteBlackText;
            editTextBoldCursor2.setTextColor(Theme.getColor(i3));
            this.firstNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.firstNameField.setCursorColor(Theme.getColor(i3));
            this.firstNameField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.firstNameField.setCursorWidth(1.5f);
            this.firstNameField.setHint(LocaleController.getString("FirstName", R.string.FirstName));
            this.firstNameField.setImeOptions(268435461);
            this.firstNameField.setTextSize(1, 17.0f);
            this.firstNameField.setMaxLines(1);
            this.firstNameField.setInputType(8192);
            EditTextBoldCursor editTextBoldCursor3 = this.firstNameField;
            boolean z = LocaleController.isRTL;
            frameLayout.addView(editTextBoldCursor3, LayoutHelper.createFrame(-1, 36.0f, (z ? 5 : 3) | 48, z ? 0.0f : 85.0f, 0.0f, z ? 85.0f : 0.0f, 0.0f));
            this.firstNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda9
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i4, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$7(textView3, i4, keyEvent);
                }
            });
            EditTextBoldCursor editTextBoldCursor4 = new EditTextBoldCursor(context);
            this.lastNameField = editTextBoldCursor4;
            editTextBoldCursor4.setHint(LocaleController.getString("LastName", R.string.LastName));
            this.lastNameField.setHintTextColor(Theme.getColor(i2));
            this.lastNameField.setTextColor(Theme.getColor(i3));
            this.lastNameField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.lastNameField.setCursorColor(Theme.getColor(i3));
            this.lastNameField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.lastNameField.setCursorWidth(1.5f);
            this.lastNameField.setImeOptions(268435462);
            this.lastNameField.setTextSize(1, 17.0f);
            this.lastNameField.setMaxLines(1);
            this.lastNameField.setInputType(8192);
            EditTextBoldCursor editTextBoldCursor5 = this.lastNameField;
            boolean z2 = LocaleController.isRTL;
            frameLayout.addView(editTextBoldCursor5, LayoutHelper.createFrame(-1, 36.0f, (z2 ? 5 : 3) | 48, z2 ? 0.0f : 85.0f, 51.0f, z2 ? 85.0f : 0.0f, 0.0f));
            this.lastNameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda8
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView3, int i4, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$8(textView3, i4, keyEvent);
                }
            });
            TextView textView3 = new TextView(context);
            this.wrongNumber = textView3;
            textView3.setText(LocaleController.getString("CancelRegistration", R.string.CancelRegistration));
            this.wrongNumber.setGravity((LocaleController.isRTL ? 5 : 3) | 1);
            this.wrongNumber.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4));
            this.wrongNumber.setTextSize(1, 14.0f);
            this.wrongNumber.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.wrongNumber.setPadding(0, AndroidUtilities.dp(24.0f), 0, 0);
            this.wrongNumber.setVisibility(8);
            addView(this.wrongNumber, LayoutHelper.createLinear(-2, -2, (LocaleController.isRTL ? 5 : 3) | 48, 0, 20, 0, 0));
            this.wrongNumber.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$new$9(view2);
                }
            });
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setClipToPadding(false);
            frameLayout2.setPadding(0, AndroidUtilities.dp(28.0f), AndroidUtilities.dp(100.0f), AndroidUtilities.dp(16.0f));
            addView(frameLayout2, LayoutHelper.createLinear(-1, -1, 83));
            TextView textView4 = new TextView(context);
            this.privacyView = textView4;
            textView4.setTextColor(Theme.getColor(i));
            this.privacyView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
            this.privacyView.setLinkTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkText));
            this.privacyView.setTextSize(1, 14.0f);
            this.privacyView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            VerticalPositionAutoAnimator.attach(this.privacyView);
            frameLayout2.addView(this.privacyView, LayoutHelper.createFrame(-2, -2, 83));
            String string = LocaleController.getString("TermsOfServiceLogin", R.string.TermsOfServiceLogin);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            int iIndexOf = string.indexOf(42);
            int iLastIndexOf = string.lastIndexOf(42);
            if (iIndexOf != -1 && iLastIndexOf != -1 && iIndexOf != iLastIndexOf) {
                spannableStringBuilder.replace(iLastIndexOf, iLastIndexOf + 1, (CharSequence) BuildConfig.FLAVOR);
                spannableStringBuilder.replace(iIndexOf, iIndexOf + 1, (CharSequence) BuildConfig.FLAVOR);
                spannableStringBuilder.setSpan(new LinkSpan(), iIndexOf, iLastIndexOf - 1, 33);
            }
            this.privacyView.setText(spannableStringBuilder);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$6(View view) {
            this.imageUpdater.openMenu(this.avatar != null, new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$4();
                }
            }, new DialogInterface.OnDismissListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda5
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    this.f$0.lambda$new$5(dialogInterface);
                }
            });
            this.cameraDrawable.setCurrentFrame(0);
            this.cameraDrawable.setCustomEndFrame(43);
            this.avatarEditor.playAnimation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$4() {
            this.avatar = null;
            this.avatarBig = null;
            showAvatarProgress(false, true);
            this.avatarImage.setImage((ImageLocation) null, (String) null, this.avatarDrawable, (Object) null);
            this.avatarEditor.setImageResource(R.drawable.actions_setphoto);
            this.avatarEditor.setAnimation(this.cameraDrawable);
            this.cameraDrawable.setCurrentFrame(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$5(DialogInterface dialogInterface) {
            this.cameraDrawable.setCustomEndFrame(86);
            this.avatarEditor.playAnimation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$7(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            this.lastNameField.requestFocus();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$8(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$9(View view) {
            if (LoginActivityAppp.this.doneProgressView.getTag() != null) {
                return;
            }
            onBackPressed(false);
        }

        @Override // org.rbmain.ui.Components.ImageUpdater.ImageUpdaterDelegate
        public void didUploadPhoto(TLRPC$InputFile tLRPC$InputFile, TLRPC$InputFile tLRPC$InputFile2, TLRPC$InputFile tLRPC$InputFile3, double d, String str, final TLRPC$PhotoSize tLRPC$PhotoSize, final TLRPC$PhotoSize tLRPC$PhotoSize2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$didUploadPhoto$10(tLRPC$PhotoSize2, tLRPC$PhotoSize);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$didUploadPhoto$10(TLRPC$PhotoSize tLRPC$PhotoSize, TLRPC$PhotoSize tLRPC$PhotoSize2) {
            TLRPC$FileLocation tLRPC$FileLocation = tLRPC$PhotoSize.location;
            this.avatar = tLRPC$FileLocation;
            this.avatarBig = tLRPC$PhotoSize2.location;
            this.avatarImage.setImage(ImageLocation.getForLocal(tLRPC$FileLocation), "50_50", this.avatarDrawable, (Object) null);
        }

        private void showAvatarProgress(final boolean z, boolean z2) {
            if (this.avatarEditor == null) {
                return;
            }
            AnimatorSet animatorSet = this.avatarAnimation;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.avatarAnimation = null;
            }
            if (z2) {
                this.avatarAnimation = new AnimatorSet();
                if (z) {
                    this.avatarProgressView.setVisibility(0);
                    this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarEditor, (Property<RLottieImageView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 1.0f));
                } else {
                    this.avatarEditor.setVisibility(0);
                    this.avatarAnimation.playTogether(ObjectAnimator.ofFloat(this.avatarEditor, (Property<RLottieImageView, Float>) View.ALPHA, 1.0f), ObjectAnimator.ofFloat(this.avatarProgressView, (Property<RadialProgressView, Float>) View.ALPHA, 0.0f));
                }
                this.avatarAnimation.setDuration(180L);
                this.avatarAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.LoginActivityAppp.LoginActivityApppRegisterView.5
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (LoginActivityApppRegisterView.this.avatarAnimation == null || LoginActivityApppRegisterView.this.avatarEditor == null) {
                            return;
                        }
                        if (z) {
                            LoginActivityApppRegisterView.this.avatarEditor.setVisibility(4);
                        } else {
                            LoginActivityApppRegisterView.this.avatarProgressView.setVisibility(4);
                        }
                        LoginActivityApppRegisterView.this.avatarAnimation = null;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        LoginActivityApppRegisterView.this.avatarAnimation = null;
                    }
                });
                this.avatarAnimation.start();
                return;
            }
            if (z) {
                this.avatarEditor.setAlpha(1.0f);
                this.avatarEditor.setVisibility(4);
                this.avatarProgressView.setAlpha(1.0f);
                this.avatarProgressView.setVisibility(0);
                return;
            }
            this.avatarEditor.setAlpha(1.0f);
            this.avatarEditor.setVisibility(0);
            this.avatarProgressView.setAlpha(0.0f);
            this.avatarProgressView.setVisibility(4);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean onBackPressed(boolean z) {
            if (z) {
                LoginActivityAppp.this.needHideProgress(true);
                this.nextPressed = false;
                this.currentParams = null;
                return true;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivityAppp.this.getParentActivity());
            builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
            builder.setMessage(LocaleController.getString("AreYouSureRegistration", R.string.AreYouSureRegistration));
            builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onBackPressed$11(dialogInterface, i);
                }
            });
            builder.setPositiveButton(LocaleController.getString("Continue", R.string.Continue), null);
            LoginActivityAppp.this.showDialog(builder.create());
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBackPressed$11(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            LoginActivityAppp.this.setPage(0, true, null, true);
            hidePrivacyView();
        }

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("YourName", R.string.YourName);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            if (this.privacyView != null) {
                if (LoginActivityAppp.this.restoringState) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$12();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onShow$12() {
            EditTextBoldCursor editTextBoldCursor = this.firstNameField;
            if (editTextBoldCursor != null) {
                editTextBoldCursor.requestFocus();
                EditTextBoldCursor editTextBoldCursor2 = this.firstNameField;
                editTextBoldCursor2.setSelection(editTextBoldCursor2.length());
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void setParams(Bundle bundle, boolean z) {
            if (bundle == null) {
                return;
            }
            this.firstNameField.setText(BuildConfig.FLAVOR);
            this.lastNameField.setText(BuildConfig.FLAVOR);
            this.requestPhone = bundle.getString("phoneFormated");
            this.phoneHash = bundle.getString("phoneHash");
            this.currentParams = bundle;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            if (LoginActivityAppp.this.currentTermsOfService != null && LoginActivityAppp.this.currentTermsOfService.popup) {
                showTermsOfService(true);
                return;
            }
            if (this.firstNameField.length() == 0) {
                LoginActivityAppp.this.onFieldError(this.firstNameField);
                return;
            }
            this.nextPressed = true;
            TLRPC$TL_auth_signUp tLRPC$TL_auth_signUp = new TLRPC$TL_auth_signUp();
            tLRPC$TL_auth_signUp.phone_code_hash = this.phoneHash;
            tLRPC$TL_auth_signUp.phone_number = this.requestPhone;
            tLRPC$TL_auth_signUp.first_name = this.firstNameField.getText().toString();
            tLRPC$TL_auth_signUp.last_name = this.lastNameField.getText().toString();
            LoginActivityAppp.this.needShowProgress(0);
            ConnectionsManager.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).sendRequest(tLRPC$TL_auth_signUp, new RequestDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda15
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$15(tLObject, tLRPC$TL_error);
                }
            }, 10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$15(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$14(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$14(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            this.nextPressed = false;
            if (!(tLObject instanceof TLRPC$TL_auth_authorization)) {
                LoginActivityAppp.this.needHideProgress(false);
                if (tLRPC$TL_error.text.contains("PHONE_NUMBER_INVALID")) {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                    return;
                }
                if (tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") || tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidCode", R.string.InvalidCode));
                    return;
                }
                if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("CodeExpired", R.string.CodeExpired));
                    return;
                }
                if (tLRPC$TL_error.text.contains("FIRSTNAME_INVALID")) {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidFirstName", R.string.InvalidFirstName));
                    return;
                } else if (tLRPC$TL_error.text.contains("LASTNAME_INVALID")) {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("InvalidLastName", R.string.InvalidLastName));
                    return;
                } else {
                    LoginActivityAppp.this.needShowAlert(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
                    return;
                }
            }
            hidePrivacyView();
            LoginActivityAppp.this.showDoneButton(false, true);
            postDelayed(new Runnable() { // from class: org.rbmain.ui.LoginActivityAppp$LoginActivityApppRegisterView$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$13(tLObject);
                }
            }, 150L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$13(TLObject tLObject) {
            LoginActivityAppp.this.needHideProgress(false, false);
            AndroidUtilities.hideKeyboard(LoginActivityAppp.this.fragmentView.findFocus());
            LoginActivityAppp.this.onAuthSuccess((TLRPC$TL_auth_authorization) tLObject, true);
            if (this.avatarBig != null) {
                MessagesController.getInstance(((BaseFragment) LoginActivityAppp.this).currentAccount).uploadAndApplyUserAvatar(this.avatarBig);
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void saveStateParams(Bundle bundle) {
            String string = this.firstNameField.getText().toString();
            if (string.length() != 0) {
                bundle.putString("registerview_first", string);
            }
            String string2 = this.lastNameField.getText().toString();
            if (string2.length() != 0) {
                bundle.putString("registerview_last", string2);
            }
            if (LoginActivityAppp.this.currentTermsOfService != null) {
                SerializedData serializedData = new SerializedData(LoginActivityAppp.this.currentTermsOfService.getObjectSize());
                LoginActivityAppp.this.currentTermsOfService.serializeToStream(serializedData);
                bundle.putString("terms", Base64.encodeToString(serializedData.toByteArray(), 0));
                serializedData.cleanup();
            }
            Bundle bundle2 = this.currentParams;
            if (bundle2 != null) {
                bundle.putBundle("registerview_params", bundle2);
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
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
                    LoginActivityAppp.this.currentTermsOfService = TLRPC$TL_help_termsOfService.TLdeserialize(serializedData, serializedData.readInt32(false), false);
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

    @Override // org.rbmain.ui.ActionBar.BaseFragment
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
                LoginActivityApppSmsView loginActivityApppSmsView = (LoginActivityApppSmsView) slideViewArr[1];
                LoginActivityApppSmsView loginActivityApppSmsView2 = (LoginActivityApppSmsView) slideViewArr[2];
                LoginActivityApppSmsView loginActivityApppSmsView3 = (LoginActivityApppSmsView) slideViewArr[3];
                LoginActivityApppSmsView loginActivityApppSmsView4 = (LoginActivityApppSmsView) slideViewArr[4];
                LoginActivityApppRegisterView loginActivityApppRegisterView = (LoginActivityApppRegisterView) slideViewArr[5];
                LoginActivityApppPasswordView loginActivityApppPasswordView = (LoginActivityApppPasswordView) slideViewArr[6];
                LoginActivityApppRecoverView loginActivityApppRecoverView = (LoginActivityApppRecoverView) slideViewArr[7];
                LoginActivityApppResetWaitView loginActivityApppResetWaitView = (LoginActivityApppResetWaitView) slideViewArr[8];
                ArrayList<ThemeDescription> arrayList = new ArrayList<>();
                ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.LoginActivityAppp$$ExternalSyntheticLambda4
                    @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
                    public final void didSetColor() {
                        this.f$0.lambda$getThemeDescriptions$4();
                    }
                };
                arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
                ImageView imageView = this.floatingButtonIcon;
                int i2 = ThemeDescription.FLAG_IMAGECOLOR;
                int i3 = Theme.key_chats_actionIcon;
                arrayList.add(new ThemeDescription(imageView, i2, null, null, null, null, i3));
                arrayList.add(new ThemeDescription(this.floatingButtonIcon, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_chats_actionBackground));
                arrayList.add(new ThemeDescription(this.floatingButtonIcon, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_chats_actionPressedBackground));
                arrayList.add(new ThemeDescription(this.floatingProgressView, ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, i3));
                ActionBar actionBar = this.actionBar;
                int i4 = ThemeDescription.FLAG_BACKGROUND;
                int i5 = Theme.key_actionBarDefault;
                arrayList.add(new ThemeDescription(actionBar, i4, null, null, null, null, i5));
                arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i5));
                arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
                arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
                arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
                TextView textView = phoneView.countryButton;
                int i6 = ThemeDescription.FLAG_TEXTCOLOR;
                int i7 = Theme.key_windowBackgroundWhiteBlackText;
                arrayList.add(new ThemeDescription(textView, i6, null, null, null, null, i7));
                arrayList.add(new ThemeDescription(phoneView.countryButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_listSelector));
                arrayList.add(new ThemeDescription(phoneView.view, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhiteGrayLine));
                arrayList.add(new ThemeDescription(phoneView.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                arrayList.add(new ThemeDescription(phoneView.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                EditTextBoldCursor editTextBoldCursor = phoneView.codeField;
                int i8 = ThemeDescription.FLAG_BACKGROUNDFILTER;
                int i9 = Theme.key_windowBackgroundWhiteInputField;
                arrayList.add(new ThemeDescription(editTextBoldCursor, i8, null, null, null, null, i9));
                EditTextBoldCursor editTextBoldCursor2 = phoneView.codeField;
                int i10 = ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE;
                int i11 = Theme.key_windowBackgroundWhiteInputFieldActivated;
                arrayList.add(new ThemeDescription(editTextBoldCursor2, i10, null, null, null, null, i11));
                arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                HintEditText hintEditText = phoneView.phoneField;
                int i12 = ThemeDescription.FLAG_HINTTEXTCOLOR;
                int i13 = Theme.key_windowBackgroundWhiteHintText;
                arrayList.add(new ThemeDescription(hintEditText, i12, null, null, null, null, i13));
                arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i9));
                arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i11));
                TextView textView2 = phoneView.textView2;
                int i14 = ThemeDescription.FLAG_TEXTCOLOR;
                int i15 = Theme.key_windowBackgroundWhiteGrayText6;
                arrayList.add(new ThemeDescription(textView2, i14, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppPasswordView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppPasswordView.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                arrayList.add(new ThemeDescription(loginActivityApppPasswordView.codeField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i13));
                arrayList.add(new ThemeDescription(loginActivityApppPasswordView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i9));
                arrayList.add(new ThemeDescription(loginActivityApppPasswordView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i11));
                TextView textView3 = loginActivityApppPasswordView.cancelButton;
                int i16 = ThemeDescription.FLAG_TEXTCOLOR;
                int i17 = Theme.key_windowBackgroundWhiteBlueText4;
                arrayList.add(new ThemeDescription(textView3, i16, null, null, null, null, i17));
                TextView textView4 = loginActivityApppPasswordView.resetAccountButton;
                int i18 = ThemeDescription.FLAG_TEXTCOLOR;
                int i19 = Theme.key_text_RedRegular;
                arrayList.add(new ThemeDescription(textView4, i18, null, null, null, null, i19));
                arrayList.add(new ThemeDescription(loginActivityApppPasswordView.resetAccountText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.firstNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i13));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.firstNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i9));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.firstNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i11));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.lastNameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i13));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.lastNameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i9));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.lastNameField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i11));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.wrongNumber, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i17));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.privacyView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppRegisterView.privacyView, ThemeDescription.FLAG_LINKCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteLinkText));
                arrayList.add(new ThemeDescription(loginActivityApppRecoverView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppRecoverView.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                arrayList.add(new ThemeDescription(loginActivityApppRecoverView.codeField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, i13));
                arrayList.add(new ThemeDescription(loginActivityApppRecoverView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i9));
                arrayList.add(new ThemeDescription(loginActivityApppRecoverView.codeField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i11));
                arrayList.add(new ThemeDescription(loginActivityApppRecoverView.cancelButton, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i17));
                arrayList.add(new ThemeDescription(loginActivityApppResetWaitView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppResetWaitView.resetAccountText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppResetWaitView.resetAccountTime, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppResetWaitView.resetAccountButton, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppResetWaitView.resetAccountButton, ThemeDescription.FLAG_TEXTCOLOR | ThemeDescription.FLAG_CHECKTAG, null, null, null, null, i19));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i7));
                if (loginActivityApppSmsView.codeField != null) {
                    for (int i20 = 0; i20 < loginActivityApppSmsView.codeField.length; i20++) {
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView.codeField[i20], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView.codeField[i20], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
                    }
                }
                TextView textView5 = loginActivityApppSmsView.timeText;
                int i21 = ThemeDescription.FLAG_TEXTCOLOR;
                int i22 = Theme.key_windowBackgroundWhiteGrayText6;
                arrayList.add(new ThemeDescription(textView5, i21, null, null, null, null, i22));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
                ImageView imageView2 = loginActivityApppSmsView.blackImageView;
                int i23 = ThemeDescription.FLAG_IMAGECOLOR;
                int i24 = Theme.key_windowBackgroundWhiteBlackText;
                arrayList.add(new ThemeDescription(imageView2, i23, null, null, null, null, i24));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionBackground));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView2.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i22));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView2.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i24));
                if (loginActivityApppSmsView2.codeField != null) {
                    for (int i25 = 0; i25 < loginActivityApppSmsView2.codeField.length; i25++) {
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView2.codeField[i25], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView2.codeField[i25], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
                    }
                }
                TextView textView6 = loginActivityApppSmsView2.timeText;
                int i26 = ThemeDescription.FLAG_TEXTCOLOR;
                int i27 = Theme.key_windowBackgroundWhiteGrayText6;
                arrayList.add(new ThemeDescription(textView6, i26, null, null, null, null, i27));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView2.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView2.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView2.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
                ImageView imageView3 = loginActivityApppSmsView2.blackImageView;
                int i28 = ThemeDescription.FLAG_IMAGECOLOR;
                int i29 = Theme.key_windowBackgroundWhiteBlackText;
                arrayList.add(new ThemeDescription(imageView3, i28, null, null, null, null, i29));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView2.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionBackground));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView3.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i27));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView3.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i29));
                if (loginActivityApppSmsView3.codeField != null) {
                    for (int i30 = 0; i30 < loginActivityApppSmsView3.codeField.length; i30++) {
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView3.codeField[i30], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView3.codeField[i30], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
                    }
                }
                TextView textView7 = loginActivityApppSmsView3.timeText;
                int i31 = ThemeDescription.FLAG_TEXTCOLOR;
                int i32 = Theme.key_windowBackgroundWhiteGrayText6;
                arrayList.add(new ThemeDescription(textView7, i31, null, null, null, null, i32));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView3.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView3.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView3.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
                ImageView imageView4 = loginActivityApppSmsView3.blackImageView;
                int i33 = ThemeDescription.FLAG_IMAGECOLOR;
                int i34 = Theme.key_windowBackgroundWhiteBlackText;
                arrayList.add(new ThemeDescription(imageView4, i33, null, null, null, null, i34));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView3.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionBackground));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i32));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i34));
                if (loginActivityApppSmsView4.codeField != null) {
                    for (int i35 = 0; i35 < loginActivityApppSmsView4.codeField.length; i35++) {
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView4.codeField[i35], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                        arrayList.add(new ThemeDescription(loginActivityApppSmsView4.codeField[i35], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
                    }
                }
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.timeText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText6));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.blackImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                RLottieImageView rLottieImageView = loginActivityApppSmsView4.blueImageView;
                int i36 = ThemeDescription.FLAG_IMAGECOLOR;
                int i37 = Theme.key_chats_actionBackground;
                arrayList.add(new ThemeDescription(rLottieImageView, i36, null, null, null, null, i37));
                arrayList.add(new ThemeDescription(loginActivityApppSmsView4.blueImageView, 0, null, null, null, themeDescriptionDelegate, i37));
                return arrayList;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$4() {
        LoginActivityApppSmsView loginActivityApppSmsView;
        RLottieDrawable rLottieDrawable;
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                return;
            }
            if ((slideViewArr[i] instanceof LoginActivityApppSmsView) && (rLottieDrawable = (loginActivityApppSmsView = (LoginActivityApppSmsView) slideViewArr[i]).hintDrawable) != null) {
                int i2 = Theme.key_chats_actionBackground;
                rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor(i2));
                loginActivityApppSmsView.hintDrawable.setLayerColor("Phone.**", Theme.getColor(i2));
            }
            i++;
        }
    }
}
