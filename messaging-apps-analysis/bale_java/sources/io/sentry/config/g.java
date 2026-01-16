package io.sentry.config;

import io.sentry.S3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/* loaded from: classes3.dex */
public abstract class g {
    public static f a() throws IOException {
        Properties propertiesA;
        Properties propertiesA2;
        S3 s3 = new S3();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new i());
        arrayList.add(new d());
        String property = System.getProperty("sentry.properties.file");
        if (property != null && (propertiesA2 = new e(property, s3).a()) != null) {
            arrayList.add(new h(propertiesA2));
        }
        String str = System.getenv("SENTRY_PROPERTIES_FILE");
        if (str != null && (propertiesA = new e(str, s3).a()) != null) {
            arrayList.add(new h(propertiesA));
        }
        Properties propertiesA3 = new b(s3).a();
        if (propertiesA3 != null) {
            arrayList.add(new h(propertiesA3));
        }
        Properties propertiesA4 = new e("sentry.properties", s3).a();
        if (propertiesA4 != null) {
            arrayList.add(new h(propertiesA4));
        }
        return new c(arrayList);
    }
}
