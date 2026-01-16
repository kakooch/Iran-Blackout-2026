package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
    private static final long serialVersionUID = -3289606805203488840L;

    public AcceptLanguageList() {
        super(AcceptLanguage.class, SIPHeaderNames.ACCEPT_LANGUAGE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        AcceptLanguageList acceptLanguageList = new AcceptLanguageList();
        acceptLanguageList.clonehlist(this.hlist);
        return acceptLanguageList;
    }
}
