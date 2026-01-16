package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class Option implements Cloneable, Serializable {
    private String description;
    private String longOpt;
    private int numberOfArgs;
    private String opt;
    private boolean optionalArg;
    private boolean required;
    private Object type;
    private char valuesep;
    private String argName = "arg";
    private List values = new ArrayList();

    public Option(String str, String str2, boolean z, String str3) throws IllegalArgumentException {
        this.numberOfArgs = -1;
        OptionValidator.validateOption(str);
        this.opt = str;
        this.longOpt = str2;
        if (z) {
            this.numberOfArgs = 1;
        }
        this.description = str3;
    }

    String getKey() {
        String str = this.opt;
        return str == null ? this.longOpt : str;
    }

    public String getOpt() {
        return this.opt;
    }

    public String getLongOpt() {
        return this.longOpt;
    }

    public boolean hasOptionalArg() {
        return this.optionalArg;
    }

    public boolean hasLongOpt() {
        return this.longOpt != null;
    }

    public boolean hasArg() {
        int i = this.numberOfArgs;
        return i > 0 || i == -2;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isRequired() {
        return this.required;
    }

    public String getArgName() {
        return this.argName;
    }

    public boolean hasArgName() {
        String str = this.argName;
        return str != null && str.length() > 0;
    }

    public boolean hasArgs() {
        int i = this.numberOfArgs;
        return i > 1 || i == -2;
    }

    public char getValueSeparator() {
        return this.valuesep;
    }

    public boolean hasValueSeparator() {
        return this.valuesep > 0;
    }

    void addValueForProcessing(String str) {
        if (this.numberOfArgs == -1) {
            throw new RuntimeException("NO_ARGS_ALLOWED");
        }
        processValue(str);
    }

    private void processValue(String str) {
        if (hasValueSeparator()) {
            char valueSeparator = getValueSeparator();
            int iIndexOf = str.indexOf(valueSeparator);
            while (iIndexOf != -1 && this.values.size() != this.numberOfArgs - 1) {
                add(str.substring(0, iIndexOf));
                str = str.substring(iIndexOf + 1);
                iIndexOf = str.indexOf(valueSeparator);
            }
        }
        add(str);
    }

    private void add(String str) {
        if (this.numberOfArgs > 0 && this.values.size() > this.numberOfArgs - 1) {
            throw new RuntimeException("Cannot add value, list full.");
        }
        this.values.add(str);
    }

    public String[] getValues() {
        if (hasNoValues()) {
            return null;
        }
        List list = this.values;
        return (String[]) list.toArray(new String[list.size()]);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ option: ");
        stringBuffer.append(this.opt);
        if (this.longOpt != null) {
            stringBuffer.append(" ");
            stringBuffer.append(this.longOpt);
        }
        stringBuffer.append(" ");
        if (hasArgs()) {
            stringBuffer.append("[ARG...]");
        } else if (hasArg()) {
            stringBuffer.append(" [ARG]");
        }
        stringBuffer.append(" :: ");
        stringBuffer.append(this.description);
        if (this.type != null) {
            stringBuffer.append(" :: ");
            stringBuffer.append(this.type);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    private boolean hasNoValues() {
        return this.values.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Option.class != obj.getClass()) {
            return false;
        }
        Option option = (Option) obj;
        String str = this.opt;
        if (str == null ? option.opt != null : !str.equals(option.opt)) {
            return false;
        }
        String str2 = this.longOpt;
        String str3 = option.longOpt;
        return str2 == null ? str3 == null : str2.equals(str3);
    }

    public int hashCode() {
        String str = this.opt;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.longOpt;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public Object clone() {
        try {
            Option option = (Option) super.clone();
            option.values = new ArrayList(this.values);
            return option;
        } catch (CloneNotSupportedException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("A CloneNotSupportedException was thrown: ");
            stringBuffer.append(e.getMessage());
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    void clearValues() {
        this.values.clear();
    }
}
