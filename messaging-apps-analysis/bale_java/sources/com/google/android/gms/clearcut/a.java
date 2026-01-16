package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.internal.clearcut.E0;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC15506jh8;
import ir.nasim.AbstractC24109y35;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.BD1;
import ir.nasim.C12568ep8;
import ir.nasim.EnumC23376wo8;
import ir.nasim.InterfaceC20863sj8;
import ir.nasim.OV0;
import ir.nasim.Ym8;
import java.util.ArrayList;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class a {
    private static final a.g n;
    private static final a.AbstractC0169a o;
    public static final com.google.android.gms.common.api.a p;
    private static final ExperimentTokens[] q;
    private static final String[] r;
    private static final byte[][] s;
    private final Context a;
    private final String b;
    private final int c;
    private String d;
    private int e;
    private String f;
    private String g;
    private final boolean h;
    private EnumC23376wo8 i;
    private final InterfaceC20863sj8 j;
    private final OV0 k;
    private d l;
    private final b m;

    /* renamed from: com.google.android.gms.clearcut.a$a, reason: collision with other inner class name */
    public class C0168a {
        private int a;
        private String b;
        private String c;
        private String d;
        private EnumC23376wo8 e;
        private ArrayList f;
        private ArrayList g;
        private ArrayList h;
        private ArrayList i;
        private ArrayList j;
        private boolean k;
        private final C12568ep8 l;
        private boolean m;

        private C0168a(a aVar, byte[] bArr) {
            this(bArr, (c) null);
        }

        public void a() {
            if (this.m) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.m = true;
            zze zzeVar = new zze(new zzr(a.this.b, a.this.c, this.a, this.b, this.c, this.d, a.this.h, this.e), this.l, null, null, a.f(null), null, a.f(null), null, null, this.k);
            if (a.this.m.a(zzeVar)) {
                a.this.j.c(zzeVar);
            } else {
                AbstractC24109y35.b(Status.f, null);
            }
        }

        public C0168a b(int i) {
            this.l.f = i;
            return this;
        }

        private C0168a(byte[] bArr, c cVar) {
            this.a = a.this.e;
            this.b = a.this.d;
            this.c = a.this.f;
            this.d = null;
            this.e = a.this.i;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = true;
            C12568ep8 c12568ep8 = new C12568ep8();
            this.l = c12568ep8;
            this.m = false;
            this.c = a.this.f;
            this.d = null;
            c12568ep8.x = AbstractC15506jh8.a(a.this.a);
            c12568ep8.b = a.this.k.currentTimeMillis();
            c12568ep8.c = a.this.k.elapsedRealtime();
            d unused = a.this.l;
            c12568ep8.q = TimeZone.getDefault().getOffset(c12568ep8.b) / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT;
            if (bArr != null) {
                c12568ep8.m = bArr;
            }
        }

        /* synthetic */ C0168a(a aVar, byte[] bArr, com.google.android.gms.clearcut.b bVar) {
            this(aVar, bArr);
        }
    }

    public interface b {
        boolean a(zze zzeVar);
    }

    public interface c {
    }

    public static class d {
    }

    static {
        a.g gVar = new a.g();
        n = gVar;
        com.google.android.gms.clearcut.b bVar = new com.google.android.gms.clearcut.b();
        o = bVar;
        p = new com.google.android.gms.common.api.a("ClearcutLogger.API", bVar, gVar);
        q = new ExperimentTokens[0];
        r = new String[0];
        s = new byte[0][];
    }

    private a(Context context, int i, String str, String str2, String str3, boolean z, InterfaceC20863sj8 interfaceC20863sj8, OV0 ov0, d dVar, b bVar) {
        this.e = -1;
        EnumC23376wo8 enumC23376wo8 = EnumC23376wo8.DEFAULT;
        this.i = enumC23376wo8;
        this.a = context;
        this.b = context.getPackageName();
        this.c = b(context);
        this.e = -1;
        this.d = str;
        this.f = str2;
        this.g = null;
        this.h = z;
        this.j = interfaceC20863sj8;
        this.k = ov0;
        this.l = new d();
        this.i = enumC23376wo8;
        this.m = bVar;
        if (z) {
            AbstractC3795Cj5.b(str2 == null, "can't be anonymous with an upload account");
        }
    }

    private static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.", e);
            return 0;
        }
    }

    private static int[] d(ArrayList arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            iArr[i2] = ((Integer) obj).intValue();
            i2++;
        }
        return iArr;
    }

    static /* synthetic */ int[] f(ArrayList arrayList) {
        return d(null);
    }

    public final C0168a a(byte[] bArr) {
        return new C0168a(this, bArr, (com.google.android.gms.clearcut.b) null);
    }

    public a(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, Ym8.z(context), BD1.a(), null, new E0(context));
    }
}
