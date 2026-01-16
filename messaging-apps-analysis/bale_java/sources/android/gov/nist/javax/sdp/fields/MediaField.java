package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC16577lW3;
import java.util.Vector;

/* loaded from: classes.dex */
public class MediaField extends SDPField implements InterfaceC16577lW3 {
    protected Vector formats;
    protected String media;
    protected int nports;
    protected int port;
    protected String proto;

    public MediaField() {
        super(SDPFieldNames.MEDIA_FIELD);
        this.formats = new Vector();
    }

    private String encodeFormats() {
        StringBuilder sb = new StringBuilder(this.formats.size() * 3);
        for (int i = 0; i < this.formats.size(); i++) {
            sb.append(this.formats.elementAt(i));
            if (i < this.formats.size() - 1) {
                sb.append(Separators.SP);
            }
        }
        return sb.toString();
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        MediaField mediaField = (MediaField) super.clone();
        Vector vector = this.formats;
        if (vector != null) {
            mediaField.formats = (Vector) vector.clone();
        }
        return mediaField;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        String str = this.media;
        String str2 = SDPFieldNames.MEDIA_FIELD;
        if (str != null) {
            str2 = SDPFieldNames.MEDIA_FIELD + this.media.toLowerCase() + Separators.SP + this.port;
        }
        if (this.nports > 1) {
            str2 = str2 + Separators.SLASH + this.nports;
        }
        if (this.proto != null) {
            str2 = str2 + Separators.SP + this.proto;
        }
        if (this.formats != null) {
            str2 = str2 + Separators.SP + encodeFormats();
        }
        return str2 + Separators.NEWLINE;
    }

    public Vector getFormats() {
        return this.formats;
    }

    public String getMedia() {
        return this.media;
    }

    public Vector getMediaFormats(boolean z) {
        if (z || this.formats.size() != 0) {
            return this.formats;
        }
        return null;
    }

    public int getMediaPort() {
        return getPort();
    }

    @Override // ir.nasim.InterfaceC16577lW3
    public String getMediaType() {
        return getMedia();
    }

    public int getNports() {
        return this.nports;
    }

    public int getPort() {
        return this.port;
    }

    public int getPortCount() {
        return getNports();
    }

    public String getProto() {
        return this.proto;
    }

    public String getProtocol() {
        return getProto();
    }

    public void setFormats(Vector vector) {
        this.formats = vector;
    }

    public void setMedia(String str) {
        this.media = str;
    }

    public void setMediaFormats(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The mediaFormats is null");
        }
        this.formats = vector;
    }

    public void setMediaPort(int i) throws SdpException {
        if (i < 0) {
            throw new SdpException("The port is < 0");
        }
        setPort(i);
    }

    public void setMediaType(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The mediaType is null");
        }
        setMedia(str);
    }

    public void setNports(int i) {
        this.nports = i;
    }

    public void setPort(int i) {
        this.port = i;
    }

    public void setPortCount(int i) throws SdpException {
        if (i < 0) {
            throw new SdpException("The port count is < 0");
        }
        setNports(i);
    }

    public void setProto(String str) {
        this.proto = str;
    }

    public void setProtocol(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The protocol is null");
        }
        setProto(str);
    }
}
