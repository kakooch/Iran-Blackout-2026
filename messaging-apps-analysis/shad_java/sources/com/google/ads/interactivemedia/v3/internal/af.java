package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class af extends ac {
    private WebView a;
    private final Map<String, ek> c;
    private Long b = null;
    private final String d = null;

    public af(Map<String, ek> map, String str) {
        this.c = map;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ac
    public final void a() {
        WebView webView = new WebView(t.a().b());
        this.a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        c(this.a);
        v.a().h(this.a, null);
        Iterator<String> it = this.c.keySet().iterator();
        if (!it.hasNext()) {
            this.b = Long.valueOf(System.nanoTime());
        } else {
            this.c.get(it.next());
            throw null;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ac
    public final void b() {
        super.b();
        new Handler().postDelayed(new ae(this), Math.max(4000 - (this.b == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.b.longValue(), TimeUnit.NANOSECONDS)), 2000L));
        this.a = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ac
    public final void h(i iVar, g gVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Map<String, ek> mapD = gVar.d();
        for (String str : mapD.keySet()) {
            ah.d(jSONObject, str, mapD.get(str));
        }
        i(iVar, gVar, jSONObject);
    }
}
