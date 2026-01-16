package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: classes.dex */
public interface PChargingFunctionAddressesHeader extends InterfaceC20733sW4, HU2 {
    public static final String NAME = "P-Charging-Function-Addresses";

    void addChargingCollectionFunctionAddress(String str);

    void addEventChargingFunctionAddress(String str);

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    ListIterator getChargingCollectionFunctionAddresses();

    ListIterator getEventChargingFunctionAddresses();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    void removeChargingCollectionFunctionAddress(String str);

    void removeEventChargingFunctionAddress(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setChargingCollectionFunctionAddress(String str);

    void setEventChargingFunctionAddress(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);
}
