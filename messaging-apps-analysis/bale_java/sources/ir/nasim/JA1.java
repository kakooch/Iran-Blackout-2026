package ir.nasim;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class JA1 extends AbstractC6277Mx7 {
    public static final InterfaceC6537Nx7 b = new a();
    private final List a;

    class a implements InterfaceC6537Nx7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            if (typeToken.c() == Date.class) {
                return new JA1();
            }
            return null;
        }
    }

    public JA1() {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (AbstractC9299Zi3.d()) {
            arrayList.add(AbstractC17887nj5.c(2, 2));
        }
    }

    private Date e(C12523el3 c12523el3) throws IOException {
        String strT0 = c12523el3.T0();
        synchronized (this.a) {
            try {
                Iterator it = this.a.iterator();
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
        if (c12523el3.G() != EnumC16723ll3.NULL) {
            return e(c12523el3);
        }
        c12523el3.u();
        return null;
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, Date date) throws IOException {
        String str;
        if (date == null) {
            c22155ul3.s();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.a.get(0);
        synchronized (this.a) {
            str = dateFormat.format(date);
        }
        c22155ul3.X(str);
    }
}
