package android.gov.nist.javax.sdp.fields;

import android.gov.nist.core.NameValue;
import android.gov.nist.core.Separators;
import android.javax.sdp.SdpException;
import ir.nasim.InterfaceC23330wk2;

/* loaded from: classes.dex */
public class AttributeField extends SDPField implements InterfaceC23330wk2 {
    protected NameValue attribute;

    public AttributeField() {
        super(SDPFieldNames.ATTRIBUTE_FIELD);
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        AttributeField attributeField = (AttributeField) super.clone();
        NameValue nameValue = this.attribute;
        if (nameValue != null) {
            attributeField.attribute = (NameValue) nameValue.clone();
        }
        return attributeField;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public String encode() {
        NameValue nameValue = this.attribute;
        String str = SDPFieldNames.ATTRIBUTE_FIELD;
        if (nameValue != null) {
            str = SDPFieldNames.ATTRIBUTE_FIELD + this.attribute.encode();
        }
        return str + Separators.NEWLINE;
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPObject, android.gov.nist.core.GenericObject
    public boolean equals(Object obj) {
        if (!(obj instanceof AttributeField)) {
            return false;
        }
        AttributeField attributeField = (AttributeField) obj;
        return attributeField.getAttribute().getName().equalsIgnoreCase(getAttribute().getName()) && (getAttribute().getValueAsObject() != null ? getAttribute().getValueAsObject().equals(attributeField.getAttribute().getValueAsObject()) : attributeField.getAttribute().getValueAsObject() == null);
    }

    public NameValue getAttribute() {
        return this.attribute;
    }

    public String getName() {
        String name;
        NameValue attribute = getAttribute();
        if (attribute == null || (name = attribute.getName()) == null) {
            return null;
        }
        return name;
    }

    public String getValue() {
        Object valueAsObject;
        NameValue attribute = getAttribute();
        if (attribute == null || (valueAsObject = attribute.getValueAsObject()) == null) {
            return null;
        }
        return valueAsObject instanceof String ? (String) valueAsObject : valueAsObject.toString();
    }

    public boolean hasValue() {
        NameValue attribute = getAttribute();
        return (attribute == null || attribute.getValueAsObject() == null) ? false : true;
    }

    public int hashCode() {
        if (getAttribute() != null) {
            return encode().hashCode();
        }
        throw new UnsupportedOperationException("Attribute is null cannot compute hashCode ");
    }

    public void setAttribute(NameValue nameValue) {
        this.attribute = nameValue;
        nameValue.setSeparator(":");
    }

    public void setName(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The name is null");
        }
        NameValue attribute = getAttribute();
        if (attribute == null) {
            attribute = new NameValue();
        }
        attribute.setName(str);
        setAttribute(attribute);
    }

    public void setValue(String str) throws SdpException {
        if (str == null) {
            throw new SdpException("The value is null");
        }
        NameValue attribute = getAttribute();
        if (attribute == null) {
            attribute = new NameValue();
        }
        attribute.setValueAsObject(str);
        setAttribute(attribute);
    }

    public void setValueAllowNull(String str) {
        NameValue attribute = getAttribute();
        if (attribute == null) {
            attribute = new NameValue();
        }
        attribute.setValueAsObject(str);
        setAttribute(attribute);
    }

    @Override // android.gov.nist.javax.sdp.fields.SDPField, android.gov.nist.javax.sdp.fields.SDPObject
    public String toString() {
        return encode();
    }
}
