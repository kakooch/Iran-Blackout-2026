package android.gov.nist.javax.sip.header;

import android.gov.nist.core.Separators;
import ir.nasim.InterfaceC19085pl1;

/* loaded from: classes.dex */
public class ContentType extends ParametersHeader implements InterfaceC19085pl1 {
    private static final long serialVersionUID = 8475682204373446610L;
    protected MediaRange mediaRange;

    public ContentType() {
        super(SIPHeaderNames.CONTENT_TYPE);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.core.GenericObject
    public Object clone() {
        ContentType contentType = (ContentType) super.clone();
        MediaRange mediaRange = this.mediaRange;
        if (mediaRange != null) {
            contentType.mediaRange = (MediaRange) mediaRange.clone();
        }
        return contentType;
    }

    public int compareMediaRange(String str) {
        return (this.mediaRange.type + Separators.SLASH + this.mediaRange.subtype).compareToIgnoreCase(str);
    }

    public String encodeBody() {
        return encodeBody(new StringBuilder()).toString();
    }

    @Override // android.gov.nist.javax.sip.header.SIPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (!(obj instanceof InterfaceC19085pl1)) {
            return false;
        }
        InterfaceC19085pl1 interfaceC19085pl1 = (InterfaceC19085pl1) obj;
        return getContentType().equalsIgnoreCase(interfaceC19085pl1.getContentType()) && getContentSubType().equalsIgnoreCase(interfaceC19085pl1.getContentSubType()) && equalParameters(interfaceC19085pl1);
    }

    public String getCharset() {
        return getParameter("charset");
    }

    @Override // ir.nasim.InterfaceC20759sZ3
    public String getContentSubType() {
        MediaRange mediaRange = this.mediaRange;
        if (mediaRange == null) {
            return null;
        }
        return mediaRange.getSubtype();
    }

    @Override // ir.nasim.InterfaceC20759sZ3
    public String getContentType() {
        MediaRange mediaRange = this.mediaRange;
        if (mediaRange == null) {
            return null;
        }
        return mediaRange.getType();
    }

    public MediaRange getMediaRange() {
        return this.mediaRange;
    }

    public String getMediaSubType() {
        return this.mediaRange.subtype;
    }

    public String getMediaType() {
        return this.mediaRange.type;
    }

    public void setContentSubType(String str) {
        if (str == null) {
            throw new NullPointerException("null arg");
        }
        if (this.mediaRange == null) {
            this.mediaRange = new MediaRange();
        }
        this.mediaRange.setSubtype(str);
    }

    public void setContentType(String str, String str2) {
        if (this.mediaRange == null) {
            this.mediaRange = new MediaRange();
        }
        this.mediaRange.setType(str);
        this.mediaRange.setSubtype(str2);
    }

    public void setMediaRange(MediaRange mediaRange) {
        this.mediaRange = mediaRange;
    }

    public ContentType(String str, String str2) {
        this();
        setContentType(str, str2);
    }

    @Override // android.gov.nist.javax.sip.header.ParametersHeader, android.gov.nist.javax.sip.header.SIPHeader
    protected StringBuilder encodeBody(StringBuilder sb) {
        this.mediaRange.encode(sb);
        if (hasParameters()) {
            sb.append(Separators.SEMICOLON);
            this.parameters.encode(sb);
        }
        return sb;
    }

    public void setContentType(String str) {
        if (str != null) {
            if (this.mediaRange == null) {
                this.mediaRange = new MediaRange();
            }
            this.mediaRange.setType(str);
            return;
        }
        throw new NullPointerException("null arg");
    }
}
