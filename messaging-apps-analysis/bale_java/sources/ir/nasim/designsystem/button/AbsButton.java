package ir.nasim.designsystem.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC4310Eo7;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.YE5;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b'\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010\u001aJ\u0015\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b \u0010\u001eJ\r\u0010!\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\u001aJ\r\u0010\"\u001a\u00020\u0016¢\u0006\u0004\b\"\u0010\u001aJ\u0015\u0010#\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b#\u0010\u0018J\r\u0010$\u001a\u00020\u0016¢\u0006\u0004\b$\u0010\u001aJ\u0017\u0010&\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u001bH\u0016¢\u0006\u0004\b&\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u001b¢\u0006\u0004\b\u001f\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00162\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b\u001f\u0010*R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00107\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u00108¨\u0006:"}, d2 = {"Lir/nasim/designsystem/button/AbsButton;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/widget/TextView;", "g", "()Landroid/widget/TextView;", "Landroid/widget/ImageView;", "c", "()Landroid/widget/ImageView;", "Landroid/widget/ProgressBar;", "e", "()Landroid/widget/ProgressBar;", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", "", "value", "Lir/nasim/rB7;", "setIsActive", "(Z)V", "d", "()V", "", "color", "h", "(I)V", "setText", "setTextColor", "setIcon", "a", "setPreserveColor", "b", "visibility", "setVisibility", "res", "", "content", "(Ljava/lang/String;)V", "Landroid/content/res/TypedArray;", "Landroid/content/res/TypedArray;", "getAttr", "()Landroid/content/res/TypedArray;", "setAttr", "(Landroid/content/res/TypedArray;)V", "attr", "Ljava/lang/Integer;", "getResIcon", "()Ljava/lang/Integer;", "setResIcon", "(Ljava/lang/Integer;)V", "resIcon", "Z", "preserveDefaultColor", "nasim_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes5.dex */
public abstract class AbsButton extends LinearLayout {

    /* renamed from: a, reason: from kotlin metadata */
    private TypedArray attr;

    /* renamed from: b, reason: from kotlin metadata */
    private Integer resIcon;

    /* renamed from: c, reason: from kotlin metadata */
    private boolean preserveDefaultColor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.f(context);
        this.attr = context.obtainStyledAttributes(attributeSet, YE5.BaleFullWidthButton);
        this.resIcon = 0;
    }

    public final void a() {
        setIsActive(false);
        if (!this.preserveDefaultColor) {
            ViewGroup viewGroupF = f();
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            viewGroupF.setBackground(AbstractC4310Eo7.j(c5495Jo7.Z(), c5495Jo7.B2(), 0));
            g().setTextColor(c5495Jo7.e0());
            h(c5495Jo7.e0());
        }
        e().setVisibility(8);
        g().setVisibility(0);
    }

    public final void b() {
        setIsActive(false);
        if (!this.preserveDefaultColor) {
            ViewGroup viewGroupF = f();
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            viewGroupF.setBackground(AbstractC4310Eo7.j(c5495Jo7.Z(), c5495Jo7.B2(), 0));
        }
        g().setVisibility(8);
        c().setVisibility(8);
        e().setVisibility(0);
    }

    public abstract ImageView c();

    public final void d() {
        TypedArray typedArray = this.attr;
        this.resIcon = typedArray != null ? Integer.valueOf(typedArray.getResourceId(YE5.BaleFullWidthButton_button_icon, 0)) : null;
        g().setTypeface(C6011Lu2.i());
        setText();
        g().setTextColor(C5495Jo7.a.i());
    }

    public abstract ProgressBar e();

    public abstract ViewGroup f();

    public abstract TextView g();

    public final TypedArray getAttr() {
        return this.attr;
    }

    public final Integer getResIcon() {
        return this.resIcon;
    }

    public final void h(int color) {
        Integer num = this.resIcon;
        if (num != null && num.intValue() == 0) {
            c().setVisibility(8);
            return;
        }
        c().setVisibility(0);
        ImageView imageViewC = c();
        Integer num2 = this.resIcon;
        AbstractC13042fc3.f(num2);
        imageViewC.setImageResource(num2.intValue());
        c().setColorFilter(color);
    }

    public final void setAttr(TypedArray typedArray) {
        this.attr = typedArray;
    }

    public final void setIcon() {
        TypedArray typedArray = this.attr;
        Integer numValueOf = typedArray != null ? Integer.valueOf(typedArray.getResourceId(YE5.BaleFullWidthButton_button_icon, 0)) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            return;
        }
        ImageView imageViewC = c();
        AbstractC13042fc3.f(numValueOf);
        imageViewC.setImageResource(numValueOf.intValue());
    }

    public abstract void setIsActive(boolean value);

    public final void setPreserveColor(boolean value) {
        this.preserveDefaultColor = value;
    }

    public final void setResIcon(Integer num) {
        this.resIcon = num;
    }

    public final void setText() {
        TextView textViewG = g();
        TypedArray typedArray = this.attr;
        textViewG.setText(typedArray != null ? typedArray.getString(YE5.BaleFullWidthButton_button_text) : null);
        setIcon();
    }

    public final void setTextColor(int color) {
        g().setTextColor(color);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
    }

    public final void setText(int res) {
        g().setText(res);
    }

    public final void setText(String content) {
        AbstractC13042fc3.i(content, "content");
        g().setText(content);
    }
}
