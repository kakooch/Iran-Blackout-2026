package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import ir.nasim.D62;
import ir.nasim.HE5;

/* loaded from: classes.dex */
class i {
    private final TextView a;
    private final D62 b;

    i(TextView textView) {
        this.a = textView;
        this.b = new D62(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.b.a(inputFilterArr);
    }

    public boolean b() {
        return this.b.b();
    }

    void c(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.a.getContext().obtainStyledAttributes(attributeSet, HE5.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(HE5.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(HE5.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void d(boolean z) {
        this.b.c(z);
    }

    void e(boolean z) {
        this.b.d(z);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.b.e(transformationMethod);
    }
}
