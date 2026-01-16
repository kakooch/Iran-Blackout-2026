package com.neovisionaries.ws.client;

/* loaded from: classes3.dex */
public class StatusLine {
    private final int mStatusCode;
    private final String mString;

    StatusLine(String str) {
        String[] strArrSplit = str.split(" +", 3);
        if (strArrSplit.length < 2) {
            throw new IllegalArgumentException();
        }
        String str2 = strArrSplit[0];
        this.mStatusCode = Integer.parseInt(strArrSplit[1]);
        if (strArrSplit.length == 3) {
            String str3 = strArrSplit[2];
        }
        this.mString = str;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String toString() {
        return this.mString;
    }
}
