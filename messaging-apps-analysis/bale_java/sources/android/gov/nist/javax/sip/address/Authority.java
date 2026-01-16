package android.gov.nist.javax.sip.address;

import android.gov.nist.core.Host;
import android.gov.nist.core.HostPort;
import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public class Authority extends NetObject {
    private static final long serialVersionUID = -3570349777347017894L;
    protected HostPort hostPort;
    protected UserInfo userInfo;

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        Authority authority = (Authority) super.clone();
        HostPort hostPort = this.hostPort;
        if (hostPort != null) {
            authority.hostPort = (HostPort) hostPort.clone();
        }
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            authority.userInfo = (UserInfo) userInfo.clone();
        }
        return authority;
    }

    @Override // android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.address.NetObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        UserInfo userInfo;
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Authority authority = (Authority) obj;
        if (!this.hostPort.equals(authority.hostPort)) {
            return false;
        }
        UserInfo userInfo2 = this.userInfo;
        return userInfo2 == null || (userInfo = authority.userInfo) == null || userInfo2.equals(userInfo);
    }

    public Host getHost() {
        HostPort hostPort = this.hostPort;
        if (hostPort == null) {
            return null;
        }
        return hostPort.getHost();
    }

    public HostPort getHostPort() {
        return this.hostPort;
    }

    public String getPassword() {
        UserInfo userInfo = this.userInfo;
        if (userInfo == null) {
            return null;
        }
        return userInfo.password;
    }

    public int getPort() {
        HostPort hostPort = this.hostPort;
        if (hostPort == null) {
            return -1;
        }
        return hostPort.getPort();
    }

    public String getUser() {
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            return userInfo.user;
        }
        return null;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public int hashCode() {
        HostPort hostPort = this.hostPort;
        if (hostPort != null) {
            return hostPort.encode().hashCode();
        }
        throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
    }

    public void removePort() {
        HostPort hostPort = this.hostPort;
        if (hostPort != null) {
            hostPort.removePort();
        }
    }

    public void removeUserInfo() {
        this.userInfo = null;
    }

    public void setHost(Host host) {
        if (this.hostPort == null) {
            this.hostPort = new HostPort();
        }
        this.hostPort.setHost(host);
    }

    public void setHostPort(HostPort hostPort) {
        this.hostPort = hostPort;
    }

    public void setPassword(String str) {
        if (this.userInfo == null) {
            this.userInfo = new UserInfo();
        }
        this.userInfo.setPassword(str);
    }

    public void setPort(int i) {
        if (this.hostPort == null) {
            this.hostPort = new HostPort();
        }
        this.hostPort.setPort(i);
    }

    public void setUser(String str) {
        if (this.userInfo == null) {
            this.userInfo = new UserInfo();
        }
        this.userInfo.setUser(str);
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override // android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            userInfo.encode(sb);
            sb.append(Separators.AT);
            this.hostPort.encode(sb);
        } else {
            this.hostPort.encode(sb);
        }
        return sb;
    }
}
