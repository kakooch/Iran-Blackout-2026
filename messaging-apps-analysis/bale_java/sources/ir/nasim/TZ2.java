package ir.nasim;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface TZ2 extends IInterface {
    public static final String e = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    public static abstract class a extends Binder implements TZ2 {

        /* renamed from: ir.nasim.TZ2$a$a, reason: collision with other inner class name */
        private static class C0662a implements TZ2 {
            private IBinder a;

            C0662a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // ir.nasim.TZ2
            public void u2(String str, int i, String str2, Notification notification) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(TZ2.e);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str2);
                    b.b(parcelObtain, notification, 0);
                    this.a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public static TZ2 B2(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(TZ2.e);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof TZ2)) ? new C0662a(iBinder) : (TZ2) iInterfaceQueryLocalInterface;
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Parcel parcel, Parcelable parcelable, int i) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i);
            }
        }
    }

    void u2(String str, int i, String str2, Notification notification);
}
