package ir.resaneh1.iptv.helper;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;
import ir.resaneh1.iptv.logger.MyLog;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.Bulletin;
import org.rbmain.ui.Components.BulletinFactory;

/* loaded from: classes3.dex */
public class ToastiLikeSnack {
    public static TextView textView;

    public static void customViewToast(Context context, String str, int i) {
        TextView textView2;
        if (context == null || str == null) {
            return;
        }
        try {
            if (str.isEmpty()) {
                return;
            }
            Toast toastMakeText = Toast.makeText(context, "   " + str + "   ", i);
            View view = toastMakeText.getView();
            if (view != null && (textView2 = (TextView) view.findViewById(R.id.message)) != null) {
                textView2.setTextSize(15.0f);
                textView2.setTextColor(-1);
                textView2.setGravity(17);
                view.setBackground(context.getResources().getDrawable(ir.medu.shad.R.drawable.toast_shape));
            }
            toastMakeText.show();
        } catch (Exception e) {
            MyLog.handleExceptionThrowOnDebug(e);
        }
    }

    public static void showS(Context context, String str) {
        customViewToast(context, str, 0);
    }

    public static void showL(Context context, String str) {
        customViewToast(context, str, 1);
    }

    public static void showNoInternet() {
        if (ApplicationLoader.applicationActivity != null) {
            showS(ApplicationLoader.applicationActivity, "خطا در اتصال به اینترنت");
        }
    }

    public static void showMessageLikeToast(String str) {
        showMessageLikeToast(str, 2000);
    }

    public static void showMessageLikeToastLong(String str) {
        showMessageLikeToast(str, 3500);
    }

    public static void showMessageLikeToast(final String str, final int i) {
        if (ApplicationLoader.applicationActivity == null || TextUtils.isEmpty(str)) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.helper.ToastiLikeSnack$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ToastiLikeSnack.lambda$showMessageLikeToast$0(i, str);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showMessageLikeToast$0(int i, String str) {
        Bulletin bulletinCreateCustomBulletin;
        BaseFragment lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
        if (i <= 0) {
            bulletinCreateCustomBulletin = BulletinFactory.of(lastFragment).createCustomBulletin(str);
        } else {
            bulletinCreateCustomBulletin = BulletinFactory.of(lastFragment).createCustomBulletin(str, i);
        }
        bulletinCreateCustomBulletin.show();
    }

    static {
        new Runnable() { // from class: ir.resaneh1.iptv.helper.ToastiLikeSnack.1
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationLoader.applicationActivity != null) {
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ToastiLikeSnack.textView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 1.0f, 0.0f));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(200L);
                    animatorSet.setInterpolator(new AccelerateInterpolator());
                    animatorSet.play(objectAnimatorOfPropertyValuesHolder);
                    animatorSet.start();
                    animatorSet.addListener(new Animator.AnimatorListener(this) { // from class: ir.resaneh1.iptv.helper.ToastiLikeSnack.1.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            ToastiLikeSnack.textView.setVisibility(8);
                        }
                    });
                }
            }
        };
    }
}
