package com.google.android.exoplayer2t.metadata.emsg;

import com.google.android.exoplayer2t.metadata.Metadata;
import com.google.android.exoplayer2t.metadata.MetadataDecoder;
import com.google.android.exoplayer2t.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2t.util.Assertions;
import com.google.android.exoplayer2t.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EventMessageDecoder implements MetadataDecoder {
    @Override // com.google.android.exoplayer2t.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(metadataInputBuffer.data);
        return new Metadata(decode(new ParsableByteArray(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage decode(ParsableByteArray parsableByteArray) {
        return new EventMessage((String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString()), (String) Assertions.checkNotNull(parsableByteArray.readNullTerminatedString()), parsableByteArray.readUnsignedInt(), parsableByteArray.readUnsignedInt(), Arrays.copyOfRange(parsableByteArray.data, parsableByteArray.getPosition(), parsableByteArray.limit()));
    }
}
