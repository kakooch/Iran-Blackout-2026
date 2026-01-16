package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes.dex */
final class zaag extends zaap {
    final /* synthetic */ zaaf zaa;
    private final Map<Api.Client, zaah> zab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaag(zaaf zaafVar, Map<Api.Client, zaah> map) {
        super(zaafVar, null);
        this.zaa = zaafVar;
        this.zab = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaap
    public final void zaa() {
        com.google.android.gms.common.internal.zaj zajVar = new com.google.android.gms.common.internal.zaj(this.zaa.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.zab.keySet()) {
            if (client.requiresGooglePlayServices() && !this.zab.get(client).zac) {
                arrayList.add(client);
            } else {
                arrayList2.add(client);
            }
        }
        int iZaa = -1;
        int i = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                iZaa = zajVar.zaa(this.zaa.zac, (Api.Client) obj);
                if (iZaa == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i < size2) {
                Object obj2 = arrayList.get(i);
                i++;
                iZaa = zajVar.zaa(this.zaa.zac, (Api.Client) obj2);
                if (iZaa != 0) {
                    break;
                }
            }
        }
        if (iZaa != 0) {
            this.zaa.zaa.zaa(new zaaj(this, this.zaa, new ConnectionResult(iZaa, null)));
            return;
        }
        if (this.zaa.zam && this.zaa.zak != null) {
            this.zaa.zak.zab();
        }
        for (Api.Client client2 : this.zab.keySet()) {
            zaah zaahVar = this.zab.get(client2);
            if (!client2.requiresGooglePlayServices() || zajVar.zaa(this.zaa.zac, client2) == 0) {
                client2.connect(zaahVar);
            } else {
                this.zaa.zaa.zaa(new zaai(this, this.zaa, zaahVar));
            }
        }
    }
}
