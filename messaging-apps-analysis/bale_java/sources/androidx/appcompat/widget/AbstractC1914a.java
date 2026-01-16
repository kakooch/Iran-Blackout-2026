package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC12990fW7;
import ir.nasim.AbstractC15790kA5;
import ir.nasim.C23798xX7;
import ir.nasim.HE5;
import ir.nasim.InterfaceC24982zX7;

/* renamed from: androidx.appcompat.widget.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC1914a extends ViewGroup {
    protected final C0015a a;
    protected final Context b;
    protected ActionMenuView c;
    protected ActionMenuPresenter d;
    protected int e;
    protected C23798xX7 f;
    private boolean g;
    private boolean h;

    /* renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    protected class C0015a implements InterfaceC24982zX7 {
        private boolean a = false;
        int b;

        protected C0015a() {
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void a(View view) {
            this.a = true;
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void b(View view) {
            if (this.a) {
                return;
            }
            AbstractC1914a abstractC1914a = AbstractC1914a.this;
            abstractC1914a.f = null;
            AbstractC1914a.super.setVisibility(this.b);
        }

        @Override // ir.nasim.InterfaceC24982zX7
        public void c(View view) {
            AbstractC1914a.super.setVisibility(0);
            this.a = false;
        }

        public C0015a d(C23798xX7 c23798xX7, int i) {
            AbstractC1914a.this.f = c23798xX7;
            this.b = i;
            return this;
        }
    }

    AbstractC1914a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new C0015a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(AbstractC15790kA5.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, RecyclerView.UNDEFINED_DURATION), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public C23798xX7 f(int i, long j) {
        C23798xX7 c23798xX7 = this.f;
        if (c23798xX7 != null) {
            c23798xX7.c();
        }
        if (i != 0) {
            C23798xX7 c23798xX7B = AbstractC12990fW7.e(this).b(0.0f);
            c23798xX7B.f(j);
            c23798xX7B.h(this.a.d(c23798xX7B, i));
            return c23798xX7B;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        C23798xX7 c23798xX7B2 = AbstractC12990fW7.e(this).b(1.0f);
        c23798xX7B2.f(j);
        c23798xX7B2.h(this.a.d(c23798xX7B2, i));
        return c23798xX7B2;
    }

    public int getAnimatedVisibility() {
        return this.f != null ? this.a.b : getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, HE5.ActionBar, AbstractC15790kA5.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(HE5.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.I(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            C23798xX7 c23798xX7 = this.f;
            if (c23798xX7 != null) {
                c23798xX7.c();
            }
            super.setVisibility(i);
        }
    }
}
