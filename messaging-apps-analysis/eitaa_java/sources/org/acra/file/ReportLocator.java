package org.acra.file;

import android.content.Context;
import java.io.File;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ReportLocator {
    private final Context context;

    public ReportLocator(Context context) {
        this.context = context;
    }

    public File getUnapprovedFolder() {
        return this.context.getDir("ACRA-unapproved", 0);
    }

    public File[] getUnapprovedReports() {
        File[] fileArrListFiles = getUnapprovedFolder().listFiles();
        return fileArrListFiles == null ? new File[0] : fileArrListFiles;
    }

    public File getApprovedFolder() {
        return this.context.getDir("ACRA-approved", 0);
    }

    public File[] getApprovedReports() {
        File[] fileArrListFiles = getApprovedFolder().listFiles();
        if (fileArrListFiles == null) {
            return new File[0];
        }
        Arrays.sort(fileArrListFiles, new LastModifiedComparator());
        return fileArrListFiles;
    }
}
