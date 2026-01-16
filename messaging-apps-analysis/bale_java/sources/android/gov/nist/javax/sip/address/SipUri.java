package android.gov.nist.javax.sip.address;

import android.gov.nist.core.Debug;
import android.gov.nist.core.GenericObject;
import android.gov.nist.core.Host;
import android.gov.nist.core.HostPort;
import android.gov.nist.core.NameValue;
import android.gov.nist.core.NameValueList;
import android.gov.nist.core.Separators;
import android.javax.sip.PeerUnavailableException;
import ir.nasim.JD6;
import ir.nasim.LU2;
import ir.nasim.ND6;
import java.text.ParseException;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SipUri extends GenericURI implements ND6, SipURIExt {
    private static final long serialVersionUID = 7749781076218987044L;
    protected Authority authority;
    protected NameValueList qheaders;
    protected TelephoneNumber telephoneSubscriber;
    protected NameValueList uriParms;

    public SipUri() {
        this.scheme = "sip";
        this.uriParms = new NameValueList();
        NameValueList nameValueList = new NameValueList();
        this.qheaders = nameValueList;
        nameValueList.setSeparator(Separators.AND);
    }

    public void clearPassword() {
        UserInfo userInfo;
        Authority authority = this.authority;
        if (authority == null || (userInfo = authority.getUserInfo()) == null) {
            return;
        }
        userInfo.clearPassword();
    }

    public void clearQheaders() {
        this.qheaders = new NameValueList();
    }

    public void clearUriParms() {
        this.uriParms = new NameValueList();
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        SipUri sipUri = (SipUri) super.clone();
        Authority authority = this.authority;
        if (authority != null) {
            sipUri.authority = (Authority) authority.clone();
        }
        NameValueList nameValueList = this.uriParms;
        if (nameValueList != null) {
            sipUri.uriParms = (NameValueList) nameValueList.clone();
        }
        NameValueList nameValueList2 = this.qheaders;
        if (nameValueList2 != null) {
            sipUri.qheaders = (NameValueList) nameValueList2.clone();
        }
        TelephoneNumber telephoneNumber = this.telephoneSubscriber;
        if (telephoneNumber != null) {
            sipUri.telephoneSubscriber = (TelephoneNumber) telephoneNumber.clone();
        }
        return sipUri;
    }

    @Override // android.gov.nist.javax.sip.address.GenericURI, android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.address.GenericURI, android.gov.nist.javax.sip.address.NetObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ND6)) {
            return false;
        }
        ND6 nd6 = (ND6) obj;
        if (isSecure() ^ nd6.isSecure()) {
            return false;
        }
        if ((getUser() == null) ^ (nd6.getUser() == null)) {
            return false;
        }
        if ((getUserPassword() == null) ^ (nd6.getUserPassword() == null)) {
            return false;
        }
        if (getUser() != null && !UriDecoder.decode(getUser()).equals(UriDecoder.decode(nd6.getUser()))) {
            return false;
        }
        if (getUserPassword() != null && !UriDecoder.decode(getUserPassword()).equals(UriDecoder.decode(nd6.getUserPassword()))) {
            return false;
        }
        if ((getHost() == null) ^ (nd6.getHost() == null)) {
            return false;
        }
        if ((getHost() != null && !getHost().equalsIgnoreCase(nd6.getHost())) || getPort() != nd6.getPort()) {
            return false;
        }
        Iterator parameterNames = getParameterNames();
        while (parameterNames.hasNext()) {
            String str = (String) parameterNames.next();
            String parameter = getParameter(str);
            String parameter2 = nd6.getParameter(str);
            if (parameter != null && parameter2 != null && !UriDecoder.decode(parameter).equalsIgnoreCase(UriDecoder.decode(parameter2))) {
                return false;
            }
        }
        if ((getTransportParam() == null) ^ (nd6.getTransportParam() == null)) {
            return false;
        }
        if ((getUserParam() == null) ^ (nd6.getUserParam() == null)) {
            return false;
        }
        if ((getTTLParam() == -1) ^ (nd6.getTTLParam() == -1)) {
            return false;
        }
        if ((getMethodParam() == null) ^ (nd6.getMethodParam() == null)) {
            return false;
        }
        if ((getMAddrParam() == null) ^ (nd6.getMAddrParam() == null)) {
            return false;
        }
        if (getHeaderNames().hasNext() && !nd6.getHeaderNames().hasNext()) {
            return false;
        }
        if (!getHeaderNames().hasNext() && nd6.getHeaderNames().hasNext()) {
            return false;
        }
        if (getHeaderNames().hasNext() && nd6.getHeaderNames().hasNext()) {
            try {
                LU2 lu2A = JD6.c().a();
                Iterator headerNames = getHeaderNames();
                while (headerNames.hasNext()) {
                    String str2 = (String) headerNames.next();
                    String header = getHeader(str2);
                    String header2 = nd6.getHeader(str2);
                    if (header == null && header2 != null) {
                        return false;
                    }
                    if (header2 == null && header != null) {
                        return false;
                    }
                    if (header != null || header2 != null) {
                        try {
                            if (!lu2A.createHeader(str2, UriDecoder.decode(header)).equals(lu2A.createHeader(str2, UriDecoder.decode(header2)))) {
                                return false;
                            }
                        } catch (ParseException e) {
                            Debug.logError("Cannot parse one of the header of the sip uris to compare " + this + Separators.SP + nd6, e);
                            return false;
                        }
                    }
                }
            } catch (PeerUnavailableException e2) {
                Debug.logError("Cannot get the header factory to parse the header of the sip uris to compare", e2);
                return false;
            }
        }
        return true;
    }

    public Authority getAuthority() {
        return this.authority;
    }

    public String getGrParam() {
        return (String) this.uriParms.getValue("gr");
    }

    @Override // ir.nasim.ND6
    public String getHeader(String str) {
        if (this.qheaders.getValue(str) != null) {
            return this.qheaders.getValue(str).toString();
        }
        return null;
    }

    @Override // ir.nasim.ND6
    public Iterator<String> getHeaderNames() {
        return this.qheaders.getNames();
    }

    @Override // ir.nasim.ND6
    public String getHost() {
        Authority authority = this.authority;
        if (authority == null || authority.getHost() == null) {
            return null;
        }
        return this.authority.getHost().encode();
    }

    public HostPort getHostPort() {
        Authority authority = this.authority;
        if (authority == null || authority.getHost() == null) {
            return null;
        }
        return this.authority.getHostPort();
    }

    public String getLrParam() {
        if (hasParameter("lr")) {
            return "true";
        }
        return null;
    }

    @Override // ir.nasim.ND6
    public String getMAddrParam() {
        NameValue nameValue = this.uriParms.getNameValue("maddr");
        if (nameValue == null) {
            return null;
        }
        return (String) nameValue.getValueAsObject();
    }

    public String getMethod() {
        return (String) getParm("method");
    }

    @Override // ir.nasim.ND6
    public String getMethodParam() {
        return getParameter("method");
    }

    @Override // ir.nasim.InterfaceC20733sW4
    public String getParameter(String str) {
        Object value = this.uriParms.getValue(str);
        if (value == null) {
            return null;
        }
        return value instanceof GenericObject ? ((GenericObject) value).encode() : value.toString();
    }

    @Override // ir.nasim.InterfaceC20733sW4
    public Iterator<String> getParameterNames() {
        return this.uriParms.getNames();
    }

    public NameValueList getParameters() {
        return this.uriParms;
    }

    public Object getParm(String str) {
        return this.uriParms.getValue(str);
    }

    @Override // ir.nasim.ND6
    public int getPort() {
        HostPort hostPort = getHostPort();
        if (hostPort == null) {
            return -1;
        }
        return hostPort.getPort();
    }

    public NameValueList getQheaders() {
        return this.qheaders;
    }

    @Override // android.gov.nist.javax.sip.address.GenericURI, ir.nasim.InterfaceC21815uA7
    public String getScheme() {
        return this.scheme;
    }

    @Override // ir.nasim.ND6
    public int getTTLParam() {
        Integer num = (Integer) this.uriParms.getValue("ttl");
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public TelephoneNumber getTelephoneSubscriber() {
        if (this.telephoneSubscriber == null) {
            this.telephoneSubscriber = new TelephoneNumber();
        }
        return this.telephoneSubscriber;
    }

    @Override // ir.nasim.ND6
    public String getTransportParam() {
        NameValueList nameValueList = this.uriParms;
        if (nameValueList != null) {
            return (String) nameValueList.getValue(android.gov.nist.javax.sip.header.ParameterNames.TRANSPORT);
        }
        return null;
    }

    @Override // ir.nasim.ND6
    public String getUser() {
        return this.authority.getUser();
    }

    public String getUserAtHost() {
        StringBuilder sb;
        String user = this.authority.getUserInfo() != null ? this.authority.getUserInfo().getUser() : "";
        String strEncode = this.authority.getHost().encode();
        if (user == null || user.equals("")) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder(user);
            sb.append(Separators.AT);
        }
        sb.append(strEncode);
        return sb.toString();
    }

    public String getUserAtHostPort() {
        StringBuilder sb;
        String user = this.authority.getUserInfo() != null ? this.authority.getUserInfo().getUser() : "";
        String strEncode = this.authority.getHost().encode();
        int port = this.authority.getPort();
        if (user == null || user.equals("")) {
            sb = new StringBuilder();
        } else {
            sb = new StringBuilder(user);
            sb.append(Separators.AT);
        }
        if (port == -1) {
            sb.append(strEncode);
            return sb.toString();
        }
        sb.append(strEncode);
        sb.append(":");
        sb.append(port);
        return sb.toString();
    }

    @Override // ir.nasim.ND6
    public String getUserParam() {
        return getParameter("user");
    }

    @Override // ir.nasim.ND6
    public String getUserPassword() {
        Authority authority = this.authority;
        if (authority == null) {
            return null;
        }
        return authority.getPassword();
    }

    public String getUserType() {
        return (String) this.uriParms.getValue("user");
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public boolean hasGrParam() {
        return this.uriParms.getNameValue("gr") != null;
    }

    @Override // ir.nasim.ND6
    public boolean hasLrParam() {
        return this.uriParms.getNameValue("lr") != null;
    }

    public boolean hasParameter(String str) {
        return this.uriParms.getValue(str) != null;
    }

    public boolean hasTransport() {
        return hasParameter(android.gov.nist.javax.sip.header.ParameterNames.TRANSPORT);
    }

    @Override // ir.nasim.ND6
    public boolean isSecure() {
        return getScheme().equalsIgnoreCase("sips");
    }

    @Override // android.gov.nist.javax.sip.address.GenericURI, ir.nasim.InterfaceC21815uA7
    public boolean isSipURI() {
        return true;
    }

    public boolean isUserTelephoneSubscriber() {
        String str = (String) this.uriParms.getValue("user");
        if (str == null) {
            return false;
        }
        return str.equalsIgnoreCase("phone");
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void removeHeader(String str) {
        NameValueList nameValueList = this.qheaders;
        if (nameValueList != null) {
            nameValueList.delete(str);
        }
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void removeHeaders() {
        this.qheaders = new NameValueList();
    }

    public void removeMAddr() {
        NameValueList nameValueList = this.uriParms;
        if (nameValueList != null) {
            nameValueList.delete("maddr");
        }
    }

    public void removeMethod() {
        NameValueList nameValueList = this.uriParms;
        if (nameValueList != null) {
            nameValueList.delete("method");
        }
    }

    @Override // ir.nasim.InterfaceC20733sW4
    public void removeParameter(String str) {
        this.uriParms.delete(str);
    }

    public void removeParameters() {
        this.uriParms = new NameValueList();
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void removePort() {
        this.authority.removePort();
    }

    public void removeTTL() {
        NameValueList nameValueList = this.uriParms;
        if (nameValueList != null) {
            nameValueList.delete("ttl");
        }
    }

    public void removeTransport() {
        NameValueList nameValueList = this.uriParms;
        if (nameValueList != null) {
            nameValueList.delete(android.gov.nist.javax.sip.header.ParameterNames.TRANSPORT);
        }
    }

    public void removeUser() {
        this.authority.removeUserInfo();
    }

    public void removeUserType() {
        NameValueList nameValueList = this.uriParms;
        if (nameValueList != null) {
            nameValueList.delete("user");
        }
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public void setDefaultParm(String str, Object obj) {
        if (this.uriParms.getValue(str) == null) {
            this.uriParms.set(new NameValue(str, obj));
        }
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void setGrParam(String str) {
        this.uriParms.set("gr", str);
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void setHeader(String str, String str2) {
        this.qheaders.set(new NameValue(str, str2));
    }

    public void setHost(Host host) {
        if (this.authority == null) {
            this.authority = new Authority();
        }
        this.authority.setHost(host);
    }

    public void setHostPort(HostPort hostPort) {
        if (this.authority == null) {
            this.authority = new Authority();
        }
        this.authority.setHostPort(hostPort);
    }

    public void setIsdnSubAddress(String str) {
        if (this.telephoneSubscriber == null) {
            this.telephoneSubscriber = new TelephoneNumber();
        }
        this.telephoneSubscriber.setIsdnSubaddress(str);
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void setLrParam() {
        this.uriParms.set("lr", null);
    }

    public void setMAddr(String str) {
        NameValue nameValue = this.uriParms.getNameValue("maddr");
        Host host = new Host();
        host.setAddress(str);
        if (nameValue != null) {
            nameValue.setValueAsObject(host);
        } else {
            this.uriParms.set(new NameValue("maddr", host));
        }
    }

    @Override // ir.nasim.ND6
    public void setMAddrParam(String str) throws NumberFormatException, ParseException {
        if (str == null) {
            throw new NullPointerException("bad maddr");
        }
        setParameter("maddr", str);
    }

    public void setMethod(String str) {
        this.uriParms.set("method", str);
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void setMethodParam(String str) throws NumberFormatException, ParseException {
        setParameter("method", str);
    }

    @Override // ir.nasim.InterfaceC20733sW4
    public void setParameter(String str, String str2) throws NumberFormatException, ParseException {
        if (str.equalsIgnoreCase("ttl")) {
            try {
                Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                throw new ParseException("bad parameter " + str2, 0);
            }
        }
        this.uriParms.set(str, str2);
    }

    @Override // ir.nasim.ND6
    public void setPort(int i) {
        if (this.authority == null) {
            this.authority = new Authority();
        }
        this.authority.setPort(i);
    }

    public void setQHeader(NameValue nameValue) {
        this.qheaders.set(nameValue);
    }

    public void setQheaders(NameValueList nameValueList) {
        this.qheaders = nameValueList;
    }

    public void setScheme(String str) {
        if (str.compareToIgnoreCase("sip") == 0 || str.compareToIgnoreCase("sips") == 0) {
            this.scheme = str.toLowerCase();
            return;
        }
        throw new IllegalArgumentException("bad scheme " + str);
    }

    @Override // ir.nasim.ND6
    public void setSecure(boolean z) {
        if (z) {
            this.scheme = "sips";
        } else {
            this.scheme = "sip";
        }
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void setTTLParam(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Bad ttl value");
        }
        if (this.uriParms != null) {
            this.uriParms.set(new NameValue("ttl", Integer.valueOf(i)));
        }
    }

    public void setTelephoneSubscriber(TelephoneNumber telephoneNumber) {
        this.telephoneSubscriber = telephoneNumber;
    }

    @Override // ir.nasim.ND6
    public void setTransportParam(String str) {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        this.uriParms.set(new NameValue(android.gov.nist.javax.sip.header.ParameterNames.TRANSPORT, str.toLowerCase()));
    }

    public void setUriParameter(NameValue nameValue) {
        this.uriParms.set(nameValue);
    }

    public void setUriParm(String str, Object obj) {
        this.uriParms.set(new NameValue(str, obj));
    }

    public void setUriParms(NameValueList nameValueList) {
        this.uriParms = nameValueList;
    }

    @Override // ir.nasim.ND6
    public void setUser(String str) {
        if (this.authority == null) {
            this.authority = new Authority();
        }
        this.authority.setUser(str);
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void setUserParam(String str) {
        this.uriParms.set("user", str);
    }

    @Override // android.gov.nist.javax.sip.address.SipURIExt
    public void setUserPassword(String str) {
        if (this.authority == null) {
            this.authority = new Authority();
        }
        this.authority.setPassword(str);
    }

    @Override // android.gov.nist.javax.sip.address.GenericURI, android.gov.nist.javax.sip.address.NetObject, ir.nasim.InterfaceC21815uA7
    public String toString() {
        return encode();
    }

    @Override // android.gov.nist.javax.sip.address.GenericURI, android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        sb.append(this.scheme);
        sb.append(":");
        Authority authority = this.authority;
        if (authority != null) {
            authority.encode(sb);
        }
        if (!this.uriParms.isEmpty()) {
            sb.append(Separators.SEMICOLON);
            this.uriParms.encode(sb);
        }
        if (!this.qheaders.isEmpty()) {
            sb.append(Separators.QUESTION);
            this.qheaders.encode(sb);
        }
        return sb;
    }

    @Override // ir.nasim.ND6
    public void setHost(String str) {
        setHost(new Host(str));
    }
}
