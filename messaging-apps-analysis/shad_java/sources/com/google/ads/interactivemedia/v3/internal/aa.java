package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aa implements y {
    private final y a;

    public aa(y yVar) {
        this.a = yVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.y
    public final JSONObject a(View view) {
        return ah.b(0, 0, 0, 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.y
    public final void b(View view, JSONObject jSONObject, x xVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        p pVarA = p.a();
        if (pVarA != null) {
            Collection<i> collectionF = pVarA.f();
            int size = collectionF.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            Iterator<i> it = collectionF.iterator();
            while (it.hasNext()) {
                View viewJ = it.next().j();
                if (viewJ != null && (Build.VERSION.SDK_INT < 19 || viewJ.isAttachedToWindow())) {
                    if (viewJ.isShown()) {
                        View view2 = viewJ;
                        while (true) {
                            if (view2 == null) {
                                View rootView = viewJ.getRootView();
                                if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                    identityHashMap.put(rootView, rootView);
                                    float fB = ek.b(rootView);
                                    int size2 = arrayList.size();
                                    while (size2 > 0) {
                                        int i = size2 - 1;
                                        if (ek.b((View) arrayList.get(i)) <= fB) {
                                            break;
                                        } else {
                                            size2 = i;
                                        }
                                    }
                                    arrayList.add(size2, rootView);
                                }
                            } else if (view2.getAlpha() != 0.0f) {
                                Object parent = view2.getParent();
                                view2 = parent instanceof View ? (View) parent : null;
                            }
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i2 = 0; i2 < size3; i2++) {
            xVar.a((View) arrayList.get(i2), this.a, jSONObject);
        }
    }
}
