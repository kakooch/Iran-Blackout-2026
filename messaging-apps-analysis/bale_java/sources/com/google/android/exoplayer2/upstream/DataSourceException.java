package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes2.dex */
public class DataSourceException extends IOException {
    public final int a;

    public DataSourceException(int i) {
        this.a = i;
    }

    public static boolean a(IOException iOException) {
        for (IOException cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).a == 2008) {
                return true;
            }
        }
        return false;
    }

    public DataSourceException(Throwable th, int i) {
        super(th);
        this.a = i;
    }

    public DataSourceException(String str, int i) {
        super(str);
        this.a = i;
    }

    public DataSourceException(String str, Throwable th, int i) {
        super(str, th);
        this.a = i;
    }
}
