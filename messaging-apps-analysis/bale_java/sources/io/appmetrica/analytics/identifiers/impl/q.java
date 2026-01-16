package io.appmetrica.analytics.identifiers.impl;

import android.content.Context;
import android.os.Parcel;
import io.appmetrica.analytics.coreapi.internal.identifiers.IdentifierStatus;

/* loaded from: classes3.dex */
public final class q implements b {
    public final f a;

    public q(f fVar) {
        this.a = fVar;
    }

    @Override // io.appmetrica.analytics.identifiers.impl.b
    public final c a(Context context) {
        c cVar;
        try {
            try {
                try {
                    try {
                        c cVarB = b(context);
                        try {
                            this.a.b(context);
                            return cVarB;
                        } catch (Throwable unused) {
                            return cVarB;
                        }
                    } catch (g e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = "unknown exception while binding yandex adv_id service";
                        }
                        cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, message, 2);
                        this.a.b(context);
                        return cVar;
                    }
                } catch (l e2) {
                    String message2 = e2.getMessage();
                    if (message2 == null) {
                        message2 = "No yandex adv_id service";
                    }
                    cVar = new c(IdentifierStatus.IDENTIFIER_PROVIDER_UNAVAILABLE, null, message2, 2);
                    this.a.b(context);
                    return cVar;
                } catch (Throwable th) {
                    return new c(IdentifierStatus.UNKNOWN, null, "exception while fetching yandex adv_id: " + th.getMessage(), 2);
                }
            } catch (Throwable unused2) {
                return cVar;
            }
        } finally {
            try {
                this.a.b(context);
            } catch (Throwable unused3) {
            }
        }
    }

    public final c b(Context context) {
        s sVar = (s) ((u) this.a.a(context));
        sVar.getClass();
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.yandex.android.advid.service.YandexAdvIdInterface");
            sVar.a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            String string = parcelObtain2.readString();
            parcelObtain2.recycle();
            parcelObtain.recycle();
            parcelObtain = Parcel.obtain();
            parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.yandex.android.advid.service.YandexAdvIdInterface");
                sVar.a.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                boolean z = parcelObtain2.readInt() != 0;
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return new c(IdentifierStatus.OK, new a("yandex", string, Boolean.valueOf(z)), null, 4);
            } finally {
            }
        } finally {
        }
    }

    public q() {
        this(new f(r.a, p.a, "yandex"));
    }
}
