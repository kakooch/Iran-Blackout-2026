package org.apache.commons.cli;

/* loaded from: classes4.dex */
public class AlreadySelectedException extends ParseException {
    public AlreadySelectedException(String str) {
        super(str);
    }

    public AlreadySelectedException(OptionGroup optionGroup, Option option) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The option '");
        stringBuffer.append(option.getKey());
        stringBuffer.append("' was specified but an option from this group ");
        stringBuffer.append("has already been selected: '");
        stringBuffer.append(optionGroup.getSelected());
        stringBuffer.append("'");
        this(stringBuffer.toString());
    }
}
