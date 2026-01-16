package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.j;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public class i implements j {
    private final int a;

    public i() {
        this(-1);
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public long a(j.c cVar) {
        IOException iOException = cVar.c;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.a(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((cVar.d - 1) * AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public int b(int i) {
        int i2 = this.a;
        return i2 == -1 ? i == 7 ? 6 : 3 : i2;
    }

    @Override // com.google.android.exoplayer2.upstream.j
    public j.b c(j.a aVar, j.c cVar) {
        if (!e(cVar.c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new j.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new j.b(2, 60000L);
        }
        return null;
    }

    protected boolean e(IOException iOException) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i = ((HttpDataSource.InvalidResponseCodeException) iOException).d;
        return i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503;
    }

    public i(int i) {
        this.a = i;
    }
}
