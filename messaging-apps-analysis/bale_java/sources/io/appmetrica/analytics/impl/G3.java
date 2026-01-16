package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class G3 implements B5 {
    @Override // io.appmetrica.analytics.impl.B5, ir.nasim.UA2
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Map<String, String> invoke(ContentValues contentValues) {
        String asString = contentValues.getAsString("clids");
        HashMap mapC = Ya.c(asString);
        if (Gl.a(mapC)) {
            return mapC;
        }
        AbstractC2904ui.a("Passed clids (" + asString + ") are invalid.", new Object[0]);
        return null;
    }
}
