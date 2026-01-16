package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.NameValue;
import android.gov.nist.core.Separators;
import android.gov.nist.javax.sip.header.ParameterNames;
import android.javax.sdp.SdpException;
import io.appmetrica.analytics.coreutils.internal.services.telephony.CellularNetworkTypeExtractor;
import java.io.Serializable;
import java.util.Vector;

/* loaded from: classes.dex */
public class PreconditionFields implements Serializable {
    public static final int DIRECTION_NONE = 0;
    public static final int DIRECTION_RECV = 2;
    public static final int DIRECTION_SEND = 1;
    public static final int DIRECTION_SENDRECV = 3;
    public static final int PRECONDITION_QOS = 0;
    public static final int STATUS_E2E = 0;
    public static final int STATUS_LOCAL = 1;
    public static final int STATUS_REMOTE = 2;
    public static final int STRENGTH_FAILURE = 1;
    public static final int STRENGTH_MANDATORY = 4;
    public static final int STRENGTH_NONE = 2;
    public static final int STRENGTH_OPTIONAL = 3;
    public static final int STRENGTH_UNKNOWN = 0;
    protected Vector preconditionAttributes = new Vector();
    public static final String[] STRENGTH = {CellularNetworkTypeExtractor.UNKNOWN_NETWORK_TYPE_VALUE, "failure", "none", ParameterNames.OPTIONAL, "mandatory"};
    public static final String[] DIRECTION = {"none", "send", "recv", "sendrecv"};
    public static final String[] STATUS = {"e2e", "local", "remote"};
    public static final String[] PRECONDITION = {"qos"};

