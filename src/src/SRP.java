import java.util.Date;

public class SRP {
    public class Factura {
        public String codigo;
        public Date fechaEmision;
        public float importeFactura;
        public float importeIVA;
        public float importeDeduccion;
        public float importeTotal;
        public int porcentajeDeduccion;

        public void calcularTotal() {
            importeDeduccion = CalculadoraDeduccion.calcularDeduccion(importeFactura, porcentajeDeduccion);
            if (codigo.equals("0")) { // Verificar si el código es 0
                importeIVA = 0; // No se aplica IVA
            } else {
                importeIVA = importeFactura * 0.18f; // Aplicar IVA del 18%
            }

            importeTotal = (importeFactura - importeDeduccion) + importeIVA;
        }


        public class CalculadoraDeduccion {
            public static float calcularDeduccion(float importeFactura, int porcentajeDeduccion) {
                if (importeFactura > 10000) {
                    return (importeFactura * (porcentajeDeduccion + 3)) / 100;
                } else {
                    return (importeFactura * porcentajeDeduccion) / 100;
                }
            }
        }
    }

}
