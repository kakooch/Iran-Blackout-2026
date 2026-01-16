package ir.nasim;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: ir.nasim.rJ6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C20009rJ6 extends AbstractC6277Mx7 {
    static final InterfaceC6537Nx7 b = new a();
    private final DateFormat a;

    /* renamed from: ir.nasim.rJ6$a */
    class a implements InterfaceC6537Nx7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.c() == Date.class) {
                return new C20009rJ6(aVar);
            }
            return null;
        }
    }

    /* synthetic */ C20009rJ6(a aVar) {
        this();
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Date b(C12523el3 c12523el3) throws IOException {
        java.util.Date date;
        if (c12523el3.G() == EnumC16723ll3.NULL) {
            c12523el3.u();
            return null;
        }
        String strT0 = c12523el3.T0();
        try {
            synchronized (this) {
                date = this.a.parse(strT0);
            }
            return new Date(date.getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException("Failed parsing '" + strT0 + "' as SQL Date; at path " + c12523el3.k(), e);
        }
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, Date date) throws IOException {
        String str;
        if (date == null) {
            c22155ul3.s();
            return;
        }
        synchronized (this) {
            str = this.a.format((java.util.Date) date);
        }
        c22155ul3.X(str);
    }

    private C20009rJ6() {
        this.a = new SimpleDateFormat("MMM d, yyyy");
    }
}
