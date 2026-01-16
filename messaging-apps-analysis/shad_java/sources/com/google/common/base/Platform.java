package com.google.common.base;

import java.util.Locale;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class Platform {
    static {
        Logger.getLogger(Platform.class.getName());
        loadPatternCompiler();
    }

    private Platform() {
    }

    static long systemNanoTime() {
        return System.nanoTime();
    }

    static String formatCompact4Digits(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    static boolean stringIsNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    static String emptyToNull(String str) {
        if (stringIsNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler();
    }

    private static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }
    }
}
