package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* renamed from: ir.nasim.pl3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19087pl3 {
    private final Z0 a;
    private final boolean b;
    private final boolean c;
    private int d;

    /* renamed from: ir.nasim.pl3$a */
    static final class a extends V06 implements InterfaceC15796kB2 {
        int a;
        private /* synthetic */ Object b;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.a;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                SB1 sb1 = (SB1) this.b;
                byte bF = C19087pl3.this.a.F();
                if (bF == 1) {
                    return C19087pl3.this.j(true);
                }
                if (bF == 0) {
                    return C19087pl3.this.j(false);
                }
                if (bF != 6) {
                    if (bF == 8) {
                        return C19087pl3.this.f();
                    }
                    Z0.x(C19087pl3.this.a, "Can't begin reading element, unexpected token", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                C19087pl3 c19087pl3 = C19087pl3.this;
                this.a = 1;
                obj = c19087pl3.h(sb1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return (JsonElement) obj;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object q(SB1 sb1, C19938rB7 c19938rB7, InterfaceC20295rm1 interfaceC20295rm1) {
            a aVar = C19087pl3.this.new a(interfaceC20295rm1);
            aVar.b = sb1;
            return aVar.invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.pl3$b */
    static final class b extends AbstractC22163um1 {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= RecyclerView.UNDEFINED_DURATION;
            return C19087pl3.this.h(null, this);
        }
    }

    public C19087pl3(C15531jk3 c15531jk3, Z0 z0) {
        AbstractC13042fc3.i(c15531jk3, "configuration");
        AbstractC13042fc3.i(z0, "lexer");
        this.a = z0;
        this.b = c15531jk3.p();
        this.c = c15531jk3.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonElement f() {
        byte bJ = this.a.j();
        if (this.a.F() == 4) {
            Z0.x(this.a, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.a.e()) {
            arrayList.add(e());
            bJ = this.a.j();
            if (bJ != 4) {
                Z0 z0 = this.a;
                boolean z = bJ == 9;
                int i = z0.a;
                if (!z) {
                    Z0.x(z0, "Expected end of the array or comma", i, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bJ == 8) {
            this.a.k((byte) 9);
        } else if (bJ == 4) {
            if (!this.c) {
                AbstractC3802Ck3.g(this.a, "array");
                throw new KotlinNothingValueException();
            }
            this.a.k((byte) 9);
        }
        return new JsonArray(arrayList);
    }

    private final JsonElement g() {
        return (JsonElement) RB1.b(new QB1(new a(null)), C19938rB7.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0096 -> B:27:0x00a0). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(ir.nasim.SB1 r21, ir.nasim.InterfaceC20295rm1 r22) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C19087pl3.h(ir.nasim.SB1, ir.nasim.rm1):java.lang.Object");
    }

    private final JsonElement i() {
        byte bK = this.a.k((byte) 6);
        if (this.a.F() == 4) {
            Z0.x(this.a, "Unexpected leading comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.a.e()) {
                break;
            }
            String strQ = this.b ? this.a.q() : this.a.o();
            this.a.k((byte) 5);
            linkedHashMap.put(strQ, e());
            bK = this.a.j();
            if (bK != 4) {
                if (bK != 7) {
                    Z0.x(this.a, "Expected end of the object or comma", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (bK == 6) {
            this.a.k((byte) 7);
        } else if (bK == 4) {
            if (!this.c) {
                AbstractC3802Ck3.h(this.a, null, 1, null);
                throw new KotlinNothingValueException();
            }
            this.a.k((byte) 7);
        }
        return new JsonObject(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JsonPrimitive j(boolean z) {
        String strQ = (this.b || !z) ? this.a.q() : this.a.o();
        return (z || !AbstractC13042fc3.d(strQ, "null")) ? new C5221Ik3(strQ, z, null, 4, null) : JsonNull.INSTANCE;
    }

    public final JsonElement e() {
        byte bF = this.a.F();
        if (bF == 1) {
            return j(true);
        }
        if (bF == 0) {
            return j(false);
        }
        if (bF == 6) {
            int i = this.d + 1;
            this.d = i;
            this.d--;
            return i == 200 ? g() : i();
        }
        if (bF == 8) {
            return f();
        }
        Z0.x(this.a, "Cannot read Json element because of unexpected " + AbstractC9468a1.c(bF), 0, null, 6, null);
        throw new KotlinNothingValueException();
    }
}
