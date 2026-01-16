package com.google.android.exoplayer2t.extractor.mkv;

import com.google.android.exoplayer2t.ParserException;
import com.google.android.exoplayer2t.extractor.ExtractorInput;
import java.io.IOException;

/* loaded from: classes.dex */
public interface EbmlProcessor {
    void binaryElement(int i, int i2, ExtractorInput extractorInput) throws InterruptedException, IOException;

    void endMasterElement(int i) throws ParserException;

    void floatElement(int i, double d) throws ParserException;

    int getElementType(int i);

    void integerElement(int i, long j) throws ParserException;

    boolean isLevel1Element(int i);

    void startMasterElement(int i, long j, long j2) throws ParserException;

    void stringElement(int i, String str) throws ParserException;
}
