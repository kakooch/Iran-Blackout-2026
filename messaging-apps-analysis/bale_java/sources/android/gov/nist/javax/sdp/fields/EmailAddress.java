package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;

/* loaded from: classes.dex */
public class EmailAddress extends SDPObject {
    protected String displayName;
    protected Email email;

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        EmailAddress emailAddress = (EmailAddress) super.clone();
        Email email = this.email;
        if (email != null) {
            emailAddress.email = (Email) email.clone();
        }
        return emailAddress;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str;
        if (this.displayName != null) {
            str = this.displayName + Separators.LESS_THAN;
        } else {
            str = "";
        }
        String str2 = str + this.email.encode();
        if (this.displayName == null) {
            return str2;
        }
        return str2 + Separators.GREATER_THAN;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
