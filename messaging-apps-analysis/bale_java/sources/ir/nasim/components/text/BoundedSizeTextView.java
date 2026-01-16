package ir.nasim.components.text;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC23053wG5;
import ir.nasim.ED1;
import ir.nasim.ME5;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0018B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lir/nasim/components/text/BoundedSizeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lir/nasim/rB7;", "s", "r", "()V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Lir/nasim/components/text/BoundedSizeTextView$a;", "h", "Lir/nasim/components/text/BoundedSizeTextView$a;", "clampInfo", "i", "a", "b", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class BoundedSizeTextView extends AppCompatTextView {
    private static final b i = new b(null);
    public static final int j = 8;

    /* renamed from: h, reason: from kotlin metadata */
    private a clampInfo;

    private static final class a {
        private final float a;
        private final float b;

        public a(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public final float a() {
            return this.a;
        }

        public final float b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Float.compare(this.a, aVar.a) == 0 && Float.compare(this.b, aVar.b) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.a) * 31) + Float.hashCode(this.b);
        }

        public String toString() {
            return "ClampInfo(minSizePx=" + this.a + ", maxSizePx=" + this.b + Separators.RPAREN;
        }
    }

    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BoundedSizeTextView(Context context) {
        this(context, null, 0, 6, null);
        AbstractC13042fc3.i(context, "context");
    }

    private final void r() {
        a aVar = this.clampInfo;
        if (aVar == null) {
            return;
        }
        setTextSize(0, AbstractC23053wG5.l(getTextSize(), aVar.a(), aVar.b()));
    }

    private final void s(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, ME5.BoundedSizeTextView, defStyleAttr, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(ME5.BoundedSizeTextView_minTextSize) || typedArrayObtainStyledAttributes.hasValue(ME5.BoundedSizeTextView_maxTextSize)) {
                this.clampInfo = new a(typedArrayObtainStyledAttributes.getDimension(ME5.BoundedSizeTextView_minTextSize, 0.0f), typedArrayObtainStyledAttributes.getDimension(ME5.BoundedSizeTextView_maxTextSize, Float.MAX_VALUE));
            }
            typedArrayObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        AbstractC13042fc3.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        r();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BoundedSizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        AbstractC13042fc3.i(context, "context");
    }

    public /* synthetic */ BoundedSizeTextView(Context context, AttributeSet attributeSet, int i2, int i3, ED1 ed1) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? R.attr.textViewStyle : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoundedSizeTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AbstractC13042fc3.i(context, "context");
        s(context, attributeSet, i2);
        r();
    }
}
