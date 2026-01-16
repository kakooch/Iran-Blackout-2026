package ir.nasim;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import java.util.Map;

/* renamed from: ir.nasim.Mn7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C6187Mn7 extends Transition {

    /* renamed from: ir.nasim.Mn7$a */
    class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ TextView a;

        a(TextView textView) {
            this.a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.a.setScaleX(fFloatValue);
            this.a.setScaleY(fFloatValue);
        }
    }

    private void l0(androidx.transition.t tVar) {
        View view = tVar.b;
        if (view instanceof TextView) {
            tVar.a.put("android:textscale:scale", Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    @Override // androidx.transition.Transition
    public void i(androidx.transition.t tVar) {
        l0(tVar);
    }

    @Override // androidx.transition.Transition
    public void m(androidx.transition.t tVar) {
        l0(tVar);
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, androidx.transition.t tVar, androidx.transition.t tVar2) {
        if (tVar == null || tVar2 == null || !(tVar.b instanceof TextView)) {
            return null;
        }
        View view = tVar2.b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map map = tVar.a;
        Map map2 = tVar2.a;
        float fFloatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float fFloatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new a(textView));
        return valueAnimatorOfFloat;
    }
}
