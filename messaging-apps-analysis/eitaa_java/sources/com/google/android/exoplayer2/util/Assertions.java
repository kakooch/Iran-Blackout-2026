package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public final class Assertions {
    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static int checkIndex(int index, int start, int limit) {
        if (index < start || index >= limit) {
            throw new IndexOutOfBoundsException();
        }
        return index;
    }

    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    public static void checkState(boolean expression, Object errorMessage) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkStateNotNull(T reference) {
        if (reference != null) {
            return reference;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T reference) {
        reference.getClass();
        return reference;
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String string) {
        if (TextUtils.isEmpty(string)) {
            throw new IllegalArgumentException();
        }
        return string;
    }
}
