package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class apj extends apg {
    private static AdvertisingIdClient d;
    private static final CountDownLatch e = new CountDownLatch(1);
    private static volatile boolean f;
    private final boolean g;

    protected apj(Context context, apm apmVar, app appVar) {
        super(context, apmVar, appVar);
        this.g = true;
    }

    public static apj q(Context context) {
        aoo aooVar = new aoo();
        apg.k(context, aooVar);
        synchronized (apj.class) {
            if (d == null) {
                new Thread(new api(context)).start();
            }
        }
        return new apj(context, aooVar, new app());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.apg, com.google.ads.interactivemedia.v3.internal.ape
    protected final void b(Context context) throws apf {
        super.b(context);
        try {
            if (f) {
                d(24, apg.g(context));
                return;
            }
            aph aphVarL = l();
            String strA = aphVarL.a();
            if (strA != null) {
                c(28, true != aphVarL.b() ? 0L : 1L);
                c(26, 5L);
                d(24, strA);
            }
        } catch (apf | IOException unused) {
        }
    }

    final aph l() throws IOException {
        try {
            if (!e.await(2L, TimeUnit.SECONDS)) {
                return new aph(null, false);
            }
            synchronized (apj.class) {
                AdvertisingIdClient advertisingIdClient = d;
                if (advertisingIdClient == null) {
                    return new aph(null, false);
                }
                AdvertisingIdClient.Info info = advertisingIdClient.getInfo();
                String id = info.getId();
                if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
                    UUID uuidFromString = UUID.fromString(id);
                    byte[] bArr = new byte[16];
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
                    byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
                    id = this.b.b(bArr);
                }
                return new aph(id, info.isLimitAdTrackingEnabled());
            }
        } catch (InterruptedException unused) {
            return new aph(null, false);
        }
    }
}
