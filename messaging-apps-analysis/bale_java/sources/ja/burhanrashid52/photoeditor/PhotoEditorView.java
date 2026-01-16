package ja.burhanrashid52.photoeditor;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8934Xw1;
import ir.nasim.ED1;
import ir.nasim.I85;
import ir.nasim.NE5;
import ir.nasim.VJ4;
import ja.burhanrashid52.photoeditor.FilterImageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0017\u001a\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0017\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R$\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020$8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010,R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010.R\u0011\u00103\u001a\u0002008F¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lja/burhanrashid52/photoeditor/PhotoEditorView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/RelativeLayout$LayoutParams;", "f", "(Landroid/util/AttributeSet;)Landroid/widget/RelativeLayout$LayoutParams;", "d", "()Landroid/widget/RelativeLayout$LayoutParams;", "e", "Lir/nasim/VJ4;", "onSaveBitmap", "Lir/nasim/rB7;", "c", "(Lir/nasim/VJ4;)V", "Lir/nasim/I85;", "filterType", "setFilterEffect", "(Lir/nasim/I85;)V", "Lir/nasim/Xw1;", "customEffect", "(Lir/nasim/Xw1;)V", "", "clip", "setClipSourceImage", "(Z)V", "Lja/burhanrashid52/photoeditor/FilterImageView;", "a", "Lja/burhanrashid52/photoeditor/FilterImageView;", "mImgSource", "Lja/burhanrashid52/photoeditor/DrawingView;", "<set-?>", "b", "Lja/burhanrashid52/photoeditor/DrawingView;", "getDrawingView", "()Lja/burhanrashid52/photoeditor/DrawingView;", "drawingView", "Lja/burhanrashid52/photoeditor/ImageFilterView;", "Lja/burhanrashid52/photoeditor/ImageFilterView;", "mImageFilterView", "Z", "clipSourceImage", "Landroid/widget/ImageView;", "getSource", "()Landroid/widget/ImageView;", "source", "photoeditor_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class PhotoEditorView extends RelativeLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private FilterImageView mImgSource;

    /* renamed from: b, reason: from kotlin metadata */
    private DrawingView drawingView;

    /* renamed from: c, reason: from kotlin metadata */
    private ImageFilterView mImageFilterView;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean clipSourceImage;

    public static final class a implements FilterImageView.a {
        a() {
        }

        @Override // ja.burhanrashid52.photoeditor.FilterImageView.a
        public void a(Bitmap bitmap) {
            PhotoEditorView.this.mImageFilterView.setFilterEffect(I85.NONE);
            PhotoEditorView.this.mImageFilterView.setSourceBitmap(bitmap);
            Log.d("PhotoEditorView", "onBitmapLoaded() called with: sourceBitmap = [" + bitmap + ']');
        }
    }

    public static final class c implements VJ4 {
        final /* synthetic */ VJ4 b;

        c(VJ4 vj4) {
            this.b = vj4;
        }

        @Override // ir.nasim.VJ4
        public void a(Exception exc) {
            this.b.a(exc);
        }

        @Override // ir.nasim.VJ4
        public void b(Bitmap bitmap) {
            Log.e("PhotoEditorView", AbstractC13042fc3.q("saveFilter: ", bitmap));
            if (bitmap != null) {
                PhotoEditorView.this.mImgSource.setImageBitmap(bitmap);
            }
            PhotoEditorView.this.mImageFilterView.setVisibility(8);
            this.b.b(bitmap);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoEditorView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final RelativeLayout.LayoutParams d() {
        this.drawingView.setVisibility(8);
        this.drawingView.setId(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13, -1);
        layoutParams.addRule(6, 1);
        layoutParams.addRule(8, 1);
        layoutParams.addRule(5, 1);
        layoutParams.addRule(7, 1);
        return layoutParams;
    }

    private final RelativeLayout.LayoutParams e() {
        this.mImageFilterView.setVisibility(8);
        this.mImageFilterView.setId(3);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13, -1);
        layoutParams.addRule(6, 1);
        layoutParams.addRule(8, 1);
        return layoutParams;
    }

    private final RelativeLayout.LayoutParams f(AttributeSet attrs) {
        this.mImgSource.setId(1);
        this.mImgSource.setAdjustViewBounds(true);
        this.mImgSource.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, NE5.PhotoEditorView);
            AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…tyleable.PhotoEditorView)");
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(NE5.PhotoEditorView_photo_src);
            if (drawable != null) {
                this.mImgSource.setImageDrawable(drawable);
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.clipSourceImage ? -2 : -1, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    public final void c(VJ4 onSaveBitmap) {
        AbstractC13042fc3.i(onSaveBitmap, "onSaveBitmap");
        if (this.mImageFilterView.getVisibility() == 0) {
            this.mImageFilterView.g(new c(onSaveBitmap));
        } else {
            onSaveBitmap.b(this.mImgSource.getBitmap());
        }
    }

    public final DrawingView getDrawingView() {
        return this.drawingView;
    }

    public final ImageView getSource() {
        return this.mImgSource;
    }

    public final void setClipSourceImage(boolean clip) {
        this.clipSourceImage = clip;
        this.mImgSource.setLayoutParams(f(null));
    }

    public final void setFilterEffect(I85 filterType) {
        this.mImageFilterView.setVisibility(0);
        this.mImageFilterView.setSourceBitmap(this.mImgSource.getBitmap());
        this.mImageFilterView.setFilterEffect(filterType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhotoEditorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ PhotoEditorView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoEditorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
        this.mImgSource = new FilterImageView(context, null, 0, 6, null);
        RelativeLayout.LayoutParams layoutParamsF = f(attributeSet);
        this.mImageFilterView = new ImageFilterView(context, null, 2, null);
        RelativeLayout.LayoutParams layoutParamsE = e();
        this.mImgSource.setOnImageChangedListener(new a());
        this.drawingView = new DrawingView(context, null, 0, 6, null);
        RelativeLayout.LayoutParams layoutParamsD = d();
        addView(this.mImgSource, layoutParamsF);
        addView(this.mImageFilterView, layoutParamsE);
        addView(this.drawingView, layoutParamsD);
    }

    public final void setFilterEffect(AbstractC8934Xw1 customEffect) {
        this.mImageFilterView.setVisibility(0);
        this.mImageFilterView.setSourceBitmap(this.mImgSource.getBitmap());
        this.mImageFilterView.setFilterEffect(customEffect);
    }
}
