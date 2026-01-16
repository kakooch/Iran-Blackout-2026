package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.net.Uri;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/* renamed from: io.appmetrica.analytics.impl.hi, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2594hi implements InterfaceC2617ii {
    public final Context a;
    public final String b = "content://" + a() + "/clids";
    public final String c = "clid_key";
    public final String d = "clid_value";

    public C2594hi(Context context) {
        this.a = context;
    }

    public final String a() {
        return "com.yandex.preinstallsatellite.appmetrica.provider";
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC2617ii, ir.nasim.SA2
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final I3 invoke() {
        Cursor cursorQuery;
        String string;
        String string2;
        if (!PackageManagerUtils.hasContentProvider(this.a, "com.yandex.preinstallsatellite.appmetrica.provider")) {
            AbstractC2904ui.a("Satellite content provider with clids was not found.", new Object[0]);
            return null;
        }
        try {
            cursorQuery = this.a.getContentResolver().query(Uri.parse(this.b), null, null, null, null);
        } catch (Throwable th) {
            th = th;
            cursorQuery = null;
        }
        try {
        } catch (Throwable th2) {
            th = th2;
            try {
                Pattern pattern = AbstractC2904ui.a;
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Error while getting satellite clids", new Object[0]) + Separators.RETURN + StringUtils.throwableToString(th), new Object[0]);
                return null;
            } finally {
                hn.a(cursorQuery);
            }
        }
        if (cursorQuery == null) {
            AbstractC2904ui.a("No Satellite content provider found", new Object[0]);
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursorQuery.moveToNext()) {
            try {
                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(this.c));
                string2 = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(this.d));
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
                AbstractC2904ui.a("Invalid clid {%s : %s}", string, string2);
            } else {
                linkedHashMap.put(string, string2);
            }
        }
        AbstractC2904ui.a("Clids from satellite: %s", linkedHashMap);
        return new I3(linkedHashMap, M7.d);
    }
}
