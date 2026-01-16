package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: ir.nasim.nr7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC17969nr7 {
    private static final C22580vU2 a = C22580vU2.g();
    private static Boolean b = Boolean.FALSE;
    private static Long c = 0L;
    private static final ReentrantLock d = new ReentrantLock();

    /* renamed from: ir.nasim.nr7$a */
    class a implements Callback {
        final /* synthetic */ InterfaceC17569nB2 a;

        a(InterfaceC17569nB2 interfaceC17569nB2) {
            this.a = interfaceC17569nB2;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.a.apply(Boolean.FALSE);
            C19406qI3.b("TASH", "Getting h list is failed, Error: \n" + iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            try {
                if (!response.isSuccessful()) {
                    this.a.apply(Boolean.FALSE);
                    C19406qI3.b("TASH", "Getting h list is failed, Code: \n" + response.code());
                    return;
                }
                ResponseBody responseBodyBody = response.body();
                if (responseBodyBody == null) {
                    C19406qI3.d("NON_FATAL_EXCEPTION", new Exception("Hashes list content is null!"));
                    return;
                }
                String str = response.headers().get("signBale");
                byte[] bArrBytes = responseBodyBody.bytes();
                if (!(str != null ? AbstractC6028Lw1.e(AbstractC22589vV2.a("1e89fe4deb27e7c663a03fe76117f9af18b514037019afd21e1de441135b5f24"), bArrBytes, AbstractC22589vV2.a(str.toLowerCase())) : false)) {
                    C19406qI3.b("TASH", "There have been issues with pkh");
                    return;
                }
                C13149fk3 c13149fk3 = (C13149fk3) C19231q00.b.a().k(new String(bArrBytes), C13149fk3.class);
                ArrayList arrayList = new ArrayList();
                Iterator it = c13149fk3.iterator();
                while (it.hasNext()) {
                    C19231q00 c19231q00 = new C19231q00(((AbstractC22735vk3) it.next()).o());
                    String strO = c19231q00.o("host", "");
                    String strN = c19231q00.n("known_ip");
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it2 = c19231q00.h("hashes").iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((AbstractC22735vk3) it2.next()).v());
                    }
                    arrayList.add(new C20713sU2(strO, strN, arrayList2));
                }
                AbstractC17969nr7.a.j(arrayList);
                this.a.apply(Boolean.TRUE);
            } catch (Exception e) {
                this.a.apply(Boolean.FALSE);
                C19406qI3.d("TASH", e);
            }
        }
    }

    public static List d() {
        ArrayList arrayList = new ArrayList();
        Map mapE = a.e();
        Iterator it = mapE.keySet().iterator();
        while (it.hasNext()) {
            for (String str : ((C20713sU2) mapE.get((String) it.next())).a()) {
                if (!arrayList.contains(str)) {
                    arrayList.add("SHA256:" + str);
                }
            }
        }
        return arrayList;
    }

    public static C6517Nv5 e() {
        return new C6517Nv5(new InterfaceC6990Pv5() { // from class: ir.nasim.lr7
            @Override // ir.nasim.InterfaceC6990Pv5
            public final void a(C7234Qv5 c7234Qv5) {
                AbstractC17969nr7.h(c7234Qv5);
            }
        });
    }

    public static List f(String str) {
        Map mapE = a.e();
        return mapE.containsKey(str) ? new ArrayList(((C20713sU2) mapE.get(str)).a()) : new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void g(C7234Qv5 c7234Qv5, Boolean bool) {
        if (bool.booleanValue()) {
            b = Boolean.TRUE;
            C13916h22.e();
        }
        c7234Qv5.b(bool);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(final C7234Qv5 c7234Qv5) {
        C19406qI3.a("TASH", "Getting fresh hs from endpoint", new Object[0]);
        if (b.booleanValue()) {
            c7234Qv5.b(Boolean.TRUE);
        } else {
            j(new InterfaceC17569nB2() { // from class: ir.nasim.mr7
                @Override // ir.nasim.InterfaceC17569nB2
                public final Object apply(Object obj) {
                    return AbstractC17969nr7.g(c7234Qv5, (Boolean) obj);
                }
            });
        }
    }

    public static boolean i() {
        try {
            ReentrantLock reentrantLock = d;
            reentrantLock.lock();
            if (System.currentTimeMillis() - c.longValue() < 5000) {
                reentrantLock.unlock();
                return false;
            }
            c = Long.valueOf(System.currentTimeMillis());
            b = Boolean.FALSE;
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            d.unlock();
            throw th;
        }
    }

    public static void j(InterfaceC17569nB2 interfaceC17569nB2) {
        XS2.a().newCall(new Request.Builder().url("http://hash.bale.ai/hashes-android.json").build()).enqueue(new a(interfaceC17569nB2));
    }
}
