package ir.nasim;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: ir.nasim.ag8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC9861ag8 implements Runnable {
    private static final LI3 c = new LI3("RevokeAccessOperation", new String[0]);
    private final String a;
    private final C21922uM6 b = new C21922uM6(null);

    public RunnableC9861ag8(String str) {
        this.a = AbstractC3795Cj5.f(str);
    }

    public static AbstractC22929w35 a(String str) {
        if (str == null) {
            return AbstractC24109y35.a(new Status(4), null);
        }
        RunnableC9861ag8 runnableC9861ag8 = new RunnableC9861ag8(str);
        new Thread(runnableC9861ag8).start();
        return runnableC9861ag8.b;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Status status = Status.h;
        try {
            String strValueOf = String.valueOf(this.a);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strValueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(strValueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty(SIPHeaderNames.CONTENT_TYPE, "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f;
            } else {
                c.b("Unable to revoke access!", new Object[0]);
            }
            LI3 li3 = c;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            li3.a(sb.toString(), new Object[0]);
        } catch (IOException e) {
            LI3 li32 = c;
            String strValueOf2 = String.valueOf(e.toString());
            li32.b(strValueOf2.length() != 0 ? "IOException when revoking access: ".concat(strValueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e2) {
            LI3 li33 = c;
            String strValueOf3 = String.valueOf(e2.toString());
            li33.b(strValueOf3.length() != 0 ? "Exception when revoking access: ".concat(strValueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.b.setResult(status);
    }
}
