package ir.nasim.core.modules.banking;

import android.gov.nist.javax.sip.header.SIPHeaderNames;
import ir.nasim.AbstractC22735vk3;
import ir.nasim.AbstractC6360Ng4;
import ir.nasim.C13149fk3;
import ir.nasim.C14505i18;
import ir.nasim.C14582i90;
import ir.nasim.C19014pe0;
import ir.nasim.C19231q00;
import ir.nasim.C19406qI3;
import ir.nasim.C6517Nv5;
import ir.nasim.C8542Wk3;
import ir.nasim.C9057Yh4;
import ir.nasim.EnumC15044iu7;
import ir.nasim.InterfaceC15283jK;
import ir.nasim.InterfaceC17569nB2;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.M15;
import ir.nasim.PH3;
import ir.nasim.XS2;
import ir.nasim.XY6;
import ir.nasim.ZS2;
import ir.nasim.core.runtime.http.HTTPError;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes5.dex */
public class r extends AbstractC6360Ng4 {
    private final String m;
    private final String n;
    private final C9057Yh4 o;

    static class a implements InterfaceC15283jK {
        String a;
        String b;
        String c;

        public a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    static class b implements InterfaceC15283jK {
        String a;
        ir.nasim.core.modules.banking.a b;
        String c;

        b(String str, String str2, String str3, String str4, String str5, String str6) {
            this.b = new ir.nasim.core.modules.banking.a(str, str3, str2, str4);
            this.a = str5;
            this.c = str6;
        }
    }

    public static class c implements InterfaceC15283jK {
        ir.nasim.core.modules.banking.a a;
        String b;
        String c;
        String d;

        public c(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.a = new ir.nasim.core.modules.banking.a(str, str3, str2, str4);
            this.b = str5;
            this.c = str6;
            this.d = str7;
        }
    }

    static class d implements InterfaceC15283jK {
        ir.nasim.core.modules.banking.a a;
        String b;
        String c;

        public d(String str, String str2, String str3, String str4, String str5, String str6) {
            this.a = new ir.nasim.core.modules.banking.a(str, str2, str3, str4);
            this.b = str5;
            this.c = str6;
        }
    }

    static class e implements InterfaceC15283jK {
        String a;
        long b;
        String c;

        e(String str, long j, String str2) {
            this.a = str;
            this.b = j;
            this.c = str2;
        }
    }

    public static class f implements InterfaceC15283jK {
        String a;
        String b;
        int c;
        long d;
        String e;
        String f;

        public f(String str, String str2, int i, long j, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = j;
            this.e = str3;
            this.f = str4;
        }
    }

