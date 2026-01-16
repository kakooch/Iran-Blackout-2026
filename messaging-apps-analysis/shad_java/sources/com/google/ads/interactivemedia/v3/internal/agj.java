package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.io.StringWriter;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class agj {
    public final String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            ald aldVar = new ald(stringWriter);
            aldVar.m(true);
            com.google.ads.interactivemedia.v3.impl.data.ax.b(this, aldVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
