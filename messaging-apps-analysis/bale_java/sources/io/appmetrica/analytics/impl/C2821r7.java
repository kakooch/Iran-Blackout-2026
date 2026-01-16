package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import ir.nasim.ED1;

/* renamed from: io.appmetrica.analytics.impl.r7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2821r7 implements Converter {
    public final C2750o7 a;

    /* JADX WARN: Multi-variable type inference failed */
    public C2821r7() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ContentValues fromModel(C2798q7 c2798q7) {
        ContentValues contentValues = new ContentValues();
        Long l = c2798q7.a;
        if (l != null) {
            contentValues.put("id", Long.valueOf(l.longValue()));
        }
        Wj wj = c2798q7.b;
        if (wj != null) {
            contentValues.put("type", Integer.valueOf(wj.a));
        }
        String str = c2798q7.c;
        if (str != null) {
            contentValues.put("report_request_parameters", str);
        }
        C2750o7 c2750o7 = this.a;
        contentValues.put("session_description", MessageNano.toByteArray(c2750o7.a.fromModel(c2798q7.d)));
        return contentValues;
    }

    public C2821r7(C2750o7 c2750o7) {
        this.a = c2750o7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ C2821r7(C2750o7 c2750o7, int i, ED1 ed1) {
        this((i & 1) != 0 ? new C2750o7(null, 1, 0 == true ? 1 : 0) : c2750o7);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C2798q7 toModel(ContentValues contentValues) {
        Wj wj;
        Long asLong = contentValues.getAsLong("id");
        Integer asInteger = contentValues.getAsInteger("type");
        if (asInteger != null) {
            int iIntValue = asInteger.intValue();
            wj = Wj.FOREGROUND;
            if (iIntValue != 0 && iIntValue == 1) {
                wj = Wj.BACKGROUND;
            }
        } else {
            wj = null;
        }
        return new C2798q7(asLong, wj, contentValues.getAsString("report_request_parameters"), this.a.toModel(contentValues.getAsByteArray("session_description")));
    }
}
