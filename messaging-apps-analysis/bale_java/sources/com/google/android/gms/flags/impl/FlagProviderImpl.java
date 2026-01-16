package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import ir.nasim.AbstractC24506yj8;
import ir.nasim.Bq8;
import ir.nasim.CG4;
import ir.nasim.Dn8;
import ir.nasim.So8;
import ir.nasim.Ul8;
import ir.nasim.Vl8;
import ir.nasim.XZ2;

@DynamiteApi
/* loaded from: classes3.dex */
public class FlagProviderImpl extends Ul8 {
    private boolean a = false;
    private SharedPreferences h;

    @Override // ir.nasim.Wk8
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.a ? z : AbstractC24506yj8.a(this.h, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // ir.nasim.Wk8
    public int getIntFlagValue(String str, int i, int i2) {
        return !this.a ? i : Vl8.a(this.h, str, Integer.valueOf(i)).intValue();
    }

    @Override // ir.nasim.Wk8
    public long getLongFlagValue(String str, long j, int i) {
        return !this.a ? j : Dn8.a(this.h, str, Long.valueOf(j)).longValue();
    }

    @Override // ir.nasim.Wk8
    public String getStringFlagValue(String str, String str2, int i) {
        return !this.a ? str2 : So8.a(this.h, str, str2);
    }

    @Override // ir.nasim.Wk8
    public void init(XZ2 xz2) {
        Context context = (Context) CG4.D2(xz2);
        if (this.a) {
            return;
        }
        try {
            this.h = Bq8.a(context.createPackageContext("com.google.android.gms", 0));
            this.a = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e) {
            String strValueOf = String.valueOf(e.getMessage());
            Log.w("FlagProviderImpl", strValueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(strValueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
