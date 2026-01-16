package ir.nasim.tgwidgets.editor.ui.Components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import ir.nasim.AbstractC12724f57;
import ir.nasim.C24687z23;
import ir.nasim.GU;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import ir.nasim.tgwidgets.editor.messenger.Utilities;

/* loaded from: classes7.dex */
public class BackupImageView extends View {
    protected ImageReceiver a;
    protected ImageReceiver b;
    protected int c;
    protected int d;
    public C21463b e;
    boolean f;
    protected boolean g;
    protected boolean h;
    public boolean i;

    public BackupImageView(Context context) {
        super(context);
        this.c = -1;
        this.d = -1;
        ImageReceiver imageReceiverC = c();
        this.a = imageReceiverC;
        imageReceiverC.v0(true);
        this.a.H0(new ImageReceiver.c() { // from class: ir.nasim.dW
            @Override // ir.nasim.tgwidgets.editor.messenger.ImageReceiver.c
            public final void a(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) throws InterruptedException {
                this.a.d(imageReceiver, z, z2, z3);
            }
        });
    }

    private void b() throws InterruptedException {
        Bitmap bitmapL;
        if (!this.g || this.b.l() != null || this.a.l() == null || (bitmapL = this.a.l()) == null || bitmapL.isRecycled()) {
            return;
        }
        this.b.V0(Utilities.j(bitmapL));
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(ImageReceiver imageReceiver, boolean z, boolean z2, boolean z3) throws InterruptedException {
        if (!z || z2) {
            return;
        }
        b();
    }

    protected ImageReceiver c() {
        return new ImageReceiver(this);
    }

    public void e() throws InterruptedException {
        if (this.g) {
            if (this.b.l() != null && !this.b.l().isRecycled()) {
                this.b.l().recycle();
            }
            this.b.V0(null);
            b();
        }
    }

    public ImageReceiver getImageReceiver() {
        return this.a;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws InterruptedException {
        super.onAttachedToWindow();
        this.f = true;
        this.a.q0();
        if (this.h) {
            this.b.q0();
        }
        C21463b c21463b = this.e;
        if (c21463b != null) {
            c21463b.c(this);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() throws InterruptedException {
        super.onDetachedFromWindow();
        this.f = false;
        this.a.s0();
        if (this.h) {
            this.b.s0();
        }
        C21463b c21463b = this.e;
        if (c21463b != null) {
            c21463b.t(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        C21463b c21463b = this.e;
        ImageReceiver imageReceiverL = c21463b != null ? c21463b.l() : this.a;
        if (imageReceiverL == null) {
            return;
        }
        int i2 = this.c;
        if (i2 == -1 || (i = this.d) == -1) {
            imageReceiverL.Y0(0.0f, 0.0f, getWidth(), getHeight());
            if (this.h) {
                this.b.Y0(0.0f, 0.0f, getWidth(), getHeight());
            }
        } else if (this.i) {
            imageReceiverL.Y0(0.0f, 0.0f, i2, i);
            if (this.h) {
                this.b.Y0(0.0f, 0.0f, this.c, this.d);
            }
        } else {
            float width = (getWidth() - this.c) / 2;
            int height = getHeight();
            imageReceiverL.Y0(width, (height - r3) / 2, this.c, this.d);
            if (this.h) {
                ImageReceiver imageReceiver = this.b;
                float width2 = (getWidth() - this.c) / 2;
                int height2 = getHeight();
                imageReceiver.Y0(width2, (height2 - r4) / 2, this.c, this.d);
            }
        }
        imageReceiverL.e(canvas);
        if (this.h) {
            this.b.e(canvas);
        }
    }

    public void setAspectFit(boolean z) {
        this.a.y0(z);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.C0(colorFilter);
    }

    public void setForUserOrChat(AbstractC12724f57 abstractC12724f57, GU gu) throws InterruptedException {
        this.a.L0(abstractC12724f57, gu);
        e();
    }

    public void setImage(C24687z23 c24687z23, String str, String str2, Drawable drawable, Object obj) throws InterruptedException {
        setImage(c24687z23, str, null, null, drawable, null, str2, 0, obj);
    }

    public void setImageBitmap(Bitmap bitmap) throws InterruptedException {
        this.a.V0(bitmap);
        e();
    }

    public void setImageDrawable(Drawable drawable) throws InterruptedException {
        this.a.W0(drawable);
        e();
    }

    public void setImageResource(int i) {
        this.a.W0(getResources().getDrawable(i));
        invalidate();
        e();
    }

    public void setLayerNum(int i) {
        this.a.d1(i);
    }

    public void setOrientation(int i, boolean z) {
        this.a.h1(i, z);
    }

    public void setRoundRadius(int i) {
        this.a.k1(i);
        if (this.h) {
            this.b.k1(i);
        }
        invalidate();
    }

    public void setSize(int i, int i2) {
        this.c = i;
        this.d = i2;
        invalidate();
    }

    public void setImage(C24687z23 c24687z23, String str, Drawable drawable, Object obj) throws InterruptedException {
        setImage(c24687z23, str, null, null, drawable, null, null, 0, obj);
    }

    public void setOrientation(int i, int i2, boolean z) {
        this.a.g1(i, i2, z);
    }

    public void setImage(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, Drawable drawable, Object obj) throws InterruptedException {
        this.a.S0(c24687z23, str, c24687z232, str2, null, null, drawable, 0L, null, obj, 1);
        e();
    }

    public void setImage(C24687z23 c24687z23, String str, Bitmap bitmap, Object obj) throws InterruptedException {
        setImage(c24687z23, str, null, null, null, bitmap, null, 0, obj);
    }

    public void setImageResource(int i, int i2) throws InterruptedException, Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.MULTIPLY));
        }
        this.a.W0(drawable);
        invalidate();
        e();
    }

    public void setRoundRadius(int i, int i2, int i3, int i4) {
        this.a.l1(i, i2, i3, i4);
        if (this.h) {
            this.b.l1(i, i2, i3, i4);
        }
        invalidate();
    }

    public void setImage(C24687z23 c24687z23, String str, Drawable drawable, int i, Object obj) throws InterruptedException {
        setImage(c24687z23, str, null, null, drawable, null, null, i, obj);
    }

    public void setImage(C24687z23 c24687z23, String str, Bitmap bitmap, int i, int i2, Object obj) throws InterruptedException {
        BackupImageView backupImageView;
        BitmapDrawable bitmapDrawable;
        if (bitmap != null) {
            backupImageView = this;
            bitmapDrawable = new BitmapDrawable((Resources) null, bitmap);
        } else {
            backupImageView = this;
            bitmapDrawable = null;
        }
        backupImageView.a.Q0(c24687z23, str, null, null, bitmapDrawable, i, null, obj, i2);
        e();
    }

    public void setImage(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, int i, Object obj) throws InterruptedException {
        setImage(c24687z23, str, c24687z232, str2, null, null, null, i, obj);
    }

    public void setImage(String str, String str2, Drawable drawable) {
        setImage(C24687z23.g(str), str2, null, null, drawable, null, null, 0, null);
    }

    public void setImage(String str, String str2, String str3, String str4) throws InterruptedException {
        setImage(C24687z23.g(str), str2, C24687z23.g(str3), str4, null, null, null, 0, null);
    }

    public void setImage(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, Drawable drawable, Bitmap bitmap, String str3, int i, Object obj) throws InterruptedException {
        BackupImageView backupImageView;
        Drawable bitmapDrawable;
        if (bitmap != null) {
            backupImageView = this;
            bitmapDrawable = new BitmapDrawable((Resources) null, bitmap);
        } else {
            backupImageView = this;
            bitmapDrawable = drawable;
        }
        backupImageView.a.Q0(c24687z23, str, c24687z232, str2, bitmapDrawable, i, str3, obj, 0);
        e();
    }

    public void setImage(C24687z23 c24687z23, String str, C24687z23 c24687z232, String str2, String str3, long j, int i, Object obj) throws InterruptedException {
        this.a.Q0(c24687z23, str, c24687z232, str2, null, j, str3, obj, i);
        e();
    }
}
