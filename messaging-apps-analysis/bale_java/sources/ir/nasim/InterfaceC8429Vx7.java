package ir.nasim;

/* renamed from: ir.nasim.Vx7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC8429Vx7 {

    /* renamed from: ir.nasim.Vx7$a */
    public static final class a implements InterfaceC8429Vx7 {
        public static final a a = new a();

        private a() {
        }

        @Override // ir.nasim.InterfaceC8429Vx7
        public void a(InterfaceC21651tu interfaceC21651tu) {
            AbstractC13042fc3.i(interfaceC21651tu, "annotation");
        }

        @Override // ir.nasim.InterfaceC8429Vx7
        public void b(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, AbstractC4099Dr3 abstractC4099Dr33, InterfaceC22882vy7 interfaceC22882vy7) {
            AbstractC13042fc3.i(abstractC4099Dr3, "bound");
            AbstractC13042fc3.i(abstractC4099Dr32, "unsubstitutedArgument");
            AbstractC13042fc3.i(abstractC4099Dr33, "argument");
            AbstractC13042fc3.i(interfaceC22882vy7, "typeParameter");
        }

        @Override // ir.nasim.InterfaceC8429Vx7
        public void c(InterfaceC7722Sx7 interfaceC7722Sx7, InterfaceC22882vy7 interfaceC22882vy7, AbstractC4099Dr3 abstractC4099Dr3) {
            AbstractC13042fc3.i(interfaceC7722Sx7, "typeAlias");
            AbstractC13042fc3.i(abstractC4099Dr3, "substitutedArgument");
        }

        @Override // ir.nasim.InterfaceC8429Vx7
        public void d(InterfaceC7722Sx7 interfaceC7722Sx7) {
            AbstractC13042fc3.i(interfaceC7722Sx7, "typeAlias");
        }
    }

    void a(InterfaceC21651tu interfaceC21651tu);

    void b(AbstractC4099Dr3 abstractC4099Dr3, AbstractC4099Dr3 abstractC4099Dr32, AbstractC4099Dr3 abstractC4099Dr33, InterfaceC22882vy7 interfaceC22882vy7);

    void c(InterfaceC7722Sx7 interfaceC7722Sx7, InterfaceC22882vy7 interfaceC22882vy7, AbstractC4099Dr3 abstractC4099Dr3);

    void d(InterfaceC7722Sx7 interfaceC7722Sx7);
}
