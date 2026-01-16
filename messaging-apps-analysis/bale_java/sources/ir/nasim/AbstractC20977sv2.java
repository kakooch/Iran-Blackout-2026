package ir.nasim;

import java.text.Format;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: ir.nasim.sv2, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
abstract class AbstractC20977sv2 {
    private static final ConcurrentMap b = new ConcurrentHashMap(7);
    private final ConcurrentMap a = new ConcurrentHashMap(7);

    /* renamed from: ir.nasim.sv2$a */
    private static class a {
        private final Object[] a;
        private int b;

        public a(Object... objArr) {
            this.a = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.a, ((a) obj).a);
        }

        public int hashCode() {
            if (this.b == 0) {
                int iHashCode = 0;
                for (Object obj : this.a) {
                    if (obj != null) {
                        iHashCode = (iHashCode * 7) + obj.hashCode();
                    }
                }
                this.b = iHashCode;
            }
            return this.b;
        }
    }

    AbstractC20977sv2() {
    }

    protected abstract Format a(String str, TimeZone timeZone, Locale locale);

    public Format b(String str, TimeZone timeZone, Locale locale) {
        if (str == null) {
            throw new NullPointerException("pattern must not be null");
        }
        if (timeZone == null) {
            timeZone = TimeZone.getDefault();
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        a aVar = new a(str, timeZone, locale);
        Format format = (Format) this.a.get(aVar);
        if (format != null) {
            return format;
        }
        Format formatA = a(str, timeZone, locale);
        Format format2 = (Format) this.a.putIfAbsent(aVar, formatA);
        return format2 != null ? format2 : formatA;
    }
}
