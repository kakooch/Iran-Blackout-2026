package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC22405vA7;
import java.net.URL;

/* loaded from: classes.dex */
public class URIField extends SDPField implements InterfaceC22405vA7 {
    private static final long serialVersionUID = -4322063343955734258L;
    protected URL url;
    protected String urlString;

    public URIField() {
        super(SDPFieldNames.URI_FIELD);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        if (this.urlString != null) {
            return SDPFieldNames.URI_FIELD + this.urlString + Separators.NEWLINE;
        }
        if (this.url == null) {
            return "";
        }
        return SDPFieldNames.URI_FIELD + this.url.toString() + Separators.NEWLINE;
    }

    public URL get() {
        URL url = this.url;
        if (url != null) {
            return url;
        }
        try {
            URL url2 = new URL(this.urlString);
            this.url = url2;
            return url2;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getURI() {
        return this.urlString;
    }

    public void set(URL url) {
        this.url = url;
        this.urlString = null;
    }

    public void setURI(String str) {
        this.urlString = str;
        this.url = null;
    }
}
