package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.I;
import ir.nasim.InterfaceC4387Ex3;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1932a implements I {
    protected int memoizedHashCode = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0080a implements I.a {
        protected static void c(Iterable iterable, List list) {
            AbstractC1952v.a(iterable);
            if (!(iterable instanceof InterfaceC4387Ex3)) {
                if (iterable instanceof P) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    d(iterable, list);
                    return;
                }
            }
            List listN = ((InterfaceC4387Ex3) iterable).n();
            InterfaceC4387Ex3 interfaceC4387Ex3 = (InterfaceC4387Ex3) list;
            int size = list.size();
            for (Object obj : listN) {
                if (obj == null) {
                    String str = "Element at index " + (interfaceC4387Ex3.size() - size) + " is null.";
                    for (int size2 = interfaceC4387Ex3.size() - 1; size2 >= size; size2--) {
                        interfaceC4387Ex3.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC1937f) {
                    interfaceC4387Ex3.h1((AbstractC1937f) obj);
                } else {
                    interfaceC4387Ex3.add((String) obj);
                }
            }
        }

        private static void d(Iterable iterable, List list) {
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

        protected static UninitializedMessageException h(I i) {
            return new UninitializedMessageException(i);
        }

        protected abstract AbstractC0080a e(AbstractC1932a abstractC1932a);

        @Override // androidx.datastore.preferences.protobuf.I.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public AbstractC0080a P(I i) {
            if (getDefaultInstanceForType().getClass().isInstance(i)) {
                return e((AbstractC1932a) i);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    protected static void a(Iterable iterable, List list) {
        AbstractC0080a.c(iterable, list);
    }

    abstract int c();

    int d(V v) {
        int iC = c();
        if (iC != -1) {
            return iC;
        }
        int iG = v.g(this);
        f(iG);
        return iG;
    }

    UninitializedMessageException e() {
        return new UninitializedMessageException(this);
    }

    abstract void f(int i);

    public void g(OutputStream outputStream) {
        CodedOutputStream codedOutputStreamZ = CodedOutputStream.Z(outputStream, CodedOutputStream.C(getSerializedSize()));
        b(codedOutputStreamZ);
        codedOutputStreamZ.W();
    }
}
