package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public final class ContentLanguageList extends SIPHeaderList<ContentLanguage> {
    private static final long serialVersionUID = -5302265987802886465L;

    public ContentLanguageList() {
        super(ContentLanguage.class, SIPHeaderNames.CONTENT_LANGUAGE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        ContentLanguageList contentLanguageList = new ContentLanguageList();
        contentLanguageList.clonehlist(this.hlist);
        return contentLanguageList;
    }
}
