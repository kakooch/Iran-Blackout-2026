package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import ir.nasim.AC5;
import ir.nasim.AbstractC9454Zz5;
import ir.nasim.OK4;

/* loaded from: classes2.dex */
abstract class m {
    private static int a(Fragment fragment, boolean z, boolean z2) {
        return z2 ? z ? fragment.X5() : fragment.Y5() : z ? fragment.H5() : fragment.K5();
    }

    static a b(Context context, Fragment fragment, boolean z, boolean z2) throws Resources.NotFoundException {
        int iT5 = fragment.T5();
        int iA = a(fragment, z, z2);
        fragment.Z7(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.A0;
        if (viewGroup != null && viewGroup.getTag(AC5.visible_removing_fragment_view_tag) != null) {
            fragment.A0.setTag(AC5.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.A0;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationN6 = fragment.N6(iT5, z, iA);
        if (animationN6 != null) {
            return new a(animationN6);
        }
        Animator animatorO6 = fragment.O6(iT5, z, iA);
        if (animatorO6 != null) {
            return new a(animatorO6);
        }
        if (iA == 0 && iT5 != 0) {
            iA = d(context, iT5, z);
        }
        if (iA != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            } else {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                    if (animatorLoadAnimator != null) {
                        return new a(animatorLoadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (zEquals) {
                        throw e2;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation2 != null) {
                        return new a(animationLoadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    private static int c(Context context, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i, boolean z) {
        if (i == 4097) {
            return z ? AbstractC9454Zz5.fragment_open_enter : AbstractC9454Zz5.fragment_open_exit;
        }
        if (i == 8194) {
            return z ? AbstractC9454Zz5.fragment_close_enter : AbstractC9454Zz5.fragment_close_exit;
        }
        if (i == 8197) {
            return z ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i == 4099) {
            return z ? AbstractC9454Zz5.fragment_fade_enter : AbstractC9454Zz5.fragment_fade_exit;
        }
        if (i != 4100) {
            return -1;
        }
        return z ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    static class a {
        public final Animation a;
        public final AnimatorSet b;

        a(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.a = null;
            AnimatorSet animatorSet = new AnimatorSet();
            this.b = animatorSet;
            animatorSet.play(animator);
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    static class b extends AnimationSet implements Runnable {
        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean d;
        private boolean e;

        b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.e = true;
            this.a = viewGroup;
            this.b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.c = true;
                OK4.a(this.a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c || !this.e) {
                this.a.endViewTransition(this.b);
                this.d = true;
            } else {
                this.e = false;
                this.a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.e = true;
            if (this.c) {
                return !this.d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.c = true;
                OK4.a(this.a, this);
            }
            return true;
        }
    }
}
