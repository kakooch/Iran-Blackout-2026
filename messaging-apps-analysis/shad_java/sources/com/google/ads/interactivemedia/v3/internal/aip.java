package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aip extends agt<Date> {
    public static final agu a = new aio();
    private final List<DateFormat> b;

    public aip() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (ahs.b()) {
            arrayList.add(com.google.ads.interactivemedia.v3.impl.data.ax.d(2, 2));
        }
    }

    private final synchronized Date b(String str) {
        Iterator<DateFormat> it = this.b.iterator();
        while (it.hasNext()) {
            try {
                return it.next().parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return akv.a(str, new ParsePosition(0));
        } catch (ParseException e) {
            throw new agq(str, e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final synchronized void write(ald aldVar, Date date) throws IOException {
        if (date == null) {
            aldVar.g();
        } else {
            aldVar.k(this.b.get(0).format(date));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Date read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return b(albVar.g());
        }
        albVar.i();
        return null;
    }
}
