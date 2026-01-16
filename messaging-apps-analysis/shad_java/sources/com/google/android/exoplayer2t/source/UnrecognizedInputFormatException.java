package com.google.android.exoplayer2t.source;

import android.net.Uri;
import com.google.android.exoplayer2t.ParserException;

/* loaded from: classes.dex */
public class UnrecognizedInputFormatException extends ParserException {
    public UnrecognizedInputFormatException(String str, Uri uri) {
        super(str);
    }
}
