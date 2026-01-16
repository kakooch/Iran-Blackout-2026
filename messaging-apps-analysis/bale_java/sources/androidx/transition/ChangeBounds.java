package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC8958Xy7;
import java.util.Map;

/* loaded from: classes2.dex */
public class ChangeBounds extends Transition {
    private static final String[] D0 = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property E0 = new b(PointF.class, "boundsOrigin");
    private static final Property F0 = new c(PointF.class, "topLeft");
    private static final Property G0 = new d(PointF.class, "bottomRight");
    private static final Property H0 = new e(PointF.class, "bottomRight");
    private static final Property I0 = new f(PointF.class, "topLeft");
    private static final Property J0 = new g(PointF.class, "position");
    private static n K0 = new n();
    private int[] A0;
    private boolean B0;
    private boolean C0;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ ViewGroup a;
        final /* synthetic */ BitmapDrawable b;
        final /* synthetic */ View c;
        final /* synthetic */ float d;

        a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.a = viewGroup;
            this.b = bitmapDrawable;
            this.c = view;
            this.d = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            B.b(this.a).b(this.b);
            B.h(this.c, this.d);
        }
    }

    class b extends Property {
        private Rect a;

        b(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.a);
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            B.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    class f extends Property {
        f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            B.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    class g extends Property {
        g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            B.g(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    class h extends AnimatorListenerAdapter {
        final /* synthetic */ k a;
        private k mViewBounds;

        h(k kVar) {
            this.a = kVar;
            this.mViewBounds = kVar;
        }
    }

    class i extends AnimatorListenerAdapter {
        private boolean a;
        final /* synthetic */ View b;
        final /* synthetic */ Rect c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ int f;
        final /* synthetic */ int g;

        i(View view, Rect rect, int i, int i2, int i3, int i4) {
            this.b = view;
            this.c = rect;
            this.d = i;
            this.e = i2;
            this.f = i3;
            this.g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            AbstractC12990fW7.w0(this.b, this.c);
            B.g(this.b, this.d, this.e, this.f, this.g);
        }
    }

    class j extends q {
        boolean a = false;
        final /* synthetic */ ViewGroup b;

        j(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void a(Transition transition) {
            y.d(this.b, true);
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void c(Transition transition) {
            y.d(this.b, false);
        }

        @Override // androidx.transition.Transition.f
        public void d(Transition transition) {
            if (!this.a) {
                y.d(this.b, false);
            }
            transition.W(this);
        }

        @Override // androidx.transition.q, androidx.transition.Transition.f
        public void e(Transition transition) {
            y.d(this.b, false);
            this.a = true;
        }
    }

    private static class k {
        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        k(View view) {
            this.e = view;
        }

        private void b() {
            B.g(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    public ChangeBounds() {
        this.A0 = new int[2];
        this.B0 = false;
        this.C0 = false;
    }

    private void l0(t tVar) {
        View view = tVar.b;
        if (!AbstractC12990fW7.T(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        tVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        tVar.a.put("android:changeBounds:parent", tVar.b.getParent());
        if (this.C0) {
            tVar.b.getLocationInWindow(this.A0);
            tVar.a.put("android:changeBounds:windowX", Integer.valueOf(this.A0[0]));
            tVar.a.put("android:changeBounds:windowY", Integer.valueOf(this.A0[1]));
        }
        if (this.B0) {
            tVar.a.put("android:changeBounds:clip", AbstractC12990fW7.t(view));
        }
    }

    private boolean m0(View view, View view2) {
        if (!this.C0) {
            return true;
        }
        t tVarX = x(view, true);
        if (tVarX == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == tVarX.b) {
            return true;
        }
        return false;
    }

    @Override // androidx.transition.Transition
    public String[] G() {
        return D0;
    }

    @Override // androidx.transition.Transition
    public void i(t tVar) {
        l0(tVar);
    }

    @Override // androidx.transition.Transition
    public void m(t tVar) {
        l0(tVar);
    }

    public void n0(boolean z) {
        this.B0 = z;
    }

    @Override // androidx.transition.Transition
    public Animator q(ViewGroup viewGroup, t tVar, t tVar2) {
        int i2;
        View view;
        int i3;
        ObjectAnimator objectAnimator;
        Animator animatorC;
        if (tVar == null || tVar2 == null) {
            return null;
        }
        Map map = tVar.a;
        Map map2 = tVar2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = tVar2.b;
        if (!m0(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) tVar.a.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) tVar.a.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) tVar2.a.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) tVar2.a.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.A0);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fC = B.c(view2);
            B.h(view2, 0.0f);
            B.b(viewGroup).a(bitmapDrawable);
            PathMotion pathMotionY = y();
            int[] iArr = this.A0;
            int i4 = iArr[0];
            int i5 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, m.a(E0, pathMotionY.a(iIntValue - i4, iIntValue2 - i5, iIntValue3 - i4, iIntValue4 - i5)));
            objectAnimatorOfPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, fC));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect = (Rect) tVar.a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) tVar2.a.get("android:changeBounds:bounds");
        int i6 = rect.left;
        int i7 = rect2.left;
        int i8 = rect.top;
        int i9 = rect2.top;
        int i10 = rect.right;
        int i11 = rect2.right;
        int i12 = rect.bottom;
        int i13 = rect2.bottom;
        int i14 = i10 - i6;
        int i15 = i12 - i8;
        int i16 = i11 - i7;
        int i17 = i13 - i9;
        Rect rect3 = (Rect) tVar.a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) tVar2.a.get("android:changeBounds:clip");
        if ((i14 == 0 || i15 == 0) && (i16 == 0 || i17 == 0)) {
            i2 = 0;
        } else {
            i2 = (i6 == i7 && i8 == i9) ? 0 : 1;
            if (i10 != i11 || i12 != i13) {
                i2++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.B0) {
            view = view2;
            B.g(view, i6, i8, Math.max(i14, i16) + i6, Math.max(i15, i17) + i8);
            ObjectAnimator objectAnimatorA = (i6 == i7 && i8 == i9) ? null : l.a(view, J0, y().a(i6, i8, i7, i9));
            if (rect3 == null) {
                i3 = 0;
                rect3 = new Rect(0, 0, i14, i15);
            } else {
                i3 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i3, i3, i16, i17) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                AbstractC12990fW7.w0(view, rect3);
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", K0, rect3, rect5);
                objectAnimatorOfObject.addListener(new i(view, rect4, i7, i9, i11, i13));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorC = s.c(objectAnimatorA, objectAnimator);
        } else {
            view = view2;
            B.g(view, i6, i8, i10, i12);
            if (i2 != 2) {
                animatorC = (i6 == i7 && i8 == i9) ? l.a(view, H0, y().a(i10, i12, i11, i13)) : l.a(view, I0, y().a(i6, i8, i7, i9));
            } else if (i14 == i16 && i15 == i17) {
                animatorC = l.a(view, J0, y().a(i6, i8, i7, i9));
            } else {
                k kVar = new k(view);
                ObjectAnimator objectAnimatorA2 = l.a(kVar, F0, y().a(i6, i8, i7, i9));
                ObjectAnimator objectAnimatorA3 = l.a(kVar, G0, y().a(i10, i12, i11, i13));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new h(kVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            y.d(viewGroup4, true);
            b(new j(viewGroup4));
        }
        return animatorC;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A0 = new int[2];
        this.B0 = false;
        this.C0 = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.d);
        boolean zA = AbstractC8958Xy7.a(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        n0(zA);
    }
}
