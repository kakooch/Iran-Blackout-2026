package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
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
import com.facebook.stetho.server.http.HttpStatus;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.File;
import java.util.Locale;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_help_appUpdate;
import org.rbmain.tgnet.TLRPC$TL_help_getAppUpdate;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class BlockingUpdateView extends FrameLayout implements NotificationCenter.NotificationCenterDelegate {
    private FrameLayout acceptButton;
    private TextView acceptTextView;
    private int accountNum;
    private TLRPC$TL_help_appUpdate appUpdate;
    private String fileName;
    private int pressCount;
    private AnimatorSet progressAnimation;
    private RadialProgress radialProgress;
    private FrameLayout radialProgressView;
    private TextView textView;

    public BlockingUpdateView(Context context) throws NoSuchFieldException {
        super(context);
        setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        int i = Build.VERSION.SDK_INT;
        int i2 = i >= 21 ? (int) (AndroidUtilities.statusBarHeight / AndroidUtilities.density) : 0;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(-11556378);
        addView(frameLayout, new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(176.0f) + (i >= 21 ? AndroidUtilities.statusBarHeight : 0)));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.intro_tg_plane);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setPadding(0, 0, 0, AndroidUtilities.dp(14.0f));
        frameLayout.addView(imageView, LayoutHelper.createFrame(-2, -2.0f, 17, 0.0f, i2, 0.0f, 0.0f));
        imageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.BlockingUpdateView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$0(view);
            }
        });
        ScrollView scrollView = new ScrollView(context);
        AndroidUtilities.setScrollViewEdgeEffectColor(scrollView, Theme.getColor(Theme.key_actionBarDefault));
        addView(scrollView, LayoutHelper.createFrame(-1, -1.0f, 51, 27.0f, i2 + 206, 27.0f, 130.0f));
        FrameLayout frameLayout2 = new FrameLayout(context);
        scrollView.addView(frameLayout2, LayoutHelper.createScroll(-1, -2, 17));
        TextView textView = new TextView(context);
        int i3 = Theme.key_windowBackgroundWhiteBlackText;
        textView.setTextColor(Theme.getColor(i3));
        textView.setTextSize(1, 20.0f);
        textView.setGravity(49);
        textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        textView.setText(LocaleController.getString("UpdateRubika", R.string.UpdateRubika));
        frameLayout2.addView(textView, LayoutHelper.createFrame(-2, -2, 49));
        TextView textView2 = new TextView(context);
        this.textView = textView2;
        textView2.setTextColor(Theme.getColor(i3));
        this.textView.setLinkTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteLinkText));
        this.textView.setTextSize(1, 15.0f);
        this.textView.setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
        this.textView.setGravity(49);
        this.textView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
        frameLayout2.addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 44.0f, 0.0f, 0.0f));
        FrameLayout frameLayout3 = new FrameLayout(context);
        this.acceptButton = frameLayout3;
        frameLayout3.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), -11491093, -12346402));
        this.acceptButton.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        addView(this.acceptButton, LayoutHelper.createFrame(-2, 42.0f, 81, 0.0f, 0.0f, 0.0f, 45.0f));
        this.acceptButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.Components.BlockingUpdateView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1(view);
            }
        });
        TextView textView3 = new TextView(context);
        this.acceptTextView = textView3;
        textView3.setGravity(17);
        this.acceptTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
        this.acceptTextView.setTextColor(-1);
        this.acceptTextView.setTextSize(1, 14.0f);
        this.acceptButton.addView(this.acceptTextView, LayoutHelper.createFrame(-2, -2, 17));
        FrameLayout frameLayout4 = new FrameLayout(context) { // from class: org.rbmain.ui.Components.BlockingUpdateView.1
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i4, int i5, int i6, int i7) {
                super.onLayout(z, i4, i5, i6, i7);
                int iDp = AndroidUtilities.dp(36.0f);
                int i8 = ((i6 - i4) - iDp) / 2;
                int i9 = ((i7 - i5) - iDp) / 2;
                BlockingUpdateView.this.radialProgress.setProgressRect(i8, i9, i8 + iDp, iDp + i9);
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
    public /* synthetic */ void lambda$new$0(View view) {
        int i = this.pressCount + 1;
        this.pressCount = i;
        if (i >= 10) {
            setVisibility(8);
            UserConfig.getInstance(0).pendingAppUpdate = null;
            UserConfig.getInstance(0).saveConfig(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view) {
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
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8) {
            NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.fileDidLoad);
            NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.fileDidFailToLoad);
            NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.FileLoadProgressChanged);
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.fileDidLoad) {
            String str = (String) objArr[0];
            String str2 = this.fileName;
            if (str2 == null || !str2.equals(str)) {
                return;
            }
            showProgress(false);
            openApkInstall((Activity) getContext(), this.appUpdate.document);
            return;
        }
        if (i == NotificationCenter.fileDidFailToLoad) {
            String str3 = (String) objArr[0];
            String str4 = this.fileName;
            if (str4 == null || !str4.equals(str3)) {
                return;
            }
            showProgress(false);
            return;
        }
        if (i == NotificationCenter.FileLoadProgressChanged) {
            String str5 = (String) objArr[0];
            String str6 = this.fileName;
            if (str6 == null || !str6.equals(str5)) {
                return;
            }
            this.radialProgress.setProgress(Math.min(1.0f, ((Long) objArr[1]).longValue() / ((Long) objArr[2]).longValue()), true);
        }
    }

    public static boolean checkApkInstallPermissions(final Context context) {
        if (Build.VERSION.SDK_INT < 26 || ApplicationLoader.applicationContext.getPackageManager().canRequestPackageInstalls()) {
            return true;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setMessage(LocaleController.getString("ApkRestricted", R.string.ApkRestricted));
        builder.setPositiveButton(LocaleController.getString("PermissionOpenSettings", R.string.PermissionOpenSettings), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.BlockingUpdateView$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                BlockingUpdateView.lambda$checkApkInstallPermissions$2(context, dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.show();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkApkInstallPermissions$2(Context context, DialogInterface dialogInterface, int i) {
        try {
            context.startActivity(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + ApplicationLoader.applicationContext.getPackageName())));
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    public static boolean openApkInstall(Activity activity, TLRPC$Document tLRPC$Document) {
        boolean zExists = false;
        try {
            FileLoader.getAttachFileName(tLRPC$Document);
            File pathToAttach = FileLoader.getPathToAttach(tLRPC$Document, true);
            zExists = pathToAttach.exists();
            if (zExists) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(1);
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.setDataAndType(FileProvider.getUriForFile(activity, "ir.medu.shad.provider", pathToAttach), "application/vnd.android.package-archive");
                } else {
                    intent.setDataAndType(Uri.fromFile(pathToAttach), "application/vnd.android.package-archive");
                }
                try {
                    activity.startActivityForResult(intent, HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
        } catch (Exception e2) {
            FileLog.e(e2);
        }
        return zExists;
    }

    private void showProgress(final boolean z) {
        AnimatorSet animatorSet = this.progressAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.progressAnimation = new AnimatorSet();
        if (z) {
            this.radialProgressView.setVisibility(0);
            this.acceptButton.setEnabled(false);
            this.progressAnimation.playTogether(ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.ALPHA, 1.0f));
        } else {
            this.acceptTextView.setVisibility(0);
            this.acceptButton.setEnabled(true);
            this.progressAnimation.playTogether(ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.radialProgressView, (Property<FrameLayout, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.acceptTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
        }
        this.progressAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.BlockingUpdateView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BlockingUpdateView.this.progressAnimation == null || !BlockingUpdateView.this.progressAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    BlockingUpdateView.this.radialProgressView.setVisibility(4);
                } else {
                    BlockingUpdateView.this.acceptTextView.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (BlockingUpdateView.this.progressAnimation == null || !BlockingUpdateView.this.progressAnimation.equals(animator)) {
                    return;
                }
                BlockingUpdateView.this.progressAnimation = null;
            }
        });
        this.progressAnimation.setDuration(150L);
        this.progressAnimation.start();
    }

    public void show(int i, TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate, boolean z) {
        this.pressCount = 0;
        this.appUpdate = tLRPC$TL_help_appUpdate;
        this.accountNum = i;
        TLRPC$Document tLRPC$Document = tLRPC$TL_help_appUpdate.document;
        if (tLRPC$Document instanceof TLRPC$TL_document) {
            this.fileName = FileLoader.getAttachFileName(tLRPC$Document);
        }
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(tLRPC$TL_help_appUpdate.text);
        MessageObject.addEntitiesToText(spannableStringBuilder, tLRPC$TL_help_appUpdate.entities, false, false, false, false);
        this.textView.setText(spannableStringBuilder);
        if (tLRPC$TL_help_appUpdate.document instanceof TLRPC$TL_document) {
            this.acceptTextView.setText(LocaleController.getString("Update", R.string.Update) + String.format(Locale.US, " (%1$s)", AndroidUtilities.formatFileSize(tLRPC$TL_help_appUpdate.document.size)));
        } else {
            this.acceptTextView.setText(LocaleController.getString("Update", R.string.Update));
        }
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.fileDidLoad);
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.fileDidFailToLoad);
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.FileLoadProgressChanged);
        if (z) {
            TLRPC$TL_help_getAppUpdate tLRPC$TL_help_getAppUpdate = new TLRPC$TL_help_getAppUpdate();
            try {
                tLRPC$TL_help_getAppUpdate.source = ApplicationLoader.applicationContext.getPackageManager().getInstallerPackageName(ApplicationLoader.applicationContext.getPackageName());
            } catch (Exception unused) {
            }
            if (tLRPC$TL_help_getAppUpdate.source == null) {
                tLRPC$TL_help_getAppUpdate.source = BuildConfig.FLAVOR;
            }
            ConnectionsManager.getInstance(this.accountNum).sendRequest(tLRPC$TL_help_getAppUpdate, new RequestDelegate() { // from class: org.rbmain.ui.Components.BlockingUpdateView$$ExternalSyntheticLambda4
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$show$4(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$4(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.Components.BlockingUpdateView$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$show$3(tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$show$3(TLObject tLObject) {
        if (!(tLObject instanceof TLRPC$TL_help_appUpdate) || ((TLRPC$TL_help_appUpdate) tLObject).can_not_skip) {
            return;
        }
        setVisibility(8);
        UserConfig.getInstance(0).pendingAppUpdate = null;
        UserConfig.getInstance(0).saveConfig(false);
    }
}
