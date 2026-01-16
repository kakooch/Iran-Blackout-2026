package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;

/* renamed from: ir.nasim.yH7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC24244yH7 {

    /* renamed from: ir.nasim.yH7$a */
    public static final class a implements InterfaceC24244yH7 {
        public static final int c = FileReference.$stable;
        private final long a;
        private final FileReference b;

        public a(long j, FileReference fileReference) {
            AbstractC13042fc3.i(fileReference, "fileReference");
            this.a = j;
            this.b = fileReference;
        }

        public final FileReference a() {
            return this.b;
        }

        public long b() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.yH7$b */
    public static final class b implements InterfaceC24244yH7 {
        private final long a;

        public b(long j) {
            this.a = j;
        }

        public long a() {
            return this.a;
        }
    }
}
