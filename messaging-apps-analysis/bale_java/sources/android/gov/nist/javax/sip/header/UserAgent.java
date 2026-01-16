package android.gov.nist.javax.sip.header;

import ir.nasim.InterfaceC18819pI7;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class UserAgent extends SIPHeader implements InterfaceC18819pI7 {
    private static final long serialVersionUID = 4561239179796364295L;
    protected List productTokens;

    public UserAgent() {
        super(SIPHeaderNames.USER_AGENT);
        this.productTokens = new LinkedList();
    }

    private StringBuilder encodeProduct(StringBuilder sb) {
        ListIterator listIterator = this.productTokens.listIterator();
        while (listIterator.hasNext()) {
            sb.append((String) listIterator.next());
        }
        return sb;
    }

    public void addProductToken(String str) {
        this.productTokens.add(str);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        UserAgent userAgent = (UserAgent) super.clone();
        if (this.productTokens != null) {
            userAgent.productTokens = new LinkedList(this.productTokens);
        }
        return userAgent;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    public StringBuilder encodeBody(StringBuilder sb) {
        return encodeProduct(sb);
    }

    public ListIterator getProduct() {
        List list = this.productTokens;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return this.productTokens.listIterator();
    }

    public void setProduct(List list) {
        if (list == null) {
            throw new NullPointerException("JAIN-SIP Exception, UserAgent, setProduct(), the  product parameter is null");
        }
        this.productTokens = list;
    }
}
