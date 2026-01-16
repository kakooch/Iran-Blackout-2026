package kotlin.reflect.jvm.internal.impl.protobuf;

import ir.nasim.LW4;
import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.a;

/* loaded from: classes8.dex */
public abstract class b implements LW4 {
    private static final f a = f.c();

    private l d(l lVar) throws InvalidProtocolBufferException {
        if (lVar == null || lVar.isInitialized()) {
            return lVar;
        }
        throw e(lVar).a().k(lVar);
    }

    private UninitializedMessageException e(l lVar) {
        return lVar instanceof a ? ((a) lVar).c() : new UninitializedMessageException(lVar);
    }

    @Override // ir.nasim.LW4
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public l c(InputStream inputStream, f fVar) {
        return d(h(inputStream, fVar));
    }

    @Override // ir.nasim.LW4
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public l a(InputStream inputStream, f fVar) {
        return d(i(inputStream, fVar));
    }

    public l h(InputStream inputStream, f fVar) throws IOException {
        try {
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            return i(new a.AbstractC1828a.C1829a(inputStream, e.A(i, inputStream)), fVar);
        } catch (IOException e) {
            throw new InvalidProtocolBufferException(e.getMessage());
        }
    }

    public l i(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        e eVarG = e.g(inputStream);
        l lVar = (l) b(eVarG, fVar);
        try {
            eVarG.a(0);
            return lVar;
        } catch (InvalidProtocolBufferException e) {
            throw e.k(lVar);
        }
    }
}
