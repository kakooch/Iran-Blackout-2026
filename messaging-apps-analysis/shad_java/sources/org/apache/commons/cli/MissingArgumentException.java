package org.apache.commons.cli;

/* loaded from: classes4.dex */
public class MissingArgumentException extends ParseException {
    public MissingArgumentException(String str) {
        super(str);
    }

    public MissingArgumentException(Option option) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Missing argument for option: ");
        stringBuffer.append(option.getKey());
        this(stringBuffer.toString());
    }
}
