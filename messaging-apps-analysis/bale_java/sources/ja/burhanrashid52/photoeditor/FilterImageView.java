package ja.burhanrashid52.photoeditor;

import android.content.Context;
import android.content.res.ColorStateList;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001:\u0001<B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010+\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0006H\u0016¢\u0006\u0004\b5\u0010/R\u0018\u00108\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0013\u0010;\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006="}, d2 = {"Lja/burhanrashid52/photoeditor/FilterImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lja/burhanrashid52/photoeditor/FilterImageView$a;", "onImageChangedListener", "Lir/nasim/rB7;", "setOnImageChangedListener", "(Lja/burhanrashid52/photoeditor/FilterImageView$a;)V", "Landroid/graphics/Bitmap;", "bm", "setImageBitmap", "(Landroid/graphics/Bitmap;)V", "Landroid/graphics/drawable/Icon;", ParameterNames.ICON, "setImageIcon", "(Landroid/graphics/drawable/Icon;)V", "Landroid/graphics/Matrix;", "matrix", "setImageMatrix", "(Landroid/graphics/Matrix;)V", "", "state", "", "merge", "setImageState", "([IZ)V", "Landroid/content/res/ColorStateList;", "tint", "setImageTintList", "(Landroid/content/res/ColorStateList;)V", "Landroid/graphics/PorterDuff$Mode;", "tintMode", "setImageTintMode", "(Landroid/graphics/PorterDuff$Mode;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "resId", "setImageResource", "(I)V", "Landroid/net/Uri;", "uri", "setImageURI", "(Landroid/net/Uri;)V", "level", "setImageLevel", "d", "Lja/burhanrashid52/photoeditor/FilterImageView$a;", "mOnImageChangedListener", "getBitmap", "()Landroid/graphics/Bitmap;", "bitmap", "a", "photoeditor_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes8.dex */
public final class FilterImageView extends AppCompatImageView {

    /* renamed from: d, reason: from kotlin metadata */
    private a mOnImageChangedListener;

    public interface a {
        void a(Bitmap bitmap);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilterImageView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    public final Bitmap getBitmap() {
        if (!(getDrawable() instanceof BitmapDrawable)) {
            return null;
        }
        Drawable drawable = getDrawable();
        if (drawable != null) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bm) {
        AbstractC13042fc3.i(bm, "bm");
        super.setImageBitmap(bm);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // android.widget.ImageView
    public void setImageIcon(Icon icon) {
        super.setImageIcon(icon);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageLevel(int level) {
        super.setImageLevel(level);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        AbstractC13042fc3.i(matrix, "matrix");
        super.setImageMatrix(matrix);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // android.widget.ImageView
    public void setImageState(int[] state, boolean merge) {
        AbstractC13042fc3.i(state, "state");
        super.setImageState(state, merge);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // android.widget.ImageView
    public void setImageTintList(ColorStateList tint) {
        super.setImageTintList(tint);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // android.widget.ImageView
    public void setImageTintMode(PorterDuff.Mode tintMode) {
        super.setImageTintMode(tintMode);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a aVar = this.mOnImageChangedListener;
        if (aVar == null) {
            return;
        }
        aVar.a(getBitmap());
    }

    public final void setOnImageChangedListener(a onImageChangedListener) {
        this.mOnImageChangedListener = onImageChangedListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FilterImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ FilterImageView(Context context, AttributeSet attributeSet, int i, int i2, ED1 ed1) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AbstractC13042fc3.i(context, "context");
    }
}
