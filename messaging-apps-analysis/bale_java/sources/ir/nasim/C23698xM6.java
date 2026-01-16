package ir.nasim;

import ir.nasim.core.modules.file.entity.FileReference;
import java.util.Objects;

/* renamed from: ir.nasim.xM6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C23698xM6 extends AbstractC25020zb8 {
    public static final InterfaceC17311ml0 k = new InterfaceC17311ml0() { // from class: ir.nasim.wM6
        @Override // ir.nasim.InterfaceC17311ml0
        public final Object a() {
            return C23698xM6.q();
        }
    };
    private FileReference a;
    private C4626Fy b;
    private FileReference c;
    private C4626Fy d;
    private FileReference e;
    private C4626Fy f;
    private int g;
    private String h;
    private Integer i;
    private Long j;

    public C23698xM6(HC hc, Integer num, Long l) {
        super(10, hc);
        this.i = num;
        this.j = l;
    }

    public static /* synthetic */ C23698xM6 q() {
        return new C23698xM6();
    }

    public FileReference C() {
        return this.e;
    }

    public IC D() {
        return new IC(Integer.valueOf(this.g), null, this.f, this.d, this.i, this.j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C23698xM6 c23698xM6 = (C23698xM6) obj;
        return this.g == c23698xM6.g && this.i.equals(c23698xM6.i) && this.h.equals(c23698xM6.h);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.g), this.i);
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        super.parse(c19084pl0);
        int iX = c19084pl0.x(100);
        if (iX > 0) {
            this.i = Integer.valueOf(iX);
        }
        long jY = c19084pl0.y(101);
        if (jY > 0) {
            this.j = Long.valueOf(jY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void applyWrapped(HC hc) {
        this.h = hc.q();
        this.g = hc.r();
        this.b = hc.s();
        this.a = new FileReference(this.b.getFileLocation(), "sticker.webp", "", this.b.getFileSize());
        if (hc.u() != null) {
            this.d = hc.u();
            this.c = new FileReference(this.d.getFileLocation(), "sticker.webp", "", this.d.getFileSize());
        }
        if (hc.w() != null) {
            this.f = hc.w();
            this.e = new FileReference(hc.w().getFileLocation(), "sticker.webp", "", hc.w().getFileSize());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ir.nasim.AbstractC25020zb8
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public HC createInstance() {
        return new HC();
    }

    @Override // ir.nasim.AbstractC25020zb8, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        super.serialize(c19675ql0);
        Integer num = this.i;
        if (num != null) {
            c19675ql0.f(100, num.intValue());
        }
        Long l = this.j;
        if (l != null) {
            c19675ql0.g(101, l.longValue());
        }
    }

    public Integer u() {
        return this.i;
    }

    public String w() {
        return this.h;
    }

    public int y() {
        return this.g;
    }

    public FileReference z() {
        return this.a;
    }

    public C23698xM6(byte[] bArr) {
        this();
        load(bArr);
    }

    private C23698xM6() {
        super(10);
    }
}
