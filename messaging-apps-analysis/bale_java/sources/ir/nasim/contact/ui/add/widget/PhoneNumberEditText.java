package ir.nasim.contact.ui.add.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import ir.nasim.AbstractC10242bK;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC15401jX0;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC22039uZ6;
import ir.nasim.C12266eK0;
import ir.nasim.C24411ya3;
import ir.nasim.C5495Jo7;
import ir.nasim.GY6;
import ir.nasim.KE5;
import ir.nasim.XY6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u001d*\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b$\u0010\u001bJ\u0017\u0010%\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b%\u0010\rR\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010'R\u0014\u0010*\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010)R(\u0010.\u001a\u0004\u0018\u00010\t2\b\u0010+\u001a\u0004\u0018\u00010\t8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u0010\u0010,\"\u0004\b-\u0010\rR\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010/R\u001c\u00103\u001a\b\u0018\u000101R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00102¨\u00065"}, d2 = {"Lir/nasim/contact/ui/add/widget/PhoneNumberEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "format", "Lir/nasim/rB7;", "j", "(Ljava/lang/String;)V", "", "", "i", "(Ljava/lang/String;)Ljava/util/List;", "k", "()V", "color", "Landroid/graphics/Paint;", "h", "(I)Landroid/graphics/Paint;", "Landroid/graphics/Canvas;", "canvas", "g", "(Landroid/graphics/Canvas;)V", ParameterNames.TEXT, "", "l", "(Landroid/graphics/Paint;Ljava/lang/String;)F", "", "error", "setError", "(Ljava/lang/CharSequence;)V", "onDraw", "setFormat", "", "Z", "hasError", "Landroid/graphics/Paint;", "formatterPaint", "value", "Ljava/lang/String;", "setPhoneNumberFormat", "phoneNumberFormat", "Ljava/util/List;", "spaceIndies", "Lir/nasim/contact/ui/add/widget/PhoneNumberEditText$a;", "Lir/nasim/contact/ui/add/widget/PhoneNumberEditText$a;", "textWatcher", "a", "contact_release"}, k = 1, mv = {2, 0, 0})
/* loaded from: classes4.dex */
public final class PhoneNumberEditText extends AppCompatEditText {

    /* renamed from: g, reason: from kotlin metadata */
    private boolean hasError;

    /* renamed from: h, reason: from kotlin metadata */
    private final Paint formatterPaint;

    /* renamed from: i, reason: from kotlin metadata */
    private String phoneNumberFormat;

    /* renamed from: j, reason: from kotlin metadata */
    private List spaceIndies;

    /* renamed from: k, reason: from kotlin metadata */
    private a textWatcher;

    private final class a implements TextWatcher {
        private boolean a;
        private final C12266eK0 b = new C12266eK0('0', '9');

        public a() throws IOException {
            Editable text = PhoneNumberEditText.this.getText();
            String strA = a(text != null ? text.toString() : null);
            PhoneNumberEditText.this.setText(strA);
            PhoneNumberEditText.this.setSelection(strA != null ? strA.length() : 0);
        }

