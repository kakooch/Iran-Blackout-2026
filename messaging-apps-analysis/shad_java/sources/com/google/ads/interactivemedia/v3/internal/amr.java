package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class amr extends AsyncTask<Void, Void, Bitmap> {
    Exception a = null;
    final /* synthetic */ amt b;

    amr(amt amtVar) {
        this.b = amtVar;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Bitmap doInBackground(Void[] voidArr) {
        try {
            amt amtVar = this.b;
            return amtVar.a(amtVar.a.src());
        } catch (IOException e) {
            this.a = e;
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            amt.c(this.b);
            this.b.setImageBitmap(bitmap2);
            return;
        }
        String strSrc = this.b.a.src();
        String strValueOf = String.valueOf(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(strSrc).length() + 33 + strValueOf.length());
        sb.append("Loading image companion ");
        sb.append(strSrc);
        sb.append(" failed: ");
        sb.append(strValueOf);
        Log.e("IMASDK", sb.toString());
    }
}
