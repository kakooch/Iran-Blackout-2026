package ir.nasim;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class ID1 extends AbstractC6277Mx7 {
    private final b a;
    private final List b;

    private Date e(C12523el3 c12523el3) throws IOException {
        String strT0 = c12523el3.T0();
        synchronized (this.b) {
            try {
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    try {
                        return ((DateFormat) it.next()).parse(strT0);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return AbstractC9462a03.c(strT0, new ParsePosition(0));
                } catch (ParseException e) {
                    throw new JsonSyntaxException("Failed parsing '" + strT0 + "' as Date; at path " + c12523el3.k(), e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Date b(C12523el3 c12523el3) throws IOException {
        if (c12523el3.G() == EnumC16723ll3.NULL) {
            c12523el3.u();
            return null;
        }
        return this.a.d(e(c12523el3));
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, Date date) throws IOException {
        String str;
        if (date == null) {
            c22155ul3.s();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        synchronized (this.b) {
            str = dateFormat.format(date);
        }
        c22155ul3.X(str);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private ID1(b bVar, String str) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Objects.requireNonNull(bVar);
        this.a = bVar;
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    private ID1(b bVar, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Objects.requireNonNull(bVar);
        this.a = bVar;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (AbstractC9299Zi3.d()) {
            arrayList.add(AbstractC17887nj5.c(i, i2));
        }
    }

    public static abstract class b {
        public static final b b = new a(Date.class);
        private final Class a;

        protected b(Class cls) {
            this.a = cls;
        }

        private InterfaceC6537Nx7 c(ID1 id1) {
            return AbstractC7010Px7.b(this.a, id1);
        }

        public final InterfaceC6537Nx7 a(int i, int i2) {
            return c(new ID1(this, i, i2));
        }

        public final InterfaceC6537Nx7 b(String str) {
            return c(new ID1(this, str));
        }

        protected abstract Date d(Date date);

        class a extends b {
            a(Class cls) {
                super(cls);
            }

            @Override // ir.nasim.ID1.b
            protected Date d(Date date) {
                return date;
            }
        }
    }
}
