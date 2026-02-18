package com.apps.quantitymeasurement;

import java.util.Scanner;

public class QuantityMeasurementApp {
	public static class Feet {
		private final double value;

		public Feet(double value) {
			this.value = value;
		}

		public double getValue() {
			return value;
		}

		// override equals
		@Override
		public boolean equals(Object obj)
		{
			if(this==obj)
			{
				return true;
			}
			//null check
			if(obj==null)
			{
				return false;
			}
			//type check
			if(getClass()!=obj.getClass())
			{
				return false;
			}
			//safe casting
			Feet other=(Feet) obj;
			return Double.compare(this.value, other.value)==0;
		}

		@Override
		public int hashCode() {
			return Double.hashCode(value);
		}
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.print("Enter first value in feet: ");
            double value1 = Double.parseDouble(sc.nextLine());

            System.out.print("Enter second value in feet: ");
            double value2 = Double.parseDouble(sc.nextLine());
            
            Feet feet1=new Feet(value1);
            Feet feet2=new Feet(value2);
            
            boolean result=feet1.equals(feet2);
            
            System.out.println("Are the two measurements equal? " + result);

		}
		catch(NumberFormatException e)
		{
			
		}
		
	}

}
