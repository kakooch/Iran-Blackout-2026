package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aj {
    private final HashMap<View, String> a = new HashMap<>();
    private final HashMap<View, ai> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();
    private final HashSet<View> d = new HashSet<>();
    private final HashSet<String> e = new HashSet<>();
    private final HashSet<String> f = new HashSet<>();
    private final HashMap<String, String> g = new HashMap<>();
    private boolean h;

    public final HashSet<String> a() {
        return this.e;
    }

    public final HashSet<String> b() {
        return this.f;
    }

    public final String c(String str) {
        return this.g.get(str);
    }

    public final void d() {
        p pVarA = p.a();
        if (pVarA != null) {
            for (i iVar : pVarA.f()) {
                View viewJ = iVar.j();
                if (iVar.k()) {
                    String strI = iVar.i();
                    if (viewJ != null) {
                        String str = null;
                        if (viewJ.hasWindowFocus()) {
                            HashSet hashSet = new HashSet();
                            View view = viewJ;
                            while (true) {
                                if (view == null) {
                                    this.d.addAll(hashSet);
                                    break;
                                }
                                String strC = ek.c(view);
                                if (strC != null) {
                                    str = strC;
                                    break;
                                } else {
                                    hashSet.add(view);
                                    Object parent = view.getParent();
                                    view = parent instanceof View ? (View) parent : null;
                                }
                            }
                        } else {
                            str = "noWindowFocus";
                        }
                        if (str == null) {
                            this.e.add(strI);
                            this.a.put(viewJ, strI);
                            for (s sVar : iVar.g()) {
                                WebView webView = sVar.d().get();
                                if (webView != null) {
                                    ai aiVar = this.b.get(webView);
                                    if (aiVar != null) {
                                        aiVar.a(iVar.i());
                                    } else {
                                        this.b.put(webView, new ai(sVar, iVar.i()));
                                    }
                                }
                            }
                        } else {
                            this.f.add(strI);
                            this.c.put(strI, viewJ);
                            this.g.put(strI, str);
                        }
                    } else {
                        this.f.add(strI);
                        this.g.put(strI, "noAdView");
                    }
                }
            }
        }
    }

    public final void e() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h = false;
    }

    public final void f() {
        this.h = true;
    }

    public final String g(View view) {
        if (this.a.size() == 0) {
            return null;
        }
        String str = this.a.get(view);
        if (str != null) {
            this.a.remove(view);
        }
        return str;
    }

    public final View h(String str) {
        return this.c.get(str);
    }

    public final ai i(View view) {
        ai aiVar = this.b.get(view);
        if (aiVar != null) {
            this.b.remove(view);
        }
        return aiVar;
    }

    public final int j(View view) {
        if (this.d.contains(view)) {
            return 1;
        }
        return this.h ? 2 : 3;
    }
}
