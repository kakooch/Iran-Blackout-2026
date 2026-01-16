package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ab implements y {
    private final int[] a = new int[2];

    @Override // com.google.ads.interactivemedia.v3.internal.y
    public final JSONObject a(View view) {
        if (view == null) {
            return ah.b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.a);
        int[] iArr = this.a;
        return ah.b(iArr[0], iArr[1], width, height);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.y
    public final void b(View view, JSONObject jSONObject, x xVar, boolean z) {
        int i;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    xVar.a(viewGroup.getChildAt(i2), this, jSONObject);
                }
                return;
            }
            HashMap map = new HashMap();
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                ArrayList arrayList = (ArrayList) map.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(map.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                ArrayList arrayList3 = (ArrayList) map.get((Float) arrayList2.get(i4));
                int size2 = arrayList3.size();
                int i5 = 0;
                while (true) {
                    i = i4 + 1;
                    if (i5 < size2) {
                        xVar.a((View) arrayList3.get(i5), this, jSONObject);
                        i5++;
                    }
                }
                i4 = i;
            }
        }
    }
}
