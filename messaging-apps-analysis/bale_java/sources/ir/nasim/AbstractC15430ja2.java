package ir.nasim;

import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.ja2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC15430ja2 extends AbstractC7068Qd1 {
    public static final a b = new a(null);

    /* renamed from: ir.nasim.ja2$a */
    public static final class a {
        private a() {
        }

        public final AbstractC15430ja2 a(String str) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            return new b(str);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.ja2$b */
    public static final class b extends AbstractC15430ja2 {
        private final String c;

        public b(String str) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            this.c = str;
        }

        @Override // ir.nasim.AbstractC7068Qd1
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public XC6 a(InterfaceC8507Wg4 interfaceC8507Wg4) {
            AbstractC13042fc3.i(interfaceC8507Wg4, "module");
            XC6 xc6J = AbstractC14230ha2.j(this.c);
            AbstractC13042fc3.h(xc6J, "createErrorType(message)");
            return xc6J;
        }

        @Override // ir.nasim.AbstractC7068Qd1
        public String toString() {
            return this.c;
        }
    }

    public AbstractC15430ja2() {
        super(C19938rB7.a);
    }

    @Override // ir.nasim.AbstractC7068Qd1
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C19938rB7 b() {
        throw new UnsupportedOperationException();
    }
}
