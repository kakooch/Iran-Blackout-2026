package ir.nasim.features.media.components;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC14815iX3;
import ir.nasim.AbstractC7426Rr;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C5161Id6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.KB5;

/* loaded from: classes6.dex */
public class PhotoPickerAlbumsCell extends FrameLayout {
    private b[] a;
    private AbstractC14815iX3.a[] b;
    private int c;
    private PhotoPickerAlbumsCellDelegate d;

    public interface PhotoPickerAlbumsCellDelegate {
        void didSelectAlbum(AbstractC14815iX3.a aVar);
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoPickerAlbumsCell.this.d != null) {
                PhotoPickerAlbumsCell.this.d.didSelectAlbum(PhotoPickerAlbumsCell.this.b[((Integer) view.getTag()).intValue()]);
            }
        }
    }

    private class b extends FrameLayout {
        private BackupImageView a;
        private TextView b;
        private TextView c;
        private View d;

        public b(Context context) {
            super(context);
            BackupImageView backupImageView = new BackupImageView(context);
            this.a = backupImageView;
            addView(backupImageView, C14433hu3.a(-1, -1.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            linearLayout.setBackgroundColor(c5495Jo7.y0(c5495Jo7.g0(), 50));
            addView(linearLayout, C14433hu3.c(-1, 28, 83));
            TextView textView = new TextView(context);
            this.b = textView;
            textView.setTypeface(C6011Lu2.k());
            this.b.setTextSize(1, 13.0f);
            this.b.setTextColor(c5495Jo7.f0());
            this.b.setSingleLine(true);
            TextView textView2 = this.b;
            TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
            textView2.setEllipsize(truncateAt);
            this.b.setMaxLines(1);
            this.b.setGravity(16);
            linearLayout.addView(this.b, C14433hu3.g(0, -1, 1.0f, 8, 0, 0, 0));
            TextView textView3 = new TextView(context);
            this.c = textView3;
            textView3.setTypeface(C6011Lu2.k());
            this.c.setTextSize(1, 13.0f);
            this.c.setTextColor(c5495Jo7.f0());
            this.c.setSingleLine(true);
            this.c.setEllipsize(truncateAt);
            this.c.setMaxLines(1);
            this.c.setGravity(16);
            linearLayout.addView(this.c, C14433hu3.f(-2, -1, 4.0f, 0.0f, 4.0f, 0.0f));
            View view = new View(context);
            this.d = view;
            view.setBackgroundResource(KB5.list_selector);
            addView(this.d, C14433hu3.a(-1, -1.0f));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.d.drawableHotspotChanged(motionEvent.getX(), motionEvent.getY());
            return super.onTouchEvent(motionEvent);
        }
    }

    public PhotoPickerAlbumsCell(Context context) {
        super(context);
        this.b = new AbstractC14815iX3.a[4];
        this.a = new b[4];
        for (int i = 0; i < 4; i++) {
            this.a[i] = new b(context);
            addView(this.a[i]);
            this.a[i].setVisibility(4);
            this.a[i].setTag(Integer.valueOf(i));
            this.a[i].setOnClickListener(new a());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iA = C5161Id6.k() ? (C22078ud6.a(490.0f) - ((this.c + 1) * C22078ud6.a(4.0f))) / this.c : (AbstractC7426Rr.C().x - ((this.c + 1) * C22078ud6.a(4.0f))) / this.c;
        for (int i3 = 0; i3 < this.c; i3++) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a[i3].getLayoutParams();
            layoutParams.topMargin = C22078ud6.a(4.0f);
            layoutParams.leftMargin = (C22078ud6.a(4.0f) + iA) * i3;
            layoutParams.width = iA;
            layoutParams.height = iA;
            layoutParams.gravity = 51;
            this.a[i3].setLayoutParams(layoutParams);
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(C22078ud6.a(4.0f) + iA, 1073741824));
    }

    public void setAlbum(int i, AbstractC14815iX3.a aVar) {
        this.b[i] = aVar;
        if (aVar == null) {
            this.a[i].setVisibility(4);
            return;
        }
        b bVar = this.a[i];
        AbstractC14815iX3.b bVar2 = aVar.b;
        if (bVar2 == null || bVar2.A == null) {
            bVar.a.setImageResource(KB5.nophotos);
        } else if (bVar2.D) {
            bVar.a.setImage("vthumb://" + aVar.b.u + ":" + aVar.b.A, (String) null, getContext().getResources().getDrawable(KB5.nophotos));
        } else {
            bVar.a.setImage("thumb://" + aVar.b.u + ":" + aVar.b.A, (String) null, getContext().getResources().getDrawable(KB5.nophotos));
        }
        bVar.b.setText(aVar.a);
        bVar.c.setText(String.format("%d", Integer.valueOf(aVar.c.size())));
    }

    public void setAlbumsCount(int i) {
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.a;
            if (i2 >= bVarArr.length) {
                this.c = i;
                return;
            } else {
                bVarArr[i2].setVisibility(i2 < i ? 0 : 4);
                i2++;
            }
        }
    }

    public void setDelegate(PhotoPickerAlbumsCellDelegate photoPickerAlbumsCellDelegate) {
        this.d = photoPickerAlbumsCellDelegate;
    }
}
