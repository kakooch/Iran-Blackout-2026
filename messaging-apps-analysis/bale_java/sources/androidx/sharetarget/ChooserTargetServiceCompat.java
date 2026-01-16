package androidx.sharetarget;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import androidx.sharetarget.a;
import ir.nasim.C15791kA6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ChooserTargetServiceCompat extends ChooserTargetService {

    static class a implements Comparable {
        private final C15791kA6 a;
        private final ComponentName b;

        a(C15791kA6 c15791kA6, ComponentName componentName) {
            this.a = c15791kA6;
            this.b = componentName;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return h().m() - aVar.h().m();
        }

        C15791kA6 h() {
            return this.a;
        }

        ComponentName i() {
            return this.b;
        }
    }

    static List a(ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl, List list) {
        IconCompat iconCompatJ;
        if (list.isEmpty()) {
            return new ArrayList();
        }
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int iM = ((a) list.get(0)).h().m();
        Iterator it = list.iterator();
        float f = 1.0f;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            C15791kA6 c15791kA6H = aVar.h();
            try {
                iconCompatJ = shortcutInfoCompatSaverImpl.j(c15791kA6H.f());
            } catch (Exception e) {
                Log.e("ChooserServiceCompat", "Failed to retrieve shortcut icon: ", e);
                iconCompatJ = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("android.intent.extra.shortcut.ID", c15791kA6H.f());
            if (iM != c15791kA6H.m()) {
                f -= 0.01f;
                iM = c15791kA6H.m();
            }
            arrayList.add(new ChooserTarget(c15791kA6H.n(), iconCompatJ != null ? iconCompatJ.w() : null, f, aVar.i(), bundle));
        }
        return arrayList;
    }

    @Override // android.service.chooser.ChooserTargetService
    public List onGetChooserTargets(ComponentName componentName, IntentFilter intentFilter) {
        Context applicationContext = getApplicationContext();
        ArrayList<androidx.sharetarget.a> arrayListB = b.b(applicationContext);
        ArrayList arrayList = new ArrayList();
        for (androidx.sharetarget.a aVar : arrayListB) {
            if (aVar.b.equals(componentName.getClassName())) {
                a.C0124a[] c0124aArr = aVar.a;
                int length = c0124aArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    if (intentFilter.hasDataType(c0124aArr[i].g)) {
                        arrayList.add(aVar);
                        break;
                    }
                    i++;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return Collections.emptyList();
        }
        ShortcutInfoCompatSaverImpl shortcutInfoCompatSaverImpl = ShortcutInfoCompatSaverImpl.getInstance(applicationContext);
        try {
            List<C15791kA6> listB = shortcutInfoCompatSaverImpl.b();
            if (listB == null || listB.isEmpty()) {
                return Collections.emptyList();
            }
            ArrayList arrayList2 = new ArrayList();
            for (C15791kA6 c15791kA6 : listB) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        androidx.sharetarget.a aVar2 = (androidx.sharetarget.a) it.next();
                        if (c15791kA6.c().containsAll(Arrays.asList(aVar2.c))) {
                            arrayList2.add(new a(c15791kA6, new ComponentName(applicationContext.getPackageName(), aVar2.b)));
                            break;
                        }
                    }
                }
            }
            return a(shortcutInfoCompatSaverImpl, arrayList2);
        } catch (Exception e) {
            Log.e("ChooserServiceCompat", "Failed to retrieve shortcuts: ", e);
            return Collections.emptyList();
        }
    }
}
