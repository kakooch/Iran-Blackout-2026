package ir.nasim.database.dailogLists;

import android.database.Cursor;
import android.gov.nist.core.Separators;
import ir.nasim.AbstractC10360bX0;
import ir.nasim.AbstractC10685c16;
import ir.nasim.AbstractC11429cz6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC14862ic3;
import ir.nasim.AbstractC19859r37;
import ir.nasim.AbstractC19914r92;
import ir.nasim.AbstractC21126t92;
import ir.nasim.AbstractC5795Kw1;
import ir.nasim.AbstractC7716Sx1;
import ir.nasim.C19938rB7;
import ir.nasim.C21800u92;
import ir.nasim.C7681St2;
import ir.nasim.C8613Ws2;
import ir.nasim.C8879Xs2;
import ir.nasim.D26;
import ir.nasim.ED1;
import ir.nasim.InterfaceC15121j27;
import ir.nasim.InterfaceC20295rm1;
import ir.nasim.InterfaceC4557Fq2;
import ir.nasim.O26;
import ir.nasim.UA2;
import ir.nasim.WP1;
import ir.nasim.WY6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public final class d extends c {
    public static final C11798r s = new C11798r(null);
    private final D26 b;
    private final AbstractC21126t92 c;
    private final AbstractC21126t92 d;
    private final AbstractC19914r92 e;
    private final AbstractC11429cz6 f;
    private final AbstractC11429cz6 g;
    private final AbstractC11429cz6 h;
    private final AbstractC11429cz6 i;
    private final AbstractC11429cz6 j;
    private final AbstractC11429cz6 k;
    private final AbstractC11429cz6 l;
    private final AbstractC11429cz6 m;
    private final AbstractC11429cz6 n;
    private final AbstractC11429cz6 o;
    private final AbstractC11429cz6 p;
    private final AbstractC11429cz6 q;
    private final C21800u92 r;

    static final class A extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        A(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new A(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                int i2 = this.d;
                this.b = 1;
                if (d.super.j(i2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((A) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class B implements Callable {
        final /* synthetic */ String b;
        final /* synthetic */ int c;

        B(String str, int i) {
            this.b = str;
            this.c = i;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.g.b();
            interfaceC15121j27B.U0(1, this.b);
            interfaceC15121j27B.k1(2, this.c);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.g.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    static final class C extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ List f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C(int i, String str, List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = i;
            this.e = str;
            this.f = list;
            this.g = list2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new C(this.d, this.e, this.f, this.g, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                int i2 = this.d;
                String str = this.e;
                List list = this.f;
                List list2 = this.g;
                this.b = 1;
                if (d.super.m(i2, str, list, list2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class D implements Callable {
        final /* synthetic */ O26 b;

        D(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "name");
                int iE3 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_INDEX);
                int iE4 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_LOADED_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_END_OF_PAGINATION_REACHED);
                int iE6 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_PINNED_ITEM_LOADED);
                int iE7 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_IS_ACTIVE);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new DialogFolderEntity(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4)), cursorC.getInt(iE5) != 0, cursorC.getInt(iE6) != 0, cursorC.getInt(iE7) != 0));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class E implements Callable {
        final /* synthetic */ O26 b;

        E(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "name");
                int iE3 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_INDEX);
                int iE4 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_LOADED_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_END_OF_PAGINATION_REACHED);
                int iE6 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_PINNED_ITEM_LOADED);
                int iE7 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_IS_ACTIVE);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new DialogFolderEntity(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4)), cursorC.getInt(iE5) != 0, cursorC.getInt(iE6) != 0, cursorC.getInt(iE7) != 0));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class F implements Callable {
        final /* synthetic */ O26 b;

        F(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new WP1(cursorC.getLong(0), cursorC.isNull(1) ? null : cursorC.getString(1)));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class G implements Callable {
        final /* synthetic */ O26 b;

        G(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(cursorC.getString(0));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class H implements Callable {
        final /* synthetic */ O26 b;

        H(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(Long.valueOf(cursorC.getLong(0)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class I implements Callable {
        final /* synthetic */ O26 b;

        I(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DialogFolderEntity call() {
            DialogFolderEntity dialogFolderEntity = null;
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "name");
                int iE3 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_INDEX);
                int iE4 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_LOADED_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_END_OF_PAGINATION_REACHED);
                int iE6 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_PINNED_ITEM_LOADED);
                int iE7 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_IS_ACTIVE);
                if (cursorC.moveToFirst()) {
                    dialogFolderEntity = new DialogFolderEntity(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4)), cursorC.getInt(iE5) != 0, cursorC.getInt(iE6) != 0, cursorC.getInt(iE7) != 0);
                }
                return dialogFolderEntity;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class J implements Callable {
        final /* synthetic */ O26 b;

        J(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(Integer.valueOf(cursorC.getInt(0)));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class K implements Callable {
        final /* synthetic */ O26 b;

        K(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                if (cursorC.moveToFirst()) {
                    return cursorC.getString(0);
                }
                throw new IllegalStateException("The query result was empty, but expected a single row to return a NON-NULL object of type <kotlin.String>.".toString());
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class L implements Callable {
        final /* synthetic */ O26 b;

        L(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, DialogFolderAssociationEntity.COLUMN_FOLDER_ID);
                int iE2 = AbstractC5795Kw1.e(cursorC, "unreadPeerCount");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C8879Xs2(cursorC.getInt(iE), cursorC.getInt(iE2)));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class M implements Callable {
        final /* synthetic */ O26 b;

        M(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, DialogFolderAssociationEntity.COLUMN_FOLDER_ID);
                int iE2 = AbstractC5795Kw1.e(cursorC, "unreadPeerCount");
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new C8613Ws2(cursorC.getInt(iE), cursorC.getInt(iE2)));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class N implements Callable {
        final /* synthetic */ O26 b;

        N(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                int iE = AbstractC5795Kw1.e(cursorC, "id");
                int iE2 = AbstractC5795Kw1.e(cursorC, "name");
                int iE3 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_INDEX);
                int iE4 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_LOADED_DATE);
                int iE5 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_END_OF_PAGINATION_REACHED);
                int iE6 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_HAS_PINNED_ITEM_LOADED);
                int iE7 = AbstractC5795Kw1.e(cursorC, DialogFolderEntity.COLUMN_IS_ACTIVE);
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new DialogFolderEntity(cursorC.getInt(iE), cursorC.getString(iE2), cursorC.getInt(iE3), cursorC.isNull(iE4) ? null : Long.valueOf(cursorC.getLong(iE4)), cursorC.getInt(iE5) != 0, cursorC.getInt(iE6) != 0, cursorC.getInt(iE7) != 0));
                }
                return arrayList;
            } finally {
                cursorC.close();
                this.b.j();
            }
        }
    }

    public static final class O implements Callable {
        final /* synthetic */ O26 b;

        O(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(new SortedDialogEntry(cursorC.getLong(0), cursorC.getInt(2) != 0));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class P implements Callable {
        final /* synthetic */ O26 b;

        P(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    long j = cursorC.getLong(0);
                    boolean z = true;
                    if (cursorC.getInt(1) == 0) {
                        z = false;
                    }
                    arrayList.add(new SortedDialogEntry(j, z));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class Q implements Callable {
        final /* synthetic */ O26 b;

        Q(O26 o26) {
            this.b = o26;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Boolean boolValueOf;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            int i = 0;
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    long j = cursorC.getLong(i);
                    boolean z = true;
                    long j2 = cursorC.getLong(1);
                    String string = cursorC.getString(2);
                    long j3 = cursorC.getLong(3);
                    int i2 = cursorC.getInt(4);
                    boolean z2 = cursorC.getInt(5) != 0 ? 1 : i;
                    String string2 = cursorC.isNull(6) ? null : cursorC.getString(6);
                    Long lValueOf = cursorC.isNull(7) ? null : Long.valueOf(cursorC.getLong(7));
                    boolean z3 = cursorC.getInt(8) != 0 ? 1 : i;
                    String string3 = cursorC.getString(9);
                    String string4 = cursorC.isNull(10) ? null : cursorC.getString(10);
                    String string5 = cursorC.isNull(11) ? null : cursorC.getString(11);
                    f fVar = f.a;
                    DialogLastMessage dialogLastMessageC = fVar.c(string5);
                    Integer numValueOf = cursorC.isNull(12) ? null : Integer.valueOf(cursorC.getInt(12));
                    if (numValueOf != null) {
                        boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                    } else {
                        boolValueOf = null;
                    }
                    Long lValueOf2 = cursorC.isNull(13) ? null : Long.valueOf(cursorC.getLong(13));
                    List listE = fVar.e(cursorC.isNull(14) ? null : cursorC.getString(14));
                    List listE2 = fVar.e(cursorC.isNull(15) ? null : cursorC.getString(15));
                    boolean z4 = cursorC.getInt(16) != 0;
                    boolean z5 = cursorC.getInt(17) != 0;
                    Integer numValueOf2 = cursorC.isNull(18) ? null : Integer.valueOf(cursorC.getInt(18));
                    if (numValueOf2 != null) {
                        boolValueOf2 = Boolean.valueOf(numValueOf2.intValue() != 0);
                    } else {
                        boolValueOf2 = null;
                    }
                    boolean z6 = cursorC.getInt(19) != 0;
                    Integer numValueOf3 = cursorC.isNull(20) ? null : Integer.valueOf(cursorC.getInt(20));
                    if (numValueOf3 != null) {
                        if (numValueOf3.intValue() == 0) {
                            z = false;
                        }
                        boolValueOf3 = Boolean.valueOf(z);
                    } else {
                        boolValueOf3 = null;
                    }
                    arrayList.add(new DialogEntity(j, j2, string, j3, i2, z2, string2, lValueOf, z3, string3, string4, dialogLastMessageC, boolValueOf, lValueOf2, listE, listE2, z4, z5, boolValueOf2, z6, boolValueOf3));
                    i = 0;
                }
                cursorC.close();
                this.b.j();
                return arrayList;
            } catch (Throwable th) {
                cursorC.close();
                this.b.j();
                throw th;
            }
        }
    }

    public static final class R implements Callable {
        final /* synthetic */ O26 b;

        R(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    arrayList.add(Long.valueOf(cursorC.getLong(0)));
                }
                return arrayList;
            } finally {
                cursorC.close();
            }
        }

        protected final void finalize() {
            this.b.j();
        }
    }

    public static final class S implements Callable {
        final /* synthetic */ O26 b;

        S(O26 o26) {
            this.b = o26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() throws Throwable {
            S s;
            int iE;
            int iE2;
            int iE3;
            int iE4;
            int iE5;
            int iE6;
            int iE7;
            int iE8;
            int iE9;
            int iE10;
            int iE11;
            int iE12;
            int iE13;
            int iE14;
            String string;
            int i;
            int i2;
            Boolean boolValueOf;
            int i3;
            String string2;
            int i4;
            String string3;
            int i5;
            boolean z;
            int i6;
            Boolean boolValueOf2;
            Boolean boolValueOf3;
            Cursor cursorC = AbstractC7716Sx1.c(d.this.b, this.b, false, null);
            try {
                iE = AbstractC5795Kw1.e(cursorC, "peerUid");
                iE2 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_RID);
                iE3 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DIALOG_TITLE);
                iE4 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_SORT_DATE);
                iE5 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_UNREAD_COUNT);
                iE6 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_DELETED_ACCOUNT);
                iE7 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DRAFT);
                iE8 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DRAFT_DATE);
                iE9 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_GROUP_CALL_RUNNING);
                iE10 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_EX_PEER_TYPE);
                iE11 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_PUPPET_TYPE);
                iE12 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_MESSAGE);
                iE13 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_HAS_BLUE_TICK);
                iE14 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_FIRST_UNREAD_DATE);
            } catch (Throwable th) {
                th = th;
                s = this;
            }
            try {
                int iE15 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_UNREAD_MENTIONS_DATE);
                int iE16 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_UNREAD_RE_ACTION_DATE);
                int iE17 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_DELETED_LOCALLY);
                int iE18 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_FORWARDED);
                int iE19 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_MARK_AS_UNREAD);
                int iE20 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_HAS_MAIN_WEBAPP);
                int iE21 = AbstractC5795Kw1.e(cursorC, DialogEntity.COLUMN_IS_PINNED);
                int i7 = iE14;
                ArrayList arrayList = new ArrayList(cursorC.getCount());
                while (cursorC.moveToNext()) {
                    long j = cursorC.getLong(iE);
                    long j2 = cursorC.getLong(iE2);
                    String string4 = cursorC.getString(iE3);
                    long j3 = cursorC.getLong(iE4);
                    int i8 = cursorC.getInt(iE5);
                    boolean z2 = true;
                    boolean z3 = cursorC.getInt(iE6) != 0;
                    String string5 = cursorC.isNull(iE7) ? null : cursorC.getString(iE7);
                    Long lValueOf = cursorC.isNull(iE8) ? null : Long.valueOf(cursorC.getLong(iE8));
                    boolean z4 = cursorC.getInt(iE9) != 0;
                    String string6 = cursorC.getString(iE10);
                    String string7 = cursorC.isNull(iE11) ? null : cursorC.getString(iE11);
                    if (cursorC.isNull(iE12)) {
                        i = iE;
                        string = null;
                    } else {
                        string = cursorC.getString(iE12);
                        i = iE;
                    }
                    f fVar = f.a;
                    DialogLastMessage dialogLastMessageC = fVar.c(string);
                    Integer numValueOf = cursorC.isNull(iE13) ? null : Integer.valueOf(cursorC.getInt(iE13));
                    if (numValueOf != null) {
                        boolValueOf = Boolean.valueOf(numValueOf.intValue() != 0);
                        i2 = i7;
                    } else {
                        i2 = i7;
                        boolValueOf = null;
                    }
                    Long lValueOf2 = cursorC.isNull(i2) ? null : Long.valueOf(cursorC.getLong(i2));
                    int i9 = iE15;
                    int i10 = iE13;
                    if (cursorC.isNull(i9)) {
                        i3 = i9;
                        string2 = null;
                    } else {
                        i3 = i9;
                        string2 = cursorC.getString(i9);
                    }
                    List listE = fVar.e(string2);
                    int i11 = iE16;
                    if (cursorC.isNull(i11)) {
                        i4 = i11;
                        string3 = null;
                    } else {
                        i4 = i11;
                        string3 = cursorC.getString(i11);
                    }
                    List listE2 = fVar.e(string3);
                    int i12 = iE17;
                    if (cursorC.getInt(i12) != 0) {
                        i5 = iE18;
                        z = true;
                    } else {
                        i5 = iE18;
                        z = false;
                    }
                    iE17 = i12;
                    int i13 = iE19;
                    boolean z5 = cursorC.getInt(i5) != 0;
                    Integer numValueOf2 = cursorC.isNull(i13) ? null : Integer.valueOf(cursorC.getInt(i13));
                    if (numValueOf2 != null) {
                        iE19 = i13;
                        boolValueOf2 = Boolean.valueOf(numValueOf2.intValue() != 0);
                        i6 = iE20;
                    } else {
                        iE19 = i13;
                        i6 = iE20;
                        boolValueOf2 = null;
                    }
                    int i14 = cursorC.getInt(i6);
                    iE20 = i6;
                    int i15 = iE21;
                    boolean z6 = i14 != 0;
                    Integer numValueOf3 = cursorC.isNull(i15) ? null : Integer.valueOf(cursorC.getInt(i15));
                    if (numValueOf3 != null) {
                        if (numValueOf3.intValue() == 0) {
                            z2 = false;
                        }
                        iE21 = i15;
                        boolValueOf3 = Boolean.valueOf(z2);
                    } else {
                        iE21 = i15;
                        boolValueOf3 = null;
                    }
                    arrayList.add(new DialogEntity(j, j2, string4, j3, i8, z3, string5, lValueOf, z4, string6, string7, dialogLastMessageC, boolValueOf, lValueOf2, listE, listE2, z, z5, boolValueOf2, z6, boolValueOf3));
                    iE18 = i5;
                    iE13 = i10;
                    iE16 = i4;
                    iE = i;
                    iE15 = i3;
                    i7 = i2;
                }
                cursorC.close();
                this.b.j();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                s = this;
                cursorC.close();
                s.b.j();
                throw th;
            }
        }
    }

    public static final class T implements Callable {
        final /* synthetic */ List b;

        T(List list) {
            this.b = list;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List call() {
            d.this.b.e();
            try {
                List listM = d.this.c.m(this.b);
                d.this.b.F();
                return listM;
            } finally {
                d.this.b.j();
            }
        }
    }

    static final class U extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ C7681St2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        U(C7681St2 c7681St2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = c7681St2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new U(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                C7681St2 c7681St2 = this.d;
                this.b = 1;
                if (d.super.K(c7681St2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((U) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class V extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        V(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new V(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                List list = this.d;
                this.b = 1;
                if (d.super.N(list, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((V) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class W implements Callable {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        W(int i, int i2) {
            this.b = i;
            this.c = i2;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.i.b();
            interfaceC15121j27B.k1(1, this.b);
            interfaceC15121j27B.k1(2, this.c);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.i.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    static final class X extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ DialogFolderEntity d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        X(DialogFolderEntity dialogFolderEntity, List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = dialogFolderEntity;
            this.e = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new X(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                DialogFolderEntity dialogFolderEntity = this.d;
                List list = this.e;
                this.b = 1;
                if (d.super.Q(dialogFolderEntity, list, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((X) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class Y extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ C7681St2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Y(C7681St2 c7681St2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = c7681St2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new Y(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                C7681St2 c7681St2 = this.d;
                this.b = 1;
                if (d.super.P(c7681St2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Y) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    static final class Z extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        Z(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new Z(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                int i2 = this.d;
                int i3 = this.e;
                this.b = 1;
                if (d.super.T(i2, i3, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((Z) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$a, reason: case insensitive filesystem */
    public static final class C11782a extends AbstractC11429cz6 {
        C11782a(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialog_folder_associations WHERE folderId = ?";
        }
    }

    static final class a0 extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ long e;
        final /* synthetic */ boolean f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a0(int i, long j, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = i;
            this.e = j;
            this.f = z;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new a0(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                int i2 = this.d;
                long j = this.e;
                boolean z = this.f;
                this.b = 1;
                if (d.super.V(i2, j, z, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a0) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$b, reason: case insensitive filesystem */
    public static final class C11783b extends AbstractC11429cz6 {
        C11783b(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialog_folder_associations WHERE peerUid = ?";
        }
    }

    public static final class b0 implements Callable {
        final /* synthetic */ int b;

        b0(int i) {
            this.b = i;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.q.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.q.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$c, reason: case insensitive filesystem */
    public static final class C11784c extends AbstractC11429cz6 {
        C11784c(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialog_folders;";
        }
    }

    public static final class c0 implements Callable {
        final /* synthetic */ List a;
        final /* synthetic */ d b;
        final /* synthetic */ int c;

        c0(List list, d dVar, int i) {
            this.a = list;
            this.b = dVar;
            this.c = i;
        }

        public void a() {
            StringBuilder sbB = WY6.b();
            sbB.append("UPDATE dialog_folder_associations SET pinnedIndex = null WHERE peerUid IN (");
            int size = this.a.size();
            WY6.a(sbB, size);
            sbB.append(") AND folderId = ");
            sbB.append(Separators.QUESTION);
            String string = sbB.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            InterfaceC15121j27 interfaceC15121j27G = this.b.b.g(string);
            Iterator it = this.a.iterator();
            int i = 1;
            while (it.hasNext()) {
                interfaceC15121j27G.k1(i, ((Number) it.next()).longValue());
                i++;
            }
            interfaceC15121j27G.k1(size + 1, this.c);
            this.b.b.e();
            try {
                interfaceC15121j27G.V();
                this.b.b.F();
            } finally {
                this.b.b.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$d, reason: collision with other inner class name */
    public static final class C1015d extends AbstractC11429cz6 {
        C1015d(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialog_folder_associations;";
        }
    }

    public static final class d0 implements Callable {
        final /* synthetic */ String b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ int e;

        d0(String str, int i, boolean z, int i2) {
            this.b = str;
            this.c = i;
            this.d = z;
            this.e = i2;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.f.b();
            interfaceC15121j27B.U0(1, this.b);
            interfaceC15121j27B.k1(2, this.c);
            interfaceC15121j27B.k1(3, this.d ? 1L : 0L);
            interfaceC15121j27B.k1(4, this.e);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.f.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$e, reason: case insensitive filesystem */
    public static final class C11785e extends AbstractC11429cz6 {
        C11785e(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialog_folders SET lastLoadedDate = ?, hasEndOfPaginationReached = ? WHERE id = ?";
        }
    }

    public static final class e0 implements Callable {
        final /* synthetic */ long b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;

        e0(long j, boolean z, int i) {
            this.b = j;
            this.c = z;
            this.d = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.p.b();
            interfaceC15121j27B.k1(1, this.b);
            interfaceC15121j27B.k1(2, this.c ? 1L : 0L);
            interfaceC15121j27B.k1(3, this.d);
            try {
                d.this.b.e();
                try {
                    int iV = interfaceC15121j27B.V();
                    d.this.b.F();
                    return Integer.valueOf(iV);
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.p.h(interfaceC15121j27B);
            }
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$f, reason: case insensitive filesystem */
    public static final class C11786f extends AbstractC11429cz6 {
        C11786f(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialog_folders set hasPinnedItemLoaded=1 WHERE id =?";
        }
    }

    public static final class f0 implements Callable {
        final /* synthetic */ boolean b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        f0(boolean z, int i, int i2) {
            this.b = z;
            this.c = i;
            this.d = i2;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.h.b();
            interfaceC15121j27B.k1(1, this.b ? 1L : 0L);
            interfaceC15121j27B.k1(2, this.c);
            interfaceC15121j27B.k1(3, this.d);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.h.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$g, reason: case insensitive filesystem */
    public static final class C11787g extends AbstractC21126t92 {
        C11787g(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT INTO `dialog_folder_associations` (`peerUid`,`folderId`,`pinnedIndex`) VALUES (?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogFolderAssociationEntity dialogFolderAssociationEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogFolderAssociationEntity, "entity");
            interfaceC15121j27.k1(1, dialogFolderAssociationEntity.getPeerUid());
            interfaceC15121j27.k1(2, dialogFolderAssociationEntity.getFolderId());
            if (dialogFolderAssociationEntity.getPinnedIndex() == null) {
                interfaceC15121j27.y1(3);
            } else {
                interfaceC15121j27.k1(3, r5.intValue());
            }
        }
    }

    static final class g0 extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ List d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g0(List list, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = list;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new g0(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                List list = this.d;
                this.b = 1;
                if (d.super.d0(list, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((g0) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$h, reason: case insensitive filesystem */
    public static final class C11788h extends AbstractC19914r92 {
        C11788h(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "UPDATE `dialog_folder_associations` SET `peerUid` = ?,`folderId` = ?,`pinnedIndex` = ? WHERE `peerUid` = ? AND `folderId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogFolderAssociationEntity dialogFolderAssociationEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogFolderAssociationEntity, "entity");
            interfaceC15121j27.k1(1, dialogFolderAssociationEntity.getPeerUid());
            interfaceC15121j27.k1(2, dialogFolderAssociationEntity.getFolderId());
            if (dialogFolderAssociationEntity.getPinnedIndex() == null) {
                interfaceC15121j27.y1(3);
            } else {
                interfaceC15121j27.k1(3, r0.intValue());
            }
            interfaceC15121j27.k1(4, dialogFolderAssociationEntity.getPeerUid());
            interfaceC15121j27.k1(5, dialogFolderAssociationEntity.getFolderId());
        }
    }

    public static final class h0 implements Callable {
        final /* synthetic */ List b;

        h0(List list) {
            this.b = list;
        }

        public void a() {
            d.this.b.e();
            try {
                d.this.r.b(this.b);
                d.this.b.F();
            } finally {
                d.this.b.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$i, reason: case insensitive filesystem */
    public static final class C11789i extends AbstractC21126t92 {
        C11789i(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR IGNORE INTO `dialog_folders` (`id`,`name`,`sortIndex`,`lastLoadedDate`,`hasEndOfPaginationReached`,`hasPinnedItemLoaded`,`isActive`) VALUES (?,?,?,?,?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogFolderEntity dialogFolderEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogFolderEntity, "entity");
            interfaceC15121j27.k1(1, dialogFolderEntity.getId());
            interfaceC15121j27.U0(2, dialogFolderEntity.getName());
            interfaceC15121j27.k1(3, dialogFolderEntity.getSortIndex());
            Long lastLoadedDate = dialogFolderEntity.getLastLoadedDate();
            if (lastLoadedDate == null) {
                interfaceC15121j27.y1(4);
            } else {
                interfaceC15121j27.k1(4, lastLoadedDate.longValue());
            }
            interfaceC15121j27.k1(5, dialogFolderEntity.getHasEndOfPaginationReached() ? 1L : 0L);
            interfaceC15121j27.k1(6, dialogFolderEntity.getHasPinnedItemLoaded() ? 1L : 0L);
            interfaceC15121j27.k1(7, dialogFolderEntity.isActive() ? 1L : 0L);
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$j, reason: case insensitive filesystem */
    public static final class C11790j extends AbstractC21126t92 {
        C11790j(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "INSERT OR IGNORE INTO `dialog_folder_associations` (`peerUid`,`folderId`,`pinnedIndex`) VALUES (?,?,?)";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC21126t92
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogFolderAssociationEntity dialogFolderAssociationEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogFolderAssociationEntity, "entity");
            interfaceC15121j27.k1(1, dialogFolderAssociationEntity.getPeerUid());
            interfaceC15121j27.k1(2, dialogFolderAssociationEntity.getFolderId());
            if (dialogFolderAssociationEntity.getPinnedIndex() == null) {
                interfaceC15121j27.y1(3);
            } else {
                interfaceC15121j27.k1(3, r5.intValue());
            }
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$k, reason: case insensitive filesystem */
    public static final class C11791k extends AbstractC19914r92 {
        C11791k(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        protected String e() {
            return "DELETE FROM `dialog_folder_associations` WHERE `peerUid` = ? AND `folderId` = ?";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.AbstractC19914r92
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void i(InterfaceC15121j27 interfaceC15121j27, DialogFolderAssociationEntity dialogFolderAssociationEntity) {
            AbstractC13042fc3.i(interfaceC15121j27, "statement");
            AbstractC13042fc3.i(dialogFolderAssociationEntity, "entity");
            interfaceC15121j27.k1(1, dialogFolderAssociationEntity.getPeerUid());
            interfaceC15121j27.k1(2, dialogFolderAssociationEntity.getFolderId());
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$l, reason: case insensitive filesystem */
    public static final class C11792l extends AbstractC11429cz6 {
        C11792l(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialog_folders SET name = ?, sortIndex = ?, isActive = ? WHERE id = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$m, reason: case insensitive filesystem */
    public static final class C11793m extends AbstractC11429cz6 {
        C11793m(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialog_folders SET name = ? WHERE id = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$n, reason: case insensitive filesystem */
    public static final class C11794n extends AbstractC11429cz6 {
        C11794n(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialog_folders SET isActive = ? , sortIndex = ? WHERE id = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$o, reason: case insensitive filesystem */
    public static final class C11795o extends AbstractC11429cz6 {
        C11795o(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "UPDATE dialog_folders SET sortIndex = ? WHERE id = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$p, reason: case insensitive filesystem */
    public static final class C11796p extends AbstractC11429cz6 {
        C11796p(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialog_folders WHERE id = ?";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$q, reason: case insensitive filesystem */
    public static final class C11797q extends AbstractC11429cz6 {
        C11797q(D26 d26) {
            super(d26);
        }

        @Override // ir.nasim.AbstractC11429cz6
        public String e() {
            return "DELETE FROM dialog_folders";
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$r, reason: case insensitive filesystem */
    public static final class C11798r {
        private C11798r() {
        }

        public final List a() {
            return AbstractC10360bX0.m();
        }

        public /* synthetic */ C11798r(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$s, reason: case insensitive filesystem */
    public static final class CallableC11799s implements Callable {
        final /* synthetic */ List b;

        CallableC11799s(List list) {
            this.b = list;
        }

        public void a() {
            d.this.b.e();
            try {
                d.this.d.j(this.b);
                d.this.b.F();
            } finally {
                d.this.b.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$t, reason: case insensitive filesystem */
    public static final class CallableC11800t implements Callable {
        CallableC11800t() {
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.o.b();
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.o.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$u, reason: case insensitive filesystem */
    public static final class CallableC11801u implements Callable {
        final /* synthetic */ long b;

        CallableC11801u(long j) {
            this.b = j;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.m.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.m.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$v, reason: case insensitive filesystem */
    public static final class CallableC11802v implements Callable {
        final /* synthetic */ int b;

        CallableC11802v(int i) {
            this.b = i;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.l.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.l.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$w, reason: case insensitive filesystem */
    public static final class CallableC11803w implements Callable {
        final /* synthetic */ int b;

        CallableC11803w(int i) {
            this.b = i;
        }

        public void a() {
            InterfaceC15121j27 interfaceC15121j27B = d.this.j.b();
            interfaceC15121j27B.k1(1, this.b);
            try {
                d.this.b.e();
                try {
                    interfaceC15121j27B.V();
                    d.this.b.F();
                } finally {
                    d.this.b.j();
                }
            } finally {
                d.this.j.h(interfaceC15121j27B);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$x, reason: case insensitive filesystem */
    public static final class CallableC11804x implements Callable {
        final /* synthetic */ List b;

        CallableC11804x(List list) {
            this.b = list;
        }

        public void a() {
            d.this.b.e();
            try {
                d.this.e.k(this.b);
                d.this.b.F();
            } finally {
                d.this.b.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$y, reason: case insensitive filesystem */
    static final class C11805y extends AbstractC19859r37 implements UA2 {
        int b;
        final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11805y(int i, InterfaceC20295rm1 interfaceC20295rm1) {
            super(1, interfaceC20295rm1);
            this.d = i;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(InterfaceC20295rm1 interfaceC20295rm1) {
            return d.this.new C11805y(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                d dVar = d.this;
                int i2 = this.d;
                this.b = 1;
                if (d.super.g(i2, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.UA2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20295rm1 interfaceC20295rm1) {
            return ((C11805y) create(interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.database.dailogLists.d$z, reason: case insensitive filesystem */
    public static final class CallableC11806z implements Callable {
        final /* synthetic */ List a;
        final /* synthetic */ d b;

        CallableC11806z(List list, d dVar) {
            this.a = list;
            this.b = dVar;
        }

        public void a() {
            StringBuilder sbB = WY6.b();
            sbB.append("DELETE FROM dialog_folders WHERE id NOT IN (");
            WY6.a(sbB, this.a.size());
            sbB.append(Separators.RPAREN);
            String string = sbB.toString();
            AbstractC13042fc3.h(string, "toString(...)");
            InterfaceC15121j27 interfaceC15121j27G = this.b.b.g(string);
            Iterator it = this.a.iterator();
            int i = 1;
            while (it.hasNext()) {
                interfaceC15121j27G.k1(i, ((Number) it.next()).intValue());
                i++;
            }
            this.b.b.e();
            try {
                interfaceC15121j27G.V();
                this.b.b.F();
            } finally {
                this.b.b.j();
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            a();
            return C19938rB7.a;
        }
    }

    public d(D26 d26) {
        AbstractC13042fc3.i(d26, "__db");
        this.b = d26;
        this.c = new C11789i(d26);
        this.d = new C11790j(d26);
        this.e = new C11791k(d26);
        this.f = new C11792l(d26);
        this.g = new C11793m(d26);
        this.h = new C11794n(d26);
        this.i = new C11795o(d26);
        this.j = new C11796p(d26);
        this.k = new C11797q(d26);
        this.l = new C11782a(d26);
        this.m = new C11783b(d26);
        this.n = new C11784c(d26);
        this.o = new C1015d(d26);
        this.p = new C11785e(d26);
        this.q = new C11786f(d26);
        this.r = new C21800u92(new C11787g(d26), new C11788h(d26));
    }

    @Override // ir.nasim.database.dailogLists.c
    public InterfaceC4557Fq2 A() {
        return androidx.room.a.a.a(this.b, false, new String[]{"folder_unread_peer_count_view"}, new M(O26.i.a("SELECT * FROM folder_unread_peer_count_view", 0)));
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object B(InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("\n        SELECT dialog_folders.*\n        FROM dialog_folders where isActive = 0 AND 11\n        ORDER BY dialog_folders.sortIndex  \n        ", 0);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new N(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    protected InterfaceC4557Fq2 E(int i, boolean z) {
        O26 o26A = O26.i.a("\n        WITH folder_bound AS (\n            SELECT\n              id AS folderId,\n              CASE\n                WHEN hasEndOfPaginationReached THEN 0\n                WHEN lastLoadedDate IS NULL THEN 9223372036854775807\n                ELSE lastLoadedDate\n              END AS minDate\n            FROM dialog_folders\n            WHERE id = ?\n          ),\n          dialog_candidates AS (\n            SELECT\n              d.peerUid,\n              a.pinnedIndex,\n              d.dialogTitle,\n              CASE\n                WHEN d.draft IS NOT NULL\n                 AND d.draft <> ''\n                 AND d.draftDate IS NOT NULL\n                 AND d.draftDate > d.sortDate\n                THEN d.draftDate\n                ELSE d.sortDate\n              END AS effectiveSortDate\n            FROM dialogs AS d\n            INNER JOIN dialog_folder_associations AS a\n              ON d.peerUid = a.peerUid\n             AND a.folderId = ?\n            INNER JOIN folder_bound AS fb\n              ON a.folderId = fb.folderId\n            LEFT JOIN dialog_folder_associations as archived\n                ON d.peerUid  = archived.peerUid\n                AND archived.folderId = 11\n            WHERE d.isLocallyDeleted = 0 \n              AND (effectiveSortDate >= fb.minDate OR a.pinnedIndex IS NOT NULL)\n              AND (\n                ? = 0\n                OR ? != 0\n                OR archived.peerUid IS NULL)),\n        latest_by_peer AS ( SELECT peerUid, MAX(effectiveSortDate) AS maxSortDate FROM dialog_candidates GROUP BY peerUid)\n        SELECT\n          dc.peerUid,\n          dc.dialogTitle,\n          CASE WHEN dc.pinnedIndex IS NOT NULL THEN 1 ELSE 0 END AS isPinned\n        FROM dialog_candidates AS dc\n        INNER JOIN latest_by_peer AS lbp\n          ON dc.peerUid = lbp.peerUid\n         AND dc.effectiveSortDate = lbp.maxSortDate\n        \n        ORDER BY\n          (dc.pinnedIndex IS NULL),\n          dc.pinnedIndex ASC, \n          dc.effectiveSortDate DESC\n    ", 4);
        long j = i;
        o26A.k1(1, j);
        o26A.k1(2, j);
        o26A.k1(3, z ? 1L : 0L);
        o26A.k1(4, j);
        return androidx.room.a.a.a(this.b, false, new String[]{DialogFolderEntity.TABLE_NAME, DialogEntity.TABLE_NAME, DialogFolderAssociationEntity.TABLE_NAME}, new O(o26A));
    }

    @Override // ir.nasim.database.dailogLists.c
    protected InterfaceC4557Fq2 F(boolean z) {
        O26 o26A = O26.i.a("\n            SELECT d.peerUid as peerUid, 0 AS isPinned\n            FROM dialogs AS d\n            INNER JOIN dialog_peer_unread_state AS s\n              ON d.peerUid = s.peerUid\n            WHERE d.isLocallyDeleted = 0\n              AND (? = 1 OR IFNULL(s.isMute, 0) = 0)\n            ORDER BY\n              CASE\n                WHEN d.draft IS NOT NULL\n                 AND d.draft != ''\n                 AND d.draftDate IS NOT NULL\n                 AND d.draftDate > d.sortDate\n                THEN d.draftDate\n                ELSE d.sortDate\n              END DESC\n        ", 1);
        o26A.k1(1, z ? 1L : 0L);
        return androidx.room.a.a.a(this.b, false, new String[]{DialogEntity.TABLE_NAME, DialogPeerUnreadStateEntity.TABLE_NAME}, new P(o26A));
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object G(int i, int i2, int i3, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("\n        WITH folder_bound AS (\n            SELECT\n              id AS folderId,\n              CASE\n                WHEN hasEndOfPaginationReached THEN 0\n                WHEN lastLoadedDate IS NULL THEN 9223372036854775807\n                ELSE lastLoadedDate\n              END AS minDate\n            FROM dialog_folders\n            WHERE id = ?\n          ),\n          dialog_candidates AS (\n            SELECT\n              d.peerUid,\n              d.rid,\n              d.dialogTitle,\n              d.sortDate,\n              d.unreadCount,\n              d.isDeletedAccount,\n              d.draft,\n              d.draftDate,\n              d.isGroupCallRunning,\n              d.exPeerType,\n              d.puppetType,\n              d.message,\n              d.hasBlueTick,\n              d.firstUnreadDate,\n              d.unreadMentions,\n              d.unreadReActions,\n              d.isLocallyDeleted,\n              d.isForwarded,\n              d.markAsUnRead,\n              d.hasMainWebApp,\n              a.pinnedIndex,\n              CASE\n                WHEN d.draft IS NOT NULL\n                 AND d.draft <> ''\n                 AND d.draftDate IS NOT NULL\n                 AND d.draftDate > d.sortDate\n                THEN d.draftDate\n                ELSE d.sortDate\n              END AS effectiveSortDate\n            FROM dialogs AS d\n            INNER JOIN dialog_folder_associations AS a\n              ON d.peerUid = a.peerUid\n             AND a.folderId = ?\n            INNER JOIN folder_bound AS fb\n              ON a.folderId = fb.folderId\n                          LEFT JOIN dialog_folder_associations as archived\n                ON d.peerUid  = archived.peerUid\n                AND archived.folderId = 11\n            WHERE d.isLocallyDeleted = 0 \n              AND (effectiveSortDate >= fb.minDate OR a.pinnedIndex IS NOT NULL)\n             AND (\n                ? = 0\n                OR ? != 0 \n                OR archived.peerUid IS NULL)\n          ),\n        latest_by_peer AS ( SELECT peerUid, MAX(effectiveSortDate) AS maxSortDate FROM dialog_candidates GROUP BY peerUid)\n        SELECT\n          dc.peerUid, \n          dc.rid,\n          dc.dialogTitle,\n          dc.sortDate,\n          dc.unreadCount,\n          dc.isDeletedAccount,\n          dc.draft,\n          dc.draftDate,\n          dc.isGroupCallRunning,\n          dc.exPeerType,\n          dc.puppetType,\n          dc.message,\n          dc.hasBlueTick,\n          dc.firstUnreadDate,\n          dc.unreadMentions,\n          dc.unreadReActions,\n          dc.isLocallyDeleted,\n          dc.isForwarded,\n          dc.markAsUnRead,\n          dc.hasMainWebApp,\n          CASE WHEN dc.pinnedIndex IS NOT NULL THEN 1 ELSE 0 END AS isPinned\n        \n        FROM dialog_candidates AS dc\n        INNER JOIN latest_by_peer AS lbp\n          ON dc.peerUid = lbp.peerUid\n         AND dc.effectiveSortDate = lbp.maxSortDate\n        \n        ORDER BY\n          (dc.pinnedIndex IS NULL),\n          dc.pinnedIndex ASC, \n          dc.effectiveSortDate DESC \n        LIMIT ?\n        OFFSET ?;\n      ", 6);
        long j = i;
        o26A.k1(1, j);
        o26A.k1(2, j);
        o26A.k1(3, z ? 1L : 0L);
        o26A.k1(4, j);
        o26A.k1(5, i2);
        o26A.k1(6, i3);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new Q(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public InterfaceC4557Fq2 H(int i) {
        O26 o26A = O26.i.a("\n        SELECT dialog_folder_associations.peerUid\n        FROM dialog_folder_associations\n        WHERE dialog_folder_associations.folderId = ?\n        ", 1);
        o26A.k1(1, i);
        return androidx.room.a.a.a(this.b, false, new String[]{DialogFolderAssociationEntity.TABLE_NAME}, new R(o26A));
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object I(int i, int i2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("\n            SELECT d.*\n            FROM dialogs AS d\n            INNER JOIN dialog_peer_unread_state AS s\n              ON d.peerUid = s.peerUid\n            WHERE d.isLocallyDeleted = 0\n              AND (? = 1 OR IFNULL(s.isMute, 0) = 0) AND d.unreadCount > 0\n            ORDER BY\n              CASE\n                WHEN d.draft IS NOT NULL\n                 AND d.draft != ''\n                 AND d.draftDate IS NOT NULL\n                 AND d.draftDate > d.sortDate\n                THEN d.draftDate\n                ELSE d.sortDate\n              END DESC\n            LIMIT ?\n            OFFSET ?;\n    ", 3);
        o26A.k1(1, z ? 1L : 0L);
        o26A.k1(2, i);
        o26A.k1(3, i2);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new S(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    protected Object J(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        return androidx.room.a.a.c(this.b, true, new T(list), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object K(C7681St2 c7681St2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new U(c7681St2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object M(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new W(i2, i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object N(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new V(list, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object P(C7681St2 c7681St2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new Y(c7681St2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object Q(DialogFolderEntity dialogFolderEntity, List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new X(dialogFolderEntity, list, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object T(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new Z(i, i2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object V(int i, long j, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new a0(i, j, z, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object X(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new b0(i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object Y(List list, int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new c0(list, this, i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    protected Object Z(int i, String str, int i2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new d0(str, i2, z, i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object a(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new CallableC11799s(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    protected Object a0(int i, long j, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        return androidx.room.a.a.c(this.b, true, new e0(j, z, i), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object b(InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new CallableC11800t(), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object b0(int i, boolean z, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new f0(z, i2, i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object c(long j, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new CallableC11801u(j), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object d(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new CallableC11802v(i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object d0(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new g0(list, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object e(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new CallableC11803w(i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object f(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new CallableC11804x(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object f0(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new h0(list), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object g(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new C11805y(i, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object i(List list, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new CallableC11806z(list, this), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object j(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new A(i, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object l(int i, String str, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objC = androidx.room.a.a.c(this.b, true, new B(str, i), interfaceC20295rm1);
        return objC == AbstractC14862ic3.e() ? objC : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object m(int i, String str, List list, List list2, InterfaceC20295rm1 interfaceC20295rm1) {
        Object objD = androidx.room.f.d(this.b, new C(i, str, list, list2, null), interfaceC20295rm1);
        return objD == AbstractC14862ic3.e() ? objD : C19938rB7.a;
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object o(boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("\n        SELECT dialog_folders.* FROM dialog_folders \n        WHERE (? = 1 OR isActive = 1) AND 11\n        ORDER BY isActive ASC , sortIndex ASC\n        ", 1);
        o26A.k1(1, z ? 1L : 0L);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new D(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public InterfaceC4557Fq2 q(boolean z) {
        O26 o26A = O26.i.a("\n        SELECT dialog_folders.* FROM dialog_folders \n        WHERE (? = 1 OR isActive = 1)\n          AND id != 11\n        ORDER BY isActive ASC , sortIndex ASC\n        ", 1);
        o26A.k1(1, z ? 1L : 0L);
        return androidx.room.a.a.a(this.b, false, new String[]{DialogFolderEntity.TABLE_NAME}, new E(o26A));
    }

    @Override // ir.nasim.database.dailogLists.c
    public InterfaceC4557Fq2 r() {
        return androidx.room.a.a.a(this.b, false, new String[]{DialogFolderAssociationEntity.TABLE_NAME, DialogFolderEntity.TABLE_NAME}, new F(O26.i.a("\n        SELECT dialog_folder_associations.peerUid,\n               GROUP_CONCAT(dialog_folders.name, \". \") AS foldersList\n        FROM dialog_folder_associations\n        LEFT JOIN dialog_folders ON dialog_folders.id = dialog_folder_associations.folderId\n        WHERE dialog_folders.name <> ''\n        GROUP BY dialog_folder_associations.peerUid\n        ", 0)));
    }

    @Override // ir.nasim.database.dailogLists.c
    public InterfaceC4557Fq2 s(int i, int i2) {
        O26 o26A = O26.i.a("\n        SELECT d.dialogTitle \n        FROM dialogs d\n        INNER JOIN dialog_folder_associations dfa ON d.peerUid = dfa.peerUid\n        WHERE dfa.folderId = ?\n        ORDER BY d.sortDate DESC\n        LIMIT ?\n    ", 2);
        o26A.k1(1, i);
        o26A.k1(2, i2);
        return androidx.room.a.a.a(this.b, false, new String[]{DialogEntity.TABLE_NAME, DialogFolderAssociationEntity.TABLE_NAME}, new G(o26A));
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object t(int i, int i2, boolean z, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("\n        SELECT dialogs.peerUid\n        FROM dialogs\n        LEFT JOIN dialog_folder_associations ON dialogs.peerUid = dialog_folder_associations.peerUid\n      \n        LEFT JOIN dialog_folder_associations as archived\n            ON dialogs.peerUid  = archived.peerUid\n            AND archived.folderId = 11\n        WHERE dialog_folder_associations.folderId = ?\n         AND (\n                ? = 0\n                OR ? != 0 -- ALL_FOLDER_ID\n                OR archived.peerUid IS NULL)\n        ORDER BY\n        CASE \n            WHEN dialog_folder_associations.pinnedIndex IS NOT NULL THEN 0\n            ELSE 1 \n        END,\n        dialog_folder_associations.pinnedIndex ASC,\n        dialogs.sortDate DESC\n        LIMIT ?\n        ", 4);
        long j = i2;
        o26A.k1(1, j);
        o26A.k1(2, z ? 1L : 0L);
        o26A.k1(3, j);
        o26A.k1(4, i);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new H(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object v(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT * FROM dialog_folders WHERE id = ? ", 1);
        o26A.k1(1, i);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new I(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object w(InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT id FROM dialog_folders", 0);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new J(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public Object x(int i, InterfaceC20295rm1 interfaceC20295rm1) {
        O26 o26A = O26.i.a("SELECT name FROM dialog_folders WHERE id = ?", 1);
        o26A.k1(1, i);
        return androidx.room.a.a.b(this.b, false, AbstractC7716Sx1.a(), new K(o26A), interfaceC20295rm1);
    }

    @Override // ir.nasim.database.dailogLists.c
    public InterfaceC4557Fq2 z() {
        return androidx.room.a.a.a(this.b, false, new String[]{"folder_unread_peer_count_excluding_archived_view"}, new L(O26.i.a("SELECT * FROM folder_unread_peer_count_excluding_archived_view", 0)));
    }
}
