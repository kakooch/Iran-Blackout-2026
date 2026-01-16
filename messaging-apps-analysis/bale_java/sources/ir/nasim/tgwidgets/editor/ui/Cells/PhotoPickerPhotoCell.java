package ir.nasim.tgwidgets.editor.ui.Cells;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ir.nasim.AbstractC13840gu3;
import ir.nasim.AbstractC23598xB5;
import ir.nasim.FH3;
import ir.nasim.TD5;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.MediaController;
import ir.nasim.tgwidgets.editor.ui.ActionBar.m;
import ir.nasim.tgwidgets.editor.ui.Components.BackupImageView;
import ir.nasim.tgwidgets.editor.ui.Components.CheckBox2;

/* loaded from: classes7.dex */
public class PhotoPickerPhotoCell extends FrameLayout {
    public BackupImageView a;
    public FrameLayout b;
    public CheckBox2 c;
    public TextView d;
    public FrameLayout e;
    private int f;
    private int g;
    private Paint h;

    class a extends FrameLayout {
        private Path a;
        float[] b;
        private RectF c;
        private Paint d;

        a(Context context) {
            super(context);
            this.a = new Path();
            this.b = new float[8];
            this.c = new RectF();
            this.d = new Paint(1);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            this.c.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
            float[] fArr = this.b;
            fArr[3] = 0.0f;
            fArr[2] = 0.0f;
            fArr[1] = 0.0f;
            fArr[0] = 0.0f;
            float F = AbstractC21455b.F(4.0f);
            fArr[7] = F;
            fArr[6] = F;
            fArr[5] = F;
            fArr[4] = F;
            this.a.reset();
            this.a.addRoundRect(this.c, this.b, Path.Direction.CW);
            this.a.close();
            this.d.setColor(2130706432);
            canvas.drawPath(this.a, this.d);
        }
    }

    public PhotoPickerPhotoCell(Context context) {
        super(context);
        this.h = new Paint();
        setWillNotDraw(false);
        BackupImageView backupImageView = new BackupImageView(context);
        this.a = backupImageView;
        backupImageView.setRoundRadius(AbstractC21455b.F(4.0f));
        addView(this.a, AbstractC13840gu3.b(-1, -1.0f));
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        addView(frameLayout, AbstractC13840gu3.d(42, 42, 53));
        a aVar = new a(context);
        this.e = aVar;
        aVar.setWillNotDraw(false);
        this.e.setPadding(AbstractC21455b.F(3.0f), 0, AbstractC21455b.F(3.0f), 0);
        addView(this.e, AbstractC13840gu3.d(-1, 16, 83));
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(AbstractC23598xB5.ic_video);
        this.e.addView(imageView, AbstractC13840gu3.d(-2, -2, 19));
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setTextColor(-1);
        this.d.setTextSize(1, 12.0f);
        this.d.setImportantForAccessibility(2);
        this.e.addView(this.d, AbstractC13840gu3.c(-2, -2.0f, 19, 18.0f, -0.7f, 0.0f, 0.0f));
        CheckBox2 checkBox2 = new CheckBox2(context, 24);
        this.c = checkBox2;
        checkBox2.setDrawBackgroundAsArc(11);
        this.c.setColor(m.C8, m.D8, m.B8);
        addView(this.c, AbstractC13840gu3.c(26, 26.0f, 51, 55.0f, 4.0f, 0.0f, 0.0f));
        this.c.setVisibility(0);
        setFocusable(true);
    }

    public void a() {
        this.c.setColor(m.C8, m.D8, m.B8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f + this.g, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f, 1073741824));
    }

    public void setChecked(int i, boolean z, boolean z2) {
        this.c.setChecked(i, z, z2);
    }

    public void setImage(MediaController.m mVar) throws InterruptedException, Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(AbstractC23598xB5.nophotos);
        String str = mVar.b;
        if (str != null) {
            this.a.setImage(str, null, drawable);
            return;
        }
        if (mVar.A == null) {
            this.a.setImageDrawable(drawable);
            return;
        }
        this.a.setOrientation(mVar.B, mVar.C, true);
        if (!mVar.D) {
            this.e.setVisibility(4);
            setContentDescription(FH3.E("AttachPhoto", TD5.tgwidget_AttachPhoto));
            this.a.setImage("thumb://" + mVar.u + ":" + mVar.A, null, drawable);
            return;
        }
        this.e.setVisibility(0);
        this.d.setText(AbstractC21455b.O(mVar.w));
        setContentDescription(FH3.E("AttachVideo", TD5.tgwidget_AttachVideo) + ", " + FH3.n(mVar.w));
        this.a.setImage("vthumb://" + mVar.u + ":" + mVar.A, null, drawable);
    }

    public void setItemWidth(int i, int i2) {
        this.f = i;
        this.g = i2;
        ((FrameLayout.LayoutParams) this.b.getLayoutParams()).rightMargin = i2;
        ((FrameLayout.LayoutParams) this.a.getLayoutParams()).rightMargin = i2;
        ((FrameLayout.LayoutParams) this.e.getLayoutParams()).rightMargin = i2;
    }

    public void setNum(int i) {
        this.c.setNum(i);
    }

    public void setImage(MediaController.o oVar) throws Resources.NotFoundException {
        getResources().getDrawable(AbstractC23598xB5.nophotos);
        throw null;
    }
}
