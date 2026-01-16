package ir.nasim;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ir.nasim.InterfaceC16279l03;

/* renamed from: ir.nasim.m03, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC16870m03 extends IInterface {
    public static final String g = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    void o1(InterfaceC16279l03 interfaceC16279l03);

    /* renamed from: ir.nasim.m03$a */
    public static abstract class a extends Binder implements InterfaceC16870m03 {
        public a() {
            attachInterface(this, InterfaceC16870m03.g);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = InterfaceC16870m03.g;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            o1(InterfaceC16279l03.a.B2(parcel.readStrongBinder()));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
