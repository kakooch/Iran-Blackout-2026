package android.gov.nist.javax.sip.address;

import ir.nasim.InterfaceC16126kk7;
import ir.nasim.InterfaceC16609la;
import ir.nasim.InterfaceC17200ma;
import ir.nasim.InterfaceC21815uA7;
import ir.nasim.ND6;

/* loaded from: classes.dex */
public interface AddressFactoryEx extends InterfaceC17200ma {
    /* synthetic */ InterfaceC16609la createAddress(InterfaceC21815uA7 interfaceC21815uA7);

    /* synthetic */ InterfaceC16609la createAddress(String str);

    /* synthetic */ InterfaceC16609la createAddress(String str, InterfaceC21815uA7 interfaceC21815uA7);

    ND6 createSipURI(String str);

    /* synthetic */ ND6 createSipURI(String str, String str2);

    /* synthetic */ InterfaceC16126kk7 createTelURL(String str);

    /* synthetic */ InterfaceC21815uA7 createURI(String str);
}
