package android.gov.nist.javax.sip.header;

import android.gov.nist.core.DuplicateNameValueList;
import android.gov.nist.core.NameValue;
import android.gov.nist.core.NameValueList;
import android.gov.nist.javax.sip.address.GenericURI;
import ir.nasim.InterfaceC20733sW4;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class ParametersHeader extends SIPHeader implements InterfaceC20733sW4, ParametersExt, Serializable {
    protected DuplicateNameValueList duplicates;
    protected NameValueList parameters;

    protected ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
    }

    @Override // android.gov.nist.core.GenericObject
    public Object clone() {
        ParametersHeader parametersHeader = (ParametersHeader) super.clone();
        NameValueList nameValueList = this.parameters;
        if (nameValueList != null) {
            parametersHeader.parameters = (NameValueList) nameValueList.clone();
        }
        return parametersHeader;
    }

    @Override // android.gov.nist.javax.sip.header.SIPHeader
    protected abstract StringBuilder encodeBody(StringBuilder sb);

    protected final boolean equalParameters(InterfaceC20733sW4 interfaceC20733sW4) {
        if (this == interfaceC20733sW4) {
            return true;
        }
        Iterator<String> parameterNames = getParameterNames();
        while (parameterNames.hasNext()) {
            String next = parameterNames.next();
            String parameter = getParameter(next);
            String parameter2 = interfaceC20733sW4.getParameter(next);
            if ((parameter == null) ^ (parameter2 == null)) {
                return false;
            }
            if (parameter != null && !parameter.equalsIgnoreCase(parameter2)) {
                return false;
            }
        }
        Iterator parameterNames2 = interfaceC20733sW4.getParameterNames();
        while (parameterNames2.hasNext()) {
            String str = (String) parameterNames2.next();
            String parameter3 = interfaceC20733sW4.getParameter(str);
            String parameter4 = getParameter(str);
            if ((parameter3 == null) ^ (parameter4 == null)) {
                return false;
            }
            if (parameter3 != null && !parameter3.equalsIgnoreCase(parameter4)) {
                return false;
            }
        }
        return true;
    }

    public String getMultiParameter(String str) {
        return this.duplicates.getParameter(str);
    }

    public Iterator<String> getMultiParameterNames() {
        return this.duplicates.getNames();
    }

    public Object getMultiParameterValue(String str) {
        return this.duplicates.getValue(str);
    }

    public DuplicateNameValueList getMultiParameters() {
        return this.duplicates;
    }

    public NameValue getNameValue(String str) {
        return this.parameters.getNameValue(str);
    }

    @Override // ir.nasim.InterfaceC20733sW4
    public String getParameter(String str) {
        return this.parameters.getParameter(str);
    }

    protected boolean getParameterAsBoolean(String str) {
        Object parameterValue = getParameterValue(str);
        if (parameterValue == null) {
            return false;
        }
        if (parameterValue instanceof Boolean) {
            return ((Boolean) parameterValue).booleanValue();
        }
        if (parameterValue instanceof String) {
            return Boolean.valueOf((String) parameterValue).booleanValue();
        }
        return false;
    }

    protected float getParameterAsFloat(String str) {
        if (getParameterValue(str) != null) {
            try {
                return getParameterValue(str) instanceof String ? Float.parseFloat(getParameter(str)) : ((Float) getParameterValue(str)).floatValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0f;
    }

    protected int getParameterAsHexInt(String str) {
        if (getParameterValue(str) != null) {
            try {
                return getParameterValue(str) instanceof String ? Integer.parseInt(getParameter(str), 16) : ((Integer) getParameterValue(str)).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    protected int getParameterAsInt(String str) {
        if (getParameterValue(str) != null) {
            try {
                return getParameterValue(str) instanceof String ? Integer.parseInt(getParameter(str)) : ((Integer) getParameterValue(str)).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    protected long getParameterAsLong(String str) {
        if (getParameterValue(str) != null) {
            try {
                return getParameterValue(str) instanceof String ? Long.parseLong(getParameter(str)) : ((Long) getParameterValue(str)).longValue();
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    protected GenericURI getParameterAsURI(String str) {
        Object parameterValue = getParameterValue(str);
        if (parameterValue instanceof GenericURI) {
            return (GenericURI) parameterValue;
        }
        try {
            return new GenericURI((String) parameterValue);
        } catch (ParseException unused) {
            return null;
        }
    }

    @Override // ir.nasim.InterfaceC20733sW4
    public Iterator<String> getParameterNames() {
        return this.parameters.getNames();
    }

    public Object getParameterValue(String str) {
        return this.parameters.getValue(str);
    }

    public NameValueList getParameters() {
        return this.parameters;
    }

    public boolean hasMultiParameter(String str) {
        return this.duplicates.hasNameValue(str);
    }

    public boolean hasMultiParameters() {
        DuplicateNameValueList duplicateNameValueList = this.duplicates;
        return (duplicateNameValueList == null || duplicateNameValueList.isEmpty()) ? false : true;
    }

    public boolean hasParameter(String str) {
        return this.parameters.hasNameValue(str);
    }

    public boolean hasParameters() {
        NameValueList nameValueList = this.parameters;
        return (nameValueList == null || nameValueList.isEmpty()) ? false : true;
    }

    public void removeMultiParameter(String str) {
        this.duplicates.delete(str);
    }

    public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
    }

    @Override // ir.nasim.InterfaceC20733sW4
    public void removeParameter(String str) {
        this.parameters.delete(str);
    }

    public void removeParameters() {
        this.parameters = new NameValueList();
    }

    public void setMultiParameter(String str, String str2) {
        NameValue nameValue = new NameValue();
        nameValue.setName(str);
        nameValue.setValue(str2);
        this.duplicates.set(nameValue);
    }

    public void setParameter(String str, String str2) {
        NameValue nameValue = this.parameters.getNameValue(str);
        if (nameValue != null) {
            nameValue.setValueAsObject(str2);
        } else {
            this.parameters.set(new NameValue(str, str2));
        }
    }

    public void setParameters(NameValueList nameValueList) {
        this.parameters = nameValueList;
    }

    @Override // android.gov.nist.javax.sip.header.ParametersExt
    public void setQuotedParameter(String str, String str2) {
        NameValue nameValue = this.parameters.getNameValue(str);
        if (nameValue != null) {
            nameValue.setValueAsObject(str2);
            nameValue.setQuotedValue();
        } else {
            NameValue nameValue2 = new NameValue(str, str2);
            nameValue2.setQuotedValue();
            this.parameters.set(nameValue2);
        }
    }

    @Override // android.gov.nist.javax.sip.header.ParametersExt
    public String getParameter(String str, boolean z) {
        return this.parameters.getParameter(str, z);
    }

    protected ParametersHeader(String str) {
        super(str);
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
    }

    public void setMultiParameter(NameValue nameValue) {
        this.duplicates.set(nameValue);
    }

    protected void setParameter(String str, int i) {
        this.parameters.set(str, Integer.valueOf(i));
    }

    protected ParametersHeader(String str, boolean z) {
        super(str);
        this.parameters = new NameValueList(z);
        this.duplicates = new DuplicateNameValueList();
    }

    protected void setParameter(String str, boolean z) {
        this.parameters.set(str, Boolean.valueOf(z));
    }

    protected void setParameter(String str, float f) {
        Float fValueOf = Float.valueOf(f);
        NameValue nameValue = this.parameters.getNameValue(str);
        if (nameValue != null) {
            nameValue.setValueAsObject(fValueOf);
        } else {
            this.parameters.set(new NameValue(str, fValueOf));
        }
    }

    protected void setParameter(String str, Object obj) {
        this.parameters.set(str, obj);
    }

    public void setParameter(NameValue nameValue) {
        this.parameters.set(nameValue);
    }
}
