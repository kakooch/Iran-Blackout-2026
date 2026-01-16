package android.gov.nist.javax.sdp;

import android.gov.nist.javax.sdp.fields.AttributeField;
import android.gov.nist.javax.sdp.fields.BandwidthField;
import android.gov.nist.javax.sdp.fields.ConnectionField;
import android.gov.nist.javax.sdp.fields.EmailField;
import android.gov.nist.javax.sdp.fields.InformationField;
import android.gov.nist.javax.sdp.fields.KeyField;
import android.gov.nist.javax.sdp.fields.MediaField;
import android.gov.nist.javax.sdp.fields.OriginField;
import android.gov.nist.javax.sdp.fields.PhoneField;
import android.gov.nist.javax.sdp.fields.ProtoVersionField;
import android.gov.nist.javax.sdp.fields.RepeatField;
import android.gov.nist.javax.sdp.fields.SDPField;
import android.gov.nist.javax.sdp.fields.SessionNameField;
import android.gov.nist.javax.sdp.fields.TimeField;
import android.gov.nist.javax.sdp.fields.URIField;
import android.gov.nist.javax.sdp.fields.ZoneField;
import android.javax.sdp.SdpException;
import android.javax.sdp.SdpParseException;
import ir.nasim.AM4;
import ir.nasim.InterfaceC11382cu6;
import ir.nasim.InterfaceC15571jo3;
import ir.nasim.InterfaceC16641ld1;
import ir.nasim.InterfaceC22405vA7;
import ir.nasim.InterfaceC23547x63;
import ir.nasim.InterfaceC8892Xt6;
import ir.nasim.ZR7;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Vector;

/* loaded from: classes.dex */
public class SessionDescriptionImpl implements InterfaceC8892Xt6 {
    protected Vector attributesList;
    protected Vector bandwidthList;
    protected ConnectionField connectionImpl;
    private MediaDescriptionImpl currentMediaDescription;
    private TimeDescriptionImpl currentTimeDescription;
    protected Vector emailList;
    protected InformationField infoImpl;
    protected KeyField keyImpl;
    protected Vector mediaDescriptions;
    protected OriginField originImpl;
    protected Vector phoneList;
    protected SessionNameField sessionNameImpl;
    protected Vector timeDescriptions;
    protected URIField uriImpl;
    protected ProtoVersionField versionImpl;
    protected Vector zoneAdjustments;

    public SessionDescriptionImpl() {
    }

