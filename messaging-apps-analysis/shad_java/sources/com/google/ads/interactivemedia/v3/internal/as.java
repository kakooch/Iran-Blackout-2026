package com.google.ads.interactivemedia.v3.internal;

import android.os.AsyncTask;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class as extends AsyncTask<Object, Void, String> {
    private at a;
    protected final ak d;

    public as(ak akVar) {
        this.d = akVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        at atVar = this.a;
        if (atVar != null) {
            atVar.b();
        }
    }

    public final void b(at atVar) {
        this.a = atVar;
    }
}
