package com.fasterxml.jackson.core;

/* loaded from: classes.dex */
public interface SerializableString {
    int appendQuoted(char[] cArr, int i);

    int appendUnquoted(char[] cArr, int i);

    char[] asQuotedChars();

    String getValue();
}
