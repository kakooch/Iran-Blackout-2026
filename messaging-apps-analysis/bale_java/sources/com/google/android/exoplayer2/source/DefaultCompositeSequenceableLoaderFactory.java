package com.google.android.exoplayer2.source;

/* loaded from: classes2.dex */
public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    @Override // com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory
    public SequenceableLoader a(SequenceableLoader... sequenceableLoaderArr) {
        return new CompositeSequenceableLoader(sequenceableLoaderArr);
    }
}
