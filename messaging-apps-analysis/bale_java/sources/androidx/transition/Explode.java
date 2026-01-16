package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import ir.nasim.C17147mU0;
import ir.nasim.TB5;

/* loaded from: classes2.dex */
public class Explode extends Visibility {
    private static final TimeInterpolator D0 = new DecelerateInterpolator();
    private static final TimeInterpolator E0 = new AccelerateInterpolator();
    private int[] C0;

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C0 = new int[2];
        h0(new C17147mU0());
    }

    private void l0(t tVar) {
        View view = tVar.b;
        view.getLocationOnScreen(this.C0);
        int[] iArr = this.C0;
        int i = iArr[0];
        int i2 = iArr[1];
        tVar.a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    private static float u0(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private static float v0(View view, int i, int i2) {
        return u0(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    private void w0(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.C0);
        int[] iArr2 = this.C0;
        int i = iArr2[0];
        int i2 = iArr2[1];
        Rect rectU = u();
        if (rectU == null) {
            width = (view.getWidth() / 2) + i + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectU.centerX();
            iCenterY = rectU.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fU0 = u0(fCenterX, fCenterY);
        float fV0 = v0(view, width - i, iCenterY - i2);
        iArr[0] = Math.round((fCenterX / fU0) * fV0);
        iArr[1] = Math.round(fV0 * (fCenterY / fU0));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void i(t tVar) {
        super.i(tVar);
        l0(tVar);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void m(t tVar) {
        super.m(tVar);
        l0(tVar);
    }

    @Override // androidx.transition.Visibility
    public Animator o0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        if (tVar2 == null) {
            return null;
        }
        Rect rect = (Rect) tVar2.a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        w0(viewGroup, rect, this.C0);
        int[] iArr = this.C0;
        return v.a(view, tVar2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, D0, this);
    }

    @Override // androidx.transition.Visibility
    public Animator q0(ViewGroup viewGroup, View view, t tVar, t tVar2) {
        float f;
        float f2;
        if (tVar == null) {
            return null;
        }
        Rect rect = (Rect) tVar.a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) tVar.b.getTag(TB5.transition_position);
        if (iArr != null) {
            f = (r7 - rect.left) + translationX;
            f2 = (r0 - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        w0(viewGroup, rect, this.C0);
        int[] iArr2 = this.C0;
        return v.a(view, tVar, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], E0, this);
    }
}
