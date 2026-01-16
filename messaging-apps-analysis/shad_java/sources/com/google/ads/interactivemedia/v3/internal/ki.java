package com.google.ads.interactivemedia.v3.internal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class ki {
    private static final Pattern c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;
    public int b = -1;

    private final boolean c(String str) throws NumberFormatException {
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i = aeu.a;
            int i2 = Integer.parseInt(strGroup, 16);
            int i3 = Integer.parseInt(matcher.group(2), 16);
            if (i2 <= 0 && i3 <= 0) {
                return false;
            }
            this.a = i2;
            this.b = i3;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean a() {
        return (this.a == -1 || this.b == -1) ? false : true;
    }

    public final void b(qz qzVar) {
        for (int i = 0; i < qzVar.a(); i++) {
            qy qyVarB = qzVar.b(i);
            if (qyVarB instanceof ru) {
                ru ruVar = (ru) qyVarB;
                if ("iTunSMPB".equals(ruVar.b) && c(ruVar.c)) {
                    return;
                }
            } else if (qyVarB instanceof sd) {
                sd sdVar = (sd) qyVarB;
                if ("com.apple.iTunes".equals(sdVar.a) && "iTunSMPB".equals(sdVar.b) && c(sdVar.c)) {
                    return;
                }
            } else {
                continue;
            }
        }
    }
}
