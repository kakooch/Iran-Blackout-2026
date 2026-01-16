package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class i extends e {
    private static final Pattern a = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final g b;
    private ac d;
    private ax h;
    private final List<s> c = new ArrayList();
    private boolean e = false;
    private boolean f = false;
    private final String g = UUID.randomUUID().toString();

    i(f fVar, g gVar) {
        this.b = gVar;
        l(null);
        if (gVar.h() == h.HTML || gVar.h() == h.JAVASCRIPT) {
            this.d = new ad(gVar.e());
        } else {
            this.d = new af(gVar.d(), null);
        }
        this.d.a();
        p.a().b(this);
        v.a().b(this.d.d(), fVar.a());
    }

    private final void l(View view) {
        this.h = new ax(view);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.e
    public final void a() throws JSONException {
        if (this.e) {
            return;
        }
        this.e = true;
        p.a().c(this);
        this.d.j(w.a().f());
        this.d.h(this, this.b);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.e
    public final void b(View view) {
        if (this.f) {
            return;
        }
        ih.b(view, "AdView is null");
        if (j() == view) {
            return;
        }
        l(view);
        this.d.k();
        Collection<i> collectionE = p.a().e();
        if (collectionE == null || collectionE.size() <= 0) {
            return;
        }
        for (i iVar : collectionE) {
            if (iVar != this && iVar.j() == view) {
                iVar.h.clear();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.e
    public final void c() {
        if (this.f) {
            return;
        }
        this.h.clear();
        e();
        this.f = true;
        v.a().d(this.d.d());
        p.a().d(this);
        this.d.b();
        this.d = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.e
    public final void d(View view, k kVar, String str) {
        s next;
        if (this.f) {
            return;
        }
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (str != null && (str.length() > 50 || !a.matcher(str).matches())) {
            throw new IllegalArgumentException("FriendlyObstruction has improperly formatted detailed reason");
        }
        Iterator<s> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (next.d().get() == view) {
                    break;
                }
            }
        }
        if (next == null) {
            this.c.add(new s(view, kVar, str));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.e
    public final void e() {
        if (this.f) {
            return;
        }
        this.c.clear();
    }

    public final List<s> g() {
        return this.c;
    }

    public final ac h() {
        return this.d;
    }

    public final String i() {
        return this.g;
    }

    public final View j() {
        return this.h.get();
    }

    public final boolean k() {
        return this.e && !this.f;
    }
}
