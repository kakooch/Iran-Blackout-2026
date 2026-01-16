package ir.nasim;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzkw;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Fm8 extends AbstractBinderC11906dk8 implements Gm8 {
    public Fm8() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // ir.nasim.AbstractBinderC11906dk8
    protected final boolean B2(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzaw zzawVar = (zzaw) AbstractC13154fk8.a(parcel, zzaw.CREATOR);
                zzq zzqVar = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                m0(zzawVar, zzqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzkw zzkwVar = (zzkw) AbstractC13154fk8.a(parcel, zzkw.CREATOR);
                zzq zzqVar2 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                C0(zzkwVar, zzqVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzq zzqVar3 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                o0(zzqVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzaw zzawVar2 = (zzaw) AbstractC13154fk8.a(parcel, zzaw.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                AbstractC13154fk8.c(parcel);
                b2(zzawVar2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzq zzqVar4 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                h1(zzqVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzq zzqVar5 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                boolean zG = AbstractC13154fk8.g(parcel);
                AbstractC13154fk8.c(parcel);
                List listK = K(zzqVar5, zG);
                parcel2.writeNoException();
                parcel2.writeTypedList(listK);
                return true;
            case 9:
                zzaw zzawVar3 = (zzaw) AbstractC13154fk8.a(parcel, zzaw.CREATOR);
                String string3 = parcel.readString();
                AbstractC13154fk8.c(parcel);
                byte[] bArrR1 = r1(zzawVar3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrR1);
                return true;
            case 10:
                long j = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                AbstractC13154fk8.c(parcel);
                v0(j, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzq zzqVar6 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                String strU1 = u1(zzqVar6);
                parcel2.writeNoException();
                parcel2.writeString(strU1);
                return true;
            case 12:
                zzac zzacVar = (zzac) AbstractC13154fk8.a(parcel, zzac.CREATOR);
                zzq zzqVar7 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                n2(zzacVar, zzqVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzac zzacVar2 = (zzac) AbstractC13154fk8.a(parcel, zzac.CREATOR);
                AbstractC13154fk8.c(parcel);
                I(zzacVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zG2 = AbstractC13154fk8.g(parcel);
                zzq zzqVar8 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                List listM0 = M0(string7, string8, zG2, zzqVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listM0);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zG3 = AbstractC13154fk8.g(parcel);
                AbstractC13154fk8.c(parcel);
                List listL1 = l1(string9, string10, string11, zG3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listL1);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzq zzqVar9 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                List listS1 = S1(string12, string13, zzqVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listS1);
                return true;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                AbstractC13154fk8.c(parcel);
                List listY1 = y1(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listY1);
                return true;
            case 18:
                zzq zzqVar10 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                P0(zzqVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) AbstractC13154fk8.a(parcel, Bundle.CREATOR);
                zzq zzqVar11 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                k1(bundle, zzqVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzq zzqVar12 = (zzq) AbstractC13154fk8.a(parcel, zzq.CREATOR);
                AbstractC13154fk8.c(parcel);
                G0(zzqVar12);
                parcel2.writeNoException();
                return true;
        }
    }
}
