package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.a;

/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();
    final boolean a = false;
    final Handler b = null;
    android.support.v4.os.a c;

    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    class b extends a.AbstractBinderC0008a {
        b() {
        }

        @Override // android.support.v4.os.a
        public void e1(int i, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.b;
            if (handler != null) {
                handler.post(resultReceiver.new c(i, bundle));
            } else {
                resultReceiver.a(i, bundle);
            }
        }
    }

    class c implements Runnable {
        final int a;
        final Bundle b;

        c(int i, Bundle bundle) {
            this.a = i;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.a, this.b);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.c = a.AbstractBinderC0008a.B2(parcel.readStrongBinder());
    }

    protected void a(int i, Bundle bundle) {
    }

    public void b(int i, Bundle bundle) {
        if (this.a) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new c(i, bundle));
                return;
            } else {
                a(i, bundle);
                return;
            }
        }
        android.support.v4.os.a aVar = this.c;
        if (aVar != null) {
            try {
                aVar.e1(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.c == null) {
                    this.c = new b();
                }
                parcel.writeStrongBinder(this.c.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
