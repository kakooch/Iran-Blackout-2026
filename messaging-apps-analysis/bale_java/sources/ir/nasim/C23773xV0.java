package ir.nasim;

import android.accounts.Account;
import android.view.View;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: ir.nasim.xV0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23773xV0 {
    private final Account a;
    private final Set b;
    private final Set c;
    private final Map d;
    private final int e;
    private final View f;
    private final String g;
    private final String h;
    private final QB6 i;
    private Integer j;

    /* renamed from: ir.nasim.xV0$a */
    public static final class a {
        private Account a;
        private PJ b;
        private String c;
        private String d;
        private QB6 e = QB6.j;

        public C23773xV0 a() {
            return new C23773xV0(this.a, this.b, null, 0, null, this.c, this.d, this.e, false);
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.b == null) {
                this.b = new PJ();
            }
            this.b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.a = account;
            return this;
        }

        public final a e(String str) {
            this.d = str;
            return this;
        }
    }

    public C23773xV0(Account account, Set set, Map map, int i, View view, String str, String str2, QB6 qb6, boolean z) {
        this.a = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.b = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.d = map;
        this.f = view;
        this.e = i;
        this.g = str;
        this.h = str2;
        this.i = qb6 == null ? QB6.j : qb6;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        this.c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.a;
    }

    public String b() {
        Account account = this.a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account c() {
        Account account = this.a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set d() {
        return this.c;
    }

    public Set e(com.google.android.gms.common.api.a aVar) {
        AbstractC18350oW3.a(this.d.get(aVar));
        return this.b;
    }

    public String f() {
        return this.g;
    }

    public Set g() {
        return this.b;
    }

    public final QB6 h() {
        return this.i;
    }

    public final Integer i() {
        return this.j;
    }

    public final String j() {
        return this.h;
    }

    public final void k(Integer num) {
        this.j = num;
    }
}
