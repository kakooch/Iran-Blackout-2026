package com.google.protobuf;

import com.google.protobuf.AbstractC2383g;
import com.google.protobuf.P;
import ir.nasim.InterfaceC3919Cx3;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC2377a implements P {
    protected int memoizedHashCode = 0;

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        AbstractC0204a.b(iterable, (List) collection);
    }

    private String b(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    protected static void checkByteStringIsUtf8(AbstractC2383g abstractC2383g) {
        if (!abstractC2383g.Q()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    abstract int getSerializedSize(e0 e0Var);

    UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException(this);
    }

    @Override // com.google.protobuf.P
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream codedOutputStreamD0 = CodedOutputStream.d0(bArr);
            writeTo(codedOutputStreamD0);
            codedOutputStreamD0.d();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(b("byte array"), e);
        }
    }

    public AbstractC2383g toByteString() {
        try {
            AbstractC2383g.h hVarS = AbstractC2383g.S(getSerializedSize());
            writeTo(hVarS.b());
            return hVarS.a();
        } catch (IOException e) {
            throw new RuntimeException(b("ByteString"), e);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) {
        int serializedSize = getSerializedSize();
        CodedOutputStream codedOutputStreamC0 = CodedOutputStream.c0(outputStream, CodedOutputStream.G(CodedOutputStream.U(serializedSize) + serializedSize));
        codedOutputStreamC0.V0(serializedSize);
        writeTo(codedOutputStreamC0);
        codedOutputStreamC0.Z();
    }

    public void writeTo(OutputStream outputStream) {
        CodedOutputStream codedOutputStreamC0 = CodedOutputStream.c0(outputStream, CodedOutputStream.G(getSerializedSize()));
        writeTo(codedOutputStreamC0);
        codedOutputStreamC0.Z();
    }

    /* renamed from: com.google.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0204a implements P.a {
        protected static void b(Iterable iterable, List list) {
            B.a(iterable);
            if (!(iterable instanceof InterfaceC3919Cx3)) {
                if (iterable instanceof Z) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    c(iterable, list);
                    return;
                }
            }
            List listN = ((InterfaceC3919Cx3) iterable).n();
            InterfaceC3919Cx3 interfaceC3919Cx3 = (InterfaceC3919Cx3) list;
            int size = list.size();
            for (Object obj : listN) {
                if (obj == null) {
                    String str = "Element at index " + (interfaceC3919Cx3.size() - size) + " is null.";
                    for (int size2 = interfaceC3919Cx3.size() - 1; size2 >= size; size2--) {
                        interfaceC3919Cx3.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC2383g) {
                    interfaceC3919Cx3.X((AbstractC2383g) obj);
                } else {
                    interfaceC3919Cx3.add((String) obj);
                }
            }
        }

        private static void c(Iterable iterable, List list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (Object obj : iterable) {
                if (obj == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(obj);
            }
        }

        private String d(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        protected static UninitializedMessageException m(P p) {
            return new UninitializedMessageException(p);
        }

        protected abstract AbstractC0204a e(AbstractC2377a abstractC2377a);

        @Override // com.google.protobuf.P.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public AbstractC0204a X0(AbstractC2383g abstractC2383g, C2394s c2394s) throws InvalidProtocolBufferException {
            try {
                AbstractC2384h abstractC2384hV = abstractC2383g.V();
                h(abstractC2384hV, c2394s);
                abstractC2384hV.a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(d("ByteString"), e2);
            }
        }

        public abstract AbstractC0204a h(AbstractC2384h abstractC2384h, C2394s c2394s);

        @Override // com.google.protobuf.P.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public AbstractC0204a A0(P p) {
            if (getDefaultInstanceForType().getClass().isInstance(p)) {
                return e((AbstractC2377a) p);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public AbstractC0204a k(byte[] bArr) {
            return l(bArr, 0, bArr.length);
        }

        public abstract AbstractC0204a l(byte[] bArr, int i, int i2);

        /* renamed from: com.google.protobuf.a$a$a, reason: collision with other inner class name */
        static final class C0205a extends FilterInputStream {
            private int a;

            C0205a(InputStream inputStream, int i) {
                super(inputStream);
                this.a = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.a <= 0) {
                    return -1;
                }
                int i = super.read();
                if (i >= 0) {
                    this.a--;
                }
                return i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) {
                int iSkip = (int) super.skip(Math.min(j, this.a));
                if (iSkip >= 0) {
                    this.a -= iSkip;
                }
                return iSkip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.a;
                if (i3 <= 0) {
                    return -1;
                }
                int i4 = super.read(bArr, i, Math.min(i2, i3));
                if (i4 >= 0) {
                    this.a -= i4;
                }
                return i4;
            }
        }
    }

    protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        AbstractC0204a.b(iterable, list);
    }
}
