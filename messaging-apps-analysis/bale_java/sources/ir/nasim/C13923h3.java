package ir.nasim;

import ir.nasim.core.runtime.AccountInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.h3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13923h3 {
    public static final C13923h3 a;
    private static final InterfaceC9173Yu3 b;
    private static final InterfaceC9173Yu3 c;
    private static int d;
    private static InterfaceC3570Bk5 e;

    static {
        C13923h3 c13923h3 = new C13923h3();
        a = c13923h3;
        b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.f3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return Integer.valueOf(C13923h3.c());
            }
        });
        c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.g3
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C13923h3.d();
            }
        });
        d = c13923h3.j().getInt("default_account", 0);
        InterfaceC3570Bk5 interfaceC3570Bk5L = c13923h3.l();
        AbstractC13042fc3.h(interfaceC3570Bk5L, "getActiveAccountInfoPref(...)");
        e = interfaceC3570Bk5L;
    }

    private C13923h3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c() {
        return ((InterfaceC14516i3) C92.a(C5721Ko.a.d(), InterfaceC14516i3.class)).n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC3570Bk5 d() {
        return C7183Qq.r("active_info.ini");
    }

    private final InterfaceC3570Bk5 l() {
        return C7183Qq.r(p());
    }

    public static final String p() {
        return q(d);
    }

    public static final String q(int i) {
        return r(String.valueOf(i));
    }

    public static final String r(String str) {
        AbstractC13042fc3.i(str, "uid");
        return str + "_default_pref.ini";
    }

    public final void e(AccountInfo accountInfo) {
        AbstractC13042fc3.i(accountInfo, "account");
        InterfaceC3570Bk5 interfaceC3570Bk5R = C7183Qq.r(q(accountInfo.getUid()));
        interfaceC3570Bk5R.g("is_auth_complete", accountInfo.getIsAuthCompleted());
        interfaceC3570Bk5R.putInt("auth_uid", accountInfo.getUid());
        interfaceC3570Bk5R.putString("auth_jwt", accountInfo.getJwt());
        interfaceC3570Bk5R.putLong("auth_phone", accountInfo.getPhone());
        interfaceC3570Bk5R.putLong("auth_access_hash", accountInfo.getAccessHash());
        interfaceC3570Bk5R.putLong("auth_id", accountInfo.getAuthId());
        interfaceC3570Bk5R.f("auth_master_key", accountInfo.getMasterKey());
        interfaceC3570Bk5R.f("auth_user", accountInfo.getUser());
        interfaceC3570Bk5R.g("sync_account", accountInfo.getSyncContacts());
        Set setL = j().l("users_login");
        setL.add(String.valueOf(accountInfo.getUid()));
        j().putStringSet("users_login", setL);
    }

    public final void f(int i) {
        j().c("default_account", i);
        d = i;
        e = l();
    }

    public final void g() {
        j().putStringSet("users_login", AbstractC4597Fu6.d());
    }

    public final AccountInfo h(InterfaceC3570Bk5 interfaceC3570Bk5) {
        AbstractC13042fc3.i(interfaceC3570Bk5, "prefStorage");
        return new AccountInfo(interfaceC3570Bk5.h("is_auth_complete", false), interfaceC3570Bk5.getInt("auth_uid", 0), interfaceC3570Bk5.getString("auth_jwt", ""), interfaceC3570Bk5.getLong("auth_phone", 0L), interfaceC3570Bk5.getLong("auth_access_hash", 0L), interfaceC3570Bk5.getLong("auth_id", 0L), interfaceC3570Bk5.b("auth_master_key"), interfaceC3570Bk5.b("auth_user"), interfaceC3570Bk5.h("sync_account", true));
    }

    public final AccountInfo i(int i) {
        InterfaceC3570Bk5 interfaceC3570Bk5R = C7183Qq.r(q(i));
        AbstractC13042fc3.h(interfaceC3570Bk5R, "getInstance(...)");
        return h(interfaceC3570Bk5R);
    }

    public final InterfaceC3570Bk5 j() {
        Object value = c.getValue();
        AbstractC13042fc3.h(value, "getValue(...)");
        return (InterfaceC3570Bk5) value;
    }

    public final AccountInfo k() {
        return h(e);
    }

    public final int m() {
        return d;
    }

    public final List n() {
        ArrayList arrayList = new ArrayList();
        for (String str : o()) {
            C13923h3 c13923h3 = a;
            InterfaceC3570Bk5 interfaceC3570Bk5R = C7183Qq.r(q(Integer.parseInt(str)));
            AbstractC13042fc3.h(interfaceC3570Bk5R, "getInstance(...)");
            arrayList.add(c13923h3.h(interfaceC3570Bk5R));
        }
        return arrayList;
    }

    public final Set o() {
        Set setL = j().l("users_login");
        AbstractC13042fc3.h(setL, "getStringSet(...)");
        return setL;
    }

    public final int s() {
        return ((Number) b.getValue()).intValue();
    }

    public final boolean t() {
        return d != 0;
    }

    public final void v() {
        Set setO = o();
        if (setO.size() == 1) {
            j().clear();
            return;
        }
        setO.remove(String.valueOf(d));
        j().putStringSet("users_login", setO);
        if (!setO.isEmpty()) {
            f(Integer.parseInt((String) AbstractC15401jX0.p0(setO)));
        } else {
            f(0);
        }
    }

    public final void w(int i) {
        d = i;
    }

    public final void x(boolean z) {
        AccountInfo accountInfoK = k();
        e(accountInfoK.b((510 & 1) != 0 ? accountInfoK.isAuthCompleted : z, (510 & 2) != 0 ? accountInfoK.uid : 0, (510 & 4) != 0 ? accountInfoK.jwt : null, (510 & 8) != 0 ? accountInfoK.phone : 0L, (510 & 16) != 0 ? accountInfoK.accessHash : 0L, (510 & 32) != 0 ? accountInfoK.authId : 0L, (510 & 64) != 0 ? accountInfoK.masterKey : null, (510 & 128) != 0 ? accountInfoK.user : null, (510 & 256) != 0 ? accountInfoK.syncContacts : false));
    }

    public final void y(boolean z) {
        e.g("sync_account", z);
    }

    public final void u() {
    }
}