    public Vector getPreconditionConfirmStatus() {
        if (this.preconditionAttributes == null) {
            return null;
        }
        Vector vector = new Vector();
        for (int i = 0; i < this.preconditionAttributes.size(); i++) {
            AttributeField attributeField = (AttributeField) this.preconditionAttributes.elementAt(i);
            if (attributeField.getAttribute().getName().equals("conf")) {
                vector.addElement(attributeField);
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        return vector;
    }

    public Vector getPreconditionCurr(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The status-type is null");
        }
        if (this.preconditionAttributes == null) {
            return null;
        }
        Vector vector = new Vector();
        for (int i = 0; i < this.preconditionAttributes.size(); i++) {
            AttributeField attributeField = (AttributeField) this.preconditionAttributes.elementAt(i);
            if (attributeField.getAttribute().getName().equals("curr") && attributeField.getValue().indexOf(str) != -1) {
                vector.addElement(attributeField);
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        return vector;
    }

    public Vector getPreconditionDes(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The status-type is null");
        }
        if (this.preconditionAttributes == null) {
            return null;
        }
        Vector vector = new Vector();
        for (int i = 0; i < this.preconditionAttributes.size(); i++) {
            AttributeField attributeField = (AttributeField) this.preconditionAttributes.elementAt(i);
            if (attributeField.getAttribute().getName().equals("des") && attributeField.getValue().indexOf(str) != -1) {
                vector.addElement(attributeField);
            }
        }
        if (vector.size() == 0) {
            return null;
        }
        return vector;
    }

    public int getPreconditionSize() {
        Vector vector = this.preconditionAttributes;
        if (vector != null) {
            return vector.size();
        }
        return -1;
    }

    public Vector getPreconditions() {
        return this.preconditionAttributes;
    }

    public void setPreconditionConfirmStatus(String str) throws SdpException {
        if (str == null || str.length() == 0) {
            throw new SdpException("The Precondition \"conf\" attribute value is null");
        }
        if (this.preconditionAttributes == null) {
            throw new SdpException("The Precondition Attributes is null");
        }
        try {
            String[] strArrSplit = str.split(Separators.SP);
            setPreconditionConfirmStatus(strArrSplit[1], strArrSplit[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SdpException("Error spliting the \"conf\" attribute into words", e);
        }
    }

    public void setPreconditionCurr(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The Precondition \"curr\" attribute value is null");
        }
        if (this.preconditionAttributes == null) {
            throw new SdpException("The Precondition Attributes is null");
        }
        try {
            String[] strArrSplit = str.split(Separators.SP);
            setPreconditionCurr(strArrSplit[1], strArrSplit[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SdpException("Error spliting the \"curr\" attribute into words", e);
        }
    }

    public void setPreconditionDes(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The Precondition \"des\" attribute value is null");
        }
        if (this.preconditionAttributes == null) {
            throw new SdpException("The Precondition Attributes is null");
        }
        try {
            String[] strArrSplit = str.split(Separators.SP);
            setPreconditionDes(strArrSplit[1], strArrSplit[2], strArrSplit[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new SdpException("Error spliting the \"des\" attribute into words", e);
        }
    }

    public void setPreconditions(Vector vector) throws SdpException {
        if (vector == null) {
            throw new SdpException("Precondition attributes are null");
        }
        this.preconditionAttributes = vector;
    }

    public void setPreconditionCurr(String str, String str2) throws SdpException {
        if (str == null) {
            throw new SdpException("The status-type is null");
        }
        if (str2 != null) {
            if (this.preconditionAttributes != null) {
                int i = 0;
                while (i < this.preconditionAttributes.size()) {
                    AttributeField attributeField = (AttributeField) this.preconditionAttributes.elementAt(i);
                    if (attributeField.getAttribute().getName().equals("curr") && attributeField.getValue().indexOf(str) != -1) {
                        if (attributeField.getValue().indexOf(str2) != -1) {
                            break;
                        }
                        attributeField.setValue("qos " + str + Separators.SP + str2);
                        this.preconditionAttributes.setElementAt(attributeField, i);
                    }
                    i++;
                }
                if (i == this.preconditionAttributes.size()) {
                    NameValue nameValue = new NameValue("curr", "qos " + str + Separators.SP + str2);
                    AttributeField attributeField2 = new AttributeField();
                    attributeField2.setAttribute(nameValue);
                    this.preconditionAttributes.add(attributeField2);
                    return;
                }
                return;
            }
            throw new SdpException("Precondition Attributes is null");
        }
        throw new SdpException("The direction-tag is null");
    }

    public void setPreconditionDes(String str, String str2, String str3) throws SdpException {
        if (str == null) {
            throw new SdpException("The strength-tag is null");
        }
        if (str2 == null) {
            throw new SdpException("The status-type is null");
        }
        if (str3 != null) {
            if (this.preconditionAttributes != null) {
                int i = 0;
                while (i < this.preconditionAttributes.size()) {
                    AttributeField attributeField = (AttributeField) this.preconditionAttributes.elementAt(i);
                    if (attributeField.getAttribute().getName().equals("des") && attributeField.getValue().indexOf(str2) != -1) {
                        attributeField.setValue("qos " + str + Separators.SP + str2 + Separators.SP + str3);
                        this.preconditionAttributes.setElementAt(attributeField, i);
                    }
                    i++;
                }
                if (i == this.preconditionAttributes.size()) {
                    NameValue nameValue = new NameValue("des", "qos " + str + Separators.SP + str2 + Separators.SP + str3);
                    AttributeField attributeField2 = new AttributeField();
                    attributeField2.setAttribute(nameValue);
                    this.preconditionAttributes.add(attributeField2);
                    return;
                }
                return;
            }
            throw new SdpException("Precondition Attributes is null");
        }
        throw new SdpException("The direction-tag is null");
    }

    public void setPreconditionConfirmStatus(String str, String str2) throws SdpException {
        if (str != null && str2.length() != 0) {
            if (str2.length() != 0) {
                if (this.preconditionAttributes != null) {
                    int i = 0;
                    while (true) {
                        if (i >= this.preconditionAttributes.size()) {
                            break;
                        }
                        AttributeField attributeField = (AttributeField) this.preconditionAttributes.elementAt(i);
                        if (!attributeField.getAttribute().getName().equals("conf") || attributeField.getValue().indexOf(str) == -1) {
                            i++;
                        } else if (attributeField.getValue().indexOf(str2) == -1) {
                            attributeField.setValue("qos " + str + Separators.SP + str2);
                            this.preconditionAttributes.setElementAt(attributeField, i);
                        }
                    }
                    if (i == this.preconditionAttributes.size()) {
                        NameValue nameValue = new NameValue("conf", "qos " + str + Separators.SP + str2);
                        AttributeField attributeField2 = new AttributeField();
                        attributeField2.setAttribute(nameValue);
                        this.preconditionAttributes.add(attributeField2);
                        return;
                    }
                    return;
                }
                throw new SdpException("Precondition Attributes is null");
            }
            throw new SdpException("The direction-tag is null");
        }
        throw new SdpException("The status-type is null");
    }
}