    private String encodeVector(Vector vector) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vector.size(); i++) {
            sb.append(vector.elementAt(i));
        }
        return sb.toString();
    }

    public void addField(SDPField sDPField) throws ParseException {
        try {
            if (sDPField instanceof ProtoVersionField) {
                this.versionImpl = (ProtoVersionField) sDPField;
                return;
            }
            if (sDPField instanceof OriginField) {
                this.originImpl = (OriginField) sDPField;
                return;
            }
            if (sDPField instanceof SessionNameField) {
                this.sessionNameImpl = (SessionNameField) sDPField;
                return;
            }
            if (sDPField instanceof InformationField) {
                MediaDescriptionImpl mediaDescriptionImpl = this.currentMediaDescription;
                if (mediaDescriptionImpl != null) {
                    mediaDescriptionImpl.setInformationField((InformationField) sDPField);
                    return;
                } else {
                    this.infoImpl = (InformationField) sDPField;
                    return;
                }
            }
            if (sDPField instanceof URIField) {
                this.uriImpl = (URIField) sDPField;
                return;
            }
            if (sDPField instanceof ConnectionField) {
                MediaDescriptionImpl mediaDescriptionImpl2 = this.currentMediaDescription;
                if (mediaDescriptionImpl2 != null) {
                    mediaDescriptionImpl2.setConnectionField((ConnectionField) sDPField);
                    return;
                } else {
                    this.connectionImpl = (ConnectionField) sDPField;
                    return;
                }
            }
            if (sDPField instanceof KeyField) {
                MediaDescriptionImpl mediaDescriptionImpl3 = this.currentMediaDescription;
                if (mediaDescriptionImpl3 != null) {
                    mediaDescriptionImpl3.setKey((KeyField) sDPField);
                    return;
                } else {
                    this.keyImpl = (KeyField) sDPField;
                    return;
                }
            }
            if (sDPField instanceof EmailField) {
                getEmails(true).add(sDPField);
                return;
            }
            if (sDPField instanceof PhoneField) {
                getPhones(true).add(sDPField);
                return;
            }
            if (sDPField instanceof TimeField) {
                this.currentTimeDescription = new TimeDescriptionImpl((TimeField) sDPField);
                getTimeDescriptions(true).add(this.currentTimeDescription);
                return;
            }
            if (sDPField instanceof RepeatField) {
                TimeDescriptionImpl timeDescriptionImpl = this.currentTimeDescription;
                if (timeDescriptionImpl == null) {
                    throw new ParseException("no time specified", 0);
                }
                timeDescriptionImpl.addRepeatField((RepeatField) sDPField);
                return;
            }
            if (sDPField instanceof ZoneField) {
                getZoneAdjustments(true).add(sDPField);
                return;
            }
            if (sDPField instanceof BandwidthField) {
                MediaDescriptionImpl mediaDescriptionImpl4 = this.currentMediaDescription;
                if (mediaDescriptionImpl4 != null) {
                    mediaDescriptionImpl4.addBandwidthField((BandwidthField) sDPField);
                    return;
                } else {
                    getBandwidths(true).add(sDPField);
                    return;
                }
            }
            if (sDPField instanceof AttributeField) {
                if (this.currentMediaDescription == null) {
                    getAttributes(true).add(sDPField);
                    return;
                } else {
                    ((AttributeField) sDPField).getName();
                    this.currentMediaDescription.addAttribute((AttributeField) sDPField);
                    return;
                }
            }
            if (sDPField instanceof MediaField) {
                this.currentMediaDescription = new MediaDescriptionImpl();
                getMediaDescriptions(true).add(this.currentMediaDescription);
                this.currentMediaDescription.setMediaField((MediaField) sDPField);
            }
        } catch (SdpException unused) {
            throw new ParseException(sDPField.encode(), 0);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            return new SessionDescriptionImpl(this);
        } catch (SdpException unused) {
            throw new CloneNotSupportedException();
        }
    }

    public String getAttribute(String str) {
        AttributeField attributeField;
        String name;
        if (str == null || this.attributesList == null) {
            return null;
        }
        for (int i = 0; i < this.attributesList.size(); i++) {
            Object objElementAt = this.attributesList.elementAt(i);
            if ((objElementAt instanceof AttributeField) && (name = (attributeField = (AttributeField) objElementAt).getName()) != null && str.equals(name)) {
                return attributeField.getValue();
            }
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public Vector getAttributes(boolean z) {
        if (this.attributesList == null && z) {
            this.attributesList = new Vector();
        }
        return this.attributesList;
    }

    public int getBandwidth(String str) {
        BandwidthField bandwidthField;
        String type;
        if (str == null || this.bandwidthList == null) {
            return -1;
        }
        for (int i = 0; i < this.bandwidthList.size(); i++) {
            Object objElementAt = this.bandwidthList.elementAt(i);
            if ((objElementAt instanceof BandwidthField) && (type = (bandwidthField = (BandwidthField) objElementAt).getType()) != null && str.equals(type)) {
                return bandwidthField.getValue();
            }
        }
        return -1;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public Vector getBandwidths(boolean z) {
        if (this.bandwidthList == null && z) {
            this.bandwidthList = new Vector();
        }
        return this.bandwidthList;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public InterfaceC16641ld1 getConnection() {
        return this.connectionImpl;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public Vector getEmails(boolean z) {
        if (this.emailList == null && z) {
            this.emailList = new Vector();
        }
        return this.emailList;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public InterfaceC23547x63 getInfo() {
        return this.infoImpl;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public InterfaceC15571jo3 getKey() {
        return this.keyImpl;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public Vector getMediaDescriptions(boolean z) {
        if (this.mediaDescriptions == null && z) {
            this.mediaDescriptions = new Vector();
        }
        return this.mediaDescriptions;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public AM4 getOrigin() {
        return this.originImpl;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public Vector getPhones(boolean z) {
        if (this.phoneList == null && z) {
            this.phoneList = new Vector();
        }
        return this.phoneList;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public InterfaceC11382cu6 getSessionName() {
        return this.sessionNameImpl;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public Vector getTimeDescriptions(boolean z) {
        if (this.timeDescriptions == null && z) {
            this.timeDescriptions = new Vector();
        }
        return this.timeDescriptions;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public InterfaceC22405vA7 getURI() {
        return this.uriImpl;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public ZR7 getVersion() {
        return this.versionImpl;
    }

    @Override // ir.nasim.InterfaceC8892Xt6
    public Vector getZoneAdjustments(boolean z) {
        if (this.zoneAdjustments == null && z) {
            this.zoneAdjustments = new Vector();
        }
        return this.zoneAdjustments;
    }

    public void removeAttribute(String str) {
        if (str == null || this.attributesList == null) {
            return;
        }
        for (int i = 0; i < this.attributesList.size(); i++) {
            Object objElementAt = this.attributesList.elementAt(i);
            if (objElementAt instanceof AttributeField) {
                AttributeField attributeField = (AttributeField) objElementAt;
                try {
                    String name = attributeField.getName();
                    if (name != null && str.equals(name)) {
                        this.attributesList.remove(attributeField);
                    }
                } catch (SdpParseException unused) {
                }
            }
        }
    }

    public void removeBandwidth(String str) {
        if (str == null || this.bandwidthList == null) {
            return;
        }
        for (int i = 0; i < this.bandwidthList.size(); i++) {
            Object objElementAt = this.bandwidthList.elementAt(i);
            if (objElementAt instanceof BandwidthField) {
                BandwidthField bandwidthField = (BandwidthField) objElementAt;
                try {
                    String type = bandwidthField.getType();
                    if (type != null && str.equals(type)) {
                        this.bandwidthList.remove(bandwidthField);
                    }
                } catch (SdpParseException unused) {
                }
            }
        }
    }

    public void setAttribute(String str, String str2) throws SdpException {
        AttributeField attributeField;
        String name;
        if (str == null || str2 == null) {
            throw new SdpException("The parameter is null");
        }
        if (this.attributesList != null) {
            for (int i = 0; i < this.attributesList.size(); i++) {
                Object objElementAt = this.attributesList.elementAt(i);
                if ((objElementAt instanceof AttributeField) && (name = (attributeField = (AttributeField) objElementAt).getName()) != null && str.equals(name)) {
                    attributeField.setValue(str2);
                }
            }
        }
    }

    public void setAttributes(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The parameter is null");
        }
        this.attributesList = vector;
    }

    public void setBandwidth(String str, int i) throws SdpException {
        BandwidthField bandwidthField;
        String type;
        if (str == null) {
            throw new SdpException("The parameter is null");
        }
        if (this.bandwidthList != null) {
            for (int i2 = 0; i2 < this.bandwidthList.size(); i2++) {
                Object objElementAt = this.bandwidthList.elementAt(i2);
                if ((objElementAt instanceof BandwidthField) && (type = (bandwidthField = (BandwidthField) objElementAt).getType()) != null && str.equals(type)) {
                    bandwidthField.setValue(i);
                }
            }
        }
    }

    public void setBandwidths(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The parameter is null");
        }
        this.bandwidthList = vector;
    }

    public void setConnection(InterfaceC16641ld1 interfaceC16641ld1) throws SdpException {
        if (interfaceC16641ld1 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(interfaceC16641ld1 instanceof ConnectionField)) {
            throw new SdpException("Bad implementation class ConnectionField");
        }
        this.connectionImpl = (ConnectionField) interfaceC16641ld1;
    }

    public void setEmails(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The parameter is null");
        }
        this.emailList = vector;
    }

    public void setInfo(InterfaceC23547x63 interfaceC23547x63) throws SdpException {
        if (interfaceC23547x63 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(interfaceC23547x63 instanceof InformationField)) {
            throw new SdpException("The parameter must be an instance of InformationField");
        }
        this.infoImpl = (InformationField) interfaceC23547x63;
    }

    public void setKey(InterfaceC15571jo3 interfaceC15571jo3) throws SdpException {
        if (interfaceC15571jo3 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(interfaceC15571jo3 instanceof KeyField)) {
            throw new SdpException("The parameter must be an instance of KeyField");
        }
        this.keyImpl = (KeyField) interfaceC15571jo3;
    }

    public void setMediaDescriptions(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The parameter is null");
        }
        this.mediaDescriptions = vector;
    }

    public void setOrigin(AM4 am4) throws SdpException {
        if (am4 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(am4 instanceof OriginField)) {
            throw new SdpException("The parameter must be an instance of OriginField");
        }
        this.originImpl = (OriginField) am4;
    }

    public void setPhones(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The parameter is null");
        }
        this.phoneList = vector;
    }

    public void setSessionName(InterfaceC11382cu6 interfaceC11382cu6) throws SdpException {
        if (interfaceC11382cu6 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(interfaceC11382cu6 instanceof SessionNameField)) {
            throw new SdpException("The parameter must be an instance of SessionNameField");
        }
        this.sessionNameImpl = (SessionNameField) interfaceC11382cu6;
    }

    public void setTimeDescriptions(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The parameter is null");
        }
        this.timeDescriptions = vector;
    }

    public void setURI(InterfaceC22405vA7 interfaceC22405vA7) throws SdpException {
        if (interfaceC22405vA7 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(interfaceC22405vA7 instanceof URIField)) {
            throw new SdpException("The parameter must be an instance of URIField");
        }
        this.uriImpl = (URIField) interfaceC22405vA7;
    }

    public void setVersion(ZR7 zr7) throws SdpException {
        if (zr7 == null) {
            throw new SdpException("The parameter is null");
        }
        if (!(zr7 instanceof ProtoVersionField)) {
            throw new SdpException("The parameter must be an instance of VersionField");
        }
        this.versionImpl = (ProtoVersionField) zr7;
    }

    public void setZoneAdjustments(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("The parameter is null");
        }
        this.zoneAdjustments = vector;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strEncodeVector = "";
        sb.append(getVersion() == null ? "" : getVersion().toString());
        sb.append(getOrigin() == null ? "" : getOrigin().toString());
        sb.append(getSessionName() == null ? "" : getSessionName().toString());
        sb.append(getInfo() == null ? "" : getInfo().toString());
        try {
            sb.append(getURI() == null ? "" : getURI().toString());
            sb.append(getEmails(false) == null ? "" : encodeVector(getEmails(false)));
            sb.append(getPhones(false) == null ? "" : encodeVector(getPhones(false)));
            sb.append(getConnection() == null ? "" : getConnection().toString());
            sb.append(getBandwidths(false) == null ? "" : encodeVector(getBandwidths(false)));
            sb.append(getTimeDescriptions(false) == null ? "" : encodeVector(getTimeDescriptions(false)));
            sb.append(getZoneAdjustments(false) == null ? "" : encodeVector(getZoneAdjustments(false)));
            sb.append(getKey() == null ? "" : getKey().toString());
            sb.append(getAttributes(false) == null ? "" : encodeVector(getAttributes(false)));
            if (getMediaDescriptions(false) != null) {
                strEncodeVector = encodeVector(getMediaDescriptions(false));
            }
            sb.append(strEncodeVector);
        } catch (SdpException unused) {
        }
        return sb.toString();
    }

    public SessionDescriptionImpl(InterfaceC8892Xt6 interfaceC8892Xt6) throws SdpException {
        if (interfaceC8892Xt6 == null) {
            return;
        }
        ZR7 version = interfaceC8892Xt6.getVersion();
        if (version != null) {
            setVersion((ZR7) version.clone());
        }
        AM4 origin = interfaceC8892Xt6.getOrigin();
        if (origin != null) {
            setOrigin((AM4) origin.clone());
        }
        InterfaceC11382cu6 sessionName = interfaceC8892Xt6.getSessionName();
        if (sessionName != null) {
            setSessionName((InterfaceC11382cu6) sessionName.clone());
        }
        InterfaceC23547x63 info = interfaceC8892Xt6.getInfo();
        if (info != null) {
            setInfo((InterfaceC23547x63) info.clone());
        }
        URIField uRIField = (URIField) interfaceC8892Xt6.getURI();
        if (uRIField != null) {
            URIField uRIField2 = new URIField();
            uRIField2.set(uRIField.get());
            setURI(uRIField2);
        }
        InterfaceC16641ld1 connection = interfaceC8892Xt6.getConnection();
        if (connection != null) {
            setConnection((InterfaceC16641ld1) connection.clone());
        }
        InterfaceC15571jo3 key = interfaceC8892Xt6.getKey();
        if (key != null) {
            setKey((InterfaceC15571jo3) key.clone());
        }
        Vector timeDescriptions = interfaceC8892Xt6.getTimeDescriptions(false);
        if (timeDescriptions != null) {
            Vector vector = new Vector();
            Iterator it = timeDescriptions.iterator();
            while (it.hasNext()) {
                TimeDescriptionImpl timeDescriptionImpl = (TimeDescriptionImpl) it.next();
                if (timeDescriptionImpl != null) {
                    TimeDescriptionImpl timeDescriptionImpl2 = new TimeDescriptionImpl((TimeField) timeDescriptionImpl.getTime().clone());
                    Vector repeatTimes = timeDescriptionImpl.getRepeatTimes(false);
                    if (repeatTimes != null) {
                        Iterator it2 = repeatTimes.iterator();
                        while (it2.hasNext()) {
                            RepeatField repeatField = (RepeatField) it2.next();
                            if (repeatField != null) {
                                timeDescriptionImpl2.addRepeatField((RepeatField) repeatField.clone());
                            }
                        }
                    }
                    vector.add(timeDescriptionImpl2);
                }
            }
            setTimeDescriptions(vector);
        }
        Vector emails = interfaceC8892Xt6.getEmails(false);
        if (emails != null) {
            Vector vector2 = new Vector();
            Iterator it3 = emails.iterator();
            while (it3.hasNext()) {
                EmailField emailField = (EmailField) it3.next();
                if (emailField != null) {
                    vector2.add((EmailField) emailField.clone());
                }
            }
            setEmails(vector2);
        }
        Vector phones = interfaceC8892Xt6.getPhones(false);
        if (phones != null) {
            Vector vector3 = new Vector();
            Iterator it4 = phones.iterator();
            while (it4.hasNext()) {
                PhoneField phoneField = (PhoneField) it4.next();
                if (phoneField != null) {
                    vector3.add((PhoneField) phoneField.clone());
                }
            }
            setPhones(vector3);
        }
        Vector zoneAdjustments = interfaceC8892Xt6.getZoneAdjustments(false);
        if (zoneAdjustments != null) {
            Vector vector4 = new Vector();
            Iterator it5 = zoneAdjustments.iterator();
            while (it5.hasNext()) {
                ZoneField zoneField = (ZoneField) it5.next();
                if (zoneField != null) {
                    vector4.add((ZoneField) zoneField.clone());
                }
            }
            setZoneAdjustments(vector4);
        }
        Vector bandwidths = interfaceC8892Xt6.getBandwidths(false);
        if (bandwidths != null) {
            Vector vector5 = new Vector();
            Iterator it6 = bandwidths.iterator();
            while (it6.hasNext()) {
                BandwidthField bandwidthField = (BandwidthField) it6.next();
                if (bandwidthField != null) {
                    vector5.add((BandwidthField) bandwidthField.clone());
                }
            }
            setBandwidths(vector5);
        }
        Vector attributes = interfaceC8892Xt6.getAttributes(false);
        if (attributes != null) {
            Vector vector6 = new Vector();
            Iterator it7 = attributes.iterator();
            while (it7.hasNext()) {
                AttributeField attributeField = (AttributeField) it7.next();
                if (attributeField != null) {
                    vector6.add((AttributeField) attributeField.clone());
                }
            }
            setAttributes(vector6);
        }
        Vector mediaDescriptions = interfaceC8892Xt6.getMediaDescriptions(false);
        if (mediaDescriptions != null) {
            Vector vector7 = new Vector();
            Iterator it8 = mediaDescriptions.iterator();
            while (it8.hasNext()) {
                MediaDescriptionImpl mediaDescriptionImpl = (MediaDescriptionImpl) it8.next();
                if (mediaDescriptionImpl != null) {
                    MediaDescriptionImpl mediaDescriptionImpl2 = new MediaDescriptionImpl();
                    MediaField mediaField = mediaDescriptionImpl.getMediaField();
                    if (mediaField != null) {
                        MediaField mediaField2 = new MediaField();
                        mediaField2.setMedia(mediaField.getMedia());
                        mediaField2.setPort(mediaField.getPort());
                        mediaField2.setNports(mediaField.getNports());
                        mediaField2.setProto(mediaField.getProto());
                        Vector formats = mediaField.getFormats();
                        if (formats != null) {
                            Vector vector8 = new Vector();
                            Iterator it9 = formats.iterator();
                            while (it9.hasNext()) {
                                Object next = it9.next();
                                if (next != null) {
                                    vector8.add(String.valueOf(next));
                                }
                            }
                            mediaField2.setFormats(vector8);
                        }
                        mediaDescriptionImpl2.setMedia(mediaField2);
                    }
                    InformationField informationField = mediaDescriptionImpl.getInformationField();
                    if (informationField != null) {
                        mediaDescriptionImpl2.setInformationField((InformationField) informationField.clone());
                    }
                    ConnectionField connectionField = mediaDescriptionImpl.getConnectionField();
                    if (connectionField != null) {
                        mediaDescriptionImpl2.setConnectionField((ConnectionField) connectionField.clone());
                    }
                    Vector bandwidths2 = mediaDescriptionImpl.getBandwidths(false);
                    if (bandwidths2 != null) {
                        Vector vector9 = new Vector();
                        Iterator it10 = bandwidths2.iterator();
                        while (it10.hasNext()) {
                            BandwidthField bandwidthField2 = (BandwidthField) it10.next();
                            if (bandwidthField2 != null) {
                                vector9.add((BandwidthField) bandwidthField2.clone());
                            }
                        }
                        mediaDescriptionImpl2.setBandwidths(vector9);
                    }
                    KeyField keyField = mediaDescriptionImpl.getKeyField();
                    if (keyField != null) {
                        mediaDescriptionImpl2.setKeyField((KeyField) keyField.clone());
                    }
                    Vector attributeFields = mediaDescriptionImpl.getAttributeFields();
                    if (attributeFields != null) {
                        Vector vector10 = new Vector();
                        Iterator it11 = attributeFields.iterator();
                        while (it11.hasNext()) {
                            AttributeField attributeField2 = (AttributeField) it11.next();
                            if (attributeField2 != null) {
                                vector10.add((AttributeField) attributeField2.clone());
                            }
                        }
                        mediaDescriptionImpl2.setAttributeFields(vector10);
                    }
                    vector7.add(mediaDescriptionImpl2);
                }
            }
            setMediaDescriptions(vector7);
        }
    }
}
