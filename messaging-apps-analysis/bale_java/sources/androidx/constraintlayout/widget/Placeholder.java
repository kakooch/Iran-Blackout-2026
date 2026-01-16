package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C16651le1;
import ir.nasim.SE5;

/* loaded from: classes2.dex */
public class Placeholder extends View {
    private int a;
    private View b;
    private int c;

    public Placeholder(Context context) {
        super(context);
        this.a = -1;
        this.b = null;
        this.c = 4;
        a(null);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.c);
        this.a = -1;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.ConstraintLayout_placeholder);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.ConstraintLayout_placeholder_content) {
                    this.a = typedArrayObtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == SE5.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.c = typedArrayObtainStyledAttributes.getInt(index, this.c);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams2.u0.i1(0);
        C16651le1.b bVarC = layoutParams.u0.C();
        C16651le1.b bVar = C16651le1.b.FIXED;
        if (bVarC != bVar) {
            layoutParams.u0.j1(layoutParams2.u0.X());
        }
        if (layoutParams.u0.U() != bVar) {
            layoutParams.u0.K0(layoutParams2.u0.z());
        }
        layoutParams2.u0.i1(8);
    }

    public void c(ConstraintLayout constraintLayout) {
        if (this.a == -1 && !isInEditMode()) {
            setVisibility(this.c);
        }
        View viewFindViewById = constraintLayout.findViewById(this.a);
        this.b = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.LayoutParams) viewFindViewById.getLayoutParams()).i0 = true;
            this.b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.b;
    }

    public int getEmptyVisibility() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(Separators.QUESTION, 0, 1, rect);
            canvas.drawText(Separators.QUESTION, ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View viewFindViewById;
        if (this.a == i) {
            return;
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.b.getLayoutParams()).i0 = false;
            this.b = null;
        }
        this.a = i;
        if (i == -1 || (viewFindViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.c = i;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = -1;
        this.b = null;
        this.c = 4;
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = -1;
        this.b = null;
        this.c = 4;
        a(attributeSet);
    }
}
