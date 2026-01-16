package ir.nasim;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: ir.nasim.eJ2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C12259eJ2 extends AbstractC6360Ng4 {

    /* renamed from: ir.nasim.eJ2$a */
    public static final class a {
    }

    public C12259eJ2(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
    }

    private final void h0() {
        String name;
        try {
            Response responseExecute = XS2.c(null, 1, null).newCall(new Request.Builder().url("https://assets.bale.ai/configs.json").build()).execute();
            if (responseExecute.code() != 200) {
                AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.cJ2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12259eJ2.k0();
                    }
                });
                return;
            }
            ResponseBody responseBodyBody = responseExecute.body();
            AbstractC13042fc3.f(responseBodyBody);
            C19231q00 c19231q00 = new C19231q00(new String(responseBodyBody.bytes(), C12275eL0.b));
            EnumC18608ow5 enumC18608ow5 = EnumC18608ow5.h;
            boolean zD = ZI2.d(C7183Qq.q(enumC18608ow5).e("PREF_JSON_FORCE_UPDATE"), 0L, 0, 6, null);
            C7183Qq.q(enumC18608ow5).clear();
            C7183Qq.q(enumC18608ow5).putString("PREF_JSON_FORCE_UPDATE", c19231q00.toString());
            boolean zD2 = ZI2.d(c19231q00.toString(), 0L, 0, 6, null);
            if (!zD2 || zD == zD2) {
                AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.bJ2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12259eJ2.j0();
                    }
                });
            } else {
                AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.aJ2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C12259eJ2.i0();
                    }
                });
            }
            ZI2.a.a(c19231q00.l());
        } catch (Exception e) {
            AbstractC20507s76.C(new Runnable() { // from class: ir.nasim.dJ2
                @Override // java.lang.Runnable
                public final void run() {
                    C12259eJ2.l0();
                }
            });
            if (C12259eJ2.class.isAnonymousClass()) {
                name = C12259eJ2.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C12259eJ2.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0() {
        C15225jD4.b().c(C15225jD4.m, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0() {
        C15225jD4.b().c(C15225jD4.m, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0() {
        C15225jD4.b().c(C15225jD4.m, Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0() {
        C15225jD4.b().c(C15225jD4.m, Boolean.FALSE);
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) {
        if (obj instanceof a) {
            h0();
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        q(new a(), 3000L);
    }
}
