package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.ED1;

/* renamed from: io.appmetrica.analytics.impl.d7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2486d7 implements Converter {
    public final C2411a7 a;

    /* JADX WARN: Multi-variable type inference failed */
    public C2486d7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ContentValues fromModel(C2461c7 c2461c7) {
        ContentValues contentValues = new ContentValues();
        Long l = c2461c7.a;
        if (l != null) {
            contentValues.put("session_id", Long.valueOf(l.longValue()));
        }
        Wj wj = c2461c7.b;
        if (wj != null) {
            contentValues.put("session_type", Integer.valueOf(wj.a));
        }
        Long l2 = c2461c7.c;
        if (l2 != null) {
            contentValues.put("number_in_session", Long.valueOf(l2.longValue()));
        }
        Ta ta = c2461c7.d;
        if (ta != null) {
            contentValues.put("type", Integer.valueOf(ta.a));
        }
        Long l3 = c2461c7.e;
        if (l3 != null) {
            contentValues.put("global_number", Long.valueOf(l3.longValue()));
        }
        Long l4 = c2461c7.f;
        if (l4 != null) {
            contentValues.put("time", Long.valueOf(l4.longValue()));
        }
        C2411a7 c2411a7 = this.a;
        contentValues.put("event_description", MessageNano.toByteArray(c2411a7.a.fromModel(c2461c7.g)));
        return contentValues;
    }

    public C2486d7(C2411a7 c2411a7) {
        this.a = c2411a7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C2486d7(C2411a7 c2411a7, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C2411a7(null, 1, 0 == true ? 1 : 0) : c2411a7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2461c7 toModel(ContentValues contentValues) {
        Wj wj;
        Long asLong = contentValues.getAsLong("session_id");
        Integer asInteger = contentValues.getAsInteger("session_type");
        if (asInteger != null) {
            int iIntValue = asInteger.intValue();
            wj = Wj.FOREGROUND;
            if (iIntValue != 0 && iIntValue == 1) {
                wj = Wj.BACKGROUND;
            }
        } else {
            wj = null;
        }
        Long asLong2 = contentValues.getAsLong("number_in_session");
        Integer asInteger2 = contentValues.getAsInteger("type");
        return new C2461c7(asLong, wj, asLong2, asInteger2 != null ? Ta.a(asInteger2.intValue()) : null, contentValues.getAsLong("global_number"), contentValues.getAsLong("time"), this.a.toModel(contentValues.getAsByteArray("event_description")));
    }
}
