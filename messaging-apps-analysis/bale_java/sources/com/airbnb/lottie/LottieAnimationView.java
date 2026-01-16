package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import ir.nasim.AbstractC16500lN7;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.AbstractC20536sA5;
import ir.nasim.AbstractC24809zE5;
import ir.nasim.AbstractC3581Bl7;
import ir.nasim.AbstractC6219Mr3;
import ir.nasim.AbstractC8622Wt2;
import ir.nasim.AbstractC9594aE;
import ir.nasim.C10255bL3;
import ir.nasim.C13505gL3;
import ir.nasim.C23677xK3;
import ir.nasim.C35;
import ir.nasim.C5023Ho3;
import ir.nasim.DC6;
import ir.nasim.GL;
import ir.nasim.InterfaceC9661aL3;
import ir.nasim.JI3;
import ir.nasim.JK3;
import ir.nasim.Q03;
import ir.nasim.QN5;
import ir.nasim.SK3;
import ir.nasim.WK3;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public class LottieAnimationView extends AppCompatImageView {
    private static final String q = "LottieAnimationView";
    private static final WK3 r = new WK3() { // from class: ir.nasim.pK3
        @Override // ir.nasim.WK3
        public final void a(Object obj) {
            LottieAnimationView.u((Throwable) obj);
        }
    };
    private final WK3 d;
    private final WK3 e;
    private WK3 f;
    private int g;
    private final q h;
    private String i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private final Set n;
    private final Set o;
    private s p;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        String a;
        int b;
        float c;
        boolean d;
        String e;
        int f;
        int g;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, com.airbnb.lottie.a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.d ? 1 : 0);
            parcel.writeString(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            this.d = parcel.readInt() == 1;
            this.e = parcel.readString();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }
    }

    private enum a {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    private static class b implements WK3 {
        private final WeakReference a;

        public b(LottieAnimationView lottieAnimationView) {
            this.a = new WeakReference(lottieAnimationView);
        }

        @Override // ir.nasim.WK3
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.a.get();
            if (lottieAnimationView == null) {
                return;
            }
            if (lottieAnimationView.g != 0) {
                lottieAnimationView.setImageResource(lottieAnimationView.g);
            }
            (lottieAnimationView.f == null ? LottieAnimationView.r : lottieAnimationView.f).a(th);
        }
    }

    private static class c implements WK3 {
        private final WeakReference a;

        public c(LottieAnimationView lottieAnimationView) {
            this.a = new WeakReference(lottieAnimationView);
        }

        @Override // ir.nasim.WK3
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C23677xK3 c23677xK3) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.a.get();
            if (lottieAnimationView == null) {
                return;
            }
            lottieAnimationView.setComposition(c23677xK3);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.d = new c(this);
        this.e = new b(this);
        this.g = 0;
        this.h = new q();
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = new HashSet();
        this.o = new HashSet();
        q(null, AbstractC20536sA5.lottieAnimationViewStyle);
    }

    private void A(float f, boolean z) {
        if (z) {
            this.n.add(a.SET_PROGRESS);
        }
        this.h.k1(f);
    }

    private void l() {
        s sVar = this.p;
        if (sVar != null) {
            sVar.k(this.d);
            this.p.j(this.e);
        }
    }

    private void m() {
        this.h.x();
    }

    private s o(final String str) {
        return isInEditMode() ? new s(new Callable() { // from class: ir.nasim.oK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.s(str);
            }
        }, true) : this.m ? JK3.m(getContext(), str) : JK3.n(getContext(), str, null);
    }

    private s p(final int i) {
        return isInEditMode() ? new s(new Callable() { // from class: ir.nasim.qK3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.a.t(i);
            }
        }, true) : this.m ? JK3.B(getContext(), i) : JK3.C(getContext(), i, null);
    }

    private void q(AttributeSet attributeSet, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC24809zE5.LottieAnimationView, i, 0);
        this.m = typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_cacheComposition, true);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_rawRes);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_fileName);
        boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_url);
        if (zHasValue && zHasValue2) {
            throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
        }
        if (zHasValue) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(AbstractC24809zE5.LottieAnimationView_lottie_rawRes, 0);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else if (zHasValue2) {
            String string2 = typedArrayObtainStyledAttributes.getString(AbstractC24809zE5.LottieAnimationView_lottie_fileName);
            if (string2 != null) {
                setAnimation(string2);
            }
        } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(AbstractC24809zE5.LottieAnimationView_lottie_url)) != null) {
            setAnimationFromUrl(string);
        }
        setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(AbstractC24809zE5.LottieAnimationView_lottie_fallbackRes, 0));
        if (typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_autoPlay, false)) {
            this.l = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_loop, false)) {
            this.h.m1(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(AbstractC24809zE5.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(AbstractC24809zE5.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(AbstractC24809zE5.LottieAnimationView_lottie_speed, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_clipToCompositionBounds)) {
            setClipToCompositionBounds(typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_clipToCompositionBounds, true));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_clipTextToBoundingBox)) {
            setClipTextToBoundingBox(typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_clipTextToBoundingBox, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_defaultFontFileExtension)) {
            setDefaultFontFileExtension(typedArrayObtainStyledAttributes.getString(AbstractC24809zE5.LottieAnimationView_lottie_defaultFontFileExtension));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(AbstractC24809zE5.LottieAnimationView_lottie_imageAssetsFolder));
        A(typedArrayObtainStyledAttributes.getFloat(AbstractC24809zE5.LottieAnimationView_lottie_progress, 0.0f), typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_progress));
        n(typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        setApplyingOpacityToLayersEnabled(typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_applyOpacityToLayers, false));
        setApplyingShadowToLayersEnabled(typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_applyShadowToLayers, true));
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_colorFilter)) {
            j(new C5023Ho3("**"), InterfaceC9661aL3.K, new C13505gL3(new DC6(AbstractC9594aE.a(getContext(), typedArrayObtainStyledAttributes.getResourceId(AbstractC24809zE5.LottieAnimationView_lottie_colorFilter, -1)).getDefaultColor())));
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_renderMode)) {
            int i2 = AbstractC24809zE5.LottieAnimationView_lottie_renderMode;
            QN5 qn5 = QN5.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i2, qn5.ordinal());
            if (iOrdinal >= QN5.values().length) {
                iOrdinal = qn5.ordinal();
            }
            setRenderMode(QN5.values()[iOrdinal]);
        }
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_asyncUpdates)) {
            int i3 = AbstractC24809zE5.LottieAnimationView_lottie_asyncUpdates;
            GL gl = GL.AUTOMATIC;
            int iOrdinal2 = typedArrayObtainStyledAttributes.getInt(i3, gl.ordinal());
            if (iOrdinal2 >= QN5.values().length) {
                iOrdinal2 = gl.ordinal();
            }
            setAsyncUpdates(GL.values()[iOrdinal2]);
        }
        setIgnoreDisabledSystemAnimations(typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC24809zE5.LottieAnimationView_lottie_useCompositionFrameRate)) {
            setUseCompositionFrameRate(typedArrayObtainStyledAttributes.getBoolean(AbstractC24809zE5.LottieAnimationView_lottie_useCompositionFrameRate, false));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C10255bL3 s(String str) {
        return this.m ? JK3.o(getContext(), str) : JK3.p(getContext(), str, null);
    }

    private void setCompositionTask(s sVar) {
        C10255bL3 c10255bL3E = sVar.e();
        q qVar = this.h;
        if (c10255bL3E != null && qVar == getDrawable() && qVar.N() == c10255bL3E.b()) {
            return;
        }
        this.n.add(a.SET_ANIMATION);
        m();
        l();
        this.p = sVar.d(this.d).c(this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C10255bL3 t(int i) {
        return this.m ? JK3.D(getContext(), i) : JK3.E(getContext(), i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(Throwable th) {
        if (!AbstractC16500lN7.k(th)) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
        JI3.d("Unable to load composition.", th);
    }

    private void z() {
        boolean zR = r();
        setImageDrawable(null);
        setImageDrawable(this.h);
        if (zR) {
            this.h.I0();
        }
    }

    public GL getAsyncUpdates() {
        return this.h.I();
    }

    public boolean getAsyncUpdatesEnabled() {
        return this.h.J();
    }

    public boolean getClipTextToBoundingBox() {
        return this.h.L();
    }

    public boolean getClipToCompositionBounds() {
        return this.h.M();
    }

    public C23677xK3 getComposition() {
        Drawable drawable = getDrawable();
        q qVar = this.h;
        if (drawable == qVar) {
            return qVar.N();
        }
        return null;
    }

    public long getDuration() {
        C23677xK3 composition = getComposition();
        if (composition != null) {
            return (long) composition.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.h.Q();
    }

    public String getImageAssetsFolder() {
        return this.h.S();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.h.U();
    }

    public float getMaxFrame() {
        return this.h.W();
    }

    public float getMinFrame() {
        return this.h.X();
    }

    public C35 getPerformanceTracker() {
        return this.h.Y();
    }

    public float getProgress() {
        return this.h.Z();
    }

    public QN5 getRenderMode() {
        return this.h.a0();
    }

    public int getRepeatCount() {
        return this.h.b0();
    }

    public int getRepeatMode() {
        return this.h.c0();
    }

    public float getSpeed() {
        return this.h.d0();
    }

    public void i(Animator.AnimatorListener animatorListener) {
        this.h.s(animatorListener);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof q) && ((q) drawable).a0() == QN5.SOFTWARE) {
            this.h.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        q qVar = this.h;
        if (drawable2 == qVar) {
            super.invalidateDrawable(qVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j(C5023Ho3 c5023Ho3, Object obj, C13505gL3 c13505gL3) {
        this.h.t(c5023Ho3, obj, c13505gL3);
    }

    public void k() {
        this.l = false;
        this.n.add(a.PLAY_OPTION);
        this.h.w();
    }

    public void n(boolean z) {
        this.h.E(SK3.MergePathsApi19, z);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.l) {
            return;
        }
        this.h.F0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.i = savedState.a;
        Set set = this.n;
        a aVar = a.SET_ANIMATION;
        if (!set.contains(aVar) && !TextUtils.isEmpty(this.i)) {
            setAnimation(this.i);
        }
        this.j = savedState.b;
        if (!this.n.contains(aVar) && (i = this.j) != 0) {
            setAnimation(i);
        }
        if (!this.n.contains(a.SET_PROGRESS)) {
            A(savedState.c, false);
        }
        if (!this.n.contains(a.PLAY_OPTION) && savedState.d) {
            x();
        }
        if (!this.n.contains(a.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.e);
        }
        if (!this.n.contains(a.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.f);
        }
        if (this.n.contains(a.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(savedState.g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.i;
        savedState.b = this.j;
        savedState.c = this.h.Z();
        savedState.d = this.h.i0();
        savedState.e = this.h.S();
        savedState.f = this.h.c0();
        savedState.g = this.h.b0();
        return savedState;
    }

    public boolean r() {
        return this.h.h0();
    }

    public void setAnimation(int i) {
        this.j = i;
        this.i = null;
        setCompositionTask(p(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.m ? JK3.F(getContext(), str) : JK3.G(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.h.K0(z);
    }

    public void setApplyingShadowToLayersEnabled(boolean z) {
        this.h.L0(z);
    }

    public void setAsyncUpdates(GL gl) {
        this.h.M0(gl);
    }

    public void setCacheComposition(boolean z) {
        this.m = z;
    }

    public void setClipTextToBoundingBox(boolean z) {
        this.h.N0(z);
    }

    public void setClipToCompositionBounds(boolean z) {
        this.h.O0(z);
    }

    public void setComposition(C23677xK3 c23677xK3) {
        if (AbstractC6219Mr3.a) {
            Log.v(q, "Set Composition \n" + c23677xK3);
        }
        this.h.setCallback(this);
        this.k = true;
        boolean zP0 = this.h.P0(c23677xK3);
        if (this.l) {
            this.h.F0();
        }
        this.k = false;
        if (getDrawable() != this.h || zP0) {
            if (!zP0) {
                z();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.o.iterator();
            if (it.hasNext()) {
                AbstractC18350oW3.a(it.next());
                throw null;
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.h.Q0(str);
    }

    public void setFailureListener(WK3 wk3) {
        this.f = wk3;
    }

    public void setFallbackResource(int i) {
        this.g = i;
    }

    public void setFontAssetDelegate(AbstractC8622Wt2 abstractC8622Wt2) {
        this.h.R0(abstractC8622Wt2);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.h.S0(map);
    }

    public void setFrame(int i) {
        this.h.T0(i);
    }

    @Deprecated
    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.h.U0(z);
    }

    public void setImageAssetDelegate(Q03 q03) {
        this.h.V0(q03);
    }

    public void setImageAssetsFolder(String str) {
        this.h.W0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.j = 0;
        this.i = null;
        l();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.j = 0;
        this.i = null;
        l();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        this.j = 0;
        this.i = null;
        l();
        super.setImageResource(i);
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.h.X0(z);
    }

    public void setMaxFrame(int i) {
        this.h.Y0(i);
    }

    public void setMaxProgress(float f) {
        this.h.a1(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.h.c1(str);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.h.e1(f, f2);
    }

    public void setMinFrame(int i) {
        this.h.f1(i);
    }

    public void setMinProgress(float f) {
        this.h.h1(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.h.i1(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.h.j1(z);
    }

    public void setProgress(float f) {
        A(f, true);
    }

    public void setRenderMode(QN5 qn5) {
        this.h.l1(qn5);
    }

    public void setRepeatCount(int i) {
        this.n.add(a.SET_REPEAT_COUNT);
        this.h.m1(i);
    }

    public void setRepeatMode(int i) {
        this.n.add(a.SET_REPEAT_MODE);
        this.h.n1(i);
    }

    public void setSafeMode(boolean z) {
        this.h.o1(z);
    }

    public void setSpeed(float f) {
        this.h.p1(f);
    }

    public void setTextDelegate(AbstractC3581Bl7 abstractC3581Bl7) {
        this.h.q1(abstractC3581Bl7);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.h.r1(z);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        q qVar;
        if (!this.k && drawable == (qVar = this.h) && qVar.h0()) {
            w();
        } else if (!this.k && (drawable instanceof q)) {
            q qVar2 = (q) drawable;
            if (qVar2.h0()) {
                qVar2.E0();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void v(boolean z) {
        this.h.m1(z ? -1 : 0);
    }

    public void w() {
        this.l = false;
        this.h.E0();
    }

    public void x() {
        this.n.add(a.PLAY_OPTION);
        this.h.F0();
    }

    public void y() {
        this.n.add(a.PLAY_OPTION);
        this.h.I0();
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.h.Z0(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.h.d1(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.h.g1(str);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.h.b1(i, i2);
    }

    public void setAnimation(String str) {
        this.i = str;
        this.j = 0;
        setCompositionTask(o(str));
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(JK3.G(getContext(), str, str2));
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(JK3.r(inputStream, str));
    }

    public void setAnimation(ZipInputStream zipInputStream, String str) {
        setCompositionTask(JK3.I(zipInputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = new c(this);
        this.e = new b(this);
        this.g = 0;
        this.h = new q();
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = new HashSet();
        this.o = new HashSet();
        q(attributeSet, AbstractC20536sA5.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new c(this);
        this.e = new b(this);
        this.g = 0;
        this.h = new q();
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = new HashSet();
        this.o = new HashSet();
        q(attributeSet, i);
    }
}
