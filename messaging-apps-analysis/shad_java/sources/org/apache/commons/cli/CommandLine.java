package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class CommandLine implements Serializable {
    private List args = new LinkedList();
    private List options = new ArrayList();

    CommandLine() {
    }

    public boolean hasOption(String str) {
        return this.options.contains(resolveOption(str));
    }

    private Option resolveOption(String str) {
        String strStripLeadingHyphens = Util.stripLeadingHyphens(str);
        for (Option option : this.options) {
            if (strStripLeadingHyphens.equals(option.getOpt()) || strStripLeadingHyphens.equals(option.getLongOpt())) {
                return option;
            }
        }
        return null;
    }

    public List getArgList() {
        return this.args;
    }

    void addArg(String str) {
        this.args.add(str);
    }

    void addOption(Option option) {
        this.options.add(option);
    }
}
