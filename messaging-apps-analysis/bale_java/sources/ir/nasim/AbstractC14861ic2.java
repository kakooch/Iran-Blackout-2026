package ir.nasim;

import java.io.File;

/* renamed from: ir.nasim.ic2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14861ic2 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }
}
