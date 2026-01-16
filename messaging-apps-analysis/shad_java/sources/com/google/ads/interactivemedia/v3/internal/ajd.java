package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ajd extends agt<Date> {
    public static final agu a = new ajc();
    private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final synchronized Date read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        try {
            return new Date(this.b.parse(albVar.g()).getTime());
        } catch (ParseException e) {
            throw new agq(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void write(ald aldVar, Date date) throws IOException {
        aldVar.k(date == null ? null : this.b.format((java.util.Date) date));
    }
}
