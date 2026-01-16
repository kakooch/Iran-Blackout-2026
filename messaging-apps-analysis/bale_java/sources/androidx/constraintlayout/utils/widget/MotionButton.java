package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import ir.nasim.SE5;

/* loaded from: classes2.dex */
public class MotionButton extends AppCompatButton {
    private float d;
    private float e;
    private Path f;
    ViewOutlineProvider g;
    RectF h;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), (Math.min(r3, r4) * MotionButton.this.d) / 2.0f);
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.e);
        }
    }

    public MotionButton(Context context) {
        super(context);
        this.d = 0.0f;
        this.e = Float.NaN;
        c(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == SE5.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.e;
    }

    public float getRoundPercent() {
        return this.d;
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.e = f;
            float f2 = this.d;
            this.d = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.e != f;
        this.e = f;
        if (f != 0.0f) {
            if (this.f == null) {
                this.f = new Path();
            }
            if (this.h == null) {
                this.h = new RectF();
            }
            if (this.g == null) {
                b bVar = new b();
                this.g = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f.reset();
            Path path = this.f;
            RectF rectF = this.h;
            float f3 = this.e;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.d != f;
        this.d = f;
        if (f != 0.0f) {
            if (this.f == null) {
                this.f = new Path();
            }
            if (this.h == null) {
                this.h = new RectF();
            }
            if (this.g == null) {
                a aVar = new a();
                this.g = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.d) / 2.0f;
            this.h.set(0.0f, 0.0f, width, height);
            this.f.reset();
            this.f.addRoundRect(this.h, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        this.e = Float.NaN;
        c(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.0f;
        this.e = Float.NaN;
        c(context, attributeSet);
    }
}
