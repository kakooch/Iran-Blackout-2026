package io.antmedia.android.broadcaster.utils;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Resolution implements Serializable {
    public final int height;
    public final int width;

    public Resolution(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
