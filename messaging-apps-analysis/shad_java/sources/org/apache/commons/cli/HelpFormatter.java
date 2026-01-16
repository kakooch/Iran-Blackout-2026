package org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class HelpFormatter {
    public int defaultWidth = 74;
    public int defaultLeftPad = 1;
    public int defaultDescPad = 3;
    public String defaultNewLine = System.getProperty("line.separator");
    public String defaultOptPrefix = "-";
    public String defaultLongOptPrefix = "--";
    protected Comparator optionComparator = new OptionComparator();

    public int getWidth() {
        return this.defaultWidth;
    }

    public int getLeftPadding() {
        return this.defaultLeftPad;
    }

    public int getDescPadding() {
        return this.defaultDescPad;
    }

    public Comparator getOptionComparator() {
        return this.optionComparator;
    }

    public void printOptions(PrintWriter printWriter, int i, Options options, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        renderOptions(stringBuffer, i, options, i2, i3);
        printWriter.println(stringBuffer.toString());
    }

    protected StringBuffer renderOptions(StringBuffer stringBuffer, int i, Options options, int i2, int i3) {
        String strCreatePadding = createPadding(i2);
        String strCreatePadding2 = createPadding(i3);
        ArrayList arrayList = new ArrayList();
        List<Option> listHelpOptions = options.helpOptions();
        Collections.sort(listHelpOptions, getOptionComparator());
        int i4 = 0;
        int length = 0;
        for (Option option : listHelpOptions) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option.getOpt() == null) {
                stringBuffer2.append(strCreatePadding);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("   ");
                stringBuffer3.append(this.defaultLongOptPrefix);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(option.getLongOpt());
            } else {
                stringBuffer2.append(strCreatePadding);
                stringBuffer2.append(this.defaultOptPrefix);
                stringBuffer2.append(option.getOpt());
                if (option.hasLongOpt()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.defaultLongOptPrefix);
                    stringBuffer2.append(option.getLongOpt());
                }
            }
            if (option.hasArg()) {
                if (option.hasArgName()) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(option.getArgName());
                    stringBuffer2.append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > length) {
                length = stringBuffer2.length();
            }
        }
        Iterator it = listHelpOptions.iterator();
        while (it.hasNext()) {
            Option option2 = (Option) it.next();
            int i5 = i4 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i4).toString());
            if (stringBuffer4.length() < length) {
                stringBuffer4.append(createPadding(length - stringBuffer4.length()));
            }
            stringBuffer4.append(strCreatePadding2);
            int i6 = length + i3;
            if (option2.getDescription() != null) {
                stringBuffer4.append(option2.getDescription());
            }
            renderWrappedText(stringBuffer, i, i6, stringBuffer4.toString());
            if (it.hasNext()) {
                stringBuffer.append(this.defaultNewLine);
            }
            i4 = i5;
        }
        return stringBuffer;
    }

    protected StringBuffer renderWrappedText(StringBuffer stringBuffer, int i, int i2, String str) {
        int iFindWrapPos = findWrapPos(str, i, 0);
        if (iFindWrapPos == -1) {
            stringBuffer.append(rtrim(str));
            return stringBuffer;
        }
        stringBuffer.append(rtrim(str.substring(0, iFindWrapPos)));
        stringBuffer.append(this.defaultNewLine);
        if (i2 >= i) {
            i2 = 1;
        }
        String strCreatePadding = createPadding(i2);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(strCreatePadding);
            stringBuffer2.append(str.substring(iFindWrapPos).trim());
            str = stringBuffer2.toString();
            iFindWrapPos = findWrapPos(str, i, 0);
            if (iFindWrapPos == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i && iFindWrapPos == i2 - 1) {
                iFindWrapPos = i;
            }
            stringBuffer.append(rtrim(str.substring(0, iFindWrapPos)));
            stringBuffer.append(this.defaultNewLine);
        }
    }

    protected int findWrapPos(String str, int i, int i2) {
        char cCharAt;
        char cCharAt2;
        int iIndexOf = str.indexOf(10, i2);
        if ((iIndexOf != -1 && iIndexOf <= i) || ((iIndexOf = str.indexOf(9, i2)) != -1 && iIndexOf <= i)) {
            return iIndexOf + 1;
        }
        int i3 = i + i2;
        if (i3 >= str.length()) {
            return -1;
        }
        int i4 = i3;
        while (i4 >= i2 && (cCharAt2 = str.charAt(i4)) != ' ' && cCharAt2 != '\n' && cCharAt2 != '\r') {
            i4--;
        }
        if (i4 > i2) {
            return i4;
        }
        while (i3 <= str.length() && (cCharAt = str.charAt(i3)) != ' ' && cCharAt != '\n' && cCharAt != '\r') {
            i3++;
        }
        if (i3 == str.length()) {
            return -1;
        }
        return i3;
    }

    protected String createPadding(int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    protected String rtrim(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }

    private static class OptionComparator implements Comparator {
        private OptionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Option) obj).getKey().compareToIgnoreCase(((Option) obj2).getKey());
        }
    }
}
