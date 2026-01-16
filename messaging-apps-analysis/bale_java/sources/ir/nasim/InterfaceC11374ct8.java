package ir.nasim;

import android.location.Location;
import android.os.IInterface;
import com.google.android.gms.internal.location.zzdb;
import com.google.android.gms.internal.location.zzdf;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;

/* renamed from: ir.nasim.ct8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC11374ct8 extends IInterface {
    void Q0(LocationSettingsRequest locationSettingsRequest, Ju8 ju8, String str);

    void W0(zzdb zzdbVar, InterfaceC10672c03 interfaceC10672c03);

    Location d();

    void j2(zzdb zzdbVar, LocationRequest locationRequest, InterfaceC10672c03 interfaceC10672c03);

    void v2(LastLocationRequest lastLocationRequest, InterfaceC20382ru8 interfaceC20382ru8);

    void w1(zzdf zzdfVar);
}
