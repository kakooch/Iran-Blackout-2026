package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akb extends agt<Calendar> {
    akb() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Calendar read(alb albVar) throws IOException, NumberFormatException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        albVar.c();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (albVar.p() != 4) {
            String strF = albVar.f();
            int iL = albVar.l();
            if ("year".equals(strF)) {
                i = iL;
            } else if ("month".equals(strF)) {
                i2 = iL;
            } else if ("dayOfMonth".equals(strF)) {
                i3 = iL;
            } else if ("hourOfDay".equals(strF)) {
                i4 = iL;
            } else if ("minute".equals(strF)) {
                i5 = iL;
            } else if ("second".equals(strF)) {
                i6 = iL;
            }
        }
        albVar.d();
        return new GregorianCalendar(i, i2, i3, i4, i5, i6);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Calendar calendar) throws IOException {
        if (calendar == null) {
            aldVar.g();
            return;
        }
        aldVar.c();
        aldVar.f("year");
        aldVar.h(r4.get(1));
        aldVar.f("month");
        aldVar.h(r4.get(2));
        aldVar.f("dayOfMonth");
        aldVar.h(r4.get(5));
        aldVar.f("hourOfDay");
        aldVar.h(r4.get(11));
        aldVar.f("minute");
        aldVar.h(r4.get(12));
        aldVar.f("second");
        aldVar.h(r4.get(13));
        aldVar.e();
    }
}
