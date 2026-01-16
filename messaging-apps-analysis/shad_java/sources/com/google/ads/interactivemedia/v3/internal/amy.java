package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class amy extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ String a;
    final /* synthetic */ ane b;

    amy(ane aneVar, String str) {
        this.b = aneVar;
        this.a = str;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Void doInBackground(Void[] voidArr) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.a));
        if (!(this.b.g instanceof Activity)) {
            intent.setFlags(268435456);
        }
        this.b.g.startActivity(intent);
        return null;
    }
}
