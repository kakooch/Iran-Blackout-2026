package ir.nasim;

import android.gov.nist.core.Separators;
import com.github.mikephil.charting.formatter.ValueFormatter;
import java.util.List;

/* loaded from: classes6.dex */
public final class Vb8 extends ValueFormatter {
    private final List a;
    private final boolean b;

    public Vb8(List list, boolean z) {
        AbstractC13042fc3.i(list, "dates");
        this.a = list;
        this.b = z;
    }

    private final String a(int i, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AbstractC16613la3.a(i % 100));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(i2));
        stringBuffer.append(Separators.SLASH);
        stringBuffer.append(AbstractC16613la3.a(i3));
        return XY6.e(stringBuffer.toString());
    }

    private final String b(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AbstractC16613la3.a(i));
        stringBuffer.append(Separators.SP);
        stringBuffer.append(str);
        return XY6.e(stringBuffer.toString());
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String getFormattedValue(float f) {
        D45 d45 = new D45((Long) this.a.get((int) f));
        if (!this.b) {
            return a(d45.C(), d45.B(), d45.A());
        }
        String strM = d45.M();
        AbstractC13042fc3.h(strM, "monthName(...)");
        return b(strM, d45.A());
    }
}
