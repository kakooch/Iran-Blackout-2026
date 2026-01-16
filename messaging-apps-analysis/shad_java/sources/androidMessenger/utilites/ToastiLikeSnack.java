package androidMessenger.utilites;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes.dex */
public class ToastiLikeSnack {
    static Handler handler;
    static Runnable hideMessageRunnable = new Runnable() { // from class: androidMessenger.utilites.ToastiLikeSnack.2
        @Override // java.lang.Runnable
        public void run() {
            if (ApplicationLoader.applicationActivity != null) {
                ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ToastiLikeSnack.textView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 1.0f, 0.0f));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.setInterpolator(new AccelerateInterpolator());
                animatorSet.play(objectAnimatorOfPropertyValuesHolder);
                animatorSet.start();
                animatorSet.addListener(new Animator.AnimatorListener(this) { // from class: androidMessenger.utilites.ToastiLikeSnack.2.1
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
                view.setBackground(ContextCompat.getDrawable(context, ir.medu.shad.R.drawable.toast_shape));
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

    public static void showMessageLikeToast(String str, int i) {
        if (ApplicationLoader.applicationActivity != null) {
            textView = ApplicationLoader.applicationActivity.getToastTextView();
        }
        if (textView == null || str == null || str.isEmpty()) {
            return;
        }
        cancelTimer();
        if (ApplicationLoader.applicationActivity != null) {
            textView.setVisibility(0);
            textView.setText(str);
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(textView, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, textView.getAlpha(), 1.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new AccelerateInterpolator());
            animatorSet.play(objectAnimatorOfPropertyValuesHolder);
            animatorSet.addListener(new Animator.AnimatorListener() { // from class: androidMessenger.utilites.ToastiLikeSnack.1
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
                    ToastiLikeSnack.textView.invalidate();
                    ToastiLikeSnack.textView.setVisibility(0);
                    ToastiLikeSnack.textView.setAlpha(1.0f);
                }
            });
            animatorSet.start();
        }
        startTimer(i);
    }

    public static void startTimer(int i) {
        try {
            if (handler == null) {
                handler = new Handler();
            }
            handler.postDelayed(hideMessageRunnable, i);
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }

    public static void cancelTimer() {
        try {
            if (handler == null) {
                handler = new Handler();
            }
            handler.removeCallbacks(hideMessageRunnable);
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }
}
