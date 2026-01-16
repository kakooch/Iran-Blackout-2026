package android.gov.nist.javax.sip.header;

/* loaded from: classes.dex */
public final class RequireList extends SIPHeaderList<Require> {
    private static final long serialVersionUID = -1760629092046963213L;

    public RequireList() {
        super(Require.class, SIPHeaderNames.REQUIRE);
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        RequireList requireList = new RequireList();
        requireList.clonehlist(this.hlist);
        return requireList;
    }
}
