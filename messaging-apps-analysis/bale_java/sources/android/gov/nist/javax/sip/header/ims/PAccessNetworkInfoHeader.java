package android.gov.nist.javax.sip.header.ims;

import ir.nasim.HU2;
import ir.nasim.InterfaceC20733sW4;
import java.util.Iterator;

/* loaded from: classes.dex */
public interface PAccessNetworkInfoHeader extends InterfaceC20733sW4, HU2 {
    public static final String ADSL = "ADSL";
    public static final String ADSL2 = "ADSL2";
    public static final String ADSL2p = "ADSL2+";
    public static final String GGGPP2_1X = "3GPP2-1X";
    public static final String GGGPP2_1XHRPD = "3GPP2-1XHRPD";
    public static final String GGGPP_CDMA2000 = "3GPP-CDMA2000";
    public static final String GGGPP_GERAN = "3GPP-GERAN";
    public static final String GGGPP_UTRAN_FDD = "3GPP-UTRAN-FDD";
    public static final String GGGPP_UTRAN_TDD = "3GPP-UTRAN-TDD";
    public static final String GSHDSL = "G.SHDSL";
    public static final String HDSL = "HDSL";
    public static final String HDSL2 = "HDSL2";
    public static final String IDSL = "IDSL";
    public static final String IEEE_802_11 = "IEEE-802.11";
    public static final String IEEE_802_11A = "IEEE-802.11a";
    public static final String IEEE_802_11B = "IEEE-802.11b";
    public static final String IEEE_802_11G = "IEEE-802.11g";
    public static final String NAME = "P-Access-Network-Info";
    public static final String RADSL = "RADSL";
    public static final String SDSL = "SDSL";
    public static final String VDSL = "VDSL";

    @Override // ir.nasim.HU2
    /* synthetic */ Object clone();

    String getAccessType();

    String getCGI3GPP();

    String getCI3GPP2();

    String getDSLLocation();

    Object getExtensionAccessInfo();

    /* synthetic */ String getName();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ String getParameter(String str);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ Iterator getParameterNames();

    String getUtranCellID3GPP();

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void removeParameter(String str);

    void setAccessType(String str);

    void setCGI3GPP(String str);

    void setCI3GPP2(String str);

    void setDSLLocation(String str);

    void setExtensionAccessInfo(Object obj);

    @Override // ir.nasim.InterfaceC20733sW4
    /* synthetic */ void setParameter(String str, String str2);

    void setUtranCellID3GPP(String str);
}
