package ir.nasim;

import android.gov.nist.core.Separators;
import android.os.Build;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.util.Base64;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class I88 implements E88 {
    private static final a d = new a(null);
    public static final int e = 8;
    private final C15346jR a;
    private String b;
    private Long c;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public I88(C15346jR c15346jR) {
        AbstractC13042fc3.i(c15346jR, "authModule");
        this.a = c15346jR;
    }

    private final String c(String str) {
        byte[] bArrDecode = Build.VERSION.SDK_INT >= 26 ? Base64.getUrlDecoder().decode(str) : android.util.Base64.decode(str, 10);
        AbstractC13042fc3.f(bArrDecode);
        return new String(bArrDecode, C12275eL0.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(I88 i88, String str) {
        AbstractC13042fc3.i(i88, "this$0");
        i88.b = str;
        i88.c = null;
        return C19938rB7.a;
    }

    private final boolean e() {
        if (this.b == null) {
            return true;
        }
        f();
        if (this.c == null) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
        long j2 = jCurrentTimeMillis / j;
        Long l = this.c;
        if (l != null) {
            return l.longValue() < j2 / j;
        }
        return false;
    }

    private final void f() {
        if (this.c != null) {
            return;
        }
        try {
            String str = this.b;
            if (str == null) {
                str = "";
            }
            List listN0 = AbstractC20762sZ6.N0(str, new String[]{Separators.DOT}, false, 0, 6, null);
            if (listN0.size() != 3) {
                this.c = null;
                return;
            }
            JSONObject jSONObject = new JSONObject(c((String) listN0.get(1)));
            if (jSONObject.has("exp")) {
                this.c = Long.valueOf(jSONObject.getLong("exp"));
            } else {
                this.c = null;
            }
        } catch (Exception e2) {
            this.c = null;
            C19406qI3.c("WebViewRepositoryImpl", "error = ", e2);
        }
    }

    @Override // ir.nasim.E88
    public String a() {
        String str = this.b;
        if (str != null && !AbstractC20762sZ6.n0(str) && !e()) {
            return this.b;
        }
        init();
        return null;
    }

    @Override // ir.nasim.E88
    public void init() {
        this.a.g().h0(new InterfaceC17569nB2() { // from class: ir.nasim.H88
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return I88.d(this.a, (String) obj);
            }
        });
    }
}
