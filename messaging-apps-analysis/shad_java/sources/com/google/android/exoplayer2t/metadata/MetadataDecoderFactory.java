package com.google.android.exoplayer2t.metadata;

import com.google.android.exoplayer2t.Format;
import com.google.android.exoplayer2t.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2t.metadata.icy.IcyDecoder;
import com.google.android.exoplayer2t.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2t.metadata.scte35.SpliceInfoDecoder;

/* loaded from: classes.dex */
public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT = new MetadataDecoderFactory() { // from class: com.google.android.exoplayer2t.metadata.MetadataDecoderFactory.1
        @Override // com.google.android.exoplayer2t.metadata.MetadataDecoderFactory
        public boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str);
        }

        @Override // com.google.android.exoplayer2t.metadata.MetadataDecoderFactory
        public MetadataDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            if (str != null) {
                switch (str) {
                    case "application/x-icy":
                        return new IcyDecoder();
                    case "application/id3":
                        return new Id3Decoder();
                    case "application/x-emsg":
                        return new EventMessageDecoder();
                    case "application/x-scte35":
                        return new SpliceInfoDecoder();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    };

    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
