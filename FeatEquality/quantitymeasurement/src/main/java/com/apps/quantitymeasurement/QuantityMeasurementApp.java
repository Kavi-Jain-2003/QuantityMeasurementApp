package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {

            // Reflexive
            if (this == obj)
                return true;

            // Null check
            if (obj == null)
                return false;

            // Type check
            if (getClass() != obj.getClass())
                return false;

            Feet other = (Feet) obj;

            // Floating point comparison
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    // Simple main method for manual testing
    public static void main(String[] args) {

        Feet f1 = new Feet(1.0);
        Feet f2 = new Feet(1.0);

        System.out.println("Are equal? " + f1.equals(f2));
    }
}
