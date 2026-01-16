package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.api.AdEvent;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class anr implements AdEvent.AdEventListener, AdErrorEvent.AdErrorListener, amf, and {
    private final ane a;
    private final anq b;
    private final Context c;
    private View d;
    private String e;
    private final Set<FriendlyObstruction> f;
    private boolean g;
    private boolean h;
    private String i;
    private e j;

    anr(ane aneVar, Context context) {
        anq anqVar = new anq();
        this.g = false;
        this.h = false;
        this.i = null;
        this.a = aneVar;
        this.c = context;
        this.b = anqVar;
        this.f = new HashSet();
    }

    private final void j(List<FriendlyObstruction> list) {
        com.google.ads.interactivemedia.v3.impl.data.bm bmVarBuild;
        if (list == null) {
            bmVarBuild = null;
        } else if (list.isEmpty()) {
            return;
        } else {
            bmVarBuild = com.google.ads.interactivemedia.v3.impl.data.bm.builder().friendlyObstructions(list).build();
        }
        this.a.n(new amx(amv.omid, amw.registerFriendlyObstructions, this.e, bmVarBuild));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.and
    public final void a() {
        c.a(this.c);
        this.g = true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.and
    public final void b() {
        this.g = false;
    }

    public final void c(String str) {
        this.i = str;
    }

    public final void d(View view) {
        this.d = view;
    }

    public final void e(String str) {
        this.e = str;
    }

    public final boolean f() {
        e eVar;
        if (!this.g || (eVar = this.j) == null) {
            return false;
        }
        eVar.c();
        this.j = null;
        return true;
    }

    public final void g(FriendlyObstruction friendlyObstruction) {
        if (this.f.contains(friendlyObstruction)) {
            return;
        }
        this.f.add(friendlyObstruction);
        e eVar = this.j;
        if (eVar == null) {
            return;
        }
        eVar.d(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
        j(Arrays.asList(friendlyObstruction));
    }

    public final void h() {
        this.f.clear();
        e eVar = this.j;
        if (eVar == null) {
            return;
        }
        eVar.e();
        j(null);
    }

    public final void i() {
        this.h = true;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdErrorEvent.AdErrorListener
    public final void onAdError(AdErrorEvent adErrorEvent) {
        e eVar;
        if (!this.g || (eVar = this.j) == null) {
            return;
        }
        eVar.c();
        this.j = null;
    }

    @Override // com.google.ads.interactivemedia.v3.api.AdEvent.AdEventListener
    public final void onAdEvent(AdEvent adEvent) {
        if (this.g) {
            AdEvent.AdEventType adEventType = AdEvent.AdEventType.ALL_ADS_COMPLETED;
            int iOrdinal = adEvent.getType().ordinal();
            if (iOrdinal == 3 || iOrdinal == 14) {
                f();
                return;
            }
            if (iOrdinal == 15 && this.g && this.j == null && this.d != null) {
                j jVar = j.DEFINED_BY_JAVASCRIPT;
                l lVar = l.DEFINED_BY_JAVASCRIPT;
                m mVar = m.JAVASCRIPT;
                f fVarB = f.b(jVar, lVar, mVar, mVar);
                n nVarC = n.c();
                WebView webViewB = this.a.b();
                String str = this.i;
                String str2 = true != this.h ? "false" : "true";
                StringBuilder sb = new StringBuilder(str2.length() + 7);
                sb.append("{ssai:");
                sb.append(str2);
                sb.append("}");
                e eVarF = e.f(fVarB, g.a(nVarC, webViewB, str, sb.toString()));
                this.j = eVarF;
                eVarF.b(this.d);
                for (FriendlyObstruction friendlyObstruction : this.f) {
                    this.j.d(friendlyObstruction.getView(), friendlyObstruction.getPurpose().getOmidPurpose(), friendlyObstruction.getDetailedReason());
                }
                j(new ArrayList(this.f));
                this.j.a();
            }
        }
    }
}
