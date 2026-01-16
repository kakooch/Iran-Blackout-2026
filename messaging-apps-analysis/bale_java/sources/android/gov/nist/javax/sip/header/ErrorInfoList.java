package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class ErrorInfoList extends SIPHeaderList<ErrorInfo> {
    private static final long serialVersionUID = 1;

    public ErrorInfoList() {
        super(ErrorInfo.class, SIPHeaderNames.ERROR_INFO);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        ErrorInfoList errorInfoList = new ErrorInfoList();
        errorInfoList.clonehlist(this.hlist);
        return errorInfoList;
    }
}
