package io.appmetrica.analytics.impl;

import android.content.Context;
import ir.nasim.AbstractC13042fc3;

/* renamed from: io.appmetrica.analytics.impl.ie, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2614ie implements InterfaceC2994yc {
    public final Context a;
    public final String b;
    public final String c;

    public C2614ie(Context context, String str, String str2) {
        this.a = context;
        this.b = str;
        this.c = str2;
    }

    public final C2614ie a(Context context, String str, String str2) {
        return new C2614ie(context, str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2614ie)) {
            return false;
        }
        C2614ie c2614ie = (C2614ie) obj;
        return AbstractC13042fc3.d(this.a, c2614ie.a) && AbstractC13042fc3.d(this.b, c2614ie.b) && AbstractC13042fc3.d(this.c, c2614ie.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "PreferencesBasedModuleEntryPoint(context=" + this.a + ", prefName=" + this.b + ", prefValueName=" + this.c + ')';
    }

    public static C2614ie a(C2614ie c2614ie, Context context, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            context = c2614ie.a;
        }
        if ((i & 2) != 0) {
            str = c2614ie.b;
        }
        if ((i & 4) != 0) {
            str2 = c2614ie.c;
        }
        c2614ie.getClass();
        return new C2614ie(context, str, str2);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2994yc
    public final String a() {
        String string = this.a.getSharedPreferences(this.b, 0).getString(this.c, "");
        return string == null ? "" : string;
    }
}
