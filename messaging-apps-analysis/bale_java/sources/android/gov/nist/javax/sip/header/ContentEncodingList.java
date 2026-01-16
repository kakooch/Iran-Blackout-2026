package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public final class ContentEncodingList extends SIPHeaderList<ContentEncoding> {
    private static final long serialVersionUID = 7365216146576273970L;

    public ContentEncodingList() {
        super(ContentEncoding.class, SIPHeaderNames.CONTENT_ENCODING);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        ContentEncodingList contentEncodingList = new ContentEncodingList();
        contentEncodingList.clonehlist(this.hlist);
        return contentEncodingList;
    }
}
