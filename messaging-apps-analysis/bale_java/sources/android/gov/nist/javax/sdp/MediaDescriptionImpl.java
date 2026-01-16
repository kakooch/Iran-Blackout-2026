package android.gov.nist.javax.sdp;

import android.gov.nist.core.NameValue;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sdp.fields.AttributeField;
import android.gov.nist.javax.sdp.fields.BandwidthField;
import android.gov.nist.javax.sdp.fields.ConnectionField;
import android.gov.nist.javax.sdp.fields.InformationField;
import android.gov.nist.javax.sdp.fields.KeyField;
import android.gov.nist.javax.sdp.fields.MediaField;
import android.gov.nist.javax.sdp.fields.PreconditionFields;
import android.gov.nist.javax.sdp.fields.SDPField;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC15571jo3;
import ir.nasim.InterfaceC16577lW3;
import ir.nasim.InterfaceC16586lX3;
import ir.nasim.InterfaceC16641ld1;
import ir.nasim.InterfaceC23547x63;
import java.util.Vector;

/* loaded from: classes.dex */
public class MediaDescriptionImpl implements InterfaceC16586lX3 {
    protected ConnectionField connectionField;
    protected InformationField informationField;
    protected KeyField keyField;
    protected MediaField mediaField;
    protected Vector bandwidthFields = new Vector();
    protected Vector attributeFields = new Vector();
    protected PreconditionFields preconditionFields = new PreconditionFields();

    @Override // ir.nasim.InterfaceC16586lX3
    public void addAttribute(AttributeField attributeField) {
        this.attributeFields.add(attributeField);
    }

    public void addBandwidthField(BandwidthField bandwidthField) {
        this.bandwidthFields.add(bandwidthField);
    }

    public void addDynamicPayloads(Vector vector, Vector vector2) throws SdpException {
        if (vector == null || vector2 == null) {
            throw new SdpException(" The vectors are null");
        }
        if (vector.isEmpty() || vector2.isEmpty()) {
            throw new SdpException(" The vectors are empty");
        }
        if (vector.size() != vector2.size()) {
            throw new SdpException(" The vector sizes are unequal");
        }
        for (int i = 0; i < vector.size(); i++) {
            setAttribute((String) vector.elementAt(i), (String) vector2.elementAt(i));
        }
    }

    public String encode() {
        StringBuilder sb = new StringBuilder();
        MediaField mediaField = this.mediaField;
        if (mediaField != null) {
            sb.append(mediaField.encode());
        }
        InformationField informationField = this.informationField;
        if (informationField != null) {
            sb.append(informationField.encode());
        }
        ConnectionField connectionField = this.connectionField;
        if (connectionField != null) {
            sb.append(connectionField.encode());
        }
        if (this.bandwidthFields != null) {
            for (int i = 0; i < this.bandwidthFields.size(); i++) {
                sb.append(((SDPField) this.bandwidthFields.elementAt(i)).encode());
            }
            PreconditionFields preconditionFields = this.preconditionFields;
            if (preconditionFields != null) {
                int preconditionSize = preconditionFields.getPreconditionSize();
                for (int i2 = 0; i2 < preconditionSize; i2++) {
                    sb.append(((SDPField) this.preconditionFields.getPreconditions().elementAt(i2)).encode());
                }
            }
        }
        KeyField keyField = this.keyField;
        if (keyField != null) {
            sb.append(keyField.encode());
        }
        if (this.attributeFields != null) {
            for (int i3 = 0; i3 < this.attributeFields.size(); i3++) {
                sb.append(((SDPField) this.attributeFields.elementAt(i3)).encode());
            }
        }
        return sb.toString();
    }

    @Override // ir.nasim.InterfaceC16586lX3
    public String getAttribute(String str) {
        if (str == null) {
            throw new NullPointerException("null arg!");
        }
        for (int i = 0; i < this.attributeFields.size(); i++) {
            AttributeField attributeField = (AttributeField) this.attributeFields.elementAt(i);
            if (str.equals(attributeField.getAttribute().getName())) {
                return (String) attributeField.getAttribute().getValueAsObject();
            }
        }
        return null;
    }

    public Vector getAttributeFields() {
        return this.attributeFields;
    }

    @Override // ir.nasim.InterfaceC16586lX3
    public Vector getAttributes(boolean z) {
        return this.attributeFields;
    }

