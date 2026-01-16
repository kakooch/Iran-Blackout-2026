package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public class Email extends SDPObject {
    protected String hostName;
    protected String userName;

    @Override // android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        return this.userName + Separators.AT + this.hostName;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setHostName(String str) {
        this.hostName = str.trim();
    }

    public void setUserName(String str) {
        this.userName = str;
    }
}
