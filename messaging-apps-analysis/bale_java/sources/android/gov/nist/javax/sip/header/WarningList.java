package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class WarningList extends SIPHeaderList<Warning> {
    private static final long serialVersionUID = -1423278728898430175L;

    public WarningList() {
        super(Warning.class, SIPHeaderNames.WARNING);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new WarningList().clonehlist(this.hlist);
    }
}
