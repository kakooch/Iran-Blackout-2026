package ir.nasim;

import java.util.Iterator;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* renamed from: ir.nasim.mq6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC17367mq6 {

    /* renamed from: ir.nasim.mq6$a */
    public static final class a implements Iterator, InterfaceC17915nm3 {
        private int a;
        final /* synthetic */ SerialDescriptor b;

        a(SerialDescriptor serialDescriptor) {
            this.b = serialDescriptor;
            this.a = serialDescriptor.d();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SerialDescriptor next() {
            SerialDescriptor serialDescriptor = this.b;
            int iD = serialDescriptor.d();
            int i = this.a;
            this.a = i - 1;
            return serialDescriptor.h(iD - i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: ir.nasim.mq6$b */
    public static final class b implements Iterator, InterfaceC17915nm3 {
        private int a;
        final /* synthetic */ SerialDescriptor b;

        b(SerialDescriptor serialDescriptor) {
            this.b = serialDescriptor;
            this.a = serialDescriptor.d();
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            SerialDescriptor serialDescriptor = this.b;
            int iD = serialDescriptor.d();
            int i = this.a;
            this.a = i - 1;
            return serialDescriptor.e(iD - i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: ir.nasim.mq6$c */
    public static final class c implements Iterable, InterfaceC17915nm3 {
        final /* synthetic */ SerialDescriptor a;

        public c(SerialDescriptor serialDescriptor) {
            this.a = serialDescriptor;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(this.a);
        }
    }

    /* renamed from: ir.nasim.mq6$d */
    public static final class d implements Iterable, InterfaceC17915nm3 {
        final /* synthetic */ SerialDescriptor a;

        public d(SerialDescriptor serialDescriptor) {
            this.a = serialDescriptor;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new b(this.a);
        }
    }

    public static final Iterable a(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        return new c(serialDescriptor);
    }

    public static final Iterable b(SerialDescriptor serialDescriptor) {
        AbstractC13042fc3.i(serialDescriptor, "<this>");
        return new d(serialDescriptor);
    }
}
