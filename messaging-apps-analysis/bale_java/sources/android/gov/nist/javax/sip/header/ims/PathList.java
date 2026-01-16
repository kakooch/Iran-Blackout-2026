package android.gov.nist.javax.sip.header.ims;

import android.gov.nist.javax.sip.header.SIPHeaderList;

/* loaded from: classes.dex */
public class PathList extends SIPHeaderList<Path> {
    public PathList() {
        super(Path.class, "Path");
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeaderList, android.gov.nist.core.GenericObject
    public Object clone() {
        return new PathList().clonehlist(this.hlist);
    }
}
