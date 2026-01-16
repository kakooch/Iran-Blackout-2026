package io.appmetrica.analytics.gpllibrary.internal;

import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import ir.nasim.KB2;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class GplLibraryWrapper implements IGplLibraryWrapper {
    public static final String FUSED_PROVIDER = "fused";
    private final KB2 a;
    private final LocationListener b;
    private final LocationCallback c;
    private final Looper d;
    private final Executor e;
    private final long f;

    /* renamed from: io.appmetrica.analytics.gpllibrary.internal.GplLibraryWrapper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Priority.values().length];
            a = iArr;
            try {
                iArr[Priority.PRIORITY_LOW_POWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Priority.PRIORITY_BALANCED_POWER_ACCURACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Priority.PRIORITY_HIGH_ACCURACY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static class ClientProvider {
        private final Context a;

        ClientProvider(Context context) {
            this.a = context;
        }

        final KB2 a() {
            return new KB2(this.a);
        }
    }

    public enum Priority {
        PRIORITY_NO_POWER,
        PRIORITY_LOW_POWER,
        PRIORITY_BALANCED_POWER_ACCURACY,
        PRIORITY_HIGH_ACCURACY
    }

    public GplLibraryWrapper(Context context, LocationListener locationListener, Looper looper, Executor executor, long j) {
        this(new ClientProvider(context), locationListener, looper, executor, j);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void startLocationUpdates(Priority priority) {
        KB2 kb2 = this.a;
        LocationRequest locationRequestV1 = LocationRequest.P().V1(this.f);
        int i = AnonymousClass1.a[priority.ordinal()];
        kb2.b(locationRequestV1.W1(i != 1 ? i != 2 ? i != 3 ? 105 : 100 : 102 : 104), this.c, this.d);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void stopLocationUpdates() {
        this.a.d(this.c);
    }

    @Override // io.appmetrica.analytics.gpllibrary.internal.IGplLibraryWrapper
    public void updateLastKnownLocation() {
        this.a.g().g(this.e, new GplOnSuccessListener(this.b));
    }

    GplLibraryWrapper(ClientProvider clientProvider, LocationListener locationListener, Looper looper, Executor executor, long j) {
        this.a = clientProvider.a();
        this.b = locationListener;
        this.d = looper;
        this.e = executor;
        this.f = j;
        this.c = new GplLocationCallback(locationListener);
    }
}