    public r(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.m = "TransactorActor";
        this.n = "TransactorActorType2";
        this.o = c9057Yh4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(Exception exc) {
        C19406qI3.d("TransactorActor", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 B0(ZS2 zs2) {
        String str;
        if (zs2.a() == 200) {
            try {
                str = new String(zs2.b(), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                C19406qI3.d("TransactorActor", e2);
                str = null;
            }
            try {
                C19231q00 c19231q00 = new C19231q00(str);
                return c19231q00.i("isSuccessful", false) ? C6517Nv5.l0(new k(null, c19231q00.n(DialogEntity.COLUMN_MESSAGE))) : C6517Nv5.l0(new k(c19231q00.n(DialogEntity.COLUMN_MESSAGE), null));
            } catch (Exception e3) {
                C19406qI3.d("TransactorActor", e3);
            }
        }
        return C6517Nv5.F(new HTTPError(zs2.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(Exception exc) {
        C19406qI3.d("TransactorActorType2", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 D0(ZS2 zs2) {
        String str;
        if (zs2.a() != 200) {
            return C6517Nv5.F(new HTTPError(zs2.a()));
        }
        try {
            str = new String(zs2.b(), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C19406qI3.d("TransactorActor", e2);
            str = null;
        }
        C19231q00 c19231q00 = new C19231q00(str);
        return c19231q00.k("responseCode", 0) == 0 ? C6517Nv5.l0(new M15(c19231q00.o("loanType", ""), c19231q00.o("loanNumber", ""), c19231q00.o("fullName", ""))) : PH3.e().equalsIgnoreCase("fa") ? C6517Nv5.F(new Exception(c19231q00.o("faMessage", ""))) : C6517Nv5.F(new Exception(c19231q00.o("enMessage", "")));
    }

    private C6517Nv5 E0(b bVar) {
        String str = bVar.a + "/v1/bam/loan/payment";
        C8542Wk3 c8542Wk3B = bVar.b.b();
        String strB = C14582i90.b((this.o.i0() + ":" + bVar.c).getBytes());
        return XS2.d(str, "application/json", c8542Wk3B.toString().getBytes(), new String[]{SIPHeaderNames.AUTHORIZATION}, new String[]{"Basic " + strB}, 60000).E(new InterfaceC24449ye1() { // from class: ir.nasim.ku7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.y0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.lu7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.z0((ZS2) obj);
            }
        });
    }

    private C6517Nv5 G0(e eVar) {
        String str = eVar.a + "/v1/bam/loan/verify";
        C19231q00 c19231q00E = new C19231q00().e("amount", Long.valueOf(eVar.b));
        String strB = C14582i90.b((this.o.i0() + ":" + eVar.c).getBytes());
        return XS2.d(str, "application/json", c19231q00E.toString().getBytes(), new String[]{SIPHeaderNames.AUTHORIZATION}, new String[]{"Basic " + strB}, 60000).E(new InterfaceC24449ye1() { // from class: ir.nasim.ru7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.C0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.su7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.D0((ZS2) obj);
            }
        });
    }

    private C6517Nv5 p0(a aVar) {
        String str = aVar.a + "/v1/advice";
        C19231q00 c19231q00F = new C19231q00().f("token", aVar.c);
        String strB = C14582i90.b((this.o.i0() + ":" + aVar.b).getBytes());
        return XS2.d(str, "application/json", c19231q00F.toString().getBytes(), new String[]{SIPHeaderNames.AUTHORIZATION}, new String[]{"Basic " + strB}, 60000).E(new InterfaceC24449ye1() { // from class: ir.nasim.pu7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.s0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.qu7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return ir.nasim.core.modules.banking.r.t0((ZS2) obj);
            }
        });
    }

    private C6517Nv5 q0(c cVar) {
        String str = cVar.c;
        C8542Wk3 c8542Wk3A = cVar.a.a();
        String strB = C14582i90.b((this.o.i0() + ":" + cVar.d).getBytes());
        return XS2.d(str, "application/json", c8542Wk3A.toString().getBytes(), new String[]{SIPHeaderNames.AUTHORIZATION}, new String[]{"Basic " + strB}, 60000).E(new InterfaceC24449ye1() { // from class: ir.nasim.ju7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.u0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.mu7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.v0((ZS2) obj);
            }
        });
    }

    private C6517Nv5 r0(d dVar) {
        String str = dVar.b + "/v1/bam/card_statements";
        C8542Wk3 c8542Wk3A = dVar.a.a();
        String strB = C14582i90.b((this.o.i0() + ":" + dVar.c).getBytes());
        return XS2.d(str, "application/json", c8542Wk3A.toString().getBytes(), new String[]{SIPHeaderNames.AUTHORIZATION}, new String[]{"Basic " + strB}, 60000).E(new InterfaceC24449ye1() { // from class: ir.nasim.tu7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.w0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.uu7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.x0((ZS2) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(Exception exc) {
        C19406qI3.d("TransactorActorType2", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C6517Nv5 t0(ZS2 zs2) {
        return zs2.a() == 200 ? C6517Nv5.l0(C14505i18.a) : C6517Nv5.F(new HTTPError(zs2.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(Exception exc) {
        C19406qI3.d("TransactorActorType2", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 v0(ZS2 zs2) {
        String str;
        if (zs2.a() != 200) {
            return C6517Nv5.F(new HTTPError(zs2.a()));
        }
        String str2 = null;
        try {
            str = new String(zs2.b(), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C19406qI3.d("TransactorActor", e2);
            str = null;
        }
        C19231q00 c19231q00 = new C19231q00(str);
        String strO = c19231q00.o("status", "Error in parse");
        String strO2 = c19231q00.o("currentBalanceAmount", "-1");
        String strO3 = c19231q00.o("availableBalanceAmount", "-1");
        c19231q00.o("currentBalanceType", "");
        c19231q00.o("traceNo", "");
        c19231q00.o("realtransactiondatetime", "");
        c19231q00.o("refrenceNumber", "");
        String strO4 = c19231q00.o("errorMsgEn", "");
        String strO5 = c19231q00.o("errorMsgFa", "");
        if (!strO.equals("SUCCESS")) {
            String strE = PH3.e();
            str2 = (strE == null || !strE.toLowerCase().equals("en") || strO4 == null || strO4.length() == 0) ? strO5 : strO4;
        }
        return C6517Nv5.l0(new h(str2, strO2, strO3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(Exception exc) {
        C19406qI3.d("TransactorActorType2", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 x0(ZS2 zs2) {
        String str;
        if (zs2.a() != 200) {
            return C6517Nv5.F(new HTTPError(zs2.a()));
        }
        try {
            str = new String(zs2.b(), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C19406qI3.d("TransactorActor", e2);
            str = null;
        }
        C19231q00 c19231q00 = new C19231q00(str);
        String strO = c19231q00.o("responseCode", "-1");
        String strO2 = !strO.equals("00") ? c19231q00.o("responseMessage", "Error") : "";
        c19231q00.o("traceNo", "-1");
        c19231q00.o("retrivalReferenceNumber", "-1");
        C13149fk3 c13149fk3H = c19231q00.h("billInfos");
        ArrayList arrayList = new ArrayList();
        Iterator it = c13149fk3H.iterator();
        while (it.hasNext()) {
            C19231q00 c19231q002 = new C19231q00(((AbstractC22735vk3) it.next()).o());
            arrayList.add(new C19014pe0(c19231q002.o("symbol", ""), c19231q002.o("amount", "0"), c19231q002.o("date", "0"), c19231q002.o("description", ""), true));
        }
        Collections.reverse(arrayList);
        return C6517Nv5.l0(new i(strO, strO2, arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(Exception exc) {
        C19406qI3.d("TransactorActorType2", exc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ C6517Nv5 z0(ZS2 zs2) {
        String str;
        if (zs2.a() != 200) {
            return C6517Nv5.F(new HTTPError(zs2.a()));
        }
        String strV = null;
        try {
            str = new String(zs2.b(), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C19406qI3.d("TransactorActor", e2);
            str = null;
        }
        try {
            C8542Wk3 c8542Wk3N = new C19231q00(str).g("resultSet").o().N("innerResponse");
            if (!c8542Wk3N.L("status").v().equals("SUCCEEDED")) {
                strV = c8542Wk3N.L("responseMessage").v();
            }
        } catch (Exception e3) {
            C19406qI3.d("TransactorActor", e3);
            strV = "Can't parse json.";
        }
        return C6517Nv5.l0(new j(strV));
    }

    public C6517Nv5 F0(f fVar) {
        C19231q00 c19231q00 = new C19231q00();
        boolean z = fVar.c == EnumC15044iu7.MONEY_TRANSFER.j() || !XY6.m(fVar.b);
        String str = fVar.e + (z ? "/v2" : "/v1") + "/bale/deliver_otp";
        if (z) {
            c19231q00.f("srcPan", fVar.a);
            c19231q00.f("destPan", fVar.b);
            c19231q00.e("transactionType", Integer.valueOf(fVar.c));
        } else {
            c19231q00.f("pan", fVar.a);
            c19231q00.e("transactionType", Integer.valueOf(fVar.c));
        }
        c19231q00.e("amount", Long.valueOf(fVar.d));
        String strB = C14582i90.b((this.o.i0() + ":" + fVar.f).getBytes());
        return XS2.d(str, "application/json", c19231q00.toString().getBytes(), new String[]{SIPHeaderNames.AUTHORIZATION}, new String[]{"Basic " + strB}, 60000).E(new InterfaceC24449ye1() { // from class: ir.nasim.nu7
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                this.a.A0((Exception) obj);
            }
        }).H(new InterfaceC17569nB2() { // from class: ir.nasim.ou7
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return this.a.B0((ZS2) obj);
            }
        });
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        return obj instanceof c ? q0((c) obj) : obj instanceof a ? p0((a) obj) : obj instanceof d ? r0((d) obj) : obj instanceof e ? G0((e) obj) : obj instanceof b ? E0((b) obj) : obj instanceof f ? F0((f) obj) : C6517Nv5.l0(Boolean.FALSE);
    }
}
