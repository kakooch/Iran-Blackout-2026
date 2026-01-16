package org.rbmain.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import java.lang.reflect.InvocationTargetException;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.FileLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.browser.Browser;
import org.rbmain.tgnet.TLRPC$Document;
import org.rbmain.tgnet.TLRPC$TL_document;
import org.rbmain.tgnet.TLRPC$TL_help_appUpdate;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.Theme;

/* loaded from: classes5.dex */
public class UpdateAppAlertDialog extends AlertDialog {
    private int accountNum;
    private TLRPC$TL_help_appUpdate appUpdate;
    private String fileName;
    private Activity parentActivity;
    private AnimatorSet progressAnimation;
    private RadialProgress radialProgress;
    private FrameLayout radialProgressView;

    public UpdateAppAlertDialog(Activity activity, TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate, int i) {
        super(activity, 0);
        this.appUpdate = tLRPC$TL_help_appUpdate;
        this.accountNum = i;
        TLRPC$Document tLRPC$Document = tLRPC$TL_help_appUpdate.document;
        if (tLRPC$Document instanceof TLRPC$TL_document) {
            this.fileName = FileLoader.getAttachFileName(tLRPC$Document);
        }
        this.parentActivity = activity;
        setTopImage(R.drawable.update, Theme.getColor(Theme.key_dialogTopBackground));
        setTopHeight(175);
        setMessage(this.appUpdate.text);
        if (this.appUpdate.document instanceof TLRPC$TL_document) {
            setSecondTitle(AndroidUtilities.formatFileSize(r2.size));
        }
        setDismissDialogByButtons(false);
        setTitle(LocaleController.getString("UpdateRubika", R.string.UpdateRubika));
        setPositiveButton(LocaleController.getString("UpdateNow", R.string.UpdateNow), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.UpdateAppAlertDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$new$0(dialogInterface, i2);
            }
        });
        setNeutralButton(LocaleController.getString("Later", R.string.Later), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.Components.UpdateAppAlertDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$new$1(dialogInterface, i2);
            }
        });
        FrameLayout frameLayout = new FrameLayout(this.parentActivity) { // from class: org.rbmain.ui.Components.UpdateAppAlertDialog.1
            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                super.onLayout(z, i2, i3, i4, i5);
                int iDp = AndroidUtilities.dp(24.0f);
                int i6 = ((i4 - i2) - iDp) / 2;
                int iDp2 = (((i5 - i3) - iDp) / 2) + AndroidUtilities.dp(2.0f);
                UpdateAppAlertDialog.this.radialProgress.setProgressRect(i6, iDp2, i6 + iDp, iDp + iDp2);
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                UpdateAppAlertDialog.this.radialProgress.draw(canvas);
            }
        };
        this.radialProgressView = frameLayout;
        frameLayout.setWillNotDraw(false);
        this.radialProgressView.setAlpha(0.0f);
        this.radialProgressView.setScaleX(0.1f);
        this.radialProgressView.setScaleY(0.1f);
        this.radialProgressView.setVisibility(4);
        RadialProgress radialProgress = new RadialProgress(this.radialProgressView);
        this.radialProgress = radialProgress;
        radialProgress.setStrokeWidth(AndroidUtilities.dp(2.0f));
        this.radialProgress.setBackground(null, true, false);
        this.radialProgress.setProgressColor(Theme.getColor(Theme.key_dialogButton));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(DialogInterface dialogInterface, int i) {
        if (BlockingUpdateView.checkApkInstallPermissions(getContext())) {
            TLRPC$TL_help_appUpdate tLRPC$TL_help_appUpdate = this.appUpdate;
            TLRPC$Document tLRPC$Document = tLRPC$TL_help_appUpdate.document;
            if (tLRPC$Document instanceof TLRPC$TL_document) {
                if (BlockingUpdateView.openApkInstall(this.parentActivity, tLRPC$Document)) {
                    return;
                }
                FileLoader.getInstance(this.accountNum).loadFile(this.appUpdate.document, "update", 1, 1);
                showProgress(true);
                return;
            }
            if (tLRPC$TL_help_appUpdate.url != null) {
                Browser.openUrl(getContext(), this.appUpdate.url);
                dialogInterface.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(DialogInterface dialogInterface, int i) {
        if (this.appUpdate.document instanceof TLRPC$TL_document) {
            FileLoader.getInstance(this.accountNum).cancelLoadFile(this.appUpdate.document);
        }
        dialogInterface.dismiss();
    }

    @Override // org.rbmain.ui.ActionBar.AlertDialog, org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.fileDidLoad) {
            String str = (String) objArr[0];
            String str2 = this.fileName;
            if (str2 == null || !str2.equals(str)) {
                return;
            }
            showProgress(false);
            BlockingUpdateView.openApkInstall(this.parentActivity, this.appUpdate.document);
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

    @Override // org.rbmain.ui.ActionBar.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.fileDidLoad);
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.fileDidFailToLoad);
        NotificationCenter.getInstance(this.accountNum).addObserver(this, NotificationCenter.FileLoadProgressChanged);
        this.buttonsLayout.addView(this.radialProgressView, LayoutHelper.createFrame(36, 36.0f));
    }

    @Override // org.rbmain.ui.ActionBar.AlertDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.fileDidLoad);
        NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.fileDidFailToLoad);
        NotificationCenter.getInstance(this.accountNum).removeObserver(this, NotificationCenter.FileLoadProgressChanged);
    }

    private void showProgress(final boolean z) {
        AnimatorSet animatorSet = this.progressAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.progressAnimation = new AnimatorSet();
        final View viewFindViewWithTag = this.buttonsLayout.findViewWithTag(-1);
        if (z) {
            this.radialProgressView.setVisibility(0);
            viewFindViewWithTag.setEnabled(false);
            this.progressAnimation.playTogether(ObjectAnimator.ofFloat(viewFindViewWithTag, "scaleX", 0.1f), ObjectAnimator.ofFloat(viewFindViewWithTag, "scaleY", 0.1f), ObjectAnimator.ofFloat(viewFindViewWithTag, "alpha", 0.0f), ObjectAnimator.ofFloat(this.radialProgressView, "scaleX", 1.0f), ObjectAnimator.ofFloat(this.radialProgressView, "scaleY", 1.0f), ObjectAnimator.ofFloat(this.radialProgressView, "alpha", 1.0f));
        } else {
            viewFindViewWithTag.setVisibility(0);
            viewFindViewWithTag.setEnabled(true);
            this.progressAnimation.playTogether(ObjectAnimator.ofFloat(this.radialProgressView, "scaleX", 0.1f), ObjectAnimator.ofFloat(this.radialProgressView, "scaleY", 0.1f), ObjectAnimator.ofFloat(this.radialProgressView, "alpha", 0.0f), ObjectAnimator.ofFloat(viewFindViewWithTag, "scaleX", 1.0f), ObjectAnimator.ofFloat(viewFindViewWithTag, "scaleY", 1.0f), ObjectAnimator.ofFloat(viewFindViewWithTag, "alpha", 1.0f));
        }
        this.progressAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.Components.UpdateAppAlertDialog.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (UpdateAppAlertDialog.this.progressAnimation == null || !UpdateAppAlertDialog.this.progressAnimation.equals(animator)) {
                    return;
                }
                if (!z) {
                    UpdateAppAlertDialog.this.radialProgressView.setVisibility(4);
                } else {
                    viewFindViewWithTag.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (UpdateAppAlertDialog.this.progressAnimation == null || !UpdateAppAlertDialog.this.progressAnimation.equals(animator)) {
                    return;
                }
                UpdateAppAlertDialog.this.progressAnimation = null;
            }
        });
        this.progressAnimation.setDuration(150L);
        this.progressAnimation.start();
    }
}
