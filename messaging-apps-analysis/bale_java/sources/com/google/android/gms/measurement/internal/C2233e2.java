package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzcl;
import ir.nasim.AbstractC3795Cj5;

/* renamed from: com.google.android.gms.measurement.internal.e2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2233e2 {
    final Context a;
    String b;
    String c;
    String d;
    Boolean e;
    long f;
    zzcl g;
    boolean h;
    final Long i;
    String j;

    public C2233e2(Context context, zzcl zzclVar, Long l) {
        this.h = true;
        AbstractC3795Cj5.j(context);
        Context applicationContext = context.getApplicationContext();
        AbstractC3795Cj5.j(applicationContext);
        this.a = applicationContext;
        this.i = l;
        if (zzclVar != null) {
            this.g = zzclVar;
            this.b = zzclVar.f;
            this.c = zzclVar.e;
            this.d = zzclVar.d;
            this.h = zzclVar.c;
            this.f = zzclVar.b;
            this.j = zzclVar.h;
            Bundle bundle = zzclVar.g;
            if (bundle != null) {
                this.e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
