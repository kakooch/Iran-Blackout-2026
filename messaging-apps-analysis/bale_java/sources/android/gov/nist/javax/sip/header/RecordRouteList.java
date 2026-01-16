package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class RecordRouteList extends SIPHeaderList<RecordRoute> {
    private static final long serialVersionUID = 1724940469426766691L;

    public RecordRouteList() {
        super(RecordRoute.class, SIPHeaderNames.RECORD_ROUTE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        RecordRouteList recordRouteList = new RecordRouteList();
        recordRouteList.clonehlist(this.hlist);
        return recordRouteList;
    }
}
