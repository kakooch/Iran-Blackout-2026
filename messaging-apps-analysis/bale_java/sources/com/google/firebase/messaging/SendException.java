package com.google.firebase.messaging;

import java.util.Locale;

/* loaded from: classes3.dex */
public final class SendException extends Exception {
    private final int a;

    SendException(String str) {
        super(str);
        this.a = a(str);
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.hashCode();
        switch (lowerCase) {
        }
        return 0;
    }
}
