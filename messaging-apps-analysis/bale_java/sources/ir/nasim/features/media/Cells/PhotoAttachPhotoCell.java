package ir.nasim.features.media.Cells;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.KB5;
import ir.nasim.components.checkbox.view.CheckBox;
import ir.nasim.features.media.components.BackupImageView;
import ir.nasim.features.media.components.PhotoViewerAbs;

/* loaded from: classes6.dex */
public class PhotoAttachPhotoCell extends FrameLayout {
    private static Rect g = new Rect();
    private BackupImageView a;
    private FrameLayout b;
    private CheckBox c;
    private boolean d;
    private boolean e;
    private AbstractC14815iX3.b f;

    public interface a {
    }

    public PhotoAttachPhotoCell(Context context) {
        super(context);
        BackupImageView backupImageView = new BackupImageView(context);
        this.a = backupImageView;
        addView(backupImageView, C14433hu3.a(80, 80.0f));
        FrameLayout frameLayout = new FrameLayout(context);
        this.b = frameLayout;
        addView(frameLayout, C14433hu3.b(42, 42.0f, 51, 38.0f, 0.0f, 0.0f, 0.0f));
        CheckBox checkBox = new CheckBox(context, KB5.checkbig);
        this.c = checkBox;
        checkBox.setSize(30);
        this.c.setCheckOffset(C22078ud6.a(1.0f));
        this.c.setDrawBackground(true);
        this.c.setColor(C5495Jo7.a.t2());
        addView(this.c, C14433hu3.b(30, 30.0f, 51, 46.0f, 4.0f, 0.0f, 0.0f));
        this.c.setVisibility(0);
    }

    public CheckBox getCheckBox() {
        return this.c;
    }

    public BackupImageView getImageView() {
        return this.a;
    }

    public AbstractC14815iX3.b getPhotoEntry() {
        return this.f;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(C22078ud6.a((this.d ? 0 : 6) + 80), 1073741824), View.MeasureSpec.makeMeasureSpec(C22078ud6.a(80.0f), 1073741824));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.widget.FrameLayout r0 = r5.b
            android.graphics.Rect r1 = ir.nasim.features.media.Cells.PhotoAttachPhotoCell.g
            r0.getHitRect(r1)
            int r0 = r6.getAction()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L27
            android.graphics.Rect r0 = ir.nasim.features.media.Cells.PhotoAttachPhotoCell.g
            float r3 = r6.getX()
            int r3 = (int) r3
            float r4 = r6.getY()
            int r4 = (int) r4
            boolean r0 = r0.contains(r3, r4)
            if (r0 == 0) goto L6b
            r5.e = r1
            r5.invalidate()
            goto L6c
        L27:
            boolean r0 = r5.e
            if (r0 == 0) goto L6b
            int r0 = r6.getAction()
            if (r0 == r1) goto L5d
            int r0 = r6.getAction()
            r1 = 3
            if (r0 != r1) goto L3e
            r5.e = r2
            r5.invalidate()
            goto L6b
        L3e:
            int r0 = r6.getAction()
            r1 = 2
            if (r0 != r1) goto L6b
            android.graphics.Rect r0 = ir.nasim.features.media.Cells.PhotoAttachPhotoCell.g
            float r1 = r6.getX()
            int r1 = (int) r1
            float r3 = r6.getY()
            int r3 = (int) r3
            boolean r0 = r0.contains(r1, r3)
            if (r0 != 0) goto L6b
            r5.e = r2
            r5.invalidate()
            goto L6b
        L5d:
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r1)
            r5.e = r2
            r5.playSoundEffect(r2)
            r6 = 0
            throw r6
        L6b:
            r1 = r2
        L6c:
            if (r1 != 0) goto L72
            boolean r1 = super.onTouchEvent(r6)
        L72:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.features.media.Cells.PhotoAttachPhotoCell.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z, boolean z2) {
        this.c.setChecked(z, z2);
    }

    public void setDelegate(a aVar) {
    }

    public void setPhotoEntry(AbstractC14815iX3.b bVar, boolean z) {
        this.e = false;
        this.f = bVar;
        this.d = z;
        String str = bVar.b;
        if (str != null) {
            this.a.setImage(str, (String) null, getResources().getDrawable(KB5.nophotos));
        } else if (bVar.A != null) {
            this.a.setOrientation(bVar.B, true);
            this.a.setImage("thumb://" + this.f.u + ":" + this.f.A, (String) null, getResources().getDrawable(KB5.nophotos));
        } else {
            this.a.setImageResource(KB5.nophotos);
        }
        boolean zIsShowingImage = PhotoViewerAbs.getInstance().isShowingImage(this.f.A);
        this.a.getImageReceiver().Z(!zIsShowingImage, true);
        this.c.setVisibility(zIsShowingImage ? 4 : 0);
        requestLayout();
    }
}
