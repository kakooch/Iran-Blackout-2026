package ir.nasim;

import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: ir.nasim.sJ6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C20618sJ6 extends AbstractC6277Mx7 {
    static final InterfaceC6537Nx7 b = new a();
    private final DateFormat a;

    /* renamed from: ir.nasim.sJ6$a */
    class a implements InterfaceC6537Nx7 {
        a() {
        }

        @Override // ir.nasim.InterfaceC6537Nx7
        public AbstractC6277Mx7 b(KS2 ks2, TypeToken typeToken) {
            a aVar = null;
            if (typeToken.c() == Time.class) {
                return new C20618sJ6(aVar);
            }
            return null;
        }
    }

    /* synthetic */ C20618sJ6(a aVar) {
        this();
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Time b(C12523el3 c12523el3) throws IOException {
        Time time;
        if (c12523el3.G() == EnumC16723ll3.NULL) {
            c12523el3.u();
            return null;
        }
        String strT0 = c12523el3.T0();
        try {
            synchronized (this) {
                time = new Time(this.a.parse(strT0).getTime());
            }
            return time;
        } catch (ParseException e) {
            throw new JsonSyntaxException("Failed parsing '" + strT0 + "' as SQL Time; at path " + c12523el3.k(), e);
        }
    }

    @Override // ir.nasim.AbstractC6277Mx7
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(C22155ul3 c22155ul3, Time time) throws IOException {
        String str;
        if (time == null) {
            c22155ul3.s();
            return;
        }
        synchronized (this) {
            str = this.a.format((Date) time);
        }
        c22155ul3.X(str);
    }

    private C20618sJ6() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }
}
