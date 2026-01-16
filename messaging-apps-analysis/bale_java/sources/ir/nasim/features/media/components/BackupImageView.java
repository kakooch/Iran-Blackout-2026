package ir.nasim.features.media.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import ir.nasim.AbstractC13360g57;
import ir.nasim.AbstractC4761Gl2;
import ir.nasim.S23;

/* loaded from: classes6.dex */
public class BackupImageView extends View {
    private S23 a;
    private int b;
    private int c;

    public BackupImageView(Context context) {
        super(context);
        this.b = -1;
        this.c = -1;
        a();
    }

    private void a() {
        this.a = new S23(this);
    }

    public S23 getImageReceiver() {
        return this.a;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.a.G();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.H();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.b == -1 || this.c == -1) {
            this.a.R(0, 0, getWidth(), getHeight());
        } else {
            S23 s23 = this.a;
            int width = (getWidth() - this.b) / 2;
            int height = getHeight();
            int i = this.c;
            s23.R(width, (height - i) / 2, this.b, i);
        }
        this.a.c(canvas);
    }

    public void setImage(AbstractC13360g57 abstractC13360g57, String str, Drawable drawable) {
        setImage(abstractC13360g57, null, str, drawable, null, null, null, null, 0);
    }

    public void setImageResource(int i) {
        this.a.P(getResources().getDrawable(i));
    }

    public void setOrientation(int i, boolean z) {
        this.a.U(i, z);
    }

    public void setImage(String str, String str2, Drawable drawable) {
        setImage(null, str, str2, drawable, null, null, null, null, 0);
    }

    public void setImage(AbstractC13360g57 abstractC13360g57, String str, String str2, Drawable drawable, Bitmap bitmap, AbstractC4761Gl2 abstractC4761Gl2, String str3, String str4, int i) {
        BackupImageView backupImageView;
        Drawable bitmapDrawable;
        if (bitmap != null) {
            backupImageView = this;
            bitmapDrawable = new BitmapDrawable((Resources) null, bitmap);
        } else {
            backupImageView = this;
            bitmapDrawable = drawable;
        }
        backupImageView.a.M(abstractC13360g57, str, str2, bitmapDrawable, abstractC4761Gl2, str3, i, str4, false);
    }

    public BackupImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.c = -1;
        a();
    }

    public BackupImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        this.c = -1;
        a();
    }
}
