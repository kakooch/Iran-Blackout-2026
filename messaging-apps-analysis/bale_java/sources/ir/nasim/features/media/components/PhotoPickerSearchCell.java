package ir.nasim.features.media.components;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.nasim.AbstractC12217eE5;
import ir.nasim.C14433hu3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.KB5;

/* loaded from: classes6.dex */
public class PhotoPickerSearchCell extends LinearLayout {
    private PhotoPickerSearchCellDelegate a;

    public interface PhotoPickerSearchCellDelegate {
        void didPressedSearchButton(int i);
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoPickerSearchCell.this.a != null) {
                PhotoPickerSearchCell.this.a.didPressedSearchButton(0);
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PhotoPickerSearchCell.this.a != null) {
                PhotoPickerSearchCell.this.a.didPressedSearchButton(1);
            }
        }
    }

    private class c extends FrameLayout {
        private TextView a;
        private TextView b;
        private ImageView c;
        private View d;

        public c(Context context) {
            super(context);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            setBackgroundColor(c5495Jo7.m2());
            View view = new View(context);
            this.d = view;
            view.setBackgroundResource(KB5.list_selector);
            addView(this.d, C14433hu3.a(-1, -1.0f));
            ImageView imageView = new ImageView(context);
            this.c = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.c, C14433hu3.c(48, 48, 51));
            TextView textView = new TextView(context);
            this.a = textView;
            textView.setGravity(16);
            this.a.setTextSize(1, 14.0f);
            this.a.setTextColor(c5495Jo7.f0());
            this.a.setSingleLine(true);
            TextView textView2 = this.a;
            TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
            textView2.setEllipsize(truncateAt);
            addView(this.a, C14433hu3.b(-1, -2.0f, 51, 51.0f, 8.0f, 4.0f, 0.0f));
            TextView textView3 = new TextView(context);
            this.b = textView3;
            textView3.setGravity(16);
            this.b.setTextSize(1, 10.0f);
            this.b.setTextColor(c5495Jo7.q2());
            this.b.setSingleLine(true);
            this.b.setEllipsize(truncateAt);
            addView(this.b, C14433hu3.b(-1, -2.0f, 51, 51.0f, 26.0f, 4.0f, 0.0f));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            this.d.drawableHotspotChanged(motionEvent.getX(), motionEvent.getY());
            return super.onTouchEvent(motionEvent);
        }
    }

    public PhotoPickerSearchCell(Context context, boolean z) {
        super(context);
        setOrientation(0);
        c cVar = new c(context);
        cVar.a.setText(AbstractC12217eE5.SearchImages);
        cVar.b.setText(AbstractC12217eE5.SearchImagesInfo);
        cVar.c.setImageResource(KB5.search_web);
        addView(cVar);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.getLayoutParams();
        layoutParams.weight = 0.5f;
        layoutParams.topMargin = C22078ud6.a(4.0f);
        layoutParams.height = C22078ud6.a(48.0f);
        layoutParams.width = 0;
        cVar.setLayoutParams(layoutParams);
        cVar.setOnClickListener(new a());
        View frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(0);
        addView(frameLayout);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams2.topMargin = C22078ud6.a(4.0f);
        layoutParams2.height = C22078ud6.a(48.0f);
        layoutParams2.width = C22078ud6.a(4.0f);
        frameLayout.setLayoutParams(layoutParams2);
        c cVar2 = new c(context);
        cVar2.a.setText(AbstractC12217eE5.SearchGifs);
        cVar2.b.setText("GIPHY");
        cVar2.c.setImageResource(KB5.search_gif);
        addView(cVar2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) cVar2.getLayoutParams();
        layoutParams3.weight = 0.5f;
        layoutParams3.topMargin = C22078ud6.a(4.0f);
        layoutParams3.height = C22078ud6.a(48.0f);
        layoutParams3.width = 0;
        cVar2.setLayoutParams(layoutParams3);
        if (z) {
            cVar2.setOnClickListener(new b());
        } else {
            cVar2.setAlpha(0.5f);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(C22078ud6.a(52.0f), 1073741824));
    }

    public void setDelegate(PhotoPickerSearchCellDelegate photoPickerSearchCellDelegate) {
        this.a = photoPickerSearchCellDelegate;
    }
}
