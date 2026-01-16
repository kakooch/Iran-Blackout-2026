package ir.nasim;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: ir.nasim.mg2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public class C17263mg2 extends Format {
    private static final AbstractC20977sv2 c = new a();
    private final C19036pg2 a;
    private final C17854ng2 b;

    /* renamed from: ir.nasim.mg2$a */
    class a extends AbstractC20977sv2 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC20977sv2
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public C17263mg2 a(String str, TimeZone timeZone, Locale locale) {
            return new C17263mg2(str, timeZone, locale);
        }
    }

    protected C17263mg2(String str, TimeZone timeZone, Locale locale) {
        this(str, timeZone, locale, null);
    }

    public static C17263mg2 d(String str, Locale locale) {
        return (C17263mg2) c.b(str, null, locale);
    }

    public String b(long j) {
        return this.a.c(j);
    }

    public String c(Date date) {
        return this.a.d(date);
    }

    public TimeZone e() {
        return this.a.m();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C17263mg2) {
            return this.a.equals(((C17263mg2) obj).a);
        }
        return false;
    }

    @Override // java.text.Format
    public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return this.a.f(obj, stringBuffer, fieldPosition);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.text.Format
    public Object parseObject(String str, ParsePosition parsePosition) {
        return this.b.u(str, parsePosition);
    }

    public String toString() {
        return "FastDateFormat[" + this.a.l() + "," + this.a.k() + "," + this.a.m().getID() + "]";
    }

    protected C17263mg2(String str, TimeZone timeZone, Locale locale, Date date) {
        this.a = new C19036pg2(str, timeZone, locale);
        this.b = new C17854ng2(str, timeZone, locale, date);
    }
}