    public int getBandwidth(String str) {
        if (str == null) {
            throw new NullPointerException("null parameter");
        }
        if (this.bandwidthFields == null) {
            return -1;
        }
        for (int i = 0; i < this.bandwidthFields.size(); i++) {
            BandwidthField bandwidthField = (BandwidthField) this.bandwidthFields.elementAt(i);
            String bwtype = bandwidthField.getBwtype();
            if (bwtype != null && bwtype.equals(str)) {
                return bandwidthField.getBandwidth();
            }
        }
        return -1;
    }

    public Vector getBandwidths(boolean z) {
        return this.bandwidthFields;
    }

    public InterfaceC16641ld1 getConnection() {
        return this.connectionField;
    }

    public ConnectionField getConnectionField() {
        return this.connectionField;
    }

    public String getDuplexity() {
        for (int i = 0; i < this.attributeFields.size(); i++) {
            AttributeField attributeField = (AttributeField) this.attributeFields.elementAt(i);
            if (attributeField.getAttribute().getName().equalsIgnoreCase("sendrecv") || attributeField.getAttribute().getName().equalsIgnoreCase("recvonly") || attributeField.getAttribute().getName().equalsIgnoreCase("sendonly") || attributeField.getAttribute().getName().equalsIgnoreCase("inactive")) {
                return attributeField.getAttribute().getName();
            }
        }
        return null;
    }

    public InterfaceC23547x63 getInfo() {
        InformationField informationField = getInformationField();
        if (informationField == null) {
            return null;
        }
        return informationField;
    }

    public InformationField getInformationField() {
        return this.informationField;
    }

    public InterfaceC15571jo3 getKey() {
        KeyField keyField = this.keyField;
        if (keyField == null) {
            return null;
        }
        return keyField;
    }

    public KeyField getKeyField() {
        return this.keyField;
    }

    @Override // ir.nasim.InterfaceC16586lX3
    public InterfaceC16577lW3 getMedia() {
        return this.mediaField;
    }

    public MediaField getMediaField() {
        return this.mediaField;
    }

    public Vector getMimeParameters() {
        String attribute = getAttribute("rate");
        String attribute2 = getAttribute("ptime");
        String attribute3 = getAttribute("maxptime");
        String attribute4 = getAttribute("ftmp");
        Vector vector = new Vector();
        vector.addElement(attribute);
        vector.addElement(attribute2);
        vector.addElement(attribute3);
        vector.addElement(attribute4);
        return vector;
    }

    public Vector getMimeTypes() {
        String str;
        MediaField mediaField = (MediaField) getMedia();
        String mediaType = mediaField.getMediaType();
        String protocol = mediaField.getProtocol();
        Vector mediaFormats = mediaField.getMediaFormats(false);
        Vector vector = new Vector();
        for (int i = 0; i < mediaFormats.size(); i++) {
            if (!protocol.equals("RTP/AVP")) {
                str = mediaType + Separators.SLASH + protocol;
            } else if (getAttribute("rtpmap") != null) {
                str = mediaType + Separators.SLASH + protocol;
            } else {
                str = null;
            }
            vector.addElement(str);
        }
        return vector;
    }

    public Vector getPreconditionFields() {
        return this.preconditionFields.getPreconditions();
    }

