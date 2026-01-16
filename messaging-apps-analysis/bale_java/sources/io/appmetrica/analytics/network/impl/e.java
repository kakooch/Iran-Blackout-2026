package io.appmetrica.analytics.network.impl;

import ir.nasim.C19938rB7;
import ir.nasim.SA2;
import ir.nasim.YV0;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class e {
    public static byte[] a(int i, SA2 sa2) {
        try {
            InputStream inputStream = (InputStream) sa2.invoke();
            if (inputStream != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[8192];
                            int i2 = 0;
                            while (true) {
                                int i3 = inputStream.read(bArr);
                                if (-1 == i3 || i2 > i) {
                                    break;
                                }
                                if (i3 > 0) {
                                    byteArrayOutputStream.write(bArr, 0, i3);
                                    i2 += i3;
                                }
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            YV0.a(byteArrayOutputStream, null);
                            YV0.a(inputStream, null);
                            return byteArray;
                        } catch (Throwable unused) {
                            C19938rB7 c19938rB7 = C19938rB7.a;
                            YV0.a(byteArrayOutputStream, null);
                            YV0.a(inputStream, null);
                        }
                    } finally {
                    }
                } finally {
                }
            }
        } catch (Throwable unused2) {
        }
        return new byte[0];
    }

    public static final Map a(Map map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }
}
