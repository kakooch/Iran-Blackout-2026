package ir.nasim;

import android.gov.nist.core.Separators;
import android.javax.sip.PeerUnavailableException;
import java.util.Hashtable;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class JD6 {
    private static JD6 g;
    private String a = "gov.nist";
    private B64 c = null;
    private LU2 d = null;
    private InterfaceC17200ma e = null;
    private final LinkedList f = new LinkedList();
    private Hashtable b = new Hashtable();

    private JD6() {
    }

    private Object b(String str) throws PeerUnavailableException {
        str.getClass();
        try {
            return Class.forName(d() + Separators.DOT + str).newInstance();
        } catch (Exception e) {
            throw new PeerUnavailableException("The Peer Factory: " + d() + Separators.DOT + str + " could not be instantiated. Ensure the Path Name has been set.", e);
        }
    }

    public static synchronized JD6 c() {
        try {
            if (g == null) {
                g = new JD6();
            }
        } catch (Throwable th) {
            throw th;
        }
        return g;
    }

    public LU2 a() {
        if (this.d == null) {
            this.d = (LU2) b("javax.sip.header.HeaderFactoryImpl");
        }
        return this.d;
    }

    public String d() {
        return this.a;
    }
}
