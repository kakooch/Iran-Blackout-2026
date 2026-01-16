package io.grpc.protobuf.lite;

import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.KnownLength;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes3.dex */
public final class ProtoLiteUtils {
    static volatile ExtensionRegistryLite globalRegistry = ExtensionRegistryLite.getEmptyRegistry();

    public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshaller(T t) {
        return new MessageMarshaller(t);
    }

    static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream, "inputStream cannot be null!");
        Preconditions.checkNotNull(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += i;
        }
    }

    private static final class MessageMarshaller<T extends MessageLite> implements MethodDescriptor.Marshaller {
        private static final ThreadLocal<Reference<byte[]>> bufs = new ThreadLocal<>();
        private final T defaultInstance;
        private final Parser<T> parser;

        MessageMarshaller(T t) {
            this.defaultInstance = t;
            this.parser = (Parser<T>) t.getParserForType();
        }

        @Override // io.grpc.MethodDescriptor.Marshaller
        public InputStream stream(T t) {
            return new ProtoInputStream(t, this.parser);
        }

        @Override // io.grpc.MethodDescriptor.Marshaller
        public T parse(InputStream inputStream) throws IOException {
            byte[] bArr;
            if ((inputStream instanceof ProtoInputStream) && ((ProtoInputStream) inputStream).parser() == this.parser) {
                try {
                    return (T) ((ProtoInputStream) inputStream).message();
                } catch (IllegalStateException unused) {
                }
            }
            CodedInputStream codedInputStreamNewInstance = null;
            try {
                if (inputStream instanceof KnownLength) {
                    int iAvailable = inputStream.available();
                    if (iAvailable > 0 && iAvailable <= 4194304) {
                        ThreadLocal<Reference<byte[]>> threadLocal = bufs;
                        Reference<byte[]> reference = threadLocal.get();
                        if (reference == null || (bArr = reference.get()) == null || bArr.length < iAvailable) {
                            bArr = new byte[iAvailable];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i = iAvailable;
                        while (i > 0) {
                            int i2 = inputStream.read(bArr, iAvailable - i, i);
                            if (i2 == -1) {
                                break;
                            }
                            i -= i2;
                        }
                        if (i != 0) {
                            throw new RuntimeException("size inaccurate: " + iAvailable + " != " + (iAvailable - i));
                        }
                        codedInputStreamNewInstance = CodedInputStream.newInstance(bArr, 0, iAvailable);
                    } else if (iAvailable == 0) {
                        return this.defaultInstance;
                    }
                }
                if (codedInputStreamNewInstance == null) {
                    codedInputStreamNewInstance = CodedInputStream.newInstance(inputStream);
                }
                codedInputStreamNewInstance.setSizeLimit(ConnectionsManager.DEFAULT_DATACENTER_ID);
                try {
                    return (T) parseFrom(codedInputStreamNewInstance);
                } catch (InvalidProtocolBufferException e) {
                    throw Status.INTERNAL.withDescription("Invalid protobuf byte sequence").withCause(e).asRuntimeException();
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        private T parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
            T from = this.parser.parseFrom(codedInputStream, ProtoLiteUtils.globalRegistry);
            try {
                codedInputStream.checkLastTagWas(0);
                return from;
            } catch (InvalidProtocolBufferException e) {
                e.setUnfinishedMessage(from);
                throw e;
            }
        }
    }
}
