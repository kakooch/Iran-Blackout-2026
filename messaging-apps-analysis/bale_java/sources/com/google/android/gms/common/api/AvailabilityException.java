package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import ir.nasim.AbstractC3795Cj5;
import ir.nasim.C9205Yy;
import ir.nasim.KJ;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AvailabilityException extends Exception {
    private final KJ a;

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (C9205Yy c9205Yy : this.a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) AbstractC3795Cj5.j((ConnectionResult) this.a.get(c9205Yy));
            z &= !connectionResult.x0();
            arrayList.add(c9205Yy.b() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }
}
