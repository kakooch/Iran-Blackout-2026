package ir.nasim.components.textfield.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Rect;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.card.MaterialCardView;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.C22078ud6;
import ir.nasim.C5495Jo7;
import ir.nasim.C6011Lu2;
import ir.nasim.F10;
import ir.nasim.ME5;
import ir.nasim.TC5;
import ir.nasim.components.textfield.view.BaleTextInputLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u0015\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0016¢\u0006\u0004\b!\u0010\u0019J\u001f\u0010$\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u000e2\b\b\u0001\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010/\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u000e¢\u0006\u0004\b2\u0010\u0011J\u0015\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020'¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\t2\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J!\u0010=\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u0015\u0010?\u001a\u00020\t2\u0006\u0010:\u001a\u00020'¢\u0006\u0004\b?\u00105J\u0017\u0010@\u001a\u00020\t2\b\b\u0001\u0010(\u001a\u00020'¢\u0006\u0004\b@\u00105J\u0015\u0010B\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u000e¢\u0006\u0004\bB\u0010\u0011J\u0015\u0010D\u001a\u00020\t2\u0006\u0010C\u001a\u00020'¢\u0006\u0004\bD\u00105R$\u0010\"\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u0016\u0010K\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010GR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006P"}, d2 = {"Lir/nasim/components/textfield/view/BaleTextInputLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lir/nasim/rB7;", "n0", "()V", "k0", "i0", "", "hasFocus", "h0", "(Z)V", "Landroid/view/View$OnClickListener;", "l", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "hint", "setHint", "helper", "setHelper", "prefix", "setPrefix", "suffix", "setSuffix", "hasError", "showErrorOnHelper", "setError", "(ZZ)V", "show", "", "color", "setStroke", "(ZI)V", "getText", "()Ljava/lang/String;", "", ParameterNames.TEXT, "setText", "(Ljava/lang/CharSequence;)V", "isVisible", "f0", "imeOptions", "setImeOptions", "(I)V", "Landroid/widget/TextView$OnEditorActionListener;", "listener", "setOnEditorActionListener", "(Landroid/widget/TextView$OnEditorActionListener;)V", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "requestFocus", "(ILandroid/graphics/Rect;)Z", "g0", "setPrefixColor", "isSingleLine", "setIsSingleLine", "maxLines", "setMaxLines", "value", "y", "Z", "getHasError", "()Z", "z", "changeBoarderOnFocusChanged", "Lir/nasim/F10;", "A", "Lir/nasim/F10;", "binding", "ui_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class BaleTextInputLayout extends ConstraintLayout {

    /* renamed from: A, reason: from kotlin metadata */
    private final F10 binding;

    /* renamed from: y, reason: from kotlin metadata */
    private boolean hasError;

    /* renamed from: z, reason: from kotlin metadata */
    private boolean changeBoarderOnFocusChanged;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleTextInputLayout(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.changeBoarderOnFocusChanged = true;
        this.binding = F10.a(View.inflate(getContext(), TC5.bale_text_input_layout, this));
        n0();
    }

    private final void h0(boolean hasFocus) {
        if (hasFocus) {
            setStroke(true, C5495Jo7.a.e2());
        } else {
            setStroke(false, C5495Jo7.a.B2());
        }
    }

    private final void i0() {
        this.binding.d.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.nasim.E10
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                BaleTextInputLayout.j0(this.a, view, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(BaleTextInputLayout baleTextInputLayout, View view, boolean z) {
        AbstractC13042fc3.i(baleTextInputLayout, "this$0");
        if (baleTextInputLayout.hasError || !baleTextInputLayout.changeBoarderOnFocusChanged) {
            return;
        }
        baleTextInputLayout.h0(z);
    }

    private final void k0() {
        this.binding.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.D10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaleTextInputLayout.m0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(BaleTextInputLayout baleTextInputLayout, View view) {
        AbstractC13042fc3.i(baleTextInputLayout, "this$0");
        AppCompatEditText appCompatEditText = baleTextInputLayout.binding.d;
        if (appCompatEditText.hasFocus()) {
            return;
        }
        appCompatEditText.requestFocus();
    }

    private final void n0() {
        F10 f10 = this.binding;
        f10.h.setTypeface(C6011Lu2.i());
        f10.f.setTypeface(C6011Lu2.k());
        f10.d.setTypeface(C6011Lu2.k());
        f10.c.setTypeface(C6011Lu2.k());
        i0();
        k0();
    }

    public static /* synthetic */ void setError$default(BaleTextInputLayout baleTextInputLayout, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        baleTextInputLayout.setError(z, z2);
    }

    public final void f0(boolean isVisible) {
        TextView textView = this.binding.c;
        AbstractC13042fc3.h(textView, "helper");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    public final void g0(int direction) {
        F10 f10 = this.binding;
        f10.e.setLayoutDirection(direction);
        f10.e.setTextDirection(direction != 0 ? direction != 1 ? 0 : 4 : 3);
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final String getText() {
        String string;
        Editable text = this.binding.d.getText();
        return (text == null || (string = text.toString()) == null) ? "" : string;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        return this.binding.d.requestFocus(direction, previouslyFocusedRect);
    }

    public final void setError(boolean hasError, boolean showErrorOnHelper) {
        this.hasError = hasError;
        if (hasError) {
            setStroke(true, C5495Jo7.a.B0());
        } else {
            h0(hasFocus());
        }
        this.binding.c.setTextColor((showErrorOnHelper && hasError) ? C5495Jo7.a.B0() : C5495Jo7.a.v0());
    }

    public final void setHelper(String helper) {
        AbstractC13042fc3.i(helper, "helper");
        this.binding.c.setText(helper);
    }

    public final void setHint(String hint) {
        AbstractC13042fc3.i(hint, "hint");
        this.binding.d.setHint(hint);
    }

    public final void setImeOptions(int imeOptions) {
        this.binding.d.setImeOptions(imeOptions);
    }

    public final void setIsSingleLine(boolean isSingleLine) {
        this.binding.d.setSingleLine(isSingleLine);
    }

    public final void setMaxLines(int maxLines) {
        this.binding.d.setMaxLines(maxLines);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
    }

    public final void setOnEditorActionListener(TextView.OnEditorActionListener listener) {
        AbstractC13042fc3.i(listener, "listener");
        this.binding.d.setOnEditorActionListener(listener);
    }

    public final void setPrefix(String prefix) {
        AbstractC13042fc3.i(prefix, "prefix");
        this.binding.f.setText(prefix);
    }

    public final void setPrefixColor(int color) {
        this.binding.f.setTextColor(color);
    }

    public final void setStroke(boolean show, int color) {
        MaterialCardView materialCardView = this.binding.b;
        materialCardView.setStrokeColor(color);
        materialCardView.setStrokeWidth(C22078ud6.a(show ? 2.0f : 0.0f));
    }

    public final void setSuffix(String suffix) {
        AbstractC13042fc3.i(suffix, "suffix");
        this.binding.g.setText(suffix);
    }

    public final void setText(CharSequence text) {
        this.binding.d.setText(text);
    }

    public final void setTitle(String title) {
        AbstractC13042fc3.i(title, "title");
        this.binding.h.setText(title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaleTextInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.changeBoarderOnFocusChanged = true;
        F10 f10A = F10.a(View.inflate(getContext(), TC5.bale_text_input_layout, this));
        this.binding = f10A;
        n0();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ME5.BaleTextInputLayout);
        AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        g0(typedArrayObtainStyledAttributes.getInteger(ME5.BaleTextInputLayout_inputTextDirection, 2));
        String string = typedArrayObtainStyledAttributes.getString(ME5.BaleTextInputLayout_hint);
        setHint(string == null ? "" : string);
        String string2 = typedArrayObtainStyledAttributes.getString(ME5.BaleTextInputLayout_title);
        setTitle(string2 == null ? "" : string2);
        setPrefixColor(typedArrayObtainStyledAttributes.getColor(ME5.BaleTextInputLayout_prefixTextColor, f10A.d.getCurrentTextColor()));
        String string3 = typedArrayObtainStyledAttributes.getString(ME5.BaleTextInputLayout_suffix);
        setSuffix(string3 == null ? "" : string3);
        String string4 = typedArrayObtainStyledAttributes.getString(ME5.BaleTextInputLayout_prefix);
        setPrefix(string4 == null ? "" : string4);
        String string5 = typedArrayObtainStyledAttributes.getString(ME5.BaleTextInputLayout_helper);
        setHelper(string5 != null ? string5 : "");
        f0(!typedArrayObtainStyledAttributes.getBoolean(ME5.BaleTextInputLayout_hide_helper, false));
        setImeOptions(typedArrayObtainStyledAttributes.getInt(ME5.BaleTextInputLayout_android_imeOptions, 1));
        setIsSingleLine(typedArrayObtainStyledAttributes.getBoolean(ME5.BaleTextInputLayout_android_singleLine, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
