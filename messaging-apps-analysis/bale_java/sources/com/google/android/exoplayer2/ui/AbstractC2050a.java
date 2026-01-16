package com.google.android.exoplayer2.ui;

import android.gov.nist.core.Separators;
import android.graphics.Color;
import ir.nasim.AbstractC9683aN7;

/* renamed from: com.google.android.exoplayer2.ui.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC2050a {
    public static String a(String str) {
        return Separators.DOT + str + ",." + str + " *";
    }

    public static String b(int i) {
        return AbstractC9683aN7.A("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Double.valueOf(Color.alpha(i) / 255.0d));
    }
}
