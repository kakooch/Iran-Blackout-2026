package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.gov.nist.core.Separators;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: io.appmetrica.analytics.impl.ue, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2900ue implements B5 {
    @Override // io.appmetrica.analytics.impl.B5, ir.nasim.UA2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Ee invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("tracking_id");
        if (TextUtils.isEmpty(asString)) {
            AbstractC2904ui.a("Tracking id is empty", new Object[0]);
            return null;
        }
        if (ParseUtils.parseLong(asString) == null) {
            AbstractC2904ui.a("Tracking id from preload info content provider is not a number", new Object[0]);
            return null;
        }
        try {
            String asString2 = contentValues.getAsString("additional_params");
            if (TextUtils.isEmpty(asString2)) {
                AbstractC2904ui.a("No additional params", new Object[0]);
                return null;
            }
            JSONObject jSONObject = new JSONObject(asString2);
            if (jSONObject.length() == 0) {
                AbstractC2904ui.a("Additional params are empty", new Object[0]);
                return null;
            }
            AbstractC2904ui.a("Successfully parsed preload info. Tracking id = %s, additionalParams = %s", asString, jSONObject);
            return new Ee(asString, jSONObject, true, false, M7.e);
        } catch (Throwable th) {
            Pattern pattern = AbstractC2904ui.a;
            ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Could not parse additional parameters", new Object[0]) + Separators.RETURN + StringUtils.throwableToString(th), new Object[0]);
            return null;
        }
    }
}