    protected boolean hasAttribute(String str) {
        for (int i = 0; i < this.attributeFields.size(); i++) {
            if (((AttributeField) this.attributeFields.elementAt(i)).getAttribute().getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void removeAttribute(String str) {
        if (str == null) {
            throw new NullPointerException("null arg!");
        }
        int i = 0;
        while (i < this.attributeFields.size() && !((AttributeField) this.attributeFields.elementAt(i)).getAttribute().getName().equals(str)) {
            i++;
        }
        if (i < this.attributeFields.size()) {
            this.attributeFields.removeElementAt(i);
        }
    }

    public void removeBandwidth(String str) {
        String bwtype;
        if (str == null) {
            throw new NullPointerException("null bandwidth type");
        }
        int i = 0;
        while (i < this.bandwidthFields.size() && ((bwtype = ((BandwidthField) this.bandwidthFields.elementAt(i)).getBwtype()) == null || !bwtype.equals(str))) {
            i++;
        }
        if (i < this.bandwidthFields.size()) {
            this.bandwidthFields.removeElementAt(i);
        }
    }

    public void setAttribute(String str, String str2) throws SdpException {
        if (str == null) {
            throw new SdpException("The parameters are null");
        }
        int i = 0;
        while (true) {
            if (i >= this.attributeFields.size()) {
                break;
            }
            AttributeField attributeField = (AttributeField) this.attributeFields.elementAt(i);
            if (attributeField.getAttribute().getName().equals(str)) {
                attributeField.getAttribute().setValueAsObject(str2);
                break;
            }
            i++;
        }
        if (i == this.attributeFields.size()) {
            AttributeField attributeField2 = new AttributeField();
            attributeField2.setAttribute(new NameValue(str, str2));
            this.attributeFields.add(attributeField2);
        }
    }

    public void setAttributeFields(Vector vector) {
        this.attributeFields = vector;
    }

    public void setAttributes(Vector vector) {
        this.attributeFields = vector;
    }

    public void setBandwidth(String str, int i) throws SdpException {
        if (str == null) {
            throw new SdpException("The name is null");
        }
        int i2 = 0;
        while (true) {
            if (i2 < this.bandwidthFields.size()) {
                BandwidthField bandwidthField = (BandwidthField) this.bandwidthFields.elementAt(i2);
                String bwtype = bandwidthField.getBwtype();
                if (bwtype != null && bwtype.equals(str)) {
                    bandwidthField.setBandwidth(i);
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (i2 == this.bandwidthFields.size()) {
            BandwidthField bandwidthField2 = new BandwidthField();
            bandwidthField2.setType(str);
            bandwidthField2.setValue(i);
            this.bandwidthFields.add(bandwidthField2);
        }
    }

    public void setBandwidths(Vector vector) {
        if (vector == null) {
            throw new SdpException("The vector bandwidths is null");
        }
        this.bandwidthFields = vector;
    }

    public void setConnection(InterfaceC16641ld1 interfaceC16641ld1) throws SdpException {
        if (interfaceC16641ld1 == null) {
            throw new SdpException("The conn is null");
        }
        if (!(interfaceC16641ld1 instanceof ConnectionField)) {
            throw new SdpException("bad implementation");
        }
        this.connectionField = (ConnectionField) interfaceC16641ld1;
    }

    public void setConnectionField(ConnectionField connectionField) {
        this.connectionField = connectionField;
    }

    public void setDuplexity(String str) {
        if (str == null) {
            throw new NullPointerException("Null arg");
        }
        int i = 0;
        while (i < this.attributeFields.size()) {
            AttributeField attributeField = (AttributeField) this.attributeFields.elementAt(i);
            if (attributeField.getAttribute().getName().equalsIgnoreCase("sendrecv") || attributeField.getAttribute().getName().equalsIgnoreCase("recvonly") || attributeField.getAttribute().getName().equalsIgnoreCase("sendonly") || attributeField.getAttribute().getName().equalsIgnoreCase("inactive")) {
                attributeField.setAttribute(new NameValue(str, null));
                return;
            }
            i++;
        }
        if (i == this.attributeFields.size()) {
            AttributeField attributeField2 = new AttributeField();
            attributeField2.setAttribute(new NameValue(str, null));
            this.attributeFields.add(attributeField2);
        }
    }

    public void setInfo(InterfaceC23547x63 interfaceC23547x63) throws SdpException {
        if (interfaceC23547x63 == null) {
            throw new SdpException("The info is null");
        }
        if (!(interfaceC23547x63 instanceof InformationField)) {
            throw new SdpException("A informationField parameter is required");
        }
        this.informationField = (InformationField) interfaceC23547x63;
    }

    public void setInformationField(InformationField informationField) {
        this.informationField = informationField;
    }

    public void setKey(InterfaceC15571jo3 interfaceC15571jo3) {
        if (interfaceC15571jo3 == null) {
            throw new SdpException("The key is null");
        }
        if (!(interfaceC15571jo3 instanceof KeyField)) {
            throw new SdpException("A keyField parameter is required");
        }
        setKeyField((KeyField) interfaceC15571jo3);
    }

    public void setKeyField(KeyField keyField) {
        this.keyField = keyField;
    }

    public void setMedia(InterfaceC16577lW3 interfaceC16577lW3) {
        if (interfaceC16577lW3 == null) {
            throw new SdpException("The media is null");
        }
        if (!(interfaceC16577lW3 instanceof MediaField)) {
            throw new SdpException("A mediaField parameter is required");
        }
        this.mediaField = (MediaField) interfaceC16577lW3;
    }

    public void setMediaField(MediaField mediaField) {
        this.mediaField = mediaField;
    }

    public void setPreconditionFields(Vector vector) throws SdpException {
        this.preconditionFields.setPreconditions(vector);
    }

    public void setPreconditions(PreconditionFields preconditionFields) {
        this.preconditionFields = preconditionFields;
    }

    public String toString() {
        return encode();
    }
}
