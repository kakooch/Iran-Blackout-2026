package com.google.ads.interactivemedia.v3.internal;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aw extends ar {
    public aw(ak akVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(akVar, hashSet, jSONObject, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.v3.internal.as
    /* renamed from: a */
    public final void onPostExecute(String str) {
        p pVarA;
        if (!TextUtils.isEmpty(str) && (pVarA = p.a()) != null) {
            for (i iVar : pVarA.e()) {
                if (((ar) this).a.contains(iVar.i())) {
                    iVar.h().f(str, this.c);
                }
            }
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ String doInBackground(Object[] objArr) {
        if (ah.j(this.b, this.d.d())) {
            return null;
        }
        this.d.e(this.b);
        return this.b.toString();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.as, android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(String str) {
        onPostExecute(str);
    }
}
