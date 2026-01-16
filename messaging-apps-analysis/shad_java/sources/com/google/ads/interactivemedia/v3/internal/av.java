package com.google.ads.interactivemedia.v3.internal;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class av extends ar {
    public av(ak akVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(akVar, hashSet, jSONObject, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.v3.internal.as
    /* renamed from: a */
    public final void onPostExecute(String str) {
        p pVarA = p.a();
        if (pVarA != null) {
            for (i iVar : pVarA.e()) {
                if (((ar) this).a.contains(iVar.i())) {
                    iVar.h().g(str, this.c);
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ String doInBackground(Object[] objArr) {
        return this.b.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.as, android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(String str) {
        onPostExecute(str);
    }
}
