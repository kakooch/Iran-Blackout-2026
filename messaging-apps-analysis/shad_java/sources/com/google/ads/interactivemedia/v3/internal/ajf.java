package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ajf extends agt<Time> {
    public static final agu a = new aje();
    private final DateFormat b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final synchronized Time read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        try {
            return new Time(this.b.parse(albVar.g()).getTime());
        } catch (ParseException e) {
            throw new agq(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final synchronized void write(ald aldVar, Time time) throws IOException {
        aldVar.k(time == null ? null : this.b.format((Date) time));
    }
}
