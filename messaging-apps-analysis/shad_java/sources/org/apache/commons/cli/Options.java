package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class Options implements Serializable {
    private Map shortOpts = new HashMap();
    private Map longOpts = new HashMap();
    private List requiredOpts = new ArrayList();
    private Map optionGroups = new HashMap();

    public Options addOption(Option option) {
        String key = option.getKey();
        if (option.hasLongOpt()) {
            this.longOpts.put(option.getLongOpt(), option);
        }
        if (option.isRequired()) {
            if (this.requiredOpts.contains(key)) {
                List list = this.requiredOpts;
                list.remove(list.indexOf(key));
            }
            this.requiredOpts.add(key);
        }
        this.shortOpts.put(key, option);
        return this;
    }

    List helpOptions() {
        return new ArrayList(this.shortOpts.values());
    }

    public List getRequiredOptions() {
        return this.requiredOpts;
    }

    public Option getOption(String str) {
        String strStripLeadingHyphens = Util.stripLeadingHyphens(str);
        if (this.shortOpts.containsKey(strStripLeadingHyphens)) {
            return (Option) this.shortOpts.get(strStripLeadingHyphens);
        }
        return (Option) this.longOpts.get(strStripLeadingHyphens);
    }

    public boolean hasOption(String str) {
        String strStripLeadingHyphens = Util.stripLeadingHyphens(str);
        return this.shortOpts.containsKey(strStripLeadingHyphens) || this.longOpts.containsKey(strStripLeadingHyphens);
    }

    public OptionGroup getOptionGroup(Option option) {
        return (OptionGroup) this.optionGroups.get(option.getKey());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.shortOpts.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.longOpts);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