        private final String a(String str) throws IOException {
            String strB;
            String strV;
            if (str == null || (strB = GY6.b(str)) == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int length = strB.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = strB.charAt(i);
                C12266eK0 c12266eK0 = this.b;
                char cO = c12266eK0.o();
                if (cCharAt <= c12266eK0.t() && cO <= cCharAt) {
                    sb.append(cCharAt);
                }
            }
            String string = sb.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            if (string == null || (strV = XY6.v(string)) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(AbstractC22039uZ6.D1(strV));
            Iterator it = PhoneNumberEditText.this.spaceIndies.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue <= arrayList.size() - 1) {
                    arrayList.add(iIntValue, ' ');
                }
            }
            return AbstractC15401jX0.A0(arrayList, "", null, null, 0, null, null, 62, null);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws IOException {
            int i4;
            if (this.a || PhoneNumberEditText.this.hasError) {
                return;
            }
            String string = charSequence != null ? charSequence.toString() : null;
            if (i2 <= i3) {
                if (i2 == 0 && i3 == 1) {
                    i = PhoneNumberEditText.this.spaceIndies.contains(Integer.valueOf(i)) ? i + 2 : i + 1;
                } else {
                    if (string == null) {
                        return;
                    }
                    String strSubstring = string.substring(i, i3 + i);
                    AbstractC13042fc3.h(strSubstring, "substring(...)");
                    if (strSubstring == null) {
                        return;
                    }
                    String strQ = XY6.q(strSubstring);
                    C24411ya3 c24411ya3 = new C24411ya3(i, strQ.length() + i);
                    int length = i + strQ.length();
                    List list = PhoneNumberEditText.this.spaceIndies;
                    if ((list instanceof Collection) && list.isEmpty()) {
                        i4 = 0;
                    } else {
                        Iterator it = list.iterator();
                        i4 = 0;
                        while (it.hasNext()) {
                            int iIntValue = ((Number) it.next()).intValue();
                            int iO = c24411ya3.o();
                            if (iIntValue <= c24411ya3.t() && iO <= iIntValue && (i4 = i4 + 1) < 0) {
                                AbstractC10360bX0.v();
                            }
                        }
                    }
                    i = length + i4;
                }
            }
            this.a = true;
            String strA = a(string);
            int length2 = strA != null ? strA.length() : 0;
            PhoneNumberEditText.this.setText(strA);
            if (i > length2) {
                PhoneNumberEditText.this.setSelection(length2);
            } else {
                PhoneNumberEditText.this.setSelection(i);
            }
            this.a = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumberEditText(Context context) {
        super(context);
        AbstractC13042fc3.i(context, "context");
        this.spaceIndies = AbstractC10360bX0.m();
        setPhoneNumberFormat(null);
        this.formatterPaint = h(-1);
    }

    private final void g(Canvas canvas) {
        String str = this.phoneNumberFormat;
        if (str == null || !(!AbstractC20762sZ6.n0(str))) {
            return;
        }
        Editable text = getText();
        String string = text != null ? text.toString() : null;
        String strSubstring = str.substring(Math.min(str.length(), string != null ? string.length() : 0));
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        float paddingLeft = getPaddingLeft();
        TextPaint paint = getPaint();
        AbstractC13042fc3.h(paint, "getPaint(...)");
        canvas.drawText(strSubstring, paddingLeft + l(paint, string), getLineBounds(0, null), this.formatterPaint);
    }

    private final Paint h(int color) {
        if (color != -1) {
            Paint paint = new Paint(getPaint());
            paint.setColor(color);
            return paint;
        }
        TextPaint paint2 = getPaint();
        AbstractC13042fc3.f(paint2);
        return paint2;
    }

    private final List i(String format) {
        if (format == null) {
            return AbstractC10360bX0.m();
        }
        ArrayList arrayList = new ArrayList(4);
        int i = 0;
        int i2 = 0;
        while (i < format.length()) {
            int i3 = i2 + 1;
            if (format.charAt(i) == ' ') {
                arrayList.add(Integer.valueOf(i2));
            }
            i++;
            i2 = i3;
        }
        return AbstractC15401jX0.S0(arrayList, Integer.valueOf(format.length()));
    }

    private final void j(String format) {
        this.spaceIndies = i(format);
        k();
    }

    private final void k() {
        TextWatcher textWatcher = this.textWatcher;
        if (textWatcher != null) {
            removeTextChangedListener(textWatcher);
        }
        a aVar = new a();
        addTextChangedListener(aVar);
        this.textWatcher = aVar;
    }

    private final float l(Paint paint, String str) {
        if (str == null) {
            return 0.0f;
        }
        float[] fArr = new float[str.length()];
        paint.getTextWidths(str, fArr);
        return AbstractC10242bK.S0(fArr);
    }

    private final void setPhoneNumberFormat(String str) {
        this.phoneNumberFormat = str != null ? AbstractC20153rZ6.L(str, 'X', (char) 8211, false, 4, null) : null;
        j(str);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        AbstractC13042fc3.i(canvas, "canvas");
        super.onDraw(canvas);
        g(canvas);
    }

    @Override // android.widget.TextView
    public void setError(CharSequence error) {
        boolean z = error != null;
        this.hasError = z;
        if (z) {
            String strValueOf = String.valueOf(getText());
            int length = strValueOf.length();
            String str = this.phoneNumberFormat;
            int iMin = Math.min(length, str != null ? str.length() : Integer.MAX_VALUE);
            String strSubstring = strValueOf.substring(0, iMin);
            AbstractC13042fc3.h(strSubstring, "substring(...)");
            int iB0 = C5495Jo7.a.B0();
            String strSubstring2 = strValueOf.substring(iMin, strValueOf.length());
            AbstractC13042fc3.h(strSubstring2, "substring(...)");
            setText(Html.fromHtml(strSubstring + ("<font color=" + iB0 + Separators.GREATER_THAN + strSubstring2 + "</font>")));
            setSelection(strValueOf.length());
            this.hasError = false;
        }
    }

    public final void setFormat(String format) {
        setPhoneNumberFormat(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumberEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(attributeSet, "attrs");
        this.spaceIndies = AbstractC10360bX0.m();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, KE5.PhoneNumberEditText);
        AbstractC13042fc3.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        this.formatterPaint = h(typedArrayObtainStyledAttributes.getColor(KE5.PhoneNumberEditText_formatterColor, -1));
        setPhoneNumberFormat(typedArrayObtainStyledAttributes.getString(KE5.PhoneNumberEditText_phoneNumberFormat));
        typedArrayObtainStyledAttributes.recycle();
    }
}
