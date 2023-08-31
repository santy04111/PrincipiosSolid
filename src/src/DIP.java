import java.util.Date;


public class DIP {

    //implmentacion de interfaces de deduccion
    public interface CalculadoraDeduccion {
        float calculaDeduccion(float importeFactura, int porcentajeDeduccion);
    }

    public interface CalculadoraIva {
        float calculaIva(float importeFactura);
    }

    //implmentacion de clases concretas
    public class Deduccion implements CalculadoraDeduccion {
        @Override
        public float calculaDeduccion(float importeFactura, int porcentajeDeduccion) {
            if (importeFactura > 10000) {
                return (importeFactura * (porcentajeDeduccion + 3)) / 100;
            } else {
                return (importeFactura * porcentajeDeduccion) / 100;
            }
        }
    }

    public class Iva implements CalculadoraIva {
        @Override
        public float calculaIva(float importeFactura) {
            return importeFactura * 0.18f; // Cambio del 16% al 18%
        }
    }

    //refactorizacion de la clase "factura" para cumplir con el principio DIP
    public class Factura {
        public String codigo;
        public Date fechaEmision;
        public float importeFactura;
        public float importeIVA;
        public float importeDeduccion;
        public float importeTotal;
        public int porcentajeDeduccion;

        public void calcularTotal(CalculadoraDeduccion calculadoraDeduccion, CalculadoraIva calculadoraIva) {
            importeDeduccion = calculadoraDeduccion.calculaDeduccion(importeFactura, porcentajeDeduccion);
            importeIVA = calculadoraIva.calculaIva(importeFactura);
            importeTotal = (importeFactura - importeDeduccion) + importeIVA;
        }
    }



}
