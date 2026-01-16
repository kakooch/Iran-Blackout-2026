package io.appmetrica.analytics.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.gov.nist.core.Separators;
import android.net.Uri;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.impl.AbstractC2904ui;
import io.appmetrica.analytics.impl.C2900ue;
import io.appmetrica.analytics.impl.C2924ve;
import io.appmetrica.analytics.impl.D5;
import io.appmetrica.analytics.impl.E5;
import io.appmetrica.analytics.impl.G3;
import io.appmetrica.analytics.impl.H3;
import io.appmetrica.analytics.impl.Y9;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class PreloadInfoContentProvider extends ContentProvider {
    private boolean a = false;
    private final UriMatcher b = new UriMatcher(-1);

    private void a(E5 e5, ContentValues contentValues) {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        if (applicationContext != null) {
            try {
                Object objInvoke = e5.a.invoke(contentValues);
                if (objInvoke != null) {
                    e5.c.b(applicationContext);
                    if (((Boolean) e5.b.invoke(objInvoke)).booleanValue()) {
                        AbstractC2904ui.a("Successfully saved " + e5.d, new Object[0]);
                    } else {
                        AbstractC2904ui.a("Did not save " + e5.d + " because data is already present", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                Pattern pattern = AbstractC2904ui.a;
                ImportantLogger.INSTANCE.info("AppMetrica-Attribution", String.format("Unexpected error occurred", new Object[0]) + Separators.RETURN + StringUtils.throwableToString(th), new Object[0]);
            }
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        AbstractC2904ui.a("Deleting is not supported", new Object[0]);
        return -1;
    }

    public synchronized void disable() {
        this.a = true;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        synchronized (this) {
            try {
                if (this.a) {
                    return null;
                }
                if (contentValues != null) {
                    int iMatch = this.b.match(uri);
                    if (iMatch == 1) {
                        a(new E5(new C2900ue(), new C2924ve(), Y9.d, "preload info"), contentValues);
                    } else if (iMatch != 2) {
                        AbstractC2904ui.a("Bad content provider uri.", new Object[0]);
                    } else {
                        a(new E5(new G3(), new H3(), Y9.d, "clids"), contentValues);
                    }
                }
                CountDownLatch countDownLatch = D5.a;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        Context applicationContext = context == null ? null : context.getApplicationContext();
        String str = (applicationContext != null ? applicationContext.getPackageName() : "") + ".appmetrica.preloadinfo.retail";
        this.b.addURI(str, "preloadinfo", 1);
        this.b.addURI(str, "clids", 2);
        D5.a = new CountDownLatch(1);
        D5.b = this;
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AbstractC2904ui.a("Query is not supported", new Object[0]);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AbstractC2904ui.a("Updating is not supported", new Object[0]);
        return -1;
    }
}
