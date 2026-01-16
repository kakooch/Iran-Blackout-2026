package android.gov.nist.javax.sip.address;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public final class UserInfo extends NetObject {
    public static final int TELEPHONE_SUBSCRIBER = 1;
    public static final int USER = 2;
    private static final long serialVersionUID = 7268593273924256144L;
    protected String password;
    protected String user;
    protected int userType;

    public void clearPassword() {
        this.password = null;
    }

    @Override // android.gov.nist.core.GenericObject
    public String encode() {
        return encode(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.address.NetObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (UserInfo.class != obj.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (this.userType != userInfo.userType || !this.user.equalsIgnoreCase(userInfo.user)) {
            return false;
        }
        String str = this.password;
        if (str != null && userInfo.password == null) {
            return false;
        }
        String str2 = userInfo.password;
        if (str2 != null && str == null) {
            return false;
        }
        if (str == str2) {
            return true;
        }
        return str.equals(str2);
    }

    public String getPassword() {
        return this.password;
    }

    public String getUser() {
        return this.user;
    }

    public int getUserType() {
        return this.userType;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUser(String str) {
        if (str == null || "".equals(str)) {
            return;
        }
        this.user = str;
        if (str.indexOf(Separators.POUND) >= 0 || str.indexOf(Separators.SEMICOLON) >= 0) {
            setUserType(1);
        } else {
            setUserType(2);
        }
    }

    public void setUserType(int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Parameter not in range");
        }
        this.userType = i;
    }

    @Override // android.gov.nist.core.GenericObject
    public StringBuilder encode(StringBuilder sb) {
        if (this.password != null) {
            sb.append(this.user);
            sb.append(":");
            sb.append(this.password);
        } else {
            sb.append(this.user);
        }
        return sb;
    }
}
