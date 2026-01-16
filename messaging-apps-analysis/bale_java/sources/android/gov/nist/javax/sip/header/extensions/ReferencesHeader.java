package android.gov.nist.javax.sip.header.extensions;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface ReferencesHeader extends InterfaceC20733sW4, HU2 {
    public static final String CHAIN = "chain";
    public static final String INQUIRY = "inquiry";
    public static final String NAME = "References";
    public static final String REFER = "refer";
    public static final String REL = "rel";
    public static final String SEQUEL = "sequel";
    public static final String SERVICE = "service";
    public static final String XFER = "xfer";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    String getCallId();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    String getRel();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setCallId(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setRel(String str);
}
