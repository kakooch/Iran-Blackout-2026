package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.text.TextUtils;
import j$.util.DesugarTimeZone;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class wq implements adc<Long> {
    private static final Pattern a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

    wq() {
    }

    public static final Long b(InputStream inputStream) throws IOException, NumberFormatException {
        String line = new BufferedReader(new InputStreamReader(inputStream, apv.b)).readLine();
        try {
            Matcher matcher = a.matcher(line);
            if (!matcher.matches()) {
                String strValueOf = String.valueOf(line);
                throw new dt(strValueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(strValueOf) : new String("Couldn't parse timestamp: "));
            }
            String strGroup = matcher.group(1);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            long time = simpleDateFormat.parse(strGroup).getTime();
            if (!"Z".equals(matcher.group(2))) {
                long j = true != "+".equals(matcher.group(4)) ? -1L : 1L;
                long j2 = Long.parseLong(matcher.group(5));
                String strGroup2 = matcher.group(7);
                time -= j * (((j2 * 60) + (TextUtils.isEmpty(strGroup2) ? 0L : Long.parseLong(strGroup2))) * 60000);
            }
            return Long.valueOf(time);
        } catch (ParseException e) {
            throw new dt(e);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.adc
    public final /* bridge */ /* synthetic */ Long a(Uri uri, InputStream inputStream) throws IOException {
        return b(inputStream);
    }
}
