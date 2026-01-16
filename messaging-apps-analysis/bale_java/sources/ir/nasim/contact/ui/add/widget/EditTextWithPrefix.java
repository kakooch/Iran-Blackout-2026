package ir.nasim.contact.ui.add.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.javax.sip.parser.TokenNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13269fw3;
import ir.nasim.InterfaceC9173Yu3;
import ir.nasim.KE5;
import ir.nasim.SA2;
import ir.nasim.contact.ui.add.widget.EditTextWithPrefix;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lir/nasim/contact/ui/add/widget/EditTextWithPrefix;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "f", "()V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "prefix", "setPrefix", "(Ljava/lang/String;)V", "g", TokenNames.I, "originalPaddingLeft", "", "h", "Z", "prefixChanged", "i", "Ljava/lang/String;", "Landroid/graphics/Paint;", "j", "Lir/nasim/Yu3;", "getPrefixPaint", "()Landroid/graphics/Paint;", "prefixPaint", "contact_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public class EditTextWithPrefix extends AppCompatEditText {

    /* renamed from: g, reason: from kotlin metadata */
    private int originalPaddingLeft;

    /* renamed from: h, reason: from kotlin metadata */
    private boolean prefixChanged;

    /* renamed from: i, reason: from kotlin metadata */
    private String prefix;

    /* renamed from: j, reason: from kotlin metadata */
    private final InterfaceC9173Yu3 prefixPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextWithPrefix(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.originalPaddingLeft = -1;
        this.prefixChanged = true;
        this.prefixPaint = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.A42
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EditTextWithPrefix.g(this.a);
            }
        });
        this.prefix = "";
    }

    private final void f() {
        if (this.prefixChanged) {
            float[] fArr = new float[this.prefix.length()];
            getPaint().getTextWidths(this.prefix, fArr);
            setPadding((int) (AbstractC10242bK.S0(fArr) + this.originalPaddingLeft), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.prefixChanged = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint g(EditTextWithPrefix editTextWithPrefix) {
        AbstractC13042fc3.i(editTextWithPrefix, "this$0");
        return new Paint(editTextWithPrefix.getPaint());
    }

    private final Paint getPrefixPaint() {
        return (Paint) this.prefixPaint.getValue();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.onDraw(canvas);
        canvas.drawText(this.prefix, this.originalPaddingLeft, getLineBounds(0, null), getPrefixPaint());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.originalPaddingLeft == -1) {
            this.originalPaddingLeft = getCompoundPaddingLeft();
        }
        f();
    }

    public final void setPrefix(String prefix) {
        AbstractC13042fc3.i(prefix, "prefix");
        this.prefix = prefix;
        this.prefixChanged = true;
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextWithPrefix(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.originalPaddingLeft = -1;
        this.prefixChanged = true;
        this.prefixPaint = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.A42
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return EditTextWithPrefix.g(this.a);
            }
        });
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, KE5.EditTextWithPrefix);
        AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        String string = typedArrayObtainStyledAttributes.getString(KE5.EditTextWithPrefix_prefix);
        this.prefix = string == null ? "" : string;
        typedArrayObtainStyledAttributes.recycle();
    }
}
