package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.B86;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.kT2, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15958kT2 {
    public static final a e = new a(null);
    public static final int f = 8;
    private static C15958kT2 g;
    private final B86 a;
    private String b;
    private long c;
    private long d;

    /* renamed from: ir.nasim.kT2$a */
    public static final class a {
        private a() {
        }

        public final C15958kT2 a(B86 b86) {
            AbstractC13042fc3.i(b86, "queryPush");
            if (C15958kT2.g == null) {
                synchronized (C15958kT2.class) {
                    try {
                        if (C15958kT2.g == null) {
                            C15958kT2.g = new C15958kT2(b86, null);
                        }
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            C15958kT2 c15958kT2 = C15958kT2.g;
            AbstractC13042fc3.g(c15958kT2, "null cannot be cast to non-null type ir.nasim.features.firebase.newPush.HandlePushDatabase");
            return c15958kT2;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C15958kT2(B86 b86, ED1 ed1) {
        this(b86);
    }

    private final void c(B86.a aVar) {
        this.a.e(aVar);
    }

    private final void d(List list) {
        this.a.f(list);
    }

    private final B86.a e(long j) {
        return this.a.l(j);
    }

    public final boolean f(Map map) {
        Long lQ;
        Long lQ2;
        Long lQ3;
        String strM;
        String strM2;
        List listM;
        Long lQ4;
        AbstractC13042fc3.i(map, "data");
        List listM2 = AbstractC10360bX0.m();
        long jLongValue = 0;
        if (map.containsKey("peer_user_id")) {
            this.b = TokenNames.MESSAGE;
            String str = (String) map.get("messageDate");
            if (str != null && (lQ4 = AbstractC19562qZ6.q(str)) != null) {
                jLongValue = lQ4.longValue();
            }
            this.c = jLongValue;
        } else if (map.containsKey("update_peer_user_id")) {
            String str2 = (String) map.get("pushType");
            if (str2 == null) {
                str2 = "";
            }
            this.b = str2;
            int iHashCode = str2.hashCode();
            if (iHashCode != 2123274) {
                if (iHashCode != 2511254) {
                    if (iHashCode == 2012838315 && str2.equals("DELETE")) {
                        String str3 = (String) map.get("messageDates");
                        listM2 = (str3 == null || (strM = AbstractC20153rZ6.M(str3, "[", "", false, 4, null)) == null || (strM2 = AbstractC20153rZ6.M(strM, "]", "", false, 4, null)) == null) ? null : AbstractC20762sZ6.N0(strM2, new String[]{","}, false, 0, 6, null);
                    }
                } else if (str2.equals("READ")) {
                    String str4 = (String) map.get("messageDate");
                    if (str4 != null && (lQ3 = AbstractC19562qZ6.q(str4)) != null) {
                        jLongValue = lQ3.longValue();
                    }
                    this.c = jLongValue;
                }
            } else if (str2.equals("EDIT")) {
                String str5 = (String) map.get("pushSendTime");
                this.d = (str5 == null || (lQ2 = AbstractC19562qZ6.q(str5)) == null) ? 0L : lQ2.longValue();
                String str6 = (String) map.get("messageDate");
                if (str6 != null && (lQ = AbstractC19562qZ6.q(str6)) != null) {
                    jLongValue = lQ.longValue();
                }
                this.c = jLongValue;
                return true;
            }
        }
        B86.a aVarE = e(this.c);
        if (aVarE == null) {
            if (listM2 == null || !(!listM2.isEmpty())) {
                c(new B86.a(this.c, this.b, 0L, 4, null));
            } else {
                List list = listM2;
                ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new B86.a(Long.parseLong((String) it.next()), this.b, this.d));
                }
                d(arrayList);
            }
            return true;
        }
        B86.a aVar = new B86.a(this.c, this.b, this.d);
        if (AbstractC13042fc3.d(aVar.c(), "DELETE")) {
            if (listM2 != null) {
                List list2 = listM2;
                listM = new ArrayList(AbstractC10976cX0.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    listM.add(new B86.a(Long.parseLong((String) it2.next()), this.b, this.d));
                }
            } else {
                listM = AbstractC10360bX0.m();
            }
            d(listM);
            return true;
        }
        if (!AbstractC13042fc3.d(aVar.c(), "READ")) {
            if (!AbstractC13042fc3.d(aVar.c(), TokenNames.MESSAGE)) {
                return true;
            }
            C19406qI3.j("HandlePushDatabase", "current type == MESSAGE, so return false", new Object[0]);
            return false;
        }
        if (AbstractC13042fc3.d(aVarE.c(), "DELETE")) {
            C19406qI3.j("HandlePushDatabase", "previous pushType == DELETE, so return false", new Object[0]);
            return false;
        }
        c(aVar);
        return true;
    }

    public final C12118e42 g() {
        boolean z;
        B86.a aVarE = e(this.c);
        String str = TokenNames.MESSAGE;
        if (aVarE == null) {
            z = true;
        } else {
            z = false;
            if (aVarE.b() >= 0) {
                z = !AbstractC13042fc3.d(this.b, TokenNames.MESSAGE) && aVarE.b() < this.d;
                str = "EDIT";
            }
        }
        if (z) {
            c(new B86.a(this.c, "EDIT", this.d));
        }
        return new C12118e42(z, str, z);
    }

    private C15958kT2(B86 b86) {
        this.a = b86;
        this.b = "";
        this.d = -1L;
    }
}
