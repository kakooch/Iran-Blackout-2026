package ir.eitaa.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.util.Property;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.browser.Browser;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Document;
import ir.eitaa.tgnet.TLRPC$TL_document;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_help_appUpdate;
import ir.eitaa.tgnet.TLRPC$TL_help_getAppUpdate;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.voip.CellFlickerDrawable;
import java.io.File;
import java.util.Locale;

/* loaded from: classes3.dex */
public class BlockingUpdateView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private FrameLayout acceptButton;
    private TextView acceptTextView;
    private int accountNum;
    private TLRPC$TL_help_appUpdate appUpdate;
    private String fileName;
    Drawable gradientDrawableBottom;
    Drawable gradientDrawableTop;
    private int pressCount;
    private AnimatorSet progressAnimation;
    private RadialProgress radialProgress;
    private FrameLayout radialProgressView;
    private ScrollView scrollView;
    private TextView textView;

    public BlockingUpdateView(final Context context) throws NoSuchFieldException {
        super(context);
        this.gradientDrawableTop = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Theme.getColor("windowBackgroundWhite"), 0});
        this.gradientDrawableBottom = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Theme.getColor("windowBackgroundWhite"), 0});
        setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        int i = Build.VERSION.SDK_INT;
        int i2 = i >= 21 ? (int) (AndroidUtilities.statusBarHeight / AndroidUtilities.density) : 0;
        FrameLayout frameLayout = new FrameLayout(context);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(176.0f) + (i >= 21 ? AndroidUtilities.statusBarHeight : 0)));
        RLottieImageView rLottieImageView = new RLottieImageView(context);
        rLottieImageView.setAnimation(R.raw.qr_code_logo, R.styleable.AppCompatTheme_tooltipForegroundColor, R.styleable.AppCompatTheme_tooltipForegroundColor);
        rLottieImageView.playAnimation();
        rLottieImageView.getAnimatedDrawable().setAutoRepeat(1);
        rLottieImageView.setScaleType(ImageView.ScaleType.CENTER);
        rLottieImageView.setPadding(0, 0, 0, AndroidUtilities.dp(14.0f));
        frameLayout.addView(rLottieImageView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, i2, 0.0f, 0.0f));
        rLottieImageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlockingUpdateView$i4eCulUjpVn484SYUog_ZqC_K-E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0$BlockingUpdateView(view);
            }
        });
        FrameLayout frameLayout2 = new FrameLayout(context);
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        AndroidUtilities.setScrollViewEdgeEffectColor(scrollView, Theme.getColor("actionBarDefault"));
        this.scrollView.setPadding(0, AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f));
        this.scrollView.setClipToPadding(false);
        addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f, 51, 27.0f, i2 + 178, 27.0f, 130.0f));
        this.scrollView.addView(frameLayout2);
        TextView textView = new TextView(context);
        textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        textView.setTextSize(1, 20.0f);
        textView.setGravity(49);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setText(LocaleController.getString("UpdateEitaa ", R.string.UpdateEitaa));
        frameLayout2.addView(textView, LayoutHelper.createFrame(-2, -2, 49));
        TextView textView2 = new TextView(context);
        this.textView = textView2;
        textView2.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.textView.setLinkTextColor(Theme.getColor("windowBackgroundWhiteLinkText"));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        this.textView.setGravity(49);
        this.textView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        frameLayout2.addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 44.0f, 0.0f, 0.0f));
        FrameLayout frameLayout3 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.BlockingUpdateView.1
            CellFlickerDrawable cellFlickerDrawable;

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                if (this.cellFlickerDrawable == null) {
                    CellFlickerDrawable cellFlickerDrawable = new CellFlickerDrawable();
                    this.cellFlickerDrawable = cellFlickerDrawable;
                    cellFlickerDrawable.drawFrame = false;
                    cellFlickerDrawable.repeatProgress = 2.0f;
                }
                this.cellFlickerDrawable.setParentWidth(getMeasuredWidth());
                RectF rectF = AndroidUtilities.rectTmp;
                rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
                this.cellFlickerDrawable.draw(canvas, rectF, AndroidUtilities.dp(4.0f));
                invalidate();
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                if (View.MeasureSpec.getSize(widthMeasureSpec) > AndroidUtilities.dp(260.0f)) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(320.0f), 1073741824), heightMeasureSpec);
                } else {
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            }
        };
        this.acceptButton = frameLayout3;
        frameLayout3.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        this.acceptButton.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        this.acceptButton.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        addView(this.acceptButton, LayoutHelper.createFrame(-2, 46.0f, 81, 0.0f, 0.0f, 0.0f, 45.0f));
        this.acceptButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlockingUpdateView$BIdSJCarm5QcefhqfSwCqwaWU_A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$BlockingUpdateView(view);
            }
        });
        TextView textView3 = new TextView(context);
        this.acceptTextView = textView3;
        textView3.setGravity(17);
        this.acceptTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        this.acceptTextView.setTextColor(-1);
        this.acceptTextView.setTextSize(1, 14.0f);
        this.acceptButton.addView(this.acceptTextView, LayoutHelper.createFrame(-2, -2, 17));
        FrameLayout frameLayout4 = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.BlockingUpdateView.2
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                int iDp = AndroidUtilities.dp(36.0f);
                int i3 = ((right - left) - iDp) / 2;
                int i4 = ((bottom - top) - iDp) / 2;
                BlockingUpdateView.this.radialProgress.setProgressRect(i3, i4, i3 + iDp, iDp + i4);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                BlockingUpdateView.this.radialProgress.draw(canvas);
            }
        };
        this.radialProgressView = frameLayout4;
        frameLayout4.setWillNotDraw(false);
        this.radialProgressView.setAlpha(0.0f);
        this.radialProgressView.setScaleX(0.1f);
        this.radialProgressView.setScaleY(0.1f);
        this.radialProgressView.setVisibility(4);
        RadialProgress radialProgress = new RadialProgress(this.radialProgressView);
        this.radialProgress = radialProgress;
        radialProgress.setBackground(null, true, false);
        this.radialProgress.setProgressColor(-1);
        this.acceptButton.addView(this.radialProgressView, LayoutHelper.createFrame(36, 36, 17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$BlockingUpdateView(View view) {
        int i = this.pressCount + 1;
        this.pressCount = i;
        if (i >= 10) {
            setVisibility(8);
            SharedConfig.pendingAppUpdate = null;
            SharedConfig.saveConfig();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$BlockingUpdateView(View view) {
        if (checkApkInstallPermissions(getContext())) {
            TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = this.appUpdate;
            if (tLRPC$TL_help_appUpdate.document instanceof TLRPC$TL_document) {
                if (openApkInstall((Activity) getContext(), this.appUpdate.document)) {
                    return;
                }
                FileLoader.getInstance(this.accountNum).loadFile(this.appUpdate.document, "update", 2, 1);
                showProgress(true);
                return;
            }
            if (tLRPC$TL_help_appUpdate.url != null) {
                Browser.openUrl(getContext(), this.appUpdate.url);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 8) {
            NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.fileLoaded);
            NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.fileLoadFailed);
            NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.fileLoadProgressChanged);
        }
    }

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.fileLoaded) {
            String str = (String) args[0];
            String str2 = this.fileName;
            if (str2 == null || !str2.equals(str)) {
                return;
            }
            showProgress(false);
            openApkInstall((Activity) getContext(), this.appUpdate.document);
            return;
        }
        if (id == NotificationCenter.fileLoadFailed) {
            String str3 = (String) args[0];
            String str4 = this.fileName;
            if (str4 == null || !str4.equals(str3)) {
                return;
            }
            showProgress(false);
            return;
        }
        if (id == NotificationCenter.fileLoadProgressChanged) {
            String str5 = (String) args[0];
            String str6 = this.fileName;
            if (str6 == null || !str6.equals(str5)) {
                return;
            }
            this.radialProgress.setProgress(Math.min(1.0f, ((Long) args[1]).longValue() / ((Long) args[2]).longValue()), true);
        }
    }

    public static boolean checkApkInstallPermissions(final Context context) {
        if (Build.VERSION.SDK_INT < 26 || ApplicationLoader.applicationContext.getPackageManager().canRequestPackageInstalls()) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("ApkRestricted", R.string.ApkRestricted));
        builder.setPositiveButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlockingUpdateView$fAglJPH-XdqsAuYQvnNCIDfKsdQ
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BlockingUpdateView.lambda$checkApkInstallPermissions$2(context, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.show();
        return false;
    }

    static /* synthetic */ void lambda$checkApkInstallPermissions$2(Context context, DialogInterface dialogInterface, int i) {
        try {
            context.startActivity(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName())));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static boolean openApkInstall(Activity activity, TLRPC$Document document) {
        boolean zExists = false;
        try {
            FileLoader.getAttachFileName(document);
            File pathToAttach = FileLoader.getPathToAttach(document, true);
            zExists = pathToAttach.exists();
            if (zExists) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(1);
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.setDataAndType(FileProvider.getUriForFile(activity, "ir.eitaa.messenger.provider", pathToAttach), "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(pathToAttach), "application/vnd.android.package-archive");
                }
                try {
                    activity.startActivityForResult(intent, 500);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        return zExists;
    }

    private void showProgress(final boolean show) {
        AnimatorSet animatorSet = this.progressAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.progressAnimation = new AnimatorSet();
        if (show) {
            this.radialProgressView.setVisibility(0);
            this.acceptButton.setEnabled(false);
            this.progressAnimation.playTogether(ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.ALPHA, 1.0f));
        } else {
            this.acceptTextView.setVisibility(0);
            this.acceptButton.setEnabled(true);
            this.progressAnimation.playTogether(ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
        }
        this.progressAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.Components.BlockingUpdateView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                if (BlockingUpdateView.this.progressAnimation == null || !BlockingUpdateView.this.progressAnimation.equals(animation)) {
                    return;
                }
                if (!show) {
                    BlockingUpdateView.this.radialProgressView.setVisibility(4);
                } else {
                    BlockingUpdateView.this.acceptTextView.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                if (BlockingUpdateView.this.progressAnimation == null || !BlockingUpdateView.this.progressAnimation.equals(animation)) {
                    return;
                }
                BlockingUpdateView.this.progressAnimation = null;
            }
        });
        this.progressAnimation.setDuration(150L);
        this.progressAnimation.start();
    }

    public void show(int account, TLRPC$TL_help_appUpdate update, boolean check) {
        this.pressCount = 0;
        this.appUpdate = update;
        this.accountNum = account;
        TLRPC$Document tLRPC$Document = update.document;
        if (tLRPC$Document instanceof TLRPC$TL_document) {
            this.fileName = FileLoader.getAttachFileName(tLRPC$Document);
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(update.text);
        MessageObject.addEntitiesToText(spannableStringBuilder, update.entities, false, false, false, false);
        this.textView.setText(spannableStringBuilder);
        if (update.document instanceof TLRPC$TL_document) {
            this.acceptTextView.setText(LocaleController.getString("Update", R.string.Update) + String.format(Locale.US, " (%1$s)", AndroidUtilities.formatFileSize(update.document.size)));
        } else {
            this.acceptTextView.setText(LocaleController.getString("Update", R.string.Update));
        }
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.fileLoaded);
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.fileLoadFailed);
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.fileLoadProgressChanged);
        if (check) {
            TLRPC$TL_help_getAppUpdate tLRPC$TL_help_getAppUpdate = new TLRPC$TL_help_getAppUpdate();
            try {
                tLRPC$TL_help_getAppUpdate.source = ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(ApplicationLoader.applicationContext.getPackageName());
            } catch (Exception unused) {
            }
            if (tLRPC$TL_help_getAppUpdate.source == null) {
                tLRPC$TL_help_getAppUpdate.source = "";
            }
            ConnectionsManager.getInstance(this.accountNum).sendRequest(tLRPC$TL_help_getAppUpdate, new RequestDelegate() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlockingUpdateView$C3bArfq-Yq_jkvtNWzaeQZy6HE8
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$show$4$BlockingUpdateView(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$show$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$show$4$BlockingUpdateView(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.Components.-$$Lambda$BlockingUpdateView$Fq2v2q1DCOrizY5ZCp7f4EiUHC4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$3$BlockingUpdateView(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$show$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$show$3$BlockingUpdateView(TLObject tLObject) {
        if (!(tLObject instanceof TLRPC$TL_help_appUpdate) || ((TLRPC$TL_help_appUpdate) tLObject).can_not_skip) {
            return;
        }
        setVisibility(8);
        SharedConfig.pendingAppUpdate = null;
        SharedConfig.saveConfig();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.gradientDrawableTop.setBounds(this.scrollView.getLeft(), this.scrollView.getTop(), this.scrollView.getRight(), this.scrollView.getTop() + AndroidUtilities.dp(16.0f));
        this.gradientDrawableTop.draw(canvas);
        this.gradientDrawableBottom.setBounds(this.scrollView.getLeft(), this.scrollView.getBottom() - AndroidUtilities.dp(18.0f), this.scrollView.getRight(), this.scrollView.getBottom());
        this.gradientDrawableBottom.draw(canvas);
    }
}
