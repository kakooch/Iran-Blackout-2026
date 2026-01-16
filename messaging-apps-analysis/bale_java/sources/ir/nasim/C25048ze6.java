package ir.nasim;

import android.gov.nist.javax.sdp.parser.SDPAnnounceParser;
import android.javax.sdp.SdpParseException;
import java.text.ParseException;
import java.util.Date;

/* renamed from: ir.nasim.ze6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C25048ze6 {
    private static final C25048ze6 a = new C25048ze6();

    private C25048ze6() {
    }

    public static Date b(long j) {
        return new Date((j - 2208988800L) * 1000);
    }

    public static C25048ze6 c() {
        return a;
    }

    public static long d(Date date) {
        if (date == null) {
            return -1L;
        }
        return (date.getTime() / 1000) + 2208988800L;
    }

    public InterfaceC8892Xt6 a(String str) throws SdpParseException {
        try {
            return new SDPAnnounceParser(str).parse();
        } catch (ParseException e) {
            e.printStackTrace();
            throw new SdpParseException(0, 0, "Could not parse message");
        }
    }
}
