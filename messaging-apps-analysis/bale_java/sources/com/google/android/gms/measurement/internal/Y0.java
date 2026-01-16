package com.google.android.gms.measurement.internal;

import android.gov.nist.core.Separators;
import android.os.Bundle;
import ir.nasim.AbstractC24556yo8;
import ir.nasim.AbstractC25150zo8;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.Ao8;
import ir.nasim.InterfaceC12548en8;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.HttpUrl;

/* loaded from: classes3.dex */
public final class Y0 {
    protected static final AtomicReference b = new AtomicReference();
    protected static final AtomicReference c = new AtomicReference();
    protected static final AtomicReference d = new AtomicReference();
    private final InterfaceC12548en8 a;

    public Y0(InterfaceC12548en8 interfaceC12548en8) {
        this.a = interfaceC12548en8;
    }

    private static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        AbstractC3795Cj5.j(strArr);
        AbstractC3795Cj5.j(strArr2);
        AbstractC3795Cj5.j(atomicReference);
        AbstractC3795Cj5.a(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            Object obj = strArr[i];
            if (str == obj || str.equals(obj)) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + Separators.LPAREN + strArr[i] + Separators.RPAREN;
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    protected final String a(Object[] objArr) {
        if (objArr == null) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : objArr) {
            String strB = obj instanceof Bundle ? b((Bundle) obj) : String.valueOf(obj);
            if (strB != null) {
                if (sb.length() != 1) {
                    sb.append(", ");
                }
                sb.append(strB);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected final String b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.a.zza()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb.length() != 8) {
                sb.append(", ");
            }
            sb.append(e(str));
            sb.append(Separators.EQUALS);
            Object obj = bundle.get(str);
            sb.append(obj instanceof Bundle ? a(new Object[]{obj}) : obj instanceof Object[] ? a((Object[]) obj) : obj instanceof ArrayList ? a(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb.append("}]");
        return sb.toString();
    }

    protected final String c(zzaw zzawVar) {
        if (!this.a.zza()) {
            return zzawVar.toString();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzawVar.c);
        sb.append(",name=");
        sb.append(d(zzawVar.a));
        sb.append(",params=");
        zzau zzauVar = zzawVar.b;
        sb.append(zzauVar == null ? null : !this.a.zza() ? zzauVar.toString() : b(zzauVar.d0()));
        return sb.toString();
    }

    protected final String d(String str) {
        if (str == null) {
            return null;
        }
        return !this.a.zza() ? str : g(str, AbstractC24556yo8.c, AbstractC24556yo8.a, b);
    }

    protected final String e(String str) {
        if (str == null) {
            return null;
        }
        return !this.a.zza() ? str : g(str, AbstractC25150zo8.b, AbstractC25150zo8.a, c);
    }

    protected final String f(String str) {
        if (str == null) {
            return null;
        }
        if (!this.a.zza()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return g(str, Ao8.b, Ao8.a, d);
        }
        return "experiment_id(" + str + Separators.RPAREN;
    }
}
