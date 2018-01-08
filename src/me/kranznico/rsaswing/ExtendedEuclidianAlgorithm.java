package me.kranznico.rsaswing;

import java.math.BigInteger;

public class ExtendedEuclidianAlgorithm {
	
	public static BigInteger[] gcd(BigInteger a, BigInteger b) 
	{
		BigInteger[] returnval = new BigInteger[3];
		
		int signX = (a.compareTo(BigInteger.ZERO) == -1) ? -1 : 1;
		int signY = (b.compareTo(BigInteger.ZERO) == -1) ? -1 : 1;
		BigInteger x = BigInteger.ZERO;
		BigInteger y = BigInteger.ONE;
		BigInteger u = BigInteger.ONE;
		BigInteger v = BigInteger.ZERO;
		BigInteger q;
		BigInteger r;
		BigInteger m;
		BigInteger n;
		
		a = a.abs();
		b = b.abs();
		while (a.compareTo(BigInteger.ZERO) != 0) {
			q = b.divide(a);
			r = b.remainder(a);
			m = x.subtract(u.multiply(q));
			n = y.subtract(v.multiply(q));
			b = a;
			a = r;
			x = u;
			y = v;
			u = m;
			v = n;
		}
		returnval[0] = b;
		returnval[1] = x.multiply(new BigInteger(Integer.toString(signX)));
		returnval[2] = y.multiply(new BigInteger(Integer.toString(signY)));
//		for(int i = 0; i < returnval.length; i++)
//		{
//			System.out.println(returnval[i]);
//		}
		return returnval;
	}

}
